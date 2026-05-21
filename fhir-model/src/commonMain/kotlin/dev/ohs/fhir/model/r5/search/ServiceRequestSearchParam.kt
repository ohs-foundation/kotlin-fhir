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

import dev.ohs.fhir.model.r5.ActivityDefinition
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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
      BodyStructure,
      Category,
      CodeConcept,
      CodeReference,
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
    public override val paramName: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ServiceRequest.authoredOn"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object BasedOn : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(ServiceRequest::class, CarePlan::class, MedicationRequest::class)

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.basedOn
  }

  public data object BodySite : SearchParam<ServiceRequest, CodeableConcept> {
    public override val paramName: String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.bodySite"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> = resource.bodySite
  }

  public data object BodyStructure : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "body-structure"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.bodyStructure"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.BodyStructure::class)

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.bodyStructure)
  }

  public data object Category : SearchParam<ServiceRequest, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> = resource.category
  }

  public data object CodeConcept : SearchParam<ServiceRequest, CodeableConcept> {
    public override val paramName: String = "code-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.code.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> =
      listOfNotNull(resource.code?.concept)
  }

  public data object CodeReference : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "code-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.code.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(ActivityDefinition::class, PlanDefinition::class)

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.code?.reference)
  }

  public data object Encounter : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Encounter::class)

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<ServiceRequest, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<ServiceRequest, Canonical> {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.instantiatesCanonical"

    public override val target: List<KClass<out Resource>> =
      listOf(ActivityDefinition::class, PlanDefinition::class)

    public override fun extract(resource: ServiceRequest): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : SearchParam<ServiceRequest, Uri> {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ServiceRequest.instantiatesUri"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Uri> = resource.instantiatesUri
  }

  public data object Intent : SearchParam<ServiceRequest, Any> {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.intent"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> = listOf(resource.intent)
  }

  public data object Occurrence : SearchParam<ServiceRequest, Any> {
    public override val paramName: String = "occurrence"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ServiceRequest.occurrence.ofType(dateTime)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> = emptyList()
  }

  public data object Patient : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.performer"

    public override val target: List<KClass<out Resource>> =
      listOf(
        HealthcareService::class,
        Organization::class,
        CareTeam::class,
        Device::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.performer
  }

  public data object PerformerType : SearchParam<ServiceRequest, CodeableConcept> {
    public override val paramName: String = "performer-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.performerType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> =
      listOfNotNull(resource.performerType)
  }

  public data object Priority : SearchParam<ServiceRequest, Any> {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.priority"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Replaces : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "replaces"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.replaces"

    public override val target: List<KClass<out Resource>> = listOf(ServiceRequest::class)

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.replaces
  }

  public data object Requester : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.requester"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Organization::class,
        Device::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Requisition : SearchParam<ServiceRequest, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "requisition"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.requisition"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<dev.ohs.fhir.model.r5.Identifier> =
      listOfNotNull(resource.requisition)
  }

  public data object Specimen : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.specimen"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Specimen::class)

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.specimen
  }

  public data object Status : SearchParam<ServiceRequest, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<ServiceRequest, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Device::class, Group::class, Location::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOf(resource.subject)
  }
}
