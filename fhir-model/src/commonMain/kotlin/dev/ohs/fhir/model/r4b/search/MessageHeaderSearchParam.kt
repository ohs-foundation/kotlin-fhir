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

import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.MessageHeader
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MessageHeader] resource type. */
public object MessageHeaderSearchParam {
  /** All search parameters for the MessageHeader resource type. */
  public val ALL: List<SearchParam<MessageHeader, *>> =
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

  public data object Author : SearchParam<MessageHeader, Reference> {
    public override val paramName: KotlinString = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.author"

    public override val target: List<KotlinString> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.author)
  }

  public data object Code : SearchParam<MessageHeader, Any> {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageHeader.response.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> =
      listOfNotNull(resource.response?.code)
  }

  public data object Destination : SearchParam<MessageHeader, R4bString> {
    public override val paramName: KotlinString = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MessageHeader.destination.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<R4bString> =
      resource.destination.mapNotNull { it.name }
  }

  public data object DestinationUri : SearchParam<MessageHeader, Url> {
    public override val paramName: KotlinString = "destination-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "MessageHeader.destination.endpoint"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<Url> =
      resource.destination.map { it.endpoint }
  }

  public data object Enterer : SearchParam<MessageHeader, Reference> {
    public override val paramName: KotlinString = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.enterer"

    public override val target: List<KotlinString> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.enterer)
  }

  public data object Event : SearchParam<MessageHeader, MessageHeader.Event> {
    public override val paramName: KotlinString = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageHeader.event"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<MessageHeader.Event> =
      listOf(resource.event)
  }

  public data object Focus : SearchParam<MessageHeader, Reference> {
    public override val paramName: KotlinString = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.focus"

    public override val target: List<KotlinString> =
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

    public override fun extract(resource: MessageHeader): List<Reference> = resource.focus
  }

  public data object Receiver : SearchParam<MessageHeader, Reference> {
    public override val paramName: KotlinString = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.destination.receiver"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      resource.destination.mapNotNull { it.receiver }
  }

  public data object ResponseId : SearchParam<MessageHeader, Id> {
    public override val paramName: KotlinString = "response-id"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageHeader.response.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<Id> =
      listOfNotNull(resource.response?.identifier)
  }

  public data object Responsible : SearchParam<MessageHeader, Reference> {
    public override val paramName: KotlinString = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.responsible"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.responsible)
  }

  public data object Sender : SearchParam<MessageHeader, Reference> {
    public override val paramName: KotlinString = "sender"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.sender"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.sender)
  }

  public data object Source : SearchParam<MessageHeader, R4bString> {
    public override val paramName: KotlinString = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MessageHeader.source.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<R4bString> =
      listOfNotNull(resource.source.name)
  }

  public data object SourceUri : SearchParam<MessageHeader, Url> {
    public override val paramName: KotlinString = "source-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "MessageHeader.source.endpoint"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<Url> =
      listOf(resource.source.endpoint)
  }

  public data object Target : SearchParam<MessageHeader, Reference> {
    public override val paramName: KotlinString = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.destination.target"

    public override val target: List<KotlinString> = listOf("Device")

    public override fun extract(resource: MessageHeader): List<Reference> =
      resource.destination.mapNotNull { it.target }
  }
}
