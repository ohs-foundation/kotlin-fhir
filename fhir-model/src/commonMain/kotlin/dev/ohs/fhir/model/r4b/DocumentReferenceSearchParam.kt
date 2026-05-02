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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DocumentReference] resource type. */
public sealed class DocumentReferenceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DocumentReference): List<T>

  public data object Authenticator : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "authenticator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.authenticator"

    public override val target: List<kotlin.String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.authenticator)
  }

  public data object Author : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.author"

    public override val target: List<kotlin.String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: DocumentReference): List<Reference> = resource.author
  }

  public data object Category : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.category
  }

  public data object Contenttype : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "contenttype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "DocumentReference.content.attachment.contentType"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.contentType }
  }

  public data object Custodian : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "custodian"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.custodian"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.custodian)
  }

  public data object Date : DocumentReferenceSearchParam<Instant>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "DocumentReference.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Instant> =
      listOfNotNull(resource.date)
  }

  public data object Description : DocumentReferenceSearchParam<String>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "DocumentReference.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<String> =
      listOfNotNull(resource.description)
  }

  public data object Encounter : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "DocumentReference.context.encounter.where(resolve() is Encounter)"

    public override val target: List<kotlin.String> = listOf("Encounter")

    public override fun extract(resource: DocumentReference): List<Reference> =
      (resource.context?.encounter ?: emptyList()).filter {
        it.reference?.value?.toString()?.contains("Encounter/") == true
      }
  }

  public data object Event : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.context.event"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.context?.event ?: emptyList()
  }

  public data object Facility : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.context.facilityType"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.context?.facilityType)
  }

  public data object Format : DocumentReferenceSearchParam<Coding>() {
    public override val paramName: kotlin.String = "format"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.content.format"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Coding> =
      resource.content.mapNotNull { it.format }
  }

  public data object Identifier :
    DocumentReferenceSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.masterIdentifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): List<dev.ohs.fhir.model.r4b.Identifier> = listOfNotNull(resource.masterIdentifier)
  }

  public data object Language : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.content.attachment.language"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      resource.content.map { it.attachment }.mapNotNull { it.language }
  }

  public data object Location : DocumentReferenceSearchParam<Url>() {
    public override val paramName: kotlin.String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "DocumentReference.content.attachment.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Url> =
      resource.content.map { it.attachment }.mapNotNull { it.url }
  }

  public data object Patient : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : DocumentReferenceSearchParam<dev.ohs.fhir.model.r4b.Period>() {
    public override val paramName: kotlin.String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "DocumentReference.context.period"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<dev.ohs.fhir.model.r4b.Period> =
      listOfNotNull(resource.context?.period)
  }

  public data object Related : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "related"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.context.related"

    public override val target: List<kotlin.String> =
      listOf(
        "Account",
        "ActivityDefinition",
        "AdministrableProductDefinition",
        "AdverseEvent",
        "AllergyIntolerance",
        "Appointment",
        "AppointmentResponse",
        "AuditEvent",
        "Basic",
        "Binary",
        "BiologicallyDerivedProduct",
        "BodyStructure",
        "Bundle",
        "CapabilityStatement",
        "CarePlan",
        "CareTeam",
        "CatalogEntry",
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
        "Consent",
        "Contract",
        "Coverage",
        "CoverageEligibilityRequest",
        "CoverageEligibilityResponse",
        "DetectedIssue",
        "Device",
        "DeviceDefinition",
        "DeviceMetric",
        "DeviceRequest",
        "DeviceUseStatement",
        "DiagnosticReport",
        "DocumentManifest",
        "DocumentReference",
        "Encounter",
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
        "Goal",
        "GraphDefinition",
        "Group",
        "GuidanceResponse",
        "HealthcareService",
        "ImagingStudy",
        "Immunization",
        "ImmunizationEvaluation",
        "ImmunizationRecommendation",
        "ImplementationGuide",
        "Ingredient",
        "InsurancePlan",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "ManufacturedItemDefinition",
        "Measure",
        "MeasureReport",
        "Media",
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
        "NutritionOrder",
        "NutritionProduct",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
        "PackagedProductDefinition",
        "Patient",
        "PaymentNotice",
        "PaymentReconciliation",
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
        "RequestGroup",
        "ResearchDefinition",
        "ResearchElementDefinition",
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
        "SupplyDelivery",
        "SupplyRequest",
        "Task",
        "TerminologyCapabilities",
        "TestReport",
        "TestScript",
        "ValueSet",
        "VerificationResult",
        "VisionPrescription",
      )

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.context?.related ?: emptyList()
  }

  public data object Relatesto : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "relatesto"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.relatesTo.target"

    public override val target: List<kotlin.String> = listOf("DocumentReference")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.relatesTo.map { it.target }
  }

  public data object Relation : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.relatesTo.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
      resource.relatesTo.map { it.code }
  }

  public data object Relationship : DocumentReferenceSearchParam<DocumentReference.RelatesTo>() {
    public override val paramName: kotlin.String = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "DocumentReference.relatesTo"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<DocumentReference.RelatesTo> =
      resource.relatesTo
  }

  public data object SecurityLabel : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.securityLabel"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.securityLabel
  }

  public data object Setting : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "setting"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.context.practiceSetting"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.context?.practiceSetting)
  }

  public data object Status : DocumentReferenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = listOf(resource.status)
  }

  public data object Subject : DocumentReferenceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "DocumentReference.subject"

    public override val target: List<kotlin.String> =
      listOf("Practitioner", "Group", "Device", "Patient")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : DocumentReferenceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "DocumentReference.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public companion object {
    /** All search parameters for the DocumentReference resource type. */
    public val ALL: List<DocumentReferenceSearchParam<*>> =
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
  }
}
