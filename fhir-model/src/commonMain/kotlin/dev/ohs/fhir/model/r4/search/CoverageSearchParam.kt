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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coverage
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Coverage] resource type. */
public object CoverageSearchParam {
  public val Beneficiary: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "beneficiary",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.beneficiary",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOf(resource.beneficiary) },
    )

  public val ClassType: SearchParam<Coverage, CodeableConcept> =
    SimpleSearchParam<Coverage, CodeableConcept>(
      name = "class-type",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.class.type",
      extractor = { resource -> resource.`class`.map { it.type } },
    )

  public val ClassValue: SearchParam<Coverage, String> =
    SimpleSearchParam<Coverage, String>(
      name = "class-value",
      type = SearchParamType.fromCode("string"),
      expression = "Coverage.class.value",
      extractor = { resource -> resource.`class`.map { it.value } },
    )

  public val Dependent: SearchParam<Coverage, String> =
    SimpleSearchParam<Coverage, String>(
      name = "dependent",
      type = SearchParamType.fromCode("string"),
      expression = "Coverage.dependent",
      extractor = { resource -> listOfNotNull(resource.dependent) },
    )

  public val Identifier: SearchParam<Coverage, Identifier> =
    SimpleSearchParam<Coverage, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.beneficiary",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOf(resource.beneficiary) },
    )

  public val Payor: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "payor",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.payor",
      target =
        listOf(Organization::class, dev.ohs.fhir.model.r4.Patient::class, RelatedPerson::class),
      extractor = { resource -> resource.payor },
    )

  public val PolicyHolder: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "policy-holder",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.policyHolder",
      target =
        listOf(Organization::class, dev.ohs.fhir.model.r4.Patient::class, RelatedPerson::class),
      extractor = { resource -> listOfNotNull(resource.policyHolder) },
    )

  public val Status: SearchParam<Coverage, Any> =
    SimpleSearchParam<Coverage, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subscriber: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "subscriber",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.subscriber",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, RelatedPerson::class),
      extractor = { resource -> listOfNotNull(resource.subscriber) },
    )

  public val Type: SearchParam<Coverage, CodeableConcept> =
    SimpleSearchParam<Coverage, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the Coverage resource type. */
  public val ALL: List<SearchParam<Coverage, *>> =
    listOf(
      Beneficiary,
      ClassType,
      ClassValue,
      Dependent,
      Identifier,
      Patient,
      Payor,
      PolicyHolder,
      Status,
      Subscriber,
      Type,
    )
}
