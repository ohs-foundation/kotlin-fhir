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

import com.google.fhir.model.r4.Annotation
import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Instant
import com.google.fhir.model.r4.Integer
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Observation
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.Ratio
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.SampledData
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Time
import com.google.fhir.model.r4.Timing
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ObservationReferenceRangeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var low: Quantity? = null,
  public var high: Quantity? = null,
  public var type: CodeableConcept? = null,
  public var appliesTo: List<CodeableConcept>? = null,
  public var age: Range? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
) {
  public fun toModel(): Observation.ReferenceRange =
    Observation.ReferenceRange(
      id = this@ObservationReferenceRangeSurrogate.id,
      extension = this@ObservationReferenceRangeSurrogate.extension ?: listOf(),
      modifierExtension = this@ObservationReferenceRangeSurrogate.modifierExtension ?: listOf(),
      low = this@ObservationReferenceRangeSurrogate.low,
      high = this@ObservationReferenceRangeSurrogate.high,
      type = this@ObservationReferenceRangeSurrogate.type,
      appliesTo = this@ObservationReferenceRangeSurrogate.appliesTo ?: listOf(),
      age = this@ObservationReferenceRangeSurrogate.age,
      text =
        R4String.of(
          this@ObservationReferenceRangeSurrogate.text,
          this@ObservationReferenceRangeSurrogate._text,
        ),
    )

  public companion object {
    public fun fromModel(model: Observation.ReferenceRange): ObservationReferenceRangeSurrogate =
      with(model) {
        ObservationReferenceRangeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          low = this@with.low,
          high = this@with.high,
          type = this@with.type,
          appliesTo = this@with.appliesTo.takeIf { it.isNotEmpty() },
          age = this@with.age,
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ObservationComponentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var `value`: Observation.Component.Value? = null,
  public var dataAbsentReason: CodeableConcept? = null,
  public var interpretation: List<CodeableConcept>? = null,
  public var referenceRange: List<Observation.ReferenceRange>? = null,
) {
  public fun toModel(): Observation.Component =
    Observation.Component(
      id = this@ObservationComponentSurrogate.id,
      extension = this@ObservationComponentSurrogate.extension ?: listOf(),
      modifierExtension = this@ObservationComponentSurrogate.modifierExtension ?: listOf(),
      code = this@ObservationComponentSurrogate.code,
      `value` = this@ObservationComponentSurrogate.`value`,
      dataAbsentReason = this@ObservationComponentSurrogate.dataAbsentReason,
      interpretation = this@ObservationComponentSurrogate.interpretation ?: listOf(),
      referenceRange = this@ObservationComponentSurrogate.referenceRange ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Observation.Component): ObservationComponentSurrogate =
      with(model) {
        ObservationComponentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          `value` = this@with.`value`,
          dataAbsentReason = this@with.dataAbsentReason,
          interpretation = this@with.interpretation.takeIf { it.isNotEmpty() },
          referenceRange = this@with.referenceRange.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ObservationEffectiveSurrogate(
  public var effectiveDateTime: KotlinString? = null,
  public var _effectiveDateTime: Element? = null,
  public var effectivePeriod: Period? = null,
  public var effectiveTiming: Timing? = null,
  public var effectiveInstant: KotlinString? = null,
  public var _effectiveInstant: Element? = null,
) {
  public fun toModel(): Observation.Effective =
    Observation.Effective.from(
      DateTime.of(
        FhirDateTime.fromString(this@ObservationEffectiveSurrogate.effectiveDateTime),
        this@ObservationEffectiveSurrogate._effectiveDateTime,
      ),
      this@ObservationEffectiveSurrogate.effectivePeriod,
      this@ObservationEffectiveSurrogate.effectiveTiming,
      Instant.of(
        FhirDateTime.fromString(this@ObservationEffectiveSurrogate.effectiveInstant),
        this@ObservationEffectiveSurrogate._effectiveInstant,
      ),
    )!!

  public companion object {
    public fun fromModel(model: Observation.Effective): ObservationEffectiveSurrogate =
      with(model) {
        ObservationEffectiveSurrogate(
          effectiveDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _effectiveDateTime = this@with.asDateTime()?.value?.toElement(),
          effectivePeriod = this@with.asPeriod()?.value,
          effectiveTiming = this@with.asTiming()?.value,
          effectiveInstant = this@with.asInstant()?.value?.value?.toString(),
          _effectiveInstant = this@with.asInstant()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ObservationValueSurrogate(
  public var valueQuantity: Quantity? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueRange: Range? = null,
  public var valueRatio: Ratio? = null,
  public var valueSampledData: SampledData? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valuePeriod: Period? = null,
) {
  public fun toModel(): Observation.Value =
    Observation.Value.from(
      this@ObservationValueSurrogate.valueQuantity,
      this@ObservationValueSurrogate.valueCodeableConcept,
      R4String.of(
        this@ObservationValueSurrogate.valueString,
        this@ObservationValueSurrogate._valueString,
      ),
      R4Boolean.of(
        this@ObservationValueSurrogate.valueBoolean,
        this@ObservationValueSurrogate._valueBoolean,
      ),
      Integer.of(
        this@ObservationValueSurrogate.valueInteger,
        this@ObservationValueSurrogate._valueInteger,
      ),
      this@ObservationValueSurrogate.valueRange,
      this@ObservationValueSurrogate.valueRatio,
      this@ObservationValueSurrogate.valueSampledData,
      Time.of(this@ObservationValueSurrogate.valueTime, this@ObservationValueSurrogate._valueTime),
      DateTime.of(
        FhirDateTime.fromString(this@ObservationValueSurrogate.valueDateTime),
        this@ObservationValueSurrogate._valueDateTime,
      ),
      this@ObservationValueSurrogate.valuePeriod,
    )!!

  public companion object {
    public fun fromModel(model: Observation.Value): ObservationValueSurrogate =
      with(model) {
        ObservationValueSurrogate(
          valueQuantity = this@with.asQuantity()?.value,
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueRange = this@with.asRange()?.value,
          valueRatio = this@with.asRatio()?.value,
          valueSampledData = this@with.asSampledData()?.value,
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valuePeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class ObservationComponentValueSurrogate(
  public var valueQuantity: Quantity? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueRange: Range? = null,
  public var valueRatio: Ratio? = null,
  public var valueSampledData: SampledData? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valuePeriod: Period? = null,
) {
  public fun toModel(): Observation.Component.Value =
    Observation.Component.Value.from(
      this@ObservationComponentValueSurrogate.valueQuantity,
      this@ObservationComponentValueSurrogate.valueCodeableConcept,
      R4String.of(
        this@ObservationComponentValueSurrogate.valueString,
        this@ObservationComponentValueSurrogate._valueString,
      ),
      R4Boolean.of(
        this@ObservationComponentValueSurrogate.valueBoolean,
        this@ObservationComponentValueSurrogate._valueBoolean,
      ),
      Integer.of(
        this@ObservationComponentValueSurrogate.valueInteger,
        this@ObservationComponentValueSurrogate._valueInteger,
      ),
      this@ObservationComponentValueSurrogate.valueRange,
      this@ObservationComponentValueSurrogate.valueRatio,
      this@ObservationComponentValueSurrogate.valueSampledData,
      Time.of(
        this@ObservationComponentValueSurrogate.valueTime,
        this@ObservationComponentValueSurrogate._valueTime,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ObservationComponentValueSurrogate.valueDateTime),
        this@ObservationComponentValueSurrogate._valueDateTime,
      ),
      this@ObservationComponentValueSurrogate.valuePeriod,
    )!!

  public companion object {
    public fun fromModel(model: Observation.Component.Value): ObservationComponentValueSurrogate =
      with(model) {
        ObservationComponentValueSurrogate(
          valueQuantity = this@with.asQuantity()?.value,
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueRange = this@with.asRange()?.value,
          valueRatio = this@with.asRatio()?.value,
          valueSampledData = this@with.asSampledData()?.value,
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valuePeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class ObservationSurrogate(
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
  public var category: List<CodeableConcept>? = null,
  public var code: CodeableConcept,
  public var subject: Reference? = null,
  public var focus: List<Reference>? = null,
  public var encounter: Reference? = null,
  public var effective: Observation.Effective? = null,
  public var issued: KotlinString? = null,
  public var _issued: Element? = null,
  public var performer: List<Reference>? = null,
  public var `value`: Observation.Value? = null,
  public var dataAbsentReason: CodeableConcept? = null,
  public var interpretation: List<CodeableConcept>? = null,
  public var note: List<Annotation>? = null,
  public var bodySite: CodeableConcept? = null,
  public var method: CodeableConcept? = null,
  public var specimen: Reference? = null,
  public var device: Reference? = null,
  public var referenceRange: List<Observation.ReferenceRange>? = null,
  public var hasMember: List<Reference>? = null,
  public var derivedFrom: List<Reference>? = null,
  public var component: List<Observation.Component>? = null,
) {
  public fun toModel(): Observation =
    Observation(
      id = this@ObservationSurrogate.id,
      meta = this@ObservationSurrogate.meta,
      implicitRules =
        Uri.of(this@ObservationSurrogate.implicitRules, this@ObservationSurrogate._implicitRules),
      language = Code.of(this@ObservationSurrogate.language, this@ObservationSurrogate._language),
      text = this@ObservationSurrogate.text,
      contained = this@ObservationSurrogate.contained ?: listOf(),
      extension = this@ObservationSurrogate.extension ?: listOf(),
      modifierExtension = this@ObservationSurrogate.modifierExtension ?: listOf(),
      identifier = this@ObservationSurrogate.identifier ?: listOf(),
      basedOn = this@ObservationSurrogate.basedOn ?: listOf(),
      partOf = this@ObservationSurrogate.partOf ?: listOf(),
      status =
        Enumeration.of(
          Observation.ObservationStatus.fromCode(this@ObservationSurrogate.status!!),
          this@ObservationSurrogate._status,
        ),
      category = this@ObservationSurrogate.category ?: listOf(),
      code = this@ObservationSurrogate.code,
      subject = this@ObservationSurrogate.subject,
      focus = this@ObservationSurrogate.focus ?: listOf(),
      encounter = this@ObservationSurrogate.encounter,
      effective = this@ObservationSurrogate.effective,
      issued =
        Instant.of(
          FhirDateTime.fromString(this@ObservationSurrogate.issued),
          this@ObservationSurrogate._issued,
        ),
      performer = this@ObservationSurrogate.performer ?: listOf(),
      `value` = this@ObservationSurrogate.`value`,
      dataAbsentReason = this@ObservationSurrogate.dataAbsentReason,
      interpretation = this@ObservationSurrogate.interpretation ?: listOf(),
      note = this@ObservationSurrogate.note ?: listOf(),
      bodySite = this@ObservationSurrogate.bodySite,
      method = this@ObservationSurrogate.method,
      specimen = this@ObservationSurrogate.specimen,
      device = this@ObservationSurrogate.device,
      referenceRange = this@ObservationSurrogate.referenceRange ?: listOf(),
      hasMember = this@ObservationSurrogate.hasMember ?: listOf(),
      derivedFrom = this@ObservationSurrogate.derivedFrom ?: listOf(),
      component = this@ObservationSurrogate.component ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Observation): ObservationSurrogate =
      with(model) {
        ObservationSurrogate(
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
          category = this@with.category.takeIf { it.isNotEmpty() },
          code = this@with.code,
          subject = this@with.subject,
          focus = this@with.focus.takeIf { it.isNotEmpty() },
          encounter = this@with.encounter,
          effective = this@with.effective,
          issued = this@with.issued?.value?.toString(),
          _issued = this@with.issued?.toElement(),
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
          dataAbsentReason = this@with.dataAbsentReason,
          interpretation = this@with.interpretation.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          bodySite = this@with.bodySite,
          method = this@with.method,
          specimen = this@with.specimen,
          device = this@with.device,
          referenceRange = this@with.referenceRange.takeIf { it.isNotEmpty() },
          hasMember = this@with.hasMember.takeIf { it.isNotEmpty() },
          derivedFrom = this@with.derivedFrom.takeIf { it.isNotEmpty() },
          component = this@with.component.takeIf { it.isNotEmpty() },
        )
      }
  }
}
