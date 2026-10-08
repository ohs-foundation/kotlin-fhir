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

/** The type of network access point of this agent in the audit event. */
public enum class AuditEventAgentNetworkType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  _1("1", "http://hl7.org/fhir/network-type", "Machine Name"),
  _2("2", "http://hl7.org/fhir/network-type", "IP Address"),
  _3("3", "http://hl7.org/fhir/network-type", "Telephone Number"),
  _4("4", "http://hl7.org/fhir/network-type", "Email address"),
  _5("5", "http://hl7.org/fhir/network-type", "URI");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AuditEventAgentNetworkType =
      when (code) {
        "1" -> _1
        "2" -> _2
        "3" -> _3
        "4" -> _4
        "5" -> _5
        else ->
          throw IllegalArgumentException("Unknown code $code for enum AuditEventAgentNetworkType")
      }
  }
}
