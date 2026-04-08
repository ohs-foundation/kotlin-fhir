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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
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
        "HealthcareService",
        "CareTeam",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Group",
        "Practitioner",
        "Location",
        "Patient",
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

    public override val target: List<String> =
      listOf("DeviceRequest", "ServiceRequest", "CarePlan", "MedicationRequest")

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Date : AppointmentSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String =
      "AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object Group : AppointmentSearchParam<Any>() {
    public override val paramName: String = "group"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Group)"

    public override val target: List<String> = listOf("Group")

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

    public override val expression: String = "Appointment.reason.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object ReasonReference : AppointmentSearchParam<Any>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.reason.reference"

    public override val target: List<String> =
      listOf("Procedure", "Observation", "ImmunizationRecommendation", "Condition")

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object RequestedPeriod : AppointmentSearchParam<Any>() {
    public override val paramName: String = "requested-period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "requestedPeriod"

    public override val target: List<String> = emptyList()

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

    public override val expression: String = "Appointment.serviceType.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Appointment): List<Any> = emptyList()
  }

  public data object ServiceTypeReference : AppointmentSearchParam<Any>() {
    public override val paramName: String = "service-type-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.serviceType.reference"

    public override val target: List<String> = listOf("HealthcareService")

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

  public data object Subject : AppointmentSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.subject"

    public override val target: List<String> = listOf("Group", "Patient")

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
        Group,
        Identifier,
        Location,
        PartStatus,
        Patient,
        Practitioner,
        ReasonCode,
        ReasonReference,
        RequestedPeriod,
        ServiceCategory,
        ServiceType,
        ServiceTypeReference,
        Slot,
        Specialty,
        Status,
        Subject,
        SupportingInfo,
      )
  }
}
