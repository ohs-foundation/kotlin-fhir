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

/** Search parameters for the [MedicinalProductAuthorization] resource type. */
public sealed class MedicinalProductAuthorizationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicinalProductAuthorization): List<T>

  public data object Country : MedicinalProductAuthorizationSearchParam<Any>() {
    public override val paramName: String = "country"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductAuthorization.country"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductAuthorization): List<Any> = emptyList()
  }

  public data object Holder : MedicinalProductAuthorizationSearchParam<Any>() {
    public override val paramName: String = "holder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicinalProductAuthorization.holder"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: MedicinalProductAuthorization): List<Any> = emptyList()
  }

  public data object Identifier : MedicinalProductAuthorizationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductAuthorization.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductAuthorization): List<Any> = emptyList()
  }

  public data object Status : MedicinalProductAuthorizationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductAuthorization.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductAuthorization): List<Any> = emptyList()
  }

  public data object Subject : MedicinalProductAuthorizationSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicinalProductAuthorization.subject"

    public override val target: List<String> =
      listOf("MedicinalProductPackaged", "MedicinalProduct")

    public override fun extract(resource: MedicinalProductAuthorization): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the MedicinalProductAuthorization resource type. */
    public val ALL: List<MedicinalProductAuthorizationSearchParam<*>> =
      listOf(Country, Holder, Identifier, Status, Subject)
  }
}
