/*
package com.knoldus.cc.ks.impl.rdbms.mapping

import java.sql.Timestamp

import com.knoldus.cc.ks.impl.rdbms.settings.driver.DriverComponent


trait FlightMapping {
  this: DriverComponent =>

  val flightInfo: TableQuery[FlightMapping] = TableQuery[FlightMapping]

  protected def flightAutoInc = flightInfo returning flightInfo.map(_.id)

  private[rdbms] class FlightMapping(tag: Tag) extends Table[RDFlight](tag, "flight") {

    def * : ProvenShape[RDFlight] = (id, airlineCode, flightNumber, flightDate, oagId, vertexId,
      originAirport, destinationAirport, departureUtc, departureLocal, arrivalUtc, arrivalLocal) <>(RDFlight.tupled, RDFlight.unapply)

    def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def airlineCode: Rep[String] = column[String]("airline_code")

    def flightNumber: Rep[String] = column[String]("flight_number")

    def flightDate: Rep[String] = column[String]("flight_date")

    def oagId: Rep[Option[String]] = column[Option[String]]("oag_id")

    def vertexId: Rep[String] = column[String]("vertex_id")

    def originAirport: Rep[String] = column[String]("origin_airport")

    def destinationAirport: Rep[String] = column[String]("destination_airport")

    def departureUtc: Rep[Option[Timestamp]] = column[Option[Timestamp]]("departure_utc")

    def departureLocal: Rep[Option[Timestamp]] = column[Option[Timestamp]]("departure_local")

    def arrivalUtc: Rep[Option[Timestamp]] = column[Option[Timestamp]]("arrival_utc")

    def arrivalLocal: Rep[Option[Timestamp]] = column[Option[Timestamp]]("arrival_local")
  }

}
*/
