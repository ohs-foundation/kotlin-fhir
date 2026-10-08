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

/**
 * The level of confidence that this link represents the same actual person, based on NIST
 * Authentication Levels.
 */
public enum class IdentityAssuranceLevel(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Level1("level1", "http://hl7.org/fhir/identity-assuranceLevel", "Level 1"),
  Level2("level2", "http://hl7.org/fhir/identity-assuranceLevel", "Level 2"),
  Level3("level3", "http://hl7.org/fhir/identity-assuranceLevel", "Level 3"),
  Level4("level4", "http://hl7.org/fhir/identity-assuranceLevel", "Level 4");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): IdentityAssuranceLevel =
      when (code) {
        "level1" -> Level1
        "level2" -> Level2
        "level3" -> Level3
        "level4" -> Level4
        else -> throw IllegalArgumentException("Unknown code $code for enum IdentityAssuranceLevel")
      }
  }
}
