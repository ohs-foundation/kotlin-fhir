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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationAdministration] resource type. */
public sealed class MedicationAdministrationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicationAdministration): List<T>

  public data object Code : MedicationAdministrationSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.medication.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<CodeableConcept> =
      listOfNotNull(resource.medication.concept)
  }

  public data object Date : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationAdministration.occurence.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> = emptyList()
  }

  public data object Device : MedicationAdministrationSearchParam<Reference>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.device.reference"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      resource.device.mapNotNull { it.reference }
  }

  public data object Encounter : MedicationAdministrationSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier :
    MedicationAdministrationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: MedicationAdministration
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Medication : MedicationAdministrationSearchParam<Reference>() {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.medication.reference"

    public override val target: List<String> = listOf("Medication")

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOfNotNull(resource.medication.reference)
  }

  public data object Patient : MedicationAdministrationSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationAdministration.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : MedicationAdministrationSearchParam<Reference>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.performer.actor.reference"

    public override val target: List<String> =
      listOf("Device", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      resource.performer.map { it.actor }.mapNotNull { it.reference }
  }

  public data object PerformerDeviceCode : MedicationAdministrationSearchParam<CodeableConcept>() {
    public override val paramName: String = "performer-device-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.performer.actor.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<CodeableConcept> =
      resource.performer.map { it.actor }.mapNotNull { it.concept }
  }

  public data object ReasonGiven : MedicationAdministrationSearchParam<Reference>() {
    public override val paramName: String = "reason-given"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.reason.reference"

    public override val target: List<String> =
      listOf("Observation", "DiagnosticReport", "Condition")

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      resource.reason.mapNotNull { it.reference }
  }

  public data object ReasonGivenCode : MedicationAdministrationSearchParam<CodeableConcept>() {
    public override val paramName: String = "reason-given-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.reason.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<CodeableConcept> =
      resource.reason.mapNotNull { it.concept }
  }

  public data object ReasonNotGiven : MedicationAdministrationSearchParam<CodeableConcept>() {
    public override val paramName: String = "reason-not-given"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.statusReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<CodeableConcept> =
      resource.statusReason
  }

  public data object Request : MedicationAdministrationSearchParam<Reference>() {
    public override val paramName: String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.request"

    public override val target: List<String> = listOf("MedicationRequest")

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOfNotNull(resource.request)
  }

  public data object Status : MedicationAdministrationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> =
      listOf(resource.status)
  }

  public data object Subject : MedicationAdministrationSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the MedicationAdministration resource type. */
    public val ALL: List<MedicationAdministrationSearchParam<*>> =
      listOf(
        Code,
        Date,
        Device,
        Encounter,
        Identifier,
        Medication,
        Patient,
        Performer,
        PerformerDeviceCode,
        ReasonGiven,
        ReasonGivenCode,
        ReasonNotGiven,
        Request,
        Status,
        Subject,
      )
  }
}
