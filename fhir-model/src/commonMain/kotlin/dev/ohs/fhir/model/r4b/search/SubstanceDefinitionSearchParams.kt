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
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.SubstanceDefinition
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SubstanceDefinition] resource type. */
public object SubstanceDefinitionSearchParams {
  public val classification: SearchParam<SubstanceDefinition, CodeableConcept> =
    SimpleSearchParam<SubstanceDefinition, CodeableConcept>(
      name = "classification",
      type = SearchParamType.fromCode("token"),
      expression = "SubstanceDefinition.classification",
      extractor = { resource -> resource.classification },
    )

  public val code: SearchParam<SubstanceDefinition, CodeableConcept> =
    SimpleSearchParam<SubstanceDefinition, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "SubstanceDefinition.code.code",
      extractor = { resource -> resource.code.mapNotNull { it.code } },
    )

  public val domain: SearchParam<SubstanceDefinition, CodeableConcept> =
    SimpleSearchParam<SubstanceDefinition, CodeableConcept>(
      name = "domain",
      type = SearchParamType.fromCode("token"),
      expression = "SubstanceDefinition.domain",
      extractor = { resource -> listOfNotNull(resource.domain) },
    )

  public val identifier: SearchParam<SubstanceDefinition, Identifier> =
    SimpleSearchParam<SubstanceDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SubstanceDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<SubstanceDefinition, String> =
    SimpleSearchParam<SubstanceDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "SubstanceDefinition.name.name",
      extractor = { resource -> resource.name.map { it.name } },
    )

  /** All search parameters for the SubstanceDefinition resource type. */
  public val all: List<SearchParam<SubstanceDefinition, *>> =
    listOf(classification, code, domain, identifier, name)
}
