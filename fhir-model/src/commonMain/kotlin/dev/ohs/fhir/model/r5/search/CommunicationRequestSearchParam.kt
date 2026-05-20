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
import dev.ohs.fhir.model.r5.CommunicationRequest
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CommunicationRequest] resource type. */
public object CommunicationRequestSearchParam {
  /** All search parameters for the CommunicationRequest resource type. */
  public val ALL: List<SearchParam<CommunicationRequest, *>> =
    listOf(
      Authored,
      BasedOn,
      Category,
      Encounter,
      GroupIdentifier,
      Identifier,
      InformationProvider,
      Medium,
      Occurrence,
      Patient,
      Priority,
      Recipient,
      Replaces,
      Requester,
      Status,
      Subject,
    )

  public data object Authored : SearchParam<CommunicationRequest, DateTime> {
    public override val paramName: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CommunicationRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object BasedOn : SearchParam<CommunicationRequest, Reference> {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.basedOn"

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

    public override fun extract(resource: CommunicationRequest): List<Reference> = resource.basedOn
  }

  public data object Category : SearchParam<CommunicationRequest, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<CodeableConcept> =
      resource.category
  }

  public data object Encounter : SearchParam<CommunicationRequest, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: CommunicationRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object GroupIdentifier :
    SearchParam<CommunicationRequest, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.groupIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: CommunicationRequest
    ): List<dev.ohs.fhir.model.r5.Identifier> = listOfNotNull(resource.groupIdentifier)
  }

  public data object Identifier :
    SearchParam<CommunicationRequest, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: CommunicationRequest
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object InformationProvider : SearchParam<CommunicationRequest, Reference> {
    public override val paramName: String = "information-provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.informationProvider"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Device",
        "Organization",
        "Endpoint",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: CommunicationRequest): List<Reference> =
      resource.informationProvider
  }

  public data object Medium : SearchParam<CommunicationRequest, CodeableConcept> {
    public override val paramName: String = "medium"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.medium"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<CodeableConcept> =
      resource.medium
  }

  public data object Occurrence : SearchParam<CommunicationRequest, Any> {
    public override val paramName: String = "occurrence"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CommunicationRequest.occurrence.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = emptyList()
  }

  public data object Patient : SearchParam<CommunicationRequest, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "CommunicationRequest.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: CommunicationRequest): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Priority : SearchParam<CommunicationRequest, Any> {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Recipient : SearchParam<CommunicationRequest, Reference> {
    public override val paramName: String = "recipient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.recipient"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Device",
        "Organization",
        "CareTeam",
        "Endpoint",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Group",
        "Patient",
      )

    public override fun extract(resource: CommunicationRequest): List<Reference> =
      resource.recipient
  }

  public data object Replaces : SearchParam<CommunicationRequest, Reference> {
    public override val paramName: String = "replaces"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.replaces"

    public override val target: List<String> = listOf("CommunicationRequest")

    public override fun extract(resource: CommunicationRequest): List<Reference> = resource.replaces
  }

  public data object Requester : SearchParam<CommunicationRequest, Reference> {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.requester"

    public override val target: List<String> =
      listOf(
        "Organization",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: CommunicationRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : SearchParam<CommunicationRequest, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CommunicationRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CommunicationRequest): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<CommunicationRequest, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CommunicationRequest.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: CommunicationRequest): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
