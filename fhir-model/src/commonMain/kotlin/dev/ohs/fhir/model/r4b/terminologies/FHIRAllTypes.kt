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

package com.google.fhir.model.r4b.terminologies

/**
 * A list of all the concrete types defined in this version of the FHIR specification - Abstract
 * Types, Data Types and Resource Types.
 */
public enum class FHIRAllTypes(
  private val code: kotlin.String,
  private val system: kotlin.String,
  private val display: kotlin.String?,
) {
  Address("Address", "http://hl7.org/fhir/data-types", "Address"),
  Age("Age", "http://hl7.org/fhir/data-types", "Age"),
  Annotation("Annotation", "http://hl7.org/fhir/data-types", "Annotation"),
  Attachment("Attachment", "http://hl7.org/fhir/data-types", "Attachment"),
  BackboneElement("BackboneElement", "http://hl7.org/fhir/data-types", "BackboneElement"),
  CodeableConcept("CodeableConcept", "http://hl7.org/fhir/data-types", "CodeableConcept"),
  CodeableReference("CodeableReference", "http://hl7.org/fhir/data-types", "CodeableReference"),
  Coding("Coding", "http://hl7.org/fhir/data-types", "Coding"),
  ContactDetail("ContactDetail", "http://hl7.org/fhir/data-types", "ContactDetail"),
  ContactPoint("ContactPoint", "http://hl7.org/fhir/data-types", "ContactPoint"),
  Contributor("Contributor", "http://hl7.org/fhir/data-types", "Contributor"),
  Count("Count", "http://hl7.org/fhir/data-types", "Count"),
  DataRequirement("DataRequirement", "http://hl7.org/fhir/data-types", "DataRequirement"),
  Distance("Distance", "http://hl7.org/fhir/data-types", "Distance"),
  Dosage("Dosage", "http://hl7.org/fhir/data-types", "Dosage"),
  Duration("Duration", "http://hl7.org/fhir/data-types", "Duration"),
  Element("Element", "http://hl7.org/fhir/data-types", "Element"),
  ElementDefinition("ElementDefinition", "http://hl7.org/fhir/data-types", "ElementDefinition"),
  Expression("Expression", "http://hl7.org/fhir/data-types", "Expression"),
  Extension("Extension", "http://hl7.org/fhir/data-types", "Extension"),
  HumanName("HumanName", "http://hl7.org/fhir/data-types", "HumanName"),
  Identifier("Identifier", "http://hl7.org/fhir/data-types", "Identifier"),
  MarketingStatus("MarketingStatus", "http://hl7.org/fhir/data-types", "MarketingStatus"),
  Meta("Meta", "http://hl7.org/fhir/data-types", "Meta"),
  Money("Money", "http://hl7.org/fhir/data-types", "Money"),
  MoneyQuantity("MoneyQuantity", "http://hl7.org/fhir/data-types", "MoneyQuantity"),
  Narrative("Narrative", "http://hl7.org/fhir/data-types", "Narrative"),
  ParameterDefinition(
    "ParameterDefinition",
    "http://hl7.org/fhir/data-types",
    "ParameterDefinition",
  ),
  Period("Period", "http://hl7.org/fhir/data-types", "Period"),
  Population("Population", "http://hl7.org/fhir/data-types", "Population"),
  ProdCharacteristic("ProdCharacteristic", "http://hl7.org/fhir/data-types", "ProdCharacteristic"),
  ProductShelfLife("ProductShelfLife", "http://hl7.org/fhir/data-types", "ProductShelfLife"),
  Quantity("Quantity", "http://hl7.org/fhir/data-types", "Quantity"),
  Range("Range", "http://hl7.org/fhir/data-types", "Range"),
  Ratio("Ratio", "http://hl7.org/fhir/data-types", "Ratio"),
  RatioRange("RatioRange", "http://hl7.org/fhir/data-types", "RatioRange"),
  Reference("Reference", "http://hl7.org/fhir/data-types", "Reference"),
  RelatedArtifact("RelatedArtifact", "http://hl7.org/fhir/data-types", "RelatedArtifact"),
  SampledData("SampledData", "http://hl7.org/fhir/data-types", "SampledData"),
  Signature("Signature", "http://hl7.org/fhir/data-types", "Signature"),
  SimpleQuantity("SimpleQuantity", "http://hl7.org/fhir/data-types", "SimpleQuantity"),
  Timing("Timing", "http://hl7.org/fhir/data-types", "Timing"),
  TriggerDefinition("TriggerDefinition", "http://hl7.org/fhir/data-types", "TriggerDefinition"),
  UsageContext("UsageContext", "http://hl7.org/fhir/data-types", "UsageContext"),
  Base64Binary("base64Binary", "http://hl7.org/fhir/data-types", "base64Binary"),
  Boolean("boolean", "http://hl7.org/fhir/data-types", "boolean"),
  Canonical("canonical", "http://hl7.org/fhir/data-types", "canonical"),
  Code("code", "http://hl7.org/fhir/data-types", "code"),
  Date("date", "http://hl7.org/fhir/data-types", "date"),
  DateTime("dateTime", "http://hl7.org/fhir/data-types", "dateTime"),
  Decimal("decimal", "http://hl7.org/fhir/data-types", "decimal"),
  Id("id", "http://hl7.org/fhir/data-types", "id"),
  Instant("instant", "http://hl7.org/fhir/data-types", "instant"),
  Integer("integer", "http://hl7.org/fhir/data-types", "integer"),
  Markdown("markdown", "http://hl7.org/fhir/data-types", "markdown"),
  Oid("oid", "http://hl7.org/fhir/data-types", "oid"),
  PositiveInt("positiveInt", "http://hl7.org/fhir/data-types", "positiveInt"),
  String("string", "http://hl7.org/fhir/data-types", "string"),
  Time("time", "http://hl7.org/fhir/data-types", "time"),
  UnsignedInt("unsignedInt", "http://hl7.org/fhir/data-types", "unsignedInt"),
  Uri("uri", "http://hl7.org/fhir/data-types", "uri"),
  Url("url", "http://hl7.org/fhir/data-types", "url"),
  Uuid("uuid", "http://hl7.org/fhir/data-types", "uuid"),
  Xhtml("xhtml", "http://hl7.org/fhir/data-types", "XHTML"),
  Resource("Resource", "http://hl7.org/fhir/resource-types", "Resource"),
  Binary("Binary", "http://hl7.org/fhir/resource-types", "Binary"),
  Bundle("Bundle", "http://hl7.org/fhir/resource-types", "Bundle"),
  DomainResource("DomainResource", "http://hl7.org/fhir/resource-types", "DomainResource"),
  Account("Account", "http://hl7.org/fhir/resource-types", "Account"),
  ActivityDefinition(
    "ActivityDefinition",
    "http://hl7.org/fhir/resource-types",
    "ActivityDefinition",
  ),
  AdministrableProductDefinition(
    "AdministrableProductDefinition",
    "http://hl7.org/fhir/resource-types",
    "AdministrableProductDefinition",
  ),
  AdverseEvent("AdverseEvent", "http://hl7.org/fhir/resource-types", "AdverseEvent"),
  AllergyIntolerance(
    "AllergyIntolerance",
    "http://hl7.org/fhir/resource-types",
    "AllergyIntolerance",
  ),
  Appointment("Appointment", "http://hl7.org/fhir/resource-types", "Appointment"),
  AppointmentResponse(
    "AppointmentResponse",
    "http://hl7.org/fhir/resource-types",
    "AppointmentResponse",
  ),
  AuditEvent("AuditEvent", "http://hl7.org/fhir/resource-types", "AuditEvent"),
  Basic("Basic", "http://hl7.org/fhir/resource-types", "Basic"),
  BiologicallyDerivedProduct(
    "BiologicallyDerivedProduct",
    "http://hl7.org/fhir/resource-types",
    "BiologicallyDerivedProduct",
  ),
  BodyStructure("BodyStructure", "http://hl7.org/fhir/resource-types", "BodyStructure"),
  CapabilityStatement(
    "CapabilityStatement",
    "http://hl7.org/fhir/resource-types",
    "CapabilityStatement",
  ),
  CarePlan("CarePlan", "http://hl7.org/fhir/resource-types", "CarePlan"),
  CareTeam("CareTeam", "http://hl7.org/fhir/resource-types", "CareTeam"),
  CatalogEntry("CatalogEntry", "http://hl7.org/fhir/resource-types", "CatalogEntry"),
  ChargeItem("ChargeItem", "http://hl7.org/fhir/resource-types", "ChargeItem"),
  ChargeItemDefinition(
    "ChargeItemDefinition",
    "http://hl7.org/fhir/resource-types",
    "ChargeItemDefinition",
  ),
  Citation("Citation", "http://hl7.org/fhir/resource-types", "Citation"),
  Claim("Claim", "http://hl7.org/fhir/resource-types", "Claim"),
  ClaimResponse("ClaimResponse", "http://hl7.org/fhir/resource-types", "ClaimResponse"),
  ClinicalImpression(
    "ClinicalImpression",
    "http://hl7.org/fhir/resource-types",
    "ClinicalImpression",
  ),
  ClinicalUseDefinition(
    "ClinicalUseDefinition",
    "http://hl7.org/fhir/resource-types",
    "ClinicalUseDefinition",
  ),
  CodeSystem("CodeSystem", "http://hl7.org/fhir/resource-types", "CodeSystem"),
  Communication("Communication", "http://hl7.org/fhir/resource-types", "Communication"),
  CommunicationRequest(
    "CommunicationRequest",
    "http://hl7.org/fhir/resource-types",
    "CommunicationRequest",
  ),
  CompartmentDefinition(
    "CompartmentDefinition",
    "http://hl7.org/fhir/resource-types",
    "CompartmentDefinition",
  ),
  Composition("Composition", "http://hl7.org/fhir/resource-types", "Composition"),
  ConceptMap("ConceptMap", "http://hl7.org/fhir/resource-types", "ConceptMap"),
  Condition("Condition", "http://hl7.org/fhir/resource-types", "Condition"),
  Consent("Consent", "http://hl7.org/fhir/resource-types", "Consent"),
  Contract("Contract", "http://hl7.org/fhir/resource-types", "Contract"),
  Coverage("Coverage", "http://hl7.org/fhir/resource-types", "Coverage"),
  CoverageEligibilityRequest(
    "CoverageEligibilityRequest",
    "http://hl7.org/fhir/resource-types",
    "CoverageEligibilityRequest",
  ),
  CoverageEligibilityResponse(
    "CoverageEligibilityResponse",
    "http://hl7.org/fhir/resource-types",
    "CoverageEligibilityResponse",
  ),
  DetectedIssue("DetectedIssue", "http://hl7.org/fhir/resource-types", "DetectedIssue"),
  Device("Device", "http://hl7.org/fhir/resource-types", "Device"),
  DeviceDefinition("DeviceDefinition", "http://hl7.org/fhir/resource-types", "DeviceDefinition"),
  DeviceMetric("DeviceMetric", "http://hl7.org/fhir/resource-types", "DeviceMetric"),
  DeviceRequest("DeviceRequest", "http://hl7.org/fhir/resource-types", "DeviceRequest"),
  DeviceUseStatement(
    "DeviceUseStatement",
    "http://hl7.org/fhir/resource-types",
    "DeviceUseStatement",
  ),
  DiagnosticReport("DiagnosticReport", "http://hl7.org/fhir/resource-types", "DiagnosticReport"),
  DocumentManifest("DocumentManifest", "http://hl7.org/fhir/resource-types", "DocumentManifest"),
  DocumentReference("DocumentReference", "http://hl7.org/fhir/resource-types", "DocumentReference"),
  Encounter("Encounter", "http://hl7.org/fhir/resource-types", "Encounter"),
  Endpoint("Endpoint", "http://hl7.org/fhir/resource-types", "Endpoint"),
  EnrollmentRequest("EnrollmentRequest", "http://hl7.org/fhir/resource-types", "EnrollmentRequest"),
  EnrollmentResponse(
    "EnrollmentResponse",
    "http://hl7.org/fhir/resource-types",
    "EnrollmentResponse",
  ),
  EpisodeOfCare("EpisodeOfCare", "http://hl7.org/fhir/resource-types", "EpisodeOfCare"),
  EventDefinition("EventDefinition", "http://hl7.org/fhir/resource-types", "EventDefinition"),
  Evidence("Evidence", "http://hl7.org/fhir/resource-types", "Evidence"),
  EvidenceReport("EvidenceReport", "http://hl7.org/fhir/resource-types", "EvidenceReport"),
  EvidenceVariable("EvidenceVariable", "http://hl7.org/fhir/resource-types", "EvidenceVariable"),
  ExampleScenario("ExampleScenario", "http://hl7.org/fhir/resource-types", "ExampleScenario"),
  ExplanationOfBenefit(
    "ExplanationOfBenefit",
    "http://hl7.org/fhir/resource-types",
    "ExplanationOfBenefit",
  ),
  FamilyMemberHistory(
    "FamilyMemberHistory",
    "http://hl7.org/fhir/resource-types",
    "FamilyMemberHistory",
  ),
  Flag("Flag", "http://hl7.org/fhir/resource-types", "Flag"),
  Goal("Goal", "http://hl7.org/fhir/resource-types", "Goal"),
  GraphDefinition("GraphDefinition", "http://hl7.org/fhir/resource-types", "GraphDefinition"),
  Group("Group", "http://hl7.org/fhir/resource-types", "Group"),
  GuidanceResponse("GuidanceResponse", "http://hl7.org/fhir/resource-types", "GuidanceResponse"),
  HealthcareService("HealthcareService", "http://hl7.org/fhir/resource-types", "HealthcareService"),
  ImagingStudy("ImagingStudy", "http://hl7.org/fhir/resource-types", "ImagingStudy"),
  Immunization("Immunization", "http://hl7.org/fhir/resource-types", "Immunization"),
  ImmunizationEvaluation(
    "ImmunizationEvaluation",
    "http://hl7.org/fhir/resource-types",
    "ImmunizationEvaluation",
  ),
  ImmunizationRecommendation(
    "ImmunizationRecommendation",
    "http://hl7.org/fhir/resource-types",
    "ImmunizationRecommendation",
  ),
  ImplementationGuide(
    "ImplementationGuide",
    "http://hl7.org/fhir/resource-types",
    "ImplementationGuide",
  ),
  Ingredient("Ingredient", "http://hl7.org/fhir/resource-types", "Ingredient"),
  InsurancePlan("InsurancePlan", "http://hl7.org/fhir/resource-types", "InsurancePlan"),
  Invoice("Invoice", "http://hl7.org/fhir/resource-types", "Invoice"),
  Library("Library", "http://hl7.org/fhir/resource-types", "Library"),
  Linkage("Linkage", "http://hl7.org/fhir/resource-types", "Linkage"),
  List("List", "http://hl7.org/fhir/resource-types", "List"),
  Location("Location", "http://hl7.org/fhir/resource-types", "Location"),
  ManufacturedItemDefinition(
    "ManufacturedItemDefinition",
    "http://hl7.org/fhir/resource-types",
    "ManufacturedItemDefinition",
  ),
  Measure("Measure", "http://hl7.org/fhir/resource-types", "Measure"),
  MeasureReport("MeasureReport", "http://hl7.org/fhir/resource-types", "MeasureReport"),
  Media("Media", "http://hl7.org/fhir/resource-types", "Media"),
  Medication("Medication", "http://hl7.org/fhir/resource-types", "Medication"),
  MedicationAdministration(
    "MedicationAdministration",
    "http://hl7.org/fhir/resource-types",
    "MedicationAdministration",
  ),
  MedicationDispense(
    "MedicationDispense",
    "http://hl7.org/fhir/resource-types",
    "MedicationDispense",
  ),
  MedicationKnowledge(
    "MedicationKnowledge",
    "http://hl7.org/fhir/resource-types",
    "MedicationKnowledge",
  ),
  MedicationRequest("MedicationRequest", "http://hl7.org/fhir/resource-types", "MedicationRequest"),
  MedicationStatement(
    "MedicationStatement",
    "http://hl7.org/fhir/resource-types",
    "MedicationStatement",
  ),
  MedicinalProductDefinition(
    "MedicinalProductDefinition",
    "http://hl7.org/fhir/resource-types",
    "MedicinalProductDefinition",
  ),
  MessageDefinition("MessageDefinition", "http://hl7.org/fhir/resource-types", "MessageDefinition"),
  MessageHeader("MessageHeader", "http://hl7.org/fhir/resource-types", "MessageHeader"),
  MolecularSequence("MolecularSequence", "http://hl7.org/fhir/resource-types", "MolecularSequence"),
  NamingSystem("NamingSystem", "http://hl7.org/fhir/resource-types", "NamingSystem"),
  NutritionOrder("NutritionOrder", "http://hl7.org/fhir/resource-types", "NutritionOrder"),
  NutritionProduct("NutritionProduct", "http://hl7.org/fhir/resource-types", "NutritionProduct"),
  Observation("Observation", "http://hl7.org/fhir/resource-types", "Observation"),
  ObservationDefinition(
    "ObservationDefinition",
    "http://hl7.org/fhir/resource-types",
    "ObservationDefinition",
  ),
  OperationDefinition(
    "OperationDefinition",
    "http://hl7.org/fhir/resource-types",
    "OperationDefinition",
  ),
  OperationOutcome("OperationOutcome", "http://hl7.org/fhir/resource-types", "OperationOutcome"),
  Organization("Organization", "http://hl7.org/fhir/resource-types", "Organization"),
  OrganizationAffiliation(
    "OrganizationAffiliation",
    "http://hl7.org/fhir/resource-types",
    "OrganizationAffiliation",
  ),
  PackagedProductDefinition(
    "PackagedProductDefinition",
    "http://hl7.org/fhir/resource-types",
    "PackagedProductDefinition",
  ),
  Patient("Patient", "http://hl7.org/fhir/resource-types", "Patient"),
  PaymentNotice("PaymentNotice", "http://hl7.org/fhir/resource-types", "PaymentNotice"),
  PaymentReconciliation(
    "PaymentReconciliation",
    "http://hl7.org/fhir/resource-types",
    "PaymentReconciliation",
  ),
  Person("Person", "http://hl7.org/fhir/resource-types", "Person"),
  PlanDefinition("PlanDefinition", "http://hl7.org/fhir/resource-types", "PlanDefinition"),
  Practitioner("Practitioner", "http://hl7.org/fhir/resource-types", "Practitioner"),
  PractitionerRole("PractitionerRole", "http://hl7.org/fhir/resource-types", "PractitionerRole"),
  Procedure("Procedure", "http://hl7.org/fhir/resource-types", "Procedure"),
  Provenance("Provenance", "http://hl7.org/fhir/resource-types", "Provenance"),
  Questionnaire("Questionnaire", "http://hl7.org/fhir/resource-types", "Questionnaire"),
  QuestionnaireResponse(
    "QuestionnaireResponse",
    "http://hl7.org/fhir/resource-types",
    "QuestionnaireResponse",
  ),
  RegulatedAuthorization(
    "RegulatedAuthorization",
    "http://hl7.org/fhir/resource-types",
    "RegulatedAuthorization",
  ),
  RelatedPerson("RelatedPerson", "http://hl7.org/fhir/resource-types", "RelatedPerson"),
  RequestGroup("RequestGroup", "http://hl7.org/fhir/resource-types", "RequestGroup"),
  ResearchDefinition(
    "ResearchDefinition",
    "http://hl7.org/fhir/resource-types",
    "ResearchDefinition",
  ),
  ResearchElementDefinition(
    "ResearchElementDefinition",
    "http://hl7.org/fhir/resource-types",
    "ResearchElementDefinition",
  ),
  ResearchStudy("ResearchStudy", "http://hl7.org/fhir/resource-types", "ResearchStudy"),
  ResearchSubject("ResearchSubject", "http://hl7.org/fhir/resource-types", "ResearchSubject"),
  RiskAssessment("RiskAssessment", "http://hl7.org/fhir/resource-types", "RiskAssessment"),
  Schedule("Schedule", "http://hl7.org/fhir/resource-types", "Schedule"),
  SearchParameter("SearchParameter", "http://hl7.org/fhir/resource-types", "SearchParameter"),
  ServiceRequest("ServiceRequest", "http://hl7.org/fhir/resource-types", "ServiceRequest"),
  Slot("Slot", "http://hl7.org/fhir/resource-types", "Slot"),
  Specimen("Specimen", "http://hl7.org/fhir/resource-types", "Specimen"),
  SpecimenDefinition(
    "SpecimenDefinition",
    "http://hl7.org/fhir/resource-types",
    "SpecimenDefinition",
  ),
  StructureDefinition(
    "StructureDefinition",
    "http://hl7.org/fhir/resource-types",
    "StructureDefinition",
  ),
  StructureMap("StructureMap", "http://hl7.org/fhir/resource-types", "StructureMap"),
  Subscription("Subscription", "http://hl7.org/fhir/resource-types", "Subscription"),
  SubscriptionStatus(
    "SubscriptionStatus",
    "http://hl7.org/fhir/resource-types",
    "SubscriptionStatus",
  ),
  SubscriptionTopic("SubscriptionTopic", "http://hl7.org/fhir/resource-types", "SubscriptionTopic"),
  Substance("Substance", "http://hl7.org/fhir/resource-types", "Substance"),
  SubstanceDefinition(
    "SubstanceDefinition",
    "http://hl7.org/fhir/resource-types",
    "SubstanceDefinition",
  ),
  SupplyDelivery("SupplyDelivery", "http://hl7.org/fhir/resource-types", "SupplyDelivery"),
  SupplyRequest("SupplyRequest", "http://hl7.org/fhir/resource-types", "SupplyRequest"),
  Task("Task", "http://hl7.org/fhir/resource-types", "Task"),
  TerminologyCapabilities(
    "TerminologyCapabilities",
    "http://hl7.org/fhir/resource-types",
    "TerminologyCapabilities",
  ),
  TestReport("TestReport", "http://hl7.org/fhir/resource-types", "TestReport"),
  TestScript("TestScript", "http://hl7.org/fhir/resource-types", "TestScript"),
  ValueSet("ValueSet", "http://hl7.org/fhir/resource-types", "ValueSet"),
  VerificationResult(
    "VerificationResult",
    "http://hl7.org/fhir/resource-types",
    "VerificationResult",
  ),
  VisionPrescription(
    "VisionPrescription",
    "http://hl7.org/fhir/resource-types",
    "VisionPrescription",
  ),
  Parameters("Parameters", "http://hl7.org/fhir/resource-types", "Parameters"),
  Type("Type", "http://hl7.org/fhir/abstract-types", "Type"),
  Any("Any", "http://hl7.org/fhir/abstract-types", "Any");

  override fun toString(): kotlin.String = code

  public fun getCode(): kotlin.String = code

  public fun getSystem(): kotlin.String = system

  public fun getDisplay(): kotlin.String? = display

  public companion object {
    public fun fromCode(code: kotlin.String): FHIRAllTypes =
      when (code) {
        "Address" -> Address
        "Age" -> Age
        "Annotation" -> Annotation
        "Attachment" -> Attachment
        "BackboneElement" -> BackboneElement
        "CodeableConcept" -> CodeableConcept
        "CodeableReference" -> CodeableReference
        "Coding" -> Coding
        "ContactDetail" -> ContactDetail
        "ContactPoint" -> ContactPoint
        "Contributor" -> Contributor
        "Count" -> Count
        "DataRequirement" -> DataRequirement
        "Distance" -> Distance
        "Dosage" -> Dosage
        "Duration" -> Duration
        "Element" -> Element
        "ElementDefinition" -> ElementDefinition
        "Expression" -> Expression
        "Extension" -> Extension
        "HumanName" -> HumanName
        "Identifier" -> Identifier
        "MarketingStatus" -> MarketingStatus
        "Meta" -> Meta
        "Money" -> Money
        "MoneyQuantity" -> MoneyQuantity
        "Narrative" -> Narrative
        "ParameterDefinition" -> ParameterDefinition
        "Period" -> Period
        "Population" -> Population
        "ProdCharacteristic" -> ProdCharacteristic
        "ProductShelfLife" -> ProductShelfLife
        "Quantity" -> Quantity
        "Range" -> Range
        "Ratio" -> Ratio
        "RatioRange" -> RatioRange
        "Reference" -> Reference
        "RelatedArtifact" -> RelatedArtifact
        "SampledData" -> SampledData
        "Signature" -> Signature
        "SimpleQuantity" -> SimpleQuantity
        "Timing" -> Timing
        "TriggerDefinition" -> TriggerDefinition
        "UsageContext" -> UsageContext
        "base64Binary" -> Base64Binary
        "boolean" -> Boolean
        "canonical" -> Canonical
        "code" -> Code
        "date" -> Date
        "dateTime" -> DateTime
        "decimal" -> Decimal
        "id" -> Id
        "instant" -> Instant
        "integer" -> Integer
        "markdown" -> Markdown
        "oid" -> Oid
        "positiveInt" -> PositiveInt
        "string" -> String
        "time" -> Time
        "unsignedInt" -> UnsignedInt
        "uri" -> Uri
        "url" -> Url
        "uuid" -> Uuid
        "xhtml" -> Xhtml
        "Resource" -> Resource
        "Binary" -> Binary
        "Bundle" -> Bundle
        "DomainResource" -> DomainResource
        "Account" -> Account
        "ActivityDefinition" -> ActivityDefinition
        "AdministrableProductDefinition" -> AdministrableProductDefinition
        "AdverseEvent" -> AdverseEvent
        "AllergyIntolerance" -> AllergyIntolerance
        "Appointment" -> Appointment
        "AppointmentResponse" -> AppointmentResponse
        "AuditEvent" -> AuditEvent
        "Basic" -> Basic
        "BiologicallyDerivedProduct" -> BiologicallyDerivedProduct
        "BodyStructure" -> BodyStructure
        "CapabilityStatement" -> CapabilityStatement
        "CarePlan" -> CarePlan
        "CareTeam" -> CareTeam
        "CatalogEntry" -> CatalogEntry
        "ChargeItem" -> ChargeItem
        "ChargeItemDefinition" -> ChargeItemDefinition
        "Citation" -> Citation
        "Claim" -> Claim
        "ClaimResponse" -> ClaimResponse
        "ClinicalImpression" -> ClinicalImpression
        "ClinicalUseDefinition" -> ClinicalUseDefinition
        "CodeSystem" -> CodeSystem
        "Communication" -> Communication
        "CommunicationRequest" -> CommunicationRequest
        "CompartmentDefinition" -> CompartmentDefinition
        "Composition" -> Composition
        "ConceptMap" -> ConceptMap
        "Condition" -> Condition
        "Consent" -> Consent
        "Contract" -> Contract
        "Coverage" -> Coverage
        "CoverageEligibilityRequest" -> CoverageEligibilityRequest
        "CoverageEligibilityResponse" -> CoverageEligibilityResponse
        "DetectedIssue" -> DetectedIssue
        "Device" -> Device
        "DeviceDefinition" -> DeviceDefinition
        "DeviceMetric" -> DeviceMetric
        "DeviceRequest" -> DeviceRequest
        "DeviceUseStatement" -> DeviceUseStatement
        "DiagnosticReport" -> DiagnosticReport
        "DocumentManifest" -> DocumentManifest
        "DocumentReference" -> DocumentReference
        "Encounter" -> Encounter
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
        "FamilyMemberHistory" -> FamilyMemberHistory
        "Flag" -> Flag
        "Goal" -> Goal
        "GraphDefinition" -> GraphDefinition
        "Group" -> Group
        "GuidanceResponse" -> GuidanceResponse
        "HealthcareService" -> HealthcareService
        "ImagingStudy" -> ImagingStudy
        "Immunization" -> Immunization
        "ImmunizationEvaluation" -> ImmunizationEvaluation
        "ImmunizationRecommendation" -> ImmunizationRecommendation
        "ImplementationGuide" -> ImplementationGuide
        "Ingredient" -> Ingredient
        "InsurancePlan" -> InsurancePlan
        "Invoice" -> Invoice
        "Library" -> Library
        "Linkage" -> Linkage
        "List" -> List
        "Location" -> Location
        "ManufacturedItemDefinition" -> ManufacturedItemDefinition
        "Measure" -> Measure
        "MeasureReport" -> MeasureReport
        "Media" -> Media
        "Medication" -> Medication
        "MedicationAdministration" -> MedicationAdministration
        "MedicationDispense" -> MedicationDispense
        "MedicationKnowledge" -> MedicationKnowledge
        "MedicationRequest" -> MedicationRequest
        "MedicationStatement" -> MedicationStatement
        "MedicinalProductDefinition" -> MedicinalProductDefinition
        "MessageDefinition" -> MessageDefinition
        "MessageHeader" -> MessageHeader
        "MolecularSequence" -> MolecularSequence
        "NamingSystem" -> NamingSystem
        "NutritionOrder" -> NutritionOrder
        "NutritionProduct" -> NutritionProduct
        "Observation" -> Observation
        "ObservationDefinition" -> ObservationDefinition
        "OperationDefinition" -> OperationDefinition
        "OperationOutcome" -> OperationOutcome
        "Organization" -> Organization
        "OrganizationAffiliation" -> OrganizationAffiliation
        "PackagedProductDefinition" -> PackagedProductDefinition
        "Patient" -> Patient
        "PaymentNotice" -> PaymentNotice
        "PaymentReconciliation" -> PaymentReconciliation
        "Person" -> Person
        "PlanDefinition" -> PlanDefinition
        "Practitioner" -> Practitioner
        "PractitionerRole" -> PractitionerRole
        "Procedure" -> Procedure
        "Provenance" -> Provenance
        "Questionnaire" -> Questionnaire
        "QuestionnaireResponse" -> QuestionnaireResponse
        "RegulatedAuthorization" -> RegulatedAuthorization
        "RelatedPerson" -> RelatedPerson
        "RequestGroup" -> RequestGroup
        "ResearchDefinition" -> ResearchDefinition
        "ResearchElementDefinition" -> ResearchElementDefinition
        "ResearchStudy" -> ResearchStudy
        "ResearchSubject" -> ResearchSubject
        "RiskAssessment" -> RiskAssessment
        "Schedule" -> Schedule
        "SearchParameter" -> SearchParameter
        "ServiceRequest" -> ServiceRequest
        "Slot" -> Slot
        "Specimen" -> Specimen
        "SpecimenDefinition" -> SpecimenDefinition
        "StructureDefinition" -> StructureDefinition
        "StructureMap" -> StructureMap
        "Subscription" -> Subscription
        "SubscriptionStatus" -> SubscriptionStatus
        "SubscriptionTopic" -> SubscriptionTopic
        "Substance" -> Substance
        "SubstanceDefinition" -> SubstanceDefinition
        "SupplyDelivery" -> SupplyDelivery
        "SupplyRequest" -> SupplyRequest
        "Task" -> Task
        "TerminologyCapabilities" -> TerminologyCapabilities
        "TestReport" -> TestReport
        "TestScript" -> TestScript
        "ValueSet" -> ValueSet
        "VerificationResult" -> VerificationResult
        "VisionPrescription" -> VisionPrescription
        "Parameters" -> Parameters
        "Type" -> Type
        "Any" -> Any
        else -> throw IllegalArgumentException("Unknown code $code for enum FHIRAllTypes")
      }
  }
}
