package com.knoldus.cc.ingestion.api

import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait IngestionService extends Service{

  def ingest(channelId: String): ServiceCall[String, String]

  override def descriptor: Descriptor = {
    import Service._
    named("cc-ingestion")
      .withCalls(
        pathCall("/api/ingest/:channelId", ingest _)
      )
      .withAutoAcl(true)
  }

}
