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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

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
import kotlin.NotImplementedError
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
      target = listOf(ServiceRequest::class, CarePlan::class, MedicationRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val bodySite: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam(
      name = "body-site",
      type = SearchParamType.Token,
      expression = "ServiceRequest.bodySite",
      extractor = { resource -> resource.bodySite },
    )

  public val bodyStructure: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "body-structure",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.bodyStructure",
      target = listOf(BodyStructure::class),
      extractor = { resource -> listOfNotNull(resource.bodyStructure) },
    )

  public val category: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "ServiceRequest.category",
      extractor = { resource -> resource.category },
    )

  public val codeConcept: SearchParam<ServiceRequest, CodeableConcept> =
    SearchParam(
      name = "code-concept",
      type = SearchParamType.Token,
      expression = "ServiceRequest.code.concept",
      extractor = { resource -> listOfNotNull(resource.code?.concept) },
    )

  public val codeReference: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "code-reference",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.code.reference",
      target = listOf(ActivityDefinition::class, PlanDefinition::class),
      extractor = { resource -> listOfNotNull(resource.code?.reference) },
    )

  public val encounter: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.encounter",
      target = listOf(Encounter::class),
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
      target = listOf(ActivityDefinition::class, PlanDefinition::class),
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

  public val occurrence: SearchParam<ServiceRequest, Any> =
    SearchParam(
      name = "occurrence",
      type = SearchParamType.Date,
      expression = "ServiceRequest.occurrence.ofType(dateTime)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'occurrence' has expression 'ServiceRequest.occurrence.ofType(dateTime)' which is not yet supported."
        )
      },
    )

  public val patient: SearchParam<ServiceRequest, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "ServiceRequest.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
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
      target = listOf(Device::class, Group::class, Location::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ServiceRequest, *>> = listOf(occurrence)

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
      bodyStructure,
      category,
      codeConcept,
      codeReference,
      encounter,
      identifier,
      instantiatesCanonical,
      instantiatesUri,
      intent,
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
