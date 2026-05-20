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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Consent
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Consent] resource type. */
public object ConsentSearchParam {
  /** All search parameters for the Consent resource type. */
  public val ALL: List<SearchParam<Consent, *>> =
    listOf(
      Action,
      Actor,
      Category,
      Consentor,
      Data,
      Date,
      Identifier,
      Organization,
      Patient,
      Period,
      Purpose,
      Scope,
      SecurityLabel,
      SourceReference,
      Status,
    )

  public data object Action : SearchParam<Consent, CodeableConcept> {
    public override val paramName: String = "action"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.provision.action"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<CodeableConcept> =
      resource.provision?.action ?: emptyList()
  }

  public data object Actor : SearchParam<Consent, Reference> {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.provision.actor.reference"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Group",
        "Organization",
        "CareTeam",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: Consent): List<Reference> =
      (resource.provision?.actor ?: emptyList()).map { it.reference }
  }

  public data object Category : SearchParam<Consent, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<CodeableConcept> = resource.category
  }

  public data object Consentor : SearchParam<Consent, Reference> {
    public override val paramName: String = "consentor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.performer"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Consent): List<Reference> = resource.performer
  }

  public data object Data : SearchParam<Consent, Reference> {
    public override val paramName: String = "data"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.provision.data.reference"

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

    public override fun extract(resource: Consent): List<Reference> =
      (resource.provision?.data ?: emptyList()).map { it.reference }
  }

  public data object Date : SearchParam<Consent, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Consent.dateTime"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<DateTime> =
      listOfNotNull(resource.dateTime)
  }

  public data object Identifier : SearchParam<Consent, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Organization : SearchParam<Consent, Reference> {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.organization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Consent): List<Reference> = resource.organization
  }

  public data object Patient : SearchParam<Consent, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Consent): List<Reference> =
      listOfNotNull(resource.patient)
  }

  public data object Period : SearchParam<Consent, dev.ohs.fhir.model.r4b.Period> {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Consent.provision.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<dev.ohs.fhir.model.r4b.Period> =
      listOfNotNull(resource.provision?.period)
  }

  public data object Purpose : SearchParam<Consent, Coding> {
    public override val paramName: String = "purpose"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.provision.purpose"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<Coding> =
      resource.provision?.purpose ?: emptyList()
  }

  public data object Scope : SearchParam<Consent, CodeableConcept> {
    public override val paramName: String = "scope"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.scope"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<CodeableConcept> = listOf(resource.scope)
  }

  public data object SecurityLabel : SearchParam<Consent, Coding> {
    public override val paramName: String = "security-label"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.provision.securityLabel"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<Coding> =
      resource.provision?.securityLabel ?: emptyList()
  }

  public data object SourceReference : SearchParam<Consent, Consent.Source> {
    public override val paramName: String = "source-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Consent.source"

    public override val target: List<String> =
      listOf("Consent", "Contract", "QuestionnaireResponse", "DocumentReference")

    public override fun extract(resource: Consent): List<Consent.Source> =
      listOfNotNull(resource.source)
  }

  public data object Status : SearchParam<Consent, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Consent.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Consent): List<Any> = listOf(resource.status)
  }
}
