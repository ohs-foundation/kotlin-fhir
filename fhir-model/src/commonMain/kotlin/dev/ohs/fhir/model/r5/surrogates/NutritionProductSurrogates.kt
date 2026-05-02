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

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Base64Binary
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.NutritionProduct
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Ratio
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class NutritionProductNutrientSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: CodeableReference? = null,
  public var amount: List<Ratio>? = null,
) {
  public fun toModel(): NutritionProduct.Nutrient =
    NutritionProduct.Nutrient(
      id = this@NutritionProductNutrientSurrogate.id,
      extension = this@NutritionProductNutrientSurrogate.extension ?: listOf(),
      modifierExtension = this@NutritionProductNutrientSurrogate.modifierExtension ?: listOf(),
      item = this@NutritionProductNutrientSurrogate.item,
      amount = this@NutritionProductNutrientSurrogate.amount ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: NutritionProduct.Nutrient): NutritionProductNutrientSurrogate =
      with(model) {
        NutritionProductNutrientSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
          amount = this@with.amount.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class NutritionProductIngredientSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: CodeableReference,
  public var amount: List<Ratio>? = null,
) {
  public fun toModel(): NutritionProduct.Ingredient =
    NutritionProduct.Ingredient(
      id = this@NutritionProductIngredientSurrogate.id,
      extension = this@NutritionProductIngredientSurrogate.extension ?: listOf(),
      modifierExtension = this@NutritionProductIngredientSurrogate.modifierExtension ?: listOf(),
      item = this@NutritionProductIngredientSurrogate.item,
      amount = this@NutritionProductIngredientSurrogate.amount ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: NutritionProduct.Ingredient): NutritionProductIngredientSurrogate =
      with(model) {
        NutritionProductIngredientSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
          amount = this@with.amount.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class NutritionProductCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: NutritionProduct.Characteristic.Value,
) {
  public fun toModel(): NutritionProduct.Characteristic =
    NutritionProduct.Characteristic(
      id = this@NutritionProductCharacteristicSurrogate.id,
      extension = this@NutritionProductCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension =
        this@NutritionProductCharacteristicSurrogate.modifierExtension ?: listOf(),
      type = this@NutritionProductCharacteristicSurrogate.type,
      `value` = this@NutritionProductCharacteristicSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: NutritionProduct.Characteristic
    ): NutritionProductCharacteristicSurrogate =
      with(model) {
        NutritionProductCharacteristicSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class NutritionProductInstanceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var quantity: Quantity? = null,
  public var identifier: List<Identifier>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var lotNumber: KotlinString? = null,
  public var _lotNumber: Element? = null,
  public var expiry: KotlinString? = null,
  public var _expiry: Element? = null,
  public var useBy: KotlinString? = null,
  public var _useBy: Element? = null,
  public var biologicalSourceEvent: Identifier? = null,
) {
  public fun toModel(): NutritionProduct.Instance =
    NutritionProduct.Instance(
      id = this@NutritionProductInstanceSurrogate.id,
      extension = this@NutritionProductInstanceSurrogate.extension ?: listOf(),
      modifierExtension = this@NutritionProductInstanceSurrogate.modifierExtension ?: listOf(),
      quantity = this@NutritionProductInstanceSurrogate.quantity,
      identifier = this@NutritionProductInstanceSurrogate.identifier ?: listOf(),
      name =
        R5String.of(
          this@NutritionProductInstanceSurrogate.name,
          this@NutritionProductInstanceSurrogate._name,
        ),
      lotNumber =
        R5String.of(
          this@NutritionProductInstanceSurrogate.lotNumber,
          this@NutritionProductInstanceSurrogate._lotNumber,
        ),
      expiry =
        DateTime.of(
          FhirDateTime.fromString(this@NutritionProductInstanceSurrogate.expiry),
          this@NutritionProductInstanceSurrogate._expiry,
        ),
      useBy =
        DateTime.of(
          FhirDateTime.fromString(this@NutritionProductInstanceSurrogate.useBy),
          this@NutritionProductInstanceSurrogate._useBy,
        ),
      biologicalSourceEvent = this@NutritionProductInstanceSurrogate.biologicalSourceEvent,
    )

  public companion object {
    public fun fromModel(model: NutritionProduct.Instance): NutritionProductInstanceSurrogate =
      with(model) {
        NutritionProductInstanceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          lotNumber = this@with.lotNumber?.value,
          _lotNumber = this@with.lotNumber?.toElement(),
          expiry = this@with.expiry?.value?.toString(),
          _expiry = this@with.expiry?.toElement(),
          useBy = this@with.useBy?.value?.toString(),
          _useBy = this@with.useBy?.toElement(),
          biologicalSourceEvent = this@with.biologicalSourceEvent,
        )
      }
  }
}

@Serializable
internal data class NutritionProductCharacteristicValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueQuantity: Quantity? = null,
  public var valueBase64Binary: KotlinString? = null,
  public var _valueBase64Binary: Element? = null,
  public var valueAttachment: Attachment? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
) {
  public fun toModel(): NutritionProduct.Characteristic.Value =
    NutritionProduct.Characteristic.Value.from(
      this@NutritionProductCharacteristicValueSurrogate.valueCodeableConcept,
      R5String.of(
        this@NutritionProductCharacteristicValueSurrogate.valueString,
        this@NutritionProductCharacteristicValueSurrogate._valueString,
      ),
      this@NutritionProductCharacteristicValueSurrogate.valueQuantity,
      Base64Binary.of(
        this@NutritionProductCharacteristicValueSurrogate.valueBase64Binary,
        this@NutritionProductCharacteristicValueSurrogate._valueBase64Binary,
      ),
      this@NutritionProductCharacteristicValueSurrogate.valueAttachment,
      R5Boolean.of(
        this@NutritionProductCharacteristicValueSurrogate.valueBoolean,
        this@NutritionProductCharacteristicValueSurrogate._valueBoolean,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: NutritionProduct.Characteristic.Value
    ): NutritionProductCharacteristicValueSurrogate =
      with(model) {
        NutritionProductCharacteristicValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
          valueBase64Binary = this@with.asBase64Binary()?.value?.value,
          _valueBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class NutritionProductSurrogate(
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
  public var code: CodeableConcept? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var manufacturer: List<Reference>? = null,
  public var nutrient: List<NutritionProduct.Nutrient>? = null,
  public var ingredient: List<NutritionProduct.Ingredient>? = null,
  public var knownAllergen: List<CodeableReference>? = null,
  public var characteristic: List<NutritionProduct.Characteristic>? = null,
  public var instance: List<NutritionProduct.Instance>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): NutritionProduct =
    NutritionProduct(
      id = this@NutritionProductSurrogate.id,
      meta = this@NutritionProductSurrogate.meta,
      implicitRules =
        Uri.of(
          this@NutritionProductSurrogate.implicitRules,
          this@NutritionProductSurrogate._implicitRules,
        ),
      language =
        Code.of(this@NutritionProductSurrogate.language, this@NutritionProductSurrogate._language),
      text = this@NutritionProductSurrogate.text,
      contained = this@NutritionProductSurrogate.contained ?: listOf(),
      extension = this@NutritionProductSurrogate.extension ?: listOf(),
      modifierExtension = this@NutritionProductSurrogate.modifierExtension ?: listOf(),
      code = this@NutritionProductSurrogate.code,
      status =
        Enumeration.of(
          NutritionProduct.NutritionProductStatus.fromCode(this@NutritionProductSurrogate.status!!),
          this@NutritionProductSurrogate._status,
        ),
      category = this@NutritionProductSurrogate.category ?: listOf(),
      manufacturer = this@NutritionProductSurrogate.manufacturer ?: listOf(),
      nutrient = this@NutritionProductSurrogate.nutrient ?: listOf(),
      ingredient = this@NutritionProductSurrogate.ingredient ?: listOf(),
      knownAllergen = this@NutritionProductSurrogate.knownAllergen ?: listOf(),
      characteristic = this@NutritionProductSurrogate.characteristic ?: listOf(),
      instance = this@NutritionProductSurrogate.instance ?: listOf(),
      note = this@NutritionProductSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: NutritionProduct): NutritionProductSurrogate =
      with(model) {
        NutritionProductSurrogate(
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
          code = this@with.code,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          nutrient = this@with.nutrient.takeIf { it.isNotEmpty() },
          ingredient = this@with.ingredient.takeIf { it.isNotEmpty() },
          knownAllergen = this@with.knownAllergen.takeIf { it.isNotEmpty() },
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
          instance = this@with.instance.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
