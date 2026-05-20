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
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AdministrableProductDefinition] resource type. */
public object AdministrableProductDefinitionSearchParam {
  /** All search parameters for the AdministrableProductDefinition resource type. */
  public val ALL: List<SearchParam<AdministrableProductDefinition, *>> =
    listOf(Device, DoseForm, FormOf, Identifier, Ingredient, ManufacturedItem, Route, TargetSpecies)

  public data object Device : SearchParam<AdministrableProductDefinition, Reference> {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdministrableProductDefinition.device"

    public override val target: List<String> = listOf("DeviceDefinition")

    public override fun extract(resource: AdministrableProductDefinition): List<Reference> =
      listOfNotNull(resource.device)
  }

  public data object DoseForm : SearchParam<AdministrableProductDefinition, CodeableConcept> {
    public override val paramName: String = "dose-form"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdministrableProductDefinition.administrableDoseForm"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdministrableProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.administrableDoseForm)
  }

  public data object FormOf : SearchParam<AdministrableProductDefinition, Reference> {
    public override val paramName: String = "form-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdministrableProductDefinition.formOf"

    public override val target: List<String> = listOf("MedicinalProductDefinition")

    public override fun extract(resource: AdministrableProductDefinition): List<Reference> =
      resource.formOf
  }

  public data object Identifier :
    SearchParam<AdministrableProductDefinition, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdministrableProductDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: AdministrableProductDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Ingredient : SearchParam<AdministrableProductDefinition, CodeableConcept> {
    public override val paramName: String = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdministrableProductDefinition.ingredient"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdministrableProductDefinition): List<CodeableConcept> =
      resource.ingredient
  }

  public data object ManufacturedItem : SearchParam<AdministrableProductDefinition, Reference> {
    public override val paramName: String = "manufactured-item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdministrableProductDefinition.producedFrom"

    public override val target: List<String> = listOf("ManufacturedItemDefinition")

    public override fun extract(resource: AdministrableProductDefinition): List<Reference> =
      resource.producedFrom
  }

  public data object Route : SearchParam<AdministrableProductDefinition, CodeableConcept> {
    public override val paramName: String = "route"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "AdministrableProductDefinition.routeOfAdministration.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdministrableProductDefinition): List<CodeableConcept> =
      resource.routeOfAdministration.map { it.code }
  }

  public data object TargetSpecies : SearchParam<AdministrableProductDefinition, CodeableConcept> {
    public override val paramName: String = "target-species"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "AdministrableProductDefinition.routeOfAdministration.targetSpecies.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdministrableProductDefinition): List<CodeableConcept> =
      resource.routeOfAdministration.flatMap { it.targetSpecies }.map { it.code }
  }
}
