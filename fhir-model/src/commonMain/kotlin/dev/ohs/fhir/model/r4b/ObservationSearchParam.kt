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

/** Search parameters for the [Observation] resource type. */
public sealed class ObservationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Observation): List<T>

  public data object AminoAcidChange : ObservationSearchParam<Any>() {
    public override val paramName: String = "amino-acid-change"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object BasedOn : ObservationSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.basedOn"

    public override val target: List<String> =
      listOf(
        "CarePlan",
        "MedicationRequest",
        "NutritionOrder",
        "DeviceRequest",
        "ServiceRequest",
        "ImmunizationRecommendation",
      )

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Category : ObservationSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Code : ObservationSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
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

  public data object ComboCode : ObservationSearchParam<Any>() {
    public override val paramName: String = "combo-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboCodeValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "combo-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation.component"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboCodeValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "combo-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation.component"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboDataAbsentReason : ObservationSearchParam<Any>() {
    public override val paramName: String = "combo-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.dataAbsentReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "combo-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(Observation.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "combo-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(Observation.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentCode : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.component.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentCodeValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation.component"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentCodeValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Observation.component"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentDataAbsentReason : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.component.dataAbsentReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(Observation.component.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComponentValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "component-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(Observation.component.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object DataAbsentReason : ObservationSearchParam<Any>() {
    public override val paramName: String = "data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.dataAbsentReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Date : ObservationSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Observation.effective"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object DerivedFrom : ObservationSearchParam<Any>() {
    public override val paramName: String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.derivedFrom"

    public override val target: List<String> =
      listOf(
        "Media",
        "Observation",
        "ImagingStudy",
        "MolecularSequence",
        "QuestionnaireResponse",
        "DocumentReference",
      )

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Device : ObservationSearchParam<Any>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.device"

    public override val target: List<String> = listOf("Device", "DeviceMetric")

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object DnaVariant : ObservationSearchParam<Any>() {
    public override val paramName: String = "dna-variant"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Encounter : ObservationSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Focus : ObservationSearchParam<Any>() {
    public override val paramName: String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.focus"

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

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object GeneAminoAcidChange : ObservationSearchParam<Any>() {
    public override val paramName: String = "gene-amino-acid-change"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object GeneDnavariant : ObservationSearchParam<Any>() {
    public override val paramName: String = "gene-dnavariant"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object GeneIdentifier : ObservationSearchParam<Any>() {
    public override val paramName: String = "gene-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsGene')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object HasMember : ObservationSearchParam<Any>() {
    public override val paramName: String = "has-member"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.hasMember"

    public override val target: List<String> =
      listOf("Observation", "MolecularSequence", "QuestionnaireResponse")

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Identifier : ObservationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Method : ObservationSearchParam<Any>() {
    public override val paramName: String = "method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.method"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object PartOf : ObservationSearchParam<Any>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.partOf"

    public override val target: List<String> =
      listOf(
        "Immunization",
        "MedicationDispense",
        "MedicationAdministration",
        "Procedure",
        "ImagingStudy",
        "MedicationStatement",
      )

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Patient : ObservationSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Performer : ObservationSearchParam<Any>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.performer"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Specimen : ObservationSearchParam<Any>() {
    public override val paramName: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.specimen"

    public override val target: List<String> = listOf("Specimen")

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Status : ObservationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Observation.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Subject : ObservationSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Observation.subject"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Group",
        "Organization",
        "Device",
        "Medication",
        "Patient",
        "Procedure",
        "Substance",
        "Location",
      )

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(Observation.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueDate : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(Observation.value as dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(Observation.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ValueString : ObservationSearchParam<Any>() {
    public override val paramName: String = "value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "(Observation.value as string)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Observation resource type. */
    public val ALL: List<ObservationSearchParam<*>> =
      listOf(
        AminoAcidChange,
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
        ComponentValueConcept,
        ComponentValueQuantity,
        DataAbsentReason,
        Date,
        DerivedFrom,
        Device,
        DnaVariant,
        Encounter,
        Focus,
        GeneAminoAcidChange,
        GeneDnavariant,
        GeneIdentifier,
        HasMember,
        Identifier,
        Method,
        PartOf,
        Patient,
        Performer,
        Specimen,
        Status,
        Subject,
        ValueConcept,
        ValueDate,
        ValueQuantity,
        ValueString,
      )
  }
}
