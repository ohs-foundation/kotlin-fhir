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

import dev.ohs.fhir.model.r5.ActivityDefinition
import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Ingredient
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.ObservationDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.PackagedProductDefinition
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RegulatedAuthorization
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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
          Ingredient::class,
          Organization::class,
          ObservationDefinition::class,
          ActivityDefinition::class,
          PlanDefinition::class,
          BiologicallyDerivedProduct::class,
          Practitioner::class,
          PackagedProductDefinition::class,
          SubstanceDefinition::class,
          Location::class,
          MedicinalProductDefinition::class,
          NutritionProduct::class,
          DeviceDefinition::class,
          ResearchStudy::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource -> resource.subject },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
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
