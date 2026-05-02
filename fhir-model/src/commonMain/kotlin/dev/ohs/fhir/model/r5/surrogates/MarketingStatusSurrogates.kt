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

import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.MarketingStatus
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MarketingStatusSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var country: CodeableConcept? = null,
  public var jurisdiction: CodeableConcept? = null,
  public var status: CodeableConcept,
  public var dateRange: Period? = null,
  public var restoreDate: String? = null,
  public var _restoreDate: Element? = null,
) {
  public fun toModel(): MarketingStatus =
    MarketingStatus(
      id = this@MarketingStatusSurrogate.id,
      extension = this@MarketingStatusSurrogate.extension ?: listOf(),
      modifierExtension = this@MarketingStatusSurrogate.modifierExtension ?: listOf(),
      country = this@MarketingStatusSurrogate.country,
      jurisdiction = this@MarketingStatusSurrogate.jurisdiction,
      status = this@MarketingStatusSurrogate.status,
      dateRange = this@MarketingStatusSurrogate.dateRange,
      restoreDate =
        DateTime.of(
          FhirDateTime.fromString(this@MarketingStatusSurrogate.restoreDate),
          this@MarketingStatusSurrogate._restoreDate,
        ),
    )

  public companion object {
    public fun fromModel(model: MarketingStatus): MarketingStatusSurrogate =
      with(model) {
        MarketingStatusSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          country = this@with.country,
          jurisdiction = this@with.jurisdiction,
          status = this@with.status,
          dateRange = this@with.dateRange,
          restoreDate = this@with.restoreDate?.value?.toString(),
          _restoreDate = this@with.restoreDate?.toElement(),
        )
      }
  }
}
