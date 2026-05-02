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

import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Decimal
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.MonetaryComponent
import com.google.fhir.model.r5.Money
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MonetaryComponentSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var type: String? = null,
  public var _type: Element? = null,
  public var code: CodeableConcept? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var amount: Money? = null,
) {
  public fun toModel(): MonetaryComponent =
    MonetaryComponent(
      id = this@MonetaryComponentSurrogate.id,
      extension = this@MonetaryComponentSurrogate.extension ?: listOf(),
      type =
        Enumeration.of(
          MonetaryComponent.PriceComponentType.fromCode(this@MonetaryComponentSurrogate.type!!),
          this@MonetaryComponentSurrogate._type,
        ),
      code = this@MonetaryComponentSurrogate.code,
      factor =
        Decimal.of(this@MonetaryComponentSurrogate.factor, this@MonetaryComponentSurrogate._factor),
      amount = this@MonetaryComponentSurrogate.amount,
    )

  public companion object {
    public fun fromModel(model: MonetaryComponent): MonetaryComponentSurrogate =
      with(model) {
        MonetaryComponentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          code = this@with.code,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          amount = this@with.amount,
        )
      }
  }
}
