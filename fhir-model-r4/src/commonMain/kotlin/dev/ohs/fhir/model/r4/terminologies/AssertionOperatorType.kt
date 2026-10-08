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

/** The type of operator to use for assertion. */
public enum class AssertionOperatorType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Equals("equals", "http://hl7.org/fhir/assert-operator-codes", "equals"),
  NotEquals("notEquals", "http://hl7.org/fhir/assert-operator-codes", "notEquals"),
  In("in", "http://hl7.org/fhir/assert-operator-codes", "in"),
  NotIn("notIn", "http://hl7.org/fhir/assert-operator-codes", "notIn"),
  GreaterThan("greaterThan", "http://hl7.org/fhir/assert-operator-codes", "greaterThan"),
  LessThan("lessThan", "http://hl7.org/fhir/assert-operator-codes", "lessThan"),
  Empty("empty", "http://hl7.org/fhir/assert-operator-codes", "empty"),
  NotEmpty("notEmpty", "http://hl7.org/fhir/assert-operator-codes", "notEmpty"),
  Contains("contains", "http://hl7.org/fhir/assert-operator-codes", "contains"),
  NotContains("notContains", "http://hl7.org/fhir/assert-operator-codes", "notContains"),
  Eval("eval", "http://hl7.org/fhir/assert-operator-codes", "evaluate");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AssertionOperatorType =
      when (code) {
        "equals" -> Equals
        "notEquals" -> NotEquals
        "in" -> In
        "notIn" -> NotIn
        "greaterThan" -> GreaterThan
        "lessThan" -> LessThan
        "empty" -> Empty
        "notEmpty" -> NotEmpty
        "contains" -> Contains
        "notContains" -> NotContains
        "eval" -> Eval
        else -> throw IllegalArgumentException("Unknown code $code for enum AssertionOperatorType")
      }
  }
}
