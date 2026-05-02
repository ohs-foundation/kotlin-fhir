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
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.DeviceUsage
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class DeviceUsageAdherenceSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var reason: List<CodeableConcept>? = null,
) {
  public fun toModel(): DeviceUsage.Adherence =
    DeviceUsage.Adherence(
      id = this@DeviceUsageAdherenceSurrogate.id,
      extension = this@DeviceUsageAdherenceSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceUsageAdherenceSurrogate.modifierExtension ?: listOf(),
      code = this@DeviceUsageAdherenceSurrogate.code,
      reason = this@DeviceUsageAdherenceSurrogate.reason ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceUsage.Adherence): DeviceUsageAdherenceSurrogate =
      with(model) {
        DeviceUsageAdherenceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          reason = this@with.reason.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceUsageTimingSurrogate(
  public var timingTiming: Timing? = null,
  public var timingPeriod: Period? = null,
  public var timingDateTime: String? = null,
  public var _timingDateTime: Element? = null,
) {
  public fun toModel(): DeviceUsage.Timing =
    DeviceUsage.Timing.from(
      this@DeviceUsageTimingSurrogate.timingTiming,
      this@DeviceUsageTimingSurrogate.timingPeriod,
      DateTime.of(
        FhirDateTime.fromString(this@DeviceUsageTimingSurrogate.timingDateTime),
        this@DeviceUsageTimingSurrogate._timingDateTime,
      ),
    )!!

  public companion object {
    public fun fromModel(model: DeviceUsage.Timing): DeviceUsageTimingSurrogate =
      with(model) {
        DeviceUsageTimingSurrogate(
          timingTiming = this@with.asTiming()?.value,
          timingPeriod = this@with.asPeriod()?.value,
          timingDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _timingDateTime = this@with.asDateTime()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceUsageSurrogate(
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
  public var basedOn: List<Reference>? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var patient: Reference,
  public var derivedFrom: List<Reference>? = null,
  public var context: Reference? = null,
  public var timing: DeviceUsage.Timing? = null,
  public var dateAsserted: String? = null,
  public var _dateAsserted: Element? = null,
  public var usageStatus: CodeableConcept? = null,
  public var usageReason: List<CodeableConcept>? = null,
  public var adherence: DeviceUsage.Adherence? = null,
  public var informationSource: Reference? = null,
  public var device: CodeableReference,
  public var reason: List<CodeableReference>? = null,
  public var bodySite: CodeableReference? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): DeviceUsage =
    DeviceUsage(
      id = this@DeviceUsageSurrogate.id,
      meta = this@DeviceUsageSurrogate.meta,
      implicitRules =
        Uri.of(this@DeviceUsageSurrogate.implicitRules, this@DeviceUsageSurrogate._implicitRules),
      language = Code.of(this@DeviceUsageSurrogate.language, this@DeviceUsageSurrogate._language),
      text = this@DeviceUsageSurrogate.text,
      contained = this@DeviceUsageSurrogate.contained ?: listOf(),
      extension = this@DeviceUsageSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceUsageSurrogate.modifierExtension ?: listOf(),
      identifier = this@DeviceUsageSurrogate.identifier ?: listOf(),
      basedOn = this@DeviceUsageSurrogate.basedOn ?: listOf(),
      status =
        Enumeration.of(
          DeviceUsage.DeviceUsageStatus.fromCode(this@DeviceUsageSurrogate.status!!),
          this@DeviceUsageSurrogate._status,
        ),
      category = this@DeviceUsageSurrogate.category ?: listOf(),
      patient = this@DeviceUsageSurrogate.patient,
      derivedFrom = this@DeviceUsageSurrogate.derivedFrom ?: listOf(),
      context = this@DeviceUsageSurrogate.context,
      timing = this@DeviceUsageSurrogate.timing,
      dateAsserted =
        DateTime.of(
          FhirDateTime.fromString(this@DeviceUsageSurrogate.dateAsserted),
          this@DeviceUsageSurrogate._dateAsserted,
        ),
      usageStatus = this@DeviceUsageSurrogate.usageStatus,
      usageReason = this@DeviceUsageSurrogate.usageReason ?: listOf(),
      adherence = this@DeviceUsageSurrogate.adherence,
      informationSource = this@DeviceUsageSurrogate.informationSource,
      device = this@DeviceUsageSurrogate.device,
      reason = this@DeviceUsageSurrogate.reason ?: listOf(),
      bodySite = this@DeviceUsageSurrogate.bodySite,
      note = this@DeviceUsageSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceUsage): DeviceUsageSurrogate =
      with(model) {
        DeviceUsageSurrogate(
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          patient = this@with.patient,
          derivedFrom = this@with.derivedFrom.takeIf { it.isNotEmpty() },
          context = this@with.context,
          timing = this@with.timing,
          dateAsserted = this@with.dateAsserted?.value?.toString(),
          _dateAsserted = this@with.dateAsserted?.toElement(),
          usageStatus = this@with.usageStatus,
          usageReason = this@with.usageReason.takeIf { it.isNotEmpty() },
          adherence = this@with.adherence,
          informationSource = this@with.informationSource,
          device = this@with.device,
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          bodySite = this@with.bodySite,
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
