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

import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DeviceMetric
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Media
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Specimen
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Media] resource type. */
public object MediaSearchParam {
  /** All search parameters for the Media resource type. */
  public val ALL: List<SearchParam<Media, *>> =
    listOf(
      BasedOn,
      Created,
      Device,
      Encounter,
      Identifier,
      Modality,
      Operator,
      Patient,
      Site,
      Status,
      Subject,
      Type,
      View,
    )

  public data object BasedOn : SearchParam<Media, Reference> {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(CarePlan::class, ServiceRequest::class)

    public override fun extract(resource: Media): List<Reference> = resource.basedOn
  }

  public data object Created : SearchParam<Media, Media.Created> {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Media.created"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Media): List<Media.Created> =
      listOfNotNull(resource.created)
  }

  public data object Device : SearchParam<Media, Reference> {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.device"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Device::class, DeviceMetric::class)

    public override fun extract(resource: Media): List<Reference> = listOfNotNull(resource.device)
  }

  public data object Encounter : SearchParam<Media, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Encounter::class)

    public override fun extract(resource: Media): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<Media, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Media): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Modality : SearchParam<Media, CodeableConcept> {
    public override val paramName: String = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.modality"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Media): List<CodeableConcept> =
      listOfNotNull(resource.modality)
  }

  public data object Operator : SearchParam<Media, Reference> {
    public override val paramName: String = "operator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.operator"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        CareTeam::class,
        dev.ohs.fhir.model.r4b.Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: Media): List<Reference> = listOfNotNull(resource.operator)
  }

  public data object Patient : SearchParam<Media, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: Media): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Site : SearchParam<Media, CodeableConcept> {
    public override val paramName: String = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.bodySite"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Media): List<CodeableConcept> =
      listOfNotNull(resource.bodySite)
  }

  public data object Status : SearchParam<Media, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Media): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<Media, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Group::class,
        Specimen::class,
        dev.ohs.fhir.model.r4b.Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        Location::class,
      )

    public override fun extract(resource: Media): List<Reference> = listOfNotNull(resource.subject)
  }

  public data object Type : SearchParam<Media, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Media): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object View : SearchParam<Media, CodeableConcept> {
    public override val paramName: String = "view"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.view"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Media): List<CodeableConcept> =
      listOfNotNull(resource.view)
  }
}
