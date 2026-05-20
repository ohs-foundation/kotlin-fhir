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

import dev.ohs.fhir.model.r4b.Contract
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Contract] resource type. */
public sealed class ContractSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Contract): List<T>

  public data object Authority : ContractSearchParam<Reference>() {
    public override val paramName: String = "authority"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Contract.authority"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Contract): List<Reference> = resource.authority
  }

  public data object Domain : ContractSearchParam<Reference>() {
    public override val paramName: String = "domain"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Contract.domain"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Contract): List<Reference> = resource.domain
  }

  public data object Identifier : ContractSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Contract.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Contract): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Instantiates : ContractSearchParam<Uri>() {
    public override val paramName: String = "instantiates"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Contract.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Contract): List<Uri> =
      listOfNotNull(resource.instantiatesUri)
  }

  public data object Issued : ContractSearchParam<DateTime>() {
    public override val paramName: String = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Contract.issued"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Contract): List<DateTime> = listOfNotNull(resource.issued)
  }

  public data object Patient : ContractSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Contract.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Contract): List<Reference> =
      resource.subject.filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Signer : ContractSearchParam<Reference>() {
    public override val paramName: String = "signer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Contract.signer.party"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Contract): List<Reference> =
      resource.signer.map { it.party }
  }

  public data object Status : ContractSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Contract.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Contract): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : ContractSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Contract.subject"

    public override val target: List<String> =
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

    public override fun extract(resource: Contract): List<Reference> = resource.subject
  }

  public data object Url : ContractSearchParam<Uri>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Contract.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Contract): List<Uri> = listOfNotNull(resource.url)
  }

  public companion object {
    /** All search parameters for the Contract resource type. */
    public val ALL: List<ContractSearchParam<*>> =
      listOf(
        Authority,
        Domain,
        Identifier,
        Instantiates,
        Issued,
        Patient,
        Signer,
        Status,
        Subject,
        Url,
      )
  }
}
