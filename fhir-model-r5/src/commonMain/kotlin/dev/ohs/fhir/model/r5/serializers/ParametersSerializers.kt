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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("valueBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_valueBase64Binary", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueCanonical", KotlinString.serializer().descriptor)
      optionalElement("_valueCanonical", ElementSerializer.descriptor)
      optionalElement("valueCode", KotlinString.serializer().descriptor)
      optionalElement("_valueCode", ElementSerializer.descriptor)
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", ElementSerializer.descriptor)
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", ElementSerializer.descriptor)
      optionalElement("valueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_valueDecimal", ElementSerializer.descriptor)
      optionalElement("valueId", KotlinString.serializer().descriptor)
      optionalElement("_valueId", ElementSerializer.descriptor)
      optionalElement("valueInstant", KotlinString.serializer().descriptor)
      optionalElement("_valueInstant", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueInteger64", KotlinString.serializer().descriptor)
      optionalElement("_valueInteger64", ElementSerializer.descriptor)
      optionalElement("valueMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_valueMarkdown", ElementSerializer.descriptor)
      optionalElement("valueOid", KotlinString.serializer().descriptor)
      optionalElement("_valueOid", ElementSerializer.descriptor)
      optionalElement("valuePositiveInt", Int.serializer().descriptor)
      optionalElement("_valuePositiveInt", ElementSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueTime", LocalTimeSerializer.descriptor)
      optionalElement("_valueTime", ElementSerializer.descriptor)
      optionalElement("valueUnsignedInt", Int.serializer().descriptor)
      optionalElement("_valueUnsignedInt", ElementSerializer.descriptor)
      optionalElement("valueUri", KotlinString.serializer().descriptor)
      optionalElement("_valueUri", ElementSerializer.descriptor)
      optionalElement("valueUrl", KotlinString.serializer().descriptor)
      optionalElement("_valueUrl", ElementSerializer.descriptor)
      optionalElement("valueUuid", KotlinString.serializer().descriptor)
      optionalElement("_valueUuid", ElementSerializer.descriptor)
      optionalElement("valueAddress", AddressSerializer.descriptor)
      optionalElement("valueAge", AgeSerializer.descriptor)
      optionalElement("valueAnnotation", AnnotationSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableReference", CodeableReferenceSerializer.descriptor)
      optionalElement("valueCoding", CodingSerializer.descriptor)
      optionalElement("valueContactPoint", ContactPointSerializer.descriptor)
      optionalElement("valueCount", CountSerializer.descriptor)
      optionalElement("valueDistance", DistanceSerializer.descriptor)
      optionalElement("valueDuration", DurationSerializer.descriptor)
      optionalElement("valueHumanName", HumanNameSerializer.descriptor)
      optionalElement("valueIdentifier", IdentifierSerializer.descriptor)
      optionalElement("valueMoney", MoneySerializer.descriptor)
      optionalElement("valuePeriod", PeriodSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueRatio", RatioSerializer.descriptor)
      optionalElement("valueRatioRange", RatioRangeSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
      optionalElement("valueSampledData", SampledDataSerializer.descriptor)
      optionalElement("valueSignature", SignatureSerializer.descriptor)
      optionalElement("valueTiming", TimingSerializer.descriptor)
      optionalElement("valueContactDetail", ContactDetailSerializer.descriptor)
      optionalElement("valueDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("valueExpression", ExpressionSerializer.descriptor)
      optionalElement("valueParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("valueRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("valueTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("valueUsageContext", UsageContextSerializer.descriptor)
      optionalElement("valueAvailability", AvailabilitySerializer.descriptor)
      optionalElement("valueExtendedContactDetail", ExtendedContactDetailSerializer.descriptor)
      optionalElement("valueDosage", DosageSerializer.descriptor)
      optionalElement("valueMeta", MetaSerializer.descriptor)
      optionalElement("resource", lazyDescriptor { ResourcePolymorphicSerializer.descriptor })
      optionalElement(
        "part",
        listSerialDescriptor(lazyDescriptor { ParametersParameterSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Parameters.Parameter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Parameters.Parameter =
    decoder.decodeStructure(descriptor) {
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
      var resource: Resource? = null
      var part: List<Parameters.Parameter>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> valueBase64Binary = decodeStringElement(descriptor, i)
          6 ->
            _valueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> valueBoolean = decodeBooleanElement(descriptor, i)
          8 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> valueCanonical = decodeStringElement(descriptor, i)
          10 ->
            _valueCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> valueCode = decodeStringElement(descriptor, i)
          12 ->
            _valueCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> valueDate = decodeStringElement(descriptor, i)
          14 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> valueDateTime = decodeStringElement(descriptor, i)
          16 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          18 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 -> valueId = decodeStringElement(descriptor, i)
          20 -> _valueId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          21 -> valueInstant = decodeStringElement(descriptor, i)
          22 ->
            _valueInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          23 -> valueInteger = decodeIntElement(descriptor, i)
          24 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          25 -> valueInteger64 = decodeStringElement(descriptor, i)
          26 ->
            _valueInteger64 =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          27 -> valueMarkdown = decodeStringElement(descriptor, i)
          28 ->
            _valueMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          29 -> valueOid = decodeStringElement(descriptor, i)
          30 ->
            _valueOid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          31 -> valuePositiveInt = decodeIntElement(descriptor, i)
          32 ->
            _valuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          33 -> valueString = decodeStringElement(descriptor, i)
          34 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          35 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          36 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          37 -> valueUnsignedInt = decodeIntElement(descriptor, i)
          38 ->
            _valueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          39 -> valueUri = decodeStringElement(descriptor, i)
          40 ->
            _valueUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          41 -> valueUrl = decodeStringElement(descriptor, i)
          42 ->
            _valueUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          43 -> valueUuid = decodeStringElement(descriptor, i)
          44 ->
            _valueUuid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          45 ->
            valueAddress = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          46 -> valueAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          47 ->
            valueAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          48 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          49 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          50 ->
            valueCodeableReference =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          51 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          52 ->
            valueContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          53 -> valueCount = decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          54 ->
            valueDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          55 ->
            valueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          56 ->
            valueHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          57 ->
            valueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          58 -> valueMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          59 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          60 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          61 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          62 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          63 ->
            valueRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          64 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          65 ->
            valueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          66 ->
            valueSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          67 ->
            valueTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          68 ->
            valueContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          69 ->
            valueDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          70 ->
            valueExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          71 ->
            valueParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          72 ->
            valueRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          73 ->
            valueTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          74 ->
            valueUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          75 ->
            valueAvailability =
              decodeNullableSerializableElement(descriptor, i, AvailabilitySerializer, null)
          76 ->
            valueExtendedContactDetail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtendedContactDetailSerializer,
                null,
              )
          77 ->
            valueDosage = decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          78 -> valueMeta = decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
          79 ->
            resource =
              decodeNullableSerializableElement(descriptor, i, ResourcePolymorphicSerializer, null)
          80 ->
            part =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ParametersParameterSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      Parameters.Parameter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R5String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on Parameters.Parameter"
            ),
        `value` =
          Parameters.Parameter.Value.from(
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Canonical.of(valueCanonical, _valueCanonical),
            Code.of(valueCode, _valueCode),
            Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
            DateTime.of(
              if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
              _valueDateTime,
            ),
            Decimal.of(valueDecimal, _valueDecimal),
            Id.of(valueId, _valueId),
            Instant.of(
              if (valueInstant != null) FhirDateTime.fromString(valueInstant) else null,
              _valueInstant,
            ),
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
          ),
        resource = resource,
        part = part ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Parameters.Parameter) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      when (val choice = value.`value`) {
        null -> {}
        is Parameters.Parameter.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is Parameters.Parameter.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Parameters.Parameter.Value.Canonical -> {
          encodeStringIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is Parameters.Parameter.Value.Code -> {
          encodeStringIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is Parameters.Parameter.Value.Date -> {
          encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
        is Parameters.Parameter.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 15, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is Parameters.Parameter.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 17, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is Parameters.Parameter.Value.Id -> {
          encodeStringIfNotNull(descriptor, 19, choice.value.value)
          encodeElementIfNotNull(descriptor, 20, choice.value)
        }
        is Parameters.Parameter.Value.Instant -> {
          encodeStringIfNotNull(descriptor, 21, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 22, choice.value)
        }
        is Parameters.Parameter.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 23, choice.value.value)
          encodeElementIfNotNull(descriptor, 24, choice.value)
        }
        is Parameters.Parameter.Value.Integer64 -> {
          encodeStringIfNotNull(descriptor, 25, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 26, choice.value)
        }
        is Parameters.Parameter.Value.Markdown -> {
          encodeStringIfNotNull(descriptor, 27, choice.value.value)
          encodeElementIfNotNull(descriptor, 28, choice.value)
        }
        is Parameters.Parameter.Value.Oid -> {
          encodeStringIfNotNull(descriptor, 29, choice.value.value)
          encodeElementIfNotNull(descriptor, 30, choice.value)
        }
        is Parameters.Parameter.Value.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 31, choice.value.value)
          encodeElementIfNotNull(descriptor, 32, choice.value)
        }
        is Parameters.Parameter.Value.String -> {
          encodeStringIfNotNull(descriptor, 33, choice.value.value)
          encodeElementIfNotNull(descriptor, 34, choice.value)
        }
        is Parameters.Parameter.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 35, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 36, choice.value)
        }
        is Parameters.Parameter.Value.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 37, choice.value.value)
          encodeElementIfNotNull(descriptor, 38, choice.value)
        }
        is Parameters.Parameter.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 39, choice.value.value)
          encodeElementIfNotNull(descriptor, 40, choice.value)
        }
        is Parameters.Parameter.Value.Url -> {
          encodeStringIfNotNull(descriptor, 41, choice.value.value)
          encodeElementIfNotNull(descriptor, 42, choice.value)
        }
        is Parameters.Parameter.Value.Uuid -> {
          encodeStringIfNotNull(descriptor, 43, choice.value.value)
          encodeElementIfNotNull(descriptor, 44, choice.value)
        }
        is Parameters.Parameter.Value.Address -> {
          encodeSerializableElement(descriptor, 45, AddressSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Age -> {
          encodeSerializableElement(descriptor, 46, AgeSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Annotation -> {
          encodeSerializableElement(descriptor, 47, AnnotationSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Attachment -> {
          encodeSerializableElement(descriptor, 48, AttachmentSerializer, choice.value)
        }
        is Parameters.Parameter.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 49, CodeableConceptSerializer, choice.value)
        }
        is Parameters.Parameter.Value.CodeableReference -> {
          encodeSerializableElement(descriptor, 50, CodeableReferenceSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Coding -> {
          encodeSerializableElement(descriptor, 51, CodingSerializer, choice.value)
        }
        is Parameters.Parameter.Value.ContactPoint -> {
          encodeSerializableElement(descriptor, 52, ContactPointSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Count -> {
          encodeSerializableElement(descriptor, 53, CountSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Distance -> {
          encodeSerializableElement(descriptor, 54, DistanceSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Duration -> {
          encodeSerializableElement(descriptor, 55, DurationSerializer, choice.value)
        }
        is Parameters.Parameter.Value.HumanName -> {
          encodeSerializableElement(descriptor, 56, HumanNameSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Identifier -> {
          encodeSerializableElement(descriptor, 57, IdentifierSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Money -> {
          encodeSerializableElement(descriptor, 58, MoneySerializer, choice.value)
        }
        is Parameters.Parameter.Value.Period -> {
          encodeSerializableElement(descriptor, 59, PeriodSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Quantity -> {
          encodeSerializableElement(descriptor, 60, QuantitySerializer, choice.value)
        }
        is Parameters.Parameter.Value.Range -> {
          encodeSerializableElement(descriptor, 61, RangeSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Ratio -> {
          encodeSerializableElement(descriptor, 62, RatioSerializer, choice.value)
        }
        is Parameters.Parameter.Value.RatioRange -> {
          encodeSerializableElement(descriptor, 63, RatioRangeSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Reference -> {
          encodeSerializableElement(descriptor, 64, ReferenceSerializer, choice.value)
        }
        is Parameters.Parameter.Value.SampledData -> {
          encodeSerializableElement(descriptor, 65, SampledDataSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Signature -> {
          encodeSerializableElement(descriptor, 66, SignatureSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Timing -> {
          encodeSerializableElement(descriptor, 67, TimingSerializer, choice.value)
        }
        is Parameters.Parameter.Value.ContactDetail -> {
          encodeSerializableElement(descriptor, 68, ContactDetailSerializer, choice.value)
        }
        is Parameters.Parameter.Value.DataRequirement -> {
          encodeSerializableElement(descriptor, 69, DataRequirementSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Expression -> {
          encodeSerializableElement(descriptor, 70, ExpressionSerializer, choice.value)
        }
        is Parameters.Parameter.Value.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 71, ParameterDefinitionSerializer, choice.value)
        }
        is Parameters.Parameter.Value.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 72, RelatedArtifactSerializer, choice.value)
        }
        is Parameters.Parameter.Value.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 73, TriggerDefinitionSerializer, choice.value)
        }
        is Parameters.Parameter.Value.UsageContext -> {
          encodeSerializableElement(descriptor, 74, UsageContextSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Availability -> {
          encodeSerializableElement(descriptor, 75, AvailabilitySerializer, choice.value)
        }
        is Parameters.Parameter.Value.ExtendedContactDetail -> {
          encodeSerializableElement(descriptor, 76, ExtendedContactDetailSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Dosage -> {
          encodeSerializableElement(descriptor, 77, DosageSerializer, choice.value)
        }
        is Parameters.Parameter.Value.Meta -> {
          encodeSerializableElement(descriptor, 78, MetaSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 79, ResourcePolymorphicSerializer, value.resource)
      if (value.part.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          80,
          ParametersParameterSerializer.listSerializer,
          value.part,
        )
    }
  }
}

internal object ParametersSerializer : FhirResourceSerializer<Parameters> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Parameters")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("parameter", ParametersParameterSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Parameters,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6 + descriptorOffset,
        ParametersParameterSerializer.listSerializer,
        value.parameter,
      )
  }
}
