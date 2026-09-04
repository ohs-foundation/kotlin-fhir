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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

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
import dev.ohs.fhir.model.r5.FhirDecimal
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
import dev.ohs.fhir.model.r5.Task
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.TriggerDefinition
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.Uuid
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
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

internal object TaskPerformerSerializer : KSerializer<Task.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Task.Performer =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Task.Performer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Task.Performer {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          function =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.functionSer, null)
        4 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + i)
      }
    }
    return Task.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor =
        actor
          ?: throw SerializationException("Missing required property 'actor' on Task.Performer"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Task.Performer) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.function)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.functionSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorSer, value.actor)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object TaskRestrictionSerializer : KSerializer<Task.Restriction> {
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

  override fun deserialize(decoder: Decoder): Task.Restriction =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Task.Restriction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Task.Restriction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var repetitions: Int? = null
    var _repetitions: Element? = null
    var period: Period? = null
    var recipient: List<Reference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> repetitions = decoder.decodeIntElement(descriptor, i)
        4 ->
          _repetitions =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.repetitionsSer, null)
        5 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        6 ->
          recipient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.recipientSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Restriction: " + i)
      }
    }
    return Task.Restriction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      repetitions = PositiveInt.of(repetitions, _repetitions),
      period = period,
      recipient = recipient ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Task.Restriction) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.repetitions?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.repetitions?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.repetitionsSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.periodSer, it) }
    if (value.recipient.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.recipientSer, value.recipient)
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

internal object TaskInputSerializer : KSerializer<Task.Input> {
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
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
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

