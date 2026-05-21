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
import dev.ohs.fhir.model.r5.DeviceAssociation
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [DeviceAssociation] resource type. */
public object DeviceAssociationSearchParam {
  /** All search parameters for the DeviceAssociation resource type. */
  public val ALL: List<SearchParam<DeviceAssociation, *>> =
    listOf(Device, Identifier, Operator, Patient, Status, Subject)

  public data object Device : SearchParam<DeviceAssociation, Reference> {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceAssociation.device"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Device::class)

    public override fun extract(resource: DeviceAssociation): List<Reference> =
      listOf(resource.device)
  }

  public data object Identifier : SearchParam<DeviceAssociation, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceAssociation.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DeviceAssociation
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Operator : SearchParam<DeviceAssociation, Reference> {
    public override val paramName: String = "operator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceAssociation.operation.operator"

    public override val target: List<KClass<out Resource>> =
      listOf(RelatedPerson::class, Practitioner::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: DeviceAssociation): List<Reference> =
      resource.operation.flatMap { it.operator }
  }

  public data object Patient : SearchParam<DeviceAssociation, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceAssociation.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: DeviceAssociation): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Status : SearchParam<DeviceAssociation, CodeableConcept> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceAssociation.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceAssociation): List<CodeableConcept> =
      listOf(resource.status)
  }

  public data object Subject : SearchParam<DeviceAssociation, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceAssociation.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: DeviceAssociation): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }
}
