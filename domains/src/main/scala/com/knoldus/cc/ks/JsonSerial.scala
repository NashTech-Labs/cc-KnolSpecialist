package com.knoldus.cc.ks

import play.api.libs.json.{Json, Format}


object JsonSerial {
  implicit val format: Format[Technology] = Json.format
  implicit val format2: Format[Specialist] = Json.format
}
