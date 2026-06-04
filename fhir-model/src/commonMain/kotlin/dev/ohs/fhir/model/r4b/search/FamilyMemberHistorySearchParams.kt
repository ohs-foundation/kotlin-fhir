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
    SearchParam<FamilyMemberHistory, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.condition.code",
      extractor = { resource -> resource.condition.map { it.code } },
    )

  public val date: SearchParam<FamilyMemberHistory, DateTime> =
    SearchParam<FamilyMemberHistory, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "FamilyMemberHistory.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val identifier: SearchParam<FamilyMemberHistory, Identifier> =
    SearchParam<FamilyMemberHistory, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<FamilyMemberHistory, Canonical> =
    SearchParam<FamilyMemberHistory, Canonical>(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
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
    SearchParam<FamilyMemberHistory, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "FamilyMemberHistory.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val patient: SearchParam<FamilyMemberHistory, Reference> =
    SearchParam<FamilyMemberHistory, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "FamilyMemberHistory.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val relationship: SearchParam<FamilyMemberHistory, CodeableConcept> =
    SearchParam<FamilyMemberHistory, CodeableConcept>(
      name = "relationship",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.relationship",
      extractor = { resource -> listOf(resource.relationship) },
    )

  public val sex: SearchParam<FamilyMemberHistory, CodeableConcept> =
    SearchParam<FamilyMemberHistory, CodeableConcept>(
      name = "sex",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.sex",
      extractor = { resource -> listOfNotNull(resource.sex) },
    )

  public val status: SearchParam<FamilyMemberHistory, Any> =
    SearchParam<FamilyMemberHistory, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the FamilyMemberHistory resource type. */
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
