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

@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.AccountPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ActivityDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.AdministrableProductDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.AdverseEventPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.AllergyIntolerancePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.AppointmentPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.AppointmentResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.AuditEventPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.BasicPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.BinaryPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.BiologicallyDerivedProductPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.BodyStructurePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.BundlePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CapabilityStatementPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CarePlanPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CareTeamPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CatalogEntryPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ChargeItemDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ChargeItemPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CitationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ClaimPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ClaimResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ClinicalImpressionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ClinicalUseDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CodeSystemPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CommunicationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CommunicationRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CompartmentDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CompositionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ConceptMapPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ConditionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ConsentPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CoverageEligibilityRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CoverageEligibilityResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.CoveragePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DetectedIssuePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceMetricPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DevicePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceUseStatementPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DiagnosticReportPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DocumentManifestPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.DocumentReferencePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EncounterPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EndpointPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EnrollmentRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EnrollmentResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EpisodeOfCarePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EventDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EvidencePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EvidenceReportPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.EvidenceVariablePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ExampleScenarioPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ExplanationOfBenefitPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.FamilyMemberHistoryPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.FlagPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.GoalPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.GraphDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.GroupPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.GuidanceResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.HealthcareServicePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ImagingStudyPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ImmunizationEvaluationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ImmunizationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ImmunizationRecommendationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuidePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.IngredientPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.InsurancePlanPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.InvoicePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.LibraryPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.LinkagePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ListPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.LocationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ManufacturedItemDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MeasurePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MeasureReportPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MediaPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationAdministrationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationDispensePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationKnowledgePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationStatementPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MessageDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MessageHeaderPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.MolecularSequencePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.NamingSystemPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionOrderPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionProductPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ObservationDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ObservationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.OperationDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.OperationOutcomePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.OrganizationAffiliationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.OrganizationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.PackagedProductDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ParametersPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.PatientPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.PaymentNoticePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.PaymentReconciliationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.PersonPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.PractitionerPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.PractitionerRolePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ProcedurePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ProvenancePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.QuestionnairePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.QuestionnaireResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.RegulatedAuthorizationPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.RelatedPersonPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.RequestGroupPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ResearchDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ResearchElementDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ResearchStudyPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ResearchSubjectPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.RiskAssessmentPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SchedulePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SearchParameterPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ServiceRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SlotPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SpecimenDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SpecimenPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.StructureDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.StructureMapPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SubscriptionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SubscriptionStatusPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SubscriptionTopicPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SubstanceDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SubstancePolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SupplyDeliveryPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.SupplyRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.TaskPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.TerminologyCapabilitiesPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.TestReportPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.ValueSetPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.VerificationResultPolymorphicSerializer
import dev.ohs.fhir.model.r4b.serializers.VisionPrescriptionPolymorphicSerializer
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.collections.mapOf
import kotlin.reflect.KClass
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.SerialKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.`internal`.AbstractPolymorphicSerializer
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(
  InternalSerializationApi::class,
  ExperimentalSerializationApi::class,
)
internal object ResourcePolymorphicSerializer : AbstractPolymorphicSerializer<Resource>() {
  override val baseClass: KClass<Resource> = Resource::class

