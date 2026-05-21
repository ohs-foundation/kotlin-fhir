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

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [PractitionerRole] resource type. */
public object PractitionerRoleSearchParam {
  /** All search parameters for the PractitionerRole resource type. */
  public val ALL: List<SearchParam<PractitionerRole, *>> =
    listOf(
      Active,
      Date,
      Email,
      Endpoint,
      Identifier,
      Location,
      Organization,
      Phone,
      Practitioner,
      Role,
      Service,
      Specialty,
      Telecom,
    )

  public data object Active : SearchParam<PractitionerRole, Boolean> {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.active"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Date : SearchParam<PractitionerRole, Period> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "PractitionerRole.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Email : SearchParam<PractitionerRole, ContactPoint> {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.telecom.where(system='email')"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: PractitionerRole): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Endpoint : SearchParam<PractitionerRole, Reference> {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.endpoint"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Endpoint::class)

    public override fun extract(resource: PractitionerRole): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<PractitionerRole, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: PractitionerRole
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Location : SearchParam<PractitionerRole, Reference> {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Location::class)

    public override fun extract(resource: PractitionerRole): List<Reference> = resource.location
  }

  public data object Organization : SearchParam<PractitionerRole, Reference> {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.organization"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Organization::class)

    public override fun extract(resource: PractitionerRole): List<Reference> =
      listOfNotNull(resource.organization)
  }

  public data object Phone : SearchParam<PractitionerRole, ContactPoint> {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.telecom.where(system='phone')"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: PractitionerRole): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Practitioner : SearchParam<PractitionerRole, Reference> {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.practitioner"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Practitioner::class)

    public override fun extract(resource: PractitionerRole): List<Reference> =
      listOfNotNull(resource.practitioner)
  }

  public data object Role : SearchParam<PractitionerRole, CodeableConcept> {
    public override val paramName: String = "role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: PractitionerRole): List<CodeableConcept> = resource.code
  }

  public data object Service : SearchParam<PractitionerRole, Reference> {
    public override val paramName: String = "service"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.healthcareService"

    public override val target: List<KClass<out Resource>> = listOf(HealthcareService::class)

    public override fun extract(resource: PractitionerRole): List<Reference> =
      resource.healthcareService
  }

  public data object Specialty : SearchParam<PractitionerRole, CodeableConcept> {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.specialty"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: PractitionerRole): List<CodeableConcept> =
      resource.specialty
  }

  public data object Telecom : SearchParam<PractitionerRole, ContactPoint> {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.telecom"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: PractitionerRole): List<ContactPoint> = resource.telecom
  }
}
