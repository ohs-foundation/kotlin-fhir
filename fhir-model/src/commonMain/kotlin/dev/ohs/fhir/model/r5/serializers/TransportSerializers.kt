/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r5.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.Age
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Availability
import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Count
import dev.ohs.fhir.model.r5.DataRequirement
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Distance
import dev.ohs.fhir.model.r5.Dosage
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Integer64
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Oid
import dev.ohs.fhir.model.r5.ParameterDefinition
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.RatioRange
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.SampledData
import dev.ohs.fhir.model.r5.Signature
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Transport
import dev.ohs.fhir.model.r5.TriggerDefinition
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.Uuid
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object TransportRestrictionSerializer : KSerializer<Transport.Restriction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Restriction") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("repetitions", Int.serializer().descriptor, isOptional = true)
      element("_repetitions", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element(
        "recipient",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Transport.Restriction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Transport.Restriction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Transport.Restriction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var repetitions: Int? = null
    var _repetitions: Element? = null
    var period: Period? = null
    var recipient: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> repetitions = decoder.decodeIntElement(__desc, 3)
        4 ->
          _repetitions =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.repetitionsSer, null)
        5 -> period = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.periodSer, null)
        6 ->
          recipient =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.recipientSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Restriction: " + __i)
      }
    }
    return Transport.Restriction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      repetitions = PositiveInt.of(repetitions, _repetitions),
      period = period,
      recipient = recipient ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Transport.Restriction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.repetitions?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.repetitions?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.repetitionsSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.periodSer, it) }
    if (value.recipient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.recipientSer, value.recipient)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val repetitionsSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val recipientSerInner: KSerializer<Reference> = Reference.serializer()

    public val recipientSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.recipientSerInner)
  }
}

