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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CareTeam] resource type. */
public sealed class CareTeamSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CareTeam): List<T>

  public data object Category : CareTeamSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Date : CareTeamSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CareTeam.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Encounter : CareTeamSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Identifier : CareTeamSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Participant : CareTeamSearchParam<Any>() {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.participant.member"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Patient : CareTeamSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Status : CareTeamSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Subject : CareTeamSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the CareTeam resource type. */
    public val ALL: List<CareTeamSearchParam<*>> =
      listOf(Category, Date, Encounter, Identifier, Participant, Patient, Status, Subject)
  }
}
