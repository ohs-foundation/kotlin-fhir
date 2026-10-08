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

/** The media type of the expression language. */
public enum class ExpressionLanguage(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Text_Cql("text/cql", "urn:ietf:bcp:13", "CQL"),
  Text_Fhirpath("text/fhirpath", "urn:ietf:bcp:13", "FHIRPath"),
  Text_X_Fhir_Query("text/x-fhir-query", "urn:ietf:bcp:13", "FHIR Query"),
  Text_Cql_Identifier("text/cql-identifier", "urn:ietf:bcp:13", "CQL Identifier"),
  Text_Cql_Expression("text/cql-expression", "urn:ietf:bcp:13", "CQL Expression");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ExpressionLanguage =
      when (code) {
        "text/cql" -> Text_Cql
        "text/fhirpath" -> Text_Fhirpath
        "text/x-fhir-query" -> Text_X_Fhir_Query
        "text/cql-identifier" -> Text_Cql_Identifier
        "text/cql-expression" -> Text_Cql_Expression
        else -> throw IllegalArgumentException("Unknown code $code for enum ExpressionLanguage")
      }
  }
}
