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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SubstanceDefinition] resource type. */
public sealed class SubstanceDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SubstanceDefinition): List<T>

  public data object Classification : SubstanceDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SubstanceDefinition.classification"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<CodeableConcept> =
      resource.classification
  }

  public data object Code : SubstanceDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SubstanceDefinition.code.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<CodeableConcept> =
      resource.code.mapNotNull { it.code }
  }

  public data object Domain : SubstanceDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "domain"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SubstanceDefinition.domain"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<CodeableConcept> =
      listOfNotNull(resource.domain)
  }

  public data object Identifier :
    SubstanceDefinitionSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SubstanceDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: SubstanceDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Name : SubstanceDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "SubstanceDefinition.name.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<String> =
      resource.name.map { it.name }
  }

  public companion object {
    /** All search parameters for the SubstanceDefinition resource type. */
    public val ALL: List<SubstanceDefinitionSearchParam<*>> =
      listOf(Classification, Code, Domain, Identifier, Name)
  }
}