  override fun deserialize(decoder: Decoder): Task.Input =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Task.Input) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Task.Input {
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
    var valueDecimal: FhirDecimal? = null
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        5 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        6 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        8 -> valueCanonical = decoder.decodeStringElement(descriptor, i)
        9 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        10 -> valueCode = decoder.decodeStringElement(descriptor, i)
        11 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        12 -> valueDate = decoder.decodeStringElement(descriptor, i)
        13 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        14 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        18 -> valueId = decoder.decodeStringElement(descriptor, i)
        19 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        20 -> valueInstant = decoder.decodeStringElement(descriptor, i)
        21 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        22 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        23 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        24 -> valueInteger64 = decoder.decodeStringElement(descriptor, i)
        25 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        26 -> valueMarkdown = decoder.decodeStringElement(descriptor, i)
        27 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        28 -> valueOid = decoder.decodeStringElement(descriptor, i)
        29 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        30 -> valuePositiveInt = decoder.decodeIntElement(descriptor, i)
        31 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        32 -> valueString = decoder.decodeStringElement(descriptor, i)
        33 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        34 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        35 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        36 -> valueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        37 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        38 -> valueUri = decoder.decodeStringElement(descriptor, i)
        39 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        40 -> valueUrl = decoder.decodeStringElement(descriptor, i)
        41 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        42 -> valueUuid = decoder.decodeStringElement(descriptor, i)
        43 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        44 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAddressSer, null)
        45 ->
          valueAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAgeSer, null)
        46 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAnnotationSer,
              null,
            )
        47 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        48 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        49 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        50 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        51 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactPointSer,
              null,
            )
        52 ->
          valueCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCountSer, null)
        53 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDistanceSer, null)
        54 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDurationSer, null)
        55 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueHumanNameSer,
              null,
            )
        56 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueIdentifierSer,
              null,
            )
        57 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMoneySer, null)
        58 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        59 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        60 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        61 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        62 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRatioRangeSer,
              null,
            )
        63 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        64 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSampledDataSer,
              null,
            )
        65 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSignatureSer,
              null,
            )
        66 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueTimingSer, null)
        67 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactDetailSer,
              null,
            )
        68 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        69 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExpressionSer,
              null,
            )
        70 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        73 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueUsageContextSer,
              null,
            )
        74 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAvailabilitySer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        76 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDosageSer, null)
        77 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Input: " + i)
      }
    }
    return Task.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: throw SerializationException("Missing required property 'type' on Task.Input"),
      `value` =
        Task.Input.Value.from(
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Canonical.of(valueCanonical, _valueCanonical),
          Code.of(valueCode, _valueCode),
          Date.of(valueDate?.let { FhirDate.fromString(it) }, _valueDate),
          DateTime.of(valueDateTime?.let { FhirDateTime.fromString(it) }, _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(valueInstant?.let { FhirDateTime.fromString(it) }, _valueInstant),
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
        ) ?: throw SerializationException("Missing required property 'value' on Task.Input"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Task.Input) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.`value`) {
      is Task.Input.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 16, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 17, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 18, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 19, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 20, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 21, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 22, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 23, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Integer64 -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 24, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 25, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 26, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 27, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Oid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 28, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 29, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 30, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 31, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 32, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 33, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 34, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 35, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 36, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 37, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 38, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 39, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 40, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 41, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Uuid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 42, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 43, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Input.Value.Address -> {
        encoder.encodeSerializableElement(descriptor, 44, Hoisted.valueAddressSer, choice.value)
      }
      is Task.Input.Value.Age -> {
        encoder.encodeSerializableElement(descriptor, 45, Hoisted.valueAgeSer, choice.value)
      }
      is Task.Input.Value.Annotation -> {
        encoder.encodeSerializableElement(descriptor, 46, Hoisted.valueAnnotationSer, choice.value)
      }
      is Task.Input.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 47, Hoisted.valueAttachmentSer, choice.value)
      }
      is Task.Input.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 48, Hoisted.typeSer, choice.value)
      }
      is Task.Input.Value.CodeableReference -> {
        encoder.encodeSerializableElement(
          descriptor,
          49,
          Hoisted.valueCodeableReferenceSer,
          choice.value,
        )
      }
      is Task.Input.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 50, Hoisted.valueCodingSer, choice.value)
      }
      is Task.Input.Value.ContactPoint -> {
        encoder.encodeSerializableElement(
          descriptor,
          51,
          Hoisted.valueContactPointSer,
          choice.value,
        )
      }
      is Task.Input.Value.Count -> {
        encoder.encodeSerializableElement(descriptor, 52, Hoisted.valueCountSer, choice.value)
      }
      is Task.Input.Value.Distance -> {
        encoder.encodeSerializableElement(descriptor, 53, Hoisted.valueDistanceSer, choice.value)
      }
      is Task.Input.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 54, Hoisted.valueDurationSer, choice.value)
      }
      is Task.Input.Value.HumanName -> {
        encoder.encodeSerializableElement(descriptor, 55, Hoisted.valueHumanNameSer, choice.value)
      }
      is Task.Input.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 56, Hoisted.valueIdentifierSer, choice.value)
      }
      is Task.Input.Value.Money -> {
        encoder.encodeSerializableElement(descriptor, 57, Hoisted.valueMoneySer, choice.value)
      }
      is Task.Input.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 58, Hoisted.valuePeriodSer, choice.value)
      }
      is Task.Input.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 59, Hoisted.valueQuantitySer, choice.value)
      }
      is Task.Input.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 60, Hoisted.valueRangeSer, choice.value)
      }
      is Task.Input.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 61, Hoisted.valueRatioSer, choice.value)
      }
      is Task.Input.Value.RatioRange -> {
        encoder.encodeSerializableElement(descriptor, 62, Hoisted.valueRatioRangeSer, choice.value)
      }
      is Task.Input.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 63, Hoisted.valueReferenceSer, choice.value)
      }
      is Task.Input.Value.SampledData -> {
        encoder.encodeSerializableElement(descriptor, 64, Hoisted.valueSampledDataSer, choice.value)
      }
      is Task.Input.Value.Signature -> {
        encoder.encodeSerializableElement(descriptor, 65, Hoisted.valueSignatureSer, choice.value)
      }
      is Task.Input.Value.Timing -> {
        encoder.encodeSerializableElement(descriptor, 66, Hoisted.valueTimingSer, choice.value)
      }
      is Task.Input.Value.ContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          67,
          Hoisted.valueContactDetailSer,
          choice.value,
        )
      }
      is Task.Input.Value.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          68,
          Hoisted.valueDataRequirementSer,
          choice.value,
        )
      }
      is Task.Input.Value.Expression -> {
        encoder.encodeSerializableElement(descriptor, 69, Hoisted.valueExpressionSer, choice.value)
      }
      is Task.Input.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          70,
          Hoisted.valueParameterDefinitionSer,
          choice.value,
        )
      }
      is Task.Input.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          descriptor,
          71,
          Hoisted.valueRelatedArtifactSer,
          choice.value,
        )
      }
      is Task.Input.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          72,
          Hoisted.valueTriggerDefinitionSer,
          choice.value,
        )
      }
      is Task.Input.Value.UsageContext -> {
        encoder.encodeSerializableElement(
          descriptor,
          73,
          Hoisted.valueUsageContextSer,
          choice.value,
        )
      }
      is Task.Input.Value.Availability -> {
        encoder.encodeSerializableElement(
          descriptor,
          74,
          Hoisted.valueAvailabilitySer,
          choice.value,
        )
      }
      is Task.Input.Value.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          75,
          Hoisted.valueExtendedContactDetailSer,
          choice.value,
        )
      }
      is Task.Input.Value.Dosage -> {
        encoder.encodeSerializableElement(descriptor, 76, Hoisted.valueDosageSer, choice.value)
      }
      is Task.Input.Value.Meta -> {
        encoder.encodeSerializableElement(descriptor, 77, Hoisted.valueMetaSer, choice.value)
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

internal object TaskOutputSerializer : KSerializer<Task.Output> {
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
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
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

  override fun deserialize(decoder: Decoder): Task.Output =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Task.Output) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Task.Output {
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
    var valueDecimal: FhirDecimal? = null
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        5 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        6 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        8 -> valueCanonical = decoder.decodeStringElement(descriptor, i)
        9 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        10 -> valueCode = decoder.decodeStringElement(descriptor, i)
        11 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        12 -> valueDate = decoder.decodeStringElement(descriptor, i)
        13 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        14 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        18 -> valueId = decoder.decodeStringElement(descriptor, i)
        19 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        20 -> valueInstant = decoder.decodeStringElement(descriptor, i)
        21 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        22 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        23 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        24 -> valueInteger64 = decoder.decodeStringElement(descriptor, i)
        25 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        26 -> valueMarkdown = decoder.decodeStringElement(descriptor, i)
        27 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        28 -> valueOid = decoder.decodeStringElement(descriptor, i)
        29 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        30 -> valuePositiveInt = decoder.decodeIntElement(descriptor, i)
        31 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        32 -> valueString = decoder.decodeStringElement(descriptor, i)
        33 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        34 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        35 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        36 -> valueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        37 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        38 -> valueUri = decoder.decodeStringElement(descriptor, i)
        39 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        40 -> valueUrl = decoder.decodeStringElement(descriptor, i)
        41 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        42 -> valueUuid = decoder.decodeStringElement(descriptor, i)
        43 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        44 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAddressSer, null)
        45 ->
          valueAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAgeSer, null)
        46 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAnnotationSer,
              null,
            )
        47 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        48 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        49 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        50 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        51 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactPointSer,
              null,
            )
        52 ->
          valueCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCountSer, null)
        53 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDistanceSer, null)
        54 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDurationSer, null)
        55 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueHumanNameSer,
              null,
            )
        56 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueIdentifierSer,
              null,
            )
        57 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMoneySer, null)
        58 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        59 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        60 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        61 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        62 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRatioRangeSer,
              null,
            )
        63 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        64 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSampledDataSer,
              null,
            )
        65 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSignatureSer,
              null,
            )
        66 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueTimingSer, null)
        67 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactDetailSer,
              null,
            )
        68 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        69 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExpressionSer,
              null,
            )
        70 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        73 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueUsageContextSer,
              null,
            )
        74 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAvailabilitySer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        76 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDosageSer, null)
        77 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Output: " + i)
      }
    }
    return Task.Output(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Task.Output"),
      `value` =
        Task.Output.Value.from(
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Canonical.of(valueCanonical, _valueCanonical),
          Code.of(valueCode, _valueCode),
          Date.of(valueDate?.let { FhirDate.fromString(it) }, _valueDate),
          DateTime.of(valueDateTime?.let { FhirDateTime.fromString(it) }, _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(valueInstant?.let { FhirDateTime.fromString(it) }, _valueInstant),
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
        ) ?: throw SerializationException("Missing required property 'value' on Task.Output"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Task.Output) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.`value`) {
      is Task.Output.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 16, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 17, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 18, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 19, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 20, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 21, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 22, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 23, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Integer64 -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 24, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 25, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 26, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 27, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Oid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 28, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 29, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 30, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 31, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 32, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 33, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 34, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 35, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 36, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 37, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 38, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 39, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 40, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 41, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Uuid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 42, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 43, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Task.Output.Value.Address -> {
        encoder.encodeSerializableElement(descriptor, 44, Hoisted.valueAddressSer, choice.value)
      }
      is Task.Output.Value.Age -> {
        encoder.encodeSerializableElement(descriptor, 45, Hoisted.valueAgeSer, choice.value)
      }
      is Task.Output.Value.Annotation -> {
        encoder.encodeSerializableElement(descriptor, 46, Hoisted.valueAnnotationSer, choice.value)
      }
      is Task.Output.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 47, Hoisted.valueAttachmentSer, choice.value)
      }
      is Task.Output.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 48, Hoisted.typeSer, choice.value)
      }
      is Task.Output.Value.CodeableReference -> {
        encoder.encodeSerializableElement(
          descriptor,
          49,
          Hoisted.valueCodeableReferenceSer,
          choice.value,
        )
      }
      is Task.Output.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 50, Hoisted.valueCodingSer, choice.value)
      }
      is Task.Output.Value.ContactPoint -> {
        encoder.encodeSerializableElement(
          descriptor,
          51,
          Hoisted.valueContactPointSer,
          choice.value,
        )
      }
      is Task.Output.Value.Count -> {
        encoder.encodeSerializableElement(descriptor, 52, Hoisted.valueCountSer, choice.value)
      }
      is Task.Output.Value.Distance -> {
        encoder.encodeSerializableElement(descriptor, 53, Hoisted.valueDistanceSer, choice.value)
      }
      is Task.Output.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 54, Hoisted.valueDurationSer, choice.value)
      }
      is Task.Output.Value.HumanName -> {
        encoder.encodeSerializableElement(descriptor, 55, Hoisted.valueHumanNameSer, choice.value)
      }
      is Task.Output.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 56, Hoisted.valueIdentifierSer, choice.value)
      }
      is Task.Output.Value.Money -> {
        encoder.encodeSerializableElement(descriptor, 57, Hoisted.valueMoneySer, choice.value)
      }
      is Task.Output.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 58, Hoisted.valuePeriodSer, choice.value)
      }
      is Task.Output.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 59, Hoisted.valueQuantitySer, choice.value)
      }
      is Task.Output.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 60, Hoisted.valueRangeSer, choice.value)
      }
      is Task.Output.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 61, Hoisted.valueRatioSer, choice.value)
      }
      is Task.Output.Value.RatioRange -> {
        encoder.encodeSerializableElement(descriptor, 62, Hoisted.valueRatioRangeSer, choice.value)
      }
      is Task.Output.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 63, Hoisted.valueReferenceSer, choice.value)
      }
      is Task.Output.Value.SampledData -> {
        encoder.encodeSerializableElement(descriptor, 64, Hoisted.valueSampledDataSer, choice.value)
      }
      is Task.Output.Value.Signature -> {
        encoder.encodeSerializableElement(descriptor, 65, Hoisted.valueSignatureSer, choice.value)
      }
      is Task.Output.Value.Timing -> {
        encoder.encodeSerializableElement(descriptor, 66, Hoisted.valueTimingSer, choice.value)
      }
      is Task.Output.Value.ContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          67,
          Hoisted.valueContactDetailSer,
          choice.value,
        )
      }
      is Task.Output.Value.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          68,
          Hoisted.valueDataRequirementSer,
          choice.value,
        )
      }
      is Task.Output.Value.Expression -> {
        encoder.encodeSerializableElement(descriptor, 69, Hoisted.valueExpressionSer, choice.value)
      }
      is Task.Output.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          70,
          Hoisted.valueParameterDefinitionSer,
          choice.value,
        )
      }
      is Task.Output.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          descriptor,
          71,
          Hoisted.valueRelatedArtifactSer,
          choice.value,
        )
      }
      is Task.Output.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          72,
          Hoisted.valueTriggerDefinitionSer,
          choice.value,
        )
      }
      is Task.Output.Value.UsageContext -> {
        encoder.encodeSerializableElement(
          descriptor,
          73,
          Hoisted.valueUsageContextSer,
          choice.value,
        )
      }
      is Task.Output.Value.Availability -> {
        encoder.encodeSerializableElement(
          descriptor,
          74,
          Hoisted.valueAvailabilitySer,
          choice.value,
        )
      }
      is Task.Output.Value.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          75,
          Hoisted.valueExtendedContactDetailSer,
          choice.value,
        )
      }
      is Task.Output.Value.Dosage -> {
        encoder.encodeSerializableElement(descriptor, 76, Hoisted.valueDosageSer, choice.value)
      }
      is Task.Output.Value.Meta -> {
        encoder.encodeSerializableElement(descriptor, 77, Hoisted.valueMetaSer, choice.value)
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

internal object TaskSerializer : KSerializer<Task> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Task") {
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
    b.element("statusReason", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("businessStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("intent", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element("priority", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_priority", Element.serializer().descriptor, isOptional = true)
    b.element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("focus", Reference.serializer().descriptor, isOptional = true)
    b.element("for", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("requestedPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("executionPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("authoredOn", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_authoredOn", Element.serializer().descriptor, isOptional = true)
    b.element("lastModified", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastModified", Element.serializer().descriptor, isOptional = true)
    b.element("requester", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "requestedPerformer",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("owner", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(lazyDescriptor { Task.Performer.serializer().descriptor }),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
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
      lazyDescriptor { Task.Restriction.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "input",
      listSerialDescriptor(lazyDescriptor { Task.Input.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "output",
      listSerialDescriptor(lazyDescriptor { Task.Output.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Task =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Task) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Task")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Task {
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
    var statusReason: CodeableReference? = null
    var businessStatus: CodeableConcept? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var code: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var focus: Reference? = null
    var `for`: Reference? = null
    var encounter: Reference? = null
    var requestedPeriod: Period? = null
    var executionPeriod: Period? = null
    var authoredOn: KotlinString? = null
    var _authoredOn: Element? = null
    var lastModified: KotlinString? = null
    var _lastModified: Element? = null
    var requester: Reference? = null
    var requestedPerformer: List<CodeableReference>? = null
    var owner: Reference? = null
    var performer: List<Task.Performer>? = null
    var location: Reference? = null
    var reason: List<CodeableReference>? = null
    var insurance: List<Reference>? = null
    var note: List<Annotation>? = null
    var relevantHistory: List<Reference>? = null
    var restriction: Task.Restriction? = null
    var input: List<Task.Input>? = null
    var output: List<Task.Output>? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> instantiatesCanonical = decoder.decodeStringElement(descriptor, i)
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> instantiatesUri = decoder.decodeStringElement(descriptor, i)
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        16 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        17 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 ->
          statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        21 ->
          businessStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.businessStatusSer,
              null,
            )
        22 -> intent = decoder.decodeStringElement(descriptor, i)
        23 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> priority = decoder.decodeStringElement(descriptor, i)
        25 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        27 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.businessStatusSer,
              null,
            )
        29 -> description = decoder.decodeStringElement(descriptor, i)
        30 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 ->
          focus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        32 ->
          `for` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        33 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        34 ->
          requestedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.requestedPeriodSer,
              null,
            )
        35 ->
          executionPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.requestedPeriodSer,
              null,
            )
        36 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        37 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        38 -> lastModified = decoder.decodeStringElement(descriptor, i)
        39 ->
          _lastModified =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        40 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        41 ->
          requestedPerformer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.requestedPerformerSer,
              null,
            )
        42 ->
          owner =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        43 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        44 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        45 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.requestedPerformerSer,
              null,
            )
        46 ->
          insurance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        47 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        48 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        49 ->
          restriction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.restrictionSer, null)
        50 ->
          input = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.inputSer, null)
        51 ->
          output = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.outputSer, null)
        else -> throw SerializationException("Unexpected index decoding Task: " + i)
      }
    }
    return Task(
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
      status =
        Enumeration.of(status?.let { Task.TaskStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Task"),
      statusReason = statusReason,
      businessStatus = businessStatus,
      intent =
        Enumeration.of(intent?.let { Task.TaskIntent.fromCode(it) }, _intent)
          ?: throw SerializationException("Missing required property 'intent' on Task"),
      priority = Enumeration.of(priority?.let { Task.RequestPriority.fromCode(it) }, _priority),
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      code = code,
      description = R5String.of(description, _description),
      focus = focus,
      `for` = `for`,
      encounter = encounter,
      requestedPeriod = requestedPeriod,
      executionPeriod = executionPeriod,
      authoredOn = DateTime.of(authoredOn?.let { FhirDateTime.fromString(it) }, _authoredOn),
      lastModified = DateTime.of(lastModified?.let { FhirDateTime.fromString(it) }, _lastModified),
      requester = requester,
      requestedPerformer = requestedPerformer ?: listOf(),
      owner = owner,
      performer = performer ?: listOf(),
      location = location,
      reason = reason ?: listOf(),
      insurance = insurance ?: listOf(),
      note = note ?: listOf(),
      relevantHistory = relevantHistory ?: listOf(),
      restriction = restriction,
      input = input ?: listOf(),
      output = output ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Task,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.instantiatesCanonical?.value))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.instantiatesCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.instantiatesUri?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.instantiatesUri?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.basedOnSer,
        value.partOf,
      )
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    (value.businessStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.businessStatusSer,
        it,
      )
    }
    ((value.intent.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.priority?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.doNotPerform?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.businessStatusSer,
        it,
      )
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.focus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.`for`)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.requestedPeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.requestedPeriodSer,
        it,
      )
    }
    (value.executionPeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.requestedPeriodSer,
        it,
      )
    }
    ((value.authoredOn?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 36 + descriptorOffset, it)
    }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastModified?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 38 + descriptorOffset, it)
    }
    (value.lastModified?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.requestedPerformer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.requestedPerformerSer,
        value.requestedPerformer,
      )
    (value.owner)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.performerSer,
        value.performer,
      )
    (value.location)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.requestedPerformerSer,
        value.reason,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.basedOnSer,
        value.insurance,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.basedOnSer,
        value.relevantHistory,
      )
    (value.restriction)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.restrictionSer,
        it,
      )
    }
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.inputSer,
        value.input,
      )
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.outputSer,
        value.output,
      )
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

    public val statusReasonSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val businessStatusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val requestedPeriodSer: KSerializer<Period> = Period.serializer()

    public val requestedPerformerSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val performerSerInner: KSerializer<Task.Performer> = Task.Performer.serializer()

    public val performerSer: KSerializer<List<Task.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val restrictionSer: KSerializer<Task.Restriction> = Task.Restriction.serializer()

    public val inputSerInner: KSerializer<Task.Input> = Task.Input.serializer()

    public val inputSer: KSerializer<List<Task.Input>> = ListSerializer(Hoisted.inputSerInner)

    public val outputSerInner: KSerializer<Task.Output> = Task.Output.serializer()

    public val outputSer: KSerializer<List<Task.Output>> = ListSerializer(Hoisted.outputSerInner)
  }
}

internal object TaskPolymorphicSerializer : KSerializer<Task> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Task") { TaskSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Task) {
    encoder.encodeStructure(descriptor) {
      TaskSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Task =
    decoder.decodeStructure(descriptor) {
      TaskSerializer.deserializeInternal(this, descriptor, 0)
    }
}
