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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coverage
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Coverage] resource type. */
public object CoverageSearchParams {
  public val Beneficiary: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "beneficiary",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.beneficiary",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.beneficiary) },
    )

  public val ClassType: SearchParam<Coverage, CodeableConcept> =
    SimpleSearchParam<Coverage, CodeableConcept>(
      name = "class-type",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.class.type",
      extractor = { resource -> resource.`class`.map { it.type } },
    )

  public val ClassValue: SearchParam<Coverage, Identifier> =
    SimpleSearchParam<Coverage, Identifier>(
      name = "class-value",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.class.value",
      extractor = { resource -> resource.`class`.map { it.`value` } },
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

  public val Insurer: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "insurer",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.insurer) },
    )

  public val Patient: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.beneficiary",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.beneficiary) },
    )

  public val PaymentbyParty: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "paymentby-party",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.paymentBy.party",
      target =
        listOf(Organization::class, RelatedPerson::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> resource.paymentBy.map { it.party } },
    )

  public val PolicyHolder: SearchParam<Coverage, Reference> =
    SimpleSearchParam<Coverage, Reference>(
      name = "policy-holder",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.policyHolder",
      target =
        listOf(Organization::class, RelatedPerson::class, dev.ohs.fhir.model.r5.Patient::class),
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
      target = listOf(RelatedPerson::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subscriber) },
    )

  public val Subscriberid: SearchParam<Coverage, Identifier> =
    SimpleSearchParam<Coverage, Identifier>(
      name = "subscriberid",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.subscriberId",
      extractor = { resource -> resource.subscriberId },
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
      Insurer,
      Patient,
      PaymentbyParty,
      PolicyHolder,
      Status,
      Subscriber,
      Subscriberid,
      Type,
    )
}
