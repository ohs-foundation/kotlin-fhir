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

import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class PeriodSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var start: String? = null,
  public var _start: Element? = null,
  public var end: String? = null,
  public var _end: Element? = null,
) {
  public fun toModel(): Period =
    Period(
      id = this@PeriodSurrogate.id,
      extension = this@PeriodSurrogate.extension ?: listOf(),
      start =
        DateTime.of(
          FhirDateTime.fromString(this@PeriodSurrogate.start),
          this@PeriodSurrogate._start,
        ),
      end =
        DateTime.of(FhirDateTime.fromString(this@PeriodSurrogate.end), this@PeriodSurrogate._end),
    )

  public companion object {
    public fun fromModel(model: Period): PeriodSurrogate =
      with(model) {
        PeriodSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          start = this@with.start?.value?.toString(),
          _start = this@with.start?.toElement(),
          end = this@with.end?.value?.toString(),
          _end = this@with.end?.toElement(),
        )
      }
  }
}
