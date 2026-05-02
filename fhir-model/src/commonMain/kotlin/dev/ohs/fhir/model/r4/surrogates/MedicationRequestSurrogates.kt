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
import com.google.fhir.model.r4.Canonical
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Dosage
import com.google.fhir.model.r4.Duration
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.MedicationRequest
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.UnsignedInt
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MedicationRequestDispenseRequestSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var initialFill: MedicationRequest.DispenseRequest.InitialFill? = null,
  public var dispenseInterval: Duration? = null,
  public var validityPeriod: Period? = null,
  public var numberOfRepeatsAllowed: Int? = null,
  public var _numberOfRepeatsAllowed: Element? = null,
  public var quantity: Quantity? = null,
  public var expectedSupplyDuration: Duration? = null,
  public var performer: Reference? = null,
) {
  public fun toModel(): MedicationRequest.DispenseRequest =
    MedicationRequest.DispenseRequest(
      id = this@MedicationRequestDispenseRequestSurrogate.id,
      extension = this@MedicationRequestDispenseRequestSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationRequestDispenseRequestSurrogate.modifierExtension ?: listOf(),
      initialFill = this@MedicationRequestDispenseRequestSurrogate.initialFill,
      dispenseInterval = this@MedicationRequestDispenseRequestSurrogate.dispenseInterval,
      validityPeriod = this@MedicationRequestDispenseRequestSurrogate.validityPeriod,
      numberOfRepeatsAllowed =
        UnsignedInt.of(
          this@MedicationRequestDispenseRequestSurrogate.numberOfRepeatsAllowed,
          this@MedicationRequestDispenseRequestSurrogate._numberOfRepeatsAllowed,
        ),
      quantity = this@MedicationRequestDispenseRequestSurrogate.quantity,
      expectedSupplyDuration =
        this@MedicationRequestDispenseRequestSurrogate.expectedSupplyDuration,
      performer = this@MedicationRequestDispenseRequestSurrogate.performer,
    )

  public companion object {
    public fun fromModel(
      model: MedicationRequest.DispenseRequest
    ): MedicationRequestDispenseRequestSurrogate =
      with(model) {
        MedicationRequestDispenseRequestSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          initialFill = this@with.initialFill,
          dispenseInterval = this@with.dispenseInterval,
          validityPeriod = this@with.validityPeriod,
          numberOfRepeatsAllowed = this@with.numberOfRepeatsAllowed?.value,
          _numberOfRepeatsAllowed = this@with.numberOfRepeatsAllowed?.toElement(),
          quantity = this@with.quantity,
          expectedSupplyDuration = this@with.expectedSupplyDuration,
          performer = this@with.performer,
        )
      }
  }
}

@Serializable
internal data class MedicationRequestDispenseRequestInitialFillSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var quantity: Quantity? = null,
  public var duration: Duration? = null,
) {
  public fun toModel(): MedicationRequest.DispenseRequest.InitialFill =
    MedicationRequest.DispenseRequest.InitialFill(
      id = this@MedicationRequestDispenseRequestInitialFillSurrogate.id,
      extension = this@MedicationRequestDispenseRequestInitialFillSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationRequestDispenseRequestInitialFillSurrogate.modifierExtension ?: listOf(),
      quantity = this@MedicationRequestDispenseRequestInitialFillSurrogate.quantity,
      duration = this@MedicationRequestDispenseRequestInitialFillSurrogate.duration,
    )

  public companion object {
    public fun fromModel(
      model: MedicationRequest.DispenseRequest.InitialFill
    ): MedicationRequestDispenseRequestInitialFillSurrogate =
      with(model) {
        MedicationRequestDispenseRequestInitialFillSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          duration = this@with.duration,
        )
      }
  }
}

@Serializable
internal data class MedicationRequestSubstitutionSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var allowed: MedicationRequest.Substitution.Allowed,
  public var reason: CodeableConcept? = null,
) {
  public fun toModel(): MedicationRequest.Substitution =
    MedicationRequest.Substitution(
      id = this@MedicationRequestSubstitutionSurrogate.id,
      extension = this@MedicationRequestSubstitutionSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationRequestSubstitutionSurrogate.modifierExtension ?: listOf(),
      allowed = this@MedicationRequestSubstitutionSurrogate.allowed,
      reason = this@MedicationRequestSubstitutionSurrogate.reason,
    )

  public companion object {
    public fun fromModel(
      model: MedicationRequest.Substitution
    ): MedicationRequestSubstitutionSurrogate =
      with(model) {
        MedicationRequestSubstitutionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          allowed = this@with.allowed,
          reason = this@with.reason,
        )
      }
  }
}

