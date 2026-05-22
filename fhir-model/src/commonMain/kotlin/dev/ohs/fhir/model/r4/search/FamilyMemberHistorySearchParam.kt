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

import dev.ohs.fhir.model.r4.ActivityDefinition
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.FamilyMemberHistory
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Measure
import dev.ohs.fhir.model.r4.OperationDefinition
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Questionnaire
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [FamilyMemberHistory] resource type. */
public object FamilyMemberHistorySearchParam {
  public val Code: SearchParam<FamilyMemberHistory, CodeableConcept> =
    SimpleSearchParam<FamilyMemberHistory, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.condition.code",
      extractor = { resource -> resource.condition.map { it.code } },
    )

  public val Date: SearchParam<FamilyMemberHistory, DateTime> =
    SimpleSearchParam<FamilyMemberHistory, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "FamilyMemberHistory.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Identifier: SearchParam<FamilyMemberHistory, Identifier> =
    SimpleSearchParam<FamilyMemberHistory, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val InstantiatesCanonical: SearchParam<FamilyMemberHistory, Canonical> =
    SimpleSearchParam<FamilyMemberHistory, Canonical>(
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

  public val InstantiatesUri: SearchParam<FamilyMemberHistory, Uri> =
    SimpleSearchParam<FamilyMemberHistory, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "FamilyMemberHistory.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val Patient: SearchParam<FamilyMemberHistory, Reference> =
    SimpleSearchParam<FamilyMemberHistory, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "FamilyMemberHistory.patient",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Relationship: SearchParam<FamilyMemberHistory, CodeableConcept> =
    SimpleSearchParam<FamilyMemberHistory, CodeableConcept>(
      name = "relationship",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.relationship",
      extractor = { resource -> listOf(resource.relationship) },
    )

  public val Sex: SearchParam<FamilyMemberHistory, CodeableConcept> =
    SimpleSearchParam<FamilyMemberHistory, CodeableConcept>(
      name = "sex",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.sex",
      extractor = { resource -> listOfNotNull(resource.sex) },
    )

  public val Status: SearchParam<FamilyMemberHistory, Any> =
    SimpleSearchParam<FamilyMemberHistory, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "FamilyMemberHistory.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the FamilyMemberHistory resource type. */
  public val ALL: List<SearchParam<FamilyMemberHistory, *>> =
    listOf(
      Code,
      Date,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Patient,
      Relationship,
      Sex,
      Status,
    )
}
