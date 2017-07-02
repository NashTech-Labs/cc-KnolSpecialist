package com.knoldus.cc.ks.impl.rdbms.mapping

import com.knoldus.cc.ks.impl.rdbms.model.Expert
import com.knoldus.cc.ks.impl.rdbms.settings.driver.DriverComponent
import slick.lifted.ProvenShape

trait ExpertMapping extends TechnologyMapping with KnolderMapping{

  this: DriverComponent =>

  import driver.api._

  private[rdbms] class ExpertMapping(tag: Tag) extends Table[Expert](tag, "expert") {
    val techId: Rep[Int] = column[Int]("t_id", O.PrimaryKey)
    val knolId: Rep[Int] = column[Int]("k_id", O.PrimaryKey)
    val skill: Rep[Int] = column[Int]("skill_level", O.PrimaryKey)

    def * : ProvenShape[Expert] = (techId, knolId, skill) <> (Expert.tupled, Expert.unapply)

    def technologyExpertFK = foreignKey("technology-expert_fk", techId, technologyInfo)(_.id)
    def knolderExpertFK = foreignKey("knolder-expert_fk", knolId, knolderInfo)(_.id)
  }

  val expertInfo: TableQuery[ExpertMapping] = TableQuery[ExpertMapping]
  protected def expertAutoInc = expertInfo returning expertInfo.map(_.techId)
}

