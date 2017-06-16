package com.knoldus.ccknolspecialist.impl

import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.persistence.cassandra.CassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.server._
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import play.api.libs.ws.ahc.AhcWSComponents
import com.knoldus.ccknolspecialist.api.CcknolspecialistService
import com.lightbend.lagom.scaladsl.broker.kafka.LagomKafkaComponents
import com.softwaremill.macwire._

class CcknolspecialistLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new CcknolspecialistApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new CcknolspecialistApplication(context) with LagomDevModeComponents

  override def describeServices = List(
    readDescriptor[CcknolspecialistService]
  )
}

abstract class CcknolspecialistApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with CassandraPersistenceComponents
    with LagomKafkaComponents
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[CcknolspecialistService](wire[CcknolspecialistServiceImpl])

  // Register the JSON serializer registry
  override lazy val jsonSerializerRegistry = CcknolspecialistSerializerRegistry

  // Register the cc-KnolSpecialist persistent entity
  persistentEntityRegistry.register(wire[CcknolspecialistEntity])
}
