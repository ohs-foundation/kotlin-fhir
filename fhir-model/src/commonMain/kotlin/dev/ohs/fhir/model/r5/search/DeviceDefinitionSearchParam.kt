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
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [DeviceDefinition] resource type. */
public object DeviceDefinitionSearchParam {
  /** All search parameters for the DeviceDefinition resource type. */
  public val ALL: List<SearchParam<DeviceDefinition, *>> =
    listOf(
      DeviceName,
      Identifier,
      Manufacturer,
      Organization,
      Specification,
      SpecificationVersion,
      Type,
    )

  public data object DeviceName : SearchParam<DeviceDefinition, R5String> {
    public override val paramName: KotlinString = "device-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "DeviceDefinition.deviceName.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<R5String> =
      resource.deviceName.map { it.name }
  }

  public data object Identifier : SearchParam<DeviceDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DeviceDefinition.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DeviceDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Manufacturer : SearchParam<DeviceDefinition, Reference> {
    public override val paramName: KotlinString = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DeviceDefinition.manufacturer"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Organization::class)

    public override fun extract(resource: DeviceDefinition): List<Reference> =
      listOfNotNull(resource.manufacturer)
  }

  public data object Organization : SearchParam<DeviceDefinition, Reference> {
    public override val paramName: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DeviceDefinition.owner"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Organization::class)

    public override fun extract(resource: DeviceDefinition): List<Reference> =
      listOfNotNull(resource.owner)
  }

  public data object Specification : SearchParam<DeviceDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "specification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DeviceDefinition.conformsTo.specification"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<CodeableConcept> =
      resource.conformsTo.map { it.specification }
  }

  public data object SpecificationVersion :
    SearchParam<DeviceDefinition, DeviceDefinition.ConformsTo> {
    public override val paramName: KotlinString = "specification-version"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "DeviceDefinition.conformsTo"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<DeviceDefinition.ConformsTo> =
      resource.conformsTo
  }

  public data object Type : SearchParam<DeviceDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DeviceDefinition.conformsTo.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<CodeableConcept> =
      resource.conformsTo.mapNotNull { it.category }
  }
}
