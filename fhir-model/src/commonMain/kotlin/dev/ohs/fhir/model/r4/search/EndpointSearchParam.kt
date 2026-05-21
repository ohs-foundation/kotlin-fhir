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
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Endpoint
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Endpoint] resource type. */
public object EndpointSearchParam {
  /** All search parameters for the Endpoint resource type. */
  public val ALL: List<SearchParam<Endpoint, *>> =
    listOf(ConnectionType, Identifier, Name, Organization, PayloadType, Status)

  public data object ConnectionType : SearchParam<Endpoint, Coding> {
    public override val name: KotlinString = "connection-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Endpoint.connectionType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Endpoint): List<Coding> = listOf(resource.connectionType)
  }

  public data object Identifier : SearchParam<Endpoint, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Endpoint.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Endpoint): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<Endpoint, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Endpoint.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Endpoint): List<R4String> = listOfNotNull(resource.name)
  }

  public data object Organization : SearchParam<Endpoint, Reference> {
    public override val name: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Endpoint.managingOrganization"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Organization::class)

    public override fun extract(resource: Endpoint): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object PayloadType : SearchParam<Endpoint, CodeableConcept> {
    public override val name: KotlinString = "payload-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Endpoint.payloadType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Endpoint): List<CodeableConcept> = resource.payloadType
  }

  public data object Status : SearchParam<Endpoint, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Endpoint.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Endpoint): List<Any> = listOf(resource.status)
  }
}
