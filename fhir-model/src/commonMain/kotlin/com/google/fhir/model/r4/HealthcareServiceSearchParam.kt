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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [HealthcareService] resource type. */
public sealed class HealthcareServiceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: HealthcareService): List<T>

  public data object Active : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "HealthcareService.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object Characteristic : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "HealthcareService.characteristic"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object CoverageArea : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "coverage-area"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "HealthcareService.coverageArea"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object Endpoint : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "HealthcareService.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object Identifier : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "HealthcareService.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object Location : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "HealthcareService.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object Name : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "HealthcareService.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object Organization : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "HealthcareService.providedBy"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object Program : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "program"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "HealthcareService.program"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object ServiceCategory : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "HealthcareService.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object ServiceType : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "HealthcareService.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public data object Specialty : HealthcareServiceSearchParam<Any>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "HealthcareService.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the HealthcareService resource type. */
    public val ALL: List<HealthcareServiceSearchParam<*>> =
      listOf(
        Active,
        Characteristic,
        CoverageArea,
        Endpoint,
        Identifier,
        Location,
        Name,
        Organization,
        Program,
        ServiceCategory,
        ServiceType,
        Specialty,
      )
  }
}
