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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.ImmunizationRecommendation
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImmunizationRecommendation] resource type. */
public object ImmunizationRecommendationSearchParam {
  /** All search parameters for the ImmunizationRecommendation resource type. */
  public val ALL: List<SearchParam<ImmunizationRecommendation, *>> =
    listOf(Date, Identifier, Information, Patient, Status, Support, TargetDisease, VaccineType)

  public data object Date : SearchParam<ImmunizationRecommendation, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImmunizationRecommendation.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationRecommendation): List<DateTime> =
      listOf(resource.date)
  }

  public data object Identifier :
    SearchParam<ImmunizationRecommendation, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImmunizationRecommendation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ImmunizationRecommendation
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Information : SearchParam<ImmunizationRecommendation, Reference> {
    public override val paramName: String = "information"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ImmunizationRecommendation.recommendation.supportingPatientInformation"

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

    public override fun extract(resource: ImmunizationRecommendation): List<Reference> =
      resource.recommendation.flatMap { it.supportingPatientInformation }
  }

  public data object Patient : SearchParam<ImmunizationRecommendation, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImmunizationRecommendation.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ImmunizationRecommendation): List<Reference> =
      listOf(resource.patient)
  }

  public data object Status : SearchParam<ImmunizationRecommendation, CodeableConcept> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ImmunizationRecommendation.recommendation.forecastStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationRecommendation): List<CodeableConcept> =
      resource.recommendation.map { it.forecastStatus }
  }

  public data object Support : SearchParam<ImmunizationRecommendation, Reference> {
    public override val paramName: String = "support"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ImmunizationRecommendation.recommendation.supportingImmunization"

    public override val target: List<String> = listOf("Immunization", "ImmunizationEvaluation")

    public override fun extract(resource: ImmunizationRecommendation): List<Reference> =
      resource.recommendation.flatMap { it.supportingImmunization }
  }

  public data object TargetDisease : SearchParam<ImmunizationRecommendation, CodeableConcept> {
    public override val paramName: String = "target-disease"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ImmunizationRecommendation.recommendation.targetDisease"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationRecommendation): List<CodeableConcept> =
      resource.recommendation.mapNotNull { it.targetDisease }
  }

  public data object VaccineType : SearchParam<ImmunizationRecommendation, CodeableConcept> {
    public override val paramName: String = "vaccine-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImmunizationRecommendation.recommendation.vaccineCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationRecommendation): List<CodeableConcept> =
      resource.recommendation.flatMap { it.vaccineCode }
  }
}
