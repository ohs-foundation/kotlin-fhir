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

import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.Decimal
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.SampledData
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SampledDataSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var origin: Quantity,
  public var interval: Double? = null,
  public var _interval: Element? = null,
  public var intervalUnit: KotlinString? = null,
  public var _intervalUnit: Element? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var lowerLimit: Double? = null,
  public var _lowerLimit: Element? = null,
  public var upperLimit: Double? = null,
  public var _upperLimit: Element? = null,
  public var dimensions: Int? = null,
  public var _dimensions: Element? = null,
  public var codeMap: KotlinString? = null,
  public var _codeMap: Element? = null,
  public var offsets: KotlinString? = null,
  public var _offsets: Element? = null,
  public var `data`: KotlinString? = null,
  public var _data: Element? = null,
) {
  public fun toModel(): SampledData =
    SampledData(
      id = this@SampledDataSurrogate.id,
      extension = this@SampledDataSurrogate.extension ?: listOf(),
      origin = this@SampledDataSurrogate.origin,
      interval =
        Decimal.of(this@SampledDataSurrogate.interval, this@SampledDataSurrogate._interval),
      intervalUnit =
        Code.of(this@SampledDataSurrogate.intervalUnit, this@SampledDataSurrogate._intervalUnit)!!,
      factor = Decimal.of(this@SampledDataSurrogate.factor, this@SampledDataSurrogate._factor),
      lowerLimit =
        Decimal.of(this@SampledDataSurrogate.lowerLimit, this@SampledDataSurrogate._lowerLimit),
      upperLimit =
        Decimal.of(this@SampledDataSurrogate.upperLimit, this@SampledDataSurrogate._upperLimit),
      dimensions =
        PositiveInt.of(
          this@SampledDataSurrogate.dimensions,
          this@SampledDataSurrogate._dimensions,
        )!!,
      codeMap = Canonical.of(this@SampledDataSurrogate.codeMap, this@SampledDataSurrogate._codeMap),
      offsets = R5String.of(this@SampledDataSurrogate.offsets, this@SampledDataSurrogate._offsets),
      `data` = R5String.of(this@SampledDataSurrogate.`data`, this@SampledDataSurrogate._data),
    )

  public companion object {
    public fun fromModel(model: SampledData): SampledDataSurrogate =
      with(model) {
        SampledDataSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          origin = this@with.origin,
          interval = this@with.interval?.value?.toString()?.toDouble(),
          _interval = this@with.interval?.toElement(),
          intervalUnit = this@with.intervalUnit.value,
          _intervalUnit = this@with.intervalUnit.toElement(),
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          lowerLimit = this@with.lowerLimit?.value?.toString()?.toDouble(),
          _lowerLimit = this@with.lowerLimit?.toElement(),
          upperLimit = this@with.upperLimit?.value?.toString()?.toDouble(),
          _upperLimit = this@with.upperLimit?.toElement(),
          dimensions = this@with.dimensions.value,
          _dimensions = this@with.dimensions.toElement(),
          codeMap = this@with.codeMap?.value,
          _codeMap = this@with.codeMap?.toElement(),
          offsets = this@with.offsets?.value,
          _offsets = this@with.offsets?.toElement(),
          `data` = this@with.`data`?.value,
          _data = this@with.`data`?.toElement(),
        )
      }
  }
}
