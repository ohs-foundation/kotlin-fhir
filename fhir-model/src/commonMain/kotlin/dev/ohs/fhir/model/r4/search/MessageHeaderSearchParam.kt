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

import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.MessageHeader
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MessageHeader] resource type. */
public sealed class MessageHeaderSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MessageHeader): List<T>

  public data object Author : MessageHeaderSearchParam<Reference>() {
    public override val paramName: KotlinString = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.author"

    public override val target: List<KotlinString> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.author)
  }

  public data object Code : MessageHeaderSearchParam<Any>() {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageHeader.response.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<Any> =
      listOfNotNull(resource.response?.code)
  }

  public data object Destination : MessageHeaderSearchParam<R4String>() {
    public override val paramName: KotlinString = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MessageHeader.destination.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<R4String> =
      resource.destination.mapNotNull { it.name }
  }

  public data object DestinationUri : MessageHeaderSearchParam<Url>() {
    public override val paramName: KotlinString = "destination-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "MessageHeader.destination.endpoint"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<Url> =
      resource.destination.map { it.endpoint }
  }

  public data object Enterer : MessageHeaderSearchParam<Reference>() {
    public override val paramName: KotlinString = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.enterer"

    public override val target: List<KotlinString> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.enterer)
  }

  public data object Event : MessageHeaderSearchParam<MessageHeader.Event>() {
    public override val paramName: KotlinString = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageHeader.event"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<MessageHeader.Event> =
      listOf(resource.event)
  }

  public data object Focus : MessageHeaderSearchParam<Reference>() {
    public override val paramName: KotlinString = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.focus"

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

    public override fun extract(resource: MessageHeader): List<Reference> = resource.focus
  }

  public data object Receiver : MessageHeaderSearchParam<Reference>() {
    public override val paramName: KotlinString = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.destination.receiver"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      resource.destination.mapNotNull { it.receiver }
  }

  public data object ResponseId : MessageHeaderSearchParam<Id>() {
    public override val paramName: KotlinString = "response-id"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageHeader.response.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<Id> =
      listOfNotNull(resource.response?.identifier)
  }

  public data object Responsible : MessageHeaderSearchParam<Reference>() {
    public override val paramName: KotlinString = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.responsible"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.responsible)
  }

  public data object Sender : MessageHeaderSearchParam<Reference>() {
    public override val paramName: KotlinString = "sender"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.sender"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: MessageHeader): List<Reference> =
      listOfNotNull(resource.sender)
  }

  public data object Source : MessageHeaderSearchParam<R4String>() {
    public override val paramName: KotlinString = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MessageHeader.source.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<R4String> =
      listOfNotNull(resource.source.name)
  }

  public data object SourceUri : MessageHeaderSearchParam<Url>() {
    public override val paramName: KotlinString = "source-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "MessageHeader.source.endpoint"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageHeader): List<Url> =
      listOf(resource.source.endpoint)
  }

  public data object Target : MessageHeaderSearchParam<Reference>() {
    public override val paramName: KotlinString = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageHeader.destination.target"

    public override val target: List<KotlinString> = listOf("Device")

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
