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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.ImmunizationRecommendation
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImmunizationRecommendation] resource type. */
public sealed class ImmunizationRecommendationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ImmunizationRecommendation): List<T>

  public data object Date : ImmunizationRecommendationSearchParam<DateTime>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImmunizationRecommendation.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationRecommendation): List<DateTime> =
      listOf(resource.date)
  }

  public data object Identifier :
    ImmunizationRecommendationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImmunizationRecommendation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ImmunizationRecommendation
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Information : ImmunizationRecommendationSearchParam<Reference>() {
    public override val paramName: String = "information"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ImmunizationRecommendation.recommendation.supportingPatientInformation"

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

    public override fun extract(resource: ImmunizationRecommendation): List<Reference> =
      resource.recommendation.flatMap { it.supportingPatientInformation }
  }

  public data object Patient : ImmunizationRecommendationSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImmunizationRecommendation.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ImmunizationRecommendation): List<Reference> =
      listOf(resource.patient)
  }

  public data object Status : ImmunizationRecommendationSearchParam<CodeableConcept>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ImmunizationRecommendation.recommendation.forecastStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationRecommendation): List<CodeableConcept> =
      resource.recommendation.map { it.forecastStatus }
  }

  public data object Support : ImmunizationRecommendationSearchParam<Reference>() {
    public override val paramName: String = "support"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ImmunizationRecommendation.recommendation.supportingImmunization"

    public override val target: List<String> = listOf("ImmunizationEvaluation", "Immunization")

    public override fun extract(resource: ImmunizationRecommendation): List<Reference> =
      resource.recommendation.flatMap { it.supportingImmunization }
  }

  public data object TargetDisease : ImmunizationRecommendationSearchParam<CodeableConcept>() {
    public override val paramName: String = "target-disease"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ImmunizationRecommendation.recommendation.targetDisease"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationRecommendation): List<CodeableConcept> =
      resource.recommendation.flatMap { it.targetDisease }
  }

  public data object VaccineType : ImmunizationRecommendationSearchParam<CodeableConcept>() {
    public override val paramName: String = "vaccine-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImmunizationRecommendation.recommendation.vaccineCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationRecommendation): List<CodeableConcept> =
      resource.recommendation.flatMap { it.vaccineCode }
  }

  public companion object {
    /** All search parameters for the ImmunizationRecommendation resource type. */
    public val ALL: List<ImmunizationRecommendationSearchParam<*>> =
      listOf(Date, Identifier, Information, Patient, Status, Support, TargetDisease, VaccineType)
  }
}
