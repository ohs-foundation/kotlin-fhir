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

import dev.ohs.fhir.model.r5.Transport
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Transport] resource type. */
public object TransportSearchParam {
  /** All search parameters for the Transport resource type. */
  public val ALL: List<SearchParam<Transport, *>> = listOf(Identifier, Status)

  public data object Identifier : SearchParam<Transport, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Transport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Transport): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Status : SearchParam<Transport, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Transport.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Transport): List<Any> = listOfNotNull(resource.status)
  }
}
