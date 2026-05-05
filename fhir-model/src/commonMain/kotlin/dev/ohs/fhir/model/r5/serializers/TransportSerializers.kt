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
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> repetitions = decoder.decodeIntElement(__desc, __i)
        4 ->
          _repetitions =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.repetitionsSer, null)
        5 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        6 ->
          recipient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.recipientSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> valueBase64Binary = decoder.decodeStringElement(__desc, __i)
        5 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        6 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        8 -> valueCanonical = decoder.decodeStringElement(__desc, __i)
        9 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        10 -> valueCode = decoder.decodeStringElement(__desc, __i)
        11 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        12 -> valueDate = decoder.decodeStringElement(__desc, __i)
        13 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        14 -> valueDateTime = decoder.decodeStringElement(__desc, __i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        18 -> valueId = decoder.decodeStringElement(__desc, __i)
        19 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        20 -> valueInstant = decoder.decodeStringElement(__desc, __i)
        21 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        22 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        23 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        24 -> valueInteger64 = decoder.decodeStringElement(__desc, __i)
        25 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        26 -> valueMarkdown = decoder.decodeStringElement(__desc, __i)
        27 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        28 -> valueOid = decoder.decodeStringElement(__desc, __i)
        29 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        30 -> valuePositiveInt = decoder.decodeIntElement(__desc, __i)
        31 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        32 -> valueString = decoder.decodeStringElement(__desc, __i)
        33 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        34 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        35 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        36 -> valueUnsignedInt = decoder.decodeIntElement(__desc, __i)
        37 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        38 -> valueUri = decoder.decodeStringElement(__desc, __i)
        39 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        40 -> valueUrl = decoder.decodeStringElement(__desc, __i)
        41 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        42 -> valueUuid = decoder.decodeStringElement(__desc, __i)
        43 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        44 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAddressSer, null)
        45 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAgeSer, null)
        46 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAnnotationSer, null)
        47 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        48 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        49 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        50 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCodingSer, null)
        51 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContactPointSer,
              null,
            )
        52 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCountSer, null)
        53 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDistanceSer, null)
        54 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDurationSer, null)
        55 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueHumanNameSer, null)
        56 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdentifierSer, null)
        57 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueMoneySer, null)
        58 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valuePeriodSer, null)
        59 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        60 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        61 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioSer, null)
        62 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioRangeSer, null)
        63 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueReferenceSer, null)
        64 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueSampledDataSer,
              null,
            )
        65 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSignatureSer, null)
        66 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueTimingSer, null)
        67 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContactDetailSer,
              null,
            )
        68 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        69 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueExpressionSer, null)
        70 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        73 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueUsageContextSer,
              null,
            )
        74 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueAvailabilitySer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        76 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDosageSer, null)
        77 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueMetaSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> valueBase64Binary = decoder.decodeStringElement(__desc, __i)
        5 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        6 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        8 -> valueCanonical = decoder.decodeStringElement(__desc, __i)
        9 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        10 -> valueCode = decoder.decodeStringElement(__desc, __i)
        11 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        12 -> valueDate = decoder.decodeStringElement(__desc, __i)
        13 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        14 -> valueDateTime = decoder.decodeStringElement(__desc, __i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        18 -> valueId = decoder.decodeStringElement(__desc, __i)
        19 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        20 -> valueInstant = decoder.decodeStringElement(__desc, __i)
        21 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        22 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        23 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        24 -> valueInteger64 = decoder.decodeStringElement(__desc, __i)
        25 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        26 -> valueMarkdown = decoder.decodeStringElement(__desc, __i)
        27 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        28 -> valueOid = decoder.decodeStringElement(__desc, __i)
        29 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        30 -> valuePositiveInt = decoder.decodeIntElement(__desc, __i)
        31 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        32 -> valueString = decoder.decodeStringElement(__desc, __i)
        33 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        34 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        35 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        36 -> valueUnsignedInt = decoder.decodeIntElement(__desc, __i)
        37 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        38 -> valueUri = decoder.decodeStringElement(__desc, __i)
        39 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        40 -> valueUrl = decoder.decodeStringElement(__desc, __i)
        41 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        42 -> valueUuid = decoder.decodeStringElement(__desc, __i)
        43 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        44 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAddressSer, null)
        45 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAgeSer, null)
        46 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAnnotationSer, null)
        47 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        48 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        49 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        50 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCodingSer, null)
        51 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContactPointSer,
              null,
            )
        52 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCountSer, null)
        53 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDistanceSer, null)
        54 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDurationSer, null)
        55 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueHumanNameSer, null)
        56 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdentifierSer, null)
        57 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueMoneySer, null)
        58 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valuePeriodSer, null)
        59 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        60 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        61 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioSer, null)
        62 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioRangeSer, null)
        63 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueReferenceSer, null)
        64 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueSampledDataSer,
              null,
            )
        65 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSignatureSer, null)
        66 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueTimingSer, null)
        67 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContactDetailSer,
              null,
            )
        68 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        69 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueExpressionSer, null)
        70 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        73 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueUsageContextSer,
              null,
            )
        74 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueAvailabilitySer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        76 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDosageSer, null)
        77 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueMetaSer, null)
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
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("instantiatesCanonical", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_instantiatesCanonical", Element.serializer().descriptor, isOptional = true)
    b.element("instantiatesUri", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_instantiatesUri", Element.serializer().descriptor, isOptional = true)
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("intent", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element("priority", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_priority", Element.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("focus", Reference.serializer().descriptor, isOptional = true)
    b.element("for", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("completionTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_completionTime", Element.serializer().descriptor, isOptional = true)
    b.element("authoredOn", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_authoredOn", Element.serializer().descriptor, isOptional = true)
    b.element("lastModified", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastModified", Element.serializer().descriptor, isOptional = true)
    b.element("requester", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "performerType",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("owner", Reference.serializer().descriptor, isOptional = true)
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "insurance",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "relevantHistory",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "restriction",
      lazyDescriptor { Transport.Restriction.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "input",
      listSerialDescriptor(lazyDescriptor { Transport.Input.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "output",
      listSerialDescriptor(lazyDescriptor { Transport.Output.serializer().descriptor }),
      isOptional = true,
    )
    b.element("requestedLocation", Reference.serializer().descriptor, isOptional = true)
    b.element("currentLocation", Reference.serializer().descriptor, isOptional = true)
    b.element("reason", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("history", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Transport =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Transport) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Transport")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Transport {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> instantiatesCanonical = decoder.decodeStringElement(__desc, __i)
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 -> instantiatesUri = decoder.decodeStringElement(__desc, __i)
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        16 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSerInner, null)
        17 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        18 -> status = decoder.decodeStringElement(__desc, __i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        21 -> intent = decoder.decodeStringElement(__desc, __i)
        22 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> priority = decoder.decodeStringElement(__desc, __i)
        24 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        26 -> description = decoder.decodeStringElement(__desc, __i)
        27 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 ->
          focus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        29 ->
          `for` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        30 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        31 -> completionTime = decoder.decodeStringElement(__desc, __i)
        32 ->
          _completionTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        33 -> authoredOn = decoder.decodeStringElement(__desc, __i)
        34 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        35 -> lastModified = decoder.decodeStringElement(__desc, __i)
        36 ->
          _lastModified =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        37 ->
          requester =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        38 ->
          performerType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerTypeSer, null)
        39 ->
          owner =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        40 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        41 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        42 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        43 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        44 ->
          restriction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.restrictionSer, null)
        45 -> input = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.inputSer, null)
        46 ->
          output = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.outputSer, null)
        47 ->
          requestedLocation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        48 ->
          currentLocation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        49 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        50 ->
          history =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Transport,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.instantiatesCanonical?.value))?.let {
      encoder.encodeStringElement(__desc, 11 + __off, it)
    }
    (value.instantiatesCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.instantiatesUri?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.instantiatesUri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.basedOnSer, value.basedOn)
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.identifierSerInner, it)
    }
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.basedOnSer, value.partOf)
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.statusReasonSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.priority?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 23 + __off, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.statusReasonSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 26 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.focus)?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.`for`)?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.basedOnSerInner, it)
    }
    ((value.completionTime?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 31 + __off, it)
    }
    (value.completionTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.authoredOn?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 33 + __off, it)
    }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.lastModified?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 35 + __off, it)
    }
    (value.lastModified?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.performerType.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        38 + __off,
        Hoisted.performerTypeSer,
        value.performerType,
      )
    (value.owner)?.let {
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.basedOnSer, value.insurance)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.noteSer, value.note)
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        43 + __off,
        Hoisted.basedOnSer,
        value.relevantHistory,
      )
    (value.restriction)?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.restrictionSer, it)
    }
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.inputSer, value.input)
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.outputSer, value.output)
    (value.requestedLocation)?.let {
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.currentLocation)?.let {
      encoder.encodeSerializableElement(__desc, 48 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.reason)?.let {
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.reasonSer, it)
    }
    (value.history)?.let {
      encoder.encodeSerializableElement(__desc, 50 + __off, Hoisted.basedOnSerInner, it)
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

internal object TransportPolymorphicSerializer : KSerializer<Transport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Transport") { TransportSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Transport) {
    encoder.encodeStructure(descriptor) {
      TransportSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Transport =
    decoder.decodeStructure(descriptor) { TransportSerializer.deserializeJson(this, descriptor, 0) }
}
