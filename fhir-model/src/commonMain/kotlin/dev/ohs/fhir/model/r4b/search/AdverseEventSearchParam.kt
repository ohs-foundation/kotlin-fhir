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

import dev.ohs.fhir.model.r4b.AdverseEvent
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Immunization
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.MedicationStatement
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

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
    public override val name: String = "actuality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.actuality"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = listOf(resource.actuality)
  }

  public data object Category : SearchParam<AdverseEvent, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> = resource.category
  }

  public data object Date : SearchParam<AdverseEvent, DateTime> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AdverseEvent.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Event : SearchParam<AdverseEvent, CodeableConcept> {
    public override val name: String = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.event"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> =
      listOfNotNull(resource.event)
  }

  public data object Location : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Location::class)

    public override fun extract(resource: AdverseEvent): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object Recorder : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "recorder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.recorder"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Patient::class, PractitionerRole::class, RelatedPerson::class)

    public override fun extract(resource: AdverseEvent): List<Reference> =
      listOfNotNull(resource.recorder)
  }

  public data object Resultingcondition : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "resultingcondition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.resultingCondition"

    public override val target: List<KClass<out Resource>> = listOf(Condition::class)

    public override fun extract(resource: AdverseEvent): List<Reference> =
      resource.resultingCondition
  }

  public data object Seriousness : SearchParam<AdverseEvent, CodeableConcept> {
    public override val name: String = "seriousness"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.seriousness"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> =
      listOfNotNull(resource.seriousness)
  }

  public data object Severity : SearchParam<AdverseEvent, CodeableConcept> {
    public override val name: String = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.severity"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> =
      listOfNotNull(resource.severity)
  }

  public data object Study : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "study"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.study"

    public override val target: List<KClass<out Resource>> = listOf(ResearchStudy::class)

    public override fun extract(resource: AdverseEvent): List<Reference> = resource.study
  }

  public data object Subject : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Group::class, Patient::class, RelatedPerson::class)

    public override fun extract(resource: AdverseEvent): List<Reference> = listOf(resource.subject)
  }

  public data object Substance : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "substance"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.suspectEntity.instance"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Immunization::class,
        Device::class,
        Medication::class,
        Procedure::class,
        dev.ohs.fhir.model.r4b.Substance::class,
        MedicationAdministration::class,
        MedicationStatement::class,
      )

    public override fun extract(resource: AdverseEvent): List<Reference> =
      resource.suspectEntity.map { it.instance }
  }
}
