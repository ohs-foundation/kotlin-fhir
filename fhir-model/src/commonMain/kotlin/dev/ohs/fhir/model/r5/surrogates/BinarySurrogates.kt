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

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.Base64Binary
import com.google.fhir.model.r4b.Binary
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class BinarySurrogate(
  public var id: String? = null,
  public var meta: Meta? = null,
  public var implicitRules: String? = null,
  public var _implicitRules: Element? = null,
  public var language: String? = null,
  public var _language: Element? = null,
  public var contentType: String? = null,
  public var _contentType: Element? = null,
  public var securityContext: Reference? = null,
  public var `data`: String? = null,
  public var _data: Element? = null,
) {
  public fun toModel(): Binary =
    Binary(
      id = this@BinarySurrogate.id,
      meta = this@BinarySurrogate.meta,
      implicitRules =
        Uri.of(this@BinarySurrogate.implicitRules, this@BinarySurrogate._implicitRules),
      language = Code.of(this@BinarySurrogate.language, this@BinarySurrogate._language),
      contentType = Code.of(this@BinarySurrogate.contentType, this@BinarySurrogate._contentType)!!,
      securityContext = this@BinarySurrogate.securityContext,
      `data` = Base64Binary.of(this@BinarySurrogate.`data`, this@BinarySurrogate._data),
    )

  public companion object {
    public fun fromModel(model: Binary): BinarySurrogate =
      with(model) {
        BinarySurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          contentType = this@with.contentType.value,
          _contentType = this@with.contentType.toElement(),
          securityContext = this@with.securityContext,
          `data` = this@with.`data`?.value,
          _data = this@with.`data`?.toElement(),
        )
      }
  }
}
