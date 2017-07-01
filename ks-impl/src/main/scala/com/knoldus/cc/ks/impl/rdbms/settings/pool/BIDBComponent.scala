package com.knoldus.cc.ks.impl.rdbms.settings.pool

import com.freebird.rdbms.settings.driver.{PGDriver, DriverComponent}
import com.typesafe.config.ConfigFactory

/**
 * This trait provides postgres database configuration
 */
trait BIDBComponent extends DBComponent {
  this: DriverComponent =>
  import driver.api._
  val db: Database = BIDBConnectionPool.pool
}

private[rdbms] object BIDBConnectionPool extends PGDriver {
  import driver.api._

  private val config = ConfigFactory.load().getConfig("rdbms")
  val pool = Database.forConfig("biDBConf", config)
}
