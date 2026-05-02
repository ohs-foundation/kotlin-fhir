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

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Composition
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CompositionAttesterSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var mode: CodeableConcept,
  public var time: KotlinString? = null,
  public var _time: Element? = null,
  public var party: Reference? = null,
) {
  public fun toModel(): Composition.Attester =
    Composition.Attester(
      id = this@CompositionAttesterSurrogate.id,
      extension = this@CompositionAttesterSurrogate.extension ?: listOf(),
      modifierExtension = this@CompositionAttesterSurrogate.modifierExtension ?: listOf(),
      mode = this@CompositionAttesterSurrogate.mode,
      time =
        DateTime.of(
          FhirDateTime.fromString(this@CompositionAttesterSurrogate.time),
          this@CompositionAttesterSurrogate._time,
        ),
      party = this@CompositionAttesterSurrogate.party,
    )

  public companion object {
    public fun fromModel(model: Composition.Attester): CompositionAttesterSurrogate =
      with(model) {
        CompositionAttesterSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          mode = this@with.mode,
          time = this@with.time?.value?.toString(),
          _time = this@with.time?.toElement(),
          party = this@with.party,
        )
      }
  }
}

@Serializable
internal data class CompositionEventSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var period: Period? = null,
  public var detail: List<CodeableReference>? = null,
) {
  public fun toModel(): Composition.Event =
    Composition.Event(
      id = this@CompositionEventSurrogate.id,
      extension = this@CompositionEventSurrogate.extension ?: listOf(),
      modifierExtension = this@CompositionEventSurrogate.modifierExtension ?: listOf(),
      period = this@CompositionEventSurrogate.period,
      detail = this@CompositionEventSurrogate.detail ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Composition.Event): CompositionEventSurrogate =
      with(model) {
        CompositionEventSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          period = this@with.period,
          detail = this@with.detail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CompositionSectionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var code: CodeableConcept? = null,
  public var author: List<Reference>? = null,
  public var focus: Reference? = null,
  public var text: Narrative? = null,
  public var orderedBy: CodeableConcept? = null,
  public var entry: List<Reference>? = null,
  public var emptyReason: CodeableConcept? = null,
  public var section: List<Composition.Section>? = null,
) {
  public fun toModel(): Composition.Section =
    Composition.Section(
      id = this@CompositionSectionSurrogate.id,
      extension = this@CompositionSectionSurrogate.extension ?: listOf(),
      modifierExtension = this@CompositionSectionSurrogate.modifierExtension ?: listOf(),
      title =
        R5String.of(
          this@CompositionSectionSurrogate.title,
          this@CompositionSectionSurrogate._title,
        ),
      code = this@CompositionSectionSurrogate.code,
      author = this@CompositionSectionSurrogate.author ?: listOf(),
      focus = this@CompositionSectionSurrogate.focus,
      text = this@CompositionSectionSurrogate.text,
      orderedBy = this@CompositionSectionSurrogate.orderedBy,
      entry = this@CompositionSectionSurrogate.entry ?: listOf(),
      emptyReason = this@CompositionSectionSurrogate.emptyReason,
      section = this@CompositionSectionSurrogate.section ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Composition.Section): CompositionSectionSurrogate =
      with(model) {
        CompositionSectionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          code = this@with.code,
          author = this@with.author.takeIf { it.isNotEmpty() },
          focus = this@with.focus,
          text = this@with.text,
          orderedBy = this@with.orderedBy,
          entry = this@with.entry.takeIf { it.isNotEmpty() },
          emptyReason = this@with.emptyReason,
          section = this@with.section.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CompositionSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var type: CodeableConcept,
  public var category: List<CodeableConcept>? = null,
  public var subject: List<Reference>? = null,
  public var encounter: Reference? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var author: List<Reference>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var note: List<Annotation>? = null,
  public var attester: List<Composition.Attester>? = null,
  public var custodian: Reference? = null,
  public var relatesTo: List<RelatedArtifact>? = null,
  public var event: List<Composition.Event>? = null,
  public var section: List<Composition.Section>? = null,
) {
  public fun toModel(): Composition =
    Composition(
      id = this@CompositionSurrogate.id,
      meta = this@CompositionSurrogate.meta,
      implicitRules =
        Uri.of(this@CompositionSurrogate.implicitRules, this@CompositionSurrogate._implicitRules),
      language = Code.of(this@CompositionSurrogate.language, this@CompositionSurrogate._language),
      text = this@CompositionSurrogate.text,
      contained = this@CompositionSurrogate.contained ?: listOf(),
      extension = this@CompositionSurrogate.extension ?: listOf(),
      modifierExtension = this@CompositionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@CompositionSurrogate.url, this@CompositionSurrogate._url),
      identifier = this@CompositionSurrogate.identifier ?: listOf(),
      version = R5String.of(this@CompositionSurrogate.version, this@CompositionSurrogate._version),
      status =
        Enumeration.of(
          Composition.CompositionStatus.fromCode(this@CompositionSurrogate.status!!),
          this@CompositionSurrogate._status,
        ),
      type = this@CompositionSurrogate.type,
      category = this@CompositionSurrogate.category ?: listOf(),
      subject = this@CompositionSurrogate.subject ?: listOf(),
      encounter = this@CompositionSurrogate.encounter,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@CompositionSurrogate.date),
          this@CompositionSurrogate._date,
        )!!,
      useContext = this@CompositionSurrogate.useContext ?: listOf(),
      author = this@CompositionSurrogate.author ?: listOf(),
      name = R5String.of(this@CompositionSurrogate.name, this@CompositionSurrogate._name),
      title = R5String.of(this@CompositionSurrogate.title, this@CompositionSurrogate._title)!!,
      note = this@CompositionSurrogate.note ?: listOf(),
      attester = this@CompositionSurrogate.attester ?: listOf(),
      custodian = this@CompositionSurrogate.custodian,
      relatesTo = this@CompositionSurrogate.relatesTo ?: listOf(),
      event = this@CompositionSurrogate.event ?: listOf(),
      section = this@CompositionSurrogate.section ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Composition): CompositionSurrogate =
      with(model) {
        CompositionSurrogate(
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
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          type = this@with.type,
          category = this@with.category.takeIf { it.isNotEmpty() },
          subject = this@with.subject.takeIf { it.isNotEmpty() },
          encounter = this@with.encounter,
          date = this@with.date.value?.toString(),
          _date = this@with.date.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          author = this@with.author.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title.value,
          _title = this@with.title.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          attester = this@with.attester.takeIf { it.isNotEmpty() },
          custodian = this@with.custodian,
          relatesTo = this@with.relatesTo.takeIf { it.isNotEmpty() },
          event = this@with.event.takeIf { it.isNotEmpty() },
          section = this@with.section.takeIf { it.isNotEmpty() },
        )
      }
  }
}
