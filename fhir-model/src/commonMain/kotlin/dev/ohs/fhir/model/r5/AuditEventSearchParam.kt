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

/** Search parameters for the [AuditEvent] resource type. */
public sealed class AuditEventSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: AuditEvent): List<T>

  public data object Action : AuditEventSearchParam<Any>() {
    public override val paramName: String = "action"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.action"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = listOfNotNull(resource.action)
  }

  public data object Agent : AuditEventSearchParam<Reference>() {
    public override val paramName: String = "agent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.agent.who"

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

    public override fun extract(resource: AuditEvent): List<Reference> =
      resource.agent.map { it.who }
  }

  public data object AgentRole : AuditEventSearchParam<CodeableConcept>() {
    public override val paramName: String = "agent-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.agent.role"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<CodeableConcept> =
      resource.agent.flatMap { it.role }
  }

  public data object BasedOn : AuditEventSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.basedOn"

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

    public override fun extract(resource: AuditEvent): List<Reference> = resource.basedOn
  }

  public data object Category : AuditEventSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<CodeableConcept> = resource.category
  }

  public data object Code : AuditEventSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<CodeableConcept> = listOf(resource.code)
  }

  public data object Date : AuditEventSearchParam<Instant>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AuditEvent.recorded"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Instant> = listOf(resource.recorded)
  }

  public data object Encounter : AuditEventSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: AuditEvent): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Entity : AuditEventSearchParam<Reference>() {
    public override val paramName: String = "entity"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.entity.what"

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

    public override fun extract(resource: AuditEvent): List<Reference> =
      resource.entity.mapNotNull { it.what }
  }

  public data object EntityRole : AuditEventSearchParam<CodeableConcept>() {
    public override val paramName: String = "entity-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.entity.role"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<CodeableConcept> =
      resource.entity.mapNotNull { it.role }
  }

  public data object Outcome : AuditEventSearchParam<Coding>() {
    public override val paramName: String = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.outcome.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> =
      listOfNotNull(resource.outcome?.code)
  }

  public data object Patient : AuditEventSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: AuditEvent): List<Reference> =
      listOfNotNull(resource.patient)
  }

  public data object Policy : AuditEventSearchParam<Uri>() {
    public override val paramName: String = "policy"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "AuditEvent.agent.policy"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Uri> =
      resource.agent.flatMap { it.policy }
  }

  public data object Purpose : AuditEventSearchParam<CodeableConcept>() {
    public override val paramName: String = "purpose"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.authorization"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<CodeableConcept> =
      resource.authorization
  }

  public data object Source : AuditEventSearchParam<Reference>() {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.source.observer"

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

    public override fun extract(resource: AuditEvent): List<Reference> =
      listOf(resource.source.observer)
  }

  public companion object {
    /** All search parameters for the AuditEvent resource type. */
    public val ALL: List<AuditEventSearchParam<*>> =
      listOf(
        Action,
        Agent,
        AgentRole,
        BasedOn,
        Category,
        Code,
        Date,
        Encounter,
        Entity,
        EntityRole,
        Outcome,
        Patient,
        Policy,
        Purpose,
        Source,
      )
  }
}
