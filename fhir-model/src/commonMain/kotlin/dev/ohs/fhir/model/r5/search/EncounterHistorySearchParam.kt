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

import dev.ohs.fhir.model.r5.EncounterHistory
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EncounterHistory] resource type. */
public object EncounterHistorySearchParam {
  public val Encounter: SearchParam<EncounterHistory, Reference> =
    SimpleSearchParam<EncounterHistory, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "EncounterHistory.encounter",
      target = listOf(dev.ohs.fhir.model.r5.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<EncounterHistory, Identifier> =
    SimpleSearchParam<EncounterHistory, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "EncounterHistory.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<EncounterHistory, Reference> =
    SimpleSearchParam<EncounterHistory, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "EncounterHistory.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Status: SearchParam<EncounterHistory, Any> =
    SimpleSearchParam<EncounterHistory, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "EncounterHistory.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<EncounterHistory, Reference> =
    SimpleSearchParam<EncounterHistory, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "EncounterHistory.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the EncounterHistory resource type. */
  public val ALL: List<SearchParam<EncounterHistory, *>> =
    listOf(Encounter, Identifier, Patient, Status, Subject)
}
