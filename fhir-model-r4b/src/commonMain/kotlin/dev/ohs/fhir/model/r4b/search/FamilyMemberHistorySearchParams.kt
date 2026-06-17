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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.FamilyMemberHistory
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Measure
import dev.ohs.fhir.model.r4b.OperationDefinition
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Questionnaire
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [FamilyMemberHistory] resource type. */
public object FamilyMemberHistorySearchParams {
  public val code: SearchParam<FamilyMemberHistory, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "FamilyMemberHistory.condition.code",
      extractor = { resource -> resource.condition.map { it.code } },
    )

  public val date: SearchParam<FamilyMemberHistory, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "FamilyMemberHistory.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val identifier: SearchParam<FamilyMemberHistory, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "FamilyMemberHistory.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<FamilyMemberHistory, Canonical> =
    SearchParam(
      name = "instantiates-canonical",
      type = SearchParamType.Reference,
      expression = "FamilyMemberHistory.instantiatesCanonical",
      target =
        listOf(
          Questionnaire::class,
          Measure::class,
          PlanDefinition::class,
          OperationDefinition::class,
          ActivityDefinition::class,
        ),
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val instantiatesUri: SearchParam<FamilyMemberHistory, Uri> =
    SearchParam(
      name = "instantiates-uri",
      type = SearchParamType.Uri,
      expression = "FamilyMemberHistory.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val patient: SearchParam<FamilyMemberHistory, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "FamilyMemberHistory.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val relationship: SearchParam<FamilyMemberHistory, CodeableConcept> =
    SearchParam(
      name = "relationship",
      type = SearchParamType.Token,
      expression = "FamilyMemberHistory.relationship",
      extractor = { resource -> listOf(resource.relationship) },
    )

  public val sex: SearchParam<FamilyMemberHistory, CodeableConcept> =
    SearchParam(
      name = "sex",
      type = SearchParamType.Token,
      expression = "FamilyMemberHistory.sex",
      extractor = { resource -> listOfNotNull(resource.sex) },
    )

  public val status: SearchParam<FamilyMemberHistory, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "FamilyMemberHistory.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<FamilyMemberHistory, *>> = listOf()

  /**
   * Supported search parameters for the FamilyMemberHistory resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<FamilyMemberHistory, *>> =
    listOf(
      code,
      date,
      identifier,
      instantiatesCanonical,
      instantiatesUri,
      patient,
      relationship,
      sex,
      status,
    )
}
