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

import com.google.fhir.model.r5.Base64Binary
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Instant
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Signature
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SignatureSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var type: List<Coding>? = null,
  public var `when`: String? = null,
  public var _when: Element? = null,
  public var who: Reference? = null,
  public var onBehalfOf: Reference? = null,
  public var targetFormat: String? = null,
  public var _targetFormat: Element? = null,
  public var sigFormat: String? = null,
  public var _sigFormat: Element? = null,
  public var `data`: String? = null,
  public var _data: Element? = null,
) {
  public fun toModel(): Signature =
    Signature(
      id = this@SignatureSurrogate.id,
      extension = this@SignatureSurrogate.extension ?: listOf(),
      type = this@SignatureSurrogate.type ?: listOf(),
      `when` =
        Instant.of(
          FhirDateTime.fromString(this@SignatureSurrogate.`when`),
          this@SignatureSurrogate._when,
        ),
      who = this@SignatureSurrogate.who,
      onBehalfOf = this@SignatureSurrogate.onBehalfOf,
      targetFormat =
        Code.of(this@SignatureSurrogate.targetFormat, this@SignatureSurrogate._targetFormat),
      sigFormat = Code.of(this@SignatureSurrogate.sigFormat, this@SignatureSurrogate._sigFormat),
      `data` = Base64Binary.of(this@SignatureSurrogate.`data`, this@SignatureSurrogate._data),
    )

  public companion object {
    public fun fromModel(model: Signature): SignatureSurrogate =
      with(model) {
        SignatureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          type = this@with.type.takeIf { it.isNotEmpty() },
          `when` = this@with.`when`?.value?.toString(),
          _when = this@with.`when`?.toElement(),
          who = this@with.who,
          onBehalfOf = this@with.onBehalfOf,
          targetFormat = this@with.targetFormat?.value,
          _targetFormat = this@with.targetFormat?.toElement(),
          sigFormat = this@with.sigFormat?.value,
          _sigFormat = this@with.sigFormat?.toElement(),
          `data` = this@with.`data`?.value,
          _data = this@with.`data`?.toElement(),
        )
      }
  }
}
