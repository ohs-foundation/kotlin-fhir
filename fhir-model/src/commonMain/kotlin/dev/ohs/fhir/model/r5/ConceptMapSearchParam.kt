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

/** Search parameters for the [ConceptMap] resource type. */
public sealed class ConceptMapSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ConceptMap): List<T>

  public data object Context : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(ConceptMap.useContext.value.ofType(CodeableConcept))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextQuantity : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(ConceptMap.useContext.value.ofType(Quantity))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextType : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ConceptMap.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextTypeValue : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ConceptMap.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Date : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ConceptMap.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object DerivedFrom : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ConceptMap.relatedArtifact.where(type='derived-from').resource"

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

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Description : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ConceptMap.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Effective : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ConceptMap.effectivePeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Identifier : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Jurisdiction : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object MappingProperty : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "mapping-property"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ConceptMap.property.uri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Name : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ConceptMap.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object OtherMap : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "other-map"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ConceptMap.group.unmapped.otherMap"

    public override val target: List<String> = listOf("ConceptMap")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Predecessor : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "predecessor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ConceptMap.relatedArtifact.where(type='predecessor').resource"

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

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Publisher : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ConceptMap.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object SourceCode : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "source-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.group.element.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object SourceGroupSystem : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "source-group-system"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ConceptMap.group.source"

    public override val target: List<String> = listOf("CodeSystem")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object SourceScope : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "source-scope"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(ConceptMap.sourceScope as canonical)"

    public override val target: List<String> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object SourceScopeUri : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "source-scope-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "(ConceptMap.sourceScope as uri)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Status : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object TargetCode : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "target-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.group.element.target.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object TargetGroupSystem : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "target-group-system"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ConceptMap.group.target"

    public override val target: List<String> = listOf("CodeSystem")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object TargetScope : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "target-scope"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(ConceptMap.targetScope as canonical)"

    public override val target: List<String> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object TargetScopeUri : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "target-scope-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "(ConceptMap.targetScope as uri)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Title : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ConceptMap.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Topic : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.topic"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Url : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ConceptMap.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Version : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ConceptMap resource type. */
    public val ALL: List<ConceptMapSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        DerivedFrom,
        Description,
        Effective,
        Identifier,
        Jurisdiction,
        MappingProperty,
        Name,
        OtherMap,
        Predecessor,
        Publisher,
        SourceCode,
        SourceGroupSystem,
        SourceScope,
        SourceScopeUri,
        Status,
        TargetCode,
        TargetGroupSystem,
        TargetScope,
        TargetScopeUri,
        Title,
        Topic,
        Url,
        Version,
      )
  }
}
