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

import dev.ohs.fhir.model.r5.DomainResource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DomainResource] resource type. */
public object DomainResourceSearchParams {
  public val _text: SearchParam<DomainResource, Any> =
    SearchParam<DomainResource, Any>(
      name = "_text",
      type = SearchParamType.fromCode("special"),
      expression = "",
      extractor = { emptyList() },
    )

  /** All search parameters for the DomainResource resource type. */
  public val all: List<SearchParam<DomainResource, *>> = listOf(_text)
}
