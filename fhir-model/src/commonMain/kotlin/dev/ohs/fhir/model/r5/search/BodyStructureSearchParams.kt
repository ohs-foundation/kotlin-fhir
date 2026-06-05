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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.BodyStructure
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [BodyStructure] resource type. */
public object BodyStructureSearchParams {
  public val excluded_structure: SearchParam<BodyStructure, Any> =
    SearchParam(
      name = "excluded_structure",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.excludedStructure.structure",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'excluded_structure' has expression 'BodyStructure.excludedStructure.structure' which is not yet supported."
        )
      },
    )

  public val identifier: SearchParam<BodyStructure, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val included_structure: SearchParam<BodyStructure, CodeableConcept> =
    SearchParam(
      name = "included_structure",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.includedStructure.structure",
      extractor = { resource -> resource.includedStructure.map { it.structure } },
    )

  public val morphology: SearchParam<BodyStructure, CodeableConcept> =
    SearchParam(
      name = "morphology",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.morphology",
      extractor = { resource -> listOfNotNull(resource.morphology) },
    )

  public val patient: SearchParam<BodyStructure, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "BodyStructure.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<BodyStructure, *>> = listOf(excluded_structure)

  /**
   * Supported search parameters for the BodyStructure resource type. Entries in [unsupported] are
   * excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<BodyStructure, *>> =
    listOf(excluded_structure, identifier, included_structure, morphology, patient) -
      unsupported.toSet()
}
