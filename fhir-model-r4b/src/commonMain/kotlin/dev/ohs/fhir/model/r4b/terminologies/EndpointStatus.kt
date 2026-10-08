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

/** The status of the endpoint. */
public enum class EndpointStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Active("active", "http://hl7.org/fhir/endpoint-status", "Active"),
  Suspended("suspended", "http://hl7.org/fhir/endpoint-status", "Suspended"),
  Error("error", "http://hl7.org/fhir/endpoint-status", "Error"),
  Off("off", "http://hl7.org/fhir/endpoint-status", "Off"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/endpoint-status", "Entered in error"),
  Test("test", "http://hl7.org/fhir/endpoint-status", "Test");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): EndpointStatus =
      when (code) {
        "active" -> Active
        "suspended" -> Suspended
        "error" -> Error
        "off" -> Off
        "entered-in-error" -> Entered_In_Error
        "test" -> Test
        else -> throw IllegalArgumentException("Unknown code $code for enum EndpointStatus")
      }
  }
}
