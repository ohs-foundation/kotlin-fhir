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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.AccountSerializer
import dev.ohs.fhir.model.r4b.serializers.ActivityDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.AdministrableProductDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.AdverseEventSerializer
import dev.ohs.fhir.model.r4b.serializers.AllergyIntoleranceSerializer
import dev.ohs.fhir.model.r4b.serializers.AppointmentResponseSerializer
import dev.ohs.fhir.model.r4b.serializers.AppointmentSerializer
import dev.ohs.fhir.model.r4b.serializers.AuditEventSerializer
import dev.ohs.fhir.model.r4b.serializers.BasicSerializer
import dev.ohs.fhir.model.r4b.serializers.BinarySerializer
import dev.ohs.fhir.model.r4b.serializers.BiologicallyDerivedProductSerializer
import dev.ohs.fhir.model.r4b.serializers.BodyStructureSerializer
import dev.ohs.fhir.model.r4b.serializers.BundleSerializer
import dev.ohs.fhir.model.r4b.serializers.CapabilityStatementSerializer
import dev.ohs.fhir.model.r4b.serializers.CarePlanSerializer
import dev.ohs.fhir.model.r4b.serializers.CareTeamSerializer
import dev.ohs.fhir.model.r4b.serializers.CatalogEntrySerializer
import dev.ohs.fhir.model.r4b.serializers.ChargeItemDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.ChargeItemSerializer
import dev.ohs.fhir.model.r4b.serializers.CitationSerializer
import dev.ohs.fhir.model.r4b.serializers.ClaimResponseSerializer
import dev.ohs.fhir.model.r4b.serializers.ClaimSerializer
import dev.ohs.fhir.model.r4b.serializers.ClinicalImpressionSerializer
import dev.ohs.fhir.model.r4b.serializers.ClinicalUseDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.CodeSystemSerializer
import dev.ohs.fhir.model.r4b.serializers.CommunicationRequestSerializer
import dev.ohs.fhir.model.r4b.serializers.CommunicationSerializer
import dev.ohs.fhir.model.r4b.serializers.CompartmentDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.CompositionSerializer
import dev.ohs.fhir.model.r4b.serializers.ConceptMapSerializer
import dev.ohs.fhir.model.r4b.serializers.ConditionSerializer
import dev.ohs.fhir.model.r4b.serializers.ConsentSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractSerializer
import dev.ohs.fhir.model.r4b.serializers.CoverageEligibilityRequestSerializer
import dev.ohs.fhir.model.r4b.serializers.CoverageEligibilityResponseSerializer
import dev.ohs.fhir.model.r4b.serializers.CoverageSerializer
import dev.ohs.fhir.model.r4b.serializers.DetectedIssueSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceMetricSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceRequestSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceUseStatementSerializer
import dev.ohs.fhir.model.r4b.serializers.DiagnosticReportSerializer
import dev.ohs.fhir.model.r4b.serializers.DocumentManifestSerializer
import dev.ohs.fhir.model.r4b.serializers.DocumentReferenceSerializer
import dev.ohs.fhir.model.r4b.serializers.EncounterSerializer
import dev.ohs.fhir.model.r4b.serializers.EndpointSerializer
import dev.ohs.fhir.model.r4b.serializers.EnrollmentRequestSerializer
import dev.ohs.fhir.model.r4b.serializers.EnrollmentResponseSerializer
import dev.ohs.fhir.model.r4b.serializers.EpisodeOfCareSerializer
import dev.ohs.fhir.model.r4b.serializers.EventDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.EvidenceReportSerializer
import dev.ohs.fhir.model.r4b.serializers.EvidenceSerializer
import dev.ohs.fhir.model.r4b.serializers.EvidenceVariableSerializer
import dev.ohs.fhir.model.r4b.serializers.ExampleScenarioSerializer
import dev.ohs.fhir.model.r4b.serializers.ExplanationOfBenefitSerializer
import dev.ohs.fhir.model.r4b.serializers.FamilyMemberHistorySerializer
import dev.ohs.fhir.model.r4b.serializers.FlagSerializer
import dev.ohs.fhir.model.r4b.serializers.GoalSerializer
import dev.ohs.fhir.model.r4b.serializers.GraphDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.GroupSerializer
import dev.ohs.fhir.model.r4b.serializers.GuidanceResponseSerializer
import dev.ohs.fhir.model.r4b.serializers.HealthcareServiceSerializer
import dev.ohs.fhir.model.r4b.serializers.ImagingStudySerializer
import dev.ohs.fhir.model.r4b.serializers.ImmunizationEvaluationSerializer
import dev.ohs.fhir.model.r4b.serializers.ImmunizationRecommendationSerializer
import dev.ohs.fhir.model.r4b.serializers.ImmunizationSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideSerializer
import dev.ohs.fhir.model.r4b.serializers.IngredientSerializer
import dev.ohs.fhir.model.r4b.serializers.InsurancePlanSerializer
import dev.ohs.fhir.model.r4b.serializers.InvoiceSerializer
import dev.ohs.fhir.model.r4b.serializers.LibrarySerializer
import dev.ohs.fhir.model.r4b.serializers.LinkageSerializer
import dev.ohs.fhir.model.r4b.serializers.ListSerializer
import dev.ohs.fhir.model.r4b.serializers.LocationSerializer
import dev.ohs.fhir.model.r4b.serializers.ManufacturedItemDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.MeasureReportSerializer
import dev.ohs.fhir.model.r4b.serializers.MeasureSerializer
import dev.ohs.fhir.model.r4b.serializers.MediaSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationAdministrationSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationDispenseSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationKnowledgeSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationRequestSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationStatementSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.MessageDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.MessageHeaderSerializer
import dev.ohs.fhir.model.r4b.serializers.MolecularSequenceSerializer
import dev.ohs.fhir.model.r4b.serializers.NamingSystemSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionOrderSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionProductSerializer
import dev.ohs.fhir.model.r4b.serializers.ObservationDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.ObservationSerializer
import dev.ohs.fhir.model.r4b.serializers.OperationDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.OperationOutcomeSerializer
import dev.ohs.fhir.model.r4b.serializers.OrganizationAffiliationSerializer
import dev.ohs.fhir.model.r4b.serializers.OrganizationSerializer
import dev.ohs.fhir.model.r4b.serializers.PackagedProductDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.ParametersSerializer
import dev.ohs.fhir.model.r4b.serializers.PatientSerializer
import dev.ohs.fhir.model.r4b.serializers.PaymentNoticeSerializer
import dev.ohs.fhir.model.r4b.serializers.PaymentReconciliationSerializer
import dev.ohs.fhir.model.r4b.serializers.PersonSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.PractitionerRoleSerializer
import dev.ohs.fhir.model.r4b.serializers.PractitionerSerializer
import dev.ohs.fhir.model.r4b.serializers.ProcedureSerializer
import dev.ohs.fhir.model.r4b.serializers.ProvenanceSerializer
import dev.ohs.fhir.model.r4b.serializers.QuestionnaireResponseSerializer
import dev.ohs.fhir.model.r4b.serializers.QuestionnaireSerializer
import dev.ohs.fhir.model.r4b.serializers.RegulatedAuthorizationSerializer
import dev.ohs.fhir.model.r4b.serializers.RelatedPersonSerializer
import dev.ohs.fhir.model.r4b.serializers.RequestGroupSerializer
import dev.ohs.fhir.model.r4b.serializers.ResearchDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.ResearchElementDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.ResearchStudySerializer
import dev.ohs.fhir.model.r4b.serializers.ResearchSubjectSerializer
import dev.ohs.fhir.model.r4b.serializers.RiskAssessmentSerializer
import dev.ohs.fhir.model.r4b.serializers.ScheduleSerializer
import dev.ohs.fhir.model.r4b.serializers.SearchParameterSerializer
import dev.ohs.fhir.model.r4b.serializers.ServiceRequestSerializer
import dev.ohs.fhir.model.r4b.serializers.SlotSerializer
import dev.ohs.fhir.model.r4b.serializers.SpecimenDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.SpecimenSerializer
import dev.ohs.fhir.model.r4b.serializers.StructureDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.StructureMapSerializer
import dev.ohs.fhir.model.r4b.serializers.SubscriptionSerializer
import dev.ohs.fhir.model.r4b.serializers.SubscriptionStatusSerializer
import dev.ohs.fhir.model.r4b.serializers.SubscriptionTopicSerializer
import dev.ohs.fhir.model.r4b.serializers.SubstanceDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.SubstanceSerializer
import dev.ohs.fhir.model.r4b.serializers.SupplyDeliverySerializer
import dev.ohs.fhir.model.r4b.serializers.SupplyRequestSerializer
import dev.ohs.fhir.model.r4b.serializers.TaskSerializer
import dev.ohs.fhir.model.r4b.serializers.TerminologyCapabilitiesSerializer
import dev.ohs.fhir.model.r4b.serializers.TestReportSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptSerializer
import dev.ohs.fhir.model.r4b.serializers.ValueSetSerializer
import dev.ohs.fhir.model.r4b.serializers.VerificationResultSerializer
import dev.ohs.fhir.model.r4b.serializers.VisionPrescriptionSerializer
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.collections.associateBy
import kotlin.collections.mapOf
import kotlin.reflect.KClass
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
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

