/*
package com.knoldus.cc.ks.impl.rdbms.mapping

trait LegMapping {
  this: DriverComponent =>

  val legInfo: TableQuery[LegMapping] = TableQuery[LegMapping]

  protected def legAutoInc = legInfo returning legInfo.map(_.id)

  private[rdbms] class LegMapping(tag: Tag) extends Table[RDLeg](tag, "leg") {

    def * : ProvenShape[RDLeg] = (id, aircraft, originIata, destinationIata, metadata, ordinal,
      vertexId, segmentId, flightId) <>(RDLeg.tupled, RDLeg.unapply)

    def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def aircraft: Rep[Option[String]] = column[Option[String]]("aircraft")

    def originIata: Rep[String] = column[String]("origin_iata")

    def destinationIata: Rep[String] = column[String]("destination_iata")

    def metadata: Rep[Option[String]] = column[Option[String]]("metadata")

    def ordinal: Rep[Int] = column[Int]("ordinal")

    def vertexId: Rep[String] = column[String]("vertex_id")

    def segmentId: Rep[Long] = column[Long]("segment_id")

    def flightId: Rep[Long] = column[Long]("flight_id")
  }

}
*/
