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

import dev.ohs.fhir.model.r5.serializers.AccountSerializer
import dev.ohs.fhir.model.r5.serializers.ActivityDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.ActorDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.AdministrableProductDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventSerializer
import dev.ohs.fhir.model.r5.serializers.AllergyIntoleranceSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentResponseSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentSerializer
import dev.ohs.fhir.model.r5.serializers.ArtifactAssessmentSerializer
import dev.ohs.fhir.model.r5.serializers.AuditEventSerializer
import dev.ohs.fhir.model.r5.serializers.BasicSerializer
import dev.ohs.fhir.model.r5.serializers.BinarySerializer
import dev.ohs.fhir.model.r5.serializers.BiologicallyDerivedProductDispenseSerializer
import dev.ohs.fhir.model.r5.serializers.BiologicallyDerivedProductSerializer
import dev.ohs.fhir.model.r5.serializers.BodyStructureSerializer
import dev.ohs.fhir.model.r5.serializers.BundleSerializer
import dev.ohs.fhir.model.r5.serializers.CapabilityStatementSerializer
import dev.ohs.fhir.model.r5.serializers.CarePlanSerializer
import dev.ohs.fhir.model.r5.serializers.CareTeamSerializer
import dev.ohs.fhir.model.r5.serializers.ChargeItemDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.ChargeItemSerializer
import dev.ohs.fhir.model.r5.serializers.CitationSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimSerializer
import dev.ohs.fhir.model.r5.serializers.ClinicalImpressionSerializer
import dev.ohs.fhir.model.r5.serializers.ClinicalUseDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.CodeSystemSerializer
import dev.ohs.fhir.model.r5.serializers.CommunicationRequestSerializer
import dev.ohs.fhir.model.r5.serializers.CommunicationSerializer
import dev.ohs.fhir.model.r5.serializers.CompartmentDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.CompositionSerializer
import dev.ohs.fhir.model.r5.serializers.ConceptMapSerializer
import dev.ohs.fhir.model.r5.serializers.ConditionDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.ConditionSerializer
import dev.ohs.fhir.model.r5.serializers.ConsentSerializer
import dev.ohs.fhir.model.r5.serializers.ContractSerializer
import dev.ohs.fhir.model.r5.serializers.CoverageEligibilityRequestSerializer
import dev.ohs.fhir.model.r5.serializers.CoverageEligibilityResponseSerializer
import dev.ohs.fhir.model.r5.serializers.CoverageSerializer
import dev.ohs.fhir.model.r5.serializers.DetectedIssueSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceAssociationSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDispenseSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceMetricSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceRequestSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceUsageSerializer
import dev.ohs.fhir.model.r5.serializers.DiagnosticReportSerializer
import dev.ohs.fhir.model.r5.serializers.DocumentReferenceSerializer
import dev.ohs.fhir.model.r5.serializers.EncounterHistorySerializer
import dev.ohs.fhir.model.r5.serializers.EncounterSerializer
import dev.ohs.fhir.model.r5.serializers.EndpointSerializer
import dev.ohs.fhir.model.r5.serializers.EnrollmentRequestSerializer
import dev.ohs.fhir.model.r5.serializers.EnrollmentResponseSerializer
import dev.ohs.fhir.model.r5.serializers.EpisodeOfCareSerializer
import dev.ohs.fhir.model.r5.serializers.EventDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceReportSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableSerializer
import dev.ohs.fhir.model.r5.serializers.ExampleScenarioSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitSerializer
import dev.ohs.fhir.model.r5.serializers.FamilyMemberHistorySerializer
import dev.ohs.fhir.model.r5.serializers.FhirSerializer
import dev.ohs.fhir.model.r5.serializers.FlagSerializer
import dev.ohs.fhir.model.r5.serializers.FormularyItemSerializer
import dev.ohs.fhir.model.r5.serializers.GenomicStudySerializer
import dev.ohs.fhir.model.r5.serializers.GoalSerializer
import dev.ohs.fhir.model.r5.serializers.GraphDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.GroupSerializer
import dev.ohs.fhir.model.r5.serializers.GuidanceResponseSerializer
import dev.ohs.fhir.model.r5.serializers.HealthcareServiceSerializer
import dev.ohs.fhir.model.r5.serializers.ImagingSelectionSerializer
import dev.ohs.fhir.model.r5.serializers.ImagingStudySerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationEvaluationSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationRecommendationSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideSerializer
import dev.ohs.fhir.model.r5.serializers.IngredientSerializer
import dev.ohs.fhir.model.r5.serializers.InsurancePlanSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryItemSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryReportSerializer
import dev.ohs.fhir.model.r5.serializers.InvoiceSerializer
import dev.ohs.fhir.model.r5.serializers.LibrarySerializer
import dev.ohs.fhir.model.r5.serializers.LinkageSerializer
import dev.ohs.fhir.model.r5.serializers.ListSerializer
import dev.ohs.fhir.model.r5.serializers.LocationSerializer
import dev.ohs.fhir.model.r5.serializers.ManufacturedItemDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureReportSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationAdministrationSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationDispenseSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationRequestSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationStatementSerializer
import dev.ohs.fhir.model.r5.serializers.MedicinalProductDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.MessageDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.MessageHeaderSerializer
import dev.ohs.fhir.model.r5.serializers.MolecularSequenceSerializer
import dev.ohs.fhir.model.r5.serializers.NamingSystemSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionIntakeSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionOrderSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionProductSerializer
import dev.ohs.fhir.model.r5.serializers.ObservationDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.ObservationSerializer
import dev.ohs.fhir.model.r5.serializers.OperationDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.OperationOutcomeSerializer
import dev.ohs.fhir.model.r5.serializers.OrganizationAffiliationSerializer
import dev.ohs.fhir.model.r5.serializers.OrganizationSerializer
import dev.ohs.fhir.model.r5.serializers.PackagedProductDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.ParametersSerializer
import dev.ohs.fhir.model.r5.serializers.PatientSerializer
import dev.ohs.fhir.model.r5.serializers.PaymentNoticeSerializer
import dev.ohs.fhir.model.r5.serializers.PaymentReconciliationSerializer
import dev.ohs.fhir.model.r5.serializers.PermissionSerializer
import dev.ohs.fhir.model.r5.serializers.PersonSerializer
import dev.ohs.fhir.model.r5.serializers.PlanDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.PractitionerRoleSerializer
import dev.ohs.fhir.model.r5.serializers.PractitionerSerializer
import dev.ohs.fhir.model.r5.serializers.ProcedureSerializer
import dev.ohs.fhir.model.r5.serializers.ProvenanceSerializer
import dev.ohs.fhir.model.r5.serializers.QuestionnaireResponseSerializer
import dev.ohs.fhir.model.r5.serializers.QuestionnaireSerializer
import dev.ohs.fhir.model.r5.serializers.RegulatedAuthorizationSerializer
import dev.ohs.fhir.model.r5.serializers.RelatedPersonSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationSerializer
import dev.ohs.fhir.model.r5.serializers.RequirementsSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudySerializer
import dev.ohs.fhir.model.r5.serializers.ResearchSubjectSerializer
import dev.ohs.fhir.model.r5.serializers.RiskAssessmentSerializer
import dev.ohs.fhir.model.r5.serializers.ScheduleSerializer
import dev.ohs.fhir.model.r5.serializers.SearchParameterSerializer
import dev.ohs.fhir.model.r5.serializers.ServiceRequestSerializer
import dev.ohs.fhir.model.r5.serializers.SlotSerializer
import dev.ohs.fhir.model.r5.serializers.SpecimenDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.SpecimenSerializer
import dev.ohs.fhir.model.r5.serializers.StructureDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.StructureMapSerializer
import dev.ohs.fhir.model.r5.serializers.SubscriptionSerializer
import dev.ohs.fhir.model.r5.serializers.SubscriptionStatusSerializer
import dev.ohs.fhir.model.r5.serializers.SubscriptionTopicSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceNucleicAcidSerializer
import dev.ohs.fhir.model.r5.serializers.SubstancePolymerSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceProteinSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceReferenceInformationSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceSourceMaterialSerializer
import dev.ohs.fhir.model.r5.serializers.SupplyDeliverySerializer
import dev.ohs.fhir.model.r5.serializers.SupplyRequestSerializer
import dev.ohs.fhir.model.r5.serializers.TaskSerializer
import dev.ohs.fhir.model.r5.serializers.TerminologyCapabilitiesSerializer
import dev.ohs.fhir.model.r5.serializers.TestPlanSerializer
import dev.ohs.fhir.model.r5.serializers.TestReportSerializer
import dev.ohs.fhir.model.r5.serializers.TestScriptSerializer
import dev.ohs.fhir.model.r5.serializers.TransportSerializer
import dev.ohs.fhir.model.r5.serializers.ValueSetSerializer
import dev.ohs.fhir.model.r5.serializers.VerificationResultSerializer
import dev.ohs.fhir.model.r5.serializers.VisionPrescriptionSerializer
import dev.ohs.fhir.model.r5.serializers.stringDescriptor
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.collections.associateBy
import kotlin.collections.mapOf
import kotlin.jvm.JvmField
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
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.`internal`.AbstractPolymorphicSerializer
import kotlinx.serialization.json.JsonClassDiscriminator

