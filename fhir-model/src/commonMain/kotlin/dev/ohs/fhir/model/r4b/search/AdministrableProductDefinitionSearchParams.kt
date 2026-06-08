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

import dev.ohs.fhir.model.r4b.AdministrableProductDefinition
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DeviceDefinition
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ManufacturedItemDefinition
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AdministrableProductDefinition] resource type. */
public object AdministrableProductDefinitionSearchParams {
  public val device: SearchParam<AdministrableProductDefinition, Reference> =
    SearchParam(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "AdministrableProductDefinition.device",
      target = listOf(DeviceDefinition::class),
      extractor = { resource -> listOfNotNull(resource.device) },
    )

  public val doseForm: SearchParam<AdministrableProductDefinition, CodeableConcept> =
    SearchParam(
      name = "dose-form",
      type = SearchParamType.fromCode("token"),
      expression = "AdministrableProductDefinition.administrableDoseForm",
      extractor = { resource -> listOfNotNull(resource.administrableDoseForm) },
    )

  public val formOf: SearchParam<AdministrableProductDefinition, Reference> =
    SearchParam(
      name = "form-of",
      type = SearchParamType.fromCode("reference"),
      expression = "AdministrableProductDefinition.formOf",
      target = listOf(MedicinalProductDefinition::class),
      extractor = { resource -> resource.formOf },
    )

  public val identifier: SearchParam<AdministrableProductDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "AdministrableProductDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ingredient: SearchParam<AdministrableProductDefinition, CodeableConcept> =
    SearchParam(
      name = "ingredient",
      type = SearchParamType.fromCode("token"),
      expression = "AdministrableProductDefinition.ingredient",
      extractor = { resource -> resource.ingredient },
    )

  public val manufacturedItem: SearchParam<AdministrableProductDefinition, Reference> =
    SearchParam(
      name = "manufactured-item",
      type = SearchParamType.fromCode("reference"),
      expression = "AdministrableProductDefinition.producedFrom",
      target = listOf(ManufacturedItemDefinition::class),
      extractor = { resource -> resource.producedFrom },
    )

  public val route: SearchParam<AdministrableProductDefinition, CodeableConcept> =
    SearchParam(
      name = "route",
      type = SearchParamType.fromCode("token"),
      expression = "AdministrableProductDefinition.routeOfAdministration.code",
      extractor = { resource -> resource.routeOfAdministration.map { it.code } },
    )

  public val targetSpecies: SearchParam<AdministrableProductDefinition, CodeableConcept> =
    SearchParam(
      name = "target-species",
      type = SearchParamType.fromCode("token"),
      expression = "AdministrableProductDefinition.routeOfAdministration.targetSpecies.code",
      extractor = { resource ->
        resource.routeOfAdministration.flatMap { it.targetSpecies }.map { it.code }
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<AdministrableProductDefinition, *>> = listOf()

  /**
   * Supported search parameters for the AdministrableProductDefinition resource type. Iterating
   * `all` and calling `extractFrom` on each entry is safe; see [unsupported] for the parameters
   * excluded from this list.
   */
  public val all: List<SearchParam<AdministrableProductDefinition, *>> =
    listOf(device, doseForm, formOf, identifier, ingredient, manufacturedItem, route, targetSpecies)
}
