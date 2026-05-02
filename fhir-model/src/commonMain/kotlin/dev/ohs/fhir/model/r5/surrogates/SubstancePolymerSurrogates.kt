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

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.SubstancePolymer
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubstancePolymerMonomerSetSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var ratioType: CodeableConcept? = null,
  public var startingMaterial: List<SubstancePolymer.MonomerSet.StartingMaterial>? = null,
) {
  public fun toModel(): SubstancePolymer.MonomerSet =
    SubstancePolymer.MonomerSet(
      id = this@SubstancePolymerMonomerSetSurrogate.id,
      extension = this@SubstancePolymerMonomerSetSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstancePolymerMonomerSetSurrogate.modifierExtension ?: listOf(),
      ratioType = this@SubstancePolymerMonomerSetSurrogate.ratioType,
      startingMaterial = this@SubstancePolymerMonomerSetSurrogate.startingMaterial ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstancePolymer.MonomerSet): SubstancePolymerMonomerSetSurrogate =
      with(model) {
        SubstancePolymerMonomerSetSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          ratioType = this@with.ratioType,
          startingMaterial = this@with.startingMaterial.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstancePolymerMonomerSetStartingMaterialSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var category: CodeableConcept? = null,
  public var isDefining: KotlinBoolean? = null,
  public var _isDefining: Element? = null,
  public var amount: Quantity? = null,
) {
  public fun toModel(): SubstancePolymer.MonomerSet.StartingMaterial =
    SubstancePolymer.MonomerSet.StartingMaterial(
      id = this@SubstancePolymerMonomerSetStartingMaterialSurrogate.id,
      extension = this@SubstancePolymerMonomerSetStartingMaterialSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstancePolymerMonomerSetStartingMaterialSurrogate.modifierExtension ?: listOf(),
      code = this@SubstancePolymerMonomerSetStartingMaterialSurrogate.code,
      category = this@SubstancePolymerMonomerSetStartingMaterialSurrogate.category,
      isDefining =
        R5Boolean.of(
          this@SubstancePolymerMonomerSetStartingMaterialSurrogate.isDefining,
          this@SubstancePolymerMonomerSetStartingMaterialSurrogate._isDefining,
        ),
      amount = this@SubstancePolymerMonomerSetStartingMaterialSurrogate.amount,
    )

  public companion object {
    public fun fromModel(
      model: SubstancePolymer.MonomerSet.StartingMaterial
    ): SubstancePolymerMonomerSetStartingMaterialSurrogate =
      with(model) {
        SubstancePolymerMonomerSetStartingMaterialSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          category = this@with.category,
          isDefining = this@with.isDefining?.value,
          _isDefining = this@with.isDefining?.toElement(),
          amount = this@with.amount,
        )
      }
  }
}

