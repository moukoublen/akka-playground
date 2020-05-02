package com.moukoublen.playground

import com.moukoublen.core.AppActorSystem

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import akka.event.Logging

object MainApp extends AppActorSystem {

  override def getActorSystemName: String = "playgroundActorSystem"

  def main(args: Array[String]): Unit = {
    val log = Logging.getLogger(system, this)
    log.debug("Application Starts...")

    val s = new SampleMicroService
    s.bindRoutes("0.0.0.0", 8080)
    Await.result(system.whenTerminated, Duration.Inf)
  }
}
