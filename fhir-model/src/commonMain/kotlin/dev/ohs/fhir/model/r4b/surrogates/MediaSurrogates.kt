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
import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Decimal
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Instant
import com.google.fhir.model.r4b.Media
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.PositiveInt
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MediaCreatedSurrogate(
  public var createdDateTime: KotlinString? = null,
  public var _createdDateTime: Element? = null,
  public var createdPeriod: Period? = null,
) {
  public fun toModel(): Media.Created =
    Media.Created.from(
      DateTime.of(
        FhirDateTime.fromString(this@MediaCreatedSurrogate.createdDateTime),
        this@MediaCreatedSurrogate._createdDateTime,
      ),
      this@MediaCreatedSurrogate.createdPeriod,
    )!!

  public companion object {
    public fun fromModel(model: Media.Created): MediaCreatedSurrogate =
      with(model) {
        MediaCreatedSurrogate(
          createdDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _createdDateTime = this@with.asDateTime()?.value?.toElement(),
          createdPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class MediaSurrogate(
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
  public var identifier: List<Identifier>? = null,
  public var basedOn: List<Reference>? = null,
  public var partOf: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var type: CodeableConcept? = null,
  public var modality: CodeableConcept? = null,
  public var view: CodeableConcept? = null,
  public var subject: Reference? = null,
  public var encounter: Reference? = null,
  public var created: Media.Created? = null,
  public var issued: KotlinString? = null,
  public var _issued: Element? = null,
  public var `operator`: Reference? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var bodySite: CodeableConcept? = null,
  public var deviceName: KotlinString? = null,
  public var _deviceName: Element? = null,
  public var device: Reference? = null,
  public var height: Int? = null,
  public var _height: Element? = null,
  public var width: Int? = null,
  public var _width: Element? = null,
  public var frames: Int? = null,
  public var _frames: Element? = null,
  public var duration: Double? = null,
  public var _duration: Element? = null,
  public var content: Attachment,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): Media =
    Media(
      id = this@MediaSurrogate.id,
      meta = this@MediaSurrogate.meta,
      implicitRules = Uri.of(this@MediaSurrogate.implicitRules, this@MediaSurrogate._implicitRules),
      language = Code.of(this@MediaSurrogate.language, this@MediaSurrogate._language),
      text = this@MediaSurrogate.text,
      contained = this@MediaSurrogate.contained ?: listOf(),
      extension = this@MediaSurrogate.extension ?: listOf(),
      modifierExtension = this@MediaSurrogate.modifierExtension ?: listOf(),
      identifier = this@MediaSurrogate.identifier ?: listOf(),
      basedOn = this@MediaSurrogate.basedOn ?: listOf(),
      partOf = this@MediaSurrogate.partOf ?: listOf(),
      status =
        Enumeration.of(
          Media.EventStatus.fromCode(this@MediaSurrogate.status!!),
          this@MediaSurrogate._status,
        ),
      type = this@MediaSurrogate.type,
      modality = this@MediaSurrogate.modality,
      view = this@MediaSurrogate.view,
      subject = this@MediaSurrogate.subject,
      encounter = this@MediaSurrogate.encounter,
      created = this@MediaSurrogate.created,
      issued =
        Instant.of(
          FhirDateTime.fromString(this@MediaSurrogate.issued),
          this@MediaSurrogate._issued,
        ),
      `operator` = this@MediaSurrogate.`operator`,
      reasonCode = this@MediaSurrogate.reasonCode ?: listOf(),
      bodySite = this@MediaSurrogate.bodySite,
      deviceName = R4bString.of(this@MediaSurrogate.deviceName, this@MediaSurrogate._deviceName),
      device = this@MediaSurrogate.device,
      height = PositiveInt.of(this@MediaSurrogate.height, this@MediaSurrogate._height),
      width = PositiveInt.of(this@MediaSurrogate.width, this@MediaSurrogate._width),
      frames = PositiveInt.of(this@MediaSurrogate.frames, this@MediaSurrogate._frames),
      duration = Decimal.of(this@MediaSurrogate.duration, this@MediaSurrogate._duration),
      content = this@MediaSurrogate.content,
      note = this@MediaSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Media): MediaSurrogate =
      with(model) {
        MediaSurrogate(
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
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          type = this@with.type,
          modality = this@with.modality,
          view = this@with.view,
          subject = this@with.subject,
          encounter = this@with.encounter,
          created = this@with.created,
          issued = this@with.issued?.value?.toString(),
          _issued = this@with.issued?.toElement(),
          `operator` = this@with.`operator`,
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          bodySite = this@with.bodySite,
          deviceName = this@with.deviceName?.value,
          _deviceName = this@with.deviceName?.toElement(),
          device = this@with.device,
          height = this@with.height?.value,
          _height = this@with.height?.toElement(),
          width = this@with.width?.value,
          _width = this@with.width?.toElement(),
          frames = this@with.frames?.value,
          _frames = this@with.frames?.toElement(),
          duration = this@with.duration?.value?.toString()?.toDouble(),
          _duration = this@with.duration?.toElement(),
          content = this@with.content,
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
