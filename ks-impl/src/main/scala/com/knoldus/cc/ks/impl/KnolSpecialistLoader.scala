package com.knoldus.cc.ks.impl

import com.lightbend.lagom.scaladsl.server._
import play.api.libs.ws.ahc.AhcWSComponents
import com.knoldus.cc.ks.api.KnolSpecialistService
import com.softwaremill.macwire._

/**
  * Created by knoldus on 21/6/17.
  */
abstract class KnolSpecialistLoader(context: LagomApplicationContext) extends LagomApplication(context) with
  AhcWSComponents {
  override lazy val lagomServer = serverFor[KnolSpecialistService](wire[KnolSpecialistImpl])
}
