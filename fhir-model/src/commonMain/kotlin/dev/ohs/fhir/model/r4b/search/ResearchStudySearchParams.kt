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
  public val Category: SearchParam<ResearchStudy, CodeableConcept> =
    SimpleSearchParam<ResearchStudy, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.category",
      extractor = { resource -> resource.category },
    )

  public val Date: SearchParam<ResearchStudy, Period> =
    SimpleSearchParam<ResearchStudy, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ResearchStudy.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val Focus: SearchParam<ResearchStudy, CodeableConcept> =
    SimpleSearchParam<ResearchStudy, CodeableConcept>(
      name = "focus",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.focus",
      extractor = { resource -> resource.focus },
    )

  public val Identifier: SearchParam<ResearchStudy, Identifier> =
    SimpleSearchParam<ResearchStudy, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Keyword: SearchParam<ResearchStudy, CodeableConcept> =
    SimpleSearchParam<ResearchStudy, CodeableConcept>(
      name = "keyword",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.keyword",
      extractor = { resource -> resource.keyword },
    )

  public val Location: SearchParam<ResearchStudy, CodeableConcept> =
    SimpleSearchParam<ResearchStudy, CodeableConcept>(
      name = "location",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.location",
      extractor = { resource -> resource.location },
    )

  public val Partof: SearchParam<ResearchStudy, Reference> =
    SimpleSearchParam<ResearchStudy, Reference>(
      name = "partof",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.partOf",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> resource.partOf },
    )

  public val Principalinvestigator: SearchParam<ResearchStudy, Reference> =
    SimpleSearchParam<ResearchStudy, Reference>(
      name = "principalinvestigator",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.principalInvestigator",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.principalInvestigator) },
    )

  public val Protocol: SearchParam<ResearchStudy, Reference> =
    SimpleSearchParam<ResearchStudy, Reference>(
      name = "protocol",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.protocol",
      target = listOf(PlanDefinition::class),
      extractor = { resource -> resource.protocol },
    )

  public val Site: SearchParam<ResearchStudy, Reference> =
    SimpleSearchParam<ResearchStudy, Reference>(
      name = "site",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.site",
      target = listOf(dev.ohs.fhir.model.r4b.Location::class),
      extractor = { resource -> resource.site },
    )

  public val Sponsor: SearchParam<ResearchStudy, Reference> =
    SimpleSearchParam<ResearchStudy, Reference>(
      name = "sponsor",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.sponsor",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.sponsor) },
    )

  public val Status: SearchParam<ResearchStudy, Any> =
    SimpleSearchParam<ResearchStudy, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<ResearchStudy, String> =
    SimpleSearchParam<ResearchStudy, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ResearchStudy.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  /** All search parameters for the ResearchStudy resource type. */
  public val ALL: List<SearchParam<ResearchStudy, *>> =
    listOf(
      Category,
      Date,
      Focus,
      Identifier,
      Keyword,
      Location,
      Partof,
      Principalinvestigator,
      Protocol,
      Site,
      Sponsor,
      Status,
      Title,
    )
}
