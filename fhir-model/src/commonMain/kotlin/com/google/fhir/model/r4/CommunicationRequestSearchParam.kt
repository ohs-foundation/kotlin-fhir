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

/** Search parameters for the [CommunicationRequest] resource type. */
public sealed class CommunicationRequestSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CommunicationRequest): List<T>

  public data object Authored : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CommunicationRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object BasedOn : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.basedOn"

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

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Category : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Encounter : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object GroupIdentifier : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.groupIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Identifier : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Medium : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "medium"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.medium"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Occurrence : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "occurrence"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(CommunicationRequest.occurrence as dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Patient : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "CommunicationRequest.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Priority : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Recipient : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "recipient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.recipient"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Group",
        "Organization",
        "CareTeam",
        "Device",
        "Patient",
        "HealthcareService",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Replaces : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "replaces"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.replaces"

    public override val target: List<String> = listOf("CommunicationRequest")

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Requester : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.requester"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Sender : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "sender"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.sender"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "HealthcareService",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Status : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Subject : CommunicationRequestSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the CommunicationRequest resource type. */
    public val ALL: List<CommunicationRequestSearchParam<*>> =
      listOf(
        Authored,
        BasedOn,
        Category,
        Encounter,
        GroupIdentifier,
        Identifier,
        Medium,
        Occurrence,
        Patient,
        Priority,
        Recipient,
        Replaces,
        Requester,
        Sender,
        Status,
        Subject,
      )
  }
}
