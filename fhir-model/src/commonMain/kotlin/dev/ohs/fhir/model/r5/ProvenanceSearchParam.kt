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
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Provenance] resource type. */
public sealed class ProvenanceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Provenance): List<T>

  public data object Activity : ProvenanceSearchParam<CodeableConcept>() {
    public override val paramName: String = "activity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Provenance.activity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Provenance): List<CodeableConcept> =
      listOfNotNull(resource.activity)
  }

  public data object Agent : ProvenanceSearchParam<Reference>() {
    public override val paramName: String = "agent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Provenance.agent.who"

    public override val target: List<String> =
      listOf(
        "Organization",
        "CareTeam",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Provenance): List<Reference> =
      resource.agent.map { it.who }
  }

  public data object AgentRole : ProvenanceSearchParam<CodeableConcept>() {
    public override val paramName: String = "agent-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Provenance.agent.role"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Provenance): List<CodeableConcept> =
      resource.agent.flatMap { it.role }
  }

  public data object AgentType : ProvenanceSearchParam<CodeableConcept>() {
    public override val paramName: String = "agent-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Provenance.agent.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Provenance): List<CodeableConcept> =
      resource.agent.mapNotNull { it.type }
  }

  public data object BasedOn : ProvenanceSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Provenance.basedOn"

    public override val target: List<String> =
      listOf(
        "DeviceRequest",
        "ServiceRequest",
        "CarePlan",
        "Task",
        "MedicationRequest",
        "ImmunizationRecommendation",
        "NutritionOrder",
      )

    public override fun extract(resource: Provenance): List<Reference> = resource.basedOn
  }

  public data object Encounter : ProvenanceSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Provenance.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Provenance): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Entity : ProvenanceSearchParam<Reference>() {
    public override val paramName: String = "entity"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Provenance.entity.what"

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

    public override fun extract(resource: Provenance): List<Reference> =
      resource.entity.map { it.what }
  }

  public data object Location : ProvenanceSearchParam<Reference>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Provenance.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Provenance): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object Patient : ProvenanceSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Provenance.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Provenance): List<Reference> =
      listOfNotNull(resource.patient)
  }

  public data object Recorded : ProvenanceSearchParam<Instant>() {
    public override val paramName: String = "recorded"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Provenance.recorded"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Provenance): List<Instant> =
      listOfNotNull(resource.recorded)
  }

  public data object SignatureType : ProvenanceSearchParam<Coding>() {
    public override val paramName: String = "signature-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Provenance.signature.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Provenance): List<Coding> =
      resource.signature.flatMap { it.type }
  }

  public data object Target : ProvenanceSearchParam<Reference>() {
    public override val paramName: String = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Provenance.target"

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

    public override fun extract(resource: Provenance): List<Reference> = resource.target
  }

  public data object When : ProvenanceSearchParam<Any>() {
    public override val paramName: String = "when"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(Provenance.occurred.ofType(dateTime))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Provenance): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Provenance resource type. */
    public val ALL: List<ProvenanceSearchParam<*>> =
      listOf(
        Activity,
        Agent,
        AgentRole,
        AgentType,
        BasedOn,
        Encounter,
        Entity,
        Location,
        Patient,
        Recorded,
        SignatureType,
        Target,
        When,
      )
  }
}
