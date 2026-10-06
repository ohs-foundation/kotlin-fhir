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
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ExtensionSerializer : KSerializer<Extension> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Extension") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("valueBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_valueBase64Binary", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueCanonical", KotlinString.serializer().descriptor)
      optionalElement("_valueCanonical", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueCode", KotlinString.serializer().descriptor)
      optionalElement("_valueCode", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_valueDecimal", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueId", KotlinString.serializer().descriptor)
      optionalElement("_valueId", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueInstant", KotlinString.serializer().descriptor)
      optionalElement("_valueInstant", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_valueMarkdown", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueOid", KotlinString.serializer().descriptor)
      optionalElement("_valueOid", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valuePositiveInt", Int.serializer().descriptor)
      optionalElement("_valuePositiveInt", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueTime", LocalTimeSerializer.descriptor)
      optionalElement("_valueTime", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueUnsignedInt", Int.serializer().descriptor)
      optionalElement("_valueUnsignedInt", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueUri", KotlinString.serializer().descriptor)
      optionalElement("_valueUri", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueUrl", KotlinString.serializer().descriptor)
      optionalElement("_valueUrl", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueUuid", KotlinString.serializer().descriptor)
      optionalElement("_valueUuid", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueAddress", lazyDescriptor { AddressSerializer.descriptor })
      optionalElement("valueAge", lazyDescriptor { AgeSerializer.descriptor })
      optionalElement("valueAnnotation", lazyDescriptor { AnnotationSerializer.descriptor })
      optionalElement("valueAttachment", lazyDescriptor { AttachmentSerializer.descriptor })
      optionalElement(
        "valueCodeableConcept",
        lazyDescriptor { CodeableConceptSerializer.descriptor },
      )
      optionalElement(
        "valueCodeableReference",
        lazyDescriptor { CodeableReferenceSerializer.descriptor },
      )
      optionalElement("valueCoding", lazyDescriptor { CodingSerializer.descriptor })
      optionalElement("valueContactPoint", lazyDescriptor { ContactPointSerializer.descriptor })
      optionalElement("valueCount", lazyDescriptor { CountSerializer.descriptor })
      optionalElement("valueDistance", lazyDescriptor { DistanceSerializer.descriptor })
      optionalElement("valueDuration", lazyDescriptor { DurationSerializer.descriptor })
      optionalElement("valueHumanName", lazyDescriptor { HumanNameSerializer.descriptor })
      optionalElement("valueIdentifier", lazyDescriptor { IdentifierSerializer.descriptor })
      optionalElement("valueMoney", lazyDescriptor { MoneySerializer.descriptor })
      optionalElement("valuePeriod", lazyDescriptor { PeriodSerializer.descriptor })
      optionalElement("valueQuantity", lazyDescriptor { QuantitySerializer.descriptor })
      optionalElement("valueRange", lazyDescriptor { RangeSerializer.descriptor })
      optionalElement("valueRatio", lazyDescriptor { RatioSerializer.descriptor })
      optionalElement("valueRatioRange", lazyDescriptor { RatioRangeSerializer.descriptor })
      optionalElement("valueReference", lazyDescriptor { ReferenceSerializer.descriptor })
      optionalElement("valueSampledData", lazyDescriptor { SampledDataSerializer.descriptor })
      optionalElement("valueSignature", lazyDescriptor { SignatureSerializer.descriptor })
      optionalElement("valueTiming", lazyDescriptor { TimingSerializer.descriptor })
      optionalElement("valueContactDetail", lazyDescriptor { ContactDetailSerializer.descriptor })
      optionalElement("valueContributor", lazyDescriptor { ContributorSerializer.descriptor })
      optionalElement(
        "valueDataRequirement",
        lazyDescriptor { DataRequirementSerializer.descriptor },
      )
      optionalElement("valueExpression", lazyDescriptor { ExpressionSerializer.descriptor })
      optionalElement(
        "valueParameterDefinition",
        lazyDescriptor { ParameterDefinitionSerializer.descriptor },
      )
      optionalElement(
        "valueRelatedArtifact",
        lazyDescriptor { RelatedArtifactSerializer.descriptor },
      )
      optionalElement(
        "valueTriggerDefinition",
        lazyDescriptor { TriggerDefinitionSerializer.descriptor },
      )
      optionalElement("valueUsageContext", lazyDescriptor { UsageContextSerializer.descriptor })
      optionalElement("valueDosage", lazyDescriptor { DosageSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Extension>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Extension =
    decoder.decodeStructure(descriptor) {
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
          2 -> url = decodeStringElement(descriptor, i)
          3 -> valueBase64Binary = decodeStringElement(descriptor, i)
          4 ->
            _valueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> valueBoolean = decodeBooleanElement(descriptor, i)
          6 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> valueCanonical = decodeStringElement(descriptor, i)
          8 ->
            _valueCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> valueCode = decodeStringElement(descriptor, i)
          10 ->
            _valueCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> valueDate = decodeStringElement(descriptor, i)
          12 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> valueDateTime = decodeStringElement(descriptor, i)
          14 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          16 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> valueId = decodeStringElement(descriptor, i)
          18 -> _valueId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 -> valueInstant = decodeStringElement(descriptor, i)
          20 ->
            _valueInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          21 -> valueInteger = decodeIntElement(descriptor, i)
          22 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          23 -> valueMarkdown = decodeStringElement(descriptor, i)
          24 ->
            _valueMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          25 -> valueOid = decodeStringElement(descriptor, i)
          26 ->
            _valueOid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          27 -> valuePositiveInt = decodeIntElement(descriptor, i)
          28 ->
            _valuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          29 -> valueString = decodeStringElement(descriptor, i)
          30 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          31 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          32 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          33 -> valueUnsignedInt = decodeIntElement(descriptor, i)
          34 ->
            _valueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          35 -> valueUri = decodeStringElement(descriptor, i)
          36 ->
            _valueUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          37 -> valueUrl = decodeStringElement(descriptor, i)
          38 ->
            _valueUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          39 -> valueUuid = decodeStringElement(descriptor, i)
          40 ->
            _valueUuid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          41 ->
            valueAddress = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          42 -> valueAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          43 ->
            valueAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          44 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          45 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          46 ->
            valueCodeableReference =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          47 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          48 ->
            valueContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          49 -> valueCount = decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          50 ->
            valueDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          51 ->
            valueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          52 ->
            valueHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          53 ->
            valueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          54 -> valueMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          55 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          56 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          57 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          58 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          59 ->
            valueRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          60 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          61 ->
            valueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          62 ->
            valueSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          63 ->
            valueTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          64 ->
            valueContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          65 ->
            valueContributor =
              decodeNullableSerializableElement(descriptor, i, ContributorSerializer, null)
          66 ->
            valueDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          67 ->
            valueExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          68 ->
            valueParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          69 ->
            valueRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          70 ->
            valueTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          71 ->
            valueUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          72 ->
            valueDosage = decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Extension: " + i)
        }
      }
      Extension(
        id = id,
        extension = extension ?: listOf(),
        url = url ?: throw SerializationException("Missing required property 'url' on Extension"),
        `value` =
          Extension.Value.from(
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
            R4bBoolean.of(valueBoolean, _valueBoolean),
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringElement(descriptor, 2, value.url)
      when (val choice = value.`value`) {
        null -> {}
        is Extension.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is Extension.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is Extension.Value.Canonical -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Extension.Value.Code -> {
          encodeStringIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is Extension.Value.Date -> {
          encodeStringIfNotNull(descriptor, 11, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is Extension.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
        is Extension.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 15, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is Extension.Value.Id -> {
          encodeStringIfNotNull(descriptor, 17, choice.value.value)
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is Extension.Value.Instant -> {
          encodeStringIfNotNull(descriptor, 19, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 20, choice.value)
        }
        is Extension.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 21, choice.value.value)
          encodeElementIfNotNull(descriptor, 22, choice.value)
        }
        is Extension.Value.Markdown -> {
          encodeStringIfNotNull(descriptor, 23, choice.value.value)
          encodeElementIfNotNull(descriptor, 24, choice.value)
        }
        is Extension.Value.Oid -> {
          encodeStringIfNotNull(descriptor, 25, choice.value.value)
          encodeElementIfNotNull(descriptor, 26, choice.value)
        }
        is Extension.Value.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 27, choice.value.value)
          encodeElementIfNotNull(descriptor, 28, choice.value)
        }
        is Extension.Value.String -> {
          encodeStringIfNotNull(descriptor, 29, choice.value.value)
          encodeElementIfNotNull(descriptor, 30, choice.value)
        }
        is Extension.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 31, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 32, choice.value)
        }
        is Extension.Value.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 33, choice.value.value)
          encodeElementIfNotNull(descriptor, 34, choice.value)
        }
        is Extension.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 35, choice.value.value)
          encodeElementIfNotNull(descriptor, 36, choice.value)
        }
        is Extension.Value.Url -> {
          encodeStringIfNotNull(descriptor, 37, choice.value.value)
          encodeElementIfNotNull(descriptor, 38, choice.value)
        }
        is Extension.Value.Uuid -> {
          encodeStringIfNotNull(descriptor, 39, choice.value.value)
          encodeElementIfNotNull(descriptor, 40, choice.value)
        }
        is Extension.Value.Address -> {
          encodeSerializableElement(descriptor, 41, AddressSerializer, choice.value)
        }
        is Extension.Value.Age -> {
          encodeSerializableElement(descriptor, 42, AgeSerializer, choice.value)
        }
        is Extension.Value.Annotation -> {
          encodeSerializableElement(descriptor, 43, AnnotationSerializer, choice.value)
        }
        is Extension.Value.Attachment -> {
          encodeSerializableElement(descriptor, 44, AttachmentSerializer, choice.value)
        }
        is Extension.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 45, CodeableConceptSerializer, choice.value)
        }
        is Extension.Value.CodeableReference -> {
          encodeSerializableElement(descriptor, 46, CodeableReferenceSerializer, choice.value)
        }
        is Extension.Value.Coding -> {
          encodeSerializableElement(descriptor, 47, CodingSerializer, choice.value)
        }
        is Extension.Value.ContactPoint -> {
          encodeSerializableElement(descriptor, 48, ContactPointSerializer, choice.value)
        }
        is Extension.Value.Count -> {
          encodeSerializableElement(descriptor, 49, CountSerializer, choice.value)
        }
        is Extension.Value.Distance -> {
          encodeSerializableElement(descriptor, 50, DistanceSerializer, choice.value)
        }
        is Extension.Value.Duration -> {
          encodeSerializableElement(descriptor, 51, DurationSerializer, choice.value)
        }
        is Extension.Value.HumanName -> {
          encodeSerializableElement(descriptor, 52, HumanNameSerializer, choice.value)
        }
        is Extension.Value.Identifier -> {
          encodeSerializableElement(descriptor, 53, IdentifierSerializer, choice.value)
        }
        is Extension.Value.Money -> {
          encodeSerializableElement(descriptor, 54, MoneySerializer, choice.value)
        }
        is Extension.Value.Period -> {
          encodeSerializableElement(descriptor, 55, PeriodSerializer, choice.value)
        }
        is Extension.Value.Quantity -> {
          encodeSerializableElement(descriptor, 56, QuantitySerializer, choice.value)
        }
        is Extension.Value.Range -> {
          encodeSerializableElement(descriptor, 57, RangeSerializer, choice.value)
        }
        is Extension.Value.Ratio -> {
          encodeSerializableElement(descriptor, 58, RatioSerializer, choice.value)
        }
        is Extension.Value.RatioRange -> {
          encodeSerializableElement(descriptor, 59, RatioRangeSerializer, choice.value)
        }
        is Extension.Value.Reference -> {
          encodeSerializableElement(descriptor, 60, ReferenceSerializer, choice.value)
        }
        is Extension.Value.SampledData -> {
          encodeSerializableElement(descriptor, 61, SampledDataSerializer, choice.value)
        }
        is Extension.Value.Signature -> {
          encodeSerializableElement(descriptor, 62, SignatureSerializer, choice.value)
        }
        is Extension.Value.Timing -> {
          encodeSerializableElement(descriptor, 63, TimingSerializer, choice.value)
        }
        is Extension.Value.ContactDetail -> {
          encodeSerializableElement(descriptor, 64, ContactDetailSerializer, choice.value)
        }
        is Extension.Value.Contributor -> {
          encodeSerializableElement(descriptor, 65, ContributorSerializer, choice.value)
        }
        is Extension.Value.DataRequirement -> {
          encodeSerializableElement(descriptor, 66, DataRequirementSerializer, choice.value)
        }
        is Extension.Value.Expression -> {
          encodeSerializableElement(descriptor, 67, ExpressionSerializer, choice.value)
        }
        is Extension.Value.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 68, ParameterDefinitionSerializer, choice.value)
        }
        is Extension.Value.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 69, RelatedArtifactSerializer, choice.value)
        }
        is Extension.Value.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 70, TriggerDefinitionSerializer, choice.value)
        }
        is Extension.Value.UsageContext -> {
          encodeSerializableElement(descriptor, 71, UsageContextSerializer, choice.value)
        }
        is Extension.Value.Dosage -> {
          encodeSerializableElement(descriptor, 72, DosageSerializer, choice.value)
        }
      }
    }
  }
}
