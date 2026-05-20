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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.ImplementationGuide
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImplementationGuide] resource type. */
public object ImplementationGuideSearchParam {
  /** All search parameters for the ImplementationGuide resource type. */
  public val ALL: List<SearchParam<ImplementationGuide, *>> =
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
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Resource,
      Status,
      Title,
      Url,
      Version,
    )

  public data object Context : SearchParam<ImplementationGuide, Any> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ImplementationGuide.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<ImplementationGuide, Any> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(ImplementationGuide.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<ImplementationGuide, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ImplementationGuide, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ImplementationGuide.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ImplementationGuide, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ImplementationGuide.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<ImplementationGuide, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ImplementationGuide.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DependsOn : SearchParam<ImplementationGuide, Canonical> {
    public override val paramName: KotlinString = "depends-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ImplementationGuide.dependsOn.uri"

    public override val target: List<KotlinString> = listOf("ImplementationGuide")

    public override fun extract(resource: ImplementationGuide): List<Canonical> =
      resource.dependsOn.map { it.uri }
  }

  public data object Description : SearchParam<ImplementationGuide, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ImplementationGuide.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Experimental : SearchParam<ImplementationGuide, Boolean> {
    public override val paramName: KotlinString = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.experimental"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Boolean> =
      listOfNotNull(resource.experimental)
  }

  public data object Global : SearchParam<ImplementationGuide, Canonical> {
    public override val paramName: KotlinString = "global"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ImplementationGuide.global.profile"

    public override val target: List<KotlinString> = listOf("StructureDefinition")

    public override fun extract(resource: ImplementationGuide): List<Canonical> =
      resource.global.map { it.profile }
  }

  public data object Identifier :
    SearchParam<ImplementationGuide, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: ImplementationGuide
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Jurisdiction : SearchParam<ImplementationGuide, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<ImplementationGuide, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ImplementationGuide.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<R5String> =
      listOf(resource.name)
  }

  public data object Publisher : SearchParam<ImplementationGuide, R5String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ImplementationGuide.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Resource : SearchParam<ImplementationGuide, Reference> {
    public override val paramName: KotlinString = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "ImplementationGuide.definition.resource.reference"

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

    public override fun extract(resource: ImplementationGuide): List<Reference> =
      (resource.definition?.resource ?: emptyList()).map { it.reference }
  }

  public data object Status : SearchParam<ImplementationGuide, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<ImplementationGuide, R5String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ImplementationGuide.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<ImplementationGuide, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ImplementationGuide.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<Uri> = listOf(resource.url)
  }

  public data object Version : SearchParam<ImplementationGuide, R5String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ImplementationGuide): List<R5String> =
      listOfNotNull(resource.version)
  }
}