internal object TransportInputSerializer : KSerializer<Transport.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueBase64Binary", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCanonical", Element.serializer().descriptor, isOptional = true)
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element("valueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueId", Element.serializer().descriptor, isOptional = true)
      element("valueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueInstant", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueInteger64", Element.serializer().descriptor, isOptional = true)
      element("valueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueMarkdown", Element.serializer().descriptor, isOptional = true)
      element("valueOid", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueOid", Element.serializer().descriptor, isOptional = true)
      element("valuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_valuePositiveInt", Element.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", Element.serializer().descriptor, isOptional = true)
      element("valueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_valueUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("valueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUri", Element.serializer().descriptor, isOptional = true)
      element("valueUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUrl", Element.serializer().descriptor, isOptional = true)
      element("valueUuid", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUuid", Element.serializer().descriptor, isOptional = true)
      element("valueAddress", Address.serializer().descriptor, isOptional = true)
      element("valueAge", Age.serializer().descriptor, isOptional = true)
      element("valueAnnotation", Annotation.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "valueCodeableReference",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueContactPoint", ContactPoint.serializer().descriptor, isOptional = true)
      element("valueCount", Count.serializer().descriptor, isOptional = true)
      element("valueDistance", Distance.serializer().descriptor, isOptional = true)
      element("valueDuration", Duration.serializer().descriptor, isOptional = true)
      element("valueHumanName", HumanName.serializer().descriptor, isOptional = true)
      element("valueIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("valueMoney", Money.serializer().descriptor, isOptional = true)
      element("valuePeriod", Period.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("valueRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("valueSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("valueSignature", Signature.serializer().descriptor, isOptional = true)
      element("valueTiming", Timing.serializer().descriptor, isOptional = true)
      element("valueContactDetail", ContactDetail.serializer().descriptor, isOptional = true)
      element("valueDataRequirement", DataRequirement.serializer().descriptor, isOptional = true)
      element("valueExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "valueParameterDefinition",
        ParameterDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("valueRelatedArtifact", RelatedArtifact.serializer().descriptor, isOptional = true)
      element(
        "valueTriggerDefinition",
        TriggerDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("valueUsageContext", UsageContext.serializer().descriptor, isOptional = true)
      element("valueAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "valueExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("valueDosage", Dosage.serializer().descriptor, isOptional = true)
      element("valueMeta", Meta.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Transport.Input =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Transport.Input) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Transport.Input {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueBase64Binary: KotlinString? = null
    var _valueBase64Binary: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueCanonical: KotlinString? = null
    var _valueCanonical: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valueDecimal: BigDecimal? = null
    var _valueDecimal: Element? = null
    var valueId: KotlinString? = null
    var _valueId: Element? = null
    var valueInstant: KotlinString? = null
    var _valueInstant: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueInteger64: KotlinString? = null
    var _valueInteger64: Element? = null
    var valueMarkdown: KotlinString? = null
    var _valueMarkdown: Element? = null
    var valueOid: KotlinString? = null
    var _valueOid: Element? = null
    var valuePositiveInt: Int? = null
    var _valuePositiveInt: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueUnsignedInt: Int? = null
    var _valueUnsignedInt: Element? = null
    var valueUri: KotlinString? = null
    var _valueUri: Element? = null
    var valueUrl: KotlinString? = null
    var _valueUrl: Element? = null
    var valueUuid: KotlinString? = null
    var _valueUuid: Element? = null
    var valueAddress: Address? = null
    var valueAge: Age? = null
    var valueAnnotation: Annotation? = null
    var valueAttachment: Attachment? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueCodeableReference: CodeableReference? = null
    var valueCoding: Coding? = null
    var valueContactPoint: ContactPoint? = null
    var valueCount: Count? = null
    var valueDistance: Distance? = null
    var valueDuration: Duration? = null
    var valueHumanName: HumanName? = null
    var valueIdentifier: Identifier? = null
    var valueMoney: Money? = null
    var valuePeriod: Period? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueRatio: Ratio? = null
    var valueRatioRange: RatioRange? = null
    var valueReference: Reference? = null
    var valueSampledData: SampledData? = null
    var valueSignature: Signature? = null
    var valueTiming: Timing? = null
    var valueContactDetail: ContactDetail? = null
    var valueDataRequirement: DataRequirement? = null
    var valueExpression: Expression? = null
    var valueParameterDefinition: ParameterDefinition? = null
    var valueRelatedArtifact: RelatedArtifact? = null
    var valueTriggerDefinition: TriggerDefinition? = null
    var valueUsageContext: UsageContext? = null
    var valueAvailability: Availability? = null
    var valueExtendedContactDetail: ExtendedContactDetail? = null
    var valueDosage: Dosage? = null
    var valueMeta: Meta? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> valueBase64Binary = decoder.decodeStringElement(__desc, 4)
        5 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueBase64BinarySer, null)
        6 -> valueBoolean = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueBase64BinarySer, null)
        8 -> valueCanonical = decoder.decodeStringElement(__desc, 8)
        9 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueBase64BinarySer, null)
        10 -> valueCode = decoder.decodeStringElement(__desc, 10)
        11 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.valueBase64BinarySer,
              null,
            )
        12 -> valueDate = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.valueBase64BinarySer,
              null,
            )
        14 -> valueDateTime = decoder.decodeStringElement(__desc, 14)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.valueBase64BinarySer,
              null,
            )
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 16, BigDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.valueBase64BinarySer,
              null,
            )
        18 -> valueId = decoder.decodeStringElement(__desc, 18)
        19 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.valueBase64BinarySer,
              null,
            )
        20 -> valueInstant = decoder.decodeStringElement(__desc, 20)
        21 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.valueBase64BinarySer,
              null,
            )
        22 -> valueInteger = decoder.decodeIntElement(__desc, 22)
        23 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              __desc,
              23,
              Hoisted.valueBase64BinarySer,
              null,
            )
        24 -> valueInteger64 = decoder.decodeStringElement(__desc, 24)
        25 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(
              __desc,
              25,
              Hoisted.valueBase64BinarySer,
              null,
            )
        26 -> valueMarkdown = decoder.decodeStringElement(__desc, 26)
        27 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              __desc,
              27,
              Hoisted.valueBase64BinarySer,
              null,
            )
        28 -> valueOid = decoder.decodeStringElement(__desc, 28)
        29 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              __desc,
              29,
              Hoisted.valueBase64BinarySer,
              null,
            )
        30 -> valuePositiveInt = decoder.decodeIntElement(__desc, 30)
        31 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              31,
              Hoisted.valueBase64BinarySer,
              null,
            )
        32 -> valueString = decoder.decodeStringElement(__desc, 32)
        33 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              __desc,
              33,
              Hoisted.valueBase64BinarySer,
              null,
            )
        34 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 34, LocalTimeSerializer, null)
        35 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              35,
              Hoisted.valueBase64BinarySer,
              null,
            )
        36 -> valueUnsignedInt = decoder.decodeIntElement(__desc, 36)
        37 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              37,
              Hoisted.valueBase64BinarySer,
              null,
            )
        38 -> valueUri = decoder.decodeStringElement(__desc, 38)
        39 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              39,
              Hoisted.valueBase64BinarySer,
              null,
            )
        40 -> valueUrl = decoder.decodeStringElement(__desc, 40)
        41 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              __desc,
              41,
              Hoisted.valueBase64BinarySer,
              null,
            )
        42 -> valueUuid = decoder.decodeStringElement(__desc, 42)
        43 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              __desc,
              43,
              Hoisted.valueBase64BinarySer,
              null,
            )
        44 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.valueAddressSer, null)
        45 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.valueAgeSer, null)
        46 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.valueAnnotationSer, null)
        47 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.valueAttachmentSer, null)
        48 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.typeSer, null)
        49 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              49,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        50 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.valueCodingSer, null)
        51 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              51,
              Hoisted.valueContactPointSer,
              null,
            )
        52 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.valueCountSer, null)
        53 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.valueDistanceSer, null)
        54 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.valueDurationSer, null)
        55 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.valueHumanNameSer, null)
        56 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.valueIdentifierSer, null)
        57 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.valueMoneySer, null)
        58 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.valuePeriodSer, null)
        59 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.valueQuantitySer, null)
        60 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.valueRangeSer, null)
        61 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.valueRatioSer, null)
        62 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.valueRatioRangeSer, null)
        63 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 63, Hoisted.valueReferenceSer, null)
        64 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.valueSampledDataSer, null)
        65 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, 65, Hoisted.valueSignatureSer, null)
        66 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.valueTimingSer, null)
        67 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              67,
              Hoisted.valueContactDetailSer,
              null,
            )
        68 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              68,
              Hoisted.valueDataRequirementSer,
              null,
            )
        69 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, 69, Hoisted.valueExpressionSer, null)
        70 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              70,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              71,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              72,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        73 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              73,
              Hoisted.valueUsageContextSer,
              null,
            )
        74 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              74,
              Hoisted.valueAvailabilitySer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              75,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        76 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, 76, Hoisted.valueDosageSer, null)
        77 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, 77, Hoisted.valueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Input: " + __i)
      }
    }
    return Transport.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        Transport.Input.Value.from(
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Canonical.of(valueCanonical, _valueCanonical),
          Code.of(valueCode, _valueCode),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(FhirDateTime.fromString(valueInstant), _valueInstant),
          Integer.of(valueInteger, _valueInteger),
          Integer64.of(valueInteger64?.toLong(), _valueInteger64),
          Markdown.of(valueMarkdown, _valueMarkdown),
          Oid.of(valueOid, _valueOid),
          PositiveInt.of(valuePositiveInt, _valuePositiveInt),
          R5String.of(valueString, _valueString),
          Time.of(valueTime, _valueTime),
          UnsignedInt.of(valueUnsignedInt, _valueUnsignedInt),
          Uri.of(valueUri, _valueUri),
          Url.of(valueUrl, _valueUrl),
          Uuid.of(valueUuid, _valueUuid),
          valueAddress,
          valueAge,
          valueAnnotation,
          valueAttachment,
          valueCodeableConcept,
          valueCodeableReference,
          valueCoding,
          valueContactPoint,
          valueCount,
          valueDistance,
          valueDuration,
          valueHumanName,
          valueIdentifier,
          valueMoney,
          valuePeriod,
          valueQuantity,
          valueRange,
          valueRatio,
          valueRatioRange,
          valueReference,
          valueSampledData,
          valueSignature,
          valueTiming,
          valueContactDetail,
          valueDataRequirement,
          valueExpression,
          valueParameterDefinition,
          valueRelatedArtifact,
          valueTriggerDefinition,
          valueUsageContext,
          valueAvailability,
          valueExtendedContactDetail,
          valueDosage,
          valueMeta,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Transport.Input) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is Transport.Input.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 16, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 19, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 25, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 27, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 29, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 30, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 31, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 33, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 34, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 35, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 36, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 37, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 39, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 41, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 43, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Input.Value.Address -> {
        encoder.encodeSerializableElement(__desc, 44, Hoisted.valueAddressSer, __d.value)
      }
      is Transport.Input.Value.Age -> {
        encoder.encodeSerializableElement(__desc, 45, Hoisted.valueAgeSer, __d.value)
      }
      is Transport.Input.Value.Annotation -> {
        encoder.encodeSerializableElement(__desc, 46, Hoisted.valueAnnotationSer, __d.value)
      }
      is Transport.Input.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 47, Hoisted.valueAttachmentSer, __d.value)
      }
      is Transport.Input.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 48, Hoisted.typeSer, __d.value)
      }
      is Transport.Input.Value.CodeableReference -> {
        encoder.encodeSerializableElement(__desc, 49, Hoisted.valueCodeableReferenceSer, __d.value)
      }
      is Transport.Input.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 50, Hoisted.valueCodingSer, __d.value)
      }
      is Transport.Input.Value.ContactPoint -> {
        encoder.encodeSerializableElement(__desc, 51, Hoisted.valueContactPointSer, __d.value)
      }
      is Transport.Input.Value.Count -> {
        encoder.encodeSerializableElement(__desc, 52, Hoisted.valueCountSer, __d.value)
      }
      is Transport.Input.Value.Distance -> {
        encoder.encodeSerializableElement(__desc, 53, Hoisted.valueDistanceSer, __d.value)
      }
      is Transport.Input.Value.Duration -> {
        encoder.encodeSerializableElement(__desc, 54, Hoisted.valueDurationSer, __d.value)
      }
      is Transport.Input.Value.HumanName -> {
        encoder.encodeSerializableElement(__desc, 55, Hoisted.valueHumanNameSer, __d.value)
      }
      is Transport.Input.Value.Identifier -> {
        encoder.encodeSerializableElement(__desc, 56, Hoisted.valueIdentifierSer, __d.value)
      }
      is Transport.Input.Value.Money -> {
        encoder.encodeSerializableElement(__desc, 57, Hoisted.valueMoneySer, __d.value)
      }
      is Transport.Input.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 58, Hoisted.valuePeriodSer, __d.value)
      }
      is Transport.Input.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 59, Hoisted.valueQuantitySer, __d.value)
      }
      is Transport.Input.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 60, Hoisted.valueRangeSer, __d.value)
      }
      is Transport.Input.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 61, Hoisted.valueRatioSer, __d.value)
      }
      is Transport.Input.Value.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 62, Hoisted.valueRatioRangeSer, __d.value)
      }
      is Transport.Input.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 63, Hoisted.valueReferenceSer, __d.value)
      }
      is Transport.Input.Value.SampledData -> {
        encoder.encodeSerializableElement(__desc, 64, Hoisted.valueSampledDataSer, __d.value)
      }
      is Transport.Input.Value.Signature -> {
        encoder.encodeSerializableElement(__desc, 65, Hoisted.valueSignatureSer, __d.value)
      }
      is Transport.Input.Value.Timing -> {
        encoder.encodeSerializableElement(__desc, 66, Hoisted.valueTimingSer, __d.value)
      }
      is Transport.Input.Value.ContactDetail -> {
        encoder.encodeSerializableElement(__desc, 67, Hoisted.valueContactDetailSer, __d.value)
      }
      is Transport.Input.Value.DataRequirement -> {
        encoder.encodeSerializableElement(__desc, 68, Hoisted.valueDataRequirementSer, __d.value)
      }
      is Transport.Input.Value.Expression -> {
        encoder.encodeSerializableElement(__desc, 69, Hoisted.valueExpressionSer, __d.value)
      }
      is Transport.Input.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          70,
          Hoisted.valueParameterDefinitionSer,
          __d.value,
        )
      }
      is Transport.Input.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(__desc, 71, Hoisted.valueRelatedArtifactSer, __d.value)
      }
      is Transport.Input.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(__desc, 72, Hoisted.valueTriggerDefinitionSer, __d.value)
      }
      is Transport.Input.Value.UsageContext -> {
        encoder.encodeSerializableElement(__desc, 73, Hoisted.valueUsageContextSer, __d.value)
      }
      is Transport.Input.Value.Availability -> {
        encoder.encodeSerializableElement(__desc, 74, Hoisted.valueAvailabilitySer, __d.value)
      }
      is Transport.Input.Value.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          75,
          Hoisted.valueExtendedContactDetailSer,
          __d.value,
        )
      }
      is Transport.Input.Value.Dosage -> {
        encoder.encodeSerializableElement(__desc, 76, Hoisted.valueDosageSer, __d.value)
      }
      is Transport.Input.Value.Meta -> {
        encoder.encodeSerializableElement(__desc, 77, Hoisted.valueMetaSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueBase64BinarySer: KSerializer<Element> = Element.serializer()

    public val valueAddressSer: KSerializer<Address> = Address.serializer()

    public val valueAgeSer: KSerializer<Age> = Age.serializer()

    public val valueAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueCodeableReferenceSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val valueContactPointSer: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val valueCountSer: KSerializer<Count> = Count.serializer()

    public val valueDistanceSer: KSerializer<Distance> = Distance.serializer()

    public val valueDurationSer: KSerializer<Duration> = Duration.serializer()

    public val valueHumanNameSer: KSerializer<HumanName> = HumanName.serializer()

    public val valueIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val valueMoneySer: KSerializer<Money> = Money.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueRatioRangeSer: KSerializer<RatioRange> = RatioRange.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val valueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val valueSignatureSer: KSerializer<Signature> = Signature.serializer()

    public val valueTimingSer: KSerializer<Timing> = Timing.serializer()

    public val valueContactDetailSer: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val valueDataRequirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val valueExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val valueParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val valueRelatedArtifactSer: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val valueTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val valueUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val valueAvailabilitySer: KSerializer<Availability> = Availability.serializer()

    public val valueExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val valueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val valueMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}

internal object TransportOutputSerializer : KSerializer<Transport.Output> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Output") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueBase64Binary", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCanonical", Element.serializer().descriptor, isOptional = true)
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element("valueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueId", Element.serializer().descriptor, isOptional = true)
      element("valueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueInstant", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueInteger64", Element.serializer().descriptor, isOptional = true)
      element("valueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueMarkdown", Element.serializer().descriptor, isOptional = true)
      element("valueOid", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueOid", Element.serializer().descriptor, isOptional = true)
      element("valuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_valuePositiveInt", Element.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", Element.serializer().descriptor, isOptional = true)
      element("valueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_valueUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("valueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUri", Element.serializer().descriptor, isOptional = true)
      element("valueUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUrl", Element.serializer().descriptor, isOptional = true)
      element("valueUuid", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUuid", Element.serializer().descriptor, isOptional = true)
      element("valueAddress", Address.serializer().descriptor, isOptional = true)
      element("valueAge", Age.serializer().descriptor, isOptional = true)
      element("valueAnnotation", Annotation.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "valueCodeableReference",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueContactPoint", ContactPoint.serializer().descriptor, isOptional = true)
      element("valueCount", Count.serializer().descriptor, isOptional = true)
      element("valueDistance", Distance.serializer().descriptor, isOptional = true)
      element("valueDuration", Duration.serializer().descriptor, isOptional = true)
      element("valueHumanName", HumanName.serializer().descriptor, isOptional = true)
      element("valueIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("valueMoney", Money.serializer().descriptor, isOptional = true)
      element("valuePeriod", Period.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("valueRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("valueSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("valueSignature", Signature.serializer().descriptor, isOptional = true)
      element("valueTiming", Timing.serializer().descriptor, isOptional = true)
      element("valueContactDetail", ContactDetail.serializer().descriptor, isOptional = true)
      element("valueDataRequirement", DataRequirement.serializer().descriptor, isOptional = true)
      element("valueExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "valueParameterDefinition",
        ParameterDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("valueRelatedArtifact", RelatedArtifact.serializer().descriptor, isOptional = true)
      element(
        "valueTriggerDefinition",
        TriggerDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("valueUsageContext", UsageContext.serializer().descriptor, isOptional = true)
      element("valueAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "valueExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("valueDosage", Dosage.serializer().descriptor, isOptional = true)
      element("valueMeta", Meta.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Transport.Output =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Transport.Output) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Transport.Output {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueBase64Binary: KotlinString? = null
    var _valueBase64Binary: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueCanonical: KotlinString? = null
    var _valueCanonical: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valueDecimal: BigDecimal? = null
    var _valueDecimal: Element? = null
    var valueId: KotlinString? = null
    var _valueId: Element? = null
    var valueInstant: KotlinString? = null
    var _valueInstant: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueInteger64: KotlinString? = null
    var _valueInteger64: Element? = null
    var valueMarkdown: KotlinString? = null
    var _valueMarkdown: Element? = null
    var valueOid: KotlinString? = null
    var _valueOid: Element? = null
    var valuePositiveInt: Int? = null
    var _valuePositiveInt: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueUnsignedInt: Int? = null
    var _valueUnsignedInt: Element? = null
    var valueUri: KotlinString? = null
    var _valueUri: Element? = null
    var valueUrl: KotlinString? = null
    var _valueUrl: Element? = null
    var valueUuid: KotlinString? = null
    var _valueUuid: Element? = null
    var valueAddress: Address? = null
    var valueAge: Age? = null
    var valueAnnotation: Annotation? = null
    var valueAttachment: Attachment? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueCodeableReference: CodeableReference? = null
    var valueCoding: Coding? = null
    var valueContactPoint: ContactPoint? = null
    var valueCount: Count? = null
    var valueDistance: Distance? = null
    var valueDuration: Duration? = null
    var valueHumanName: HumanName? = null
    var valueIdentifier: Identifier? = null
    var valueMoney: Money? = null
    var valuePeriod: Period? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueRatio: Ratio? = null
    var valueRatioRange: RatioRange? = null
    var valueReference: Reference? = null
    var valueSampledData: SampledData? = null
    var valueSignature: Signature? = null
    var valueTiming: Timing? = null
    var valueContactDetail: ContactDetail? = null
    var valueDataRequirement: DataRequirement? = null
    var valueExpression: Expression? = null
    var valueParameterDefinition: ParameterDefinition? = null
    var valueRelatedArtifact: RelatedArtifact? = null
    var valueTriggerDefinition: TriggerDefinition? = null
    var valueUsageContext: UsageContext? = null
    var valueAvailability: Availability? = null
    var valueExtendedContactDetail: ExtendedContactDetail? = null
    var valueDosage: Dosage? = null
    var valueMeta: Meta? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> valueBase64Binary = decoder.decodeStringElement(__desc, 4)
        5 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueBase64BinarySer, null)
        6 -> valueBoolean = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueBase64BinarySer, null)
        8 -> valueCanonical = decoder.decodeStringElement(__desc, 8)
        9 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueBase64BinarySer, null)
        10 -> valueCode = decoder.decodeStringElement(__desc, 10)
        11 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.valueBase64BinarySer,
              null,
            )
        12 -> valueDate = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.valueBase64BinarySer,
              null,
            )
        14 -> valueDateTime = decoder.decodeStringElement(__desc, 14)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.valueBase64BinarySer,
              null,
            )
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 16, BigDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.valueBase64BinarySer,
              null,
            )
        18 -> valueId = decoder.decodeStringElement(__desc, 18)
        19 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.valueBase64BinarySer,
              null,
            )
        20 -> valueInstant = decoder.decodeStringElement(__desc, 20)
        21 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.valueBase64BinarySer,
              null,
            )
        22 -> valueInteger = decoder.decodeIntElement(__desc, 22)
        23 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              __desc,
              23,
              Hoisted.valueBase64BinarySer,
              null,
            )
        24 -> valueInteger64 = decoder.decodeStringElement(__desc, 24)
        25 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(
              __desc,
              25,
              Hoisted.valueBase64BinarySer,
              null,
            )
        26 -> valueMarkdown = decoder.decodeStringElement(__desc, 26)
        27 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              __desc,
              27,
              Hoisted.valueBase64BinarySer,
              null,
            )
        28 -> valueOid = decoder.decodeStringElement(__desc, 28)
        29 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              __desc,
              29,
              Hoisted.valueBase64BinarySer,
              null,
            )
        30 -> valuePositiveInt = decoder.decodeIntElement(__desc, 30)
        31 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              31,
              Hoisted.valueBase64BinarySer,
              null,
            )
        32 -> valueString = decoder.decodeStringElement(__desc, 32)
        33 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              __desc,
              33,
              Hoisted.valueBase64BinarySer,
              null,
            )
        34 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 34, LocalTimeSerializer, null)
        35 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              35,
              Hoisted.valueBase64BinarySer,
              null,
            )
        36 -> valueUnsignedInt = decoder.decodeIntElement(__desc, 36)
        37 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              37,
              Hoisted.valueBase64BinarySer,
              null,
            )
        38 -> valueUri = decoder.decodeStringElement(__desc, 38)
        39 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              39,
              Hoisted.valueBase64BinarySer,
              null,
            )
        40 -> valueUrl = decoder.decodeStringElement(__desc, 40)
        41 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              __desc,
              41,
              Hoisted.valueBase64BinarySer,
              null,
            )
        42 -> valueUuid = decoder.decodeStringElement(__desc, 42)
        43 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              __desc,
              43,
              Hoisted.valueBase64BinarySer,
              null,
            )
        44 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.valueAddressSer, null)
        45 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.valueAgeSer, null)
        46 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.valueAnnotationSer, null)
        47 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.valueAttachmentSer, null)
        48 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.typeSer, null)
        49 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              49,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        50 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.valueCodingSer, null)
        51 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              51,
              Hoisted.valueContactPointSer,
              null,
            )
        52 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.valueCountSer, null)
        53 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.valueDistanceSer, null)
        54 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.valueDurationSer, null)
        55 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.valueHumanNameSer, null)
        56 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.valueIdentifierSer, null)
        57 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.valueMoneySer, null)
        58 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.valuePeriodSer, null)
        59 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.valueQuantitySer, null)
        60 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.valueRangeSer, null)
        61 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.valueRatioSer, null)
        62 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.valueRatioRangeSer, null)
        63 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 63, Hoisted.valueReferenceSer, null)
        64 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.valueSampledDataSer, null)
        65 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, 65, Hoisted.valueSignatureSer, null)
        66 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.valueTimingSer, null)
        67 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              67,
              Hoisted.valueContactDetailSer,
              null,
            )
        68 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              68,
              Hoisted.valueDataRequirementSer,
              null,
            )
        69 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, 69, Hoisted.valueExpressionSer, null)
        70 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              70,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              71,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              72,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        73 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              73,
              Hoisted.valueUsageContextSer,
              null,
            )
        74 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              74,
              Hoisted.valueAvailabilitySer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              75,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        76 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, 76, Hoisted.valueDosageSer, null)
        77 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, 77, Hoisted.valueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Output: " + __i)
      }
    }
    return Transport.Output(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        Transport.Output.Value.from(
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Canonical.of(valueCanonical, _valueCanonical),
          Code.of(valueCode, _valueCode),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(FhirDateTime.fromString(valueInstant), _valueInstant),
          Integer.of(valueInteger, _valueInteger),
          Integer64.of(valueInteger64?.toLong(), _valueInteger64),
          Markdown.of(valueMarkdown, _valueMarkdown),
          Oid.of(valueOid, _valueOid),
          PositiveInt.of(valuePositiveInt, _valuePositiveInt),
          R5String.of(valueString, _valueString),
          Time.of(valueTime, _valueTime),
          UnsignedInt.of(valueUnsignedInt, _valueUnsignedInt),
          Uri.of(valueUri, _valueUri),
          Url.of(valueUrl, _valueUrl),
          Uuid.of(valueUuid, _valueUuid),
          valueAddress,
          valueAge,
          valueAnnotation,
          valueAttachment,
          valueCodeableConcept,
          valueCodeableReference,
          valueCoding,
          valueContactPoint,
          valueCount,
          valueDistance,
          valueDuration,
          valueHumanName,
          valueIdentifier,
          valueMoney,
          valuePeriod,
          valueQuantity,
          valueRange,
          valueRatio,
          valueRatioRange,
          valueReference,
          valueSampledData,
          valueSignature,
          valueTiming,
          valueContactDetail,
          valueDataRequirement,
          valueExpression,
          valueParameterDefinition,
          valueRelatedArtifact,
          valueTriggerDefinition,
          valueUsageContext,
          valueAvailability,
          valueExtendedContactDetail,
          valueDosage,
          valueMeta,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Transport.Output) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is Transport.Output.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 16, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 19, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 25, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 27, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 29, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 30, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 31, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 33, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 34, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 35, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 36, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 37, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 39, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 41, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 43, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Transport.Output.Value.Address -> {
        encoder.encodeSerializableElement(__desc, 44, Hoisted.valueAddressSer, __d.value)
      }
      is Transport.Output.Value.Age -> {
        encoder.encodeSerializableElement(__desc, 45, Hoisted.valueAgeSer, __d.value)
      }
      is Transport.Output.Value.Annotation -> {
        encoder.encodeSerializableElement(__desc, 46, Hoisted.valueAnnotationSer, __d.value)
      }
      is Transport.Output.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 47, Hoisted.valueAttachmentSer, __d.value)
      }
      is Transport.Output.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 48, Hoisted.typeSer, __d.value)
      }
      is Transport.Output.Value.CodeableReference -> {
        encoder.encodeSerializableElement(__desc, 49, Hoisted.valueCodeableReferenceSer, __d.value)
      }
      is Transport.Output.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 50, Hoisted.valueCodingSer, __d.value)
      }
      is Transport.Output.Value.ContactPoint -> {
        encoder.encodeSerializableElement(__desc, 51, Hoisted.valueContactPointSer, __d.value)
      }
      is Transport.Output.Value.Count -> {
        encoder.encodeSerializableElement(__desc, 52, Hoisted.valueCountSer, __d.value)
      }
      is Transport.Output.Value.Distance -> {
        encoder.encodeSerializableElement(__desc, 53, Hoisted.valueDistanceSer, __d.value)
      }
      is Transport.Output.Value.Duration -> {
        encoder.encodeSerializableElement(__desc, 54, Hoisted.valueDurationSer, __d.value)
      }
      is Transport.Output.Value.HumanName -> {
        encoder.encodeSerializableElement(__desc, 55, Hoisted.valueHumanNameSer, __d.value)
      }
      is Transport.Output.Value.Identifier -> {
        encoder.encodeSerializableElement(__desc, 56, Hoisted.valueIdentifierSer, __d.value)
      }
      is Transport.Output.Value.Money -> {
        encoder.encodeSerializableElement(__desc, 57, Hoisted.valueMoneySer, __d.value)
      }
      is Transport.Output.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 58, Hoisted.valuePeriodSer, __d.value)
      }
      is Transport.Output.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 59, Hoisted.valueQuantitySer, __d.value)
      }
      is Transport.Output.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 60, Hoisted.valueRangeSer, __d.value)
      }
      is Transport.Output.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 61, Hoisted.valueRatioSer, __d.value)
      }
      is Transport.Output.Value.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 62, Hoisted.valueRatioRangeSer, __d.value)
      }
      is Transport.Output.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 63, Hoisted.valueReferenceSer, __d.value)
      }
      is Transport.Output.Value.SampledData -> {
        encoder.encodeSerializableElement(__desc, 64, Hoisted.valueSampledDataSer, __d.value)
      }
      is Transport.Output.Value.Signature -> {
        encoder.encodeSerializableElement(__desc, 65, Hoisted.valueSignatureSer, __d.value)
      }
      is Transport.Output.Value.Timing -> {
        encoder.encodeSerializableElement(__desc, 66, Hoisted.valueTimingSer, __d.value)
      }
      is Transport.Output.Value.ContactDetail -> {
        encoder.encodeSerializableElement(__desc, 67, Hoisted.valueContactDetailSer, __d.value)
      }
      is Transport.Output.Value.DataRequirement -> {
        encoder.encodeSerializableElement(__desc, 68, Hoisted.valueDataRequirementSer, __d.value)
      }
      is Transport.Output.Value.Expression -> {
        encoder.encodeSerializableElement(__desc, 69, Hoisted.valueExpressionSer, __d.value)
      }
      is Transport.Output.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          70,
          Hoisted.valueParameterDefinitionSer,
          __d.value,
        )
      }
      is Transport.Output.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(__desc, 71, Hoisted.valueRelatedArtifactSer, __d.value)
      }
      is Transport.Output.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(__desc, 72, Hoisted.valueTriggerDefinitionSer, __d.value)
      }
      is Transport.Output.Value.UsageContext -> {
        encoder.encodeSerializableElement(__desc, 73, Hoisted.valueUsageContextSer, __d.value)
      }
      is Transport.Output.Value.Availability -> {
        encoder.encodeSerializableElement(__desc, 74, Hoisted.valueAvailabilitySer, __d.value)
      }
      is Transport.Output.Value.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          75,
          Hoisted.valueExtendedContactDetailSer,
          __d.value,
        )
      }
      is Transport.Output.Value.Dosage -> {
        encoder.encodeSerializableElement(__desc, 76, Hoisted.valueDosageSer, __d.value)
      }
      is Transport.Output.Value.Meta -> {
        encoder.encodeSerializableElement(__desc, 77, Hoisted.valueMetaSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueBase64BinarySer: KSerializer<Element> = Element.serializer()

    public val valueAddressSer: KSerializer<Address> = Address.serializer()

    public val valueAgeSer: KSerializer<Age> = Age.serializer()

    public val valueAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueCodeableReferenceSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val valueContactPointSer: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val valueCountSer: KSerializer<Count> = Count.serializer()

    public val valueDistanceSer: KSerializer<Distance> = Distance.serializer()

    public val valueDurationSer: KSerializer<Duration> = Duration.serializer()

    public val valueHumanNameSer: KSerializer<HumanName> = HumanName.serializer()

    public val valueIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val valueMoneySer: KSerializer<Money> = Money.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueRatioRangeSer: KSerializer<RatioRange> = RatioRange.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val valueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val valueSignatureSer: KSerializer<Signature> = Signature.serializer()

    public val valueTimingSer: KSerializer<Timing> = Timing.serializer()

    public val valueContactDetailSer: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val valueDataRequirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val valueExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val valueParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val valueRelatedArtifactSer: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val valueTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val valueUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val valueAvailabilitySer: KSerializer<Availability> = Availability.serializer()

    public val valueExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val valueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val valueMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}

internal object TransportSerializer : KSerializer<Transport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Transport") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("instantiatesCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_instantiatesCanonical", Element.serializer().descriptor, isOptional = true)
      element("instantiatesUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_instantiatesUri", Element.serializer().descriptor, isOptional = true)
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("intent", KotlinString.serializer().descriptor, isOptional = true)
      element("_intent", Element.serializer().descriptor, isOptional = true)
      element("priority", KotlinString.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("focus", Reference.serializer().descriptor, isOptional = true)
      element("for", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("completionTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_completionTime", Element.serializer().descriptor, isOptional = true)
      element("authoredOn", KotlinString.serializer().descriptor, isOptional = true)
      element("_authoredOn", Element.serializer().descriptor, isOptional = true)
      element("lastModified", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastModified", Element.serializer().descriptor, isOptional = true)
      element("requester", Reference.serializer().descriptor, isOptional = true)
      element(
        "performerType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("owner", Reference.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element(
        "insurance",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "relevantHistory",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "restriction",
        lazyDescriptor { Transport.Restriction.serializer().descriptor },
        isOptional = true,
      )
      element(
        "input",
        listSerialDescriptor(lazyDescriptor { Transport.Input.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "output",
        listSerialDescriptor(lazyDescriptor { Transport.Output.serializer().descriptor }),
        isOptional = true,
      )
      element("requestedLocation", Reference.serializer().descriptor, isOptional = true)
      element("currentLocation", Reference.serializer().descriptor, isOptional = true)
      element("reason", CodeableReference.serializer().descriptor, isOptional = true)
      element("history", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Transport =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Transport) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Transport {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var instantiatesCanonical: KotlinString? = null
    var _instantiatesCanonical: Element? = null
    var instantiatesUri: KotlinString? = null
    var _instantiatesUri: Element? = null
    var basedOn: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: CodeableConcept? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var code: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var focus: Reference? = null
    var `for`: Reference? = null
    var encounter: Reference? = null
    var completionTime: KotlinString? = null
    var _completionTime: Element? = null
    var authoredOn: KotlinString? = null
    var _authoredOn: Element? = null
    var lastModified: KotlinString? = null
    var _lastModified: Element? = null
    var requester: Reference? = null
    var performerType: List<CodeableConcept>? = null
    var owner: Reference? = null
    var location: Reference? = null
    var insurance: List<Reference>? = null
    var note: List<Annotation>? = null
    var relevantHistory: List<Reference>? = null
    var restriction: Transport.Restriction? = null
    var input: List<Transport.Input>? = null
    var output: List<Transport.Output>? = null
    var requestedLocation: Reference? = null
    var currentLocation: Reference? = null
    var reason: CodeableReference? = null
    var history: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> instantiatesCanonical = decoder.decodeStringElement(__desc, 12)
        13 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> instantiatesUri = decoder.decodeStringElement(__desc, 14)
        15 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSer, null)
        17 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.identifierSerInner, null)
        18 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.basedOnSer, null)
        19 -> status = decoder.decodeStringElement(__desc, 19)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.statusReasonSer, null)
        22 -> intent = decoder.decodeStringElement(__desc, 22)
        23 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> priority = decoder.decodeStringElement(__desc, 24)
        25 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.statusReasonSer, null)
        27 -> description = decoder.decodeStringElement(__desc, 27)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 ->
          focus =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.basedOnSerInner, null)
        30 ->
          `for` =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.basedOnSerInner, null)
        31 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.basedOnSerInner, null)
        32 -> completionTime = decoder.decodeStringElement(__desc, 32)
        33 ->
          _completionTime =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 -> authoredOn = decoder.decodeStringElement(__desc, 34)
        35 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> lastModified = decoder.decodeStringElement(__desc, 36)
        37 ->
          _lastModified =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 ->
          requester =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.basedOnSerInner, null)
        39 ->
          performerType =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.performerTypeSer, null)
        40 ->
          owner =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.basedOnSerInner, null)
        41 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.basedOnSerInner, null)
        42 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.basedOnSer, null)
        43 -> note = decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.noteSer, null)
        44 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.basedOnSer, null)
        45 ->
          restriction =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.restrictionSer, null)
        46 -> input = decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.inputSer, null)
        47 ->
          output = decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.outputSer, null)
        48 ->
          requestedLocation =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.basedOnSerInner, null)
        49 ->
          currentLocation =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.basedOnSerInner, null)
        50 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.reasonSer, null)
        51 ->
          history =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.basedOnSerInner, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Transport: " + __i)
      }
    }
    return Transport(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical = Canonical.of(instantiatesCanonical, _instantiatesCanonical),
      instantiatesUri = Uri.of(instantiatesUri, _instantiatesUri),
      basedOn = basedOn ?: listOf(),
      groupIdentifier = groupIdentifier,
      partOf = partOf ?: listOf(),
      status = status?.let { Enumeration.of(Transport.TransportStatus.fromCode(it), _status) },
      statusReason = statusReason,
      intent = Enumeration.of(Transport.TransportIntent.fromCode(intent!!), _intent),
      priority =
        priority?.let { Enumeration.of(Transport.RequestPriority.fromCode(it), _priority) },
      code = code,
      description = R5String.of(description, _description),
      focus = focus,
      `for` = `for`,
      encounter = encounter,
      completionTime = DateTime.of(FhirDateTime.fromString(completionTime), _completionTime),
      authoredOn = DateTime.of(FhirDateTime.fromString(authoredOn), _authoredOn),
      lastModified = DateTime.of(FhirDateTime.fromString(lastModified), _lastModified),
      requester = requester,
      performerType = performerType ?: listOf(),
      owner = owner,
      location = location,
      insurance = insurance ?: listOf(),
      note = note ?: listOf(),
      relevantHistory = relevantHistory ?: listOf(),
      restriction = restriction,
      input = input ?: listOf(),
      output = output ?: listOf(),
      requestedLocation = requestedLocation!!,
      currentLocation = currentLocation!!,
      reason = reason,
      history = history,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Transport) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Transport")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.instantiatesCanonical?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.instantiatesCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.instantiatesUri?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.instantiatesUri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSer, value.basedOn)
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.identifierSerInner, it)
    }
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.basedOnSer, value.partOf)
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.statusReasonSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.statusReasonSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    (value.focus)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.basedOnSerInner, it)
    }
    (value.`for`)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.basedOnSerInner, it)
    }
    ((value.completionTime?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.completionTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    ((value.authoredOn?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    ((value.lastModified?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.lastModified?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.basedOnSerInner, it)
    }
    if (value.performerType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.performerTypeSer, value.performerType)
    (value.owner)?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.basedOnSerInner, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.basedOnSerInner, it)
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.basedOnSer, value.insurance)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.noteSer, value.note)
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.basedOnSer, value.relevantHistory)
    (value.restriction)?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.restrictionSer, it)
    }
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.inputSer, value.input)
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.outputSer, value.output)
    (value.requestedLocation)?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.basedOnSerInner, it)
    }
    (value.currentLocation)?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.basedOnSerInner, it)
    }
    (value.reason)?.let { encoder.encodeSerializableElement(__desc, 50, Hoisted.reasonSer, it) }
    (value.history)?.let {
      encoder.encodeSerializableElement(__desc, 51, Hoisted.basedOnSerInner, it)
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val performerTypeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val restrictionSer: KSerializer<Transport.Restriction> =
      Transport.Restriction.serializer()

    public val inputSerInner: KSerializer<Transport.Input> = Transport.Input.serializer()

    public val inputSer: KSerializer<List<Transport.Input>> = ListSerializer(Hoisted.inputSerInner)

    public val outputSerInner: KSerializer<Transport.Output> = Transport.Output.serializer()

    public val outputSer: KSerializer<List<Transport.Output>> =
      ListSerializer(Hoisted.outputSerInner)

    public val reasonSer: KSerializer<CodeableReference> = CodeableReference.serializer()
  }
}
