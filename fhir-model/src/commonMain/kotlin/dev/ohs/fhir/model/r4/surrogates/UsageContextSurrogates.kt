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
import com.google.fhir.model.r4.Coding
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.UsageContext
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class UsageContextValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): UsageContext.Value =
    UsageContext.Value.from(
      this@UsageContextValueSurrogate.valueCodeableConcept,
      this@UsageContextValueSurrogate.valueQuantity,
      this@UsageContextValueSurrogate.valueRange,
      this@UsageContextValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(model: UsageContext.Value): UsageContextValueSurrogate =
      with(model) {
        UsageContextValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class UsageContextSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var code: Coding,
  public var `value`: UsageContext.Value,
) {
  public fun toModel(): UsageContext =
    UsageContext(
      id = this@UsageContextSurrogate.id,
      extension = this@UsageContextSurrogate.extension ?: listOf(),
      code = this@UsageContextSurrogate.code,
      `value` = this@UsageContextSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: UsageContext): UsageContextSurrogate =
      with(model) {
        UsageContextSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          `value` = this@with.`value`,
        )
      }
  }
}
