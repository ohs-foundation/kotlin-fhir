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

    public override val expression: String = "Condition.abatement.ofType(Age)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object AbatementDate : ConditionSearchParam<Any>() {
    public override val paramName: String = "abatement-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Condition.abatement.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object AbatementString : ConditionSearchParam<Any>() {
    public override val paramName: String = "abatement-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Condition.abatement.ofType(string)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object BodySite : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.bodySite"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> = resource.bodySite
  }

  public data object Category : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> = resource.category
  }

  public data object ClinicalStatus : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "clinical-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.clinicalStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOf(resource.clinicalStatus)
  }

  public data object Code : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Encounter : ConditionSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Condition): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Evidence : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "evidence"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.evidence.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      resource.evidence.mapNotNull { it.concept }
  }

  public data object EvidenceDetail : ConditionSearchParam<Reference>() {
    public override val paramName: String = "evidence-detail"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.evidence.reference"

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

    public override fun extract(resource: Condition): List<Reference> =
      resource.evidence.mapNotNull { it.reference }
  }

  public data object Identifier : ConditionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object OnsetAge : ConditionSearchParam<Any>() {
    public override val paramName: String = "onset-age"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Condition.onset.ofType(Age)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object OnsetDate : ConditionSearchParam<Any>() {
    public override val paramName: String = "onset-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Condition.onset.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object OnsetInfo : ConditionSearchParam<Any>() {
    public override val paramName: String = "onset-info"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Condition.onset.ofType(string)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<Any> = emptyList()
  }

  public data object ParticipantActor : ConditionSearchParam<Reference>() {
    public override val paramName: String = "participant-actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.participant.actor"

    public override val target: List<String> =
      listOf(
        "Device",
        "Organization",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Condition): List<Reference> =
      resource.participant.map { it.actor }
  }

  public data object ParticipantFunction : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "participant-function"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.participant.function"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      resource.participant.mapNotNull { it.function }
  }

  public data object Patient : ConditionSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Condition): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object RecordedDate : ConditionSearchParam<DateTime>() {
    public override val paramName: String = "recorded-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Condition.recordedDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<DateTime> =
      listOfNotNull(resource.recordedDate)
  }

  public data object Severity : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.severity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.severity)
  }

  public data object Stage : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "stage"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.stage.summary"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      resource.stage.mapNotNull { it.summary }
  }

  public data object Subject : ConditionSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Condition.subject"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Condition): List<Reference> = listOf(resource.subject)
  }

  public data object VerificationStatus : ConditionSearchParam<CodeableConcept>() {
    public override val paramName: String = "verification-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Condition.verificationStatus"

    public override val target: List<String> = emptyList()

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
        ParticipantActor,
        ParticipantFunction,
        Patient,
        RecordedDate,
        Severity,
        Stage,
        Subject,
        VerificationStatus,
      )
  }
}
