/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5.terminologies

/** Data types allowed to be used for search parameters. */
public enum class SearchParamType(
  private val code: kotlin.String,
  private val system: kotlin.String,
  private val display: kotlin.String?,
) {
  Number("number", "http://hl7.org/fhir/search-param-type", "Number"),
  Date("date", "http://hl7.org/fhir/search-param-type", "Date/DateTime"),
  String("string", "http://hl7.org/fhir/search-param-type", "String"),
  Token("token", "http://hl7.org/fhir/search-param-type", "Token"),
  Reference("reference", "http://hl7.org/fhir/search-param-type", "Reference"),
  Composite("composite", "http://hl7.org/fhir/search-param-type", "Composite"),
  Quantity("quantity", "http://hl7.org/fhir/search-param-type", "Quantity"),
  Uri("uri", "http://hl7.org/fhir/search-param-type", "URI"),
  Special("special", "http://hl7.org/fhir/search-param-type", "Special");

  override fun toString(): kotlin.String = code

  public fun getCode(): kotlin.String = code

  public fun getSystem(): kotlin.String = system

  public fun getDisplay(): kotlin.String? = display

  public companion object {
    public fun fromCode(code: kotlin.String): SearchParamType =
      when (code) {
        "number" -> Number
        "date" -> Date
        "string" -> String
        "token" -> Token
        "reference" -> Reference
        "composite" -> Composite
        "quantity" -> Quantity
        "uri" -> Uri
        "special" -> Special
        else -> throw IllegalArgumentException("Unknown code $code for enum SearchParamType")
      }
  }
}
