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

import com.google.fhir.model.r4.Address
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
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
internal data class AddressSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var line: List<KotlinString?>? = null,
  public var _line: List<Element?>? = null,
  public var city: KotlinString? = null,
  public var _city: Element? = null,
  public var district: KotlinString? = null,
  public var _district: Element? = null,
  public var state: KotlinString? = null,
  public var _state: Element? = null,
  public var postalCode: KotlinString? = null,
  public var _postalCode: Element? = null,
  public var country: KotlinString? = null,
  public var _country: Element? = null,
  public var period: Period? = null,
) {
  public fun toModel(): Address =
    Address(
      id = this@AddressSurrogate.id,
      extension = this@AddressSurrogate.extension ?: listOf(),
      use =
        this@AddressSurrogate.use?.let {
          Enumeration.of(Address.AddressUse.fromCode(it), this@AddressSurrogate._use)
        },
      type =
        this@AddressSurrogate.type?.let {
          Enumeration.of(Address.AddressType.fromCode(it), this@AddressSurrogate._type)
        },
      text = R4String.of(this@AddressSurrogate.text, this@AddressSurrogate._text),
      line =
        if (this@AddressSurrogate.line == null && this@AddressSurrogate._line == null) {
          listOf()
        } else {
          (this@AddressSurrogate.line ?: List(this@AddressSurrogate._line!!.size) { null })
            .zip(this@AddressSurrogate._line ?: List(this@AddressSurrogate.line!!.size) { null })
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      city = R4String.of(this@AddressSurrogate.city, this@AddressSurrogate._city),
      district = R4String.of(this@AddressSurrogate.district, this@AddressSurrogate._district),
      state = R4String.of(this@AddressSurrogate.state, this@AddressSurrogate._state),
      postalCode = R4String.of(this@AddressSurrogate.postalCode, this@AddressSurrogate._postalCode),
      country = R4String.of(this@AddressSurrogate.country, this@AddressSurrogate._country),
      period = this@AddressSurrogate.period,
    )

  public companion object {
    public fun fromModel(model: Address): AddressSurrogate =
      with(model) {
        AddressSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          use = this@with.use?.value?.getCode(),
          _use = this@with.use?.toElement(),
          type = this@with.type?.value?.getCode(),
          _type = this@with.type?.toElement(),
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          line = this@with.line.map { it.value }.toList().takeUnless { it.all { it == null } },
          _line =
            this@with.line
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          city = this@with.city?.value,
          _city = this@with.city?.toElement(),
          district = this@with.district?.value,
          _district = this@with.district?.toElement(),
          state = this@with.state?.value,
          _state = this@with.state?.toElement(),
          postalCode = this@with.postalCode?.value,
          _postalCode = this@with.postalCode?.toElement(),
          country = this@with.country?.value,
          _country = this@with.country?.toElement(),
          period = this@with.period,
        )
      }
  }
}
