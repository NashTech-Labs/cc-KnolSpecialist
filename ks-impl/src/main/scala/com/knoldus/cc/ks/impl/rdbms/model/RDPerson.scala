package com.knoldus.cc.ks.impl.rdbms.model


case class RDPerson(
                    id: Long,
                    firstName: String,
                    middleName: Option[String],
                    lastName: String,
                    age: Option[Int],
                    dateOfBirth: Option[String],
                    phone: String,
                    email: String,
                    vertexId: String,
                    tripId: Long,
                    userId: Option[Long],
                    isDeciderToPay: Option[Boolean],
                    isPayer: Boolean,
                    isPassenger: Boolean,
                    isBookingPerson: Option[Boolean],
                    notifyMe: Boolean,
                    isTravelAgent: Option[Boolean]
                    ){
  def getPerson: Person = Person(None, firstName, lastName, middleName, dateOfBirth, phone, email)
}
