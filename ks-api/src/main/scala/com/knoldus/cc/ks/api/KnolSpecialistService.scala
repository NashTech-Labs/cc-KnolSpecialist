package com.knoldus.cc.ks.api

import akka.NotUsed
import com.knoldus.cc.ks.Technology
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

import scala.concurrent.Future

trait KnolSpecialistService extends Service {

  import com.knoldus.cc.ks.JsonSerial._

  def getTechnique(id: Int): ServiceCall[NotUsed, Technology]

  def welcome: ServiceCall[NotUsed, String] = ServiceCall { request =>
    Future.successful("Welcome to cc-specialist")
  }

  override def descriptor: Descriptor = {
    import Service._
    named("ks")
      .withCalls(
        pathCall("/", welcome _),
        pathCall("/api/get/technology/:id", getTechnique _)
      )
      .withAutoAcl(true)
  }

}