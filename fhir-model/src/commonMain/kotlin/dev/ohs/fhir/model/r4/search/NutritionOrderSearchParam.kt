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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.NutritionOrder
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionOrder] resource type. */
public object NutritionOrderSearchParam {
  /** All search parameters for the NutritionOrder resource type. */
  public val ALL: List<SearchParam<NutritionOrder, *>> =
    listOf(
      Additive,
      Datetime,
      Encounter,
      Formula,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Oraldiet,
      Patient,
      Provider,
      Status,
      Supplement,
    )

  public data object Additive : SearchParam<NutritionOrder, CodeableConcept> {
    public override val paramName: String = "additive"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.enteralFormula.additiveType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<CodeableConcept> =
      listOfNotNull(resource.enteralFormula?.additiveType)
  }

  public data object Datetime : SearchParam<NutritionOrder, DateTime> {
    public override val paramName: String = "datetime"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NutritionOrder.dateTime"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<DateTime> =
      listOf(resource.dateTime)
  }

  public data object Encounter : SearchParam<NutritionOrder, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionOrder.encounter"

    public override val target: List<String> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: NutritionOrder): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Formula : SearchParam<NutritionOrder, CodeableConcept> {
    public override val paramName: String = "formula"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.enteralFormula.baseFormulaType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<CodeableConcept> =
      listOfNotNull(resource.enteralFormula?.baseFormulaType)
  }

  public data object Identifier : SearchParam<NutritionOrder, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<NutritionOrder, Canonical> {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionOrder.instantiatesCanonical"

    public override val target: List<String> = listOf("PlanDefinition", "ActivityDefinition")

    public override fun extract(resource: NutritionOrder): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : SearchParam<NutritionOrder, Uri> {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "NutritionOrder.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Uri> = resource.instantiatesUri
  }

  public data object Oraldiet : SearchParam<NutritionOrder, CodeableConcept> {
    public override val paramName: String = "oraldiet"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.oralDiet.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<CodeableConcept> =
      resource.oralDiet?.type ?: emptyList()
  }

  public data object Patient : SearchParam<NutritionOrder, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionOrder.patient"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: NutritionOrder): List<Reference> =
      listOf(resource.patient)
  }

  public data object Provider : SearchParam<NutritionOrder, Reference> {
    public override val paramName: String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionOrder.orderer"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: NutritionOrder): List<Reference> =
      listOfNotNull(resource.orderer)
  }

  public data object Status : SearchParam<NutritionOrder, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<Any> = listOf(resource.status)
  }

  public data object Supplement : SearchParam<NutritionOrder, CodeableConcept> {
    public override val paramName: String = "supplement"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionOrder.supplement.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NutritionOrder): List<CodeableConcept> =
      resource.supplement.mapNotNull { it.type }
  }
}
