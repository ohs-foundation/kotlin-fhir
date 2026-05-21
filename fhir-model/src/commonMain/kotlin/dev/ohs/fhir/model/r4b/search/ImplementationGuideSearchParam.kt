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
import dev.ohs.fhir.model.r4b.Boolean
import dev.ohs.fhir.model.r4b.Bundle
import dev.ohs.fhir.model.r4b.Canonical
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
import dev.ohs.fhir.model.r4b.Markdown
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
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.ValueSet
import dev.ohs.fhir.model.r4b.VerificationResult
import dev.ohs.fhir.model.r4b.VisionPrescription
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
import kotlin.reflect.KClass

/** Search parameters for the [ImplementationGuide] resource type. */
public object ImplementationGuideSearchParam {
  /** All search parameters for the ImplementationGuide resource type. */
  public val ALL: CollectionsList<SearchParam<ImplementationGuide, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      DependsOn,
      Description,
      Experimental,
      Global,
      Jurisdiction,
      Name,
      Publisher,
      Resource,
      Status,
      Title,
      Url,
      Version,
    )

  public data object Context : SearchParam<ImplementationGuide, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ImplementationGuide.useContext.value as CodeableConcept)"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<ImplementationGuide, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(ImplementationGuide.useContext.value as Quantity)"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<ImplementationGuide, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.useContext.code"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ImplementationGuide, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ImplementationGuide.useContext"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ImplementationGuide, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ImplementationGuide.useContext"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<ImplementationGuide, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ImplementationGuide.date"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DependsOn : SearchParam<ImplementationGuide, Canonical> {
    public override val paramName: KotlinString = "depends-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ImplementationGuide.dependsOn.uri"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      listOf(ImplementationGuide::class)

    public override fun extract(resource: ImplementationGuide): CollectionsList<Canonical> =
      resource.dependsOn.map { it.uri }
  }

  public data object Description : SearchParam<ImplementationGuide, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ImplementationGuide.description"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Experimental : SearchParam<ImplementationGuide, Boolean> {
    public override val paramName: KotlinString = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.experimental"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<Boolean> =
      listOfNotNull(resource.experimental)
  }

  public data object Global : SearchParam<ImplementationGuide, Canonical> {
    public override val paramName: KotlinString = "global"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ImplementationGuide.global.profile"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      listOf(StructureDefinition::class)

    public override fun extract(resource: ImplementationGuide): CollectionsList<Canonical> =
      resource.global.map { it.profile }
  }

  public data object Jurisdiction : SearchParam<ImplementationGuide, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.jurisdiction"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<ImplementationGuide, R4bString> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ImplementationGuide.name"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<R4bString> =
      listOf(resource.name)
  }

  public data object Publisher : SearchParam<ImplementationGuide, R4bString> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ImplementationGuide.publisher"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<R4bString> =
      listOfNotNull(resource.publisher)
  }

  public data object Resource : SearchParam<ImplementationGuide, Reference> {
    public override val paramName: KotlinString = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "ImplementationGuide.definition.resource.reference"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
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
      )

    public override fun extract(resource: ImplementationGuide): CollectionsList<Reference> =
      (resource.definition?.resource ?: emptyList()).map { it.reference }
  }

  public data object Status : SearchParam<ImplementationGuide, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.status"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<Any> =
      listOf(resource.status)
  }

  public data object Title : SearchParam<ImplementationGuide, R4bString> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ImplementationGuide.title"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<R4bString> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<ImplementationGuide, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ImplementationGuide.url"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<Uri> =
      listOf(resource.url)
  }

  public data object Version : SearchParam<ImplementationGuide, R4bString> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ImplementationGuide.version"

    public override val target: CollectionsList<KClass<out dev.ohs.fhir.model.r4b.Resource>> =
      emptyList()

    public override fun extract(resource: ImplementationGuide): CollectionsList<R4bString> =
      listOfNotNull(resource.version)
  }
}
