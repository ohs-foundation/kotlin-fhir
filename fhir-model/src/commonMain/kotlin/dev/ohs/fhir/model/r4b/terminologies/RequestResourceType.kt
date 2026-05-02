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

import kotlin.String

/** A list of all the request resource types defined in this version of the FHIR specification. */
public enum class RequestResourceType(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Appointment("Appointment", "http://hl7.org/fhir/request-resource-types", "Appointment"),
  AppointmentResponse(
    "AppointmentResponse",
    "http://hl7.org/fhir/request-resource-types",
    "AppointmentResponse",
  ),
  CarePlan("CarePlan", "http://hl7.org/fhir/request-resource-types", "CarePlan"),
  Claim("Claim", "http://hl7.org/fhir/request-resource-types", "Claim"),
  CommunicationRequest(
    "CommunicationRequest",
    "http://hl7.org/fhir/request-resource-types",
    "CommunicationRequest",
  ),
  Contract("Contract", "http://hl7.org/fhir/request-resource-types", "Contract"),
  DeviceRequest("DeviceRequest", "http://hl7.org/fhir/request-resource-types", "DeviceRequest"),
  EnrollmentRequest(
    "EnrollmentRequest",
    "http://hl7.org/fhir/request-resource-types",
    "EnrollmentRequest",
  ),
  ImmunizationRecommendation(
    "ImmunizationRecommendation",
    "http://hl7.org/fhir/request-resource-types",
    "ImmunizationRecommendation",
  ),
  MedicationRequest(
    "MedicationRequest",
    "http://hl7.org/fhir/request-resource-types",
    "MedicationRequest",
  ),
  NutritionOrder("NutritionOrder", "http://hl7.org/fhir/request-resource-types", "NutritionOrder"),
  ServiceRequest("ServiceRequest", "http://hl7.org/fhir/request-resource-types", "ServiceRequest"),
  SupplyRequest("SupplyRequest", "http://hl7.org/fhir/request-resource-types", "SupplyRequest"),
  Task("Task", "http://hl7.org/fhir/request-resource-types", "Task"),
  VisionPrescription(
    "VisionPrescription",
    "http://hl7.org/fhir/request-resource-types",
    "VisionPrescription",
  );

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): RequestResourceType =
      when (code) {
        "Appointment" -> Appointment
        "AppointmentResponse" -> AppointmentResponse
        "CarePlan" -> CarePlan
        "Claim" -> Claim
        "CommunicationRequest" -> CommunicationRequest
        "Contract" -> Contract
        "DeviceRequest" -> DeviceRequest
        "EnrollmentRequest" -> EnrollmentRequest
        "ImmunizationRecommendation" -> ImmunizationRecommendation
        "MedicationRequest" -> MedicationRequest
        "NutritionOrder" -> NutritionOrder
        "ServiceRequest" -> ServiceRequest
        "SupplyRequest" -> SupplyRequest
        "Task" -> Task
        "VisionPrescription" -> VisionPrescription
        else -> throw IllegalArgumentException("Unknown code $code for enum RequestResourceType")
      }
  }
}
