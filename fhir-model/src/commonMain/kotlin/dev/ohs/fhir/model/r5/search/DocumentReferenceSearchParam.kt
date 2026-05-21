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
import dev.ohs.fhir.model.r5.DateTime
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
import dev.ohs.fhir.model.r5.ImagingSelection
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.ImmunizationEvaluation
import dev.ohs.fhir.model.r5.ImmunizationRecommendation
import dev.ohs.fhir.model.r5.ImplementationGuide
import dev.ohs.fhir.model.r5.Ingredient
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.InsurancePlan
import dev.ohs.fhir.model.r5.InventoryItem
import dev.ohs.fhir.model.r5.InventoryReport
import dev.ohs.fhir.model.r5.Invoice
import dev.ohs.fhir.model.r5.Library
import dev.ohs.fhir.model.r5.Linkage
import dev.ohs.fhir.model.r5.List as R5List
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.Markdown
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
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.RiskAssessment
import dev.ohs.fhir.model.r5.Schedule
import dev.ohs.fhir.model.r5.SearchParameter
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Slot
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.SpecimenDefinition
import dev.ohs.fhir.model.r5.String as R5String
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
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.ValueSet
import dev.ohs.fhir.model.r5.VerificationResult
import dev.ohs.fhir.model.r5.VisionPrescription
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
import kotlin.reflect.KClass

/** Search parameters for the [DocumentReference] resource type. */
public object DocumentReferenceSearchParam {
  /** All search parameters for the DocumentReference resource type. */
  public val ALL: CollectionsList<SearchParam<DocumentReference, *>> =
    listOf(
      Attester,
      Author,
      BasedOn,
      Bodysite,
      BodysiteReference,
      Category,
      Contenttype,
      Context,
      Creation,
      Custodian,
      Date,
      Description,
      DocStatus,
      EventCode,
      EventReference,
      Facility,
      FormatCanonical,
      FormatCode,
      FormatUri,
      Identifier,
      Language,
      Location,
      Modality,
      Patient,
      Period,
      Relatesto,
      Relation,
      Relationship,
      SecurityLabel,
      Setting,
      Status,
      Subject,
      Type,
      Version,
    )

