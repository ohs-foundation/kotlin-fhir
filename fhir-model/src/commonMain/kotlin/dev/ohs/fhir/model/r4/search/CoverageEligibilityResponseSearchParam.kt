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

import dev.ohs.fhir.model.r4.CoverageEligibilityRequest
import dev.ohs.fhir.model.r4.CoverageEligibilityResponse
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [CoverageEligibilityResponse] resource type. */
public object CoverageEligibilityResponseSearchParam {
  /** All search parameters for the CoverageEligibilityResponse resource type. */
  public val ALL: List<SearchParam<CoverageEligibilityResponse, *>> =
    listOf(Created, Disposition, Identifier, Insurer, Outcome, Patient, Request, Requestor, Status)

  public data object Created : SearchParam<CoverageEligibilityResponse, DateTime> {
    public override val name: KotlinString = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "CoverageEligibilityResponse.created"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CoverageEligibilityResponse): List<DateTime> =
      listOf(resource.created)
  }

  public data object Disposition : SearchParam<CoverageEligibilityResponse, R4String> {
    public override val name: KotlinString = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CoverageEligibilityResponse.disposition"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CoverageEligibilityResponse): List<R4String> =
      listOfNotNull(resource.disposition)
  }

  public data object Identifier :
    SearchParam<CoverageEligibilityResponse, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CoverageEligibilityResponse.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: CoverageEligibilityResponse
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Insurer : SearchParam<CoverageEligibilityResponse, Reference> {
    public override val name: KotlinString = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "CoverageEligibilityResponse.insurer"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: CoverageEligibilityResponse): List<Reference> =
      listOf(resource.insurer)
  }

  public data object Outcome : SearchParam<CoverageEligibilityResponse, Any> {
    public override val name: KotlinString = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CoverageEligibilityResponse.outcome"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CoverageEligibilityResponse): List<Any> =
      listOf(resource.outcome)
  }

  public data object Patient : SearchParam<CoverageEligibilityResponse, Reference> {
    public override val name: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "CoverageEligibilityResponse.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: CoverageEligibilityResponse): List<Reference> =
      listOf(resource.patient)
  }

  public data object Request : SearchParam<CoverageEligibilityResponse, Reference> {
    public override val name: KotlinString = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "CoverageEligibilityResponse.request"

    public override val target: List<KClass<out Resource>> =
      listOf(CoverageEligibilityRequest::class)

    public override fun extract(resource: CoverageEligibilityResponse): List<Reference> =
      listOf(resource.request)
  }

  public data object Requestor : SearchParam<CoverageEligibilityResponse, Reference> {
    public override val name: KotlinString = "requestor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "CoverageEligibilityResponse.requestor"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, PractitionerRole::class)

    public override fun extract(resource: CoverageEligibilityResponse): List<Reference> =
      listOfNotNull(resource.requestor)
  }

  public data object Status : SearchParam<CoverageEligibilityResponse, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CoverageEligibilityResponse.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CoverageEligibilityResponse): List<Any> =
      listOf(resource.status)
  }
}
