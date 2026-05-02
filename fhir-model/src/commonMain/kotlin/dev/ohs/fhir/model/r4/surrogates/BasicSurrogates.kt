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

import com.google.fhir.model.r4.Basic
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDate
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class BasicSurrogate(
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
  public var code: CodeableConcept,
  public var subject: Reference? = null,
  public var created: String? = null,
  public var _created: Element? = null,
  public var author: Reference? = null,
) {
  public fun toModel(): Basic =
    Basic(
      id = this@BasicSurrogate.id,
      meta = this@BasicSurrogate.meta,
      implicitRules = Uri.of(this@BasicSurrogate.implicitRules, this@BasicSurrogate._implicitRules),
      language = Code.of(this@BasicSurrogate.language, this@BasicSurrogate._language),
      text = this@BasicSurrogate.text,
      contained = this@BasicSurrogate.contained ?: listOf(),
      extension = this@BasicSurrogate.extension ?: listOf(),
      modifierExtension = this@BasicSurrogate.modifierExtension ?: listOf(),
      identifier = this@BasicSurrogate.identifier ?: listOf(),
      code = this@BasicSurrogate.code,
      subject = this@BasicSurrogate.subject,
      created =
        Date.of(FhirDate.fromString(this@BasicSurrogate.created), this@BasicSurrogate._created),
      author = this@BasicSurrogate.author,
    )

  public companion object {
    public fun fromModel(model: Basic): BasicSurrogate =
      with(model) {
        BasicSurrogate(
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
          subject = this@with.subject,
          created = this@with.created?.value?.toString(),
          _created = this@with.created?.toElement(),
          author = this@with.author,
        )
      }
  }
}
