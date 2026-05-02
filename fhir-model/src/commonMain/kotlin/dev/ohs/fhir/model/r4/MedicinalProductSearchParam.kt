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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProduct] resource type. */
public sealed class MedicinalProductSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicinalProduct): List<T>

  public data object Identifier : MedicinalProductSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicinalProduct.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: MedicinalProduct
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Name : MedicinalProductSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "MedicinalProduct.name.productName"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicinalProduct): List<String> =
      resource.name.map { it.productName }
  }

  public data object NameLanguage : MedicinalProductSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "name-language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicinalProduct.name.countryLanguage.language"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicinalProduct): List<CodeableConcept> =
      resource.name.flatMap { it.countryLanguage }.map { it.language }
  }

  public companion object {
    /** All search parameters for the MedicinalProduct resource type. */
    public val ALL: List<MedicinalProductSearchParam<*>> = listOf(Identifier, Name, NameLanguage)
  }
}
