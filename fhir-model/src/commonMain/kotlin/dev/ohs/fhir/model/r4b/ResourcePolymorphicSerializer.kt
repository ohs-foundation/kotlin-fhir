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
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.`internal`.StreamingJsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

internal object ResourcePolymorphicSerializer : KSerializer<Resource> {
  @OptIn(ExperimentalSerializationApi::class, InternalSerializationApi::class)
  override val descriptor: SerialDescriptor =
    buildSerialDescriptor("Resource", PolymorphicKind.SEALED)

  /**
   * Discriminator-only descriptor: `{ resourceType: String }`. Used on the streaming fast path to
   * open the JSON object and advance past the leading discriminator; the concrete subclass
   * continues the loop against its own flat-shape descriptor.
   */
  private val discriminatorDescriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
      element("resourceType", String.serializer().descriptor)
    }

  override fun serialize(encoder: Encoder, `value`: Resource) {
    when (value) {
      is Account -> AccountSerializer.serialize(encoder, value)
      is ActivityDefinition -> ActivityDefinitionSerializer.serialize(encoder, value)
      is AdministrableProductDefinition ->
        AdministrableProductDefinitionSerializer.serialize(encoder, value)
      is AdverseEvent -> AdverseEventSerializer.serialize(encoder, value)
      is AllergyIntolerance -> AllergyIntoleranceSerializer.serialize(encoder, value)
      is Appointment -> AppointmentSerializer.serialize(encoder, value)
      is AppointmentResponse -> AppointmentResponseSerializer.serialize(encoder, value)
      is AuditEvent -> AuditEventSerializer.serialize(encoder, value)
      is Basic -> BasicSerializer.serialize(encoder, value)
      is Binary -> BinarySerializer.serialize(encoder, value)
      is BiologicallyDerivedProduct ->
        BiologicallyDerivedProductSerializer.serialize(encoder, value)
      is BodyStructure -> BodyStructureSerializer.serialize(encoder, value)
      is Bundle -> BundleSerializer.serialize(encoder, value)
      is CapabilityStatement -> CapabilityStatementSerializer.serialize(encoder, value)
      is CarePlan -> CarePlanSerializer.serialize(encoder, value)
      is CareTeam -> CareTeamSerializer.serialize(encoder, value)
      is CatalogEntry -> CatalogEntrySerializer.serialize(encoder, value)
      is ChargeItem -> ChargeItemSerializer.serialize(encoder, value)
      is ChargeItemDefinition -> ChargeItemDefinitionSerializer.serialize(encoder, value)
      is Citation -> CitationSerializer.serialize(encoder, value)
      is Claim -> ClaimSerializer.serialize(encoder, value)
      is ClaimResponse -> ClaimResponseSerializer.serialize(encoder, value)
      is ClinicalImpression -> ClinicalImpressionSerializer.serialize(encoder, value)
      is ClinicalUseDefinition -> ClinicalUseDefinitionSerializer.serialize(encoder, value)
      is CodeSystem -> CodeSystemSerializer.serialize(encoder, value)
      is Communication -> CommunicationSerializer.serialize(encoder, value)
      is CommunicationRequest -> CommunicationRequestSerializer.serialize(encoder, value)
      is CompartmentDefinition -> CompartmentDefinitionSerializer.serialize(encoder, value)
      is Composition -> CompositionSerializer.serialize(encoder, value)
      is ConceptMap -> ConceptMapSerializer.serialize(encoder, value)
      is Condition -> ConditionSerializer.serialize(encoder, value)
      is Consent -> ConsentSerializer.serialize(encoder, value)
      is Contract -> ContractSerializer.serialize(encoder, value)
      is Coverage -> CoverageSerializer.serialize(encoder, value)
      is CoverageEligibilityRequest ->
        CoverageEligibilityRequestSerializer.serialize(encoder, value)
      is CoverageEligibilityResponse ->
        CoverageEligibilityResponseSerializer.serialize(encoder, value)
      is DetectedIssue -> DetectedIssueSerializer.serialize(encoder, value)
      is Device -> DeviceSerializer.serialize(encoder, value)
      is DeviceDefinition -> DeviceDefinitionSerializer.serialize(encoder, value)
      is DeviceMetric -> DeviceMetricSerializer.serialize(encoder, value)
      is DeviceRequest -> DeviceRequestSerializer.serialize(encoder, value)
      is DeviceUseStatement -> DeviceUseStatementSerializer.serialize(encoder, value)
      is DiagnosticReport -> DiagnosticReportSerializer.serialize(encoder, value)
      is DocumentManifest -> DocumentManifestSerializer.serialize(encoder, value)
      is DocumentReference -> DocumentReferenceSerializer.serialize(encoder, value)
      is Encounter -> EncounterSerializer.serialize(encoder, value)
      is Endpoint -> EndpointSerializer.serialize(encoder, value)
      is EnrollmentRequest -> EnrollmentRequestSerializer.serialize(encoder, value)
      is EnrollmentResponse -> EnrollmentResponseSerializer.serialize(encoder, value)
      is EpisodeOfCare -> EpisodeOfCareSerializer.serialize(encoder, value)
      is EventDefinition -> EventDefinitionSerializer.serialize(encoder, value)
      is Evidence -> EvidenceSerializer.serialize(encoder, value)
      is EvidenceReport -> EvidenceReportSerializer.serialize(encoder, value)
      is EvidenceVariable -> EvidenceVariableSerializer.serialize(encoder, value)
      is ExampleScenario -> ExampleScenarioSerializer.serialize(encoder, value)
      is ExplanationOfBenefit -> ExplanationOfBenefitSerializer.serialize(encoder, value)
      is FamilyMemberHistory -> FamilyMemberHistorySerializer.serialize(encoder, value)
      is Flag -> FlagSerializer.serialize(encoder, value)
      is Goal -> GoalSerializer.serialize(encoder, value)
      is GraphDefinition -> GraphDefinitionSerializer.serialize(encoder, value)
      is Group -> GroupSerializer.serialize(encoder, value)
      is GuidanceResponse -> GuidanceResponseSerializer.serialize(encoder, value)
      is HealthcareService -> HealthcareServiceSerializer.serialize(encoder, value)
      is ImagingStudy -> ImagingStudySerializer.serialize(encoder, value)
      is Immunization -> ImmunizationSerializer.serialize(encoder, value)
      is ImmunizationEvaluation -> ImmunizationEvaluationSerializer.serialize(encoder, value)
      is ImmunizationRecommendation ->
        ImmunizationRecommendationSerializer.serialize(encoder, value)
      is ImplementationGuide -> ImplementationGuideSerializer.serialize(encoder, value)
      is Ingredient -> IngredientSerializer.serialize(encoder, value)
      is InsurancePlan -> InsurancePlanSerializer.serialize(encoder, value)
      is Invoice -> InvoiceSerializer.serialize(encoder, value)
      is Library -> LibrarySerializer.serialize(encoder, value)
      is Linkage -> LinkageSerializer.serialize(encoder, value)
      is List -> ListSerializer.serialize(encoder, value)
      is Location -> LocationSerializer.serialize(encoder, value)
      is ManufacturedItemDefinition ->
        ManufacturedItemDefinitionSerializer.serialize(encoder, value)
      is Measure -> MeasureSerializer.serialize(encoder, value)
      is MeasureReport -> MeasureReportSerializer.serialize(encoder, value)
      is Media -> MediaSerializer.serialize(encoder, value)
      is Medication -> MedicationSerializer.serialize(encoder, value)
      is MedicationAdministration -> MedicationAdministrationSerializer.serialize(encoder, value)
      is MedicationDispense -> MedicationDispenseSerializer.serialize(encoder, value)
      is MedicationKnowledge -> MedicationKnowledgeSerializer.serialize(encoder, value)
      is MedicationRequest -> MedicationRequestSerializer.serialize(encoder, value)
      is MedicationStatement -> MedicationStatementSerializer.serialize(encoder, value)
      is MedicinalProductDefinition ->
        MedicinalProductDefinitionSerializer.serialize(encoder, value)
      is MessageDefinition -> MessageDefinitionSerializer.serialize(encoder, value)
      is MessageHeader -> MessageHeaderSerializer.serialize(encoder, value)
      is MolecularSequence -> MolecularSequenceSerializer.serialize(encoder, value)
      is NamingSystem -> NamingSystemSerializer.serialize(encoder, value)
      is NutritionOrder -> NutritionOrderSerializer.serialize(encoder, value)
      is NutritionProduct -> NutritionProductSerializer.serialize(encoder, value)
      is Observation -> ObservationSerializer.serialize(encoder, value)
      is ObservationDefinition -> ObservationDefinitionSerializer.serialize(encoder, value)
      is OperationDefinition -> OperationDefinitionSerializer.serialize(encoder, value)
      is OperationOutcome -> OperationOutcomeSerializer.serialize(encoder, value)
      is Organization -> OrganizationSerializer.serialize(encoder, value)
      is OrganizationAffiliation -> OrganizationAffiliationSerializer.serialize(encoder, value)
      is PackagedProductDefinition -> PackagedProductDefinitionSerializer.serialize(encoder, value)
      is Parameters -> ParametersSerializer.serialize(encoder, value)
      is Patient -> PatientSerializer.serialize(encoder, value)
      is PaymentNotice -> PaymentNoticeSerializer.serialize(encoder, value)
      is PaymentReconciliation -> PaymentReconciliationSerializer.serialize(encoder, value)
      is Person -> PersonSerializer.serialize(encoder, value)
      is PlanDefinition -> PlanDefinitionSerializer.serialize(encoder, value)
      is Practitioner -> PractitionerSerializer.serialize(encoder, value)
      is PractitionerRole -> PractitionerRoleSerializer.serialize(encoder, value)
      is Procedure -> ProcedureSerializer.serialize(encoder, value)
      is Provenance -> ProvenanceSerializer.serialize(encoder, value)
      is Questionnaire -> QuestionnaireSerializer.serialize(encoder, value)
      is QuestionnaireResponse -> QuestionnaireResponseSerializer.serialize(encoder, value)
      is RegulatedAuthorization -> RegulatedAuthorizationSerializer.serialize(encoder, value)
      is RelatedPerson -> RelatedPersonSerializer.serialize(encoder, value)
      is RequestGroup -> RequestGroupSerializer.serialize(encoder, value)
      is ResearchDefinition -> ResearchDefinitionSerializer.serialize(encoder, value)
      is ResearchElementDefinition -> ResearchElementDefinitionSerializer.serialize(encoder, value)
      is ResearchStudy -> ResearchStudySerializer.serialize(encoder, value)
      is ResearchSubject -> ResearchSubjectSerializer.serialize(encoder, value)
      is RiskAssessment -> RiskAssessmentSerializer.serialize(encoder, value)
      is Schedule -> ScheduleSerializer.serialize(encoder, value)
      is SearchParameter -> SearchParameterSerializer.serialize(encoder, value)
      is ServiceRequest -> ServiceRequestSerializer.serialize(encoder, value)
      is Slot -> SlotSerializer.serialize(encoder, value)
      is Specimen -> SpecimenSerializer.serialize(encoder, value)
      is SpecimenDefinition -> SpecimenDefinitionSerializer.serialize(encoder, value)
      is StructureDefinition -> StructureDefinitionSerializer.serialize(encoder, value)
      is StructureMap -> StructureMapSerializer.serialize(encoder, value)
      is Subscription -> SubscriptionSerializer.serialize(encoder, value)
      is SubscriptionStatus -> SubscriptionStatusSerializer.serialize(encoder, value)
      is SubscriptionTopic -> SubscriptionTopicSerializer.serialize(encoder, value)
      is Substance -> SubstanceSerializer.serialize(encoder, value)
      is SubstanceDefinition -> SubstanceDefinitionSerializer.serialize(encoder, value)
      is SupplyDelivery -> SupplyDeliverySerializer.serialize(encoder, value)
      is SupplyRequest -> SupplyRequestSerializer.serialize(encoder, value)
      is Task -> TaskSerializer.serialize(encoder, value)
      is TerminologyCapabilities -> TerminologyCapabilitiesSerializer.serialize(encoder, value)
      is TestReport -> TestReportSerializer.serialize(encoder, value)
      is TestScript -> TestScriptSerializer.serialize(encoder, value)
      is ValueSet -> ValueSetSerializer.serialize(encoder, value)
      is VerificationResult -> VerificationResultSerializer.serialize(encoder, value)
      is VisionPrescription -> VisionPrescriptionSerializer.serialize(encoder, value)
      else ->
        throw SerializationException("""Unknown Resource subtype ${value::class.simpleName}""")
    }
  }

  override fun deserialize(decoder: Decoder): Resource {
    val jd = decoder as JsonDecoder
    // Streaming fast path: when the decoder is kotlinx's StreamingJsonDecoder, use its
    // internal lexer's `peekLeadingMatchingValue` to read the discriminator without
    // consuming state. Returns null if `resourceType` isn't the first key — falls through
    // to the tree path.
    val peeked: String? =
      if (jd is StreamingJsonDecoder) {
        jd.lexer.peekLeadingMatchingValue("resourceType", jd.json.configuration.isLenient)
      } else null
    if (peeked != null) {
      val composite = jd.beginStructure(discriminatorDescriptor)
      // Advance the lexer past `resourceType` before dispatching to the concrete's loop.
      composite.decodeElementIndex(discriminatorDescriptor)
      composite.decodeStringElement(discriminatorDescriptor, 0)
      val result: Resource =
        when (peeked) {
          "Account" -> AccountSerializer.deserializeJson(composite)
          "ActivityDefinition" -> ActivityDefinitionSerializer.deserializeJson(composite)
          "AdministrableProductDefinition" ->
            AdministrableProductDefinitionSerializer.deserializeJson(composite)
          "AdverseEvent" -> AdverseEventSerializer.deserializeJson(composite)
          "AllergyIntolerance" -> AllergyIntoleranceSerializer.deserializeJson(composite)
          "Appointment" -> AppointmentSerializer.deserializeJson(composite)
          "AppointmentResponse" -> AppointmentResponseSerializer.deserializeJson(composite)
          "AuditEvent" -> AuditEventSerializer.deserializeJson(composite)
          "Basic" -> BasicSerializer.deserializeJson(composite)
          "Binary" -> BinarySerializer.deserializeJson(composite)
          "BiologicallyDerivedProduct" ->
            BiologicallyDerivedProductSerializer.deserializeJson(composite)
          "BodyStructure" -> BodyStructureSerializer.deserializeJson(composite)
          "Bundle" -> BundleSerializer.deserializeJson(composite)
          "CapabilityStatement" -> CapabilityStatementSerializer.deserializeJson(composite)
          "CarePlan" -> CarePlanSerializer.deserializeJson(composite)
          "CareTeam" -> CareTeamSerializer.deserializeJson(composite)
          "CatalogEntry" -> CatalogEntrySerializer.deserializeJson(composite)
          "ChargeItem" -> ChargeItemSerializer.deserializeJson(composite)
          "ChargeItemDefinition" -> ChargeItemDefinitionSerializer.deserializeJson(composite)
          "Citation" -> CitationSerializer.deserializeJson(composite)
          "Claim" -> ClaimSerializer.deserializeJson(composite)
          "ClaimResponse" -> ClaimResponseSerializer.deserializeJson(composite)
          "ClinicalImpression" -> ClinicalImpressionSerializer.deserializeJson(composite)
          "ClinicalUseDefinition" -> ClinicalUseDefinitionSerializer.deserializeJson(composite)
          "CodeSystem" -> CodeSystemSerializer.deserializeJson(composite)
          "Communication" -> CommunicationSerializer.deserializeJson(composite)
          "CommunicationRequest" -> CommunicationRequestSerializer.deserializeJson(composite)
          "CompartmentDefinition" -> CompartmentDefinitionSerializer.deserializeJson(composite)
          "Composition" -> CompositionSerializer.deserializeJson(composite)
          "ConceptMap" -> ConceptMapSerializer.deserializeJson(composite)
          "Condition" -> ConditionSerializer.deserializeJson(composite)
          "Consent" -> ConsentSerializer.deserializeJson(composite)
          "Contract" -> ContractSerializer.deserializeJson(composite)
          "Coverage" -> CoverageSerializer.deserializeJson(composite)
          "CoverageEligibilityRequest" ->
            CoverageEligibilityRequestSerializer.deserializeJson(composite)
          "CoverageEligibilityResponse" ->
            CoverageEligibilityResponseSerializer.deserializeJson(composite)
          "DetectedIssue" -> DetectedIssueSerializer.deserializeJson(composite)
          "Device" -> DeviceSerializer.deserializeJson(composite)
          "DeviceDefinition" -> DeviceDefinitionSerializer.deserializeJson(composite)
          "DeviceMetric" -> DeviceMetricSerializer.deserializeJson(composite)
          "DeviceRequest" -> DeviceRequestSerializer.deserializeJson(composite)
          "DeviceUseStatement" -> DeviceUseStatementSerializer.deserializeJson(composite)
          "DiagnosticReport" -> DiagnosticReportSerializer.deserializeJson(composite)
          "DocumentManifest" -> DocumentManifestSerializer.deserializeJson(composite)
          "DocumentReference" -> DocumentReferenceSerializer.deserializeJson(composite)
          "Encounter" -> EncounterSerializer.deserializeJson(composite)
          "Endpoint" -> EndpointSerializer.deserializeJson(composite)
          "EnrollmentRequest" -> EnrollmentRequestSerializer.deserializeJson(composite)
          "EnrollmentResponse" -> EnrollmentResponseSerializer.deserializeJson(composite)
          "EpisodeOfCare" -> EpisodeOfCareSerializer.deserializeJson(composite)
          "EventDefinition" -> EventDefinitionSerializer.deserializeJson(composite)
          "Evidence" -> EvidenceSerializer.deserializeJson(composite)
          "EvidenceReport" -> EvidenceReportSerializer.deserializeJson(composite)
          "EvidenceVariable" -> EvidenceVariableSerializer.deserializeJson(composite)
          "ExampleScenario" -> ExampleScenarioSerializer.deserializeJson(composite)
          "ExplanationOfBenefit" -> ExplanationOfBenefitSerializer.deserializeJson(composite)
          "FamilyMemberHistory" -> FamilyMemberHistorySerializer.deserializeJson(composite)
          "Flag" -> FlagSerializer.deserializeJson(composite)
          "Goal" -> GoalSerializer.deserializeJson(composite)
          "GraphDefinition" -> GraphDefinitionSerializer.deserializeJson(composite)
          "Group" -> GroupSerializer.deserializeJson(composite)
          "GuidanceResponse" -> GuidanceResponseSerializer.deserializeJson(composite)
          "HealthcareService" -> HealthcareServiceSerializer.deserializeJson(composite)
          "ImagingStudy" -> ImagingStudySerializer.deserializeJson(composite)
          "Immunization" -> ImmunizationSerializer.deserializeJson(composite)
          "ImmunizationEvaluation" -> ImmunizationEvaluationSerializer.deserializeJson(composite)
          "ImmunizationRecommendation" ->
            ImmunizationRecommendationSerializer.deserializeJson(composite)
          "ImplementationGuide" -> ImplementationGuideSerializer.deserializeJson(composite)
          "Ingredient" -> IngredientSerializer.deserializeJson(composite)
          "InsurancePlan" -> InsurancePlanSerializer.deserializeJson(composite)
          "Invoice" -> InvoiceSerializer.deserializeJson(composite)
          "Library" -> LibrarySerializer.deserializeJson(composite)
          "Linkage" -> LinkageSerializer.deserializeJson(composite)
          "List" -> ListSerializer.deserializeJson(composite)
          "Location" -> LocationSerializer.deserializeJson(composite)
          "ManufacturedItemDefinition" ->
            ManufacturedItemDefinitionSerializer.deserializeJson(composite)
          "Measure" -> MeasureSerializer.deserializeJson(composite)
          "MeasureReport" -> MeasureReportSerializer.deserializeJson(composite)
          "Media" -> MediaSerializer.deserializeJson(composite)
          "Medication" -> MedicationSerializer.deserializeJson(composite)
          "MedicationAdministration" ->
            MedicationAdministrationSerializer.deserializeJson(composite)
          "MedicationDispense" -> MedicationDispenseSerializer.deserializeJson(composite)
          "MedicationKnowledge" -> MedicationKnowledgeSerializer.deserializeJson(composite)
          "MedicationRequest" -> MedicationRequestSerializer.deserializeJson(composite)
          "MedicationStatement" -> MedicationStatementSerializer.deserializeJson(composite)
          "MedicinalProductDefinition" ->
            MedicinalProductDefinitionSerializer.deserializeJson(composite)
          "MessageDefinition" -> MessageDefinitionSerializer.deserializeJson(composite)
          "MessageHeader" -> MessageHeaderSerializer.deserializeJson(composite)
          "MolecularSequence" -> MolecularSequenceSerializer.deserializeJson(composite)
          "NamingSystem" -> NamingSystemSerializer.deserializeJson(composite)
          "NutritionOrder" -> NutritionOrderSerializer.deserializeJson(composite)
          "NutritionProduct" -> NutritionProductSerializer.deserializeJson(composite)
          "Observation" -> ObservationSerializer.deserializeJson(composite)
          "ObservationDefinition" -> ObservationDefinitionSerializer.deserializeJson(composite)
          "OperationDefinition" -> OperationDefinitionSerializer.deserializeJson(composite)
          "OperationOutcome" -> OperationOutcomeSerializer.deserializeJson(composite)
          "Organization" -> OrganizationSerializer.deserializeJson(composite)
          "OrganizationAffiliation" -> OrganizationAffiliationSerializer.deserializeJson(composite)
          "PackagedProductDefinition" ->
            PackagedProductDefinitionSerializer.deserializeJson(composite)
          "Parameters" -> ParametersSerializer.deserializeJson(composite)
          "Patient" -> PatientSerializer.deserializeJson(composite)
          "PaymentNotice" -> PaymentNoticeSerializer.deserializeJson(composite)
          "PaymentReconciliation" -> PaymentReconciliationSerializer.deserializeJson(composite)
          "Person" -> PersonSerializer.deserializeJson(composite)
          "PlanDefinition" -> PlanDefinitionSerializer.deserializeJson(composite)
          "Practitioner" -> PractitionerSerializer.deserializeJson(composite)
          "PractitionerRole" -> PractitionerRoleSerializer.deserializeJson(composite)
          "Procedure" -> ProcedureSerializer.deserializeJson(composite)
          "Provenance" -> ProvenanceSerializer.deserializeJson(composite)
          "Questionnaire" -> QuestionnaireSerializer.deserializeJson(composite)
          "QuestionnaireResponse" -> QuestionnaireResponseSerializer.deserializeJson(composite)
          "RegulatedAuthorization" -> RegulatedAuthorizationSerializer.deserializeJson(composite)
          "RelatedPerson" -> RelatedPersonSerializer.deserializeJson(composite)
          "RequestGroup" -> RequestGroupSerializer.deserializeJson(composite)
          "ResearchDefinition" -> ResearchDefinitionSerializer.deserializeJson(composite)
          "ResearchElementDefinition" ->
            ResearchElementDefinitionSerializer.deserializeJson(composite)
          "ResearchStudy" -> ResearchStudySerializer.deserializeJson(composite)
          "ResearchSubject" -> ResearchSubjectSerializer.deserializeJson(composite)
          "RiskAssessment" -> RiskAssessmentSerializer.deserializeJson(composite)
          "Schedule" -> ScheduleSerializer.deserializeJson(composite)
          "SearchParameter" -> SearchParameterSerializer.deserializeJson(composite)
          "ServiceRequest" -> ServiceRequestSerializer.deserializeJson(composite)
          "Slot" -> SlotSerializer.deserializeJson(composite)
          "Specimen" -> SpecimenSerializer.deserializeJson(composite)
          "SpecimenDefinition" -> SpecimenDefinitionSerializer.deserializeJson(composite)
          "StructureDefinition" -> StructureDefinitionSerializer.deserializeJson(composite)
          "StructureMap" -> StructureMapSerializer.deserializeJson(composite)
          "Subscription" -> SubscriptionSerializer.deserializeJson(composite)
          "SubscriptionStatus" -> SubscriptionStatusSerializer.deserializeJson(composite)
          "SubscriptionTopic" -> SubscriptionTopicSerializer.deserializeJson(composite)
          "Substance" -> SubstanceSerializer.deserializeJson(composite)
          "SubstanceDefinition" -> SubstanceDefinitionSerializer.deserializeJson(composite)
          "SupplyDelivery" -> SupplyDeliverySerializer.deserializeJson(composite)
          "SupplyRequest" -> SupplyRequestSerializer.deserializeJson(composite)
          "Task" -> TaskSerializer.deserializeJson(composite)
          "TerminologyCapabilities" -> TerminologyCapabilitiesSerializer.deserializeJson(composite)
          "TestReport" -> TestReportSerializer.deserializeJson(composite)
          "TestScript" -> TestScriptSerializer.deserializeJson(composite)
          "ValueSet" -> ValueSetSerializer.deserializeJson(composite)
          "VerificationResult" -> VerificationResultSerializer.deserializeJson(composite)
          "VisionPrescription" -> VisionPrescriptionSerializer.deserializeJson(composite)
          else -> throw SerializationException("""Unknown Resource type "$peeked"""")
        }
      composite.endStructure(discriminatorDescriptor)
      return result
    }
    // Tree fallback — resourceType not first, or non-streaming decoder. Re-enter kotlinx's
    // JsonTreeDecoder via `decodeFromJsonElement` so the concrete subclass's regular
    // `deserialize(Decoder)` entry runs against a tree-backed CompositeDecoder. Slower
    // per-field than streaming but produces path-aware error messages.
    val tree = jd.decodeJsonElement().jsonObject
    val type =
      tree["resourceType"]?.jsonPrimitive?.contentOrNull
        ?: throw SerializationException(
          "Missing required 'resourceType' discriminator in FHIR Resource JSON"
        )
    return when (type) {
      "Account" -> jd.json.decodeFromJsonElement(AccountSerializer, tree)
      "ActivityDefinition" -> jd.json.decodeFromJsonElement(ActivityDefinitionSerializer, tree)
      "AdministrableProductDefinition" ->
        jd.json.decodeFromJsonElement(AdministrableProductDefinitionSerializer, tree)
      "AdverseEvent" -> jd.json.decodeFromJsonElement(AdverseEventSerializer, tree)
      "AllergyIntolerance" -> jd.json.decodeFromJsonElement(AllergyIntoleranceSerializer, tree)
      "Appointment" -> jd.json.decodeFromJsonElement(AppointmentSerializer, tree)
      "AppointmentResponse" -> jd.json.decodeFromJsonElement(AppointmentResponseSerializer, tree)
      "AuditEvent" -> jd.json.decodeFromJsonElement(AuditEventSerializer, tree)
      "Basic" -> jd.json.decodeFromJsonElement(BasicSerializer, tree)
      "Binary" -> jd.json.decodeFromJsonElement(BinarySerializer, tree)
      "BiologicallyDerivedProduct" ->
        jd.json.decodeFromJsonElement(BiologicallyDerivedProductSerializer, tree)
      "BodyStructure" -> jd.json.decodeFromJsonElement(BodyStructureSerializer, tree)
      "Bundle" -> jd.json.decodeFromJsonElement(BundleSerializer, tree)
      "CapabilityStatement" -> jd.json.decodeFromJsonElement(CapabilityStatementSerializer, tree)
      "CarePlan" -> jd.json.decodeFromJsonElement(CarePlanSerializer, tree)
      "CareTeam" -> jd.json.decodeFromJsonElement(CareTeamSerializer, tree)
      "CatalogEntry" -> jd.json.decodeFromJsonElement(CatalogEntrySerializer, tree)
      "ChargeItem" -> jd.json.decodeFromJsonElement(ChargeItemSerializer, tree)
      "ChargeItemDefinition" -> jd.json.decodeFromJsonElement(ChargeItemDefinitionSerializer, tree)
      "Citation" -> jd.json.decodeFromJsonElement(CitationSerializer, tree)
      "Claim" -> jd.json.decodeFromJsonElement(ClaimSerializer, tree)
      "ClaimResponse" -> jd.json.decodeFromJsonElement(ClaimResponseSerializer, tree)
      "ClinicalImpression" -> jd.json.decodeFromJsonElement(ClinicalImpressionSerializer, tree)
      "ClinicalUseDefinition" ->
        jd.json.decodeFromJsonElement(ClinicalUseDefinitionSerializer, tree)
      "CodeSystem" -> jd.json.decodeFromJsonElement(CodeSystemSerializer, tree)
      "Communication" -> jd.json.decodeFromJsonElement(CommunicationSerializer, tree)
      "CommunicationRequest" -> jd.json.decodeFromJsonElement(CommunicationRequestSerializer, tree)
      "CompartmentDefinition" ->
        jd.json.decodeFromJsonElement(CompartmentDefinitionSerializer, tree)
      "Composition" -> jd.json.decodeFromJsonElement(CompositionSerializer, tree)
      "ConceptMap" -> jd.json.decodeFromJsonElement(ConceptMapSerializer, tree)
      "Condition" -> jd.json.decodeFromJsonElement(ConditionSerializer, tree)
      "Consent" -> jd.json.decodeFromJsonElement(ConsentSerializer, tree)
      "Contract" -> jd.json.decodeFromJsonElement(ContractSerializer, tree)
      "Coverage" -> jd.json.decodeFromJsonElement(CoverageSerializer, tree)
      "CoverageEligibilityRequest" ->
        jd.json.decodeFromJsonElement(CoverageEligibilityRequestSerializer, tree)
      "CoverageEligibilityResponse" ->
        jd.json.decodeFromJsonElement(CoverageEligibilityResponseSerializer, tree)
      "DetectedIssue" -> jd.json.decodeFromJsonElement(DetectedIssueSerializer, tree)
      "Device" -> jd.json.decodeFromJsonElement(DeviceSerializer, tree)
      "DeviceDefinition" -> jd.json.decodeFromJsonElement(DeviceDefinitionSerializer, tree)
      "DeviceMetric" -> jd.json.decodeFromJsonElement(DeviceMetricSerializer, tree)
      "DeviceRequest" -> jd.json.decodeFromJsonElement(DeviceRequestSerializer, tree)
      "DeviceUseStatement" -> jd.json.decodeFromJsonElement(DeviceUseStatementSerializer, tree)
      "DiagnosticReport" -> jd.json.decodeFromJsonElement(DiagnosticReportSerializer, tree)
      "DocumentManifest" -> jd.json.decodeFromJsonElement(DocumentManifestSerializer, tree)
      "DocumentReference" -> jd.json.decodeFromJsonElement(DocumentReferenceSerializer, tree)
      "Encounter" -> jd.json.decodeFromJsonElement(EncounterSerializer, tree)
      "Endpoint" -> jd.json.decodeFromJsonElement(EndpointSerializer, tree)
      "EnrollmentRequest" -> jd.json.decodeFromJsonElement(EnrollmentRequestSerializer, tree)
      "EnrollmentResponse" -> jd.json.decodeFromJsonElement(EnrollmentResponseSerializer, tree)
      "EpisodeOfCare" -> jd.json.decodeFromJsonElement(EpisodeOfCareSerializer, tree)
      "EventDefinition" -> jd.json.decodeFromJsonElement(EventDefinitionSerializer, tree)
      "Evidence" -> jd.json.decodeFromJsonElement(EvidenceSerializer, tree)
      "EvidenceReport" -> jd.json.decodeFromJsonElement(EvidenceReportSerializer, tree)
      "EvidenceVariable" -> jd.json.decodeFromJsonElement(EvidenceVariableSerializer, tree)
      "ExampleScenario" -> jd.json.decodeFromJsonElement(ExampleScenarioSerializer, tree)
      "ExplanationOfBenefit" -> jd.json.decodeFromJsonElement(ExplanationOfBenefitSerializer, tree)
      "FamilyMemberHistory" -> jd.json.decodeFromJsonElement(FamilyMemberHistorySerializer, tree)
      "Flag" -> jd.json.decodeFromJsonElement(FlagSerializer, tree)
      "Goal" -> jd.json.decodeFromJsonElement(GoalSerializer, tree)
      "GraphDefinition" -> jd.json.decodeFromJsonElement(GraphDefinitionSerializer, tree)
      "Group" -> jd.json.decodeFromJsonElement(GroupSerializer, tree)
      "GuidanceResponse" -> jd.json.decodeFromJsonElement(GuidanceResponseSerializer, tree)
      "HealthcareService" -> jd.json.decodeFromJsonElement(HealthcareServiceSerializer, tree)
      "ImagingStudy" -> jd.json.decodeFromJsonElement(ImagingStudySerializer, tree)
      "Immunization" -> jd.json.decodeFromJsonElement(ImmunizationSerializer, tree)
      "ImmunizationEvaluation" ->
        jd.json.decodeFromJsonElement(ImmunizationEvaluationSerializer, tree)
      "ImmunizationRecommendation" ->
        jd.json.decodeFromJsonElement(ImmunizationRecommendationSerializer, tree)
      "ImplementationGuide" -> jd.json.decodeFromJsonElement(ImplementationGuideSerializer, tree)
      "Ingredient" -> jd.json.decodeFromJsonElement(IngredientSerializer, tree)
      "InsurancePlan" -> jd.json.decodeFromJsonElement(InsurancePlanSerializer, tree)
      "Invoice" -> jd.json.decodeFromJsonElement(InvoiceSerializer, tree)
      "Library" -> jd.json.decodeFromJsonElement(LibrarySerializer, tree)
      "Linkage" -> jd.json.decodeFromJsonElement(LinkageSerializer, tree)
      "List" -> jd.json.decodeFromJsonElement(ListSerializer, tree)
      "Location" -> jd.json.decodeFromJsonElement(LocationSerializer, tree)
      "ManufacturedItemDefinition" ->
        jd.json.decodeFromJsonElement(ManufacturedItemDefinitionSerializer, tree)
      "Measure" -> jd.json.decodeFromJsonElement(MeasureSerializer, tree)
      "MeasureReport" -> jd.json.decodeFromJsonElement(MeasureReportSerializer, tree)
      "Media" -> jd.json.decodeFromJsonElement(MediaSerializer, tree)
      "Medication" -> jd.json.decodeFromJsonElement(MedicationSerializer, tree)
      "MedicationAdministration" ->
        jd.json.decodeFromJsonElement(MedicationAdministrationSerializer, tree)
      "MedicationDispense" -> jd.json.decodeFromJsonElement(MedicationDispenseSerializer, tree)
      "MedicationKnowledge" -> jd.json.decodeFromJsonElement(MedicationKnowledgeSerializer, tree)
      "MedicationRequest" -> jd.json.decodeFromJsonElement(MedicationRequestSerializer, tree)
      "MedicationStatement" -> jd.json.decodeFromJsonElement(MedicationStatementSerializer, tree)
      "MedicinalProductDefinition" ->
        jd.json.decodeFromJsonElement(MedicinalProductDefinitionSerializer, tree)
      "MessageDefinition" -> jd.json.decodeFromJsonElement(MessageDefinitionSerializer, tree)
      "MessageHeader" -> jd.json.decodeFromJsonElement(MessageHeaderSerializer, tree)
      "MolecularSequence" -> jd.json.decodeFromJsonElement(MolecularSequenceSerializer, tree)
      "NamingSystem" -> jd.json.decodeFromJsonElement(NamingSystemSerializer, tree)
      "NutritionOrder" -> jd.json.decodeFromJsonElement(NutritionOrderSerializer, tree)
      "NutritionProduct" -> jd.json.decodeFromJsonElement(NutritionProductSerializer, tree)
      "Observation" -> jd.json.decodeFromJsonElement(ObservationSerializer, tree)
      "ObservationDefinition" ->
        jd.json.decodeFromJsonElement(ObservationDefinitionSerializer, tree)
      "OperationDefinition" -> jd.json.decodeFromJsonElement(OperationDefinitionSerializer, tree)
      "OperationOutcome" -> jd.json.decodeFromJsonElement(OperationOutcomeSerializer, tree)
      "Organization" -> jd.json.decodeFromJsonElement(OrganizationSerializer, tree)
      "OrganizationAffiliation" ->
        jd.json.decodeFromJsonElement(OrganizationAffiliationSerializer, tree)
      "PackagedProductDefinition" ->
        jd.json.decodeFromJsonElement(PackagedProductDefinitionSerializer, tree)
      "Parameters" -> jd.json.decodeFromJsonElement(ParametersSerializer, tree)
      "Patient" -> jd.json.decodeFromJsonElement(PatientSerializer, tree)
      "PaymentNotice" -> jd.json.decodeFromJsonElement(PaymentNoticeSerializer, tree)
      "PaymentReconciliation" ->
        jd.json.decodeFromJsonElement(PaymentReconciliationSerializer, tree)
      "Person" -> jd.json.decodeFromJsonElement(PersonSerializer, tree)
      "PlanDefinition" -> jd.json.decodeFromJsonElement(PlanDefinitionSerializer, tree)
      "Practitioner" -> jd.json.decodeFromJsonElement(PractitionerSerializer, tree)
      "PractitionerRole" -> jd.json.decodeFromJsonElement(PractitionerRoleSerializer, tree)
      "Procedure" -> jd.json.decodeFromJsonElement(ProcedureSerializer, tree)
      "Provenance" -> jd.json.decodeFromJsonElement(ProvenanceSerializer, tree)
      "Questionnaire" -> jd.json.decodeFromJsonElement(QuestionnaireSerializer, tree)
      "QuestionnaireResponse" ->
        jd.json.decodeFromJsonElement(QuestionnaireResponseSerializer, tree)
      "RegulatedAuthorization" ->
        jd.json.decodeFromJsonElement(RegulatedAuthorizationSerializer, tree)
      "RelatedPerson" -> jd.json.decodeFromJsonElement(RelatedPersonSerializer, tree)
      "RequestGroup" -> jd.json.decodeFromJsonElement(RequestGroupSerializer, tree)
      "ResearchDefinition" -> jd.json.decodeFromJsonElement(ResearchDefinitionSerializer, tree)
      "ResearchElementDefinition" ->
        jd.json.decodeFromJsonElement(ResearchElementDefinitionSerializer, tree)
      "ResearchStudy" -> jd.json.decodeFromJsonElement(ResearchStudySerializer, tree)
      "ResearchSubject" -> jd.json.decodeFromJsonElement(ResearchSubjectSerializer, tree)
      "RiskAssessment" -> jd.json.decodeFromJsonElement(RiskAssessmentSerializer, tree)
      "Schedule" -> jd.json.decodeFromJsonElement(ScheduleSerializer, tree)
      "SearchParameter" -> jd.json.decodeFromJsonElement(SearchParameterSerializer, tree)
      "ServiceRequest" -> jd.json.decodeFromJsonElement(ServiceRequestSerializer, tree)
      "Slot" -> jd.json.decodeFromJsonElement(SlotSerializer, tree)
      "Specimen" -> jd.json.decodeFromJsonElement(SpecimenSerializer, tree)
      "SpecimenDefinition" -> jd.json.decodeFromJsonElement(SpecimenDefinitionSerializer, tree)
      "StructureDefinition" -> jd.json.decodeFromJsonElement(StructureDefinitionSerializer, tree)
      "StructureMap" -> jd.json.decodeFromJsonElement(StructureMapSerializer, tree)
      "Subscription" -> jd.json.decodeFromJsonElement(SubscriptionSerializer, tree)
      "SubscriptionStatus" -> jd.json.decodeFromJsonElement(SubscriptionStatusSerializer, tree)
      "SubscriptionTopic" -> jd.json.decodeFromJsonElement(SubscriptionTopicSerializer, tree)
      "Substance" -> jd.json.decodeFromJsonElement(SubstanceSerializer, tree)
      "SubstanceDefinition" -> jd.json.decodeFromJsonElement(SubstanceDefinitionSerializer, tree)
      "SupplyDelivery" -> jd.json.decodeFromJsonElement(SupplyDeliverySerializer, tree)
      "SupplyRequest" -> jd.json.decodeFromJsonElement(SupplyRequestSerializer, tree)
      "Task" -> jd.json.decodeFromJsonElement(TaskSerializer, tree)
      "TerminologyCapabilities" ->
        jd.json.decodeFromJsonElement(TerminologyCapabilitiesSerializer, tree)
      "TestReport" -> jd.json.decodeFromJsonElement(TestReportSerializer, tree)
      "TestScript" -> jd.json.decodeFromJsonElement(TestScriptSerializer, tree)
      "ValueSet" -> jd.json.decodeFromJsonElement(ValueSetSerializer, tree)
      "VerificationResult" -> jd.json.decodeFromJsonElement(VerificationResultSerializer, tree)
      "VisionPrescription" -> jd.json.decodeFromJsonElement(VisionPrescriptionSerializer, tree)
      else -> throw SerializationException("""Unknown Resource type "$type"""")
    }
  }
}
