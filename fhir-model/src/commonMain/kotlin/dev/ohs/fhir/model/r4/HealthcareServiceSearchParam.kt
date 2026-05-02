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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [HealthcareService] resource type. */
public sealed class HealthcareServiceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: HealthcareService): List<T>

  public data object Active : HealthcareServiceSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "HealthcareService.active"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: HealthcareService): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Characteristic : HealthcareServiceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "HealthcareService.characteristic"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.characteristic
  }

  public data object CoverageArea : HealthcareServiceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "coverage-area"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "HealthcareService.coverageArea"

    public override val target: List<kotlin.String> = listOf("Location")

    public override fun extract(resource: HealthcareService): List<Reference> =
      resource.coverageArea
  }

  public data object Endpoint : HealthcareServiceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "HealthcareService.endpoint"

    public override val target: List<kotlin.String> = listOf("Endpoint")

    public override fun extract(resource: HealthcareService): List<Reference> = resource.endpoint
  }

  public data object Identifier : HealthcareServiceSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "HealthcareService.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: HealthcareService
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Location : HealthcareServiceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "HealthcareService.location"

    public override val target: List<kotlin.String> = listOf("Location")

    public override fun extract(resource: HealthcareService): List<Reference> = resource.location
  }

  public data object Name : HealthcareServiceSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "HealthcareService.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: HealthcareService): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Organization : HealthcareServiceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "HealthcareService.providedBy"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: HealthcareService): List<Reference> =
      listOfNotNull(resource.providedBy)
  }

  public data object Program : HealthcareServiceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "program"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "HealthcareService.program"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.program
  }

  public data object ServiceCategory : HealthcareServiceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "HealthcareService.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.category
  }

  public data object ServiceType : HealthcareServiceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "HealthcareService.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> = resource.type
  }

  public data object Specialty : HealthcareServiceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "HealthcareService.specialty"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.specialty
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
