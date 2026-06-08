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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchStudy] resource type. */
public object ResearchStudySearchParams {
  public val category: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "ResearchStudy.category",
      extractor = { resource -> resource.category },
    )

  public val date: SearchParam<ResearchStudy, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "ResearchStudy.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val focus: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "focus",
      type = SearchParamType.Token,
      expression = "ResearchStudy.focus",
      extractor = { resource -> resource.focus },
    )

  public val identifier: SearchParam<ResearchStudy, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ResearchStudy.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val keyword: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "keyword",
      type = SearchParamType.Token,
      expression = "ResearchStudy.keyword",
      extractor = { resource -> resource.keyword },
    )

  public val location: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "location",
      type = SearchParamType.Token,
      expression = "ResearchStudy.location",
      extractor = { resource -> resource.location },
    )

  public val partof: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "partof",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.partOf",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> resource.partOf },
    )

  public val principalinvestigator: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "principalinvestigator",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.principalInvestigator",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.principalInvestigator) },
    )

  public val protocol: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "protocol",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.protocol",
      target = listOf(PlanDefinition::class),
      extractor = { resource -> resource.protocol },
    )

  public val site: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "site",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.site",
      target = listOf(Location::class),
      extractor = { resource -> resource.site },
    )

  public val sponsor: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "sponsor",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.sponsor",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.sponsor) },
    )

  public val status: SearchParam<ResearchStudy, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ResearchStudy.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<ResearchStudy, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "ResearchStudy.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ResearchStudy, *>> = listOf()

  /**
   * Supported search parameters for the ResearchStudy resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ResearchStudy, *>> =
    listOf(
      category,
      date,
      focus,
      identifier,
      keyword,
      location,
      partof,
      principalinvestigator,
      protocol,
      site,
      sponsor,
      status,
      title,
    )
}
