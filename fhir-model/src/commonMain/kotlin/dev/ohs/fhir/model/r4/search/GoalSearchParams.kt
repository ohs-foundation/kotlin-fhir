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
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.Goal
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Goal] resource type. */
public object GoalSearchParams {
  public val AchievementStatus: SearchParam<Goal, CodeableConcept> =
    SimpleSearchParam<Goal, CodeableConcept>(
      name = "achievement-status",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.achievementStatus",
      extractor = { resource -> listOfNotNull(resource.achievementStatus) },
    )

  public val Category: SearchParam<Goal, CodeableConcept> =
    SimpleSearchParam<Goal, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.category",
      extractor = { resource -> resource.category },
    )

  public val Identifier: SearchParam<Goal, Identifier> =
    SimpleSearchParam<Goal, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val LifecycleStatus: SearchParam<Goal, Any> =
    SimpleSearchParam<Goal, Any>(
      name = "lifecycle-status",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.lifecycleStatus",
      extractor = { resource -> listOf(resource.lifecycleStatus) },
    )

  public val Patient: SearchParam<Goal, Reference> =
    SimpleSearchParam<Goal, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Goal.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val StartDate: SearchParam<Goal, Date> =
    SimpleSearchParam<Goal, Date>(
      name = "start-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Goal.start as date)",
      extractor = { resource -> listOfNotNull((resource.start as? Goal.Start.Date)?.value) },
    )

  public val Subject: SearchParam<Goal, Reference> =
    SimpleSearchParam<Goal, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Goal.subject",
      target = listOf(Group::class, Organization::class, dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val TargetDate: SearchParam<Goal, Date> =
    SimpleSearchParam<Goal, Date>(
      name = "target-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Goal.target.due as date)",
      extractor = { resource ->
        resource.target.mapNotNull { (it.due as? Goal.Target.Due.Date)?.value }
      },
    )

  /** All search parameters for the Goal resource type. */
  public val ALL: List<SearchParam<Goal, *>> =
    listOf(
      AchievementStatus,
      Category,
      Identifier,
      LifecycleStatus,
      Patient,
      StartDate,
      Subject,
      TargetDate,
    )
}
