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
import dev.ohs.fhir.model.r4.Canonical
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
import dev.ohs.fhir.model.r4.DateTime
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
import dev.ohs.fhir.model.r4.Encounter
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
import dev.ohs.fhir.model.r4.Markdown
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
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.PaymentNotice
import dev.ohs.fhir.model.r4.PaymentReconciliation
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Person
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Procedure
import dev.ohs.fhir.model.r4.Provenance
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Questionnaire
import dev.ohs.fhir.model.r4.QuestionnaireResponse
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
import dev.ohs.fhir.model.r4.Specimen
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
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.VerificationResult
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
import kotlin.reflect.KClass

/** Search parameters for the [Measure] resource type. */
public object MeasureSearchParam {
  /** All search parameters for the Measure resource type. */
  public val ALL: CollectionsList<SearchParam<Measure, *>> =
    listOf(
      ComposedOf,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      DependsOn,
      DerivedFrom,
      Description,
      Effective,
      Identifier,
      Jurisdiction,
      Name,
      Predecessor,
      Publisher,
      Status,
      Successor,
      Title,
      Topic,
      Url,
      Version,
    )

  public data object ComposedOf : SearchParam<Measure, Canonical> {
    public override val paramName: KotlinString = "composed-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "Measure.relatedArtifact.where(type='composed-of').resource"

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
        Device::class,
        DeviceDefinition::class,
        DeviceMetric::class,
        DeviceRequest::class,
        DeviceUseStatement::class,
        DiagnosticReport::class,
        DocumentManifest::class,
        DocumentReference::class,
        EffectEvidenceSynthesis::class,
        Encounter::class,
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
      )

    public override fun extract(resource: Measure): CollectionsList<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "composed-of" }
        .mapNotNull { it.resource }
  }

  public data object Context : SearchParam<Measure, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Measure.useContext.value as CodeableConcept)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<Measure, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Measure.useContext.value as Quantity)"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<Measure, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Measure.useContext.code"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<Measure, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Measure.useContext"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<Measure, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Measure.useContext"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<Measure, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Measure.date"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DependsOn : SearchParam<Measure, Canonical> {
    public override val paramName: KotlinString = "depends-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "Measure.relatedArtifact.where(type='depends-on').resource"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Library::class,
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
        Encounter::class,
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
      )

    public override fun extract(resource: Measure): CollectionsList<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "depends-on" }
        .mapNotNull { it.resource }
  }

  public data object DerivedFrom : SearchParam<Measure, Canonical> {
    public override val paramName: KotlinString = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "Measure.relatedArtifact.where(type='derived-from').resource"

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
        Device::class,
        DeviceDefinition::class,
        DeviceMetric::class,
        DeviceRequest::class,
        DeviceUseStatement::class,
        DiagnosticReport::class,
        DocumentManifest::class,
        DocumentReference::class,
        EffectEvidenceSynthesis::class,
        Encounter::class,
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
      )

    public override fun extract(resource: Measure): CollectionsList<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "derived-from" }
        .mapNotNull { it.resource }
  }

  public data object Description : SearchParam<Measure, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Measure.description"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : SearchParam<Measure, Period> {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Measure.effectivePeriod"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier : SearchParam<Measure, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Measure.identifier"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: Measure
    ): CollectionsList<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Jurisdiction : SearchParam<Measure, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Measure.jurisdiction"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<Measure, R4String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Measure.name"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Predecessor : SearchParam<Measure, Canonical> {
    public override val paramName: KotlinString = "predecessor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "Measure.relatedArtifact.where(type='predecessor').resource"

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
        Device::class,
        DeviceDefinition::class,
        DeviceMetric::class,
        DeviceRequest::class,
        DeviceUseStatement::class,
        DiagnosticReport::class,
        DocumentManifest::class,
        DocumentReference::class,
        EffectEvidenceSynthesis::class,
        Encounter::class,
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
      )

    public override fun extract(resource: Measure): CollectionsList<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "predecessor" }
        .mapNotNull { it.resource }
  }

  public data object Publisher : SearchParam<Measure, R4String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Measure.publisher"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<Measure, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Measure.status"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<Any> = listOf(resource.status)
  }

  public data object Successor : SearchParam<Measure, Canonical> {
    public override val paramName: KotlinString = "successor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "Measure.relatedArtifact.where(type='successor').resource"

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
        Device::class,
        DeviceDefinition::class,
        DeviceMetric::class,
        DeviceRequest::class,
        DeviceUseStatement::class,
        DiagnosticReport::class,
        DocumentManifest::class,
        DocumentReference::class,
        EffectEvidenceSynthesis::class,
        Encounter::class,
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
      )

    public override fun extract(resource: Measure): CollectionsList<Canonical> =
      resource.relatedArtifact
        .filter { it.type?.value?.toString() == "successor" }
        .mapNotNull { it.resource }
  }

  public data object Title : SearchParam<Measure, R4String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Measure.title"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Topic : SearchParam<Measure, CodeableConcept> {
    public override val paramName: KotlinString = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Measure.topic"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<CodeableConcept> =
      resource.topic
  }

  public data object Url : SearchParam<Measure, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Measure.url"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<Measure, R4String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Measure.version"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Measure): CollectionsList<R4String> =
      listOfNotNull(resource.version)
  }
}
