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

/** State values for FHIR Subscriptions. */
public enum class SubscriptionStatusCodes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Requested("requested", "http://hl7.org/fhir/subscription-status", "Requested"),
  Active("active", "http://hl7.org/fhir/subscription-status", "Active"),
  Error("error", "http://hl7.org/fhir/subscription-status", "Error"),
  Off("off", "http://hl7.org/fhir/subscription-status", "Off"),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/subscription-status",
    "Entered in Error",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SubscriptionStatusCodes =
      when (code) {
        "requested" -> Requested
        "active" -> Active
        "error" -> Error
        "off" -> Off
        "entered-in-error" -> Entered_In_Error
        else ->
          throw IllegalArgumentException("Unknown code $code for enum SubscriptionStatusCodes")
      }
  }
}