internal interface FhirResourceSerializer<T : Resource> : FhirSerializer<T> {
  public fun buildResourceDescriptor(serialName: String): SerialDescriptor =
    buildClassSerialDescriptor(serialName) {
      element("resourceType", stringDescriptor, isOptional = false)
      buildDescriptor(this)
    }

  public fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): T

  public fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: T,
  )

  override fun deserialize(decoder: Decoder): T =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: T) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, descriptor.serialName)
      serializeInternal(this, descriptor, 1, value)
    }
  }
}

internal class FhirResourcePolymorphicSerializer<T : Resource>(
  private val `delegate`: FhirResourceSerializer<T>
) : KSerializer<T> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor(delegate.descriptor.serialName) { delegate.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: T) {
    encoder.encodeStructure(descriptor) {
      delegate.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): T =
    decoder.decodeStructure(descriptor) {
      delegate.deserializeInternal(this, descriptor, 0)
    }
}

@OptIn(
  InternalSerializationApi::class,
  ExperimentalSerializationApi::class,
)
internal object ResourcePolymorphicSerializer : AbstractPolymorphicSerializer<Resource>() {
  override val baseClass: KClass<Resource> = Resource::class

  private val byClass: Map<KClass<*>, KSerializer<out Resource>> =
    mapOf(
      Account::class to FhirResourcePolymorphicSerializer(AccountSerializer),
      ActivityDefinition::class to FhirResourcePolymorphicSerializer(ActivityDefinitionSerializer),
      ActorDefinition::class to FhirResourcePolymorphicSerializer(ActorDefinitionSerializer),
      AdministrableProductDefinition::class to
        FhirResourcePolymorphicSerializer(AdministrableProductDefinitionSerializer),
      AdverseEvent::class to FhirResourcePolymorphicSerializer(AdverseEventSerializer),
      AllergyIntolerance::class to FhirResourcePolymorphicSerializer(AllergyIntoleranceSerializer),
      Appointment::class to FhirResourcePolymorphicSerializer(AppointmentSerializer),
      AppointmentResponse::class to
        FhirResourcePolymorphicSerializer(AppointmentResponseSerializer),
      ArtifactAssessment::class to FhirResourcePolymorphicSerializer(ArtifactAssessmentSerializer),
      AuditEvent::class to FhirResourcePolymorphicSerializer(AuditEventSerializer),
      Basic::class to FhirResourcePolymorphicSerializer(BasicSerializer),
      Binary::class to FhirResourcePolymorphicSerializer(BinarySerializer),
      BiologicallyDerivedProduct::class to
        FhirResourcePolymorphicSerializer(BiologicallyDerivedProductSerializer),
      BiologicallyDerivedProductDispense::class to
        FhirResourcePolymorphicSerializer(BiologicallyDerivedProductDispenseSerializer),
      BodyStructure::class to FhirResourcePolymorphicSerializer(BodyStructureSerializer),
      Bundle::class to FhirResourcePolymorphicSerializer(BundleSerializer),
      CapabilityStatement::class to
        FhirResourcePolymorphicSerializer(CapabilityStatementSerializer),
      CarePlan::class to FhirResourcePolymorphicSerializer(CarePlanSerializer),
      CareTeam::class to FhirResourcePolymorphicSerializer(CareTeamSerializer),
      ChargeItem::class to FhirResourcePolymorphicSerializer(ChargeItemSerializer),
      ChargeItemDefinition::class to
        FhirResourcePolymorphicSerializer(ChargeItemDefinitionSerializer),
      Citation::class to FhirResourcePolymorphicSerializer(CitationSerializer),
      Claim::class to FhirResourcePolymorphicSerializer(ClaimSerializer),
      ClaimResponse::class to FhirResourcePolymorphicSerializer(ClaimResponseSerializer),
      ClinicalImpression::class to FhirResourcePolymorphicSerializer(ClinicalImpressionSerializer),
      ClinicalUseDefinition::class to
        FhirResourcePolymorphicSerializer(ClinicalUseDefinitionSerializer),
      CodeSystem::class to FhirResourcePolymorphicSerializer(CodeSystemSerializer),
      Communication::class to FhirResourcePolymorphicSerializer(CommunicationSerializer),
      CommunicationRequest::class to
        FhirResourcePolymorphicSerializer(CommunicationRequestSerializer),
      CompartmentDefinition::class to
        FhirResourcePolymorphicSerializer(CompartmentDefinitionSerializer),
      Composition::class to FhirResourcePolymorphicSerializer(CompositionSerializer),
      ConceptMap::class to FhirResourcePolymorphicSerializer(ConceptMapSerializer),
      Condition::class to FhirResourcePolymorphicSerializer(ConditionSerializer),
      ConditionDefinition::class to
        FhirResourcePolymorphicSerializer(ConditionDefinitionSerializer),
      Consent::class to FhirResourcePolymorphicSerializer(ConsentSerializer),
      Contract::class to FhirResourcePolymorphicSerializer(ContractSerializer),
      Coverage::class to FhirResourcePolymorphicSerializer(CoverageSerializer),
      CoverageEligibilityRequest::class to
        FhirResourcePolymorphicSerializer(CoverageEligibilityRequestSerializer),
      CoverageEligibilityResponse::class to
        FhirResourcePolymorphicSerializer(CoverageEligibilityResponseSerializer),
      DetectedIssue::class to FhirResourcePolymorphicSerializer(DetectedIssueSerializer),
      Device::class to FhirResourcePolymorphicSerializer(DeviceSerializer),
      DeviceAssociation::class to FhirResourcePolymorphicSerializer(DeviceAssociationSerializer),
      DeviceDefinition::class to FhirResourcePolymorphicSerializer(DeviceDefinitionSerializer),
      DeviceDispense::class to FhirResourcePolymorphicSerializer(DeviceDispenseSerializer),
      DeviceMetric::class to FhirResourcePolymorphicSerializer(DeviceMetricSerializer),
      DeviceRequest::class to FhirResourcePolymorphicSerializer(DeviceRequestSerializer),
      DeviceUsage::class to FhirResourcePolymorphicSerializer(DeviceUsageSerializer),
      DiagnosticReport::class to FhirResourcePolymorphicSerializer(DiagnosticReportSerializer),
      DocumentReference::class to FhirResourcePolymorphicSerializer(DocumentReferenceSerializer),
      Encounter::class to FhirResourcePolymorphicSerializer(EncounterSerializer),
      EncounterHistory::class to FhirResourcePolymorphicSerializer(EncounterHistorySerializer),
      Endpoint::class to FhirResourcePolymorphicSerializer(EndpointSerializer),
      EnrollmentRequest::class to FhirResourcePolymorphicSerializer(EnrollmentRequestSerializer),
      EnrollmentResponse::class to FhirResourcePolymorphicSerializer(EnrollmentResponseSerializer),
      EpisodeOfCare::class to FhirResourcePolymorphicSerializer(EpisodeOfCareSerializer),
      EventDefinition::class to FhirResourcePolymorphicSerializer(EventDefinitionSerializer),
      Evidence::class to FhirResourcePolymorphicSerializer(EvidenceSerializer),
      EvidenceReport::class to FhirResourcePolymorphicSerializer(EvidenceReportSerializer),
      EvidenceVariable::class to FhirResourcePolymorphicSerializer(EvidenceVariableSerializer),
      ExampleScenario::class to FhirResourcePolymorphicSerializer(ExampleScenarioSerializer),
      ExplanationOfBenefit::class to
        FhirResourcePolymorphicSerializer(ExplanationOfBenefitSerializer),
      FamilyMemberHistory::class to
        FhirResourcePolymorphicSerializer(FamilyMemberHistorySerializer),
      Flag::class to FhirResourcePolymorphicSerializer(FlagSerializer),
      FormularyItem::class to FhirResourcePolymorphicSerializer(FormularyItemSerializer),
      GenomicStudy::class to FhirResourcePolymorphicSerializer(GenomicStudySerializer),
      Goal::class to FhirResourcePolymorphicSerializer(GoalSerializer),
      GraphDefinition::class to FhirResourcePolymorphicSerializer(GraphDefinitionSerializer),
      Group::class to FhirResourcePolymorphicSerializer(GroupSerializer),
      GuidanceResponse::class to FhirResourcePolymorphicSerializer(GuidanceResponseSerializer),
      HealthcareService::class to FhirResourcePolymorphicSerializer(HealthcareServiceSerializer),
      ImagingSelection::class to FhirResourcePolymorphicSerializer(ImagingSelectionSerializer),
      ImagingStudy::class to FhirResourcePolymorphicSerializer(ImagingStudySerializer),
      Immunization::class to FhirResourcePolymorphicSerializer(ImmunizationSerializer),
      ImmunizationEvaluation::class to
        FhirResourcePolymorphicSerializer(ImmunizationEvaluationSerializer),
      ImmunizationRecommendation::class to
        FhirResourcePolymorphicSerializer(ImmunizationRecommendationSerializer),
      ImplementationGuide::class to
        FhirResourcePolymorphicSerializer(ImplementationGuideSerializer),
      Ingredient::class to FhirResourcePolymorphicSerializer(IngredientSerializer),
      InsurancePlan::class to FhirResourcePolymorphicSerializer(InsurancePlanSerializer),
      InventoryItem::class to FhirResourcePolymorphicSerializer(InventoryItemSerializer),
      InventoryReport::class to FhirResourcePolymorphicSerializer(InventoryReportSerializer),
      Invoice::class to FhirResourcePolymorphicSerializer(InvoiceSerializer),
      Library::class to FhirResourcePolymorphicSerializer(LibrarySerializer),
      Linkage::class to FhirResourcePolymorphicSerializer(LinkageSerializer),
      List::class to FhirResourcePolymorphicSerializer(ListSerializer),
      Location::class to FhirResourcePolymorphicSerializer(LocationSerializer),
      ManufacturedItemDefinition::class to
        FhirResourcePolymorphicSerializer(ManufacturedItemDefinitionSerializer),
      Measure::class to FhirResourcePolymorphicSerializer(MeasureSerializer),
      MeasureReport::class to FhirResourcePolymorphicSerializer(MeasureReportSerializer),
      Medication::class to FhirResourcePolymorphicSerializer(MedicationSerializer),
      MedicationAdministration::class to
        FhirResourcePolymorphicSerializer(MedicationAdministrationSerializer),
      MedicationDispense::class to FhirResourcePolymorphicSerializer(MedicationDispenseSerializer),
      MedicationKnowledge::class to
        FhirResourcePolymorphicSerializer(MedicationKnowledgeSerializer),
      MedicationRequest::class to FhirResourcePolymorphicSerializer(MedicationRequestSerializer),
      MedicationStatement::class to
        FhirResourcePolymorphicSerializer(MedicationStatementSerializer),
      MedicinalProductDefinition::class to
        FhirResourcePolymorphicSerializer(MedicinalProductDefinitionSerializer),
      MessageDefinition::class to FhirResourcePolymorphicSerializer(MessageDefinitionSerializer),
      MessageHeader::class to FhirResourcePolymorphicSerializer(MessageHeaderSerializer),
      MolecularSequence::class to FhirResourcePolymorphicSerializer(MolecularSequenceSerializer),
      NamingSystem::class to FhirResourcePolymorphicSerializer(NamingSystemSerializer),
      NutritionIntake::class to FhirResourcePolymorphicSerializer(NutritionIntakeSerializer),
      NutritionOrder::class to FhirResourcePolymorphicSerializer(NutritionOrderSerializer),
      NutritionProduct::class to FhirResourcePolymorphicSerializer(NutritionProductSerializer),
      Observation::class to FhirResourcePolymorphicSerializer(ObservationSerializer),
      ObservationDefinition::class to
        FhirResourcePolymorphicSerializer(ObservationDefinitionSerializer),
      OperationDefinition::class to
        FhirResourcePolymorphicSerializer(OperationDefinitionSerializer),
      OperationOutcome::class to FhirResourcePolymorphicSerializer(OperationOutcomeSerializer),
      Organization::class to FhirResourcePolymorphicSerializer(OrganizationSerializer),
      OrganizationAffiliation::class to
        FhirResourcePolymorphicSerializer(OrganizationAffiliationSerializer),
      PackagedProductDefinition::class to
        FhirResourcePolymorphicSerializer(PackagedProductDefinitionSerializer),
      Parameters::class to FhirResourcePolymorphicSerializer(ParametersSerializer),
      Patient::class to FhirResourcePolymorphicSerializer(PatientSerializer),
      PaymentNotice::class to FhirResourcePolymorphicSerializer(PaymentNoticeSerializer),
      PaymentReconciliation::class to
        FhirResourcePolymorphicSerializer(PaymentReconciliationSerializer),
      Permission::class to FhirResourcePolymorphicSerializer(PermissionSerializer),
      Person::class to FhirResourcePolymorphicSerializer(PersonSerializer),
      PlanDefinition::class to FhirResourcePolymorphicSerializer(PlanDefinitionSerializer),
      Practitioner::class to FhirResourcePolymorphicSerializer(PractitionerSerializer),
      PractitionerRole::class to FhirResourcePolymorphicSerializer(PractitionerRoleSerializer),
      Procedure::class to FhirResourcePolymorphicSerializer(ProcedureSerializer),
      Provenance::class to FhirResourcePolymorphicSerializer(ProvenanceSerializer),
      Questionnaire::class to FhirResourcePolymorphicSerializer(QuestionnaireSerializer),
      QuestionnaireResponse::class to
        FhirResourcePolymorphicSerializer(QuestionnaireResponseSerializer),
      RegulatedAuthorization::class to
        FhirResourcePolymorphicSerializer(RegulatedAuthorizationSerializer),
      RelatedPerson::class to FhirResourcePolymorphicSerializer(RelatedPersonSerializer),
      RequestOrchestration::class to
        FhirResourcePolymorphicSerializer(RequestOrchestrationSerializer),
      Requirements::class to FhirResourcePolymorphicSerializer(RequirementsSerializer),
      ResearchStudy::class to FhirResourcePolymorphicSerializer(ResearchStudySerializer),
      ResearchSubject::class to FhirResourcePolymorphicSerializer(ResearchSubjectSerializer),
      RiskAssessment::class to FhirResourcePolymorphicSerializer(RiskAssessmentSerializer),
      Schedule::class to FhirResourcePolymorphicSerializer(ScheduleSerializer),
      SearchParameter::class to FhirResourcePolymorphicSerializer(SearchParameterSerializer),
      ServiceRequest::class to FhirResourcePolymorphicSerializer(ServiceRequestSerializer),
      Slot::class to FhirResourcePolymorphicSerializer(SlotSerializer),
      Specimen::class to FhirResourcePolymorphicSerializer(SpecimenSerializer),
      SpecimenDefinition::class to FhirResourcePolymorphicSerializer(SpecimenDefinitionSerializer),
      StructureDefinition::class to
        FhirResourcePolymorphicSerializer(StructureDefinitionSerializer),
      StructureMap::class to FhirResourcePolymorphicSerializer(StructureMapSerializer),
      Subscription::class to FhirResourcePolymorphicSerializer(SubscriptionSerializer),
      SubscriptionStatus::class to FhirResourcePolymorphicSerializer(SubscriptionStatusSerializer),
      SubscriptionTopic::class to FhirResourcePolymorphicSerializer(SubscriptionTopicSerializer),
      Substance::class to FhirResourcePolymorphicSerializer(SubstanceSerializer),
      SubstanceDefinition::class to
        FhirResourcePolymorphicSerializer(SubstanceDefinitionSerializer),
      SubstanceNucleicAcid::class to
        FhirResourcePolymorphicSerializer(SubstanceNucleicAcidSerializer),
      SubstancePolymer::class to FhirResourcePolymorphicSerializer(SubstancePolymerSerializer),
      SubstanceProtein::class to FhirResourcePolymorphicSerializer(SubstanceProteinSerializer),
      SubstanceReferenceInformation::class to
        FhirResourcePolymorphicSerializer(SubstanceReferenceInformationSerializer),
      SubstanceSourceMaterial::class to
        FhirResourcePolymorphicSerializer(SubstanceSourceMaterialSerializer),
      SupplyDelivery::class to FhirResourcePolymorphicSerializer(SupplyDeliverySerializer),
      SupplyRequest::class to FhirResourcePolymorphicSerializer(SupplyRequestSerializer),
      Task::class to FhirResourcePolymorphicSerializer(TaskSerializer),
      TerminologyCapabilities::class to
        FhirResourcePolymorphicSerializer(TerminologyCapabilitiesSerializer),
      TestPlan::class to FhirResourcePolymorphicSerializer(TestPlanSerializer),
      TestReport::class to FhirResourcePolymorphicSerializer(TestReportSerializer),
      TestScript::class to FhirResourcePolymorphicSerializer(TestScriptSerializer),
      Transport::class to FhirResourcePolymorphicSerializer(TransportSerializer),
      ValueSet::class to FhirResourcePolymorphicSerializer(ValueSetSerializer),
      VerificationResult::class to FhirResourcePolymorphicSerializer(VerificationResultSerializer),
      VisionPrescription::class to FhirResourcePolymorphicSerializer(VisionPrescriptionSerializer),
    )

  private val byName: Map<String, KSerializer<out Resource>> =
    byClass.values.associateBy { it.descriptor.serialName }

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

  @JvmField
  internal val listSerializer: KSerializer<kotlin.collections.List<Resource>> =
    kotlinx.serialization.builtins.ListSerializer(this)

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
