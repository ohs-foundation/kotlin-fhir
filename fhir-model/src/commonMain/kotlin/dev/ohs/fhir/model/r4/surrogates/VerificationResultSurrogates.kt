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

import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDate
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.Signature
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Timing
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.VerificationResult
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class VerificationResultPrimarySourceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var who: Reference? = null,
  public var type: List<CodeableConcept>? = null,
  public var communicationMethod: List<CodeableConcept>? = null,
  public var validationStatus: CodeableConcept? = null,
  public var validationDate: KotlinString? = null,
  public var _validationDate: Element? = null,
  public var canPushUpdates: CodeableConcept? = null,
  public var pushTypeAvailable: List<CodeableConcept>? = null,
) {
  public fun toModel(): VerificationResult.PrimarySource =
    VerificationResult.PrimarySource(
      id = this@VerificationResultPrimarySourceSurrogate.id,
      extension = this@VerificationResultPrimarySourceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@VerificationResultPrimarySourceSurrogate.modifierExtension ?: listOf(),
      who = this@VerificationResultPrimarySourceSurrogate.who,
      type = this@VerificationResultPrimarySourceSurrogate.type ?: listOf(),
      communicationMethod =
        this@VerificationResultPrimarySourceSurrogate.communicationMethod ?: listOf(),
      validationStatus = this@VerificationResultPrimarySourceSurrogate.validationStatus,
      validationDate =
        DateTime.of(
          FhirDateTime.fromString(this@VerificationResultPrimarySourceSurrogate.validationDate),
          this@VerificationResultPrimarySourceSurrogate._validationDate,
        ),
      canPushUpdates = this@VerificationResultPrimarySourceSurrogate.canPushUpdates,
      pushTypeAvailable =
        this@VerificationResultPrimarySourceSurrogate.pushTypeAvailable ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: VerificationResult.PrimarySource
    ): VerificationResultPrimarySourceSurrogate =
      with(model) {
        VerificationResultPrimarySourceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          who = this@with.who,
          type = this@with.type.takeIf { it.isNotEmpty() },
          communicationMethod = this@with.communicationMethod.takeIf { it.isNotEmpty() },
          validationStatus = this@with.validationStatus,
          validationDate = this@with.validationDate?.value?.toString(),
          _validationDate = this@with.validationDate?.toElement(),
          canPushUpdates = this@with.canPushUpdates,
          pushTypeAvailable = this@with.pushTypeAvailable.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class VerificationResultAttestationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var who: Reference? = null,
  public var onBehalfOf: Reference? = null,
  public var communicationMethod: CodeableConcept? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var sourceIdentityCertificate: KotlinString? = null,
  public var _sourceIdentityCertificate: Element? = null,
  public var proxyIdentityCertificate: KotlinString? = null,
  public var _proxyIdentityCertificate: Element? = null,
  public var proxySignature: Signature? = null,
  public var sourceSignature: Signature? = null,
) {
  public fun toModel(): VerificationResult.Attestation =
    VerificationResult.Attestation(
      id = this@VerificationResultAttestationSurrogate.id,
      extension = this@VerificationResultAttestationSurrogate.extension ?: listOf(),
      modifierExtension = this@VerificationResultAttestationSurrogate.modifierExtension ?: listOf(),
      who = this@VerificationResultAttestationSurrogate.who,
      onBehalfOf = this@VerificationResultAttestationSurrogate.onBehalfOf,
      communicationMethod = this@VerificationResultAttestationSurrogate.communicationMethod,
      date =
        Date.of(
          FhirDate.fromString(this@VerificationResultAttestationSurrogate.date),
          this@VerificationResultAttestationSurrogate._date,
        ),
      sourceIdentityCertificate =
        R4String.of(
          this@VerificationResultAttestationSurrogate.sourceIdentityCertificate,
          this@VerificationResultAttestationSurrogate._sourceIdentityCertificate,
        ),
      proxyIdentityCertificate =
        R4String.of(
          this@VerificationResultAttestationSurrogate.proxyIdentityCertificate,
          this@VerificationResultAttestationSurrogate._proxyIdentityCertificate,
        ),
      proxySignature = this@VerificationResultAttestationSurrogate.proxySignature,
      sourceSignature = this@VerificationResultAttestationSurrogate.sourceSignature,
    )

  public companion object {
    public fun fromModel(
      model: VerificationResult.Attestation
    ): VerificationResultAttestationSurrogate =
      with(model) {
        VerificationResultAttestationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          who = this@with.who,
          onBehalfOf = this@with.onBehalfOf,
          communicationMethod = this@with.communicationMethod,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          sourceIdentityCertificate = this@with.sourceIdentityCertificate?.value,
          _sourceIdentityCertificate = this@with.sourceIdentityCertificate?.toElement(),
          proxyIdentityCertificate = this@with.proxyIdentityCertificate?.value,
          _proxyIdentityCertificate = this@with.proxyIdentityCertificate?.toElement(),
          proxySignature = this@with.proxySignature,
          sourceSignature = this@with.sourceSignature,
        )
      }
  }
}

