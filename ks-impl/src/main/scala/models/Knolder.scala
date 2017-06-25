package models

case class Knolder(id: Int, name: String, designation: String)

trait KnolderTable extends TechnologyTable {

  import slick.jdbc.PostgresProfile.api._

  class KnolderTable(tag: Tag) extends Table[Knolder](tag, "knolder") {
    val id = column[Int]("k_id", O.PrimaryKey)
    val name = column[String]("k_name")
    val designation = column[String]("k_desg")

    def * = (id, name, designation) <> (Knolder.tupled, Knolder.unapply)
  }

  val knolderTableQuery = TableQuery[KnolderTable]
}