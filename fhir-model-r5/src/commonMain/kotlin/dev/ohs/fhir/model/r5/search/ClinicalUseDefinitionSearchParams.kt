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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

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
  public val contraindication: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SearchParam(
      name = "contraindication",
      type = SearchParamType.Token,
      expression = "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.concept",
      extractor = { resource ->
        listOfNotNull(resource.contraindication?.diseaseSymptomProcedure?.concept)
      },
    )

  public val contraindicationReference: SearchParam<ClinicalUseDefinition, Reference> =
    SearchParam(
      name = "contraindication-reference",
      type = SearchParamType.Reference,
      expression = "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.reference",
      target = listOf(ObservationDefinition::class),
      extractor = { resource ->
        listOfNotNull(resource.contraindication?.diseaseSymptomProcedure?.reference)
      },
    )

  public val effect: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SearchParam(
      name = "effect",
      type = SearchParamType.Token,
      expression = "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.concept",
      extractor = { resource ->
        listOfNotNull(resource.undesirableEffect?.symptomConditionEffect?.concept)
      },
    )

  public val effectReference: SearchParam<ClinicalUseDefinition, Reference> =
    SearchParam(
      name = "effect-reference",
      type = SearchParamType.Reference,
      expression = "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.reference",
      target = listOf(ObservationDefinition::class),
      extractor = { resource ->
        listOfNotNull(resource.undesirableEffect?.symptomConditionEffect?.reference)
      },
    )

  public val identifier: SearchParam<ClinicalUseDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ClinicalUseDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val indication: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SearchParam(
      name = "indication",
      type = SearchParamType.Token,
      expression = "ClinicalUseDefinition.indication.diseaseSymptomProcedure.concept",
      extractor = { resource ->
        listOfNotNull(resource.indication?.diseaseSymptomProcedure?.concept)
      },
    )

  public val indicationReference: SearchParam<ClinicalUseDefinition, Reference> =
    SearchParam(
      name = "indication-reference",
      type = SearchParamType.Reference,
      expression = "ClinicalUseDefinition.indication.diseaseSymptomProcedure.reference",
      target = listOf(ObservationDefinition::class),
      extractor = { resource ->
        listOfNotNull(resource.indication?.diseaseSymptomProcedure?.reference)
      },
    )

  public val interaction: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SearchParam(
      name = "interaction",
      type = SearchParamType.Token,
      expression = "ClinicalUseDefinition.interaction.type",
      extractor = { resource -> listOfNotNull(resource.interaction?.type) },
    )

  public val product: SearchParam<ClinicalUseDefinition, Reference> =
    SearchParam(
      name = "product",
      type = SearchParamType.Reference,
      expression = "ClinicalUseDefinition.subject.where(resolve() is MedicinalProductDefinition)",
      target = listOf(MedicinalProductDefinition::class),
      extractor = { resource ->
        resource.subject.filter {
          it.reference?.value?.toString()?.contains("MedicinalProductDefinition/") == true
        }
      },
    )

  public val status: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ClinicalUseDefinition.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val subject: SearchParam<ClinicalUseDefinition, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
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

  public val type: SearchParam<ClinicalUseDefinition, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "ClinicalUseDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ClinicalUseDefinition, *>> = listOf()

  /**
   * Supported search parameters for the ClinicalUseDefinition resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<ClinicalUseDefinition, *>> =
    listOf(
      contraindication,
      contraindicationReference,
      effect,
      effectReference,
      identifier,
      indication,
      indicationReference,
      interaction,
      product,
      status,
      subject,
      type,
    )
}
