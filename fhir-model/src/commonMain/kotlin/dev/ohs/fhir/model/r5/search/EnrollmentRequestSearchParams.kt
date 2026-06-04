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

import dev.ohs.fhir.model.r5.EnrollmentRequest
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EnrollmentRequest] resource type. */
public object EnrollmentRequestSearchParams {
  public val identifier: SearchParam<EnrollmentRequest, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "EnrollmentRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<EnrollmentRequest, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "EnrollmentRequest.candidate",
      target = listOf(Patient::class),
      extractor = { resource -> listOfNotNull(resource.candidate) },
    )

  public val status: SearchParam<EnrollmentRequest, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "EnrollmentRequest.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val subject: SearchParam<EnrollmentRequest, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "EnrollmentRequest.candidate",
      target = listOf(Patient::class),
      extractor = { resource -> listOfNotNull(resource.candidate) },
    )

  /** All search parameters for the EnrollmentRequest resource type. */
  public val all: List<SearchParam<EnrollmentRequest, *>> =
    listOf(identifier, patient, status, subject)
}
