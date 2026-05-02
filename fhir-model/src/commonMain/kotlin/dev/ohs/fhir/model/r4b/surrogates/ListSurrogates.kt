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

import com.google.fhir.model.r4b.Annotation
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.List as R4bList
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ListEntrySurrogate(
  public var id: KotlinString? = null,
  public var extension: CollectionsList<Extension>? = null,
  public var modifierExtension: CollectionsList<Extension>? = null,
  public var flag: CodeableConcept? = null,
  public var deleted: KotlinBoolean? = null,
  public var _deleted: Element? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var item: Reference,
) {
  public fun toModel(): R4bList.Entry =
    R4bList.Entry(
      id = this@ListEntrySurrogate.id,
      extension = this@ListEntrySurrogate.extension ?: listOf(),
      modifierExtension = this@ListEntrySurrogate.modifierExtension ?: listOf(),
      flag = this@ListEntrySurrogate.flag,
      deleted = R4bBoolean.of(this@ListEntrySurrogate.deleted, this@ListEntrySurrogate._deleted),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ListEntrySurrogate.date),
          this@ListEntrySurrogate._date,
        ),
      item = this@ListEntrySurrogate.item,
    )

  public companion object {
    public fun fromModel(model: R4bList.Entry): ListEntrySurrogate =
      with(model) {
        ListEntrySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          flag = this@with.flag,
          deleted = this@with.deleted?.value,
          _deleted = this@with.deleted?.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          item = this@with.item,
        )
      }
  }
}

@Serializable
internal data class ListSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: CollectionsList<Resource>? = null,
  public var extension: CollectionsList<Extension>? = null,
  public var modifierExtension: CollectionsList<Extension>? = null,
  public var identifier: CollectionsList<Identifier>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var code: CodeableConcept? = null,
  public var subject: Reference? = null,
  public var encounter: Reference? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var source: Reference? = null,
  public var orderedBy: CodeableConcept? = null,
  public var note: CollectionsList<Annotation>? = null,
  public var entry: CollectionsList<R4bList.Entry>? = null,
  public var emptyReason: CodeableConcept? = null,
) {
  public fun toModel(): R4bList =
    R4bList(
      id = this@ListSurrogate.id,
      meta = this@ListSurrogate.meta,
      implicitRules = Uri.of(this@ListSurrogate.implicitRules, this@ListSurrogate._implicitRules),
      language = Code.of(this@ListSurrogate.language, this@ListSurrogate._language),
      text = this@ListSurrogate.text,
      contained = this@ListSurrogate.contained ?: listOf(),
      extension = this@ListSurrogate.extension ?: listOf(),
      modifierExtension = this@ListSurrogate.modifierExtension ?: listOf(),
      identifier = this@ListSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          R4bList.ListStatus.fromCode(this@ListSurrogate.status!!),
          this@ListSurrogate._status,
        ),
      mode =
        Enumeration.of(
          R4bList.ListMode.fromCode(this@ListSurrogate.mode!!),
          this@ListSurrogate._mode,
        ),
      title = R4bString.of(this@ListSurrogate.title, this@ListSurrogate._title),
      code = this@ListSurrogate.code,
      subject = this@ListSurrogate.subject,
      encounter = this@ListSurrogate.encounter,
      date =
        DateTime.of(FhirDateTime.fromString(this@ListSurrogate.date), this@ListSurrogate._date),
      source = this@ListSurrogate.source,
      orderedBy = this@ListSurrogate.orderedBy,
      note = this@ListSurrogate.note ?: listOf(),
      entry = this@ListSurrogate.entry ?: listOf(),
      emptyReason = this@ListSurrogate.emptyReason,
    )

  public companion object {
    public fun fromModel(model: R4bList): ListSurrogate =
      with(model) {
        ListSurrogate(
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          mode = this@with.mode.value?.getCode(),
          _mode = this@with.mode.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          code = this@with.code,
          subject = this@with.subject,
          encounter = this@with.encounter,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          source = this@with.source,
          orderedBy = this@with.orderedBy,
          note = this@with.note.takeIf { it.isNotEmpty() },
          entry = this@with.entry.takeIf { it.isNotEmpty() },
          emptyReason = this@with.emptyReason,
        )
      }
  }
}
