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

/** The mode of a RESTful capability statement. */
public enum class RestfulCapabilityMode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Client("client", "http://hl7.org/fhir/restful-capability-mode", "Client"),
  Server("server", "http://hl7.org/fhir/restful-capability-mode", "Server");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): RestfulCapabilityMode =
      when (code) {
        "client" -> Client
        "server" -> Server
        else -> throw IllegalArgumentException("Unknown code $code for enum RestfulCapabilityMode")
      }
  }
}
