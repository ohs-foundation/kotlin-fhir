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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Condition
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Condition] resource type. */
public object ConditionSearchParam {
  /** All search parameters for the Condition resource type. */
  public val ALL: List<SearchParam<Condition, *>> =
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

  public data object AbatementAge : SearchParam<Condition, Age> {
    public override val paramName: KotlinString = "abatement-age"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "Condition.abatement.as(Age)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<Age> =
      listOfNotNull((resource.abatement as? Condition.Abatement.Age)?.value)
  }

  public data object AbatementDate : SearchParam<Condition, DateTime> {
    public override val paramName: KotlinString = "abatement-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Condition.abatement.as(dateTime)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<DateTime> =
      listOfNotNull((resource.abatement as? Condition.Abatement.DateTime)?.value)
  }

  public data object AbatementString : SearchParam<Condition, R4String> {
    public override val paramName: KotlinString = "abatement-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Condition.abatement.as(string)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<R4String> =
      listOfNotNull((resource.abatement as? Condition.Abatement.String)?.value)
  }

  public data object Asserter : SearchParam<Condition, Reference> {
    public override val paramName: KotlinString = "asserter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Condition.asserter"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Condition): List<Reference> =
      listOfNotNull(resource.asserter)
  }

  public data object BodySite : SearchParam<Condition, CodeableConcept> {
    public override val paramName: KotlinString = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.bodySite"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> = resource.bodySite
  }

  public data object Category : SearchParam<Condition, CodeableConcept> {
    public override val paramName: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.category"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> = resource.category
  }

  public data object ClinicalStatus : SearchParam<Condition, CodeableConcept> {
    public override val paramName: KotlinString = "clinical-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.clinicalStatus"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.clinicalStatus)
  }

  public data object Code : SearchParam<Condition, CodeableConcept> {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Encounter : SearchParam<Condition, Reference> {
    public override val paramName: KotlinString = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Condition.encounter"

    public override val target: List<KotlinString> = listOf("Encounter")

    public override fun extract(resource: Condition): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Evidence : SearchParam<Condition, CodeableConcept> {
    public override val paramName: KotlinString = "evidence"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.evidence.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      resource.evidence.flatMap { it.code }
  }

  public data object EvidenceDetail : SearchParam<Condition, Reference> {
    public override val paramName: KotlinString = "evidence-detail"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Condition.evidence.detail"

    public override val target: List<KotlinString> =
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

    public override fun extract(resource: Condition): List<Reference> =
      resource.evidence.flatMap { it.detail }
  }

  public data object Identifier : SearchParam<Condition, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object OnsetAge : SearchParam<Condition, Age> {
    public override val paramName: KotlinString = "onset-age"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "Condition.onset.as(Age)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<Age> =
      listOfNotNull((resource.onset as? Condition.Onset.Age)?.value)
  }

  public data object OnsetDate : SearchParam<Condition, DateTime> {
    public override val paramName: KotlinString = "onset-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Condition.onset.as(dateTime)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<DateTime> =
      listOfNotNull((resource.onset as? Condition.Onset.DateTime)?.value)
  }

  public data object OnsetInfo : SearchParam<Condition, R4String> {
    public override val paramName: KotlinString = "onset-info"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Condition.onset.as(string)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<R4String> =
      listOfNotNull((resource.onset as? Condition.Onset.String)?.value)
  }

  public data object Patient : SearchParam<Condition, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Condition.subject.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient", "Group")

    public override fun extract(resource: Condition): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object RecordedDate : SearchParam<Condition, DateTime> {
    public override val paramName: KotlinString = "recorded-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Condition.recordedDate"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<DateTime> =
      listOfNotNull(resource.recordedDate)
  }

  public data object Severity : SearchParam<Condition, CodeableConcept> {
    public override val paramName: KotlinString = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.severity"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.severity)
  }

  public data object Stage : SearchParam<Condition, CodeableConcept> {
    public override val paramName: KotlinString = "stage"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.stage.summary"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      resource.stage.mapNotNull { it.summary }
  }

  public data object Subject : SearchParam<Condition, Reference> {
    public override val paramName: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Condition.subject"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Condition): List<Reference> = listOf(resource.subject)
  }

  public data object VerificationStatus : SearchParam<Condition, CodeableConcept> {
    public override val paramName: KotlinString = "verification-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Condition.verificationStatus"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Condition): List<CodeableConcept> =
      listOfNotNull(resource.verificationStatus)
  }
}
