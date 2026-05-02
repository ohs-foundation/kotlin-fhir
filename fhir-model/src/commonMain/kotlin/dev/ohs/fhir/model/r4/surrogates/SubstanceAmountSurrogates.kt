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

import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.SubstanceAmount
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubstanceAmountReferenceRangeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var lowLimit: Quantity? = null,
  public var highLimit: Quantity? = null,
) {
  public fun toModel(): SubstanceAmount.ReferenceRange =
    SubstanceAmount.ReferenceRange(
      id = this@SubstanceAmountReferenceRangeSurrogate.id,
      extension = this@SubstanceAmountReferenceRangeSurrogate.extension ?: listOf(),
      lowLimit = this@SubstanceAmountReferenceRangeSurrogate.lowLimit,
      highLimit = this@SubstanceAmountReferenceRangeSurrogate.highLimit,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceAmount.ReferenceRange
    ): SubstanceAmountReferenceRangeSurrogate =
      with(model) {
        SubstanceAmountReferenceRangeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          lowLimit = this@with.lowLimit,
          highLimit = this@with.highLimit,
        )
      }
  }
}

@Serializable
internal data class SubstanceAmountAmountSurrogate(
  public var amountQuantity: Quantity? = null,
  public var amountRange: Range? = null,
  public var amountString: KotlinString? = null,
  public var _amountString: Element? = null,
) {
  public fun toModel(): SubstanceAmount.Amount =
    SubstanceAmount.Amount.from(
      this@SubstanceAmountAmountSurrogate.amountQuantity,
      this@SubstanceAmountAmountSurrogate.amountRange,
      R4String.of(
        this@SubstanceAmountAmountSurrogate.amountString,
        this@SubstanceAmountAmountSurrogate._amountString,
      ),
    )!!

  public companion object {
    public fun fromModel(model: SubstanceAmount.Amount): SubstanceAmountAmountSurrogate =
      with(model) {
        SubstanceAmountAmountSurrogate(
          amountQuantity = this@with.asQuantity()?.value,
          amountRange = this@with.asRange()?.value,
          amountString = this@with.asString()?.value?.value,
          _amountString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceAmountSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var amount: SubstanceAmount.Amount? = null,
  public var amountType: CodeableConcept? = null,
  public var amountText: KotlinString? = null,
  public var _amountText: Element? = null,
  public var referenceRange: SubstanceAmount.ReferenceRange? = null,
) {
  public fun toModel(): SubstanceAmount =
    SubstanceAmount(
      id = this@SubstanceAmountSurrogate.id,
      extension = this@SubstanceAmountSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceAmountSurrogate.modifierExtension ?: listOf(),
      amount = this@SubstanceAmountSurrogate.amount,
      amountType = this@SubstanceAmountSurrogate.amountType,
      amountText =
        R4String.of(
          this@SubstanceAmountSurrogate.amountText,
          this@SubstanceAmountSurrogate._amountText,
        ),
      referenceRange = this@SubstanceAmountSurrogate.referenceRange,
    )

  public companion object {
    public fun fromModel(model: SubstanceAmount): SubstanceAmountSurrogate =
      with(model) {
        SubstanceAmountSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          amount = this@with.amount,
          amountType = this@with.amountType,
          amountText = this@with.amountText?.value,
          _amountText = this@with.amountText?.toElement(),
          referenceRange = this@with.referenceRange,
        )
      }
  }
}
