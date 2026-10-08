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

/** Defines the types of relationships between actions. */
public enum class ActionRelationshipType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Before_Start("before-start", "http://hl7.org/fhir/action-relationship-type", "Before Start"),
  Before("before", "http://hl7.org/fhir/action-relationship-type", "Before"),
  Before_End("before-end", "http://hl7.org/fhir/action-relationship-type", "Before End"),
  Concurrent_With_Start(
    "concurrent-with-start",
    "http://hl7.org/fhir/action-relationship-type",
    "Concurrent With Start",
  ),
  Concurrent("concurrent", "http://hl7.org/fhir/action-relationship-type", "Concurrent"),
  Concurrent_With_End(
    "concurrent-with-end",
    "http://hl7.org/fhir/action-relationship-type",
    "Concurrent With End",
  ),
  After_Start("after-start", "http://hl7.org/fhir/action-relationship-type", "After Start"),
  After("after", "http://hl7.org/fhir/action-relationship-type", "After"),
  After_End("after-end", "http://hl7.org/fhir/action-relationship-type", "After End");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ActionRelationshipType =
      when (code) {
        "before-start" -> Before_Start
        "before" -> Before
        "before-end" -> Before_End
        "concurrent-with-start" -> Concurrent_With_Start
        "concurrent" -> Concurrent
        "concurrent-with-end" -> Concurrent_With_End
        "after-start" -> After_Start
        "after" -> After
        "after-end" -> After_End
        else -> throw IllegalArgumentException("Unknown code $code for enum ActionRelationshipType")
      }
  }
}
