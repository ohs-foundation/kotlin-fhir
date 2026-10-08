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

/** How the system supports versioning for a resource. */
public enum class ResourceVersionPolicy(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  No_Version("no-version", "http://hl7.org/fhir/versioning-policy", "No VersionId Support"),
  Versioned("versioned", "http://hl7.org/fhir/versioning-policy", "Versioned"),
  Versioned_Update(
    "versioned-update",
    "http://hl7.org/fhir/versioning-policy",
    "VersionId tracked fully",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ResourceVersionPolicy =
      when (code) {
        "no-version" -> No_Version
        "versioned" -> Versioned
        "versioned-update" -> Versioned_Update
        else -> throw IllegalArgumentException("Unknown code $code for enum ResourceVersionPolicy")
      }
  }
}
