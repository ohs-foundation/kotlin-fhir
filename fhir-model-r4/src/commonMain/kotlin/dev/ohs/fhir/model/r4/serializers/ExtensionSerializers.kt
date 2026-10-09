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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Contributor
import dev.ohs.fhir.model.r4.Count
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Distance
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Oid
import dev.ohs.fhir.model.r4.ParameterDefinition
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.SampledData
import dev.ohs.fhir.model.r4.Signature
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.TriggerDefinition
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.Uuid
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
    b.optionalElement("valueMeta", lazyDescriptor(LazyDescriptorId.MetaSerializer))
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
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        47 ->
          valueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        48 ->
          valueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        49 ->
          valueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        50 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        51 ->
          valueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        52 ->
          valueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        53 ->
          valueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        54 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        55 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        56 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        57 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        58 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        59 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        60 ->
          valueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        61 ->
          valueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        62 ->
          valueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        63 ->
          valueContributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContributorSerializer,
              null,
            )
        64 ->
          valueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        65 ->
          valueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        66 ->
          valueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        67 ->
          valueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        68 ->
          valueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        69 ->
          valueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        70 ->
          valueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        71 ->
          valueMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
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
          R4Boolean.of(valueBoolean, _valueBoolean),
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
          R4String.of(valueString, _valueString),
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
          valueMeta,
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
      is Extension.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 46, CodingSerializer, choice.value)
      }
      is Extension.Value.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          47,
          ContactPointSerializer,
          choice.value,
        )
      }
      is Extension.Value.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 48, CountSerializer, choice.value)
      }
      is Extension.Value.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 49, DistanceSerializer, choice.value)
      }
      is Extension.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 50, DurationSerializer, choice.value)
      }
      is Extension.Value.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          51,
          HumanNameSerializer,
          choice.value,
        )
      }
      is Extension.Value.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          52,
          IdentifierSerializer,
          choice.value,
        )
      }
      is Extension.Value.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 53, MoneySerializer, choice.value)
      }
      is Extension.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 54, PeriodSerializer, choice.value)
      }
      is Extension.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 55, QuantitySerializer, choice.value)
      }
      is Extension.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 56, RangeSerializer, choice.value)
      }
      is Extension.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 57, RatioSerializer, choice.value)
      }
      is Extension.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          58,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Extension.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          59,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Extension.Value.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          60,
          SignatureSerializer,
          choice.value,
        )
      }
      is Extension.Value.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 61, TimingSerializer, choice.value)
      }
      is Extension.Value.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          62,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is Extension.Value.Contributor -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          63,
          ContributorSerializer,
          choice.value,
        )
      }
      is Extension.Value.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          64,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is Extension.Value.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          65,
          ExpressionSerializer,
          choice.value,
        )
      }
      is Extension.Value.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          66,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is Extension.Value.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          67,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is Extension.Value.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          68,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is Extension.Value.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          69,
          UsageContextSerializer,
          choice.value,
        )
      }
      is Extension.Value.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 70, DosageSerializer, choice.value)
      }
      is Extension.Value.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 71, MetaSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}
