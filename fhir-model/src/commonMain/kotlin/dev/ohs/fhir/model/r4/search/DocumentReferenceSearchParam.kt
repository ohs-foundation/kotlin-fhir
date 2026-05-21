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
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.InsurancePlan
import dev.ohs.fhir.model.r4.Invoice
import dev.ohs.fhir.model.r4.Library
import dev.ohs.fhir.model.r4.Linkage
import dev.ohs.fhir.model.r4.List as R4List
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
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.VerificationResult
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
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
    public override val paramName: KotlinString = "authenticator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.authenticator"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, PractitionerRole::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.authenticator)
  }

  public data object Author : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.author"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.author
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

  public data object Description : SearchParam<DocumentReference, R4String> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "DocumentReference.description"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<R4String> =
      listOfNotNull(resource.description)
  }

  public data object Encounter : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.context.encounter"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.context?.encounter ?: emptyList()
  }

  public data object Event : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.context.event"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      resource.context?.event ?: emptyList()
  }

  public data object Facility : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.context.facilityType"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.context?.facilityType)
  }

  public data object Format : SearchParam<DocumentReference, Coding> {
    public override val paramName: KotlinString = "format"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.content.format"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Coding> =
      resource.content.mapNotNull { it.format }
  }

  public data object Identifier : SearchParam<DocumentReference, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.masterIdentifier"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): CollectionsList<dev.ohs.fhir.model.r4.Identifier> = listOfNotNull(resource.masterIdentifier)
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

  public data object Patient : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: CollectionsList<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : SearchParam<DocumentReference, dev.ohs.fhir.model.r4.Period> {
    public override val paramName: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.context.period"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): CollectionsList<dev.ohs.fhir.model.r4.Period> = listOfNotNull(resource.context?.period)
  }

  public data object Related : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "related"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.context.related"

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
        dev.ohs.fhir.model.r4.Location::class,
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

    public override fun extract(resource: DocumentReference): CollectionsList<Reference> =
      resource.context?.related ?: emptyList()
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

  public data object Relation : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.relatesTo.code"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<Any> =
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

    public override val expression: KotlinString = "DocumentReference.context.practiceSetting"

    public override val target: CollectionsList<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DocumentReference): CollectionsList<CodeableConcept> =
      listOfNotNull(resource.context?.practiceSetting)
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
      listOf(Practitioner::class, Group::class, Device::class, dev.ohs.fhir.model.r4.Patient::class)

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
}
