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
import dev.ohs.fhir.model.r4b.Coding
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
import dev.ohs.fhir.model.r4b.DetectedIssue
import dev.ohs.fhir.model.r4b.Device
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
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.InsurancePlan
import dev.ohs.fhir.model.r4b.Invoice
import dev.ohs.fhir.model.r4b.Library
import dev.ohs.fhir.model.r4b.Linkage
import dev.ohs.fhir.model.r4b.List as R4bList
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
import dev.ohs.fhir.model.r4b.Specimen
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
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.ValueSet
import dev.ohs.fhir.model.r4b.VerificationResult
import dev.ohs.fhir.model.r4b.VisionPrescription
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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

  public data object Authenticator : SearchParam<DocumentReference, Reference> {
    public override val name: KotlinString = "authenticator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.authenticator"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, PractitionerRole::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.authenticator)
  }

  public data object Author : SearchParam<DocumentReference, Reference> {
    public override val name: KotlinString = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.author"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.author
  }

  public data object Category : SearchParam<DocumentReference, CodeableConcept> {
    public override val name: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.category"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.category
  }

  public data object Contenttype : SearchParam<DocumentReference, Any> {
    public override val name: KotlinString = "contenttype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "DocumentReference.content.attachment.contentType"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.contentType }
  }

  public data object Custodian : SearchParam<DocumentReference, Reference> {
    public override val name: KotlinString = "custodian"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.custodian"

    public override val target: CollectionsList<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.custodian)
  }

  public data object Date : SearchParam<DocumentReference, Instant> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.date"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Instant> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<DocumentReference, R4bString> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "DocumentReference.description"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<R4bString> =
      listOfNotNull(resource.description)
  }

  public data object Encounter : SearchParam<DocumentReference, Reference> {
    public override val name: KotlinString = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "DocumentReference.context.encounter.where(resolve() is Encounter)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Encounter::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      (resource.context?.encounter ?: emptyList()).filter {
        it.reference?.value?.toString()?.contains("Encounter/") == true
      }
  }

  public data object Event : SearchParam<DocumentReference, CodeableConcept> {
    public override val name: KotlinString = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.context.event"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.context?.event ?: emptyList()
  }

  public data object Facility : SearchParam<DocumentReference, CodeableConcept> {
    public override val name: KotlinString = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.context.facilityType"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.context?.facilityType)
  }

  public data object Format : SearchParam<DocumentReference, Coding> {
    public override val name: KotlinString = "format"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.content.format"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Coding> =
      resource.content.mapNotNull { it.format }
  }

  public data object Identifier :
    SearchParam<DocumentReference, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.masterIdentifier"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): CollectionsList<dev.ohs.fhir.model.r4b.Identifier> = listOfNotNull(resource.masterIdentifier)
  }

  public data object Language : SearchParam<DocumentReference, Any> {
    public override val name: KotlinString = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.content.attachment.language"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.language }
  }

  public data object Location : SearchParam<DocumentReference, Url> {
    public override val name: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "DocumentReference.content.attachment.url"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Url> =
      resource.content.map { it.attachment }.mapNotNull { it.url }
  }

  public data object Patient : SearchParam<DocumentReference, Reference> {
    public override val name: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : SearchParam<DocumentReference, dev.ohs.fhir.model.r4b.Period> {
    public override val name: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.context.period"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): CollectionsList<dev.ohs.fhir.model.r4b.Period> = listOfNotNull(resource.context?.period)
  }

  public data object Related : SearchParam<DocumentReference, Reference> {
    public override val name: KotlinString = "related"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.context.related"

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
        Device::class,
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
        dev.ohs.fhir.model.r4b.Location::class,
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
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.context?.related ?: emptyList()
  }

  public data object Relatesto : SearchParam<DocumentReference, Reference> {
    public override val name: KotlinString = "relatesto"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.relatesTo.target"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(DocumentReference::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.relatesTo.map { it.target }
  }

  public data object Relation : SearchParam<DocumentReference, Any> {
    public override val name: KotlinString = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.relatesTo.code"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
      resource.relatesTo.map { it.code }
  }

  public data object Relationship : SearchParam<DocumentReference, DocumentReference.RelatesTo> {
    public override val name: KotlinString = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "DocumentReference.relatesTo"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): CollectionsList<DocumentReference.RelatesTo> = resource.relatesTo
  }

  public data object SecurityLabel : SearchParam<DocumentReference, CodeableConcept> {
    public override val name: KotlinString = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.securityLabel"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.securityLabel
  }

  public data object Setting : SearchParam<DocumentReference, CodeableConcept> {
    public override val name: KotlinString = "setting"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.context.practiceSetting"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.context?.practiceSetting)
  }

  public data object Status : SearchParam<DocumentReference, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.status"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
      listOf(resource.status)
  }

  public data object Subject : SearchParam<DocumentReference, Reference> {
    public override val name: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.subject"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Group::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : SearchParam<DocumentReference, CodeableConcept> {
    public override val name: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.type"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.type)
  }
}
