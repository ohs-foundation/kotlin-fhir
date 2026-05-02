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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DocumentManifest] resource type. */
public sealed class DocumentManifestSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DocumentManifest): List<T>

  public data object Author : DocumentManifestSearchParam<Reference>() {
    public override val paramName: kotlin.String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentManifest.author"

    public override val target: List<kotlin.String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: DocumentManifest): List<Reference> = resource.author
  }

  public data object Created : DocumentManifestSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "DocumentManifest.created"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentManifest): List<DateTime> =
      listOfNotNull(resource.created)
  }

  public data object Description : DocumentManifestSearchParam<String>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "DocumentManifest.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentManifest): List<String> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : DocumentManifestSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentManifest.masterIdentifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: DocumentManifest
    ): List<dev.ohs.fhir.model.r4b.Identifier> = listOfNotNull(resource.masterIdentifier)
  }

  public data object Item : DocumentManifestSearchParam<Reference>() {
    public override val paramName: kotlin.String = "item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentManifest.content"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: DocumentManifest): List<Reference> = resource.content
  }

  public data object Patient : DocumentManifestSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "DocumentManifest.subject.where(resolve() is Patient)"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: DocumentManifest): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Recipient : DocumentManifestSearchParam<Reference>() {
    public override val paramName: kotlin.String = "recipient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentManifest.recipient"

    public override val target: List<kotlin.String> =
      listOf("Practitioner", "Organization", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: DocumentManifest): List<Reference> = resource.recipient
  }

  public data object RelatedId : DocumentManifestSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "related-id"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentManifest.related.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: DocumentManifest
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.related.mapNotNull { it.identifier }
  }

  public data object RelatedRef : DocumentManifestSearchParam<Reference>() {
    public override val paramName: kotlin.String = "related-ref"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentManifest.related.ref"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: DocumentManifest): List<Reference> =
      resource.related.mapNotNull { it.ref }
  }

  public data object Source : DocumentManifestSearchParam<Uri>() {
    public override val paramName: kotlin.String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "DocumentManifest.source"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentManifest): List<Uri> =
      listOfNotNull(resource.source)
  }

  public data object Status : DocumentManifestSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentManifest.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentManifest): List<Any> = listOf(resource.status)
  }

  public data object Subject : DocumentManifestSearchParam<Reference>() {
    public override val paramName: kotlin.String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentManifest.subject"

    public override val target: List<kotlin.String> =
      listOf("Practitioner", "Group", "Device", "Patient")

    public override fun extract(resource: DocumentManifest): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : DocumentManifestSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentManifest.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentManifest): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public companion object {
    /** All search parameters for the DocumentManifest resource type. */
    public val ALL: List<DocumentManifestSearchParam<*>> =
      listOf(
        Author,
        Created,
        Description,
        Identifier,
        Item,
        Patient,
        Recipient,
        RelatedId,
        RelatedRef,
        Source,
        Status,
        Subject,
        Type,
      )
  }
}
