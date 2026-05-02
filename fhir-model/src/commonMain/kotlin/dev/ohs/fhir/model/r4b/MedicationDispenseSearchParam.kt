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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationDispense] resource type. */
public sealed class MedicationDispenseSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicationDispense): List<T>

  public data object Code : MedicationDispenseSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(MedicationDispense.medication as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<CodeableConcept> =
      listOfNotNull((resource.medication as? MedicationDispense.Medication.CodeableConcept)?.value)
  }

  public data object Context : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.context"

    public override val target: List<String> = listOf("EpisodeOfCare", "Encounter")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.context)
  }

  public data object Destination : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.destination"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.destination)
  }

  public data object Identifier :
    MedicationDispenseSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: MedicationDispense
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Medication : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(MedicationDispense.medication as Reference)"

    public override val target: List<String> = listOf("Medication")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull((resource.medication as? MedicationDispense.Medication.Reference)?.value)
  }

  public data object Patient : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationDispense.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.performer.actor"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: MedicationDispense): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object Prescription : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "prescription"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.authorizingPrescription"

    public override val target: List<String> = listOf("MedicationRequest")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      resource.authorizingPrescription
  }

  public data object Receiver : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.receiver"

    public override val target: List<String> = listOf("Practitioner", "Patient")

    public override fun extract(resource: MedicationDispense): List<Reference> = resource.receiver
  }

  public data object Responsibleparty : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "responsibleparty"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.substitution.responsibleParty"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      resource.substitution?.responsibleParty ?: emptyList()
  }

  public data object Status : MedicationDispenseSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = listOf(resource.status)
  }

  public data object Subject : MedicationDispenseSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : MedicationDispenseSearchParam<CodeableConcept>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Whenhandedover : MedicationDispenseSearchParam<DateTime>() {
    public override val paramName: String = "whenhandedover"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.whenHandedOver"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<DateTime> =
      listOfNotNull(resource.whenHandedOver)
  }

  public data object Whenprepared : MedicationDispenseSearchParam<DateTime>() {
    public override val paramName: String = "whenprepared"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.whenPrepared"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<DateTime> =
      listOfNotNull(resource.whenPrepared)
  }

  public companion object {
    /** All search parameters for the MedicationDispense resource type. */
    public val ALL: List<MedicationDispenseSearchParam<*>> =
      listOf(
        Code,
        Context,
        Destination,
        Identifier,
        Medication,
        Patient,
        Performer,
        Prescription,
        Receiver,
        Responsibleparty,
        Status,
        Subject,
        Type,
        Whenhandedover,
        Whenprepared,
      )
  }
}
