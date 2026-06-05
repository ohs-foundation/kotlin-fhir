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
import dev.ohs.fhir.model.r4b.Endpoint
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [HealthcareService] resource type. */
public object HealthcareServiceSearchParams {
  public val active: SearchParam<HealthcareService, Boolean> =
    SearchParam(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val characteristic: SearchParam<HealthcareService, CodeableConcept> =
    SearchParam(
      name = "characteristic",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.characteristic",
      extractor = { resource -> resource.characteristic },
    )

  public val coverageArea: SearchParam<HealthcareService, Reference> =
    SearchParam(
      name = "coverage-area",
      type = SearchParamType.fromCode("reference"),
      expression = "HealthcareService.coverageArea",
      target = listOf(Location::class),
      extractor = { resource -> resource.coverageArea },
    )

  public val endpoint: SearchParam<HealthcareService, Reference> =
    SearchParam(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "HealthcareService.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<HealthcareService, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<HealthcareService, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "HealthcareService.location",
      target = listOf(Location::class),
      extractor = { resource -> resource.location },
    )

  public val name: SearchParam<HealthcareService, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "HealthcareService.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val organization: SearchParam<HealthcareService, Reference> =
    SearchParam(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "HealthcareService.providedBy",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.providedBy) },
    )

  public val program: SearchParam<HealthcareService, CodeableConcept> =
    SearchParam(
      name = "program",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.program",
      extractor = { resource -> resource.program },
    )

  public val serviceCategory: SearchParam<HealthcareService, CodeableConcept> =
    SearchParam(
      name = "service-category",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.category",
      extractor = { resource -> resource.category },
    )

  public val serviceType: SearchParam<HealthcareService, CodeableConcept> =
    SearchParam(
      name = "service-type",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.type",
      extractor = { resource -> resource.type },
    )

  public val specialty: SearchParam<HealthcareService, CodeableConcept> =
    SearchParam(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "HealthcareService.specialty",
      extractor = { resource -> resource.specialty },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<HealthcareService, *>> = listOf()

  /**
   * Supported search parameters for the HealthcareService resource type. Entries in [unsupported]
   * are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<HealthcareService, *>> =
    listOf(
      active,
      characteristic,
      coverageArea,
      endpoint,
      identifier,
      location,
      name,
      organization,
      program,
      serviceCategory,
      serviceType,
      specialty,
    ) - unsupported.toSet()
}
