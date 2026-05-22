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
import dev.ohs.fhir.model.r4b.Canonical
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
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.DetectedIssue
import dev.ohs.fhir.model.r4b.DeviceDefinition
import dev.ohs.fhir.model.r4b.DeviceMetric
import dev.ohs.fhir.model.r4b.DeviceRequest
import dev.ohs.fhir.model.r4b.DeviceUseStatement
import dev.ohs.fhir.model.r4b.DiagnosticReport
import dev.ohs.fhir.model.r4b.DocumentManifest
import dev.ohs.fhir.model.r4b.DocumentReference
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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ImagingStudy
import dev.ohs.fhir.model.r4b.Immunization
import dev.ohs.fhir.model.r4b.ImmunizationEvaluation
import dev.ohs.fhir.model.r4b.ImmunizationRecommendation
import dev.ohs.fhir.model.r4b.ImplementationGuide
import dev.ohs.fhir.model.r4b.Ingredient
import dev.ohs.fhir.model.r4b.InsurancePlan
import dev.ohs.fhir.model.r4b.Invoice
import dev.ohs.fhir.model.r4b.Library
import dev.ohs.fhir.model.r4b.Linkage
import dev.ohs.fhir.model.r4b.List as R4bList
import dev.ohs.fhir.model.r4b.Location
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
import dev.ohs.fhir.model.r4b.Practitioner
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
import dev.ohs.fhir.model.r4b.RiskAssessment
import dev.ohs.fhir.model.r4b.Schedule
import dev.ohs.fhir.model.r4b.SearchParameter
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Slot
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
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.ValueSet
import dev.ohs.fhir.model.r4b.VerificationResult
import dev.ohs.fhir.model.r4b.VisionPrescription
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List as CollectionsList

/** Search parameters for the [DeviceRequest] resource type. */
public object DeviceRequestSearchParam {
  public val AuthoredOn: SearchParam<DeviceRequest, DateTime> =
    SimpleSearchParam<DeviceRequest, DateTime>(
      name = "authored-on",
      type = SearchParamType.fromCode("date"),
      expression = "DeviceRequest.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val BasedOn: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.basedOn",
      target =
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
          dev.ohs.fhir.model.r4b.Device::class,
          DeviceDefinition::class,
          DeviceMetric::class,
          DeviceRequest::class,
          DeviceUseStatement::class,
          DiagnosticReport::class,
          DocumentManifest::class,
          DocumentReference::class,
          dev.ohs.fhir.model.r4b.Encounter::class,
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
          Location::class,
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
          Practitioner::class,
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
          SupplyDelivery::class,
          SupplyRequest::class,
          Task::class,
          TerminologyCapabilities::class,
          TestReport::class,
          TestScript::class,
          ValueSet::class,
          VerificationResult::class,
          VisionPrescription::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val Code: SearchParam<DeviceRequest, CodeableConcept> =
    SimpleSearchParam<DeviceRequest, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "(DeviceRequest.code as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull((resource.code as? DeviceRequest.Code.CodeableConcept)?.value)
      },
    )

  public val Device: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "(DeviceRequest.code as Reference)",
      target = listOf(dev.ohs.fhir.model.r4b.Device::class),
      extractor = { resource ->
        listOfNotNull((resource.code as? DeviceRequest.Code.Reference)?.value)
      },
    )

  public val Encounter: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.encounter",
      target = listOf(dev.ohs.fhir.model.r4b.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val EventDate: SearchParam<DeviceRequest, DateTime> =
    SimpleSearchParam<DeviceRequest, DateTime>(
      name = "event-date",
      type = SearchParamType.fromCode("date"),
      expression = "(DeviceRequest.occurrence as dateTime)",
      extractor = { resource ->
        listOfNotNull((resource.occurrence as? DeviceRequest.Occurrence.DateTime)?.value)
      },
    )

  public val GroupIdentifier: SearchParam<DeviceRequest, Identifier> =
    SimpleSearchParam<DeviceRequest, Identifier>(
      name = "group-identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceRequest.groupIdentifier",
      extractor = { resource -> listOfNotNull(resource.groupIdentifier) },
    )

  public val Identifier: SearchParam<DeviceRequest, Identifier> =
    SimpleSearchParam<DeviceRequest, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val InstantiatesCanonical: SearchParam<DeviceRequest, Canonical> =
    SimpleSearchParam<DeviceRequest, Canonical>(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.instantiatesCanonical",
      target = listOf(PlanDefinition::class, ActivityDefinition::class),
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val InstantiatesUri: SearchParam<DeviceRequest, Uri> =
    SimpleSearchParam<DeviceRequest, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "DeviceRequest.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val Insurance: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "insurance",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.insurance",
      target = listOf(ClaimResponse::class, Coverage::class),
      extractor = { resource -> resource.insurance },
    )

  public val Intent: SearchParam<DeviceRequest, Any> =
    SimpleSearchParam<DeviceRequest, Any>(
      name = "intent",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceRequest.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val Patient: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.performer",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          dev.ohs.fhir.model.r4b.Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.performer) },
    )

  public val PriorRequest: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "prior-request",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.priorRequest",
      target =
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
          dev.ohs.fhir.model.r4b.Device::class,
          DeviceDefinition::class,
          DeviceMetric::class,
          DeviceRequest::class,
          DeviceUseStatement::class,
          DiagnosticReport::class,
          DocumentManifest::class,
          DocumentReference::class,
          dev.ohs.fhir.model.r4b.Encounter::class,
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
          Location::class,
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
          Practitioner::class,
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
          SupplyDelivery::class,
          SupplyRequest::class,
          Task::class,
          TerminologyCapabilities::class,
          TestReport::class,
          TestScript::class,
          ValueSet::class,
          VerificationResult::class,
          VisionPrescription::class,
        ),
      extractor = { resource -> resource.priorRequest },
    )

  public val Requester: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "requester",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.requester",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          dev.ohs.fhir.model.r4b.Device::class,
          PractitionerRole::class,
        ),
      extractor = { resource -> listOfNotNull(resource.requester) },
    )

  public val Status: SearchParam<DeviceRequest, Any> =
    SimpleSearchParam<DeviceRequest, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceRequest.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Subject: SearchParam<DeviceRequest, Reference> =
    SimpleSearchParam<DeviceRequest, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceRequest.subject",
      target =
        listOf(
          Group::class,
          dev.ohs.fhir.model.r4b.Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          Location::class,
        ),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the DeviceRequest resource type. */
  public val ALL: CollectionsList<SearchParam<DeviceRequest, *>> =
    listOf(
      AuthoredOn,
      BasedOn,
      Code,
      Device,
      Encounter,
      EventDate,
      GroupIdentifier,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Insurance,
      Intent,
      Patient,
      Performer,
      PriorRequest,
      Requester,
      Status,
      Subject,
    )
}
