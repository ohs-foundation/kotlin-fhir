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

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ExtensionSerializer : KSerializer<Extension> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Extension") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("valueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueBase64Binary",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element(
        "_valueBoolean",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueCanonical",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueDateTime",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element(
        "_valueDecimal",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueId", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueInstant",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element(
        "_valueInteger",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueMarkdown",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueOid", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueOid", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element(
        "_valuePositiveInt",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element(
        "_valueUnsignedInt",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUri", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUrl", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueUuid", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUuid", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueAddress", lazyDescriptor { Address.serializer().descriptor }, isOptional = true)
      element("valueAge", lazyDescriptor { Age.serializer().descriptor }, isOptional = true)
      element(
        "valueAnnotation",
        lazyDescriptor { Annotation.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueAttachment",
        lazyDescriptor { Attachment.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueCodeableConcept",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueCodeableReference",
        lazyDescriptor { CodeableReference.serializer().descriptor },
        isOptional = true,
      )
      element("valueCoding", lazyDescriptor { Coding.serializer().descriptor }, isOptional = true)
      element(
        "valueContactPoint",
        lazyDescriptor { ContactPoint.serializer().descriptor },
        isOptional = true,
      )
      element("valueCount", lazyDescriptor { Count.serializer().descriptor }, isOptional = true)
      element(
        "valueDistance",
        lazyDescriptor { Distance.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueDuration",
        lazyDescriptor { Duration.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueHumanName",
        lazyDescriptor { HumanName.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueIdentifier",
        lazyDescriptor { Identifier.serializer().descriptor },
        isOptional = true,
      )
      element("valueMoney", lazyDescriptor { Money.serializer().descriptor }, isOptional = true)
      element("valuePeriod", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
      element(
        "valueQuantity",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
      element("valueRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element("valueRatio", lazyDescriptor { Ratio.serializer().descriptor }, isOptional = true)
      element(
        "valueRatioRange",
        lazyDescriptor { RatioRange.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueSampledData",
        lazyDescriptor { SampledData.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueSignature",
        lazyDescriptor { Signature.serializer().descriptor },
        isOptional = true,
      )
      element("valueTiming", lazyDescriptor { Timing.serializer().descriptor }, isOptional = true)
      element(
        "valueContactDetail",
        lazyDescriptor { ContactDetail.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueContributor",
        lazyDescriptor { Contributor.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueDataRequirement",
        lazyDescriptor { DataRequirement.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueExpression",
        lazyDescriptor { Expression.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueParameterDefinition",
        lazyDescriptor { ParameterDefinition.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueRelatedArtifact",
        lazyDescriptor { RelatedArtifact.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueTriggerDefinition",
        lazyDescriptor { TriggerDefinition.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueUsageContext",
        lazyDescriptor { UsageContext.serializer().descriptor },
        isOptional = true,
      )
      element("valueDosage", lazyDescriptor { Dosage.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Extension =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Extension) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Extension {
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
    var valueDecimal: BigDecimal? = null
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> url = decoder.decodeStringElement(descriptor, i)
        3 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        4 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        5 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        7 -> valueCanonical = decoder.decodeStringElement(descriptor, i)
        8 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        9 -> valueCode = decoder.decodeStringElement(descriptor, i)
        10 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        11 -> valueDate = decoder.decodeStringElement(descriptor, i)
        12 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        13 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        14 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        15 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        16 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        17 -> valueId = decoder.decodeStringElement(descriptor, i)
        18 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        19 -> valueInstant = decoder.decodeStringElement(descriptor, i)
        20 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        21 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        22 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        23 -> valueMarkdown = decoder.decodeStringElement(descriptor, i)
        24 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        25 -> valueOid = decoder.decodeStringElement(descriptor, i)
        26 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        27 -> valuePositiveInt = decoder.decodeIntElement(descriptor, i)
        28 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        29 -> valueString = decoder.decodeStringElement(descriptor, i)
        30 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        31 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        32 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        33 -> valueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        34 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        35 -> valueUri = decoder.decodeStringElement(descriptor, i)
        36 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        37 -> valueUrl = decoder.decodeStringElement(descriptor, i)
        38 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        39 -> valueUuid = decoder.decodeStringElement(descriptor, i)
        40 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        41 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAddressSer, null)
        42 ->
          valueAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAgeSer, null)
        43 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAnnotationSer,
              null,
            )
        44 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        45 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        46 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        47 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        48 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactPointSer,
              null,
            )
        49 ->
          valueCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCountSer, null)
        50 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDistanceSer, null)
        51 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDurationSer, null)
        52 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueHumanNameSer,
              null,
            )
        53 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueIdentifierSer,
              null,
            )
        54 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMoneySer, null)
        55 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        56 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        57 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        58 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        59 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRatioRangeSer,
              null,
            )
        60 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        61 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSampledDataSer,
              null,
            )
        62 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSignatureSer,
              null,
            )
        63 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueTimingSer, null)
        64 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactDetailSer,
              null,
            )
        65 ->
          valueContributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContributorSer,
              null,
            )
        66 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        67 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExpressionSer,
              null,
            )
        68 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        69 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        70 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        71 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueUsageContextSer,
              null,
            )
        72 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDosageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Extension: " + i)
      }
    }
    return Extension(
      id = id,
      extension = extension ?: listOf(),
      url = url!!,
      `value` =
        Extension.Value.from(
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          Canonical.of(valueCanonical, _valueCanonical),
          Code.of(valueCode, _valueCode),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(FhirDateTime.fromString(valueInstant), _valueInstant),
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Extension) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    (value.url)?.let { encoder.encodeStringElement(descriptor, 2, it) }
    when (val __d = value.`value`) {
      null -> {}
      is Extension.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 15, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 20, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(descriptor, 21, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 22, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 23, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 24, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 25, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 26, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(descriptor, 27, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 28, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 29, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 30, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 31, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 32, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(descriptor, 33, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 34, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 35, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 36, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 37, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 38, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 39, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 40, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Address -> {
        encoder.encodeSerializableElement(descriptor, 41, Hoisted.valueAddressSer, __d.value)
      }
      is Extension.Value.Age -> {
        encoder.encodeSerializableElement(descriptor, 42, Hoisted.valueAgeSer, __d.value)
      }
      is Extension.Value.Annotation -> {
        encoder.encodeSerializableElement(descriptor, 43, Hoisted.valueAnnotationSer, __d.value)
      }
      is Extension.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 44, Hoisted.valueAttachmentSer, __d.value)
      }
      is Extension.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          45,
          Hoisted.valueCodeableConceptSer,
          __d.value,
        )
      }
      is Extension.Value.CodeableReference -> {
        encoder.encodeSerializableElement(
          descriptor,
          46,
          Hoisted.valueCodeableReferenceSer,
          __d.value,
        )
      }
      is Extension.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 47, Hoisted.valueCodingSer, __d.value)
      }
      is Extension.Value.ContactPoint -> {
        encoder.encodeSerializableElement(descriptor, 48, Hoisted.valueContactPointSer, __d.value)
      }
      is Extension.Value.Count -> {
        encoder.encodeSerializableElement(descriptor, 49, Hoisted.valueCountSer, __d.value)
      }
      is Extension.Value.Distance -> {
        encoder.encodeSerializableElement(descriptor, 50, Hoisted.valueDistanceSer, __d.value)
      }
      is Extension.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 51, Hoisted.valueDurationSer, __d.value)
      }
      is Extension.Value.HumanName -> {
        encoder.encodeSerializableElement(descriptor, 52, Hoisted.valueHumanNameSer, __d.value)
      }
      is Extension.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 53, Hoisted.valueIdentifierSer, __d.value)
      }
      is Extension.Value.Money -> {
        encoder.encodeSerializableElement(descriptor, 54, Hoisted.valueMoneySer, __d.value)
      }
      is Extension.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 55, Hoisted.valuePeriodSer, __d.value)
      }
      is Extension.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 56, Hoisted.valueQuantitySer, __d.value)
      }
      is Extension.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 57, Hoisted.valueRangeSer, __d.value)
      }
      is Extension.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 58, Hoisted.valueRatioSer, __d.value)
      }
      is Extension.Value.RatioRange -> {
        encoder.encodeSerializableElement(descriptor, 59, Hoisted.valueRatioRangeSer, __d.value)
      }
      is Extension.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 60, Hoisted.valueReferenceSer, __d.value)
      }
      is Extension.Value.SampledData -> {
        encoder.encodeSerializableElement(descriptor, 61, Hoisted.valueSampledDataSer, __d.value)
      }
      is Extension.Value.Signature -> {
        encoder.encodeSerializableElement(descriptor, 62, Hoisted.valueSignatureSer, __d.value)
      }
      is Extension.Value.Timing -> {
        encoder.encodeSerializableElement(descriptor, 63, Hoisted.valueTimingSer, __d.value)
      }
      is Extension.Value.ContactDetail -> {
        encoder.encodeSerializableElement(descriptor, 64, Hoisted.valueContactDetailSer, __d.value)
      }
      is Extension.Value.Contributor -> {
        encoder.encodeSerializableElement(descriptor, 65, Hoisted.valueContributorSer, __d.value)
      }
      is Extension.Value.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          66,
          Hoisted.valueDataRequirementSer,
          __d.value,
        )
      }
      is Extension.Value.Expression -> {
        encoder.encodeSerializableElement(descriptor, 67, Hoisted.valueExpressionSer, __d.value)
      }
      is Extension.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          68,
          Hoisted.valueParameterDefinitionSer,
          __d.value,
        )
      }
      is Extension.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          descriptor,
          69,
          Hoisted.valueRelatedArtifactSer,
          __d.value,
        )
      }
      is Extension.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          70,
          Hoisted.valueTriggerDefinitionSer,
          __d.value,
        )
      }
      is Extension.Value.UsageContext -> {
        encoder.encodeSerializableElement(descriptor, 71, Hoisted.valueUsageContextSer, __d.value)
      }
      is Extension.Value.Dosage -> {
        encoder.encodeSerializableElement(descriptor, 72, Hoisted.valueDosageSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueBase64BinarySer: KSerializer<Element> = Element.serializer()

    public val valueAddressSer: KSerializer<Address> = Address.serializer()

    public val valueAgeSer: KSerializer<Age> = Age.serializer()

    public val valueAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

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

    public val valueContributorSer: KSerializer<Contributor> = Contributor.serializer()

    public val valueDataRequirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val valueExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val valueParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val valueRelatedArtifactSer: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val valueTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val valueUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val valueDosageSer: KSerializer<Dosage> = Dosage.serializer()
  }
}
