/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AllergyIntolerance] resource type. */
public sealed class AllergyIntoleranceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: AllergyIntolerance): List<T>

  public data object Category : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object ClinicalStatus : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "clinical-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.clinicalStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Code : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Criticality : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "criticality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.criticality"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Date : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AllergyIntolerance.recordedDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Identifier : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object LastDate : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "last-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AllergyIntolerance.lastOccurrence"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object ManifestationCode : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "manifestation-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.manifestation.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object ManifestationReference : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "manifestation-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.reaction.manifestation.reference"

    public override val target: List<String> = listOf("Observation")

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Participant : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.participant.actor"

    public override val target: List<String> =
      listOf(
        "Device",
        "Organization",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Patient : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Route : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "route"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.exposureRoute"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Severity : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.severity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object Type : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public data object VerificationStatus : AllergyIntoleranceSearchParam<Any>() {
    public override val paramName: String = "verification-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.verificationStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the AllergyIntolerance resource type. */
    public val ALL: List<AllergyIntoleranceSearchParam<*>> =
      listOf(
        Category,
        ClinicalStatus,
        Code,
        Criticality,
        Date,
        Identifier,
        LastDate,
        ManifestationCode,
        ManifestationReference,
        Participant,
        Patient,
        Route,
        Severity,
        Type,
        VerificationStatus,
      )
  }
}
