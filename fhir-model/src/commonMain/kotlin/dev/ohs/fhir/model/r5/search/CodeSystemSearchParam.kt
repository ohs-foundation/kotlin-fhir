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
import dev.ohs.fhir.model.r5.CodeSystem
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CodeSystem] resource type. */
public object CodeSystemSearchParam {
  /** All search parameters for the CodeSystem resource type. */
  public val ALL: List<SearchParam<CodeSystem, *>> =
    listOf(
      Code,
      ContentMode,
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
      Language,
      Name,
      Predecessor,
      Publisher,
      Status,
      Supplements,
      System,
      Title,
      Topic,
      Url,
      Version,
    )

  public data object Code : SearchParam<CodeSystem, Any> {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.concept.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = resource.concept.map { it.code }
  }

  public data object ContentMode : SearchParam<CodeSystem, Any> {
    public override val paramName: KotlinString = "content-mode"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.content"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = listOf(resource.content)
  }

  public data object Context : SearchParam<CodeSystem, Any> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(CodeSystem.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<CodeSystem, Any> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(CodeSystem.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<CodeSystem, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<CodeSystem, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "CodeSystem.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<CodeSystem, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "CodeSystem.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<CodeSystem, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "CodeSystem.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object DerivedFrom : SearchParam<CodeSystem, Canonical> {
    public override val paramName: KotlinString = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "CodeSystem.relatedArtifact.where(type='derived-from').resource"

    public override val target: List<KotlinString> =
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

    public override fun extract(resource: CodeSystem): List<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "derived-from" }
        .mapNotNull { it.resource }
  }

  public data object Description : SearchParam<CodeSystem, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CodeSystem.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : SearchParam<CodeSystem, Period> {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "CodeSystem.effectivePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier : SearchParam<CodeSystem, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<CodeSystem, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Language : SearchParam<CodeSystem, Any> {
    public override val paramName: KotlinString = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.concept.designation.language"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> =
      resource.concept.flatMap { it.designation }.mapNotNull { it.language }
  }

  public data object Name : SearchParam<CodeSystem, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CodeSystem.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<R5String> = listOfNotNull(resource.name)
  }

  public data object Predecessor : SearchParam<CodeSystem, Canonical> {
    public override val paramName: KotlinString = "predecessor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "CodeSystem.relatedArtifact.where(type='predecessor').resource"

    public override val target: List<KotlinString> =
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

    public override fun extract(resource: CodeSystem): List<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "predecessor" }
        .mapNotNull { it.resource }
  }

  public data object Publisher : SearchParam<CodeSystem, R5String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CodeSystem.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<CodeSystem, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = listOf(resource.status)
  }

  public data object Supplements : SearchParam<CodeSystem, Canonical> {
    public override val paramName: KotlinString = "supplements"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "CodeSystem.supplements"

    public override val target: List<KotlinString> = listOf("CodeSystem")

    public override fun extract(resource: CodeSystem): List<Canonical> =
      listOfNotNull(resource.supplements)
  }

  public data object System : SearchParam<CodeSystem, Uri> {
    public override val paramName: KotlinString = "system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "CodeSystem.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Title : SearchParam<CodeSystem, R5String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CodeSystem.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Topic : SearchParam<CodeSystem, CodeableConcept> {
    public override val paramName: KotlinString = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.topic"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<CodeableConcept> = resource.topic
  }

  public data object Url : SearchParam<CodeSystem, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "CodeSystem.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<CodeSystem, R5String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CodeSystem.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CodeSystem): List<R5String> =
      listOfNotNull(resource.version)
  }
}
