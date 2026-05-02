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

import com.google.fhir.model.r4.Decimal
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Money
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.Currencies
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MoneySurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var `value`: Double? = null,
  public var _value: Element? = null,
  public var currency: String? = null,
  public var _currency: Element? = null,
) {
  public fun toModel(): Money =
    Money(
      id = this@MoneySurrogate.id,
      extension = this@MoneySurrogate.extension ?: listOf(),
      `value` = Decimal.of(this@MoneySurrogate.`value`, this@MoneySurrogate._value),
      currency =
        this@MoneySurrogate.currency?.let {
          Enumeration.of(Currencies.fromCode(it), this@MoneySurrogate._currency)
        },
    )

  public companion object {
    public fun fromModel(model: Money): MoneySurrogate =
      with(model) {
        MoneySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`?.value?.toString()?.toDouble(),
          _value = this@with.`value`?.toElement(),
          currency = this@with.currency?.value?.getCode(),
          _currency = this@with.currency?.toElement(),
        )
      }
  }
}
