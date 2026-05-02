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

import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FormularyItem
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class FormularyItemSurrogate(
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
  public var identifier: List<Identifier>? = null,
  public var code: CodeableConcept? = null,
  public var status: String? = null,
  public var _status: Element? = null,
) {
  public fun toModel(): FormularyItem =
    FormularyItem(
      id = this@FormularyItemSurrogate.id,
      meta = this@FormularyItemSurrogate.meta,
      implicitRules =
        Uri.of(
          this@FormularyItemSurrogate.implicitRules,
          this@FormularyItemSurrogate._implicitRules,
        ),
      language =
        Code.of(this@FormularyItemSurrogate.language, this@FormularyItemSurrogate._language),
      text = this@FormularyItemSurrogate.text,
      contained = this@FormularyItemSurrogate.contained ?: listOf(),
      extension = this@FormularyItemSurrogate.extension ?: listOf(),
      modifierExtension = this@FormularyItemSurrogate.modifierExtension ?: listOf(),
      identifier = this@FormularyItemSurrogate.identifier ?: listOf(),
      code = this@FormularyItemSurrogate.code,
      status =
        this@FormularyItemSurrogate.status?.let {
          Enumeration.of(
            FormularyItem.FormularyItemStatusCodes.fromCode(it),
            this@FormularyItemSurrogate._status,
          )
        },
    )

  public companion object {
    public fun fromModel(model: FormularyItem): FormularyItemSurrogate =
      with(model) {
        FormularyItemSurrogate(
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
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          code = this@with.code,
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
        )
      }
  }
}
