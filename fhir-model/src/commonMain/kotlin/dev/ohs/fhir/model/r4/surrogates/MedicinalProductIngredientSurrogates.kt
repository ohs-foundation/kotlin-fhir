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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4.surrogates

import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.MedicinalProductIngredient
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Ratio
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MedicinalProductIngredientSpecifiedSubstanceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var group: CodeableConcept,
  public var confidentiality: CodeableConcept? = null,
  public var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null,
) {
  public fun toModel(): MedicinalProductIngredient.SpecifiedSubstance =
    MedicinalProductIngredient.SpecifiedSubstance(
      id = this@MedicinalProductIngredientSpecifiedSubstanceSurrogate.id,
      extension = this@MedicinalProductIngredientSpecifiedSubstanceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductIngredientSpecifiedSubstanceSurrogate.modifierExtension ?: listOf(),
      code = this@MedicinalProductIngredientSpecifiedSubstanceSurrogate.code,
      group = this@MedicinalProductIngredientSpecifiedSubstanceSurrogate.group,
      confidentiality = this@MedicinalProductIngredientSpecifiedSubstanceSurrogate.confidentiality,
      strength = this@MedicinalProductIngredientSpecifiedSubstanceSurrogate.strength ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductIngredient.SpecifiedSubstance
    ): MedicinalProductIngredientSpecifiedSubstanceSurrogate =
      with(model) {
        MedicinalProductIngredientSpecifiedSubstanceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          group = this@with.group,
          confidentiality = this@with.confidentiality,
          strength = this@with.strength.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var presentation: Ratio,
  public var presentationLowLimit: Ratio? = null,
  public var concentration: Ratio? = null,
  public var concentrationLowLimit: Ratio? = null,
  public var measurementPoint: KotlinString? = null,
  public var _measurementPoint: Element? = null,
  public var country: List<CodeableConcept>? = null,
  public var referenceStrength:
    List<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength>? =
    null,
) {
  public fun toModel(): MedicinalProductIngredient.SpecifiedSubstance.Strength =
    MedicinalProductIngredient.SpecifiedSubstance.Strength(
      id = this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.id,
      extension =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.modifierExtension
          ?: listOf(),
      presentation =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.presentation,
      presentationLowLimit =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.presentationLowLimit,
      concentration =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.concentration,
      concentrationLowLimit =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.concentrationLowLimit,
      measurementPoint =
        R4String.of(
          this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.measurementPoint,
          this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate._measurementPoint,
        ),
      country =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.country ?: listOf(),
      referenceStrength =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.referenceStrength
          ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductIngredient.SpecifiedSubstance.Strength
    ): MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate =
      with(model) {
        MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          presentation = this@with.presentation,
          presentationLowLimit = this@with.presentationLowLimit,
          concentration = this@with.concentration,
          concentrationLowLimit = this@with.concentrationLowLimit,
          measurementPoint = this@with.measurementPoint?.value,
          _measurementPoint = this@with.measurementPoint?.toElement(),
          country = this@with.country.takeIf { it.isNotEmpty() },
          referenceStrength = this@with.referenceStrength.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var substance: CodeableConcept? = null,
  public var strength: Ratio,
  public var strengthLowLimit: Ratio? = null,
  public var measurementPoint: KotlinString? = null,
  public var _measurementPoint: Element? = null,
  public var country: List<CodeableConcept>? = null,
) {
  public fun toModel(): MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength =
    MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength(
      id = this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate.id,
      extension =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
          .extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
          .modifierExtension ?: listOf(),
      substance =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
          .substance,
      strength =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
          .strength,
      strengthLowLimit =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
          .strengthLowLimit,
      measurementPoint =
        R4String.of(
          this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
            .measurementPoint,
          this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
            ._measurementPoint,
        ),
      country =
        this@MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate.country
          ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength
    ): MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate =
      with(model) {
        MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          substance = this@with.substance,
          strength = this@with.strength,
          strengthLowLimit = this@with.strengthLowLimit,
          measurementPoint = this@with.measurementPoint?.value,
          _measurementPoint = this@with.measurementPoint?.toElement(),
          country = this@with.country.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicinalProductIngredientSubstanceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null,
) {
  public fun toModel(): MedicinalProductIngredient.Substance =
    MedicinalProductIngredient.Substance(
      id = this@MedicinalProductIngredientSubstanceSurrogate.id,
      extension = this@MedicinalProductIngredientSubstanceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductIngredientSubstanceSurrogate.modifierExtension ?: listOf(),
      code = this@MedicinalProductIngredientSubstanceSurrogate.code,
      strength = this@MedicinalProductIngredientSubstanceSurrogate.strength ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductIngredient.Substance
    ): MedicinalProductIngredientSubstanceSurrogate =
      with(model) {
        MedicinalProductIngredientSubstanceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          strength = this@with.strength.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicinalProductIngredientSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var role: CodeableConcept,
  public var allergenicIndicator: KotlinBoolean? = null,
  public var _allergenicIndicator: Element? = null,
  public var manufacturer: List<Reference>? = null,
  public var specifiedSubstance: List<MedicinalProductIngredient.SpecifiedSubstance>? = null,
  public var substance: MedicinalProductIngredient.Substance? = null,
) {
  public fun toModel(): MedicinalProductIngredient =
    MedicinalProductIngredient(
      id = this@MedicinalProductIngredientSurrogate.id,
      meta = this@MedicinalProductIngredientSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicinalProductIngredientSurrogate.implicitRules,
          this@MedicinalProductIngredientSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicinalProductIngredientSurrogate.language,
          this@MedicinalProductIngredientSurrogate._language,
        ),
      text = this@MedicinalProductIngredientSurrogate.text,
      contained = this@MedicinalProductIngredientSurrogate.contained ?: listOf(),
      extension = this@MedicinalProductIngredientSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicinalProductIngredientSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicinalProductIngredientSurrogate.identifier,
      role = this@MedicinalProductIngredientSurrogate.role,
      allergenicIndicator =
        R4Boolean.of(
          this@MedicinalProductIngredientSurrogate.allergenicIndicator,
          this@MedicinalProductIngredientSurrogate._allergenicIndicator,
        ),
      manufacturer = this@MedicinalProductIngredientSurrogate.manufacturer ?: listOf(),
      specifiedSubstance = this@MedicinalProductIngredientSurrogate.specifiedSubstance ?: listOf(),
      substance = this@MedicinalProductIngredientSurrogate.substance,
    )

  public companion object {
    public fun fromModel(model: MedicinalProductIngredient): MedicinalProductIngredientSurrogate =
      with(model) {
        MedicinalProductIngredientSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier,
          role = this@with.role,
          allergenicIndicator = this@with.allergenicIndicator?.value,
          _allergenicIndicator = this@with.allergenicIndicator?.toElement(),
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          specifiedSubstance = this@with.specifiedSubstance.takeIf { it.isNotEmpty() },
          substance = this@with.substance,
        )
      }
  }
}
