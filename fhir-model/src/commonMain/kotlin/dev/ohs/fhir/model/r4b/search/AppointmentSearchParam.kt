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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Account
import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.AdministrableProductDefinition
import dev.ohs.fhir.model.r4b.AdverseEvent
import dev.ohs.fhir.model.r4b.AllergyIntolerance
import dev.ohs.fhir.model.r4b.Appointment
import dev.ohs.fhir.model.r4b.AppointmentResponse
import dev.ohs.fhir.model.r4b.AuditEvent
import dev.ohs.fhir.model.r4b.Basic
import dev.ohs.fhir.model.r4b.Binary
import dev.ohs.fhir.model.r4b.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r4b.BodyStructure
import dev.ohs.fhir.model.r4b.Bundle
import dev.ohs.fhir.model.r4b.CapabilityStatement
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.CatalogEntry
import dev.ohs.fhir.model.r4b.ChargeItem
import dev.ohs.fhir.model.r4b.ChargeItemDefinition
import dev.ohs.fhir.model.r4b.Citation
import dev.ohs.fhir.model.r4b.Claim
import dev.ohs.fhir.model.r4b.ClaimResponse
import dev.ohs.fhir.model.r4b.ClinicalImpression
import dev.ohs.fhir.model.r4b.ClinicalUseDefinition
import dev.ohs.fhir.model.r4b.CodeSystem
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Communication
import dev.ohs.fhir.model.r4b.CommunicationRequest
import dev.ohs.fhir.model.r4b.CompartmentDefinition
import dev.ohs.fhir.model.r4b.Composition
import dev.ohs.fhir.model.r4b.ConceptMap
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.Consent
import dev.ohs.fhir.model.r4b.Contract
import dev.ohs.fhir.model.r4b.Coverage
import dev.ohs.fhir.model.r4b.CoverageEligibilityRequest
import dev.ohs.fhir.model.r4b.CoverageEligibilityResponse
import dev.ohs.fhir.model.r4b.DetectedIssue
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DeviceDefinition
import dev.ohs.fhir.model.r4b.DeviceMetric
import dev.ohs.fhir.model.r4b.DeviceRequest
import dev.ohs.fhir.model.r4b.DeviceUseStatement
import dev.ohs.fhir.model.r4b.DiagnosticReport
import dev.ohs.fhir.model.r4b.DocumentManifest
import dev.ohs.fhir.model.r4b.DocumentReference
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Endpoint
import dev.ohs.fhir.model.r4b.EnrollmentRequest
import dev.ohs.fhir.model.r4b.EnrollmentResponse
import dev.ohs.fhir.model.r4b.EpisodeOfCare
import dev.ohs.fhir.model.r4b.EventDefinition
import dev.ohs.fhir.model.r4b.Evidence
import dev.ohs.fhir.model.r4b.EvidenceReport
import dev.ohs.fhir.model.r4b.EvidenceVariable
import dev.ohs.fhir.model.r4b.ExampleScenario
import dev.ohs.fhir.model.r4b.ExplanationOfBenefit
import dev.ohs.fhir.model.r4b.FamilyMemberHistory
import dev.ohs.fhir.model.r4b.Flag
import dev.ohs.fhir.model.r4b.Goal
import dev.ohs.fhir.model.r4b.GraphDefinition
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.GuidanceResponse
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.ImagingStudy
import dev.ohs.fhir.model.r4b.Immunization
import dev.ohs.fhir.model.r4b.ImmunizationEvaluation
import dev.ohs.fhir.model.r4b.ImmunizationRecommendation
import dev.ohs.fhir.model.r4b.ImplementationGuide
import dev.ohs.fhir.model.r4b.Ingredient
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.InsurancePlan
import dev.ohs.fhir.model.r4b.Invoice
import dev.ohs.fhir.model.r4b.Library
import dev.ohs.fhir.model.r4b.Linkage
import dev.ohs.fhir.model.r4b.List as R4bList
import dev.ohs.fhir.model.r4b.ManufacturedItemDefinition
import dev.ohs.fhir.model.r4b.Measure
import dev.ohs.fhir.model.r4b.MeasureReport
import dev.ohs.fhir.model.r4b.Media
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.MedicationDispense
import dev.ohs.fhir.model.r4b.MedicationKnowledge
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.MedicationStatement
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.MessageDefinition
import dev.ohs.fhir.model.r4b.MessageHeader
import dev.ohs.fhir.model.r4b.MolecularSequence
import dev.ohs.fhir.model.r4b.NamingSystem
import dev.ohs.fhir.model.r4b.NutritionOrder
import dev.ohs.fhir.model.r4b.NutritionProduct
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.ObservationDefinition
import dev.ohs.fhir.model.r4b.OperationDefinition
import dev.ohs.fhir.model.r4b.OperationOutcome
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.OrganizationAffiliation
import dev.ohs.fhir.model.r4b.PackagedProductDefinition
import dev.ohs.fhir.model.r4b.PaymentNotice
import dev.ohs.fhir.model.r4b.PaymentReconciliation
import dev.ohs.fhir.model.r4b.Person
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Provenance
import dev.ohs.fhir.model.r4b.Questionnaire
import dev.ohs.fhir.model.r4b.QuestionnaireResponse
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RegulatedAuthorization
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.RequestGroup
import dev.ohs.fhir.model.r4b.ResearchDefinition
import dev.ohs.fhir.model.r4b.ResearchElementDefinition
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.ResearchSubject
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.RiskAssessment
import dev.ohs.fhir.model.r4b.Schedule
import dev.ohs.fhir.model.r4b.SearchParameter
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Specimen
import dev.ohs.fhir.model.r4b.SpecimenDefinition
import dev.ohs.fhir.model.r4b.StructureDefinition
import dev.ohs.fhir.model.r4b.StructureMap
import dev.ohs.fhir.model.r4b.Subscription
import dev.ohs.fhir.model.r4b.SubscriptionStatus
import dev.ohs.fhir.model.r4b.SubscriptionTopic
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.SubstanceDefinition
import dev.ohs.fhir.model.r4b.SupplyDelivery
import dev.ohs.fhir.model.r4b.SupplyRequest
import dev.ohs.fhir.model.r4b.Task
import dev.ohs.fhir.model.r4b.TerminologyCapabilities
import dev.ohs.fhir.model.r4b.TestReport
import dev.ohs.fhir.model.r4b.TestScript
import dev.ohs.fhir.model.r4b.ValueSet
import dev.ohs.fhir.model.r4b.VerificationResult
import dev.ohs.fhir.model.r4b.VisionPrescription
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
import kotlin.reflect.KClass

