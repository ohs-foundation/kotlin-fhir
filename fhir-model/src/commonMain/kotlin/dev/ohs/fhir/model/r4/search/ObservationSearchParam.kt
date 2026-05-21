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
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.RiskAssessment
import dev.ohs.fhir.model.r4.RiskEvidenceSynthesis
import dev.ohs.fhir.model.r4.Schedule
import dev.ohs.fhir.model.r4.SearchParameter
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.Slot
import dev.ohs.fhir.model.r4.SpecimenDefinition
import dev.ohs.fhir.model.r4.String as R4String
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
      listOf(dev.ohs.fhir.model.r4.Device::class, DeviceMetric::class)

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
      listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class)

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

  public data object Identifier : SearchParam<Observation, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.identifier"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: Observation
    ): CollectionsList<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
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
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

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
        dev.ohs.fhir.model.r4.Patient::class,
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
      listOf(dev.ohs.fhir.model.r4.Specimen::class)

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
        Group::class,
        dev.ohs.fhir.model.r4.Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
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

  public data object ValueString : SearchParam<Observation, R4String> {
    public override val name: KotlinString = "value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "(Observation.value as string)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Observation): CollectionsList<R4String> =
      listOfNotNull((resource.value as? Observation.Value.String)?.value)
  }
}
