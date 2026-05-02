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
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.MedicationAdministration
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Ratio
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
internal data class MedicationAdministrationPerformerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var function: CodeableConcept? = null,
  public var actor: Reference,
) {
  public fun toModel(): MedicationAdministration.Performer =
    MedicationAdministration.Performer(
      id = this@MedicationAdministrationPerformerSurrogate.id,
      extension = this@MedicationAdministrationPerformerSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationAdministrationPerformerSurrogate.modifierExtension ?: listOf(),
      function = this@MedicationAdministrationPerformerSurrogate.function,
      actor = this@MedicationAdministrationPerformerSurrogate.actor,
    )

  public companion object {
    public fun fromModel(
      model: MedicationAdministration.Performer
    ): MedicationAdministrationPerformerSurrogate =
      with(model) {
        MedicationAdministrationPerformerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          function = this@with.function,
          actor = this@with.actor,
        )
      }
  }
}

@Serializable
internal data class MedicationAdministrationDosageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var site: CodeableConcept? = null,
  public var route: CodeableConcept? = null,
  public var method: CodeableConcept? = null,
  public var dose: Quantity? = null,
  public var rate: MedicationAdministration.Dosage.Rate? = null,
) {
  public fun toModel(): MedicationAdministration.Dosage =
    MedicationAdministration.Dosage(
      id = this@MedicationAdministrationDosageSurrogate.id,
      extension = this@MedicationAdministrationDosageSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationAdministrationDosageSurrogate.modifierExtension ?: listOf(),
      text =
        R4bString.of(
          this@MedicationAdministrationDosageSurrogate.text,
          this@MedicationAdministrationDosageSurrogate._text,
        ),
      site = this@MedicationAdministrationDosageSurrogate.site,
      route = this@MedicationAdministrationDosageSurrogate.route,
      method = this@MedicationAdministrationDosageSurrogate.method,
      dose = this@MedicationAdministrationDosageSurrogate.dose,
      rate = this@MedicationAdministrationDosageSurrogate.rate,
    )

  public companion object {
    public fun fromModel(
      model: MedicationAdministration.Dosage
    ): MedicationAdministrationDosageSurrogate =
      with(model) {
        MedicationAdministrationDosageSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          site = this@with.site,
          route = this@with.route,
          method = this@with.method,
          dose = this@with.dose,
          rate = this@with.rate,
        )
      }
  }
}

