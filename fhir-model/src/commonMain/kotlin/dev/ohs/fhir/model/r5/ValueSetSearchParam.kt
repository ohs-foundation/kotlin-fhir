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

/** Search parameters for the [ValueSet] resource type. */
public sealed class ValueSetSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ValueSet): List<T>

  public data object Code : ValueSetSearchParam<Any>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.expansion.contains.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> =
      (resource.expansion?.contains ?: emptyList()).mapNotNull { it.code }
  }

  public data object Context : ValueSetSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(ValueSet.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object ContextQuantity : ValueSetSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(ValueSet.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object ContextType : ValueSetSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ValueSetSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ValueSet.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : ValueSetSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ValueSet.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<UsageContext> = resource.useContext
  }

  public data object Date : ValueSetSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ValueSet.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object DerivedFrom : ValueSetSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "ValueSet.relatedArtifact.where(type='derived-from').resource"

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

    public override fun extract(resource: ValueSet): List<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "derived-from" }
        .mapNotNull { it.resource }
  }

  public data object Description : ValueSetSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ValueSet.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : ValueSetSearchParam<Period>() {
    public override val paramName: kotlin.String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ValueSet.effectivePeriod"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Expansion : ValueSetSearchParam<Uri>() {
    public override val paramName: kotlin.String = "expansion"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ValueSet.expansion.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> =
      listOfNotNull(resource.expansion?.identifier)
  }

  public data object Identifier : ValueSetSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : ValueSetSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : ValueSetSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ValueSet.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<String> = listOfNotNull(resource.name)
  }

  public data object Predecessor : ValueSetSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "predecessor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "ValueSet.relatedArtifact.where(type='predecessor').resource"

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

    public override fun extract(resource: ValueSet): List<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "predecessor" }
        .mapNotNull { it.resource }
  }

  public data object Publisher : ValueSetSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ValueSet.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Reference : ValueSetSearchParam<Uri>() {
    public override val paramName: kotlin.String = "reference"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ValueSet.compose.include.system"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> =
      (resource.compose?.include ?: emptyList()).mapNotNull { it.system }
  }

  public data object Status : ValueSetSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = listOf(resource.status)
  }

  public data object Title : ValueSetSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ValueSet.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<String> = listOfNotNull(resource.title)
  }

  public data object Topic : ValueSetSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.topic"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<CodeableConcept> = resource.topic
  }

  public data object Url : ValueSetSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ValueSet.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : ValueSetSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<String> = listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the ValueSet resource type. */
    public val ALL: List<ValueSetSearchParam<*>> =
      listOf(
        Code,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        DerivedFrom,
        Description,
        Effective,
        Expansion,
        Identifier,
        Jurisdiction,
        Name,
        Predecessor,
        Publisher,
        Reference,
        Status,
        Title,
        Topic,
        Url,
        Version,
      )
  }
}
