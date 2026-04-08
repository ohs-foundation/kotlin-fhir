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

/** Search parameters for the [MedicinalProduct] resource type. */
public sealed class MedicinalProductSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicinalProduct): List<T>

  public data object Identifier : MedicinalProductSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProduct.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProduct): List<Any> = emptyList()
  }

  public data object Name : MedicinalProductSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "MedicinalProduct.name.productName"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProduct): List<Any> = emptyList()
  }

  public data object NameLanguage : MedicinalProductSearchParam<Any>() {
    public override val paramName: String = "name-language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProduct.name.countryLanguage.language"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProduct): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the MedicinalProduct resource type. */
    public val ALL: List<MedicinalProductSearchParam<*>> = listOf(Identifier, Name, NameLanguage)
  }
}
