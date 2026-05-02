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

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Base64Binary
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Decimal
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Integer64
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Url
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class AttachmentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var contentType: KotlinString? = null,
  public var _contentType: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var `data`: KotlinString? = null,
  public var _data: Element? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var size: KotlinString? = null,
  public var _size: Element? = null,
  public var hash: KotlinString? = null,
  public var _hash: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var creation: KotlinString? = null,
  public var _creation: Element? = null,
  public var height: Int? = null,
  public var _height: Element? = null,
  public var width: Int? = null,
  public var _width: Element? = null,
  public var frames: Int? = null,
  public var _frames: Element? = null,
  public var duration: Double? = null,
  public var _duration: Element? = null,
  public var pages: Int? = null,
  public var _pages: Element? = null,
) {
  public fun toModel(): Attachment =
    Attachment(
      id = this@AttachmentSurrogate.id,
      extension = this@AttachmentSurrogate.extension ?: listOf(),
      contentType =
        Code.of(this@AttachmentSurrogate.contentType, this@AttachmentSurrogate._contentType),
      language = Code.of(this@AttachmentSurrogate.language, this@AttachmentSurrogate._language),
      `data` = Base64Binary.of(this@AttachmentSurrogate.`data`, this@AttachmentSurrogate._data),
      url = Url.of(this@AttachmentSurrogate.url, this@AttachmentSurrogate._url),
      size = Integer64.of(this@AttachmentSurrogate.size?.toLong(), this@AttachmentSurrogate._size),
      hash = Base64Binary.of(this@AttachmentSurrogate.hash, this@AttachmentSurrogate._hash),
      title = R5String.of(this@AttachmentSurrogate.title, this@AttachmentSurrogate._title),
      creation =
        DateTime.of(
          FhirDateTime.fromString(this@AttachmentSurrogate.creation),
          this@AttachmentSurrogate._creation,
        ),
      height = PositiveInt.of(this@AttachmentSurrogate.height, this@AttachmentSurrogate._height),
      width = PositiveInt.of(this@AttachmentSurrogate.width, this@AttachmentSurrogate._width),
      frames = PositiveInt.of(this@AttachmentSurrogate.frames, this@AttachmentSurrogate._frames),
      duration = Decimal.of(this@AttachmentSurrogate.duration, this@AttachmentSurrogate._duration),
      pages = PositiveInt.of(this@AttachmentSurrogate.pages, this@AttachmentSurrogate._pages),
    )

  public companion object {
    public fun fromModel(model: Attachment): AttachmentSurrogate =
      with(model) {
        AttachmentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          contentType = this@with.contentType?.value,
          _contentType = this@with.contentType?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          `data` = this@with.`data`?.value,
          _data = this@with.`data`?.toElement(),
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          size = this@with.size?.value?.toString(),
          _size = this@with.size?.toElement(),
          hash = this@with.hash?.value,
          _hash = this@with.hash?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          creation = this@with.creation?.value?.toString(),
          _creation = this@with.creation?.toElement(),
          height = this@with.height?.value,
          _height = this@with.height?.toElement(),
          width = this@with.width?.value,
          _width = this@with.width?.toElement(),
          frames = this@with.frames?.value,
          _frames = this@with.frames?.toElement(),
          duration = this@with.duration?.value?.toString()?.toDouble(),
          _duration = this@with.duration?.toElement(),
          pages = this@with.pages?.value,
          _pages = this@with.pages?.toElement(),
        )
      }
  }
}
