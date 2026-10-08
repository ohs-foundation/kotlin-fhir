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

/** Operations supported by REST at the type or instance level. */
public enum class TypeRestfulInteraction(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Read("read", "http://hl7.org/fhir/restful-interaction", "read"),
  Vread("vread", "http://hl7.org/fhir/restful-interaction", "vread"),
  Update("update", "http://hl7.org/fhir/restful-interaction", "update"),
  Patch("patch", "http://hl7.org/fhir/restful-interaction", "patch"),
  Delete("delete", "http://hl7.org/fhir/restful-interaction", "delete"),
  History_Instance(
    "history-instance",
    "http://hl7.org/fhir/restful-interaction",
    "history-instance",
  ),
  History_Type("history-type", "http://hl7.org/fhir/restful-interaction", "history-type"),
  Create("create", "http://hl7.org/fhir/restful-interaction", "create"),
  Search_Type("search-type", "http://hl7.org/fhir/restful-interaction", "search-type");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): TypeRestfulInteraction =
      when (code) {
        "read" -> Read
        "vread" -> Vread
        "update" -> Update
        "patch" -> Patch
        "delete" -> Delete
        "history-instance" -> History_Instance
        "history-type" -> History_Type
        "create" -> Create
        "search-type" -> Search_Type
        else -> throw IllegalArgumentException("Unknown code $code for enum TypeRestfulInteraction")
      }
  }
}
