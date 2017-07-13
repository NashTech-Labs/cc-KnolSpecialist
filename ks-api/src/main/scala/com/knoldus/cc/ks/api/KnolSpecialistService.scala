package com.knoldus.cc.ks.api

import akka.NotUsed
import com.knoldus.cc.ks.Technology
import com.knoldus.cc.ks.Specialist
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

import scala.concurrent.Future

trait KnolSpecialistService extends Service {

  import com.knoldus.cc.ks.JsonSerial._

  def getTechnique(id: Int): ServiceCall[NotUsed, Technology]

  def getAllTechnologies: ServiceCall[NotUsed, List[Technology]]

  def getAllSpecialist: ServiceCall[NotUsed, List[Specialist]]

  def getSpecialistByTechnology(techId: Int): ServiceCall[NotUsed, List[Specialist]]

  def welcome: ServiceCall[NotUsed, String] = ServiceCall { request =>
    Future.successful("Welcome to cc-specialist")
  }

  override def descriptor: Descriptor = {
    import Service._
    named("ks")
      .withCalls(
        pathCall("/", welcome _),
        pathCall("/api/get/technology/:id", getTechnique _),
        pathCall("/api/get/technologies", getAllTechnologies _),
        pathCall("/api/get/experts", getAllSpecialist _),
        pathCall("/api/get/expert/technology/:id", getSpecialistByTechnology _)
      )
      .withAutoAcl(true)
  }

}