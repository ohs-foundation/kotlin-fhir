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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.DeviceRequest
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceRequest] resource type. */
public object DeviceRequestSearchParam {
  /** All search parameters for the DeviceRequest resource type. */
  public val ALL: List<SearchParam<DeviceRequest, *>> =
    listOf(
      AuthoredOn,
      BasedOn,
      Code,
      Device,
      Encounter,
      EventDate,
      GroupIdentifier,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Insurance,
      Intent,
      Patient,
      Performer,
      PriorRequest,
      Requester,
      Status,
      Subject,
    )

  public data object AuthoredOn : SearchParam<DeviceRequest, DateTime> {
    public override val paramName: String = "authored-on"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DeviceRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object BasedOn : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.basedOn"

    public override val target: List<String> =
      listOf(
        "Account",
        "ActivityDefinition",
        "AdministrableProductDefinition",
        "AdverseEvent",
        "AllergyIntolerance",
        "Appointment",
        "AppointmentResponse",
        "AuditEvent",
        "Basic",
        "Binary",
        "BiologicallyDerivedProduct",
        "BodyStructure",
        "Bundle",
        "CapabilityStatement",
        "CarePlan",
        "CareTeam",
        "CatalogEntry",
        "ChargeItem",
        "ChargeItemDefinition",
        "Citation",
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
        "ClinicalUseDefinition",
        "CodeSystem",
        "Communication",
        "CommunicationRequest",
        "CompartmentDefinition",
        "Composition",
        "ConceptMap",
        "Condition",
        "Consent",
        "Contract",
        "Coverage",
        "CoverageEligibilityRequest",
        "CoverageEligibilityResponse",
        "DetectedIssue",
        "Device",
        "DeviceDefinition",
        "DeviceMetric",
        "DeviceRequest",
        "DeviceUseStatement",
        "DiagnosticReport",
        "DocumentManifest",
        "DocumentReference",
        "Encounter",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
        "EvidenceReport",
        "EvidenceVariable",
        "ExampleScenario",
        "ExplanationOfBenefit",
        "FamilyMemberHistory",
        "Flag",
        "Goal",
        "GraphDefinition",
        "Group",
        "GuidanceResponse",
        "HealthcareService",
        "ImagingStudy",
        "Immunization",
        "ImmunizationEvaluation",
        "ImmunizationRecommendation",
        "ImplementationGuide",
        "Ingredient",
        "InsurancePlan",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "ManufacturedItemDefinition",
        "Measure",
        "MeasureReport",
        "Media",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProductDefinition",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionOrder",
        "NutritionProduct",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
        "PackagedProductDefinition",
        "Patient",
        "PaymentNotice",
        "PaymentReconciliation",
        "Person",
        "PlanDefinition",
        "Practitioner",
        "PractitionerRole",
        "Procedure",
        "Provenance",
        "Questionnaire",
        "QuestionnaireResponse",
        "RegulatedAuthorization",
        "RelatedPerson",
        "RequestGroup",
        "ResearchDefinition",
        "ResearchElementDefinition",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "SubscriptionStatus",
        "SubscriptionTopic",
        "Substance",
        "SubstanceDefinition",
        "SupplyDelivery",
        "SupplyRequest",
        "Task",
        "TerminologyCapabilities",
        "TestReport",
        "TestScript",
        "ValueSet",
        "VerificationResult",
        "VisionPrescription",
      )

    public override fun extract(resource: DeviceRequest): List<Reference> = resource.basedOn
  }

  public data object Code : SearchParam<DeviceRequest, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(DeviceRequest.code as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<CodeableConcept> =
      listOfNotNull((resource.code as? DeviceRequest.Code.CodeableConcept)?.value)
  }

