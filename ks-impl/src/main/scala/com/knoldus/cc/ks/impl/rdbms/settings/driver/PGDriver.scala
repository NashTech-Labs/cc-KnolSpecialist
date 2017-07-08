package com.knoldus.cc.ks.impl.rdbms.settings.driver

import slick.jdbc.{PostgresProfile, JdbcProfile}

trait PGDriver extends DriverComponent {
  val driver: JdbcProfile = PostgresProfile
}
