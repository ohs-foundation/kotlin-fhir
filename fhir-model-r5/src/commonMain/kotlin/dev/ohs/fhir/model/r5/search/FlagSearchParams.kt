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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Flag
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Flag] resource type. */
public object FlagSearchParams {
  public val author: SearchParam<Flag, Reference> =
    SearchParam(
      name = "author",
      type = SearchParamType.Reference,
      expression = "Flag.author",
      target =
        listOf(
          Device::class,
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.author) },
    )

  public val category: SearchParam<Flag, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "Flag.category",
      extractor = { resource -> resource.category },
    )

  public val date: SearchParam<Flag, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "Flag.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val encounter: SearchParam<Flag, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "Flag.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<Flag, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Flag.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<Flag, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Flag.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter { it.reference?.value?.contains("Patient/") == true }
      },
    )

  public val status: SearchParam<Flag, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Flag.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Flag, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "Flag.subject",
      target =
        listOf(
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Procedure::class,
          PlanDefinition::class,
          Group::class,
          Practitioner::class,
          Location::class,
          Patient::class,
          Medication::class,
        ),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Flag, *>> = listOf()

  /**
   * Supported search parameters for the Flag resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Flag, *>> =
    listOf(author, category, date, encounter, identifier, patient, status, subject)
}
