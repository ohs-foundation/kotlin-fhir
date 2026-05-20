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

import dev.ohs.fhir.model.r5.ClinicalImpression
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClinicalImpression] resource type. */
public object ClinicalImpressionSearchParam {
  /** All search parameters for the ClinicalImpression resource type. */
  public val ALL: List<SearchParam<ClinicalImpression, *>> =
    listOf(
      Date,
      Encounter,
      FindingCode,
      FindingRef,
      Identifier,
      Patient,
      Performer,
      Previous,
      Problem,
      Status,
      Subject,
      SupportingInfo,
    )

  public data object Date : SearchParam<ClinicalImpression, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ClinicalImpression.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalImpression): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Encounter : SearchParam<ClinicalImpression, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object FindingCode : SearchParam<ClinicalImpression, CodeableConcept> {
    public override val paramName: String = "finding-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalImpression.finding.item.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalImpression): List<CodeableConcept> =
      resource.finding.mapNotNull { it.item }.mapNotNull { it.concept }
  }

  public data object FindingRef : SearchParam<ClinicalImpression, Reference> {
    public override val paramName: String = "finding-ref"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.finding.item.reference"

    public override val target: List<String> =
      listOf("DocumentReference", "Observation", "Condition")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      resource.finding.mapNotNull { it.item }.mapNotNull { it.reference }
  }

  public data object Identifier :
    SearchParam<ClinicalImpression, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalImpression.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ClinicalImpression
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Patient : SearchParam<ClinicalImpression, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalImpression.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<ClinicalImpression, Reference> {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.performer"

    public override val target: List<String> = listOf("PractitionerRole", "Practitioner")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOfNotNull(resource.performer)
  }

  public data object Previous : SearchParam<ClinicalImpression, Reference> {
    public override val paramName: String = "previous"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.previous"

    public override val target: List<String> = listOf("ClinicalImpression")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOfNotNull(resource.previous)
  }

  public data object Problem : SearchParam<ClinicalImpression, Reference> {
    public override val paramName: String = "problem"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.problem"

    public override val target: List<String> = listOf("AllergyIntolerance", "Condition")

    public override fun extract(resource: ClinicalImpression): List<Reference> = resource.problem
  }

  public data object Status : SearchParam<ClinicalImpression, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalImpression.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalImpression): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<ClinicalImpression, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOf(resource.subject)
  }

  public data object SupportingInfo : SearchParam<ClinicalImpression, Reference> {
    public override val paramName: String = "supporting-info"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.supportingInfo"

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

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      resource.supportingInfo
  }
}
