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

/** Possible group measure aggregates (E.g. Mean, Median). */
public enum class GroupMeasure(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Mean("mean", "http://hl7.org/fhir/group-measure", "Mean"),
  Median("median", "http://hl7.org/fhir/group-measure", "Median"),
  Mean_Of_Mean("mean-of-mean", "http://hl7.org/fhir/group-measure", "Mean of Study Means"),
  Mean_Of_Median("mean-of-median", "http://hl7.org/fhir/group-measure", "Mean of Study Medins"),
  Median_Of_Mean("median-of-mean", "http://hl7.org/fhir/group-measure", "Median of Study Means"),
  Median_Of_Median(
    "median-of-median",
    "http://hl7.org/fhir/group-measure",
    "Median of Study Medians",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): GroupMeasure =
      when (code) {
        "mean" -> Mean
        "median" -> Median
        "mean-of-mean" -> Mean_Of_Mean
        "mean-of-median" -> Mean_Of_Median
        "median-of-mean" -> Median_Of_Mean
        "median-of-median" -> Median_Of_Median
        else -> throw IllegalArgumentException("Unknown code $code for enum GroupMeasure")
      }
  }
}
