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
import kotlin.Suppress

/** Search parameters for the [List] resource type. */
public sealed class ListSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: List): kotlin.collections.List<T>

  public data object Code : ListSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "List.code"

    public override val target: kotlin.collections.List<kotlin.String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Date : ListSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "List.date"

    public override val target: kotlin.collections.List<kotlin.String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object EmptyReason : ListSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "empty-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "List.emptyReason"

    public override val target: kotlin.collections.List<kotlin.String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<CodeableConcept> =
      listOfNotNull(resource.emptyReason)
  }

  public data object Encounter : ListSearchParam<Reference>() {
    public override val paramName: kotlin.String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "List.encounter"

    public override val target: kotlin.collections.List<kotlin.String> =
      listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: List): kotlin.collections.List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : ListSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "List.identifier"

    public override val target: kotlin.collections.List<kotlin.String> = emptyList()

    public override fun extract(
      resource: List
    ): kotlin.collections.List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Item : ListSearchParam<Reference>() {
    public override val paramName: kotlin.String = "item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "List.entry.item"

    public override val target: kotlin.collections.List<kotlin.String> =
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

    public override fun extract(resource: List): kotlin.collections.List<Reference> =
      resource.entry.map { it.item }
  }

  public data object Notes : ListSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "notes"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "List.note.text"

    public override val target: kotlin.collections.List<kotlin.String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Markdown> =
      resource.note.map { it.text }
  }

  public data object Patient : ListSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "List.subject.where(resolve() is Patient)"

    public override val target: kotlin.collections.List<kotlin.String> = listOf("Patient", "Group")

    public override fun extract(resource: List): kotlin.collections.List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Source : ListSearchParam<Reference>() {
    public override val paramName: kotlin.String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "List.source"

    public override val target: kotlin.collections.List<kotlin.String> =
      listOf("Practitioner", "Device", "Patient", "PractitionerRole")

    public override fun extract(resource: List): kotlin.collections.List<Reference> =
      listOfNotNull(resource.source)
  }

  public data object Status : ListSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "List.status"

    public override val target: kotlin.collections.List<kotlin.String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<Any> =
      listOf(resource.status)
  }

  public data object Subject : ListSearchParam<Reference>() {
    public override val paramName: kotlin.String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "List.subject"

    public override val target: kotlin.collections.List<kotlin.String> =
      listOf("Group", "Device", "Patient", "Location")

    public override fun extract(resource: List): kotlin.collections.List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Title : ListSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "List.title"

    public override val target: kotlin.collections.List<kotlin.String> = emptyList()

    public override fun extract(resource: List): kotlin.collections.List<String> =
      listOfNotNull(resource.title)
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
