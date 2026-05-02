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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Condition] resource type. */
public sealed class ConditionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Condition): List<T>

  public data object AbatementAge : ConditionSearchParam<Any>() {
    public override val paramName: String = "abatement-age"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Condition.abatement.as(Age)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object AbatementDate : ConditionSearchParam<Any>() {
    public override val paramName: String = "abatement-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Condition.abatement.as(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object AbatementString : ConditionSearchParam<Any>() {
    public override val paramName: String = "abatement-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Condition.abatement.as(string)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Asserter : ConditionSearchParam<Any>() {
    public override val paramName: String = "asserter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.asserter"

    public override val target: List<String> =
      listOf("Practitioner", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object BodySite : ConditionSearchParam<Any>() {
    public override val paramName: String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.bodySite"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Category : ConditionSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object ClinicalStatus : ConditionSearchParam<Any>() {
    public override val paramName: String = "clinical-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.clinicalStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Code : ConditionSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Encounter : ConditionSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Evidence : ConditionSearchParam<Any>() {
    public override val paramName: String = "evidence"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.evidence.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object EvidenceDetail : ConditionSearchParam<Any>() {
    public override val paramName: String = "evidence-detail"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.evidence.detail"

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

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Identifier : ConditionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object OnsetAge : ConditionSearchParam<Any>() {
    public override val paramName: String = "onset-age"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Condition.onset.as(Age)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object OnsetDate : ConditionSearchParam<Any>() {
    public override val paramName: String = "onset-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Condition.onset.as(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object OnsetInfo : ConditionSearchParam<Any>() {
    public override val paramName: String = "onset-info"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Condition.onset.as(string)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Patient : ConditionSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object RecordedDate : ConditionSearchParam<Any>() {
    public override val paramName: String = "recorded-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Condition.recordedDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Severity : ConditionSearchParam<Any>() {
    public override val paramName: String = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.severity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Stage : ConditionSearchParam<Any>() {
    public override val paramName: String = "stage"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.stage.summary"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object Subject : ConditionSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.subject"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object VerificationStatus : ConditionSearchParam<Any>() {
    public override val paramName: String = "verification-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.verificationStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Condition resource type. */
    public val ALL: List<ConditionSearchParam<*>> =
      listOf(
        AbatementAge,
        AbatementDate,
        AbatementString,
        Asserter,
        BodySite,
        Category,
        ClinicalStatus,
        Code,
        Encounter,
        Evidence,
        EvidenceDetail,
        Identifier,
        OnsetAge,
        OnsetDate,
        OnsetInfo,
        Patient,
        RecordedDate,
        Severity,
        Stage,
        Subject,
        VerificationStatus,
      )
  }
}
