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

import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Dosage
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Ratio
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class DosageDoseAndRateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var dose: Dosage.DoseAndRate.Dose? = null,
  public var rate: Dosage.DoseAndRate.Rate? = null,
) {
  public fun toModel(): Dosage.DoseAndRate =
    Dosage.DoseAndRate(
      id = this@DosageDoseAndRateSurrogate.id,
      extension = this@DosageDoseAndRateSurrogate.extension ?: listOf(),
      type = this@DosageDoseAndRateSurrogate.type,
      dose = this@DosageDoseAndRateSurrogate.dose,
      rate = this@DosageDoseAndRateSurrogate.rate,
    )

  public companion object {
    public fun fromModel(model: Dosage.DoseAndRate): DosageDoseAndRateSurrogate =
      with(model) {
        DosageDoseAndRateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          dose = this@with.dose,
          rate = this@with.rate,
        )
      }
  }
}

@Serializable
internal data class DosageDoseAndRateDoseSurrogate(
  public var doseRange: Range? = null,
  public var doseQuantity: Quantity? = null,
) {
  public fun toModel(): Dosage.DoseAndRate.Dose =
    Dosage.DoseAndRate.Dose.from(
      this@DosageDoseAndRateDoseSurrogate.doseRange,
      this@DosageDoseAndRateDoseSurrogate.doseQuantity,
    )!!

  public companion object {
    public fun fromModel(model: Dosage.DoseAndRate.Dose): DosageDoseAndRateDoseSurrogate =
      with(model) {
        DosageDoseAndRateDoseSurrogate(
          doseRange = this@with.asRange()?.value,
          doseQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class DosageDoseAndRateRateSurrogate(
  public var rateRatio: Ratio? = null,
  public var rateRange: Range? = null,
  public var rateQuantity: Quantity? = null,
) {
  public fun toModel(): Dosage.DoseAndRate.Rate =
    Dosage.DoseAndRate.Rate.from(
      this@DosageDoseAndRateRateSurrogate.rateRatio,
      this@DosageDoseAndRateRateSurrogate.rateRange,
      this@DosageDoseAndRateRateSurrogate.rateQuantity,
    )!!

  public companion object {
    public fun fromModel(model: Dosage.DoseAndRate.Rate): DosageDoseAndRateRateSurrogate =
      with(model) {
        DosageDoseAndRateRateSurrogate(
          rateRatio = this@with.asRatio()?.value,
          rateRange = this@with.asRange()?.value,
          rateQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class DosageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var additionalInstruction: List<CodeableConcept>? = null,
  public var patientInstruction: KotlinString? = null,
  public var _patientInstruction: Element? = null,
  public var timing: Timing? = null,
  public var asNeeded: KotlinBoolean? = null,
  public var _asNeeded: Element? = null,
  public var asNeededFor: List<CodeableConcept>? = null,
  public var site: CodeableConcept? = null,
  public var route: CodeableConcept? = null,
  public var method: CodeableConcept? = null,
  public var doseAndRate: List<Dosage.DoseAndRate>? = null,
  public var maxDosePerPeriod: List<Ratio>? = null,
  public var maxDosePerAdministration: Quantity? = null,
  public var maxDosePerLifetime: Quantity? = null,
) {
  public fun toModel(): Dosage =
    Dosage(
      id = this@DosageSurrogate.id,
      extension = this@DosageSurrogate.extension ?: listOf(),
      modifierExtension = this@DosageSurrogate.modifierExtension ?: listOf(),
      sequence = Integer.of(this@DosageSurrogate.sequence, this@DosageSurrogate._sequence),
      text = R5String.of(this@DosageSurrogate.text, this@DosageSurrogate._text),
      additionalInstruction = this@DosageSurrogate.additionalInstruction ?: listOf(),
      patientInstruction =
        R5String.of(
          this@DosageSurrogate.patientInstruction,
          this@DosageSurrogate._patientInstruction,
        ),
      timing = this@DosageSurrogate.timing,
      asNeeded = R5Boolean.of(this@DosageSurrogate.asNeeded, this@DosageSurrogate._asNeeded),
      asNeededFor = this@DosageSurrogate.asNeededFor ?: listOf(),
      site = this@DosageSurrogate.site,
      route = this@DosageSurrogate.route,
      method = this@DosageSurrogate.method,
      doseAndRate = this@DosageSurrogate.doseAndRate ?: listOf(),
      maxDosePerPeriod = this@DosageSurrogate.maxDosePerPeriod ?: listOf(),
      maxDosePerAdministration = this@DosageSurrogate.maxDosePerAdministration,
      maxDosePerLifetime = this@DosageSurrogate.maxDosePerLifetime,
    )

  public companion object {
    public fun fromModel(model: Dosage): DosageSurrogate =
      with(model) {
        DosageSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence?.value,
          _sequence = this@with.sequence?.toElement(),
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          additionalInstruction = this@with.additionalInstruction.takeIf { it.isNotEmpty() },
          patientInstruction = this@with.patientInstruction?.value,
          _patientInstruction = this@with.patientInstruction?.toElement(),
          timing = this@with.timing,
          asNeeded = this@with.asNeeded?.value,
          _asNeeded = this@with.asNeeded?.toElement(),
          asNeededFor = this@with.asNeededFor.takeIf { it.isNotEmpty() },
          site = this@with.site,
          route = this@with.route,
          method = this@with.method,
          doseAndRate = this@with.doseAndRate.takeIf { it.isNotEmpty() },
          maxDosePerPeriod = this@with.maxDosePerPeriod.takeIf { it.isNotEmpty() },
          maxDosePerAdministration = this@with.maxDosePerAdministration,
          maxDosePerLifetime = this@with.maxDosePerLifetime,
        )
      }
  }
}
