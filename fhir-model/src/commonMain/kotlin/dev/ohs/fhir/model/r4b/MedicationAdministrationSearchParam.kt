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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationAdministration] resource type. */
public sealed class MedicationAdministrationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicationAdministration): List<T>

  public data object Code : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(MedicationAdministration.medication as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Context : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.context"

    public override val target: List<String> = listOf("EpisodeOfCare", "Encounter")

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Device : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.device"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object EffectiveTime : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "effective-time"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationAdministration.effective"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Identifier : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Medication : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(MedicationAdministration.medication as Reference)"

    public override val target: List<String> = listOf("Medication")

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Patient : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationAdministration.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Performer : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.performer.actor"

    public override val target: List<String> =
      listOf("Practitioner", "Device", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object ReasonGiven : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "reason-given"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.reasonCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object ReasonNotGiven : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "reason-not-given"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.statusReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Request : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.request"

    public override val target: List<String> = listOf("MedicationRequest")

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Status : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Subject : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the MedicationAdministration resource type. */
    public val ALL: List<MedicationAdministrationSearchParam<*>> =
      listOf(
        Code,
        Context,
        Device,
        EffectiveTime,
        Identifier,
        Medication,
        Patient,
        Performer,
        ReasonGiven,
        ReasonNotGiven,
        Request,
        Status,
        Subject,
      )
  }
}
