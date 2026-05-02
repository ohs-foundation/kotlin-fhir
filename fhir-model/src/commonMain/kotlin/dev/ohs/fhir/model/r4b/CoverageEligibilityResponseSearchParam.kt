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

/** Search parameters for the [CoverageEligibilityResponse] resource type. */
public sealed class CoverageEligibilityResponseSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CoverageEligibilityResponse): List<T>

  public data object Created : CoverageEligibilityResponseSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.created"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CoverageEligibilityResponse): List<DateTime> =
      listOf(resource.created)
  }

  public data object Disposition : CoverageEligibilityResponseSearchParam<String>() {
    public override val paramName: kotlin.String = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.disposition"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CoverageEligibilityResponse): List<String> =
      listOfNotNull(resource.disposition)
  }

  public data object Identifier :
    CoverageEligibilityResponseSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: CoverageEligibilityResponse
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Insurer : CoverageEligibilityResponseSearchParam<Reference>() {
    public override val paramName: kotlin.String = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.insurer"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: CoverageEligibilityResponse): List<Reference> =
      listOf(resource.insurer)
  }

  public data object Outcome : CoverageEligibilityResponseSearchParam<Any>() {
    public override val paramName: kotlin.String = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.outcome"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CoverageEligibilityResponse): List<Any> =
      listOf(resource.outcome)
  }

  public data object Patient : CoverageEligibilityResponseSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.patient"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: CoverageEligibilityResponse): List<Reference> =
      listOf(resource.patient)
  }

  public data object Request : CoverageEligibilityResponseSearchParam<Reference>() {
    public override val paramName: kotlin.String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.request"

    public override val target: List<kotlin.String> = listOf("CoverageEligibilityRequest")

    public override fun extract(resource: CoverageEligibilityResponse): List<Reference> =
      listOf(resource.request)
  }

  public data object Requestor : CoverageEligibilityResponseSearchParam<Reference>() {
    public override val paramName: kotlin.String = "requestor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.requestor"

    public override val target: List<kotlin.String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: CoverageEligibilityResponse): List<Reference> =
      listOfNotNull(resource.requestor)
  }

  public data object Status : CoverageEligibilityResponseSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CoverageEligibilityResponse.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CoverageEligibilityResponse): List<Any> =
      listOf(resource.status)
  }

  public companion object {
    /** All search parameters for the CoverageEligibilityResponse resource type. */
    public val ALL: List<CoverageEligibilityResponseSearchParam<*>> =
      listOf(
        Created,
        Disposition,
        Identifier,
        Insurer,
        Outcome,
        Patient,
        Request,
        Requestor,
        Status,
      )
  }
}
