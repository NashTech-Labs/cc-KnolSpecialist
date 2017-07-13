package com.knoldus.cc.ks.impl

import akka.NotUsed
import com.knoldus.cc.ks.{Technology, Specialist}
import com.knoldus.cc.ks.api.KnolSpecialistService
import com.knoldus.cc.ks.impl.rdbms.repository.{TechnologyRepoFactory, SpecialistRepoFactory}
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.ExecutionContext.Implicits.global

class KnolSpecialistImpl extends KnolSpecialistService{

  val technologyRepo = TechnologyRepoFactory()
  val specialistRepo = SpecialistRepoFactory()

  @Override
  def getTechnique(id: Int): ServiceCall[NotUsed, Technology] = ServiceCall{ request =>
    technologyRepo.get(id).map{
      case Some(tech) => tech
	case None => throw new Exception(s"No technology found for id $id")
    }
  }

  @Override
  def getAllTechnologies: ServiceCall[NotUsed, List[Technology]] = ServiceCall{ request =>
    technologyRepo.getAll
  }

  @Override
  def getAllSpecialist: ServiceCall[NotUsed, List[Specialist]] = ServiceCall { request =>
      specialistRepo.getAll
  }

  @Override
  def getSpecialistByTechnology(techId: Int): ServiceCall[NotUsed, List[Specialist]] = ServiceCall { request =>
      specialistRepo.getByTechnologyId(techId)
  }


}
