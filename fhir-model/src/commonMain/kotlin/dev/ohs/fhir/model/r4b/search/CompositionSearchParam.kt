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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Composition
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Composition] resource type. */
public sealed class CompositionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Composition): List<T>

  public data object Attester : CompositionSearchParam<Reference>() {
    public override val paramName: KotlinString = "attester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Composition.attester.party"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Composition): List<Reference> =
      resource.attester.mapNotNull { it.party }
  }

  public data object Author : CompositionSearchParam<Reference>() {
    public override val paramName: KotlinString = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Composition.author"

    public override val target: List<KotlinString> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: Composition): List<Reference> = resource.author
  }

  public data object Category : CompositionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Composition.category"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<CodeableConcept> = resource.category
  }

  public data object Confidentiality : CompositionSearchParam<Any>() {
    public override val paramName: KotlinString = "confidentiality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Composition.confidentiality"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<Any> =
      listOfNotNull(resource.confidentiality)
  }

  public data object Context : CompositionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Composition.event.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<CodeableConcept> =
      resource.event.flatMap { it.code }
  }

  public data object Date : CompositionSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Composition.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<DateTime> = listOf(resource.date)
  }

  public data object Encounter : CompositionSearchParam<Reference>() {
    public override val paramName: KotlinString = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Composition.encounter"

    public override val target: List<KotlinString> = listOf("Encounter")

    public override fun extract(resource: Composition): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Entry : CompositionSearchParam<Reference>() {
    public override val paramName: KotlinString = "entry"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Composition.section.entry"

    public override val target: List<KotlinString> =
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

    public override fun extract(resource: Composition): List<Reference> =
      resource.section.flatMap { it.entry }
  }

  public data object Identifier : CompositionSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Composition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<dev.ohs.fhir.model.r4b.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Patient : CompositionSearchParam<Reference>() {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Composition.subject.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Composition): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : CompositionSearchParam<dev.ohs.fhir.model.r4b.Period>() {
    public override val paramName: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Composition.event.period"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<dev.ohs.fhir.model.r4b.Period> =
      resource.event.mapNotNull { it.period }
  }

  public data object RelatedId : CompositionSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: KotlinString = "related-id"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Composition.relatesTo.target as Identifier)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.relatesTo.mapNotNull {
        (it.target as? Composition.RelatesTo.Target.Identifier)?.value
      }
  }

  public data object RelatedRef : CompositionSearchParam<Reference>() {
    public override val paramName: KotlinString = "related-ref"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(Composition.relatesTo.target as Reference)"

    public override val target: List<KotlinString> = listOf("Composition")

    public override fun extract(resource: Composition): List<Reference> =
      resource.relatesTo.mapNotNull {
        (it.target as? Composition.RelatesTo.Target.Reference)?.value
      }
  }

  public data object Section : CompositionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "section"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Composition.section.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<CodeableConcept> =
      resource.section.mapNotNull { it.code }
  }

  public data object Status : CompositionSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Composition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<Any> = listOf(resource.status)
  }

  public data object Subject : CompositionSearchParam<Reference>() {
    public override val paramName: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Composition.subject"

    public override val target: List<KotlinString> =
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

    public override fun extract(resource: Composition): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Title : CompositionSearchParam<R4bString>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Composition.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<R4bString> = listOf(resource.title)
  }

  public data object Type : CompositionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Composition.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Composition): List<CodeableConcept> =
      listOf(resource.type)
  }

  public companion object {
    /** All search parameters for the Composition resource type. */
    public val ALL: List<CompositionSearchParam<*>> =
      listOf(
        Attester,
        Author,
        Category,
        Confidentiality,
        Context,
        Date,
        Encounter,
        Entry,
        Identifier,
        Patient,
        Period,
        RelatedId,
        RelatedRef,
        Section,
        Status,
        Subject,
        Title,
        Type,
      )
  }
}
