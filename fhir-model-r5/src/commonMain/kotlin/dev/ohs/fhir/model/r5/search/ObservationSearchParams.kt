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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

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
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List as CollectionsList

/** Search parameters for the [Observation] resource type. */
public object ObservationSearchParams {
  public val basedOn: SearchParam<Observation, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.Reference,
      expression = "Observation.basedOn",
      target =
        listOf(
          DeviceRequest::class,
          ServiceRequest::class,
          CarePlan::class,
          MedicationRequest::class,
          ImmunizationRecommendation::class,
          NutritionOrder::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val category: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "Observation.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "Observation.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val codeValueConcept: SearchParam<Observation, Any> =
    SearchParam(
      name = "code-value-concept",
      type = SearchParamType.Composite,
      expression = "Observation",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'code-value-concept' has expression 'Observation' which is not yet supported."
        )
      },
    )

  public val codeValueDate: SearchParam<Observation, Any> =
    SearchParam(
      name = "code-value-date",
      type = SearchParamType.Composite,
      expression = "Observation",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'code-value-date' has expression 'Observation' which is not yet supported."
        )
      },
    )

  public val codeValueQuantity: SearchParam<Observation, Any> =
    SearchParam(
      name = "code-value-quantity",
      type = SearchParamType.Composite,
      expression = "Observation",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'code-value-quantity' has expression 'Observation' which is not yet supported."
        )
      },
    )

  public val codeValueString: SearchParam<Observation, Any> =
    SearchParam(
      name = "code-value-string",
      type = SearchParamType.Composite,
      expression = "Observation",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'code-value-string' has expression 'Observation' which is not yet supported."
        )
      },
    )

  public val comboCode: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "combo-code",
      type = SearchParamType.Token,
      expression = "Observation.code | Observation.component.code",
      extractor = { resource ->
        buildList {
            addAll(listOf(resource.code))
            addAll(resource.component.map { it.code })
          }
          .distinct()
      },
    )

  public val comboCodeValueConcept: SearchParam<Observation, Observation.Component> =
    SearchParam(
      name = "combo-code-value-concept",
      type = SearchParamType.Composite,
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val comboCodeValueQuantity: SearchParam<Observation, Observation.Component> =
    SearchParam(
      name = "combo-code-value-quantity",
      type = SearchParamType.Composite,
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val comboDataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "combo-data-absent-reason",
      type = SearchParamType.Token,
      expression = "Observation.dataAbsentReason | Observation.component.dataAbsentReason",
      extractor = { resource ->
        buildList {
            addAll(listOfNotNull(resource.dataAbsentReason))
            addAll(resource.component.mapNotNull { it.dataAbsentReason })
          }
          .distinct()
      },
    )

  public val comboValueConcept: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "combo-value-concept",
      type = SearchParamType.Token,
      expression =
        "Observation.value.ofType(CodeableConcept) | Observation.component.value.ofType(CodeableConcept)",
      extractor = { resource ->
        buildList {
            addAll(listOfNotNull((resource.`value` as? Observation.Value.CodeableConcept)?.value))
            addAll(
              resource.component.mapNotNull {
                (it.`value` as? Observation.Component.Value.CodeableConcept)?.value
              }
            )
          }
          .distinct()
      },
    )

  public val comboValueQuantity: SearchParam<Observation, Any> =
    SearchParam(
      name = "combo-value-quantity",
      type = SearchParamType.Quantity,
      expression =
        "Observation.value.ofType(Quantity) | Observation.value.ofType(SampledData) | Observation.component.value.ofType(Quantity) | Observation.component.value.ofType(SampledData)",
      extractor = { resource ->
        buildList {
            addAll(listOfNotNull((resource.`value` as? Observation.Value.Quantity)?.value))
            addAll(listOfNotNull((resource.`value` as? Observation.Value.SampledData)?.value))
            addAll(
              resource.component.mapNotNull {
                (it.`value` as? Observation.Component.Value.Quantity)?.value
              }
            )
            addAll(
              resource.component.mapNotNull {
                (it.`value` as? Observation.Component.Value.SampledData)?.value
              }
            )
          }
          .distinct()
      },
    )

  public val componentCode: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "component-code",
      type = SearchParamType.Token,
      expression = "Observation.component.code",
      extractor = { resource -> resource.component.map { it.code } },
    )

  public val componentCodeValueConcept: SearchParam<Observation, Observation.Component> =
    SearchParam(
      name = "component-code-value-concept",
      type = SearchParamType.Composite,
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val componentCodeValueQuantity: SearchParam<Observation, Observation.Component> =
    SearchParam(
      name = "component-code-value-quantity",
      type = SearchParamType.Composite,
      expression = "Observation.component",
      extractor = { resource -> resource.component },
    )

  public val componentDataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "component-data-absent-reason",
      type = SearchParamType.Token,
      expression = "Observation.component.dataAbsentReason",
      extractor = { resource -> resource.component.mapNotNull { it.dataAbsentReason } },
    )

  public val componentValueCanonical: SearchParam<Observation, Any> =
    SearchParam(
      name = "component-value-canonical",
      type = SearchParamType.Uri,
      expression = "Observation.component.value.ofType(canonical)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'component-value-canonical' has expression 'Observation.component.value.ofType(canonical)' which is not yet supported."
        )
      },
    )

  public val componentValueConcept: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "component-value-concept",
      type = SearchParamType.Token,
      expression = "Observation.component.value.ofType(CodeableConcept)",
      extractor = { resource ->
        resource.component.mapNotNull {
          (it.`value` as? Observation.Component.Value.CodeableConcept)?.value
        }
      },
    )

  public val componentValueQuantity: SearchParam<Observation, Any> =
    SearchParam(
      name = "component-value-quantity",
      type = SearchParamType.Quantity,
      expression =
        "Observation.component.value.ofType(Quantity) | Observation.component.value.ofType(SampledData)",
      extractor = { resource ->
        buildList {
            addAll(
              resource.component.mapNotNull {
                (it.`value` as? Observation.Component.Value.Quantity)?.value
              }
            )
            addAll(
              resource.component.mapNotNull {
                (it.`value` as? Observation.Component.Value.SampledData)?.value
              }
            )
          }
          .distinct()
      },
    )

  public val componentValueReference: SearchParam<Observation, Reference> =
    SearchParam(
      name = "component-value-reference",
      type = SearchParamType.Reference,
      expression = "Observation.component.value.ofType(Reference)",
      target = listOf(MolecularSequence::class),
      extractor = { resource ->
        resource.component.mapNotNull {
          (it.`value` as? Observation.Component.Value.Reference)?.value
        }
      },
    )

  public val dataAbsentReason: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "data-absent-reason",
      type = SearchParamType.Token,
      expression = "Observation.dataAbsentReason",
      extractor = { resource -> listOfNotNull(resource.dataAbsentReason) },
    )

  public val date: SearchParam<Observation, Any> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression =
        "Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant)",
      extractor = { resource ->
        buildList {
            addAll(listOfNotNull((resource.effective as? Observation.Effective.DateTime)?.value))
            addAll(listOfNotNull((resource.effective as? Observation.Effective.Period)?.value))
            addAll(listOfNotNull((resource.effective as? Observation.Effective.Timing)?.value))
            addAll(listOfNotNull((resource.effective as? Observation.Effective.Instant)?.value))
          }
          .distinct()
      },
    )

  public val derivedFrom: SearchParam<Observation, Reference> =
    SearchParam(
      name = "derived-from",
      type = SearchParamType.Reference,
      expression = "Observation.derivedFrom",
      target =
        listOf(
          ImagingStudy::class,
          DocumentReference::class,
          Observation::class,
          MolecularSequence::class,
          GenomicStudy::class,
          ImagingSelection::class,
          QuestionnaireResponse::class,
        ),
      extractor = { resource -> resource.derivedFrom },
    )

  public val device: SearchParam<Observation, Reference> =
    SearchParam(
      name = "device",
      type = SearchParamType.Reference,
      expression = "Observation.device",
      target = listOf(Device::class, DeviceMetric::class),
      extractor = { resource -> listOfNotNull(resource.device) },
    )

  public val encounter: SearchParam<Observation, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "Observation.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val focus: SearchParam<Observation, Reference> =
    SearchParam(
      name = "focus",
      type = SearchParamType.Reference,
      expression = "Observation.focus",
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
      extractor = { resource -> resource.focus },
    )

  public val hasMember: SearchParam<Observation, Reference> =
    SearchParam(
      name = "has-member",
      type = SearchParamType.Reference,
      expression = "Observation.hasMember",
      target = listOf(Observation::class, MolecularSequence::class, QuestionnaireResponse::class),
      extractor = { resource -> resource.hasMember },
    )

  public val identifier: SearchParam<Observation, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Observation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val method: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "method",
      type = SearchParamType.Token,
      expression = "Observation.method",
      extractor = { resource -> listOfNotNull(resource.method) },
    )

  public val partOf: SearchParam<Observation, Reference> =
    SearchParam(
      name = "part-of",
      type = SearchParamType.Reference,
      expression = "Observation.partOf",
      target =
        listOf(
          ImagingStudy::class,
          Procedure::class,
          MedicationStatement::class,
          MedicationAdministration::class,
          GenomicStudy::class,
          Immunization::class,
          MedicationDispense::class,
        ),
      extractor = { resource -> resource.partOf },
    )

  public val patient: SearchParam<Observation, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Observation.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter { it.reference?.value?.contains("Patient/") == true }
      },
    )

  public val performer: SearchParam<Observation, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.Reference,
      expression = "Observation.performer",
      target =
        listOf(
          Organization::class,
          CareTeam::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.performer },
    )

  public val specimen: SearchParam<Observation, Reference> =
    SearchParam(
      name = "specimen",
      type = SearchParamType.Reference,
      expression = "Observation.specimen",
      target = listOf(Group::class, Specimen::class),
      extractor = { resource -> listOfNotNull(resource.specimen) },
    )

  public val status: SearchParam<Observation, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Observation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Observation, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "Observation.subject",
      target =
        listOf(
          Device::class,
          Organization::class,
          Procedure::class,
          NutritionProduct::class,
          Group::class,
          Practitioner::class,
          BiologicallyDerivedProduct::class,
          Substance::class,
          Location::class,
          Patient::class,
          Medication::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val valueCanonical: SearchParam<Observation, Any> =
    SearchParam(
      name = "value-canonical",
      type = SearchParamType.Uri,
      expression = "Observation.value.ofType(canonical)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'value-canonical' has expression 'Observation.value.ofType(canonical)' which is not yet supported."
        )
      },
    )

  public val valueConcept: SearchParam<Observation, CodeableConcept> =
    SearchParam(
      name = "value-concept",
      type = SearchParamType.Token,
      expression = "Observation.value.ofType(CodeableConcept)",
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.CodeableConcept)?.value)
      },
    )

  public val valueDate: SearchParam<Observation, Any> =
    SearchParam(
      name = "value-date",
      type = SearchParamType.Date,
      expression = "Observation.value.ofType(dateTime) | Observation.value.ofType(Period)",
      extractor = { resource ->
        buildList {
            addAll(listOfNotNull((resource.`value` as? Observation.Value.DateTime)?.value))
            addAll(listOfNotNull((resource.`value` as? Observation.Value.Period)?.value))
          }
          .distinct()
      },
    )

  public val valueMarkdown: SearchParam<Observation, Any> =
    SearchParam(
      name = "value-markdown",
      type = SearchParamType.String,
      expression =
        "Observation.value.ofType(markdown) | Observation.value.ofType(CodeableConcept).text",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'value-markdown' has expression 'Observation.value.ofType(markdown) | Observation.value.ofType(CodeableConcept).text' which is not yet supported."
        )
      },
    )

  public val valueQuantity: SearchParam<Observation, Any> =
    SearchParam(
      name = "value-quantity",
      type = SearchParamType.Quantity,
      expression = "Observation.value.ofType(Quantity) | Observation.value.ofType(SampledData)",
      extractor = { resource ->
        buildList {
            addAll(listOfNotNull((resource.`value` as? Observation.Value.Quantity)?.value))
            addAll(listOfNotNull((resource.`value` as? Observation.Value.SampledData)?.value))
          }
          .distinct()
      },
    )

  public val valueReference: SearchParam<Observation, Reference> =
    SearchParam(
      name = "value-reference",
      type = SearchParamType.Reference,
      expression = "Observation.value.ofType(Reference)",
      target = listOf(MolecularSequence::class),
      extractor = { resource ->
        listOfNotNull((resource.`value` as? Observation.Value.Reference)?.value)
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: CollectionsList<SearchParam<Observation, *>> =
    listOf(
      codeValueConcept,
      codeValueDate,
      codeValueQuantity,
      codeValueString,
      componentValueCanonical,
      valueCanonical,
      valueMarkdown,
    )

  /**
   * Supported search parameters for the Observation resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: CollectionsList<SearchParam<Observation, *>> =
    listOf(
      basedOn,
      category,
      code,
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
      componentValueReference,
      dataAbsentReason,
      date,
      derivedFrom,
      device,
      encounter,
      focus,
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
      valueReference,
    )
}
