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

package dev.ohs.fhir.model.r4.terminologies

import dev.ohs.fhir.model.r4.FhirEnum
import kotlin.String

/**
 * Resource types defined as part of FHIR that can be represented as in-line definitions of a care
 * plan activity.
 */
public enum class CarePlanActivityKind(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Appointment("Appointment", "http://hl7.org/fhir/resource-types", "Appointment"),
  CommunicationRequest(
    "CommunicationRequest",
    "http://hl7.org/fhir/resource-types",
    "CommunicationRequest",
  ),
  DeviceRequest("DeviceRequest", "http://hl7.org/fhir/resource-types", "DeviceRequest"),
  MedicationRequest("MedicationRequest", "http://hl7.org/fhir/resource-types", "MedicationRequest"),
  NutritionOrder("NutritionOrder", "http://hl7.org/fhir/resource-types", "NutritionOrder"),
  Task("Task", "http://hl7.org/fhir/resource-types", "Task"),
  ServiceRequest("ServiceRequest", "http://hl7.org/fhir/resource-types", "ServiceRequest"),
  VisionPrescription(
    "VisionPrescription",
    "http://hl7.org/fhir/resource-types",
    "VisionPrescription",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): CarePlanActivityKind =
      when (code) {
        "Appointment" -> Appointment
        "CommunicationRequest" -> CommunicationRequest
        "DeviceRequest" -> DeviceRequest
        "MedicationRequest" -> MedicationRequest
        "NutritionOrder" -> NutritionOrder
        "Task" -> Task
        "ServiceRequest" -> ServiceRequest
        "VisionPrescription" -> VisionPrescription
        else -> throw IllegalArgumentException("Unknown code $code for enum CarePlanActivityKind")
      }
  }
}
