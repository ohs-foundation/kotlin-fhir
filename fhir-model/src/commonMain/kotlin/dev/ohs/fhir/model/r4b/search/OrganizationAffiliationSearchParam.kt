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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Boolean
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.OrganizationAffiliation
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [OrganizationAffiliation] resource type. */
public sealed class OrganizationAffiliationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: OrganizationAffiliation): List<T>

  public data object Active : OrganizationAffiliationSearchParam<Boolean>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Date : OrganizationAffiliationSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "OrganizationAffiliation.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Email : OrganizationAffiliationSearchParam<ContactPoint>() {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.telecom.where(system='email')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Endpoint : OrganizationAffiliationSearchParam<Reference>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: OrganizationAffiliation): List<Reference> =
      resource.endpoint
  }

  public data object Identifier :
    OrganizationAffiliationSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: OrganizationAffiliation
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Location : OrganizationAffiliationSearchParam<Reference>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: OrganizationAffiliation): List<Reference> =
      resource.location
  }

  public data object Network : OrganizationAffiliationSearchParam<Reference>() {
    public override val paramName: String = "network"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.network"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: OrganizationAffiliation): List<Reference> =
      resource.network
  }

  public data object ParticipatingOrganization : OrganizationAffiliationSearchParam<Reference>() {
    public override val paramName: String = "participating-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.participatingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: OrganizationAffiliation): List<Reference> =
      listOfNotNull(resource.participatingOrganization)
  }

  public data object Phone : OrganizationAffiliationSearchParam<ContactPoint>() {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.telecom.where(system='phone')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object PrimaryOrganization : OrganizationAffiliationSearchParam<Reference>() {
    public override val paramName: String = "primary-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.organization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: OrganizationAffiliation): List<Reference> =
      listOfNotNull(resource.organization)
  }

  public data object Role : OrganizationAffiliationSearchParam<CodeableConcept>() {
    public override val paramName: String = "role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<CodeableConcept> =
      resource.code
  }

  public data object Service : OrganizationAffiliationSearchParam<Reference>() {
    public override val paramName: String = "service"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OrganizationAffiliation.healthcareService"

    public override val target: List<String> = listOf("HealthcareService")

    public override fun extract(resource: OrganizationAffiliation): List<Reference> =
      resource.healthcareService
  }

  public data object Specialty : OrganizationAffiliationSearchParam<CodeableConcept>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<CodeableConcept> =
      resource.specialty
  }

  public data object Telecom : OrganizationAffiliationSearchParam<ContactPoint>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OrganizationAffiliation.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OrganizationAffiliation): List<ContactPoint> =
      resource.telecom
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
