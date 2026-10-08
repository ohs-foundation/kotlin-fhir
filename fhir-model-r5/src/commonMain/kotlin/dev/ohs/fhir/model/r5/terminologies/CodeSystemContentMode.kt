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

/**
 * The extent of the content of the code system (the concepts and codes it defines) are represented
 * in a code system resource.
 */
public enum class CodeSystemContentMode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Not_Present("not-present", "http://hl7.org/fhir/codesystem-content-mode", "Not Present"),
  Example("example", "http://hl7.org/fhir/codesystem-content-mode", "Example"),
  Fragment("fragment", "http://hl7.org/fhir/codesystem-content-mode", "Fragment"),
  Complete("complete", "http://hl7.org/fhir/codesystem-content-mode", "Complete"),
  Supplement("supplement", "http://hl7.org/fhir/codesystem-content-mode", "Supplement");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): CodeSystemContentMode =
      when (code) {
        "not-present" -> Not_Present
        "example" -> Example
        "fragment" -> Fragment
        "complete" -> Complete
        "supplement" -> Supplement
        else -> throw IllegalArgumentException("Unknown code $code for enum CodeSystemContentMode")
      }
  }
}
