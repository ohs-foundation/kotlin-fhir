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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.AccountPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ActivityDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.AdverseEventPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.AllergyIntolerancePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.AppointmentPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.AppointmentResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.AuditEventPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.BasicPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.BinaryPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.BiologicallyDerivedProductPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.BodyStructurePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.BundlePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CarePlanPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CareTeamPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CatalogEntryPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ChargeItemDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ChargeItemPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ClaimPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ClaimResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ClinicalImpressionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CodeSystemPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CommunicationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CommunicationRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CompartmentDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CompositionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ConceptMapPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ConditionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ConsentPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ContractPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CoverageEligibilityRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CoverageEligibilityResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.CoveragePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DetectedIssuePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceMetricPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DevicePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceUseStatementPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DiagnosticReportPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DocumentManifestPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.DocumentReferencePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EncounterPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EndpointPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EnrollmentRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EnrollmentResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EpisodeOfCarePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EventDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EvidencePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.EvidenceVariablePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ExplanationOfBenefitPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.FamilyMemberHistoryPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.FlagPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.GoalPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.GraphDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.GroupPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.GuidanceResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.HealthcareServicePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ImagingStudyPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ImmunizationEvaluationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ImmunizationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ImmunizationRecommendationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ImplementationGuidePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.InsurancePlanPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.InvoicePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.LibraryPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.LinkagePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ListPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.LocationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MeasurePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureReportPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MediaPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationAdministrationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationDispensePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationStatementPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductAuthorizationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductContraindicationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductIndicationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductIngredientPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductInteractionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductManufacturedPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductPackagedPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductPharmaceuticalPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductUndesirableEffectPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MessageDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MessageHeaderPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.MolecularSequencePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.NamingSystemPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.NutritionOrderPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ObservationDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ObservationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.OperationDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.OperationOutcomePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.OrganizationAffiliationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.OrganizationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ParametersPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.PatientPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.PaymentNoticePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.PaymentReconciliationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.PersonPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.PractitionerPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.PractitionerRolePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ProcedurePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ProvenancePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnairePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireResponsePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.RelatedPersonPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.RequestGroupPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ResearchDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ResearchElementDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ResearchStudyPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ResearchSubjectPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.RiskAssessmentPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.RiskEvidenceSynthesisPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SchedulePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SearchParameterPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ServiceRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SlotPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SpecimenDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SpecimenPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.StructureDefinitionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.StructureMapPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SubscriptionPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceNucleicAcidPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SubstancePolymerPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SubstancePolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceProteinPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceReferenceInformationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSpecificationPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SupplyDeliveryPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.SupplyRequestPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.TaskPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.TerminologyCapabilitiesPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.TestReportPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.TestScriptPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.ValueSetPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.VerificationResultPolymorphicSerializer
import dev.ohs.fhir.model.r4.serializers.VisionPrescriptionPolymorphicSerializer
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
      "Claim" to ClaimPolymorphicSerializer,
      "ClaimResponse" to ClaimResponsePolymorphicSerializer,
      "ClinicalImpression" to ClinicalImpressionPolymorphicSerializer,
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
      "EffectEvidenceSynthesis" to EffectEvidenceSynthesisPolymorphicSerializer,
      "Encounter" to EncounterPolymorphicSerializer,
      "Endpoint" to EndpointPolymorphicSerializer,
      "EnrollmentRequest" to EnrollmentRequestPolymorphicSerializer,
      "EnrollmentResponse" to EnrollmentResponsePolymorphicSerializer,
      "EpisodeOfCare" to EpisodeOfCarePolymorphicSerializer,
      "EventDefinition" to EventDefinitionPolymorphicSerializer,
      "Evidence" to EvidencePolymorphicSerializer,
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
      "InsurancePlan" to InsurancePlanPolymorphicSerializer,
      "Invoice" to InvoicePolymorphicSerializer,
      "Library" to LibraryPolymorphicSerializer,
      "Linkage" to LinkagePolymorphicSerializer,
      "List" to ListPolymorphicSerializer,
      "Location" to LocationPolymorphicSerializer,
      "Measure" to MeasurePolymorphicSerializer,
      "MeasureReport" to MeasureReportPolymorphicSerializer,
      "Media" to MediaPolymorphicSerializer,
      "Medication" to MedicationPolymorphicSerializer,
      "MedicationAdministration" to MedicationAdministrationPolymorphicSerializer,
      "MedicationDispense" to MedicationDispensePolymorphicSerializer,
      "MedicationKnowledge" to MedicationKnowledgePolymorphicSerializer,
      "MedicationRequest" to MedicationRequestPolymorphicSerializer,
      "MedicationStatement" to MedicationStatementPolymorphicSerializer,
      "MedicinalProduct" to MedicinalProductPolymorphicSerializer,
      "MedicinalProductAuthorization" to MedicinalProductAuthorizationPolymorphicSerializer,
      "MedicinalProductContraindication" to MedicinalProductContraindicationPolymorphicSerializer,
      "MedicinalProductIndication" to MedicinalProductIndicationPolymorphicSerializer,
      "MedicinalProductIngredient" to MedicinalProductIngredientPolymorphicSerializer,
      "MedicinalProductInteraction" to MedicinalProductInteractionPolymorphicSerializer,
      "MedicinalProductManufactured" to MedicinalProductManufacturedPolymorphicSerializer,
      "MedicinalProductPackaged" to MedicinalProductPackagedPolymorphicSerializer,
      "MedicinalProductPharmaceutical" to MedicinalProductPharmaceuticalPolymorphicSerializer,
      "MedicinalProductUndesirableEffect" to MedicinalProductUndesirableEffectPolymorphicSerializer,
      "MessageDefinition" to MessageDefinitionPolymorphicSerializer,
      "MessageHeader" to MessageHeaderPolymorphicSerializer,
      "MolecularSequence" to MolecularSequencePolymorphicSerializer,
      "NamingSystem" to NamingSystemPolymorphicSerializer,
      "NutritionOrder" to NutritionOrderPolymorphicSerializer,
      "Observation" to ObservationPolymorphicSerializer,
      "ObservationDefinition" to ObservationDefinitionPolymorphicSerializer,
      "OperationDefinition" to OperationDefinitionPolymorphicSerializer,
      "OperationOutcome" to OperationOutcomePolymorphicSerializer,
      "Organization" to OrganizationPolymorphicSerializer,
      "OrganizationAffiliation" to OrganizationAffiliationPolymorphicSerializer,
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
      "RelatedPerson" to RelatedPersonPolymorphicSerializer,
      "RequestGroup" to RequestGroupPolymorphicSerializer,
      "ResearchDefinition" to ResearchDefinitionPolymorphicSerializer,
      "ResearchElementDefinition" to ResearchElementDefinitionPolymorphicSerializer,
      "ResearchStudy" to ResearchStudyPolymorphicSerializer,
      "ResearchSubject" to ResearchSubjectPolymorphicSerializer,
      "RiskAssessment" to RiskAssessmentPolymorphicSerializer,
      "RiskEvidenceSynthesis" to RiskEvidenceSynthesisPolymorphicSerializer,
      "Schedule" to SchedulePolymorphicSerializer,
      "SearchParameter" to SearchParameterPolymorphicSerializer,
      "ServiceRequest" to ServiceRequestPolymorphicSerializer,
      "Slot" to SlotPolymorphicSerializer,
      "Specimen" to SpecimenPolymorphicSerializer,
      "SpecimenDefinition" to SpecimenDefinitionPolymorphicSerializer,
      "StructureDefinition" to StructureDefinitionPolymorphicSerializer,
      "StructureMap" to StructureMapPolymorphicSerializer,
      "Subscription" to SubscriptionPolymorphicSerializer,
      "Substance" to SubstancePolymorphicSerializer,
      "SubstanceNucleicAcid" to SubstanceNucleicAcidPolymorphicSerializer,
      "SubstancePolymer" to SubstancePolymerPolymorphicSerializer,
      "SubstanceProtein" to SubstanceProteinPolymorphicSerializer,
      "SubstanceReferenceInformation" to SubstanceReferenceInformationPolymorphicSerializer,
      "SubstanceSourceMaterial" to SubstanceSourceMaterialPolymorphicSerializer,
      "SubstanceSpecification" to SubstanceSpecificationPolymorphicSerializer,
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
      Claim::class to ClaimPolymorphicSerializer,
      ClaimResponse::class to ClaimResponsePolymorphicSerializer,
      ClinicalImpression::class to ClinicalImpressionPolymorphicSerializer,
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
      EffectEvidenceSynthesis::class to EffectEvidenceSynthesisPolymorphicSerializer,
      Encounter::class to EncounterPolymorphicSerializer,
      Endpoint::class to EndpointPolymorphicSerializer,
      EnrollmentRequest::class to EnrollmentRequestPolymorphicSerializer,
      EnrollmentResponse::class to EnrollmentResponsePolymorphicSerializer,
      EpisodeOfCare::class to EpisodeOfCarePolymorphicSerializer,
      EventDefinition::class to EventDefinitionPolymorphicSerializer,
      Evidence::class to EvidencePolymorphicSerializer,
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
      InsurancePlan::class to InsurancePlanPolymorphicSerializer,
      Invoice::class to InvoicePolymorphicSerializer,
      Library::class to LibraryPolymorphicSerializer,
      Linkage::class to LinkagePolymorphicSerializer,
      List::class to ListPolymorphicSerializer,
      Location::class to LocationPolymorphicSerializer,
      Measure::class to MeasurePolymorphicSerializer,
      MeasureReport::class to MeasureReportPolymorphicSerializer,
      Media::class to MediaPolymorphicSerializer,
      Medication::class to MedicationPolymorphicSerializer,
      MedicationAdministration::class to MedicationAdministrationPolymorphicSerializer,
      MedicationDispense::class to MedicationDispensePolymorphicSerializer,
      MedicationKnowledge::class to MedicationKnowledgePolymorphicSerializer,
      MedicationRequest::class to MedicationRequestPolymorphicSerializer,
      MedicationStatement::class to MedicationStatementPolymorphicSerializer,
      MedicinalProduct::class to MedicinalProductPolymorphicSerializer,
      MedicinalProductAuthorization::class to MedicinalProductAuthorizationPolymorphicSerializer,
      MedicinalProductContraindication::class to
        MedicinalProductContraindicationPolymorphicSerializer,
      MedicinalProductIndication::class to MedicinalProductIndicationPolymorphicSerializer,
      MedicinalProductIngredient::class to MedicinalProductIngredientPolymorphicSerializer,
      MedicinalProductInteraction::class to MedicinalProductInteractionPolymorphicSerializer,
      MedicinalProductManufactured::class to MedicinalProductManufacturedPolymorphicSerializer,
      MedicinalProductPackaged::class to MedicinalProductPackagedPolymorphicSerializer,
      MedicinalProductPharmaceutical::class to MedicinalProductPharmaceuticalPolymorphicSerializer,
      MedicinalProductUndesirableEffect::class to
        MedicinalProductUndesirableEffectPolymorphicSerializer,
      MessageDefinition::class to MessageDefinitionPolymorphicSerializer,
      MessageHeader::class to MessageHeaderPolymorphicSerializer,
      MolecularSequence::class to MolecularSequencePolymorphicSerializer,
      NamingSystem::class to NamingSystemPolymorphicSerializer,
      NutritionOrder::class to NutritionOrderPolymorphicSerializer,
      Observation::class to ObservationPolymorphicSerializer,
      ObservationDefinition::class to ObservationDefinitionPolymorphicSerializer,
      OperationDefinition::class to OperationDefinitionPolymorphicSerializer,
      OperationOutcome::class to OperationOutcomePolymorphicSerializer,
      Organization::class to OrganizationPolymorphicSerializer,
      OrganizationAffiliation::class to OrganizationAffiliationPolymorphicSerializer,
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
      RelatedPerson::class to RelatedPersonPolymorphicSerializer,
      RequestGroup::class to RequestGroupPolymorphicSerializer,
      ResearchDefinition::class to ResearchDefinitionPolymorphicSerializer,
      ResearchElementDefinition::class to ResearchElementDefinitionPolymorphicSerializer,
      ResearchStudy::class to ResearchStudyPolymorphicSerializer,
      ResearchSubject::class to ResearchSubjectPolymorphicSerializer,
      RiskAssessment::class to RiskAssessmentPolymorphicSerializer,
      RiskEvidenceSynthesis::class to RiskEvidenceSynthesisPolymorphicSerializer,
      Schedule::class to SchedulePolymorphicSerializer,
      SearchParameter::class to SearchParameterPolymorphicSerializer,
      ServiceRequest::class to ServiceRequestPolymorphicSerializer,
      Slot::class to SlotPolymorphicSerializer,
      Specimen::class to SpecimenPolymorphicSerializer,
      SpecimenDefinition::class to SpecimenDefinitionPolymorphicSerializer,
      StructureDefinition::class to StructureDefinitionPolymorphicSerializer,
      StructureMap::class to StructureMapPolymorphicSerializer,
      Subscription::class to SubscriptionPolymorphicSerializer,
      Substance::class to SubstancePolymorphicSerializer,
      SubstanceNucleicAcid::class to SubstanceNucleicAcidPolymorphicSerializer,
      SubstancePolymer::class to SubstancePolymerPolymorphicSerializer,
      SubstanceProtein::class to SubstanceProteinPolymorphicSerializer,
      SubstanceReferenceInformation::class to SubstanceReferenceInformationPolymorphicSerializer,
      SubstanceSourceMaterial::class to SubstanceSourceMaterialPolymorphicSerializer,
      SubstanceSpecification::class to SubstanceSpecificationPolymorphicSerializer,
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
