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
import dev.ohs.fhir.model.r5.DeviceUsage
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [DeviceUsage] resource type. */
public object DeviceUsageSearchParam {
  /** All search parameters for the DeviceUsage resource type. */
  public val ALL: List<SearchParam<DeviceUsage, *>> = listOf(Device, Identifier, Patient, Status)

  public data object Device : SearchParam<DeviceUsage, CodeableConcept> {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceUsage.device.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceUsage): List<CodeableConcept> =
      listOfNotNull(resource.device.concept)
  }

  public data object Identifier : SearchParam<DeviceUsage, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceUsage.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceUsage): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Patient : SearchParam<DeviceUsage, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceUsage.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: DeviceUsage): List<Reference> = listOf(resource.patient)
  }

  public data object Status : SearchParam<DeviceUsage, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceUsage.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceUsage): List<Any> = listOf(resource.status)
  }
}
