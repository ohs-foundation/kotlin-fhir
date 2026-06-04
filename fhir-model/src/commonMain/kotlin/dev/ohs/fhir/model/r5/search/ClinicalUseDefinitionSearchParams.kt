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

import dev.ohs.fhir.model.r5.ActivityDefinition
import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.ClinicalUseDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.ObservationDefinition
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClinicalUseDefinition] resource type. */
public object ClinicalUseDefinitionSearchParams {
  public val Contraindication: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableConcept>(
      name = "contraindication",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.concept",
      extractor = { resource ->
        listOfNotNull(resource.contraindication?.diseaseSymptomProcedure?.concept)
      },
    )

  public val ContraindicationReference: SearchParam<ClinicalUseDefinition, Reference> =
    SimpleSearchParam<ClinicalUseDefinition, Reference>(
      name = "contraindication-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.reference",
      target = listOf(ObservationDefinition::class),
      extractor = { resource ->
        listOfNotNull(resource.contraindication?.diseaseSymptomProcedure?.reference)
      },
    )

  public val Effect: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableConcept>(
      name = "effect",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.concept",
      extractor = { resource ->
        listOfNotNull(resource.undesirableEffect?.symptomConditionEffect?.concept)
      },
    )

  public val EffectReference: SearchParam<ClinicalUseDefinition, Reference> =
    SimpleSearchParam<ClinicalUseDefinition, Reference>(
      name = "effect-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.reference",
      target = listOf(ObservationDefinition::class),
      extractor = { resource ->
        listOfNotNull(resource.undesirableEffect?.symptomConditionEffect?.reference)
      },
    )

  public val Identifier: SearchParam<ClinicalUseDefinition, Identifier> =
    SimpleSearchParam<ClinicalUseDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Indication: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableConcept>(
      name = "indication",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.indication.diseaseSymptomProcedure.concept",
      extractor = { resource ->
        listOfNotNull(resource.indication?.diseaseSymptomProcedure?.concept)
      },
    )

  public val IndicationReference: SearchParam<ClinicalUseDefinition, Reference> =
    SimpleSearchParam<ClinicalUseDefinition, Reference>(
      name = "indication-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.indication.diseaseSymptomProcedure.reference",
      target = listOf(ObservationDefinition::class),
      extractor = { resource ->
        listOfNotNull(resource.indication?.diseaseSymptomProcedure?.reference)
      },
    )

  public val Interaction: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableConcept>(
      name = "interaction",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.interaction.type",
      extractor = { resource -> listOfNotNull(resource.interaction?.type) },
    )

  public val Product: SearchParam<ClinicalUseDefinition, Reference> =
    SimpleSearchParam<ClinicalUseDefinition, Reference>(
      name = "product",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.subject.where(resolve() is MedicinalProductDefinition)",
      target = listOf(MedicinalProductDefinition::class),
      extractor = { resource ->
        resource.subject.filter {
          it.reference?.value?.toString()?.contains("MedicinalProductDefinition/") == true
        }
      },
    )

  public val Status: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableConcept>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Subject: SearchParam<ClinicalUseDefinition, Reference> =
    SimpleSearchParam<ClinicalUseDefinition, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.subject",
      target =
        listOf(
          MedicinalProductDefinition::class,
          Device::class,
          DeviceDefinition::class,
          NutritionProduct::class,
          ActivityDefinition::class,
          PlanDefinition::class,
          BiologicallyDerivedProduct::class,
          Substance::class,
          Medication::class,
        ),
      extractor = { resource -> resource.subject },
    )

  public val Type: SearchParam<ClinicalUseDefinition, Any> =
    SimpleSearchParam<ClinicalUseDefinition, Any>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

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
}
