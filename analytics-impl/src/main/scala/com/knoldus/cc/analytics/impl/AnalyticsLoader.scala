package com.knoldus.cc.analytics.impl

import com.knoldus.cc.analytics.api.AnalyticsService
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext}
import com.softwaremill.macwire._
import play.api.libs.ws.ahc.AhcWSComponents

/**
  * Created by knoldus on 21/6/17.
  */
abstract class AnalyticsLoader (context: LagomApplicationContext) extends LagomApplication(context) with
  AhcWSComponents {
  override lazy val lagomServer = serverFor[AnalyticsService](wire[AnalyticsImpl])
}

