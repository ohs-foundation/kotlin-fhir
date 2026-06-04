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
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [HealthcareService] resource type. */
public object HealthcareServiceSearchParams {
  public val Active: SearchParam<HealthcareService, Boolean> =
    SimpleSearchParam<HealthcareService, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val Characteristic: SearchParam<HealthcareService, CodeableConcept> =
    SimpleSearchParam<HealthcareService, CodeableConcept>(
      name = "characteristic",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.characteristic",
      extractor = { resource -> resource.characteristic },
    )

  public val CoverageArea: SearchParam<HealthcareService, Reference> =
    SimpleSearchParam<HealthcareService, Reference>(
      name = "coverage-area",
      type = SearchParamType.fromCode("reference"),
      expression = "HealthcareService.coverageArea",
      target = listOf(dev.ohs.fhir.model.r4b.Location::class),
      extractor = { resource -> resource.coverageArea },
    )

  public val Endpoint: SearchParam<HealthcareService, Reference> =
    SimpleSearchParam<HealthcareService, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "HealthcareService.endpoint",
      target = listOf(dev.ohs.fhir.model.r4b.Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val Identifier: SearchParam<HealthcareService, Identifier> =
    SimpleSearchParam<HealthcareService, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Location: SearchParam<HealthcareService, Reference> =
    SimpleSearchParam<HealthcareService, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "HealthcareService.location",
      target = listOf(dev.ohs.fhir.model.r4b.Location::class),
      extractor = { resource -> resource.location },
    )

  public val Name: SearchParam<HealthcareService, String> =
    SimpleSearchParam<HealthcareService, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "HealthcareService.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Organization: SearchParam<HealthcareService, Reference> =
    SimpleSearchParam<HealthcareService, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "HealthcareService.providedBy",
      target = listOf(dev.ohs.fhir.model.r4b.Organization::class),
      extractor = { resource -> listOfNotNull(resource.providedBy) },
    )

  public val Program: SearchParam<HealthcareService, CodeableConcept> =
    SimpleSearchParam<HealthcareService, CodeableConcept>(
      name = "program",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.program",
      extractor = { resource -> resource.program },
    )

  public val ServiceCategory: SearchParam<HealthcareService, CodeableConcept> =
    SimpleSearchParam<HealthcareService, CodeableConcept>(
      name = "service-category",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.category",
      extractor = { resource -> resource.category },
    )

  public val ServiceType: SearchParam<HealthcareService, CodeableConcept> =
    SimpleSearchParam<HealthcareService, CodeableConcept>(
      name = "service-type",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.type",
      extractor = { resource -> resource.type },
    )

  public val Specialty: SearchParam<HealthcareService, CodeableConcept> =
    SimpleSearchParam<HealthcareService, CodeableConcept>(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.specialty",
      extractor = { resource -> resource.specialty },
    )

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
}
