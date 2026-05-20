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

import dev.ohs.fhir.model.r4b.ClinicalUseDefinition
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CodeableReference
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClinicalUseDefinition] resource type. */
public sealed class ClinicalUseDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ClinicalUseDefinition): List<T>

  public data object Contraindication : ClinicalUseDefinitionSearchParam<CodeableReference>() {
    public override val paramName: String = "contraindication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.contraindication?.diseaseSymptomProcedure)
  }

  public data object ContraindicationReference :
    ClinicalUseDefinitionSearchParam<CodeableReference>() {
    public override val paramName: String = "contraindication-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.contraindication?.diseaseSymptomProcedure)
  }

  public data object Effect : ClinicalUseDefinitionSearchParam<CodeableReference>() {
    public override val paramName: String = "effect"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.undesirableEffect?.symptomConditionEffect)
  }

  public data object EffectReference : ClinicalUseDefinitionSearchParam<CodeableReference>() {
    public override val paramName: String = "effect-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.undesirableEffect?.symptomConditionEffect)
  }

  public data object Identifier :
    ClinicalUseDefinitionSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ClinicalUseDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Indication : ClinicalUseDefinitionSearchParam<CodeableReference>() {
    public override val paramName: String = "indication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.indication.diseaseSymptomProcedure"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.indication?.diseaseSymptomProcedure)
  }

  public data object IndicationReference : ClinicalUseDefinitionSearchParam<CodeableReference>() {
    public override val paramName: String = "indication-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.indication.diseaseSymptomProcedure"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.indication?.diseaseSymptomProcedure)
  }

  public data object Interaction : ClinicalUseDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: String = "interaction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.interaction.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableConcept> =
      listOfNotNull(resource.interaction?.type)
  }

  public data object Product : ClinicalUseDefinitionSearchParam<Reference>() {
    public override val paramName: String = "product"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.subject.where(resolve() is MedicinalProductDefinition)"

    public override val target: List<String> = listOf("MedicinalProductDefinition")

    public override fun extract(resource: ClinicalUseDefinition): List<Reference> =
      resource.subject.filter {
        it.reference?.value?.toString()?.contains("MedicinalProductDefinition/") == true
      }
  }

  public data object Subject : ClinicalUseDefinitionSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalUseDefinition.subject"

    public override val target: List<String> =
      listOf(
        "MedicinalProductDefinition",
        "Device",
        "Medication",
        "DeviceDefinition",
        "PlanDefinition",
        "Substance",
        "ActivityDefinition",
      )

    public override fun extract(resource: ClinicalUseDefinition): List<Reference> = resource.subject
  }

  public data object Type : ClinicalUseDefinitionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = listOf(resource.type)
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
        Subject,
        Type,
      )
  }
}
