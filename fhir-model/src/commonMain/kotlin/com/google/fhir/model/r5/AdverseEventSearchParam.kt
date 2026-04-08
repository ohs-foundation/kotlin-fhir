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

/** Search parameters for the [AdverseEvent] resource type. */
public sealed class AdverseEventSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: AdverseEvent): List<T>

  public data object Actuality : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "actuality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.actuality"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Category : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Code : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Date : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AdverseEvent.occurrence.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Identifier : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Location : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Patient : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Recorder : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "recorder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.recorder"

    public override val target: List<String> =
      listOf("RelatedPerson", "PractitionerRole", "ResearchSubject", "Practitioner", "Patient")

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Resultingeffect : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "resultingeffect"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.resultingEffect"

    public override val target: List<String> = listOf("Observation", "Condition")

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Seriousness : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "seriousness"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.seriousness"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Status : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Study : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "study"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.study"

    public override val target: List<String> = listOf("ResearchStudy")

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Subject : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.subject"

    public override val target: List<String> =
      listOf("RelatedPerson", "ResearchSubject", "Group", "Practitioner", "Patient")

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Substance : AdverseEventSearchParam<Any>() {
    public override val paramName: String = "substance"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(AdverseEvent.suspectEntity.instance as Reference)"

    public override val target: List<String> =
      listOf(
        "Device",
        "Procedure",
        "MedicationStatement",
        "ResearchStudy",
        "MedicationAdministration",
        "BiologicallyDerivedProduct",
        "Immunization",
        "Substance",
        "Medication",
      )

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the AdverseEvent resource type. */
    public val ALL: List<AdverseEventSearchParam<*>> =
      listOf(
        Actuality,
        Category,
        Code,
        Date,
        Identifier,
        Location,
        Patient,
        Recorder,
        Resultingeffect,
        Seriousness,
        Status,
        Study,
        Subject,
        Substance,
      )
  }
}
