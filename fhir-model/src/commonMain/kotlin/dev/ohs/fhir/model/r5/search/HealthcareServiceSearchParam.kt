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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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
      Communication,
      CoverageArea,
      Eligibility,
      Endpoint,
      Identifier,
      Location,
      Name,
      OfferedIn,
      Organization,
      Program,
      ServiceCategory,
      ServiceType,
      Specialty,
    )

  public data object Active : SearchParam<HealthcareService, Boolean> {
    public override val name: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.active"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Characteristic : SearchParam<HealthcareService, CodeableConcept> {
    public override val name: KotlinString = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.characteristic"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.characteristic
  }

  public data object Communication : SearchParam<HealthcareService, CodeableConcept> {
    public override val name: KotlinString = "communication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.communication"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.communication
  }

  public data object CoverageArea : SearchParam<HealthcareService, Reference> {
    public override val name: KotlinString = "coverage-area"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.coverageArea"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: HealthcareService): List<Reference> =
      resource.coverageArea
  }

  public data object Eligibility : SearchParam<HealthcareService, CodeableConcept> {
    public override val name: KotlinString = "eligibility"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.eligibility.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.eligibility.mapNotNull { it.code }
  }

  public data object Endpoint : SearchParam<HealthcareService, Reference> {
    public override val name: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.endpoint"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Endpoint::class)

    public override fun extract(resource: HealthcareService): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<HealthcareService, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: HealthcareService
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Location : SearchParam<HealthcareService, Reference> {
    public override val name: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: HealthcareService): List<Reference> = resource.location
  }

  public data object Name : SearchParam<HealthcareService, R5String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "HealthcareService.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object OfferedIn : SearchParam<HealthcareService, Reference> {
    public override val name: KotlinString = "offered-in"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.offeredIn"

    public override val target: List<KClass<out Resource>> = listOf(HealthcareService::class)

    public override fun extract(resource: HealthcareService): List<Reference> = resource.offeredIn
  }

  public data object Organization : SearchParam<HealthcareService, Reference> {
    public override val name: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "HealthcareService.providedBy"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Organization::class)

    public override fun extract(resource: HealthcareService): List<Reference> =
      listOfNotNull(resource.providedBy)
  }

  public data object Program : SearchParam<HealthcareService, CodeableConcept> {
    public override val name: KotlinString = "program"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.program"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.program
  }

  public data object ServiceCategory : SearchParam<HealthcareService, CodeableConcept> {
    public override val name: KotlinString = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.category
  }

  public data object ServiceType : SearchParam<HealthcareService, CodeableConcept> {
    public override val name: KotlinString = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> = resource.type
  }

  public data object Specialty : SearchParam<HealthcareService, CodeableConcept> {
    public override val name: KotlinString = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "HealthcareService.specialty"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: HealthcareService): List<CodeableConcept> =
      resource.specialty
  }
}
