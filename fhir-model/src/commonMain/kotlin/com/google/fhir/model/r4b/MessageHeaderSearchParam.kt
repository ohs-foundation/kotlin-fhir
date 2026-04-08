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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MessageHeader] resource type. */
public sealed class MessageHeaderSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MessageHeader): List<T>

  public data object Author : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MessageHeader.author"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Code : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageHeader.response.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Destination : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "MessageHeader.destination.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object DestinationUri : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "destination-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "MessageHeader.destination.endpoint"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Enterer : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MessageHeader.enterer"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Event : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageHeader.event"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Focus : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MessageHeader.focus"

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

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Receiver : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MessageHeader.destination.receiver"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object ResponseId : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "response-id"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageHeader.response.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Responsible : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MessageHeader.responsible"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Sender : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "sender"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MessageHeader.sender"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Source : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "MessageHeader.source.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object SourceUri : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "source-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "MessageHeader.source.endpoint"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public data object Target : MessageHeaderSearchParam<Any>() {
    public override val paramName: String = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MessageHeader.destination.target"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: MessageHeader): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the MessageHeader resource type. */
    public val ALL: List<MessageHeaderSearchParam<*>> =
      listOf(
        Author,
        Code,
        Destination,
        DestinationUri,
        Enterer,
        Event,
        Focus,
        Receiver,
        ResponseId,
        Responsible,
        Sender,
        Source,
        SourceUri,
        Target,
      )
  }
}
