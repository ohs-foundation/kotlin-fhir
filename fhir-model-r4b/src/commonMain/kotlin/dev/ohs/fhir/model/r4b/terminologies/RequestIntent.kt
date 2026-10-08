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

/** Codes indicating the degree of authority/intentionality associated with a request. */
public enum class RequestIntent(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Proposal("proposal", "http://hl7.org/fhir/request-intent", "Proposal"),
  Plan("plan", "http://hl7.org/fhir/request-intent", "Plan"),
  Directive("directive", "http://hl7.org/fhir/request-intent", "Directive"),
  Order("order", "http://hl7.org/fhir/request-intent", "Order"),
  Original_Order("original-order", "http://hl7.org/fhir/request-intent", "Original Order"),
  Reflex_Order("reflex-order", "http://hl7.org/fhir/request-intent", "Reflex Order"),
  Filler_Order("filler-order", "http://hl7.org/fhir/request-intent", "Filler Order"),
  Instance_Order("instance-order", "http://hl7.org/fhir/request-intent", "Instance Order"),
  Option("option", "http://hl7.org/fhir/request-intent", "Option");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): RequestIntent =
      when (code) {
        "proposal" -> Proposal
        "plan" -> Plan
        "directive" -> Directive
        "order" -> Order
        "original-order" -> Original_Order
        "reflex-order" -> Reflex_Order
        "filler-order" -> Filler_Order
        "instance-order" -> Instance_Order
        "option" -> Option
        else -> throw IllegalArgumentException("Unknown code $code for enum RequestIntent")
      }
  }
}
