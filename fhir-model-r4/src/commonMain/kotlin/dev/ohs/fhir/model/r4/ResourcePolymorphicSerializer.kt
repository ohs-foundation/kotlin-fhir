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

import dev.ohs.fhir.model.r4.serializers.AccountSerializer
import dev.ohs.fhir.model.r4.serializers.ActivityDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.AdverseEventSerializer
import dev.ohs.fhir.model.r4.serializers.AllergyIntoleranceSerializer
import dev.ohs.fhir.model.r4.serializers.AppointmentResponseSerializer
import dev.ohs.fhir.model.r4.serializers.AppointmentSerializer
import dev.ohs.fhir.model.r4.serializers.AuditEventSerializer
import dev.ohs.fhir.model.r4.serializers.BasicSerializer
import dev.ohs.fhir.model.r4.serializers.BinarySerializer
import dev.ohs.fhir.model.r4.serializers.BiologicallyDerivedProductSerializer
import dev.ohs.fhir.model.r4.serializers.BodyStructureSerializer
import dev.ohs.fhir.model.r4.serializers.BundleSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementSerializer
import dev.ohs.fhir.model.r4.serializers.CarePlanSerializer
import dev.ohs.fhir.model.r4.serializers.CareTeamSerializer
import dev.ohs.fhir.model.r4.serializers.CatalogEntrySerializer
import dev.ohs.fhir.model.r4.serializers.ChargeItemDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.ChargeItemSerializer
import dev.ohs.fhir.model.r4.serializers.ClaimResponseSerializer
import dev.ohs.fhir.model.r4.serializers.ClaimSerializer
import dev.ohs.fhir.model.r4.serializers.ClinicalImpressionSerializer
import dev.ohs.fhir.model.r4.serializers.CodeSystemSerializer
import dev.ohs.fhir.model.r4.serializers.CommunicationRequestSerializer
import dev.ohs.fhir.model.r4.serializers.CommunicationSerializer
import dev.ohs.fhir.model.r4.serializers.CompartmentDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.CompositionSerializer
import dev.ohs.fhir.model.r4.serializers.ConceptMapSerializer
import dev.ohs.fhir.model.r4.serializers.ConditionSerializer
import dev.ohs.fhir.model.r4.serializers.ConsentSerializer
import dev.ohs.fhir.model.r4.serializers.ContractSerializer
import dev.ohs.fhir.model.r4.serializers.CoverageEligibilityRequestSerializer
import dev.ohs.fhir.model.r4.serializers.CoverageEligibilityResponseSerializer
import dev.ohs.fhir.model.r4.serializers.CoverageSerializer
import dev.ohs.fhir.model.r4.serializers.DetectedIssueSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceMetricSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceRequestSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceUseStatementSerializer
import dev.ohs.fhir.model.r4.serializers.DiagnosticReportSerializer
import dev.ohs.fhir.model.r4.serializers.DocumentManifestSerializer
import dev.ohs.fhir.model.r4.serializers.DocumentReferenceSerializer
import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisSerializer
import dev.ohs.fhir.model.r4.serializers.EncounterSerializer
import dev.ohs.fhir.model.r4.serializers.EndpointSerializer
import dev.ohs.fhir.model.r4.serializers.EnrollmentRequestSerializer
import dev.ohs.fhir.model.r4.serializers.EnrollmentResponseSerializer
import dev.ohs.fhir.model.r4.serializers.EpisodeOfCareSerializer
import dev.ohs.fhir.model.r4.serializers.EventDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.EvidenceSerializer
import dev.ohs.fhir.model.r4.serializers.EvidenceVariableSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioSerializer
import dev.ohs.fhir.model.r4.serializers.ExplanationOfBenefitSerializer
import dev.ohs.fhir.model.r4.serializers.FamilyMemberHistorySerializer
import dev.ohs.fhir.model.r4.serializers.FlagSerializer
import dev.ohs.fhir.model.r4.serializers.GoalSerializer
import dev.ohs.fhir.model.r4.serializers.GraphDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.GroupSerializer
import dev.ohs.fhir.model.r4.serializers.GuidanceResponseSerializer
import dev.ohs.fhir.model.r4.serializers.HealthcareServiceSerializer
import dev.ohs.fhir.model.r4.serializers.ImagingStudySerializer
import dev.ohs.fhir.model.r4.serializers.ImmunizationEvaluationSerializer
import dev.ohs.fhir.model.r4.serializers.ImmunizationRecommendationSerializer
import dev.ohs.fhir.model.r4.serializers.ImmunizationSerializer
import dev.ohs.fhir.model.r4.serializers.ImplementationGuideSerializer
import dev.ohs.fhir.model.r4.serializers.InsurancePlanSerializer
import dev.ohs.fhir.model.r4.serializers.InvoiceSerializer
import dev.ohs.fhir.model.r4.serializers.LibrarySerializer
import dev.ohs.fhir.model.r4.serializers.LinkageSerializer
import dev.ohs.fhir.model.r4.serializers.ListSerializer
import dev.ohs.fhir.model.r4.serializers.LocationSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureReportSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureSerializer
import dev.ohs.fhir.model.r4.serializers.MediaSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationAdministrationSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationDispenseSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationRequestSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationStatementSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductAuthorizationSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductContraindicationSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductIndicationSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductIngredientSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductInteractionSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductManufacturedSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductPackagedSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductPharmaceuticalSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductUndesirableEffectSerializer
import dev.ohs.fhir.model.r4.serializers.MessageDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.MessageHeaderSerializer
import dev.ohs.fhir.model.r4.serializers.MolecularSequenceSerializer
import dev.ohs.fhir.model.r4.serializers.NamingSystemSerializer
import dev.ohs.fhir.model.r4.serializers.NutritionOrderSerializer
import dev.ohs.fhir.model.r4.serializers.ObservationDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.ObservationSerializer
import dev.ohs.fhir.model.r4.serializers.OperationDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.OperationOutcomeSerializer
import dev.ohs.fhir.model.r4.serializers.OrganizationAffiliationSerializer
import dev.ohs.fhir.model.r4.serializers.OrganizationSerializer
import dev.ohs.fhir.model.r4.serializers.ParametersSerializer
import dev.ohs.fhir.model.r4.serializers.PatientSerializer
import dev.ohs.fhir.model.r4.serializers.PaymentNoticeSerializer
import dev.ohs.fhir.model.r4.serializers.PaymentReconciliationSerializer
import dev.ohs.fhir.model.r4.serializers.PersonSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.PractitionerRoleSerializer
import dev.ohs.fhir.model.r4.serializers.PractitionerSerializer
import dev.ohs.fhir.model.r4.serializers.ProcedureSerializer
import dev.ohs.fhir.model.r4.serializers.ProvenanceSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireResponseSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireSerializer
import dev.ohs.fhir.model.r4.serializers.RelatedPersonSerializer
import dev.ohs.fhir.model.r4.serializers.RequestGroupSerializer
import dev.ohs.fhir.model.r4.serializers.ResearchDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.ResearchElementDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.ResearchStudySerializer
import dev.ohs.fhir.model.r4.serializers.ResearchSubjectSerializer
import dev.ohs.fhir.model.r4.serializers.RiskAssessmentSerializer
import dev.ohs.fhir.model.r4.serializers.RiskEvidenceSynthesisSerializer
import dev.ohs.fhir.model.r4.serializers.ScheduleSerializer
import dev.ohs.fhir.model.r4.serializers.SearchParameterSerializer
import dev.ohs.fhir.model.r4.serializers.ServiceRequestSerializer
import dev.ohs.fhir.model.r4.serializers.SlotSerializer
import dev.ohs.fhir.model.r4.serializers.SpecimenDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.SpecimenSerializer
import dev.ohs.fhir.model.r4.serializers.StructureDefinitionSerializer
import dev.ohs.fhir.model.r4.serializers.StructureMapSerializer
import dev.ohs.fhir.model.r4.serializers.SubscriptionSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceNucleicAcidSerializer
import dev.ohs.fhir.model.r4.serializers.SubstancePolymerSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceProteinSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceReferenceInformationSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSpecificationSerializer
import dev.ohs.fhir.model.r4.serializers.SupplyDeliverySerializer
import dev.ohs.fhir.model.r4.serializers.SupplyRequestSerializer
import dev.ohs.fhir.model.r4.serializers.TaskSerializer
import dev.ohs.fhir.model.r4.serializers.TerminologyCapabilitiesSerializer
import dev.ohs.fhir.model.r4.serializers.TestReportSerializer
import dev.ohs.fhir.model.r4.serializers.TestScriptSerializer
import dev.ohs.fhir.model.r4.serializers.ValueSetSerializer
import dev.ohs.fhir.model.r4.serializers.VerificationResultSerializer
import dev.ohs.fhir.model.r4.serializers.VisionPrescriptionSerializer
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
      Claim::class to FhirResourcePolymorphicSerializer(ClaimSerializer),
      ClaimResponse::class to FhirResourcePolymorphicSerializer(ClaimResponseSerializer),
      ClinicalImpression::class to FhirResourcePolymorphicSerializer(ClinicalImpressionSerializer),
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
      EffectEvidenceSynthesis::class to
        FhirResourcePolymorphicSerializer(EffectEvidenceSynthesisSerializer),
      Encounter::class to FhirResourcePolymorphicSerializer(EncounterSerializer),
      Endpoint::class to FhirResourcePolymorphicSerializer(EndpointSerializer),
      EnrollmentRequest::class to FhirResourcePolymorphicSerializer(EnrollmentRequestSerializer),
      EnrollmentResponse::class to FhirResourcePolymorphicSerializer(EnrollmentResponseSerializer),
      EpisodeOfCare::class to FhirResourcePolymorphicSerializer(EpisodeOfCareSerializer),
      EventDefinition::class to FhirResourcePolymorphicSerializer(EventDefinitionSerializer),
      Evidence::class to FhirResourcePolymorphicSerializer(EvidenceSerializer),
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
      InsurancePlan::class to FhirResourcePolymorphicSerializer(InsurancePlanSerializer),
      Invoice::class to FhirResourcePolymorphicSerializer(InvoiceSerializer),
      Library::class to FhirResourcePolymorphicSerializer(LibrarySerializer),
      Linkage::class to FhirResourcePolymorphicSerializer(LinkageSerializer),
      List::class to FhirResourcePolymorphicSerializer(ListSerializer),
      Location::class to FhirResourcePolymorphicSerializer(LocationSerializer),
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
      MedicinalProduct::class to FhirResourcePolymorphicSerializer(MedicinalProductSerializer),
      MedicinalProductAuthorization::class to
        FhirResourcePolymorphicSerializer(MedicinalProductAuthorizationSerializer),
      MedicinalProductContraindication::class to
        FhirResourcePolymorphicSerializer(MedicinalProductContraindicationSerializer),
      MedicinalProductIndication::class to
        FhirResourcePolymorphicSerializer(MedicinalProductIndicationSerializer),
      MedicinalProductIngredient::class to
        FhirResourcePolymorphicSerializer(MedicinalProductIngredientSerializer),
      MedicinalProductInteraction::class to
        FhirResourcePolymorphicSerializer(MedicinalProductInteractionSerializer),
      MedicinalProductManufactured::class to
        FhirResourcePolymorphicSerializer(MedicinalProductManufacturedSerializer),
      MedicinalProductPackaged::class to
        FhirResourcePolymorphicSerializer(MedicinalProductPackagedSerializer),
      MedicinalProductPharmaceutical::class to
        FhirResourcePolymorphicSerializer(MedicinalProductPharmaceuticalSerializer),
      MedicinalProductUndesirableEffect::class to
        FhirResourcePolymorphicSerializer(MedicinalProductUndesirableEffectSerializer),
      MessageDefinition::class to FhirResourcePolymorphicSerializer(MessageDefinitionSerializer),
      MessageHeader::class to FhirResourcePolymorphicSerializer(MessageHeaderSerializer),
      MolecularSequence::class to FhirResourcePolymorphicSerializer(MolecularSequenceSerializer),
      NamingSystem::class to FhirResourcePolymorphicSerializer(NamingSystemSerializer),
      NutritionOrder::class to FhirResourcePolymorphicSerializer(NutritionOrderSerializer),
      Observation::class to FhirResourcePolymorphicSerializer(ObservationSerializer),
      ObservationDefinition::class to
        FhirResourcePolymorphicSerializer(ObservationDefinitionSerializer),
      OperationDefinition::class to
        FhirResourcePolymorphicSerializer(OperationDefinitionSerializer),
      OperationOutcome::class to FhirResourcePolymorphicSerializer(OperationOutcomeSerializer),
      Organization::class to FhirResourcePolymorphicSerializer(OrganizationSerializer),
      OrganizationAffiliation::class to
        FhirResourcePolymorphicSerializer(OrganizationAffiliationSerializer),
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
      RelatedPerson::class to FhirResourcePolymorphicSerializer(RelatedPersonSerializer),
      RequestGroup::class to FhirResourcePolymorphicSerializer(RequestGroupSerializer),
      ResearchDefinition::class to FhirResourcePolymorphicSerializer(ResearchDefinitionSerializer),
      ResearchElementDefinition::class to
        FhirResourcePolymorphicSerializer(ResearchElementDefinitionSerializer),
      ResearchStudy::class to FhirResourcePolymorphicSerializer(ResearchStudySerializer),
      ResearchSubject::class to FhirResourcePolymorphicSerializer(ResearchSubjectSerializer),
      RiskAssessment::class to FhirResourcePolymorphicSerializer(RiskAssessmentSerializer),
      RiskEvidenceSynthesis::class to
        FhirResourcePolymorphicSerializer(RiskEvidenceSynthesisSerializer),
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
      Substance::class to FhirResourcePolymorphicSerializer(SubstanceSerializer),
      SubstanceNucleicAcid::class to
        FhirResourcePolymorphicSerializer(SubstanceNucleicAcidSerializer),
      SubstancePolymer::class to FhirResourcePolymorphicSerializer(SubstancePolymerSerializer),
      SubstanceProtein::class to FhirResourcePolymorphicSerializer(SubstanceProteinSerializer),
      SubstanceReferenceInformation::class to
        FhirResourcePolymorphicSerializer(SubstanceReferenceInformationSerializer),
      SubstanceSourceMaterial::class to
        FhirResourcePolymorphicSerializer(SubstanceSourceMaterialSerializer),
      SubstanceSpecification::class to
        FhirResourcePolymorphicSerializer(SubstanceSpecificationSerializer),
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
