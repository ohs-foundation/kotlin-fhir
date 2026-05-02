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
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceDefinition] resource type. */
public sealed class DeviceDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DeviceDefinition): List<T>

  public data object DeviceName : DeviceDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "device-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "DeviceDefinition.deviceName.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<String> =
      resource.deviceName.map { it.name }
  }

  public data object Identifier : DeviceDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DeviceDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: DeviceDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Manufacturer : DeviceDefinitionSearchParam<Reference>() {
    public override val paramName: kotlin.String = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DeviceDefinition.manufacturer"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: DeviceDefinition): List<Reference> =
      listOfNotNull(resource.manufacturer)
  }

  public data object Organization : DeviceDefinitionSearchParam<Reference>() {
    public override val paramName: kotlin.String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DeviceDefinition.owner"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: DeviceDefinition): List<Reference> =
      listOfNotNull(resource.owner)
  }

  public data object Specification : DeviceDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "specification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DeviceDefinition.conformsTo.specification"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<CodeableConcept> =
      resource.conformsTo.map { it.specification }
  }

  public data object SpecificationVersion :
    DeviceDefinitionSearchParam<DeviceDefinition.ConformsTo>() {
    public override val paramName: kotlin.String = "specification-version"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "DeviceDefinition.conformsTo"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<DeviceDefinition.ConformsTo> =
      resource.conformsTo
  }

  public data object Type : DeviceDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DeviceDefinition.conformsTo.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DeviceDefinition): List<CodeableConcept> =
      resource.conformsTo.mapNotNull { it.category }
  }

  public companion object {
    /** All search parameters for the DeviceDefinition resource type. */
    public val ALL: List<DeviceDefinitionSearchParam<*>> =
      listOf(
        DeviceName,
        Identifier,
        Manufacturer,
        Organization,
        Specification,
        SpecificationVersion,
        Type,
      )
  }
}
