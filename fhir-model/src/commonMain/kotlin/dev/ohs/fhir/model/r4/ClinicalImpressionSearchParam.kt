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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClinicalImpression] resource type. */
public sealed class ClinicalImpressionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ClinicalImpression): List<T>

  public data object Assessor : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "assessor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.assessor"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOfNotNull(resource.assessor)
  }

  public data object Date : ClinicalImpressionSearchParam<DateTime>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ClinicalImpression.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalImpression): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Encounter : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object FindingCode : ClinicalImpressionSearchParam<CodeableConcept>() {
    public override val paramName: String = "finding-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalImpression.finding.itemCodeableConcept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalImpression): List<CodeableConcept> =
      resource.finding.mapNotNull { it.itemCodeableConcept }
  }

  public data object FindingRef : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "finding-ref"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.finding.itemReference"

    public override val target: List<String> = listOf("Condition", "Observation", "Media")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      resource.finding.mapNotNull { it.itemReference }
  }

  public data object Identifier :
    ClinicalImpressionSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalImpression.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ClinicalImpression
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Investigation : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "investigation"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.investigation.item"

    public override val target: List<String> =
      listOf(
        "RiskAssessment",
        "FamilyMemberHistory",
        "Observation",
        "Media",
        "DiagnosticReport",
        "ImagingStudy",
        "QuestionnaireResponse",
      )

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      resource.investigation.flatMap { it.item }
  }

  public data object Patient : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalImpression.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Previous : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "previous"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.previous"

    public override val target: List<String> = listOf("ClinicalImpression")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOfNotNull(resource.previous)
  }

  public data object Problem : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "problem"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.problem"

    public override val target: List<String> = listOf("Condition", "AllergyIntolerance")

    public override fun extract(resource: ClinicalImpression): List<Reference> = resource.problem
  }

  public data object Status : ClinicalImpressionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalImpression.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalImpression): List<Any> = listOf(resource.status)
  }

  public data object Subject : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      listOf(resource.subject)
  }

  public data object SupportingInfo : ClinicalImpressionSearchParam<Reference>() {
    public override val paramName: String = "supporting-info"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalImpression.supportingInfo"

    public override val target: List<String> =
      listOf(
        "Account",
        "ActivityDefinition",
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
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
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
        "EffectEvidenceSynthesis",
        "Encounter",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
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
        "InsurancePlan",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "Measure",
        "MeasureReport",
        "Media",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProduct",
        "MedicinalProductAuthorization",
        "MedicinalProductContraindication",
        "MedicinalProductIndication",
        "MedicinalProductIngredient",
        "MedicinalProductInteraction",
        "MedicinalProductManufactured",
        "MedicinalProductPackaged",
        "MedicinalProductPharmaceutical",
        "MedicinalProductUndesirableEffect",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionOrder",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
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
        "RelatedPerson",
        "RequestGroup",
        "ResearchDefinition",
        "ResearchElementDefinition",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "RiskEvidenceSynthesis",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "Substance",
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SubstanceSpecification",
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

    public override fun extract(resource: ClinicalImpression): List<Reference> =
      resource.supportingInfo
  }

  public companion object {
    /** All search parameters for the ClinicalImpression resource type. */
    public val ALL: List<ClinicalImpressionSearchParam<*>> =
      listOf(
        Assessor,
        Date,
        Encounter,
        FindingCode,
        FindingRef,
        Identifier,
        Investigation,
        Patient,
        Previous,
        Problem,
        Status,
        Subject,
        SupportingInfo,
      )
  }
}
