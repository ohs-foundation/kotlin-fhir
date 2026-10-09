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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
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
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
import dev.ohs.fhir.model.r5.terminologies.RequestPriority
import dev.ohs.fhir.model.r5.terminologies.TaskIntent
import dev.ohs.fhir.model.r5.terminologies.TaskStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object TaskPerformerSerializer : FhirSerializer<Task.Performer> {
  override val descriptor: SerialDescriptor = buildDescriptor("Performer", this)

  @JvmField internal val listSerializer: KSerializer<List<Task.Performer>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("function", CodeableConceptSerializer.descriptor)
    b.optionalElement("actor", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Performer {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          function =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Task.Performer(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      function = function,
      actor = required(actor, "Task.Performer", "actor"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Task.Performer) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.function,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TaskRestrictionSerializer : FhirSerializer<Task.Restriction> {
  override val descriptor: SerialDescriptor = buildDescriptor("Restriction", this)

  @JvmField internal val listSerializer: KSerializer<List<Task.Restriction>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("repetitions")
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("recipient", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Restriction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var repetitions: Int? = null
    var _repetitions: Element? = null
    var period: Period? = null
    var recipient: List<Reference>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> repetitions = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _repetitions =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        6 ->
          recipient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Task.Restriction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      repetitions = PositiveInt.of(repetitions, _repetitions),
      period = period,
      recipient = listOrEmpty(recipient),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Task.Restriction) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.repetitions?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.repetitions)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, PeriodSerializer, value.period)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      ReferenceSerializer.listSerializer,
      value.recipient,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TaskInputSerializer : FhirSerializer<Task.Input> {
  override val descriptor: SerialDescriptor = buildDescriptor("Input", this)

  @JvmField internal val listSerializer: KSerializer<List<Task.Input>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("valueBase64Binary")
    b.boolPrim("valueBoolean")
    b.strPrim("valueCanonical")
    b.strPrim("valueCode")
    b.strPrim("valueDate")
    b.strPrim("valueDateTime")
    b.prim("valueDecimal", FhirDecimalSerializer.descriptor)
    b.strPrim("valueId")
    b.strPrim("valueInstant")
    b.intPrim("valueInteger")
    b.strPrim("valueInteger64")
    b.strPrim("valueMarkdown")
    b.strPrim("valueOid")
    b.intPrim("valuePositiveInt")
    b.strPrim("valueString")
    b.prim("valueTime", LocalTimeSerializer.descriptor)
    b.intPrim("valueUnsignedInt")
    b.strPrim("valueUri")
    b.strPrim("valueUrl")
    b.strPrim("valueUuid")
    b.optionalElement("valueAddress", AddressSerializer.descriptor)
    b.optionalElement("valueAge", AgeSerializer.descriptor)
    b.optionalElement("valueAnnotation", AnnotationSerializer.descriptor)
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueCodeableReference", CodeableReferenceSerializer.descriptor)
    b.optionalElement("valueCoding", CodingSerializer.descriptor)
    b.optionalElement("valueContactPoint", ContactPointSerializer.descriptor)
    b.optionalElement("valueCount", CountSerializer.descriptor)
    b.optionalElement("valueDistance", DistanceSerializer.descriptor)
    b.optionalElement("valueDuration", DurationSerializer.descriptor)
    b.optionalElement("valueHumanName", HumanNameSerializer.descriptor)
    b.optionalElement("valueIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("valueMoney", MoneySerializer.descriptor)
    b.optionalElement("valuePeriod", PeriodSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueRange", RangeSerializer.descriptor)
    b.optionalElement("valueRatio", RatioSerializer.descriptor)
    b.optionalElement("valueRatioRange", RatioRangeSerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
    b.optionalElement("valueSampledData", SampledDataSerializer.descriptor)
    b.optionalElement("valueSignature", SignatureSerializer.descriptor)
    b.optionalElement("valueTiming", TimingSerializer.descriptor)
    b.optionalElement("valueContactDetail", ContactDetailSerializer.descriptor)
    b.optionalElement("valueDataRequirement", DataRequirementSerializer.descriptor)
    b.optionalElement("valueExpression", ExpressionSerializer.descriptor)
    b.optionalElement("valueParameterDefinition", ParameterDefinitionSerializer.descriptor)
    b.optionalElement("valueRelatedArtifact", RelatedArtifactSerializer.descriptor)
    b.optionalElement("valueTriggerDefinition", TriggerDefinitionSerializer.descriptor)
    b.optionalElement("valueUsageContext", UsageContextSerializer.descriptor)
    b.optionalElement("valueAvailability", AvailabilitySerializer.descriptor)
    b.optionalElement("valueExtendedContactDetail", ExtendedContactDetailSerializer.descriptor)
    b.optionalElement("valueDosage", DosageSerializer.descriptor)
    b.optionalElement("valueMeta", MetaSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Input {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var valueDate: FhirDate? = null
    var _valueDate: Element? = null
    var valueDateTime: FhirDateTime? = null
    var _valueDateTime: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
    var valueId: KotlinString? = null
    var _valueId: Element? = null
    var valueInstant: FhirDateTime? = null
    var _valueInstant: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueInteger64: Long? = null
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> valueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _valueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        7 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> valueCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _valueCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        15 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        17 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> valueId = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _valueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          valueInstant =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _valueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        23 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> valueInteger64 = compositeDecoder.decodeStringElement(descriptor, i).toLong()
        25 ->
          _valueInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> valueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _valueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> valueOid = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _valueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> valuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        31 ->
          _valuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        35 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> valueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        37 ->
          _valueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 -> valueUri = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _valueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 -> valueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _valueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 -> valueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        43 ->
          _valueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 ->
          valueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        45 ->
          valueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        46 ->
          valueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        47 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        48 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        49 ->
          valueCodeableReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        50 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        51 ->
          valueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        52 ->
          valueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        53 ->
          valueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        54 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        55 ->
          valueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        56 ->
          valueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        57 ->
          valueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        58 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        59 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        60 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        61 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        62 ->
          valueRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        63 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        64 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        65 ->
          valueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        66 ->
          valueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        67 ->
          valueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        68 ->
          valueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        69 ->
          valueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        70 ->
          valueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        73 ->
          valueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        74 ->
          valueAvailability =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilitySerializer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer,
              null,
            )
        76 ->
          valueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        77 ->
          valueMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Task.Input(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "Task.Input", "type"),
      `value` =
        required(
          Task.Input.Value.from(
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Canonical.of(valueCanonical, _valueCanonical),
            Code.of(valueCode, _valueCode),
            Date.of(valueDate, _valueDate),
            DateTime.of(valueDateTime, _valueDateTime),
            Decimal.of(valueDecimal, _valueDecimal),
            Id.of(valueId, _valueId),
            Instant.of(valueInstant, _valueInstant),
            Integer.of(valueInteger, _valueInteger),
            Integer64.of(valueInteger64, _valueInteger64),
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
          ),
          "Task.Input",
          "value",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Task.Input) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`value`) {
      is Task.Input.Value.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is Task.Input.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is Task.Input.Value.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is Task.Input.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is Task.Input.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is Task.Input.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 15, choice.value)
      }
      is Task.Input.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          16,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 17, choice.value)
      }
      is Task.Input.Value.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 18, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 19, choice.value)
      }
      is Task.Input.Value.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 20, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 21, choice.value)
      }
      is Task.Input.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 22, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 23, choice.value)
      }
      is Task.Input.Value.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 24, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 25, choice.value)
      }
      is Task.Input.Value.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 26, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 27, choice.value)
      }
      is Task.Input.Value.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 28, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 29, choice.value)
      }
      is Task.Input.Value.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 30, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 31, choice.value)
      }
      is Task.Input.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 32, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 33, choice.value)
      }
      is Task.Input.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          34,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 35, choice.value)
      }
      is Task.Input.Value.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 36, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 37, choice.value)
      }
      is Task.Input.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 38, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 39, choice.value)
      }
      is Task.Input.Value.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 40, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 41, choice.value)
      }
      is Task.Input.Value.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 42, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 43, choice.value)
      }
      is Task.Input.Value.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 44, AddressSerializer, choice.value)
      }
      is Task.Input.Value.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 45, AgeSerializer, choice.value)
      }
      is Task.Input.Value.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          46,
          AnnotationSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          47,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          48,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.CodeableReference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          49,
          CodeableReferenceSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 50, CodingSerializer, choice.value)
      }
      is Task.Input.Value.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          51,
          ContactPointSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 52, CountSerializer, choice.value)
      }
      is Task.Input.Value.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 53, DistanceSerializer, choice.value)
      }
      is Task.Input.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 54, DurationSerializer, choice.value)
      }
      is Task.Input.Value.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          55,
          HumanNameSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          56,
          IdentifierSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 57, MoneySerializer, choice.value)
      }
      is Task.Input.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 58, PeriodSerializer, choice.value)
      }
      is Task.Input.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 59, QuantitySerializer, choice.value)
      }
      is Task.Input.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 60, RangeSerializer, choice.value)
      }
      is Task.Input.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 61, RatioSerializer, choice.value)
      }
      is Task.Input.Value.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          62,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          63,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          64,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          65,
          SignatureSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 66, TimingSerializer, choice.value)
      }
      is Task.Input.Value.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          67,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          68,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          69,
          ExpressionSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          70,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          71,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          72,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          73,
          UsageContextSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Availability -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          74,
          AvailabilitySerializer,
          choice.value,
        )
      }
      is Task.Input.Value.ExtendedContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          75,
          ExtendedContactDetailSerializer,
          choice.value,
        )
      }
      is Task.Input.Value.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 76, DosageSerializer, choice.value)
      }
      is Task.Input.Value.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 77, MetaSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TaskOutputSerializer : FhirSerializer<Task.Output> {
  override val descriptor: SerialDescriptor = buildDescriptor("Output", this)

  @JvmField internal val listSerializer: KSerializer<List<Task.Output>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("valueBase64Binary")
    b.boolPrim("valueBoolean")
    b.strPrim("valueCanonical")
    b.strPrim("valueCode")
    b.strPrim("valueDate")
    b.strPrim("valueDateTime")
    b.prim("valueDecimal", FhirDecimalSerializer.descriptor)
    b.strPrim("valueId")
    b.strPrim("valueInstant")
    b.intPrim("valueInteger")
    b.strPrim("valueInteger64")
    b.strPrim("valueMarkdown")
    b.strPrim("valueOid")
    b.intPrim("valuePositiveInt")
    b.strPrim("valueString")
    b.prim("valueTime", LocalTimeSerializer.descriptor)
    b.intPrim("valueUnsignedInt")
    b.strPrim("valueUri")
    b.strPrim("valueUrl")
    b.strPrim("valueUuid")
    b.optionalElement("valueAddress", AddressSerializer.descriptor)
    b.optionalElement("valueAge", AgeSerializer.descriptor)
    b.optionalElement("valueAnnotation", AnnotationSerializer.descriptor)
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueCodeableReference", CodeableReferenceSerializer.descriptor)
    b.optionalElement("valueCoding", CodingSerializer.descriptor)
    b.optionalElement("valueContactPoint", ContactPointSerializer.descriptor)
    b.optionalElement("valueCount", CountSerializer.descriptor)
    b.optionalElement("valueDistance", DistanceSerializer.descriptor)
    b.optionalElement("valueDuration", DurationSerializer.descriptor)
    b.optionalElement("valueHumanName", HumanNameSerializer.descriptor)
    b.optionalElement("valueIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("valueMoney", MoneySerializer.descriptor)
    b.optionalElement("valuePeriod", PeriodSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueRange", RangeSerializer.descriptor)
    b.optionalElement("valueRatio", RatioSerializer.descriptor)
    b.optionalElement("valueRatioRange", RatioRangeSerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
    b.optionalElement("valueSampledData", SampledDataSerializer.descriptor)
    b.optionalElement("valueSignature", SignatureSerializer.descriptor)
    b.optionalElement("valueTiming", TimingSerializer.descriptor)
    b.optionalElement("valueContactDetail", ContactDetailSerializer.descriptor)
    b.optionalElement("valueDataRequirement", DataRequirementSerializer.descriptor)
    b.optionalElement("valueExpression", ExpressionSerializer.descriptor)
    b.optionalElement("valueParameterDefinition", ParameterDefinitionSerializer.descriptor)
    b.optionalElement("valueRelatedArtifact", RelatedArtifactSerializer.descriptor)
    b.optionalElement("valueTriggerDefinition", TriggerDefinitionSerializer.descriptor)
    b.optionalElement("valueUsageContext", UsageContextSerializer.descriptor)
    b.optionalElement("valueAvailability", AvailabilitySerializer.descriptor)
    b.optionalElement("valueExtendedContactDetail", ExtendedContactDetailSerializer.descriptor)
    b.optionalElement("valueDosage", DosageSerializer.descriptor)
    b.optionalElement("valueMeta", MetaSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Output {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var valueDate: FhirDate? = null
    var _valueDate: Element? = null
    var valueDateTime: FhirDateTime? = null
    var _valueDateTime: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
    var valueId: KotlinString? = null
    var _valueId: Element? = null
    var valueInstant: FhirDateTime? = null
    var _valueInstant: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueInteger64: Long? = null
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> valueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _valueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        7 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> valueCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _valueCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        15 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        17 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> valueId = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _valueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          valueInstant =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _valueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        23 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> valueInteger64 = compositeDecoder.decodeStringElement(descriptor, i).toLong()
        25 ->
          _valueInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> valueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _valueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> valueOid = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _valueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> valuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        31 ->
          _valuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        35 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> valueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        37 ->
          _valueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 -> valueUri = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _valueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 -> valueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _valueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 -> valueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        43 ->
          _valueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 ->
          valueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        45 ->
          valueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        46 ->
          valueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        47 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        48 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        49 ->
          valueCodeableReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        50 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        51 ->
          valueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        52 ->
          valueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        53 ->
          valueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        54 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        55 ->
          valueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        56 ->
          valueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        57 ->
          valueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        58 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        59 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        60 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        61 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        62 ->
          valueRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        63 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        64 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        65 ->
          valueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        66 ->
          valueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        67 ->
          valueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        68 ->
          valueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        69 ->
          valueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        70 ->
          valueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        73 ->
          valueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        74 ->
          valueAvailability =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilitySerializer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer,
              null,
            )
        76 ->
          valueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        77 ->
          valueMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Task.Output(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "Task.Output", "type"),
      `value` =
        required(
          Task.Output.Value.from(
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Canonical.of(valueCanonical, _valueCanonical),
            Code.of(valueCode, _valueCode),
            Date.of(valueDate, _valueDate),
            DateTime.of(valueDateTime, _valueDateTime),
            Decimal.of(valueDecimal, _valueDecimal),
            Id.of(valueId, _valueId),
            Instant.of(valueInstant, _valueInstant),
            Integer.of(valueInteger, _valueInteger),
            Integer64.of(valueInteger64, _valueInteger64),
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
          ),
          "Task.Output",
          "value",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Task.Output) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`value`) {
      is Task.Output.Value.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is Task.Output.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is Task.Output.Value.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is Task.Output.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is Task.Output.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is Task.Output.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 15, choice.value)
      }
      is Task.Output.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          16,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 17, choice.value)
      }
      is Task.Output.Value.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 18, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 19, choice.value)
      }
      is Task.Output.Value.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 20, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 21, choice.value)
      }
      is Task.Output.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 22, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 23, choice.value)
      }
      is Task.Output.Value.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 24, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 25, choice.value)
      }
      is Task.Output.Value.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 26, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 27, choice.value)
      }
      is Task.Output.Value.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 28, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 29, choice.value)
      }
      is Task.Output.Value.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 30, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 31, choice.value)
      }
      is Task.Output.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 32, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 33, choice.value)
      }
      is Task.Output.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          34,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 35, choice.value)
      }
      is Task.Output.Value.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 36, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 37, choice.value)
      }
      is Task.Output.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 38, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 39, choice.value)
      }
      is Task.Output.Value.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 40, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 41, choice.value)
      }
      is Task.Output.Value.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 42, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 43, choice.value)
      }
      is Task.Output.Value.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 44, AddressSerializer, choice.value)
      }
      is Task.Output.Value.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 45, AgeSerializer, choice.value)
      }
      is Task.Output.Value.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          46,
          AnnotationSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          47,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          48,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.CodeableReference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          49,
          CodeableReferenceSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 50, CodingSerializer, choice.value)
      }
      is Task.Output.Value.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          51,
          ContactPointSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 52, CountSerializer, choice.value)
      }
      is Task.Output.Value.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 53, DistanceSerializer, choice.value)
      }
      is Task.Output.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 54, DurationSerializer, choice.value)
      }
      is Task.Output.Value.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          55,
          HumanNameSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          56,
          IdentifierSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 57, MoneySerializer, choice.value)
      }
      is Task.Output.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 58, PeriodSerializer, choice.value)
      }
      is Task.Output.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 59, QuantitySerializer, choice.value)
      }
      is Task.Output.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 60, RangeSerializer, choice.value)
      }
      is Task.Output.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 61, RatioSerializer, choice.value)
      }
      is Task.Output.Value.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          62,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          63,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          64,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          65,
          SignatureSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 66, TimingSerializer, choice.value)
      }
      is Task.Output.Value.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          67,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          68,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          69,
          ExpressionSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          70,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          71,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          72,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          73,
          UsageContextSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Availability -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          74,
          AvailabilitySerializer,
          choice.value,
        )
      }
      is Task.Output.Value.ExtendedContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          75,
          ExtendedContactDetailSerializer,
          choice.value,
        )
      }
      is Task.Output.Value.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 76, DosageSerializer, choice.value)
      }
      is Task.Output.Value.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 77, MetaSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TaskSerializer : FhirResourceSerializer<Task> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Task")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("instantiatesCanonical")
    b.strPrim("instantiatesUri")
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("statusReason", CodeableReferenceSerializer.descriptor)
    b.optionalElement("businessStatus", CodeableConceptSerializer.descriptor)
    b.strPrim("intent")
    b.strPrim("priority")
    b.boolPrim("doNotPerform")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("focus", ReferenceSerializer.descriptor)
    b.optionalElement("for", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("requestedPeriod", PeriodSerializer.descriptor)
    b.optionalElement("executionPeriod", PeriodSerializer.descriptor)
    b.strPrim("authoredOn")
    b.strPrim("lastModified")
    b.optionalElement("requester", ReferenceSerializer.descriptor)
    b.optionalElement("requestedPerformer", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("owner", ReferenceSerializer.descriptor)
    b.optionalElement("performer", TaskPerformerSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("insurance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("relevantHistory", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("restriction", TaskRestrictionSerializer.descriptor)
    b.optionalElement("input", TaskInputSerializer.listSerializer.descriptor)
    b.optionalElement("output", TaskOutputSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: TaskStatus? = null
    var _status: Element? = null
    var statusReason: CodeableReference? = null
    var businessStatus: CodeableConcept? = null
    var intent: TaskIntent? = null
    var _intent: Element? = null
    var priority: RequestPriority? = null
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
    var authoredOn: FhirDateTime? = null
    var _authoredOn: Element? = null
    var lastModified: FhirDateTime? = null
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> instantiatesCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> instantiatesUri = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          groupIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        17 ->
          partOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 -> status = TaskStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        19 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          statusReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        21 ->
          businessStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        22 -> intent = TaskIntent.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        23 ->
          _intent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          priority = RequestPriority.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        25 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> doNotPerform = compositeDecoder.decodeBooleanElement(descriptor, i)
        27 ->
          _doNotPerform =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        29 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          focus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        32 ->
          `for` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        33 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        34 ->
          requestedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        35 ->
          executionPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        36 ->
          authoredOn = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        37 ->
          _authoredOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 ->
          lastModified =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        39 ->
          _lastModified =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 ->
          requester =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        41 ->
          requestedPerformer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        42 ->
          owner =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        43 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TaskPerformerSerializer.listSerializer,
              null,
            )
        44 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        45 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        46 ->
          insurance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        47 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        48 ->
          relevantHistory =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        49 ->
          restriction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TaskRestrictionSerializer,
              null,
            )
        50 ->
          input =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TaskInputSerializer.listSerializer,
              null,
            )
        51 ->
          output =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TaskOutputSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Task(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      instantiatesCanonical = Canonical.of(instantiatesCanonical, _instantiatesCanonical),
      instantiatesUri = Uri.of(instantiatesUri, _instantiatesUri),
      basedOn = listOrEmpty(basedOn),
      groupIdentifier = groupIdentifier,
      partOf = listOrEmpty(partOf),
      status = required(Enumeration.of(status, _status), "Task", "status"),
      statusReason = statusReason,
      businessStatus = businessStatus,
      intent = required(Enumeration.of(intent, _intent), "Task", "intent"),
      priority = Enumeration.of(priority, _priority),
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      code = code,
      description = R5String.of(description, _description),
      focus = focus,
      `for` = `for`,
      encounter = encounter,
      requestedPeriod = requestedPeriod,
      executionPeriod = executionPeriod,
      authoredOn = DateTime.of(authoredOn, _authoredOn),
      lastModified = DateTime.of(lastModified, _lastModified),
      requester = requester,
      requestedPerformer = listOrEmpty(requestedPerformer),
      owner = owner,
      performer = listOrEmpty(performer),
      location = location,
      reason = listOrEmpty(reason),
      insurance = listOrEmpty(insurance),
      note = listOrEmpty(note),
      relevantHistory = listOrEmpty(relevantHistory),
      restriction = restriction,
      input = listOrEmpty(input),
      output = listOrEmpty(output),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Task,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.instantiatesCanonical?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.instantiatesCanonical,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.instantiatesUri?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.instantiatesUri,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.basedOn,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.partOf,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      CodeableReferenceSerializer,
      value.statusReason,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      CodeableConceptSerializer,
      value.businessStatus,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.intent.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.intent)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.priority?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.priority)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.doNotPerform?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.doNotPerform)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.description)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.focus,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.`for`,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      PeriodSerializer,
      value.requestedPeriod,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      PeriodSerializer,
      value.executionPeriod,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.authoredOn)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      38 + descriptorOffset,
      value.lastModified?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.lastModified)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      41 + descriptorOffset,
      CodeableReferenceSerializer.listSerializer,
      value.requestedPerformer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      43 + descriptorOffset,
      TaskPerformerSerializer.listSerializer,
      value.performer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      45 + descriptorOffset,
      CodeableReferenceSerializer.listSerializer,
      value.reason,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      46 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.insurance,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      47 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      48 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.relevantHistory,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      TaskRestrictionSerializer,
      value.restriction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50 + descriptorOffset,
      TaskInputSerializer.listSerializer,
      value.input,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51 + descriptorOffset,
      TaskOutputSerializer.listSerializer,
      value.output,
    )
  }
}
