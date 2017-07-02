package com.knoldus.cc.ks

import play.api.libs.json.{Json, Format}

/**
 * Created by pranjut on 3/7/17.
 */
object JsonSerial {
  implicit val format: Format[Technology] = Json.format
}
