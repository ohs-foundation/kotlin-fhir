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

/** Type for access of external URI. */
public enum class RepositoryType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Directlink("directlink", "http://hl7.org/fhir/repository-type", "Click and see"),
  Openapi(
    "openapi",
    "http://hl7.org/fhir/repository-type",
    "The URL is the RESTful or other kind of API that can access to the result.",
  ),
  Login(
    "login",
    "http://hl7.org/fhir/repository-type",
    "Result cannot be access unless an account is logged in",
  ),
  Oauth(
    "oauth",
    "http://hl7.org/fhir/repository-type",
    "Result need to be fetched with API and need LOGIN( or cookies are required when visiting the link of resource)",
  ),
  Other(
    "other",
    "http://hl7.org/fhir/repository-type",
    "Some other complicated or particular way to get resource from URL.",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): RepositoryType =
      when (code) {
        "directlink" -> Directlink
        "openapi" -> Openapi
        "login" -> Login
        "oauth" -> Oauth
        "other" -> Other
        else -> throw IllegalArgumentException("Unknown code $code for enum RepositoryType")
      }
  }
}
