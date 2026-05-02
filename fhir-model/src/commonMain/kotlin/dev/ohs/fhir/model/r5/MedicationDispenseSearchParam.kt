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

/** Search parameters for the [MedicationDispense] resource type. */
public sealed class MedicationDispenseSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicationDispense): List<T>

  public data object Code : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.medication.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Destination : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.destination"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Encounter : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Identifier : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Location : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Medication : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.medication.reference"

    public override val target: List<String> = listOf("Medication")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Patient : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationDispense.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Performer : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.performer.actor"

    public override val target: List<String> =
      listOf(
        "Organization",
        "Device",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Prescription : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "prescription"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.authorizingPrescription"

    public override val target: List<String> = listOf("MedicationRequest")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Receiver : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.receiver"

    public override val target: List<String> =
      listOf("RelatedPerson", "PractitionerRole", "Practitioner", "Location", "Patient")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Recorded : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "recorded"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.recorded"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Responsibleparty : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "responsibleparty"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.substitution.responsibleParty"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Status : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Subject : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Type : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Whenhandedover : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "whenhandedover"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.whenHandedOver"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public data object Whenprepared : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "whenprepared"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.whenPrepared"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the MedicationDispense resource type. */
    public val ALL: List<MedicationDispenseSearchParam<*>> =
      listOf(
        Code,
        Destination,
        Encounter,
        Identifier,
        Location,
        Medication,
        Patient,
        Performer,
        Prescription,
        Receiver,
        Recorded,
        Responsibleparty,
        Status,
        Subject,
        Type,
        Whenhandedover,
        Whenprepared,
      )
  }
}
