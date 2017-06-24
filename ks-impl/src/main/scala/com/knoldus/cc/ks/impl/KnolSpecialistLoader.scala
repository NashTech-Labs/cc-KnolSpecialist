package com.knoldus.cc.ks.impl

import com.lightbend.lagom.scaladsl.server._
import play.api.libs.ws.ahc.AhcWSComponents
import com.knoldus.cc.ks.api.KnolSpecialistService
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcPersistenceComponents
import com.softwaremill.macwire._
import play.api.db.HikariCPComponents

abstract class KnolSpecialistLoader(context: LagomApplicationContext) extends LagomApplication(context) with
  JdbcPersistenceComponents with HikariCPComponents with AhcWSComponents {
  override lazy val lagomServer = serverFor[KnolSpecialistService](wire[KnolSpecialistImpl])
}
