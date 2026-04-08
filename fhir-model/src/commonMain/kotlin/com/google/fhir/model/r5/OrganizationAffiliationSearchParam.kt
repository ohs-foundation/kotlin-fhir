/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [OrganizationAffiliation] resource type. */
public sealed class OrganizationAffiliationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: OrganizationAffiliation): List<T>

  public data object Active : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Date : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "OrganizationAffiliation.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Email : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "OrganizationAffiliation.contact.telecom.where(system='email')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Endpoint : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Identifier : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Location : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Network : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "network"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.network"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object ParticipatingOrganization : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "participating-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.participatingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Phone : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "OrganizationAffiliation.contact.telecom.where(system='phone')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object PrimaryOrganization : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "primary-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.organization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Role : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Service : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "service"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.healthcareService"

    public override val target: List<String> = listOf("HealthcareService")

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Specialty : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public data object Telecom : OrganizationAffiliationSearchParam<Any>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.contact.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the OrganizationAffiliation resource type. */
    public val ALL: List<OrganizationAffiliationSearchParam<*>> =
      listOf(
        Active,
        Date,
        Email,
        Endpoint,
        Identifier,
        Location,
        Network,
        ParticipatingOrganization,
        Phone,
        PrimaryOrganization,
        Role,
        Service,
        Specialty,
        Telecom,
      )
  }
}
