package com.knoldus.cc.ks.api

import akka.NotUsed
import com.knoldus.cc.ks.Technology
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait KnolSpecialistService extends Service{
import com.knoldus.cc.ks.JsonSerial._
  def getTechnique(id: Int): ServiceCall[NotUsed, Technology]

  override def descriptor: Descriptor = {
    import Service._
    named("ks")
      .withCalls(
        pathCall("/api/get/technology/:id", getTechnique _)
      )
      .withAutoAcl(true)
  }

}