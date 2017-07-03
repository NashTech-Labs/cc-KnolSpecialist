package com.knoldus.cc.analytics.api

import akka.NotUsed
import akka.stream.scaladsl.Source
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

/**
  * Created by knoldus on 3/7/17.
  */
trait AnalyticsService extends Service{

    def analyze(): ServiceCall[String, String]

    override def descriptor: Descriptor = {
      import Service._
      named("cc-analytics")
        .withCalls(
          pathCall("/api/analytics", analyze _)
        )
        .withAutoAcl(true)
    }

  }
