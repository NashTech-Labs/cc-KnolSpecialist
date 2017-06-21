package com.knoldus.cc.analytics.api

import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait AnalyticsService extends Service {
  def analyze(): ServiceCall[String, String]

  override def descriptor: Descriptor = {
    import Service._
    named("cc-ingestion")
      .withCalls(
        pathCall("/api/analyze/", analyze())
      )
      .withAutoAcl(true)
  }

}
