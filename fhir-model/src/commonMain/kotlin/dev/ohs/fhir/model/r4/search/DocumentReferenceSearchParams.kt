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

import dev.ohs.fhir.model.r4.Account
import dev.ohs.fhir.model.r4.ActivityDefinition
import dev.ohs.fhir.model.r4.AdverseEvent
import dev.ohs.fhir.model.r4.AllergyIntolerance
import dev.ohs.fhir.model.r4.Appointment
import dev.ohs.fhir.model.r4.AppointmentResponse
import dev.ohs.fhir.model.r4.AuditEvent
import dev.ohs.fhir.model.r4.Basic
import dev.ohs.fhir.model.r4.Binary
import dev.ohs.fhir.model.r4.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r4.BodyStructure
import dev.ohs.fhir.model.r4.Bundle
import dev.ohs.fhir.model.r4.CapabilityStatement
import dev.ohs.fhir.model.r4.CarePlan
import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.CatalogEntry
import dev.ohs.fhir.model.r4.ChargeItem
import dev.ohs.fhir.model.r4.ChargeItemDefinition
import dev.ohs.fhir.model.r4.Claim
import dev.ohs.fhir.model.r4.ClaimResponse
import dev.ohs.fhir.model.r4.ClinicalImpression
import dev.ohs.fhir.model.r4.CodeSystem
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Communication
import dev.ohs.fhir.model.r4.CommunicationRequest
import dev.ohs.fhir.model.r4.CompartmentDefinition
import dev.ohs.fhir.model.r4.Composition
import dev.ohs.fhir.model.r4.ConceptMap
import dev.ohs.fhir.model.r4.Condition
import dev.ohs.fhir.model.r4.Consent
import dev.ohs.fhir.model.r4.Contract
import dev.ohs.fhir.model.r4.Coverage
import dev.ohs.fhir.model.r4.CoverageEligibilityRequest
import dev.ohs.fhir.model.r4.CoverageEligibilityResponse
import dev.ohs.fhir.model.r4.DetectedIssue
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.DeviceDefinition
import dev.ohs.fhir.model.r4.DeviceMetric
import dev.ohs.fhir.model.r4.DeviceRequest
import dev.ohs.fhir.model.r4.DeviceUseStatement
import dev.ohs.fhir.model.r4.DiagnosticReport
import dev.ohs.fhir.model.r4.DocumentManifest
import dev.ohs.fhir.model.r4.DocumentReference
import dev.ohs.fhir.model.r4.EffectEvidenceSynthesis
import dev.ohs.fhir.model.r4.Endpoint
import dev.ohs.fhir.model.r4.EnrollmentRequest
import dev.ohs.fhir.model.r4.EnrollmentResponse
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.EventDefinition
import dev.ohs.fhir.model.r4.Evidence
import dev.ohs.fhir.model.r4.EvidenceVariable
import dev.ohs.fhir.model.r4.ExampleScenario
import dev.ohs.fhir.model.r4.ExplanationOfBenefit
import dev.ohs.fhir.model.r4.FamilyMemberHistory
import dev.ohs.fhir.model.r4.Flag
import dev.ohs.fhir.model.r4.Goal
import dev.ohs.fhir.model.r4.GraphDefinition
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.GuidanceResponse
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.ImagingStudy
import dev.ohs.fhir.model.r4.Immunization
import dev.ohs.fhir.model.r4.ImmunizationEvaluation
import dev.ohs.fhir.model.r4.ImmunizationRecommendation
import dev.ohs.fhir.model.r4.ImplementationGuide
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.InsurancePlan
import dev.ohs.fhir.model.r4.Invoice
import dev.ohs.fhir.model.r4.Library
import dev.ohs.fhir.model.r4.Linkage
import dev.ohs.fhir.model.r4.List as R4List
import dev.ohs.fhir.model.r4.Measure
import dev.ohs.fhir.model.r4.MeasureReport
import dev.ohs.fhir.model.r4.Media
import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.MedicationAdministration
import dev.ohs.fhir.model.r4.MedicationDispense
import dev.ohs.fhir.model.r4.MedicationKnowledge
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.MedicationStatement
import dev.ohs.fhir.model.r4.MedicinalProduct
import dev.ohs.fhir.model.r4.MedicinalProductAuthorization
import dev.ohs.fhir.model.r4.MedicinalProductContraindication
import dev.ohs.fhir.model.r4.MedicinalProductIndication
import dev.ohs.fhir.model.r4.MedicinalProductIngredient
import dev.ohs.fhir.model.r4.MedicinalProductInteraction
import dev.ohs.fhir.model.r4.MedicinalProductManufactured
import dev.ohs.fhir.model.r4.MedicinalProductPackaged
import dev.ohs.fhir.model.r4.MedicinalProductPharmaceutical
import dev.ohs.fhir.model.r4.MedicinalProductUndesirableEffect
import dev.ohs.fhir.model.r4.MessageDefinition
import dev.ohs.fhir.model.r4.MessageHeader
import dev.ohs.fhir.model.r4.MolecularSequence
import dev.ohs.fhir.model.r4.NamingSystem
import dev.ohs.fhir.model.r4.NutritionOrder
import dev.ohs.fhir.model.r4.Observation
import dev.ohs.fhir.model.r4.ObservationDefinition
import dev.ohs.fhir.model.r4.OperationDefinition
import dev.ohs.fhir.model.r4.OperationOutcome
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.OrganizationAffiliation
import dev.ohs.fhir.model.r4.PaymentNotice
import dev.ohs.fhir.model.r4.PaymentReconciliation
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Person
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Procedure
import dev.ohs.fhir.model.r4.Provenance
import dev.ohs.fhir.model.r4.Questionnaire
import dev.ohs.fhir.model.r4.QuestionnaireResponse
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.RequestGroup
import dev.ohs.fhir.model.r4.ResearchDefinition
import dev.ohs.fhir.model.r4.ResearchElementDefinition
import dev.ohs.fhir.model.r4.ResearchStudy
import dev.ohs.fhir.model.r4.ResearchSubject
import dev.ohs.fhir.model.r4.RiskAssessment
import dev.ohs.fhir.model.r4.RiskEvidenceSynthesis
import dev.ohs.fhir.model.r4.Schedule
import dev.ohs.fhir.model.r4.SearchParameter
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.Slot
import dev.ohs.fhir.model.r4.Specimen
import dev.ohs.fhir.model.r4.SpecimenDefinition
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.StructureDefinition
import dev.ohs.fhir.model.r4.StructureMap
import dev.ohs.fhir.model.r4.Subscription
import dev.ohs.fhir.model.r4.Substance
import dev.ohs.fhir.model.r4.SubstanceNucleicAcid
import dev.ohs.fhir.model.r4.SubstancePolymer
import dev.ohs.fhir.model.r4.SubstanceProtein
import dev.ohs.fhir.model.r4.SubstanceReferenceInformation
import dev.ohs.fhir.model.r4.SubstanceSourceMaterial
import dev.ohs.fhir.model.r4.SubstanceSpecification
import dev.ohs.fhir.model.r4.SupplyDelivery
import dev.ohs.fhir.model.r4.SupplyRequest
import dev.ohs.fhir.model.r4.Task
import dev.ohs.fhir.model.r4.TerminologyCapabilities
import dev.ohs.fhir.model.r4.TestReport
import dev.ohs.fhir.model.r4.TestScript
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.VerificationResult
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List as CollectionsList

