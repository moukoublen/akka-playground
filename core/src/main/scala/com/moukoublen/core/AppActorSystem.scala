package com.moukoublen.core

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, Materializer}

import scala.concurrent.ExecutionContext

trait AppActorSystem {
  def getActorSystemName: String
  implicit val system: ActorSystem  = ActorSystem(getActorSystemName)
  implicit val mat:    Materializer = ActorMaterializer.create(system)
  //implicit val ec:     ExecutionContext
  def getSystemDefaultExecutor: ExecutionContext = system.dispatcher
}
