// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package sg.protocol.grpc.poc.city



sealed trait FilterType extends _root_.com.trueaccord.scalapb.GeneratedEnum {
  type EnumType = FilterType
  def isId: Boolean = false
  def isName: Boolean = false
  def isCountry: Boolean = false
  def isAll: Boolean = false
  def companion: _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[FilterType] = sg.protocol.grpc.poc.city.FilterType
}

object FilterType extends _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[FilterType] {
  implicit def enumCompanion: _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[FilterType] = this
  @SerialVersionUID(0L)
  case object ID extends FilterType {
    val value = 0
    val index = 0
    val name = "ID"
    override def isId: Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object NAME extends FilterType {
    val value = 1
    val index = 1
    val name = "NAME"
    override def isName: Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object COUNTRY extends FilterType {
    val value = 2
    val index = 2
    val name = "COUNTRY"
    override def isCountry: Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object ALL extends FilterType {
    val value = 3
    val index = 3
    val name = "ALL"
    override def isAll: Boolean = true
  }
  
  @SerialVersionUID(0L)
  case class Unrecognized(value: Int) extends FilterType with _root_.com.trueaccord.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.Seq(ID, NAME, COUNTRY, ALL)
  def fromValue(value: Int): FilterType = value match {
    case 0 => ID
    case 1 => NAME
    case 2 => COUNTRY
    case 3 => ALL
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = CityProto.javaDescriptor.getEnumTypes.get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = CityProto.scalaDescriptor.enums(0)
}