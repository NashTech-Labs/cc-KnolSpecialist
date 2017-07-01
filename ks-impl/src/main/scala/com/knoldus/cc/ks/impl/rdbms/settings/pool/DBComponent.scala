package com.knoldus.cc.ks.impl.rdbms.settings.pool

import com.freebird.rdbms.settings.driver.DriverComponent

/**
 * Creating database component
 */
trait DBComponent {
  this: DriverComponent =>
  import driver.api._
  val db: Database
}
