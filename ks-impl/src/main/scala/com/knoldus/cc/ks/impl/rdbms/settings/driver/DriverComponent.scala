package com.knoldus.cc.ks.impl.rdbms.settings.driver

import slick.jdbc.JdbcProfile

/*
* A profile for accessing SQL databases via JDBC. All drivers for JDBC-based databases
* implement this profile.
*/
trait DriverComponent {
//  implicit val global = com.freebird.concurrent.ExecutionContext.IO.dbOperations
  val driver: JdbcProfile
}
