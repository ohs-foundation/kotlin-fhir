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
import dev.ohs.fhir.model.r5.FormularyItem
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [FormularyItem] resource type. */
public object FormularyItemSearchParam {
  /** All search parameters for the FormularyItem resource type. */
  public val ALL: List<SearchParam<FormularyItem, *>> = listOf(Code, Identifier)

  public data object Code : SearchParam<FormularyItem, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FormularyItem.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: FormularyItem): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Identifier : SearchParam<FormularyItem, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "FormularyItem.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: FormularyItem): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }
}
