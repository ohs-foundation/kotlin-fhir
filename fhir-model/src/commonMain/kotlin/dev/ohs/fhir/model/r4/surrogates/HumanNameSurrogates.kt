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

import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.HumanName
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class HumanNameSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var family: KotlinString? = null,
  public var _family: Element? = null,
  public var given: List<KotlinString?>? = null,
  public var _given: List<Element?>? = null,
  public var prefix: List<KotlinString?>? = null,
  public var _prefix: List<Element?>? = null,
  public var suffix: List<KotlinString?>? = null,
  public var _suffix: List<Element?>? = null,
  public var period: Period? = null,
) {
  public fun toModel(): HumanName =
    HumanName(
      id = this@HumanNameSurrogate.id,
      extension = this@HumanNameSurrogate.extension ?: listOf(),
      use =
        this@HumanNameSurrogate.use?.let {
          Enumeration.of(HumanName.NameUse.fromCode(it), this@HumanNameSurrogate._use)
        },
      text = R4String.of(this@HumanNameSurrogate.text, this@HumanNameSurrogate._text),
      family = R4String.of(this@HumanNameSurrogate.family, this@HumanNameSurrogate._family),
      given =
        if (this@HumanNameSurrogate.given == null && this@HumanNameSurrogate._given == null) {
          listOf()
        } else {
          (this@HumanNameSurrogate.given ?: List(this@HumanNameSurrogate._given!!.size) { null })
            .zip(
              this@HumanNameSurrogate._given ?: List(this@HumanNameSurrogate.given!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      prefix =
        if (this@HumanNameSurrogate.prefix == null && this@HumanNameSurrogate._prefix == null) {
          listOf()
        } else {
          (this@HumanNameSurrogate.prefix ?: List(this@HumanNameSurrogate._prefix!!.size) { null })
            .zip(
              this@HumanNameSurrogate._prefix
                ?: List(this@HumanNameSurrogate.prefix!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      suffix =
        if (this@HumanNameSurrogate.suffix == null && this@HumanNameSurrogate._suffix == null) {
          listOf()
        } else {
          (this@HumanNameSurrogate.suffix ?: List(this@HumanNameSurrogate._suffix!!.size) { null })
            .zip(
              this@HumanNameSurrogate._suffix
                ?: List(this@HumanNameSurrogate.suffix!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      period = this@HumanNameSurrogate.period,
    )

  public companion object {
    public fun fromModel(model: HumanName): HumanNameSurrogate =
      with(model) {
        HumanNameSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          use = this@with.use?.value?.getCode(),
          _use = this@with.use?.toElement(),
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          family = this@with.family?.value,
          _family = this@with.family?.toElement(),
          given = this@with.given.map { it.value }.toList().takeUnless { it.all { it == null } },
          _given =
            this@with.given
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          prefix = this@with.prefix.map { it.value }.toList().takeUnless { it.all { it == null } },
          _prefix =
            this@with.prefix
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          suffix = this@with.suffix.map { it.value }.toList().takeUnless { it.all { it == null } },
          _suffix =
            this@with.suffix
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          period = this@with.period,
        )
      }
  }
}
