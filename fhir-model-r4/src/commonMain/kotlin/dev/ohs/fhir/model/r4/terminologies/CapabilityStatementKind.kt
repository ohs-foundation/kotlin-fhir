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

/** How a capability statement is intended to be used. */
public enum class CapabilityStatementKind(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Instance("instance", "http://hl7.org/fhir/capability-statement-kind", "Instance"),
  Capability("capability", "http://hl7.org/fhir/capability-statement-kind", "Capability"),
  Requirements("requirements", "http://hl7.org/fhir/capability-statement-kind", "Requirements");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): CapabilityStatementKind =
      when (code) {
        "instance" -> Instance
        "capability" -> Capability
        "requirements" -> Requirements
        else ->
          throw IllegalArgumentException("Unknown code $code for enum CapabilityStatementKind")
      }
  }
}
