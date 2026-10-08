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

/** The type of response code to use for assertion. */
public enum class AssertionResponseTypes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Okay("okay", "http://hl7.org/fhir/assert-response-code-types", "okay"),
  Created("created", "http://hl7.org/fhir/assert-response-code-types", "created"),
  NoContent("noContent", "http://hl7.org/fhir/assert-response-code-types", "noContent"),
  NotModified("notModified", "http://hl7.org/fhir/assert-response-code-types", "notModified"),
  Bad("bad", "http://hl7.org/fhir/assert-response-code-types", "bad"),
  Forbidden("forbidden", "http://hl7.org/fhir/assert-response-code-types", "forbidden"),
  NotFound("notFound", "http://hl7.org/fhir/assert-response-code-types", "notFound"),
  MethodNotAllowed(
    "methodNotAllowed",
    "http://hl7.org/fhir/assert-response-code-types",
    "methodNotAllowed",
  ),
  Conflict("conflict", "http://hl7.org/fhir/assert-response-code-types", "conflict"),
  Gone("gone", "http://hl7.org/fhir/assert-response-code-types", "gone"),
  PreconditionFailed(
    "preconditionFailed",
    "http://hl7.org/fhir/assert-response-code-types",
    "preconditionFailed",
  ),
  Unprocessable("unprocessable", "http://hl7.org/fhir/assert-response-code-types", "unprocessable");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AssertionResponseTypes =
      when (code) {
        "okay" -> Okay
        "created" -> Created
        "noContent" -> NoContent
        "notModified" -> NotModified
        "bad" -> Bad
        "forbidden" -> Forbidden
        "notFound" -> NotFound
        "methodNotAllowed" -> MethodNotAllowed
        "conflict" -> Conflict
        "gone" -> Gone
        "preconditionFailed" -> PreconditionFailed
        "unprocessable" -> Unprocessable
        else -> throw IllegalArgumentException("Unknown code $code for enum AssertionResponseTypes")
      }
  }
}
