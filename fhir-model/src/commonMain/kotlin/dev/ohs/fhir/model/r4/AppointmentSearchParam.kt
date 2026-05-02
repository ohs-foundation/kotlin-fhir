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

/** Search parameters for the [Appointment] resource type. */
public sealed class AppointmentSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Appointment): List<T>

  public data object Actor : AppointmentSearchParam<Reference>() {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.participant.actor"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Device",
        "Patient",
        "HealthcareService",
        "PractitionerRole",
        "RelatedPerson",
        "Location",
      )

    public override fun extract(resource: Appointment): List<Reference> =
      resource.participant.mapNotNull { it.actor }
  }

  public data object AppointmentType : AppointmentSearchParam<CodeableConcept>() {
    public override val paramName: String = "appointment-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.appointmentType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<CodeableConcept> =
      listOfNotNull(resource.appointmentType)
  }

  public data object BasedOn : AppointmentSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.basedOn"

    public override val target: List<String> = listOf("ServiceRequest")

    public override fun extract(resource: Appointment): List<Reference> = resource.basedOn
  }

  public data object Date : AppointmentSearchParam<Instant>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Appointment.start"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Instant> =
      listOfNotNull(resource.start)
  }

  public data object Identifier : AppointmentSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Location : AppointmentSearchParam<Reference>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Location)"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Appointment): List<Reference> =
      resource.participant
        .mapNotNull { it.actor }
        .filter { it.reference?.value?.toString()?.contains("Location/") == true }
  }

  public data object PartStatus : AppointmentSearchParam<Any>() {
    public override val paramName: String = "part-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.participant.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> =
      resource.participant.map { it.status }
  }

  public data object Patient : AppointmentSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Appointment): List<Reference> =
      resource.participant
        .mapNotNull { it.actor }
        .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Practitioner : AppointmentSearchParam<Reference>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: Appointment): List<Reference> =
      resource.participant
        .mapNotNull { it.actor }
        .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
  }

  public data object ReasonCode : AppointmentSearchParam<CodeableConcept>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.reasonCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<CodeableConcept> = resource.reasonCode
  }

  public data object ReasonReference : AppointmentSearchParam<Reference>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.reasonReference"

    public override val target: List<String> =
      listOf("Condition", "Observation", "Procedure", "ImmunizationRecommendation")

    public override fun extract(resource: Appointment): List<Reference> = resource.reasonReference
  }

  public data object ServiceCategory : AppointmentSearchParam<CodeableConcept>() {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.serviceCategory"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<CodeableConcept> =
      resource.serviceCategory
  }

  public data object ServiceType : AppointmentSearchParam<CodeableConcept>() {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.serviceType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<CodeableConcept> = resource.serviceType
  }

  public data object Slot : AppointmentSearchParam<Reference>() {
    public override val paramName: String = "slot"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.slot"

    public override val target: List<String> = listOf("Slot")

    public override fun extract(resource: Appointment): List<Reference> = resource.slot
  }

  public data object Specialty : AppointmentSearchParam<CodeableConcept>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<CodeableConcept> = resource.specialty
  }

  public data object Status : AppointmentSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = listOf(resource.status)
  }

  public data object SupportingInfo : AppointmentSearchParam<Reference>() {
    public override val paramName: String = "supporting-info"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.supportingInformation"

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

    public override fun extract(resource: Appointment): List<Reference> =
      resource.supportingInformation
  }

  public companion object {
    /** All search parameters for the Appointment resource type. */
    public val ALL: List<AppointmentSearchParam<*>> =
      listOf(
        Actor,
        AppointmentType,
        BasedOn,
        Date,
        Identifier,
        Location,
        PartStatus,
        Patient,
        Practitioner,
        ReasonCode,
        ReasonReference,
        ServiceCategory,
        ServiceType,
        Slot,
        Specialty,
        Status,
        SupportingInfo,
      )
  }
}
