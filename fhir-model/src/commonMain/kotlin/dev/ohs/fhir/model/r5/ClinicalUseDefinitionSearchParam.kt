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

/** Search parameters for the [ClinicalUseDefinition] resource type. */
public sealed class ClinicalUseDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ClinicalUseDefinition): List<T>

  public data object Contraindication : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "contraindication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object ContraindicationReference : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "contraindication-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.reference"

    public override val target: List<String> = listOf("ObservationDefinition")

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object Effect : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "effect"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object EffectReference : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "effect-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.reference"

    public override val target: List<String> = listOf("ObservationDefinition")

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object Identifier : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object Indication : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "indication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.indication.diseaseSymptomProcedure.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object IndicationReference : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "indication-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.indication.diseaseSymptomProcedure.reference"

    public override val target: List<String> = listOf("ObservationDefinition")

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object Interaction : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "interaction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.interaction.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object Product : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "product"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.subject.where(resolve() is MedicinalProductDefinition)"

    public override val target: List<String> = listOf("MedicinalProductDefinition")

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object Status : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object Subject : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalUseDefinition.subject"

    public override val target: List<String> =
      listOf(
        "MedicinalProductDefinition",
        "Device",
        "DeviceDefinition",
        "NutritionProduct",
        "ActivityDefinition",
        "PlanDefinition",
        "BiologicallyDerivedProduct",
        "Substance",
        "Medication",
      )

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public data object Type : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ClinicalUseDefinition resource type. */
    public val ALL: List<ClinicalUseDefinitionSearchParam<*>> =
      listOf(
        Contraindication,
        ContraindicationReference,
        Effect,
        EffectReference,
        Identifier,
        Indication,
        IndicationReference,
        Interaction,
        Product,
        Status,
        Subject,
        Type,
      )
  }
}
