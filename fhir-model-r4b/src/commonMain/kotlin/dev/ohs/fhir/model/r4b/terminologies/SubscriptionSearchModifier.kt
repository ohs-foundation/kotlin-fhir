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

/** FHIR search modifiers allowed for use in Subscriptions and SubscriptionTopics. */
public enum class SubscriptionSearchModifier(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  EqualTo("=", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "="),
  Eq("eq", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Equal"),
  Ne("ne", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Not Equal"),
  Gt("gt", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Greater Than"),
  Lt("lt", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Less Than"),
  Ge(
    "ge",
    "http://terminology.hl7.org/CodeSystem/subscription-search-modifier",
    "Greater Than or Equal",
  ),
  Le(
    "le",
    "http://terminology.hl7.org/CodeSystem/subscription-search-modifier",
    "Less Than or Equal",
  ),
  Sa("sa", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Starts After"),
  Eb("eb", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Ends Before"),
  Ap("ap", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Approximately"),
  Above("above", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Above"),
  Below("below", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Below"),
  In("in", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "In"),
  Not_In("not-in", "http://terminology.hl7.org/CodeSystem/subscription-search-modifier", "Not In"),
  Of_Type(
    "of-type",
    "http://terminology.hl7.org/CodeSystem/subscription-search-modifier",
    "Of Type",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SubscriptionSearchModifier =
      when (code) {
        "=" -> EqualTo
        "eq" -> Eq
        "ne" -> Ne
        "gt" -> Gt
        "lt" -> Lt
        "ge" -> Ge
        "le" -> Le
        "sa" -> Sa
        "eb" -> Eb
        "ap" -> Ap
        "above" -> Above
        "below" -> Below
        "in" -> In
        "not-in" -> Not_In
        "of-type" -> Of_Type
        else ->
          throw IllegalArgumentException("Unknown code $code for enum SubscriptionSearchModifier")
      }
  }
}
