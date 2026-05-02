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
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ConceptMap] resource type. */
public sealed class ConceptMapSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ConceptMap): List<T>

  public data object Context : ConceptMapSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(ConceptMap.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextQuantity : ConceptMapSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(ConceptMap.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextType : ConceptMapSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConceptMap.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ConceptMapSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ConceptMap.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : ConceptMapSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ConceptMap.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<UsageContext> = resource.useContext
  }

  public data object Date : ConceptMapSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ConceptMap.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object DerivedFrom : ConceptMapSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "ConceptMap.relatedArtifact.where(type='derived-from').resource"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: ConceptMap): List<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "derived-from" }
        .mapNotNull { it.resource }
  }

  public data object Description : ConceptMapSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ConceptMap.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : ConceptMapSearchParam<Period>() {
    public override val paramName: kotlin.String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ConceptMap.effectivePeriod"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier : ConceptMapSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConceptMap.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : ConceptMapSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConceptMap.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<CodeableConcept> = resource.jurisdiction
  }

  public data object MappingProperty : ConceptMapSearchParam<Uri>() {
    public override val paramName: kotlin.String = "mapping-property"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ConceptMap.property.uri"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      resource.property.mapNotNull { it.uri }
  }

  public data object Name : ConceptMapSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ConceptMap.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<String> = listOfNotNull(resource.name)
  }

  public data object OtherMap : ConceptMapSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "other-map"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ConceptMap.group.unmapped.otherMap"

    public override val target: List<kotlin.String> = listOf("ConceptMap")

    public override fun extract(resource: ConceptMap): List<Canonical> =
      resource.group.mapNotNull { it.unmapped }.mapNotNull { it.otherMap }
  }

  public data object Predecessor : ConceptMapSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "predecessor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "ConceptMap.relatedArtifact.where(type='predecessor').resource"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: ConceptMap): List<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "predecessor" }
        .mapNotNull { it.resource }
  }

  public data object Publisher : ConceptMapSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ConceptMap.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object SourceCode : ConceptMapSearchParam<Any>() {
    public override val paramName: kotlin.String = "source-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConceptMap.group.element.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> =
      resource.group.flatMap { it.element }.mapNotNull { it.code }
  }

  public data object SourceGroupSystem : ConceptMapSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "source-group-system"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ConceptMap.group.source"

    public override val target: List<kotlin.String> = listOf("CodeSystem")

    public override fun extract(resource: ConceptMap): List<Canonical> =
      resource.group.mapNotNull { it.source }
  }

  public data object SourceScope : ConceptMapSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "source-scope"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "(ConceptMap.sourceScope as canonical)"

    public override val target: List<kotlin.String> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Canonical> =
      listOfNotNull((resource.sourceScope as? ConceptMap.SourceScope.Canonical)?.value)
  }

  public data object SourceScopeUri : ConceptMapSearchParam<Uri>() {
    public override val paramName: kotlin.String = "source-scope-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "(ConceptMap.sourceScope as uri)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      listOfNotNull((resource.sourceScope as? ConceptMap.SourceScope.Uri)?.value)
  }

  public data object Status : ConceptMapSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConceptMap.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = listOf(resource.status)
  }

  public data object TargetCode : ConceptMapSearchParam<Any>() {
    public override val paramName: kotlin.String = "target-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConceptMap.group.element.target.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> =
      resource.group.flatMap { it.element }.flatMap { it.target }.mapNotNull { it.code }
  }

  public data object TargetGroupSystem : ConceptMapSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "target-group-system"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ConceptMap.group.target"

    public override val target: List<kotlin.String> = listOf("CodeSystem")

    public override fun extract(resource: ConceptMap): List<Canonical> =
      resource.group.mapNotNull { it.target }
  }

  public data object TargetScope : ConceptMapSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "target-scope"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "(ConceptMap.targetScope as canonical)"

    public override val target: List<kotlin.String> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Canonical> =
      listOfNotNull((resource.targetScope as? ConceptMap.TargetScope.Canonical)?.value)
  }

  public data object TargetScopeUri : ConceptMapSearchParam<Uri>() {
    public override val paramName: kotlin.String = "target-scope-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "(ConceptMap.targetScope as uri)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      listOfNotNull((resource.targetScope as? ConceptMap.TargetScope.Uri)?.value)
  }

  public data object Title : ConceptMapSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ConceptMap.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<String> = listOfNotNull(resource.title)
  }

  public data object Topic : ConceptMapSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConceptMap.topic"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<CodeableConcept> = resource.topic
  }

  public data object Url : ConceptMapSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ConceptMap.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : ConceptMapSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConceptMap.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConceptMap): List<String> =
      listOfNotNull(resource.version)
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
