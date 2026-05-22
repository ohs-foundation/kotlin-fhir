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
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.NutritionIntake
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionIntake] resource type. */
public object NutritionIntakeSearchParam {
  public val Code: SearchParam<NutritionIntake, CodeableConcept> =
    SimpleSearchParam<NutritionIntake, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionIntake.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Date: SearchParam<NutritionIntake, Any> =
    SimpleSearchParam<NutritionIntake, Any>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "NutritionIntake.occurrence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val Encounter: SearchParam<NutritionIntake, Reference> =
    SimpleSearchParam<NutritionIntake, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionIntake.encounter",
      target = listOf(dev.ohs.fhir.model.r5.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<NutritionIntake, Identifier> =
    SimpleSearchParam<NutritionIntake, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionIntake.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Nutrition: SearchParam<NutritionIntake, CodeableConcept> =
    SimpleSearchParam<NutritionIntake, CodeableConcept>(
      name = "nutrition",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionIntake.consumedItem.nutritionProduct.concept",
      extractor = { resource ->
        resource.consumedItem.map { it.nutritionProduct }.mapNotNull { it.concept }
      },
    )

  public val Patient: SearchParam<NutritionIntake, Reference> =
    SimpleSearchParam<NutritionIntake, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionIntake.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Source: SearchParam<NutritionIntake, Reference> =
    SimpleSearchParam<NutritionIntake, Reference>(
      name = "source",
      type = SearchParamType.fromCode("reference"),
      expression = "(NutritionIntake.reported as Reference)",
      target =
        listOf(
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource ->
        listOfNotNull((resource.reported as? NutritionIntake.Reported.Reference)?.value)
      },
    )

  public val Status: SearchParam<NutritionIntake, Any> =
    SimpleSearchParam<NutritionIntake, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionIntake.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<NutritionIntake, Reference> =
    SimpleSearchParam<NutritionIntake, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionIntake.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the NutritionIntake resource type. */
  public val ALL: List<SearchParam<NutritionIntake, *>> =
    listOf(Code, Date, Encounter, Identifier, Nutrition, Patient, Source, Status, Subject)
}
