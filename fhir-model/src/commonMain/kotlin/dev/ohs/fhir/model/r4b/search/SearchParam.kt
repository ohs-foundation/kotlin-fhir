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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.collections.List
import kotlin.reflect.KClass

/** Base type for typed FHIR search parameters. */
public sealed interface SearchParam<in R : Resource, out T> {
  /** The name of the search parameter as used in search URLs. */
  public val name: String

  /** The search parameter type (e.g., date, token, reference). */
  public val type: SearchParamType

  /** The FHIRPath expression that extracts values for this search parameter. */
  public val expression: String

  /** The target resource types for reference search parameters. */
  public val target: List<KClass<out Resource>>

  /** Extracts the values for this search parameter from the given [resource]. */
  public fun extract(resource: R): List<T>
}

/**
 * The single [SearchParam] implementation: metadata plus an [extractor] lambda that does the value
 * extraction.
 */
public class SimpleSearchParam<R : Resource, T>(
  public override val name: String,
  public override val type: SearchParamType,
  public override val expression: String,
  public override val target: List<KClass<out Resource>> = emptyList(),
  private val extractor: (R) -> List<T>,
) : SearchParam<R, T> {
  public override fun extract(resource: R): List<T> = extractor(resource)
}
