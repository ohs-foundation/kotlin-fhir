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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ServiceRequest] resource type. */
public object ServiceRequestSearchParam {
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
      target = listOf(CarePlan::class, MedicationRequest::class, ServiceRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val BodySite: SearchParam<ServiceRequest, CodeableConcept> =
    SimpleSearchParam<ServiceRequest, CodeableConcept>(
      name = "body-site",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.bodySite",
      extractor = { resource -> resource.bodySite },
    )

  public val Category: SearchParam<ServiceRequest, CodeableConcept> =
    SimpleSearchParam<ServiceRequest, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.category",
      extractor = { resource -> resource.category },
    )

  public val Code: SearchParam<ServiceRequest, CodeableConcept> =
    SimpleSearchParam<ServiceRequest, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "ServiceRequest.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Encounter: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.encounter",
      target = listOf(dev.ohs.fhir.model.r4b.Encounter::class),
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
      target = listOf(PlanDefinition::class, ActivityDefinition::class),
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

  public val Occurrence: SearchParam<ServiceRequest, ServiceRequest.Occurrence> =
    SimpleSearchParam<ServiceRequest, ServiceRequest.Occurrence>(
      name = "occurrence",
      type = SearchParamType.fromCode("date"),
      expression = "ServiceRequest.occurrence",
      extractor = { resource -> listOfNotNull(resource.occurrence) },
    )

  public val Patient: SearchParam<ServiceRequest, Reference> =
    SimpleSearchParam<ServiceRequest, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ServiceRequest.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
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
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          RelatedPerson::class,
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
          Practitioner::class,
          Organization::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
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
      target = listOf(dev.ohs.fhir.model.r4b.Specimen::class),
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
        listOf(Group::class, Device::class, dev.ohs.fhir.model.r4b.Patient::class, Location::class),
      extractor = { resource -> listOf(resource.subject) },
    )

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
}
