package com.knoldus.cc.ks.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait KnolSpecialistService extends Service{

  def getTechnique():ServiceCall[NotUsed,String]

  override final def descriptor: Descriptor = {
    import Service._
    named("ks-api")
      .withCalls(
        pathCall("/api/get/technology", getTechnique _)
      )
      .withAutoAcl(true)
  }

}
