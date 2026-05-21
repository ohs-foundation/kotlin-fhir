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
import dev.ohs.fhir.model.r5.DeviceDispense
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [DeviceDispense] resource type. */
public object DeviceDispenseSearchParam {
  /** All search parameters for the DeviceDispense resource type. */
  public val ALL: List<SearchParam<DeviceDispense, *>> =
    listOf(Code, Identifier, Patient, Status, Subject)

  public data object Code : SearchParam<DeviceDispense, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceDispense.device.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceDispense): List<CodeableConcept> =
      listOfNotNull(resource.device.concept)
  }

  public data object Identifier : SearchParam<DeviceDispense, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceDispense.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceDispense): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Patient : SearchParam<DeviceDispense, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceDispense.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: DeviceDispense): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Status : SearchParam<DeviceDispense, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceDispense.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceDispense): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<DeviceDispense, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceDispense.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: DeviceDispense): List<Reference> =
      listOf(resource.subject)
  }
}