internal interface FhirResourceSerializer<T : Resource> : KSerializer<T> {
  public fun buildDescriptor(b: ClassSerialDescriptorBuilder)

  public fun buildResourceDescriptor(serialName: String): SerialDescriptor =
    buildClassSerialDescriptor(serialName) {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  public fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): T

  public fun serializeInternal(
    encoder: CompositeEncoder,
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
      AdministrableProductDefinition::class to
        FhirResourcePolymorphicSerializer(AdministrableProductDefinitionSerializer),
      AdverseEvent::class to FhirResourcePolymorphicSerializer(AdverseEventSerializer),
      AllergyIntolerance::class to FhirResourcePolymorphicSerializer(AllergyIntoleranceSerializer),
      Appointment::class to FhirResourcePolymorphicSerializer(AppointmentSerializer),
      AppointmentResponse::class to
        FhirResourcePolymorphicSerializer(AppointmentResponseSerializer),
      AuditEvent::class to FhirResourcePolymorphicSerializer(AuditEventSerializer),
      Basic::class to FhirResourcePolymorphicSerializer(BasicSerializer),
      Binary::class to FhirResourcePolymorphicSerializer(BinarySerializer),
      BiologicallyDerivedProduct::class to
        FhirResourcePolymorphicSerializer(BiologicallyDerivedProductSerializer),
      BodyStructure::class to FhirResourcePolymorphicSerializer(BodyStructureSerializer),
      Bundle::class to FhirResourcePolymorphicSerializer(BundleSerializer),
      CapabilityStatement::class to
        FhirResourcePolymorphicSerializer(CapabilityStatementSerializer),
      CarePlan::class to FhirResourcePolymorphicSerializer(CarePlanSerializer),
      CareTeam::class to FhirResourcePolymorphicSerializer(CareTeamSerializer),
      CatalogEntry::class to FhirResourcePolymorphicSerializer(CatalogEntrySerializer),
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
      Consent::class to FhirResourcePolymorphicSerializer(ConsentSerializer),
      Contract::class to FhirResourcePolymorphicSerializer(ContractSerializer),
      Coverage::class to FhirResourcePolymorphicSerializer(CoverageSerializer),
      CoverageEligibilityRequest::class to
        FhirResourcePolymorphicSerializer(CoverageEligibilityRequestSerializer),
      CoverageEligibilityResponse::class to
        FhirResourcePolymorphicSerializer(CoverageEligibilityResponseSerializer),
      DetectedIssue::class to FhirResourcePolymorphicSerializer(DetectedIssueSerializer),
      Device::class to FhirResourcePolymorphicSerializer(DeviceSerializer),
      DeviceDefinition::class to FhirResourcePolymorphicSerializer(DeviceDefinitionSerializer),
      DeviceMetric::class to FhirResourcePolymorphicSerializer(DeviceMetricSerializer),
      DeviceRequest::class to FhirResourcePolymorphicSerializer(DeviceRequestSerializer),
      DeviceUseStatement::class to FhirResourcePolymorphicSerializer(DeviceUseStatementSerializer),
      DiagnosticReport::class to FhirResourcePolymorphicSerializer(DiagnosticReportSerializer),
      DocumentManifest::class to FhirResourcePolymorphicSerializer(DocumentManifestSerializer),
      DocumentReference::class to FhirResourcePolymorphicSerializer(DocumentReferenceSerializer),
      Encounter::class to FhirResourcePolymorphicSerializer(EncounterSerializer),
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
      Goal::class to FhirResourcePolymorphicSerializer(GoalSerializer),
      GraphDefinition::class to FhirResourcePolymorphicSerializer(GraphDefinitionSerializer),
      Group::class to FhirResourcePolymorphicSerializer(GroupSerializer),
      GuidanceResponse::class to FhirResourcePolymorphicSerializer(GuidanceResponseSerializer),
      HealthcareService::class to FhirResourcePolymorphicSerializer(HealthcareServiceSerializer),
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
      Invoice::class to FhirResourcePolymorphicSerializer(InvoiceSerializer),
      Library::class to FhirResourcePolymorphicSerializer(LibrarySerializer),
      Linkage::class to FhirResourcePolymorphicSerializer(LinkageSerializer),
      List::class to FhirResourcePolymorphicSerializer(ListSerializer),
      Location::class to FhirResourcePolymorphicSerializer(LocationSerializer),
      ManufacturedItemDefinition::class to
        FhirResourcePolymorphicSerializer(ManufacturedItemDefinitionSerializer),
      Measure::class to FhirResourcePolymorphicSerializer(MeasureSerializer),
      MeasureReport::class to FhirResourcePolymorphicSerializer(MeasureReportSerializer),
      Media::class to FhirResourcePolymorphicSerializer(MediaSerializer),
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
      RequestGroup::class to FhirResourcePolymorphicSerializer(RequestGroupSerializer),
      ResearchDefinition::class to FhirResourcePolymorphicSerializer(ResearchDefinitionSerializer),
      ResearchElementDefinition::class to
        FhirResourcePolymorphicSerializer(ResearchElementDefinitionSerializer),
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
      SupplyDelivery::class to FhirResourcePolymorphicSerializer(SupplyDeliverySerializer),
      SupplyRequest::class to FhirResourcePolymorphicSerializer(SupplyRequestSerializer),
      Task::class to FhirResourcePolymorphicSerializer(TaskSerializer),
      TerminologyCapabilities::class to
        FhirResourcePolymorphicSerializer(TerminologyCapabilitiesSerializer),
      TestReport::class to FhirResourcePolymorphicSerializer(TestReportSerializer),
      TestScript::class to FhirResourcePolymorphicSerializer(TestScriptSerializer),
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
