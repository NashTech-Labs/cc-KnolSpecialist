package com.knoldus.cc.ks.impl
import akka.NotUsed
import com.knoldus.cc.ks.api.KnolSpecialistService
import com.knoldus.cc.ks.impl.rdbms.model.Technology
import com.knoldus.cc.ks.impl.rdbms.repository.TechnologyRepoFactory
import com.lightbend.lagom.scaladsl.api.ServiceCall
import scala.concurrent.ExecutionContext.Implicits.global

class KnolSpecialistImpl extends KnolSpecialistService{

  @Override
  def getTechnique(id: Int): ServiceCall[NotUsed, Technology] = ServiceCall{ request =>
    val technologyRepo = TechnologyRepoFactory.apply()
    technologyRepo.get(id).map{
      case Some(tech) => tech
    }
  }

}
