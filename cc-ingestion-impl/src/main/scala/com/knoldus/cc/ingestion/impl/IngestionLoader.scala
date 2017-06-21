package com.knoldus.cc.ingestion.impl

import com.knoldus.cc.ingestion.api.IngestionService
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext}
import com.softwaremill.macwire._
import play.api.libs.ws.ahc.AhcWSComponents

/**
  * Created by knoldus on 21/6/17.
  */
abstract class IngestionLoader (context: LagomApplicationContext) extends LagomApplication(context) with
  AhcWSComponents {
  override lazy val lagomServer = serverFor[IngestionService](wire[IngestionServiceImpl])
}
