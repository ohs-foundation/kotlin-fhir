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
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Observation] resource type. */
public sealed class ObservationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Observation): List<T>

  public data object BasedOn : ObservationSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.basedOn"

    public override val target: List<String> =
      listOf(
        "DeviceRequest",
        "ServiceRequest",
        "CarePlan",
        "MedicationRequest",
        "ImmunizationRecommendation",
        "NutritionOrder",
      )

    public override fun extract(resource: Observation): List<Reference> = resource.basedOn
  }

  public data object Category : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> = resource.category
  }

  public data object Code : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object CodeValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueDate : ObservationSearchParam<Any>() {
    public override val paramName: String = "code-value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueString : ObservationSearchParam<Any>() {
    public override val paramName: String = "code-value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboCode : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: String = "combo-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object ComboCodeValueConcept : ObservationSearchParam<Observation.Component>() {
    public override val paramName: String = "combo-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation.component"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComboCodeValueQuantity : ObservationSearchParam<Observation.Component>() {
    public override val paramName: String = "combo-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation.component"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComboDataAbsentReason : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: String = "combo-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.dataAbsentReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.dataAbsentReason)
  }

  public data object ComboValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "combo-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.value.ofType(CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "combo-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Observation.value.ofType(Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentCode : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: String = "component-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.component.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      resource.component.map { it.code }
  }

  public data object ComponentCodeValueConcept : ObservationSearchParam<Observation.Component>() {
    public override val paramName: String = "component-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation.component"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComponentCodeValueQuantity : ObservationSearchParam<Observation.Component>() {
    public override val paramName: String = "component-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation.component"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComponentDataAbsentReason : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: String = "component-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.component.dataAbsentReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      resource.component.mapNotNull { it.dataAbsentReason }
  }

  public data object ComponentValueCanonical : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-value-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Observation.component.value.ofType(canonical)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.component.value.ofType(CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Observation.component.value.ofType(Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentValueReference : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-value-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.component.value.ofType(Reference)"

    public override val target: List<String> = listOf("MolecularSequence")

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object DataAbsentReason : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: String = "data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.dataAbsentReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.dataAbsentReason)
  }

  public data object Date : ObservationSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Observation.effective.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object DerivedFrom : ObservationSearchParam<Reference>() {
    public override val paramName: String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.derivedFrom"

    public override val target: List<String> =
      listOf(
        "ImagingStudy",
        "DocumentReference",
        "Observation",
        "MolecularSequence",
        "GenomicStudy",
        "ImagingSelection",
        "QuestionnaireResponse",
      )

    public override fun extract(resource: Observation): List<Reference> = resource.derivedFrom
  }

  public data object Device : ObservationSearchParam<Reference>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.device"

    public override val target: List<String> = listOf("Device", "DeviceMetric")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.device)
  }

  public data object Encounter : ObservationSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Focus : ObservationSearchParam<Reference>() {
    public override val paramName: String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.focus"

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

    public override fun extract(resource: Observation): List<Reference> = resource.focus
  }

  public data object HasMember : ObservationSearchParam<Reference>() {
    public override val paramName: String = "has-member"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.hasMember"

    public override val target: List<String> =
      listOf("Observation", "MolecularSequence", "QuestionnaireResponse")

    public override fun extract(resource: Observation): List<Reference> = resource.hasMember
  }

  public data object Identifier : ObservationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Method : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: String = "method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.method"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.method)
  }

  public data object PartOf : ObservationSearchParam<Reference>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.partOf"

    public override val target: List<String> =
      listOf(
        "ImagingStudy",
        "Procedure",
        "MedicationStatement",
        "MedicationAdministration",
        "GenomicStudy",
        "Immunization",
        "MedicationDispense",
      )

    public override fun extract(resource: Observation): List<Reference> = resource.partOf
  }

  public data object Patient : ObservationSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : ObservationSearchParam<Reference>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.performer"

    public override val target: List<String> =
      listOf(
        "Organization",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Observation): List<Reference> = resource.performer
  }

  public data object Specimen : ObservationSearchParam<Reference>() {
    public override val paramName: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.specimen"

    public override val target: List<String> = listOf("Group", "Specimen")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.specimen)
  }

  public data object Status : ObservationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = listOf(resource.status)
  }

  public data object Subject : ObservationSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.subject"

    public override val target: List<String> =
      listOf(
        "Device",
        "Organization",
        "Procedure",
        "NutritionProduct",
        "Group",
        "Practitioner",
        "BiologicallyDerivedProduct",
        "Substance",
        "Location",
        "Patient",
        "Medication",
      )

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object ValueCanonical : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Observation.value.ofType(canonical)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.value.ofType(CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueDate : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Observation.value.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueMarkdown : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-markdown"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Observation.value.ofType(markdown)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Observation.value.ofType(Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueReference : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.value.ofType(Reference)"

    public override val target: List<String> = listOf("MolecularSequence")

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Observation resource type. */
    public val ALL: List<ObservationSearchParam<*>> =
      listOf(
        BasedOn,
        Category,
        Code,
        CodeValueConcept,
        CodeValueDate,
        CodeValueQuantity,
        CodeValueString,
        ComboCode,
        ComboCodeValueConcept,
        ComboCodeValueQuantity,
        ComboDataAbsentReason,
        ComboValueConcept,
        ComboValueQuantity,
        ComponentCode,
        ComponentCodeValueConcept,
        ComponentCodeValueQuantity,
        ComponentDataAbsentReason,
        ComponentValueCanonical,
        ComponentValueConcept,
        ComponentValueQuantity,
        ComponentValueReference,
        DataAbsentReason,
        Date,
        DerivedFrom,
        Device,
        Encounter,
        Focus,
        HasMember,
        Identifier,
        Method,
        PartOf,
        Patient,
        Performer,
        Specimen,
        Status,
        Subject,
        ValueCanonical,
        ValueConcept,
        ValueDate,
        ValueMarkdown,
        ValueQuantity,
        ValueReference,
      )
  }
}
