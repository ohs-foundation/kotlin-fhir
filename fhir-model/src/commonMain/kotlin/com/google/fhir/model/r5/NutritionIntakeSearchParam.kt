/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionIntake] resource type. */
public sealed class NutritionIntakeSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: NutritionIntake): List<T>

  public data object Code : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionIntake.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Date : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NutritionIntake.occurrence.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Encounter : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionIntake.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Identifier : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionIntake.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Nutrition : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "nutrition"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionIntake.consumedItem.nutritionProduct.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Patient : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionIntake.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Source : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(NutritionIntake.reported as Reference)"

    public override val target: List<String> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Status : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionIntake.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Subject : NutritionIntakeSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionIntake.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the NutritionIntake resource type. */
    public val ALL: List<NutritionIntakeSearchParam<*>> =
      listOf(Code, Date, Encounter, Identifier, Nutrition, Patient, Source, Status, Subject)
  }
}
