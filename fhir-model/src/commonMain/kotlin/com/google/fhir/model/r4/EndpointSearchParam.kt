/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Endpoint] resource type. */
public sealed class EndpointSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Endpoint): List<T>

  public data object ConnectionType : EndpointSearchParam<Any>() {
    public override val paramName: String = "connection-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Endpoint.connectionType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Endpoint): List<Any> = emptyList()
  }

  public data object Identifier : EndpointSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Endpoint.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Endpoint): List<Any> = emptyList()
  }

  public data object Name : EndpointSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Endpoint.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Endpoint): List<Any> = emptyList()
  }

  public data object Organization : EndpointSearchParam<Any>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Endpoint.managingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Endpoint): List<Any> = emptyList()
  }

  public data object PayloadType : EndpointSearchParam<Any>() {
    public override val paramName: String = "payload-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Endpoint.payloadType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Endpoint): List<Any> = emptyList()
  }

  public data object Status : EndpointSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Endpoint.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Endpoint): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Endpoint resource type. */
    public val ALL: List<EndpointSearchParam<*>> =
      listOf(ConnectionType, Identifier, Name, Organization, PayloadType, Status)
  }
}
