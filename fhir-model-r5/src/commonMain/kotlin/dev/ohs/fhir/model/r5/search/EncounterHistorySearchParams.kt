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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.EncounterHistory
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EncounterHistory] resource type. */
public object EncounterHistorySearchParams {
  public val encounter: SearchParam<EncounterHistory, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "EncounterHistory.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<EncounterHistory, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "EncounterHistory.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<EncounterHistory, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "EncounterHistory.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter { it.reference?.value?.contains("Patient/") == true }
      },
    )

  public val status: SearchParam<EncounterHistory, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "EncounterHistory.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<EncounterHistory, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "EncounterHistory.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<EncounterHistory, *>> = listOf()

  /**
   * Supported search parameters for the EncounterHistory resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<EncounterHistory, *>> =
    listOf(encounter, identifier, patient, status, subject)
}