/** Search parameters for the [DocumentReference] resource type. */
public object DocumentReferenceSearchParams {
  public val Authenticator: SearchParam<DocumentReference, Reference> =
    SimpleSearchParam<DocumentReference, Reference>(
      name = "authenticator",
      type = SearchParamType.fromCode("reference"),
      expression = "DocumentReference.authenticator",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.authenticator) },
    )

  public val Author: SearchParam<DocumentReference, Reference> =
    SimpleSearchParam<DocumentReference, Reference>(
      name = "author",
      type = SearchParamType.fromCode("reference"),
      expression = "DocumentReference.author",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.author },
    )

  public val Category: SearchParam<DocumentReference, CodeableConcept> =
    SimpleSearchParam<DocumentReference, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.category",
      extractor = { resource -> resource.category },
    )

  public val Contenttype: SearchParam<DocumentReference, Any> =
    SimpleSearchParam<DocumentReference, Any>(
      name = "contenttype",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.content.attachment.contentType",
      extractor = { resource ->
        resource.content.map { it.attachment }.mapNotNull { it.contentType }
      },
    )

  public val Custodian: SearchParam<DocumentReference, Reference> =
    SimpleSearchParam<DocumentReference, Reference>(
      name = "custodian",
      type = SearchParamType.fromCode("reference"),
      expression = "DocumentReference.custodian",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.custodian) },
    )

  public val Date: SearchParam<DocumentReference, Instant> =
    SimpleSearchParam<DocumentReference, Instant>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "DocumentReference.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<DocumentReference, String> =
    SimpleSearchParam<DocumentReference, String>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "DocumentReference.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Encounter: SearchParam<DocumentReference, Reference> =
    SimpleSearchParam<DocumentReference, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "DocumentReference.context.encounter",
      target = listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class),
      extractor = { resource -> resource.context?.encounter ?: emptyList() },
    )

  public val Event: SearchParam<DocumentReference, CodeableConcept> =
    SimpleSearchParam<DocumentReference, CodeableConcept>(
      name = "event",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.context.event",
      extractor = { resource -> resource.context?.event ?: emptyList() },
    )

  public val Facility: SearchParam<DocumentReference, CodeableConcept> =
    SimpleSearchParam<DocumentReference, CodeableConcept>(
      name = "facility",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.context.facilityType",
      extractor = { resource -> listOfNotNull(resource.context?.facilityType) },
    )

  public val Format: SearchParam<DocumentReference, Coding> =
    SimpleSearchParam<DocumentReference, Coding>(
      name = "format",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.content.format",
      extractor = { resource -> resource.content.mapNotNull { it.format } },
    )

  public val Identifier: SearchParam<DocumentReference, Identifier> =
    SimpleSearchParam<DocumentReference, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.masterIdentifier",
      extractor = { resource -> listOfNotNull(resource.masterIdentifier) },
    )

  public val Language: SearchParam<DocumentReference, Any> =
    SimpleSearchParam<DocumentReference, Any>(
      name = "language",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.content.attachment.language",
      extractor = { resource -> resource.content.map { it.attachment }.mapNotNull { it.language } },
    )

  public val Location: SearchParam<DocumentReference, Url> =
    SimpleSearchParam<DocumentReference, Url>(
      name = "location",
      type = SearchParamType.fromCode("uri"),
      expression = "DocumentReference.content.attachment.url",
      extractor = { resource -> resource.content.map { it.attachment }.mapNotNull { it.url } },
    )

  public val Patient: SearchParam<DocumentReference, Reference> =
    SimpleSearchParam<DocumentReference, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "DocumentReference.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Period: SearchParam<DocumentReference, Period> =
    SimpleSearchParam<DocumentReference, Period>(
      name = "period",
      type = SearchParamType.fromCode("date"),
      expression = "DocumentReference.context.period",
      extractor = { resource -> listOfNotNull(resource.context?.period) },
    )

  public val Related: SearchParam<DocumentReference, Reference> =
    SimpleSearchParam<DocumentReference, Reference>(
      name = "related",
      type = SearchParamType.fromCode("reference"),
      expression = "DocumentReference.context.related",
      target =
        listOf(
          Account::class,
          ActivityDefinition::class,
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
          Claim::class,
          ClaimResponse::class,
          ClinicalImpression::class,
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
          EffectEvidenceSynthesis::class,
          dev.ohs.fhir.model.r4.Encounter::class,
          Endpoint::class,
          EnrollmentRequest::class,
          EnrollmentResponse::class,
          EpisodeOfCare::class,
          EventDefinition::class,
          Evidence::class,
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
          InsurancePlan::class,
          Invoice::class,
          Library::class,
          Linkage::class,
          R4List::class,
          dev.ohs.fhir.model.r4.Location::class,
          Measure::class,
          MeasureReport::class,
          Media::class,
          Medication::class,
          MedicationAdministration::class,
          MedicationDispense::class,
          MedicationKnowledge::class,
          MedicationRequest::class,
          MedicationStatement::class,
          MedicinalProduct::class,
          MedicinalProductAuthorization::class,
          MedicinalProductContraindication::class,
          MedicinalProductIndication::class,
          MedicinalProductIngredient::class,
          MedicinalProductInteraction::class,
          MedicinalProductManufactured::class,
          MedicinalProductPackaged::class,
          MedicinalProductPharmaceutical::class,
          MedicinalProductUndesirableEffect::class,
          MessageDefinition::class,
          MessageHeader::class,
          MolecularSequence::class,
          NamingSystem::class,
          NutritionOrder::class,
          Observation::class,
          ObservationDefinition::class,
          OperationDefinition::class,
          OperationOutcome::class,
          Organization::class,
          OrganizationAffiliation::class,
          dev.ohs.fhir.model.r4.Patient::class,
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
          RelatedPerson::class,
          RequestGroup::class,
          ResearchDefinition::class,
          ResearchElementDefinition::class,
          ResearchStudy::class,
          ResearchSubject::class,
          RiskAssessment::class,
          RiskEvidenceSynthesis::class,
          Schedule::class,
          SearchParameter::class,
          ServiceRequest::class,
          Slot::class,
          Specimen::class,
          SpecimenDefinition::class,
          StructureDefinition::class,
          StructureMap::class,
          Subscription::class,
          Substance::class,
          SubstanceNucleicAcid::class,
          SubstancePolymer::class,
          SubstanceProtein::class,
          SubstanceReferenceInformation::class,
          SubstanceSourceMaterial::class,
          SubstanceSpecification::class,
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
      extractor = { resource -> resource.context?.related ?: emptyList() },
    )

  public val Relatesto: SearchParam<DocumentReference, Reference> =
    SimpleSearchParam<DocumentReference, Reference>(
      name = "relatesto",
      type = SearchParamType.fromCode("reference"),
      expression = "DocumentReference.relatesTo.target",
      target = listOf(DocumentReference::class),
      extractor = { resource -> resource.relatesTo.map { it.target } },
    )

  public val Relation: SearchParam<DocumentReference, Any> =
    SimpleSearchParam<DocumentReference, Any>(
      name = "relation",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.relatesTo.code",
      extractor = { resource -> resource.relatesTo.map { it.code } },
    )

  public val Relationship: SearchParam<DocumentReference, DocumentReference.RelatesTo> =
    SimpleSearchParam<DocumentReference, DocumentReference.RelatesTo>(
      name = "relationship",
      type = SearchParamType.fromCode("composite"),
      expression = "DocumentReference.relatesTo",
      extractor = { resource -> resource.relatesTo },
    )

  public val SecurityLabel: SearchParam<DocumentReference, CodeableConcept> =
    SimpleSearchParam<DocumentReference, CodeableConcept>(
      name = "security-label",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.securityLabel",
      extractor = { resource -> resource.securityLabel },
    )

  public val Setting: SearchParam<DocumentReference, CodeableConcept> =
    SimpleSearchParam<DocumentReference, CodeableConcept>(
      name = "setting",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.context.practiceSetting",
      extractor = { resource -> listOfNotNull(resource.context?.practiceSetting) },
    )

  public val Status: SearchParam<DocumentReference, Any> =
    SimpleSearchParam<DocumentReference, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<DocumentReference, Reference> =
    SimpleSearchParam<DocumentReference, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "DocumentReference.subject",
      target =
        listOf(
          Practitioner::class,
          Group::class,
          Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val Type: SearchParam<DocumentReference, CodeableConcept> =
    SimpleSearchParam<DocumentReference, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "DocumentReference.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the DocumentReference resource type. */
  public val ALL: CollectionsList<SearchParam<DocumentReference, *>> =
    listOf(
      Authenticator,
      Author,
      Category,
      Contenttype,
      Custodian,
      Date,
      Description,
      Encounter,
      Event,
      Facility,
      Format,
      Identifier,
      Language,
      Location,
      Patient,
      Period,
      Related,
      Relatesto,
      Relation,
      Relationship,
      SecurityLabel,
      Setting,
      Status,
      Subject,
      Type,
    )
}
