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
import com.google.fhir.model.r5.Dosage
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.MedicationDispense
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MedicationDispensePerformerSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var function: CodeableConcept? = null,
  public var actor: Reference,
) {
  public fun toModel(): MedicationDispense.Performer =
    MedicationDispense.Performer(
      id = this@MedicationDispensePerformerSurrogate.id,
      extension = this@MedicationDispensePerformerSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationDispensePerformerSurrogate.modifierExtension ?: listOf(),
      function = this@MedicationDispensePerformerSurrogate.function,
      actor = this@MedicationDispensePerformerSurrogate.actor,
    )

  public companion object {
    public fun fromModel(
      model: MedicationDispense.Performer
    ): MedicationDispensePerformerSurrogate =
      with(model) {
        MedicationDispensePerformerSurrogate(
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
internal data class MedicationDispenseSubstitutionSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var wasSubstituted: KotlinBoolean? = null,
  public var _wasSubstituted: Element? = null,
  public var type: CodeableConcept? = null,
  public var reason: List<CodeableConcept>? = null,
  public var responsibleParty: Reference? = null,
) {
  public fun toModel(): MedicationDispense.Substitution =
    MedicationDispense.Substitution(
      id = this@MedicationDispenseSubstitutionSurrogate.id,
      extension = this@MedicationDispenseSubstitutionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationDispenseSubstitutionSurrogate.modifierExtension ?: listOf(),
      wasSubstituted =
        R5Boolean.of(
          this@MedicationDispenseSubstitutionSurrogate.wasSubstituted,
          this@MedicationDispenseSubstitutionSurrogate._wasSubstituted,
        )!!,
      type = this@MedicationDispenseSubstitutionSurrogate.type,
      reason = this@MedicationDispenseSubstitutionSurrogate.reason ?: listOf(),
      responsibleParty = this@MedicationDispenseSubstitutionSurrogate.responsibleParty,
    )

  public companion object {
    public fun fromModel(
      model: MedicationDispense.Substitution
    ): MedicationDispenseSubstitutionSurrogate =
      with(model) {
        MedicationDispenseSubstitutionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          wasSubstituted = this@with.wasSubstituted.value,
          _wasSubstituted = this@with.wasSubstituted.toElement(),
          type = this@with.type,
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          responsibleParty = this@with.responsibleParty,
        )
      }
  }
}

@Serializable
internal data class MedicationDispenseSurrogate(
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
  public var partOf: List<Reference>? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var notPerformedReason: CodeableReference? = null,
  public var statusChanged: String? = null,
  public var _statusChanged: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var medication: CodeableReference,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var supportingInformation: List<Reference>? = null,
  public var performer: List<MedicationDispense.Performer>? = null,
  public var location: Reference? = null,
  public var authorizingPrescription: List<Reference>? = null,
  public var type: CodeableConcept? = null,
  public var quantity: Quantity? = null,
  public var daysSupply: Quantity? = null,
  public var recorded: String? = null,
  public var _recorded: Element? = null,
  public var whenPrepared: String? = null,
  public var _whenPrepared: Element? = null,
  public var whenHandedOver: String? = null,
  public var _whenHandedOver: Element? = null,
  public var destination: Reference? = null,
  public var `receiver`: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var renderedDosageInstruction: String? = null,
  public var _renderedDosageInstruction: Element? = null,
  public var dosageInstruction: List<Dosage>? = null,
  public var substitution: MedicationDispense.Substitution? = null,
  public var eventHistory: List<Reference>? = null,
) {
  public fun toModel(): MedicationDispense =
    MedicationDispense(
      id = this@MedicationDispenseSurrogate.id,
      meta = this@MedicationDispenseSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicationDispenseSurrogate.implicitRules,
          this@MedicationDispenseSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicationDispenseSurrogate.language,
          this@MedicationDispenseSurrogate._language,
        ),
      text = this@MedicationDispenseSurrogate.text,
      contained = this@MedicationDispenseSurrogate.contained ?: listOf(),
      extension = this@MedicationDispenseSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationDispenseSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicationDispenseSurrogate.identifier ?: listOf(),
      basedOn = this@MedicationDispenseSurrogate.basedOn ?: listOf(),
      partOf = this@MedicationDispenseSurrogate.partOf ?: listOf(),
      status =
        Enumeration.of(
          MedicationDispense.MedicationDispenseStatusCodes.fromCode(
            this@MedicationDispenseSurrogate.status!!
          ),
          this@MedicationDispenseSurrogate._status,
        ),
      notPerformedReason = this@MedicationDispenseSurrogate.notPerformedReason,
      statusChanged =
        DateTime.of(
          FhirDateTime.fromString(this@MedicationDispenseSurrogate.statusChanged),
          this@MedicationDispenseSurrogate._statusChanged,
        ),
      category = this@MedicationDispenseSurrogate.category ?: listOf(),
      medication = this@MedicationDispenseSurrogate.medication,
      subject = this@MedicationDispenseSurrogate.subject,
      encounter = this@MedicationDispenseSurrogate.encounter,
      supportingInformation = this@MedicationDispenseSurrogate.supportingInformation ?: listOf(),
      performer = this@MedicationDispenseSurrogate.performer ?: listOf(),
      location = this@MedicationDispenseSurrogate.location,
      authorizingPrescription =
        this@MedicationDispenseSurrogate.authorizingPrescription ?: listOf(),
      type = this@MedicationDispenseSurrogate.type,
      quantity = this@MedicationDispenseSurrogate.quantity,
      daysSupply = this@MedicationDispenseSurrogate.daysSupply,
      recorded =
        DateTime.of(
          FhirDateTime.fromString(this@MedicationDispenseSurrogate.recorded),
          this@MedicationDispenseSurrogate._recorded,
        ),
      whenPrepared =
        DateTime.of(
          FhirDateTime.fromString(this@MedicationDispenseSurrogate.whenPrepared),
          this@MedicationDispenseSurrogate._whenPrepared,
        ),
      whenHandedOver =
        DateTime.of(
          FhirDateTime.fromString(this@MedicationDispenseSurrogate.whenHandedOver),
          this@MedicationDispenseSurrogate._whenHandedOver,
        ),
      destination = this@MedicationDispenseSurrogate.destination,
      `receiver` = this@MedicationDispenseSurrogate.`receiver` ?: listOf(),
      note = this@MedicationDispenseSurrogate.note ?: listOf(),
      renderedDosageInstruction =
        Markdown.of(
          this@MedicationDispenseSurrogate.renderedDosageInstruction,
          this@MedicationDispenseSurrogate._renderedDosageInstruction,
        ),
      dosageInstruction = this@MedicationDispenseSurrogate.dosageInstruction ?: listOf(),
      substitution = this@MedicationDispenseSurrogate.substitution,
      eventHistory = this@MedicationDispenseSurrogate.eventHistory ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MedicationDispense): MedicationDispenseSurrogate =
      with(model) {
        MedicationDispenseSurrogate(
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
          notPerformedReason = this@with.notPerformedReason,
          statusChanged = this@with.statusChanged?.value?.toString(),
          _statusChanged = this@with.statusChanged?.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          medication = this@with.medication,
          subject = this@with.subject,
          encounter = this@with.encounter,
          supportingInformation = this@with.supportingInformation.takeIf { it.isNotEmpty() },
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          location = this@with.location,
          authorizingPrescription = this@with.authorizingPrescription.takeIf { it.isNotEmpty() },
          type = this@with.type,
          quantity = this@with.quantity,
          daysSupply = this@with.daysSupply,
          recorded = this@with.recorded?.value?.toString(),
          _recorded = this@with.recorded?.toElement(),
          whenPrepared = this@with.whenPrepared?.value?.toString(),
          _whenPrepared = this@with.whenPrepared?.toElement(),
          whenHandedOver = this@with.whenHandedOver?.value?.toString(),
          _whenHandedOver = this@with.whenHandedOver?.toElement(),
          destination = this@with.destination,
          `receiver` = this@with.`receiver`.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          renderedDosageInstruction = this@with.renderedDosageInstruction?.value,
          _renderedDosageInstruction = this@with.renderedDosageInstruction?.toElement(),
          dosageInstruction = this@with.dosageInstruction.takeIf { it.isNotEmpty() },
          substitution = this@with.substitution,
          eventHistory = this@with.eventHistory.takeIf { it.isNotEmpty() },
        )
      }
  }
}
