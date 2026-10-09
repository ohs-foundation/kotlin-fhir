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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Age
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CodeableReference
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Contributor
import dev.ohs.fhir.model.r4b.Count
import dev.ohs.fhir.model.r4b.DataRequirement
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Distance
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Oid
import dev.ohs.fhir.model.r4b.ParameterDefinition
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.RatioRange
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.SampledData
import dev.ohs.fhir.model.r4b.Signature
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.TriggerDefinition
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.Uuid
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object ExtensionSerializer : FhirSerializer<Extension> {
  override val descriptor: SerialDescriptor = buildDescriptor("Extension", this)

  @JvmField internal val listSerializer: KSerializer<List<Extension>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.str("url")
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
    b.strPrim("valueMarkdown")
    b.strPrim("valueOid")
    b.intPrim("valuePositiveInt")
    b.strPrim("valueString")
    b.prim("valueTime", LocalTimeSerializer.descriptor)
    b.intPrim("valueUnsignedInt")
    b.strPrim("valueUri")
    b.strPrim("valueUrl")
    b.strPrim("valueUuid")
    b.optionalElement("valueAddress", lazyDescriptor(LazyDescriptorId.AddressSerializer))
    b.optionalElement("valueAge", lazyDescriptor(LazyDescriptorId.AgeSerializer))
    b.optionalElement("valueAnnotation", lazyDescriptor(LazyDescriptorId.AnnotationSerializer))
    b.optionalElement("valueAttachment", lazyDescriptor(LazyDescriptorId.AttachmentSerializer))
    b.optionalElement(
      "valueCodeableConcept",
      lazyDescriptor(LazyDescriptorId.CodeableConceptSerializer),
    )
    b.optionalElement(
      "valueCodeableReference",
      lazyDescriptor(LazyDescriptorId.CodeableReferenceSerializer),
    )
    b.optionalElement("valueCoding", lazyDescriptor(LazyDescriptorId.CodingSerializer))
    b.optionalElement("valueContactPoint", lazyDescriptor(LazyDescriptorId.ContactPointSerializer))
    b.optionalElement("valueCount", lazyDescriptor(LazyDescriptorId.CountSerializer))
    b.optionalElement("valueDistance", lazyDescriptor(LazyDescriptorId.DistanceSerializer))
    b.optionalElement("valueDuration", lazyDescriptor(LazyDescriptorId.DurationSerializer))
    b.optionalElement("valueHumanName", lazyDescriptor(LazyDescriptorId.HumanNameSerializer))
    b.optionalElement("valueIdentifier", lazyDescriptor(LazyDescriptorId.IdentifierSerializer))
    b.optionalElement("valueMoney", lazyDescriptor(LazyDescriptorId.MoneySerializer))
    b.optionalElement("valuePeriod", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
    b.optionalElement("valueQuantity", lazyDescriptor(LazyDescriptorId.QuantitySerializer))
    b.optionalElement("valueRange", lazyDescriptor(LazyDescriptorId.RangeSerializer))
    b.optionalElement("valueRatio", lazyDescriptor(LazyDescriptorId.RatioSerializer))
    b.optionalElement("valueRatioRange", lazyDescriptor(LazyDescriptorId.RatioRangeSerializer))
    b.optionalElement("valueReference", lazyDescriptor(LazyDescriptorId.ReferenceSerializer))
    b.optionalElement("valueSampledData", lazyDescriptor(LazyDescriptorId.SampledDataSerializer))
    b.optionalElement("valueSignature", lazyDescriptor(LazyDescriptorId.SignatureSerializer))
    b.optionalElement("valueTiming", lazyDescriptor(LazyDescriptorId.TimingSerializer))
    b.optionalElement(
      "valueContactDetail",
      lazyDescriptor(LazyDescriptorId.ContactDetailSerializer),
    )
    b.optionalElement("valueContributor", lazyDescriptor(LazyDescriptorId.ContributorSerializer))
    b.optionalElement(
      "valueDataRequirement",
      lazyDescriptor(LazyDescriptorId.DataRequirementSerializer),
    )
    b.optionalElement("valueExpression", lazyDescriptor(LazyDescriptorId.ExpressionSerializer))
    b.optionalElement(
      "valueParameterDefinition",
      lazyDescriptor(LazyDescriptorId.ParameterDefinitionSerializer),
    )
    b.optionalElement(
      "valueRelatedArtifact",
      lazyDescriptor(LazyDescriptorId.RelatedArtifactSerializer),
    )
    b.optionalElement(
      "valueTriggerDefinition",
      lazyDescriptor(LazyDescriptorId.TriggerDefinitionSerializer),
    )
    b.optionalElement("valueUsageContext", lazyDescriptor(LazyDescriptorId.UsageContextSerializer))
    b.optionalElement("valueDosage", lazyDescriptor(LazyDescriptorId.DosageSerializer))
  }

  override fun deserialize(decoder: Decoder): Extension {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var url: KotlinString? = null
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
    var valueContributor: Contributor? = null
    var valueDataRequirement: DataRequirement? = null
    var valueExpression: Expression? = null
    var valueParameterDefinition: ParameterDefinition? = null
    var valueRelatedArtifact: RelatedArtifact? = null
    var valueTriggerDefinition: TriggerDefinition? = null
    var valueUsageContext: UsageContext? = null
    var valueDosage: Dosage? = null
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
        2 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        3 -> valueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _valueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> valueCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _valueCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        16 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> valueId = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _valueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          valueInstant =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _valueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        22 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> valueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _valueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> valueOid = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _valueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> valuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        28 ->
          _valuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        32 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> valueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        34 ->
          _valueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 -> valueUri = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _valueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> valueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _valueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> valueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _valueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 ->
          valueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        42 ->
          valueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        43 ->
          valueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        44 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        45 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        46 ->
          valueCodeableReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        47 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        48 ->
          valueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        49 ->
          valueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        50 ->
          valueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        51 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        52 ->
          valueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        53 ->
          valueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        54 ->
          valueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        55 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        56 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        57 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        58 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        59 ->
          valueRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        60 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        61 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        62 ->
          valueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        63 ->
          valueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        64 ->
          valueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        65 ->
          valueContributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContributorSerializer,
              null,
            )
        66 ->
          valueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        67 ->
          valueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        68 ->
          valueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        69 ->
          valueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        70 ->
          valueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        71 ->
          valueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        72 ->
          valueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Extension(
      id = id,
      extension = listOrEmpty(extension),
      url = required(url, "Extension", "url"),
      `value` =
        Extension.Value.from(
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          Canonical.of(valueCanonical, _valueCanonical),
          Code.of(valueCode, _valueCode),
          Date.of(valueDate, _valueDate),
          DateTime.of(valueDateTime, _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(valueInstant, _valueInstant),
          Integer.of(valueInteger, _valueInteger),
          Markdown.of(valueMarkdown, _valueMarkdown),
          Oid.of(valueOid, _valueOid),
          PositiveInt.of(valuePositiveInt, _valuePositiveInt),
          R4bString.of(valueString, _valueString),
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
          valueContributor,
          valueDataRequirement,
          valueExpression,
          valueParameterDefinition,
          valueRelatedArtifact,
          valueTriggerDefinition,
          valueUsageContext,
          valueDosage,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Extension) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringElement(descriptor, 2, value.url)
    when (val choice = value.`value`) {
      null -> {}
      is Extension.Value.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is Extension.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is Extension.Value.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is Extension.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is Extension.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 11, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is Extension.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is Extension.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          15,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is Extension.Value.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 17, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is Extension.Value.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 19, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 20, choice.value)
      }
      is Extension.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 21, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 22, choice.value)
      }
      is Extension.Value.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 23, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 24, choice.value)
      }
      is Extension.Value.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 25, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 26, choice.value)
      }
      is Extension.Value.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 27, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 28, choice.value)
      }
      is Extension.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 29, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 30, choice.value)
      }
      is Extension.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          31,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 32, choice.value)
      }
      is Extension.Value.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 33, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 34, choice.value)
      }
      is Extension.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 35, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 36, choice.value)
      }
      is Extension.Value.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 37, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 38, choice.value)
      }
      is Extension.Value.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 39, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 40, choice.value)
      }
      is Extension.Value.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 41, AddressSerializer, choice.value)
      }
      is Extension.Value.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 42, AgeSerializer, choice.value)
      }
      is Extension.Value.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          43,
          AnnotationSerializer,
          choice.value,
        )
      }
      is Extension.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          44,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Extension.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          45,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Extension.Value.CodeableReference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          46,
          CodeableReferenceSerializer,
          choice.value,
        )
      }
      is Extension.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 47, CodingSerializer, choice.value)
      }
      is Extension.Value.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          48,
          ContactPointSerializer,
          choice.value,
        )
      }
      is Extension.Value.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 49, CountSerializer, choice.value)
      }
      is Extension.Value.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 50, DistanceSerializer, choice.value)
      }
      is Extension.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 51, DurationSerializer, choice.value)
      }
      is Extension.Value.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          52,
          HumanNameSerializer,
          choice.value,
        )
      }
      is Extension.Value.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          53,
          IdentifierSerializer,
          choice.value,
        )
      }
      is Extension.Value.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 54, MoneySerializer, choice.value)
      }
      is Extension.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 55, PeriodSerializer, choice.value)
      }
      is Extension.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 56, QuantitySerializer, choice.value)
      }
      is Extension.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 57, RangeSerializer, choice.value)
      }
      is Extension.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 58, RatioSerializer, choice.value)
      }
      is Extension.Value.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          59,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is Extension.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          60,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Extension.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          61,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Extension.Value.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          62,
          SignatureSerializer,
          choice.value,
        )
      }
      is Extension.Value.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 63, TimingSerializer, choice.value)
      }
      is Extension.Value.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          64,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is Extension.Value.Contributor -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          65,
          ContributorSerializer,
          choice.value,
        )
      }
      is Extension.Value.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          66,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is Extension.Value.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          67,
          ExpressionSerializer,
          choice.value,
        )
      }
      is Extension.Value.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          68,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is Extension.Value.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          69,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is Extension.Value.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          70,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is Extension.Value.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          71,
          UsageContextSerializer,
          choice.value,
        )
      }
      is Extension.Value.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 72, DosageSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}
