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

/** The criteria by which a question is enabled. */
public enum class QuestionnaireItemOperator(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Exists("exists", "http://hl7.org/fhir/questionnaire-enable-operator", "Exists"),
  EqualTo("=", "http://hl7.org/fhir/questionnaire-enable-operator", "Equals"),
  NotEqualTo("!=", "http://hl7.org/fhir/questionnaire-enable-operator", "Not Equals"),
  GreaterThan(">", "http://hl7.org/fhir/questionnaire-enable-operator", "Greater Than"),
  LessThan("<", "http://hl7.org/fhir/questionnaire-enable-operator", "Less Than"),
  GreaterThanOrEqualTo(
    ">=",
    "http://hl7.org/fhir/questionnaire-enable-operator",
    "Greater or Equals",
  ),
  LessThanOrEqualTo("<=", "http://hl7.org/fhir/questionnaire-enable-operator", "Less or Equals");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): QuestionnaireItemOperator =
      when (code) {
        "exists" -> Exists
        "=" -> EqualTo
        "!=" -> NotEqualTo
        ">" -> GreaterThan
        "<" -> LessThan
        ">=" -> GreaterThanOrEqualTo
        "<=" -> LessThanOrEqualTo
        else ->
          throw IllegalArgumentException("Unknown code $code for enum QuestionnaireItemOperator")
      }
  }
}
