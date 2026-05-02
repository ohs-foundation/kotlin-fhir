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

import com.google.fhir.model.r4.Age
import com.google.fhir.model.r4.Annotation
import com.google.fhir.model.r4.Canonical
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Procedure
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ProcedurePerformerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var function: CodeableConcept? = null,
  public var actor: Reference,
  public var onBehalfOf: Reference? = null,
) {
  public fun toModel(): Procedure.Performer =
    Procedure.Performer(
      id = this@ProcedurePerformerSurrogate.id,
      extension = this@ProcedurePerformerSurrogate.extension ?: listOf(),
      modifierExtension = this@ProcedurePerformerSurrogate.modifierExtension ?: listOf(),
      function = this@ProcedurePerformerSurrogate.function,
      actor = this@ProcedurePerformerSurrogate.actor,
      onBehalfOf = this@ProcedurePerformerSurrogate.onBehalfOf,
    )

  public companion object {
    public fun fromModel(model: Procedure.Performer): ProcedurePerformerSurrogate =
      with(model) {
        ProcedurePerformerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          function = this@with.function,
          actor = this@with.actor,
          onBehalfOf = this@with.onBehalfOf,
        )
      }
  }
}

@Serializable
internal data class ProcedureFocalDeviceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var action: CodeableConcept? = null,
  public var manipulated: Reference,
) {
  public fun toModel(): Procedure.FocalDevice =
    Procedure.FocalDevice(
      id = this@ProcedureFocalDeviceSurrogate.id,
      extension = this@ProcedureFocalDeviceSurrogate.extension ?: listOf(),
      modifierExtension = this@ProcedureFocalDeviceSurrogate.modifierExtension ?: listOf(),
      action = this@ProcedureFocalDeviceSurrogate.action,
      manipulated = this@ProcedureFocalDeviceSurrogate.manipulated,
    )

  public companion object {
    public fun fromModel(model: Procedure.FocalDevice): ProcedureFocalDeviceSurrogate =
      with(model) {
        ProcedureFocalDeviceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          action = this@with.action,
          manipulated = this@with.manipulated,
        )
      }
  }
}

@Serializable
internal data class ProcedurePerformedSurrogate(
  public var performedDateTime: KotlinString? = null,
  public var _performedDateTime: Element? = null,
  public var performedPeriod: Period? = null,
  public var performedString: KotlinString? = null,
  public var _performedString: Element? = null,
  public var performedAge: Age? = null,
  public var performedRange: Range? = null,
) {
  public fun toModel(): Procedure.Performed =
    Procedure.Performed.from(
      DateTime.of(
        FhirDateTime.fromString(this@ProcedurePerformedSurrogate.performedDateTime),
        this@ProcedurePerformedSurrogate._performedDateTime,
      ),
      this@ProcedurePerformedSurrogate.performedPeriod,
      R4String.of(
        this@ProcedurePerformedSurrogate.performedString,
        this@ProcedurePerformedSurrogate._performedString,
      ),
      this@ProcedurePerformedSurrogate.performedAge,
      this@ProcedurePerformedSurrogate.performedRange,
    )!!

  public companion object {
    public fun fromModel(model: Procedure.Performed): ProcedurePerformedSurrogate =
      with(model) {
        ProcedurePerformedSurrogate(
          performedDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _performedDateTime = this@with.asDateTime()?.value?.toElement(),
          performedPeriod = this@with.asPeriod()?.value,
          performedString = this@with.asString()?.value?.value,
          _performedString = this@with.asString()?.value?.toElement(),
          performedAge = this@with.asAge()?.value,
          performedRange = this@with.asRange()?.value,
        )
      }
  }
}

