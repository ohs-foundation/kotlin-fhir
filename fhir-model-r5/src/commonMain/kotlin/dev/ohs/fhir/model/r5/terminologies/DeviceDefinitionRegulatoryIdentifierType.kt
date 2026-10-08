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

/** Regulatory Identifier type */
public enum class DeviceDefinitionRegulatoryIdentifierType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Basic("basic", "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type", "Basic"),
  Master("master", "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type", "Master"),
  License("license", "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type", "License");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DeviceDefinitionRegulatoryIdentifierType =
      when (code) {
        "basic" -> Basic
        "master" -> Master
        "license" -> License
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum DeviceDefinitionRegulatoryIdentifierType"
          )
      }
  }
}
