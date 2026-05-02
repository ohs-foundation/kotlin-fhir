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
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.DeviceRequest
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class DeviceRequestParameterSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var `value`: DeviceRequest.Parameter.Value? = null,
) {
  public fun toModel(): DeviceRequest.Parameter =
    DeviceRequest.Parameter(
      id = this@DeviceRequestParameterSurrogate.id,
      extension = this@DeviceRequestParameterSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceRequestParameterSurrogate.modifierExtension ?: listOf(),
      code = this@DeviceRequestParameterSurrogate.code,
      `value` = this@DeviceRequestParameterSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: DeviceRequest.Parameter): DeviceRequestParameterSurrogate =
      with(model) {
        DeviceRequestParameterSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class DeviceRequestParameterValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
) {
  public fun toModel(): DeviceRequest.Parameter.Value =
    DeviceRequest.Parameter.Value.from(
      this@DeviceRequestParameterValueSurrogate.valueCodeableConcept,
      this@DeviceRequestParameterValueSurrogate.valueQuantity,
      this@DeviceRequestParameterValueSurrogate.valueRange,
      R5Boolean.of(
        this@DeviceRequestParameterValueSurrogate.valueBoolean,
        this@DeviceRequestParameterValueSurrogate._valueBoolean,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: DeviceRequest.Parameter.Value
    ): DeviceRequestParameterValueSurrogate =
      with(model) {
        DeviceRequestParameterValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceRequestOccurrenceSurrogate(
  public var occurrenceDateTime: String? = null,
  public var _occurrenceDateTime: Element? = null,
  public var occurrencePeriod: Period? = null,
  public var occurrenceTiming: Timing? = null,
) {
  public fun toModel(): DeviceRequest.Occurrence =
    DeviceRequest.Occurrence.from(
      DateTime.of(
        FhirDateTime.fromString(this@DeviceRequestOccurrenceSurrogate.occurrenceDateTime),
        this@DeviceRequestOccurrenceSurrogate._occurrenceDateTime,
      ),
      this@DeviceRequestOccurrenceSurrogate.occurrencePeriod,
      this@DeviceRequestOccurrenceSurrogate.occurrenceTiming,
    )!!

  public companion object {
    public fun fromModel(model: DeviceRequest.Occurrence): DeviceRequestOccurrenceSurrogate =
      with(model) {
        DeviceRequestOccurrenceSurrogate(
          occurrenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurrenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurrencePeriod = this@with.asPeriod()?.value,
          occurrenceTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class DeviceRequestSurrogate(
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
  public var instantiatesCanonical: List<String?>? = null,
  public var _instantiatesCanonical: List<Element?>? = null,
  public var instantiatesUri: List<String?>? = null,
  public var _instantiatesUri: List<Element?>? = null,
  public var basedOn: List<Reference>? = null,
  public var replaces: List<Reference>? = null,
  public var groupIdentifier: Identifier? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var intent: String? = null,
  public var _intent: Element? = null,
  public var priority: String? = null,
  public var _priority: Element? = null,
  public var doNotPerform: KotlinBoolean? = null,
  public var _doNotPerform: Element? = null,
  public var code: CodeableReference,
  public var quantity: Int? = null,
  public var _quantity: Element? = null,
  public var parameter: List<DeviceRequest.Parameter>? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var occurrence: DeviceRequest.Occurrence? = null,
  public var authoredOn: String? = null,
  public var _authoredOn: Element? = null,
  public var requester: Reference? = null,
  public var performer: CodeableReference? = null,
  public var reason: List<CodeableReference>? = null,
  public var asNeeded: KotlinBoolean? = null,
  public var _asNeeded: Element? = null,
  public var asNeededFor: CodeableConcept? = null,
  public var insurance: List<Reference>? = null,
  public var supportingInfo: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var relevantHistory: List<Reference>? = null,
) {
  public fun toModel(): DeviceRequest =
    DeviceRequest(
      id = this@DeviceRequestSurrogate.id,
      meta = this@DeviceRequestSurrogate.meta,
      implicitRules =
        Uri.of(
          this@DeviceRequestSurrogate.implicitRules,
          this@DeviceRequestSurrogate._implicitRules,
        ),
      language =
        Code.of(this@DeviceRequestSurrogate.language, this@DeviceRequestSurrogate._language),
      text = this@DeviceRequestSurrogate.text,
      contained = this@DeviceRequestSurrogate.contained ?: listOf(),
      extension = this@DeviceRequestSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceRequestSurrogate.modifierExtension ?: listOf(),
      identifier = this@DeviceRequestSurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        if (
          this@DeviceRequestSurrogate.instantiatesCanonical == null &&
            this@DeviceRequestSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@DeviceRequestSurrogate.instantiatesCanonical
              ?: List(this@DeviceRequestSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@DeviceRequestSurrogate._instantiatesCanonical
                ?: List(this@DeviceRequestSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@DeviceRequestSurrogate.instantiatesUri == null &&
            this@DeviceRequestSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@DeviceRequestSurrogate.instantiatesUri
              ?: List(this@DeviceRequestSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@DeviceRequestSurrogate._instantiatesUri
                ?: List(this@DeviceRequestSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      basedOn = this@DeviceRequestSurrogate.basedOn ?: listOf(),
      replaces = this@DeviceRequestSurrogate.replaces ?: listOf(),
      groupIdentifier = this@DeviceRequestSurrogate.groupIdentifier,
      status =
        this@DeviceRequestSurrogate.status?.let {
          Enumeration.of(
            DeviceRequest.RequestStatus.fromCode(it),
            this@DeviceRequestSurrogate._status,
          )
        },
      intent =
        Enumeration.of(
          DeviceRequest.RequestIntent.fromCode(this@DeviceRequestSurrogate.intent!!),
          this@DeviceRequestSurrogate._intent,
        ),
      priority =
        this@DeviceRequestSurrogate.priority?.let {
          Enumeration.of(
            DeviceRequest.RequestPriority.fromCode(it),
            this@DeviceRequestSurrogate._priority,
          )
        },
      doNotPerform =
        R5Boolean.of(
          this@DeviceRequestSurrogate.doNotPerform,
          this@DeviceRequestSurrogate._doNotPerform,
        ),
      code = this@DeviceRequestSurrogate.code,
      quantity =
        Integer.of(this@DeviceRequestSurrogate.quantity, this@DeviceRequestSurrogate._quantity),
      parameter = this@DeviceRequestSurrogate.parameter ?: listOf(),
      subject = this@DeviceRequestSurrogate.subject,
      encounter = this@DeviceRequestSurrogate.encounter,
      occurrence = this@DeviceRequestSurrogate.occurrence,
      authoredOn =
        DateTime.of(
          FhirDateTime.fromString(this@DeviceRequestSurrogate.authoredOn),
          this@DeviceRequestSurrogate._authoredOn,
        ),
      requester = this@DeviceRequestSurrogate.requester,
      performer = this@DeviceRequestSurrogate.performer,
      reason = this@DeviceRequestSurrogate.reason ?: listOf(),
      asNeeded =
        R5Boolean.of(this@DeviceRequestSurrogate.asNeeded, this@DeviceRequestSurrogate._asNeeded),
      asNeededFor = this@DeviceRequestSurrogate.asNeededFor,
      insurance = this@DeviceRequestSurrogate.insurance ?: listOf(),
      supportingInfo = this@DeviceRequestSurrogate.supportingInfo ?: listOf(),
      note = this@DeviceRequestSurrogate.note ?: listOf(),
      relevantHistory = this@DeviceRequestSurrogate.relevantHistory ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceRequest): DeviceRequestSurrogate =
      with(model) {
        DeviceRequestSurrogate(
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
          replaces = this@with.replaces.takeIf { it.isNotEmpty() },
          groupIdentifier = this@with.groupIdentifier,
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          intent = this@with.intent.value?.getCode(),
          _intent = this@with.intent.toElement(),
          priority = this@with.priority?.value?.getCode(),
          _priority = this@with.priority?.toElement(),
          doNotPerform = this@with.doNotPerform?.value,
          _doNotPerform = this@with.doNotPerform?.toElement(),
          code = this@with.code,
          quantity = this@with.quantity?.value,
          _quantity = this@with.quantity?.toElement(),
          parameter = this@with.parameter.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          encounter = this@with.encounter,
          occurrence = this@with.occurrence,
          authoredOn = this@with.authoredOn?.value?.toString(),
          _authoredOn = this@with.authoredOn?.toElement(),
          requester = this@with.requester,
          performer = this@with.performer,
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          asNeeded = this@with.asNeeded?.value,
          _asNeeded = this@with.asNeeded?.toElement(),
          asNeededFor = this@with.asNeededFor,
          insurance = this@with.insurance.takeIf { it.isNotEmpty() },
          supportingInfo = this@with.supportingInfo.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          relevantHistory = this@with.relevantHistory.takeIf { it.isNotEmpty() },
        )
      }
  }
}
