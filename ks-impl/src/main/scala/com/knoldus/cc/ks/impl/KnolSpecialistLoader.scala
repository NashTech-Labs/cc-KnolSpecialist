package com.knoldus.cc.ks.impl

import com.knoldus.cc.ks.api.KnolSpecialistService
import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server._

class KnolSpecialistLoader extends LagomApplicationLoader {

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new KnolSpecialistApplication(context) with LagomDevModeComponents

  override def load(context: LagomApplicationContext): LagomApplication =
    new KnolSpecialistApplication(context) {
      override def serviceLocator: ServiceLocator = ServiceLocator.NoServiceLocator
    }

  override def describeServices =
    List(readDescriptor[KnolSpecialistService])
}