  private val byName: Map<String, KSerializer<out Resource>> =
    mapOf(
      "Account" to AccountPolymorphicSerializer,
      "ActivityDefinition" to ActivityDefinitionPolymorphicSerializer,
      "AdministrableProductDefinition" to AdministrableProductDefinitionPolymorphicSerializer,
      "AdverseEvent" to AdverseEventPolymorphicSerializer,
      "AllergyIntolerance" to AllergyIntolerancePolymorphicSerializer,
      "Appointment" to AppointmentPolymorphicSerializer,
      "AppointmentResponse" to AppointmentResponsePolymorphicSerializer,
      "AuditEvent" to AuditEventPolymorphicSerializer,
      "Basic" to BasicPolymorphicSerializer,
      "Binary" to BinaryPolymorphicSerializer,
      "BiologicallyDerivedProduct" to BiologicallyDerivedProductPolymorphicSerializer,
      "BodyStructure" to BodyStructurePolymorphicSerializer,
      "Bundle" to BundlePolymorphicSerializer,
      "CapabilityStatement" to CapabilityStatementPolymorphicSerializer,
      "CarePlan" to CarePlanPolymorphicSerializer,
      "CareTeam" to CareTeamPolymorphicSerializer,
      "CatalogEntry" to CatalogEntryPolymorphicSerializer,
      "ChargeItem" to ChargeItemPolymorphicSerializer,
      "ChargeItemDefinition" to ChargeItemDefinitionPolymorphicSerializer,
      "Citation" to CitationPolymorphicSerializer,
      "Claim" to ClaimPolymorphicSerializer,
      "ClaimResponse" to ClaimResponsePolymorphicSerializer,
      "ClinicalImpression" to ClinicalImpressionPolymorphicSerializer,
      "ClinicalUseDefinition" to ClinicalUseDefinitionPolymorphicSerializer,
      "CodeSystem" to CodeSystemPolymorphicSerializer,
      "Communication" to CommunicationPolymorphicSerializer,
      "CommunicationRequest" to CommunicationRequestPolymorphicSerializer,
      "CompartmentDefinition" to CompartmentDefinitionPolymorphicSerializer,
      "Composition" to CompositionPolymorphicSerializer,
      "ConceptMap" to ConceptMapPolymorphicSerializer,
      "Condition" to ConditionPolymorphicSerializer,
      "Consent" to ConsentPolymorphicSerializer,
      "Contract" to ContractPolymorphicSerializer,
      "Coverage" to CoveragePolymorphicSerializer,
      "CoverageEligibilityRequest" to CoverageEligibilityRequestPolymorphicSerializer,
      "CoverageEligibilityResponse" to CoverageEligibilityResponsePolymorphicSerializer,
      "DetectedIssue" to DetectedIssuePolymorphicSerializer,
      "Device" to DevicePolymorphicSerializer,
      "DeviceDefinition" to DeviceDefinitionPolymorphicSerializer,
      "DeviceMetric" to DeviceMetricPolymorphicSerializer,
      "DeviceRequest" to DeviceRequestPolymorphicSerializer,
      "DeviceUseStatement" to DeviceUseStatementPolymorphicSerializer,
      "DiagnosticReport" to DiagnosticReportPolymorphicSerializer,
      "DocumentManifest" to DocumentManifestPolymorphicSerializer,
      "DocumentReference" to DocumentReferencePolymorphicSerializer,
      "Encounter" to EncounterPolymorphicSerializer,
      "Endpoint" to EndpointPolymorphicSerializer,
      "EnrollmentRequest" to EnrollmentRequestPolymorphicSerializer,
      "EnrollmentResponse" to EnrollmentResponsePolymorphicSerializer,
      "EpisodeOfCare" to EpisodeOfCarePolymorphicSerializer,
      "EventDefinition" to EventDefinitionPolymorphicSerializer,
      "Evidence" to EvidencePolymorphicSerializer,
      "EvidenceReport" to EvidenceReportPolymorphicSerializer,
      "EvidenceVariable" to EvidenceVariablePolymorphicSerializer,
      "ExampleScenario" to ExampleScenarioPolymorphicSerializer,
      "ExplanationOfBenefit" to ExplanationOfBenefitPolymorphicSerializer,
      "FamilyMemberHistory" to FamilyMemberHistoryPolymorphicSerializer,
      "Flag" to FlagPolymorphicSerializer,
      "Goal" to GoalPolymorphicSerializer,
      "GraphDefinition" to GraphDefinitionPolymorphicSerializer,
      "Group" to GroupPolymorphicSerializer,
      "GuidanceResponse" to GuidanceResponsePolymorphicSerializer,
      "HealthcareService" to HealthcareServicePolymorphicSerializer,
      "ImagingStudy" to ImagingStudyPolymorphicSerializer,
      "Immunization" to ImmunizationPolymorphicSerializer,
      "ImmunizationEvaluation" to ImmunizationEvaluationPolymorphicSerializer,
      "ImmunizationRecommendation" to ImmunizationRecommendationPolymorphicSerializer,
      "ImplementationGuide" to ImplementationGuidePolymorphicSerializer,
      "Ingredient" to IngredientPolymorphicSerializer,
      "InsurancePlan" to InsurancePlanPolymorphicSerializer,
      "Invoice" to InvoicePolymorphicSerializer,
      "Library" to LibraryPolymorphicSerializer,
      "Linkage" to LinkagePolymorphicSerializer,
      "List" to ListPolymorphicSerializer,
      "Location" to LocationPolymorphicSerializer,
      "ManufacturedItemDefinition" to ManufacturedItemDefinitionPolymorphicSerializer,
      "Measure" to MeasurePolymorphicSerializer,
      "MeasureReport" to MeasureReportPolymorphicSerializer,
      "Media" to MediaPolymorphicSerializer,
      "Medication" to MedicationPolymorphicSerializer,
      "MedicationAdministration" to MedicationAdministrationPolymorphicSerializer,
      "MedicationDispense" to MedicationDispensePolymorphicSerializer,
      "MedicationKnowledge" to MedicationKnowledgePolymorphicSerializer,
      "MedicationRequest" to MedicationRequestPolymorphicSerializer,
      "MedicationStatement" to MedicationStatementPolymorphicSerializer,
      "MedicinalProductDefinition" to MedicinalProductDefinitionPolymorphicSerializer,
      "MessageDefinition" to MessageDefinitionPolymorphicSerializer,
      "MessageHeader" to MessageHeaderPolymorphicSerializer,
      "MolecularSequence" to MolecularSequencePolymorphicSerializer,
      "NamingSystem" to NamingSystemPolymorphicSerializer,
      "NutritionOrder" to NutritionOrderPolymorphicSerializer,
      "NutritionProduct" to NutritionProductPolymorphicSerializer,
      "Observation" to ObservationPolymorphicSerializer,
      "ObservationDefinition" to ObservationDefinitionPolymorphicSerializer,
      "OperationDefinition" to OperationDefinitionPolymorphicSerializer,
      "OperationOutcome" to OperationOutcomePolymorphicSerializer,
      "Organization" to OrganizationPolymorphicSerializer,
      "OrganizationAffiliation" to OrganizationAffiliationPolymorphicSerializer,
      "PackagedProductDefinition" to PackagedProductDefinitionPolymorphicSerializer,
      "Parameters" to ParametersPolymorphicSerializer,
      "Patient" to PatientPolymorphicSerializer,
      "PaymentNotice" to PaymentNoticePolymorphicSerializer,
      "PaymentReconciliation" to PaymentReconciliationPolymorphicSerializer,
      "Person" to PersonPolymorphicSerializer,
      "PlanDefinition" to PlanDefinitionPolymorphicSerializer,
      "Practitioner" to PractitionerPolymorphicSerializer,
      "PractitionerRole" to PractitionerRolePolymorphicSerializer,
      "Procedure" to ProcedurePolymorphicSerializer,
      "Provenance" to ProvenancePolymorphicSerializer,
      "Questionnaire" to QuestionnairePolymorphicSerializer,
      "QuestionnaireResponse" to QuestionnaireResponsePolymorphicSerializer,
      "RegulatedAuthorization" to RegulatedAuthorizationPolymorphicSerializer,
      "RelatedPerson" to RelatedPersonPolymorphicSerializer,
      "RequestGroup" to RequestGroupPolymorphicSerializer,
      "ResearchDefinition" to ResearchDefinitionPolymorphicSerializer,
      "ResearchElementDefinition" to ResearchElementDefinitionPolymorphicSerializer,
      "ResearchStudy" to ResearchStudyPolymorphicSerializer,
      "ResearchSubject" to ResearchSubjectPolymorphicSerializer,
      "RiskAssessment" to RiskAssessmentPolymorphicSerializer,
      "Schedule" to SchedulePolymorphicSerializer,
      "SearchParameter" to SearchParameterPolymorphicSerializer,
      "ServiceRequest" to ServiceRequestPolymorphicSerializer,
      "Slot" to SlotPolymorphicSerializer,
      "Specimen" to SpecimenPolymorphicSerializer,
      "SpecimenDefinition" to SpecimenDefinitionPolymorphicSerializer,
      "StructureDefinition" to StructureDefinitionPolymorphicSerializer,
      "StructureMap" to StructureMapPolymorphicSerializer,
      "Subscription" to SubscriptionPolymorphicSerializer,
      "SubscriptionStatus" to SubscriptionStatusPolymorphicSerializer,
      "SubscriptionTopic" to SubscriptionTopicPolymorphicSerializer,
      "Substance" to SubstancePolymorphicSerializer,
      "SubstanceDefinition" to SubstanceDefinitionPolymorphicSerializer,
      "SupplyDelivery" to SupplyDeliveryPolymorphicSerializer,
      "SupplyRequest" to SupplyRequestPolymorphicSerializer,
      "Task" to TaskPolymorphicSerializer,
      "TerminologyCapabilities" to TerminologyCapabilitiesPolymorphicSerializer,
      "TestReport" to TestReportPolymorphicSerializer,
      "TestScript" to TestScriptPolymorphicSerializer,
      "ValueSet" to ValueSetPolymorphicSerializer,
      "VerificationResult" to VerificationResultPolymorphicSerializer,
      "VisionPrescription" to VisionPrescriptionPolymorphicSerializer,
    )

