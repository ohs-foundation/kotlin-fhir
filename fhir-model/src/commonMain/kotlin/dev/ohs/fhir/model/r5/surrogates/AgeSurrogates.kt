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

import com.google.fhir.model.r5.Age
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.Decimal
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Double
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class AgeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var `value`: Double? = null,
  public var _value: Element? = null,
  public var comparator: KotlinString? = null,
  public var _comparator: Element? = null,
  public var unit: KotlinString? = null,
  public var _unit: Element? = null,
  public var system: KotlinString? = null,
  public var _system: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
) {
  public fun toModel(): Age =
    Age(
      id = this@AgeSurrogate.id,
      extension = this@AgeSurrogate.extension ?: listOf(),
      `value` = Decimal.of(this@AgeSurrogate.`value`, this@AgeSurrogate._value),
      comparator =
        this@AgeSurrogate.comparator?.let {
          Enumeration.of(Quantity.QuantityComparator.fromCode(it), this@AgeSurrogate._comparator)
        },
      unit = R5String.of(this@AgeSurrogate.unit, this@AgeSurrogate._unit),
      system = Uri.of(this@AgeSurrogate.system, this@AgeSurrogate._system),
      code = Code.of(this@AgeSurrogate.code, this@AgeSurrogate._code),
    )

  public companion object {
    public fun fromModel(model: Age): AgeSurrogate =
      with(model) {
        AgeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`?.value?.toString()?.toDouble(),
          _value = this@with.`value`?.toElement(),
          comparator = this@with.comparator?.value?.getCode(),
          _comparator = this@with.comparator?.toElement(),
          unit = this@with.unit?.value,
          _unit = this@with.unit?.toElement(),
          system = this@with.system?.value,
          _system = this@with.system?.toElement(),
          code = this@with.code?.value,
          _code = this@with.code?.toElement(),
        )
      }
  }
}
