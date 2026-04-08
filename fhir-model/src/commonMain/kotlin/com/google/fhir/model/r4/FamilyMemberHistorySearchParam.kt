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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [FamilyMemberHistory] resource type. */
public sealed class FamilyMemberHistorySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: FamilyMemberHistory): List<T>

  public data object Code : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FamilyMemberHistory.condition.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public data object Date : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "FamilyMemberHistory.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public data object Identifier : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FamilyMemberHistory.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public data object InstantiatesCanonical : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "FamilyMemberHistory.instantiatesCanonical"

    public override val target: List<String> =
      listOf(
        "Questionnaire",
        "Measure",
        "PlanDefinition",
        "OperationDefinition",
        "ActivityDefinition",
      )

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public data object InstantiatesUri : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "FamilyMemberHistory.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public data object Patient : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "FamilyMemberHistory.patient"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public data object Relationship : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FamilyMemberHistory.relationship"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public data object Sex : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "sex"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FamilyMemberHistory.sex"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public data object Status : FamilyMemberHistorySearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FamilyMemberHistory.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FamilyMemberHistory): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the FamilyMemberHistory resource type. */
    public val ALL: List<FamilyMemberHistorySearchParam<*>> =
      listOf(
        Code,
        Date,
        Identifier,
        InstantiatesCanonical,
        InstantiatesUri,
        Patient,
        Relationship,
        Sex,
        Status,
      )
  }
}
