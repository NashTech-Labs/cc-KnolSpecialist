package com.knoldus.cc.ks.impl.rdbms.mapping

import com.knoldus.cc.ks.Knolder
import com.knoldus.cc.ks.impl.rdbms.settings.driver.DriverComponent
import slick.lifted.ProvenShape

trait KnolderMapping {

  this: DriverComponent =>

  import driver.api._

  private[rdbms] class KnolderMapping(tag: Tag) extends Table[Knolder](tag, "knolder") {
    val id: Rep[Int] = column[Int]("k_id", O.PrimaryKey)
    val name: Rep[String] = column[String]("k_name")
    val designation: Rep[String] = column[String]("k_desg")

    def * : ProvenShape[Knolder] = (id, name, designation) <> (Knolder.tupled, Knolder.unapply)
  }

  val knolderInfo: TableQuery[KnolderMapping] = TableQuery[KnolderMapping]

  protected def knolderAutoInc: driver.ReturningInsertActionComposer[Knolder, Int] = knolderInfo returning knolderInfo.map(_.id)

}
