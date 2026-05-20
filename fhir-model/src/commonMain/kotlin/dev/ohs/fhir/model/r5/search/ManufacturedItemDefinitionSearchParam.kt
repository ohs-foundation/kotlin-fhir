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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ManufacturedItemDefinition] resource type. */
public object ManufacturedItemDefinitionSearchParam {
  /** All search parameters for the ManufacturedItemDefinition resource type. */
  public val ALL: List<SearchParam<ManufacturedItemDefinition, *>> =
    listOf(DoseForm, Identifier, Ingredient, Name, Status)

  public data object DoseForm : SearchParam<ManufacturedItemDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "dose-form"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ManufacturedItemDefinition.manufacturedDoseForm"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ManufacturedItemDefinition): List<CodeableConcept> =
      listOf(resource.manufacturedDoseForm)
  }

  public data object Identifier :
    SearchParam<ManufacturedItemDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ManufacturedItemDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: ManufacturedItemDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Ingredient : SearchParam<ManufacturedItemDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ManufacturedItemDefinition.ingredient"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ManufacturedItemDefinition): List<CodeableConcept> =
      resource.ingredient
  }

  public data object Name : SearchParam<ManufacturedItemDefinition, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ManufacturedItemDefinition.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ManufacturedItemDefinition): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Status : SearchParam<ManufacturedItemDefinition, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ManufacturedItemDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ManufacturedItemDefinition): List<Any> =
      listOf(resource.status)
  }
}
