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

/** Search parameters for the [NutritionOrder] resource type. */
public sealed class NutritionOrderSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: NutritionOrder): List<T>

  public data object Additive : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "additive"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.enteralFormula.additive.type.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Datetime : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "datetime"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NutritionOrder.dateTime"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Encounter : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionOrder.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Formula : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "formula"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.enteralFormula.baseFormulaType.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object GroupIdentifier : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.groupIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Identifier : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Oraldiet : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "oraldiet"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.oralDiet.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Patient : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionOrder.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Provider : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionOrder.orderer"

    public override val target: List<String> = listOf("PractitionerRole", "Practitioner")

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Status : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Subject : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionOrder.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public data object Supplement : NutritionOrderSearchParam<Any>() {
    public override val paramName: String = "supplement"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.supplement.type.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the NutritionOrder resource type. */
    public val ALL: List<NutritionOrderSearchParam<*>> =
      listOf(
        Additive,
        Datetime,
        Encounter,
        Formula,
        GroupIdentifier,
        Identifier,
        Oraldiet,
        Patient,
        Provider,
        Status,
        Subject,
        Supplement,
      )
  }
}
