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

import dev.ohs.fhir.model.r4b.AppointmentResponse
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [AppointmentResponse] resource type. */
public object AppointmentResponseSearchParam {
  /** All search parameters for the AppointmentResponse resource type. */
  public val ALL: List<SearchParam<AppointmentResponse, *>> =
    listOf(Actor, Appointment, Identifier, Location, PartStatus, Patient, Practitioner)

  public data object Actor : SearchParam<AppointmentResponse, Reference> {
    public override val name: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AppointmentResponse.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        dev.ohs.fhir.model.r4b.Practitioner::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        HealthcareService::class,
        PractitionerRole::class,
        RelatedPerson::class,
        dev.ohs.fhir.model.r4b.Location::class,
      )

    public override fun extract(resource: AppointmentResponse): List<Reference> =
      listOfNotNull(resource.actor)
  }

  public data object Appointment : SearchParam<AppointmentResponse, Reference> {
    public override val name: String = "appointment"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AppointmentResponse.appointment"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Appointment::class)

    public override fun extract(resource: AppointmentResponse): List<Reference> =
      listOf(resource.appointment)
  }

  public data object Identifier :
    SearchParam<AppointmentResponse, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AppointmentResponse.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: AppointmentResponse
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Location : SearchParam<AppointmentResponse, Reference> {
    public override val name: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "AppointmentResponse.actor.where(resolve() is Location)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Location::class)

    public override fun extract(resource: AppointmentResponse): List<Reference> =
      listOfNotNull(resource.actor).filter {
        it.reference?.value?.toString()?.contains("Location/") == true
      }
  }

  public data object PartStatus : SearchParam<AppointmentResponse, Any> {
    public override val name: String = "part-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AppointmentResponse.participantStatus"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AppointmentResponse): List<Any> =
      listOf(resource.participantStatus)
  }

  public data object Patient : SearchParam<AppointmentResponse, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AppointmentResponse.actor.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: AppointmentResponse): List<Reference> =
      listOfNotNull(resource.actor).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Practitioner : SearchParam<AppointmentResponse, Reference> {
    public override val name: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "AppointmentResponse.actor.where(resolve() is Practitioner)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Practitioner::class)

    public override fun extract(resource: AppointmentResponse): List<Reference> =
      listOfNotNull(resource.actor).filter {
        it.reference?.value?.toString()?.contains("Practitioner/") == true
      }
  }
}
