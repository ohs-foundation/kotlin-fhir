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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Procedure
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Flag] resource type. */
public object FlagSearchParams {
  public val Author: SearchParam<Flag, Reference> =
    SimpleSearchParam<Flag, Reference>(
      name = "author",
      type = SearchParamType.fromCode("reference"),
      expression = "Flag.author",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
        ),
      extractor = { resource -> listOfNotNull(resource.author) },
    )

  public val Date: SearchParam<Flag, Period> =
    SimpleSearchParam<Flag, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Flag.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val Encounter: SearchParam<Flag, Reference> =
    SimpleSearchParam<Flag, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Flag.encounter",
      target = listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<Flag, Identifier> =
    SimpleSearchParam<Flag, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Flag.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<Flag, Reference> =
    SimpleSearchParam<Flag, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Flag.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Subject: SearchParam<Flag, Reference> =
    SimpleSearchParam<Flag, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Flag.subject",
      target =
        listOf(
          Practitioner::class,
          Group::class,
          Organization::class,
          Medication::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PlanDefinition::class,
          Procedure::class,
          Location::class,
        ),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the Flag resource type. */
  public val ALL: List<SearchParam<Flag, *>> =
    listOf(Author, Date, Encounter, Identifier, Patient, Subject)
}
