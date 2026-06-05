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
public object ClinicalUseDefinitionSearchParams {
  public val contraindication: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SearchParam(
      name = "contraindication",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure",
      extractor = { resource -> listOfNotNull(resource.contraindication?.diseaseSymptomProcedure) },
    )

  public val contraindicationReference: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SearchParam(
      name = "contraindication-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.contraindication.diseaseSymptomProcedure",
      extractor = { resource -> listOfNotNull(resource.contraindication?.diseaseSymptomProcedure) },
    )

  public val effect: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SearchParam(
      name = "effect",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect",
      extractor = { resource -> listOfNotNull(resource.undesirableEffect?.symptomConditionEffect) },
    )

  public val effectReference: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SearchParam(
      name = "effect-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.undesirableEffect.symptomConditionEffect",
      extractor = { resource -> listOfNotNull(resource.undesirableEffect?.symptomConditionEffect) },
    )

  public val identifier: SearchParam<ClinicalUseDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val indication: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SearchParam(
      name = "indication",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.indication.diseaseSymptomProcedure",
      extractor = { resource -> listOfNotNull(resource.indication?.diseaseSymptomProcedure) },
    )

  public val indicationReference: SearchParam<ClinicalUseDefinition, CodeableReference> =
    SearchParam(
      name = "indication-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ClinicalUseDefinition.indication.diseaseSymptomProcedure",
      extractor = { resource -> listOfNotNull(resource.indication?.diseaseSymptomProcedure) },
    )

  public val interaction: SearchParam<ClinicalUseDefinition, CodeableConcept> =
    SearchParam(
      name = "interaction",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.interaction.type",
      extractor = { resource -> listOfNotNull(resource.interaction?.type) },
    )

  public val product: SearchParam<ClinicalUseDefinition, Reference> =
    SearchParam(
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

  public val subject: SearchParam<ClinicalUseDefinition, Reference> =
    SearchParam(
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

  public val type: SearchParam<ClinicalUseDefinition, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "ClinicalUseDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ClinicalUseDefinition, *>> = listOf()

  /**
   * Supported search parameters for the ClinicalUseDefinition resource type. Entries in
   * [unsupported] are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
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
      subject,
      type,
    ) - unsupported.toSet()
}
