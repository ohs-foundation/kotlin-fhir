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
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.ProductShelfLife
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ProductShelfLifeSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var type: CodeableConcept,
  public var period: Quantity,
  public var specialPrecautionsForStorage: List<CodeableConcept>? = null,
) {
  public fun toModel(): ProductShelfLife =
    ProductShelfLife(
      id = this@ProductShelfLifeSurrogate.id,
      extension = this@ProductShelfLifeSurrogate.extension ?: listOf(),
      modifierExtension = this@ProductShelfLifeSurrogate.modifierExtension ?: listOf(),
      identifier = this@ProductShelfLifeSurrogate.identifier,
      type = this@ProductShelfLifeSurrogate.type,
      period = this@ProductShelfLifeSurrogate.period,
      specialPrecautionsForStorage =
        this@ProductShelfLifeSurrogate.specialPrecautionsForStorage ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ProductShelfLife): ProductShelfLifeSurrogate =
      with(model) {
        ProductShelfLifeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier,
          type = this@with.type,
          period = this@with.period,
          specialPrecautionsForStorage =
            this@with.specialPrecautionsForStorage.takeIf { it.isNotEmpty() },
        )
      }
  }
}
