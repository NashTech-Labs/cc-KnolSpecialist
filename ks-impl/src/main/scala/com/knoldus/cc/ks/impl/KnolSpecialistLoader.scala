package com.knoldus.cc.ks.impl

import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.persistence.cassandra.CassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.server._
import play.api.libs.ws.ahc.AhcWSComponents
import com.knoldus.cc.ks.api.KnolSpecialistService
import com.softwaremill.macwire._

class KnolspecialistLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext): LagomApplication =
    new KnolspecialistApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }
  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new KnolspecialistApplication(context) with LagomDevModeComponents

  override def describeServices = List(
    readDescriptor[KnolSpecialistService]
  )
}


abstract class KnolspecialistApplication(context: LagomApplicationContext)
  extends LagomApplication(context) with CassandraPersistenceComponents with AhcWSComponents {

  override lazy val lagomServer = serverFor[KnolSpecialistService](wire[KnolSpecialistImpl])

  override lazy val jsonSerializerRegistry = KnolspecialistSerializerRegistry
}
// Bind the service that this server provides