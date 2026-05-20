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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DocumentReference
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DocumentReference] resource type. */
public object DocumentReferenceSearchParam {
  /** All search parameters for the DocumentReference resource type. */
  public val ALL: List<SearchParam<DocumentReference, *>> =
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

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.authenticator)
  }

  public data object Author : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.author"

    public override val target: List<KotlinString> =
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

  public data object Description : SearchParam<DocumentReference, R4String> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "DocumentReference.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<R4String> =
      listOfNotNull(resource.description)
  }

  public data object Encounter : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.context.encounter"

    public override val target: List<KotlinString> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.context?.encounter ?: emptyList()
  }

  public data object Event : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.context.event"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      resource.context?.event ?: emptyList()
  }

  public data object Facility : SearchParam<DocumentReference, CodeableConcept> {
    public override val paramName: KotlinString = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.context.facilityType"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.context?.facilityType)
  }

  public data object Format : SearchParam<DocumentReference, Coding> {
    public override val paramName: KotlinString = "format"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.content.format"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Coding> =
      resource.content.mapNotNull { it.format }
  }

  public data object Identifier : SearchParam<DocumentReference, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.masterIdentifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: DocumentReference
    ): List<dev.ohs.fhir.model.r4.Identifier> = listOfNotNull(resource.masterIdentifier)
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

  public data object Patient : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "DocumentReference.subject.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient", "Group")

    public override fun extract(resource: DocumentReference): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : SearchParam<DocumentReference, dev.ohs.fhir.model.r4.Period> {
    public override val paramName: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "DocumentReference.context.period"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<dev.ohs.fhir.model.r4.Period> =
      listOfNotNull(resource.context?.period)
  }

  public data object Related : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "related"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.context.related"

    public override val target: List<KotlinString> =
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

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.context?.related ?: emptyList()
  }

  public data object Relatesto : SearchParam<DocumentReference, Reference> {
    public override val paramName: KotlinString = "relatesto"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "DocumentReference.relatesTo.target"

    public override val target: List<KotlinString> = listOf("DocumentReference")

    public override fun extract(resource: DocumentReference): List<Reference> =
      resource.relatesTo.map { it.target }
  }

  public data object Relation : SearchParam<DocumentReference, Any> {
    public override val paramName: KotlinString = "relation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "DocumentReference.relatesTo.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<Any> =
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

    public override val expression: KotlinString = "DocumentReference.context.practiceSetting"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: DocumentReference): List<CodeableConcept> =
      listOfNotNull(resource.context?.practiceSetting)
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
      listOf("Practitioner", "Group", "Device", "Patient")

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
}
