package com.moukoublen.playground

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives._
import com.moukoublen.core.MicroService

class SampleMicroService extends MicroService("SampleMicroService") {



  override def serviceRoutes: List[Route] = List({
    path("sample") {
      complete("ok")
    }
  })

}
