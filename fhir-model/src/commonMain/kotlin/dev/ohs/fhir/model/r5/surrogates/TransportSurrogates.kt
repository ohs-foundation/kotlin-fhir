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

import com.google.fhir.model.r5.Address
import com.google.fhir.model.r5.Age
import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Availability
import com.google.fhir.model.r5.Base64Binary
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactDetail
import com.google.fhir.model.r5.ContactPoint
import com.google.fhir.model.r5.Count
import com.google.fhir.model.r5.DataRequirement
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Decimal
import com.google.fhir.model.r5.Distance
import com.google.fhir.model.r5.Dosage
import com.google.fhir.model.r5.Duration
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Expression
import com.google.fhir.model.r5.ExtendedContactDetail
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.HumanName
import com.google.fhir.model.r5.Id
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Instant
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Integer64
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Money
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Oid
import com.google.fhir.model.r5.ParameterDefinition
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Ratio
import com.google.fhir.model.r5.RatioRange
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.SampledData
import com.google.fhir.model.r5.Signature
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Time
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.Transport
import com.google.fhir.model.r5.TriggerDefinition
import com.google.fhir.model.r5.UnsignedInt
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.Url
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.Uuid
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
internal data class TransportRestrictionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var repetitions: Int? = null,
  public var _repetitions: Element? = null,
  public var period: Period? = null,
  public var recipient: List<Reference>? = null,
) {
  public fun toModel(): Transport.Restriction =
    Transport.Restriction(
      id = this@TransportRestrictionSurrogate.id,
      extension = this@TransportRestrictionSurrogate.extension ?: listOf(),
      modifierExtension = this@TransportRestrictionSurrogate.modifierExtension ?: listOf(),
      repetitions =
        PositiveInt.of(
          this@TransportRestrictionSurrogate.repetitions,
          this@TransportRestrictionSurrogate._repetitions,
        ),
      period = this@TransportRestrictionSurrogate.period,
      recipient = this@TransportRestrictionSurrogate.recipient ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Transport.Restriction): TransportRestrictionSurrogate =
      with(model) {
        TransportRestrictionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          repetitions = this@with.repetitions?.value,
          _repetitions = this@with.repetitions?.toElement(),
          period = this@with.period,
          recipient = this@with.recipient.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class TransportInputSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: Transport.Input.Value,
) {
  public fun toModel(): Transport.Input =
    Transport.Input(
      id = this@TransportInputSurrogate.id,
      extension = this@TransportInputSurrogate.extension ?: listOf(),
      modifierExtension = this@TransportInputSurrogate.modifierExtension ?: listOf(),
      type = this@TransportInputSurrogate.type,
      `value` = this@TransportInputSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: Transport.Input): TransportInputSurrogate =
      with(model) {
        TransportInputSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class TransportOutputSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: Transport.Output.Value,
) {
  public fun toModel(): Transport.Output =
    Transport.Output(
      id = this@TransportOutputSurrogate.id,
      extension = this@TransportOutputSurrogate.extension ?: listOf(),
      modifierExtension = this@TransportOutputSurrogate.modifierExtension ?: listOf(),
      type = this@TransportOutputSurrogate.type,
      `value` = this@TransportOutputSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: Transport.Output): TransportOutputSurrogate =
      with(model) {
        TransportOutputSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class TransportInputValueSurrogate(
  public var valueBase64Binary: KotlinString? = null,
  public var _valueBase64Binary: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueCanonical: KotlinString? = null,
  public var _valueCanonical: Element? = null,
  public var valueCode: KotlinString? = null,
  public var _valueCode: Element? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
  public var valueId: KotlinString? = null,
  public var _valueId: Element? = null,
  public var valueInstant: KotlinString? = null,
  public var _valueInstant: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueInteger64: KotlinString? = null,
  public var _valueInteger64: Element? = null,
  public var valueMarkdown: KotlinString? = null,
  public var _valueMarkdown: Element? = null,
  public var valueOid: KotlinString? = null,
  public var _valueOid: Element? = null,
  public var valuePositiveInt: Int? = null,
  public var _valuePositiveInt: Element? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueUnsignedInt: Int? = null,
  public var _valueUnsignedInt: Element? = null,
  public var valueUri: KotlinString? = null,
  public var _valueUri: Element? = null,
  public var valueUrl: KotlinString? = null,
  public var _valueUrl: Element? = null,
  public var valueUuid: KotlinString? = null,
  public var _valueUuid: Element? = null,
  public var valueAddress: Address? = null,
  public var valueAge: Age? = null,
  public var valueAnnotation: Annotation? = null,
  public var valueAttachment: Attachment? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueCodeableReference: CodeableReference? = null,
  public var valueCoding: Coding? = null,
  public var valueContactPoint: ContactPoint? = null,
  public var valueCount: Count? = null,
  public var valueDistance: Distance? = null,
  public var valueDuration: Duration? = null,
  public var valueHumanName: HumanName? = null,
  public var valueIdentifier: Identifier? = null,
  public var valueMoney: Money? = null,
  public var valuePeriod: Period? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueRatio: Ratio? = null,
  public var valueRatioRange: RatioRange? = null,
  public var valueReference: Reference? = null,
  public var valueSampledData: SampledData? = null,
  public var valueSignature: Signature? = null,
  public var valueTiming: Timing? = null,
  public var valueContactDetail: ContactDetail? = null,
  public var valueDataRequirement: DataRequirement? = null,
  public var valueExpression: Expression? = null,
  public var valueParameterDefinition: ParameterDefinition? = null,
  public var valueRelatedArtifact: RelatedArtifact? = null,
  public var valueTriggerDefinition: TriggerDefinition? = null,
  public var valueUsageContext: UsageContext? = null,
  public var valueAvailability: Availability? = null,
  public var valueExtendedContactDetail: ExtendedContactDetail? = null,
  public var valueDosage: Dosage? = null,
  public var valueMeta: Meta? = null,
) {
  public fun toModel(): Transport.Input.Value =
    Transport.Input.Value.from(
      Base64Binary.of(
        this@TransportInputValueSurrogate.valueBase64Binary,
        this@TransportInputValueSurrogate._valueBase64Binary,
      ),
      R5Boolean.of(
        this@TransportInputValueSurrogate.valueBoolean,
        this@TransportInputValueSurrogate._valueBoolean,
      ),
      Canonical.of(
        this@TransportInputValueSurrogate.valueCanonical,
        this@TransportInputValueSurrogate._valueCanonical,
      ),
      Code.of(
        this@TransportInputValueSurrogate.valueCode,
        this@TransportInputValueSurrogate._valueCode,
      ),
      Date.of(
        FhirDate.fromString(this@TransportInputValueSurrogate.valueDate),
        this@TransportInputValueSurrogate._valueDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@TransportInputValueSurrogate.valueDateTime),
        this@TransportInputValueSurrogate._valueDateTime,
      ),
      Decimal.of(
        this@TransportInputValueSurrogate.valueDecimal,
        this@TransportInputValueSurrogate._valueDecimal,
      ),
      Id.of(this@TransportInputValueSurrogate.valueId, this@TransportInputValueSurrogate._valueId),
      Instant.of(
        FhirDateTime.fromString(this@TransportInputValueSurrogate.valueInstant),
        this@TransportInputValueSurrogate._valueInstant,
      ),
      Integer.of(
        this@TransportInputValueSurrogate.valueInteger,
        this@TransportInputValueSurrogate._valueInteger,
      ),
      Integer64.of(
        this@TransportInputValueSurrogate.valueInteger64?.toLong(),
        this@TransportInputValueSurrogate._valueInteger64,
      ),
      Markdown.of(
        this@TransportInputValueSurrogate.valueMarkdown,
        this@TransportInputValueSurrogate._valueMarkdown,
      ),
      Oid.of(
        this@TransportInputValueSurrogate.valueOid,
        this@TransportInputValueSurrogate._valueOid,
      ),
      PositiveInt.of(
        this@TransportInputValueSurrogate.valuePositiveInt,
        this@TransportInputValueSurrogate._valuePositiveInt,
      ),
      R5String.of(
        this@TransportInputValueSurrogate.valueString,
        this@TransportInputValueSurrogate._valueString,
      ),
      Time.of(
        this@TransportInputValueSurrogate.valueTime,
        this@TransportInputValueSurrogate._valueTime,
      ),
      UnsignedInt.of(
        this@TransportInputValueSurrogate.valueUnsignedInt,
        this@TransportInputValueSurrogate._valueUnsignedInt,
      ),
      Uri.of(
        this@TransportInputValueSurrogate.valueUri,
        this@TransportInputValueSurrogate._valueUri,
      ),
      Url.of(
        this@TransportInputValueSurrogate.valueUrl,
        this@TransportInputValueSurrogate._valueUrl,
      ),
      Uuid.of(
        this@TransportInputValueSurrogate.valueUuid,
        this@TransportInputValueSurrogate._valueUuid,
      ),
      this@TransportInputValueSurrogate.valueAddress,
      this@TransportInputValueSurrogate.valueAge,
      this@TransportInputValueSurrogate.valueAnnotation,
      this@TransportInputValueSurrogate.valueAttachment,
      this@TransportInputValueSurrogate.valueCodeableConcept,
      this@TransportInputValueSurrogate.valueCodeableReference,
      this@TransportInputValueSurrogate.valueCoding,
      this@TransportInputValueSurrogate.valueContactPoint,
      this@TransportInputValueSurrogate.valueCount,
      this@TransportInputValueSurrogate.valueDistance,
      this@TransportInputValueSurrogate.valueDuration,
      this@TransportInputValueSurrogate.valueHumanName,
      this@TransportInputValueSurrogate.valueIdentifier,
      this@TransportInputValueSurrogate.valueMoney,
      this@TransportInputValueSurrogate.valuePeriod,
      this@TransportInputValueSurrogate.valueQuantity,
      this@TransportInputValueSurrogate.valueRange,
      this@TransportInputValueSurrogate.valueRatio,
      this@TransportInputValueSurrogate.valueRatioRange,
      this@TransportInputValueSurrogate.valueReference,
      this@TransportInputValueSurrogate.valueSampledData,
      this@TransportInputValueSurrogate.valueSignature,
      this@TransportInputValueSurrogate.valueTiming,
      this@TransportInputValueSurrogate.valueContactDetail,
      this@TransportInputValueSurrogate.valueDataRequirement,
      this@TransportInputValueSurrogate.valueExpression,
      this@TransportInputValueSurrogate.valueParameterDefinition,
      this@TransportInputValueSurrogate.valueRelatedArtifact,
      this@TransportInputValueSurrogate.valueTriggerDefinition,
      this@TransportInputValueSurrogate.valueUsageContext,
      this@TransportInputValueSurrogate.valueAvailability,
      this@TransportInputValueSurrogate.valueExtendedContactDetail,
      this@TransportInputValueSurrogate.valueDosage,
      this@TransportInputValueSurrogate.valueMeta,
    )!!

  public companion object {
    public fun fromModel(model: Transport.Input.Value): TransportInputValueSurrogate =
      with(model) {
        TransportInputValueSurrogate(
          valueBase64Binary = this@with.asBase64Binary()?.value?.value,
          _valueBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueCanonical = this@with.asCanonical()?.value?.value,
          _valueCanonical = this@with.asCanonical()?.value?.toElement(),
          valueCode = this@with.asCode()?.value?.value,
          _valueCode = this@with.asCode()?.value?.toElement(),
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
          valueId = this@with.asId()?.value?.value,
          _valueId = this@with.asId()?.value?.toElement(),
          valueInstant = this@with.asInstant()?.value?.value?.toString(),
          _valueInstant = this@with.asInstant()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueInteger64 = this@with.asInteger64()?.value?.value?.toString(),
          _valueInteger64 = this@with.asInteger64()?.value?.toElement(),
          valueMarkdown = this@with.asMarkdown()?.value?.value,
          _valueMarkdown = this@with.asMarkdown()?.value?.toElement(),
          valueOid = this@with.asOid()?.value?.value,
          _valueOid = this@with.asOid()?.value?.toElement(),
          valuePositiveInt = this@with.asPositiveInt()?.value?.value,
          _valuePositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _valueUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          valueUri = this@with.asUri()?.value?.value,
          _valueUri = this@with.asUri()?.value?.toElement(),
          valueUrl = this@with.asUrl()?.value?.value,
          _valueUrl = this@with.asUrl()?.value?.toElement(),
          valueUuid = this@with.asUuid()?.value?.value,
          _valueUuid = this@with.asUuid()?.value?.toElement(),
          valueAddress = this@with.asAddress()?.value,
          valueAge = this@with.asAge()?.value,
          valueAnnotation = this@with.asAnnotation()?.value,
          valueAttachment = this@with.asAttachment()?.value,
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueCodeableReference = this@with.asCodeableReference()?.value,
          valueCoding = this@with.asCoding()?.value,
          valueContactPoint = this@with.asContactPoint()?.value,
          valueCount = this@with.asCount()?.value,
          valueDistance = this@with.asDistance()?.value,
          valueDuration = this@with.asDuration()?.value,
          valueHumanName = this@with.asHumanName()?.value,
          valueIdentifier = this@with.asIdentifier()?.value,
          valueMoney = this@with.asMoney()?.value,
          valuePeriod = this@with.asPeriod()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueRatio = this@with.asRatio()?.value,
          valueRatioRange = this@with.asRatioRange()?.value,
          valueReference = this@with.asReference()?.value,
          valueSampledData = this@with.asSampledData()?.value,
          valueSignature = this@with.asSignature()?.value,
          valueTiming = this@with.asTiming()?.value,
          valueContactDetail = this@with.asContactDetail()?.value,
          valueDataRequirement = this@with.asDataRequirement()?.value,
          valueExpression = this@with.asExpression()?.value,
          valueParameterDefinition = this@with.asParameterDefinition()?.value,
          valueRelatedArtifact = this@with.asRelatedArtifact()?.value,
          valueTriggerDefinition = this@with.asTriggerDefinition()?.value,
          valueUsageContext = this@with.asUsageContext()?.value,
          valueAvailability = this@with.asAvailability()?.value,
          valueExtendedContactDetail = this@with.asExtendedContactDetail()?.value,
          valueDosage = this@with.asDosage()?.value,
          valueMeta = this@with.asMeta()?.value,
        )
      }
  }
}

@Serializable
internal data class TransportOutputValueSurrogate(
  public var valueBase64Binary: KotlinString? = null,
  public var _valueBase64Binary: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueCanonical: KotlinString? = null,
  public var _valueCanonical: Element? = null,
  public var valueCode: KotlinString? = null,
  public var _valueCode: Element? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
  public var valueId: KotlinString? = null,
  public var _valueId: Element? = null,
  public var valueInstant: KotlinString? = null,
  public var _valueInstant: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueInteger64: KotlinString? = null,
  public var _valueInteger64: Element? = null,
  public var valueMarkdown: KotlinString? = null,
  public var _valueMarkdown: Element? = null,
  public var valueOid: KotlinString? = null,
  public var _valueOid: Element? = null,
  public var valuePositiveInt: Int? = null,
  public var _valuePositiveInt: Element? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueUnsignedInt: Int? = null,
  public var _valueUnsignedInt: Element? = null,
  public var valueUri: KotlinString? = null,
  public var _valueUri: Element? = null,
  public var valueUrl: KotlinString? = null,
  public var _valueUrl: Element? = null,
  public var valueUuid: KotlinString? = null,
  public var _valueUuid: Element? = null,
  public var valueAddress: Address? = null,
  public var valueAge: Age? = null,
  public var valueAnnotation: Annotation? = null,
  public var valueAttachment: Attachment? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueCodeableReference: CodeableReference? = null,
  public var valueCoding: Coding? = null,
  public var valueContactPoint: ContactPoint? = null,
  public var valueCount: Count? = null,
  public var valueDistance: Distance? = null,
  public var valueDuration: Duration? = null,
  public var valueHumanName: HumanName? = null,
  public var valueIdentifier: Identifier? = null,
  public var valueMoney: Money? = null,
  public var valuePeriod: Period? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueRatio: Ratio? = null,
  public var valueRatioRange: RatioRange? = null,
  public var valueReference: Reference? = null,
  public var valueSampledData: SampledData? = null,
  public var valueSignature: Signature? = null,
  public var valueTiming: Timing? = null,
  public var valueContactDetail: ContactDetail? = null,
  public var valueDataRequirement: DataRequirement? = null,
  public var valueExpression: Expression? = null,
  public var valueParameterDefinition: ParameterDefinition? = null,
  public var valueRelatedArtifact: RelatedArtifact? = null,
  public var valueTriggerDefinition: TriggerDefinition? = null,
  public var valueUsageContext: UsageContext? = null,
  public var valueAvailability: Availability? = null,
  public var valueExtendedContactDetail: ExtendedContactDetail? = null,
  public var valueDosage: Dosage? = null,
  public var valueMeta: Meta? = null,
) {
  public fun toModel(): Transport.Output.Value =
    Transport.Output.Value.from(
      Base64Binary.of(
        this@TransportOutputValueSurrogate.valueBase64Binary,
        this@TransportOutputValueSurrogate._valueBase64Binary,
      ),
      R5Boolean.of(
        this@TransportOutputValueSurrogate.valueBoolean,
        this@TransportOutputValueSurrogate._valueBoolean,
      ),
      Canonical.of(
        this@TransportOutputValueSurrogate.valueCanonical,
        this@TransportOutputValueSurrogate._valueCanonical,
      ),
      Code.of(
        this@TransportOutputValueSurrogate.valueCode,
        this@TransportOutputValueSurrogate._valueCode,
      ),
      Date.of(
        FhirDate.fromString(this@TransportOutputValueSurrogate.valueDate),
        this@TransportOutputValueSurrogate._valueDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@TransportOutputValueSurrogate.valueDateTime),
        this@TransportOutputValueSurrogate._valueDateTime,
      ),
      Decimal.of(
        this@TransportOutputValueSurrogate.valueDecimal,
        this@TransportOutputValueSurrogate._valueDecimal,
      ),
      Id.of(
        this@TransportOutputValueSurrogate.valueId,
        this@TransportOutputValueSurrogate._valueId,
      ),
      Instant.of(
        FhirDateTime.fromString(this@TransportOutputValueSurrogate.valueInstant),
        this@TransportOutputValueSurrogate._valueInstant,
      ),
      Integer.of(
        this@TransportOutputValueSurrogate.valueInteger,
        this@TransportOutputValueSurrogate._valueInteger,
      ),
      Integer64.of(
        this@TransportOutputValueSurrogate.valueInteger64?.toLong(),
        this@TransportOutputValueSurrogate._valueInteger64,
      ),
      Markdown.of(
        this@TransportOutputValueSurrogate.valueMarkdown,
        this@TransportOutputValueSurrogate._valueMarkdown,
      ),
      Oid.of(
        this@TransportOutputValueSurrogate.valueOid,
        this@TransportOutputValueSurrogate._valueOid,
      ),
      PositiveInt.of(
        this@TransportOutputValueSurrogate.valuePositiveInt,
        this@TransportOutputValueSurrogate._valuePositiveInt,
      ),
      R5String.of(
        this@TransportOutputValueSurrogate.valueString,
        this@TransportOutputValueSurrogate._valueString,
      ),
      Time.of(
        this@TransportOutputValueSurrogate.valueTime,
        this@TransportOutputValueSurrogate._valueTime,
      ),
      UnsignedInt.of(
        this@TransportOutputValueSurrogate.valueUnsignedInt,
        this@TransportOutputValueSurrogate._valueUnsignedInt,
      ),
      Uri.of(
        this@TransportOutputValueSurrogate.valueUri,
        this@TransportOutputValueSurrogate._valueUri,
      ),
      Url.of(
        this@TransportOutputValueSurrogate.valueUrl,
        this@TransportOutputValueSurrogate._valueUrl,
      ),
      Uuid.of(
        this@TransportOutputValueSurrogate.valueUuid,
        this@TransportOutputValueSurrogate._valueUuid,
      ),
      this@TransportOutputValueSurrogate.valueAddress,
      this@TransportOutputValueSurrogate.valueAge,
      this@TransportOutputValueSurrogate.valueAnnotation,
      this@TransportOutputValueSurrogate.valueAttachment,
      this@TransportOutputValueSurrogate.valueCodeableConcept,
      this@TransportOutputValueSurrogate.valueCodeableReference,
      this@TransportOutputValueSurrogate.valueCoding,
      this@TransportOutputValueSurrogate.valueContactPoint,
      this@TransportOutputValueSurrogate.valueCount,
      this@TransportOutputValueSurrogate.valueDistance,
      this@TransportOutputValueSurrogate.valueDuration,
      this@TransportOutputValueSurrogate.valueHumanName,
      this@TransportOutputValueSurrogate.valueIdentifier,
      this@TransportOutputValueSurrogate.valueMoney,
      this@TransportOutputValueSurrogate.valuePeriod,
      this@TransportOutputValueSurrogate.valueQuantity,
      this@TransportOutputValueSurrogate.valueRange,
      this@TransportOutputValueSurrogate.valueRatio,
      this@TransportOutputValueSurrogate.valueRatioRange,
      this@TransportOutputValueSurrogate.valueReference,
      this@TransportOutputValueSurrogate.valueSampledData,
      this@TransportOutputValueSurrogate.valueSignature,
      this@TransportOutputValueSurrogate.valueTiming,
      this@TransportOutputValueSurrogate.valueContactDetail,
      this@TransportOutputValueSurrogate.valueDataRequirement,
      this@TransportOutputValueSurrogate.valueExpression,
      this@TransportOutputValueSurrogate.valueParameterDefinition,
      this@TransportOutputValueSurrogate.valueRelatedArtifact,
      this@TransportOutputValueSurrogate.valueTriggerDefinition,
      this@TransportOutputValueSurrogate.valueUsageContext,
      this@TransportOutputValueSurrogate.valueAvailability,
      this@TransportOutputValueSurrogate.valueExtendedContactDetail,
      this@TransportOutputValueSurrogate.valueDosage,
      this@TransportOutputValueSurrogate.valueMeta,
    )!!

  public companion object {
    public fun fromModel(model: Transport.Output.Value): TransportOutputValueSurrogate =
      with(model) {
        TransportOutputValueSurrogate(
          valueBase64Binary = this@with.asBase64Binary()?.value?.value,
          _valueBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueCanonical = this@with.asCanonical()?.value?.value,
          _valueCanonical = this@with.asCanonical()?.value?.toElement(),
          valueCode = this@with.asCode()?.value?.value,
          _valueCode = this@with.asCode()?.value?.toElement(),
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
          valueId = this@with.asId()?.value?.value,
          _valueId = this@with.asId()?.value?.toElement(),
          valueInstant = this@with.asInstant()?.value?.value?.toString(),
          _valueInstant = this@with.asInstant()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueInteger64 = this@with.asInteger64()?.value?.value?.toString(),
          _valueInteger64 = this@with.asInteger64()?.value?.toElement(),
          valueMarkdown = this@with.asMarkdown()?.value?.value,
          _valueMarkdown = this@with.asMarkdown()?.value?.toElement(),
          valueOid = this@with.asOid()?.value?.value,
          _valueOid = this@with.asOid()?.value?.toElement(),
          valuePositiveInt = this@with.asPositiveInt()?.value?.value,
          _valuePositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _valueUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          valueUri = this@with.asUri()?.value?.value,
          _valueUri = this@with.asUri()?.value?.toElement(),
          valueUrl = this@with.asUrl()?.value?.value,
          _valueUrl = this@with.asUrl()?.value?.toElement(),
          valueUuid = this@with.asUuid()?.value?.value,
          _valueUuid = this@with.asUuid()?.value?.toElement(),
          valueAddress = this@with.asAddress()?.value,
          valueAge = this@with.asAge()?.value,
          valueAnnotation = this@with.asAnnotation()?.value,
          valueAttachment = this@with.asAttachment()?.value,
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueCodeableReference = this@with.asCodeableReference()?.value,
          valueCoding = this@with.asCoding()?.value,
          valueContactPoint = this@with.asContactPoint()?.value,
          valueCount = this@with.asCount()?.value,
          valueDistance = this@with.asDistance()?.value,
          valueDuration = this@with.asDuration()?.value,
          valueHumanName = this@with.asHumanName()?.value,
          valueIdentifier = this@with.asIdentifier()?.value,
          valueMoney = this@with.asMoney()?.value,
          valuePeriod = this@with.asPeriod()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueRatio = this@with.asRatio()?.value,
          valueRatioRange = this@with.asRatioRange()?.value,
          valueReference = this@with.asReference()?.value,
          valueSampledData = this@with.asSampledData()?.value,
          valueSignature = this@with.asSignature()?.value,
          valueTiming = this@with.asTiming()?.value,
          valueContactDetail = this@with.asContactDetail()?.value,
          valueDataRequirement = this@with.asDataRequirement()?.value,
          valueExpression = this@with.asExpression()?.value,
          valueParameterDefinition = this@with.asParameterDefinition()?.value,
          valueRelatedArtifact = this@with.asRelatedArtifact()?.value,
          valueTriggerDefinition = this@with.asTriggerDefinition()?.value,
          valueUsageContext = this@with.asUsageContext()?.value,
          valueAvailability = this@with.asAvailability()?.value,
          valueExtendedContactDetail = this@with.asExtendedContactDetail()?.value,
          valueDosage = this@with.asDosage()?.value,
          valueMeta = this@with.asMeta()?.value,
        )
      }
  }
}

@Serializable
internal data class TransportSurrogate(
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
  public var instantiatesCanonical: KotlinString? = null,
  public var _instantiatesCanonical: Element? = null,
  public var instantiatesUri: KotlinString? = null,
  public var _instantiatesUri: Element? = null,
  public var basedOn: List<Reference>? = null,
  public var groupIdentifier: Identifier? = null,
  public var partOf: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: CodeableConcept? = null,
  public var intent: KotlinString? = null,
  public var _intent: Element? = null,
  public var priority: KotlinString? = null,
  public var _priority: Element? = null,
  public var code: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var focus: Reference? = null,
  public var `for`: Reference? = null,
  public var encounter: Reference? = null,
  public var completionTime: KotlinString? = null,
  public var _completionTime: Element? = null,
  public var authoredOn: KotlinString? = null,
  public var _authoredOn: Element? = null,
  public var lastModified: KotlinString? = null,
  public var _lastModified: Element? = null,
  public var requester: Reference? = null,
  public var performerType: List<CodeableConcept>? = null,
  public var owner: Reference? = null,
  public var location: Reference? = null,
  public var insurance: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var relevantHistory: List<Reference>? = null,
  public var restriction: Transport.Restriction? = null,
  public var input: List<Transport.Input>? = null,
  public var output: List<Transport.Output>? = null,
  public var requestedLocation: Reference,
  public var currentLocation: Reference,
  public var reason: CodeableReference? = null,
  public var history: Reference? = null,
) {
  public fun toModel(): Transport =
    Transport(
      id = this@TransportSurrogate.id,
      meta = this@TransportSurrogate.meta,
      implicitRules =
        Uri.of(this@TransportSurrogate.implicitRules, this@TransportSurrogate._implicitRules),
      language = Code.of(this@TransportSurrogate.language, this@TransportSurrogate._language),
      text = this@TransportSurrogate.text,
      contained = this@TransportSurrogate.contained ?: listOf(),
      extension = this@TransportSurrogate.extension ?: listOf(),
      modifierExtension = this@TransportSurrogate.modifierExtension ?: listOf(),
      identifier = this@TransportSurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        Canonical.of(
          this@TransportSurrogate.instantiatesCanonical,
          this@TransportSurrogate._instantiatesCanonical,
        ),
      instantiatesUri =
        Uri.of(this@TransportSurrogate.instantiatesUri, this@TransportSurrogate._instantiatesUri),
      basedOn = this@TransportSurrogate.basedOn ?: listOf(),
      groupIdentifier = this@TransportSurrogate.groupIdentifier,
      partOf = this@TransportSurrogate.partOf ?: listOf(),
      status =
        this@TransportSurrogate.status?.let {
          Enumeration.of(Transport.TransportStatus.fromCode(it), this@TransportSurrogate._status)
        },
      statusReason = this@TransportSurrogate.statusReason,
      intent =
        Enumeration.of(
          Transport.TransportIntent.fromCode(this@TransportSurrogate.intent!!),
          this@TransportSurrogate._intent,
        ),
      priority =
        this@TransportSurrogate.priority?.let {
          Enumeration.of(Transport.RequestPriority.fromCode(it), this@TransportSurrogate._priority)
        },
      code = this@TransportSurrogate.code,
      description =
        R5String.of(this@TransportSurrogate.description, this@TransportSurrogate._description),
      focus = this@TransportSurrogate.focus,
      `for` = this@TransportSurrogate.`for`,
      encounter = this@TransportSurrogate.encounter,
      completionTime =
        DateTime.of(
          FhirDateTime.fromString(this@TransportSurrogate.completionTime),
          this@TransportSurrogate._completionTime,
        ),
      authoredOn =
        DateTime.of(
          FhirDateTime.fromString(this@TransportSurrogate.authoredOn),
          this@TransportSurrogate._authoredOn,
        ),
      lastModified =
        DateTime.of(
          FhirDateTime.fromString(this@TransportSurrogate.lastModified),
          this@TransportSurrogate._lastModified,
        ),
      requester = this@TransportSurrogate.requester,
      performerType = this@TransportSurrogate.performerType ?: listOf(),
      owner = this@TransportSurrogate.owner,
      location = this@TransportSurrogate.location,
      insurance = this@TransportSurrogate.insurance ?: listOf(),
      note = this@TransportSurrogate.note ?: listOf(),
      relevantHistory = this@TransportSurrogate.relevantHistory ?: listOf(),
      restriction = this@TransportSurrogate.restriction,
      input = this@TransportSurrogate.input ?: listOf(),
      output = this@TransportSurrogate.output ?: listOf(),
      requestedLocation = this@TransportSurrogate.requestedLocation,
      currentLocation = this@TransportSurrogate.currentLocation,
      reason = this@TransportSurrogate.reason,
      history = this@TransportSurrogate.history,
    )

  public companion object {
    public fun fromModel(model: Transport): TransportSurrogate =
      with(model) {
        TransportSurrogate(
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
          instantiatesCanonical = this@with.instantiatesCanonical?.value,
          _instantiatesCanonical = this@with.instantiatesCanonical?.toElement(),
          instantiatesUri = this@with.instantiatesUri?.value,
          _instantiatesUri = this@with.instantiatesUri?.toElement(),
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          groupIdentifier = this@with.groupIdentifier,
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          statusReason = this@with.statusReason,
          intent = this@with.intent.value?.getCode(),
          _intent = this@with.intent.toElement(),
          priority = this@with.priority?.value?.getCode(),
          _priority = this@with.priority?.toElement(),
          code = this@with.code,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          focus = this@with.focus,
          `for` = this@with.`for`,
          encounter = this@with.encounter,
          completionTime = this@with.completionTime?.value?.toString(),
          _completionTime = this@with.completionTime?.toElement(),
          authoredOn = this@with.authoredOn?.value?.toString(),
          _authoredOn = this@with.authoredOn?.toElement(),
          lastModified = this@with.lastModified?.value?.toString(),
          _lastModified = this@with.lastModified?.toElement(),
          requester = this@with.requester,
          performerType = this@with.performerType.takeIf { it.isNotEmpty() },
          owner = this@with.owner,
          location = this@with.location,
          insurance = this@with.insurance.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          relevantHistory = this@with.relevantHistory.takeIf { it.isNotEmpty() },
          restriction = this@with.restriction,
          input = this@with.input.takeIf { it.isNotEmpty() },
          output = this@with.output.takeIf { it.isNotEmpty() },
          requestedLocation = this@with.requestedLocation,
          currentLocation = this@with.currentLocation,
          reason = this@with.reason,
          history = this@with.history,
        )
      }
  }
}
