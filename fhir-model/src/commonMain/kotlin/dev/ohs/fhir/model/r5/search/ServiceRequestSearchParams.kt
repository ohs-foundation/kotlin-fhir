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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ServiceRequest] resource type. */
public object ServiceRequestSearchParams {
  public val Authored: SearchParam<ServiceRequest, DateTime> =
    SimpleSearchParam<ServiceRequest, DateTime>(
      name = "authored",
      type = SearchParamType.fromCode("date"),
      expression = "ServiceRequest.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val BasedOn: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.basedOn",
      target = listOf(ServiceRequest::class, CarePlan::class, MedicationRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val BodySite: SearchParam<ServiceRequest, CodeableConcept> =
    SimpleSearchParam<ServiceRequest, CodeableConcept>(
      name = "body-site",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.bodySite",
      extractor = { resource -> resource.bodySite },
    )

  public val BodyStructure: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "body-structure",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.bodyStructure",
      target = listOf(dev.ohs.fhir.model.r5.BodyStructure::class),
      extractor = { resource -> listOfNotNull(resource.bodyStructure) },
    )

  public val Category: SearchParam<ServiceRequest, CodeableConcept> =
    SimpleSearchParam<ServiceRequest, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.category",
      extractor = { resource -> resource.category },
    )

  public val CodeConcept: SearchParam<ServiceRequest, CodeableConcept> =
    SimpleSearchParam<ServiceRequest, CodeableConcept>(
      name = "code-concept",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.code.concept",
      extractor = { resource -> listOfNotNull(resource.code?.concept) },
    )

  public val CodeReference: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "code-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.code.reference",
      target = listOf(ActivityDefinition::class, PlanDefinition::class),
      extractor = { resource -> listOfNotNull(resource.code?.reference) },
    )

  public val Encounter: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.encounter",
      target = listOf(dev.ohs.fhir.model.r5.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<ServiceRequest, Identifier> =
    SimpleSearchParam<ServiceRequest, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val InstantiatesCanonical: SearchParam<ServiceRequest, Canonical> =
    SimpleSearchParam<ServiceRequest, Canonical>(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.instantiatesCanonical",
      target = listOf(ActivityDefinition::class, PlanDefinition::class),
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val InstantiatesUri: SearchParam<ServiceRequest, Uri> =
    SimpleSearchParam<ServiceRequest, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "ServiceRequest.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val Intent: SearchParam<ServiceRequest, Any> =
    SimpleSearchParam<ServiceRequest, Any>(
      name = "intent",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val Occurrence: SearchParam<ServiceRequest, Any> =
    SimpleSearchParam<ServiceRequest, Any>(
      name = "occurrence",
      type = SearchParamType.fromCode("date"),
      expression = "ServiceRequest.occurrence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val Patient: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
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
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.performer },
    )

  public val PerformerType: SearchParam<ServiceRequest, CodeableConcept> =
    SimpleSearchParam<ServiceRequest, CodeableConcept>(
      name = "performer-type",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.performerType",
      extractor = { resource -> listOfNotNull(resource.performerType) },
    )

  public val Priority: SearchParam<ServiceRequest, Any> =
    SimpleSearchParam<ServiceRequest, Any>(
      name = "priority",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.priority",
      extractor = { resource -> listOfNotNull(resource.priority) },
    )

  public val Replaces: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "replaces",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.replaces",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.replaces },
    )

  public val Requester: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
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
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.requester) },
    )

  public val Requisition: SearchParam<ServiceRequest, Identifier> =
    SimpleSearchParam<ServiceRequest, Identifier>(
      name = "requisition",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.requisition",
      extractor = { resource -> listOfNotNull(resource.requisition) },
    )

  public val Specimen: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "specimen",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.specimen",
      target = listOf(dev.ohs.fhir.model.r5.Specimen::class),
      extractor = { resource -> resource.specimen },
    )

  public val Status: SearchParam<ServiceRequest, Any> =
    SimpleSearchParam<ServiceRequest, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.subject",
      target =
        listOf(Device::class, Group::class, Location::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

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
}
