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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SubstanceDefinition] resource type. */
public object SubstanceDefinitionSearchParam {
  /** All search parameters for the SubstanceDefinition resource type. */
  public val ALL: List<SearchParam<SubstanceDefinition, *>> =
    listOf(Classification, Code, Domain, Identifier, Name)

  public data object Classification : SearchParam<SubstanceDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubstanceDefinition.classification"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<CodeableConcept> =
      resource.classification
  }

  public data object Code : SearchParam<SubstanceDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubstanceDefinition.code.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<CodeableConcept> =
      resource.code.mapNotNull { it.code }
  }

  public data object Domain : SearchParam<SubstanceDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "domain"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubstanceDefinition.domain"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<CodeableConcept> =
      listOfNotNull(resource.domain)
  }

  public data object Identifier :
    SearchParam<SubstanceDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubstanceDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: SubstanceDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Name : SearchParam<SubstanceDefinition, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SubstanceDefinition.name.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<R5String> =
      resource.name.map { it.name }
  }
}
