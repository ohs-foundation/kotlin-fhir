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

/** How data is copied/created. */
public enum class StructureMapTransform(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Create("create", "http://hl7.org/fhir/map-transform", "create"),
  Copy("copy", "http://hl7.org/fhir/map-transform", "copy"),
  Truncate("truncate", "http://hl7.org/fhir/map-transform", "truncate"),
  Escape("escape", "http://hl7.org/fhir/map-transform", "escape"),
  Cast("cast", "http://hl7.org/fhir/map-transform", "cast"),
  Append("append", "http://hl7.org/fhir/map-transform", "append"),
  Translate("translate", "http://hl7.org/fhir/map-transform", "translate"),
  Reference("reference", "http://hl7.org/fhir/map-transform", "reference"),
  DateOp("dateOp", "http://hl7.org/fhir/map-transform", "dateOp"),
  Uuid("uuid", "http://hl7.org/fhir/map-transform", "uuid"),
  Pointer("pointer", "http://hl7.org/fhir/map-transform", "pointer"),
  Evaluate("evaluate", "http://hl7.org/fhir/map-transform", "evaluate"),
  Cc("cc", "http://hl7.org/fhir/map-transform", "cc"),
  C("c", "http://hl7.org/fhir/map-transform", "c"),
  Qty("qty", "http://hl7.org/fhir/map-transform", "qty"),
  Id("id", "http://hl7.org/fhir/map-transform", "id"),
  Cp("cp", "http://hl7.org/fhir/map-transform", "cp");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): StructureMapTransform =
      when (code) {
        "create" -> Create
        "copy" -> Copy
        "truncate" -> Truncate
        "escape" -> Escape
        "cast" -> Cast
        "append" -> Append
        "translate" -> Translate
        "reference" -> Reference
        "dateOp" -> DateOp
        "uuid" -> Uuid
        "pointer" -> Pointer
        "evaluate" -> Evaluate
        "cc" -> Cc
        "c" -> C
        "qty" -> Qty
        "id" -> Id
        "cp" -> Cp
        else -> throw IllegalArgumentException("Unknown code $code for enum StructureMapTransform")
      }
  }
}
