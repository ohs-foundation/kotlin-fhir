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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.SpecimenDefinition
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [SpecimenDefinition] resource type. */
public object SpecimenDefinitionSearchParam {
  /** All search parameters for the SpecimenDefinition resource type. */
  public val ALL: List<SearchParam<SpecimenDefinition, *>> = listOf(Container, Identifier, Type)

  public data object Container : SearchParam<SpecimenDefinition, CodeableConcept> {
    public override val paramName: String = "container"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.typeTested.container.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<CodeableConcept> =
      resource.typeTested.mapNotNull { it.container }.mapNotNull { it.type }
  }

  public data object Identifier :
    SearchParam<SpecimenDefinition, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: SpecimenDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = listOfNotNull(resource.identifier)
  }

  public data object Type : SearchParam<SpecimenDefinition, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.typeCollected"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<CodeableConcept> =
      listOfNotNull(resource.typeCollected)
  }
}
