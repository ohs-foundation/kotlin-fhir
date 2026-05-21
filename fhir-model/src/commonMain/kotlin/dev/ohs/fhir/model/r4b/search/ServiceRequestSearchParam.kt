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

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [ServiceRequest] resource type. */
public object ServiceRequestSearchParam {
  /** All search parameters for the ServiceRequest resource type. */
  public val ALL: List<SearchParam<ServiceRequest, *>> =
    listOf(
      Authored,
      BasedOn,
      BodySite,
      Category,
      Code,
      Encounter,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Intent,
      Occurrence,
      Patient,
      Performer,
      PerformerType,
      Priority,
      Replaces,
      Requester,
      Requisition,
      Specimen,
      Status,
      Subject,
    )

  public data object Authored : SearchParam<ServiceRequest, DateTime> {
    public override val name: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ServiceRequest.authoredOn"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object BasedOn : SearchParam<ServiceRequest, Reference> {
    public override val name: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(CarePlan::class, MedicationRequest::class, ServiceRequest::class)

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.basedOn
  }

  public data object BodySite : SearchParam<ServiceRequest, CodeableConcept> {
    public override val name: String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.bodySite"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> = resource.bodySite
  }

  public data object Category : SearchParam<ServiceRequest, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> = resource.category
  }

  public data object Code : SearchParam<ServiceRequest, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Encounter : SearchParam<ServiceRequest, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Encounter::class)

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<ServiceRequest, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<ServiceRequest, Canonical> {
    public override val name: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.instantiatesCanonical"

    public override val target: List<KClass<out Resource>> =
      listOf(PlanDefinition::class, ActivityDefinition::class)

    public override fun extract(resource: ServiceRequest): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : SearchParam<ServiceRequest, Uri> {
    public override val name: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ServiceRequest.instantiatesUri"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Uri> = resource.instantiatesUri
  }

  public data object Intent : SearchParam<ServiceRequest, Any> {
    public override val name: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.intent"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> = listOf(resource.intent)
  }

  public data object Occurrence : SearchParam<ServiceRequest, ServiceRequest.Occurrence> {
    public override val name: String = "occurrence"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ServiceRequest.occurrence"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<ServiceRequest.Occurrence> =
      listOfNotNull(resource.occurrence)
  }

  public data object Patient : SearchParam<ServiceRequest, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<ServiceRequest, Reference> {
    public override val name: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.performer"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        CareTeam::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        HealthcareService::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.performer
  }

  public data object PerformerType : SearchParam<ServiceRequest, CodeableConcept> {
    public override val name: String = "performer-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.performerType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> =
      listOfNotNull(resource.performerType)
  }

  public data object Priority : SearchParam<ServiceRequest, Any> {
    public override val name: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.priority"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Replaces : SearchParam<ServiceRequest, Reference> {
    public override val name: String = "replaces"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.replaces"

    public override val target: List<KClass<out Resource>> = listOf(ServiceRequest::class)

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.replaces
  }

  public data object Requester : SearchParam<ServiceRequest, Reference> {
    public override val name: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.requester"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Requisition : SearchParam<ServiceRequest, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "requisition"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.requisition"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<dev.ohs.fhir.model.r4b.Identifier> =
      listOfNotNull(resource.requisition)
  }

  public data object Specimen : SearchParam<ServiceRequest, Reference> {
    public override val name: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.specimen"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Specimen::class)

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.specimen
  }

  public data object Status : SearchParam<ServiceRequest, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<ServiceRequest, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, Device::class, dev.ohs.fhir.model.r4b.Patient::class, Location::class)

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOf(resource.subject)
  }
}
