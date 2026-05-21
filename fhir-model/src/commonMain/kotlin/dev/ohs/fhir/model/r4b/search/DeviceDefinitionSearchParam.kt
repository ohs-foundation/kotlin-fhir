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
import dev.ohs.fhir.model.r4b.DeviceDefinition
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [DeviceDefinition] resource type. */
public object DeviceDefinitionSearchParam {
  /** All search parameters for the DeviceDefinition resource type. */
  public val ALL: List<SearchParam<DeviceDefinition, *>> = listOf(Identifier, Parent, Type)

  public data object Identifier : SearchParam<DeviceDefinition, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceDefinition.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DeviceDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Parent : SearchParam<DeviceDefinition, Reference> {
    public override val paramName: String = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceDefinition.parentDevice"

    public override val target: List<KClass<out Resource>> = listOf(DeviceDefinition::class)

    public override fun extract(resource: DeviceDefinition): List<Reference> =
      listOfNotNull(resource.parentDevice)
  }

  public data object Type : SearchParam<DeviceDefinition, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceDefinition.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }
}