  private val byClass: Map<KClass<*>, KSerializer<out Resource>> =
    mapOf(
      Account::class to AccountPolymorphicSerializer,
      ActivityDefinition::class to ActivityDefinitionPolymorphicSerializer,
      AdministrableProductDefinition::class to AdministrableProductDefinitionPolymorphicSerializer,
      AdverseEvent::class to AdverseEventPolymorphicSerializer,
      AllergyIntolerance::class to AllergyIntolerancePolymorphicSerializer,
      Appointment::class to AppointmentPolymorphicSerializer,
      AppointmentResponse::class to AppointmentResponsePolymorphicSerializer,
      AuditEvent::class to AuditEventPolymorphicSerializer,
      Basic::class to BasicPolymorphicSerializer,
      Binary::class to BinaryPolymorphicSerializer,
      BiologicallyDerivedProduct::class to BiologicallyDerivedProductPolymorphicSerializer,
      BodyStructure::class to BodyStructurePolymorphicSerializer,
      Bundle::class to BundlePolymorphicSerializer,
      CapabilityStatement::class to CapabilityStatementPolymorphicSerializer,
      CarePlan::class to CarePlanPolymorphicSerializer,
      CareTeam::class to CareTeamPolymorphicSerializer,
      CatalogEntry::class to CatalogEntryPolymorphicSerializer,
      ChargeItem::class to ChargeItemPolymorphicSerializer,
      ChargeItemDefinition::class to ChargeItemDefinitionPolymorphicSerializer,
      Citation::class to CitationPolymorphicSerializer,
      Claim::class to ClaimPolymorphicSerializer,
      ClaimResponse::class to ClaimResponsePolymorphicSerializer,
      ClinicalImpression::class to ClinicalImpressionPolymorphicSerializer,
      ClinicalUseDefinition::class to ClinicalUseDefinitionPolymorphicSerializer,
      CodeSystem::class to CodeSystemPolymorphicSerializer,
      Communication::class to CommunicationPolymorphicSerializer,
      CommunicationRequest::class to CommunicationRequestPolymorphicSerializer,
      CompartmentDefinition::class to CompartmentDefinitionPolymorphicSerializer,
      Composition::class to CompositionPolymorphicSerializer,
      ConceptMap::class to ConceptMapPolymorphicSerializer,
      Condition::class to ConditionPolymorphicSerializer,
      Consent::class to ConsentPolymorphicSerializer,
      Contract::class to ContractPolymorphicSerializer,
      Coverage::class to CoveragePolymorphicSerializer,
      CoverageEligibilityRequest::class to CoverageEligibilityRequestPolymorphicSerializer,
      CoverageEligibilityResponse::class to CoverageEligibilityResponsePolymorphicSerializer,
      DetectedIssue::class to DetectedIssuePolymorphicSerializer,
      Device::class to DevicePolymorphicSerializer,
      DeviceDefinition::class to DeviceDefinitionPolymorphicSerializer,
      DeviceMetric::class to DeviceMetricPolymorphicSerializer,
      DeviceRequest::class to DeviceRequestPolymorphicSerializer,
      DeviceUseStatement::class to DeviceUseStatementPolymorphicSerializer,
      DiagnosticReport::class to DiagnosticReportPolymorphicSerializer,
      DocumentManifest::class to DocumentManifestPolymorphicSerializer,
      DocumentReference::class to DocumentReferencePolymorphicSerializer,
      Encounter::class to EncounterPolymorphicSerializer,
      Endpoint::class to EndpointPolymorphicSerializer,
      EnrollmentRequest::class to EnrollmentRequestPolymorphicSerializer,
      EnrollmentResponse::class to EnrollmentResponsePolymorphicSerializer,
      EpisodeOfCare::class to EpisodeOfCarePolymorphicSerializer,
      EventDefinition::class to EventDefinitionPolymorphicSerializer,
      Evidence::class to EvidencePolymorphicSerializer,
      EvidenceReport::class to EvidenceReportPolymorphicSerializer,
      EvidenceVariable::class to EvidenceVariablePolymorphicSerializer,
      ExampleScenario::class to ExampleScenarioPolymorphicSerializer,
      ExplanationOfBenefit::class to ExplanationOfBenefitPolymorphicSerializer,
      FamilyMemberHistory::class to FamilyMemberHistoryPolymorphicSerializer,
      Flag::class to FlagPolymorphicSerializer,
      Goal::class to GoalPolymorphicSerializer,
      GraphDefinition::class to GraphDefinitionPolymorphicSerializer,
      Group::class to GroupPolymorphicSerializer,
      GuidanceResponse::class to GuidanceResponsePolymorphicSerializer,
      HealthcareService::class to HealthcareServicePolymorphicSerializer,
      ImagingStudy::class to ImagingStudyPolymorphicSerializer,
      Immunization::class to ImmunizationPolymorphicSerializer,
      ImmunizationEvaluation::class to ImmunizationEvaluationPolymorphicSerializer,
      ImmunizationRecommendation::class to ImmunizationRecommendationPolymorphicSerializer,
      ImplementationGuide::class to ImplementationGuidePolymorphicSerializer,
      Ingredient::class to IngredientPolymorphicSerializer,
      InsurancePlan::class to InsurancePlanPolymorphicSerializer,
      Invoice::class to InvoicePolymorphicSerializer,
      Library::class to LibraryPolymorphicSerializer,
      Linkage::class to LinkagePolymorphicSerializer,
      List::class to ListPolymorphicSerializer,
      Location::class to LocationPolymorphicSerializer,
      ManufacturedItemDefinition::class to ManufacturedItemDefinitionPolymorphicSerializer,
      Measure::class to MeasurePolymorphicSerializer,
      MeasureReport::class to MeasureReportPolymorphicSerializer,
      Media::class to MediaPolymorphicSerializer,
      Medication::class to MedicationPolymorphicSerializer,
      MedicationAdministration::class to MedicationAdministrationPolymorphicSerializer,
      MedicationDispense::class to MedicationDispensePolymorphicSerializer,
      MedicationKnowledge::class to MedicationKnowledgePolymorphicSerializer,
      MedicationRequest::class to MedicationRequestPolymorphicSerializer,
      MedicationStatement::class to MedicationStatementPolymorphicSerializer,
      MedicinalProductDefinition::class to MedicinalProductDefinitionPolymorphicSerializer,
      MessageDefinition::class to MessageDefinitionPolymorphicSerializer,
      MessageHeader::class to MessageHeaderPolymorphicSerializer,
      MolecularSequence::class to MolecularSequencePolymorphicSerializer,
      NamingSystem::class to NamingSystemPolymorphicSerializer,
      NutritionOrder::class to NutritionOrderPolymorphicSerializer,
      NutritionProduct::class to NutritionProductPolymorphicSerializer,
      Observation::class to ObservationPolymorphicSerializer,
      ObservationDefinition::class to ObservationDefinitionPolymorphicSerializer,
      OperationDefinition::class to OperationDefinitionPolymorphicSerializer,
      OperationOutcome::class to OperationOutcomePolymorphicSerializer,
      Organization::class to OrganizationPolymorphicSerializer,
      OrganizationAffiliation::class to OrganizationAffiliationPolymorphicSerializer,
      PackagedProductDefinition::class to PackagedProductDefinitionPolymorphicSerializer,
      Parameters::class to ParametersPolymorphicSerializer,
      Patient::class to PatientPolymorphicSerializer,
      PaymentNotice::class to PaymentNoticePolymorphicSerializer,
      PaymentReconciliation::class to PaymentReconciliationPolymorphicSerializer,
      Person::class to PersonPolymorphicSerializer,
      PlanDefinition::class to PlanDefinitionPolymorphicSerializer,
      Practitioner::class to PractitionerPolymorphicSerializer,
      PractitionerRole::class to PractitionerRolePolymorphicSerializer,
      Procedure::class to ProcedurePolymorphicSerializer,
      Provenance::class to ProvenancePolymorphicSerializer,
      Questionnaire::class to QuestionnairePolymorphicSerializer,
      QuestionnaireResponse::class to QuestionnaireResponsePolymorphicSerializer,
      RegulatedAuthorization::class to RegulatedAuthorizationPolymorphicSerializer,
      RelatedPerson::class to RelatedPersonPolymorphicSerializer,
      RequestGroup::class to RequestGroupPolymorphicSerializer,
      ResearchDefinition::class to ResearchDefinitionPolymorphicSerializer,
      ResearchElementDefinition::class to ResearchElementDefinitionPolymorphicSerializer,
      ResearchStudy::class to ResearchStudyPolymorphicSerializer,
      ResearchSubject::class to ResearchSubjectPolymorphicSerializer,
      RiskAssessment::class to RiskAssessmentPolymorphicSerializer,
      Schedule::class to SchedulePolymorphicSerializer,
      SearchParameter::class to SearchParameterPolymorphicSerializer,
      ServiceRequest::class to ServiceRequestPolymorphicSerializer,
      Slot::class to SlotPolymorphicSerializer,
      Specimen::class to SpecimenPolymorphicSerializer,
      SpecimenDefinition::class to SpecimenDefinitionPolymorphicSerializer,
      StructureDefinition::class to StructureDefinitionPolymorphicSerializer,
      StructureMap::class to StructureMapPolymorphicSerializer,
      Subscription::class to SubscriptionPolymorphicSerializer,
      SubscriptionStatus::class to SubscriptionStatusPolymorphicSerializer,
      SubscriptionTopic::class to SubscriptionTopicPolymorphicSerializer,
      Substance::class to SubstancePolymorphicSerializer,
      SubstanceDefinition::class to SubstanceDefinitionPolymorphicSerializer,
      SupplyDelivery::class to SupplyDeliveryPolymorphicSerializer,
      SupplyRequest::class to SupplyRequestPolymorphicSerializer,
      Task::class to TaskPolymorphicSerializer,
      TerminologyCapabilities::class to TerminologyCapabilitiesPolymorphicSerializer,
      TestReport::class to TestReportPolymorphicSerializer,
      TestScript::class to TestScriptPolymorphicSerializer,
      ValueSet::class to ValueSetPolymorphicSerializer,
      VerificationResult::class to VerificationResultPolymorphicSerializer,
      VisionPrescription::class to VisionPrescriptionPolymorphicSerializer,
    )

