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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
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

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Address : AuditEventSearchParam<Any>() {
    public override val paramName: String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "AuditEvent.agent.network.address"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Agent : AuditEventSearchParam<Any>() {
    public override val paramName: String = "agent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.agent.who"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object AgentName : AuditEventSearchParam<Any>() {
    public override val paramName: String = "agent-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "AuditEvent.agent.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object AgentRole : AuditEventSearchParam<Any>() {
    public override val paramName: String = "agent-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.agent.role"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Altid : AuditEventSearchParam<Any>() {
    public override val paramName: String = "altid"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.agent.altId"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Date : AuditEventSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AuditEvent.recorded"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Entity : AuditEventSearchParam<Any>() {
    public override val paramName: String = "entity"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.entity.what"

    public override val target: List<String> =
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

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object EntityName : AuditEventSearchParam<Any>() {
    public override val paramName: String = "entity-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "AuditEvent.entity.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object EntityRole : AuditEventSearchParam<Any>() {
    public override val paramName: String = "entity-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.entity.role"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object EntityType : AuditEventSearchParam<Any>() {
    public override val paramName: String = "entity-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.entity.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Outcome : AuditEventSearchParam<Any>() {
    public override val paramName: String = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.outcome"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Patient : AuditEventSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.agent.who.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Policy : AuditEventSearchParam<Any>() {
    public override val paramName: String = "policy"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "AuditEvent.agent.policy"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Site : AuditEventSearchParam<Any>() {
    public override val paramName: String = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.source.site"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Source : AuditEventSearchParam<Any>() {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AuditEvent.source.observer"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Subtype : AuditEventSearchParam<Any>() {
    public override val paramName: String = "subtype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.subtype"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public data object Type : AuditEventSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AuditEvent.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the AuditEvent resource type. */
    public val ALL: List<AuditEventSearchParam<*>> =
      listOf(
        Action,
        Address,
        Agent,
        AgentName,
        AgentRole,
        Altid,
        Date,
        Entity,
        EntityName,
        EntityRole,
        EntityType,
        Outcome,
        Patient,
        Policy,
        Site,
        Source,
        Subtype,
        Type,
      )
  }
}
