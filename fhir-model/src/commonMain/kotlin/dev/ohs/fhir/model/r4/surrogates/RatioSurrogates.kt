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

import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Ratio
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class RatioSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var numerator: Quantity? = null,
  public var denominator: Quantity? = null,
) {
  public fun toModel(): Ratio =
    Ratio(
      id = this@RatioSurrogate.id,
      extension = this@RatioSurrogate.extension ?: listOf(),
      numerator = this@RatioSurrogate.numerator,
      denominator = this@RatioSurrogate.denominator,
    )

  public companion object {
    public fun fromModel(model: Ratio): RatioSurrogate =
      with(model) {
        RatioSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          numerator = this@with.numerator,
          denominator = this@with.denominator,
        )
      }
  }
}
