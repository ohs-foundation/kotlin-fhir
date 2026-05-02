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

package com.google.fhir.model.r5.terminologies

/** List of all non-abstract types, data types and resources */
public enum class ConcreteFHIRTypes(
  private val code: kotlin.String,
  private val system: kotlin.String,
  private val display: kotlin.String?,
) {
  Account("Account", "http://hl7.org/fhir/fhir-types", "Account"),
  ActivityDefinition("ActivityDefinition", "http://hl7.org/fhir/fhir-types", "ActivityDefinition"),
  ActorDefinition("ActorDefinition", "http://hl7.org/fhir/fhir-types", "ActorDefinition"),
  Address("Address", "http://hl7.org/fhir/fhir-types", "Address"),
  AdministrableProductDefinition(
    "AdministrableProductDefinition",
    "http://hl7.org/fhir/fhir-types",
    "AdministrableProductDefinition",
  ),
  AdverseEvent("AdverseEvent", "http://hl7.org/fhir/fhir-types", "AdverseEvent"),
  Age("Age", "http://hl7.org/fhir/fhir-types", "Age"),
  AllergyIntolerance("AllergyIntolerance", "http://hl7.org/fhir/fhir-types", "AllergyIntolerance"),
  Annotation("Annotation", "http://hl7.org/fhir/fhir-types", "Annotation"),
  Appointment("Appointment", "http://hl7.org/fhir/fhir-types", "Appointment"),
  AppointmentResponse(
    "AppointmentResponse",
    "http://hl7.org/fhir/fhir-types",
    "AppointmentResponse",
  ),
  ArtifactAssessment("ArtifactAssessment", "http://hl7.org/fhir/fhir-types", "ArtifactAssessment"),
  Attachment("Attachment", "http://hl7.org/fhir/fhir-types", "Attachment"),
  AuditEvent("AuditEvent", "http://hl7.org/fhir/fhir-types", "AuditEvent"),
  Availability("Availability", "http://hl7.org/fhir/fhir-types", "Availability"),
  Base64Binary("base64Binary", "http://hl7.org/fhir/fhir-types", "base64Binary"),
  Basic("Basic", "http://hl7.org/fhir/fhir-types", "Basic"),
  Binary("Binary", "http://hl7.org/fhir/fhir-types", "Binary"),
  BiologicallyDerivedProduct(
    "BiologicallyDerivedProduct",
    "http://hl7.org/fhir/fhir-types",
    "BiologicallyDerivedProduct",
  ),
  BiologicallyDerivedProductDispense(
    "BiologicallyDerivedProductDispense",
    "http://hl7.org/fhir/fhir-types",
    "BiologicallyDerivedProductDispense",
  ),
  BodyStructure("BodyStructure", "http://hl7.org/fhir/fhir-types", "BodyStructure"),
  Boolean("boolean", "http://hl7.org/fhir/fhir-types", "boolean"),
  Bundle("Bundle", "http://hl7.org/fhir/fhir-types", "Bundle"),
  Canonical("canonical", "http://hl7.org/fhir/fhir-types", "canonical"),
  CapabilityStatement(
    "CapabilityStatement",
    "http://hl7.org/fhir/fhir-types",
    "CapabilityStatement",
  ),
  CarePlan("CarePlan", "http://hl7.org/fhir/fhir-types", "CarePlan"),
  CareTeam("CareTeam", "http://hl7.org/fhir/fhir-types", "CareTeam"),
  ChargeItem("ChargeItem", "http://hl7.org/fhir/fhir-types", "ChargeItem"),
  ChargeItemDefinition(
    "ChargeItemDefinition",
    "http://hl7.org/fhir/fhir-types",
    "ChargeItemDefinition",
  ),
  Citation("Citation", "http://hl7.org/fhir/fhir-types", "Citation"),
  Claim("Claim", "http://hl7.org/fhir/fhir-types", "Claim"),
  ClaimResponse("ClaimResponse", "http://hl7.org/fhir/fhir-types", "ClaimResponse"),
  ClinicalImpression("ClinicalImpression", "http://hl7.org/fhir/fhir-types", "ClinicalImpression"),
  ClinicalUseDefinition(
    "ClinicalUseDefinition",
    "http://hl7.org/fhir/fhir-types",
    "ClinicalUseDefinition",
  ),
  Code("code", "http://hl7.org/fhir/fhir-types", "code"),
  CodeableConcept("CodeableConcept", "http://hl7.org/fhir/fhir-types", "CodeableConcept"),
  CodeableReference("CodeableReference", "http://hl7.org/fhir/fhir-types", "CodeableReference"),
  CodeSystem("CodeSystem", "http://hl7.org/fhir/fhir-types", "CodeSystem"),
  Coding("Coding", "http://hl7.org/fhir/fhir-types", "Coding"),
  Communication("Communication", "http://hl7.org/fhir/fhir-types", "Communication"),
  CommunicationRequest(
    "CommunicationRequest",
    "http://hl7.org/fhir/fhir-types",
    "CommunicationRequest",
  ),
  CompartmentDefinition(
    "CompartmentDefinition",
    "http://hl7.org/fhir/fhir-types",
    "CompartmentDefinition",
  ),
  Composition("Composition", "http://hl7.org/fhir/fhir-types", "Composition"),
  ConceptMap("ConceptMap", "http://hl7.org/fhir/fhir-types", "ConceptMap"),
  Condition("Condition", "http://hl7.org/fhir/fhir-types", "Condition"),
  ConditionDefinition(
    "ConditionDefinition",
    "http://hl7.org/fhir/fhir-types",
    "ConditionDefinition",
  ),
  Consent("Consent", "http://hl7.org/fhir/fhir-types", "Consent"),
  ContactDetail("ContactDetail", "http://hl7.org/fhir/fhir-types", "ContactDetail"),
  ContactPoint("ContactPoint", "http://hl7.org/fhir/fhir-types", "ContactPoint"),
  Contract("Contract", "http://hl7.org/fhir/fhir-types", "Contract"),
  Contributor("Contributor", "http://hl7.org/fhir/fhir-types", "Contributor"),
  Count("Count", "http://hl7.org/fhir/fhir-types", "Count"),
  Coverage("Coverage", "http://hl7.org/fhir/fhir-types", "Coverage"),
  CoverageEligibilityRequest(
    "CoverageEligibilityRequest",
    "http://hl7.org/fhir/fhir-types",
    "CoverageEligibilityRequest",
  ),
  CoverageEligibilityResponse(
    "CoverageEligibilityResponse",
    "http://hl7.org/fhir/fhir-types",
    "CoverageEligibilityResponse",
  ),
  DataRequirement("DataRequirement", "http://hl7.org/fhir/fhir-types", "DataRequirement"),
  Date("date", "http://hl7.org/fhir/fhir-types", "date"),
  DateTime("dateTime", "http://hl7.org/fhir/fhir-types", "dateTime"),
  Decimal("decimal", "http://hl7.org/fhir/fhir-types", "decimal"),
  DetectedIssue("DetectedIssue", "http://hl7.org/fhir/fhir-types", "DetectedIssue"),
  Device("Device", "http://hl7.org/fhir/fhir-types", "Device"),
  DeviceAssociation("DeviceAssociation", "http://hl7.org/fhir/fhir-types", "DeviceAssociation"),
  DeviceDefinition("DeviceDefinition", "http://hl7.org/fhir/fhir-types", "DeviceDefinition"),
  DeviceDispense("DeviceDispense", "http://hl7.org/fhir/fhir-types", "DeviceDispense"),
  DeviceMetric("DeviceMetric", "http://hl7.org/fhir/fhir-types", "DeviceMetric"),
  DeviceRequest("DeviceRequest", "http://hl7.org/fhir/fhir-types", "DeviceRequest"),
  DeviceUsage("DeviceUsage", "http://hl7.org/fhir/fhir-types", "DeviceUsage"),
  DiagnosticReport("DiagnosticReport", "http://hl7.org/fhir/fhir-types", "DiagnosticReport"),
  Distance("Distance", "http://hl7.org/fhir/fhir-types", "Distance"),
  DocumentReference("DocumentReference", "http://hl7.org/fhir/fhir-types", "DocumentReference"),
  Dosage("Dosage", "http://hl7.org/fhir/fhir-types", "Dosage"),
  Duration("Duration", "http://hl7.org/fhir/fhir-types", "Duration"),
  ElementDefinition("ElementDefinition", "http://hl7.org/fhir/fhir-types", "ElementDefinition"),
  Encounter("Encounter", "http://hl7.org/fhir/fhir-types", "Encounter"),
  EncounterHistory("EncounterHistory", "http://hl7.org/fhir/fhir-types", "EncounterHistory"),
  Endpoint("Endpoint", "http://hl7.org/fhir/fhir-types", "Endpoint"),
  EnrollmentRequest("EnrollmentRequest", "http://hl7.org/fhir/fhir-types", "EnrollmentRequest"),
  EnrollmentResponse("EnrollmentResponse", "http://hl7.org/fhir/fhir-types", "EnrollmentResponse"),
  EpisodeOfCare("EpisodeOfCare", "http://hl7.org/fhir/fhir-types", "EpisodeOfCare"),
  EventDefinition("EventDefinition", "http://hl7.org/fhir/fhir-types", "EventDefinition"),
  Evidence("Evidence", "http://hl7.org/fhir/fhir-types", "Evidence"),
  EvidenceReport("EvidenceReport", "http://hl7.org/fhir/fhir-types", "EvidenceReport"),
  EvidenceVariable("EvidenceVariable", "http://hl7.org/fhir/fhir-types", "EvidenceVariable"),
  ExampleScenario("ExampleScenario", "http://hl7.org/fhir/fhir-types", "ExampleScenario"),
  ExplanationOfBenefit(
    "ExplanationOfBenefit",
    "http://hl7.org/fhir/fhir-types",
    "ExplanationOfBenefit",
  ),
  Expression("Expression", "http://hl7.org/fhir/fhir-types", "Expression"),
  ExtendedContactDetail(
    "ExtendedContactDetail",
    "http://hl7.org/fhir/fhir-types",
    "ExtendedContactDetail",
  ),
  Extension("Extension", "http://hl7.org/fhir/fhir-types", "Extension"),
  FamilyMemberHistory(
    "FamilyMemberHistory",
    "http://hl7.org/fhir/fhir-types",
    "FamilyMemberHistory",
  ),
  Flag("Flag", "http://hl7.org/fhir/fhir-types", "Flag"),
  FormularyItem("FormularyItem", "http://hl7.org/fhir/fhir-types", "FormularyItem"),
  GenomicStudy("GenomicStudy", "http://hl7.org/fhir/fhir-types", "GenomicStudy"),
  Goal("Goal", "http://hl7.org/fhir/fhir-types", "Goal"),
  GraphDefinition("GraphDefinition", "http://hl7.org/fhir/fhir-types", "GraphDefinition"),
  Group("Group", "http://hl7.org/fhir/fhir-types", "Group"),
  GuidanceResponse("GuidanceResponse", "http://hl7.org/fhir/fhir-types", "GuidanceResponse"),
  HealthcareService("HealthcareService", "http://hl7.org/fhir/fhir-types", "HealthcareService"),
  HumanName("HumanName", "http://hl7.org/fhir/fhir-types", "HumanName"),
  Id("id", "http://hl7.org/fhir/fhir-types", "id"),
  Identifier("Identifier", "http://hl7.org/fhir/fhir-types", "Identifier"),
  ImagingSelection("ImagingSelection", "http://hl7.org/fhir/fhir-types", "ImagingSelection"),
  ImagingStudy("ImagingStudy", "http://hl7.org/fhir/fhir-types", "ImagingStudy"),
  Immunization("Immunization", "http://hl7.org/fhir/fhir-types", "Immunization"),
  ImmunizationEvaluation(
    "ImmunizationEvaluation",
    "http://hl7.org/fhir/fhir-types",
    "ImmunizationEvaluation",
  ),
  ImmunizationRecommendation(
    "ImmunizationRecommendation",
    "http://hl7.org/fhir/fhir-types",
    "ImmunizationRecommendation",
  ),
  ImplementationGuide(
    "ImplementationGuide",
    "http://hl7.org/fhir/fhir-types",
    "ImplementationGuide",
  ),
  Ingredient("Ingredient", "http://hl7.org/fhir/fhir-types", "Ingredient"),
  Instant("instant", "http://hl7.org/fhir/fhir-types", "instant"),
  InsurancePlan("InsurancePlan", "http://hl7.org/fhir/fhir-types", "InsurancePlan"),
  Integer("integer", "http://hl7.org/fhir/fhir-types", "integer"),
  Integer64("integer64", "http://hl7.org/fhir/fhir-types", "integer64"),
  InventoryItem("InventoryItem", "http://hl7.org/fhir/fhir-types", "InventoryItem"),
  InventoryReport("InventoryReport", "http://hl7.org/fhir/fhir-types", "InventoryReport"),
  Invoice("Invoice", "http://hl7.org/fhir/fhir-types", "Invoice"),
  Library("Library", "http://hl7.org/fhir/fhir-types", "Library"),
  Linkage("Linkage", "http://hl7.org/fhir/fhir-types", "Linkage"),
  List("List", "http://hl7.org/fhir/fhir-types", "List"),
  Location("Location", "http://hl7.org/fhir/fhir-types", "Location"),
  ManufacturedItemDefinition(
    "ManufacturedItemDefinition",
    "http://hl7.org/fhir/fhir-types",
    "ManufacturedItemDefinition",
  ),
  Markdown("markdown", "http://hl7.org/fhir/fhir-types", "markdown"),
  MarketingStatus("MarketingStatus", "http://hl7.org/fhir/fhir-types", "MarketingStatus"),
  Measure("Measure", "http://hl7.org/fhir/fhir-types", "Measure"),
  MeasureReport("MeasureReport", "http://hl7.org/fhir/fhir-types", "MeasureReport"),
  Medication("Medication", "http://hl7.org/fhir/fhir-types", "Medication"),
  MedicationAdministration(
    "MedicationAdministration",
    "http://hl7.org/fhir/fhir-types",
    "MedicationAdministration",
  ),
  MedicationDispense("MedicationDispense", "http://hl7.org/fhir/fhir-types", "MedicationDispense"),
  MedicationKnowledge(
    "MedicationKnowledge",
    "http://hl7.org/fhir/fhir-types",
    "MedicationKnowledge",
  ),
  MedicationRequest("MedicationRequest", "http://hl7.org/fhir/fhir-types", "MedicationRequest"),
  MedicationStatement(
    "MedicationStatement",
    "http://hl7.org/fhir/fhir-types",
    "MedicationStatement",
  ),
  MedicinalProductDefinition(
    "MedicinalProductDefinition",
    "http://hl7.org/fhir/fhir-types",
    "MedicinalProductDefinition",
  ),
  MessageDefinition("MessageDefinition", "http://hl7.org/fhir/fhir-types", "MessageDefinition"),
  MessageHeader("MessageHeader", "http://hl7.org/fhir/fhir-types", "MessageHeader"),
  Meta("Meta", "http://hl7.org/fhir/fhir-types", "Meta"),
  MolecularSequence("MolecularSequence", "http://hl7.org/fhir/fhir-types", "MolecularSequence"),
  MonetaryComponent("MonetaryComponent", "http://hl7.org/fhir/fhir-types", "MonetaryComponent"),
  Money("Money", "http://hl7.org/fhir/fhir-types", "Money"),
  NamingSystem("NamingSystem", "http://hl7.org/fhir/fhir-types", "NamingSystem"),
  Narrative("Narrative", "http://hl7.org/fhir/fhir-types", "Narrative"),
  NutritionIntake("NutritionIntake", "http://hl7.org/fhir/fhir-types", "NutritionIntake"),
  NutritionOrder("NutritionOrder", "http://hl7.org/fhir/fhir-types", "NutritionOrder"),
  NutritionProduct("NutritionProduct", "http://hl7.org/fhir/fhir-types", "NutritionProduct"),
  Observation("Observation", "http://hl7.org/fhir/fhir-types", "Observation"),
  ObservationDefinition(
    "ObservationDefinition",
    "http://hl7.org/fhir/fhir-types",
    "ObservationDefinition",
  ),
  Oid("oid", "http://hl7.org/fhir/fhir-types", "oid"),
  OperationDefinition(
    "OperationDefinition",
    "http://hl7.org/fhir/fhir-types",
    "OperationDefinition",
  ),
  OperationOutcome("OperationOutcome", "http://hl7.org/fhir/fhir-types", "OperationOutcome"),
  Organization("Organization", "http://hl7.org/fhir/fhir-types", "Organization"),
  OrganizationAffiliation(
    "OrganizationAffiliation",
    "http://hl7.org/fhir/fhir-types",
    "OrganizationAffiliation",
  ),
  PackagedProductDefinition(
    "PackagedProductDefinition",
    "http://hl7.org/fhir/fhir-types",
    "PackagedProductDefinition",
  ),
  ParameterDefinition(
    "ParameterDefinition",
    "http://hl7.org/fhir/fhir-types",
    "ParameterDefinition",
  ),
  Parameters("Parameters", "http://hl7.org/fhir/fhir-types", "Parameters"),
  Patient("Patient", "http://hl7.org/fhir/fhir-types", "Patient"),
  PaymentNotice("PaymentNotice", "http://hl7.org/fhir/fhir-types", "PaymentNotice"),
  PaymentReconciliation(
    "PaymentReconciliation",
    "http://hl7.org/fhir/fhir-types",
    "PaymentReconciliation",
  ),
  Period("Period", "http://hl7.org/fhir/fhir-types", "Period"),
  Permission("Permission", "http://hl7.org/fhir/fhir-types", "Permission"),
  Person("Person", "http://hl7.org/fhir/fhir-types", "Person"),
  PlanDefinition("PlanDefinition", "http://hl7.org/fhir/fhir-types", "PlanDefinition"),
  PositiveInt("positiveInt", "http://hl7.org/fhir/fhir-types", "positiveInt"),
  Practitioner("Practitioner", "http://hl7.org/fhir/fhir-types", "Practitioner"),
  PractitionerRole("PractitionerRole", "http://hl7.org/fhir/fhir-types", "PractitionerRole"),
  Procedure("Procedure", "http://hl7.org/fhir/fhir-types", "Procedure"),
  ProductShelfLife("ProductShelfLife", "http://hl7.org/fhir/fhir-types", "ProductShelfLife"),
  Provenance("Provenance", "http://hl7.org/fhir/fhir-types", "Provenance"),
  Quantity("Quantity", "http://hl7.org/fhir/fhir-types", "Quantity"),
  Questionnaire("Questionnaire", "http://hl7.org/fhir/fhir-types", "Questionnaire"),
  QuestionnaireResponse(
    "QuestionnaireResponse",
    "http://hl7.org/fhir/fhir-types",
    "QuestionnaireResponse",
  ),
  Range("Range", "http://hl7.org/fhir/fhir-types", "Range"),
  Ratio("Ratio", "http://hl7.org/fhir/fhir-types", "Ratio"),
  RatioRange("RatioRange", "http://hl7.org/fhir/fhir-types", "RatioRange"),
  Reference("Reference", "http://hl7.org/fhir/fhir-types", "Reference"),
  RegulatedAuthorization(
    "RegulatedAuthorization",
    "http://hl7.org/fhir/fhir-types",
    "RegulatedAuthorization",
  ),
  RelatedArtifact("RelatedArtifact", "http://hl7.org/fhir/fhir-types", "RelatedArtifact"),
  RelatedPerson("RelatedPerson", "http://hl7.org/fhir/fhir-types", "RelatedPerson"),
  RequestOrchestration(
    "RequestOrchestration",
    "http://hl7.org/fhir/fhir-types",
    "RequestOrchestration",
  ),
  Requirements("Requirements", "http://hl7.org/fhir/fhir-types", "Requirements"),
  ResearchStudy("ResearchStudy", "http://hl7.org/fhir/fhir-types", "ResearchStudy"),
  ResearchSubject("ResearchSubject", "http://hl7.org/fhir/fhir-types", "ResearchSubject"),
  RiskAssessment("RiskAssessment", "http://hl7.org/fhir/fhir-types", "RiskAssessment"),
  SampledData("SampledData", "http://hl7.org/fhir/fhir-types", "SampledData"),
  Schedule("Schedule", "http://hl7.org/fhir/fhir-types", "Schedule"),
  SearchParameter("SearchParameter", "http://hl7.org/fhir/fhir-types", "SearchParameter"),
  ServiceRequest("ServiceRequest", "http://hl7.org/fhir/fhir-types", "ServiceRequest"),
  Signature("Signature", "http://hl7.org/fhir/fhir-types", "Signature"),
  Slot("Slot", "http://hl7.org/fhir/fhir-types", "Slot"),
  Specimen("Specimen", "http://hl7.org/fhir/fhir-types", "Specimen"),
  SpecimenDefinition("SpecimenDefinition", "http://hl7.org/fhir/fhir-types", "SpecimenDefinition"),
  String("string", "http://hl7.org/fhir/fhir-types", "string"),
  StructureDefinition(
    "StructureDefinition",
    "http://hl7.org/fhir/fhir-types",
    "StructureDefinition",
  ),
  StructureMap("StructureMap", "http://hl7.org/fhir/fhir-types", "StructureMap"),
  Subscription("Subscription", "http://hl7.org/fhir/fhir-types", "Subscription"),
  SubscriptionStatus("SubscriptionStatus", "http://hl7.org/fhir/fhir-types", "SubscriptionStatus"),
  SubscriptionTopic("SubscriptionTopic", "http://hl7.org/fhir/fhir-types", "SubscriptionTopic"),
  Substance("Substance", "http://hl7.org/fhir/fhir-types", "Substance"),
  SubstanceDefinition(
    "SubstanceDefinition",
    "http://hl7.org/fhir/fhir-types",
    "SubstanceDefinition",
  ),
  SubstanceNucleicAcid(
    "SubstanceNucleicAcid",
    "http://hl7.org/fhir/fhir-types",
    "SubstanceNucleicAcid",
  ),
  SubstancePolymer("SubstancePolymer", "http://hl7.org/fhir/fhir-types", "SubstancePolymer"),
  SubstanceProtein("SubstanceProtein", "http://hl7.org/fhir/fhir-types", "SubstanceProtein"),
  SubstanceReferenceInformation(
    "SubstanceReferenceInformation",
    "http://hl7.org/fhir/fhir-types",
    "SubstanceReferenceInformation",
  ),
  SubstanceSourceMaterial(
    "SubstanceSourceMaterial",
    "http://hl7.org/fhir/fhir-types",
    "SubstanceSourceMaterial",
  ),
  SupplyDelivery("SupplyDelivery", "http://hl7.org/fhir/fhir-types", "SupplyDelivery"),
  SupplyRequest("SupplyRequest", "http://hl7.org/fhir/fhir-types", "SupplyRequest"),
  Task("Task", "http://hl7.org/fhir/fhir-types", "Task"),
  TerminologyCapabilities(
    "TerminologyCapabilities",
    "http://hl7.org/fhir/fhir-types",
    "TerminologyCapabilities",
  ),
  TestPlan("TestPlan", "http://hl7.org/fhir/fhir-types", "TestPlan"),
  TestReport("TestReport", "http://hl7.org/fhir/fhir-types", "TestReport"),
  TestScript("TestScript", "http://hl7.org/fhir/fhir-types", "TestScript"),
  Time("time", "http://hl7.org/fhir/fhir-types", "time"),
  Timing("Timing", "http://hl7.org/fhir/fhir-types", "Timing"),
  Transport("Transport", "http://hl7.org/fhir/fhir-types", "Transport"),
  TriggerDefinition("TriggerDefinition", "http://hl7.org/fhir/fhir-types", "TriggerDefinition"),
  UnsignedInt("unsignedInt", "http://hl7.org/fhir/fhir-types", "unsignedInt"),
  Uri("uri", "http://hl7.org/fhir/fhir-types", "uri"),
  Url("url", "http://hl7.org/fhir/fhir-types", "url"),
  UsageContext("UsageContext", "http://hl7.org/fhir/fhir-types", "UsageContext"),
  Uuid("uuid", "http://hl7.org/fhir/fhir-types", "uuid"),
  ValueSet("ValueSet", "http://hl7.org/fhir/fhir-types", "ValueSet"),
  VerificationResult("VerificationResult", "http://hl7.org/fhir/fhir-types", "VerificationResult"),
  VirtualServiceDetail(
    "VirtualServiceDetail",
    "http://hl7.org/fhir/fhir-types",
    "VirtualServiceDetail",
  ),
  VisionPrescription("VisionPrescription", "http://hl7.org/fhir/fhir-types", "VisionPrescription"),
  Xhtml("xhtml", "http://hl7.org/fhir/fhir-types", "xhtml");

  override fun toString(): kotlin.String = code

  public fun getCode(): kotlin.String = code

  public fun getSystem(): kotlin.String = system

  public fun getDisplay(): kotlin.String? = display

  public companion object {
    public fun fromCode(code: kotlin.String): ConcreteFHIRTypes =
      when (code) {
        "Account" -> Account
        "ActivityDefinition" -> ActivityDefinition
        "ActorDefinition" -> ActorDefinition
        "Address" -> Address
        "AdministrableProductDefinition" -> AdministrableProductDefinition
        "AdverseEvent" -> AdverseEvent
        "Age" -> Age
        "AllergyIntolerance" -> AllergyIntolerance
        "Annotation" -> Annotation
        "Appointment" -> Appointment
        "AppointmentResponse" -> AppointmentResponse
        "ArtifactAssessment" -> ArtifactAssessment
        "Attachment" -> Attachment
        "AuditEvent" -> AuditEvent
        "Availability" -> Availability
        "base64Binary" -> Base64Binary
        "Basic" -> Basic
        "Binary" -> Binary
        "BiologicallyDerivedProduct" -> BiologicallyDerivedProduct
        "BiologicallyDerivedProductDispense" -> BiologicallyDerivedProductDispense
        "BodyStructure" -> BodyStructure
        "boolean" -> Boolean
        "Bundle" -> Bundle
        "canonical" -> Canonical
        "CapabilityStatement" -> CapabilityStatement
        "CarePlan" -> CarePlan
        "CareTeam" -> CareTeam
        "ChargeItem" -> ChargeItem
        "ChargeItemDefinition" -> ChargeItemDefinition
        "Citation" -> Citation
        "Claim" -> Claim
        "ClaimResponse" -> ClaimResponse
        "ClinicalImpression" -> ClinicalImpression
        "ClinicalUseDefinition" -> ClinicalUseDefinition
        "code" -> Code
        "CodeableConcept" -> CodeableConcept
        "CodeableReference" -> CodeableReference
        "CodeSystem" -> CodeSystem
        "Coding" -> Coding
        "Communication" -> Communication
        "CommunicationRequest" -> CommunicationRequest
        "CompartmentDefinition" -> CompartmentDefinition
        "Composition" -> Composition
        "ConceptMap" -> ConceptMap
        "Condition" -> Condition
        "ConditionDefinition" -> ConditionDefinition
        "Consent" -> Consent
        "ContactDetail" -> ContactDetail
        "ContactPoint" -> ContactPoint
        "Contract" -> Contract
        "Contributor" -> Contributor
        "Count" -> Count
        "Coverage" -> Coverage
        "CoverageEligibilityRequest" -> CoverageEligibilityRequest
        "CoverageEligibilityResponse" -> CoverageEligibilityResponse
        "DataRequirement" -> DataRequirement
        "date" -> Date
        "dateTime" -> DateTime
        "decimal" -> Decimal
        "DetectedIssue" -> DetectedIssue
        "Device" -> Device
        "DeviceAssociation" -> DeviceAssociation
        "DeviceDefinition" -> DeviceDefinition
        "DeviceDispense" -> DeviceDispense
        "DeviceMetric" -> DeviceMetric
        "DeviceRequest" -> DeviceRequest
        "DeviceUsage" -> DeviceUsage
        "DiagnosticReport" -> DiagnosticReport
        "Distance" -> Distance
        "DocumentReference" -> DocumentReference
        "Dosage" -> Dosage
        "Duration" -> Duration
        "ElementDefinition" -> ElementDefinition
        "Encounter" -> Encounter
        "EncounterHistory" -> EncounterHistory
        "Endpoint" -> Endpoint
        "EnrollmentRequest" -> EnrollmentRequest
        "EnrollmentResponse" -> EnrollmentResponse
        "EpisodeOfCare" -> EpisodeOfCare
        "EventDefinition" -> EventDefinition
        "Evidence" -> Evidence
        "EvidenceReport" -> EvidenceReport
        "EvidenceVariable" -> EvidenceVariable
        "ExampleScenario" -> ExampleScenario
        "ExplanationOfBenefit" -> ExplanationOfBenefit
        "Expression" -> Expression
        "ExtendedContactDetail" -> ExtendedContactDetail
        "Extension" -> Extension
        "FamilyMemberHistory" -> FamilyMemberHistory
        "Flag" -> Flag
        "FormularyItem" -> FormularyItem
        "GenomicStudy" -> GenomicStudy
        "Goal" -> Goal
        "GraphDefinition" -> GraphDefinition
        "Group" -> Group
        "GuidanceResponse" -> GuidanceResponse
        "HealthcareService" -> HealthcareService
        "HumanName" -> HumanName
        "id" -> Id
        "Identifier" -> Identifier
        "ImagingSelection" -> ImagingSelection
        "ImagingStudy" -> ImagingStudy
        "Immunization" -> Immunization
        "ImmunizationEvaluation" -> ImmunizationEvaluation
        "ImmunizationRecommendation" -> ImmunizationRecommendation
        "ImplementationGuide" -> ImplementationGuide
        "Ingredient" -> Ingredient
        "instant" -> Instant
        "InsurancePlan" -> InsurancePlan
        "integer" -> Integer
        "integer64" -> Integer64
        "InventoryItem" -> InventoryItem
        "InventoryReport" -> InventoryReport
        "Invoice" -> Invoice
        "Library" -> Library
        "Linkage" -> Linkage
        "List" -> List
        "Location" -> Location
        "ManufacturedItemDefinition" -> ManufacturedItemDefinition
        "markdown" -> Markdown
        "MarketingStatus" -> MarketingStatus
        "Measure" -> Measure
        "MeasureReport" -> MeasureReport
        "Medication" -> Medication
        "MedicationAdministration" -> MedicationAdministration
        "MedicationDispense" -> MedicationDispense
        "MedicationKnowledge" -> MedicationKnowledge
        "MedicationRequest" -> MedicationRequest
        "MedicationStatement" -> MedicationStatement
        "MedicinalProductDefinition" -> MedicinalProductDefinition
        "MessageDefinition" -> MessageDefinition
        "MessageHeader" -> MessageHeader
        "Meta" -> Meta
        "MolecularSequence" -> MolecularSequence
        "MonetaryComponent" -> MonetaryComponent
        "Money" -> Money
        "NamingSystem" -> NamingSystem
        "Narrative" -> Narrative
        "NutritionIntake" -> NutritionIntake
        "NutritionOrder" -> NutritionOrder
        "NutritionProduct" -> NutritionProduct
        "Observation" -> Observation
        "ObservationDefinition" -> ObservationDefinition
        "oid" -> Oid
        "OperationDefinition" -> OperationDefinition
        "OperationOutcome" -> OperationOutcome
        "Organization" -> Organization
        "OrganizationAffiliation" -> OrganizationAffiliation
        "PackagedProductDefinition" -> PackagedProductDefinition
        "ParameterDefinition" -> ParameterDefinition
        "Parameters" -> Parameters
        "Patient" -> Patient
        "PaymentNotice" -> PaymentNotice
        "PaymentReconciliation" -> PaymentReconciliation
        "Period" -> Period
        "Permission" -> Permission
        "Person" -> Person
        "PlanDefinition" -> PlanDefinition
        "positiveInt" -> PositiveInt
        "Practitioner" -> Practitioner
        "PractitionerRole" -> PractitionerRole
        "Procedure" -> Procedure
        "ProductShelfLife" -> ProductShelfLife
        "Provenance" -> Provenance
        "Quantity" -> Quantity
        "Questionnaire" -> Questionnaire
        "QuestionnaireResponse" -> QuestionnaireResponse
        "Range" -> Range
        "Ratio" -> Ratio
        "RatioRange" -> RatioRange
        "Reference" -> Reference
        "RegulatedAuthorization" -> RegulatedAuthorization
        "RelatedArtifact" -> RelatedArtifact
        "RelatedPerson" -> RelatedPerson
        "RequestOrchestration" -> RequestOrchestration
        "Requirements" -> Requirements
        "ResearchStudy" -> ResearchStudy
        "ResearchSubject" -> ResearchSubject
        "RiskAssessment" -> RiskAssessment
        "SampledData" -> SampledData
        "Schedule" -> Schedule
        "SearchParameter" -> SearchParameter
        "ServiceRequest" -> ServiceRequest
        "Signature" -> Signature
        "Slot" -> Slot
        "Specimen" -> Specimen
        "SpecimenDefinition" -> SpecimenDefinition
        "string" -> String
        "StructureDefinition" -> StructureDefinition
        "StructureMap" -> StructureMap
        "Subscription" -> Subscription
        "SubscriptionStatus" -> SubscriptionStatus
        "SubscriptionTopic" -> SubscriptionTopic
        "Substance" -> Substance
        "SubstanceDefinition" -> SubstanceDefinition
        "SubstanceNucleicAcid" -> SubstanceNucleicAcid
        "SubstancePolymer" -> SubstancePolymer
        "SubstanceProtein" -> SubstanceProtein
        "SubstanceReferenceInformation" -> SubstanceReferenceInformation
        "SubstanceSourceMaterial" -> SubstanceSourceMaterial
        "SupplyDelivery" -> SupplyDelivery
        "SupplyRequest" -> SupplyRequest
        "Task" -> Task
        "TerminologyCapabilities" -> TerminologyCapabilities
        "TestPlan" -> TestPlan
        "TestReport" -> TestReport
        "TestScript" -> TestScript
        "time" -> Time
        "Timing" -> Timing
        "Transport" -> Transport
        "TriggerDefinition" -> TriggerDefinition
        "unsignedInt" -> UnsignedInt
        "uri" -> Uri
        "url" -> Url
        "UsageContext" -> UsageContext
        "uuid" -> Uuid
        "ValueSet" -> ValueSet
        "VerificationResult" -> VerificationResult
        "VirtualServiceDetail" -> VirtualServiceDetail
        "VisionPrescription" -> VisionPrescription
        "xhtml" -> Xhtml
        else -> throw IllegalArgumentException("Unknown code $code for enum ConcreteFHIRTypes")
      }
  }
}
