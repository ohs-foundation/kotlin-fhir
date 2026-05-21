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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [CoverageEligibilityRequest] resource type. */
public object CoverageEligibilityRequestSearchParam {
  /** All search parameters for the CoverageEligibilityRequest resource type. */
  public val ALL: List<SearchParam<CoverageEligibilityRequest, *>> =
    listOf(Created, Enterer, Facility, Identifier, Patient, Provider, Status)

  public data object Created : SearchParam<CoverageEligibilityRequest, DateTime> {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CoverageEligibilityRequest.created"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CoverageEligibilityRequest): List<DateTime> =
      listOf(resource.created)
  }

  public data object Enterer : SearchParam<CoverageEligibilityRequest, Reference> {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CoverageEligibilityRequest.enterer"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: CoverageEligibilityRequest): List<Reference> =
      listOfNotNull(resource.enterer)
  }

  public data object Facility : SearchParam<CoverageEligibilityRequest, Reference> {
    public override val paramName: String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CoverageEligibilityRequest.facility"

    public override val target: List<KClass<out Resource>> = listOf(Location::class)

    public override fun extract(resource: CoverageEligibilityRequest): List<Reference> =
      listOfNotNull(resource.facility)
  }

  public data object Identifier :
    SearchParam<CoverageEligibilityRequest, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CoverageEligibilityRequest.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: CoverageEligibilityRequest
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Patient : SearchParam<CoverageEligibilityRequest, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CoverageEligibilityRequest.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: CoverageEligibilityRequest): List<Reference> =
      listOf(resource.patient)
  }

  public data object Provider : SearchParam<CoverageEligibilityRequest, Reference> {
    public override val paramName: String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CoverageEligibilityRequest.provider"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, PractitionerRole::class)

    public override fun extract(resource: CoverageEligibilityRequest): List<Reference> =
      listOfNotNull(resource.provider)
  }

  public data object Status : SearchParam<CoverageEligibilityRequest, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CoverageEligibilityRequest.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CoverageEligibilityRequest): List<Any> =
      listOf(resource.status)
  }
}
