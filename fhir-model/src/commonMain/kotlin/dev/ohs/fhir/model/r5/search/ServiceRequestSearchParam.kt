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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ServiceRequest] resource type. */
public sealed class ServiceRequestSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ServiceRequest): List<T>

  public data object Authored : ServiceRequestSearchParam<DateTime>() {
    public override val paramName: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ServiceRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object BasedOn : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.basedOn"

    public override val target: List<String> =
      listOf("ServiceRequest", "CarePlan", "MedicationRequest")

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.basedOn
  }

  public data object BodySite : ServiceRequestSearchParam<CodeableConcept>() {
    public override val paramName: String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.bodySite"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> = resource.bodySite
  }

  public data object BodyStructure : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "body-structure"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.bodyStructure"

    public override val target: List<String> = listOf("BodyStructure")

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.bodyStructure)
  }

  public data object Category : ServiceRequestSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> = resource.category
  }

  public data object CodeConcept : ServiceRequestSearchParam<CodeableConcept>() {
    public override val paramName: String = "code-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.code.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> =
      listOfNotNull(resource.code?.concept)
  }

  public data object CodeReference : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "code-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.code.reference"

    public override val target: List<String> = listOf("ActivityDefinition", "PlanDefinition")

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.code?.reference)
  }

  public data object Encounter : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : ServiceRequestSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : ServiceRequestSearchParam<Canonical>() {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.instantiatesCanonical"

    public override val target: List<String> = listOf("ActivityDefinition", "PlanDefinition")

    public override fun extract(resource: ServiceRequest): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : ServiceRequestSearchParam<Uri>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ServiceRequest.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Uri> = resource.instantiatesUri
  }

  public data object Intent : ServiceRequestSearchParam<Any>() {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> = listOf(resource.intent)
  }

  public data object Occurrence : ServiceRequestSearchParam<Any>() {
    public override val paramName: String = "occurrence"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ServiceRequest.occurrence.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> = emptyList()
  }

  public data object Patient : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.performer"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Organization",
        "CareTeam",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.performer
  }

  public data object PerformerType : ServiceRequestSearchParam<CodeableConcept>() {
    public override val paramName: String = "performer-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.performerType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<CodeableConcept> =
      listOfNotNull(resource.performerType)
  }

  public data object Priority : ServiceRequestSearchParam<Any>() {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Replaces : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "replaces"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.replaces"

    public override val target: List<String> = listOf("ServiceRequest")

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.replaces
  }

  public data object Requester : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.requester"

    public override val target: List<String> =
      listOf(
        "Organization",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Requisition : ServiceRequestSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "requisition"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.requisition"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<dev.ohs.fhir.model.r5.Identifier> =
      listOfNotNull(resource.requisition)
  }

  public data object Specimen : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.specimen"

    public override val target: List<String> = listOf("Specimen")

    public override fun extract(resource: ServiceRequest): List<Reference> = resource.specimen
  }

  public data object Status : ServiceRequestSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ServiceRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ServiceRequest): List<Any> = listOf(resource.status)
  }

  public data object Subject : ServiceRequestSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ServiceRequest.subject"

    public override val target: List<String> = listOf("Device", "Group", "Location", "Patient")

    public override fun extract(resource: ServiceRequest): List<Reference> =
      listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the ServiceRequest resource type. */
    public val ALL: List<ServiceRequestSearchParam<*>> =
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
  }
}
