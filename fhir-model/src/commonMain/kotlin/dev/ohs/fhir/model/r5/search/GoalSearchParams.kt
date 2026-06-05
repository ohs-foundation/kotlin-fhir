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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.Goal
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.NutritionOrder
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RiskAssessment
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Goal] resource type. */
public object GoalSearchParams {
  public val achievementStatus: SearchParam<Goal, CodeableConcept> =
    SearchParam(
      name = "achievement-status",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.achievementStatus",
      extractor = { resource -> listOfNotNull(resource.achievementStatus) },
    )

  public val addresses: SearchParam<Goal, Reference> =
    SearchParam(
      name = "addresses",
      type = SearchParamType.fromCode("reference"),
      expression = "Goal.addresses",
      target =
        listOf(
          RiskAssessment::class,
          Procedure::class,
          Observation::class,
          MedicationStatement::class,
          ServiceRequest::class,
          MedicationRequest::class,
          Condition::class,
          NutritionOrder::class,
        ),
      extractor = { resource -> resource.addresses },
    )

  public val category: SearchParam<Goal, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.category",
      extractor = { resource -> resource.category },
    )

  public val description: SearchParam<Goal, CodeableConcept> =
    SearchParam(
      name = "description",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.description",
      extractor = { resource -> listOf(resource.description) },
    )

  public val identifier: SearchParam<Goal, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val lifecycleStatus: SearchParam<Goal, Any> =
    SearchParam(
      name = "lifecycle-status",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.lifecycleStatus",
      extractor = { resource -> listOf(resource.lifecycleStatus) },
    )

  public val patient: SearchParam<Goal, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Goal.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val startDate: SearchParam<Goal, Any> =
    SearchParam(
      name = "start-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Goal.start.ofType(date))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'start-date' has expression '(Goal.start.ofType(date))' which is not yet supported."
        )
      },
    )

  public val subject: SearchParam<Goal, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Goal.subject",
      target = listOf(Organization::class, Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val targetDate: SearchParam<Goal, Any> =
    SearchParam(
      name = "target-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Goal.target.due.ofType(date))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'target-date' has expression '(Goal.target.due.ofType(date))' which is not yet supported."
        )
      },
    )

  public val targetMeasure: SearchParam<Goal, CodeableConcept> =
    SearchParam(
      name = "target-measure",
      type = SearchParamType.fromCode("token"),
      expression = "Goal.target.measure",
      extractor = { resource -> resource.target.mapNotNull { it.measure } },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Goal, *>> = listOf(startDate, targetDate)

  /**
   * Supported search parameters for the Goal resource type. Entries in [unsupported] are excluded
   * so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<Goal, *>> =
    listOf(
      achievementStatus,
      addresses,
      category,
      description,
      identifier,
      lifecycleStatus,
      patient,
      startDate,
      subject,
      targetDate,
      targetMeasure,
    ) - unsupported.toSet()
}
