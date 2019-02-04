
package sg.grpc.scalapb.poc

import java.util.concurrent.TimeUnit
import java.util.logging.{Level, Logger}

import io.grpc.{ManagedChannel, ManagedChannelBuilder, StatusRuntimeException}
import sg.protocol.grpc.poc.city.{CityRequest, CityServiceGrpc, Filter, FilterType}
import sg.protocol.grpc.poc.city.CityServiceGrpc.CityServiceBlockingStub

object CitiesClientImpl {
  def apply(host: String, port: Int): CitiesClientImpl = {
    val channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build
    val blockingStub = CityServiceGrpc.blockingStub(channel)
    new CitiesClientImpl(channel, blockingStub)
  }

  def main(args: Array[String]): Unit = {
    val client = CitiesClientImpl("localhost", 50051)
    try {
      val filter = new Filter("", FilterType.ALL)
      client.askForCities(filter)
    } finally {
      client.shutdown()
    }
  }

}

class CitiesClientImpl private(private val channel: ManagedChannel,
                               private val blockingStub: CityServiceBlockingStub){
  private[this] val logger = Logger.getLogger(classOf[CitiesClientImpl].getName)

  def shutdown(): Unit = {
    channel.shutdown.awaitTermination(5, TimeUnit.SECONDS)
  }

  def askForCities(filter: Filter): Unit = {
    logger.info("Will try to ask for cities by:  " + filter.`type` + " ...")

    val request = CityRequest(Some(filter))
    try {
      val t0 = System.nanoTime()
      val response = blockingStub.getCity(request)
      val t1 = System.nanoTime()
      logger.info("Response received: " + response.cities.foreach(println))
      logger.info("Response received length: " + response.cities.length)
      logger.info("Response received in : " + (t1 - t0)/1000000000.0 + "s")
    }
    catch {
      case e: StatusRuntimeException =>
        logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus)
    }
  }
}