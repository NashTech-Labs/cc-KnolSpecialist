package com.knoldus.cc.ks.impl
import com.knoldus.cc.ks.api.KnolSpecialistService
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession.tryWith

import scala.collection.mutable.ListBuffer

class KnolSpecialistImpl(jdbcSession: JdbcSession) extends KnolSpecialistService{

  @Override
  def getTechnique(): ServiceCall[String, String] = ServiceCall { request =>
    jdbcSession.withConnection { connection =>
      tryWith(connection.prepareStatement("SELECT * FROM technologies")) { ps =>
        tryWith(ps.executeQuery) { rs =>
          val summaries = new ListBuffer[(Int, String)]
          while (rs.next()) {
            summaries += ((rs.getInt("id"), rs.getString("title")))
          }
          summaries.toList.mkString("/")
        }
      }
    }
  }
}
