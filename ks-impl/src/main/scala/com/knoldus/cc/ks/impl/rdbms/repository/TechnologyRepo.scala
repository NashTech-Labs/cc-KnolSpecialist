package com.knoldus.cc.ks.impl.rdbms.repository

import com.knoldus.cc.ks.impl.rdbms.mapping.TechnologyMapping
import com.knoldus.cc.ks.impl.rdbms.model.Technology
import com.knoldus.cc.ks.impl.rdbms.settings.TransactionalRepo
import com.knoldus.cc.ks.impl.rdbms.settings.driver.{DriverComponent, PGDriver}
import com.knoldus.cc.ks.impl.rdbms.settings.pool.BIDBComponent

import scala.concurrent.Future

trait TechnologyRepo extends TechnologyMapping with TransactionalRepo{
  this: DriverComponent =>

  import driver.api._

  def get(id: Int): Future[Option[Technology]] = withTransaction{
    technologyInfo.filter(_.id === id).result.headOption
  }

  def insert(technology: Technology): Future[Int] = {
    withTransaction(technologyInfo += technology)
  }

  def delete(id: Int): Future[Int] = {
    val query = technologyInfo.filter(t => t.id === id)
    val action = query.delete
    withTransaction(action)
  }

  def getAll: Future[List[Technology]] = withTransaction{
    technologyInfo.to[List].result
  }

}
object TechnologyRepoImpl extends TechnologyRepo with PGDriver with BIDBComponent

object TechnologyRepoFactory {
  def apply() = new TechnologyRepo with PGDriver with BIDBComponent{}
}
