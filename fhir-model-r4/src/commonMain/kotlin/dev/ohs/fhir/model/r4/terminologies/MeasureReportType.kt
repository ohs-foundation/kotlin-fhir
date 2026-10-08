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

/** The type of the measure report. */
public enum class MeasureReportType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Individual("individual", "http://hl7.org/fhir/measure-report-type", "Individual"),
  Subject_List("subject-list", "http://hl7.org/fhir/measure-report-type", "Subject List"),
  Summary("summary", "http://hl7.org/fhir/measure-report-type", "Summary"),
  Data_Collection("data-collection", "http://hl7.org/fhir/measure-report-type", "Data Collection");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): MeasureReportType =
      when (code) {
        "individual" -> Individual
        "subject-list" -> Subject_List
        "summary" -> Summary
        "data-collection" -> Data_Collection
        else -> throw IllegalArgumentException("Unknown code $code for enum MeasureReportType")
      }
  }
}
