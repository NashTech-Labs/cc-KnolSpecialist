package repositories

import models.{Expert, ExpertTable, Knolder, Technology}
import slick.jdbc.PostgresProfile

import scala.concurrent.Future

trait ExpertRepo extends ExpertTable {

  import slick.jdbc.PostgresProfile.api._

  val db: PostgresProfile.backend.Database = Database.forConfig("myPostgresDB")

  def create: Future[Unit] = db.run(expertTableQuery.schema.create)

  def insert(expert: Expert): Future[Int] = db.run {
    expertTableQuery += expert
  }

  def delete(knolId: Int, techId: Int): Future[Int] = {
    val query = expertTableQuery.filter(d => d.knolId === knolId && d.techId === techId)
    val action = query.delete
    db.run(action)
  }
  def updateSkill(knolId: Int, techId: Int, skill: Int): Future[Int] = {
    val query = expertTableQuery
      .filter(e => e.techId === techId && e.knolId === knolId)
      .map(_.skill).update(skill)
    db.run(query)
  }

  def upsert(expert: Expert): Future[Int] = {
    val query = expertTableQuery.insertOrUpdate(expert)
    expertTableQuery += expert
    db.run(query)
  }

  def getAll: Future[List[Expert]] = db.run{
    expertTableQuery.to[List].result
  }

  def getExpertWithKnolder: Future[List[(Knolder, Expert)]] = db.run {
    (for {
      expert <- expertTableQuery
      knolder <- expert.knolderExpertFK
    }yield (knolder, expert)).to[List].result
  }

  def getExpertWithTechnology: Future[List[(Technology, Expert)]] = db.run {
    (for {
      expert <- expertTableQuery
      technology <- expert.technologyExpertFK
    }yield (technology, expert)).to[List].result
  }

}

object ExpertRepo extends ExpertRepo