  public data object Device : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(DeviceRequest.code as Reference)"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: DeviceRequest): List<Reference> =
      listOfNotNull((resource.code as? DeviceRequest.Code.Reference)?.value)
  }

  public data object Encounter : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: DeviceRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object EventDate : SearchParam<DeviceRequest, DateTime> {
    public override val paramName: String = "event-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(DeviceRequest.occurrence as dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<DateTime> =
      listOfNotNull((resource.occurrence as? DeviceRequest.Occurrence.DateTime)?.value)
  }

  public data object GroupIdentifier :
    SearchParam<DeviceRequest, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceRequest.groupIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<dev.ohs.fhir.model.r4b.Identifier> =
      listOfNotNull(resource.groupIdentifier)
  }

  public data object Identifier : SearchParam<DeviceRequest, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<DeviceRequest, Canonical> {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.instantiatesCanonical"

    public override val target: List<String> = listOf("PlanDefinition", "ActivityDefinition")

    public override fun extract(resource: DeviceRequest): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : SearchParam<DeviceRequest, Uri> {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "DeviceRequest.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Uri> = resource.instantiatesUri
  }

  public data object Insurance : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "insurance"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.insurance"

    public override val target: List<String> = listOf("ClaimResponse", "Coverage")

    public override fun extract(resource: DeviceRequest): List<Reference> = resource.insurance
  }

  public data object Intent : SearchParam<DeviceRequest, Any> {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceRequest.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = listOf(resource.intent)
  }

  public data object Patient : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: DeviceRequest): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.performer"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Device",
        "Patient",
        "HealthcareService",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: DeviceRequest): List<Reference> =
      listOfNotNull(resource.performer)
  }

  public data object PriorRequest : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "prior-request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.priorRequest"

    public override val target: List<String> =
      listOf(
        "Account",
        "ActivityDefinition",
        "AdministrableProductDefinition",
        "AdverseEvent",
        "AllergyIntolerance",
        "Appointment",
        "AppointmentResponse",
        "AuditEvent",
        "Basic",
        "Binary",
        "BiologicallyDerivedProduct",
        "BodyStructure",
        "Bundle",
        "CapabilityStatement",
        "CarePlan",
        "CareTeam",
        "CatalogEntry",
        "ChargeItem",
        "ChargeItemDefinition",
        "Citation",
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
        "ClinicalUseDefinition",
        "CodeSystem",
        "Communication",
        "CommunicationRequest",
        "CompartmentDefinition",
        "Composition",
        "ConceptMap",
        "Condition",
        "Consent",
        "Contract",
        "Coverage",
        "CoverageEligibilityRequest",
        "CoverageEligibilityResponse",
        "DetectedIssue",
        "Device",
        "DeviceDefinition",
        "DeviceMetric",
        "DeviceRequest",
        "DeviceUseStatement",
        "DiagnosticReport",
        "DocumentManifest",
        "DocumentReference",
        "Encounter",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
        "EvidenceReport",
        "EvidenceVariable",
        "ExampleScenario",
        "ExplanationOfBenefit",
        "FamilyMemberHistory",
        "Flag",
        "Goal",
        "GraphDefinition",
        "Group",
        "GuidanceResponse",
        "HealthcareService",
        "ImagingStudy",
        "Immunization",
        "ImmunizationEvaluation",
        "ImmunizationRecommendation",
        "ImplementationGuide",
        "Ingredient",
        "InsurancePlan",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "ManufacturedItemDefinition",
        "Measure",
        "MeasureReport",
        "Media",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProductDefinition",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionOrder",
        "NutritionProduct",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
        "PackagedProductDefinition",
        "Patient",
        "PaymentNotice",
        "PaymentReconciliation",
        "Person",
        "PlanDefinition",
        "Practitioner",
        "PractitionerRole",
        "Procedure",
        "Provenance",
        "Questionnaire",
        "QuestionnaireResponse",
        "RegulatedAuthorization",
        "RelatedPerson",
        "RequestGroup",
        "ResearchDefinition",
        "ResearchElementDefinition",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "SubscriptionStatus",
        "SubscriptionTopic",
        "Substance",
        "SubstanceDefinition",
        "SupplyDelivery",
        "SupplyRequest",
        "Task",
        "TerminologyCapabilities",
        "TestReport",
        "TestScript",
        "ValueSet",
        "VerificationResult",
        "VisionPrescription",
      )

    public override fun extract(resource: DeviceRequest): List<Reference> = resource.priorRequest
  }

  public data object Requester : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.requester"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "Device", "PractitionerRole")

    public override fun extract(resource: DeviceRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : SearchParam<DeviceRequest, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<DeviceRequest, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.subject"

    public override val target: List<String> = listOf("Group", "Device", "Patient", "Location")

    public override fun extract(resource: DeviceRequest): List<Reference> = listOf(resource.subject)
  }
}
