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
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Endpoint] resource type. */
public sealed class EndpointSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Endpoint): List<T>

  public data object ConnectionType : EndpointSearchParam<Coding>() {
    public override val paramName: kotlin.String = "connection-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Endpoint.connectionType"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Endpoint): List<Coding> = listOf(resource.connectionType)
  }

  public data object Identifier : EndpointSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Endpoint.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Endpoint): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Name : EndpointSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Endpoint.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Endpoint): List<String> = listOfNotNull(resource.name)
  }

  public data object Organization : EndpointSearchParam<Reference>() {
    public override val paramName: kotlin.String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Endpoint.managingOrganization"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: Endpoint): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object PayloadType : EndpointSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "payload-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Endpoint.payloadType"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Endpoint): List<CodeableConcept> = resource.payloadType
  }

  public data object Status : EndpointSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Endpoint.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Endpoint): List<Any> = listOf(resource.status)
  }

  public companion object {
    /** All search parameters for the Endpoint resource type. */
    public val ALL: List<EndpointSearchParam<*>> =
      listOf(ConnectionType, Identifier, Name, Organization, PayloadType, Status)
  }
}
