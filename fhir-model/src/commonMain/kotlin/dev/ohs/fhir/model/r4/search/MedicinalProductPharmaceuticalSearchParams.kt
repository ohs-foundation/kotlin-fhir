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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProductPharmaceutical
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductPharmaceutical] resource type. */
public object MedicinalProductPharmaceuticalSearchParams {
  public val Identifier: SearchParam<MedicinalProductPharmaceutical, Identifier> =
    SimpleSearchParam<MedicinalProductPharmaceutical, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductPharmaceutical.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Route: SearchParam<MedicinalProductPharmaceutical, CodeableConcept> =
    SimpleSearchParam<MedicinalProductPharmaceutical, CodeableConcept>(
      name = "route",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductPharmaceutical.routeOfAdministration.code",
      extractor = { resource -> resource.routeOfAdministration.map { it.code } },
    )

  public val TargetSpecies: SearchParam<MedicinalProductPharmaceutical, CodeableConcept> =
    SimpleSearchParam<MedicinalProductPharmaceutical, CodeableConcept>(
      name = "target-species",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductPharmaceutical.routeOfAdministration.targetSpecies.code",
      extractor = { resource ->
        resource.routeOfAdministration.flatMap { it.targetSpecies }.map { it.code }
      },
    )

  /** All search parameters for the MedicinalProductPharmaceutical resource type. */
  public val ALL: List<SearchParam<MedicinalProductPharmaceutical, *>> =
    listOf(Identifier, Route, TargetSpecies)
}
