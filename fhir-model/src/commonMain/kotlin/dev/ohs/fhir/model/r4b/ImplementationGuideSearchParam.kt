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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImplementationGuide] resource type. */
public sealed class ImplementationGuideSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ImplementationGuide): List<T>

  public data object Context : ImplementationGuideSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(ImplementationGuide.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : ImplementationGuideSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(ImplementationGuide.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : ImplementationGuideSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ImplementationGuide.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ImplementationGuideSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ImplementationGuide.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : ImplementationGuideSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ImplementationGuide.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<UsageContext> =
      resource.useContext
  }

  public data object Date : ImplementationGuideSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ImplementationGuide.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DependsOn : ImplementationGuideSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "depends-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ImplementationGuide.dependsOn.uri"

    public override val target: List<kotlin.String> = listOf("ImplementationGuide")

    public override fun extract(resource: ImplementationGuide): List<Canonical> =
      resource.dependsOn.map { it.uri }
  }

  public data object Description : ImplementationGuideSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ImplementationGuide.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Experimental : ImplementationGuideSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ImplementationGuide.experimental"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Boolean> =
      listOfNotNull(resource.experimental)
  }

  public data object Global : ImplementationGuideSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "global"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ImplementationGuide.global.profile"

    public override val target: List<kotlin.String> = listOf("StructureDefinition")

    public override fun extract(resource: ImplementationGuide): List<Canonical> =
      resource.global.map { it.profile }
  }

  public data object Jurisdiction : ImplementationGuideSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ImplementationGuide.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : ImplementationGuideSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ImplementationGuide.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<String> = listOf(resource.name)
  }

  public data object Publisher : ImplementationGuideSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ImplementationGuide.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Resource : ImplementationGuideSearchParam<Reference>() {
    public override val paramName: kotlin.String = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "ImplementationGuide.definition.resource.reference"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: ImplementationGuide): List<Reference> =
      (resource.definition?.resource ?: emptyList()).map { it.reference }
  }

  public data object Status : ImplementationGuideSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ImplementationGuide.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = listOf(resource.status)
  }

  public data object Title : ImplementationGuideSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ImplementationGuide.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : ImplementationGuideSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ImplementationGuide.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Uri> = listOf(resource.url)
  }

  public data object Version : ImplementationGuideSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ImplementationGuide.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<String> =
      listOfNotNull(resource.version)
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
