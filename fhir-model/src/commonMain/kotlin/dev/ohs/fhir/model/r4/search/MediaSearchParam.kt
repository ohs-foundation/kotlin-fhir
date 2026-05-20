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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Media
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Media] resource type. */
public sealed class MediaSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Media): List<T>

  public data object BasedOn : MediaSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.basedOn"

    public override val target: List<String> = listOf("CarePlan", "ServiceRequest")

    public override fun extract(resource: Media): List<Reference> = resource.basedOn
  }

  public data object Created : MediaSearchParam<Media.Created>() {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Media.created"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Media): List<Media.Created> =
      listOfNotNull(resource.created)
  }

  public data object Device : MediaSearchParam<Reference>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.device"

    public override val target: List<String> = listOf("Device", "DeviceMetric")

    public override fun extract(resource: Media): List<Reference> = listOfNotNull(resource.device)
  }

  public data object Encounter : MediaSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Media): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : MediaSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Media): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Modality : MediaSearchParam<CodeableConcept>() {
    public override val paramName: String = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.modality"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Media): List<CodeableConcept> =
      listOfNotNull(resource.modality)
  }

  public data object Operator : MediaSearchParam<Reference>() {
    public override val paramName: String = "operator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.operator"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: Media): List<Reference> = listOfNotNull(resource.operator)
  }

  public data object Patient : MediaSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Media): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Site : MediaSearchParam<CodeableConcept>() {
    public override val paramName: String = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.bodySite"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Media): List<CodeableConcept> =
      listOfNotNull(resource.bodySite)
  }

  public data object Status : MediaSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Media): List<Any> = listOf(resource.status)
  }

  public data object Subject : MediaSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Media.subject"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Group",
        "Specimen",
        "Device",
        "Patient",
        "PractitionerRole",
        "Location",
      )

    public override fun extract(resource: Media): List<Reference> = listOfNotNull(resource.subject)
  }

  public data object Type : MediaSearchParam<CodeableConcept>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Media): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object View : MediaSearchParam<CodeableConcept>() {
    public override val paramName: String = "view"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Media.view"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Media): List<CodeableConcept> =
      listOfNotNull(resource.view)
  }

  public companion object {
    /** All search parameters for the Media resource type. */
    public val ALL: List<MediaSearchParam<*>> =
      listOf(
        BasedOn,
        Created,
        Device,
        Encounter,
        Identifier,
        Modality,
        Operator,
        Patient,
        Site,
        Status,
        Subject,
        Type,
        View,
      )
  }
}
