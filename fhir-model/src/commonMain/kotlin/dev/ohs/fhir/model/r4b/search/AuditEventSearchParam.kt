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

import dev.ohs.fhir.model.r4b.AuditEvent
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AuditEvent] resource type. */
public object AuditEventSearchParam {
  /** All search parameters for the AuditEvent resource type. */
  public val ALL: List<SearchParam<AuditEvent, *>> =
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

  public data object Action : SearchParam<AuditEvent, Any> {
    public override val paramName: KotlinString = "action"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.action"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = listOfNotNull(resource.action)
  }

  public data object Address : SearchParam<AuditEvent, R4bString> {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "AuditEvent.agent.network.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<R4bString> =
      resource.agent.mapNotNull { it.network }.mapNotNull { it.address }
  }

  public data object Agent : SearchParam<AuditEvent, Reference> {
    public override val paramName: KotlinString = "agent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "AuditEvent.agent.who"

    public override val target: List<KotlinString> =
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

  public data object AgentName : SearchParam<AuditEvent, R4bString> {
    public override val paramName: KotlinString = "agent-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "AuditEvent.agent.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<R4bString> =
      resource.agent.mapNotNull { it.name }
  }

  public data object AgentRole : SearchParam<AuditEvent, CodeableConcept> {
    public override val paramName: KotlinString = "agent-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.agent.role"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<CodeableConcept> =
      resource.agent.flatMap { it.role }
  }

  public data object Altid : SearchParam<AuditEvent, R4bString> {
    public override val paramName: KotlinString = "altid"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.agent.altId"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<R4bString> =
      resource.agent.mapNotNull { it.altId }
  }

  public data object Date : SearchParam<AuditEvent, Instant> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "AuditEvent.recorded"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<Instant> = listOf(resource.recorded)
  }

  public data object Entity : SearchParam<AuditEvent, Reference> {
    public override val paramName: KotlinString = "entity"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "AuditEvent.entity.what"

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

    public override fun extract(resource: AuditEvent): List<Reference> =
      resource.entity.mapNotNull { it.what }
  }

  public data object EntityName : SearchParam<AuditEvent, R4bString> {
    public override val paramName: KotlinString = "entity-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "AuditEvent.entity.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<R4bString> =
      resource.entity.mapNotNull { it.name }
  }

  public data object EntityRole : SearchParam<AuditEvent, Coding> {
    public override val paramName: KotlinString = "entity-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.entity.role"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> =
      resource.entity.mapNotNull { it.role }
  }

  public data object EntityType : SearchParam<AuditEvent, Coding> {
    public override val paramName: KotlinString = "entity-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.entity.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> =
      resource.entity.mapNotNull { it.type }
  }

  public data object Outcome : SearchParam<AuditEvent, Any> {
    public override val paramName: KotlinString = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.outcome"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<Any> = listOfNotNull(resource.outcome)
  }

  public data object Patient : SearchParam<AuditEvent, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "AuditEvent.agent.who.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: AuditEvent): List<Reference> =
      resource.agent
        .mapNotNull { it.who }
        .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Policy : SearchParam<AuditEvent, Uri> {
    public override val paramName: KotlinString = "policy"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "AuditEvent.agent.policy"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<Uri> =
      resource.agent.flatMap { it.policy }
  }

  public data object Site : SearchParam<AuditEvent, R4bString> {
    public override val paramName: KotlinString = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.source.site"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<R4bString> =
      listOfNotNull(resource.source.site)
  }

  public data object Source : SearchParam<AuditEvent, Reference> {
    public override val paramName: KotlinString = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "AuditEvent.source.observer"

    public override val target: List<KotlinString> =
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

  public data object Subtype : SearchParam<AuditEvent, Coding> {
    public override val paramName: KotlinString = "subtype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.subtype"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> = resource.subtype
  }

  public data object Type : SearchParam<AuditEvent, Coding> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "AuditEvent.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: AuditEvent): List<Coding> = listOf(resource.type)
  }
}
