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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AuditEvent] resource type. */
public sealed class AuditEventSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: AuditEvent): List<T>

  public data object Action : AuditEventSearchParam<Any>() {
    public override val paramName: kotlin.String = "action"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.action"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = listOfNotNull(resource.action)
  }

  public data object Address : AuditEventSearchParam<String>() {
    public override val paramName: kotlin.String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "AuditEvent.agent.network.address"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<String> =
      resource.agent.mapNotNull { it.network }.mapNotNull { it.address }
  }

  public data object Agent : AuditEventSearchParam<Reference>() {
    public override val paramName: kotlin.String = "agent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "AuditEvent.agent.who"

    public override val target: List<kotlin.String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: AuditEvent): List<Reference> =
      resource.agent.mapNotNull { it.who }
  }

  public data object AgentName : AuditEventSearchParam<String>() {
    public override val paramName: kotlin.String = "agent-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "AuditEvent.agent.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<String> =
      resource.agent.mapNotNull { it.name }
  }

  public data object AgentRole : AuditEventSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "agent-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.agent.role"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<CodeableConcept> =
      resource.agent.flatMap { it.role }
  }

  public data object Altid : AuditEventSearchParam<String>() {
    public override val paramName: kotlin.String = "altid"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.agent.altId"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<String> =
      resource.agent.mapNotNull { it.altId }
  }

  public data object Date : AuditEventSearchParam<Instant>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "AuditEvent.recorded"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Instant> = listOf(resource.recorded)
  }

  public data object Entity : AuditEventSearchParam<Reference>() {
    public override val paramName: kotlin.String = "entity"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "AuditEvent.entity.what"

    public override val target: List<kotlin.String> =
      listOf(
        "Account",
        "ActivityDefinition",
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
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
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
        "EffectEvidenceSynthesis",
        "Encounter",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
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
        "InsurancePlan",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "Measure",
        "MeasureReport",
        "Media",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProduct",
        "MedicinalProductAuthorization",
        "MedicinalProductContraindication",
        "MedicinalProductIndication",
        "MedicinalProductIngredient",
        "MedicinalProductInteraction",
        "MedicinalProductManufactured",
        "MedicinalProductPackaged",
        "MedicinalProductPharmaceutical",
        "MedicinalProductUndesirableEffect",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionOrder",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
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
        "RelatedPerson",
        "RequestGroup",
        "ResearchDefinition",
        "ResearchElementDefinition",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "RiskEvidenceSynthesis",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "Substance",
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SubstanceSpecification",
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

    public override fun extract(resource: AuditEvent): List<Reference> =
      resource.entity.mapNotNull { it.what }
  }

  public data object EntityName : AuditEventSearchParam<String>() {
    public override val paramName: kotlin.String = "entity-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "AuditEvent.entity.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<String> =
      resource.entity.mapNotNull { it.name }
  }

  public data object EntityRole : AuditEventSearchParam<Coding>() {
    public override val paramName: kotlin.String = "entity-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.entity.role"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> =
      resource.entity.mapNotNull { it.role }
  }

  public data object EntityType : AuditEventSearchParam<Coding>() {
    public override val paramName: kotlin.String = "entity-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.entity.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> =
      resource.entity.mapNotNull { it.type }
  }

  public data object Outcome : AuditEventSearchParam<Any>() {
    public override val paramName: kotlin.String = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.outcome"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = listOfNotNull(resource.outcome)
  }

  public data object Patient : AuditEventSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "AuditEvent.agent.who.where(resolve() is Patient)"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: AuditEvent): List<Reference> =
      resource.agent
        .mapNotNull { it.who }
        .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Policy : AuditEventSearchParam<Uri>() {
    public override val paramName: kotlin.String = "policy"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "AuditEvent.agent.policy"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Uri> =
      resource.agent.flatMap { it.policy }
  }

  public data object Site : AuditEventSearchParam<String>() {
    public override val paramName: kotlin.String = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.source.site"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<String> =
      listOfNotNull(resource.source.site)
  }

  public data object Source : AuditEventSearchParam<Reference>() {
    public override val paramName: kotlin.String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "AuditEvent.source.observer"

    public override val target: List<kotlin.String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: AuditEvent): List<Reference> =
      listOf(resource.source.observer)
  }

  public data object Subtype : AuditEventSearchParam<Coding>() {
    public override val paramName: kotlin.String = "subtype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.subtype"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> = resource.subtype
  }

  public data object Type : AuditEventSearchParam<Coding>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "AuditEvent.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> = listOf(resource.type)
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
