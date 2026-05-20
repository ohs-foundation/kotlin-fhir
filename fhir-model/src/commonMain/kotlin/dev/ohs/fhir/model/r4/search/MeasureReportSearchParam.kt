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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.MeasureReport
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MeasureReport] resource type. */
public object MeasureReportSearchParam {
  /** All search parameters for the MeasureReport resource type. */
  public val ALL: List<SearchParam<MeasureReport, *>> =
    listOf(Date, EvaluatedResource, Identifier, Measure, Patient, Period, Reporter, Status, Subject)

  public data object Date : SearchParam<MeasureReport, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MeasureReport.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MeasureReport): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object EvaluatedResource : SearchParam<MeasureReport, Reference> {
    public override val paramName: String = "evaluated-resource"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.evaluatedResource"

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

    public override fun extract(resource: MeasureReport): List<Reference> =
      resource.evaluatedResource
  }

  public data object Identifier : SearchParam<MeasureReport, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MeasureReport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MeasureReport): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Measure : SearchParam<MeasureReport, Canonical> {
    public override val paramName: String = "measure"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.measure"

    public override val target: List<String> = listOf("Measure")

    public override fun extract(resource: MeasureReport): List<Canonical> = listOf(resource.measure)
  }

  public data object Patient : SearchParam<MeasureReport, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MeasureReport): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : SearchParam<MeasureReport, dev.ohs.fhir.model.r4.Period> {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MeasureReport.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MeasureReport): List<dev.ohs.fhir.model.r4.Period> =
      listOf(resource.period)
  }

  public data object Reporter : SearchParam<MeasureReport, Reference> {
    public override val paramName: String = "reporter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.reporter"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole", "Location")

    public override fun extract(resource: MeasureReport): List<Reference> =
      listOfNotNull(resource.reporter)
  }

  public data object Status : SearchParam<MeasureReport, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MeasureReport.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MeasureReport): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<MeasureReport, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MeasureReport.subject"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Group",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
        "Location",
      )

    public override fun extract(resource: MeasureReport): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
