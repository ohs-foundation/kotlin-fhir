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

/** Search parameters for the [VerificationResult] resource type. */
public sealed class VerificationResultSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: VerificationResult): List<T>

  public data object AttestationMethod : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "attestation-method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "VerificationResult.attestation.communicationMethod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object AttestationOnbehalfof : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "attestation-onbehalfof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VerificationResult.attestation.onBehalfOf"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object AttestationWho : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "attestation-who"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VerificationResult.attestation.who"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object PrimarysourceDate : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "primarysource-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "VerificationResult.primarySource.validationDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object PrimarysourceType : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "primarysource-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "VerificationResult.primarySource.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object PrimarysourceWho : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "primarysource-who"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VerificationResult.primarySource.who"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object Status : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "VerificationResult.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object StatusDate : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "status-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "VerificationResult.statusDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object Target : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VerificationResult.target"

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

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public data object ValidatorOrganization : VerificationResultSearchParam<Any>() {
    public override val paramName: String = "validator-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VerificationResult.validator.organization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: VerificationResult): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the VerificationResult resource type. */
    public val ALL: List<VerificationResultSearchParam<*>> =
      listOf(
        AttestationMethod,
        AttestationOnbehalfof,
        AttestationWho,
        PrimarysourceDate,
        PrimarysourceType,
        PrimarysourceWho,
        Status,
        StatusDate,
        Target,
        ValidatorOrganization,
      )
  }
}
