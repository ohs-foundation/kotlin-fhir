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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClinicalUseDefinition] resource type. */
public object ClinicalUseDefinitionSearchParam {
  public val Contraindication: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableReference>(
      name = "contraindication",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure",
      extractor = { resource -> listOfNotNull(resource.contraindication?.diseaseSymptomProcedure) },
    )

  public val ContraindicationReference: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableReference>(
      name = "contraindication-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure",
      extractor = { resource -> listOfNotNull(resource.contraindication?.diseaseSymptomProcedure) },
    )

  public val Effect: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableReference>(
      name = "effect",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect",
      extractor = { resource -> listOfNotNull(resource.undesirableEffect?.symptomConditionEffect) },
    )

  public val EffectReference: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableReference>(
      name = "effect-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect",
      extractor = { resource -> listOfNotNull(resource.undesirableEffect?.symptomConditionEffect) },
    )

  public val Identifier: SearchParam<ClinicalUseDefinition, Identifier> =
    SimpleSearchParam<ClinicalUseDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Indication: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableReference>(
      name = "indication",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.indication.diseaseSymptomProcedure",
      extractor = { resource -> listOfNotNull(resource.indication?.diseaseSymptomProcedure) },
    )

  public val IndicationReference: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SimpleSearchParam<ClinicalUseDefinition, CodeableReference>(
      name = "indication-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.indication.diseaseSymptomProcedure",
      extractor = { resource -> listOfNotNull(resource.indication?.diseaseSymptomProcedure) },
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

  public val Subject: SearchParam<ClinicalUseDefinition, Reference> =
    SimpleSearchParam<ClinicalUseDefinition, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.subject",
      target =
        listOf(
          MedicinalProductDefinition::class,
          Device::class,
          Medication::class,
          DeviceDefinition::class,
          PlanDefinition::class,
          Substance::class,
          ActivityDefinition::class,
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
      Subject,
      Type,
    )
}
