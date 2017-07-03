package com.knoldus.cc.ingestion.impl

import akka.NotUsed
import akka.persistence.cassandra.session.scaladsl.CassandraSession
import akka.stream.scaladsl.Source
import com.knoldus.cc.ingestion.api.IngestionService
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.Future

class IngestionServiceImpl(cassandraSession: CassandraSession) extends IngestionService{

  override def ingest(channelId: String): ServiceCall[Nothing, Source[String, NotUsed]] = ServiceCall { request =>
        val response: Source[String, NotUsed] =
          cassandraSession.select("SELECT * FROM CodeCombat.teams")
            .map(row => row.getString("id") + row.getString("names") + row.getInt("no_of_team_members"))
    Future.successful(response)
  }
}
