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

import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Linkage
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class LinkageItemSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: String? = null,
  public var _type: Element? = null,
  public var resource: Reference,
) {
  public fun toModel(): Linkage.Item =
    Linkage.Item(
      id = this@LinkageItemSurrogate.id,
      extension = this@LinkageItemSurrogate.extension ?: listOf(),
      modifierExtension = this@LinkageItemSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          Linkage.LinkageType.fromCode(this@LinkageItemSurrogate.type!!),
          this@LinkageItemSurrogate._type,
        ),
      resource = this@LinkageItemSurrogate.resource,
    )

  public companion object {
    public fun fromModel(model: Linkage.Item): LinkageItemSurrogate =
      with(model) {
        LinkageItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          resource = this@with.resource,
        )
      }
  }
}

@Serializable
internal data class LinkageSurrogate(
  public var id: String? = null,
  public var meta: Meta? = null,
  public var implicitRules: String? = null,
  public var _implicitRules: Element? = null,
  public var language: String? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var active: KotlinBoolean? = null,
  public var _active: Element? = null,
  public var author: Reference? = null,
  public var item: List<Linkage.Item>? = null,
) {
  public fun toModel(): Linkage =
    Linkage(
      id = this@LinkageSurrogate.id,
      meta = this@LinkageSurrogate.meta,
      implicitRules =
        Uri.of(this@LinkageSurrogate.implicitRules, this@LinkageSurrogate._implicitRules),
      language = Code.of(this@LinkageSurrogate.language, this@LinkageSurrogate._language),
      text = this@LinkageSurrogate.text,
      contained = this@LinkageSurrogate.contained ?: listOf(),
      extension = this@LinkageSurrogate.extension ?: listOf(),
      modifierExtension = this@LinkageSurrogate.modifierExtension ?: listOf(),
      active = R5Boolean.of(this@LinkageSurrogate.active, this@LinkageSurrogate._active),
      author = this@LinkageSurrogate.author,
      item = this@LinkageSurrogate.item ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Linkage): LinkageSurrogate =
      with(model) {
        LinkageSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          active = this@with.active?.value,
          _active = this@with.active?.toElement(),
          author = this@with.author,
          item = this@with.item.takeIf { it.isNotEmpty() },
        )
      }
  }
}
