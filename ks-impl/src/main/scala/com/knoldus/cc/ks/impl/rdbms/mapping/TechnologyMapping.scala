package com.knoldus.cc.ks.impl.rdbms.mapping

import com.knoldus.cc.ks.Technology
import com.knoldus.cc.ks.impl.rdbms.settings.driver.DriverComponent
import slick.lifted.ProvenShape

trait TechnologyMapping {

  this: DriverComponent =>

  import driver.api._

  private[rdbms] class TechnologyMapping(tag: Tag) extends Table[Technology](tag, "technology") {

    val id: Rep[Int] = column[Int]("t_id", O.PrimaryKey)

    val name: Rep[String] = column[String]("t_name")

    val url: Rep[String] = column[String]("url")

    def * : ProvenShape[Technology] = (id, name, url) <> (Technology.tupled, Technology.unapply)
  }

  val technologyInfo: TableQuery[TechnologyMapping] = TableQuery[TechnologyMapping]

  protected def technologyAutoInc = technologyInfo returning technologyInfo.map(_.id)

}
