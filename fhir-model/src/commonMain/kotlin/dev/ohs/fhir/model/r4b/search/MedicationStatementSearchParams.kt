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
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.EpisodeOfCare
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.MedicationDispense
import dev.ohs.fhir.model.r4b.MedicationStatement
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationStatement] resource type. */
public object MedicationStatementSearchParams {
  public val Category: SearchParam<MedicationStatement, CodeableConcept> =
    SimpleSearchParam<MedicationStatement, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val Code: SearchParam<MedicationStatement, CodeableConcept> =
    SimpleSearchParam<MedicationStatement, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "(MedicationStatement.medication as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull(
          (resource.medication as? MedicationStatement.Medication.CodeableConcept)?.value
        )
      },
    )

  public val Context: SearchParam<MedicationStatement, Reference> =
    SimpleSearchParam<MedicationStatement, Reference>(
      name = "context",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.context",
      target = listOf(EpisodeOfCare::class, Encounter::class),
      extractor = { resource -> listOfNotNull(resource.context) },
    )

  public val Effective: SearchParam<MedicationStatement, MedicationStatement.Effective> =
    SimpleSearchParam<MedicationStatement, MedicationStatement.Effective>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationStatement.effective",
      extractor = { resource -> listOfNotNull(resource.effective) },
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
      expression = "(MedicationStatement.medication as Reference)",
      target = listOf(dev.ohs.fhir.model.r4b.Medication::class),
      extractor = { resource ->
        listOfNotNull((resource.medication as? MedicationStatement.Medication.Reference)?.value)
      },
    )

  public val PartOf: SearchParam<MedicationStatement, Reference> =
    SimpleSearchParam<MedicationStatement, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.partOf",
      target =
        listOf(
          MedicationDispense::class,
          Observation::class,
          MedicationAdministration::class,
          Procedure::class,
          MedicationStatement::class,
        ),
      extractor = { resource -> resource.partOf },
    )

  public val Patient: SearchParam<MedicationStatement, Reference> =
    SimpleSearchParam<MedicationStatement, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
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
          Practitioner::class,
          Organization::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.informationSource) },
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
      target = listOf(Group::class, dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the MedicationStatement resource type. */
  public val ALL: List<SearchParam<MedicationStatement, *>> =
    listOf(
      Category,
      Code,
      Context,
      Effective,
      Identifier,
      Medication,
      PartOf,
      Patient,
      Source,
      Status,
      Subject,
    )
}
