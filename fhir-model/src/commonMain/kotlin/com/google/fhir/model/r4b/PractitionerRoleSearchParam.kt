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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PractitionerRole] resource type. */
public sealed class PractitionerRoleSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: PractitionerRole): List<T>

  public data object Active : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Date : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "PractitionerRole.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Email : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.telecom.where(system='email')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Endpoint : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Identifier : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Location : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Organization : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.organization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Phone : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.telecom.where(system='phone')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Practitioner : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.practitioner"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Role : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Service : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "service"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.healthcareService"

    public override val target: List<String> = listOf("HealthcareService")

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Specialty : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public data object Telecom : PractitionerRoleSearchParam<Any>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the PractitionerRole resource type. */
    public val ALL: List<PractitionerRoleSearchParam<*>> =
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
  }
}
