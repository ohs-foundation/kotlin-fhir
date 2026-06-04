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

import dev.ohs.fhir.model.r4.EnrollmentRequest
import dev.ohs.fhir.model.r4.EnrollmentResponse
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EnrollmentResponse] resource type. */
public object EnrollmentResponseSearchParams {
  public val Identifier: SearchParam<EnrollmentResponse, Identifier> =
    SimpleSearchParam<EnrollmentResponse, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "EnrollmentResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Request: SearchParam<EnrollmentResponse, Reference> =
    SimpleSearchParam<EnrollmentResponse, Reference>(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "EnrollmentResponse.request",
      target = listOf(EnrollmentRequest::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val Status: SearchParam<EnrollmentResponse, Any> =
    SimpleSearchParam<EnrollmentResponse, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "EnrollmentResponse.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  /** All search parameters for the EnrollmentResponse resource type. */
  public val ALL: List<SearchParam<EnrollmentResponse, *>> = listOf(Identifier, Request, Status)
}
