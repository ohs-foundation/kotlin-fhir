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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Appointment
import dev.ohs.fhir.model.r4b.AppointmentResponse
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AppointmentResponse] resource type. */
public object AppointmentResponseSearchParams {
  public val actor: SearchParam<AppointmentResponse, Reference> =
    SearchParam(
      name = "actor",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor",
      target =
        listOf(
          Practitioner::class,
          Device::class,
          Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          RelatedPerson::class,
          Location::class,
        ),
      extractor = { resource -> listOfNotNull(resource.actor) },
    )

  public val appointment: SearchParam<AppointmentResponse, Reference> =
    SearchParam(
      name = "appointment",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.appointment",
      target = listOf(Appointment::class),
      extractor = { resource -> listOf(resource.appointment) },
    )

  public val identifier: SearchParam<AppointmentResponse, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "AppointmentResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<AppointmentResponse, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor.where(resolve() is Location)",
      target = listOf(Location::class),
      extractor = { resource ->
        listOfNotNull(resource.actor).filter {
          it.reference?.value?.toString()?.contains("Location/") == true
        }
      },
    )

  public val partStatus: SearchParam<AppointmentResponse, Any> =
    SearchParam(
      name = "part-status",
      type = SearchParamType.fromCode("token"),
      expression = "AppointmentResponse.participantStatus",
      extractor = { resource -> listOf(resource.participantStatus) },
    )

  public val patient: SearchParam<AppointmentResponse, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.actor).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val practitioner: SearchParam<AppointmentResponse, Reference> =
    SearchParam(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        listOfNotNull(resource.actor).filter {
          it.reference?.value?.toString()?.contains("Practitioner/") == true
        }
      },
    )

  /** All search parameters for the AppointmentResponse resource type. */
  public val all: List<SearchParam<AppointmentResponse, *>> =
    listOf(actor, appointment, identifier, location, partStatus, patient, practitioner)
}
