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

/** Code of parameter that is input to the guide. */
public enum class GuideParameterCode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Apply("apply", "http://hl7.org/fhir/guide-parameter-code", "Apply Metadata Value"),
  Path_Resource("path-resource", "http://hl7.org/fhir/guide-parameter-code", "Resource Path"),
  Path_Pages("path-pages", "http://hl7.org/fhir/guide-parameter-code", "Pages Path"),
  Path_Tx_Cache(
    "path-tx-cache",
    "http://hl7.org/fhir/guide-parameter-code",
    "Terminology Cache Path",
  ),
  Expansion_Parameter(
    "expansion-parameter",
    "http://hl7.org/fhir/guide-parameter-code",
    "Expansion Profile",
  ),
  Rule_Broken_Links(
    "rule-broken-links",
    "http://hl7.org/fhir/guide-parameter-code",
    "Broken Links Rule",
  ),
  Generate_Xml("generate-xml", "http://hl7.org/fhir/guide-parameter-code", "Generate XML"),
  Generate_Json("generate-json", "http://hl7.org/fhir/guide-parameter-code", "Generate JSON"),
  Generate_Turtle("generate-turtle", "http://hl7.org/fhir/guide-parameter-code", "Generate Turtle"),
  Html_Template("html-template", "http://hl7.org/fhir/guide-parameter-code", "HTML Template");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): GuideParameterCode =
      when (code) {
        "apply" -> Apply
        "path-resource" -> Path_Resource
        "path-pages" -> Path_Pages
        "path-tx-cache" -> Path_Tx_Cache
        "expansion-parameter" -> Expansion_Parameter
        "rule-broken-links" -> Rule_Broken_Links
        "generate-xml" -> Generate_Xml
        "generate-json" -> Generate_Json
        "generate-turtle" -> Generate_Turtle
        "html-template" -> Html_Template
        else -> throw IllegalArgumentException("Unknown code $code for enum GuideParameterCode")
      }
  }
}
