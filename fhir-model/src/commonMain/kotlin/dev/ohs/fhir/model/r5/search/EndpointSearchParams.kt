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
import dev.ohs.fhir.model.r5.Endpoint
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Endpoint] resource type. */
public object EndpointSearchParams {
  public val ConnectionType: SearchParam<Endpoint, CodeableConcept> =
    SimpleSearchParam<Endpoint, CodeableConcept>(
      name = "connection-type",
      type = SearchParamType.fromCode("token"),
      expression = "Endpoint.connectionType",
      extractor = { resource -> resource.connectionType },
    )

  public val Identifier: SearchParam<Endpoint, Identifier> =
    SimpleSearchParam<Endpoint, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Endpoint.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<Endpoint, String> =
    SimpleSearchParam<Endpoint, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Endpoint.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Organization: SearchParam<Endpoint, Reference> =
    SimpleSearchParam<Endpoint, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Endpoint.managingOrganization",
      target = listOf(dev.ohs.fhir.model.r5.Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val PayloadType: SearchParam<Endpoint, CodeableConcept> =
    SimpleSearchParam<Endpoint, CodeableConcept>(
      name = "payload-type",
      type = SearchParamType.fromCode("token"),
      expression = "Endpoint.payload.type",
      extractor = { resource -> resource.payload.flatMap { it.type } },
    )

  public val Status: SearchParam<Endpoint, Any> =
    SimpleSearchParam<Endpoint, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Endpoint.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the Endpoint resource type. */
  public val ALL: List<SearchParam<Endpoint, *>> =
    listOf(ConnectionType, Identifier, Name, Organization, PayloadType, Status)
}
