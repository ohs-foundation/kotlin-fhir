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

/**
 * HTTP verbs (in the HTTP command line). See [HTTP rfc](https://tools.ietf.org/html/rfc7231) for
 * details.
 */
public enum class HTTPVerb(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Get("GET", "http://hl7.org/fhir/http-verb", "GET"),
  Head("HEAD", "http://hl7.org/fhir/http-verb", "HEAD"),
  Post("POST", "http://hl7.org/fhir/http-verb", "POST"),
  Put("PUT", "http://hl7.org/fhir/http-verb", "PUT"),
  Delete("DELETE", "http://hl7.org/fhir/http-verb", "DELETE"),
  Patch("PATCH", "http://hl7.org/fhir/http-verb", "PATCH");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): HTTPVerb =
      when (code) {
        "GET" -> Get
        "HEAD" -> Head
        "POST" -> Post
        "PUT" -> Put
        "DELETE" -> Delete
        "PATCH" -> Patch
        else -> throw IllegalArgumentException("Unknown code $code for enum HTTPVerb")
      }
  }
}
