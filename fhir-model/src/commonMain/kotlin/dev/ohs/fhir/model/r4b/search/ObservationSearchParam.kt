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
import dev.ohs.fhir.model.r4b.Quantity
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
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List as CollectionsList

/** Search parameters for the [Observation] resource type. */
public object ObservationSearchParam {
  public val AminoAcidChange: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "amino-acid-change",
      type = SearchParamType.fromCode("string"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')",
      extractor = { emptyList() },
    )

  public val BasedOn: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.basedOn",
      target =
        listOf(
          CarePlan::class,
          MedicationRequest::class,
          NutritionOrder::class,
          DeviceRequest::class,
          ServiceRequest::class,
          ImmunizationRecommendation::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val Category: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.category",
      extractor = { resource -> resource.category },
    )

  public val Code: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val CodeValueConcept: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "code-value-concept",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation",
      extractor = { emptyList() },
    )

  public val CodeValueDate: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "code-value-date",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation",
      extractor = { emptyList() },
    )

  public val CodeValueQuantity: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "code-value-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation",
      extractor = { emptyList() },
    )

  public val CodeValueString: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "code-value-string",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation",
      extractor = { emptyList() },
    )

  public val ComboCode: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "combo-code",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val ComboCodeValueConcept: SearchParam<Observation, Observation.Component> =
    SimpleSearchParam<Observation, Observation.Component>(
      name = "combo-code-value-concept",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val ComboCodeValueQuantity: SearchParam<Observation, Observation.Component> =
    SimpleSearchParam<Observation, Observation.Component>(
      name = "combo-code-value-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val ComboDataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "combo-data-absent-reason",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.dataAbsentReason",
      extractor = { resource -> listOfNotNull(resource.dataAbsentReason) },
    )

  public val ComboValueConcept: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "combo-value-concept",
      type = SearchParamType.fromCode("token"),
      expression = "(Observation.value as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.CodeableConcept)?.value)
      },
    )

  public val ComboValueQuantity: SearchParam<Observation, Quantity> =
    SimpleSearchParam<Observation, Quantity>(
      name = "combo-value-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Observation.value as Quantity)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.Quantity)?.value)
      },
    )

  public val ComponentCode: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "component-code",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.component.code",
      extractor = { resource -> resource.component.map { it.code } },
    )

  public val ComponentCodeValueConcept: SearchParam<Observation, Observation.Component> =
    SimpleSearchParam<Observation, Observation.Component>(
      name = "component-code-value-concept",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val ComponentCodeValueQuantity: SearchParam<Observation, Observation.Component> =
    SimpleSearchParam<Observation, Observation.Component>(
      name = "component-code-value-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val ComponentDataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "component-data-absent-reason",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.component.dataAbsentReason",
      extractor = { resource -> resource.component.mapNotNull { it.dataAbsentReason } },
    )

  public val ComponentValueConcept: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "component-value-concept",
      type = SearchParamType.fromCode("token"),
      expression = "(Observation.component.value as CodeableConcept)",
      extractor = { resource ->
        resource.component.mapNotNull {
          (it.`value` as? Observation.Component.Value.CodeableConcept)?.value
        }
      },
    )

  public val ComponentValueQuantity: SearchParam<Observation, Quantity> =
    SimpleSearchParam<Observation, Quantity>(
      name = "component-value-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Observation.component.value as Quantity)",
      extractor = { resource ->
        resource.component.mapNotNull {
          (it.`value` as? Observation.Component.Value.Quantity)?.value
        }
      },
    )

  public val DataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "data-absent-reason",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.dataAbsentReason",
      extractor = { resource -> listOfNotNull(resource.dataAbsentReason) },
    )

  public val Date: SearchParam<Observation, Observation.Effective> =
    SimpleSearchParam<Observation, Observation.Effective>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Observation.effective",
      extractor = { resource -> listOfNotNull(resource.effective) },
    )

  public val DerivedFrom: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "derived-from",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.derivedFrom",
      target =
        listOf(
          Media::class,
          Observation::class,
          ImagingStudy::class,
          MolecularSequence::class,
          QuestionnaireResponse::class,
          DocumentReference::class,
        ),
      extractor = { resource -> resource.derivedFrom },
    )

  public val Device: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.device",
      target = listOf(dev.ohs.fhir.model.r4b.Device::class, DeviceMetric::class),
      extractor = { resource -> listOfNotNull(resource.device) },
    )

  public val DnaVariant: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "dna-variant",
      type = SearchParamType.fromCode("string"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')",
      extractor = { emptyList() },
    )

  public val Encounter: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.encounter",
      target = listOf(dev.ohs.fhir.model.r4b.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Focus: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "focus",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.focus",
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
          dev.ohs.fhir.model.r4b.Specimen::class,
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
      extractor = { resource -> resource.focus },
    )

  public val GeneAminoAcidChange: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "gene-amino-acid-change",
      type = SearchParamType.fromCode("string"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')",
      extractor = { emptyList() },
    )

  public val GeneDnavariant: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "gene-dnavariant",
      type = SearchParamType.fromCode("string"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')",
      extractor = { emptyList() },
    )

  public val GeneIdentifier: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "gene-identifier",
      type = SearchParamType.fromCode("token"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsGene')",
      extractor = { emptyList() },
    )

  public val HasMember: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "has-member",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.hasMember",
      target = listOf(Observation::class, MolecularSequence::class, QuestionnaireResponse::class),
      extractor = { resource -> resource.hasMember },
    )

  public val Identifier: SearchParam<Observation, Identifier> =
    SimpleSearchParam<Observation, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Method: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "method",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.method",
      extractor = { resource -> listOfNotNull(resource.method) },
    )

  public val PartOf: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.partOf",
      target =
        listOf(
          Immunization::class,
          MedicationDispense::class,
          MedicationAdministration::class,
          Procedure::class,
          ImagingStudy::class,
          MedicationStatement::class,
        ),
      extractor = { resource -> resource.partOf },
    )

  public val Patient: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.performer",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer },
    )

  public val Specimen: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "specimen",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.specimen",
      target = listOf(dev.ohs.fhir.model.r4b.Specimen::class),
      extractor = { resource -> listOfNotNull(resource.specimen) },
    )

  public val Status: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.subject",
      target =
        listOf(
          Practitioner::class,
          Group::class,
          Organization::class,
          dev.ohs.fhir.model.r4b.Device::class,
          Medication::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          Procedure::class,
          Substance::class,
          Location::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val ValueConcept: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "value-concept",
      type = SearchParamType.fromCode("token"),
      expression = "(Observation.value as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.CodeableConcept)?.value)
      },
    )

  public val ValueDate: SearchParam<Observation, DateTime> =
    SimpleSearchParam<Observation, DateTime>(
      name = "value-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Observation.value as dateTime)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.DateTime)?.value)
      },
    )

  public val ValueQuantity: SearchParam<Observation, Quantity> =
    SimpleSearchParam<Observation, Quantity>(
      name = "value-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Observation.value as Quantity)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.Quantity)?.value)
      },
    )

  public val ValueString: SearchParam<Observation, String> =
    SimpleSearchParam<Observation, String>(
      name = "value-string",
      type = SearchParamType.fromCode("string"),
      expression = "(Observation.value as string)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.String)?.value)
      },
    )

  /** All search parameters for the Observation resource type. */
  public val ALL: CollectionsList<SearchParam<Observation, *>> =
    listOf(
      AminoAcidChange,
      BasedOn,
      Category,
      Code,
      CodeValueConcept,
      CodeValueDate,
      CodeValueQuantity,
      CodeValueString,
      ComboCode,
      ComboCodeValueConcept,
      ComboCodeValueQuantity,
      ComboDataAbsentReason,
      ComboValueConcept,
      ComboValueQuantity,
      ComponentCode,
      ComponentCodeValueConcept,
      ComponentCodeValueQuantity,
      ComponentDataAbsentReason,
      ComponentValueConcept,
      ComponentValueQuantity,
      DataAbsentReason,
      Date,
      DerivedFrom,
      Device,
      DnaVariant,
      Encounter,
      Focus,
      GeneAminoAcidChange,
      GeneDnavariant,
      GeneIdentifier,
      HasMember,
      Identifier,
      Method,
      PartOf,
      Patient,
      Performer,
      Specimen,
      Status,
      Subject,
      ValueConcept,
      ValueDate,
      ValueQuantity,
      ValueString,
    )
}