@Serializable
internal data class VerificationResultValidatorSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var organization: Reference,
  public var identityCertificate: KotlinString? = null,
  public var _identityCertificate: Element? = null,
  public var attestationSignature: Signature? = null,
) {
  public fun toModel(): VerificationResult.Validator =
    VerificationResult.Validator(
      id = this@VerificationResultValidatorSurrogate.id,
      extension = this@VerificationResultValidatorSurrogate.extension ?: listOf(),
      modifierExtension = this@VerificationResultValidatorSurrogate.modifierExtension ?: listOf(),
      organization = this@VerificationResultValidatorSurrogate.organization,
      identityCertificate =
        R4String.of(
          this@VerificationResultValidatorSurrogate.identityCertificate,
          this@VerificationResultValidatorSurrogate._identityCertificate,
        ),
      attestationSignature = this@VerificationResultValidatorSurrogate.attestationSignature,
    )

  public companion object {
    public fun fromModel(
      model: VerificationResult.Validator
    ): VerificationResultValidatorSurrogate =
      with(model) {
        VerificationResultValidatorSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          organization = this@with.organization,
          identityCertificate = this@with.identityCertificate?.value,
          _identityCertificate = this@with.identityCertificate?.toElement(),
          attestationSignature = this@with.attestationSignature,
        )
      }
  }
}

@Serializable
internal data class VerificationResultSurrogate(
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
  public var target: List<Reference>? = null,
  public var targetLocation: List<KotlinString?>? = null,
  public var _targetLocation: List<Element?>? = null,
  public var need: CodeableConcept? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusDate: KotlinString? = null,
  public var _statusDate: Element? = null,
  public var validationType: CodeableConcept? = null,
  public var validationProcess: List<CodeableConcept>? = null,
  public var frequency: Timing? = null,
  public var lastPerformed: KotlinString? = null,
  public var _lastPerformed: Element? = null,
  public var nextScheduled: KotlinString? = null,
  public var _nextScheduled: Element? = null,
  public var failureAction: CodeableConcept? = null,
  public var primarySource: List<VerificationResult.PrimarySource>? = null,
  public var attestation: VerificationResult.Attestation? = null,
  public var validator: List<VerificationResult.Validator>? = null,
) {
  public fun toModel(): VerificationResult =
    VerificationResult(
      id = this@VerificationResultSurrogate.id,
      meta = this@VerificationResultSurrogate.meta,
      implicitRules =
        Uri.of(
          this@VerificationResultSurrogate.implicitRules,
          this@VerificationResultSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@VerificationResultSurrogate.language,
          this@VerificationResultSurrogate._language,
        ),
      text = this@VerificationResultSurrogate.text,
      contained = this@VerificationResultSurrogate.contained ?: listOf(),
      extension = this@VerificationResultSurrogate.extension ?: listOf(),
      modifierExtension = this@VerificationResultSurrogate.modifierExtension ?: listOf(),
      target = this@VerificationResultSurrogate.target ?: listOf(),
      targetLocation =
        if (
          this@VerificationResultSurrogate.targetLocation == null &&
            this@VerificationResultSurrogate._targetLocation == null
        ) {
          listOf()
        } else {
          (this@VerificationResultSurrogate.targetLocation
              ?: List(this@VerificationResultSurrogate._targetLocation!!.size) { null })
            .zip(
              this@VerificationResultSurrogate._targetLocation
                ?: List(this@VerificationResultSurrogate.targetLocation!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      need = this@VerificationResultSurrogate.need,
      status =
        Enumeration.of(
          VerificationResult.Status.fromCode(this@VerificationResultSurrogate.status!!),
          this@VerificationResultSurrogate._status,
        ),
      statusDate =
        DateTime.of(
          FhirDateTime.fromString(this@VerificationResultSurrogate.statusDate),
          this@VerificationResultSurrogate._statusDate,
        ),
      validationType = this@VerificationResultSurrogate.validationType,
      validationProcess = this@VerificationResultSurrogate.validationProcess ?: listOf(),
      frequency = this@VerificationResultSurrogate.frequency,
      lastPerformed =
        DateTime.of(
          FhirDateTime.fromString(this@VerificationResultSurrogate.lastPerformed),
          this@VerificationResultSurrogate._lastPerformed,
        ),
      nextScheduled =
        Date.of(
          FhirDate.fromString(this@VerificationResultSurrogate.nextScheduled),
          this@VerificationResultSurrogate._nextScheduled,
        ),
      failureAction = this@VerificationResultSurrogate.failureAction,
      primarySource = this@VerificationResultSurrogate.primarySource ?: listOf(),
      attestation = this@VerificationResultSurrogate.attestation,
      validator = this@VerificationResultSurrogate.validator ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: VerificationResult): VerificationResultSurrogate =
      with(model) {
        VerificationResultSurrogate(
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
          target = this@with.target.takeIf { it.isNotEmpty() },
          targetLocation =
            this@with.targetLocation.map { it.value }.toList().takeUnless { it.all { it == null } },
          _targetLocation =
            this@with.targetLocation
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          need = this@with.need,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusDate = this@with.statusDate?.value?.toString(),
          _statusDate = this@with.statusDate?.toElement(),
          validationType = this@with.validationType,
          validationProcess = this@with.validationProcess.takeIf { it.isNotEmpty() },
          frequency = this@with.frequency,
          lastPerformed = this@with.lastPerformed?.value?.toString(),
          _lastPerformed = this@with.lastPerformed?.toElement(),
          nextScheduled = this@with.nextScheduled?.value?.toString(),
          _nextScheduled = this@with.nextScheduled?.toElement(),
          failureAction = this@with.failureAction,
          primarySource = this@with.primarySource.takeIf { it.isNotEmpty() },
          attestation = this@with.attestation,
          validator = this@with.validator.takeIf { it.isNotEmpty() },
        )
      }
  }
}
