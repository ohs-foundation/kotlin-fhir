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

/** Basis for membership in a group */
public enum class GroupMembershipBasis(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Definitional("definitional", "http://hl7.org/fhir/group-membership-basis", "Definitional"),
  Enumerated("enumerated", "http://hl7.org/fhir/group-membership-basis", "Enumerated");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): GroupMembershipBasis =
      when (code) {
        "definitional" -> Definitional
        "enumerated" -> Enumerated
        else -> throw IllegalArgumentException("Unknown code $code for enum GroupMembershipBasis")
      }
  }
}
