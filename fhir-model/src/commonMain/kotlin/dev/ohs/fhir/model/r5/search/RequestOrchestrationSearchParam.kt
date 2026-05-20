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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RequestOrchestration
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RequestOrchestration] resource type. */
public sealed class RequestOrchestrationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RequestOrchestration): List<T>

  public data object Author : RequestOrchestrationSearchParam<Reference>() {
    public override val paramName: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestOrchestration.author"

    public override val target: List<String> = listOf("Device", "PractitionerRole", "Practitioner")

    public override fun extract(resource: RequestOrchestration): List<Reference> =
      listOfNotNull(resource.author)
  }

  public data object Authored : RequestOrchestrationSearchParam<DateTime>() {
    public override val paramName: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "RequestOrchestration.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestOrchestration): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object BasedOn : RequestOrchestrationSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestOrchestration.basedOn"

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

    public override fun extract(resource: RequestOrchestration): List<Reference> = resource.basedOn
  }

  public data object Code : RequestOrchestrationSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestOrchestration.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestOrchestration): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Encounter : RequestOrchestrationSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestOrchestration.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: RequestOrchestration): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object GroupIdentifier :
    RequestOrchestrationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestOrchestration.groupIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: RequestOrchestration
    ): List<dev.ohs.fhir.model.r5.Identifier> = listOfNotNull(resource.groupIdentifier)
  }

  public data object Identifier :
    RequestOrchestrationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestOrchestration.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: RequestOrchestration
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object InstantiatesCanonical : RequestOrchestrationSearchParam<Canonical>() {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestOrchestration.instantiatesCanonical"

    public override val target: List<String> =
      listOf(
        "ActivityDefinition",
        "ActorDefinition",
        "CapabilityStatement",
        "ChargeItemDefinition",
        "Citation",
        "CodeSystem",
        "CompartmentDefinition",
        "Composition",
        "ConceptMap",
        "ConditionDefinition",
        "Contract",
        "Device",
        "EventDefinition",
        "Evidence",
        "EvidenceReport",
        "EvidenceVariable",
        "ExampleScenario",
        "GraphDefinition",
        "ImplementationGuide",
        "Library",
        "Measure",
        "MessageDefinition",
        "NamingSystem",
        "ObservationDefinition",
        "OperationDefinition",
        "PlanDefinition",
        "Questionnaire",
        "Requirements",
        "ResearchStudy",
        "SearchParameter",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "SubscriptionTopic",
        "TerminologyCapabilities",
        "TestPlan",
        "TestScript",
        "ValueSet",
      )

    public override fun extract(resource: RequestOrchestration): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : RequestOrchestrationSearchParam<Uri>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "RequestOrchestration.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestOrchestration): List<Uri> =
      resource.instantiatesUri
  }

  public data object Intent : RequestOrchestrationSearchParam<Any>() {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestOrchestration.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestOrchestration): List<Any> = listOf(resource.intent)
  }

  public data object Participant : RequestOrchestrationSearchParam<Any>() {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "RequestOrchestration.action.participant.actor.ofType(Reference)"

    public override val target: List<String> =
      listOf(
        "CareTeam",
        "Device",
        "Organization",
        "RelatedPerson",
        "Group",
        "Practitioner",
        "CapabilityStatement",
        "Location",
        "HealthcareService",
        "Endpoint",
        "DeviceDefinition",
        "PractitionerRole",
        "Patient",
      )

    public override fun extract(resource: RequestOrchestration): List<Any> = emptyList()
  }

  public data object Patient : RequestOrchestrationSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "RequestOrchestration.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: RequestOrchestration): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Priority : RequestOrchestrationSearchParam<Any>() {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestOrchestration.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestOrchestration): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Status : RequestOrchestrationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestOrchestration.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestOrchestration): List<Any> = listOf(resource.status)
  }

  public data object Subject : RequestOrchestrationSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestOrchestration.subject"

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

    public override fun extract(resource: RequestOrchestration): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public companion object {
    /** All search parameters for the RequestOrchestration resource type. */
    public val ALL: List<RequestOrchestrationSearchParam<*>> =
      listOf(
        Author,
        Authored,
        BasedOn,
        Code,
        Encounter,
        GroupIdentifier,
        Identifier,
        InstantiatesCanonical,
        InstantiatesUri,
        Intent,
        Participant,
        Patient,
        Priority,
        Status,
        Subject,
      )
  }
}
