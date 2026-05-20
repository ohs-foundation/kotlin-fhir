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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DocumentReference] resource type. */
public object DocumentReferenceSearchParam {
  /** All search parameters for the DocumentReference resource type. */
  public val ALL: List<SearchParam<DocumentReference, *>> =
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

    public override val target: List<KotlinString> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.attester.mapNotNull { it.party }
  }

  public data object Author : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.author"

    public override val target: List<KotlinString> =
      listOf(
        "Organization",
        "Device",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: DocumentReference): List<Reference> = resource.author
  }

  public data object BasedOn : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.basedOn"

    public override val target: List<KotlinString> =
      listOf(
        "Claim",
        "RequestOrchestration",
        "DeviceRequest",
        "ServiceRequest",
        "EnrollmentRequest",
        "CarePlan",
        "Contract",
        "MedicationRequest",
        "ImmunizationRecommendation",
        "CoverageEligibilityRequest",
        "VisionPrescription",
        "Appointment",
        "CommunicationRequest",
        "AppointmentResponse",
        "SupplyRequest",
        "NutritionOrder",
      )

    public override fun extract(resource: DocumentReference): List<Reference> = resource.basedOn
  }

  public data object Bodysite : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "bodysite"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.bodySite.concept"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.bodySite.mapNotNull { it.concept }
  }

  public data object BodysiteReference : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "bodysite-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.bodySite.reference"

    public override val target: List<KotlinString> = listOf("BodyStructure")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.bodySite.mapNotNull { it.reference }
  }

  public data object Category : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.category"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.category
  }

  public data object Contenttype : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "contenttype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "DocumentReference.content.attachment.contentType"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.contentType }
  }

  public data object Context : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.context"

    public override val target: List<KotlinString> =
      listOf("Appointment", "Encounter", "EpisodeOfCare")

    public override fun extract(resource: DocumentReference): List<Reference> = resource.context
  }

  public data object Creation : SearchParam<DocumentReference, DateTime> {
    public override val paramName: KotlinString = "creation"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.content.attachment.creation"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<DateTime> =
      resource.content.map { it.attachment }.mapNotNull { it.creation }
  }

  public data object Custodian : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "custodian"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.custodian"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.custodian)
  }

  public data object Date : SearchParam<DocumentReference, Instant> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Instant> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<DocumentReference, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "DocumentReference.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object DocStatus : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "doc-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.docStatus"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      listOfNotNull(resource.docStatus)
  }

  public data object EventCode : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "event-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.event.concept"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.event.mapNotNull { it.concept }
  }

  public data object EventReference : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "event-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.event.reference"

    public override val target: List<KotlinString> =
      listOf(
        "Account",
        "ActivityDefinition",
        "ActorDefinition",
        "AdministrableProductDefinition",
        "AdverseEvent",
        "AllergyIntolerance",
        "Appointment",
        "AppointmentResponse",
        "ArtifactAssessment",
        "AuditEvent",
        "Basic",
        "Binary",
        "BiologicallyDerivedProduct",
        "BiologicallyDerivedProductDispense",
        "BodyStructure",
        "Bundle",
        "CapabilityStatement",
        "CarePlan",
        "CareTeam",
        "ChargeItem",
        "ChargeItemDefinition",
        "Citation",
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
        "ClinicalUseDefinition",
        "CodeSystem",
        "Communication",
        "CommunicationRequest",
        "CompartmentDefinition",
        "Composition",
        "ConceptMap",
        "Condition",
        "ConditionDefinition",
        "Consent",
        "Contract",
        "Coverage",
        "CoverageEligibilityRequest",
        "CoverageEligibilityResponse",
        "DetectedIssue",
        "Device",
        "DeviceAssociation",
        "DeviceDefinition",
        "DeviceDispense",
        "DeviceMetric",
        "DeviceRequest",
        "DeviceUsage",
        "DiagnosticReport",
        "DocumentReference",
        "Encounter",
        "EncounterHistory",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
        "EvidenceReport",
        "EvidenceVariable",
        "ExampleScenario",
        "ExplanationOfBenefit",
        "FamilyMemberHistory",
        "Flag",
        "FormularyItem",
        "GenomicStudy",
        "Goal",
        "GraphDefinition",
        "Group",
        "GuidanceResponse",
        "HealthcareService",
        "ImagingSelection",
        "ImagingStudy",
        "Immunization",
        "ImmunizationEvaluation",
        "ImmunizationRecommendation",
        "ImplementationGuide",
        "Ingredient",
        "InsurancePlan",
        "InventoryItem",
        "InventoryReport",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "ManufacturedItemDefinition",
        "Measure",
        "MeasureReport",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProductDefinition",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionIntake",
        "NutritionOrder",
        "NutritionProduct",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
        "PackagedProductDefinition",
        "Parameters",
        "Patient",
        "PaymentNotice",
        "PaymentReconciliation",
        "Permission",
        "Person",
        "PlanDefinition",
        "Practitioner",
        "PractitionerRole",
        "Procedure",
        "Provenance",
        "Questionnaire",
        "QuestionnaireResponse",
        "RegulatedAuthorization",
        "RelatedPerson",
        "RequestOrchestration",
        "Requirements",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "SubscriptionStatus",
        "SubscriptionTopic",
        "Substance",
        "SubstanceDefinition",
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SupplyDelivery",
        "SupplyRequest",
        "Task",
        "TerminologyCapabilities",
        "TestPlan",
        "TestReport",
        "TestScript",
        "Transport",
        "ValueSet",
        "VerificationResult",
        "VisionPrescription",
      )

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.event.mapNotNull { it.reference }
  }

  public data object Facility : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.facilityType"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.facilityType)
  }

  public data object FormatCanonical : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "format-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "(DocumentReference.content.profile.value.ofType(canonical))"

    public override val target: List<KotlinString> =
      listOf(
        "ActivityDefinition",
        "ActorDefinition",
        "CapabilityStatement",
        "ChargeItemDefinition",
        "Citation",
        "CodeSystem",
        "CompartmentDefinition",
        "Composition",
        "ConceptMap",
        "ConditionDefinition",
        "Contract",
        "Device",
        "EventDefinition",
        "Evidence",
        "EvidenceReport",
        "EvidenceVariable",
        "ExampleScenario",
        "GraphDefinition",
        "ImplementationGuide",
        "Library",
        "Measure",
        "MessageDefinition",
        "NamingSystem",
        "ObservationDefinition",
        "OperationDefinition",
        "PlanDefinition",
        "Questionnaire",
        "Requirements",
        "ResearchStudy",
        "SearchParameter",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "SubscriptionTopic",
        "TerminologyCapabilities",
        "TestPlan",
        "TestScript",
        "ValueSet",
      )

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object FormatCode : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "format-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(DocumentReference.content.profile.value.ofType(Coding))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object FormatUri : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "format-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString =
      "(DocumentReference.content.profile.value.ofType(uri))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Identifier : SearchParam<DocumentReference, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Language : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.content.attachment.language"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.language }
  }

  public data object Location : SearchParam<DocumentReference, Url> {
    public override val paramName: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "DocumentReference.content.attachment.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Url> =
      resource.content.map { it.attachment }.mapNotNull { it.url }
  }

  public data object Modality : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.modality"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.modality
  }

  public data object Patient : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : SearchParam<DocumentReference, dev.ohs.fhir.model.r5.Period> {
    public override val paramName: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.period"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<dev.ohs.fhir.model.r5.Period> =
      listOfNotNull(resource.period)
  }

  public data object Relatesto : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "relatesto"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.relatesTo.target"

    public override val target: List<KotlinString> = listOf("DocumentReference")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.relatesTo.map { it.target }
  }

  public data object Relation : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.relatesTo.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.relatesTo.map { it.code }
  }

  public data object Relationship : SearchParam<DocumentReference, DocumentReference.RelatesTo> {
    public override val paramName: KotlinString = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "DocumentReference.relatesTo"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<DocumentReference.RelatesTo> =
      resource.relatesTo
  }

  public data object SecurityLabel : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.securityLabel"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.securityLabel
  }

  public data object Setting : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "setting"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.practiceSetting"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.practiceSetting)
  }

  public data object Status : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.subject"

    public override val target: List<KotlinString> =
      listOf(
        "Account",
        "ActivityDefinition",
        "ActorDefinition",
        "AdministrableProductDefinition",
        "AdverseEvent",
        "AllergyIntolerance",
        "Appointment",
        "AppointmentResponse",
        "ArtifactAssessment",
        "AuditEvent",
        "Basic",
        "Binary",
        "BiologicallyDerivedProduct",
        "BiologicallyDerivedProductDispense",
        "BodyStructure",
        "Bundle",
        "CapabilityStatement",
        "CarePlan",
        "CareTeam",
        "ChargeItem",
        "ChargeItemDefinition",
        "Citation",
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
        "ClinicalUseDefinition",
        "CodeSystem",
        "Communication",
        "CommunicationRequest",
        "CompartmentDefinition",
        "Composition",
        "ConceptMap",
        "Condition",
        "ConditionDefinition",
        "Consent",
        "Contract",
        "Coverage",
        "CoverageEligibilityRequest",
        "CoverageEligibilityResponse",
        "DetectedIssue",
        "Device",
        "DeviceAssociation",
        "DeviceDefinition",
        "DeviceDispense",
        "DeviceMetric",
        "DeviceRequest",
        "DeviceUsage",
        "DiagnosticReport",
        "DocumentReference",
        "Encounter",
        "EncounterHistory",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
        "EvidenceReport",
        "EvidenceVariable",
        "ExampleScenario",
        "ExplanationOfBenefit",
        "FamilyMemberHistory",
        "Flag",
        "FormularyItem",
        "GenomicStudy",
        "Goal",
        "GraphDefinition",
        "Group",
        "GuidanceResponse",
        "HealthcareService",
        "ImagingSelection",
        "ImagingStudy",
        "Immunization",
        "ImmunizationEvaluation",
        "ImmunizationRecommendation",
        "ImplementationGuide",
        "Ingredient",
        "InsurancePlan",
        "InventoryItem",
        "InventoryReport",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "ManufacturedItemDefinition",
        "Measure",
        "MeasureReport",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProductDefinition",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionIntake",
        "NutritionOrder",
        "NutritionProduct",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
        "PackagedProductDefinition",
        "Parameters",
        "Patient",
        "PaymentNotice",
        "PaymentReconciliation",
        "Permission",
        "Person",
        "PlanDefinition",
        "Practitioner",
        "PractitionerRole",
        "Procedure",
        "Provenance",
        "Questionnaire",
        "QuestionnaireResponse",
        "RegulatedAuthorization",
        "RelatedPerson",
        "RequestOrchestration",
        "Requirements",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "SubscriptionStatus",
        "SubscriptionTopic",
        "Substance",
        "SubstanceDefinition",
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SupplyDelivery",
        "SupplyRequest",
        "Task",
        "TerminologyCapabilities",
        "TestPlan",
        "TestReport",
        "TestScript",
        "Transport",
        "ValueSet",
        "VerificationResult",
        "VisionPrescription",
      )

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Version : SearchParam<DocumentReference, R5String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "DocumentReference.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<R5String> =
      listOfNotNull(resource.version)
  }
}
