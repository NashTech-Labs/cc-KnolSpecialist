package repositories

import models.{Technology, TechnologyTable}
import slick.jdbc.PostgresProfile

import scala.concurrent.Future

trait TechnologyRepo extends TechnologyTable {

  import slick.jdbc.PostgresProfile.api._

  val db: PostgresProfile.backend.Database = Database.forConfig("myPostgresDB")

  def create: Future[Unit] = db.run(technologyTableQuery.schema.create)

  def insert(technology: Technology): Future[Int] = db.run {
    technologyTableQuery += technology
  }

  def delete(id: Int): Future[Int] = {
    val query = technologyTableQuery.filter(t => t.id === id)
    val action = query.delete
    db.run(action)
  }
  def updateName(id: Int, name: String): Future[Int] = {
    val query = technologyTableQuery.filter(_.id === id).map(_.name).update(name)
    db.run(query)
  }

  def upsert(technology: Technology): Future[Int] = {
    val query = technologyTableQuery.insertOrUpdate(technology)
    technologyTableQuery += technology
    db.run(query)
  }

  def getAll: Future[List[Technology]] = db.run{
    technologyTableQuery.to[List].result
  }
}

object TechnologyRepo extends TechnologyRepo