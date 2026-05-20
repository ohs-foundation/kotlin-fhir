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
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.TestScript
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TestScript] resource type. */
public object TestScriptSearchParam {
  /** All search parameters for the TestScript resource type. */
  public val ALL: List<SearchParam<TestScript, *>> =
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

  public data object Context : SearchParam<TestScript, Any> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(TestScript.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<TestScript, Any> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(TestScript.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<TestScript, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<TestScript, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TestScript.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<TestScript, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TestScript.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<TestScript, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "TestScript.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<TestScript, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : SearchParam<TestScript, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<TestScript, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : SearchParam<TestScript, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R5String> = listOf(resource.name)
  }

  public data object Publisher : SearchParam<TestScript, R5String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object ScopeArtifact : SearchParam<TestScript, Canonical> {
    public override val paramName: KotlinString = "scope-artifact"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "TestScript.scope.artifact"

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

    public override fun extract(resource: TestScript): List<Canonical> =
      resource.scope.map { it.artifact }
  }

  public data object ScopeArtifactConformance : SearchParam<TestScript, TestScript.Scope> {
    public override val paramName: KotlinString = "scope-artifact-conformance"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TestScript.scope"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<TestScript.Scope> = resource.scope
  }

  public data object ScopeArtifactPhase : SearchParam<TestScript, TestScript.Scope> {
    public override val paramName: KotlinString = "scope-artifact-phase"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TestScript.scope"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<TestScript.Scope> = resource.scope
  }

  public data object Status : SearchParam<TestScript, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = listOf(resource.status)
  }

  public data object TestscriptCapability : SearchParam<TestScript, R5String> {
    public override val paramName: KotlinString = "testscript-capability"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.metadata.capability.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R5String> =
      (resource.metadata?.capability ?: emptyList()).mapNotNull { it.description }
  }

  public data object Title : SearchParam<TestScript, R5String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<TestScript, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "TestScript.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<TestScript, R5String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R5String> =
      listOfNotNull(resource.version)
  }
}
