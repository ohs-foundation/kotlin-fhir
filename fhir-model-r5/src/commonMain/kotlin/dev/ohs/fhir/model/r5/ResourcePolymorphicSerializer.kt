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

@file:Suppress(
  "INVISIBLE_MEMBER",
  "INVISIBLE_REFERENCE",
)

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.AccountPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ActivityDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ActorDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.AdministrableProductDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.AllergyIntolerancePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentResponsePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ArtifactAssessmentPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.AuditEventPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.BasicPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.BinaryPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.BiologicallyDerivedProductDispensePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.BiologicallyDerivedProductPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.BodyStructurePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.BundlePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CapabilityStatementPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CarePlanPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CareTeamPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ChargeItemDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ChargeItemPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CitationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponsePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ClinicalImpressionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ClinicalUseDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CodeSystemPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CommunicationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CommunicationRequestPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CompartmentDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CompositionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ConceptMapPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ConditionDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ConditionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ConsentPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ContractPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CoverageEligibilityRequestPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CoverageEligibilityResponsePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.CoveragePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DetectedIssuePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceAssociationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDispensePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceMetricPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DevicePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceRequestPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceUsagePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DiagnosticReportPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.DocumentReferencePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EncounterHistoryPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EncounterPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EndpointPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EnrollmentRequestPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EnrollmentResponsePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EpisodeOfCarePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EventDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EvidencePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceReportPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariablePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ExampleScenarioPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.FamilyMemberHistoryPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.FlagPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.FormularyItemPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.GenomicStudyPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.GoalPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.GraphDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.GroupPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.GuidanceResponsePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.HealthcareServicePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ImagingSelectionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ImagingStudyPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationEvaluationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationRecommendationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuidePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.IngredientPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.InsurancePlanPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryItemPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryReportPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.InvoicePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.LibraryPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.LinkagePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ListPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.LocationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ManufacturedItemDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MeasurePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureReportPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationAdministrationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationDispensePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationRequestPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationStatementPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicinalProductDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MessageDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MessageHeaderPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.MolecularSequencePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.NamingSystemPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionIntakePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionOrderPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionProductPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ObservationDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ObservationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.OperationDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.OperationOutcomePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.OrganizationAffiliationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.OrganizationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PackagedProductDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ParametersPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PatientPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PaymentNoticePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PaymentReconciliationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PermissionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PersonPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PlanDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PractitionerPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.PractitionerRolePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ProcedurePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ProvenancePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.QuestionnairePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.QuestionnaireResponsePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.RegulatedAuthorizationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.RelatedPersonPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.RequirementsPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudyPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchSubjectPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.RiskAssessmentPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SchedulePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SearchParameterPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ServiceRequestPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SlotPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SpecimenDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SpecimenPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.StructureDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.StructureMapPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubscriptionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubscriptionStatusPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubscriptionTopicPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceNucleicAcidPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubstancePolymerPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubstancePolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceProteinPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceReferenceInformationPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceSourceMaterialPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SupplyDeliveryPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.SupplyRequestPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.TaskPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.TerminologyCapabilitiesPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.TestPlanPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.TestReportPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.TestScriptPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.TransportPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.ValueSetPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.VerificationResultPolymorphicSerializer
import dev.ohs.fhir.model.r5.serializers.VisionPrescriptionPolymorphicSerializer
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
      "ActorDefinition" to ActorDefinitionPolymorphicSerializer,
      "AdministrableProductDefinition" to AdministrableProductDefinitionPolymorphicSerializer,
      "AdverseEvent" to AdverseEventPolymorphicSerializer,
      "AllergyIntolerance" to AllergyIntolerancePolymorphicSerializer,
      "Appointment" to AppointmentPolymorphicSerializer,
      "AppointmentResponse" to AppointmentResponsePolymorphicSerializer,
      "ArtifactAssessment" to ArtifactAssessmentPolymorphicSerializer,
      "AuditEvent" to AuditEventPolymorphicSerializer,
      "Basic" to BasicPolymorphicSerializer,
      "Binary" to BinaryPolymorphicSerializer,
      "BiologicallyDerivedProduct" to BiologicallyDerivedProductPolymorphicSerializer,
      "BiologicallyDerivedProductDispense" to
        BiologicallyDerivedProductDispensePolymorphicSerializer,
      "BodyStructure" to BodyStructurePolymorphicSerializer,
      "Bundle" to BundlePolymorphicSerializer,
      "CapabilityStatement" to CapabilityStatementPolymorphicSerializer,
      "CarePlan" to CarePlanPolymorphicSerializer,
      "CareTeam" to CareTeamPolymorphicSerializer,
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
      "ConditionDefinition" to ConditionDefinitionPolymorphicSerializer,
      "Consent" to ConsentPolymorphicSerializer,
      "Contract" to ContractPolymorphicSerializer,
      "Coverage" to CoveragePolymorphicSerializer,
      "CoverageEligibilityRequest" to CoverageEligibilityRequestPolymorphicSerializer,
      "CoverageEligibilityResponse" to CoverageEligibilityResponsePolymorphicSerializer,
      "DetectedIssue" to DetectedIssuePolymorphicSerializer,
      "Device" to DevicePolymorphicSerializer,
      "DeviceAssociation" to DeviceAssociationPolymorphicSerializer,
      "DeviceDefinition" to DeviceDefinitionPolymorphicSerializer,
      "DeviceDispense" to DeviceDispensePolymorphicSerializer,
      "DeviceMetric" to DeviceMetricPolymorphicSerializer,
      "DeviceRequest" to DeviceRequestPolymorphicSerializer,
      "DeviceUsage" to DeviceUsagePolymorphicSerializer,
      "DiagnosticReport" to DiagnosticReportPolymorphicSerializer,
      "DocumentReference" to DocumentReferencePolymorphicSerializer,
      "Encounter" to EncounterPolymorphicSerializer,
      "EncounterHistory" to EncounterHistoryPolymorphicSerializer,
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
      "FormularyItem" to FormularyItemPolymorphicSerializer,
      "GenomicStudy" to GenomicStudyPolymorphicSerializer,
      "Goal" to GoalPolymorphicSerializer,
      "GraphDefinition" to GraphDefinitionPolymorphicSerializer,
      "Group" to GroupPolymorphicSerializer,
      "GuidanceResponse" to GuidanceResponsePolymorphicSerializer,
      "HealthcareService" to HealthcareServicePolymorphicSerializer,
      "ImagingSelection" to ImagingSelectionPolymorphicSerializer,
      "ImagingStudy" to ImagingStudyPolymorphicSerializer,
      "Immunization" to ImmunizationPolymorphicSerializer,
      "ImmunizationEvaluation" to ImmunizationEvaluationPolymorphicSerializer,
      "ImmunizationRecommendation" to ImmunizationRecommendationPolymorphicSerializer,
      "ImplementationGuide" to ImplementationGuidePolymorphicSerializer,
      "Ingredient" to IngredientPolymorphicSerializer,
      "InsurancePlan" to InsurancePlanPolymorphicSerializer,
      "InventoryItem" to InventoryItemPolymorphicSerializer,
      "InventoryReport" to InventoryReportPolymorphicSerializer,
      "Invoice" to InvoicePolymorphicSerializer,
      "Library" to LibraryPolymorphicSerializer,
      "Linkage" to LinkagePolymorphicSerializer,
      "List" to ListPolymorphicSerializer,
      "Location" to LocationPolymorphicSerializer,
      "ManufacturedItemDefinition" to ManufacturedItemDefinitionPolymorphicSerializer,
      "Measure" to MeasurePolymorphicSerializer,
      "MeasureReport" to MeasureReportPolymorphicSerializer,
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
      "NutritionIntake" to NutritionIntakePolymorphicSerializer,
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
      "Permission" to PermissionPolymorphicSerializer,
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
      "RequestOrchestration" to RequestOrchestrationPolymorphicSerializer,
      "Requirements" to RequirementsPolymorphicSerializer,
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
      "SubstanceNucleicAcid" to SubstanceNucleicAcidPolymorphicSerializer,
      "SubstancePolymer" to SubstancePolymerPolymorphicSerializer,
      "SubstanceProtein" to SubstanceProteinPolymorphicSerializer,
      "SubstanceReferenceInformation" to SubstanceReferenceInformationPolymorphicSerializer,
      "SubstanceSourceMaterial" to SubstanceSourceMaterialPolymorphicSerializer,
      "SupplyDelivery" to SupplyDeliveryPolymorphicSerializer,
      "SupplyRequest" to SupplyRequestPolymorphicSerializer,
      "Task" to TaskPolymorphicSerializer,
      "TerminologyCapabilities" to TerminologyCapabilitiesPolymorphicSerializer,
      "TestPlan" to TestPlanPolymorphicSerializer,
      "TestReport" to TestReportPolymorphicSerializer,
      "TestScript" to TestScriptPolymorphicSerializer,
      "Transport" to TransportPolymorphicSerializer,
      "ValueSet" to ValueSetPolymorphicSerializer,
      "VerificationResult" to VerificationResultPolymorphicSerializer,
      "VisionPrescription" to VisionPrescriptionPolymorphicSerializer,
    )

  private val byClass: Map<KClass<*>, KSerializer<out Resource>> =
    mapOf(
      Account::class to AccountPolymorphicSerializer,
      ActivityDefinition::class to ActivityDefinitionPolymorphicSerializer,
      ActorDefinition::class to ActorDefinitionPolymorphicSerializer,
      AdministrableProductDefinition::class to AdministrableProductDefinitionPolymorphicSerializer,
      AdverseEvent::class to AdverseEventPolymorphicSerializer,
      AllergyIntolerance::class to AllergyIntolerancePolymorphicSerializer,
      Appointment::class to AppointmentPolymorphicSerializer,
      AppointmentResponse::class to AppointmentResponsePolymorphicSerializer,
      ArtifactAssessment::class to ArtifactAssessmentPolymorphicSerializer,
      AuditEvent::class to AuditEventPolymorphicSerializer,
      Basic::class to BasicPolymorphicSerializer,
      Binary::class to BinaryPolymorphicSerializer,
      BiologicallyDerivedProduct::class to BiologicallyDerivedProductPolymorphicSerializer,
      BiologicallyDerivedProductDispense::class to
        BiologicallyDerivedProductDispensePolymorphicSerializer,
      BodyStructure::class to BodyStructurePolymorphicSerializer,
      Bundle::class to BundlePolymorphicSerializer,
      CapabilityStatement::class to CapabilityStatementPolymorphicSerializer,
      CarePlan::class to CarePlanPolymorphicSerializer,
      CareTeam::class to CareTeamPolymorphicSerializer,
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
      ConditionDefinition::class to ConditionDefinitionPolymorphicSerializer,
      Consent::class to ConsentPolymorphicSerializer,
      Contract::class to ContractPolymorphicSerializer,
      Coverage::class to CoveragePolymorphicSerializer,
      CoverageEligibilityRequest::class to CoverageEligibilityRequestPolymorphicSerializer,
      CoverageEligibilityResponse::class to CoverageEligibilityResponsePolymorphicSerializer,
      DetectedIssue::class to DetectedIssuePolymorphicSerializer,
      Device::class to DevicePolymorphicSerializer,
      DeviceAssociation::class to DeviceAssociationPolymorphicSerializer,
      DeviceDefinition::class to DeviceDefinitionPolymorphicSerializer,
      DeviceDispense::class to DeviceDispensePolymorphicSerializer,
      DeviceMetric::class to DeviceMetricPolymorphicSerializer,
      DeviceRequest::class to DeviceRequestPolymorphicSerializer,
      DeviceUsage::class to DeviceUsagePolymorphicSerializer,
      DiagnosticReport::class to DiagnosticReportPolymorphicSerializer,
      DocumentReference::class to DocumentReferencePolymorphicSerializer,
      Encounter::class to EncounterPolymorphicSerializer,
      EncounterHistory::class to EncounterHistoryPolymorphicSerializer,
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
      FormularyItem::class to FormularyItemPolymorphicSerializer,
      GenomicStudy::class to GenomicStudyPolymorphicSerializer,
      Goal::class to GoalPolymorphicSerializer,
      GraphDefinition::class to GraphDefinitionPolymorphicSerializer,
      Group::class to GroupPolymorphicSerializer,
      GuidanceResponse::class to GuidanceResponsePolymorphicSerializer,
      HealthcareService::class to HealthcareServicePolymorphicSerializer,
      ImagingSelection::class to ImagingSelectionPolymorphicSerializer,
      ImagingStudy::class to ImagingStudyPolymorphicSerializer,
      Immunization::class to ImmunizationPolymorphicSerializer,
      ImmunizationEvaluation::class to ImmunizationEvaluationPolymorphicSerializer,
      ImmunizationRecommendation::class to ImmunizationRecommendationPolymorphicSerializer,
      ImplementationGuide::class to ImplementationGuidePolymorphicSerializer,
      Ingredient::class to IngredientPolymorphicSerializer,
      InsurancePlan::class to InsurancePlanPolymorphicSerializer,
      InventoryItem::class to InventoryItemPolymorphicSerializer,
      InventoryReport::class to InventoryReportPolymorphicSerializer,
      Invoice::class to InvoicePolymorphicSerializer,
      Library::class to LibraryPolymorphicSerializer,
      Linkage::class to LinkagePolymorphicSerializer,
      List::class to ListPolymorphicSerializer,
      Location::class to LocationPolymorphicSerializer,
      ManufacturedItemDefinition::class to ManufacturedItemDefinitionPolymorphicSerializer,
      Measure::class to MeasurePolymorphicSerializer,
      MeasureReport::class to MeasureReportPolymorphicSerializer,
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
      NutritionIntake::class to NutritionIntakePolymorphicSerializer,
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
      Permission::class to PermissionPolymorphicSerializer,
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
      RequestOrchestration::class to RequestOrchestrationPolymorphicSerializer,
      Requirements::class to RequirementsPolymorphicSerializer,
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
      SubstanceNucleicAcid::class to SubstanceNucleicAcidPolymorphicSerializer,
      SubstancePolymer::class to SubstancePolymerPolymorphicSerializer,
      SubstanceProtein::class to SubstanceProteinPolymorphicSerializer,
      SubstanceReferenceInformation::class to SubstanceReferenceInformationPolymorphicSerializer,
      SubstanceSourceMaterial::class to SubstanceSourceMaterialPolymorphicSerializer,
      SupplyDelivery::class to SupplyDeliveryPolymorphicSerializer,
      SupplyRequest::class to SupplyRequestPolymorphicSerializer,
      Task::class to TaskPolymorphicSerializer,
      TerminologyCapabilities::class to TerminologyCapabilitiesPolymorphicSerializer,
      TestPlan::class to TestPlanPolymorphicSerializer,
      TestReport::class to TestReportPolymorphicSerializer,
      TestScript::class to TestScriptPolymorphicSerializer,
      Transport::class to TransportPolymorphicSerializer,
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
