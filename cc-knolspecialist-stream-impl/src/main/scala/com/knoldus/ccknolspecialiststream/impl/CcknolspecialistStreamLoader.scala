package com.knoldus.ccknolspecialiststream.impl

import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.server._
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import play.api.libs.ws.ahc.AhcWSComponents
import com.knoldus.ccknolspecialiststream.api.CcknolspecialistStreamService
import com.knoldus.ccknolspecialist.api.CcknolspecialistService
import com.softwaremill.macwire._

class CcknolspecialistStreamLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new CcknolspecialistStreamApplication(context) {
      override def serviceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new CcknolspecialistStreamApplication(context) with LagomDevModeComponents

  override def describeServices = List(
    readDescriptor[CcknolspecialistStreamService]
  )
}

abstract class CcknolspecialistStreamApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[CcknolspecialistStreamService](wire[CcknolspecialistStreamServiceImpl])

  // Bind the CcknolspecialistService client
  lazy val ccknolspecialistService = serviceClient.implement[CcknolspecialistService]
}
