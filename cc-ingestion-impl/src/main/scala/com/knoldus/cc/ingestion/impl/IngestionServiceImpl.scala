package com.knoldus.cc.ingestion.impl

import com.knoldus.cc.ingestion.api.IngestionService
import com.lightbend.lagom.scaladsl.api.ServiceCall

class IngestionServiceImpl extends IngestionService{

  override def ingest(channelId: String): ServiceCall[String, String] = ???

}
