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

/** Defines how a compartment rule is used. */
public enum class GraphCompartmentUse(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Where("where", "http://hl7.org/fhir/graph-compartment-use", "Where"),
  Requires("requires", "http://hl7.org/fhir/graph-compartment-use", "requires");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): GraphCompartmentUse =
      when (code) {
        "where" -> Where
        "requires" -> Requires
        else -> throw IllegalArgumentException("Unknown code $code for enum GraphCompartmentUse")
      }
  }
}
