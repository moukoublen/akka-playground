package com.moukoublen.core

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives.concat
import akka.stream.Materializer

import scala.concurrent.Future

abstract class MicroService(val name: String) {

  def serviceRoutes: List[Route]

  protected def compactRoutes: Route = concat(serviceRoutes:_*)

  def bindRoutes(host: String, port: Int)
                (implicit system: ActorSystem, mat: Materializer)
  : Future[Http.ServerBinding] = {
    Http().bindAndHandle(
      handler   = compactRoutes,
      interface = host,
      port      = port
    )
  }

}
