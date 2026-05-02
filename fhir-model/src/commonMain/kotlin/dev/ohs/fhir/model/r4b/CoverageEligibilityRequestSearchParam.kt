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
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CoverageEligibilityRequest] resource type. */
public sealed class CoverageEligibilityRequestSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CoverageEligibilityRequest): List<T>

  public data object Created : CoverageEligibilityRequestSearchParam<DateTime>() {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CoverageEligibilityRequest.created"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CoverageEligibilityRequest): List<DateTime> =
      listOf(resource.created)
  }

  public data object Enterer : CoverageEligibilityRequestSearchParam<Reference>() {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CoverageEligibilityRequest.enterer"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: CoverageEligibilityRequest): List<Reference> =
      listOfNotNull(resource.enterer)
  }

  public data object Facility : CoverageEligibilityRequestSearchParam<Reference>() {
    public override val paramName: String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CoverageEligibilityRequest.facility"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: CoverageEligibilityRequest): List<Reference> =
      listOfNotNull(resource.facility)
  }

  public data object Identifier :
    CoverageEligibilityRequestSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CoverageEligibilityRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: CoverageEligibilityRequest
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Patient : CoverageEligibilityRequestSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CoverageEligibilityRequest.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: CoverageEligibilityRequest): List<Reference> =
      listOf(resource.patient)
  }

  public data object Provider : CoverageEligibilityRequestSearchParam<Reference>() {
    public override val paramName: String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CoverageEligibilityRequest.provider"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: CoverageEligibilityRequest): List<Reference> =
      listOfNotNull(resource.provider)
  }

  public data object Status : CoverageEligibilityRequestSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CoverageEligibilityRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CoverageEligibilityRequest): List<Any> =
      listOf(resource.status)
  }

  public companion object {
    /** All search parameters for the CoverageEligibilityRequest resource type. */
    public val ALL: List<CoverageEligibilityRequestSearchParam<*>> =
      listOf(Created, Enterer, Facility, Identifier, Patient, Provider, Status)
  }
}
