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

/** Codes indicating the degree of authority/intentionality associated with a care plan. */
public enum class CarePlanIntent(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Proposal("proposal", "http://hl7.org/fhir/request-intent", "Proposal"),
  Plan("plan", "http://hl7.org/fhir/request-intent", "Plan"),
  Order("order", "http://hl7.org/fhir/request-intent", "Order"),
  Option("option", "http://hl7.org/fhir/request-intent", "Option"),
  Directive("directive", "http://hl7.org/fhir/request-intent", "Directive");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): CarePlanIntent =
      when (code) {
        "proposal" -> Proposal
        "plan" -> Plan
        "order" -> Order
        "option" -> Option
        "directive" -> Directive
        else -> throw IllegalArgumentException("Unknown code $code for enum CarePlanIntent")
      }
  }
}
