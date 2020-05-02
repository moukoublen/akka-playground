import Dependencies._

ThisBuild / organization := "com.moukoublen.playground"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.1"

scalacOptions ++= Seq(
  "-target:11",
  "-encoding", "utf8",
  "-Xfatal-warnings",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps"
)

Compile/mainClass := Some("com.moukoublen.playground.MainApp")
//mainClass in (Compile, run) := Some("com.moukoublen.playground.MainApp")
//mainClass in (Compile, packageBin) := Some("com.moukoublen.playground.MainApp")

lazy val mainApp = (project in file("."))
  .aggregate(core)  //aggregate so that the command sent to mainApp is broadcast to core too:
  .dependsOn(core)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "MainApp",
    libraryDependencies ++= mainAppDependencies,
    dependencyOverrides ++= overridesDependencies
  )

lazy val core = (project in file("core"))
  .settings(
    name := "Core",
    libraryDependencies ++= mainAppDependencies,
    dependencyOverrides ++= overridesDependencies
  )