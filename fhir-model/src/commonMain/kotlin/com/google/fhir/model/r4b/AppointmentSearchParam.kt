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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Appointment] resource type. */
public sealed class AppointmentSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Appointment): List<T>

  public data object Actor : AppointmentSearchParam<Any>() {
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

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object AppointmentType : AppointmentSearchParam<Any>() {
    public override val paramName: String = "appointment-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.appointmentType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object BasedOn : AppointmentSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.basedOn"

    public override val target: List<String> = listOf("ServiceRequest")

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Date : AppointmentSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Appointment.start"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Identifier : AppointmentSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Location : AppointmentSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Location)"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object PartStatus : AppointmentSearchParam<Any>() {
    public override val paramName: String = "part-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.participant.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Patient : AppointmentSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Practitioner : AppointmentSearchParam<Any>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object ReasonCode : AppointmentSearchParam<Any>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.reasonCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object ReasonReference : AppointmentSearchParam<Any>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.reasonReference"

    public override val target: List<String> =
      listOf("Condition", "Observation", "Procedure", "ImmunizationRecommendation")

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object ServiceCategory : AppointmentSearchParam<Any>() {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.serviceCategory"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object ServiceType : AppointmentSearchParam<Any>() {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.serviceType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Slot : AppointmentSearchParam<Any>() {
    public override val paramName: String = "slot"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.slot"

    public override val target: List<String> = listOf("Slot")

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Specialty : AppointmentSearchParam<Any>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Status : AppointmentSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object SupportingInfo : AppointmentSearchParam<Any>() {
    public override val paramName: String = "supporting-info"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.supportingInformation"

    public override val target: List<String> =
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

    public override fun extract(resource: Appointment): List<Any> = emptyList()
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
