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

package dev.ohs.fhir.model.r5.terminologies

import dev.ohs.fhir.model.r5.FhirEnum
import kotlin.String

/** The severity of the audit entry. */
public enum class AuditEventSeverity(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Emergency("emergency", "http://hl7.org/fhir/audit-event-severity", "Emergency"),
  Alert("alert", "http://hl7.org/fhir/audit-event-severity", "Alert"),
  Critical("critical", "http://hl7.org/fhir/audit-event-severity", "Critical"),
  Error("error", "http://hl7.org/fhir/audit-event-severity", "Error"),
  Warning("warning", "http://hl7.org/fhir/audit-event-severity", "Warning"),
  Notice("notice", "http://hl7.org/fhir/audit-event-severity", "Notice"),
  Informational("informational", "http://hl7.org/fhir/audit-event-severity", "Informational"),
  Debug("debug", "http://hl7.org/fhir/audit-event-severity", "Debug");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AuditEventSeverity =
      when (code) {
        "emergency" -> Emergency
        "alert" -> Alert
        "critical" -> Critical
        "error" -> Error
        "warning" -> Warning
        "notice" -> Notice
        "informational" -> Informational
        "debug" -> Debug
        else -> throw IllegalArgumentException("Unknown code $code for enum AuditEventSeverity")
      }
  }
}
