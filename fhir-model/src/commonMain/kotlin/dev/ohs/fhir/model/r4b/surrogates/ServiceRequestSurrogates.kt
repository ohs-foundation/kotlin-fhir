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
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Range
import com.google.fhir.model.r4b.Ratio
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.ServiceRequest
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Timing
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ServiceRequestQuantitySurrogate(
  public var quantityQuantity: Quantity? = null,
  public var quantityRatio: Ratio? = null,
  public var quantityRange: Range? = null,
) {
  public fun toModel(): ServiceRequest.Quantity =
    ServiceRequest.Quantity.from(
      this@ServiceRequestQuantitySurrogate.quantityQuantity,
      this@ServiceRequestQuantitySurrogate.quantityRatio,
      this@ServiceRequestQuantitySurrogate.quantityRange,
    )!!

  public companion object {
    public fun fromModel(model: ServiceRequest.Quantity): ServiceRequestQuantitySurrogate =
      with(model) {
        ServiceRequestQuantitySurrogate(
          quantityQuantity = this@with.asQuantity()?.value,
          quantityRatio = this@with.asRatio()?.value,
          quantityRange = this@with.asRange()?.value,
        )
      }
  }
}

@Serializable
internal data class ServiceRequestOccurrenceSurrogate(
  public var occurrenceDateTime: KotlinString? = null,
  public var _occurrenceDateTime: Element? = null,
  public var occurrencePeriod: Period? = null,
  public var occurrenceTiming: Timing? = null,
) {
  public fun toModel(): ServiceRequest.Occurrence =
    ServiceRequest.Occurrence.from(
      DateTime.of(
        FhirDateTime.fromString(this@ServiceRequestOccurrenceSurrogate.occurrenceDateTime),
        this@ServiceRequestOccurrenceSurrogate._occurrenceDateTime,
      ),
      this@ServiceRequestOccurrenceSurrogate.occurrencePeriod,
      this@ServiceRequestOccurrenceSurrogate.occurrenceTiming,
    )!!

  public companion object {
    public fun fromModel(model: ServiceRequest.Occurrence): ServiceRequestOccurrenceSurrogate =
      with(model) {
        ServiceRequestOccurrenceSurrogate(
          occurrenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurrenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurrencePeriod = this@with.asPeriod()?.value,
          occurrenceTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class ServiceRequestAsNeededSurrogate(
  public var asNeededBoolean: KotlinBoolean? = null,
  public var _asNeededBoolean: Element? = null,
  public var asNeededCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): ServiceRequest.AsNeeded =
    ServiceRequest.AsNeeded.from(
      R4bBoolean.of(
        this@ServiceRequestAsNeededSurrogate.asNeededBoolean,
        this@ServiceRequestAsNeededSurrogate._asNeededBoolean,
      ),
      this@ServiceRequestAsNeededSurrogate.asNeededCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(model: ServiceRequest.AsNeeded): ServiceRequestAsNeededSurrogate =
      with(model) {
        ServiceRequestAsNeededSurrogate(
          asNeededBoolean = this@with.asBoolean()?.value?.value,
          _asNeededBoolean = this@with.asBoolean()?.value?.toElement(),
          asNeededCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class ServiceRequestSurrogate(
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
  public var replaces: List<Reference>? = null,
  public var requisition: Identifier? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var intent: KotlinString? = null,
  public var _intent: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var priority: KotlinString? = null,
  public var _priority: Element? = null,
  public var doNotPerform: KotlinBoolean? = null,
  public var _doNotPerform: Element? = null,
  public var code: CodeableConcept? = null,
  public var orderDetail: List<CodeableConcept>? = null,
  public var quantity: ServiceRequest.Quantity? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var occurrence: ServiceRequest.Occurrence? = null,
  public var asNeeded: ServiceRequest.AsNeeded? = null,
  public var authoredOn: KotlinString? = null,
  public var _authoredOn: Element? = null,
  public var requester: Reference? = null,
  public var performerType: CodeableConcept? = null,
  public var performer: List<Reference>? = null,
  public var locationCode: List<CodeableConcept>? = null,
  public var locationReference: List<Reference>? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var insurance: List<Reference>? = null,
  public var supportingInfo: List<Reference>? = null,
  public var specimen: List<Reference>? = null,
  public var bodySite: List<CodeableConcept>? = null,
  public var note: List<Annotation>? = null,
  public var patientInstruction: KotlinString? = null,
  public var _patientInstruction: Element? = null,
  public var relevantHistory: List<Reference>? = null,
) {
  public fun toModel(): ServiceRequest =
    ServiceRequest(
      id = this@ServiceRequestSurrogate.id,
      meta = this@ServiceRequestSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ServiceRequestSurrogate.implicitRules,
          this@ServiceRequestSurrogate._implicitRules,
        ),
      language =
        Code.of(this@ServiceRequestSurrogate.language, this@ServiceRequestSurrogate._language),
      text = this@ServiceRequestSurrogate.text,
      contained = this@ServiceRequestSurrogate.contained ?: listOf(),
      extension = this@ServiceRequestSurrogate.extension ?: listOf(),
      modifierExtension = this@ServiceRequestSurrogate.modifierExtension ?: listOf(),
      identifier = this@ServiceRequestSurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        if (
          this@ServiceRequestSurrogate.instantiatesCanonical == null &&
            this@ServiceRequestSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@ServiceRequestSurrogate.instantiatesCanonical
              ?: List(this@ServiceRequestSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@ServiceRequestSurrogate._instantiatesCanonical
                ?: List(this@ServiceRequestSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@ServiceRequestSurrogate.instantiatesUri == null &&
            this@ServiceRequestSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@ServiceRequestSurrogate.instantiatesUri
              ?: List(this@ServiceRequestSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@ServiceRequestSurrogate._instantiatesUri
                ?: List(this@ServiceRequestSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      basedOn = this@ServiceRequestSurrogate.basedOn ?: listOf(),
      replaces = this@ServiceRequestSurrogate.replaces ?: listOf(),
      requisition = this@ServiceRequestSurrogate.requisition,
      status =
        Enumeration.of(
          ServiceRequest.RequestStatus.fromCode(this@ServiceRequestSurrogate.status!!),
          this@ServiceRequestSurrogate._status,
        ),
      intent =
        Enumeration.of(
          ServiceRequest.RequestIntent.fromCode(this@ServiceRequestSurrogate.intent!!),
          this@ServiceRequestSurrogate._intent,
        ),
      category = this@ServiceRequestSurrogate.category ?: listOf(),
      priority =
        this@ServiceRequestSurrogate.priority?.let {
          Enumeration.of(
            ServiceRequest.RequestPriority.fromCode(it),
            this@ServiceRequestSurrogate._priority,
          )
        },
      doNotPerform =
        R4bBoolean.of(
          this@ServiceRequestSurrogate.doNotPerform,
          this@ServiceRequestSurrogate._doNotPerform,
        ),
      code = this@ServiceRequestSurrogate.code,
      orderDetail = this@ServiceRequestSurrogate.orderDetail ?: listOf(),
      quantity = this@ServiceRequestSurrogate.quantity,
      subject = this@ServiceRequestSurrogate.subject,
      encounter = this@ServiceRequestSurrogate.encounter,
      occurrence = this@ServiceRequestSurrogate.occurrence,
      asNeeded = this@ServiceRequestSurrogate.asNeeded,
      authoredOn =
        DateTime.of(
          FhirDateTime.fromString(this@ServiceRequestSurrogate.authoredOn),
          this@ServiceRequestSurrogate._authoredOn,
        ),
      requester = this@ServiceRequestSurrogate.requester,
      performerType = this@ServiceRequestSurrogate.performerType,
      performer = this@ServiceRequestSurrogate.performer ?: listOf(),
      locationCode = this@ServiceRequestSurrogate.locationCode ?: listOf(),
      locationReference = this@ServiceRequestSurrogate.locationReference ?: listOf(),
      reasonCode = this@ServiceRequestSurrogate.reasonCode ?: listOf(),
      reasonReference = this@ServiceRequestSurrogate.reasonReference ?: listOf(),
      insurance = this@ServiceRequestSurrogate.insurance ?: listOf(),
      supportingInfo = this@ServiceRequestSurrogate.supportingInfo ?: listOf(),
      specimen = this@ServiceRequestSurrogate.specimen ?: listOf(),
      bodySite = this@ServiceRequestSurrogate.bodySite ?: listOf(),
      note = this@ServiceRequestSurrogate.note ?: listOf(),
      patientInstruction =
        R4bString.of(
          this@ServiceRequestSurrogate.patientInstruction,
          this@ServiceRequestSurrogate._patientInstruction,
        ),
      relevantHistory = this@ServiceRequestSurrogate.relevantHistory ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ServiceRequest): ServiceRequestSurrogate =
      with(model) {
        ServiceRequestSurrogate(
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
          requisition = this@with.requisition,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          intent = this@with.intent.value?.getCode(),
          _intent = this@with.intent.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          priority = this@with.priority?.value?.getCode(),
          _priority = this@with.priority?.toElement(),
          doNotPerform = this@with.doNotPerform?.value,
          _doNotPerform = this@with.doNotPerform?.toElement(),
          code = this@with.code,
          orderDetail = this@with.orderDetail.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          subject = this@with.subject,
          encounter = this@with.encounter,
          occurrence = this@with.occurrence,
          asNeeded = this@with.asNeeded,
          authoredOn = this@with.authoredOn?.value?.toString(),
          _authoredOn = this@with.authoredOn?.toElement(),
          requester = this@with.requester,
          performerType = this@with.performerType,
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          locationCode = this@with.locationCode.takeIf { it.isNotEmpty() },
          locationReference = this@with.locationReference.takeIf { it.isNotEmpty() },
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          insurance = this@with.insurance.takeIf { it.isNotEmpty() },
          supportingInfo = this@with.supportingInfo.takeIf { it.isNotEmpty() },
          specimen = this@with.specimen.takeIf { it.isNotEmpty() },
          bodySite = this@with.bodySite.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          patientInstruction = this@with.patientInstruction?.value,
          _patientInstruction = this@with.patientInstruction?.toElement(),
          relevantHistory = this@with.relevantHistory.takeIf { it.isNotEmpty() },
        )
      }
  }
}