@Serializable
internal data class MedicationRequestReportedSurrogate(
  public var reportedBoolean: KotlinBoolean? = null,
  public var _reportedBoolean: Element? = null,
  public var reportedReference: Reference? = null,
) {
  public fun toModel(): MedicationRequest.Reported =
    MedicationRequest.Reported.from(
      R4Boolean.of(
        this@MedicationRequestReportedSurrogate.reportedBoolean,
        this@MedicationRequestReportedSurrogate._reportedBoolean,
      ),
      this@MedicationRequestReportedSurrogate.reportedReference,
    )!!

  public companion object {
    public fun fromModel(model: MedicationRequest.Reported): MedicationRequestReportedSurrogate =
      with(model) {
        MedicationRequestReportedSurrogate(
          reportedBoolean = this@with.asBoolean()?.value?.value,
          _reportedBoolean = this@with.asBoolean()?.value?.toElement(),
          reportedReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationRequestMedicationSurrogate(
  public var medicationCodeableConcept: CodeableConcept? = null,
  public var medicationReference: Reference? = null,
) {
  public fun toModel(): MedicationRequest.Medication =
    MedicationRequest.Medication.from(
      this@MedicationRequestMedicationSurrogate.medicationCodeableConcept,
      this@MedicationRequestMedicationSurrogate.medicationReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationRequest.Medication
    ): MedicationRequestMedicationSurrogate =
      with(model) {
        MedicationRequestMedicationSurrogate(
          medicationCodeableConcept = this@with.asCodeableConcept()?.value,
          medicationReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationRequestSubstitutionAllowedSurrogate(
  public var allowedBoolean: KotlinBoolean? = null,
  public var _allowedBoolean: Element? = null,
  public var allowedCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): MedicationRequest.Substitution.Allowed =
    MedicationRequest.Substitution.Allowed.from(
      R4Boolean.of(
        this@MedicationRequestSubstitutionAllowedSurrogate.allowedBoolean,
        this@MedicationRequestSubstitutionAllowedSurrogate._allowedBoolean,
      ),
      this@MedicationRequestSubstitutionAllowedSurrogate.allowedCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationRequest.Substitution.Allowed
    ): MedicationRequestSubstitutionAllowedSurrogate =
      with(model) {
        MedicationRequestSubstitutionAllowedSurrogate(
          allowedBoolean = this@with.asBoolean()?.value?.value,
          _allowedBoolean = this@with.asBoolean()?.value?.toElement(),
          allowedCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationRequestSurrogate(
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
  public var status: String? = null,
  public var _status: Element? = null,
  public var statusReason: CodeableConcept? = null,
  public var intent: String? = null,
  public var _intent: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var priority: String? = null,
  public var _priority: Element? = null,
  public var doNotPerform: KotlinBoolean? = null,
  public var _doNotPerform: Element? = null,
  public var reported: MedicationRequest.Reported? = null,
  public var medication: MedicationRequest.Medication,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var supportingInformation: List<Reference>? = null,
  public var authoredOn: String? = null,
  public var _authoredOn: Element? = null,
  public var requester: Reference? = null,
  public var performer: Reference? = null,
  public var performerType: CodeableConcept? = null,
  public var recorder: Reference? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var instantiatesCanonical: List<String?>? = null,
  public var _instantiatesCanonical: List<Element?>? = null,
  public var instantiatesUri: List<String?>? = null,
  public var _instantiatesUri: List<Element?>? = null,
  public var basedOn: List<Reference>? = null,
  public var groupIdentifier: Identifier? = null,
  public var courseOfTherapyType: CodeableConcept? = null,
  public var insurance: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var dosageInstruction: List<Dosage>? = null,
  public var dispenseRequest: MedicationRequest.DispenseRequest? = null,
  public var substitution: MedicationRequest.Substitution? = null,
  public var priorPrescription: Reference? = null,
  public var detectedIssue: List<Reference>? = null,
  public var eventHistory: List<Reference>? = null,
) {
  public fun toModel(): MedicationRequest =
    MedicationRequest(
      id = this@MedicationRequestSurrogate.id,
      meta = this@MedicationRequestSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicationRequestSurrogate.implicitRules,
          this@MedicationRequestSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicationRequestSurrogate.language,
          this@MedicationRequestSurrogate._language,
        ),
      text = this@MedicationRequestSurrogate.text,
      contained = this@MedicationRequestSurrogate.contained ?: listOf(),
      extension = this@MedicationRequestSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationRequestSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicationRequestSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          MedicationRequest.MedicationrequestStatus.fromCode(
            this@MedicationRequestSurrogate.status!!
          ),
          this@MedicationRequestSurrogate._status,
        ),
      statusReason = this@MedicationRequestSurrogate.statusReason,
      intent =
        Enumeration.of(
          MedicationRequest.MedicationRequestIntent.fromCode(
            this@MedicationRequestSurrogate.intent!!
          ),
          this@MedicationRequestSurrogate._intent,
        ),
      category = this@MedicationRequestSurrogate.category ?: listOf(),
      priority =
        this@MedicationRequestSurrogate.priority?.let {
          Enumeration.of(
            MedicationRequest.RequestPriority.fromCode(it),
            this@MedicationRequestSurrogate._priority,
          )
        },
      doNotPerform =
        R4Boolean.of(
          this@MedicationRequestSurrogate.doNotPerform,
          this@MedicationRequestSurrogate._doNotPerform,
        ),
      reported = this@MedicationRequestSurrogate.reported,
      medication = this@MedicationRequestSurrogate.medication,
      subject = this@MedicationRequestSurrogate.subject,
      encounter = this@MedicationRequestSurrogate.encounter,
      supportingInformation = this@MedicationRequestSurrogate.supportingInformation ?: listOf(),
      authoredOn =
        DateTime.of(
          FhirDateTime.fromString(this@MedicationRequestSurrogate.authoredOn),
          this@MedicationRequestSurrogate._authoredOn,
        ),
      requester = this@MedicationRequestSurrogate.requester,
      performer = this@MedicationRequestSurrogate.performer,
      performerType = this@MedicationRequestSurrogate.performerType,
      recorder = this@MedicationRequestSurrogate.recorder,
      reasonCode = this@MedicationRequestSurrogate.reasonCode ?: listOf(),
      reasonReference = this@MedicationRequestSurrogate.reasonReference ?: listOf(),
      instantiatesCanonical =
        if (
          this@MedicationRequestSurrogate.instantiatesCanonical == null &&
            this@MedicationRequestSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@MedicationRequestSurrogate.instantiatesCanonical
              ?: List(this@MedicationRequestSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@MedicationRequestSurrogate._instantiatesCanonical
                ?: List(this@MedicationRequestSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@MedicationRequestSurrogate.instantiatesUri == null &&
            this@MedicationRequestSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@MedicationRequestSurrogate.instantiatesUri
              ?: List(this@MedicationRequestSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@MedicationRequestSurrogate._instantiatesUri
                ?: List(this@MedicationRequestSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      basedOn = this@MedicationRequestSurrogate.basedOn ?: listOf(),
      groupIdentifier = this@MedicationRequestSurrogate.groupIdentifier,
      courseOfTherapyType = this@MedicationRequestSurrogate.courseOfTherapyType,
      insurance = this@MedicationRequestSurrogate.insurance ?: listOf(),
      note = this@MedicationRequestSurrogate.note ?: listOf(),
      dosageInstruction = this@MedicationRequestSurrogate.dosageInstruction ?: listOf(),
      dispenseRequest = this@MedicationRequestSurrogate.dispenseRequest,
      substitution = this@MedicationRequestSurrogate.substitution,
      priorPrescription = this@MedicationRequestSurrogate.priorPrescription,
      detectedIssue = this@MedicationRequestSurrogate.detectedIssue ?: listOf(),
      eventHistory = this@MedicationRequestSurrogate.eventHistory ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MedicationRequest): MedicationRequestSurrogate =
      with(model) {
        MedicationRequestSurrogate(
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusReason = this@with.statusReason,
          intent = this@with.intent.value?.getCode(),
          _intent = this@with.intent.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          priority = this@with.priority?.value?.getCode(),
          _priority = this@with.priority?.toElement(),
          doNotPerform = this@with.doNotPerform?.value,
          _doNotPerform = this@with.doNotPerform?.toElement(),
          reported = this@with.reported,
          medication = this@with.medication,
          subject = this@with.subject,
          encounter = this@with.encounter,
          supportingInformation = this@with.supportingInformation.takeIf { it.isNotEmpty() },
          authoredOn = this@with.authoredOn?.value?.toString(),
          _authoredOn = this@with.authoredOn?.toElement(),
          requester = this@with.requester,
          performer = this@with.performer,
          performerType = this@with.performerType,
          recorder = this@with.recorder,
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
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
          groupIdentifier = this@with.groupIdentifier,
          courseOfTherapyType = this@with.courseOfTherapyType,
          insurance = this@with.insurance.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          dosageInstruction = this@with.dosageInstruction.takeIf { it.isNotEmpty() },
          dispenseRequest = this@with.dispenseRequest,
          substitution = this@with.substitution,
          priorPrescription = this@with.priorPrescription,
          detectedIssue = this@with.detectedIssue.takeIf { it.isNotEmpty() },
          eventHistory = this@with.eventHistory.takeIf { it.isNotEmpty() },
        )
      }
  }
}
