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

/** The kind of response to a message. */
public enum class ResponseType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Ok("ok", "http://hl7.org/fhir/response-code", "OK"),
  Transient_Error("transient-error", "http://hl7.org/fhir/response-code", "Transient Error"),
  Fatal_Error("fatal-error", "http://hl7.org/fhir/response-code", "Fatal Error");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ResponseType =
      when (code) {
        "ok" -> Ok
        "transient-error" -> Transient_Error
        "fatal-error" -> Fatal_Error
        else -> throw IllegalArgumentException("Unknown code $code for enum ResponseType")
      }
  }
}
