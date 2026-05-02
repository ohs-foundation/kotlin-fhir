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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DocumentReference] resource type. */
public sealed class DocumentReferenceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DocumentReference): List<T>

  public data object Attester : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "attester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.attester.party"

    public override val target: List<kotlin.String> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.attester.mapNotNull { it.party }
  }

  public data object Author : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.author"

    public override val target: List<kotlin.String> =
      listOf(
        "Organization",
        "Device",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: DocumentReference): List<Reference> = resource.author
  }

  public data object BasedOn : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.basedOn"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: DocumentReference): List<Reference> = resource.basedOn
  }

  public data object Bodysite : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "bodysite"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.bodySite.concept"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.bodySite.mapNotNull { it.concept }
  }

  public data object BodysiteReference : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "bodysite-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.bodySite.reference"

    public override val target: List<kotlin.String> = listOf("BodyStructure")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.bodySite.mapNotNull { it.reference }
  }

  public data object Category : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.category
  }

  public data object Contenttype : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "contenttype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "DocumentReference.content.attachment.contentType"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.contentType }
  }

  public data object Context : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.context"

    public override val target: List<kotlin.String> =
      listOf("Appointment", "Encounter", "EpisodeOfCare")

    public override fun extract(resource: DocumentReference): List<Reference> = resource.context
  }

  public data object Creation : DocumentReferenceSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "creation"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "DocumentReference.content.attachment.creation"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<DateTime> =
      resource.content.map { it.attachment }.mapNotNull { it.creation }
  }

  public data object Custodian : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "custodian"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.custodian"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.custodian)
  }

  public data object Date : DocumentReferenceSearchParam<Instant>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "DocumentReference.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Instant> =
      listOfNotNull(resource.date)
  }

  public data object Description : DocumentReferenceSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "DocumentReference.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object DocStatus : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "doc-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.docStatus"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      listOfNotNull(resource.docStatus)
  }

  public data object EventCode : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "event-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.event.concept"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.event.mapNotNull { it.concept }
  }

  public data object EventReference : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "event-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.event.reference"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.event.mapNotNull { it.reference }
  }

  public data object Facility : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.facilityType"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.facilityType)
  }

  public data object FormatCanonical : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "format-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "(DocumentReference.content.profile.value.ofType(canonical))"

    public override val target: List<kotlin.String> =
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
    public override val paramName: kotlin.String = "format-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(DocumentReference.content.profile.value.ofType(Coding))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object FormatUri : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "format-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String =
      "(DocumentReference.content.profile.value.ofType(uri))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Identifier : DocumentReferenceSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Language : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.content.attachment.language"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.language }
  }

  public data object Location : DocumentReferenceSearchParam<Url>() {
    public override val paramName: kotlin.String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "DocumentReference.content.attachment.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Url> =
      resource.content.map { it.attachment }.mapNotNull { it.url }
  }

  public data object Modality : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.modality"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.modality
  }

  public data object Patient : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : DocumentReferenceSearchParam<dev.ohs.fhir.model.r5.Period>() {
    public override val paramName: kotlin.String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "DocumentReference.period"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<dev.ohs.fhir.model.r5.Period> =
      listOfNotNull(resource.period)
  }

  public data object Relatesto : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "relatesto"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.relatesTo.target"

    public override val target: List<kotlin.String> = listOf("DocumentReference")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.relatesTo.map { it.target }
  }

  public data object Relation : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.relatesTo.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.relatesTo.map { it.code }
  }

  public data object Relationship : DocumentReferenceSearchParam<DocumentReference.RelatesTo>() {
    public override val paramName: kotlin.String = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "DocumentReference.relatesTo"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<DocumentReference.RelatesTo> =
      resource.relatesTo
  }

  public data object SecurityLabel : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.securityLabel"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.securityLabel
  }

  public data object Setting : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "setting"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.practiceSetting"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.practiceSetting)
  }

  public data object Status : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = listOf(resource.status)
  }

  public data object Subject : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.subject"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Version : DocumentReferenceSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "DocumentReference.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<String> =
      listOfNotNull(resource.version)
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
