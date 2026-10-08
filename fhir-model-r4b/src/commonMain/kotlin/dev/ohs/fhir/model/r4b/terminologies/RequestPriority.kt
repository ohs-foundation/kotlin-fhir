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

/** Identifies the level of importance to be assigned to actioning the request. */
public enum class RequestPriority(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Routine("routine", "http://hl7.org/fhir/request-priority", "Routine"),
  Urgent("urgent", "http://hl7.org/fhir/request-priority", "Urgent"),
  Asap("asap", "http://hl7.org/fhir/request-priority", "ASAP"),
  Stat("stat", "http://hl7.org/fhir/request-priority", "STAT");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): RequestPriority =
      when (code) {
        "routine" -> Routine
        "urgent" -> Urgent
        "asap" -> Asap
        "stat" -> Stat
        else -> throw IllegalArgumentException("Unknown code $code for enum RequestPriority")
      }
  }
}
