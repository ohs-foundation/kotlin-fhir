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

/** Defines expectations around whether an action or action group is required. */
public enum class ActionRequiredBehavior(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Must("must", "http://hl7.org/fhir/action-required-behavior", "Must"),
  Could("could", "http://hl7.org/fhir/action-required-behavior", "Could"),
  Must_Unless_Documented(
    "must-unless-documented",
    "http://hl7.org/fhir/action-required-behavior",
    "Must Unless Documented",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ActionRequiredBehavior =
      when (code) {
        "must" -> Must
        "could" -> Could
        "must-unless-documented" -> Must_Unless_Documented
        else -> throw IllegalArgumentException("Unknown code $code for enum ActionRequiredBehavior")
      }
  }
}
