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
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Coverage] resource type. */
public object CoverageSearchParams {
  public val beneficiary: SearchParam<Coverage, Reference> =
    SearchParam(
      name = "beneficiary",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.beneficiary",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.beneficiary) },
    )

  public val classType: SearchParam<Coverage, CodeableConcept> =
    SearchParam(
      name = "class-type",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.class.type",
      extractor = { resource -> resource.`class`.map { it.type } },
    )

  public val classValue: SearchParam<Coverage, Identifier> =
    SearchParam(
      name = "class-value",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.class.value",
      extractor = { resource -> resource.`class`.map { it.`value` } },
    )

  public val dependent: SearchParam<Coverage, String> =
    SearchParam(
      name = "dependent",
      type = SearchParamType.fromCode("string"),
      expression = "Coverage.dependent",
      extractor = { resource -> listOfNotNull(resource.dependent) },
    )

  public val identifier: SearchParam<Coverage, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val insurer: SearchParam<Coverage, Reference> =
    SearchParam(
      name = "insurer",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.insurer) },
    )

  public val patient: SearchParam<Coverage, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.beneficiary",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.beneficiary) },
    )

  public val paymentbyParty: SearchParam<Coverage, Reference> =
    SearchParam(
      name = "paymentby-party",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.paymentBy.party",
      target = listOf(Organization::class, RelatedPerson::class, Patient::class),
      extractor = { resource -> resource.paymentBy.map { it.party } },
    )

  public val policyHolder: SearchParam<Coverage, Reference> =
    SearchParam(
      name = "policy-holder",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.policyHolder",
      target = listOf(Organization::class, RelatedPerson::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.policyHolder) },
    )

  public val status: SearchParam<Coverage, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subscriber: SearchParam<Coverage, Reference> =
    SearchParam(
      name = "subscriber",
      type = SearchParamType.fromCode("reference"),
      expression = "Coverage.subscriber",
      target = listOf(RelatedPerson::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subscriber) },
    )

  public val subscriberid: SearchParam<Coverage, Identifier> =
    SearchParam(
      name = "subscriberid",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.subscriberId",
      extractor = { resource -> resource.subscriberId },
    )

  public val type: SearchParam<Coverage, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Coverage.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Coverage, *>> = listOf()

  /**
   * Supported search parameters for the Coverage resource type. Entries in [unsupported] are
   * excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<Coverage, *>> =
    listOf(
      beneficiary,
      classType,
      classValue,
      dependent,
      identifier,
      insurer,
      patient,
      paymentbyParty,
      policyHolder,
      status,
      subscriber,
      subscriberid,
      type,
    ) - unsupported.toSet()
}
