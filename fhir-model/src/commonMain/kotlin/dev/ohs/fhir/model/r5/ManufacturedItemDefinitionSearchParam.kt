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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ManufacturedItemDefinition] resource type. */
public sealed class ManufacturedItemDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ManufacturedItemDefinition): List<T>

  public data object DoseForm : ManufacturedItemDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "dose-form"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "ManufacturedItemDefinition.manufacturedDoseForm"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ManufacturedItemDefinition): List<CodeableConcept> =
      listOf(resource.manufacturedDoseForm)
  }

  public data object Identifier :
    ManufacturedItemDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ManufacturedItemDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: ManufacturedItemDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Ingredient : ManufacturedItemDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ManufacturedItemDefinition.ingredient"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ManufacturedItemDefinition): List<CodeableConcept> =
      resource.ingredient
  }

  public data object Name : ManufacturedItemDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ManufacturedItemDefinition.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ManufacturedItemDefinition): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Status : ManufacturedItemDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ManufacturedItemDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ManufacturedItemDefinition): List<Any> =
      listOf(resource.status)
  }

  public companion object {
    /** All search parameters for the ManufacturedItemDefinition resource type. */
    public val ALL: List<ManufacturedItemDefinitionSearchParam<*>> =
      listOf(DoseForm, Identifier, Ingredient, Name, Status)
  }
}
