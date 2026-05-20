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

import dev.ohs.fhir.model.r5.ClinicalUseDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClinicalUseDefinition] resource type. */
public object ClinicalUseDefinitionSearchParam {
  /** All search parameters for the ClinicalUseDefinition resource type. */
  public val ALL: List<SearchParam<ClinicalUseDefinition, *>> =
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

  public data object Contraindication : SearchParam<ClinicalUseDefinition, CodeableConcept> {
    public override val paramName: String = "contraindication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableConcept> =
      listOfNotNull(resource.contraindication?.diseaseSymptomProcedure?.concept)
  }

  public data object ContraindicationReference : SearchParam<ClinicalUseDefinition, Reference> {
    public override val paramName: String = "contraindication-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.reference"

    public override val target: List<String> = listOf("ObservationDefinition")

    public override fun extract(resource: ClinicalUseDefinition): List<Reference> =
      listOfNotNull(resource.contraindication?.diseaseSymptomProcedure?.reference)
  }

  public data object Effect : SearchParam<ClinicalUseDefinition, CodeableConcept> {
    public override val paramName: String = "effect"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableConcept> =
      listOfNotNull(resource.undesirableEffect?.symptomConditionEffect?.concept)
  }

  public data object EffectReference : SearchParam<ClinicalUseDefinition, Reference> {
    public override val paramName: String = "effect-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.reference"

    public override val target: List<String> = listOf("ObservationDefinition")

    public override fun extract(resource: ClinicalUseDefinition): List<Reference> =
      listOfNotNull(resource.undesirableEffect?.symptomConditionEffect?.reference)
  }

  public data object Identifier :
    SearchParam<ClinicalUseDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ClinicalUseDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Indication : SearchParam<ClinicalUseDefinition, CodeableConcept> {
    public override val paramName: String = "indication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.indication.diseaseSymptomProcedure.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableConcept> =
      listOfNotNull(resource.indication?.diseaseSymptomProcedure?.concept)
  }

  public data object IndicationReference : SearchParam<ClinicalUseDefinition, Reference> {
    public override val paramName: String = "indication-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.indication.diseaseSymptomProcedure.reference"

    public override val target: List<String> = listOf("ObservationDefinition")

    public override fun extract(resource: ClinicalUseDefinition): List<Reference> =
      listOfNotNull(resource.indication?.diseaseSymptomProcedure?.reference)
  }

  public data object Interaction : SearchParam<ClinicalUseDefinition, CodeableConcept> {
    public override val paramName: String = "interaction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.interaction.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableConcept> =
      listOfNotNull(resource.interaction?.type)
  }

  public data object Product : SearchParam<ClinicalUseDefinition, Reference> {
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

  public data object Status : SearchParam<ClinicalUseDefinition, CodeableConcept> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableConcept> =
      listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<ClinicalUseDefinition, Reference> {
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

    public override fun extract(resource: ClinicalUseDefinition): List<Reference> = resource.subject
  }

  public data object Type : SearchParam<ClinicalUseDefinition, Any> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = listOf(resource.type)
  }
}
