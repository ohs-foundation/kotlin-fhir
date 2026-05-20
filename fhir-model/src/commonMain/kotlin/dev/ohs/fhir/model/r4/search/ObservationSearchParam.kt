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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Observation
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Observation] resource type. */
public object ObservationSearchParam {
  /** All search parameters for the Observation resource type. */
  public val ALL: List<SearchParam<Observation, *>> =
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

  public data object AminoAcidChange : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "amino-acid-change"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object BasedOn : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.basedOn"

    public override val target: List<KotlinString> =
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

  public data object Category : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.category"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> = resource.category
  }

  public data object Code : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object CodeValueConcept : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueDate : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "code-value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueQuantity : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object CodeValueString : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "code-value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object ComboCode : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "combo-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object ComboCodeValueConcept : SearchParam<Observation, Observation.Component> {
    public override val paramName: KotlinString = "combo-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation.component"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComboCodeValueQuantity : SearchParam<Observation, Observation.Component> {
    public override val paramName: KotlinString = "combo-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation.component"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComboDataAbsentReason : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "combo-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.dataAbsentReason"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.dataAbsentReason)
  }

  public data object ComboValueConcept : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "combo-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Observation.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull((resource.value as? Observation.Value.CodeableConcept)?.value)
  }

  public data object ComboValueQuantity : SearchParam<Observation, Quantity> {
    public override val paramName: KotlinString = "combo-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Observation.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Quantity> =
      listOfNotNull((resource.value as? Observation.Value.Quantity)?.value)
  }

  public data object ComponentCode : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "component-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.component.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      resource.component.map { it.code }
  }

  public data object ComponentCodeValueConcept : SearchParam<Observation, Observation.Component> {
    public override val paramName: KotlinString = "component-code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation.component"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComponentCodeValueQuantity : SearchParam<Observation, Observation.Component> {
    public override val paramName: KotlinString = "component-code-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Observation.component"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Component> =
      resource.component
  }

  public data object ComponentDataAbsentReason : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "component-data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.component.dataAbsentReason"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      resource.component.mapNotNull { it.dataAbsentReason }
  }

  public data object ComponentValueConcept : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "component-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(Observation.component.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      resource.component.mapNotNull {
        (it.value as? Observation.Component.Value.CodeableConcept)?.value
      }
  }

  public data object ComponentValueQuantity : SearchParam<Observation, Quantity> {
    public override val paramName: KotlinString = "component-value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Observation.component.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Quantity> =
      resource.component.mapNotNull { (it.value as? Observation.Component.Value.Quantity)?.value }
  }

  public data object DataAbsentReason : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "data-absent-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.dataAbsentReason"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.dataAbsentReason)
  }

  public data object Date : SearchParam<Observation, Observation.Effective> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Observation.effective"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Observation.Effective> =
      listOfNotNull(resource.effective)
  }

  public data object DerivedFrom : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.derivedFrom"

    public override val target: List<KotlinString> =
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

  public data object Device : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.device"

    public override val target: List<KotlinString> = listOf("Device", "DeviceMetric")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.device)
  }

  public data object DnaVariant : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "dna-variant"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object Encounter : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.encounter"

    public override val target: List<KotlinString> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Focus : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.focus"

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

    public override fun extract(resource: Observation): List<Reference> = resource.focus
  }

  public data object GeneAminoAcidChange : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "gene-amino-acid-change"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChangeName')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object GeneDnavariant : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "gene-dnavariant"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsDnaVariant')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object GeneIdentifier : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "gene-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "Observation.extension('http://hl7.org/fhir/StructureDefinition/observation-geneticsGene')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = emptyList()
  }

  public data object HasMember : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "has-member"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.hasMember"

    public override val target: List<KotlinString> =
      listOf("Observation", "MolecularSequence", "QuestionnaireResponse")

    public override fun extract(resource: Observation): List<Reference> = resource.hasMember
  }

  public data object Identifier : SearchParam<Observation, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Method : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.method"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull(resource.method)
  }

  public data object PartOf : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.partOf"

    public override val target: List<KotlinString> =
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

  public data object Patient : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.subject.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient", "Group")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.performer"

    public override val target: List<KotlinString> =
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

  public data object Specimen : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.specimen"

    public override val target: List<KotlinString> = listOf("Specimen")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.specimen)
  }

  public data object Status : SearchParam<Observation, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Observation.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<Observation, Reference> {
    public override val paramName: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Observation.subject"

    public override val target: List<KotlinString> =
      listOf("Group", "Device", "Patient", "Location")

    public override fun extract(resource: Observation): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object ValueConcept : SearchParam<Observation, CodeableConcept> {
    public override val paramName: KotlinString = "value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Observation.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<CodeableConcept> =
      listOfNotNull((resource.value as? Observation.Value.CodeableConcept)?.value)
  }

  public data object ValueDate : SearchParam<Observation, DateTime> {
    public override val paramName: KotlinString = "value-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "(Observation.value as dateTime)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<DateTime> =
      listOfNotNull((resource.value as? Observation.Value.DateTime)?.value)
  }

  public data object ValueQuantity : SearchParam<Observation, Quantity> {
    public override val paramName: KotlinString = "value-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Observation.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<Quantity> =
      listOfNotNull((resource.value as? Observation.Value.Quantity)?.value)
  }

  public data object ValueString : SearchParam<Observation, R4String> {
    public override val paramName: KotlinString = "value-string"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "(Observation.value as string)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Observation): List<R4String> =
      listOfNotNull((resource.value as? Observation.Value.String)?.value)
  }
}
