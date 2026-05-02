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

import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactPoint
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.ExtendedContactDetail
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Url
import com.google.fhir.model.r5.VirtualServiceDetail
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class VirtualServiceDetailAddressSurrogate(
  public var addressUrl: KotlinString? = null,
  public var _addressUrl: Element? = null,
  public var addressString: KotlinString? = null,
  public var _addressString: Element? = null,
  public var addressContactPoint: ContactPoint? = null,
  public var addressExtendedContactDetail: ExtendedContactDetail? = null,
) {
  public fun toModel(): VirtualServiceDetail.Address =
    VirtualServiceDetail.Address.from(
      Url.of(
        this@VirtualServiceDetailAddressSurrogate.addressUrl,
        this@VirtualServiceDetailAddressSurrogate._addressUrl,
      ),
      R5String.of(
        this@VirtualServiceDetailAddressSurrogate.addressString,
        this@VirtualServiceDetailAddressSurrogate._addressString,
      ),
      this@VirtualServiceDetailAddressSurrogate.addressContactPoint,
      this@VirtualServiceDetailAddressSurrogate.addressExtendedContactDetail,
    )!!

  public companion object {
    public fun fromModel(
      model: VirtualServiceDetail.Address
    ): VirtualServiceDetailAddressSurrogate =
      with(model) {
        VirtualServiceDetailAddressSurrogate(
          addressUrl = this@with.asUrl()?.value?.value,
          _addressUrl = this@with.asUrl()?.value?.toElement(),
          addressString = this@with.asString()?.value?.value,
          _addressString = this@with.asString()?.value?.toElement(),
          addressContactPoint = this@with.asContactPoint()?.value,
          addressExtendedContactDetail = this@with.asExtendedContactDetail()?.value,
        )
      }
  }
}

@Serializable
internal data class VirtualServiceDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var channelType: Coding? = null,
  public var address: VirtualServiceDetail.Address? = null,
  public var additionalInfo: List<KotlinString?>? = null,
  public var _additionalInfo: List<Element?>? = null,
  public var maxParticipants: Int? = null,
  public var _maxParticipants: Element? = null,
  public var sessionKey: KotlinString? = null,
  public var _sessionKey: Element? = null,
) {
  public fun toModel(): VirtualServiceDetail =
    VirtualServiceDetail(
      id = this@VirtualServiceDetailSurrogate.id,
      extension = this@VirtualServiceDetailSurrogate.extension ?: listOf(),
      channelType = this@VirtualServiceDetailSurrogate.channelType,
      address = this@VirtualServiceDetailSurrogate.address,
      additionalInfo =
        if (
          this@VirtualServiceDetailSurrogate.additionalInfo == null &&
            this@VirtualServiceDetailSurrogate._additionalInfo == null
        ) {
          listOf()
        } else {
          (this@VirtualServiceDetailSurrogate.additionalInfo
              ?: List(this@VirtualServiceDetailSurrogate._additionalInfo!!.size) { null })
            .zip(
              this@VirtualServiceDetailSurrogate._additionalInfo
                ?: List(this@VirtualServiceDetailSurrogate.additionalInfo!!.size) { null }
            )
            .map { (value, element) -> Url.of(value, element)!! }
            .toList()
        },
      maxParticipants =
        PositiveInt.of(
          this@VirtualServiceDetailSurrogate.maxParticipants,
          this@VirtualServiceDetailSurrogate._maxParticipants,
        ),
      sessionKey =
        R5String.of(
          this@VirtualServiceDetailSurrogate.sessionKey,
          this@VirtualServiceDetailSurrogate._sessionKey,
        ),
    )

  public companion object {
    public fun fromModel(model: VirtualServiceDetail): VirtualServiceDetailSurrogate =
      with(model) {
        VirtualServiceDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          channelType = this@with.channelType,
          address = this@with.address,
          additionalInfo =
            this@with.additionalInfo.map { it.value }.toList().takeUnless { it.all { it == null } },
          _additionalInfo =
            this@with.additionalInfo
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          maxParticipants = this@with.maxParticipants?.value,
          _maxParticipants = this@with.maxParticipants?.toElement(),
          sessionKey = this@with.sessionKey?.value,
          _sessionKey = this@with.sessionKey?.toElement(),
        )
      }
  }
}
