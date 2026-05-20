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
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Goal] resource type. */
public object GoalSearchParam {
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

  public data object AchievementStatus : SearchParam<Goal, CodeableConcept> {
    public override val paramName: String = "achievement-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Goal.achievementStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Goal): List<CodeableConcept> =
      listOfNotNull(resource.achievementStatus)
  }

  public data object Category : SearchParam<Goal, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Goal.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Goal): List<CodeableConcept> = resource.category
  }

  public data object Identifier : SearchParam<Goal, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Goal.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Goal): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object LifecycleStatus : SearchParam<Goal, Any> {
    public override val paramName: String = "lifecycle-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Goal.lifecycleStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Goal): List<Any> = listOf(resource.lifecycleStatus)
  }

  public data object Patient : SearchParam<Goal, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Goal.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: Goal): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object StartDate : SearchParam<Goal, Date> {
    public override val paramName: String = "start-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(Goal.start as date)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Goal): List<Date> =
      listOfNotNull((resource.start as? Goal.Start.Date)?.value)
  }

  public data object Subject : SearchParam<Goal, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Goal.subject"

    public override val target: List<String> = listOf("Group", "Organization", "Patient")

    public override fun extract(resource: Goal): List<Reference> = listOf(resource.subject)
  }

  public data object TargetDate : SearchParam<Goal, Date> {
    public override val paramName: String = "target-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(Goal.target.due as date)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Goal): List<Date> =
      resource.target.mapNotNull { (it.due as? Goal.Target.Due.Date)?.value }
  }
}
