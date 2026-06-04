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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [FormularyItem] resource type. */
public object FormularyItemSearchParams {
  public val Code: SearchParam<FormularyItem, CodeableConcept> =
    SimpleSearchParam<FormularyItem, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "FormularyItem.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Identifier: SearchParam<FormularyItem, Identifier> =
    SimpleSearchParam<FormularyItem, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "FormularyItem.identifier",
      extractor = { resource -> resource.identifier },
    )

  /** All search parameters for the FormularyItem resource type. */
  public val ALL: List<SearchParam<FormularyItem, *>> = listOf(Code, Identifier)
}
