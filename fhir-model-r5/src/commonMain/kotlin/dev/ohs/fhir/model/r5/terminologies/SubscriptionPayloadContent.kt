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

/** Codes to represent how much resource content to send in the notification payload. */
public enum class SubscriptionPayloadContent(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Empty("empty", "http://hl7.org/fhir/subscription-payload-content", "Empty"),
  Id_Only("id-only", "http://hl7.org/fhir/subscription-payload-content", "Id-only"),
  Full_Resource(
    "full-resource",
    "http://hl7.org/fhir/subscription-payload-content",
    "Full-resource",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SubscriptionPayloadContent =
      when (code) {
        "empty" -> Empty
        "id-only" -> Id_Only
        "full-resource" -> Full_Resource
        else ->
          throw IllegalArgumentException("Unknown code $code for enum SubscriptionPayloadContent")
      }
  }
}
