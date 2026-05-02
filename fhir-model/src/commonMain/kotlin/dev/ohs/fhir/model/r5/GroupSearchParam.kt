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

/** Search parameters for the [Group] resource type. */
public sealed class GroupSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Group): List<T>

  public data object Characteristic : GroupSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Group.characteristic.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<CodeableConcept> =
      resource.characteristic.map { it.code }
  }

  public data object CharacteristicReference : GroupSearchParam<Any>() {
    public override val paramName: kotlin.String = "characteristic-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "(Group.characteristic.value.ofType(Reference))"

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

    public override fun extract(resource: Group): List<Any> = emptyList()
  }

  public data object CharacteristicValue : GroupSearchParam<Group.Characteristic>() {
    public override val paramName: kotlin.String = "characteristic-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Group.characteristic"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<Group.Characteristic> =
      resource.characteristic
  }

  public data object Code : GroupSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Group.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Exclude : GroupSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "exclude"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Group.characteristic.exclude"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<Boolean> =
      resource.characteristic.map { it.exclude }
  }

  public data object Identifier : GroupSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Group.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object ManagingEntity : GroupSearchParam<Reference>() {
    public override val paramName: kotlin.String = "managing-entity"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Group.managingEntity"

    public override val target: List<kotlin.String> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner")

    public override fun extract(resource: Group): List<Reference> =
      listOfNotNull(resource.managingEntity)
  }

  public data object Member : GroupSearchParam<Reference>() {
    public override val paramName: kotlin.String = "member"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Group.member.entity"

    public override val target: List<kotlin.String> =
      listOf(
        "HealthcareService",
        "CareTeam",
        "Device",
        "Organization",
        "RelatedPerson",
        "PractitionerRole",
        "Group",
        "Practitioner",
        "Specimen",
        "Location",
        "Patient",
      )

    public override fun extract(resource: Group): List<Reference> =
      resource.member.map { it.entity }
  }

  public data object Membership : GroupSearchParam<Any>() {
    public override val paramName: kotlin.String = "membership"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Group.membership"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<Any> = listOf(resource.membership)
  }

  public data object Name : GroupSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Group.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<String> = listOfNotNull(resource.name)
  }

  public data object Type : GroupSearchParam<Any>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Group.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<Any> = listOf(resource.type)
  }

  public data object Value : GroupSearchParam<Any>() {
    public override val paramName: kotlin.String = "value"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(Group.characteristic.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Group): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Group resource type. */
    public val ALL: List<GroupSearchParam<*>> =
      listOf(
        Characteristic,
        CharacteristicReference,
        CharacteristicValue,
        Code,
        Exclude,
        Identifier,
        ManagingEntity,
        Member,
        Membership,
        Name,
        Type,
        Value,
      )
  }
}
