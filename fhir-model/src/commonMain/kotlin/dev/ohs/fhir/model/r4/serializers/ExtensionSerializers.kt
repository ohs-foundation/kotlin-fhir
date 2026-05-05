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

package dev.ohs.fhir.model.r4.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
      element("valueMeta", lazyDescriptor { Meta.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Extension =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Extension) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Extension {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 -> url = decoder.decodeStringElement(__desc, __i)
        3 -> valueBase64Binary = decoder.decodeStringElement(__desc, __i)
        4 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        5 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        6 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        7 -> valueCanonical = decoder.decodeStringElement(__desc, __i)
        8 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        9 -> valueCode = decoder.decodeStringElement(__desc, __i)
        10 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        11 -> valueDate = decoder.decodeStringElement(__desc, __i)
        12 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        13 -> valueDateTime = decoder.decodeStringElement(__desc, __i)
        14 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        15 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        16 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        17 -> valueId = decoder.decodeStringElement(__desc, __i)
        18 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        19 -> valueInstant = decoder.decodeStringElement(__desc, __i)
        20 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        21 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        22 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        23 -> valueMarkdown = decoder.decodeStringElement(__desc, __i)
        24 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        25 -> valueOid = decoder.decodeStringElement(__desc, __i)
        26 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        27 -> valuePositiveInt = decoder.decodeIntElement(__desc, __i)
        28 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        29 -> valueString = decoder.decodeStringElement(__desc, __i)
        30 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        31 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        32 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        33 -> valueUnsignedInt = decoder.decodeIntElement(__desc, __i)
        34 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        35 -> valueUri = decoder.decodeStringElement(__desc, __i)
        36 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        37 -> valueUrl = decoder.decodeStringElement(__desc, __i)
        38 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        39 -> valueUuid = decoder.decodeStringElement(__desc, __i)
        40 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueBase64BinarySer,
              null,
            )
        41 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAddressSer, null)
        42 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAgeSer, null)
        43 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAnnotationSer, null)
        44 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        45 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        46 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCodingSer, null)
        47 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContactPointSer,
              null,
            )
        48 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCountSer, null)
        49 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDistanceSer, null)
        50 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDurationSer, null)
        51 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueHumanNameSer, null)
        52 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdentifierSer, null)
        53 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueMoneySer, null)
        54 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valuePeriodSer, null)
        55 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        56 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        57 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioSer, null)
        58 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueReferenceSer, null)
        59 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueSampledDataSer,
              null,
            )
        60 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSignatureSer, null)
        61 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueTimingSer, null)
        62 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContactDetailSer,
              null,
            )
        63 ->
          valueContributor =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContributorSer,
              null,
            )
        64 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        65 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueExpressionSer, null)
        66 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        67 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        68 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        69 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueUsageContextSer,
              null,
            )
        70 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDosageSer, null)
        71 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Extension: " + __i)
      }
    }
    return Extension(
      id = id,
      extension = extension ?: listOf(),
      url = url!!,
      `value` =
        Extension.Value.from(
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          R4Boolean.of(valueBoolean, _valueBoolean),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Extension) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    (value.url)?.let { encoder.encodeStringElement(__desc, 2, it) }
    when (val __d = value.`value`) {
      null -> {}
      is Extension.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 15, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 21, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 24, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 27, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 28, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 30, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 31, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 32, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 33, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 34, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 36, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 38, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 40, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Address -> {
        encoder.encodeSerializableElement(__desc, 41, Hoisted.valueAddressSer, __d.value)
      }
      is Extension.Value.Age -> {
        encoder.encodeSerializableElement(__desc, 42, Hoisted.valueAgeSer, __d.value)
      }
      is Extension.Value.Annotation -> {
        encoder.encodeSerializableElement(__desc, 43, Hoisted.valueAnnotationSer, __d.value)
      }
      is Extension.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 44, Hoisted.valueAttachmentSer, __d.value)
      }
      is Extension.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 45, Hoisted.valueCodeableConceptSer, __d.value)
      }
      is Extension.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 46, Hoisted.valueCodingSer, __d.value)
      }
      is Extension.Value.ContactPoint -> {
        encoder.encodeSerializableElement(__desc, 47, Hoisted.valueContactPointSer, __d.value)
      }
      is Extension.Value.Count -> {
        encoder.encodeSerializableElement(__desc, 48, Hoisted.valueCountSer, __d.value)
      }
      is Extension.Value.Distance -> {
        encoder.encodeSerializableElement(__desc, 49, Hoisted.valueDistanceSer, __d.value)
      }
      is Extension.Value.Duration -> {
        encoder.encodeSerializableElement(__desc, 50, Hoisted.valueDurationSer, __d.value)
      }
      is Extension.Value.HumanName -> {
        encoder.encodeSerializableElement(__desc, 51, Hoisted.valueHumanNameSer, __d.value)
      }
      is Extension.Value.Identifier -> {
        encoder.encodeSerializableElement(__desc, 52, Hoisted.valueIdentifierSer, __d.value)
      }
      is Extension.Value.Money -> {
        encoder.encodeSerializableElement(__desc, 53, Hoisted.valueMoneySer, __d.value)
      }
      is Extension.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 54, Hoisted.valuePeriodSer, __d.value)
      }
      is Extension.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 55, Hoisted.valueQuantitySer, __d.value)
      }
      is Extension.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 56, Hoisted.valueRangeSer, __d.value)
      }
      is Extension.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 57, Hoisted.valueRatioSer, __d.value)
      }
      is Extension.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 58, Hoisted.valueReferenceSer, __d.value)
      }
      is Extension.Value.SampledData -> {
        encoder.encodeSerializableElement(__desc, 59, Hoisted.valueSampledDataSer, __d.value)
      }
      is Extension.Value.Signature -> {
        encoder.encodeSerializableElement(__desc, 60, Hoisted.valueSignatureSer, __d.value)
      }
      is Extension.Value.Timing -> {
        encoder.encodeSerializableElement(__desc, 61, Hoisted.valueTimingSer, __d.value)
      }
      is Extension.Value.ContactDetail -> {
        encoder.encodeSerializableElement(__desc, 62, Hoisted.valueContactDetailSer, __d.value)
      }
      is Extension.Value.Contributor -> {
        encoder.encodeSerializableElement(__desc, 63, Hoisted.valueContributorSer, __d.value)
      }
      is Extension.Value.DataRequirement -> {
        encoder.encodeSerializableElement(__desc, 64, Hoisted.valueDataRequirementSer, __d.value)
      }
      is Extension.Value.Expression -> {
        encoder.encodeSerializableElement(__desc, 65, Hoisted.valueExpressionSer, __d.value)
      }
      is Extension.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          66,
          Hoisted.valueParameterDefinitionSer,
          __d.value,
        )
      }
      is Extension.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(__desc, 67, Hoisted.valueRelatedArtifactSer, __d.value)
      }
      is Extension.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(__desc, 68, Hoisted.valueTriggerDefinitionSer, __d.value)
      }
      is Extension.Value.UsageContext -> {
        encoder.encodeSerializableElement(__desc, 69, Hoisted.valueUsageContextSer, __d.value)
      }
      is Extension.Value.Dosage -> {
        encoder.encodeSerializableElement(__desc, 70, Hoisted.valueDosageSer, __d.value)
      }
      is Extension.Value.Meta -> {
        encoder.encodeSerializableElement(__desc, 71, Hoisted.valueMetaSer, __d.value)
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

    public val valueMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}
