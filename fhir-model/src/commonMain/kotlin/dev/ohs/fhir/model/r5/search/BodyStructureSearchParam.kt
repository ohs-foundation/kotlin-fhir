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
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [BodyStructure] resource type. */
public object BodyStructureSearchParam {
  public val Excluded_structure: SearchParam<BodyStructure, Any> =
    SimpleSearchParam<BodyStructure, Any>(
      name = "excluded_structure",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.excludedStructure.structure",
      extractor = { emptyList() },
    )

  public val Identifier: SearchParam<BodyStructure, Identifier> =
    SimpleSearchParam<BodyStructure, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Included_structure: SearchParam<BodyStructure, CodeableConcept> =
    SimpleSearchParam<BodyStructure, CodeableConcept>(
      name = "included_structure",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.includedStructure.structure",
      extractor = { resource -> resource.includedStructure.map { it.structure } },
    )

  public val Morphology: SearchParam<BodyStructure, CodeableConcept> =
    SimpleSearchParam<BodyStructure, CodeableConcept>(
      name = "morphology",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.morphology",
      extractor = { resource -> listOfNotNull(resource.morphology) },
    )

  public val Patient: SearchParam<BodyStructure, Reference> =
    SimpleSearchParam<BodyStructure, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "BodyStructure.patient",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  /** All search parameters for the BodyStructure resource type. */
  public val ALL: List<SearchParam<BodyStructure, *>> =
    listOf(Excluded_structure, Identifier, Included_structure, Morphology, Patient)
}
