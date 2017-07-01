package com.knoldus.cc.ks.impl.rdbms.settings

import com.freebird.rdbms.settings.driver.{DriverComponent, PGDriver}
import com.freebird.rdbms.settings.pool.{BIDBComponent, DBComponent}
import slick.dbio
import slick.dbio.Effect.Transactional

import scala.concurrent.Future

trait TransactionalRepo extends DBComponent{
  this: DriverComponent =>
  import driver.api._

  def withTransaction[R](transactionFunc:  => DBIOAction[R, _ <: dbio.NoStream, _ <: Effect with Transactional]): Future[R] = {
    val query = transactionFunc
    db.run(query.transactionally)
  }
}

object TransactionalRepoImpl extends TransactionalRepo with  PGDriver with BIDBComponent
