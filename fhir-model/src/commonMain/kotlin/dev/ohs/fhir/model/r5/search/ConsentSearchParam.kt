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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Consent
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Consent] resource type. */
public sealed class ConsentSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Consent): List<T>

  public data object Action : ConsentSearchParam<CodeableConcept>() {
    public override val paramName: String = "action"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.provision.action"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<CodeableConcept> =
      resource.provision.flatMap { it.action }
  }

  public data object Actor : ConsentSearchParam<Reference>() {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.provision.actor.reference"

    public override val target: List<String> =
      listOf(
        "Device",
        "CareTeam",
        "Organization",
        "RelatedPerson",
        "PractitionerRole",
        "Group",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Consent): List<Reference> =
      resource.provision.flatMap { it.actor }.mapNotNull { it.reference }
  }

  public data object Category : ConsentSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<CodeableConcept> = resource.category
  }

  public data object Controller : ConsentSearchParam<Reference>() {
    public override val paramName: String = "controller"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.controller"

    public override val target: List<String> =
      listOf("HealthcareService", "Organization", "Practitioner", "Patient")

    public override fun extract(resource: Consent): List<Reference> = resource.controller
  }

  public data object Data : ConsentSearchParam<Reference>() {
    public override val paramName: String = "data"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.provision.data.reference"

    public override val target: List<String> =
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

    public override fun extract(resource: Consent): List<Reference> =
      resource.provision.flatMap { it.data }.map { it.reference }
  }

  public data object Date : ConsentSearchParam<dev.ohs.fhir.model.r5.Date>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Consent.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<dev.ohs.fhir.model.r5.Date> =
      listOfNotNull(resource.date)
  }

  public data object Grantee : ConsentSearchParam<Reference>() {
    public override val paramName: String = "grantee"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.grantee"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "CareTeam",
        "Organization",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Consent): List<Reference> = resource.grantee
  }

  public data object Identifier : ConsentSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Manager : ConsentSearchParam<Reference>() {
    public override val paramName: String = "manager"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.manager"

    public override val target: List<String> =
      listOf("HealthcareService", "Organization", "Practitioner", "Patient")

    public override fun extract(resource: Consent): List<Reference> = resource.manager
  }

  public data object Patient : ConsentSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Consent): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Period : ConsentSearchParam<dev.ohs.fhir.model.r5.Period>() {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Consent.provision.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<dev.ohs.fhir.model.r5.Period> =
      resource.provision.mapNotNull { it.period }
  }

  public data object Purpose : ConsentSearchParam<Coding>() {
    public override val paramName: String = "purpose"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.provision.purpose"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<Coding> =
      resource.provision.flatMap { it.purpose }
  }

  public data object SecurityLabel : ConsentSearchParam<Coding>() {
    public override val paramName: String = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.provision.securityLabel"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<Coding> =
      resource.provision.flatMap { it.securityLabel }
  }

  public data object SourceReference : ConsentSearchParam<Reference>() {
    public override val paramName: String = "source-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.sourceReference"

    public override val target: List<String> =
      listOf("Consent", "DocumentReference", "Contract", "QuestionnaireResponse")

    public override fun extract(resource: Consent): List<Reference> = resource.sourceReference
  }

  public data object Status : ConsentSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<Any> = listOf(resource.status)
  }

  public data object Subject : ConsentSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.subject"

    public override val target: List<String> = listOf("Practitioner", "Group", "Patient")

    public override fun extract(resource: Consent): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Verified : ConsentSearchParam<Boolean>() {
    public override val paramName: String = "verified"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.verification.verified"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<Boolean> =
      resource.verification.map { it.verified }
  }

  public data object VerifiedDate : ConsentSearchParam<DateTime>() {
    public override val paramName: String = "verified-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Consent.verification.verificationDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<DateTime> =
      resource.verification.flatMap { it.verificationDate }
  }

  public companion object {
    /** All search parameters for the Consent resource type. */
    public val ALL: List<ConsentSearchParam<*>> =
      listOf(
        Action,
        Actor,
        Category,
        Controller,
        Data,
        Date,
        Grantee,
        Identifier,
        Manager,
        Patient,
        Period,
        Purpose,
        SecurityLabel,
        SourceReference,
        Status,
        Subject,
        Verified,
        VerifiedDate,
      )
  }
}
