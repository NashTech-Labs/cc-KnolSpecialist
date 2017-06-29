package com.knoldus.cc.ks.impl

import akka.NotUsed
import com.knoldus.cc.ks.api.KnolSpecialistService
import com.lightbend.lagom.scaladsl.api.ServiceCall

/**
  * Created by knoldus on 21/6/17.
  */
class KnolSpecialistImpl extends KnolSpecialistService{
  @Override
  def getTechnique():ServiceCall[NotUsed,String] = ???
}