@Serializable
internal data class MedicationAdministrationMedicationSurrogate(
  public var medicationCodeableConcept: CodeableConcept? = null,
  public var medicationReference: Reference? = null,
) {
  public fun toModel(): MedicationAdministration.Medication =
    MedicationAdministration.Medication.from(
      this@MedicationAdministrationMedicationSurrogate.medicationCodeableConcept,
      this@MedicationAdministrationMedicationSurrogate.medicationReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationAdministration.Medication
    ): MedicationAdministrationMedicationSurrogate =
      with(model) {
        MedicationAdministrationMedicationSurrogate(
          medicationCodeableConcept = this@with.asCodeableConcept()?.value,
          medicationReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationAdministrationEffectiveSurrogate(
  public var effectiveDateTime: KotlinString? = null,
  public var _effectiveDateTime: Element? = null,
  public var effectivePeriod: Period? = null,
) {
  public fun toModel(): MedicationAdministration.Effective =
    MedicationAdministration.Effective.from(
      DateTime.of(
        FhirDateTime.fromString(this@MedicationAdministrationEffectiveSurrogate.effectiveDateTime),
        this@MedicationAdministrationEffectiveSurrogate._effectiveDateTime,
      ),
      this@MedicationAdministrationEffectiveSurrogate.effectivePeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationAdministration.Effective
    ): MedicationAdministrationEffectiveSurrogate =
      with(model) {
        MedicationAdministrationEffectiveSurrogate(
          effectiveDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _effectiveDateTime = this@with.asDateTime()?.value?.toElement(),
          effectivePeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationAdministrationDosageRateSurrogate(
  public var rateRatio: Ratio? = null,
  public var rateQuantity: Quantity? = null,
) {
  public fun toModel(): MedicationAdministration.Dosage.Rate =
    MedicationAdministration.Dosage.Rate.from(
      this@MedicationAdministrationDosageRateSurrogate.rateRatio,
      this@MedicationAdministrationDosageRateSurrogate.rateQuantity,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationAdministration.Dosage.Rate
    ): MedicationAdministrationDosageRateSurrogate =
      with(model) {
        MedicationAdministrationDosageRateSurrogate(
          rateRatio = this@with.asRatio()?.value,
          rateQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationAdministrationSurrogate(
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
  public var instantiates: List<KotlinString?>? = null,
  public var _instantiates: List<Element?>? = null,
  public var partOf: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: List<CodeableConcept>? = null,
  public var category: CodeableConcept? = null,
  public var medication: MedicationAdministration.Medication,
  public var subject: Reference,
  public var context: Reference? = null,
  public var supportingInformation: List<Reference>? = null,
  public var effective: MedicationAdministration.Effective,
  public var performer: List<MedicationAdministration.Performer>? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var request: Reference? = null,
  public var device: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var dosage: MedicationAdministration.Dosage? = null,
  public var eventHistory: List<Reference>? = null,
) {
  public fun toModel(): MedicationAdministration =
    MedicationAdministration(
      id = this@MedicationAdministrationSurrogate.id,
      meta = this@MedicationAdministrationSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicationAdministrationSurrogate.implicitRules,
          this@MedicationAdministrationSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicationAdministrationSurrogate.language,
          this@MedicationAdministrationSurrogate._language,
        ),
      text = this@MedicationAdministrationSurrogate.text,
      contained = this@MedicationAdministrationSurrogate.contained ?: listOf(),
      extension = this@MedicationAdministrationSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationAdministrationSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicationAdministrationSurrogate.identifier ?: listOf(),
      instantiates =
        if (
          this@MedicationAdministrationSurrogate.instantiates == null &&
            this@MedicationAdministrationSurrogate._instantiates == null
        ) {
          listOf()
        } else {
          (this@MedicationAdministrationSurrogate.instantiates
              ?: List(this@MedicationAdministrationSurrogate._instantiates!!.size) { null })
            .zip(
              this@MedicationAdministrationSurrogate._instantiates
                ?: List(this@MedicationAdministrationSurrogate.instantiates!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      partOf = this@MedicationAdministrationSurrogate.partOf ?: listOf(),
      status =
        Enumeration.of(
          MedicationAdministration.MedicationAdministrationStatusCodes.fromCode(
            this@MedicationAdministrationSurrogate.status!!
          ),
          this@MedicationAdministrationSurrogate._status,
        ),
      statusReason = this@MedicationAdministrationSurrogate.statusReason ?: listOf(),
      category = this@MedicationAdministrationSurrogate.category,
      medication = this@MedicationAdministrationSurrogate.medication,
      subject = this@MedicationAdministrationSurrogate.subject,
      context = this@MedicationAdministrationSurrogate.context,
      supportingInformation =
        this@MedicationAdministrationSurrogate.supportingInformation ?: listOf(),
      effective = this@MedicationAdministrationSurrogate.effective,
      performer = this@MedicationAdministrationSurrogate.performer ?: listOf(),
      reasonCode = this@MedicationAdministrationSurrogate.reasonCode ?: listOf(),
      reasonReference = this@MedicationAdministrationSurrogate.reasonReference ?: listOf(),
      request = this@MedicationAdministrationSurrogate.request,
      device = this@MedicationAdministrationSurrogate.device ?: listOf(),
      note = this@MedicationAdministrationSurrogate.note ?: listOf(),
      dosage = this@MedicationAdministrationSurrogate.dosage,
      eventHistory = this@MedicationAdministrationSurrogate.eventHistory ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MedicationAdministration): MedicationAdministrationSurrogate =
      with(model) {
        MedicationAdministrationSurrogate(
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
          instantiates =
            this@with.instantiates.map { it.value }.toList().takeUnless { it.all { it == null } },
          _instantiates =
            this@with.instantiates
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusReason = this@with.statusReason.takeIf { it.isNotEmpty() },
          category = this@with.category,
          medication = this@with.medication,
          subject = this@with.subject,
          context = this@with.context,
          supportingInformation = this@with.supportingInformation.takeIf { it.isNotEmpty() },
          effective = this@with.effective,
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          request = this@with.request,
          device = this@with.device.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          dosage = this@with.dosage,
          eventHistory = this@with.eventHistory.takeIf { it.isNotEmpty() },
        )
      }
  }
}
