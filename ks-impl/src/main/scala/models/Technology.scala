package models

case class Technology(id: Int, name: String)

trait TechnologyTable {
  import slick.jdbc.PostgresProfile.api._

  class TechnologyTable(tag: Tag) extends Table[Technology](tag, "technology") {
    val id = column[Int]("t_id", O.PrimaryKey)
    val name = column[String]("t_name")

    def *  = (id, name) <> (Technology.tupled, Technology.unapply)
  }

  val technologyTableQuery = TableQuery[TechnologyTable]
}