@Serializable
internal data class SubstancePolymerRepeatSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var averageMolecularFormula: KotlinString? = null,
  public var _averageMolecularFormula: Element? = null,
  public var repeatUnitAmountType: CodeableConcept? = null,
  public var repeatUnit: List<SubstancePolymer.Repeat.RepeatUnit>? = null,
) {
  public fun toModel(): SubstancePolymer.Repeat =
    SubstancePolymer.Repeat(
      id = this@SubstancePolymerRepeatSurrogate.id,
      extension = this@SubstancePolymerRepeatSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstancePolymerRepeatSurrogate.modifierExtension ?: listOf(),
      averageMolecularFormula =
        R5String.of(
          this@SubstancePolymerRepeatSurrogate.averageMolecularFormula,
          this@SubstancePolymerRepeatSurrogate._averageMolecularFormula,
        ),
      repeatUnitAmountType = this@SubstancePolymerRepeatSurrogate.repeatUnitAmountType,
      repeatUnit = this@SubstancePolymerRepeatSurrogate.repeatUnit ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstancePolymer.Repeat): SubstancePolymerRepeatSurrogate =
      with(model) {
        SubstancePolymerRepeatSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          averageMolecularFormula = this@with.averageMolecularFormula?.value,
          _averageMolecularFormula = this@with.averageMolecularFormula?.toElement(),
          repeatUnitAmountType = this@with.repeatUnitAmountType,
          repeatUnit = this@with.repeatUnit.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstancePolymerRepeatRepeatUnitSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var unit: KotlinString? = null,
  public var _unit: Element? = null,
  public var orientation: CodeableConcept? = null,
  public var amount: Int? = null,
  public var _amount: Element? = null,
  public var degreeOfPolymerisation:
    List<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation>? =
    null,
  public var structuralRepresentation:
    List<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation>? =
    null,
) {
  public fun toModel(): SubstancePolymer.Repeat.RepeatUnit =
    SubstancePolymer.Repeat.RepeatUnit(
      id = this@SubstancePolymerRepeatRepeatUnitSurrogate.id,
      extension = this@SubstancePolymerRepeatRepeatUnitSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstancePolymerRepeatRepeatUnitSurrogate.modifierExtension ?: listOf(),
      unit =
        R5String.of(
          this@SubstancePolymerRepeatRepeatUnitSurrogate.unit,
          this@SubstancePolymerRepeatRepeatUnitSurrogate._unit,
        ),
      orientation = this@SubstancePolymerRepeatRepeatUnitSurrogate.orientation,
      amount =
        Integer.of(
          this@SubstancePolymerRepeatRepeatUnitSurrogate.amount,
          this@SubstancePolymerRepeatRepeatUnitSurrogate._amount,
        ),
      degreeOfPolymerisation =
        this@SubstancePolymerRepeatRepeatUnitSurrogate.degreeOfPolymerisation ?: listOf(),
      structuralRepresentation =
        this@SubstancePolymerRepeatRepeatUnitSurrogate.structuralRepresentation ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstancePolymer.Repeat.RepeatUnit
    ): SubstancePolymerRepeatRepeatUnitSurrogate =
      with(model) {
        SubstancePolymerRepeatRepeatUnitSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          unit = this@with.unit?.value,
          _unit = this@with.unit?.toElement(),
          orientation = this@with.orientation,
          amount = this@with.amount?.value,
          _amount = this@with.amount?.toElement(),
          degreeOfPolymerisation = this@with.degreeOfPolymerisation.takeIf { it.isNotEmpty() },
          structuralRepresentation = this@with.structuralRepresentation.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var average: Int? = null,
  public var _average: Element? = null,
  public var low: Int? = null,
  public var _low: Element? = null,
  public var high: Int? = null,
  public var _high: Element? = null,
) {
  public fun toModel(): SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation =
    SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation(
      id = this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.id,
      extension =
        this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.modifierExtension
          ?: listOf(),
      type = this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.type,
      average =
        Integer.of(
          this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.average,
          this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate._average,
        ),
      low =
        Integer.of(
          this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.low,
          this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate._low,
        ),
      high =
        Integer.of(
          this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.high,
          this@SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate._high,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation
    ): SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate =
      with(model) {
        SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          average = this@with.average?.value,
          _average = this@with.average?.toElement(),
          low = this@with.low?.value,
          _low = this@with.low?.toElement(),
          high = this@with.high?.value,
          _high = this@with.high?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var representation: KotlinString? = null,
  public var _representation: Element? = null,
  public var format: CodeableConcept? = null,
  public var attachment: Attachment? = null,
) {
  public fun toModel(): SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation =
    SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation(
      id = this@SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.id,
      extension =
        this@SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.extension
          ?: listOf(),
      modifierExtension =
        this@SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.modifierExtension
          ?: listOf(),
      type = this@SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.type,
      representation =
        R5String.of(
          this@SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.representation,
          this@SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate._representation,
        ),
      format = this@SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.format,
      attachment = this@SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.attachment,
    )

  public companion object {
    public fun fromModel(
      model: SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation
    ): SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate =
      with(model) {
        SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          representation = this@with.representation?.value,
          _representation = this@with.representation?.toElement(),
          format = this@with.format,
          attachment = this@with.attachment,
        )
      }
  }
}

@Serializable
internal data class SubstancePolymerSurrogate(
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
  public var `class`: CodeableConcept? = null,
  public var geometry: CodeableConcept? = null,
  public var copolymerConnectivity: List<CodeableConcept>? = null,
  public var modification: KotlinString? = null,
  public var _modification: Element? = null,
  public var monomerSet: List<SubstancePolymer.MonomerSet>? = null,
  public var repeat: List<SubstancePolymer.Repeat>? = null,
) {
  public fun toModel(): SubstancePolymer =
    SubstancePolymer(
      id = this@SubstancePolymerSurrogate.id,
      meta = this@SubstancePolymerSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SubstancePolymerSurrogate.implicitRules,
          this@SubstancePolymerSurrogate._implicitRules,
        ),
      language =
        Code.of(this@SubstancePolymerSurrogate.language, this@SubstancePolymerSurrogate._language),
      text = this@SubstancePolymerSurrogate.text,
      contained = this@SubstancePolymerSurrogate.contained ?: listOf(),
      extension = this@SubstancePolymerSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstancePolymerSurrogate.modifierExtension ?: listOf(),
      identifier = this@SubstancePolymerSurrogate.identifier,
      `class` = this@SubstancePolymerSurrogate.`class`,
      geometry = this@SubstancePolymerSurrogate.geometry,
      copolymerConnectivity = this@SubstancePolymerSurrogate.copolymerConnectivity ?: listOf(),
      modification =
        R5String.of(
          this@SubstancePolymerSurrogate.modification,
          this@SubstancePolymerSurrogate._modification,
        ),
      monomerSet = this@SubstancePolymerSurrogate.monomerSet ?: listOf(),
      repeat = this@SubstancePolymerSurrogate.repeat ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstancePolymer): SubstancePolymerSurrogate =
      with(model) {
        SubstancePolymerSurrogate(
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
          `class` = this@with.`class`,
          geometry = this@with.geometry,
          copolymerConnectivity = this@with.copolymerConnectivity.takeIf { it.isNotEmpty() },
          modification = this@with.modification?.value,
          _modification = this@with.modification?.toElement(),
          monomerSet = this@with.monomerSet.takeIf { it.isNotEmpty() },
          repeat = this@with.repeat.takeIf { it.isNotEmpty() },
        )
      }
  }
}
