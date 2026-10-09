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
import dev.ohs.fhir.model.r5.Oid
import dev.ohs.fhir.model.r5.ParameterDefinition
import dev.ohs.fhir.model.r5.Parameters
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

internal object ParametersParameterSerializer : FhirSerializer<Parameters.Parameter> {
  override val descriptor: SerialDescriptor = buildDescriptor("Parameter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Parameters.Parameter>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
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
    b.optionalElement("resource", lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer))
    b.optionalElement(
      "part",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ParametersParameterSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): Parameters.Parameter {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
    var resource: Resource? = null
    var part: List<Parameters.Parameter>? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> valueCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _valueCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        18 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> valueId = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _valueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          valueInstant =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        22 ->
          _valueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        24 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> valueInteger64 = compositeDecoder.decodeStringElement(descriptor, i).toLong()
        26 ->
          _valueInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> valueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _valueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> valueOid = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _valueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 -> valuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        32 ->
          _valuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        36 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> valueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        38 ->
          _valueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> valueUri = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _valueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> valueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _valueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> valueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _valueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          valueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        46 ->
          valueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        47 ->
          valueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        48 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        49 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        50 ->
          valueCodeableReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        51 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        52 ->
          valueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        53 ->
          valueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        54 ->
          valueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        55 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        56 ->
          valueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        57 ->
          valueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        58 ->
          valueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        59 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        60 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        61 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        62 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        63 ->
          valueRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        64 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        65 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        66 ->
          valueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        67 ->
          valueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        68 ->
          valueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        69 ->
          valueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        70 ->
          valueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        71 ->
          valueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        72 ->
          valueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        73 ->
          valueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        74 ->
          valueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        75 ->
          valueAvailability =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilitySerializer,
              null,
            )
        76 ->
          valueExtendedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer,
              null,
            )
        77 ->
          valueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        78 ->
          valueMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        79 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer,
              null,
            )
        80 ->
          part =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParametersParameterSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Parameters.Parameter(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R5String.of(name, _name), "Parameters.Parameter", "name"),
      `value` =
        Parameters.Parameter.Value.from(
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
      resource = resource,
      part = listOrEmpty(part),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Parameters.Parameter) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    when (val choice = value.`value`) {
      null -> {}
      is Parameters.Parameter.Value.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is Parameters.Parameter.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is Parameters.Parameter.Value.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is Parameters.Parameter.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 11, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is Parameters.Parameter.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is Parameters.Parameter.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 15, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is Parameters.Parameter.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          17,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is Parameters.Parameter.Value.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 19, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 20, choice.value)
      }
      is Parameters.Parameter.Value.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 21, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 22, choice.value)
      }
      is Parameters.Parameter.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 23, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 24, choice.value)
      }
      is Parameters.Parameter.Value.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 25, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 26, choice.value)
      }
      is Parameters.Parameter.Value.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 27, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 28, choice.value)
      }
      is Parameters.Parameter.Value.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 29, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 30, choice.value)
      }
      is Parameters.Parameter.Value.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 31, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 32, choice.value)
      }
      is Parameters.Parameter.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 33, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 34, choice.value)
      }
      is Parameters.Parameter.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          35,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 36, choice.value)
      }
      is Parameters.Parameter.Value.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 37, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 38, choice.value)
      }
      is Parameters.Parameter.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 39, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 40, choice.value)
      }
      is Parameters.Parameter.Value.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 41, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 42, choice.value)
      }
      is Parameters.Parameter.Value.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 43, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 44, choice.value)
      }
      is Parameters.Parameter.Value.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 45, AddressSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 46, AgeSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          47,
          AnnotationSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          48,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          49,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.CodeableReference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          50,
          CodeableReferenceSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 51, CodingSerializer, choice.value)
      }
      is Parameters.Parameter.Value.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          52,
          ContactPointSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 53, CountSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 54, DistanceSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 55, DurationSerializer, choice.value)
      }
      is Parameters.Parameter.Value.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          56,
          HumanNameSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          57,
          IdentifierSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 58, MoneySerializer, choice.value)
      }
      is Parameters.Parameter.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 59, PeriodSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 60, QuantitySerializer, choice.value)
      }
      is Parameters.Parameter.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 61, RangeSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 62, RatioSerializer, choice.value)
      }
      is Parameters.Parameter.Value.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          63,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          64,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          65,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          66,
          SignatureSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 67, TimingSerializer, choice.value)
      }
      is Parameters.Parameter.Value.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          68,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          69,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          70,
          ExpressionSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          71,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          72,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          73,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          74,
          UsageContextSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Availability -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          75,
          AvailabilitySerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.ExtendedContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          76,
          ExtendedContactDetailSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 77, DosageSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 78, MetaSerializer, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      79,
      ResourcePolymorphicSerializer,
      value.resource,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      80,
      ParametersParameterSerializer.listSerializer,
      value.part,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ParametersSerializer : FhirResourceSerializer<Parameters> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Parameters")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("parameter", ParametersParameterSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Parameters {
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var parameter: List<Parameters.Parameter>? = null
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
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParametersParameterSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Parameters(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      parameter = listOrEmpty(parameter),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Parameters,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6 + descriptorOffset,
      ParametersParameterSerializer.listSerializer,
      value.parameter,
    )
  }
}
