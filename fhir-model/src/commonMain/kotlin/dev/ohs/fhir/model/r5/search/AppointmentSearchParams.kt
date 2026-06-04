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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Account
import dev.ohs.fhir.model.r5.ActivityDefinition
import dev.ohs.fhir.model.r5.ActorDefinition
import dev.ohs.fhir.model.r5.AdministrableProductDefinition
import dev.ohs.fhir.model.r5.AdverseEvent
import dev.ohs.fhir.model.r5.AllergyIntolerance
import dev.ohs.fhir.model.r5.Appointment
import dev.ohs.fhir.model.r5.AppointmentResponse
import dev.ohs.fhir.model.r5.ArtifactAssessment
import dev.ohs.fhir.model.r5.AuditEvent
import dev.ohs.fhir.model.r5.Basic
import dev.ohs.fhir.model.r5.Binary
import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.BiologicallyDerivedProductDispense
import dev.ohs.fhir.model.r5.BodyStructure
import dev.ohs.fhir.model.r5.Bundle
import dev.ohs.fhir.model.r5.CapabilityStatement
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.ChargeItem
import dev.ohs.fhir.model.r5.ChargeItemDefinition
import dev.ohs.fhir.model.r5.Citation
import dev.ohs.fhir.model.r5.Claim
import dev.ohs.fhir.model.r5.ClaimResponse
import dev.ohs.fhir.model.r5.ClinicalImpression
import dev.ohs.fhir.model.r5.ClinicalUseDefinition
import dev.ohs.fhir.model.r5.CodeSystem
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Communication
import dev.ohs.fhir.model.r5.CommunicationRequest
import dev.ohs.fhir.model.r5.CompartmentDefinition
import dev.ohs.fhir.model.r5.Composition
import dev.ohs.fhir.model.r5.ConceptMap
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.ConditionDefinition
import dev.ohs.fhir.model.r5.Consent
import dev.ohs.fhir.model.r5.Contract
import dev.ohs.fhir.model.r5.Coverage
import dev.ohs.fhir.model.r5.CoverageEligibilityRequest
import dev.ohs.fhir.model.r5.CoverageEligibilityResponse
import dev.ohs.fhir.model.r5.DetectedIssue
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceAssociation
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.DeviceDispense
import dev.ohs.fhir.model.r5.DeviceMetric
import dev.ohs.fhir.model.r5.DeviceRequest
import dev.ohs.fhir.model.r5.DeviceUsage
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.EncounterHistory
import dev.ohs.fhir.model.r5.Endpoint
import dev.ohs.fhir.model.r5.EnrollmentRequest
import dev.ohs.fhir.model.r5.EnrollmentResponse
import dev.ohs.fhir.model.r5.EpisodeOfCare
import dev.ohs.fhir.model.r5.EventDefinition
import dev.ohs.fhir.model.r5.Evidence
import dev.ohs.fhir.model.r5.EvidenceReport
import dev.ohs.fhir.model.r5.EvidenceVariable
import dev.ohs.fhir.model.r5.ExampleScenario
import dev.ohs.fhir.model.r5.ExplanationOfBenefit
import dev.ohs.fhir.model.r5.FamilyMemberHistory
import dev.ohs.fhir.model.r5.Flag
import dev.ohs.fhir.model.r5.FormularyItem
import dev.ohs.fhir.model.r5.GenomicStudy
import dev.ohs.fhir.model.r5.Goal
import dev.ohs.fhir.model.r5.GraphDefinition
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.GuidanceResponse
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImagingSelection
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.ImmunizationEvaluation
import dev.ohs.fhir.model.r5.ImmunizationRecommendation
import dev.ohs.fhir.model.r5.ImplementationGuide
import dev.ohs.fhir.model.r5.Ingredient
import dev.ohs.fhir.model.r5.InsurancePlan
import dev.ohs.fhir.model.r5.InventoryItem
import dev.ohs.fhir.model.r5.InventoryReport
import dev.ohs.fhir.model.r5.Invoice
import dev.ohs.fhir.model.r5.Library
import dev.ohs.fhir.model.r5.Linkage
import dev.ohs.fhir.model.r5.List as R5List
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.Measure
import dev.ohs.fhir.model.r5.MeasureReport
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.MedicationDispense
import dev.ohs.fhir.model.r5.MedicationKnowledge
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.MessageDefinition
import dev.ohs.fhir.model.r5.MessageHeader
import dev.ohs.fhir.model.r5.MolecularSequence
import dev.ohs.fhir.model.r5.NamingSystem
import dev.ohs.fhir.model.r5.NutritionIntake
import dev.ohs.fhir.model.r5.NutritionOrder
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.ObservationDefinition
import dev.ohs.fhir.model.r5.OperationDefinition
import dev.ohs.fhir.model.r5.OperationOutcome
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.OrganizationAffiliation
import dev.ohs.fhir.model.r5.PackagedProductDefinition
import dev.ohs.fhir.model.r5.Parameters
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.PaymentNotice
import dev.ohs.fhir.model.r5.PaymentReconciliation
import dev.ohs.fhir.model.r5.Permission
import dev.ohs.fhir.model.r5.Person
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Provenance
import dev.ohs.fhir.model.r5.Questionnaire
import dev.ohs.fhir.model.r5.QuestionnaireResponse
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RegulatedAuthorization
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.RequestOrchestration
import dev.ohs.fhir.model.r5.Requirements
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.ResearchSubject
import dev.ohs.fhir.model.r5.RiskAssessment
import dev.ohs.fhir.model.r5.Schedule
import dev.ohs.fhir.model.r5.SearchParameter
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Slot
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.SpecimenDefinition
import dev.ohs.fhir.model.r5.StructureDefinition
import dev.ohs.fhir.model.r5.StructureMap
import dev.ohs.fhir.model.r5.Subscription
import dev.ohs.fhir.model.r5.SubscriptionStatus
import dev.ohs.fhir.model.r5.SubscriptionTopic
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.SubstanceNucleicAcid
import dev.ohs.fhir.model.r5.SubstancePolymer
import dev.ohs.fhir.model.r5.SubstanceProtein
import dev.ohs.fhir.model.r5.SubstanceReferenceInformation
import dev.ohs.fhir.model.r5.SubstanceSourceMaterial
import dev.ohs.fhir.model.r5.SupplyDelivery
import dev.ohs.fhir.model.r5.SupplyRequest
import dev.ohs.fhir.model.r5.Task
import dev.ohs.fhir.model.r5.TerminologyCapabilities
import dev.ohs.fhir.model.r5.TestPlan
import dev.ohs.fhir.model.r5.TestReport
import dev.ohs.fhir.model.r5.TestScript
import dev.ohs.fhir.model.r5.Transport
import dev.ohs.fhir.model.r5.ValueSet
import dev.ohs.fhir.model.r5.VerificationResult
import dev.ohs.fhir.model.r5.VisionPrescription
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List as CollectionsList

