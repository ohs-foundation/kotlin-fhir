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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.SpecimenDefinition
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [SpecimenDefinition] resource type. */
public object SpecimenDefinitionSearchParam {
  /** All search parameters for the SpecimenDefinition resource type. */
  public val ALL: List<SearchParam<SpecimenDefinition, *>> =
    listOf(Container, Experimental, Identifier, IsDerived, Status, Title, Type, TypeTested, Url)

  public data object Container : SearchParam<SpecimenDefinition, CodeableConcept> {
    public override val name: KotlinString = "container"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SpecimenDefinition.typeTested.container.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<CodeableConcept> =
      resource.typeTested.mapNotNull { it.container }.mapNotNull { it.type }
  }

  public data object Experimental : SearchParam<SpecimenDefinition, Boolean> {
    public override val name: KotlinString = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SpecimenDefinition.experimental"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Boolean> =
      listOfNotNull(resource.experimental)
  }

  public data object Identifier :
    SearchParam<SpecimenDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SpecimenDefinition.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: SpecimenDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = listOfNotNull(resource.identifier)
  }

  public data object IsDerived : SearchParam<SpecimenDefinition, Boolean> {
    public override val name: KotlinString = "is-derived"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SpecimenDefinition.typeTested.isDerived"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Boolean> =
      resource.typeTested.mapNotNull { it.isDerived }
  }

  public data object Status : SearchParam<SpecimenDefinition, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SpecimenDefinition.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<SpecimenDefinition, R5String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SpecimenDefinition.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Type : SearchParam<SpecimenDefinition, CodeableConcept> {
    public override val name: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SpecimenDefinition.typeCollected"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<CodeableConcept> =
      listOfNotNull(resource.typeCollected)
  }

  public data object TypeTested : SearchParam<SpecimenDefinition, CodeableConcept> {
    public override val name: KotlinString = "type-tested"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SpecimenDefinition.typeTested.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<CodeableConcept> =
      resource.typeTested.mapNotNull { it.type }
  }

  public data object Url : SearchParam<SpecimenDefinition, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "SpecimenDefinition.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }
}
