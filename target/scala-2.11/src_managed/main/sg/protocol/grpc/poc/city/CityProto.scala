// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package sg.protocol.grpc.poc.city



object CityProto extends _root_.com.trueaccord.scalapb.GeneratedFileObject {
  lazy val dependencies: Seq[_root_.com.trueaccord.scalapb.GeneratedFileObject] = Seq(
    com.trueaccord.scalapb.scalapb.ScalapbProto
  )
  lazy val messagesCompanions: Seq[_root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_]] = Seq(
    sg.protocol.grpc.poc.city.CityRequest,
    sg.protocol.grpc.poc.city.CityResponse,
    sg.protocol.grpc.poc.city.Filter,
    sg.protocol.grpc.poc.city.City
  )
  private lazy val ProtoBytes: Array[Byte] =
      com.trueaccord.scalapb.Encoding.fromBase64(scala.collection.Seq(
  """CgpjaXR5LnByb3RvEhRzZy5wcm90b2NvbC5ncnBjLnBvYxoVc2NhbGFwYi9zY2FsYXBiLnByb3RvIkMKC0NpdHlSZXF1ZXN0E
  jQKBmZpbHRlchgBIAEoCzIcLnNnLnByb3RvY29sLmdycGMucG9jLkZpbHRlclIGZmlsdGVyIk4KDENpdHlSZXNwb25zZRI+CgZja
  XRpZXMYASADKAsyGi5zZy5wcm90b2NvbC5ncnBjLnBvYy5DaXR5QgriPwcaBUFycmF5UgZjaXRpZXMiVAoGRmlsdGVyEhQKBXZhb
  HVlGAEgASgJUgV2YWx1ZRI0CgR0eXBlGAIgASgOMiAuc2cucHJvdG9jb2wuZ3JwYy5wb2MuRmlsdGVyVHlwZVIEdHlwZSKHAQoEQ
  2l0eRISCgRuYW1lGAEgASgJUgRuYW1lEh0KCm5hbWVfYXNjaWkYAiABKAlSCW5hbWVBc2NpaRIQCgNsYXQYAyABKAlSA2xhdBIQC
  gNsb24YBCABKAlSA2xvbhIYCgdjb3VudHJ5GAUgASgJUgdjb3VudHJ5Eg4KAmlkGAYgASgJUgJpZCo0CgpGaWx0ZXJUeXBlEgYKA
  klEEAASCAoETkFNRRABEgsKB0NPVU5UUlkQAhIHCgNBTEwQAzJhCgtDaXR5U2VydmljZRJSCgdHZXRDaXR5EiEuc2cucHJvdG9jb
  2wuZ3JwYy5wb2MuQ2l0eVJlcXVlc3QaIi5zZy5wcm90b2NvbC5ncnBjLnBvYy5DaXR5UmVzcG9uc2UiAGIGcHJvdG8z"""
      ).mkString)
  lazy val scalaDescriptor: _root_.scalapb.descriptors.FileDescriptor = {
    val scalaProto = com.google.protobuf.descriptor.FileDescriptorProto.parseFrom(ProtoBytes)
    _root_.scalapb.descriptors.FileDescriptor.buildFrom(scalaProto, dependencies.map(_.scalaDescriptor))
  }
  lazy val javaDescriptor: com.google.protobuf.Descriptors.FileDescriptor = {
    val javaProto = com.google.protobuf.DescriptorProtos.FileDescriptorProto.parseFrom(ProtoBytes)
    com.google.protobuf.Descriptors.FileDescriptor.buildFrom(javaProto, Array(
      com.trueaccord.scalapb.scalapb.ScalapbProto.javaDescriptor
    ))
  }
  @deprecated("Use javaDescriptor instead. In a future version this will refer to scalaDescriptor.", "ScalaPB 0.5.47")
  def descriptor: com.google.protobuf.Descriptors.FileDescriptor = javaDescriptor
}