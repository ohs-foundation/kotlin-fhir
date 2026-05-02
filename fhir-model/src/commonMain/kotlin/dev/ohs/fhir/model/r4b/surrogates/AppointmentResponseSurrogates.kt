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

import com.google.fhir.model.r4b.AppointmentResponse
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Instant
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
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
internal data class AppointmentResponseSurrogate(
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
  public var appointment: Reference,
  public var start: KotlinString? = null,
  public var _start: Element? = null,
  public var end: KotlinString? = null,
  public var _end: Element? = null,
  public var participantType: List<CodeableConcept>? = null,
  public var actor: Reference? = null,
  public var participantStatus: KotlinString? = null,
  public var _participantStatus: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
) {
  public fun toModel(): AppointmentResponse =
    AppointmentResponse(
      id = this@AppointmentResponseSurrogate.id,
      meta = this@AppointmentResponseSurrogate.meta,
      implicitRules =
        Uri.of(
          this@AppointmentResponseSurrogate.implicitRules,
          this@AppointmentResponseSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@AppointmentResponseSurrogate.language,
          this@AppointmentResponseSurrogate._language,
        ),
      text = this@AppointmentResponseSurrogate.text,
      contained = this@AppointmentResponseSurrogate.contained ?: listOf(),
      extension = this@AppointmentResponseSurrogate.extension ?: listOf(),
      modifierExtension = this@AppointmentResponseSurrogate.modifierExtension ?: listOf(),
      identifier = this@AppointmentResponseSurrogate.identifier ?: listOf(),
      appointment = this@AppointmentResponseSurrogate.appointment,
      start =
        Instant.of(
          FhirDateTime.fromString(this@AppointmentResponseSurrogate.start),
          this@AppointmentResponseSurrogate._start,
        ),
      end =
        Instant.of(
          FhirDateTime.fromString(this@AppointmentResponseSurrogate.end),
          this@AppointmentResponseSurrogate._end,
        ),
      participantType = this@AppointmentResponseSurrogate.participantType ?: listOf(),
      actor = this@AppointmentResponseSurrogate.actor,
      participantStatus =
        Enumeration.of(
          AppointmentResponse.ParticipationStatus.fromCode(
            this@AppointmentResponseSurrogate.participantStatus!!
          ),
          this@AppointmentResponseSurrogate._participantStatus,
        ),
      comment =
        R4bString.of(
          this@AppointmentResponseSurrogate.comment,
          this@AppointmentResponseSurrogate._comment,
        ),
    )

  public companion object {
    public fun fromModel(model: AppointmentResponse): AppointmentResponseSurrogate =
      with(model) {
        AppointmentResponseSurrogate(
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
          appointment = this@with.appointment,
          start = this@with.start?.value?.toString(),
          _start = this@with.start?.toElement(),
          end = this@with.end?.value?.toString(),
          _end = this@with.end?.toElement(),
          participantType = this@with.participantType.takeIf { it.isNotEmpty() },
          actor = this@with.actor,
          participantStatus = this@with.participantStatus.value?.getCode(),
          _participantStatus = this@with.participantStatus.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
        )
      }
  }
}
