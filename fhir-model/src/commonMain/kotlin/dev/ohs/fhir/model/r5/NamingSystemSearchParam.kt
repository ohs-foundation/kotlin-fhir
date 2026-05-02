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

/** Search parameters for the [NamingSystem] resource type. */
public sealed class NamingSystemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: NamingSystem): List<T>

  public data object Contact : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.contact.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      resource.contact.mapNotNull { it.name }
  }

  public data object Context : NamingSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(NamingSystem.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextQuantity : NamingSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(NamingSystem.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextType : NamingSystemSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : NamingSystemSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "NamingSystem.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : NamingSystemSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "NamingSystem.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<UsageContext> = resource.useContext
  }

  public data object Date : NamingSystemSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "NamingSystem.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<DateTime> = listOf(resource.date)
  }

  public data object DerivedFrom : NamingSystemSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "NamingSystem.relatedArtifact.where(type='derived-from').resource"

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

    public override fun extract(resource: NamingSystem): List<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "derived-from" }
        .mapNotNull { it.resource }
  }

  public data object Description : NamingSystemSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : NamingSystemSearchParam<dev.ohs.fhir.model.r5.Period>() {
    public override val paramName: kotlin.String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "NamingSystem.effectivePeriod"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<dev.ohs.fhir.model.r5.Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object IdType : NamingSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "id-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.uniqueId.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> =
      resource.uniqueId.map { it.type }
  }

  public data object Identifier : NamingSystemSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : NamingSystemSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Kind : NamingSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.kind"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = listOf(resource.kind)
  }

  public data object Name : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> = listOf(resource.name)
  }

  public data object Period : NamingSystemSearchParam<dev.ohs.fhir.model.r5.Period>() {
    public override val paramName: kotlin.String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "NamingSystem.uniqueId.period"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<dev.ohs.fhir.model.r5.Period> =
      resource.uniqueId.mapNotNull { it.period }
  }

  public data object Predecessor : NamingSystemSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "predecessor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "NamingSystem.relatedArtifact.where(type='predecessor').resource"

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

    public override fun extract(resource: NamingSystem): List<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "predecessor" }
        .mapNotNull { it.resource }
  }

  public data object Publisher : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Responsible : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.responsible"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      listOfNotNull(resource.responsible)
  }

  public data object Status : NamingSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = listOf(resource.status)
  }

  public data object Telecom : NamingSystemSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.contact.telecom"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<ContactPoint> =
      resource.contact.flatMap { it.telecom }
  }

  public data object Topic : NamingSystemSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.topic"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> = resource.topic
  }

  public data object Type : NamingSystemSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Url : NamingSystemSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "NamingSystem.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Value : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.uniqueId.value"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      resource.uniqueId.map { it.value }
  }

  public data object Version : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      listOfNotNull(resource.version)
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
