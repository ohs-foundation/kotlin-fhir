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

import com.google.fhir.model.r5.AppointmentResponse
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Instant
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class AppointmentResponseSurrogate(
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
  public var appointment: Reference,
  public var proposedNewTime: KotlinBoolean? = null,
  public var _proposedNewTime: Element? = null,
  public var start: String? = null,
  public var _start: Element? = null,
  public var end: String? = null,
  public var _end: Element? = null,
  public var participantType: List<CodeableConcept>? = null,
  public var actor: Reference? = null,
  public var participantStatus: String? = null,
  public var _participantStatus: Element? = null,
  public var comment: String? = null,
  public var _comment: Element? = null,
  public var recurring: KotlinBoolean? = null,
  public var _recurring: Element? = null,
  public var occurrenceDate: String? = null,
  public var _occurrenceDate: Element? = null,
  public var recurrenceId: Int? = null,
  public var _recurrenceId: Element? = null,
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
      proposedNewTime =
        R5Boolean.of(
          this@AppointmentResponseSurrogate.proposedNewTime,
          this@AppointmentResponseSurrogate._proposedNewTime,
        ),
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
          AppointmentResponse.AppointmentResponseStatus.fromCode(
            this@AppointmentResponseSurrogate.participantStatus!!
          ),
          this@AppointmentResponseSurrogate._participantStatus,
        ),
      comment =
        Markdown.of(
          this@AppointmentResponseSurrogate.comment,
          this@AppointmentResponseSurrogate._comment,
        ),
      recurring =
        R5Boolean.of(
          this@AppointmentResponseSurrogate.recurring,
          this@AppointmentResponseSurrogate._recurring,
        ),
      occurrenceDate =
        Date.of(
          FhirDate.fromString(this@AppointmentResponseSurrogate.occurrenceDate),
          this@AppointmentResponseSurrogate._occurrenceDate,
        ),
      recurrenceId =
        PositiveInt.of(
          this@AppointmentResponseSurrogate.recurrenceId,
          this@AppointmentResponseSurrogate._recurrenceId,
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
          proposedNewTime = this@with.proposedNewTime?.value,
          _proposedNewTime = this@with.proposedNewTime?.toElement(),
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
          recurring = this@with.recurring?.value,
          _recurring = this@with.recurring?.toElement(),
          occurrenceDate = this@with.occurrenceDate?.value?.toString(),
          _occurrenceDate = this@with.occurrenceDate?.toElement(),
          recurrenceId = this@with.recurrenceId?.value,
          _recurrenceId = this@with.recurrenceId?.toElement(),
        )
      }
  }
}
