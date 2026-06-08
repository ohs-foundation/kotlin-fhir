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
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.MedicationDispense
import dev.ohs.fhir.model.r4b.MedicationStatement
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
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
  public val category: SearchParam<MedicationStatement, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val code: SearchParam<MedicationStatement, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "(MedicationStatement.medication as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull(
          (resource.medication as? MedicationStatement.Medication.CodeableConcept)?.value
        )
      },
    )

  public val context: SearchParam<MedicationStatement, Reference> =
    SearchParam(
      name = "context",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.context",
      target = listOf(EpisodeOfCare::class, Encounter::class),
      extractor = { resource -> listOfNotNull(resource.context) },
    )

  public val effective: SearchParam<MedicationStatement, MedicationStatement.Effective> =
    SearchParam(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationStatement.effective",
      extractor = { resource -> listOfNotNull(resource.effective) },
    )

  public val identifier: SearchParam<MedicationStatement, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val medication: SearchParam<MedicationStatement, Reference> =
    SearchParam(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "(MedicationStatement.medication as Reference)",
      target = listOf(Medication::class),
      extractor = { resource ->
        listOfNotNull((resource.medication as? MedicationStatement.Medication.Reference)?.value)
      },
    )

  public val partOf: SearchParam<MedicationStatement, Reference> =
    SearchParam(
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

  public val patient: SearchParam<MedicationStatement, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val source: SearchParam<MedicationStatement, Reference> =
    SearchParam(
      name = "source",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.informationSource",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.informationSource) },
    )

  public val status: SearchParam<MedicationStatement, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<MedicationStatement, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<MedicationStatement, *>> = listOf()

  /**
   * Supported search parameters for the MedicationStatement resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<MedicationStatement, *>> =
    listOf(
      category,
      code,
      context,
      effective,
      identifier,
      medication,
      partOf,
      patient,
      source,
      status,
      subject,
    )
}
