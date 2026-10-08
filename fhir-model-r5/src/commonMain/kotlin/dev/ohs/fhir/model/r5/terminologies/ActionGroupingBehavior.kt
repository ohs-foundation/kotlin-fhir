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

/** Defines organization behavior of a group. */
public enum class ActionGroupingBehavior(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Visual_Group("visual-group", "http://hl7.org/fhir/action-grouping-behavior", "Visual Group"),
  Logical_Group("logical-group", "http://hl7.org/fhir/action-grouping-behavior", "Logical Group"),
  Sentence_Group(
    "sentence-group",
    "http://hl7.org/fhir/action-grouping-behavior",
    "Sentence Group",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ActionGroupingBehavior =
      when (code) {
        "visual-group" -> Visual_Group
        "logical-group" -> Logical_Group
        "sentence-group" -> Sentence_Group
        else -> throw IllegalArgumentException("Unknown code $code for enum ActionGroupingBehavior")
      }
  }
}
