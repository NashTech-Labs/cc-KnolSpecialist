package com.knoldus.ccknolspecialiststream.impl

import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.knoldus.ccknolspecialiststream.api.CcknolspecialistStreamService
import com.knoldus.ccknolspecialist.api.CcknolspecialistService

import scala.concurrent.Future

/**
  * Implementation of the CcknolspecialistStreamService.
  */
class CcknolspecialistStreamServiceImpl(ccknolspecialistService: CcknolspecialistService) extends CcknolspecialistStreamService {
  def stream = ServiceCall { hellos =>
    Future.successful(hellos.mapAsync(8)(ccknolspecialistService.hello(_).invoke()))
  }
}
