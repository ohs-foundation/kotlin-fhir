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

/** Search parameters for the [TestScript] resource type. */
public sealed class TestScriptSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: TestScript): List<T>

  public data object Context : TestScriptSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(TestScript.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object ContextQuantity : TestScriptSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(TestScript.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object ContextType : TestScriptSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TestScript.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : TestScriptSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "TestScript.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : TestScriptSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "TestScript.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<UsageContext> = resource.useContext
  }

  public data object Date : TestScriptSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "TestScript.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : TestScriptSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TestScript.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : TestScriptSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TestScript.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : TestScriptSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TestScript.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : TestScriptSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TestScript.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<String> = listOf(resource.name)
  }

  public data object Publisher : TestScriptSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TestScript.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object ScopeArtifact : TestScriptSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "scope-artifact"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "TestScript.scope.artifact"

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

    public override fun extract(resource: TestScript): List<Canonical> =
      resource.scope.map { it.artifact }
  }

  public data object ScopeArtifactConformance : TestScriptSearchParam<TestScript.Scope>() {
    public override val paramName: kotlin.String = "scope-artifact-conformance"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "TestScript.scope"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<TestScript.Scope> = resource.scope
  }

  public data object ScopeArtifactPhase : TestScriptSearchParam<TestScript.Scope>() {
    public override val paramName: kotlin.String = "scope-artifact-phase"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "TestScript.scope"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<TestScript.Scope> = resource.scope
  }

  public data object Status : TestScriptSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TestScript.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = listOf(resource.status)
  }

  public data object TestscriptCapability : TestScriptSearchParam<String>() {
    public override val paramName: kotlin.String = "testscript-capability"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TestScript.metadata.capability.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<String> =
      (resource.metadata?.capability ?: emptyList()).mapNotNull { it.description }
  }

  public data object Title : TestScriptSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TestScript.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<String> = listOfNotNull(resource.title)
  }

  public data object Url : TestScriptSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "TestScript.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : TestScriptSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TestScript.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TestScript): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the TestScript resource type. */
    public val ALL: List<TestScriptSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Identifier,
        Jurisdiction,
        Name,
        Publisher,
        ScopeArtifact,
        ScopeArtifactConformance,
        ScopeArtifactPhase,
        Status,
        TestscriptCapability,
        Title,
        Url,
        Version,
      )
  }
}
