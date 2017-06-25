package models

case class Expert(techId: Int, knolId: Int, skill: Int)

trait ExpertTable extends TechnologyTable with KnolderTable{

  import slick.jdbc.PostgresProfile.api._

  class ExpertTable(tag: Tag) extends Table[Expert](tag, "expert") {
    val techId = column[Int]("t_id", O.PrimaryKey)
    val knolId = column[Int]("k_id", O.PrimaryKey)
    val skill = column[Int]("skill_level", O.PrimaryKey)

    def technologyExpertFK = foreignKey("technology-expert_fk", techId, technologyTableQuery)(_.id)
    def knolderExpertFK = foreignKey("knolder-expert_fk", knolId, knolderTableQuery)(_.id)

    def * = (techId, knolId, skill) <> (Expert.tupled, Expert.unapply)
  }

  val expertTableQuery = TableQuery[ExpertTable]
}