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

import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Composition
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
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
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
  public var time: KotlinString? = null,
  public var _time: Element? = null,
  public var party: Reference? = null,
) {
  public fun toModel(): Composition.Attester =
    Composition.Attester(
      id = this@CompositionAttesterSurrogate.id,
      extension = this@CompositionAttesterSurrogate.extension ?: listOf(),
      modifierExtension = this@CompositionAttesterSurrogate.modifierExtension ?: listOf(),
      mode =
        Enumeration.of(
          Composition.CompositionAttestationMode.fromCode(this@CompositionAttesterSurrogate.mode!!),
          this@CompositionAttesterSurrogate._mode,
        ),
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
          mode = this@with.mode.value?.getCode(),
          _mode = this@with.mode.toElement(),
          time = this@with.time?.value?.toString(),
          _time = this@with.time?.toElement(),
          party = this@with.party,
        )
      }
  }
}

@Serializable
internal data class CompositionRelatesToSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var target: Composition.RelatesTo.Target,
) {
  public fun toModel(): Composition.RelatesTo =
    Composition.RelatesTo(
      id = this@CompositionRelatesToSurrogate.id,
      extension = this@CompositionRelatesToSurrogate.extension ?: listOf(),
      modifierExtension = this@CompositionRelatesToSurrogate.modifierExtension ?: listOf(),
      code =
        Enumeration.of(
          Composition.DocumentRelationshipType.fromCode(this@CompositionRelatesToSurrogate.code!!),
          this@CompositionRelatesToSurrogate._code,
        ),
      target = this@CompositionRelatesToSurrogate.target,
    )

  public companion object {
    public fun fromModel(model: Composition.RelatesTo): CompositionRelatesToSurrogate =
      with(model) {
        CompositionRelatesToSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          target = this@with.target,
        )
      }
  }
}

@Serializable
internal data class CompositionEventSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: List<CodeableConcept>? = null,
  public var period: Period? = null,
  public var detail: List<Reference>? = null,
) {
  public fun toModel(): Composition.Event =
    Composition.Event(
      id = this@CompositionEventSurrogate.id,
      extension = this@CompositionEventSurrogate.extension ?: listOf(),
      modifierExtension = this@CompositionEventSurrogate.modifierExtension ?: listOf(),
      code = this@CompositionEventSurrogate.code ?: listOf(),
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
          code = this@with.code.takeIf { it.isNotEmpty() },
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
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
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
        R4bString.of(
          this@CompositionSectionSurrogate.title,
          this@CompositionSectionSurrogate._title,
        ),
      code = this@CompositionSectionSurrogate.code,
      author = this@CompositionSectionSurrogate.author ?: listOf(),
      focus = this@CompositionSectionSurrogate.focus,
      text = this@CompositionSectionSurrogate.text,
      mode =
        this@CompositionSectionSurrogate.mode?.let {
          Enumeration.of(Composition.ListMode.fromCode(it), this@CompositionSectionSurrogate._mode)
        },
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
          mode = this@with.mode?.value?.getCode(),
          _mode = this@with.mode?.toElement(),
          orderedBy = this@with.orderedBy,
          entry = this@with.entry.takeIf { it.isNotEmpty() },
          emptyReason = this@with.emptyReason,
          section = this@with.section.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CompositionRelatesToTargetSurrogate(
  public var targetIdentifier: Identifier? = null,
  public var targetReference: Reference? = null,
) {
  public fun toModel(): Composition.RelatesTo.Target =
    Composition.RelatesTo.Target.from(
      this@CompositionRelatesToTargetSurrogate.targetIdentifier,
      this@CompositionRelatesToTargetSurrogate.targetReference,
    )!!

  public companion object {
    public fun fromModel(model: Composition.RelatesTo.Target): CompositionRelatesToTargetSurrogate =
      with(model) {
        CompositionRelatesToTargetSurrogate(
          targetIdentifier = this@with.asIdentifier()?.value,
          targetReference = this@with.asReference()?.value,
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
  public var identifier: Identifier? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var type: CodeableConcept,
  public var category: List<CodeableConcept>? = null,
  public var subject: Reference? = null,
  public var encounter: Reference? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var author: List<Reference>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var confidentiality: KotlinString? = null,
  public var _confidentiality: Element? = null,
  public var attester: List<Composition.Attester>? = null,
  public var custodian: Reference? = null,
  public var relatesTo: List<Composition.RelatesTo>? = null,
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
      identifier = this@CompositionSurrogate.identifier,
      status =
        Enumeration.of(
          Composition.CompositionStatus.fromCode(this@CompositionSurrogate.status!!),
          this@CompositionSurrogate._status,
        ),
      type = this@CompositionSurrogate.type,
      category = this@CompositionSurrogate.category ?: listOf(),
      subject = this@CompositionSurrogate.subject,
      encounter = this@CompositionSurrogate.encounter,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@CompositionSurrogate.date),
          this@CompositionSurrogate._date,
        )!!,
      author = this@CompositionSurrogate.author ?: listOf(),
      title = R4bString.of(this@CompositionSurrogate.title, this@CompositionSurrogate._title)!!,
      confidentiality =
        this@CompositionSurrogate.confidentiality?.let {
          Enumeration.of(
            Composition.Confidentiality.fromCode(it),
            this@CompositionSurrogate._confidentiality,
          )
        },
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
          identifier = this@with.identifier,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          type = this@with.type,
          category = this@with.category.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          encounter = this@with.encounter,
          date = this@with.date.value?.toString(),
          _date = this@with.date.toElement(),
          author = this@with.author.takeIf { it.isNotEmpty() },
          title = this@with.title.value,
          _title = this@with.title.toElement(),
          confidentiality = this@with.confidentiality?.value?.getCode(),
          _confidentiality = this@with.confidentiality?.toElement(),
          attester = this@with.attester.takeIf { it.isNotEmpty() },
          custodian = this@with.custodian,
          relatesTo = this@with.relatesTo.takeIf { it.isNotEmpty() },
          event = this@with.event.takeIf { it.isNotEmpty() },
          section = this@with.section.takeIf { it.isNotEmpty() },
        )
      }
  }
}
