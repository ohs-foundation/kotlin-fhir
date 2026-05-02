/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import kotlin.String
import kotlin.Unit
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.modules.SerializersModule

public class FhirR4Json(`init`: JsonBuilder.() -> Unit = {}) {
  private val json: Json = Json {
    prettyPrint = true
    classDiscriminator = "resourceType"
    serializersModule = serializersModuleR4
    init()
  }

  public fun encodeToString(resource: Resource): String = json.encodeToString(resource)

  public fun decodeFromString(string: String): Resource = json.decodeFromString<Resource>(string)
}

private val serializersModuleR4: SerializersModule = SerializersModule {
  polymorphic(Resource::class, Account::class, Account.serializer())
  polymorphic(Resource::class, ActivityDefinition::class, ActivityDefinition.serializer())
  polymorphic(Resource::class, AdverseEvent::class, AdverseEvent.serializer())
  polymorphic(Resource::class, AllergyIntolerance::class, AllergyIntolerance.serializer())
  polymorphic(Resource::class, Appointment::class, Appointment.serializer())
  polymorphic(Resource::class, AppointmentResponse::class, AppointmentResponse.serializer())
  polymorphic(Resource::class, AuditEvent::class, AuditEvent.serializer())
  polymorphic(Resource::class, Basic::class, Basic.serializer())
  polymorphic(Resource::class, Binary::class, Binary.serializer())
  polymorphic(
    Resource::class,
    BiologicallyDerivedProduct::class,
    BiologicallyDerivedProduct.serializer(),
  )
  polymorphic(Resource::class, BodyStructure::class, BodyStructure.serializer())
  polymorphic(Resource::class, Bundle::class, Bundle.serializer())
  polymorphic(Resource::class, CapabilityStatement::class, CapabilityStatement.serializer())
  polymorphic(Resource::class, CarePlan::class, CarePlan.serializer())
  polymorphic(Resource::class, CareTeam::class, CareTeam.serializer())
  polymorphic(Resource::class, CatalogEntry::class, CatalogEntry.serializer())
  polymorphic(Resource::class, ChargeItem::class, ChargeItem.serializer())
  polymorphic(Resource::class, ChargeItemDefinition::class, ChargeItemDefinition.serializer())
  polymorphic(Resource::class, Claim::class, Claim.serializer())
  polymorphic(Resource::class, ClaimResponse::class, ClaimResponse.serializer())
  polymorphic(Resource::class, ClinicalImpression::class, ClinicalImpression.serializer())
  polymorphic(Resource::class, CodeSystem::class, CodeSystem.serializer())
  polymorphic(Resource::class, Communication::class, Communication.serializer())
  polymorphic(Resource::class, CommunicationRequest::class, CommunicationRequest.serializer())
  polymorphic(Resource::class, CompartmentDefinition::class, CompartmentDefinition.serializer())
  polymorphic(Resource::class, Composition::class, Composition.serializer())
  polymorphic(Resource::class, ConceptMap::class, ConceptMap.serializer())
  polymorphic(Resource::class, Condition::class, Condition.serializer())
  polymorphic(Resource::class, Consent::class, Consent.serializer())
  polymorphic(Resource::class, Contract::class, Contract.serializer())
  polymorphic(Resource::class, Coverage::class, Coverage.serializer())
  polymorphic(
    Resource::class,
    CoverageEligibilityRequest::class,
    CoverageEligibilityRequest.serializer(),
  )
  polymorphic(
    Resource::class,
    CoverageEligibilityResponse::class,
    CoverageEligibilityResponse.serializer(),
  )
  polymorphic(Resource::class, DetectedIssue::class, DetectedIssue.serializer())
  polymorphic(Resource::class, Device::class, Device.serializer())
  polymorphic(Resource::class, DeviceDefinition::class, DeviceDefinition.serializer())
  polymorphic(Resource::class, DeviceMetric::class, DeviceMetric.serializer())
  polymorphic(Resource::class, DeviceRequest::class, DeviceRequest.serializer())
  polymorphic(Resource::class, DeviceUseStatement::class, DeviceUseStatement.serializer())
  polymorphic(Resource::class, DiagnosticReport::class, DiagnosticReport.serializer())
  polymorphic(Resource::class, DocumentManifest::class, DocumentManifest.serializer())
  polymorphic(Resource::class, DocumentReference::class, DocumentReference.serializer())
  polymorphic(Resource::class, EffectEvidenceSynthesis::class, EffectEvidenceSynthesis.serializer())
  polymorphic(Resource::class, Encounter::class, Encounter.serializer())
  polymorphic(Resource::class, Endpoint::class, Endpoint.serializer())
  polymorphic(Resource::class, EnrollmentRequest::class, EnrollmentRequest.serializer())
  polymorphic(Resource::class, EnrollmentResponse::class, EnrollmentResponse.serializer())
  polymorphic(Resource::class, EpisodeOfCare::class, EpisodeOfCare.serializer())
  polymorphic(Resource::class, EventDefinition::class, EventDefinition.serializer())
  polymorphic(Resource::class, Evidence::class, Evidence.serializer())
  polymorphic(Resource::class, EvidenceVariable::class, EvidenceVariable.serializer())
  polymorphic(Resource::class, ExampleScenario::class, ExampleScenario.serializer())
  polymorphic(Resource::class, ExplanationOfBenefit::class, ExplanationOfBenefit.serializer())
  polymorphic(Resource::class, FamilyMemberHistory::class, FamilyMemberHistory.serializer())
  polymorphic(Resource::class, Flag::class, Flag.serializer())
  polymorphic(Resource::class, Goal::class, Goal.serializer())
  polymorphic(Resource::class, GraphDefinition::class, GraphDefinition.serializer())
  polymorphic(Resource::class, Group::class, Group.serializer())
  polymorphic(Resource::class, GuidanceResponse::class, GuidanceResponse.serializer())
  polymorphic(Resource::class, HealthcareService::class, HealthcareService.serializer())
  polymorphic(Resource::class, ImagingStudy::class, ImagingStudy.serializer())
  polymorphic(Resource::class, Immunization::class, Immunization.serializer())
  polymorphic(Resource::class, ImmunizationEvaluation::class, ImmunizationEvaluation.serializer())
  polymorphic(
    Resource::class,
    ImmunizationRecommendation::class,
    ImmunizationRecommendation.serializer(),
  )
  polymorphic(Resource::class, ImplementationGuide::class, ImplementationGuide.serializer())
  polymorphic(Resource::class, InsurancePlan::class, InsurancePlan.serializer())
  polymorphic(Resource::class, Invoice::class, Invoice.serializer())
  polymorphic(Resource::class, Library::class, Library.serializer())
  polymorphic(Resource::class, Linkage::class, Linkage.serializer())
  polymorphic(Resource::class, List::class, List.serializer())
  polymorphic(Resource::class, Location::class, Location.serializer())
  polymorphic(Resource::class, Measure::class, Measure.serializer())
  polymorphic(Resource::class, MeasureReport::class, MeasureReport.serializer())
  polymorphic(Resource::class, Media::class, Media.serializer())
  polymorphic(Resource::class, Medication::class, Medication.serializer())
  polymorphic(
    Resource::class,
    MedicationAdministration::class,
    MedicationAdministration.serializer(),
  )
  polymorphic(Resource::class, MedicationDispense::class, MedicationDispense.serializer())
  polymorphic(Resource::class, MedicationKnowledge::class, MedicationKnowledge.serializer())
  polymorphic(Resource::class, MedicationRequest::class, MedicationRequest.serializer())
  polymorphic(Resource::class, MedicationStatement::class, MedicationStatement.serializer())
  polymorphic(Resource::class, MedicinalProduct::class, MedicinalProduct.serializer())
  polymorphic(
    Resource::class,
    MedicinalProductAuthorization::class,
    MedicinalProductAuthorization.serializer(),
  )
  polymorphic(
    Resource::class,
    MedicinalProductContraindication::class,
    MedicinalProductContraindication.serializer(),
  )
  polymorphic(
    Resource::class,
    MedicinalProductIndication::class,
    MedicinalProductIndication.serializer(),
  )
  polymorphic(
    Resource::class,
    MedicinalProductIngredient::class,
    MedicinalProductIngredient.serializer(),
  )
  polymorphic(
    Resource::class,
    MedicinalProductInteraction::class,
    MedicinalProductInteraction.serializer(),
  )
  polymorphic(
    Resource::class,
    MedicinalProductManufactured::class,
    MedicinalProductManufactured.serializer(),
  )
  polymorphic(
    Resource::class,
    MedicinalProductPackaged::class,
    MedicinalProductPackaged.serializer(),
  )
  polymorphic(
    Resource::class,
    MedicinalProductPharmaceutical::class,
    MedicinalProductPharmaceutical.serializer(),
  )
  polymorphic(
    Resource::class,
    MedicinalProductUndesirableEffect::class,
    MedicinalProductUndesirableEffect.serializer(),
  )
  polymorphic(Resource::class, MessageDefinition::class, MessageDefinition.serializer())
  polymorphic(Resource::class, MessageHeader::class, MessageHeader.serializer())
  polymorphic(Resource::class, MolecularSequence::class, MolecularSequence.serializer())
  polymorphic(Resource::class, NamingSystem::class, NamingSystem.serializer())
  polymorphic(Resource::class, NutritionOrder::class, NutritionOrder.serializer())
  polymorphic(Resource::class, Observation::class, Observation.serializer())
  polymorphic(Resource::class, ObservationDefinition::class, ObservationDefinition.serializer())
  polymorphic(Resource::class, OperationDefinition::class, OperationDefinition.serializer())
  polymorphic(Resource::class, OperationOutcome::class, OperationOutcome.serializer())
  polymorphic(Resource::class, Organization::class, Organization.serializer())
  polymorphic(Resource::class, OrganizationAffiliation::class, OrganizationAffiliation.serializer())
  polymorphic(Resource::class, Parameters::class, Parameters.serializer())
  polymorphic(Resource::class, Patient::class, Patient.serializer())
  polymorphic(Resource::class, PaymentNotice::class, PaymentNotice.serializer())
  polymorphic(Resource::class, PaymentReconciliation::class, PaymentReconciliation.serializer())
  polymorphic(Resource::class, Person::class, Person.serializer())
  polymorphic(Resource::class, PlanDefinition::class, PlanDefinition.serializer())
  polymorphic(Resource::class, Practitioner::class, Practitioner.serializer())
  polymorphic(Resource::class, PractitionerRole::class, PractitionerRole.serializer())
  polymorphic(Resource::class, Procedure::class, Procedure.serializer())
  polymorphic(Resource::class, Provenance::class, Provenance.serializer())
  polymorphic(Resource::class, Questionnaire::class, Questionnaire.serializer())
  polymorphic(Resource::class, QuestionnaireResponse::class, QuestionnaireResponse.serializer())
  polymorphic(Resource::class, RelatedPerson::class, RelatedPerson.serializer())
  polymorphic(Resource::class, RequestGroup::class, RequestGroup.serializer())
  polymorphic(Resource::class, ResearchDefinition::class, ResearchDefinition.serializer())
  polymorphic(
    Resource::class,
    ResearchElementDefinition::class,
    ResearchElementDefinition.serializer(),
  )
  polymorphic(Resource::class, ResearchStudy::class, ResearchStudy.serializer())
  polymorphic(Resource::class, ResearchSubject::class, ResearchSubject.serializer())
  polymorphic(Resource::class, RiskAssessment::class, RiskAssessment.serializer())
  polymorphic(Resource::class, RiskEvidenceSynthesis::class, RiskEvidenceSynthesis.serializer())
  polymorphic(Resource::class, Schedule::class, Schedule.serializer())
  polymorphic(Resource::class, SearchParameter::class, SearchParameter.serializer())
  polymorphic(Resource::class, ServiceRequest::class, ServiceRequest.serializer())
  polymorphic(Resource::class, Slot::class, Slot.serializer())
  polymorphic(Resource::class, Specimen::class, Specimen.serializer())
  polymorphic(Resource::class, SpecimenDefinition::class, SpecimenDefinition.serializer())
  polymorphic(Resource::class, StructureDefinition::class, StructureDefinition.serializer())
  polymorphic(Resource::class, StructureMap::class, StructureMap.serializer())
  polymorphic(Resource::class, Subscription::class, Subscription.serializer())
  polymorphic(Resource::class, Substance::class, Substance.serializer())
  polymorphic(Resource::class, SubstanceNucleicAcid::class, SubstanceNucleicAcid.serializer())
  polymorphic(Resource::class, SubstancePolymer::class, SubstancePolymer.serializer())
  polymorphic(Resource::class, SubstanceProtein::class, SubstanceProtein.serializer())
  polymorphic(
    Resource::class,
    SubstanceReferenceInformation::class,
    SubstanceReferenceInformation.serializer(),
  )
  polymorphic(Resource::class, SubstanceSourceMaterial::class, SubstanceSourceMaterial.serializer())
  polymorphic(Resource::class, SubstanceSpecification::class, SubstanceSpecification.serializer())
  polymorphic(Resource::class, SupplyDelivery::class, SupplyDelivery.serializer())
  polymorphic(Resource::class, SupplyRequest::class, SupplyRequest.serializer())
  polymorphic(Resource::class, Task::class, Task.serializer())
  polymorphic(Resource::class, TerminologyCapabilities::class, TerminologyCapabilities.serializer())
  polymorphic(Resource::class, TestReport::class, TestReport.serializer())
  polymorphic(Resource::class, TestScript::class, TestScript.serializer())
  polymorphic(Resource::class, ValueSet::class, ValueSet.serializer())
  polymorphic(Resource::class, VerificationResult::class, VerificationResult.serializer())
  polymorphic(Resource::class, VisionPrescription::class, VisionPrescription.serializer())
}
