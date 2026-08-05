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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.Goal
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Goal] resource type. */
public object GoalSearchParams {
  public val achievementStatus: SearchParam<Goal, CodeableConcept> =
    SearchParam(
      name = "achievement-status",
      type = SearchParamType.Token,
      expression = "Goal.achievementStatus",
      extractor = { resource -> listOfNotNull(resource.achievementStatus) },
    )

  public val category: SearchParam<Goal, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "Goal.category",
      extractor = { resource -> resource.category },
    )

  public val identifier: SearchParam<Goal, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Goal.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val lifecycleStatus: SearchParam<Goal, Any> =
    SearchParam(
      name = "lifecycle-status",
      type = SearchParamType.Token,
      expression = "Goal.lifecycleStatus",
      extractor = { resource -> listOf(resource.lifecycleStatus) },
    )

  public val patient: SearchParam<Goal, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Goal.subject.where(resolve() is Patient)",
      target = listOf(Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter { it.reference?.value?.contains("Patient/") == true }
      },
    )

  public val startDate: SearchParam<Goal, Date> =
    SearchParam(
      name = "start-date",
      type = SearchParamType.Date,
      expression = "(Goal.start as date)",
      extractor = { resource -> listOfNotNull((resource.start as? Goal.Start.Date)?.value) },
    )

  public val subject: SearchParam<Goal, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "Goal.subject",
      target = listOf(Group::class, Organization::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val targetDate: SearchParam<Goal, Date> =
    SearchParam(
      name = "target-date",
      type = SearchParamType.Date,
      expression = "(Goal.target.due as date)",
      extractor = { resource ->
        resource.target.mapNotNull { (it.due as? Goal.Target.Due.Date)?.value }
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Goal, *>> = listOf()

  /**
   * Supported search parameters for the Goal resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Goal, *>> =
    listOf(
      achievementStatus,
      category,
      identifier,
      lifecycleStatus,
      patient,
      startDate,
      subject,
      targetDate,
    )
}
