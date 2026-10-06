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
      optionalElement("valueAddress", lazyDescriptor { AddressSerializer.descriptor })
      optionalElement("valueAge", lazyDescriptor { AgeSerializer.descriptor })
      optionalElement("valueAnnotation", lazyDescriptor { AnnotationSerializer.descriptor })
      optionalElement("valueAttachment", lazyDescriptor { AttachmentSerializer.descriptor })
      optionalElement(
        "valueCodeableConcept",
        lazyDescriptor { CodeableConceptSerializer.descriptor },
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
      optionalElement("valueMeta", lazyDescriptor { MetaSerializer.descriptor })
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
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          47 ->
            valueContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          48 -> valueCount = decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          49 ->
            valueDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          50 ->
            valueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          51 ->
            valueHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          52 ->
            valueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          53 -> valueMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          54 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          55 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          56 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          57 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          58 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          59 ->
            valueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          60 ->
            valueSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          61 ->
            valueTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          62 ->
            valueContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          63 ->
            valueContributor =
              decodeNullableSerializableElement(descriptor, i, ContributorSerializer, null)
          64 ->
            valueDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          65 ->
            valueExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          66 ->
            valueParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          67 ->
            valueRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          68 ->
            valueTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          69 ->
            valueUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          70 ->
            valueDosage = decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          71 -> valueMeta = decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
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
            R4Boolean.of(valueBoolean, _valueBoolean),
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
        is Extension.Value.Coding -> {
          encodeSerializableElement(descriptor, 46, CodingSerializer, choice.value)
        }
        is Extension.Value.ContactPoint -> {
          encodeSerializableElement(descriptor, 47, ContactPointSerializer, choice.value)
        }
        is Extension.Value.Count -> {
          encodeSerializableElement(descriptor, 48, CountSerializer, choice.value)
        }
        is Extension.Value.Distance -> {
          encodeSerializableElement(descriptor, 49, DistanceSerializer, choice.value)
        }
        is Extension.Value.Duration -> {
          encodeSerializableElement(descriptor, 50, DurationSerializer, choice.value)
        }
        is Extension.Value.HumanName -> {
          encodeSerializableElement(descriptor, 51, HumanNameSerializer, choice.value)
        }
        is Extension.Value.Identifier -> {
          encodeSerializableElement(descriptor, 52, IdentifierSerializer, choice.value)
        }
        is Extension.Value.Money -> {
          encodeSerializableElement(descriptor, 53, MoneySerializer, choice.value)
        }
        is Extension.Value.Period -> {
          encodeSerializableElement(descriptor, 54, PeriodSerializer, choice.value)
        }
        is Extension.Value.Quantity -> {
          encodeSerializableElement(descriptor, 55, QuantitySerializer, choice.value)
        }
        is Extension.Value.Range -> {
          encodeSerializableElement(descriptor, 56, RangeSerializer, choice.value)
        }
        is Extension.Value.Ratio -> {
          encodeSerializableElement(descriptor, 57, RatioSerializer, choice.value)
        }
        is Extension.Value.Reference -> {
          encodeSerializableElement(descriptor, 58, ReferenceSerializer, choice.value)
        }
        is Extension.Value.SampledData -> {
          encodeSerializableElement(descriptor, 59, SampledDataSerializer, choice.value)
        }
        is Extension.Value.Signature -> {
          encodeSerializableElement(descriptor, 60, SignatureSerializer, choice.value)
        }
        is Extension.Value.Timing -> {
          encodeSerializableElement(descriptor, 61, TimingSerializer, choice.value)
        }
        is Extension.Value.ContactDetail -> {
          encodeSerializableElement(descriptor, 62, ContactDetailSerializer, choice.value)
        }
        is Extension.Value.Contributor -> {
          encodeSerializableElement(descriptor, 63, ContributorSerializer, choice.value)
        }
        is Extension.Value.DataRequirement -> {
          encodeSerializableElement(descriptor, 64, DataRequirementSerializer, choice.value)
        }
        is Extension.Value.Expression -> {
          encodeSerializableElement(descriptor, 65, ExpressionSerializer, choice.value)
        }
        is Extension.Value.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 66, ParameterDefinitionSerializer, choice.value)
        }
        is Extension.Value.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 67, RelatedArtifactSerializer, choice.value)
        }
        is Extension.Value.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 68, TriggerDefinitionSerializer, choice.value)
        }
        is Extension.Value.UsageContext -> {
          encodeSerializableElement(descriptor, 69, UsageContextSerializer, choice.value)
        }
        is Extension.Value.Dosage -> {
          encodeSerializableElement(descriptor, 70, DosageSerializer, choice.value)
        }
        is Extension.Value.Meta -> {
          encodeSerializableElement(descriptor, 71, MetaSerializer, choice.value)
        }
      }
    }
  }
}
