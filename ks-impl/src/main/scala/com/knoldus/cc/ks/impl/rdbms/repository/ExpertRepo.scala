package com.knoldus.cc.ks.impl.rdbms.repository

import com.knoldus.cc.ks.Expert
import com.knoldus.cc.ks.impl.rdbms.mapping.ExpertMapping
import com.knoldus.cc.ks.impl.rdbms.settings.TransactionalRepo
import com.knoldus.cc.ks.impl.rdbms.settings.driver.{DriverComponent, PGDriver}
import com.knoldus.cc.ks.impl.rdbms.settings.pool.BIDBComponent

import scala.concurrent.Future

trait ExpertRepo extends ExpertMapping with TransactionalRepo{
  this: DriverComponent =>

  import driver.api._

  def get(tId: Int, kId: Int): Future[Option[Expert]] = withTransaction{
    expertInfo.filter(expert => expert.techId === tId && expert.knolId === kId).result.headOption
  }

  def insert(expert: Expert): Future[Int] = {
    withTransaction(expertInfo += expert)
  }

  def delete(tId: Int, kId: Int): Future[Int] = withTransaction{
    val query = expertInfo.filter(e => e.knolId === kId && e.techId === tId)
    query.delete
  }

  def upsert(expert: Expert): Future[Int] = withTransaction{
    expertInfo.insertOrUpdate(expert)
  }

  def getAll: Future[List[Expert]] = withTransaction{
    expertInfo.to[List].result
  }
}

object ExpertRepoImpl extends ExpertRepo with PGDriver with BIDBComponent

object ExpertRepoFactory {
  def apply() = new ExpertRepo with PGDriver with BIDBComponent{}
}
