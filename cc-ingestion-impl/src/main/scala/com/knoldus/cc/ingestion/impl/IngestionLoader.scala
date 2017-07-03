package com.knoldus.cc.ingestion.impl

import com.knoldus.cc.ingestion.api.IngestionService
import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext, LagomApplicationLoader}
import com.softwaremill.macwire._
import play.api.libs.ws.ahc.AhcWSComponents


class IngestionLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext): LagomApplication =
    new IngestionApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new IngestionApplication(context) with LagomDevModeComponents

  override def describeServices = List(
    readDescriptor[IngestionService]
  )
}


abstract class IngestionApplication(context: LagomApplicationContext) extends LagomApplication(context) with
  AhcWSComponents {
  override lazy val lagomServer = serverFor[IngestionService](wire[IngestionServiceImpl])
}
