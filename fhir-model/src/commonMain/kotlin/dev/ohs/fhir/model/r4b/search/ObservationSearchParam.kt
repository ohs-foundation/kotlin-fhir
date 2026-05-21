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
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.RiskAssessment
import dev.ohs.fhir.model.r4b.Schedule
import dev.ohs.fhir.model.r4b.SearchParameter
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Slot
import dev.ohs.fhir.model.r4b.SpecimenDefinition
import dev.ohs.fhir.model.r4b.String as R4bString
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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
import kotlin.reflect.KClass

/** Search parameters for the [Observation] resource type. */
public object ObservationSearchParam {
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

  public data object AminoAcidChange : SearchParam<Observation, Any> {
    public override val name: KotlinString = "amino-acid-change"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object BasedOn : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.basedOn"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        CarePlan::class,
        MedicationRequest::class,
        NutritionOrder::class,
        DeviceRequest::class,
        ServiceRequest::class,
        ImmunizationRecommendation::class,
      )

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      resource.basedOn
  }

  public data object Category : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.category"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      resource.category
  }

  public data object Code : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.code"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      listOf(resource.code)
  }

  public data object CodeValueConcept : SearchParam<Observation, Any> {
    public override val name: KotlinString = "code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object CodeValueDate : SearchParam<Observation, Any> {
    public override val name: KotlinString = "code-value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object CodeValueQuantity : SearchParam<Observation, Any> {
    public override val name: KotlinString = "code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object CodeValueString : SearchParam<Observation, Any> {
    public override val name: KotlinString = "code-value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object ComboCode : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "combo-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.code"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      listOf(resource.code)
  }

  public data object ComboCodeValueConcept : SearchParam<Observation, Observation.Component> {
    public override val name: KotlinString = "combo-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation.component"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Observation.Component> =
      resource.component
  }

  public data object ComboCodeValueQuantity : SearchParam<Observation, Observation.Component> {
    public override val name: KotlinString = "combo-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation.component"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Observation.Component> =
      resource.component
  }

  public data object ComboDataAbsentReason : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "combo-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.dataAbsentReason"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.dataAbsentReason)
  }

  public data object ComboValueConcept : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "combo-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Observation.value as CodeableConcept)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      listOfNotNull((resource.value as? Observation.Value.CodeableConcept)?.value)
  }

  public data object ComboValueQuantity : SearchParam<Observation, Quantity> {
    public override val name: KotlinString = "combo-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Observation.value as Quantity)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Quantity> =
      listOfNotNull((resource.value as? Observation.Value.Quantity)?.value)
  }

  public data object ComponentCode : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "component-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.component.code"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      resource.component.map { it.code }
  }

  public data object ComponentCodeValueConcept : SearchParam<Observation, Observation.Component> {
    public override val name: KotlinString = "component-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation.component"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Observation.Component> =
      resource.component
  }

  public data object ComponentCodeValueQuantity : SearchParam<Observation, Observation.Component> {
    public override val name: KotlinString = "component-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation.component"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Observation.Component> =
      resource.component
  }

  public data object ComponentDataAbsentReason : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "component-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.component.dataAbsentReason"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      resource.component.mapNotNull { it.dataAbsentReason }
  }

  public data object ComponentValueConcept : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "component-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(Observation.component.value as CodeableConcept)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      resource.component.mapNotNull {
        (it.value as? Observation.Component.Value.CodeableConcept)?.value
      }
  }

  public data object ComponentValueQuantity : SearchParam<Observation, Quantity> {
    public override val name: KotlinString = "component-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Observation.component.value as Quantity)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Quantity> =
      resource.component.mapNotNull { (it.value as? Observation.Component.Value.Quantity)?.value }
  }

  public data object DataAbsentReason : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.dataAbsentReason"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.dataAbsentReason)
  }

  public data object Date : SearchParam<Observation, Observation.Effective> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Observation.effective"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Observation.Effective> =
      listOfNotNull(resource.effective)
  }

  public data object DerivedFrom : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.derivedFrom"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Media::class,
        Observation::class,
        ImagingStudy::class,
        MolecularSequence::class,
        QuestionnaireResponse::class,
        DocumentReference::class,
      )

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      resource.derivedFrom
  }

  public data object Device : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.device"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Device::class, DeviceMetric::class)

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      listOfNotNull(resource.device)
  }

  public data object DnaVariant : SearchParam<Observation, Any> {
    public override val name: KotlinString = "dna-variant"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object Encounter : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.encounter"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Encounter::class)

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Focus : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.focus"

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
      )

    public override fun extract(resource: Observation): CollectionsList<Reference> = resource.focus
  }

  public data object GeneAminoAcidChange : SearchParam<Observation, Any> {
    public override val name: KotlinString = "gene-amino-acid-change"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object GeneDnavariant : SearchParam<Observation, Any> {
    public override val name: KotlinString = "gene-dnavariant"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object GeneIdentifier : SearchParam<Observation, Any> {
    public override val name: KotlinString = "gene-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsGene')"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> = emptyList()
  }

  public data object HasMember : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "has-member"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.hasMember"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(Observation::class, MolecularSequence::class, QuestionnaireResponse::class)

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      resource.hasMember
  }

  public data object Identifier : SearchParam<Observation, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.identifier"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: Observation
    ): CollectionsList<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Method : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.method"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.method)
  }

  public data object PartOf : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.partOf"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Immunization::class,
        MedicationDispense::class,
        MedicationAdministration::class,
        Procedure::class,
        ImagingStudy::class,
        MedicationStatement::class,
      )

    public override fun extract(resource: Observation): CollectionsList<Reference> = resource.partOf
  }

  public data object Patient : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.subject.where(resolve() is Patient)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.performer"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        CareTeam::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      resource.performer
  }

  public data object Specimen : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.specimen"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Specimen::class)

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      listOfNotNull(resource.specimen)
  }

  public data object Status : SearchParam<Observation, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.status"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Any> =
      listOf(resource.status)
  }

  public data object Subject : SearchParam<Observation, Reference> {
    public override val name: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.subject"

    public override val target: CollectionsList<KClass<out Resource>> =
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
      )

    public override fun extract(resource: Observation): CollectionsList<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object ValueConcept : SearchParam<Observation, CodeableConcept> {
    public override val name: KotlinString = "value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Observation.value as CodeableConcept)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<CodeableConcept> =
      listOfNotNull((resource.value as? Observation.Value.CodeableConcept)?.value)
  }

  public data object ValueDate : SearchParam<Observation, DateTime> {
    public override val name: KotlinString = "value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "(Observation.value as dateTime)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<DateTime> =
      listOfNotNull((resource.value as? Observation.Value.DateTime)?.value)
  }

  public data object ValueQuantity : SearchParam<Observation, Quantity> {
    public override val name: KotlinString = "value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Observation.value as Quantity)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<Quantity> =
      listOfNotNull((resource.value as? Observation.Value.Quantity)?.value)
  }

  public data object ValueString : SearchParam<Observation, R4bString> {
    public override val name: KotlinString = "value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "(Observation.value as string)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<R4bString> =
      listOfNotNull((resource.value as? Observation.Value.String)?.value)
  }
}
