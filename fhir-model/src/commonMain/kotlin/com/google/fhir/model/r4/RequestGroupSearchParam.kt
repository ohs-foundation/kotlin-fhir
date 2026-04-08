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

/** Search parameters for the [RequestGroup] resource type. */
public sealed class RequestGroupSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RequestGroup): List<T>

  public data object Author : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.author"

    public override val target: List<String> = listOf("Practitioner", "Device", "PractitionerRole")

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Authored : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "RequestGroup.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Code : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Encounter : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object GroupIdentifier : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.groupIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Identifier : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object InstantiatesCanonical : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.instantiatesCanonical"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object InstantiatesUri : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "RequestGroup.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Intent : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Participant : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.action.participant"

    public override val target: List<String> =
      listOf("Practitioner", "Device", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Patient : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Priority : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Status : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public data object Subject : RequestGroupSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: RequestGroup): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the RequestGroup resource type. */
    public val ALL: List<RequestGroupSearchParam<*>> =
      listOf(
        Author,
        Authored,
        Code,
        Encounter,
        GroupIdentifier,
        Identifier,
        InstantiatesCanonical,
        InstantiatesUri,
        Intent,
        Participant,
        Patient,
        Priority,
        Status,
        Subject,
      )
  }
}
