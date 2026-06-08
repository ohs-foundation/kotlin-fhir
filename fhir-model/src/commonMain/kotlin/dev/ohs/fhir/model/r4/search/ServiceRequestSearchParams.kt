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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.ActivityDefinition
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CarePlan
import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.Specimen
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ServiceRequest] resource type. */
public object ServiceRequestSearchParams {
  public val authored: SearchParam<ServiceRequest, DateTime> =
    SearchParam(
      name = "authored",
      type = SearchParamType.Date,
      expression = "ServiceRequest.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val basedOn: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.basedOn",
      target = listOf(CarePlan::class, MedicationRequest::class, ServiceRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val bodySite: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam(
      name = "body-site",
      type = SearchParamType.Token,
      expression = "ServiceRequest.bodySite",
      extractor = { resource -> resource.bodySite },
    )

  public val category: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "ServiceRequest.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "ServiceRequest.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val encounter: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.encounter",
      target = listOf(Encounter::class, EpisodeOfCare::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<ServiceRequest, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ServiceRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<ServiceRequest, Canonical> =
    SearchParam(
      name = "instantiates-canonical",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.instantiatesCanonical",
      target = listOf(PlanDefinition::class, ActivityDefinition::class),
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val instantiatesUri: SearchParam<ServiceRequest, Uri> =
    SearchParam(
      name = "instantiates-uri",
      type = SearchParamType.Uri,
      expression = "ServiceRequest.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val intent: SearchParam<ServiceRequest, Any> =
    SearchParam(
      name = "intent",
      type = SearchParamType.Token,
      expression = "ServiceRequest.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val occurrence: SearchParam<ServiceRequest, ServiceRequest.Occurrence> =
    SearchParam(
      name = "occurrence",
      type = SearchParamType.Date,
      expression = "ServiceRequest.occurrence",
      extractor = { resource -> listOfNotNull(resource.occurrence) },
    )

  public val patient: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.subject.where(resolve() is Patient)",
      target = listOf(Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.performer",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer },
    )

  public val performerType: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam(
      name = "performer-type",
      type = SearchParamType.Token,
      expression = "ServiceRequest.performerType",
      extractor = { resource -> listOfNotNull(resource.performerType) },
    )

  public val priority: SearchParam<ServiceRequest, Any> =
    SearchParam(
      name = "priority",
      type = SearchParamType.Token,
      expression = "ServiceRequest.priority",
      extractor = { resource -> listOfNotNull(resource.priority) },
    )

  public val replaces: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "replaces",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.replaces",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.replaces },
    )

  public val requester: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "requester",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.requester",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.requester) },
    )

  public val requisition: SearchParam<ServiceRequest, Identifier> =
    SearchParam(
      name = "requisition",
      type = SearchParamType.Token,
      expression = "ServiceRequest.requisition",
      extractor = { resource -> listOfNotNull(resource.requisition) },
    )

  public val specimen: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "specimen",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.specimen",
      target = listOf(Specimen::class),
      extractor = { resource -> resource.specimen },
    )

  public val status: SearchParam<ServiceRequest, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ServiceRequest.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.subject",
      target = listOf(Group::class, Device::class, Patient::class, Location::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ServiceRequest, *>> = listOf()

  /**
   * Supported search parameters for the ServiceRequest resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ServiceRequest, *>> =
    listOf(
      authored,
      basedOn,
      bodySite,
      category,
      code,
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
