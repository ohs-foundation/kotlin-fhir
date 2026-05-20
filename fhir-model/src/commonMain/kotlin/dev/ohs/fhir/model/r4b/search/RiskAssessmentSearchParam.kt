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
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RiskAssessment
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RiskAssessment] resource type. */
public object RiskAssessmentSearchParam {
  /** All search parameters for the RiskAssessment resource type. */
  public val ALL: List<SearchParam<RiskAssessment, *>> =
    listOf(
      Condition,
      Date,
      Encounter,
      Identifier,
      Method,
      Patient,
      Performer,
      Probability,
      Risk,
      Subject,
    )

  public data object Condition : SearchParam<RiskAssessment, Reference> {
    public override val paramName: String = "condition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RiskAssessment.condition"

    public override val target: List<String> = listOf("Condition")

    public override fun extract(resource: RiskAssessment): List<Reference> =
      listOfNotNull(resource.condition)
  }

  public data object Date : SearchParam<RiskAssessment, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(RiskAssessment.occurrence as dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskAssessment): List<DateTime> =
      listOfNotNull((resource.occurrence as? RiskAssessment.Occurrence.DateTime)?.value)
  }

  public data object Encounter : SearchParam<RiskAssessment, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RiskAssessment.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: RiskAssessment): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<RiskAssessment, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RiskAssessment.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskAssessment): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Method : SearchParam<RiskAssessment, CodeableConcept> {
    public override val paramName: String = "method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RiskAssessment.method"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskAssessment): List<CodeableConcept> =
      listOfNotNull(resource.method)
  }

  public data object Patient : SearchParam<RiskAssessment, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RiskAssessment.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: RiskAssessment): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<RiskAssessment, Reference> {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RiskAssessment.performer"

    public override val target: List<String> = listOf("Practitioner", "Device", "PractitionerRole")

    public override fun extract(resource: RiskAssessment): List<Reference> =
      listOfNotNull(resource.performer)
  }

  public data object Probability :
    SearchParam<RiskAssessment, RiskAssessment.Prediction.Probability> {
    public override val paramName: String = "probability"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "RiskAssessment.prediction.probability"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: RiskAssessment
    ): List<RiskAssessment.Prediction.Probability> =
      resource.prediction.mapNotNull { it.probability }
  }

  public data object Risk : SearchParam<RiskAssessment, CodeableConcept> {
    public override val paramName: String = "risk"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RiskAssessment.prediction.qualitativeRisk"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskAssessment): List<CodeableConcept> =
      resource.prediction.mapNotNull { it.qualitativeRisk }
  }

  public data object Subject : SearchParam<RiskAssessment, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RiskAssessment.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: RiskAssessment): List<Reference> =
      listOf(resource.subject)
  }
}
