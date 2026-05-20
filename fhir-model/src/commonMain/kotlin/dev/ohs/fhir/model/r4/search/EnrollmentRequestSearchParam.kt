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
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EnrollmentRequest] resource type. */
public sealed class EnrollmentRequestSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: EnrollmentRequest): List<T>

  public data object Identifier : EnrollmentRequestSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EnrollmentRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: EnrollmentRequest
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Patient : EnrollmentRequestSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EnrollmentRequest.candidate"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: EnrollmentRequest): List<Reference> =
      listOfNotNull(resource.candidate)
  }

  public data object Status : EnrollmentRequestSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EnrollmentRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EnrollmentRequest): List<Any> =
      listOfNotNull(resource.status)
  }

  public data object Subject : EnrollmentRequestSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EnrollmentRequest.candidate"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: EnrollmentRequest): List<Reference> =
      listOfNotNull(resource.candidate)
  }

  public companion object {
    /** All search parameters for the EnrollmentRequest resource type. */
    public val ALL: List<EnrollmentRequestSearchParam<*>> =
      listOf(Identifier, Patient, Status, Subject)
  }
}
