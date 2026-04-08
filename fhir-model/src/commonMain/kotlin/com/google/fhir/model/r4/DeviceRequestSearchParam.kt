/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceRequest] resource type. */
public sealed class DeviceRequestSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DeviceRequest): List<T>

  public data object AuthoredOn : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "authored-on"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DeviceRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object BasedOn : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.basedOn"

    public override val target: List<String> =
      listOf(
        "Account",
        "ActivityDefinition",
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
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
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
        "EffectEvidenceSynthesis",
        "Encounter",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
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
        "InsurancePlan",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "Measure",
        "MeasureReport",
        "Media",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProduct",
        "MedicinalProductAuthorization",
        "MedicinalProductContraindication",
        "MedicinalProductIndication",
        "MedicinalProductIngredient",
        "MedicinalProductInteraction",
        "MedicinalProductManufactured",
        "MedicinalProductPackaged",
        "MedicinalProductPharmaceutical",
        "MedicinalProductUndesirableEffect",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionOrder",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
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
        "RelatedPerson",
        "RequestGroup",
        "ResearchDefinition",
        "ResearchElementDefinition",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "RiskEvidenceSynthesis",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "Substance",
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SubstanceSpecification",
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

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Code : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(DeviceRequest.code as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Device : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(DeviceRequest.code as Reference)"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Encounter : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.encounter"

    public override val target: List<String> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object EventDate : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "event-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(DeviceRequest.occurrence as dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object GroupIdentifier : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceRequest.groupIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Identifier : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object InstantiatesCanonical : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.instantiatesCanonical"

    public override val target: List<String> = listOf("PlanDefinition", "ActivityDefinition")

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object InstantiatesUri : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "DeviceRequest.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Insurance : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "insurance"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.insurance"

    public override val target: List<String> = listOf("ClaimResponse", "Coverage")

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Intent : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceRequest.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Patient : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Performer : DeviceRequestSearchParam<Any>() {
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

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object PriorRequest : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "prior-request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.priorRequest"

    public override val target: List<String> =
      listOf(
        "Account",
        "ActivityDefinition",
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
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
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
        "EffectEvidenceSynthesis",
        "Encounter",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
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
        "InsurancePlan",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "Measure",
        "MeasureReport",
        "Media",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProduct",
        "MedicinalProductAuthorization",
        "MedicinalProductContraindication",
        "MedicinalProductIndication",
        "MedicinalProductIngredient",
        "MedicinalProductInteraction",
        "MedicinalProductManufactured",
        "MedicinalProductPackaged",
        "MedicinalProductPharmaceutical",
        "MedicinalProductUndesirableEffect",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionOrder",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
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
        "RelatedPerson",
        "RequestGroup",
        "ResearchDefinition",
        "ResearchElementDefinition",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "RiskEvidenceSynthesis",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "Substance",
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SubstanceSpecification",
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

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Requester : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.requester"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "Device", "PractitionerRole")

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Status : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public data object Subject : DeviceRequestSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceRequest.subject"

    public override val target: List<String> = listOf("Group", "Device", "Patient", "Location")

    public override fun extract(resource: DeviceRequest): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the DeviceRequest resource type. */
    public val ALL: List<DeviceRequestSearchParam<*>> =
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
  }
}
