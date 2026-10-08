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

/** Biologically Derived Product Category. */
public enum class BiologicallyDerivedProductCategory(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Organ("organ", "http://hl7.org/fhir/product-category", "Organ"),
  Tissue("tissue", "http://hl7.org/fhir/product-category", "Tissue"),
  Fluid("fluid", "http://hl7.org/fhir/product-category", "Fluid"),
  Cells("cells", "http://hl7.org/fhir/product-category", "Cells"),
  BiologicalAgent("biologicalAgent", "http://hl7.org/fhir/product-category", "BiologicalAgent");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): BiologicallyDerivedProductCategory =
      when (code) {
        "organ" -> Organ
        "tissue" -> Tissue
        "fluid" -> Fluid
        "cells" -> Cells
        "biologicalAgent" -> BiologicalAgent
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum BiologicallyDerivedProductCategory"
          )
      }
  }
}
