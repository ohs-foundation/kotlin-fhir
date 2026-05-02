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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AppointmentResponse] resource type. */
public sealed class AppointmentResponseSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: AppointmentResponse): List<T>

  public data object Actor : AppointmentResponseSearchParam<Any>() {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AppointmentResponse.actor"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Group",
        "Practitioner",
        "Location",
        "Patient",
      )

    public override fun extract(resource: AppointmentResponse): List<Any> = emptyList()
  }

  public data object Appointment : AppointmentResponseSearchParam<Any>() {
    public override val paramName: String = "appointment"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AppointmentResponse.appointment"

    public override val target: List<String> = listOf("Appointment")

    public override fun extract(resource: AppointmentResponse): List<Any> = emptyList()
  }

  public data object Group : AppointmentResponseSearchParam<Any>() {
    public override val paramName: String = "group"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AppointmentResponse.actor.where(resolve() is Group)"

    public override val target: List<String> = listOf("Group")

    public override fun extract(resource: AppointmentResponse): List<Any> = emptyList()
  }

  public data object Identifier : AppointmentResponseSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AppointmentResponse.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AppointmentResponse): List<Any> = emptyList()
  }

  public data object Location : AppointmentResponseSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "AppointmentResponse.actor.where(resolve() is Location)"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: AppointmentResponse): List<Any> = emptyList()
  }

  public data object PartStatus : AppointmentResponseSearchParam<Any>() {
    public override val paramName: String = "part-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AppointmentResponse.participantStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AppointmentResponse): List<Any> = emptyList()
  }

  public data object Patient : AppointmentResponseSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AppointmentResponse.actor.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: AppointmentResponse): List<Any> = emptyList()
  }

  public data object Practitioner : AppointmentResponseSearchParam<Any>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "AppointmentResponse.actor.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: AppointmentResponse): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the AppointmentResponse resource type. */
    public val ALL: List<AppointmentResponseSearchParam<*>> =
      listOf(Actor, Appointment, Group, Identifier, Location, PartStatus, Patient, Practitioner)
  }
}
