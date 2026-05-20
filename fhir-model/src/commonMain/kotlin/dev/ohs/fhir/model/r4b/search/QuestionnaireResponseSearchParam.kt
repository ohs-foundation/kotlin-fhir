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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.QuestionnaireResponse
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [QuestionnaireResponse] resource type. */
public object QuestionnaireResponseSearchParam {
  /** All search parameters for the QuestionnaireResponse resource type. */
  public val ALL: List<SearchParam<QuestionnaireResponse, *>> =
    listOf(
      Author,
      Authored,
      BasedOn,
      Encounter,
      Identifier,
      ItemSubject,
      PartOf,
      Patient,
      Questionnaire,
      Source,
      Status,
      Subject,
    )

  public data object Author : SearchParam<QuestionnaireResponse, Reference> {
    public override val paramName: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "QuestionnaireResponse.author"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: QuestionnaireResponse): List<Reference> =
      listOfNotNull(resource.author)
  }

  public data object Authored : SearchParam<QuestionnaireResponse, DateTime> {
    public override val paramName: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "QuestionnaireResponse.authored"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: QuestionnaireResponse): List<DateTime> =
      listOfNotNull(resource.authored)
  }

  public data object BasedOn : SearchParam<QuestionnaireResponse, Reference> {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "QuestionnaireResponse.basedOn"

    public override val target: List<String> = listOf("CarePlan", "ServiceRequest")

    public override fun extract(resource: QuestionnaireResponse): List<Reference> = resource.basedOn
  }

  public data object Encounter : SearchParam<QuestionnaireResponse, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "QuestionnaireResponse.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: QuestionnaireResponse): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier :
    SearchParam<QuestionnaireResponse, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "QuestionnaireResponse.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: QuestionnaireResponse
    ): List<dev.ohs.fhir.model.r4b.Identifier> = listOfNotNull(resource.identifier)
  }

  public data object ItemSubject : SearchParam<QuestionnaireResponse, Any> {
    public override val paramName: String = "item-subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "QuestionnaireResponse.item.where(extension('http://hl7.org/fhir/StructureDefinition/questionnaireresponse-isSubject').exists()).answer.value.ofType(Reference)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: QuestionnaireResponse): List<Any> = emptyList()
  }

  public data object PartOf : SearchParam<QuestionnaireResponse, Reference> {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "QuestionnaireResponse.partOf"

    public override val target: List<String> = listOf("Observation", "Procedure")

    public override fun extract(resource: QuestionnaireResponse): List<Reference> = resource.partOf
  }

  public data object Patient : SearchParam<QuestionnaireResponse, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "QuestionnaireResponse.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: QuestionnaireResponse): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Questionnaire : SearchParam<QuestionnaireResponse, Canonical> {
    public override val paramName: String = "questionnaire"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "QuestionnaireResponse.questionnaire"

    public override val target: List<String> = listOf("Questionnaire")

    public override fun extract(resource: QuestionnaireResponse): List<Canonical> =
      listOfNotNull(resource.questionnaire)
  }

  public data object Source : SearchParam<QuestionnaireResponse, Reference> {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "QuestionnaireResponse.source"

    public override val target: List<String> =
      listOf("Practitioner", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: QuestionnaireResponse): List<Reference> =
      listOfNotNull(resource.source)
  }

  public data object Status : SearchParam<QuestionnaireResponse, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "QuestionnaireResponse.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: QuestionnaireResponse): List<Any> =
      listOf(resource.status)
  }

  public data object Subject : SearchParam<QuestionnaireResponse, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "QuestionnaireResponse.subject"

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

    public override fun extract(resource: QuestionnaireResponse): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
