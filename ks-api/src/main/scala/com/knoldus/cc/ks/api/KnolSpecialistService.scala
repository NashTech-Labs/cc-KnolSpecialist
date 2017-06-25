package com.knoldus.cc.ks.api

import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait KnolSpecialistService extends Service{

  def getTechnique():ServiceCall[String, String]

  override def descriptor: Descriptor = {
    import Service._
    named("ks")
      .withCalls(
        pathCall("/api/get/technology", getTechnique _)
      )
      .withAutoAcl(true)
  }

}
