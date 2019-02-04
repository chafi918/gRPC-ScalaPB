name := "grpcScalapbPoc"

version := "0.1"

scalaVersion := "2.11.8"

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

PB.protocVersion := "-v300"

val sparkVersion = "2.2.0"

libraryDependencies ++= Seq(
  // required for customizations and access to google/protobuf/*.proto
  "com.trueaccord.scalapb" %% "scalapb-runtime"
    % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf",
  // next two lines are for gRPC
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc"
    % com.trueaccord.scalapb.compiler.Version.scalapbVersion,
  "io.grpc" % "grpc-netty"
    % com.trueaccord.scalapb.compiler.Version.grpcJavaVersion,
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)