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
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationStatement] resource type. */
public object MedicationStatementSearchParams {
  public val adherence: SearchParam<MedicationStatement, CodeableConcept> =
    SearchParam(
      name = "adherence",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.adherence.code",
      extractor = { resource -> listOfNotNull(resource.adherence?.code) },
    )

  public val category: SearchParam<MedicationStatement, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<MedicationStatement, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationStatement.medication.concept",
      extractor = { resource -> listOfNotNull(resource.medication.concept) },
    )

  public val effective: SearchParam<MedicationStatement, Any> =
    SearchParam(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationStatement.effective.ofType(dateTime)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'effective' has expression 'MedicationStatement.effective.ofType(dateTime)' which is not yet supported."
        )
      },
    )

  public val encounter: SearchParam<MedicationStatement, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationStatement.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
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
      expression = "MedicationStatement.medication.reference",
      target = listOf(Medication::class),
      extractor = { resource -> listOfNotNull(resource.medication.reference) },
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
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.informationSource },
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
  public val unsupported: List<SearchParam<MedicationStatement, *>> = listOf(effective)

  /**
   * Supported search parameters for the MedicationStatement resource type. Entries in [unsupported]
   * are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<MedicationStatement, *>> =
    listOf(
      adherence,
      category,
      code,
      effective,
      encounter,
      identifier,
      medication,
      patient,
      source,
      status,
      subject,
    ) - unsupported.toSet()
}
