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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Observation] resource type. */
public sealed class ObservationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Observation): List<T>

  public data object AminoAcidChange : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "amino-acid-change"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object BasedOn : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.basedOn"

    public override val target: List<kotlin.String> =
      listOf(
        "CarePlan",
        "MedicationRequest",
        "NutritionOrder",
        "DeviceRequest",
        "ServiceRequest",
        "ImmunizationRecommendation",
      )

    public override fun extract(resource: Observation): List<Reference> = resource.basedOn
  }

  public data object Category : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> = resource.category
  }

  public data object Code : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object CodeValueConcept : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Observation"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueDate : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "code-value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Observation"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueQuantity : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Observation"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueString : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "code-value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Observation"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboCode : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "combo-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object ComboCodeValueConcept : ObservationSearchParam<Observation.Component>() {
    public override val paramName: kotlin.String = "combo-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Observation.component"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComboCodeValueQuantity : ObservationSearchParam<Observation.Component>() {
    public override val paramName: kotlin.String = "combo-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Observation.component"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComboDataAbsentReason : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "combo-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.dataAbsentReason"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.dataAbsentReason)
  }

  public data object ComboValueConcept : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "combo-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "(Observation.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull((resource.value as? Observation.Value.CodeableConcept)?.value)
  }

  public data object ComboValueQuantity : ObservationSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "combo-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(Observation.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Quantity> =
      listOfNotNull((resource.value as? Observation.Value.Quantity)?.value)
  }

  public data object ComponentCode : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "component-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.component.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      resource.component.map { it.code }
  }

  public data object ComponentCodeValueConcept : ObservationSearchParam<Observation.Component>() {
    public override val paramName: kotlin.String = "component-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Observation.component"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComponentCodeValueQuantity : ObservationSearchParam<Observation.Component>() {
    public override val paramName: kotlin.String = "component-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Observation.component"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComponentDataAbsentReason : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "component-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.component.dataAbsentReason"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      resource.component.mapNotNull { it.dataAbsentReason }
  }

  public data object ComponentValueConcept : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "component-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(Observation.component.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      resource.component.mapNotNull {
        (it.value as? Observation.Component.Value.CodeableConcept)?.value
      }
  }

  public data object ComponentValueQuantity : ObservationSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "component-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(Observation.component.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Quantity> =
      resource.component.mapNotNull { (it.value as? Observation.Component.Value.Quantity)?.value }
  }

  public data object DataAbsentReason : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.dataAbsentReason"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.dataAbsentReason)
  }

  public data object Date : ObservationSearchParam<Observation.Effective>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Observation.effective"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Effective> =
      listOfNotNull(resource.effective)
  }

  public data object DerivedFrom : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.derivedFrom"

    public override val target: List<kotlin.String> =
      listOf(
        "Media",
        "Observation",
        "ImagingStudy",
        "MolecularSequence",
        "QuestionnaireResponse",
        "DocumentReference",
      )

    public override fun extract(resource: Observation): List<Reference> = resource.derivedFrom
  }

  public data object Device : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.device"

    public override val target: List<kotlin.String> = listOf("Device", "DeviceMetric")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.device)
  }

  public data object DnaVariant : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "dna-variant"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Encounter : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.encounter"

    public override val target: List<kotlin.String> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Focus : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.focus"

    public override val target: List<kotlin.String> =
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

    public override fun extract(resource: Observation): List<Reference> = resource.focus
  }

  public data object GeneAminoAcidChange : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "gene-amino-acid-change"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object GeneDnavariant : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "gene-dnavariant"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object GeneIdentifier : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "gene-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsGene')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object HasMember : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "has-member"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.hasMember"

    public override val target: List<kotlin.String> =
      listOf("Observation", "MolecularSequence", "QuestionnaireResponse")

    public override fun extract(resource: Observation): List<Reference> = resource.hasMember
  }

  public data object Identifier : ObservationSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Method : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.method"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.method)
  }

  public data object PartOf : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.partOf"

    public override val target: List<kotlin.String> =
      listOf(
        "Immunization",
        "MedicationDispense",
        "MedicationAdministration",
        "Procedure",
        "ImagingStudy",
        "MedicationStatement",
      )

    public override fun extract(resource: Observation): List<Reference> = resource.partOf
  }

  public data object Patient : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "Observation.subject.where(resolve() is Patient)"

    public override val target: List<kotlin.String> = listOf("Patient", "Group")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.performer"

    public override val target: List<kotlin.String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: Observation): List<Reference> = resource.performer
  }

  public data object Specimen : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.specimen"

    public override val target: List<kotlin.String> = listOf("Specimen")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.specimen)
  }

  public data object Status : ObservationSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Observation.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Any> = listOf(resource.status)
  }

  public data object Subject : ObservationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Observation.subject"

    public override val target: List<kotlin.String> =
      listOf("Group", "Device", "Patient", "Location")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object ValueConcept : ObservationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "(Observation.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull((resource.value as? Observation.Value.CodeableConcept)?.value)
  }

  public data object ValueDate : ObservationSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "(Observation.value as dateTime)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<DateTime> =
      listOfNotNull((resource.value as? Observation.Value.DateTime)?.value)
  }

  public data object ValueQuantity : ObservationSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(Observation.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<Quantity> =
      listOfNotNull((resource.value as? Observation.Value.Quantity)?.value)
  }

  public data object ValueString : ObservationSearchParam<String>() {
    public override val paramName: kotlin.String = "value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "(Observation.value as string)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Observation): List<String> =
      listOfNotNull((resource.value as? Observation.Value.String)?.value)
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
