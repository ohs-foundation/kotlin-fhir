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

/** Search parameters for the [MeasureReport] resource type. */
public sealed class MeasureReportSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MeasureReport): List<T>

  public data object Date : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MeasureReport.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object EvaluatedResource : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "evaluated-resource"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.evaluatedResource"

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

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object Identifier : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MeasureReport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object Location : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object Measure : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "measure"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.measure"

    public override val target: List<String> = listOf("Measure")

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object Patient : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object Period : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MeasureReport.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object Reporter : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "reporter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.reporter"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner", "Group")

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object Status : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MeasureReport.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public data object Subject : MeasureReportSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.subject"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "CareTeam",
        "Device",
        "Organization",
        "RelatedPerson",
        "PractitionerRole",
        "Group",
        "Practitioner",
        "Location",
        "Patient",
      )

    public override fun extract(resource: MeasureReport): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the MeasureReport resource type. */
    public val ALL: List<MeasureReportSearchParam<*>> =
      listOf(
        Date,
        EvaluatedResource,
        Identifier,
        Location,
        Measure,
        Patient,
        Period,
        Reporter,
        Status,
        Subject,
      )
  }
}
