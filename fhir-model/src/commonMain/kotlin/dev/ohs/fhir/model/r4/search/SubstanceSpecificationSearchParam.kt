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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.SubstanceSpecification
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SubstanceSpecification] resource type. */
public object SubstanceSpecificationSearchParam {
  /** All search parameters for the SubstanceSpecification resource type. */
  public val ALL: List<SearchParam<SubstanceSpecification, *>> = listOf(Code)

  public data object Code : SearchParam<SubstanceSpecification, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SubstanceSpecification.code.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubstanceSpecification): List<CodeableConcept> =
      resource.code.mapNotNull { it.code }
  }
}
