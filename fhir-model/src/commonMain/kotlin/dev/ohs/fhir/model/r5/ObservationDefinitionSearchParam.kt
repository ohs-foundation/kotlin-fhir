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
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ObservationDefinition] resource type. */
public sealed class ObservationDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ObservationDefinition): List<T>

  public data object Category : ObservationDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ObservationDefinition.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<CodeableConcept> =
      resource.category
  }

  public data object Code : ObservationDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ObservationDefinition.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object Experimental : ObservationDefinitionSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ObservationDefinition.experimental"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Boolean> =
      listOfNotNull(resource.experimental)
  }

  public data object Identifier :
    ObservationDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ObservationDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: ObservationDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = listOfNotNull(resource.identifier)
  }

  public data object Method : ObservationDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ObservationDefinition.method"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<CodeableConcept> =
      listOfNotNull(resource.method)
  }

  public data object Status : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ObservationDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> =
      listOf(resource.status)
  }

  public data object Title : ObservationDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ObservationDefinition.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : ObservationDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ObservationDefinition.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public companion object {
    /** All search parameters for the ObservationDefinition resource type. */
    public val ALL: List<ObservationDefinitionSearchParam<*>> =
      listOf(Category, Code, Experimental, Identifier, Method, Status, Title, Url)
  }
}
