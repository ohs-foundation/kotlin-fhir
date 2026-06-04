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
import dev.ohs.fhir.model.r5.BodyStructure
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ServiceRequest] resource type. */
public object ServiceRequestSearchParams {
  public val authored: SearchParam<ServiceRequest, DateTime> =
    SearchParam<ServiceRequest, DateTime>(
      name = "authored",
      type = SearchParamType.fromCode("date"),
      expression = "ServiceRequest.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val basedOn: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.basedOn",
      target = listOf(ServiceRequest::class, CarePlan::class, MedicationRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val bodySite: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam<ServiceRequest, CodeableConcept>(
      name = "body-site",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.bodySite",
      extractor = { resource -> resource.bodySite },
    )

  public val bodyStructure: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "body-structure",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.bodyStructure",
      target = listOf(BodyStructure::class),
      extractor = { resource -> listOfNotNull(resource.bodyStructure) },
    )

  public val category: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam<ServiceRequest, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.category",
      extractor = { resource -> resource.category },
    )

  public val codeConcept: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam<ServiceRequest, CodeableConcept>(
      name = "code-concept",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.code.concept",
      extractor = { resource -> listOfNotNull(resource.code?.concept) },
    )

  public val codeReference: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "code-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.code.reference",
      target = listOf(ActivityDefinition::class, PlanDefinition::class),
      extractor = { resource -> listOfNotNull(resource.code?.reference) },
    )

  public val encounter: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<ServiceRequest, Identifier> =
    SearchParam<ServiceRequest, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<ServiceRequest, Canonical> =
    SearchParam<ServiceRequest, Canonical>(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.instantiatesCanonical",
      target = listOf(ActivityDefinition::class, PlanDefinition::class),
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val instantiatesUri: SearchParam<ServiceRequest, Uri> =
    SearchParam<ServiceRequest, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "ServiceRequest.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val intent: SearchParam<ServiceRequest, Any> =
    SearchParam<ServiceRequest, Any>(
      name = "intent",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val occurrence: SearchParam<ServiceRequest, Any> =
    SearchParam<ServiceRequest, Any>(
      name = "occurrence",
      type = SearchParamType.fromCode("date"),
      expression = "ServiceRequest.occurrence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val patient: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.performer",
      target =
        listOf(
          HealthcareService::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.performer },
    )

  public val performerType: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam<ServiceRequest, CodeableConcept>(
      name = "performer-type",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.performerType",
      extractor = { resource -> listOfNotNull(resource.performerType) },
    )

  public val priority: SearchParam<ServiceRequest, Any> =
    SearchParam<ServiceRequest, Any>(
      name = "priority",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.priority",
      extractor = { resource -> listOfNotNull(resource.priority) },
    )

  public val replaces: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "replaces",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.replaces",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.replaces },
    )

  public val requester: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "requester",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.requester",
      target =
        listOf(
          Organization::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.requester) },
    )

  public val requisition: SearchParam<ServiceRequest, Identifier> =
    SearchParam<ServiceRequest, Identifier>(
      name = "requisition",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.requisition",
      extractor = { resource -> listOfNotNull(resource.requisition) },
    )

  public val specimen: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "specimen",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.specimen",
      target = listOf(Specimen::class),
      extractor = { resource -> resource.specimen },
    )

  public val status: SearchParam<ServiceRequest, Any> =
    SearchParam<ServiceRequest, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<ServiceRequest, Reference> =
    SearchParam<ServiceRequest, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.subject",
      target = listOf(Device::class, Group::class, Location::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the ServiceRequest resource type. */
  public val all: List<SearchParam<ServiceRequest, *>> =
    listOf(
      authored,
      basedOn,
      bodySite,
      bodyStructure,
      category,
      codeConcept,
      codeReference,
      encounter,
      identifier,
      instantiatesCanonical,
      instantiatesUri,
      intent,
      occurrence,
      patient,
      performer,
      performerType,
      priority,
      replaces,
      requester,
      requisition,
      specimen,
      status,
      subject,
    )
}
