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
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.ChargeItem
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.MonetaryComponent
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ChargeItemPerformerSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var function: CodeableConcept? = null,
  public var actor: Reference,
) {
  public fun toModel(): ChargeItem.Performer =
    ChargeItem.Performer(
      id = this@ChargeItemPerformerSurrogate.id,
      extension = this@ChargeItemPerformerSurrogate.extension ?: listOf(),
      modifierExtension = this@ChargeItemPerformerSurrogate.modifierExtension ?: listOf(),
      function = this@ChargeItemPerformerSurrogate.function,
      actor = this@ChargeItemPerformerSurrogate.actor,
    )

  public companion object {
    public fun fromModel(model: ChargeItem.Performer): ChargeItemPerformerSurrogate =
      with(model) {
        ChargeItemPerformerSurrogate(
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
internal data class ChargeItemOccurrenceSurrogate(
  public var occurrenceDateTime: String? = null,
  public var _occurrenceDateTime: Element? = null,
  public var occurrencePeriod: Period? = null,
  public var occurrenceTiming: Timing? = null,
) {
  public fun toModel(): ChargeItem.Occurrence =
    ChargeItem.Occurrence.from(
      DateTime.of(
        FhirDateTime.fromString(this@ChargeItemOccurrenceSurrogate.occurrenceDateTime),
        this@ChargeItemOccurrenceSurrogate._occurrenceDateTime,
      ),
      this@ChargeItemOccurrenceSurrogate.occurrencePeriod,
      this@ChargeItemOccurrenceSurrogate.occurrenceTiming,
    )!!

  public companion object {
    public fun fromModel(model: ChargeItem.Occurrence): ChargeItemOccurrenceSurrogate =
      with(model) {
        ChargeItemOccurrenceSurrogate(
          occurrenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurrenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurrencePeriod = this@with.asPeriod()?.value,
          occurrenceTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class ChargeItemSurrogate(
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
  public var definitionUri: List<String?>? = null,
  public var _definitionUri: List<Element?>? = null,
  public var definitionCanonical: List<String?>? = null,
  public var _definitionCanonical: List<Element?>? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var partOf: List<Reference>? = null,
  public var code: CodeableConcept,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var occurrence: ChargeItem.Occurrence? = null,
  public var performer: List<ChargeItem.Performer>? = null,
  public var performingOrganization: Reference? = null,
  public var requestingOrganization: Reference? = null,
  public var costCenter: Reference? = null,
  public var quantity: Quantity? = null,
  public var bodysite: List<CodeableConcept>? = null,
  public var unitPriceComponent: MonetaryComponent? = null,
  public var totalPriceComponent: MonetaryComponent? = null,
  public var overrideReason: CodeableConcept? = null,
  public var enterer: Reference? = null,
  public var enteredDate: String? = null,
  public var _enteredDate: Element? = null,
  public var reason: List<CodeableConcept>? = null,
  public var service: List<CodeableReference>? = null,
  public var product: List<CodeableReference>? = null,
  public var account: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var supportingInformation: List<Reference>? = null,
) {
  public fun toModel(): ChargeItem =
    ChargeItem(
      id = this@ChargeItemSurrogate.id,
      meta = this@ChargeItemSurrogate.meta,
      implicitRules =
        Uri.of(this@ChargeItemSurrogate.implicitRules, this@ChargeItemSurrogate._implicitRules),
      language = Code.of(this@ChargeItemSurrogate.language, this@ChargeItemSurrogate._language),
      text = this@ChargeItemSurrogate.text,
      contained = this@ChargeItemSurrogate.contained ?: listOf(),
      extension = this@ChargeItemSurrogate.extension ?: listOf(),
      modifierExtension = this@ChargeItemSurrogate.modifierExtension ?: listOf(),
      identifier = this@ChargeItemSurrogate.identifier ?: listOf(),
      definitionUri =
        if (
          this@ChargeItemSurrogate.definitionUri == null &&
            this@ChargeItemSurrogate._definitionUri == null
        ) {
          listOf()
        } else {
          (this@ChargeItemSurrogate.definitionUri
              ?: List(this@ChargeItemSurrogate._definitionUri!!.size) { null })
            .zip(
              this@ChargeItemSurrogate._definitionUri
                ?: List(this@ChargeItemSurrogate.definitionUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      definitionCanonical =
        if (
          this@ChargeItemSurrogate.definitionCanonical == null &&
            this@ChargeItemSurrogate._definitionCanonical == null
        ) {
          listOf()
        } else {
          (this@ChargeItemSurrogate.definitionCanonical
              ?: List(this@ChargeItemSurrogate._definitionCanonical!!.size) { null })
            .zip(
              this@ChargeItemSurrogate._definitionCanonical
                ?: List(this@ChargeItemSurrogate.definitionCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      status =
        Enumeration.of(
          ChargeItem.ChargeItemStatus.fromCode(this@ChargeItemSurrogate.status!!),
          this@ChargeItemSurrogate._status,
        ),
      partOf = this@ChargeItemSurrogate.partOf ?: listOf(),
      code = this@ChargeItemSurrogate.code,
      subject = this@ChargeItemSurrogate.subject,
      encounter = this@ChargeItemSurrogate.encounter,
      occurrence = this@ChargeItemSurrogate.occurrence,
      performer = this@ChargeItemSurrogate.performer ?: listOf(),
      performingOrganization = this@ChargeItemSurrogate.performingOrganization,
      requestingOrganization = this@ChargeItemSurrogate.requestingOrganization,
      costCenter = this@ChargeItemSurrogate.costCenter,
      quantity = this@ChargeItemSurrogate.quantity,
      bodysite = this@ChargeItemSurrogate.bodysite ?: listOf(),
      unitPriceComponent = this@ChargeItemSurrogate.unitPriceComponent,
      totalPriceComponent = this@ChargeItemSurrogate.totalPriceComponent,
      overrideReason = this@ChargeItemSurrogate.overrideReason,
      enterer = this@ChargeItemSurrogate.enterer,
      enteredDate =
        DateTime.of(
          FhirDateTime.fromString(this@ChargeItemSurrogate.enteredDate),
          this@ChargeItemSurrogate._enteredDate,
        ),
      reason = this@ChargeItemSurrogate.reason ?: listOf(),
      service = this@ChargeItemSurrogate.service ?: listOf(),
      product = this@ChargeItemSurrogate.product ?: listOf(),
      account = this@ChargeItemSurrogate.account ?: listOf(),
      note = this@ChargeItemSurrogate.note ?: listOf(),
      supportingInformation = this@ChargeItemSurrogate.supportingInformation ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ChargeItem): ChargeItemSurrogate =
      with(model) {
        ChargeItemSurrogate(
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
          definitionUri =
            this@with.definitionUri.map { it.value }.toList().takeUnless { it.all { it == null } },
          _definitionUri =
            this@with.definitionUri
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          definitionCanonical =
            this@with.definitionCanonical
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _definitionCanonical =
            this@with.definitionCanonical
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          code = this@with.code,
          subject = this@with.subject,
          encounter = this@with.encounter,
          occurrence = this@with.occurrence,
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          performingOrganization = this@with.performingOrganization,
          requestingOrganization = this@with.requestingOrganization,
          costCenter = this@with.costCenter,
          quantity = this@with.quantity,
          bodysite = this@with.bodysite.takeIf { it.isNotEmpty() },
          unitPriceComponent = this@with.unitPriceComponent,
          totalPriceComponent = this@with.totalPriceComponent,
          overrideReason = this@with.overrideReason,
          enterer = this@with.enterer,
          enteredDate = this@with.enteredDate?.value?.toString(),
          _enteredDate = this@with.enteredDate?.toElement(),
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          service = this@with.service.takeIf { it.isNotEmpty() },
          product = this@with.product.takeIf { it.isNotEmpty() },
          account = this@with.account.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          supportingInformation = this@with.supportingInformation.takeIf { it.isNotEmpty() },
        )
      }
  }
}
