package com.knoldus.cc.ks.impl.rdbms.repository

import com.freebird.rdbms.mapping.FlightMapping
import com.freebird.rdbms.models.RDFlight
import com.freebird.rdbms.settings.TransactionalRepo
import com.freebird.rdbms.settings.driver.{PGDriver, DriverComponent}
import com.freebird.rdbms.settings.pool.BIDBComponent
import com.freebird.concurrent.ExecutionContext.IO.dbOperations
import com.freebird.util.DateUtil
import com.freebird.util.exception.FlightTwiceADayException
import com.freebird.util.logger.FreebirdLogger
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import scala.concurrent.Future


trait FlightRepo extends FlightMapping with TransactionalRepo with FreebirdLogger{
  this: DriverComponent =>

  import driver.api._

  def getFlight(airlineCode: String, flightNumber: String, origin: String, destination: String, flightDate: String)
  : Future[Option[RDFlight]] = withTransaction{
    flightInfo.filter { data =>
      data.airlineCode === airlineCode &&
        data.flightNumber === flightNumber &&
        data.flightDate === flightDate &&
        data.originAirport === origin &&
        data.destinationAirport === destination
    }.result.headOption
  }

  private def getFlightIfExist(rdFlight: RDFlight) = {
    flightInfo.filter { data =>
      data.airlineCode === rdFlight.airlineCode &&
        data.flightNumber === rdFlight.flightNumber &&
        data.flightDate === rdFlight.flightDate &&
        data.originAirport === rdFlight.originAirport &&
        data.destinationAirport === rdFlight.destinationAirport
    }.result.headOption
  }

  private def insertFlight(rdFlight: RDFlight) = {
    (flightAutoInc += rdFlight) map { fId =>
      Some(rdFlight.copy(id = fId))
    }
  }

  def createFlightIfNotExist(rdFlight: RDFlight): Future[Option[RDFlight]] = withTransaction{
    for{
      existedFlight <- getFlightIfExist(rdFlight)
      insertedFlight <- existedFlight match {
        case Some(flt) => DBIO.successful(Some(flt))
        case None => insertFlight(rdFlight)
      }
    } yield insertedFlight
  }

  val dtf = DateTimeFormat.forPattern("yyyy-MM-dd")

  def findFlightWithDepartureDates(rdFlight: RDFlight): Future[Set[RDFlight]] = withTransaction {

    val nextDay = dtf.parseLocalDate(rdFlight.flightDate).plusDays(1)
    val previousDay = dtf.parseLocalDate(rdFlight.flightDate).minusDays(1)
    val dates = List(rdFlight.flightDate, nextDay.toString, previousDay.toString)

    flightInfo.filter { data =>
      data.airlineCode === rdFlight.airlineCode &&
        data.flightNumber === rdFlight.flightNumber &&
        data.originAirport === rdFlight.originAirport &&
        data.destinationAirport === rdFlight.destinationAirport &&
        data.flightDate.inSetBind(dates)
    }.to[Set].result
  }

}

object FlightRepoImpl extends FlightRepo with PGDriver with BIDBComponent

object FlightRepoFactory {
  def apply() = new FlightRepo with PGDriver with BIDBComponent{}
}
