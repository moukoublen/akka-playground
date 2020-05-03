import sbt._

object Dependencies {
  // Versions
  lazy val akkaVersion     = "2.5.31"
  lazy val akkaHttpVersion = "10.1.11"
  lazy val akkaStreamKafka = "2.0.2"

  // Projects
  val mainAppDependencies =
    Seq(
      //Java libs
      "ch.qos.logback"     % "logback-classic"      % "1.2.3",

      //Scala libs
      "com.typesafe.akka" %% "akka-actor"           % akkaVersion,
      "com.typesafe.akka" %% "akka-remote"          % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster"         % akkaVersion,
      "com.typesafe.akka" %% "akka-slf4j"           % akkaVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,
      "com.typesafe.akka" %% "akka-stream-kafka"    % akkaStreamKafka,
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-core"       % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.lightbend.akka.management" %% "akka-management"              % "1.0.6",
      "com.lightbend.akka.management" %% "akka-management-cluster-http" % "1.0.6",

      //Test
      "org.scalatest"     %% "scalatest"                 % "3.1.1"         % Test,
      "org.specs2"        %% "specs2-core"               % "4.9.4"         % Test,
      "com.typesafe.akka" %% "akka-testkit"              % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"       % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-kafka-testkit" % akkaStreamKafka % Test,
      "com.typesafe.akka" %% "akka-http-testkit"         % akkaHttpVersion % Test
    )

  val overridesDependencies: Seq[sbt.ModuleID] =  Seq(
    "org.slf4j" % "slf4j-api" % "1.7.28",
    "org.scala-lang.modules" %% "scala-xml" % "1.3.0"
  )
}
