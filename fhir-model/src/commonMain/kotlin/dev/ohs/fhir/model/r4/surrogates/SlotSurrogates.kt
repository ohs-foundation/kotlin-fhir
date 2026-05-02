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

import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Instant
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.Slot
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SlotSurrogate(
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
  public var serviceCategory: List<CodeableConcept>? = null,
  public var serviceType: List<CodeableConcept>? = null,
  public var specialty: List<CodeableConcept>? = null,
  public var appointmentType: CodeableConcept? = null,
  public var schedule: Reference,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var start: KotlinString? = null,
  public var _start: Element? = null,
  public var end: KotlinString? = null,
  public var _end: Element? = null,
  public var overbooked: KotlinBoolean? = null,
  public var _overbooked: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
) {
  public fun toModel(): Slot =
    Slot(
      id = this@SlotSurrogate.id,
      meta = this@SlotSurrogate.meta,
      implicitRules = Uri.of(this@SlotSurrogate.implicitRules, this@SlotSurrogate._implicitRules),
      language = Code.of(this@SlotSurrogate.language, this@SlotSurrogate._language),
      text = this@SlotSurrogate.text,
      contained = this@SlotSurrogate.contained ?: listOf(),
      extension = this@SlotSurrogate.extension ?: listOf(),
      modifierExtension = this@SlotSurrogate.modifierExtension ?: listOf(),
      identifier = this@SlotSurrogate.identifier ?: listOf(),
      serviceCategory = this@SlotSurrogate.serviceCategory ?: listOf(),
      serviceType = this@SlotSurrogate.serviceType ?: listOf(),
      specialty = this@SlotSurrogate.specialty ?: listOf(),
      appointmentType = this@SlotSurrogate.appointmentType,
      schedule = this@SlotSurrogate.schedule,
      status =
        Enumeration.of(
          Slot.SlotStatus.fromCode(this@SlotSurrogate.status!!),
          this@SlotSurrogate._status,
        ),
      start =
        Instant.of(FhirDateTime.fromString(this@SlotSurrogate.start), this@SlotSurrogate._start)!!,
      end = Instant.of(FhirDateTime.fromString(this@SlotSurrogate.end), this@SlotSurrogate._end)!!,
      overbooked = R4Boolean.of(this@SlotSurrogate.overbooked, this@SlotSurrogate._overbooked),
      comment = R4String.of(this@SlotSurrogate.comment, this@SlotSurrogate._comment),
    )

  public companion object {
    public fun fromModel(model: Slot): SlotSurrogate =
      with(model) {
        SlotSurrogate(
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
          serviceCategory = this@with.serviceCategory.takeIf { it.isNotEmpty() },
          serviceType = this@with.serviceType.takeIf { it.isNotEmpty() },
          specialty = this@with.specialty.takeIf { it.isNotEmpty() },
          appointmentType = this@with.appointmentType,
          schedule = this@with.schedule,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          start = this@with.start.value?.toString(),
          _start = this@with.start.toElement(),
          end = this@with.end.value?.toString(),
          _end = this@with.end.toElement(),
          overbooked = this@with.overbooked?.value,
          _overbooked = this@with.overbooked?.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
        )
      }
  }
}
