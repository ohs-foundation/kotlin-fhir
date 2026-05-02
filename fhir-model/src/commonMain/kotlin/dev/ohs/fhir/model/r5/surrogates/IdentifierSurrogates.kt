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

import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class IdentifierSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var type: CodeableConcept? = null,
  public var system: KotlinString? = null,
  public var _system: Element? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
  public var period: Period? = null,
  public var assigner: Reference? = null,
) {
  public fun toModel(): Identifier =
    Identifier(
      id = this@IdentifierSurrogate.id,
      extension = this@IdentifierSurrogate.extension ?: listOf(),
      use =
        this@IdentifierSurrogate.use?.let {
          Enumeration.of(Identifier.IdentifierUse.fromCode(it), this@IdentifierSurrogate._use)
        },
      type = this@IdentifierSurrogate.type,
      system = Uri.of(this@IdentifierSurrogate.system, this@IdentifierSurrogate._system),
      `value` = R5String.of(this@IdentifierSurrogate.`value`, this@IdentifierSurrogate._value),
      period = this@IdentifierSurrogate.period,
      assigner = this@IdentifierSurrogate.assigner,
    )

  public companion object {
    public fun fromModel(model: Identifier): IdentifierSurrogate =
      with(model) {
        IdentifierSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          use = this@with.use?.value?.getCode(),
          _use = this@with.use?.toElement(),
          type = this@with.type,
          system = this@with.system?.value,
          _system = this@with.system?.toElement(),
          `value` = this@with.`value`?.value,
          _value = this@with.`value`?.toElement(),
          period = this@with.period,
          assigner = this@with.assigner,
        )
      }
  }
}
