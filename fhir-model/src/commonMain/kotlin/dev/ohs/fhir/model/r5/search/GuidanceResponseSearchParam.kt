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

import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.GuidanceResponse
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [GuidanceResponse] resource type. */
public object GuidanceResponseSearchParam {
  public val Identifier: SearchParam<GuidanceResponse, Identifier> =
    SimpleSearchParam<GuidanceResponse, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "GuidanceResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<GuidanceResponse, Reference> =
    SimpleSearchParam<GuidanceResponse, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "GuidanceResponse.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Request: SearchParam<GuidanceResponse, Identifier> =
    SimpleSearchParam<GuidanceResponse, Identifier>(
      name = "request",
      type = SearchParamType.fromCode("token"),
      expression = "GuidanceResponse.requestIdentifier",
      extractor = { resource -> listOfNotNull(resource.requestIdentifier) },
    )

  public val Status: SearchParam<GuidanceResponse, Any> =
    SimpleSearchParam<GuidanceResponse, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "GuidanceResponse.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<GuidanceResponse, Reference> =
    SimpleSearchParam<GuidanceResponse, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "GuidanceResponse.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the GuidanceResponse resource type. */
  public val ALL: List<SearchParam<GuidanceResponse, *>> =
    listOf(Identifier, Patient, Request, Status, Subject)
}
