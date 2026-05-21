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

import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Flag
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Procedure
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Flag] resource type. */
public object FlagSearchParam {
  /** All search parameters for the Flag resource type. */
  public val ALL: List<SearchParam<Flag, *>> =
    listOf(Author, Date, Encounter, Identifier, Patient, Subject)

  public data object Author : SearchParam<Flag, Reference> {
    public override val paramName: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Flag.author"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PractitionerRole::class,
      )

    public override fun extract(resource: Flag): List<Reference> = listOfNotNull(resource.author)
  }

  public data object Date : SearchParam<Flag, Period> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Flag.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Flag): List<Period> = listOfNotNull(resource.period)
  }

  public data object Encounter : SearchParam<Flag, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Flag.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class)

    public override fun extract(resource: Flag): List<Reference> = listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<Flag, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Flag.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Flag): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Patient : SearchParam<Flag, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Flag.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: Flag): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Subject : SearchParam<Flag, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Flag.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Group::class,
        Organization::class,
        Medication::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PlanDefinition::class,
        Procedure::class,
        Location::class,
      )

    public override fun extract(resource: Flag): List<Reference> = listOf(resource.subject)
  }
}
