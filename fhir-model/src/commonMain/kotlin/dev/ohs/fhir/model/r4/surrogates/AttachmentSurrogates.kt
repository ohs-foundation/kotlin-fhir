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

import com.google.fhir.model.r4.Attachment
import com.google.fhir.model.r4.Base64Binary
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.UnsignedInt
import com.google.fhir.model.r4.Url
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.CommonLanguages
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
  public var size: Int? = null,
  public var _size: Element? = null,
  public var hash: KotlinString? = null,
  public var _hash: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var creation: KotlinString? = null,
  public var _creation: Element? = null,
) {
  public fun toModel(): Attachment =
    Attachment(
      id = this@AttachmentSurrogate.id,
      extension = this@AttachmentSurrogate.extension ?: listOf(),
      contentType =
        Code.of(this@AttachmentSurrogate.contentType, this@AttachmentSurrogate._contentType),
      language =
        this@AttachmentSurrogate.language?.let {
          Enumeration.of(CommonLanguages.fromCode(it), this@AttachmentSurrogate._language)
        },
      `data` = Base64Binary.of(this@AttachmentSurrogate.`data`, this@AttachmentSurrogate._data),
      url = Url.of(this@AttachmentSurrogate.url, this@AttachmentSurrogate._url),
      size = UnsignedInt.of(this@AttachmentSurrogate.size, this@AttachmentSurrogate._size),
      hash = Base64Binary.of(this@AttachmentSurrogate.hash, this@AttachmentSurrogate._hash),
      title = R4String.of(this@AttachmentSurrogate.title, this@AttachmentSurrogate._title),
      creation =
        DateTime.of(
          FhirDateTime.fromString(this@AttachmentSurrogate.creation),
          this@AttachmentSurrogate._creation,
        ),
    )

  public companion object {
    public fun fromModel(model: Attachment): AttachmentSurrogate =
      with(model) {
        AttachmentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          contentType = this@with.contentType?.value,
          _contentType = this@with.contentType?.toElement(),
          language = this@with.language?.value?.getCode(),
          _language = this@with.language?.toElement(),
          `data` = this@with.`data`?.value,
          _data = this@with.`data`?.toElement(),
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          size = this@with.size?.value,
          _size = this@with.size?.toElement(),
          hash = this@with.hash?.value,
          _hash = this@with.hash?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          creation = this@with.creation?.value?.toString(),
          _creation = this@with.creation?.toElement(),
        )
      }
  }
}
