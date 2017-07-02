package com.knoldus.cc.ks.impl.rdbms.repository

import com.knoldus.cc.ks.Knolder
import com.knoldus.cc.ks.impl.rdbms.mapping.KnolderMapping
import com.knoldus.cc.ks.impl.rdbms.settings.TransactionalRepo
import com.knoldus.cc.ks.impl.rdbms.settings.driver.{DriverComponent, PGDriver}
import com.knoldus.cc.ks.impl.rdbms.settings.pool.BIDBComponent

import scala.concurrent.Future

trait KnolderRepo extends KnolderMapping with TransactionalRepo{
  this: DriverComponent =>

  import driver.api._

  def get(id: Int): Future[Option[Knolder]] = withTransaction{
    knolderInfo.filter(_.id === id).result.headOption
  }

  def insert(knolder: Knolder): Future[Int] = {
    withTransaction(knolderInfo += knolder)
  }

  def delete(id: Int): Future[Int] = withTransaction{
    val query = knolderInfo.filter(t => t.id === id)
    query.delete
  }

  def upsert(knolder: Knolder): Future[Int] = withTransaction{
    knolderInfo.insertOrUpdate(knolder)
  }

    def getAll: Future[List[Knolder]] = withTransaction{
    knolderInfo.to[List].result
  }
}

object KnolderRepoImpl extends KnolderRepo with PGDriver with BIDBComponent

object KnolderRepoFactory {
  def apply() = new KnolderRepo with PGDriver with BIDBComponent{}
}
