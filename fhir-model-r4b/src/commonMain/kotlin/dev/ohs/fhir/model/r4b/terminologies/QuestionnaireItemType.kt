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

/** Distinguishes groups from questions and display text and indicates data type for questions. */
public enum class QuestionnaireItemType(
  override val code: kotlin.String,
  override val system: kotlin.String,
  override val display: kotlin.String?,
) : FhirEnum {
  Group("group", "http://hl7.org/fhir/item-type", "Group"),
  Display("display", "http://hl7.org/fhir/item-type", "Display"),
  Question("question", "http://hl7.org/fhir/item-type", "Question"),
  Boolean("boolean", "http://hl7.org/fhir/item-type", "Boolean"),
  Decimal("decimal", "http://hl7.org/fhir/item-type", "Decimal"),
  Integer("integer", "http://hl7.org/fhir/item-type", "Integer"),
  Date("date", "http://hl7.org/fhir/item-type", "Date"),
  DateTime("dateTime", "http://hl7.org/fhir/item-type", "Date Time"),
  Time("time", "http://hl7.org/fhir/item-type", "Time"),
  String("string", "http://hl7.org/fhir/item-type", "String"),
  Text("text", "http://hl7.org/fhir/item-type", "Text"),
  Url("url", "http://hl7.org/fhir/item-type", "Url"),
  Choice("choice", "http://hl7.org/fhir/item-type", "Choice"),
  Open_Choice("open-choice", "http://hl7.org/fhir/item-type", "Open Choice"),
  Attachment("attachment", "http://hl7.org/fhir/item-type", "Attachment"),
  Reference("reference", "http://hl7.org/fhir/item-type", "Reference"),
  Quantity("quantity", "http://hl7.org/fhir/item-type", "Quantity");

  override fun toString(): kotlin.String = code

  public companion object {
    public fun fromCode(code: kotlin.String): QuestionnaireItemType =
      when (code) {
        "group" -> Group
        "display" -> Display
        "question" -> Question
        "boolean" -> Boolean
        "decimal" -> Decimal
        "integer" -> Integer
        "date" -> Date
        "dateTime" -> DateTime
        "time" -> Time
        "string" -> String
        "text" -> Text
        "url" -> Url
        "choice" -> Choice
        "open-choice" -> Open_Choice
        "attachment" -> Attachment
        "reference" -> Reference
        "quantity" -> Quantity
        else -> throw IllegalArgumentException("Unknown code $code for enum QuestionnaireItemType")
      }
  }
}
