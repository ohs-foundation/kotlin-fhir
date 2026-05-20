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
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationStatement] resource type. */
public sealed class MedicationStatementSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicationStatement): List<T>

  public data object Adherence : MedicationStatementSearchParam<CodeableConcept>() {
    public override val paramName: String = "adherence"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationStatement.adherence.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationStatement): List<CodeableConcept> =
      listOfNotNull(resource.adherence?.code)
  }

  public data object Category : MedicationStatementSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationStatement.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationStatement): List<CodeableConcept> =
      resource.category
  }

  public data object Code : MedicationStatementSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationStatement.medication.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationStatement): List<CodeableConcept> =
      listOfNotNull(resource.medication.concept)
  }

  public data object Effective : MedicationStatementSearchParam<Any>() {
    public override val paramName: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationStatement.effective.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationStatement): List<Any> = emptyList()
  }

  public data object Encounter : MedicationStatementSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationStatement.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier :
    MedicationStatementSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationStatement.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: MedicationStatement
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Medication : MedicationStatementSearchParam<Reference>() {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationStatement.medication.reference"

    public override val target: List<String> = listOf("Medication")

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOfNotNull(resource.medication.reference)
  }

  public data object Patient : MedicationStatementSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationStatement.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Source : MedicationStatementSearchParam<Reference>() {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationStatement.informationSource"

    public override val target: List<String> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: MedicationStatement): List<Reference> =
      resource.informationSource
  }

  public data object Status : MedicationStatementSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationStatement.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationStatement): List<Any> = listOf(resource.status)
  }

  public data object Subject : MedicationStatementSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationStatement.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the MedicationStatement resource type. */
    public val ALL: List<MedicationStatementSearchParam<*>> =
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
}
