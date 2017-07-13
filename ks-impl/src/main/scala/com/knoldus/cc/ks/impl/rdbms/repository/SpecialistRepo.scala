package com.knoldus.cc.ks.impl.rdbms.repository

import com.knoldus.cc.ks.Expert
import com.knoldus.cc.ks.Specialist
import com.knoldus.cc.ks.impl.rdbms.mapping.ExpertMapping
import com.knoldus.cc.ks.impl.rdbms.mapping.SpecialistMapping
import com.knoldus.cc.ks.impl.rdbms.settings.TransactionalRepo
import com.knoldus.cc.ks.impl.rdbms.settings.driver.{DriverComponent, PGDriver}
import com.knoldus.cc.ks.impl.rdbms.settings.pool.BIDBComponent

import scala.concurrent.Future

trait SpecialistRepo extends SpecialistMapping with TransactionalRepo{
  this: DriverComponent =>

  import driver.api._

  def getByTechnologyId(technologyId: Int): Future[List[Specialist]] = withTransaction{
    specialistInfo.filter(spel => spel.technologyId === technologyId).to[List].result
  }

  def getAll: Future[List[Specialist]] = withTransaction{
    specialistInfo.to[List].result
  }
}

object SpecialistRepoImpl extends SpecialistRepo with PGDriver with BIDBComponent

object SpecialistRepoFactory {
  def apply() = new SpecialistRepo with PGDriver with BIDBComponent{}
}
