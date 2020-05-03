package com.moukoublen.playground

import com.moukoublen.core.AppActorSystem

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import akka.event.Logging
import akka.management.scaladsl.AkkaManagement

object MainApp extends AppActorSystem {

  override def getActorSystemName: String = "playground"

  def main(args: Array[String]): Unit = {
    val log = Logging.getLogger(system, this)
    log.debug("Application Starts...")
    AkkaManagement(system).start()

    val s = new SampleMicroService
    s.bindRoutes("0.0.0.0", 8099)
    Await.result(system.whenTerminated, Duration.Inf)
  }
}
