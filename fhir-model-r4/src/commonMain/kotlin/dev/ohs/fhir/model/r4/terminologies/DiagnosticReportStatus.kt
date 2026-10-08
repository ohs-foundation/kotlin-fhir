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

package dev.ohs.fhir.model.r4.terminologies

import dev.ohs.fhir.model.r4.FhirEnum
import kotlin.String

/** The status of the diagnostic report. */
public enum class DiagnosticReportStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Registered("registered", "http://hl7.org/fhir/diagnostic-report-status", "Registered"),
  Partial("partial", "http://hl7.org/fhir/diagnostic-report-status", "Partial"),
  Preliminary("preliminary", "http://hl7.org/fhir/diagnostic-report-status", "Preliminary"),
  Final("final", "http://hl7.org/fhir/diagnostic-report-status", "Final"),
  Amended("amended", "http://hl7.org/fhir/diagnostic-report-status", "Amended"),
  Corrected("corrected", "http://hl7.org/fhir/diagnostic-report-status", "Corrected"),
  Appended("appended", "http://hl7.org/fhir/diagnostic-report-status", "Appended"),
  Cancelled("cancelled", "http://hl7.org/fhir/diagnostic-report-status", "Cancelled"),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/diagnostic-report-status",
    "Entered in Error",
  ),
  Unknown("unknown", "http://hl7.org/fhir/diagnostic-report-status", "Unknown");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DiagnosticReportStatus =
      when (code) {
        "registered" -> Registered
        "partial" -> Partial
        "preliminary" -> Preliminary
        "final" -> Final
        "amended" -> Amended
        "corrected" -> Corrected
        "appended" -> Appended
        "cancelled" -> Cancelled
        "entered-in-error" -> Entered_In_Error
        "unknown" -> Unknown
        else -> throw IllegalArgumentException("Unknown code $code for enum DiagnosticReportStatus")
      }
  }
}
