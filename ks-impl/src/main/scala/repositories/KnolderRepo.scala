package repositories

import models.{Knolder, KnolderTable}
import slick.jdbc.PostgresProfile

import scala.concurrent.Future

trait KnolderRepo extends KnolderTable {

  import slick.jdbc.PostgresProfile.api._

  val db: PostgresProfile.backend.Database = Database.forConfig("myPostgresDB")

  def create: Future[Unit] = db.run(knolderTableQuery.schema.create)

  def insert(knolder: Knolder): Future[Int] = db.run {
    knolderTableQuery += knolder
  }

  def delete(id: Int): Future[Int] = {
    val query = knolderTableQuery.filter(k => k.id === id)
    val action = query.delete
    db.run(action)
  }
  def updateName(id: Int, name: String): Future[Int] = {
    val query = knolderTableQuery.filter(_.id === id).map(_.name).update(name)
    db.run(query)
  }

  def upsert(knolder: Knolder): Future[Int] = {
    val query = knolderTableQuery.insertOrUpdate(knolder)
    knolderTableQuery += knolder
    db.run(query)
  }

  def getAll: Future[List[Knolder]] = db.run{
    knolderTableQuery.to[List].result
  }

}

object KnolderRepo extends KnolderRepo
