package com.knoldus.cc.analytics.impl

import com.knoldus.cc.analytics.api.AnalyticsService
import com.lightbend.lagom.scaladsl.api.ServiceCall

class AnalyticsImpl extends AnalyticsService{
  override def analyze(): ServiceCall[String, String] = ???
}
