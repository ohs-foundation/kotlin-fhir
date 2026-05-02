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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DocumentReference] resource type. */
public sealed class DocumentReferenceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DocumentReference): List<T>

  public data object Attester : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "attester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.attester.party"

    public override val target: List<String> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Author : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.author"

    public override val target: List<String> =
      listOf(
        "Organization",
        "Device",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object BasedOn : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.basedOn"

    public override val target: List<String> =
      listOf(
        "Claim",
        "RequestOrchestration",
        "DeviceRequest",
        "ServiceRequest",
        "EnrollmentRequest",
        "CarePlan",
        "Contract",
        "MedicationRequest",
        "ImmunizationRecommendation",
        "CoverageEligibilityRequest",
        "VisionPrescription",
        "Appointment",
        "CommunicationRequest",
        "AppointmentResponse",
        "SupplyRequest",
        "NutritionOrder",
      )

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Bodysite : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "bodysite"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.bodySite.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object BodysiteReference : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "bodysite-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.bodySite.reference"

    public override val target: List<String> = listOf("BodyStructure")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Category : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Contenttype : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "contenttype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.content.attachment.contentType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Context : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.context"

    public override val target: List<String> = listOf("Appointment", "Encounter", "EpisodeOfCare")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Creation : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "creation"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DocumentReference.content.attachment.creation"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Custodian : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "custodian"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.custodian"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Date : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DocumentReference.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Description : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "DocumentReference.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object DocStatus : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "doc-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.docStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object EventCode : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "event-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.event.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object EventReference : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "event-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.event.reference"

    public override val target: List<String> =
      listOf(
        "Account",
        "ActivityDefinition",
        "ActorDefinition",
        "AdministrableProductDefinition",
        "AdverseEvent",
        "AllergyIntolerance",
        "Appointment",
        "AppointmentResponse",
        "ArtifactAssessment",
        "AuditEvent",
        "Basic",
        "Binary",
        "BiologicallyDerivedProduct",
        "BiologicallyDerivedProductDispense",
        "BodyStructure",
        "Bundle",
        "CapabilityStatement",
        "CarePlan",
        "CareTeam",
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
        "ConditionDefinition",
        "Consent",
        "Contract",
        "Coverage",
        "CoverageEligibilityRequest",
        "CoverageEligibilityResponse",
        "DetectedIssue",
        "Device",
        "DeviceAssociation",
        "DeviceDefinition",
        "DeviceDispense",
        "DeviceMetric",
        "DeviceRequest",
        "DeviceUsage",
        "DiagnosticReport",
        "DocumentReference",
        "Encounter",
        "EncounterHistory",
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
        "FormularyItem",
        "GenomicStudy",
        "Goal",
        "GraphDefinition",
        "Group",
        "GuidanceResponse",
        "HealthcareService",
        "ImagingSelection",
        "ImagingStudy",
        "Immunization",
        "ImmunizationEvaluation",
        "ImmunizationRecommendation",
        "ImplementationGuide",
        "Ingredient",
        "InsurancePlan",
        "InventoryItem",
        "InventoryReport",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "ManufacturedItemDefinition",
        "Measure",
        "MeasureReport",
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
        "NutritionIntake",
        "NutritionOrder",
        "NutritionProduct",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
        "PackagedProductDefinition",
        "Parameters",
        "Patient",
        "PaymentNotice",
        "PaymentReconciliation",
        "Permission",
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
        "RequestOrchestration",
        "Requirements",
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
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SupplyDelivery",
        "SupplyRequest",
        "Task",
        "TerminologyCapabilities",
        "TestPlan",
        "TestReport",
        "TestScript",
        "Transport",
        "ValueSet",
        "VerificationResult",
        "VisionPrescription",
      )

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Facility : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.facilityType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object FormatCanonical : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "format-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "(DocumentReference.content.profile.value.ofType(canonical))"

    public override val target: List<String> =
      listOf(
        "ActivityDefinition",
        "ActorDefinition",
        "CapabilityStatement",
        "ChargeItemDefinition",
        "Citation",
        "CodeSystem",
        "CompartmentDefinition",
        "Composition",
        "ConceptMap",
        "ConditionDefinition",
        "Contract",
        "Device",
        "EventDefinition",
        "Evidence",
        "EvidenceReport",
        "EvidenceVariable",
        "ExampleScenario",
        "GraphDefinition",
        "ImplementationGuide",
        "Library",
        "Measure",
        "MessageDefinition",
        "NamingSystem",
        "ObservationDefinition",
        "OperationDefinition",
        "PlanDefinition",
        "Questionnaire",
        "Requirements",
        "ResearchStudy",
        "SearchParameter",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "SubscriptionTopic",
        "TerminologyCapabilities",
        "TestPlan",
        "TestScript",
        "ValueSet",
      )

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object FormatCode : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "format-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(DocumentReference.content.profile.value.ofType(Coding))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object FormatUri : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "format-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "(DocumentReference.content.profile.value.ofType(uri))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Identifier : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Language : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.content.attachment.language"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Location : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "DocumentReference.content.attachment.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Modality : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.modality"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Patient : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Period : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DocumentReference.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Relatesto : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "relatesto"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.relatesTo.target"

    public override val target: List<String> = listOf("DocumentReference")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Relation : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.relatesTo.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Relationship : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "DocumentReference.relatesTo"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object SecurityLabel : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.securityLabel"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Setting : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "setting"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.practiceSetting"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Status : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Subject : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.subject"

    public override val target: List<String> =
      listOf(
        "Account",
        "ActivityDefinition",
        "ActorDefinition",
        "AdministrableProductDefinition",
        "AdverseEvent",
        "AllergyIntolerance",
        "Appointment",
        "AppointmentResponse",
        "ArtifactAssessment",
        "AuditEvent",
        "Basic",
        "Binary",
        "BiologicallyDerivedProduct",
        "BiologicallyDerivedProductDispense",
        "BodyStructure",
        "Bundle",
        "CapabilityStatement",
        "CarePlan",
        "CareTeam",
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
        "ConditionDefinition",
        "Consent",
        "Contract",
        "Coverage",
        "CoverageEligibilityRequest",
        "CoverageEligibilityResponse",
        "DetectedIssue",
        "Device",
        "DeviceAssociation",
        "DeviceDefinition",
        "DeviceDispense",
        "DeviceMetric",
        "DeviceRequest",
        "DeviceUsage",
        "DiagnosticReport",
        "DocumentReference",
        "Encounter",
        "EncounterHistory",
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
        "FormularyItem",
        "GenomicStudy",
        "Goal",
        "GraphDefinition",
        "Group",
        "GuidanceResponse",
        "HealthcareService",
        "ImagingSelection",
        "ImagingStudy",
        "Immunization",
        "ImmunizationEvaluation",
        "ImmunizationRecommendation",
        "ImplementationGuide",
        "Ingredient",
        "InsurancePlan",
        "InventoryItem",
        "InventoryReport",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "ManufacturedItemDefinition",
        "Measure",
        "MeasureReport",
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
        "NutritionIntake",
        "NutritionOrder",
        "NutritionProduct",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
        "PackagedProductDefinition",
        "Parameters",
        "Patient",
        "PaymentNotice",
        "PaymentReconciliation",
        "Permission",
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
        "RequestOrchestration",
        "Requirements",
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
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SupplyDelivery",
        "SupplyRequest",
        "Task",
        "TerminologyCapabilities",
        "TestPlan",
        "TestReport",
        "TestScript",
        "Transport",
        "ValueSet",
        "VerificationResult",
        "VisionPrescription",
      )

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Type : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Version : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "DocumentReference.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the DocumentReference resource type. */
    public val ALL: List<DocumentReferenceSearchParam<*>> =
      listOf(
        Attester,
        Author,
        BasedOn,
        Bodysite,
        BodysiteReference,
        Category,
        Contenttype,
        Context,
        Creation,
        Custodian,
        Date,
        Description,
        DocStatus,
        EventCode,
        EventReference,
        Facility,
        FormatCanonical,
        FormatCode,
        FormatUri,
        Identifier,
        Language,
        Location,
        Modality,
        Patient,
        Period,
        Relatesto,
        Relation,
        Relationship,
        SecurityLabel,
        Setting,
        Status,
        Subject,
        Type,
        Version,
      )
  }
}
