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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.DetectedIssue
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
import dev.ohs.fhir.model.r4.InsurancePlan
import dev.ohs.fhir.model.r4.Invoice
import dev.ohs.fhir.model.r4.Library
import dev.ohs.fhir.model.r4.Linkage
import dev.ohs.fhir.model.r4.List as R4List
import dev.ohs.fhir.model.r4.Location
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
import dev.ohs.fhir.model.r4.Person
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Procedure
import dev.ohs.fhir.model.r4.Provenance
import dev.ohs.fhir.model.r4.Quantity
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
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.VerificationResult
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
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
      target = listOf(dev.ohs.fhir.model.r4.Device::class, DeviceMetric::class),
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
      target = listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class),
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
          dev.ohs.fhir.model.r4.Device::class,
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
          Location::class,
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
          dev.ohs.fhir.model.r4.Specimen::class,
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
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
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
          dev.ohs.fhir.model.r4.Patient::class,
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
      target = listOf(dev.ohs.fhir.model.r4.Specimen::class),
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
          Group::class,
          dev.ohs.fhir.model.r4.Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
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
