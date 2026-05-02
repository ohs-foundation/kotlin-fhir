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

import kotlin.String

/** All Resource Types that represent request resources */
public enum class RequestResourceTypes(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Appointment("Appointment", "http://hl7.org/fhir/fhir-types", "Appointment"),
  AppointmentResponse(
    "AppointmentResponse",
    "http://hl7.org/fhir/fhir-types",
    "AppointmentResponse",
  ),
  CarePlan("CarePlan", "http://hl7.org/fhir/fhir-types", "CarePlan"),
  Claim("Claim", "http://hl7.org/fhir/fhir-types", "Claim"),
  CommunicationRequest(
    "CommunicationRequest",
    "http://hl7.org/fhir/fhir-types",
    "CommunicationRequest",
  ),
  CoverageEligibilityRequest(
    "CoverageEligibilityRequest",
    "http://hl7.org/fhir/fhir-types",
    "CoverageEligibilityRequest",
  ),
  DeviceRequest("DeviceRequest", "http://hl7.org/fhir/fhir-types", "DeviceRequest"),
  EnrollmentRequest("EnrollmentRequest", "http://hl7.org/fhir/fhir-types", "EnrollmentRequest"),
  ImmunizationRecommendation(
    "ImmunizationRecommendation",
    "http://hl7.org/fhir/fhir-types",
    "ImmunizationRecommendation",
  ),
  MedicationRequest("MedicationRequest", "http://hl7.org/fhir/fhir-types", "MedicationRequest"),
  NutritionOrder("NutritionOrder", "http://hl7.org/fhir/fhir-types", "NutritionOrder"),
  RequestOrchestration(
    "RequestOrchestration",
    "http://hl7.org/fhir/fhir-types",
    "RequestOrchestration",
  ),
  ServiceRequest("ServiceRequest", "http://hl7.org/fhir/fhir-types", "ServiceRequest"),
  SupplyRequest("SupplyRequest", "http://hl7.org/fhir/fhir-types", "SupplyRequest"),
  Task("Task", "http://hl7.org/fhir/fhir-types", "Task"),
  Transport("Transport", "http://hl7.org/fhir/fhir-types", "Transport"),
  VisionPrescription("VisionPrescription", "http://hl7.org/fhir/fhir-types", "VisionPrescription");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): RequestResourceTypes =
      when (code) {
        "Appointment" -> Appointment
        "AppointmentResponse" -> AppointmentResponse
        "CarePlan" -> CarePlan
        "Claim" -> Claim
        "CommunicationRequest" -> CommunicationRequest
        "CoverageEligibilityRequest" -> CoverageEligibilityRequest
        "DeviceRequest" -> DeviceRequest
        "EnrollmentRequest" -> EnrollmentRequest
        "ImmunizationRecommendation" -> ImmunizationRecommendation
        "MedicationRequest" -> MedicationRequest
        "NutritionOrder" -> NutritionOrder
        "RequestOrchestration" -> RequestOrchestration
        "ServiceRequest" -> ServiceRequest
        "SupplyRequest" -> SupplyRequest
        "Task" -> Task
        "Transport" -> Transport
        "VisionPrescription" -> VisionPrescription
        else -> throw IllegalArgumentException("Unknown code $code for enum RequestResourceTypes")
      }
  }
}
