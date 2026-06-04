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
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.NutritionIntake
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionIntake] resource type. */
public object NutritionIntakeSearchParams {
  public val code: SearchParam<NutritionIntake, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionIntake.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val date: SearchParam<NutritionIntake, Any> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "NutritionIntake.occurrence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val encounter: SearchParam<NutritionIntake, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionIntake.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<NutritionIntake, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionIntake.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val nutrition: SearchParam<NutritionIntake, CodeableConcept> =
    SearchParam(
      name = "nutrition",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionIntake.consumedItem.nutritionProduct.concept",
      extractor = { resource ->
        resource.consumedItem.map { it.nutritionProduct }.mapNotNull { it.concept }
      },
    )

  public val patient: SearchParam<NutritionIntake, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionIntake.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val source: SearchParam<NutritionIntake, Reference> =
    SearchParam(
      name = "source",
      type = SearchParamType.fromCode("reference"),
      expression = "(NutritionIntake.reported as Reference)",
      target =
        listOf(
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource ->
        listOfNotNull((resource.reported as? NutritionIntake.Reported.Reference)?.value)
      },
    )

  public val status: SearchParam<NutritionIntake, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionIntake.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<NutritionIntake, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionIntake.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the NutritionIntake resource type. */
  public val all: List<SearchParam<NutritionIntake, *>> =
    listOf(code, date, encounter, identifier, nutrition, patient, source, status, subject)
}
