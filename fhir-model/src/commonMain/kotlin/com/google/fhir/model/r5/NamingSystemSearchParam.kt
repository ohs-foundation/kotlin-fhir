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

/** Search parameters for the [NamingSystem] resource type. */
public sealed class NamingSystemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: NamingSystem): List<T>

  public data object Contact : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.contact.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Context : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(NamingSystem.useContext.value.ofType(CodeableConcept))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextQuantity : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(NamingSystem.useContext.value.ofType(Quantity))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextType : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "NamingSystem.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextTypeValue : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "NamingSystem.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Date : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NamingSystem.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object DerivedFrom : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "NamingSystem.relatedArtifact.where(type='derived-from').resource"

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

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Description : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Effective : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NamingSystem.effectivePeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object IdType : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "id-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.uniqueId.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Identifier : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Jurisdiction : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Kind : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.kind"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Name : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Period : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NamingSystem.uniqueId.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Predecessor : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "predecessor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "NamingSystem.relatedArtifact.where(type='predecessor').resource"

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

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Publisher : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Responsible : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.responsible"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Status : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Telecom : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.contact.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Topic : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.topic"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Type : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Url : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "NamingSystem.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Value : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.uniqueId.value"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Version : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the NamingSystem resource type. */
    public val ALL: List<NamingSystemSearchParam<*>> =
      listOf(
        Contact,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        DerivedFrom,
        Description,
        Effective,
        IdType,
        Identifier,
        Jurisdiction,
        Kind,
        Name,
        Period,
        Predecessor,
        Publisher,
        Responsible,
        Status,
        Telecom,
        Topic,
        Type,
        Url,
        Value,
        Version,
      )
  }
}
