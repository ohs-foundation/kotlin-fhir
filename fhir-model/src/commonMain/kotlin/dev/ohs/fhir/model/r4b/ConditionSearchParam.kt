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
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Condition] resource type. */
public sealed class ConditionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Condition): List<T>

  public data object AbatementAge : ConditionSearchParam<Age>() {
    public override val paramName: kotlin.String = "abatement-age"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "Condition.abatement.as(Age)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<Age> =
      listOfNotNull((resource.abatement as? Condition.Abatement.Age)?.value)
  }

  public data object AbatementDate : ConditionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "abatement-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Condition.abatement.as(dateTime)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<DateTime> =
      listOfNotNull((resource.abatement as? Condition.Abatement.DateTime)?.value)
  }

  public data object AbatementString : ConditionSearchParam<String>() {
    public override val paramName: kotlin.String = "abatement-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Condition.abatement.as(string)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<String> =
      listOfNotNull((resource.abatement as? Condition.Abatement.String)?.value)
  }

  public data object Asserter : ConditionSearchParam<Reference>() {
    public override val paramName: kotlin.String = "asserter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Condition.asserter"

    public override val target: List<kotlin.String> =
      listOf("Practitioner", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Condition): List<Reference> =
      listOfNotNull(resource.asserter)
  }

  public data object BodySite : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.bodySite"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> = resource.bodySite
  }

  public data object Category : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> = resource.category
  }

  public data object ClinicalStatus : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "clinical-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.clinicalStatus"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.clinicalStatus)
  }

  public data object Code : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Encounter : ConditionSearchParam<Reference>() {
    public override val paramName: kotlin.String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Condition.encounter"

    public override val target: List<kotlin.String> = listOf("Encounter")

    public override fun extract(resource: Condition): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Evidence : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "evidence"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.evidence.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      resource.evidence.flatMap { it.code }
  }

  public data object EvidenceDetail : ConditionSearchParam<Reference>() {
    public override val paramName: kotlin.String = "evidence-detail"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Condition.evidence.detail"

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

    public override fun extract(resource: Condition): List<Reference> =
      resource.evidence.flatMap { it.detail }
  }

  public data object Identifier : ConditionSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object OnsetAge : ConditionSearchParam<Age>() {
    public override val paramName: kotlin.String = "onset-age"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "Condition.onset.as(Age)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<Age> =
      listOfNotNull((resource.onset as? Condition.Onset.Age)?.value)
  }

  public data object OnsetDate : ConditionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "onset-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Condition.onset.as(dateTime)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<DateTime> =
      listOfNotNull((resource.onset as? Condition.Onset.DateTime)?.value)
  }

  public data object OnsetInfo : ConditionSearchParam<String>() {
    public override val paramName: kotlin.String = "onset-info"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Condition.onset.as(string)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<String> =
      listOfNotNull((resource.onset as? Condition.Onset.String)?.value)
  }

  public data object Patient : ConditionSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Condition.subject.where(resolve() is Patient)"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: Condition): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object RecordedDate : ConditionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "recorded-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Condition.recordedDate"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<DateTime> =
      listOfNotNull(resource.recordedDate)
  }

  public data object Severity : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.severity"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.severity)
  }

  public data object Stage : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "stage"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.stage.summary"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      resource.stage.mapNotNull { it.summary }
  }

  public data object Subject : ConditionSearchParam<Reference>() {
    public override val paramName: kotlin.String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Condition.subject"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: Condition): List<Reference> = listOf(resource.subject)
  }

  public data object VerificationStatus : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "verification-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Condition.verificationStatus"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.verificationStatus)
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