/** Search parameters for the [Appointment] resource type. */
public object AppointmentSearchParam {
  /** All search parameters for the Appointment resource type. */
  public val ALL: CollectionsList<SearchParam<Appointment, *>> =
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

  public data object Actor : SearchParam<Appointment, Reference> {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.participant.actor"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        dev.ohs.fhir.model.r4b.Practitioner::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        HealthcareService::class,
        PractitionerRole::class,
        RelatedPerson::class,
        dev.ohs.fhir.model.r4b.Location::class,
      )

    public override fun extract(resource: Appointment): CollectionsList<Reference> =
      resource.participant.mapNotNull { it.actor }
  }

  public data object AppointmentType : SearchParam<Appointment, CodeableConcept> {
    public override val paramName: String = "appointment-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.appointmentType"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Appointment): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.appointmentType)
  }

  public data object BasedOn : SearchParam<Appointment, Reference> {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.basedOn"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(ServiceRequest::class)

    public override fun extract(resource: Appointment): CollectionsList<Reference> =
      resource.basedOn
  }

  public data object Date : SearchParam<Appointment, Instant> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Appointment.start"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Appointment): CollectionsList<Instant> =
      listOfNotNull(resource.start)
  }

  public data object Identifier : SearchParam<Appointment, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.identifier"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: Appointment
    ): CollectionsList<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Location : SearchParam<Appointment, Reference> {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Location)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Location::class)

    public override fun extract(resource: Appointment): CollectionsList<Reference> =
      resource.participant
        .mapNotNull { it.actor }
        .filter { it.reference?.value?.toString()?.contains("Location/") == true }
  }

  public data object PartStatus : SearchParam<Appointment, Any> {
    public override val paramName: String = "part-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.participant.status"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Appointment): CollectionsList<Any> =
      resource.participant.map { it.status }
  }

  public data object Patient : SearchParam<Appointment, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Patient)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: Appointment): CollectionsList<Reference> =
      resource.participant
        .mapNotNull { it.actor }
        .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Practitioner : SearchParam<Appointment, Reference> {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Appointment.participant.actor.where(resolve() is Practitioner)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Practitioner::class)

    public override fun extract(resource: Appointment): CollectionsList<Reference> =
      resource.participant
        .mapNotNull { it.actor }
        .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
  }

  public data object ReasonCode : SearchParam<Appointment, CodeableConcept> {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.reasonCode"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Appointment): CollectionsList<CodeableConcept> =
      resource.reasonCode
  }

  public data object ReasonReference : SearchParam<Appointment, Reference> {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.reasonReference"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Condition::class,
        Observation::class,
        Procedure::class,
        ImmunizationRecommendation::class,
      )

    public override fun extract(resource: Appointment): CollectionsList<Reference> =
      resource.reasonReference
  }

  public data object ServiceCategory : SearchParam<Appointment, CodeableConcept> {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.serviceCategory"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Appointment): CollectionsList<CodeableConcept> =
      resource.serviceCategory
  }

  public data object ServiceType : SearchParam<Appointment, CodeableConcept> {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.serviceType"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Appointment): CollectionsList<CodeableConcept> =
      resource.serviceType
  }

  public data object Slot : SearchParam<Appointment, Reference> {
    public override val paramName: String = "slot"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.slot"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Slot::class)

    public override fun extract(resource: Appointment): CollectionsList<Reference> = resource.slot
  }

  public data object Specialty : SearchParam<Appointment, CodeableConcept> {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.specialty"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Appointment): CollectionsList<CodeableConcept> =
      resource.specialty
  }

  public data object Status : SearchParam<Appointment, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Appointment.status"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Appointment): CollectionsList<Any> =
      listOf(resource.status)
  }

  public data object SupportingInfo : SearchParam<Appointment, Reference> {
    public override val paramName: String = "supporting-info"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Appointment.supportingInformation"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Account::class,
        ActivityDefinition::class,
        AdministrableProductDefinition::class,
        AdverseEvent::class,
        AllergyIntolerance::class,
        Appointment::class,
        AppointmentResponse::class,
        AuditEvent::class,
        Basic::class,
        Binary::class,
        BiologicallyDerivedProduct::class,
        BodyStructure::class,
        Bundle::class,
        CapabilityStatement::class,
        CarePlan::class,
        CareTeam::class,
        CatalogEntry::class,
        ChargeItem::class,
        ChargeItemDefinition::class,
        Citation::class,
        Claim::class,
        ClaimResponse::class,
        ClinicalImpression::class,
        ClinicalUseDefinition::class,
        CodeSystem::class,
        Communication::class,
        CommunicationRequest::class,
        CompartmentDefinition::class,
        Composition::class,
        ConceptMap::class,
        Condition::class,
        Consent::class,
        Contract::class,
        Coverage::class,
        CoverageEligibilityRequest::class,
        CoverageEligibilityResponse::class,
        DetectedIssue::class,
        Device::class,
        DeviceDefinition::class,
        DeviceMetric::class,
        DeviceRequest::class,
        DeviceUseStatement::class,
        DiagnosticReport::class,
        DocumentManifest::class,
        DocumentReference::class,
        Encounter::class,
        Endpoint::class,
        EnrollmentRequest::class,
        EnrollmentResponse::class,
        EpisodeOfCare::class,
        EventDefinition::class,
        Evidence::class,
        EvidenceReport::class,
        EvidenceVariable::class,
        ExampleScenario::class,
        ExplanationOfBenefit::class,
        FamilyMemberHistory::class,
        Flag::class,
        Goal::class,
        GraphDefinition::class,
        Group::class,
        GuidanceResponse::class,
        HealthcareService::class,
        ImagingStudy::class,
        Immunization::class,
        ImmunizationEvaluation::class,
        ImmunizationRecommendation::class,
        ImplementationGuide::class,
        Ingredient::class,
        InsurancePlan::class,
        Invoice::class,
        Library::class,
        Linkage::class,
        R4bList::class,
        dev.ohs.fhir.model.r4b.Location::class,
        ManufacturedItemDefinition::class,
        Measure::class,
        MeasureReport::class,
        Media::class,
        Medication::class,
        MedicationAdministration::class,
        MedicationDispense::class,
        MedicationKnowledge::class,
        MedicationRequest::class,
        MedicationStatement::class,
        MedicinalProductDefinition::class,
        MessageDefinition::class,
        MessageHeader::class,
        MolecularSequence::class,
        NamingSystem::class,
        NutritionOrder::class,
        NutritionProduct::class,
        Observation::class,
        ObservationDefinition::class,
        OperationDefinition::class,
        OperationOutcome::class,
        Organization::class,
        OrganizationAffiliation::class,
        PackagedProductDefinition::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PaymentNotice::class,
        PaymentReconciliation::class,
        Person::class,
        PlanDefinition::class,
        dev.ohs.fhir.model.r4b.Practitioner::class,
        PractitionerRole::class,
        Procedure::class,
        Provenance::class,
        Questionnaire::class,
        QuestionnaireResponse::class,
        RegulatedAuthorization::class,
        RelatedPerson::class,
        RequestGroup::class,
        ResearchDefinition::class,
        ResearchElementDefinition::class,
        ResearchStudy::class,
        ResearchSubject::class,
        RiskAssessment::class,
        Schedule::class,
        SearchParameter::class,
        ServiceRequest::class,
        dev.ohs.fhir.model.r4b.Slot::class,
        Specimen::class,
        SpecimenDefinition::class,
        StructureDefinition::class,
        StructureMap::class,
        Subscription::class,
        SubscriptionStatus::class,
        SubscriptionTopic::class,
        Substance::class,
        SubstanceDefinition::class,
        SupplyDelivery::class,
        SupplyRequest::class,
        Task::class,
        TerminologyCapabilities::class,
        TestReport::class,
        TestScript::class,
        ValueSet::class,
        VerificationResult::class,
        VisionPrescription::class,
      )

    public override fun extract(resource: Appointment): CollectionsList<Reference> =
      resource.supportingInformation
  }
}
