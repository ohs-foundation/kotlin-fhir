/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DocumentReference] resource type. */
public sealed class DocumentReferenceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DocumentReference): List<T>

  public data object Authenticator : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "authenticator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.authenticator"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Author : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.author"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Category : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Contenttype : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "contenttype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.content.attachment.contentType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Custodian : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "custodian"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.custodian"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Date : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DocumentReference.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Description : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "DocumentReference.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Encounter : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.context.encounter"

    public override val target: List<String> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Event : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.context.event"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Facility : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.context.facilityType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Format : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "format"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.content.format"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Identifier : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.masterIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Language : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.content.attachment.language"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Location : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "DocumentReference.content.attachment.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Patient : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Period : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DocumentReference.context.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Related : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "related"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.context.related"

    public override val target: List<String> =
      listOf(
        "Account",
        "ActivityDefinition",
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
        "Claim",
        "ClaimResponse",
        "ClinicalImpression",
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
        "EffectEvidenceSynthesis",
        "Encounter",
        "Endpoint",
        "EnrollmentRequest",
        "EnrollmentResponse",
        "EpisodeOfCare",
        "EventDefinition",
        "Evidence",
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
        "InsurancePlan",
        "Invoice",
        "Library",
        "Linkage",
        "List",
        "Location",
        "Measure",
        "MeasureReport",
        "Media",
        "Medication",
        "MedicationAdministration",
        "MedicationDispense",
        "MedicationKnowledge",
        "MedicationRequest",
        "MedicationStatement",
        "MedicinalProduct",
        "MedicinalProductAuthorization",
        "MedicinalProductContraindication",
        "MedicinalProductIndication",
        "MedicinalProductIngredient",
        "MedicinalProductInteraction",
        "MedicinalProductManufactured",
        "MedicinalProductPackaged",
        "MedicinalProductPharmaceutical",
        "MedicinalProductUndesirableEffect",
        "MessageDefinition",
        "MessageHeader",
        "MolecularSequence",
        "NamingSystem",
        "NutritionOrder",
        "Observation",
        "ObservationDefinition",
        "OperationDefinition",
        "OperationOutcome",
        "Organization",
        "OrganizationAffiliation",
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
        "RelatedPerson",
        "RequestGroup",
        "ResearchDefinition",
        "ResearchElementDefinition",
        "ResearchStudy",
        "ResearchSubject",
        "RiskAssessment",
        "RiskEvidenceSynthesis",
        "Schedule",
        "SearchParameter",
        "ServiceRequest",
        "Slot",
        "Specimen",
        "SpecimenDefinition",
        "StructureDefinition",
        "StructureMap",
        "Subscription",
        "Substance",
        "SubstanceNucleicAcid",
        "SubstancePolymer",
        "SubstanceProtein",
        "SubstanceReferenceInformation",
        "SubstanceSourceMaterial",
        "SubstanceSpecification",
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

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Relatesto : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "relatesto"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.relatesTo.target"

    public override val target: List<String> = listOf("DocumentReference")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Relation : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.relatesTo.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Relationship : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "DocumentReference.relatesTo"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object SecurityLabel : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.securityLabel"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Setting : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "setting"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.context.practiceSetting"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Status : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Subject : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DocumentReference.subject"

    public override val target: List<String> = listOf("Practitioner", "Group", "Device", "Patient")

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
  }

  public data object Type : DocumentReferenceSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DocumentReference.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> = emptyList()
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
