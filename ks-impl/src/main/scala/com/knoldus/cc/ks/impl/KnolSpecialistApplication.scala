package com.knoldus.cc.ks.impl

import com.knoldus.cc.ks.api.KnolSpecialistService
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcPersistenceComponents
import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext}
import com.softwaremill.macwire.wire
import play.api.db.HikariCPComponents
import play.api.libs.ws.ahc.AhcWSComponents

import scala.collection.immutable

abstract class KnolSpecialistApplication(context: LagomApplicationContext) extends LagomApplication(context) with
  JdbcPersistenceComponents with HikariCPComponents with AhcWSComponents {

  override lazy val lagomServer = serverFor[KnolSpecialistService](wire[KnolSpecialistImpl])

  override def jsonSerializerRegistry: JsonSerializerRegistry = new JsonSerializerRegistry {
    override def serializers: immutable.Seq[JsonSerializer[_]] = Vector(JsonSerializer[String])
  }
}

