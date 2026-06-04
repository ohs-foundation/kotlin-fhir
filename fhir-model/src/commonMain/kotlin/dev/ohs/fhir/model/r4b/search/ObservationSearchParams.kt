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
import dev.ohs.fhir.model.r4b.Patient
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
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List as CollectionsList

/** Search parameters for the [Observation] resource type. */
public object ObservationSearchParams {
  public val aminoAcidChange: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "amino-acid-change",
      type = SearchParamType.fromCode("string"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')",
      extractor = { emptyList() },
    )

  public val basedOn: SearchParam<Observation, Reference> =
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

  public val category: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val codeValueConcept: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "code-value-concept",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation",
      extractor = { emptyList() },
    )

  public val codeValueDate: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "code-value-date",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation",
      extractor = { emptyList() },
    )

  public val codeValueQuantity: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "code-value-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation",
      extractor = { emptyList() },
    )

  public val codeValueString: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "code-value-string",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation",
      extractor = { emptyList() },
    )

  public val comboCode: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "combo-code",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val comboCodeValueConcept: SearchParam<Observation, Observation.Component> =
    SimpleSearchParam<Observation, Observation.Component>(
      name = "combo-code-value-concept",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val comboCodeValueQuantity: SearchParam<Observation, Observation.Component> =
    SimpleSearchParam<Observation, Observation.Component>(
      name = "combo-code-value-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val comboDataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "combo-data-absent-reason",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.dataAbsentReason",
      extractor = { resource -> listOfNotNull(resource.dataAbsentReason) },
    )

  public val comboValueConcept: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "combo-value-concept",
      type = SearchParamType.fromCode("token"),
      expression = "(Observation.value as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.CodeableConcept)?.value)
      },
    )

  public val comboValueQuantity: SearchParam<Observation, Quantity> =
    SimpleSearchParam<Observation, Quantity>(
      name = "combo-value-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Observation.value as Quantity)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.Quantity)?.value)
      },
    )

  public val componentCode: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "component-code",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.component.code",
      extractor = { resource -> resource.component.map { it.code } },
    )

  public val componentCodeValueConcept: SearchParam<Observation, Observation.Component> =
    SimpleSearchParam<Observation, Observation.Component>(
      name = "component-code-value-concept",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val componentCodeValueQuantity: SearchParam<Observation, Observation.Component> =
    SimpleSearchParam<Observation, Observation.Component>(
      name = "component-code-value-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val componentDataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "component-data-absent-reason",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.component.dataAbsentReason",
      extractor = { resource -> resource.component.mapNotNull { it.dataAbsentReason } },
    )

  public val componentValueConcept: SearchParam<Observation, CodeableConcept> =
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

  public val componentValueQuantity: SearchParam<Observation, Quantity> =
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

  public val dataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "data-absent-reason",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.dataAbsentReason",
      extractor = { resource -> listOfNotNull(resource.dataAbsentReason) },
    )

  public val date: SearchParam<Observation, Observation.Effective> =
    SimpleSearchParam<Observation, Observation.Effective>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Observation.effective",
      extractor = { resource -> listOfNotNull(resource.effective) },
    )

  public val derivedFrom: SearchParam<Observation, Reference> =
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

  public val device: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.device",
      target = listOf(Device::class, DeviceMetric::class),
      extractor = { resource -> listOfNotNull(resource.device) },
    )

  public val dnaVariant: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "dna-variant",
      type = SearchParamType.fromCode("string"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')",
      extractor = { emptyList() },
    )

  public val encounter: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val focus: SearchParam<Observation, Reference> =
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
          Patient::class,
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
      extractor = { resource -> resource.focus },
    )

  public val geneAminoAcidChange: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "gene-amino-acid-change",
      type = SearchParamType.fromCode("string"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')",
      extractor = { emptyList() },
    )

  public val geneDnavariant: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "gene-dnavariant",
      type = SearchParamType.fromCode("string"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')",
      extractor = { emptyList() },
    )

  public val geneIdentifier: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "gene-identifier",
      type = SearchParamType.fromCode("token"),
      expression =
        "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsGene')",
      extractor = { emptyList() },
    )

  public val hasMember: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "has-member",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.hasMember",
      target = listOf(Observation::class, MolecularSequence::class, QuestionnaireResponse::class),
      extractor = { resource -> resource.hasMember },
    )

  public val identifier: SearchParam<Observation, Identifier> =
    SimpleSearchParam<Observation, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val method: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "method",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.method",
      extractor = { resource -> listOfNotNull(resource.method) },
    )

  public val partOf: SearchParam<Observation, Reference> =
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

  public val patient: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.performer",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer },
    )

  public val specimen: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "specimen",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.specimen",
      target = listOf(Specimen::class),
      extractor = { resource -> listOfNotNull(resource.specimen) },
    )

  public val status: SearchParam<Observation, Any> =
    SimpleSearchParam<Observation, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Observation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Observation, Reference> =
    SimpleSearchParam<Observation, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Observation.subject",
      target =
        listOf(
          Practitioner::class,
          Group::class,
          Organization::class,
          Device::class,
          Medication::class,
          Patient::class,
          Procedure::class,
          Substance::class,
          Location::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val valueConcept: SearchParam<Observation, CodeableConcept> =
    SimpleSearchParam<Observation, CodeableConcept>(
      name = "value-concept",
      type = SearchParamType.fromCode("token"),
      expression = "(Observation.value as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.CodeableConcept)?.value)
      },
    )

  public val valueDate: SearchParam<Observation, DateTime> =
    SimpleSearchParam<Observation, DateTime>(
      name = "value-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Observation.value as dateTime)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.DateTime)?.value)
      },
    )

  public val valueQuantity: SearchParam<Observation, Quantity> =
    SimpleSearchParam<Observation, Quantity>(
      name = "value-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Observation.value as Quantity)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.Quantity)?.value)
      },
    )

  public val valueString: SearchParam<Observation, String> =
    SimpleSearchParam<Observation, String>(
      name = "value-string",
      type = SearchParamType.fromCode("string"),
      expression = "(Observation.value as string)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.String)?.value)
      },
    )

  /** All search parameters for the Observation resource type. */
  public val all: CollectionsList<SearchParam<Observation, *>> =
    listOf(
      aminoAcidChange,
      basedOn,
      category,
      code,
      codeValueConcept,
      codeValueDate,
      codeValueQuantity,
      codeValueString,
      comboCode,
      comboCodeValueConcept,
      comboCodeValueQuantity,
      comboDataAbsentReason,
      comboValueConcept,
      comboValueQuantity,
      componentCode,
      componentCodeValueConcept,
      componentCodeValueQuantity,
      componentDataAbsentReason,
      componentValueConcept,
      componentValueQuantity,
      dataAbsentReason,
      date,
      derivedFrom,
      device,
      dnaVariant,
      encounter,
      focus,
      geneAminoAcidChange,
      geneDnavariant,
      geneIdentifier,
      hasMember,
      identifier,
      method,
      partOf,
      patient,
      performer,
      specimen,
      status,
      subject,
      valueConcept,
      valueDate,
      valueQuantity,
      valueString,
    )
}
