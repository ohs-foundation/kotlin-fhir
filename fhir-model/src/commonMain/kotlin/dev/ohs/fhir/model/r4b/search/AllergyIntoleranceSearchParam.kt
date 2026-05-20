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

import dev.ohs.fhir.model.r4b.AllergyIntolerance
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AllergyIntolerance] resource type. */
public sealed class AllergyIntoleranceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: AllergyIntolerance): List<T>

  public data object Asserter : AllergyIntoleranceSearchParam<Reference>() {
    public override val paramName: String = "asserter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.asserter"

    public override val target: List<String> =
      listOf("Practitioner", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: AllergyIntolerance): List<Reference> =
      listOfNotNull(resource.asserter)
  }

  public data object Category : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = resource.category
  }

  public data object ClinicalStatus : AllergyIntoleranceSearchParam<CodeableConcept>() {
    public override val paramName: String = "clinical-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.clinicalStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      listOfNotNull(resource.clinicalStatus)
  }

  public data object Code : AllergyIntoleranceSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Criticality : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "criticality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.criticality"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> =
      listOfNotNull(resource.criticality)
  }

  public data object Date : AllergyIntoleranceSearchParam<DateTime>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AllergyIntolerance.recordedDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<DateTime> =
      listOfNotNull(resource.recordedDate)
  }

  public data object Identifier :
    AllergyIntoleranceSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: AllergyIntolerance
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object LastDate : AllergyIntoleranceSearchParam<DateTime>() {
    public override val paramName: String = "last-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AllergyIntolerance.lastOccurrence"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<DateTime> =
      listOfNotNull(resource.lastOccurrence)
  }

  public data object Manifestation : AllergyIntoleranceSearchParam<CodeableConcept>() {
    public override val paramName: String = "manifestation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.manifestation"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      resource.reaction.flatMap { it.manifestation }
  }

  public data object Onset : AllergyIntoleranceSearchParam<DateTime>() {
    public override val paramName: String = "onset"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AllergyIntolerance.reaction.onset"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<DateTime> =
      resource.reaction.mapNotNull { it.onset }
  }

  public data object Patient : AllergyIntoleranceSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: AllergyIntolerance): List<Reference> =
      listOf(resource.patient)
  }

  public data object Recorder : AllergyIntoleranceSearchParam<Reference>() {
    public override val paramName: String = "recorder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.recorder"

    public override val target: List<String> =
      listOf("Practitioner", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: AllergyIntolerance): List<Reference> =
      listOfNotNull(resource.recorder)
  }

  public data object Route : AllergyIntoleranceSearchParam<CodeableConcept>() {
    public override val paramName: String = "route"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.exposureRoute"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      resource.reaction.mapNotNull { it.exposureRoute }
  }

  public data object Severity : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.severity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> =
      resource.reaction.mapNotNull { it.severity }
  }

  public data object Type : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> =
      listOfNotNull(resource.type)
  }

  public data object VerificationStatus : AllergyIntoleranceSearchParam<CodeableConcept>() {
    public override val paramName: String = "verification-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.verificationStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      listOfNotNull(resource.verificationStatus)
  }

  public companion object {
    /** All search parameters for the AllergyIntolerance resource type. */
    public val ALL: List<AllergyIntoleranceSearchParam<*>> =
      listOf(
        Asserter,
        Category,
        ClinicalStatus,
        Code,
        Criticality,
        Date,
        Identifier,
        LastDate,
        Manifestation,
        Onset,
        Patient,
        Recorder,
        Route,
        Severity,
        Type,
        VerificationStatus,
      )
  }
}
