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
  public val identifier: SearchParam<MedicinalProductPharmaceutical, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "MedicinalProductPharmaceutical.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val route: SearchParam<MedicinalProductPharmaceutical, CodeableConcept> =
    SearchParam(
      name = "route",
      type = SearchParamType.Token,
      expression = "MedicinalProductPharmaceutical.routeOfAdministration.code",
      extractor = { resource -> resource.routeOfAdministration.map { it.code } },
    )

  public val targetSpecies: SearchParam<MedicinalProductPharmaceutical, CodeableConcept> =
    SearchParam(
      name = "target-species",
      type = SearchParamType.Token,
      expression = "MedicinalProductPharmaceutical.routeOfAdministration.targetSpecies.code",
      extractor = { resource ->
        resource.routeOfAdministration.flatMap { it.targetSpecies }.map { it.code }
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<MedicinalProductPharmaceutical, *>> = listOf()

  /**
   * Supported search parameters for the MedicinalProductPharmaceutical resource type. Iterating
   * `all` and calling `extractFrom` on each entry is safe; see [unsupported] for the parameters
   * excluded from this list.
   */
  public val all: List<SearchParam<MedicinalProductPharmaceutical, *>> =
    listOf(identifier, route, targetSpecies)
}
