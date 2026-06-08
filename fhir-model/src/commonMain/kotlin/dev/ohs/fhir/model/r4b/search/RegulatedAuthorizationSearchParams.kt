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

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DeviceDefinition
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.NutritionProduct
import dev.ohs.fhir.model.r4b.ObservationDefinition
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.PackagedProductDefinition
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RegulatedAuthorization
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.SubstanceDefinition
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RegulatedAuthorization] resource type. */
public object RegulatedAuthorizationSearchParams {
  public val case: SearchParam<RegulatedAuthorization, Identifier> =
    SearchParam(
      name = "case",
      type = SearchParamType.Token,
      expression = "RegulatedAuthorization.case.identifier",
      extractor = { resource -> listOfNotNull(resource.case?.identifier) },
    )

  public val caseType: SearchParam<RegulatedAuthorization, CodeableConcept> =
    SearchParam(
      name = "case-type",
      type = SearchParamType.Token,
      expression = "RegulatedAuthorization.case.type",
      extractor = { resource -> listOfNotNull(resource.case?.type) },
    )

  public val holder: SearchParam<RegulatedAuthorization, Reference> =
    SearchParam(
      name = "holder",
      type = SearchParamType.Reference,
      expression = "RegulatedAuthorization.holder",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.holder) },
    )

  public val identifier: SearchParam<RegulatedAuthorization, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "RegulatedAuthorization.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val region: SearchParam<RegulatedAuthorization, CodeableConcept> =
    SearchParam(
      name = "region",
      type = SearchParamType.Token,
      expression = "RegulatedAuthorization.region",
      extractor = { resource -> resource.region },
    )

  public val status: SearchParam<RegulatedAuthorization, CodeableConcept> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "RegulatedAuthorization.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val subject: SearchParam<RegulatedAuthorization, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "RegulatedAuthorization.subject",
      target =
        listOf(
          SubstanceDefinition::class,
          Organization::class,
          BiologicallyDerivedProduct::class,
          PackagedProductDefinition::class,
          ResearchStudy::class,
          Practitioner::class,
          MedicinalProductDefinition::class,
          NutritionProduct::class,
          DeviceDefinition::class,
          ObservationDefinition::class,
          PlanDefinition::class,
          ActivityDefinition::class,
          Location::class,
        ),
      extractor = { resource -> resource.subject },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<RegulatedAuthorization, *>> = listOf()

  /**
   * Supported search parameters for the RegulatedAuthorization resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<RegulatedAuthorization, *>> =
    listOf(case, caseType, holder, identifier, region, status, subject)
}
