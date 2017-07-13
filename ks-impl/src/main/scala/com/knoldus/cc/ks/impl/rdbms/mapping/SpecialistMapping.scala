package com.knoldus.cc.ks.impl.rdbms.mapping

import com.knoldus.cc.ks.Technology
import com.knoldus.cc.ks.Specialist
import com.knoldus.cc.ks.impl.rdbms.settings.driver.DriverComponent
import slick.lifted.ProvenShape

trait SpecialistMapping {

  this: DriverComponent =>

  import driver.api._

  private[rdbms] class SpecialistMapping(tag: Tag) extends Table[Specialist](tag, "specialist") {

    val id: Rep[Long] = column[Long]("id", O.PrimaryKey)

    val name: Rep[String] = column[String]("knolder_name")

    val percentage: Rep[Float] = column[Float]("skill_percentage")

    val technologyId: Rep[Int] = column[Int]("technology_id")

    def * : ProvenShape[Specialist] = (id, name, percentage, technologyId) <> (Specialist.tupled, Specialist.unapply)
  }

  val specialistInfo: TableQuery[SpecialistMapping] = TableQuery[SpecialistMapping]

  protected def specialistAutoInc = specialistInfo returning specialistInfo.map(_.id)

}
