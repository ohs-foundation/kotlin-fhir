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

import com.google.fhir.model.r5.ContactPoint
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ContactPointSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var system: KotlinString? = null,
  public var _system: Element? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var rank: Int? = null,
  public var _rank: Element? = null,
  public var period: Period? = null,
) {
  public fun toModel(): ContactPoint =
    ContactPoint(
      id = this@ContactPointSurrogate.id,
      extension = this@ContactPointSurrogate.extension ?: listOf(),
      system =
        this@ContactPointSurrogate.system?.let {
          Enumeration.of(
            ContactPoint.ContactPointSystem.fromCode(it),
            this@ContactPointSurrogate._system,
          )
        },
      `value` = R5String.of(this@ContactPointSurrogate.`value`, this@ContactPointSurrogate._value),
      use =
        this@ContactPointSurrogate.use?.let {
          Enumeration.of(ContactPoint.ContactPointUse.fromCode(it), this@ContactPointSurrogate._use)
        },
      rank = PositiveInt.of(this@ContactPointSurrogate.rank, this@ContactPointSurrogate._rank),
      period = this@ContactPointSurrogate.period,
    )

  public companion object {
    public fun fromModel(model: ContactPoint): ContactPointSurrogate =
      with(model) {
        ContactPointSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          system = this@with.system?.value?.getCode(),
          _system = this@with.system?.toElement(),
          `value` = this@with.`value`?.value,
          _value = this@with.`value`?.toElement(),
          use = this@with.use?.value?.getCode(),
          _use = this@with.use?.toElement(),
          rank = this@with.rank?.value,
          _rank = this@with.rank?.toElement(),
          period = this@with.period,
        )
      }
  }
}
