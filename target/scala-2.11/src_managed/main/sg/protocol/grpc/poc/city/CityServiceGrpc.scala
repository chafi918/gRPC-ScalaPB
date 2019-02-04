package sg.protocol.grpc.poc.city

object CityServiceGrpc {
  val METHOD_GET_CITY: _root_.io.grpc.MethodDescriptor[sg.protocol.grpc.poc.city.CityRequest, sg.protocol.grpc.poc.city.CityResponse] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("sg.protocol.grpc.poc.CityService", "GetCity"))
      .setRequestMarshaller(new com.trueaccord.scalapb.grpc.Marshaller(sg.protocol.grpc.poc.city.CityRequest))
      .setResponseMarshaller(new com.trueaccord.scalapb.grpc.Marshaller(sg.protocol.grpc.poc.city.CityResponse))
      .build()
  
  val SERVICE: _root_.io.grpc.ServiceDescriptor =
    _root_.io.grpc.ServiceDescriptor.newBuilder("sg.protocol.grpc.poc.CityService")
      .setSchemaDescriptor(new _root_.com.trueaccord.scalapb.grpc.ConcreteProtoFileDescriptorSupplier(sg.protocol.grpc.poc.city.CityProto.javaDescriptor))
      .addMethod(METHOD_GET_CITY)
      .build()
  
  trait CityService extends _root_.com.trueaccord.scalapb.grpc.AbstractService {
    override def serviceCompanion = CityService
    def getCity(request: sg.protocol.grpc.poc.city.CityRequest): scala.concurrent.Future[sg.protocol.grpc.poc.city.CityResponse]
  }
  
  object CityService extends _root_.com.trueaccord.scalapb.grpc.ServiceCompanion[CityService] {
    implicit def serviceCompanion: _root_.com.trueaccord.scalapb.grpc.ServiceCompanion[CityService] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = sg.protocol.grpc.poc.city.CityProto.javaDescriptor.getServices().get(0)
  }
  
  trait CityServiceBlockingClient {
    def serviceCompanion = CityService
    def getCity(request: sg.protocol.grpc.poc.city.CityRequest): sg.protocol.grpc.poc.city.CityResponse
  }
  
  class CityServiceBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[CityServiceBlockingStub](channel, options) with CityServiceBlockingClient {
    override def getCity(request: sg.protocol.grpc.poc.city.CityRequest): sg.protocol.grpc.poc.city.CityResponse = {
      _root_.io.grpc.stub.ClientCalls.blockingUnaryCall(channel.newCall(METHOD_GET_CITY, options), request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): CityServiceBlockingStub = new CityServiceBlockingStub(channel, options)
  }
  
  class CityServiceStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[CityServiceStub](channel, options) with CityService {
    override def getCity(request: sg.protocol.grpc.poc.city.CityRequest): scala.concurrent.Future[sg.protocol.grpc.poc.city.CityResponse] = {
      com.trueaccord.scalapb.grpc.Grpc.guavaFuture2ScalaFuture(_root_.io.grpc.stub.ClientCalls.futureUnaryCall(channel.newCall(METHOD_GET_CITY, options), request))
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): CityServiceStub = new CityServiceStub(channel, options)
  }
  
  def bindService(serviceImpl: CityService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
    _root_.io.grpc.ServerServiceDefinition.builder(SERVICE)
    .addMethod(
      METHOD_GET_CITY,
      _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[sg.protocol.grpc.poc.city.CityRequest, sg.protocol.grpc.poc.city.CityResponse] {
        override def invoke(request: sg.protocol.grpc.poc.city.CityRequest, observer: _root_.io.grpc.stub.StreamObserver[sg.protocol.grpc.poc.city.CityResponse]): Unit =
          serviceImpl.getCity(request).onComplete(com.trueaccord.scalapb.grpc.Grpc.completeObserver(observer))(
            executionContext)
      }))
    .build()
  
  def blockingStub(channel: _root_.io.grpc.Channel): CityServiceBlockingStub = new CityServiceBlockingStub(channel)
  
  def stub(channel: _root_.io.grpc.Channel): CityServiceStub = new CityServiceStub(channel)
  
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = sg.protocol.grpc.poc.city.CityProto.javaDescriptor.getServices().get(0)
  
}