@Serializable
internal data class ProcedureSurrogate(
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
  public var instantiatesCanonical: List<KotlinString?>? = null,
  public var _instantiatesCanonical: List<Element?>? = null,
  public var instantiatesUri: List<KotlinString?>? = null,
  public var _instantiatesUri: List<Element?>? = null,
  public var basedOn: List<Reference>? = null,
  public var partOf: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: CodeableConcept? = null,
  public var category: CodeableConcept? = null,
  public var code: CodeableConcept? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var performed: Procedure.Performed? = null,
  public var recorder: Reference? = null,
  public var asserter: Reference? = null,
  public var performer: List<Procedure.Performer>? = null,
  public var location: Reference? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var bodySite: List<CodeableConcept>? = null,
  public var outcome: CodeableConcept? = null,
  public var report: List<Reference>? = null,
  public var complication: List<CodeableConcept>? = null,
  public var complicationDetail: List<Reference>? = null,
  public var followUp: List<CodeableConcept>? = null,
  public var note: List<Annotation>? = null,
  public var focalDevice: List<Procedure.FocalDevice>? = null,
  public var usedReference: List<Reference>? = null,
  public var usedCode: List<CodeableConcept>? = null,
) {
  public fun toModel(): Procedure =
    Procedure(
      id = this@ProcedureSurrogate.id,
      meta = this@ProcedureSurrogate.meta,
      implicitRules =
        Uri.of(this@ProcedureSurrogate.implicitRules, this@ProcedureSurrogate._implicitRules),
      language = Code.of(this@ProcedureSurrogate.language, this@ProcedureSurrogate._language),
      text = this@ProcedureSurrogate.text,
      contained = this@ProcedureSurrogate.contained ?: listOf(),
      extension = this@ProcedureSurrogate.extension ?: listOf(),
      modifierExtension = this@ProcedureSurrogate.modifierExtension ?: listOf(),
      identifier = this@ProcedureSurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        if (
          this@ProcedureSurrogate.instantiatesCanonical == null &&
            this@ProcedureSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@ProcedureSurrogate.instantiatesCanonical
              ?: List(this@ProcedureSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@ProcedureSurrogate._instantiatesCanonical
                ?: List(this@ProcedureSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@ProcedureSurrogate.instantiatesUri == null &&
            this@ProcedureSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@ProcedureSurrogate.instantiatesUri
              ?: List(this@ProcedureSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@ProcedureSurrogate._instantiatesUri
                ?: List(this@ProcedureSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      basedOn = this@ProcedureSurrogate.basedOn ?: listOf(),
      partOf = this@ProcedureSurrogate.partOf ?: listOf(),
      status =
        Enumeration.of(
          Procedure.EventStatus.fromCode(this@ProcedureSurrogate.status!!),
          this@ProcedureSurrogate._status,
        ),
      statusReason = this@ProcedureSurrogate.statusReason,
      category = this@ProcedureSurrogate.category,
      code = this@ProcedureSurrogate.code,
      subject = this@ProcedureSurrogate.subject,
      encounter = this@ProcedureSurrogate.encounter,
      performed = this@ProcedureSurrogate.performed,
      recorder = this@ProcedureSurrogate.recorder,
      asserter = this@ProcedureSurrogate.asserter,
      performer = this@ProcedureSurrogate.performer ?: listOf(),
      location = this@ProcedureSurrogate.location,
      reasonCode = this@ProcedureSurrogate.reasonCode ?: listOf(),
      reasonReference = this@ProcedureSurrogate.reasonReference ?: listOf(),
      bodySite = this@ProcedureSurrogate.bodySite ?: listOf(),
      outcome = this@ProcedureSurrogate.outcome,
      report = this@ProcedureSurrogate.report ?: listOf(),
      complication = this@ProcedureSurrogate.complication ?: listOf(),
      complicationDetail = this@ProcedureSurrogate.complicationDetail ?: listOf(),
      followUp = this@ProcedureSurrogate.followUp ?: listOf(),
      note = this@ProcedureSurrogate.note ?: listOf(),
      focalDevice = this@ProcedureSurrogate.focalDevice ?: listOf(),
      usedReference = this@ProcedureSurrogate.usedReference ?: listOf(),
      usedCode = this@ProcedureSurrogate.usedCode ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Procedure): ProcedureSurrogate =
      with(model) {
        ProcedureSurrogate(
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
          instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          instantiatesUri =
            this@with.instantiatesUri
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesUri =
            this@with.instantiatesUri
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusReason = this@with.statusReason,
          category = this@with.category,
          code = this@with.code,
          subject = this@with.subject,
          encounter = this@with.encounter,
          performed = this@with.performed,
          recorder = this@with.recorder,
          asserter = this@with.asserter,
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          location = this@with.location,
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          bodySite = this@with.bodySite.takeIf { it.isNotEmpty() },
          outcome = this@with.outcome,
          report = this@with.report.takeIf { it.isNotEmpty() },
          complication = this@with.complication.takeIf { it.isNotEmpty() },
          complicationDetail = this@with.complicationDetail.takeIf { it.isNotEmpty() },
          followUp = this@with.followUp.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          focalDevice = this@with.focalDevice.takeIf { it.isNotEmpty() },
          usedReference = this@with.usedReference.takeIf { it.isNotEmpty() },
          usedCode = this@with.usedCode.takeIf { it.isNotEmpty() },
        )
      }
  }
}
