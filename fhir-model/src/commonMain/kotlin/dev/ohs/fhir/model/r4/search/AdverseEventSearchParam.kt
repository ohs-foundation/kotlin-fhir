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

import dev.ohs.fhir.model.r4.AdverseEvent
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AdverseEvent] resource type. */
public object AdverseEventSearchParam {
  /** All search parameters for the AdverseEvent resource type. */
  public val ALL: List<SearchParam<AdverseEvent, *>> =
    listOf(
      Actuality,
      Category,
      Date,
      Event,
      Location,
      Recorder,
      Resultingcondition,
      Seriousness,
      Severity,
      Study,
      Subject,
      Substance,
    )

  public data object Actuality : SearchParam<AdverseEvent, Any> {
    public override val paramName: String = "actuality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.actuality"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = listOf(resource.actuality)
  }

  public data object Category : SearchParam<AdverseEvent, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> = resource.category
  }

  public data object Date : SearchParam<AdverseEvent, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AdverseEvent.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Event : SearchParam<AdverseEvent, CodeableConcept> {
    public override val paramName: String = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.event"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> =
      listOfNotNull(resource.event)
  }

  public data object Location : SearchParam<AdverseEvent, Reference> {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: AdverseEvent): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object Recorder : SearchParam<AdverseEvent, Reference> {
    public override val paramName: String = "recorder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.recorder"

    public override val target: List<String> =
      listOf("Practitioner", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: AdverseEvent): List<Reference> =
      listOfNotNull(resource.recorder)
  }

  public data object Resultingcondition : SearchParam<AdverseEvent, Reference> {
    public override val paramName: String = "resultingcondition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.resultingCondition"

    public override val target: List<String> = listOf("Condition")

    public override fun extract(resource: AdverseEvent): List<Reference> =
      resource.resultingCondition
  }

  public data object Seriousness : SearchParam<AdverseEvent, CodeableConcept> {
    public override val paramName: String = "seriousness"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.seriousness"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> =
      listOfNotNull(resource.seriousness)
  }

  public data object Severity : SearchParam<AdverseEvent, CodeableConcept> {
    public override val paramName: String = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.severity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> =
      listOfNotNull(resource.severity)
  }

  public data object Study : SearchParam<AdverseEvent, Reference> {
    public override val paramName: String = "study"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.study"

    public override val target: List<String> = listOf("ResearchStudy")

    public override fun extract(resource: AdverseEvent): List<Reference> = resource.study
  }

  public data object Subject : SearchParam<AdverseEvent, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.subject"

    public override val target: List<String> =
      listOf("Practitioner", "Group", "Patient", "RelatedPerson")

    public override fun extract(resource: AdverseEvent): List<Reference> = listOf(resource.subject)
  }

  public data object Substance : SearchParam<AdverseEvent, Reference> {
    public override val paramName: String = "substance"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.suspectEntity.instance"

    public override val target: List<String> =
      listOf(
        "Immunization",
        "Device",
        "Medication",
        "Procedure",
        "Substance",
        "MedicationAdministration",
        "MedicationStatement",
      )

    public override fun extract(resource: AdverseEvent): List<Reference> =
      resource.suspectEntity.map { it.instance }
  }
}
