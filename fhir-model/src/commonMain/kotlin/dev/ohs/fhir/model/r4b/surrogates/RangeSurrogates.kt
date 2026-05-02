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

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Range
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class RangeSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var low: Quantity? = null,
  public var high: Quantity? = null,
) {
  public fun toModel(): Range =
    Range(
      id = this@RangeSurrogate.id,
      extension = this@RangeSurrogate.extension ?: listOf(),
      low = this@RangeSurrogate.low,
      high = this@RangeSurrogate.high,
    )

  public companion object {
    public fun fromModel(model: Range): RangeSurrogate =
      with(model) {
        RangeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          low = this@with.low,
          high = this@with.high,
        )
      }
  }
}
