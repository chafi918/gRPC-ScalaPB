package sg.grpc.scalapb.poc

import java.util.logging.Logger

import io.grpc.{Server, ServerBuilder}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import sg.protocol.grpc.poc.city.CityServiceGrpc.CityService
import sg.protocol.grpc.poc.city.FilterType.{ALL, COUNTRY, ID, NAME}
import sg.protocol.grpc.poc.city._

import scala.concurrent.{ExecutionContext, Future}
;


object CitiesServer {
  private val logger = Logger.getLogger(classOf[CitiesServer].getName)

  def main(args: Array[String]): Unit = {
    val server = new CitiesServer(ExecutionContext.global)
    server.start()
    server.blockUntilShutdown()
  }

  private val port = 50051

}

class CitiesServer(executionContext: ExecutionContext) { self =>
  private[this] var server: Server = null


  private def start(): Unit = {
    val sparkConf = new SparkConf().setAppName("gRpcScalaPbPoc").setMaster("local[2]")
    sparkConf.set("spark.executor.memory", "4g")
    sparkConf.set("spark.storage.memoryFraction", "0.8")
    sparkConf.set("spark.driver.memory", "2g")
    sparkConf.set("spark.driver.allowMultipleContexts", "true")
    val sc = new SparkContext(sparkConf)
      val spark = SparkSession.builder()
      .appName("gRpcScalaPbPoc")
      .getOrCreate()

    val citiesDF = spark.read.csv("src/main/ressources/worldcities.csv")

    val cities = citiesDF.rdd
      .map(city => new City(city(0).toString, city(1).toString, city(2).toString, city(3).toString, city(4).toString, city(10).toString))
    server = ServerBuilder.forPort(CitiesServer.port).addService(CityServiceGrpc.bindService(new CityServiceImpl(cities), executionContext)).build.start
    CitiesServer.logger.info("Server started, listening on " + CitiesServer.port)
    sys.addShutdownHook {
      System.err.println("*** shutting down gRPC server since JVM is shutting down")
      self.stop()
      System.err.println("*** server shut down")
    }
  }

  private def stop(): Unit = {
    if (server != null) {
      server.shutdown()
    }
  }

  private def blockUntilShutdown(): Unit = {
    if (server != null) {
      server.awaitTermination()
    }
  }

  private class CityServiceImpl(cities : RDD[City]) extends CityService{
    def getCitiesByID(value: String): Future[CityResponse] = {
      Future.successful(CityResponse(cities.filter(c => c.id == value).collect()))
    }

    def getCitiesByCountry(value: String): Future[CityResponse] = {
      Future.successful(CityResponse(cities.filter(c => c.country == value).collect()))
    }

    def getCitiesByName(value: String): Future[CityResponse] = {
      Future.successful(CityResponse(cities.filter(c => c.name == value).collect()))
    }

    override def getCity(request: CityRequest): Future[CityResponse] = {
      request.getFilter.`type` match {
        case ID => getCitiesByID(request.getFilter.value)
        case COUNTRY => getCitiesByCountry(request.getFilter.value)
        case NAME => getCitiesByName(request.getFilter.value)
        case ALL => Future.successful(CityResponse(cities.collect()))
        case _ => null
      }
    }
  }

}