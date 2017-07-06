package com.knoldus.cc.ks.impl.rdbms.mapping

import com.knoldus.cc.ks.Expert
import com.knoldus.cc.ks.impl.rdbms.settings.driver.DriverComponent
import slick.lifted.ProvenShape

trait ExpertMapping{

  this: DriverComponent =>

  import driver.api._

  private[rdbms] class ExpertMapping(tag: Tag) extends Table[Expert](tag, "expert") {
    val techId: Rep[Int] = column[Int]("t_id")
    val knolId: Rep[Int] = column[Int]("k_id")
    val skill: Rep[Int] = column[Int]("skill_level")
    def pk = primaryKey("pk_expert", (techId, knolId))

    def * : ProvenShape[Expert] = (techId, knolId, skill) <> (Expert.tupled, Expert.unapply)
  }

  val expertInfo: TableQuery[ExpertMapping] = TableQuery[ExpertMapping]
  protected def expertAutoInc = expertInfo returning expertInfo.map(_.techId)
}

