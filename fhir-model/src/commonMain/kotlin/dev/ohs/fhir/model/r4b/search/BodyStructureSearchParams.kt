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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.BodyStructure
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [BodyStructure] resource type. */
public object BodyStructureSearchParams {
  public val identifier: SearchParam<BodyStructure, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<BodyStructure, CodeableConcept> =
    SearchParam(
      name = "location",
      type = SearchParamType.fromCode("token"),
      expression = "BodyStructure.location",
      extractor = { resource -> listOfNotNull(resource.location) },
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

  /** All search parameters for the BodyStructure resource type. */
  public val all: List<SearchParam<BodyStructure, *>> =
    listOf(identifier, location, morphology, patient)
}
