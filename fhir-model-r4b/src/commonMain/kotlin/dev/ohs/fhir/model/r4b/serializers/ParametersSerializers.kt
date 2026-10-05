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
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Oid
import dev.ohs.fhir.model.r4b.ParameterDefinition
import dev.ohs.fhir.model.r4b.Parameters
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
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

internal object ParametersParameterSerializer : KSerializer<Parameters.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
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
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("valueSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("valueSignature", Signature.serializer().descriptor, isOptional = true)
      element("valueTiming", Timing.serializer().descriptor, isOptional = true)
      element("valueContactDetail", ContactDetail.serializer().descriptor, isOptional = true)
      element("valueContributor", Contributor.serializer().descriptor, isOptional = true)
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
      element("valueDosage", Dosage.serializer().descriptor, isOptional = true)
      element("valueMeta", Meta.serializer().descriptor, isOptional = true)
      element("resource", lazyDescriptor { Resource.serializer().descriptor }, isOptional = true)
      element(
        "part",
        listSerialDescriptor(lazyDescriptor { Parameters.Parameter.serializer().descriptor }),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Parameters.Parameter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Parameters.Parameter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Parameters.Parameter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Parameters.Parameter {
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
    var resource: Resource? = null
    var part: List<Parameters.Parameter>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 -> valueCanonical = decoder.decodeStringElement(descriptor, i)
        10 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 -> valueCode = decoder.decodeStringElement(descriptor, i)
        12 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> valueDate = decoder.decodeStringElement(descriptor, i)
        14 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        16 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        18 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> valueId = decoder.decodeStringElement(descriptor, i)
        20 ->
          _valueId =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> valueInstant = decoder.decodeStringElement(descriptor, i)
        22 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        24 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> valueMarkdown = decoder.decodeStringElement(descriptor, i)
        26 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> valueOid = decoder.decodeStringElement(descriptor, i)
        28 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> valuePositiveInt = decoder.decodeIntElement(descriptor, i)
        30 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 -> valueString = decoder.decodeStringElement(descriptor, i)
        32 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        34 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> valueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        36 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> valueUri = decoder.decodeStringElement(descriptor, i)
        38 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> valueUrl = decoder.decodeStringElement(descriptor, i)
        40 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 -> valueUuid = decoder.decodeStringElement(descriptor, i)
        42 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        44 ->
          valueAge = decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        45 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
        46 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        47 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        48 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        49 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
        50 ->
          valueCount =
            decoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        51 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
        52 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        53 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
        54 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        55 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        56 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        57 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        58 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        59 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        60 ->
          valueReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        61 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
        62 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
        63 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        64 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
        65 ->
          valueContributor =
            decoder.decodeNullableSerializableElement(descriptor, i, ContributorSerializer, null)
        66 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        67 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
        68 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        69 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        70 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        71 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
        72 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
        73 ->
          valueMeta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        74 ->
          resource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer,
              null,
            )
        75 ->
          part =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParametersParameterSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    return Parameters.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on Parameters.Parameter"
          ),
      `value` =
        Parameters.Parameter.Value.from(
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          Canonical.of(valueCanonical, _valueCanonical),
          Code.of(valueCode, _valueCode),
          Date.of(valueDate?.let { FhirDate.fromString(it) }, _valueDate),
          DateTime.of(valueDateTime?.let { FhirDateTime.fromString(it) }, _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(valueInstant?.let { FhirDateTime.fromString(it) }, _valueInstant),
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
      resource = resource,
      part = part ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Parameters.Parameter) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    when (val choice = value.`value`) {
      null -> {}
      is Parameters.Parameter.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 15, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 17, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 19, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 20, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 21, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 22, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 23, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 24, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 25, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 26, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Oid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 27, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 28, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 29, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 30, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 31, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 32, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 33, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 34, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 35, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 36, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 37, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 38, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 39, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 40, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Uuid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 41, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 42, ElementSerializer, it)
        }
      }
      is Parameters.Parameter.Value.Address -> {
        encoder.encodeSerializableElement(descriptor, 43, AddressSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Age -> {
        encoder.encodeSerializableElement(descriptor, 44, AgeSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Annotation -> {
        encoder.encodeSerializableElement(descriptor, 45, AnnotationSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 46, AttachmentSerializer, choice.value)
      }
      is Parameters.Parameter.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 47, CodeableConceptSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 48, CodingSerializer, choice.value)
      }
      is Parameters.Parameter.Value.ContactPoint -> {
        encoder.encodeSerializableElement(descriptor, 49, ContactPointSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Count -> {
        encoder.encodeSerializableElement(descriptor, 50, CountSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Distance -> {
        encoder.encodeSerializableElement(descriptor, 51, DistanceSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 52, DurationSerializer, choice.value)
      }
      is Parameters.Parameter.Value.HumanName -> {
        encoder.encodeSerializableElement(descriptor, 53, HumanNameSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 54, IdentifierSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Money -> {
        encoder.encodeSerializableElement(descriptor, 55, MoneySerializer, choice.value)
      }
      is Parameters.Parameter.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 56, PeriodSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 57, QuantitySerializer, choice.value)
      }
      is Parameters.Parameter.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 58, RangeSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 59, RatioSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 60, ReferenceSerializer, choice.value)
      }
      is Parameters.Parameter.Value.SampledData -> {
        encoder.encodeSerializableElement(descriptor, 61, SampledDataSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Signature -> {
        encoder.encodeSerializableElement(descriptor, 62, SignatureSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Timing -> {
        encoder.encodeSerializableElement(descriptor, 63, TimingSerializer, choice.value)
      }
      is Parameters.Parameter.Value.ContactDetail -> {
        encoder.encodeSerializableElement(descriptor, 64, ContactDetailSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Contributor -> {
        encoder.encodeSerializableElement(descriptor, 65, ContributorSerializer, choice.value)
      }
      is Parameters.Parameter.Value.DataRequirement -> {
        encoder.encodeSerializableElement(descriptor, 66, DataRequirementSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Expression -> {
        encoder.encodeSerializableElement(descriptor, 67, ExpressionSerializer, choice.value)
      }
      is Parameters.Parameter.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          68,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(descriptor, 69, RelatedArtifactSerializer, choice.value)
      }
      is Parameters.Parameter.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(descriptor, 70, TriggerDefinitionSerializer, choice.value)
      }
      is Parameters.Parameter.Value.UsageContext -> {
        encoder.encodeSerializableElement(descriptor, 71, UsageContextSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Dosage -> {
        encoder.encodeSerializableElement(descriptor, 72, DosageSerializer, choice.value)
      }
      is Parameters.Parameter.Value.Meta -> {
        encoder.encodeSerializableElement(descriptor, 73, MetaSerializer, choice.value)
      }
    }
    (value.resource)?.let {
      encoder.encodeSerializableElement(descriptor, 74, ResourcePolymorphicSerializer, it)
    }
    if (value.part.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        75,
        ParametersParameterSerializer.listSerializer,
        value.part,
      )
  }
}

internal object ParametersSerializer : KSerializer<Parameters> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameters") {
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
    b.element(
      "parameter",
      listSerialDescriptor(lazyDescriptor { Parameters.Parameter.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Parameters =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Parameters) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Parameters")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          parameter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParametersParameterSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Parameters: " + i)
      }
    }
    return Parameters(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      parameter = parameter ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Parameters,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6 + descriptorOffset,
        ParametersParameterSerializer.listSerializer,
        value.parameter,
      )
  }
}

internal object ParametersPolymorphicSerializer : KSerializer<Parameters> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameters") { ParametersSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Parameters) {
    encoder.encodeStructure(descriptor) {
      ParametersSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Parameters =
    decoder.decodeStructure(descriptor) {
      ParametersSerializer.deserializeInternal(this, descriptor, 0)
    }
}
