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
import dev.ohs.fhir.model.r4.Specimen
import dev.ohs.fhir.model.r4.SpecimenDefinition
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
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.VerificationResult
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
import kotlin.reflect.KClass

/** Search parameters for the [Communication] resource type. */
public object CommunicationSearchParam {
  /** All search parameters for the Communication resource type. */
  public val ALL: CollectionsList<SearchParam<Communication, *>> =
    listOf(
      BasedOn,
      Category,
      Encounter,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Medium,
      PartOf,
      Patient,
      Received,
      Recipient,
      Sender,
      Sent,
      Status,
      Subject,
    )

  public data object BasedOn : SearchParam<Communication, Reference> {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Communication.basedOn"

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

    public override fun extract(resource: Communication): CollectionsList<Reference> =
      resource.basedOn
  }

  public data object Category : SearchParam<Communication, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Communication.category"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Communication): CollectionsList<CodeableConcept> =
      resource.category
  }

  public data object Encounter : SearchParam<Communication, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Communication.encounter"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Encounter::class)

    public override fun extract(resource: Communication): CollectionsList<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<Communication, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Communication.identifier"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: Communication
    ): CollectionsList<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<Communication, Canonical> {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Communication.instantiatesCanonical"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Questionnaire::class,
        Measure::class,
        PlanDefinition::class,
        OperationDefinition::class,
        ActivityDefinition::class,
      )

    public override fun extract(resource: Communication): CollectionsList<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : SearchParam<Communication, Uri> {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Communication.instantiatesUri"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Communication): CollectionsList<Uri> =
      resource.instantiatesUri
  }

  public data object Medium : SearchParam<Communication, CodeableConcept> {
    public override val paramName: String = "medium"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Communication.medium"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Communication): CollectionsList<CodeableConcept> =
      resource.medium
  }

  public data object PartOf : SearchParam<Communication, Reference> {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Communication.partOf"

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

    public override fun extract(resource: Communication): CollectionsList<Reference> =
      resource.partOf
  }

  public data object Patient : SearchParam<Communication, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Communication.subject.where(resolve() is Patient)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: Communication): CollectionsList<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Received : SearchParam<Communication, DateTime> {
    public override val paramName: String = "received"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Communication.received"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Communication): CollectionsList<DateTime> =
      listOfNotNull(resource.received)
  }

  public data object Recipient : SearchParam<Communication, Reference> {
    public override val paramName: String = "recipient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Communication.recipient"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Group::class,
        Organization::class,
        CareTeam::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        HealthcareService::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: Communication): CollectionsList<Reference> =
      resource.recipient
  }

  public data object Sender : SearchParam<Communication, Reference> {
    public override val paramName: String = "sender"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Communication.sender"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        HealthcareService::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: Communication): CollectionsList<Reference> =
      listOfNotNull(resource.sender)
  }

  public data object Sent : SearchParam<Communication, DateTime> {
    public override val paramName: String = "sent"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Communication.sent"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Communication): CollectionsList<DateTime> =
      listOfNotNull(resource.sent)
  }

  public data object Status : SearchParam<Communication, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Communication.status"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Communication): CollectionsList<Any> =
      listOf(resource.status)
  }

  public data object Subject : SearchParam<Communication, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Communication.subject"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: Communication): CollectionsList<Reference> =
      listOfNotNull(resource.subject)
  }
}
