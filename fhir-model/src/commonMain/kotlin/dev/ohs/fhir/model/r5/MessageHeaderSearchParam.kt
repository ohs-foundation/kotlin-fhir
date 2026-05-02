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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MessageHeader] resource type. */
public sealed class MessageHeaderSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MessageHeader): List<T>

  public data object Author : MessageHeaderSearchParam<Reference>() {
    public override val paramName: kotlin.String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MessageHeader.author"

    public override val target: List<kotlin.String> =
      listOf("Device", "Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.author)
  }

  public data object Code : MessageHeaderSearchParam<Any>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageHeader.response.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> =
      listOfNotNull(resource.response?.code)
  }

  public data object Destination : MessageHeaderSearchParam<String>() {
    public override val paramName: kotlin.String = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "MessageHeader.destination.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageHeader): List<String> =
      resource.destination.mapNotNull { it.name }
  }

  public data object Event : MessageHeaderSearchParam<Any>() {
    public override val paramName: kotlin.String = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageHeader.event.ofType(Coding)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Focus : MessageHeaderSearchParam<Reference>() {
    public override val paramName: kotlin.String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MessageHeader.focus"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: MessageHeader): List<Reference> = resource.focus
  }

  public data object Receiver : MessageHeaderSearchParam<Reference>() {
    public override val paramName: kotlin.String = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MessageHeader.destination.receiver"

    public override val target: List<kotlin.String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: MessageHeader): List<Reference> =
      resource.destination.mapNotNull { it.receiver }
  }

  public data object ResponseId : MessageHeaderSearchParam<Identifier>() {
    public override val paramName: kotlin.String = "response-id"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageHeader.response.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Identifier> =
      listOfNotNull(resource.response?.identifier)
  }

  public data object Responsible : MessageHeaderSearchParam<Reference>() {
    public override val paramName: kotlin.String = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MessageHeader.responsible"

    public override val target: List<kotlin.String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.responsible)
  }

  public data object Sender : MessageHeaderSearchParam<Reference>() {
    public override val paramName: kotlin.String = "sender"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MessageHeader.sender"

    public override val target: List<kotlin.String> =
      listOf("Device", "Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.sender)
  }

  public data object Source : MessageHeaderSearchParam<String>() {
    public override val paramName: kotlin.String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "MessageHeader.source.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageHeader): List<String> =
      listOfNotNull(resource.source.name)
  }

  public data object Target : MessageHeaderSearchParam<Reference>() {
    public override val paramName: kotlin.String = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MessageHeader.destination.target"

    public override val target: List<kotlin.String> = listOf("Device")

    public override fun extract(resource: MessageHeader): List<Reference> =
      resource.destination.mapNotNull { it.target }
  }

  public companion object {
    /** All search parameters for the MessageHeader resource type. */
    public val ALL: List<MessageHeaderSearchParam<*>> =
      listOf(
        Author,
        Code,
        Destination,
        Event,
        Focus,
        Receiver,
        ResponseId,
        Responsible,
        Sender,
        Source,
        Target,
      )
  }
}
