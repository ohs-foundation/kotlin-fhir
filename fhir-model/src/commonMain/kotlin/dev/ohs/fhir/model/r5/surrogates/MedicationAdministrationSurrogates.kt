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
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.MedicationAdministration
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Ratio
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
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
  public var actor: CodeableReference,
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
        R5String.of(
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
internal data class MedicationAdministrationOccurenceSurrogate(
  public var occurenceDateTime: KotlinString? = null,
  public var _occurenceDateTime: Element? = null,
  public var occurencePeriod: Period? = null,
  public var occurenceTiming: Timing? = null,
) {
  public fun toModel(): MedicationAdministration.Occurence =
    MedicationAdministration.Occurence.from(
      DateTime.of(
        FhirDateTime.fromString(this@MedicationAdministrationOccurenceSurrogate.occurenceDateTime),
        this@MedicationAdministrationOccurenceSurrogate._occurenceDateTime,
      ),
      this@MedicationAdministrationOccurenceSurrogate.occurencePeriod,
      this@MedicationAdministrationOccurenceSurrogate.occurenceTiming,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationAdministration.Occurence
    ): MedicationAdministrationOccurenceSurrogate =
      with(model) {
        MedicationAdministrationOccurenceSurrogate(
          occurenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurencePeriod = this@with.asPeriod()?.value,
          occurenceTiming = this@with.asTiming()?.value,
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
  public var basedOn: List<Reference>? = null,
  public var partOf: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: List<CodeableConcept>? = null,
  public var category: List<CodeableConcept>? = null,
  public var medication: CodeableReference,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var supportingInformation: List<Reference>? = null,
  public var occurence: MedicationAdministration.Occurence,
  public var recorded: KotlinString? = null,
  public var _recorded: Element? = null,
  public var isSubPotent: KotlinBoolean? = null,
  public var _isSubPotent: Element? = null,
  public var subPotentReason: List<CodeableConcept>? = null,
  public var performer: List<MedicationAdministration.Performer>? = null,
  public var reason: List<CodeableReference>? = null,
  public var request: Reference? = null,
  public var device: List<CodeableReference>? = null,
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
      basedOn = this@MedicationAdministrationSurrogate.basedOn ?: listOf(),
      partOf = this@MedicationAdministrationSurrogate.partOf ?: listOf(),
      status =
        Enumeration.of(
          MedicationAdministration.MedicationAdministrationStatusCodes.fromCode(
            this@MedicationAdministrationSurrogate.status!!
          ),
          this@MedicationAdministrationSurrogate._status,
        ),
      statusReason = this@MedicationAdministrationSurrogate.statusReason ?: listOf(),
      category = this@MedicationAdministrationSurrogate.category ?: listOf(),
      medication = this@MedicationAdministrationSurrogate.medication,
      subject = this@MedicationAdministrationSurrogate.subject,
      encounter = this@MedicationAdministrationSurrogate.encounter,
      supportingInformation =
        this@MedicationAdministrationSurrogate.supportingInformation ?: listOf(),
      occurence = this@MedicationAdministrationSurrogate.occurence,
      recorded =
        DateTime.of(
          FhirDateTime.fromString(this@MedicationAdministrationSurrogate.recorded),
          this@MedicationAdministrationSurrogate._recorded,
        ),
      isSubPotent =
        R5Boolean.of(
          this@MedicationAdministrationSurrogate.isSubPotent,
          this@MedicationAdministrationSurrogate._isSubPotent,
        ),
      subPotentReason = this@MedicationAdministrationSurrogate.subPotentReason ?: listOf(),
      performer = this@MedicationAdministrationSurrogate.performer ?: listOf(),
      reason = this@MedicationAdministrationSurrogate.reason ?: listOf(),
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
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusReason = this@with.statusReason.takeIf { it.isNotEmpty() },
          category = this@with.category.takeIf { it.isNotEmpty() },
          medication = this@with.medication,
          subject = this@with.subject,
          encounter = this@with.encounter,
          supportingInformation = this@with.supportingInformation.takeIf { it.isNotEmpty() },
          occurence = this@with.occurence,
          recorded = this@with.recorded?.value?.toString(),
          _recorded = this@with.recorded?.toElement(),
          isSubPotent = this@with.isSubPotent?.value,
          _isSubPotent = this@with.isSubPotent?.toElement(),
          subPotentReason = this@with.subPotentReason.takeIf { it.isNotEmpty() },
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          request = this@with.request,
          device = this@with.device.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          dosage = this@with.dosage,
          eventHistory = this@with.eventHistory.takeIf { it.isNotEmpty() },
        )
      }
  }
}
