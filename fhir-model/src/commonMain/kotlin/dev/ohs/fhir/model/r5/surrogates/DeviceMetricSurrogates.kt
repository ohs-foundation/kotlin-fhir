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
import com.google.fhir.model.r5.DeviceMetric
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Instant
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
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
internal data class DeviceMetricCalibrationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: String? = null,
  public var _type: Element? = null,
  public var state: String? = null,
  public var _state: Element? = null,
  public var time: String? = null,
  public var _time: Element? = null,
) {
  public fun toModel(): DeviceMetric.Calibration =
    DeviceMetric.Calibration(
      id = this@DeviceMetricCalibrationSurrogate.id,
      extension = this@DeviceMetricCalibrationSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceMetricCalibrationSurrogate.modifierExtension ?: listOf(),
      type =
        this@DeviceMetricCalibrationSurrogate.type?.let {
          Enumeration.of(
            DeviceMetric.DeviceMetricCalibrationType.fromCode(it),
            this@DeviceMetricCalibrationSurrogate._type,
          )
        },
      state =
        this@DeviceMetricCalibrationSurrogate.state?.let {
          Enumeration.of(
            DeviceMetric.DeviceMetricCalibrationState.fromCode(it),
            this@DeviceMetricCalibrationSurrogate._state,
          )
        },
      time =
        Instant.of(
          FhirDateTime.fromString(this@DeviceMetricCalibrationSurrogate.time),
          this@DeviceMetricCalibrationSurrogate._time,
        ),
    )

  public companion object {
    public fun fromModel(model: DeviceMetric.Calibration): DeviceMetricCalibrationSurrogate =
      with(model) {
        DeviceMetricCalibrationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type?.value?.getCode(),
          _type = this@with.type?.toElement(),
          state = this@with.state?.value?.getCode(),
          _state = this@with.state?.toElement(),
          time = this@with.time?.value?.toString(),
          _time = this@with.time?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceMetricSurrogate(
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
  public var type: CodeableConcept,
  public var unit: CodeableConcept? = null,
  public var device: Reference,
  public var operationalStatus: String? = null,
  public var _operationalStatus: Element? = null,
  public var color: String? = null,
  public var _color: Element? = null,
  public var category: String? = null,
  public var _category: Element? = null,
  public var measurementFrequency: Quantity? = null,
  public var calibration: List<DeviceMetric.Calibration>? = null,
) {
  public fun toModel(): DeviceMetric =
    DeviceMetric(
      id = this@DeviceMetricSurrogate.id,
      meta = this@DeviceMetricSurrogate.meta,
      implicitRules =
        Uri.of(this@DeviceMetricSurrogate.implicitRules, this@DeviceMetricSurrogate._implicitRules),
      language = Code.of(this@DeviceMetricSurrogate.language, this@DeviceMetricSurrogate._language),
      text = this@DeviceMetricSurrogate.text,
      contained = this@DeviceMetricSurrogate.contained ?: listOf(),
      extension = this@DeviceMetricSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceMetricSurrogate.modifierExtension ?: listOf(),
      identifier = this@DeviceMetricSurrogate.identifier ?: listOf(),
      type = this@DeviceMetricSurrogate.type,
      unit = this@DeviceMetricSurrogate.unit,
      device = this@DeviceMetricSurrogate.device,
      operationalStatus =
        this@DeviceMetricSurrogate.operationalStatus?.let {
          Enumeration.of(
            DeviceMetric.DeviceMetricOperationalStatus.fromCode(it),
            this@DeviceMetricSurrogate._operationalStatus,
          )
        },
      color = Code.of(this@DeviceMetricSurrogate.color, this@DeviceMetricSurrogate._color),
      category =
        Enumeration.of(
          DeviceMetric.DeviceMetricCategory.fromCode(this@DeviceMetricSurrogate.category!!),
          this@DeviceMetricSurrogate._category,
        ),
      measurementFrequency = this@DeviceMetricSurrogate.measurementFrequency,
      calibration = this@DeviceMetricSurrogate.calibration ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceMetric): DeviceMetricSurrogate =
      with(model) {
        DeviceMetricSurrogate(
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
          type = this@with.type,
          unit = this@with.unit,
          device = this@with.device,
          operationalStatus = this@with.operationalStatus?.value?.getCode(),
          _operationalStatus = this@with.operationalStatus?.toElement(),
          color = this@with.color?.value,
          _color = this@with.color?.toElement(),
          category = this@with.category.value?.getCode(),
          _category = this@with.category.toElement(),
          measurementFrequency = this@with.measurementFrequency,
          calibration = this@with.calibration.takeIf { it.isNotEmpty() },
        )
      }
  }
}
