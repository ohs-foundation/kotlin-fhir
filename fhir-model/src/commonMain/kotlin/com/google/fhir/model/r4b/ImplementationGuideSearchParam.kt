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

/** Search parameters for the [ImplementationGuide] resource type. */
public sealed class ImplementationGuideSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ImplementationGuide): List<T>

  public data object Context : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(ImplementationGuide.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object ContextQuantity : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(ImplementationGuide.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object ContextType : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImplementationGuide.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ImplementationGuide.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object ContextTypeValue : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ImplementationGuide.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Date : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImplementationGuide.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object DependsOn : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "depends-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImplementationGuide.dependsOn.uri"

    public override val target: List<String> = listOf("ImplementationGuide")

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Description : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ImplementationGuide.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Experimental : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImplementationGuide.experimental"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Global : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "global"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImplementationGuide.global.profile"

    public override val target: List<String> = listOf("StructureDefinition")

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Jurisdiction : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImplementationGuide.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Name : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ImplementationGuide.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Publisher : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ImplementationGuide.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Resource : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImplementationGuide.definition.resource.reference"

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

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Status : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImplementationGuide.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Title : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ImplementationGuide.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Url : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ImplementationGuide.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object Version : ImplementationGuideSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImplementationGuide.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ImplementationGuide resource type. */
    public val ALL: List<ImplementationGuideSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        DependsOn,
        Description,
        Experimental,
        Global,
        Jurisdiction,
        Name,
        Publisher,
        Resource,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
