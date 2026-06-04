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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Endpoint] resource type. */
public object EndpointSearchParams {
  public val connectionType: SearchParam<Endpoint, Coding> =
    SearchParam<Endpoint, Coding>(
      name = "connection-type",
      type = SearchParamType.fromCode("token"),
      expression = "Endpoint.connectionType",
      extractor = { resource -> listOf(resource.connectionType) },
    )

  public val identifier: SearchParam<Endpoint, Identifier> =
    SearchParam<Endpoint, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Endpoint.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Endpoint, String> =
    SearchParam<Endpoint, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Endpoint.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val organization: SearchParam<Endpoint, Reference> =
    SearchParam<Endpoint, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Endpoint.managingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val payloadType: SearchParam<Endpoint, CodeableConcept> =
    SearchParam<Endpoint, CodeableConcept>(
      name = "payload-type",
      type = SearchParamType.fromCode("token"),
      expression = "Endpoint.payloadType",
      extractor = { resource -> resource.payloadType },
    )

  public val status: SearchParam<Endpoint, Any> =
    SearchParam<Endpoint, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Endpoint.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the Endpoint resource type. */
  public val all: List<SearchParam<Endpoint, *>> =
    listOf(connectionType, identifier, name, organization, payloadType, status)
}
