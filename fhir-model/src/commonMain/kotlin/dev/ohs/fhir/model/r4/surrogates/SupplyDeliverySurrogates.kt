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
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.SupplyDelivery
import com.google.fhir.model.r4.Timing
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SupplyDeliverySuppliedItemSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var quantity: Quantity? = null,
  public var item: SupplyDelivery.SuppliedItem.Item? = null,
) {
  public fun toModel(): SupplyDelivery.SuppliedItem =
    SupplyDelivery.SuppliedItem(
      id = this@SupplyDeliverySuppliedItemSurrogate.id,
      extension = this@SupplyDeliverySuppliedItemSurrogate.extension ?: listOf(),
      modifierExtension = this@SupplyDeliverySuppliedItemSurrogate.modifierExtension ?: listOf(),
      quantity = this@SupplyDeliverySuppliedItemSurrogate.quantity,
      item = this@SupplyDeliverySuppliedItemSurrogate.item,
    )

  public companion object {
    public fun fromModel(model: SupplyDelivery.SuppliedItem): SupplyDeliverySuppliedItemSurrogate =
      with(model) {
        SupplyDeliverySuppliedItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          item = this@with.item,
        )
      }
  }
}

@Serializable
internal data class SupplyDeliverySuppliedItemItemSurrogate(
  public var itemCodeableConcept: CodeableConcept? = null,
  public var itemReference: Reference? = null,
) {
  public fun toModel(): SupplyDelivery.SuppliedItem.Item =
    SupplyDelivery.SuppliedItem.Item.from(
      this@SupplyDeliverySuppliedItemItemSurrogate.itemCodeableConcept,
      this@SupplyDeliverySuppliedItemItemSurrogate.itemReference,
    )!!

  public companion object {
    public fun fromModel(
      model: SupplyDelivery.SuppliedItem.Item
    ): SupplyDeliverySuppliedItemItemSurrogate =
      with(model) {
        SupplyDeliverySuppliedItemItemSurrogate(
          itemCodeableConcept = this@with.asCodeableConcept()?.value,
          itemReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class SupplyDeliveryOccurrenceSurrogate(
  public var occurrenceDateTime: String? = null,
  public var _occurrenceDateTime: Element? = null,
  public var occurrencePeriod: Period? = null,
  public var occurrenceTiming: Timing? = null,
) {
  public fun toModel(): SupplyDelivery.Occurrence =
    SupplyDelivery.Occurrence.from(
      DateTime.of(
        FhirDateTime.fromString(this@SupplyDeliveryOccurrenceSurrogate.occurrenceDateTime),
        this@SupplyDeliveryOccurrenceSurrogate._occurrenceDateTime,
      ),
      this@SupplyDeliveryOccurrenceSurrogate.occurrencePeriod,
      this@SupplyDeliveryOccurrenceSurrogate.occurrenceTiming,
    )!!

  public companion object {
    public fun fromModel(model: SupplyDelivery.Occurrence): SupplyDeliveryOccurrenceSurrogate =
      with(model) {
        SupplyDeliveryOccurrenceSurrogate(
          occurrenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurrenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurrencePeriod = this@with.asPeriod()?.value,
          occurrenceTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class SupplyDeliverySurrogate(
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
  public var patient: Reference? = null,
  public var type: CodeableConcept? = null,
  public var suppliedItem: SupplyDelivery.SuppliedItem? = null,
  public var occurrence: SupplyDelivery.Occurrence? = null,
  public var supplier: Reference? = null,
  public var destination: Reference? = null,
  public var `receiver`: List<Reference>? = null,
) {
  public fun toModel(): SupplyDelivery =
    SupplyDelivery(
      id = this@SupplyDeliverySurrogate.id,
      meta = this@SupplyDeliverySurrogate.meta,
      implicitRules =
        Uri.of(
          this@SupplyDeliverySurrogate.implicitRules,
          this@SupplyDeliverySurrogate._implicitRules,
        ),
      language =
        Code.of(this@SupplyDeliverySurrogate.language, this@SupplyDeliverySurrogate._language),
      text = this@SupplyDeliverySurrogate.text,
      contained = this@SupplyDeliverySurrogate.contained ?: listOf(),
      extension = this@SupplyDeliverySurrogate.extension ?: listOf(),
      modifierExtension = this@SupplyDeliverySurrogate.modifierExtension ?: listOf(),
      identifier = this@SupplyDeliverySurrogate.identifier ?: listOf(),
      basedOn = this@SupplyDeliverySurrogate.basedOn ?: listOf(),
      partOf = this@SupplyDeliverySurrogate.partOf ?: listOf(),
      status =
        this@SupplyDeliverySurrogate.status?.let {
          Enumeration.of(
            SupplyDelivery.SupplyDeliveryStatus.fromCode(it),
            this@SupplyDeliverySurrogate._status,
          )
        },
      patient = this@SupplyDeliverySurrogate.patient,
      type = this@SupplyDeliverySurrogate.type,
      suppliedItem = this@SupplyDeliverySurrogate.suppliedItem,
      occurrence = this@SupplyDeliverySurrogate.occurrence,
      supplier = this@SupplyDeliverySurrogate.supplier,
      destination = this@SupplyDeliverySurrogate.destination,
      `receiver` = this@SupplyDeliverySurrogate.`receiver` ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SupplyDelivery): SupplyDeliverySurrogate =
      with(model) {
        SupplyDeliverySurrogate(
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
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          patient = this@with.patient,
          type = this@with.type,
          suppliedItem = this@with.suppliedItem,
          occurrence = this@with.occurrence,
          supplier = this@with.supplier,
          destination = this@with.destination,
          `receiver` = this@with.`receiver`.takeIf { it.isNotEmpty() },
        )
      }
  }
}
