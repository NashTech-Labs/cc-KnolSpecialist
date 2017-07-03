package com.knoldus.cc.ingestion.impl

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import play.api.libs.json.JsValue
import slack.api.SlackApiClient

import scala.concurrent.Future
import scala.language.postfixOps

class SlackOperations {

  val actorSystem = ActorSystem("Slack")
  val conf = ConfigFactory.load()
  val token = "xoxp-4087670877-158418401744-204250459729-47ba26821f1e1d4191312c4e8b1f5a61"
  val client = SlackApiClient(token)

  /*
 * Retrieve history messages for a Channel (allknol channel id = C1FQV802V)
 */

  def getHistory(channelId: String): Future[List[JsValue]] = {
    val channelHistory = client.getChannelHistory(channelId)(actorSystem)
    channelHistory.map(_.messages.toList)
  }
}
