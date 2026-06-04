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
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationStatement] resource type. */
public object MedicationStatementSearchParams {
  public val Adherence: SearchParam<MedicationStatement, CodeableConcept> =
    SimpleSearchParam<MedicationStatement, CodeableConcept>(
      name = "adherence",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.adherence.code",
      extractor = { resource -> listOfNotNull(resource.adherence?.code) },
    )

  public val Category: SearchParam<MedicationStatement, CodeableConcept> =
    SimpleSearchParam<MedicationStatement, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.category",
      extractor = { resource -> resource.category },
    )

  public val Code: SearchParam<MedicationStatement, CodeableConcept> =
    SimpleSearchParam<MedicationStatement, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.medication.concept",
      extractor = { resource -> listOfNotNull(resource.medication.concept) },
    )

  public val Effective: SearchParam<MedicationStatement, Any> =
    SimpleSearchParam<MedicationStatement, Any>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationStatement.effective.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val Encounter: SearchParam<MedicationStatement, Reference> =
    SimpleSearchParam<MedicationStatement, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.encounter",
      target = listOf(dev.ohs.fhir.model.r5.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<MedicationStatement, Identifier> =
    SimpleSearchParam<MedicationStatement, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Medication: SearchParam<MedicationStatement, Reference> =
    SimpleSearchParam<MedicationStatement, Reference>(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.medication.reference",
      target = listOf(dev.ohs.fhir.model.r5.Medication::class),
      extractor = { resource -> listOfNotNull(resource.medication.reference) },
    )

  public val Patient: SearchParam<MedicationStatement, Reference> =
    SimpleSearchParam<MedicationStatement, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Source: SearchParam<MedicationStatement, Reference> =
    SimpleSearchParam<MedicationStatement, Reference>(
      name = "source",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.informationSource",
      target =
        listOf(
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.informationSource },
    )

  public val Status: SearchParam<MedicationStatement, Any> =
    SimpleSearchParam<MedicationStatement, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<MedicationStatement, Reference> =
    SimpleSearchParam<MedicationStatement, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the MedicationStatement resource type. */
  public val ALL: List<SearchParam<MedicationStatement, *>> =
    listOf(
      Adherence,
      Category,
      Code,
      Effective,
      Encounter,
      Identifier,
      Medication,
      Patient,
      Source,
      Status,
      Subject,
    )
}