  override val descriptor: SerialDescriptor =
    buildSerialDescriptor("Resource", PolymorphicKind.SEALED) {
      // `SealedClassSerializer` convention: slot 0 is named "type" even when
      // `@JsonClassDiscriminator` overrides the wire key — kotlinx-json reads the
      // actual key from `descriptor.annotations`, not from this slot's name.
      element("type", String.serializer().descriptor)
      val valueDesc =
        buildSerialDescriptor("kotlinx.serialization.Sealed<Resource>", SerialKind.CONTEXTUAL) {
          for ((name, ser) in byName) element(name, ser.descriptor)
        }
      element("value", valueDesc)
      annotations = listOf(JsonClassDiscriminator("resourceType"))
    }

  @Suppress("UNCHECKED_CAST")
  override fun findPolymorphicSerializerOrNull(
    encoder: Encoder,
    `value`: Resource,
  ): SerializationStrategy<Resource>? =
    (byClass[value::class] ?: super.findPolymorphicSerializerOrNull(encoder, value))
      as SerializationStrategy<Resource>?

  override fun findPolymorphicSerializerOrNull(
    decoder: CompositeDecoder,
    klassName: String?,
  ): DeserializationStrategy<Resource>? =
    byName[klassName] ?: super.findPolymorphicSerializerOrNull(decoder, klassName)
}
