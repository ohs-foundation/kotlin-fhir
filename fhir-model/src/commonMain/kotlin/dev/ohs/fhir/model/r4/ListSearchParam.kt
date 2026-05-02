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

/** Search parameters for the [List] resource type. */
public sealed class ListSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: List): kotlin.collections.List<T>

  public data object Code : ListSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "List.code"

    public override val target: kotlin.collections.List<String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Date : ListSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "List.date"

    public override val target: kotlin.collections.List<String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object EmptyReason : ListSearchParam<Any>() {
    public override val paramName: String = "empty-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "List.emptyReason"

    public override val target: kotlin.collections.List<String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Encounter : ListSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "List.encounter"

    public override val target: kotlin.collections.List<String> =
      listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Identifier : ListSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "List.identifier"

    public override val target: kotlin.collections.List<String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Item : ListSearchParam<Any>() {
    public override val paramName: String = "item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "List.entry.item"

    public override val target: kotlin.collections.List<String> =
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

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Notes : ListSearchParam<Any>() {
    public override val paramName: String = "notes"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "List.note.text"

    public override val target: kotlin.collections.List<String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Patient : ListSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "List.subject.where(resolve() is Patient)"

    public override val target: kotlin.collections.List<String> = listOf("Patient", "Group")

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Source : ListSearchParam<Any>() {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "List.source"

    public override val target: kotlin.collections.List<String> =
      listOf("Practitioner", "Device", "Patient", "PractitionerRole")

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Status : ListSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "List.status"

    public override val target: kotlin.collections.List<String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Subject : ListSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "List.subject"

    public override val target: kotlin.collections.List<String> =
      listOf("Group", "Device", "Patient", "Location")

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public data object Title : ListSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "List.title"

    public override val target: kotlin.collections.List<String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the List resource type. */
    public val ALL: kotlin.collections.List<ListSearchParam<*>> =
      listOf(
        Code,
        Date,
        EmptyReason,
        Encounter,
        Identifier,
        Item,
        Notes,
        Patient,
        Source,
        Status,
        Subject,
        Title,
      )
  }
}