/** Search parameters for the [Appointment] resource type. */
public object AppointmentSearchParams {
  public val actor: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "actor",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.participant.actor",
      target =
        listOf(
          HealthcareService::class,
          CareTeam::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Group::class,
          Practitioner::class,
          Location::class,
          Patient::class,
        ),
      extractor = { resource -> resource.participant.mapNotNull { it.actor } },
    )

  public val appointmentType: SearchParam<Appointment, CodeableConcept> =
    SimpleSearchParam<Appointment, CodeableConcept>(
      name = "appointment-type",
      type = SearchParamType.fromCode("token"),
      expression = "Appointment.appointmentType",
      extractor = { resource -> listOfNotNull(resource.appointmentType) },
    )

  public val basedOn: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.basedOn",
      target =
        listOf(
          DeviceRequest::class,
          ServiceRequest::class,
          CarePlan::class,
          MedicationRequest::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val date: SearchParam<Appointment, Any> =
    SimpleSearchParam<Appointment, Any>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression =
        "AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn",
      extractor = { emptyList() },
    )

  public val group: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "group",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.participant.actor.where(resolve() is Group)",
      target = listOf(Group::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.actor }
          .filter { it.reference?.value?.toString()?.contains("Group/") == true }
      },
    )

  public val identifier: SearchParam<Appointment, Identifier> =
    SimpleSearchParam<Appointment, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Appointment.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.participant.actor.where(resolve() is Location)",
      target = listOf(Location::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.actor }
          .filter { it.reference?.value?.toString()?.contains("Location/") == true }
      },
    )

  public val partStatus: SearchParam<Appointment, Any> =
    SimpleSearchParam<Appointment, Any>(
      name = "part-status",
      type = SearchParamType.fromCode("token"),
      expression = "Appointment.participant.status",
      extractor = { resource -> resource.participant.map { it.status } },
    )

  public val patient: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.participant.actor.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.actor }
          .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
      },
    )

  public val practitioner: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.participant.actor.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.actor }
          .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
      },
    )

  public val reasonCode: SearchParam<Appointment, CodeableConcept> =
    SimpleSearchParam<Appointment, CodeableConcept>(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "Appointment.reason.concept",
      extractor = { resource -> resource.reason.mapNotNull { it.concept } },
    )

  public val reasonReference: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "reason-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.reason.reference",
      target =
        listOf(
          Procedure::class,
          Observation::class,
          ImmunizationRecommendation::class,
          Condition::class,
        ),
      extractor = { resource -> resource.reason.mapNotNull { it.reference } },
    )

  public val requestedPeriod: SearchParam<Appointment, Any> =
    SimpleSearchParam<Appointment, Any>(
      name = "requested-period",
      type = SearchParamType.fromCode("date"),
      expression = "requestedPeriod",
      extractor = { emptyList() },
    )

  public val serviceCategory: SearchParam<Appointment, CodeableConcept> =
    SimpleSearchParam<Appointment, CodeableConcept>(
      name = "service-category",
      type = SearchParamType.fromCode("token"),
      expression = "Appointment.serviceCategory",
      extractor = { resource -> resource.serviceCategory },
    )

  public val serviceType: SearchParam<Appointment, CodeableConcept> =
    SimpleSearchParam<Appointment, CodeableConcept>(
      name = "service-type",
      type = SearchParamType.fromCode("token"),
      expression = "Appointment.serviceType.concept",
      extractor = { resource -> resource.serviceType.mapNotNull { it.concept } },
    )

  public val serviceTypeReference: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "service-type-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.serviceType.reference",
      target = listOf(HealthcareService::class),
      extractor = { resource -> resource.serviceType.mapNotNull { it.reference } },
    )

  public val slot: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "slot",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.slot",
      target = listOf(Slot::class),
      extractor = { resource -> resource.slot },
    )

  public val specialty: SearchParam<Appointment, CodeableConcept> =
    SimpleSearchParam<Appointment, CodeableConcept>(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "Appointment.specialty",
      extractor = { resource -> resource.specialty },
    )

  public val status: SearchParam<Appointment, Any> =
    SimpleSearchParam<Appointment, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Appointment.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val supportingInfo: SearchParam<Appointment, Reference> =
    SimpleSearchParam<Appointment, Reference>(
      name = "supporting-info",
      type = SearchParamType.fromCode("reference"),
      expression = "Appointment.supportingInformation",
      target =
        listOf(
          Account::class,
          ActivityDefinition::class,
          ActorDefinition::class,
          AdministrableProductDefinition::class,
          AdverseEvent::class,
          AllergyIntolerance::class,
          Appointment::class,
          AppointmentResponse::class,
          ArtifactAssessment::class,
          AuditEvent::class,
          Basic::class,
          Binary::class,
          BiologicallyDerivedProduct::class,
          BiologicallyDerivedProductDispense::class,
          BodyStructure::class,
          Bundle::class,
          CapabilityStatement::class,
          CarePlan::class,
          CareTeam::class,
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
          ConditionDefinition::class,
          Consent::class,
          Contract::class,
          Coverage::class,
          CoverageEligibilityRequest::class,
          CoverageEligibilityResponse::class,
          DetectedIssue::class,
          Device::class,
          DeviceAssociation::class,
          DeviceDefinition::class,
          DeviceDispense::class,
          DeviceMetric::class,
          DeviceRequest::class,
          DeviceUsage::class,
          DiagnosticReport::class,
          DocumentReference::class,
          Encounter::class,
          EncounterHistory::class,
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
          FormularyItem::class,
          GenomicStudy::class,
          Goal::class,
          GraphDefinition::class,
          Group::class,
          GuidanceResponse::class,
          HealthcareService::class,
          ImagingSelection::class,
          ImagingStudy::class,
          Immunization::class,
          ImmunizationEvaluation::class,
          ImmunizationRecommendation::class,
          ImplementationGuide::class,
          Ingredient::class,
          InsurancePlan::class,
          InventoryItem::class,
          InventoryReport::class,
          Invoice::class,
          Library::class,
          Linkage::class,
          R5List::class,
          Location::class,
          ManufacturedItemDefinition::class,
          Measure::class,
          MeasureReport::class,
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
          NutritionIntake::class,
          NutritionOrder::class,
          NutritionProduct::class,
          Observation::class,
          ObservationDefinition::class,
          OperationDefinition::class,
          OperationOutcome::class,
          Organization::class,
          OrganizationAffiliation::class,
          PackagedProductDefinition::class,
          Parameters::class,
          Patient::class,
          PaymentNotice::class,
          PaymentReconciliation::class,
          Permission::class,
          Person::class,
          PlanDefinition::class,
          Practitioner::class,
          PractitionerRole::class,
          Procedure::class,
          Provenance::class,
          Questionnaire::class,
          QuestionnaireResponse::class,
          RegulatedAuthorization::class,
          RelatedPerson::class,
          RequestOrchestration::class,
          Requirements::class,
          ResearchStudy::class,
          ResearchSubject::class,
          RiskAssessment::class,
          Schedule::class,
          SearchParameter::class,
          ServiceRequest::class,
          Slot::class,
          Specimen::class,
          SpecimenDefinition::class,
          StructureDefinition::class,
          StructureMap::class,
          Subscription::class,
          SubscriptionStatus::class,
          SubscriptionTopic::class,
          Substance::class,
          SubstanceDefinition::class,
          SubstanceNucleicAcid::class,
          SubstancePolymer::class,
          SubstanceProtein::class,
          SubstanceReferenceInformation::class,
          SubstanceSourceMaterial::class,
          SupplyDelivery::class,
          SupplyRequest::class,
          Task::class,
          TerminologyCapabilities::class,
          TestPlan::class,
          TestReport::class,
          TestScript::class,
          Transport::class,
          ValueSet::class,
          VerificationResult::class,
          VisionPrescription::class,
        ),
      extractor = { resource -> resource.supportingInformation },
    )

  /** All search parameters for the Appointment resource type. */
  public val all: CollectionsList<SearchParam<Appointment, *>> =
    listOf(
      actor,
      appointmentType,
      basedOn,
      date,
      group,
      identifier,
      location,
      partStatus,
      patient,
      practitioner,
      reasonCode,
      reasonReference,
      requestedPeriod,
      serviceCategory,
      serviceType,
      serviceTypeReference,
      slot,
      specialty,
      status,
      subject,
      supportingInfo,
    )
}
