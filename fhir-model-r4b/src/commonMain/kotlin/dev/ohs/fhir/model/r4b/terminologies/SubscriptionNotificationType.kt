/*
 * Copyright 2026 Open Health Stack Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ohs.fhir.model.r4b.terminologies

import dev.ohs.fhir.model.r4b.FhirEnum
import kotlin.String

/** The type of notification represented by the status message. */
public enum class SubscriptionNotificationType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Handshake("handshake", "http://hl7.org/fhir/subscription-notification-type", "Handshake"),
  Heartbeat("heartbeat", "http://hl7.org/fhir/subscription-notification-type", "Heartbeat"),
  Event_Notification(
    "event-notification",
    "http://hl7.org/fhir/subscription-notification-type",
    "Event Notification",
  ),
  Query_Status(
    "query-status",
    "http://hl7.org/fhir/subscription-notification-type",
    "Query Status",
  ),
  Query_Event("query-event", "http://hl7.org/fhir/subscription-notification-type", "Query Event");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SubscriptionNotificationType =
      when (code) {
        "handshake" -> Handshake
        "heartbeat" -> Heartbeat
        "event-notification" -> Event_Notification
        "query-status" -> Query_Status
        "query-event" -> Query_Event
        else ->
          throw IllegalArgumentException("Unknown code $code for enum SubscriptionNotificationType")
      }
  }
}
