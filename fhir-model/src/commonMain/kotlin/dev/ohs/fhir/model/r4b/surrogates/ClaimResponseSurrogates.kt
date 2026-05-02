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

import com.google.fhir.model.r4b.Address
import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.ClaimResponse
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Decimal
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Money
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.PositiveInt
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.NoteType
import com.google.fhir.model.r4b.terminologies.RemittanceOutcome
import kotlin.Boolean as KotlinBoolean
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ClaimResponseItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var itemSequence: Int? = null,
  public var _itemSequence: Element? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ClaimResponse.Item.Adjudication>? = null,
  public var detail: List<ClaimResponse.Item.Detail>? = null,
) {
  public fun toModel(): ClaimResponse.Item =
    ClaimResponse.Item(
      id = this@ClaimResponseItemSurrogate.id,
      extension = this@ClaimResponseItemSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseItemSurrogate.modifierExtension ?: listOf(),
      itemSequence =
        PositiveInt.of(
          this@ClaimResponseItemSurrogate.itemSequence,
          this@ClaimResponseItemSurrogate._itemSequence,
        )!!,
      noteNumber =
        if (
          this@ClaimResponseItemSurrogate.noteNumber == null &&
            this@ClaimResponseItemSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseItemSurrogate.noteNumber
              ?: List(this@ClaimResponseItemSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ClaimResponseItemSurrogate._noteNumber
                ?: List(this@ClaimResponseItemSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ClaimResponseItemSurrogate.adjudication ?: listOf(),
      detail = this@ClaimResponseItemSurrogate.detail ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.Item): ClaimResponseItemSurrogate =
      with(model) {
        ClaimResponseItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          itemSequence = this@with.itemSequence.value,
          _itemSequence = this@with.itemSequence.toElement(),
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          detail = this@with.detail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ClaimResponseItemAdjudicationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept,
  public var reason: CodeableConcept? = null,
  public var amount: Money? = null,
  public var `value`: Double? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): ClaimResponse.Item.Adjudication =
    ClaimResponse.Item.Adjudication(
      id = this@ClaimResponseItemAdjudicationSurrogate.id,
      extension = this@ClaimResponseItemAdjudicationSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseItemAdjudicationSurrogate.modifierExtension ?: listOf(),
      category = this@ClaimResponseItemAdjudicationSurrogate.category,
      reason = this@ClaimResponseItemAdjudicationSurrogate.reason,
      amount = this@ClaimResponseItemAdjudicationSurrogate.amount,
      `value` =
        Decimal.of(
          this@ClaimResponseItemAdjudicationSurrogate.`value`,
          this@ClaimResponseItemAdjudicationSurrogate._value,
        ),
    )

  public companion object {
    public fun fromModel(
      model: ClaimResponse.Item.Adjudication
    ): ClaimResponseItemAdjudicationSurrogate =
      with(model) {
        ClaimResponseItemAdjudicationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          reason = this@with.reason,
          amount = this@with.amount,
          `value` = this@with.`value`?.value?.toString()?.toDouble(),
          _value = this@with.`value`?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ClaimResponseItemDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var detailSequence: Int? = null,
  public var _detailSequence: Element? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ClaimResponse.Item.Adjudication>? = null,
  public var subDetail: List<ClaimResponse.Item.Detail.SubDetail>? = null,
) {
  public fun toModel(): ClaimResponse.Item.Detail =
    ClaimResponse.Item.Detail(
      id = this@ClaimResponseItemDetailSurrogate.id,
      extension = this@ClaimResponseItemDetailSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseItemDetailSurrogate.modifierExtension ?: listOf(),
      detailSequence =
        PositiveInt.of(
          this@ClaimResponseItemDetailSurrogate.detailSequence,
          this@ClaimResponseItemDetailSurrogate._detailSequence,
        )!!,
      noteNumber =
        if (
          this@ClaimResponseItemDetailSurrogate.noteNumber == null &&
            this@ClaimResponseItemDetailSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseItemDetailSurrogate.noteNumber
              ?: List(this@ClaimResponseItemDetailSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ClaimResponseItemDetailSurrogate._noteNumber
                ?: List(this@ClaimResponseItemDetailSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ClaimResponseItemDetailSurrogate.adjudication ?: listOf(),
      subDetail = this@ClaimResponseItemDetailSurrogate.subDetail ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.Item.Detail): ClaimResponseItemDetailSurrogate =
      with(model) {
        ClaimResponseItemDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          detailSequence = this@with.detailSequence.value,
          _detailSequence = this@with.detailSequence.toElement(),
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          subDetail = this@with.subDetail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ClaimResponseItemDetailSubDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var subDetailSequence: Int? = null,
  public var _subDetailSequence: Element? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ClaimResponse.Item.Adjudication>? = null,
) {
  public fun toModel(): ClaimResponse.Item.Detail.SubDetail =
    ClaimResponse.Item.Detail.SubDetail(
      id = this@ClaimResponseItemDetailSubDetailSurrogate.id,
      extension = this@ClaimResponseItemDetailSubDetailSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ClaimResponseItemDetailSubDetailSurrogate.modifierExtension ?: listOf(),
      subDetailSequence =
        PositiveInt.of(
          this@ClaimResponseItemDetailSubDetailSurrogate.subDetailSequence,
          this@ClaimResponseItemDetailSubDetailSurrogate._subDetailSequence,
        )!!,
      noteNumber =
        if (
          this@ClaimResponseItemDetailSubDetailSurrogate.noteNumber == null &&
            this@ClaimResponseItemDetailSubDetailSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseItemDetailSubDetailSurrogate.noteNumber
              ?: List(this@ClaimResponseItemDetailSubDetailSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ClaimResponseItemDetailSubDetailSurrogate._noteNumber
                ?: List(this@ClaimResponseItemDetailSubDetailSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ClaimResponseItemDetailSubDetailSurrogate.adjudication ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ClaimResponse.Item.Detail.SubDetail
    ): ClaimResponseItemDetailSubDetailSurrogate =
      with(model) {
        ClaimResponseItemDetailSubDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          subDetailSequence = this@with.subDetailSequence.value,
          _subDetailSequence = this@with.subDetailSequence.toElement(),
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ClaimResponseAddItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var itemSequence: List<Int?>? = null,
  public var _itemSequence: List<Element?>? = null,
  public var detailSequence: List<Int?>? = null,
  public var _detailSequence: List<Element?>? = null,
  public var subdetailSequence: List<Int?>? = null,
  public var _subdetailSequence: List<Element?>? = null,
  public var provider: List<Reference>? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var programCode: List<CodeableConcept>? = null,
  public var serviced: ClaimResponse.AddItem.Serviced? = null,
  public var location: ClaimResponse.AddItem.Location? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var bodySite: CodeableConcept? = null,
  public var subSite: List<CodeableConcept>? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ClaimResponse.Item.Adjudication>? = null,
  public var detail: List<ClaimResponse.AddItem.Detail>? = null,
) {
  public fun toModel(): ClaimResponse.AddItem =
    ClaimResponse.AddItem(
      id = this@ClaimResponseAddItemSurrogate.id,
      extension = this@ClaimResponseAddItemSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseAddItemSurrogate.modifierExtension ?: listOf(),
      itemSequence =
        if (
          this@ClaimResponseAddItemSurrogate.itemSequence == null &&
            this@ClaimResponseAddItemSurrogate._itemSequence == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseAddItemSurrogate.itemSequence
              ?: List(this@ClaimResponseAddItemSurrogate._itemSequence!!.size) { null })
            .zip(
              this@ClaimResponseAddItemSurrogate._itemSequence
                ?: List(this@ClaimResponseAddItemSurrogate.itemSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      detailSequence =
        if (
          this@ClaimResponseAddItemSurrogate.detailSequence == null &&
            this@ClaimResponseAddItemSurrogate._detailSequence == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseAddItemSurrogate.detailSequence
              ?: List(this@ClaimResponseAddItemSurrogate._detailSequence!!.size) { null })
            .zip(
              this@ClaimResponseAddItemSurrogate._detailSequence
                ?: List(this@ClaimResponseAddItemSurrogate.detailSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      subdetailSequence =
        if (
          this@ClaimResponseAddItemSurrogate.subdetailSequence == null &&
            this@ClaimResponseAddItemSurrogate._subdetailSequence == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseAddItemSurrogate.subdetailSequence
              ?: List(this@ClaimResponseAddItemSurrogate._subdetailSequence!!.size) { null })
            .zip(
              this@ClaimResponseAddItemSurrogate._subdetailSequence
                ?: List(this@ClaimResponseAddItemSurrogate.subdetailSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      provider = this@ClaimResponseAddItemSurrogate.provider ?: listOf(),
      productOrService = this@ClaimResponseAddItemSurrogate.productOrService,
      modifier = this@ClaimResponseAddItemSurrogate.modifier ?: listOf(),
      programCode = this@ClaimResponseAddItemSurrogate.programCode ?: listOf(),
      serviced = this@ClaimResponseAddItemSurrogate.serviced,
      location = this@ClaimResponseAddItemSurrogate.location,
      quantity = this@ClaimResponseAddItemSurrogate.quantity,
      unitPrice = this@ClaimResponseAddItemSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ClaimResponseAddItemSurrogate.factor,
          this@ClaimResponseAddItemSurrogate._factor,
        ),
      net = this@ClaimResponseAddItemSurrogate.net,
      bodySite = this@ClaimResponseAddItemSurrogate.bodySite,
      subSite = this@ClaimResponseAddItemSurrogate.subSite ?: listOf(),
      noteNumber =
        if (
          this@ClaimResponseAddItemSurrogate.noteNumber == null &&
            this@ClaimResponseAddItemSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseAddItemSurrogate.noteNumber
              ?: List(this@ClaimResponseAddItemSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ClaimResponseAddItemSurrogate._noteNumber
                ?: List(this@ClaimResponseAddItemSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ClaimResponseAddItemSurrogate.adjudication ?: listOf(),
      detail = this@ClaimResponseAddItemSurrogate.detail ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.AddItem): ClaimResponseAddItemSurrogate =
      with(model) {
        ClaimResponseAddItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          itemSequence =
            this@with.itemSequence.map { it.value }.toList().takeUnless { it.all { it == null } },
          _itemSequence =
            this@with.itemSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          detailSequence =
            this@with.detailSequence.map { it.value }.toList().takeUnless { it.all { it == null } },
          _detailSequence =
            this@with.detailSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          subdetailSequence =
            this@with.subdetailSequence
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _subdetailSequence =
            this@with.subdetailSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          provider = this@with.provider.takeIf { it.isNotEmpty() },
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          programCode = this@with.programCode.takeIf { it.isNotEmpty() },
          serviced = this@with.serviced,
          location = this@with.location,
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          bodySite = this@with.bodySite,
          subSite = this@with.subSite.takeIf { it.isNotEmpty() },
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          detail = this@with.detail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ClaimResponseAddItemDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ClaimResponse.Item.Adjudication>? = null,
  public var subDetail: List<ClaimResponse.AddItem.Detail.SubDetail>? = null,
) {
  public fun toModel(): ClaimResponse.AddItem.Detail =
    ClaimResponse.AddItem.Detail(
      id = this@ClaimResponseAddItemDetailSurrogate.id,
      extension = this@ClaimResponseAddItemDetailSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseAddItemDetailSurrogate.modifierExtension ?: listOf(),
      productOrService = this@ClaimResponseAddItemDetailSurrogate.productOrService,
      modifier = this@ClaimResponseAddItemDetailSurrogate.modifier ?: listOf(),
      quantity = this@ClaimResponseAddItemDetailSurrogate.quantity,
      unitPrice = this@ClaimResponseAddItemDetailSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ClaimResponseAddItemDetailSurrogate.factor,
          this@ClaimResponseAddItemDetailSurrogate._factor,
        ),
      net = this@ClaimResponseAddItemDetailSurrogate.net,
      noteNumber =
        if (
          this@ClaimResponseAddItemDetailSurrogate.noteNumber == null &&
            this@ClaimResponseAddItemDetailSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseAddItemDetailSurrogate.noteNumber
              ?: List(this@ClaimResponseAddItemDetailSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ClaimResponseAddItemDetailSurrogate._noteNumber
                ?: List(this@ClaimResponseAddItemDetailSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ClaimResponseAddItemDetailSurrogate.adjudication ?: listOf(),
      subDetail = this@ClaimResponseAddItemDetailSurrogate.subDetail ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.AddItem.Detail): ClaimResponseAddItemDetailSurrogate =
      with(model) {
        ClaimResponseAddItemDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          subDetail = this@with.subDetail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ClaimResponseAddItemDetailSubDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ClaimResponse.Item.Adjudication>? = null,
) {
  public fun toModel(): ClaimResponse.AddItem.Detail.SubDetail =
    ClaimResponse.AddItem.Detail.SubDetail(
      id = this@ClaimResponseAddItemDetailSubDetailSurrogate.id,
      extension = this@ClaimResponseAddItemDetailSubDetailSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ClaimResponseAddItemDetailSubDetailSurrogate.modifierExtension ?: listOf(),
      productOrService = this@ClaimResponseAddItemDetailSubDetailSurrogate.productOrService,
      modifier = this@ClaimResponseAddItemDetailSubDetailSurrogate.modifier ?: listOf(),
      quantity = this@ClaimResponseAddItemDetailSubDetailSurrogate.quantity,
      unitPrice = this@ClaimResponseAddItemDetailSubDetailSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ClaimResponseAddItemDetailSubDetailSurrogate.factor,
          this@ClaimResponseAddItemDetailSubDetailSurrogate._factor,
        ),
      net = this@ClaimResponseAddItemDetailSubDetailSurrogate.net,
      noteNumber =
        if (
          this@ClaimResponseAddItemDetailSubDetailSurrogate.noteNumber == null &&
            this@ClaimResponseAddItemDetailSubDetailSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ClaimResponseAddItemDetailSubDetailSurrogate.noteNumber
              ?: List(this@ClaimResponseAddItemDetailSubDetailSurrogate._noteNumber!!.size) {
                null
              })
            .zip(
              this@ClaimResponseAddItemDetailSubDetailSurrogate._noteNumber
                ?: List(this@ClaimResponseAddItemDetailSubDetailSurrogate.noteNumber!!.size) {
                  null
                }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ClaimResponseAddItemDetailSubDetailSurrogate.adjudication ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ClaimResponse.AddItem.Detail.SubDetail
    ): ClaimResponseAddItemDetailSubDetailSurrogate =
      with(model) {
        ClaimResponseAddItemDetailSubDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ClaimResponseTotalSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept,
  public var amount: Money,
) {
  public fun toModel(): ClaimResponse.Total =
    ClaimResponse.Total(
      id = this@ClaimResponseTotalSurrogate.id,
      extension = this@ClaimResponseTotalSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseTotalSurrogate.modifierExtension ?: listOf(),
      category = this@ClaimResponseTotalSurrogate.category,
      amount = this@ClaimResponseTotalSurrogate.amount,
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.Total): ClaimResponseTotalSurrogate =
      with(model) {
        ClaimResponseTotalSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          amount = this@with.amount,
        )
      }
  }
}

@Serializable
internal data class ClaimResponsePaymentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var adjustment: Money? = null,
  public var adjustmentReason: CodeableConcept? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var amount: Money,
  public var identifier: Identifier? = null,
) {
  public fun toModel(): ClaimResponse.Payment =
    ClaimResponse.Payment(
      id = this@ClaimResponsePaymentSurrogate.id,
      extension = this@ClaimResponsePaymentSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponsePaymentSurrogate.modifierExtension ?: listOf(),
      type = this@ClaimResponsePaymentSurrogate.type,
      adjustment = this@ClaimResponsePaymentSurrogate.adjustment,
      adjustmentReason = this@ClaimResponsePaymentSurrogate.adjustmentReason,
      date =
        Date.of(
          FhirDate.fromString(this@ClaimResponsePaymentSurrogate.date),
          this@ClaimResponsePaymentSurrogate._date,
        ),
      amount = this@ClaimResponsePaymentSurrogate.amount,
      identifier = this@ClaimResponsePaymentSurrogate.identifier,
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.Payment): ClaimResponsePaymentSurrogate =
      with(model) {
        ClaimResponsePaymentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          adjustment = this@with.adjustment,
          adjustmentReason = this@with.adjustmentReason,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          amount = this@with.amount,
          identifier = this@with.identifier,
        )
      }
  }
}

@Serializable
internal data class ClaimResponseProcessNoteSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var number: Int? = null,
  public var _number: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var language: CodeableConcept? = null,
) {
  public fun toModel(): ClaimResponse.ProcessNote =
    ClaimResponse.ProcessNote(
      id = this@ClaimResponseProcessNoteSurrogate.id,
      extension = this@ClaimResponseProcessNoteSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseProcessNoteSurrogate.modifierExtension ?: listOf(),
      number =
        PositiveInt.of(
          this@ClaimResponseProcessNoteSurrogate.number,
          this@ClaimResponseProcessNoteSurrogate._number,
        ),
      type =
        this@ClaimResponseProcessNoteSurrogate.type?.let {
          Enumeration.of(NoteType.fromCode(it), this@ClaimResponseProcessNoteSurrogate._type)
        },
      text =
        R4bString.of(
          this@ClaimResponseProcessNoteSurrogate.text,
          this@ClaimResponseProcessNoteSurrogate._text,
        )!!,
      language = this@ClaimResponseProcessNoteSurrogate.language,
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.ProcessNote): ClaimResponseProcessNoteSurrogate =
      with(model) {
        ClaimResponseProcessNoteSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          number = this@with.number?.value,
          _number = this@with.number?.toElement(),
          type = this@with.type?.value?.getCode(),
          _type = this@with.type?.toElement(),
          text = this@with.text.value,
          _text = this@with.text.toElement(),
          language = this@with.language,
        )
      }
  }
}

@Serializable
internal data class ClaimResponseInsuranceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var focal: KotlinBoolean? = null,
  public var _focal: Element? = null,
  public var coverage: Reference,
  public var businessArrangement: KotlinString? = null,
  public var _businessArrangement: Element? = null,
  public var claimResponse: Reference? = null,
) {
  public fun toModel(): ClaimResponse.Insurance =
    ClaimResponse.Insurance(
      id = this@ClaimResponseInsuranceSurrogate.id,
      extension = this@ClaimResponseInsuranceSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseInsuranceSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@ClaimResponseInsuranceSurrogate.sequence,
          this@ClaimResponseInsuranceSurrogate._sequence,
        )!!,
      focal =
        R4bBoolean.of(
          this@ClaimResponseInsuranceSurrogate.focal,
          this@ClaimResponseInsuranceSurrogate._focal,
        )!!,
      coverage = this@ClaimResponseInsuranceSurrogate.coverage,
      businessArrangement =
        R4bString.of(
          this@ClaimResponseInsuranceSurrogate.businessArrangement,
          this@ClaimResponseInsuranceSurrogate._businessArrangement,
        ),
      claimResponse = this@ClaimResponseInsuranceSurrogate.claimResponse,
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.Insurance): ClaimResponseInsuranceSurrogate =
      with(model) {
        ClaimResponseInsuranceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          focal = this@with.focal.value,
          _focal = this@with.focal.toElement(),
          coverage = this@with.coverage,
          businessArrangement = this@with.businessArrangement?.value,
          _businessArrangement = this@with.businessArrangement?.toElement(),
          claimResponse = this@with.claimResponse,
        )
      }
  }
}

@Serializable
internal data class ClaimResponseErrorSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var itemSequence: Int? = null,
  public var _itemSequence: Element? = null,
  public var detailSequence: Int? = null,
  public var _detailSequence: Element? = null,
  public var subDetailSequence: Int? = null,
  public var _subDetailSequence: Element? = null,
  public var code: CodeableConcept,
) {
  public fun toModel(): ClaimResponse.Error =
    ClaimResponse.Error(
      id = this@ClaimResponseErrorSurrogate.id,
      extension = this@ClaimResponseErrorSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseErrorSurrogate.modifierExtension ?: listOf(),
      itemSequence =
        PositiveInt.of(
          this@ClaimResponseErrorSurrogate.itemSequence,
          this@ClaimResponseErrorSurrogate._itemSequence,
        ),
      detailSequence =
        PositiveInt.of(
          this@ClaimResponseErrorSurrogate.detailSequence,
          this@ClaimResponseErrorSurrogate._detailSequence,
        ),
      subDetailSequence =
        PositiveInt.of(
          this@ClaimResponseErrorSurrogate.subDetailSequence,
          this@ClaimResponseErrorSurrogate._subDetailSequence,
        ),
      code = this@ClaimResponseErrorSurrogate.code,
    )

  public companion object {
    public fun fromModel(model: ClaimResponse.Error): ClaimResponseErrorSurrogate =
      with(model) {
        ClaimResponseErrorSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          itemSequence = this@with.itemSequence?.value,
          _itemSequence = this@with.itemSequence?.toElement(),
          detailSequence = this@with.detailSequence?.value,
          _detailSequence = this@with.detailSequence?.toElement(),
          subDetailSequence = this@with.subDetailSequence?.value,
          _subDetailSequence = this@with.subDetailSequence?.toElement(),
          code = this@with.code,
        )
      }
  }
}

@Serializable
internal data class ClaimResponseAddItemServicedSurrogate(
  public var servicedDate: KotlinString? = null,
  public var _servicedDate: Element? = null,
  public var servicedPeriod: Period? = null,
) {
  public fun toModel(): ClaimResponse.AddItem.Serviced =
    ClaimResponse.AddItem.Serviced.from(
      Date.of(
        FhirDate.fromString(this@ClaimResponseAddItemServicedSurrogate.servicedDate),
        this@ClaimResponseAddItemServicedSurrogate._servicedDate,
      ),
      this@ClaimResponseAddItemServicedSurrogate.servicedPeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: ClaimResponse.AddItem.Serviced
    ): ClaimResponseAddItemServicedSurrogate =
      with(model) {
        ClaimResponseAddItemServicedSurrogate(
          servicedDate = this@with.asDate()?.value?.value?.toString(),
          _servicedDate = this@with.asDate()?.value?.toElement(),
          servicedPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class ClaimResponseAddItemLocationSurrogate(
  public var locationCodeableConcept: CodeableConcept? = null,
  public var locationAddress: Address? = null,
  public var locationReference: Reference? = null,
) {
  public fun toModel(): ClaimResponse.AddItem.Location =
    ClaimResponse.AddItem.Location.from(
      this@ClaimResponseAddItemLocationSurrogate.locationCodeableConcept,
      this@ClaimResponseAddItemLocationSurrogate.locationAddress,
      this@ClaimResponseAddItemLocationSurrogate.locationReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ClaimResponse.AddItem.Location
    ): ClaimResponseAddItemLocationSurrogate =
      with(model) {
        ClaimResponseAddItemLocationSurrogate(
          locationCodeableConcept = this@with.asCodeableConcept()?.value,
          locationAddress = this@with.asAddress()?.value,
          locationReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ClaimResponseSurrogate(
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
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var type: CodeableConcept,
  public var subType: CodeableConcept? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var patient: Reference,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var insurer: Reference,
  public var requestor: Reference? = null,
  public var request: Reference? = null,
  public var outcome: KotlinString? = null,
  public var _outcome: Element? = null,
  public var disposition: KotlinString? = null,
  public var _disposition: Element? = null,
  public var preAuthRef: KotlinString? = null,
  public var _preAuthRef: Element? = null,
  public var preAuthPeriod: Period? = null,
  public var payeeType: CodeableConcept? = null,
  public var item: List<ClaimResponse.Item>? = null,
  public var addItem: List<ClaimResponse.AddItem>? = null,
  public var adjudication: List<ClaimResponse.Item.Adjudication>? = null,
  public var total: List<ClaimResponse.Total>? = null,
  public var payment: ClaimResponse.Payment? = null,
  public var fundsReserve: CodeableConcept? = null,
  public var formCode: CodeableConcept? = null,
  public var form: Attachment? = null,
  public var processNote: List<ClaimResponse.ProcessNote>? = null,
  public var communicationRequest: List<Reference>? = null,
  public var insurance: List<ClaimResponse.Insurance>? = null,
  public var error: List<ClaimResponse.Error>? = null,
) {
  public fun toModel(): ClaimResponse =
    ClaimResponse(
      id = this@ClaimResponseSurrogate.id,
      meta = this@ClaimResponseSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ClaimResponseSurrogate.implicitRules,
          this@ClaimResponseSurrogate._implicitRules,
        ),
      language =
        Code.of(this@ClaimResponseSurrogate.language, this@ClaimResponseSurrogate._language),
      text = this@ClaimResponseSurrogate.text,
      contained = this@ClaimResponseSurrogate.contained ?: listOf(),
      extension = this@ClaimResponseSurrogate.extension ?: listOf(),
      modifierExtension = this@ClaimResponseSurrogate.modifierExtension ?: listOf(),
      identifier = this@ClaimResponseSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          ClaimResponse.FinancialResourceStatusCodes.fromCode(this@ClaimResponseSurrogate.status!!),
          this@ClaimResponseSurrogate._status,
        ),
      type = this@ClaimResponseSurrogate.type,
      subType = this@ClaimResponseSurrogate.subType,
      use =
        Enumeration.of(
          ClaimResponse.Use.fromCode(this@ClaimResponseSurrogate.use!!),
          this@ClaimResponseSurrogate._use,
        ),
      patient = this@ClaimResponseSurrogate.patient,
      created =
        DateTime.of(
          FhirDateTime.fromString(this@ClaimResponseSurrogate.created),
          this@ClaimResponseSurrogate._created,
        )!!,
      insurer = this@ClaimResponseSurrogate.insurer,
      requestor = this@ClaimResponseSurrogate.requestor,
      request = this@ClaimResponseSurrogate.request,
      outcome =
        Enumeration.of(
          RemittanceOutcome.fromCode(this@ClaimResponseSurrogate.outcome!!),
          this@ClaimResponseSurrogate._outcome,
        ),
      disposition =
        R4bString.of(
          this@ClaimResponseSurrogate.disposition,
          this@ClaimResponseSurrogate._disposition,
        ),
      preAuthRef =
        R4bString.of(
          this@ClaimResponseSurrogate.preAuthRef,
          this@ClaimResponseSurrogate._preAuthRef,
        ),
      preAuthPeriod = this@ClaimResponseSurrogate.preAuthPeriod,
      payeeType = this@ClaimResponseSurrogate.payeeType,
      item = this@ClaimResponseSurrogate.item ?: listOf(),
      addItem = this@ClaimResponseSurrogate.addItem ?: listOf(),
      adjudication = this@ClaimResponseSurrogate.adjudication ?: listOf(),
      total = this@ClaimResponseSurrogate.total ?: listOf(),
      payment = this@ClaimResponseSurrogate.payment,
      fundsReserve = this@ClaimResponseSurrogate.fundsReserve,
      formCode = this@ClaimResponseSurrogate.formCode,
      form = this@ClaimResponseSurrogate.form,
      processNote = this@ClaimResponseSurrogate.processNote ?: listOf(),
      communicationRequest = this@ClaimResponseSurrogate.communicationRequest ?: listOf(),
      insurance = this@ClaimResponseSurrogate.insurance ?: listOf(),
      error = this@ClaimResponseSurrogate.error ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ClaimResponse): ClaimResponseSurrogate =
      with(model) {
        ClaimResponseSurrogate(
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
          type = this@with.type,
          subType = this@with.subType,
          use = this@with.use.value?.getCode(),
          _use = this@with.use.toElement(),
          patient = this@with.patient,
          created = this@with.created.value?.toString(),
          _created = this@with.created.toElement(),
          insurer = this@with.insurer,
          requestor = this@with.requestor,
          request = this@with.request,
          outcome = this@with.outcome.value?.getCode(),
          _outcome = this@with.outcome.toElement(),
          disposition = this@with.disposition?.value,
          _disposition = this@with.disposition?.toElement(),
          preAuthRef = this@with.preAuthRef?.value,
          _preAuthRef = this@with.preAuthRef?.toElement(),
          preAuthPeriod = this@with.preAuthPeriod,
          payeeType = this@with.payeeType,
          item = this@with.item.takeIf { it.isNotEmpty() },
          addItem = this@with.addItem.takeIf { it.isNotEmpty() },
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          total = this@with.total.takeIf { it.isNotEmpty() },
          payment = this@with.payment,
          fundsReserve = this@with.fundsReserve,
          formCode = this@with.formCode,
          form = this@with.form,
          processNote = this@with.processNote.takeIf { it.isNotEmpty() },
          communicationRequest = this@with.communicationRequest.takeIf { it.isNotEmpty() },
          insurance = this@with.insurance.takeIf { it.isNotEmpty() },
          error = this@with.error.takeIf { it.isNotEmpty() },
        )
      }
  }
}
