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
import dev.ohs.fhir.model.r4b.Age
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
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.DetectedIssue
import dev.ohs.fhir.model.r4b.Device
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
import dev.ohs.fhir.model.r4b.String
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
import kotlin.Suppress
import kotlin.collections.List as CollectionsList

/** Search parameters for the [Condition] resource type. */
public object ConditionSearchParams {
  public val AbatementAge: SearchParam<Condition, Age> =
    SimpleSearchParam<Condition, Age>(
      name = "abatement-age",
      type = SearchParamType.fromCode("quantity"),
      expression = "Condition.abatement.as(Age)",
      extractor = { resource ->
        listOfNotNull((resource.abatement as? Condition.Abatement.Age)?.value)
      },
    )

  public val AbatementDate: SearchParam<Condition, DateTime> =
    SimpleSearchParam<Condition, DateTime>(
      name = "abatement-date",
      type = SearchParamType.fromCode("date"),
      expression = "Condition.abatement.as(dateTime)",
      extractor = { resource ->
        listOfNotNull((resource.abatement as? Condition.Abatement.DateTime)?.value)
      },
    )

  public val AbatementString: SearchParam<Condition, String> =
    SimpleSearchParam<Condition, String>(
      name = "abatement-string",
      type = SearchParamType.fromCode("string"),
      expression = "Condition.abatement.as(string)",
      extractor = { resource ->
        listOfNotNull((resource.abatement as? Condition.Abatement.String)?.value)
      },
    )

  public val Asserter: SearchParam<Condition, Reference> =
    SimpleSearchParam<Condition, Reference>(
      name = "asserter",
      type = SearchParamType.fromCode("reference"),
      expression = "Condition.asserter",
      target =
        listOf(
          Practitioner::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.asserter) },
    )

  public val BodySite: SearchParam<Condition, CodeableConcept> =
    SimpleSearchParam<Condition, CodeableConcept>(
      name = "body-site",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.bodySite",
      extractor = { resource -> resource.bodySite },
    )

  public val Category: SearchParam<Condition, CodeableConcept> =
    SimpleSearchParam<Condition, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.category",
      extractor = { resource -> resource.category },
    )

  public val ClinicalStatus: SearchParam<Condition, CodeableConcept> =
    SimpleSearchParam<Condition, CodeableConcept>(
      name = "clinical-status",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.clinicalStatus",
      extractor = { resource -> listOfNotNull(resource.clinicalStatus) },
    )

  public val Code: SearchParam<Condition, CodeableConcept> =
    SimpleSearchParam<Condition, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Encounter: SearchParam<Condition, Reference> =
    SimpleSearchParam<Condition, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Condition.encounter",
      target = listOf(dev.ohs.fhir.model.r4b.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Evidence: SearchParam<Condition, CodeableConcept> =
    SimpleSearchParam<Condition, CodeableConcept>(
      name = "evidence",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.evidence.code",
      extractor = { resource -> resource.evidence.flatMap { it.code } },
    )

  public val EvidenceDetail: SearchParam<Condition, Reference> =
    SimpleSearchParam<Condition, Reference>(
      name = "evidence-detail",
      type = SearchParamType.fromCode("reference"),
      expression = "Condition.evidence.detail",
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
          Device::class,
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
          dev.ohs.fhir.model.r4b.Evidence::class,
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
      extractor = { resource -> resource.evidence.flatMap { it.detail } },
    )

  public val Identifier: SearchParam<Condition, Identifier> =
    SimpleSearchParam<Condition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val OnsetAge: SearchParam<Condition, Age> =
    SimpleSearchParam<Condition, Age>(
      name = "onset-age",
      type = SearchParamType.fromCode("quantity"),
      expression = "Condition.onset.as(Age)",
      extractor = { resource -> listOfNotNull((resource.onset as? Condition.Onset.Age)?.value) },
    )

  public val OnsetDate: SearchParam<Condition, DateTime> =
    SimpleSearchParam<Condition, DateTime>(
      name = "onset-date",
      type = SearchParamType.fromCode("date"),
      expression = "Condition.onset.as(dateTime)",
      extractor = { resource ->
        listOfNotNull((resource.onset as? Condition.Onset.DateTime)?.value)
      },
    )

  public val OnsetInfo: SearchParam<Condition, String> =
    SimpleSearchParam<Condition, String>(
      name = "onset-info",
      type = SearchParamType.fromCode("string"),
      expression = "Condition.onset.as(string)",
      extractor = { resource -> listOfNotNull((resource.onset as? Condition.Onset.String)?.value) },
    )

  public val Patient: SearchParam<Condition, Reference> =
    SimpleSearchParam<Condition, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Condition.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val RecordedDate: SearchParam<Condition, DateTime> =
    SimpleSearchParam<Condition, DateTime>(
      name = "recorded-date",
      type = SearchParamType.fromCode("date"),
      expression = "Condition.recordedDate",
      extractor = { resource -> listOfNotNull(resource.recordedDate) },
    )

  public val Severity: SearchParam<Condition, CodeableConcept> =
    SimpleSearchParam<Condition, CodeableConcept>(
      name = "severity",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.severity",
      extractor = { resource -> listOfNotNull(resource.severity) },
    )

  public val Stage: SearchParam<Condition, CodeableConcept> =
    SimpleSearchParam<Condition, CodeableConcept>(
      name = "stage",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.stage.summary",
      extractor = { resource -> resource.stage.mapNotNull { it.summary } },
    )

  public val Subject: SearchParam<Condition, Reference> =
    SimpleSearchParam<Condition, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Condition.subject",
      target = listOf(Organization::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val VerificationStatus: SearchParam<Condition, CodeableConcept> =
    SimpleSearchParam<Condition, CodeableConcept>(
      name = "verification-status",
      type = SearchParamType.fromCode("token"),
      expression = "Condition.verificationStatus",
      extractor = { resource -> listOfNotNull(resource.verificationStatus) },
    )

  /** All search parameters for the Condition resource type. */
  public val ALL: CollectionsList<SearchParam<Condition, *>> =
    listOf(
      AbatementAge,
      AbatementDate,
      AbatementString,
      Asserter,
      BodySite,
      Category,
      ClinicalStatus,
      Code,
      Encounter,
      Evidence,
      EvidenceDetail,
      Identifier,
      OnsetAge,
      OnsetDate,
      OnsetInfo,
      Patient,
      RecordedDate,
      Severity,
      Stage,
      Subject,
      VerificationStatus,
    )
}
