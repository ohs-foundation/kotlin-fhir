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

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.ClinicalUseDefinition
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CodeableReference
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DeviceDefinition
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

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
      Subject,
      Type,
    )

  public data object Contraindication : SearchParam<ClinicalUseDefinition, CodeableReference> {
    public override val name: String = "contraindication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.contraindication?.diseaseSymptomProcedure)
  }

  public data object ContraindicationReference :
    SearchParam<ClinicalUseDefinition, CodeableReference> {
    public override val name: String = "contraindication-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.contraindication?.diseaseSymptomProcedure)
  }

  public data object Effect : SearchParam<ClinicalUseDefinition, CodeableReference> {
    public override val name: String = "effect"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.undesirableEffect?.symptomConditionEffect)
  }

  public data object EffectReference : SearchParam<ClinicalUseDefinition, CodeableReference> {
    public override val name: String = "effect-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.undesirableEffect?.symptomConditionEffect)
  }

  public data object Identifier :
    SearchParam<ClinicalUseDefinition, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: ClinicalUseDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Indication : SearchParam<ClinicalUseDefinition, CodeableReference> {
    public override val name: String = "indication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "ClinicalUseDefinition.indication.diseaseSymptomProcedure"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.indication?.diseaseSymptomProcedure)
  }

  public data object IndicationReference : SearchParam<ClinicalUseDefinition, CodeableReference> {
    public override val name: String = "indication-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.indication.diseaseSymptomProcedure"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableReference> =
      listOfNotNull(resource.indication?.diseaseSymptomProcedure)
  }

  public data object Interaction : SearchParam<ClinicalUseDefinition, CodeableConcept> {
    public override val name: String = "interaction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.interaction.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<CodeableConcept> =
      listOfNotNull(resource.interaction?.type)
  }

  public data object Product : SearchParam<ClinicalUseDefinition, Reference> {
    public override val name: String = "product"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "ClinicalUseDefinition.subject.where(resolve() is MedicinalProductDefinition)"

    public override val target: List<KClass<out Resource>> =
      listOf(MedicinalProductDefinition::class)

    public override fun extract(resource: ClinicalUseDefinition): List<Reference> =
      resource.subject.filter {
        it.reference?.value?.toString()?.contains("MedicinalProductDefinition/") == true
      }
  }

  public data object Subject : SearchParam<ClinicalUseDefinition, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClinicalUseDefinition.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        MedicinalProductDefinition::class,
        Device::class,
        Medication::class,
        DeviceDefinition::class,
        PlanDefinition::class,
        Substance::class,
        ActivityDefinition::class,
      )

    public override fun extract(resource: ClinicalUseDefinition): List<Reference> = resource.subject
  }

  public data object Type : SearchParam<ClinicalUseDefinition, Any> {
    public override val name: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClinicalUseDefinition.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ClinicalUseDefinition): List<Any> = listOf(resource.type)
  }
}
