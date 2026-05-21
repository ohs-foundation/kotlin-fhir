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
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [HealthcareService] resource type. */
public object HealthcareServiceSearchParam {
  /** All search parameters for the HealthcareService resource type. */
  public val ALL: List<SearchParam<HealthcareService, *>> =
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

  public data object Active : SearchParam<HealthcareService, Boolean> {
    public override val paramName: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.active"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Characteristic : SearchParam<HealthcareService, CodeableConcept> {
    public override val paramName: KotlinString = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.characteristic"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.characteristic
  }

  public data object CoverageArea : SearchParam<HealthcareService, Reference> {
    public override val paramName: KotlinString = "coverage-area"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.coverageArea"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Location::class)

    public override fun extract(resource: HealthcareService): List<Reference> =
      resource.coverageArea
  }

  public data object Endpoint : SearchParam<HealthcareService, Reference> {
    public override val paramName: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.endpoint"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Endpoint::class)

    public override fun extract(resource: HealthcareService): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<HealthcareService, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: HealthcareService
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Location : SearchParam<HealthcareService, Reference> {
    public override val paramName: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Location::class)

    public override fun extract(resource: HealthcareService): List<Reference> = resource.location
  }

  public data object Name : SearchParam<HealthcareService, R4String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "HealthcareService.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Organization : SearchParam<HealthcareService, Reference> {
    public override val paramName: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.providedBy"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Organization::class)

    public override fun extract(resource: HealthcareService): List<Reference> =
      listOfNotNull(resource.providedBy)
  }

  public data object Program : SearchParam<HealthcareService, CodeableConcept> {
    public override val paramName: KotlinString = "program"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.program"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.program
  }

  public data object ServiceCategory : SearchParam<HealthcareService, CodeableConcept> {
    public override val paramName: KotlinString = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.category
  }

  public data object ServiceType : SearchParam<HealthcareService, CodeableConcept> {
    public override val paramName: KotlinString = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> = resource.type
  }

  public data object Specialty : SearchParam<HealthcareService, CodeableConcept> {
    public override val paramName: KotlinString = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.specialty"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.specialty
  }
}
