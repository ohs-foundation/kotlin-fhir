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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.MedicationDispense
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationDispense] resource type. */
public object MedicationDispenseSearchParam {
  /** All search parameters for the MedicationDispense resource type. */
  public val ALL: List<SearchParam<MedicationDispense, *>> =
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

  public data object Code : SearchParam<MedicationDispense, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.medication.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<CodeableConcept> =
      listOfNotNull(resource.medication.concept)
  }

  public data object Destination : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.destination"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.destination)
  }

  public data object Encounter : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier :
    SearchParam<MedicationDispense, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: MedicationDispense
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Location : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object Medication : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.medication.reference"

    public override val target: List<String> = listOf("Medication")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.medication.reference)
  }

  public data object Patient : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationDispense.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<MedicationDispense, Reference> {
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

    public override fun extract(resource: MedicationDispense): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object Prescription : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "prescription"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.authorizingPrescription"

    public override val target: List<String> = listOf("MedicationRequest")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      resource.authorizingPrescription
  }

  public data object Receiver : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.receiver"

    public override val target: List<String> =
      listOf("RelatedPerson", "PractitionerRole", "Practitioner", "Location", "Patient")

    public override fun extract(resource: MedicationDispense): List<Reference> = resource.receiver
  }

  public data object Recorded : SearchParam<MedicationDispense, DateTime> {
    public override val paramName: String = "recorded"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.recorded"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<DateTime> =
      listOfNotNull(resource.recorded)
  }

  public data object Responsibleparty : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "responsibleparty"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.substitution.responsibleParty"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.substitution?.responsibleParty)
  }

  public data object Status : SearchParam<MedicationDispense, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<MedicationDispense, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOf(resource.subject)
  }

  public data object Type : SearchParam<MedicationDispense, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Whenhandedover : SearchParam<MedicationDispense, DateTime> {
    public override val paramName: String = "whenhandedover"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.whenHandedOver"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<DateTime> =
      listOfNotNull(resource.whenHandedOver)
  }

  public data object Whenprepared : SearchParam<MedicationDispense, DateTime> {
    public override val paramName: String = "whenprepared"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.whenPrepared"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationDispense): List<DateTime> =
      listOfNotNull(resource.whenPrepared)
  }
}