  public data object Attester : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "attester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.attester.party"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Organization::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.attester.mapNotNull { it.party }
  }

  public data object Author : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.author"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Organization::class,
        Device::class,
        CareTeam::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.author
  }

  public data object BasedOn : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.basedOn"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Claim::class,
        RequestOrchestration::class,
        DeviceRequest::class,
        ServiceRequest::class,
        EnrollmentRequest::class,
        CarePlan::class,
        Contract::class,
        MedicationRequest::class,
        ImmunizationRecommendation::class,
        CoverageEligibilityRequest::class,
        VisionPrescription::class,
        Appointment::class,
        CommunicationRequest::class,
        AppointmentResponse::class,
        SupplyRequest::class,
        NutritionOrder::class,
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.basedOn
  }

  public data object Bodysite : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "bodysite"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.bodySite.concept"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.bodySite.mapNotNull { it.concept }
  }

  public data object BodysiteReference : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "bodysite-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.bodySite.reference"

    public override val target: CollectionsList<KClass<out Resource>> = listOf(BodyStructure::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.bodySite.mapNotNull { it.reference }
  }

  public data object Category : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.category"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.category
  }

  public data object Contenttype : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "contenttype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "DocumentReference.content.attachment.contentType"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.contentType }
  }

  public data object Context : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.context"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(Appointment::class, Encounter::class, EpisodeOfCare::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.context
  }

  public data object Creation : SearchParam<DocumentReference, DateTime> {
    public override val paramName: KotlinString = "creation"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.content.attachment.creation"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<DateTime> =
      resource.content.map { it.attachment }.mapNotNull { it.creation }
  }

  public data object Custodian : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "custodian"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.custodian"

    public override val target: CollectionsList<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.custodian)
  }

  public data object Date : SearchParam<DocumentReference, Instant> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.date"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Instant> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<DocumentReference, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "DocumentReference.description"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object DocStatus : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "doc-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.docStatus"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
      listOfNotNull(resource.docStatus)
  }

  public data object EventCode : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "event-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.event.concept"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.event.mapNotNull { it.concept }
  }

  public data object EventReference : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "event-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.event.reference"

    public override val target: CollectionsList<KClass<out Resource>> =
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
        dev.ohs.fhir.model.r5.Location::class,
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
        dev.ohs.fhir.model.r5.Patient::class,
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
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.event.mapNotNull { it.reference }
  }

  public data object Facility : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.facilityType"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.facilityType)
  }

  public data object FormatCanonical : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "format-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "(DocumentReference.content.profile.value.ofType(canonical))"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        ActivityDefinition::class,
        ActorDefinition::class,
        CapabilityStatement::class,
        ChargeItemDefinition::class,
        Citation::class,
        CodeSystem::class,
        CompartmentDefinition::class,
        Composition::class,
        ConceptMap::class,
        ConditionDefinition::class,
        Contract::class,
        Device::class,
        EventDefinition::class,
        Evidence::class,
        EvidenceReport::class,
        EvidenceVariable::class,
        ExampleScenario::class,
        GraphDefinition::class,
        ImplementationGuide::class,
        Library::class,
        Measure::class,
        MessageDefinition::class,
        NamingSystem::class,
        ObservationDefinition::class,
        OperationDefinition::class,
        PlanDefinition::class,
        Questionnaire::class,
        Requirements::class,
        ResearchStudy::class,
        SearchParameter::class,
        SpecimenDefinition::class,
        StructureDefinition::class,
        StructureMap::class,
        SubscriptionTopic::class,
        TerminologyCapabilities::class,
        TestPlan::class,
        TestScript::class,
        ValueSet::class,
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Any> = emptyList()
  }

  public data object FormatCode : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "format-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(DocumentReference.content.profile.value.ofType(Coding))"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> = emptyList()
  }

  public data object FormatUri : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "format-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString =
      "(DocumentReference.content.profile.value.ofType(uri))"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> = emptyList()
  }

  public data object Identifier : SearchParam<DocumentReference, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.identifier"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): CollectionsList<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Language : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.content.attachment.language"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.language }
  }

  public data object Location : SearchParam<DocumentReference, Url> {
    public override val paramName: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "DocumentReference.content.attachment.url"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Url> =
      resource.content.map { it.attachment }.mapNotNull { it.url }
  }

  public data object Modality : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.modality"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.modality
  }

  public data object Patient : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : SearchParam<DocumentReference, dev.ohs.fhir.model.r5.Period> {
    public override val paramName: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.period"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): CollectionsList<dev.ohs.fhir.model.r5.Period> = listOfNotNull(resource.period)
  }

  public data object Relatesto : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "relatesto"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.relatesTo.target"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(DocumentReference::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.relatesTo.map { it.target }
  }

  public data object Relation : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.relatesTo.code"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.relatesTo.map { it.code }
  }

  public data object Relationship : SearchParam<DocumentReference, DocumentReference.RelatesTo> {
    public override val paramName: KotlinString = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "DocumentReference.relatesTo"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): CollectionsList<DocumentReference.RelatesTo> = resource.relatesTo
  }

  public data object SecurityLabel : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.securityLabel"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.securityLabel
  }

  public data object Setting : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "setting"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.practiceSetting"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.practiceSetting)
  }

  public data object Status : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.status"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
      listOf(resource.status)
  }

  public data object Subject : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.subject"

    public override val target: CollectionsList<KClass<out Resource>> =
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
        dev.ohs.fhir.model.r5.Location::class,
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
        dev.ohs.fhir.model.r5.Patient::class,
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
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.type"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Version : SearchParam<DocumentReference, R5String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "DocumentReference.version"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<R5String> =
      listOfNotNull(resource.version)
  }
}
