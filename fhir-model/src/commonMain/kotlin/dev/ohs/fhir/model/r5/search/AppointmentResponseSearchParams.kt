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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.AppointmentResponse
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AppointmentResponse] resource type. */
public object AppointmentResponseSearchParams {
  public val Actor: SearchParam<AppointmentResponse, Reference> =
    SimpleSearchParam<AppointmentResponse, Reference>(
      name = "actor",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor",
      target =
        listOf(
          HealthcareService::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          dev.ohs.fhir.model.r5.Group::class,
          dev.ohs.fhir.model.r5.Practitioner::class,
          dev.ohs.fhir.model.r5.Location::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.actor) },
    )

  public val Appointment: SearchParam<AppointmentResponse, Reference> =
    SimpleSearchParam<AppointmentResponse, Reference>(
      name = "appointment",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.appointment",
      target = listOf(dev.ohs.fhir.model.r5.Appointment::class),
      extractor = { resource -> listOf(resource.appointment) },
    )

  public val Group: SearchParam<AppointmentResponse, Reference> =
    SimpleSearchParam<AppointmentResponse, Reference>(
      name = "group",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor.where(resolve() is Group)",
      target = listOf(dev.ohs.fhir.model.r5.Group::class),
      extractor = { resource ->
        listOfNotNull(resource.actor).filter {
          it.reference?.value?.toString()?.contains("Group/") == true
        }
      },
    )

  public val Identifier: SearchParam<AppointmentResponse, Identifier> =
    SimpleSearchParam<AppointmentResponse, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "AppointmentResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Location: SearchParam<AppointmentResponse, Reference> =
    SimpleSearchParam<AppointmentResponse, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor.where(resolve() is Location)",
      target = listOf(dev.ohs.fhir.model.r5.Location::class),
      extractor = { resource ->
        listOfNotNull(resource.actor).filter {
          it.reference?.value?.toString()?.contains("Location/") == true
        }
      },
    )

  public val PartStatus: SearchParam<AppointmentResponse, Any> =
    SimpleSearchParam<AppointmentResponse, Any>(
      name = "part-status",
      type = SearchParamType.fromCode("token"),
      expression = "AppointmentResponse.participantStatus",
      extractor = { resource -> listOf(resource.participantStatus) },
    )

  public val Patient: SearchParam<AppointmentResponse, Reference> =
    SimpleSearchParam<AppointmentResponse, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.actor).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Practitioner: SearchParam<AppointmentResponse, Reference> =
    SimpleSearchParam<AppointmentResponse, Reference>(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "AppointmentResponse.actor.where(resolve() is Practitioner)",
      target = listOf(dev.ohs.fhir.model.r5.Practitioner::class),
      extractor = { resource ->
        listOfNotNull(resource.actor).filter {
          it.reference?.value?.toString()?.contains("Practitioner/") == true
        }
      },
    )

  /** All search parameters for the AppointmentResponse resource type. */
  public val ALL: List<SearchParam<AppointmentResponse, *>> =
    listOf(Actor, Appointment, Group, Identifier, Location, PartStatus, Patient, Practitioner)
}
