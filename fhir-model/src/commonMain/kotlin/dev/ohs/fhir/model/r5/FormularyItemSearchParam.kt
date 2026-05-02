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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [FormularyItem] resource type. */
public sealed class FormularyItemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: FormularyItem): List<T>

  public data object Code : FormularyItemSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FormularyItem.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FormularyItem): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Identifier : FormularyItemSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FormularyItem.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: FormularyItem): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public companion object {
    /** All search parameters for the FormularyItem resource type. */
    public val ALL: List<FormularyItemSearchParam<*>> = listOf(Code, Identifier)
  }
}
