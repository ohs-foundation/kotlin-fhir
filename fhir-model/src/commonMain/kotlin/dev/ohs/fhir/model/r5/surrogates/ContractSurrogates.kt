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
import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.Contract
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Decimal
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Money
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Signature
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Time
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.UnsignedInt
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ContractContentDefinitionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var subType: CodeableConcept? = null,
  public var publisher: Reference? = null,
  public var publicationDate: KotlinString? = null,
  public var _publicationDate: Element? = null,
  public var publicationStatus: KotlinString? = null,
  public var _publicationStatus: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
) {
  public fun toModel(): Contract.ContentDefinition =
    Contract.ContentDefinition(
      id = this@ContractContentDefinitionSurrogate.id,
      extension = this@ContractContentDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractContentDefinitionSurrogate.modifierExtension ?: listOf(),
      type = this@ContractContentDefinitionSurrogate.type,
      subType = this@ContractContentDefinitionSurrogate.subType,
      publisher = this@ContractContentDefinitionSurrogate.publisher,
      publicationDate =
        DateTime.of(
          FhirDateTime.fromString(this@ContractContentDefinitionSurrogate.publicationDate),
          this@ContractContentDefinitionSurrogate._publicationDate,
        ),
      publicationStatus =
        Enumeration.of(
          Contract.ContractResourcePublicationStatusCodes.fromCode(
            this@ContractContentDefinitionSurrogate.publicationStatus!!
          ),
          this@ContractContentDefinitionSurrogate._publicationStatus,
        ),
      copyright =
        Markdown.of(
          this@ContractContentDefinitionSurrogate.copyright,
          this@ContractContentDefinitionSurrogate._copyright,
        ),
    )

  public companion object {
    public fun fromModel(model: Contract.ContentDefinition): ContractContentDefinitionSurrogate =
      with(model) {
        ContractContentDefinitionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          subType = this@with.subType,
          publisher = this@with.publisher,
          publicationDate = this@with.publicationDate?.value?.toString(),
          _publicationDate = this@with.publicationDate?.toElement(),
          publicationStatus = this@with.publicationStatus.value?.getCode(),
          _publicationStatus = this@with.publicationStatus.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ContractTermSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var issued: KotlinString? = null,
  public var _issued: Element? = null,
  public var applies: Period? = null,
  public var topic: Contract.Term.Topic? = null,
  public var type: CodeableConcept? = null,
  public var subType: CodeableConcept? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var securityLabel: List<Contract.Term.SecurityLabel>? = null,
  public var offer: Contract.Term.Offer,
  public var asset: List<Contract.Term.Asset>? = null,
  public var action: List<Contract.Term.Action>? = null,
  public var group: List<Contract.Term>? = null,
) {
  public fun toModel(): Contract.Term =
    Contract.Term(
      id = this@ContractTermSurrogate.id,
      extension = this@ContractTermSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermSurrogate.modifierExtension ?: listOf(),
      identifier = this@ContractTermSurrogate.identifier,
      issued =
        DateTime.of(
          FhirDateTime.fromString(this@ContractTermSurrogate.issued),
          this@ContractTermSurrogate._issued,
        ),
      applies = this@ContractTermSurrogate.applies,
      topic = this@ContractTermSurrogate.topic,
      type = this@ContractTermSurrogate.type,
      subType = this@ContractTermSurrogate.subType,
      text = R5String.of(this@ContractTermSurrogate.text, this@ContractTermSurrogate._text),
      securityLabel = this@ContractTermSurrogate.securityLabel ?: listOf(),
      offer = this@ContractTermSurrogate.offer,
      asset = this@ContractTermSurrogate.asset ?: listOf(),
      action = this@ContractTermSurrogate.action ?: listOf(),
      group = this@ContractTermSurrogate.group ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Contract.Term): ContractTermSurrogate =
      with(model) {
        ContractTermSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier,
          issued = this@with.issued?.value?.toString(),
          _issued = this@with.issued?.toElement(),
          applies = this@with.applies,
          topic = this@with.topic,
          type = this@with.type,
          subType = this@with.subType,
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          securityLabel = this@with.securityLabel.takeIf { it.isNotEmpty() },
          offer = this@with.offer,
          asset = this@with.asset.takeIf { it.isNotEmpty() },
          action = this@with.action.takeIf { it.isNotEmpty() },
          group = this@with.group.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ContractTermSecurityLabelSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var number: List<Int?>? = null,
  public var _number: List<Element?>? = null,
  public var classification: Coding,
  public var category: List<Coding>? = null,
  public var control: List<Coding>? = null,
) {
  public fun toModel(): Contract.Term.SecurityLabel =
    Contract.Term.SecurityLabel(
      id = this@ContractTermSecurityLabelSurrogate.id,
      extension = this@ContractTermSecurityLabelSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermSecurityLabelSurrogate.modifierExtension ?: listOf(),
      number =
        if (
          this@ContractTermSecurityLabelSurrogate.number == null &&
            this@ContractTermSecurityLabelSurrogate._number == null
        ) {
          listOf()
        } else {
          (this@ContractTermSecurityLabelSurrogate.number
              ?: List(this@ContractTermSecurityLabelSurrogate._number!!.size) { null })
            .zip(
              this@ContractTermSecurityLabelSurrogate._number
                ?: List(this@ContractTermSecurityLabelSurrogate.number!!.size) { null }
            )
            .map { (value, element) -> UnsignedInt.of(value, element)!! }
            .toList()
        },
      classification = this@ContractTermSecurityLabelSurrogate.classification,
      category = this@ContractTermSecurityLabelSurrogate.category ?: listOf(),
      control = this@ContractTermSecurityLabelSurrogate.control ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Contract.Term.SecurityLabel): ContractTermSecurityLabelSurrogate =
      with(model) {
        ContractTermSecurityLabelSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          number = this@with.number.map { it.value }.toList().takeUnless { it.all { it == null } },
          _number =
            this@with.number
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          classification = this@with.classification,
          category = this@with.category.takeIf { it.isNotEmpty() },
          control = this@with.control.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ContractTermOfferSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var party: List<Contract.Term.Offer.Party>? = null,
  public var topic: Reference? = null,
  public var type: CodeableConcept? = null,
  public var decision: CodeableConcept? = null,
  public var decisionMode: List<CodeableConcept>? = null,
  public var answer: List<Contract.Term.Offer.Answer>? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var linkId: List<KotlinString?>? = null,
  public var _linkId: List<Element?>? = null,
  public var securityLabelNumber: List<Int?>? = null,
  public var _securityLabelNumber: List<Element?>? = null,
) {
  public fun toModel(): Contract.Term.Offer =
    Contract.Term.Offer(
      id = this@ContractTermOfferSurrogate.id,
      extension = this@ContractTermOfferSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermOfferSurrogate.modifierExtension ?: listOf(),
      identifier = this@ContractTermOfferSurrogate.identifier ?: listOf(),
      party = this@ContractTermOfferSurrogate.party ?: listOf(),
      topic = this@ContractTermOfferSurrogate.topic,
      type = this@ContractTermOfferSurrogate.type,
      decision = this@ContractTermOfferSurrogate.decision,
      decisionMode = this@ContractTermOfferSurrogate.decisionMode ?: listOf(),
      answer = this@ContractTermOfferSurrogate.answer ?: listOf(),
      text =
        R5String.of(this@ContractTermOfferSurrogate.text, this@ContractTermOfferSurrogate._text),
      linkId =
        if (
          this@ContractTermOfferSurrogate.linkId == null &&
            this@ContractTermOfferSurrogate._linkId == null
        ) {
          listOf()
        } else {
          (this@ContractTermOfferSurrogate.linkId
              ?: List(this@ContractTermOfferSurrogate._linkId!!.size) { null })
            .zip(
              this@ContractTermOfferSurrogate._linkId
                ?: List(this@ContractTermOfferSurrogate.linkId!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      securityLabelNumber =
        if (
          this@ContractTermOfferSurrogate.securityLabelNumber == null &&
            this@ContractTermOfferSurrogate._securityLabelNumber == null
        ) {
          listOf()
        } else {
          (this@ContractTermOfferSurrogate.securityLabelNumber
              ?: List(this@ContractTermOfferSurrogate._securityLabelNumber!!.size) { null })
            .zip(
              this@ContractTermOfferSurrogate._securityLabelNumber
                ?: List(this@ContractTermOfferSurrogate.securityLabelNumber!!.size) { null }
            )
            .map { (value, element) -> UnsignedInt.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(model: Contract.Term.Offer): ContractTermOfferSurrogate =
      with(model) {
        ContractTermOfferSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          party = this@with.party.takeIf { it.isNotEmpty() },
          topic = this@with.topic,
          type = this@with.type,
          decision = this@with.decision,
          decisionMode = this@with.decisionMode.takeIf { it.isNotEmpty() },
          answer = this@with.answer.takeIf { it.isNotEmpty() },
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          linkId = this@with.linkId.map { it.value }.toList().takeUnless { it.all { it == null } },
          _linkId =
            this@with.linkId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          securityLabelNumber =
            this@with.securityLabelNumber
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _securityLabelNumber =
            this@with.securityLabelNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class ContractTermOfferPartySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var reference: List<Reference>? = null,
  public var role: CodeableConcept,
) {
  public fun toModel(): Contract.Term.Offer.Party =
    Contract.Term.Offer.Party(
      id = this@ContractTermOfferPartySurrogate.id,
      extension = this@ContractTermOfferPartySurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermOfferPartySurrogate.modifierExtension ?: listOf(),
      reference = this@ContractTermOfferPartySurrogate.reference ?: listOf(),
      role = this@ContractTermOfferPartySurrogate.role,
    )

  public companion object {
    public fun fromModel(model: Contract.Term.Offer.Party): ContractTermOfferPartySurrogate =
      with(model) {
        ContractTermOfferPartySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          reference = this@with.reference.takeIf { it.isNotEmpty() },
          role = this@with.role,
        )
      }
  }
}

@Serializable
internal data class ContractTermOfferAnswerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: Contract.Term.Offer.Answer.Value,
) {
  public fun toModel(): Contract.Term.Offer.Answer =
    Contract.Term.Offer.Answer(
      id = this@ContractTermOfferAnswerSurrogate.id,
      extension = this@ContractTermOfferAnswerSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermOfferAnswerSurrogate.modifierExtension ?: listOf(),
      `value` = this@ContractTermOfferAnswerSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: Contract.Term.Offer.Answer): ContractTermOfferAnswerSurrogate =
      with(model) {
        ContractTermOfferAnswerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class ContractTermAssetSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var scope: CodeableConcept? = null,
  public var type: List<CodeableConcept>? = null,
  public var typeReference: List<Reference>? = null,
  public var subtype: List<CodeableConcept>? = null,
  public var relationship: Coding? = null,
  public var context: List<Contract.Term.Asset.Context>? = null,
  public var condition: KotlinString? = null,
  public var _condition: Element? = null,
  public var periodType: List<CodeableConcept>? = null,
  public var period: List<Period>? = null,
  public var usePeriod: List<Period>? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var linkId: List<KotlinString?>? = null,
  public var _linkId: List<Element?>? = null,
  public var answer: List<Contract.Term.Offer.Answer>? = null,
  public var securityLabelNumber: List<Int?>? = null,
  public var _securityLabelNumber: List<Element?>? = null,
  public var valuedItem: List<Contract.Term.Asset.ValuedItem>? = null,
) {
  public fun toModel(): Contract.Term.Asset =
    Contract.Term.Asset(
      id = this@ContractTermAssetSurrogate.id,
      extension = this@ContractTermAssetSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermAssetSurrogate.modifierExtension ?: listOf(),
      scope = this@ContractTermAssetSurrogate.scope,
      type = this@ContractTermAssetSurrogate.type ?: listOf(),
      typeReference = this@ContractTermAssetSurrogate.typeReference ?: listOf(),
      subtype = this@ContractTermAssetSurrogate.subtype ?: listOf(),
      relationship = this@ContractTermAssetSurrogate.relationship,
      context = this@ContractTermAssetSurrogate.context ?: listOf(),
      condition =
        R5String.of(
          this@ContractTermAssetSurrogate.condition,
          this@ContractTermAssetSurrogate._condition,
        ),
      periodType = this@ContractTermAssetSurrogate.periodType ?: listOf(),
      period = this@ContractTermAssetSurrogate.period ?: listOf(),
      usePeriod = this@ContractTermAssetSurrogate.usePeriod ?: listOf(),
      text =
        R5String.of(this@ContractTermAssetSurrogate.text, this@ContractTermAssetSurrogate._text),
      linkId =
        if (
          this@ContractTermAssetSurrogate.linkId == null &&
            this@ContractTermAssetSurrogate._linkId == null
        ) {
          listOf()
        } else {
          (this@ContractTermAssetSurrogate.linkId
              ?: List(this@ContractTermAssetSurrogate._linkId!!.size) { null })
            .zip(
              this@ContractTermAssetSurrogate._linkId
                ?: List(this@ContractTermAssetSurrogate.linkId!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      answer = this@ContractTermAssetSurrogate.answer ?: listOf(),
      securityLabelNumber =
        if (
          this@ContractTermAssetSurrogate.securityLabelNumber == null &&
            this@ContractTermAssetSurrogate._securityLabelNumber == null
        ) {
          listOf()
        } else {
          (this@ContractTermAssetSurrogate.securityLabelNumber
              ?: List(this@ContractTermAssetSurrogate._securityLabelNumber!!.size) { null })
            .zip(
              this@ContractTermAssetSurrogate._securityLabelNumber
                ?: List(this@ContractTermAssetSurrogate.securityLabelNumber!!.size) { null }
            )
            .map { (value, element) -> UnsignedInt.of(value, element)!! }
            .toList()
        },
      valuedItem = this@ContractTermAssetSurrogate.valuedItem ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Contract.Term.Asset): ContractTermAssetSurrogate =
      with(model) {
        ContractTermAssetSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          scope = this@with.scope,
          type = this@with.type.takeIf { it.isNotEmpty() },
          typeReference = this@with.typeReference.takeIf { it.isNotEmpty() },
          subtype = this@with.subtype.takeIf { it.isNotEmpty() },
          relationship = this@with.relationship,
          context = this@with.context.takeIf { it.isNotEmpty() },
          condition = this@with.condition?.value,
          _condition = this@with.condition?.toElement(),
          periodType = this@with.periodType.takeIf { it.isNotEmpty() },
          period = this@with.period.takeIf { it.isNotEmpty() },
          usePeriod = this@with.usePeriod.takeIf { it.isNotEmpty() },
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          linkId = this@with.linkId.map { it.value }.toList().takeUnless { it.all { it == null } },
          _linkId =
            this@with.linkId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          answer = this@with.answer.takeIf { it.isNotEmpty() },
          securityLabelNumber =
            this@with.securityLabelNumber
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _securityLabelNumber =
            this@with.securityLabelNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          valuedItem = this@with.valuedItem.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ContractTermAssetContextSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var reference: Reference? = null,
  public var code: List<CodeableConcept>? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
) {
  public fun toModel(): Contract.Term.Asset.Context =
    Contract.Term.Asset.Context(
      id = this@ContractTermAssetContextSurrogate.id,
      extension = this@ContractTermAssetContextSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermAssetContextSurrogate.modifierExtension ?: listOf(),
      reference = this@ContractTermAssetContextSurrogate.reference,
      code = this@ContractTermAssetContextSurrogate.code ?: listOf(),
      text =
        R5String.of(
          this@ContractTermAssetContextSurrogate.text,
          this@ContractTermAssetContextSurrogate._text,
        ),
    )

  public companion object {
    public fun fromModel(model: Contract.Term.Asset.Context): ContractTermAssetContextSurrogate =
      with(model) {
        ContractTermAssetContextSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          reference = this@with.reference,
          code = this@with.code.takeIf { it.isNotEmpty() },
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ContractTermAssetValuedItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var entity: Contract.Term.Asset.ValuedItem.Entity? = null,
  public var identifier: Identifier? = null,
  public var effectiveTime: KotlinString? = null,
  public var _effectiveTime: Element? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var points: Double? = null,
  public var _points: Element? = null,
  public var net: Money? = null,
  public var payment: KotlinString? = null,
  public var _payment: Element? = null,
  public var paymentDate: KotlinString? = null,
  public var _paymentDate: Element? = null,
  public var responsible: Reference? = null,
  public var recipient: Reference? = null,
  public var linkId: List<KotlinString?>? = null,
  public var _linkId: List<Element?>? = null,
  public var securityLabelNumber: List<Int?>? = null,
  public var _securityLabelNumber: List<Element?>? = null,
) {
  public fun toModel(): Contract.Term.Asset.ValuedItem =
    Contract.Term.Asset.ValuedItem(
      id = this@ContractTermAssetValuedItemSurrogate.id,
      extension = this@ContractTermAssetValuedItemSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermAssetValuedItemSurrogate.modifierExtension ?: listOf(),
      entity = this@ContractTermAssetValuedItemSurrogate.entity,
      identifier = this@ContractTermAssetValuedItemSurrogate.identifier,
      effectiveTime =
        DateTime.of(
          FhirDateTime.fromString(this@ContractTermAssetValuedItemSurrogate.effectiveTime),
          this@ContractTermAssetValuedItemSurrogate._effectiveTime,
        ),
      quantity = this@ContractTermAssetValuedItemSurrogate.quantity,
      unitPrice = this@ContractTermAssetValuedItemSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ContractTermAssetValuedItemSurrogate.factor,
          this@ContractTermAssetValuedItemSurrogate._factor,
        ),
      points =
        Decimal.of(
          this@ContractTermAssetValuedItemSurrogate.points,
          this@ContractTermAssetValuedItemSurrogate._points,
        ),
      net = this@ContractTermAssetValuedItemSurrogate.net,
      payment =
        R5String.of(
          this@ContractTermAssetValuedItemSurrogate.payment,
          this@ContractTermAssetValuedItemSurrogate._payment,
        ),
      paymentDate =
        DateTime.of(
          FhirDateTime.fromString(this@ContractTermAssetValuedItemSurrogate.paymentDate),
          this@ContractTermAssetValuedItemSurrogate._paymentDate,
        ),
      responsible = this@ContractTermAssetValuedItemSurrogate.responsible,
      recipient = this@ContractTermAssetValuedItemSurrogate.recipient,
      linkId =
        if (
          this@ContractTermAssetValuedItemSurrogate.linkId == null &&
            this@ContractTermAssetValuedItemSurrogate._linkId == null
        ) {
          listOf()
        } else {
          (this@ContractTermAssetValuedItemSurrogate.linkId
              ?: List(this@ContractTermAssetValuedItemSurrogate._linkId!!.size) { null })
            .zip(
              this@ContractTermAssetValuedItemSurrogate._linkId
                ?: List(this@ContractTermAssetValuedItemSurrogate.linkId!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      securityLabelNumber =
        if (
          this@ContractTermAssetValuedItemSurrogate.securityLabelNumber == null &&
            this@ContractTermAssetValuedItemSurrogate._securityLabelNumber == null
        ) {
          listOf()
        } else {
          (this@ContractTermAssetValuedItemSurrogate.securityLabelNumber
              ?: List(this@ContractTermAssetValuedItemSurrogate._securityLabelNumber!!.size) {
                null
              })
            .zip(
              this@ContractTermAssetValuedItemSurrogate._securityLabelNumber
                ?: List(this@ContractTermAssetValuedItemSurrogate.securityLabelNumber!!.size) {
                  null
                }
            )
            .map { (value, element) -> UnsignedInt.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(
      model: Contract.Term.Asset.ValuedItem
    ): ContractTermAssetValuedItemSurrogate =
      with(model) {
        ContractTermAssetValuedItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          entity = this@with.entity,
          identifier = this@with.identifier,
          effectiveTime = this@with.effectiveTime?.value?.toString(),
          _effectiveTime = this@with.effectiveTime?.toElement(),
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          points = this@with.points?.value?.toString()?.toDouble(),
          _points = this@with.points?.toElement(),
          net = this@with.net,
          payment = this@with.payment?.value,
          _payment = this@with.payment?.toElement(),
          paymentDate = this@with.paymentDate?.value?.toString(),
          _paymentDate = this@with.paymentDate?.toElement(),
          responsible = this@with.responsible,
          recipient = this@with.recipient,
          linkId = this@with.linkId.map { it.value }.toList().takeUnless { it.all { it == null } },
          _linkId =
            this@with.linkId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          securityLabelNumber =
            this@with.securityLabelNumber
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _securityLabelNumber =
            this@with.securityLabelNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class ContractTermActionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var doNotPerform: KotlinBoolean? = null,
  public var _doNotPerform: Element? = null,
  public var type: CodeableConcept,
  public var subject: List<Contract.Term.Action.Subject>? = null,
  public var intent: CodeableConcept,
  public var linkId: List<KotlinString?>? = null,
  public var _linkId: List<Element?>? = null,
  public var status: CodeableConcept,
  public var context: Reference? = null,
  public var contextLinkId: List<KotlinString?>? = null,
  public var _contextLinkId: List<Element?>? = null,
  public var occurrence: Contract.Term.Action.Occurrence? = null,
  public var requester: List<Reference>? = null,
  public var requesterLinkId: List<KotlinString?>? = null,
  public var _requesterLinkId: List<Element?>? = null,
  public var performerType: List<CodeableConcept>? = null,
  public var performerRole: CodeableConcept? = null,
  public var performer: Reference? = null,
  public var performerLinkId: List<KotlinString?>? = null,
  public var _performerLinkId: List<Element?>? = null,
  public var reason: List<CodeableReference>? = null,
  public var reasonLinkId: List<KotlinString?>? = null,
  public var _reasonLinkId: List<Element?>? = null,
  public var note: List<Annotation>? = null,
  public var securityLabelNumber: List<Int?>? = null,
  public var _securityLabelNumber: List<Element?>? = null,
) {
  public fun toModel(): Contract.Term.Action =
    Contract.Term.Action(
      id = this@ContractTermActionSurrogate.id,
      extension = this@ContractTermActionSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermActionSurrogate.modifierExtension ?: listOf(),
      doNotPerform =
        R5Boolean.of(
          this@ContractTermActionSurrogate.doNotPerform,
          this@ContractTermActionSurrogate._doNotPerform,
        ),
      type = this@ContractTermActionSurrogate.type,
      subject = this@ContractTermActionSurrogate.subject ?: listOf(),
      intent = this@ContractTermActionSurrogate.intent,
      linkId =
        if (
          this@ContractTermActionSurrogate.linkId == null &&
            this@ContractTermActionSurrogate._linkId == null
        ) {
          listOf()
        } else {
          (this@ContractTermActionSurrogate.linkId
              ?: List(this@ContractTermActionSurrogate._linkId!!.size) { null })
            .zip(
              this@ContractTermActionSurrogate._linkId
                ?: List(this@ContractTermActionSurrogate.linkId!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      status = this@ContractTermActionSurrogate.status,
      context = this@ContractTermActionSurrogate.context,
      contextLinkId =
        if (
          this@ContractTermActionSurrogate.contextLinkId == null &&
            this@ContractTermActionSurrogate._contextLinkId == null
        ) {
          listOf()
        } else {
          (this@ContractTermActionSurrogate.contextLinkId
              ?: List(this@ContractTermActionSurrogate._contextLinkId!!.size) { null })
            .zip(
              this@ContractTermActionSurrogate._contextLinkId
                ?: List(this@ContractTermActionSurrogate.contextLinkId!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      occurrence = this@ContractTermActionSurrogate.occurrence,
      requester = this@ContractTermActionSurrogate.requester ?: listOf(),
      requesterLinkId =
        if (
          this@ContractTermActionSurrogate.requesterLinkId == null &&
            this@ContractTermActionSurrogate._requesterLinkId == null
        ) {
          listOf()
        } else {
          (this@ContractTermActionSurrogate.requesterLinkId
              ?: List(this@ContractTermActionSurrogate._requesterLinkId!!.size) { null })
            .zip(
              this@ContractTermActionSurrogate._requesterLinkId
                ?: List(this@ContractTermActionSurrogate.requesterLinkId!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      performerType = this@ContractTermActionSurrogate.performerType ?: listOf(),
      performerRole = this@ContractTermActionSurrogate.performerRole,
      performer = this@ContractTermActionSurrogate.performer,
      performerLinkId =
        if (
          this@ContractTermActionSurrogate.performerLinkId == null &&
            this@ContractTermActionSurrogate._performerLinkId == null
        ) {
          listOf()
        } else {
          (this@ContractTermActionSurrogate.performerLinkId
              ?: List(this@ContractTermActionSurrogate._performerLinkId!!.size) { null })
            .zip(
              this@ContractTermActionSurrogate._performerLinkId
                ?: List(this@ContractTermActionSurrogate.performerLinkId!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      reason = this@ContractTermActionSurrogate.reason ?: listOf(),
      reasonLinkId =
        if (
          this@ContractTermActionSurrogate.reasonLinkId == null &&
            this@ContractTermActionSurrogate._reasonLinkId == null
        ) {
          listOf()
        } else {
          (this@ContractTermActionSurrogate.reasonLinkId
              ?: List(this@ContractTermActionSurrogate._reasonLinkId!!.size) { null })
            .zip(
              this@ContractTermActionSurrogate._reasonLinkId
                ?: List(this@ContractTermActionSurrogate.reasonLinkId!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      note = this@ContractTermActionSurrogate.note ?: listOf(),
      securityLabelNumber =
        if (
          this@ContractTermActionSurrogate.securityLabelNumber == null &&
            this@ContractTermActionSurrogate._securityLabelNumber == null
        ) {
          listOf()
        } else {
          (this@ContractTermActionSurrogate.securityLabelNumber
              ?: List(this@ContractTermActionSurrogate._securityLabelNumber!!.size) { null })
            .zip(
              this@ContractTermActionSurrogate._securityLabelNumber
                ?: List(this@ContractTermActionSurrogate.securityLabelNumber!!.size) { null }
            )
            .map { (value, element) -> UnsignedInt.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(model: Contract.Term.Action): ContractTermActionSurrogate =
      with(model) {
        ContractTermActionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          doNotPerform = this@with.doNotPerform?.value,
          _doNotPerform = this@with.doNotPerform?.toElement(),
          type = this@with.type,
          subject = this@with.subject.takeIf { it.isNotEmpty() },
          intent = this@with.intent,
          linkId = this@with.linkId.map { it.value }.toList().takeUnless { it.all { it == null } },
          _linkId =
            this@with.linkId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          status = this@with.status,
          context = this@with.context,
          contextLinkId =
            this@with.contextLinkId.map { it.value }.toList().takeUnless { it.all { it == null } },
          _contextLinkId =
            this@with.contextLinkId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          occurrence = this@with.occurrence,
          requester = this@with.requester.takeIf { it.isNotEmpty() },
          requesterLinkId =
            this@with.requesterLinkId
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _requesterLinkId =
            this@with.requesterLinkId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          performerType = this@with.performerType.takeIf { it.isNotEmpty() },
          performerRole = this@with.performerRole,
          performer = this@with.performer,
          performerLinkId =
            this@with.performerLinkId
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _performerLinkId =
            this@with.performerLinkId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          reasonLinkId =
            this@with.reasonLinkId.map { it.value }.toList().takeUnless { it.all { it == null } },
          _reasonLinkId =
            this@with.reasonLinkId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          securityLabelNumber =
            this@with.securityLabelNumber
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _securityLabelNumber =
            this@with.securityLabelNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class ContractTermActionSubjectSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var reference: List<Reference>? = null,
  public var role: CodeableConcept? = null,
) {
  public fun toModel(): Contract.Term.Action.Subject =
    Contract.Term.Action.Subject(
      id = this@ContractTermActionSubjectSurrogate.id,
      extension = this@ContractTermActionSubjectSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractTermActionSubjectSurrogate.modifierExtension ?: listOf(),
      reference = this@ContractTermActionSubjectSurrogate.reference ?: listOf(),
      role = this@ContractTermActionSubjectSurrogate.role,
    )

  public companion object {
    public fun fromModel(model: Contract.Term.Action.Subject): ContractTermActionSubjectSurrogate =
      with(model) {
        ContractTermActionSubjectSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          reference = this@with.reference.takeIf { it.isNotEmpty() },
          role = this@with.role,
        )
      }
  }
}

@Serializable
internal data class ContractSignerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: Coding,
  public var party: Reference,
  public var signature: List<Signature>? = null,
) {
  public fun toModel(): Contract.Signer =
    Contract.Signer(
      id = this@ContractSignerSurrogate.id,
      extension = this@ContractSignerSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractSignerSurrogate.modifierExtension ?: listOf(),
      type = this@ContractSignerSurrogate.type,
      party = this@ContractSignerSurrogate.party,
      signature = this@ContractSignerSurrogate.signature ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Contract.Signer): ContractSignerSurrogate =
      with(model) {
        ContractSignerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          party = this@with.party,
          signature = this@with.signature.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ContractFriendlySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var content: Contract.Friendly.Content,
) {
  public fun toModel(): Contract.Friendly =
    Contract.Friendly(
      id = this@ContractFriendlySurrogate.id,
      extension = this@ContractFriendlySurrogate.extension ?: listOf(),
      modifierExtension = this@ContractFriendlySurrogate.modifierExtension ?: listOf(),
      content = this@ContractFriendlySurrogate.content,
    )

  public companion object {
    public fun fromModel(model: Contract.Friendly): ContractFriendlySurrogate =
      with(model) {
        ContractFriendlySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          content = this@with.content,
        )
      }
  }
}

@Serializable
internal data class ContractLegalSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var content: Contract.Legal.Content,
) {
  public fun toModel(): Contract.Legal =
    Contract.Legal(
      id = this@ContractLegalSurrogate.id,
      extension = this@ContractLegalSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractLegalSurrogate.modifierExtension ?: listOf(),
      content = this@ContractLegalSurrogate.content,
    )

  public companion object {
    public fun fromModel(model: Contract.Legal): ContractLegalSurrogate =
      with(model) {
        ContractLegalSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          content = this@with.content,
        )
      }
  }
}

@Serializable
internal data class ContractRuleSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var content: Contract.Rule.Content,
) {
  public fun toModel(): Contract.Rule =
    Contract.Rule(
      id = this@ContractRuleSurrogate.id,
      extension = this@ContractRuleSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractRuleSurrogate.modifierExtension ?: listOf(),
      content = this@ContractRuleSurrogate.content,
    )

  public companion object {
    public fun fromModel(model: Contract.Rule): ContractRuleSurrogate =
      with(model) {
        ContractRuleSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          content = this@with.content,
        )
      }
  }
}

@Serializable
internal data class ContractTopicSurrogate(
  public var topicCodeableConcept: CodeableConcept? = null,
  public var topicReference: Reference? = null,
) {
  public fun toModel(): Contract.Topic =
    Contract.Topic.from(
      this@ContractTopicSurrogate.topicCodeableConcept,
      this@ContractTopicSurrogate.topicReference,
    )!!

  public companion object {
    public fun fromModel(model: Contract.Topic): ContractTopicSurrogate =
      with(model) {
        ContractTopicSurrogate(
          topicCodeableConcept = this@with.asCodeableConcept()?.value,
          topicReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractTermTopicSurrogate(
  public var topicCodeableConcept: CodeableConcept? = null,
  public var topicReference: Reference? = null,
) {
  public fun toModel(): Contract.Term.Topic =
    Contract.Term.Topic.from(
      this@ContractTermTopicSurrogate.topicCodeableConcept,
      this@ContractTermTopicSurrogate.topicReference,
    )!!

  public companion object {
    public fun fromModel(model: Contract.Term.Topic): ContractTermTopicSurrogate =
      with(model) {
        ContractTermTopicSurrogate(
          topicCodeableConcept = this@with.asCodeableConcept()?.value,
          topicReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractTermOfferAnswerValueSurrogate(
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueUri: KotlinString? = null,
  public var _valueUri: Element? = null,
  public var valueAttachment: Attachment? = null,
  public var valueCoding: Coding? = null,
  public var valueQuantity: Quantity? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): Contract.Term.Offer.Answer.Value =
    Contract.Term.Offer.Answer.Value.from(
      R5Boolean.of(
        this@ContractTermOfferAnswerValueSurrogate.valueBoolean,
        this@ContractTermOfferAnswerValueSurrogate._valueBoolean,
      ),
      Decimal.of(
        this@ContractTermOfferAnswerValueSurrogate.valueDecimal,
        this@ContractTermOfferAnswerValueSurrogate._valueDecimal,
      ),
      Integer.of(
        this@ContractTermOfferAnswerValueSurrogate.valueInteger,
        this@ContractTermOfferAnswerValueSurrogate._valueInteger,
      ),
      Date.of(
        FhirDate.fromString(this@ContractTermOfferAnswerValueSurrogate.valueDate),
        this@ContractTermOfferAnswerValueSurrogate._valueDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ContractTermOfferAnswerValueSurrogate.valueDateTime),
        this@ContractTermOfferAnswerValueSurrogate._valueDateTime,
      ),
      Time.of(
        this@ContractTermOfferAnswerValueSurrogate.valueTime,
        this@ContractTermOfferAnswerValueSurrogate._valueTime,
      ),
      R5String.of(
        this@ContractTermOfferAnswerValueSurrogate.valueString,
        this@ContractTermOfferAnswerValueSurrogate._valueString,
      ),
      Uri.of(
        this@ContractTermOfferAnswerValueSurrogate.valueUri,
        this@ContractTermOfferAnswerValueSurrogate._valueUri,
      ),
      this@ContractTermOfferAnswerValueSurrogate.valueAttachment,
      this@ContractTermOfferAnswerValueSurrogate.valueCoding,
      this@ContractTermOfferAnswerValueSurrogate.valueQuantity,
      this@ContractTermOfferAnswerValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(
      model: Contract.Term.Offer.Answer.Value
    ): ContractTermOfferAnswerValueSurrogate =
      with(model) {
        ContractTermOfferAnswerValueSurrogate(
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueUri = this@with.asUri()?.value?.value,
          _valueUri = this@with.asUri()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
          valueCoding = this@with.asCoding()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractTermAssetValuedItemEntitySurrogate(
  public var entityCodeableConcept: CodeableConcept? = null,
  public var entityReference: Reference? = null,
) {
  public fun toModel(): Contract.Term.Asset.ValuedItem.Entity =
    Contract.Term.Asset.ValuedItem.Entity.from(
      this@ContractTermAssetValuedItemEntitySurrogate.entityCodeableConcept,
      this@ContractTermAssetValuedItemEntitySurrogate.entityReference,
    )!!

  public companion object {
    public fun fromModel(
      model: Contract.Term.Asset.ValuedItem.Entity
    ): ContractTermAssetValuedItemEntitySurrogate =
      with(model) {
        ContractTermAssetValuedItemEntitySurrogate(
          entityCodeableConcept = this@with.asCodeableConcept()?.value,
          entityReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractTermActionOccurrenceSurrogate(
  public var occurrenceDateTime: KotlinString? = null,
  public var _occurrenceDateTime: Element? = null,
  public var occurrencePeriod: Period? = null,
  public var occurrenceTiming: Timing? = null,
) {
  public fun toModel(): Contract.Term.Action.Occurrence =
    Contract.Term.Action.Occurrence.from(
      DateTime.of(
        FhirDateTime.fromString(this@ContractTermActionOccurrenceSurrogate.occurrenceDateTime),
        this@ContractTermActionOccurrenceSurrogate._occurrenceDateTime,
      ),
      this@ContractTermActionOccurrenceSurrogate.occurrencePeriod,
      this@ContractTermActionOccurrenceSurrogate.occurrenceTiming,
    )!!

  public companion object {
    public fun fromModel(
      model: Contract.Term.Action.Occurrence
    ): ContractTermActionOccurrenceSurrogate =
      with(model) {
        ContractTermActionOccurrenceSurrogate(
          occurrenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurrenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurrencePeriod = this@with.asPeriod()?.value,
          occurrenceTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractFriendlyContentSurrogate(
  public var contentAttachment: Attachment? = null,
  public var contentReference: Reference? = null,
) {
  public fun toModel(): Contract.Friendly.Content =
    Contract.Friendly.Content.from(
      this@ContractFriendlyContentSurrogate.contentAttachment,
      this@ContractFriendlyContentSurrogate.contentReference,
    )!!

  public companion object {
    public fun fromModel(model: Contract.Friendly.Content): ContractFriendlyContentSurrogate =
      with(model) {
        ContractFriendlyContentSurrogate(
          contentAttachment = this@with.asAttachment()?.value,
          contentReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractLegalContentSurrogate(
  public var contentAttachment: Attachment? = null,
  public var contentReference: Reference? = null,
) {
  public fun toModel(): Contract.Legal.Content =
    Contract.Legal.Content.from(
      this@ContractLegalContentSurrogate.contentAttachment,
      this@ContractLegalContentSurrogate.contentReference,
    )!!

  public companion object {
    public fun fromModel(model: Contract.Legal.Content): ContractLegalContentSurrogate =
      with(model) {
        ContractLegalContentSurrogate(
          contentAttachment = this@with.asAttachment()?.value,
          contentReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractRuleContentSurrogate(
  public var contentAttachment: Attachment? = null,
  public var contentReference: Reference? = null,
) {
  public fun toModel(): Contract.Rule.Content =
    Contract.Rule.Content.from(
      this@ContractRuleContentSurrogate.contentAttachment,
      this@ContractRuleContentSurrogate.contentReference,
    )!!

  public companion object {
    public fun fromModel(model: Contract.Rule.Content): ContractRuleContentSurrogate =
      with(model) {
        ContractRuleContentSurrogate(
          contentAttachment = this@with.asAttachment()?.value,
          contentReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractLegallyBindingSurrogate(
  public var legallyBindingAttachment: Attachment? = null,
  public var legallyBindingReference: Reference? = null,
) {
  public fun toModel(): Contract.LegallyBinding =
    Contract.LegallyBinding.from(
      this@ContractLegallyBindingSurrogate.legallyBindingAttachment,
      this@ContractLegallyBindingSurrogate.legallyBindingReference,
    )!!

  public companion object {
    public fun fromModel(model: Contract.LegallyBinding): ContractLegallyBindingSurrogate =
      with(model) {
        ContractLegallyBindingSurrogate(
          legallyBindingAttachment = this@with.asAttachment()?.value,
          legallyBindingReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ContractSurrogate(
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
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var legalState: CodeableConcept? = null,
  public var instantiatesCanonical: Reference? = null,
  public var instantiatesUri: KotlinString? = null,
  public var _instantiatesUri: Element? = null,
  public var contentDerivative: CodeableConcept? = null,
  public var issued: KotlinString? = null,
  public var _issued: Element? = null,
  public var applies: Period? = null,
  public var expirationType: CodeableConcept? = null,
  public var subject: List<Reference>? = null,
  public var authority: List<Reference>? = null,
  public var domain: List<Reference>? = null,
  public var site: List<Reference>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var subtitle: KotlinString? = null,
  public var _subtitle: Element? = null,
  public var alias: List<KotlinString?>? = null,
  public var _alias: List<Element?>? = null,
  public var author: Reference? = null,
  public var scope: CodeableConcept? = null,
  public var topic: Contract.Topic? = null,
  public var type: CodeableConcept? = null,
  public var subType: List<CodeableConcept>? = null,
  public var contentDefinition: Contract.ContentDefinition? = null,
  public var term: List<Contract.Term>? = null,
  public var supportingInfo: List<Reference>? = null,
  public var relevantHistory: List<Reference>? = null,
  public var signer: List<Contract.Signer>? = null,
  public var friendly: List<Contract.Friendly>? = null,
  public var legal: List<Contract.Legal>? = null,
  public var rule: List<Contract.Rule>? = null,
  public var legallyBinding: Contract.LegallyBinding? = null,
) {
  public fun toModel(): Contract =
    Contract(
      id = this@ContractSurrogate.id,
      meta = this@ContractSurrogate.meta,
      implicitRules =
        Uri.of(this@ContractSurrogate.implicitRules, this@ContractSurrogate._implicitRules),
      language = Code.of(this@ContractSurrogate.language, this@ContractSurrogate._language),
      text = this@ContractSurrogate.text,
      contained = this@ContractSurrogate.contained ?: listOf(),
      extension = this@ContractSurrogate.extension ?: listOf(),
      modifierExtension = this@ContractSurrogate.modifierExtension ?: listOf(),
      identifier = this@ContractSurrogate.identifier ?: listOf(),
      url = Uri.of(this@ContractSurrogate.url, this@ContractSurrogate._url),
      version = R5String.of(this@ContractSurrogate.version, this@ContractSurrogate._version),
      status =
        this@ContractSurrogate.status?.let {
          Enumeration.of(
            Contract.ContractResourceStatusCodes.fromCode(it),
            this@ContractSurrogate._status,
          )
        },
      legalState = this@ContractSurrogate.legalState,
      instantiatesCanonical = this@ContractSurrogate.instantiatesCanonical,
      instantiatesUri =
        Uri.of(this@ContractSurrogate.instantiatesUri, this@ContractSurrogate._instantiatesUri),
      contentDerivative = this@ContractSurrogate.contentDerivative,
      issued =
        DateTime.of(
          FhirDateTime.fromString(this@ContractSurrogate.issued),
          this@ContractSurrogate._issued,
        ),
      applies = this@ContractSurrogate.applies,
      expirationType = this@ContractSurrogate.expirationType,
      subject = this@ContractSurrogate.subject ?: listOf(),
      authority = this@ContractSurrogate.authority ?: listOf(),
      domain = this@ContractSurrogate.domain ?: listOf(),
      site = this@ContractSurrogate.site ?: listOf(),
      name = R5String.of(this@ContractSurrogate.name, this@ContractSurrogate._name),
      title = R5String.of(this@ContractSurrogate.title, this@ContractSurrogate._title),
      subtitle = R5String.of(this@ContractSurrogate.subtitle, this@ContractSurrogate._subtitle),
      alias =
        if (this@ContractSurrogate.alias == null && this@ContractSurrogate._alias == null) {
          listOf()
        } else {
          (this@ContractSurrogate.alias ?: List(this@ContractSurrogate._alias!!.size) { null })
            .zip(
              this@ContractSurrogate._alias ?: List(this@ContractSurrogate.alias!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      author = this@ContractSurrogate.author,
      scope = this@ContractSurrogate.scope,
      topic = this@ContractSurrogate.topic,
      type = this@ContractSurrogate.type,
      subType = this@ContractSurrogate.subType ?: listOf(),
      contentDefinition = this@ContractSurrogate.contentDefinition,
      term = this@ContractSurrogate.term ?: listOf(),
      supportingInfo = this@ContractSurrogate.supportingInfo ?: listOf(),
      relevantHistory = this@ContractSurrogate.relevantHistory ?: listOf(),
      signer = this@ContractSurrogate.signer ?: listOf(),
      friendly = this@ContractSurrogate.friendly ?: listOf(),
      legal = this@ContractSurrogate.legal ?: listOf(),
      rule = this@ContractSurrogate.rule ?: listOf(),
      legallyBinding = this@ContractSurrogate.legallyBinding,
    )

  public companion object {
    public fun fromModel(model: Contract): ContractSurrogate =
      with(model) {
        ContractSurrogate(
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
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          legalState = this@with.legalState,
          instantiatesCanonical = this@with.instantiatesCanonical,
          instantiatesUri = this@with.instantiatesUri?.value,
          _instantiatesUri = this@with.instantiatesUri?.toElement(),
          contentDerivative = this@with.contentDerivative,
          issued = this@with.issued?.value?.toString(),
          _issued = this@with.issued?.toElement(),
          applies = this@with.applies,
          expirationType = this@with.expirationType,
          subject = this@with.subject.takeIf { it.isNotEmpty() },
          authority = this@with.authority.takeIf { it.isNotEmpty() },
          domain = this@with.domain.takeIf { it.isNotEmpty() },
          site = this@with.site.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          subtitle = this@with.subtitle?.value,
          _subtitle = this@with.subtitle?.toElement(),
          alias = this@with.alias.map { it.value }.toList().takeUnless { it.all { it == null } },
          _alias =
            this@with.alias
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          author = this@with.author,
          scope = this@with.scope,
          topic = this@with.topic,
          type = this@with.type,
          subType = this@with.subType.takeIf { it.isNotEmpty() },
          contentDefinition = this@with.contentDefinition,
          term = this@with.term.takeIf { it.isNotEmpty() },
          supportingInfo = this@with.supportingInfo.takeIf { it.isNotEmpty() },
          relevantHistory = this@with.relevantHistory.takeIf { it.isNotEmpty() },
          signer = this@with.signer.takeIf { it.isNotEmpty() },
          friendly = this@with.friendly.takeIf { it.isNotEmpty() },
          legal = this@with.legal.takeIf { it.isNotEmpty() },
          rule = this@with.rule.takeIf { it.isNotEmpty() },
          legallyBinding = this@with.legallyBinding,
        )
      }
  }
}
