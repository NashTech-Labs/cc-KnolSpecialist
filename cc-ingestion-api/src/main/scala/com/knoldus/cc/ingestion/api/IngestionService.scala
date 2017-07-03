package com.knoldus.cc.ingestion.api

import akka.NotUsed
import akka.stream.scaladsl.Source
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait IngestionService extends Service{

  def ingest(channelId: String): ServiceCall[Nothing, Source[String, NotUsed]]

  override def descriptor: Descriptor = {
    import Service._
    named("cc-ingestion")
      .withCalls(
        pathCall("/api/ingest/:channelId", ingest _)
      )
      .withAutoAcl(true)
  }

}
