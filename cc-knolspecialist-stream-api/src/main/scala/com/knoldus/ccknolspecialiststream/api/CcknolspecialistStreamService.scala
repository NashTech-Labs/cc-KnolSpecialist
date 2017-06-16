package com.knoldus.ccknolspecialiststream.api

import akka.NotUsed
import akka.stream.scaladsl.Source
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * The cc-KnolSpecialist stream interface.
  *
  * This describes everything that Lagom needs to know about how to serve and
  * consume the CcknolspecialistStream service.
  */
trait CcknolspecialistStreamService extends Service {

  def stream: ServiceCall[Source[String, NotUsed], Source[String, NotUsed]]

  override final def descriptor = {
    import Service._

    named("cc-knolspecialist-stream")
      .withCalls(
        namedCall("stream", stream)
      ).withAutoAcl(true)
  }
}

