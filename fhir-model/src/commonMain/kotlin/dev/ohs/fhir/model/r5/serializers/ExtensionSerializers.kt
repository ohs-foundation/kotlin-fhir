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

package dev.ohs.fhir.model.r5.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.RatioRange
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
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

internal object ExtensionValueSerializer : KSerializer<Extension.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Extension.Value") {
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
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element("valueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueId", Element.serializer().descriptor, isOptional = true)
      element("valueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueInstant", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueInteger64", Element.serializer().descriptor, isOptional = true)
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
      element(
        "valueAvailability",
        lazyDescriptor { Availability.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueExtendedContactDetail",
        lazyDescriptor { ExtendedContactDetail.serializer().descriptor },
        isOptional = true,
      )
      element("valueDosage", lazyDescriptor { Dosage.serializer().descriptor }, isOptional = true)
      element("valueMeta", lazyDescriptor { Meta.serializer().descriptor }, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Extension.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Extension.Value.Base64Binary -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Code -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 8, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 10, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 12, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Id -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 14, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 15, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Instant -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 16, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 17, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 18, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 19, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Integer64 -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 20, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 21, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Markdown -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 22, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 23, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Oid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 24, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 25, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.PositiveInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 26, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 27, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 28, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 29, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 30, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 31, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.UnsignedInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 32, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 33, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Uri -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 34, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 35, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Url -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 36, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 37, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Uuid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 38, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 39, Hoisted.elementSer, it)
          }
        }
        is Extension.Value.Address -> {
          encodeSerializableElement(__desc, 40, Hoisted.valueAddressSer, __d.value)
        }
        is Extension.Value.Age -> {
          encodeSerializableElement(__desc, 41, Hoisted.valueAgeSer, __d.value)
        }
        is Extension.Value.Annotation -> {
          encodeSerializableElement(__desc, 42, Hoisted.valueAnnotationSer, __d.value)
        }
        is Extension.Value.Attachment -> {
          encodeSerializableElement(__desc, 43, Hoisted.valueAttachmentSer, __d.value)
        }
        is Extension.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 44, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is Extension.Value.CodeableReference -> {
          encodeSerializableElement(__desc, 45, Hoisted.valueCodeableReferenceSer, __d.value)
        }
        is Extension.Value.Coding -> {
          encodeSerializableElement(__desc, 46, Hoisted.valueCodingSer, __d.value)
        }
        is Extension.Value.ContactPoint -> {
          encodeSerializableElement(__desc, 47, Hoisted.valueContactPointSer, __d.value)
        }
        is Extension.Value.Count -> {
          encodeSerializableElement(__desc, 48, Hoisted.valueCountSer, __d.value)
        }
        is Extension.Value.Distance -> {
          encodeSerializableElement(__desc, 49, Hoisted.valueDistanceSer, __d.value)
        }
        is Extension.Value.Duration -> {
          encodeSerializableElement(__desc, 50, Hoisted.valueDurationSer, __d.value)
        }
        is Extension.Value.HumanName -> {
          encodeSerializableElement(__desc, 51, Hoisted.valueHumanNameSer, __d.value)
        }
        is Extension.Value.Identifier -> {
          encodeSerializableElement(__desc, 52, Hoisted.valueIdentifierSer, __d.value)
        }
        is Extension.Value.Money -> {
          encodeSerializableElement(__desc, 53, Hoisted.valueMoneySer, __d.value)
        }
        is Extension.Value.Period -> {
          encodeSerializableElement(__desc, 54, Hoisted.valuePeriodSer, __d.value)
        }
        is Extension.Value.Quantity -> {
          encodeSerializableElement(__desc, 55, Hoisted.valueQuantitySer, __d.value)
        }
        is Extension.Value.Range -> {
          encodeSerializableElement(__desc, 56, Hoisted.valueRangeSer, __d.value)
        }
        is Extension.Value.Ratio -> {
          encodeSerializableElement(__desc, 57, Hoisted.valueRatioSer, __d.value)
        }
        is Extension.Value.RatioRange -> {
          encodeSerializableElement(__desc, 58, Hoisted.valueRatioRangeSer, __d.value)
        }
        is Extension.Value.Reference -> {
          encodeSerializableElement(__desc, 59, Hoisted.valueReferenceSer, __d.value)
        }
        is Extension.Value.SampledData -> {
          encodeSerializableElement(__desc, 60, Hoisted.valueSampledDataSer, __d.value)
        }
        is Extension.Value.Signature -> {
          encodeSerializableElement(__desc, 61, Hoisted.valueSignatureSer, __d.value)
        }
        is Extension.Value.Timing -> {
          encodeSerializableElement(__desc, 62, Hoisted.valueTimingSer, __d.value)
        }
        is Extension.Value.ContactDetail -> {
          encodeSerializableElement(__desc, 63, Hoisted.valueContactDetailSer, __d.value)
        }
        is Extension.Value.DataRequirement -> {
          encodeSerializableElement(__desc, 64, Hoisted.valueDataRequirementSer, __d.value)
        }
        is Extension.Value.Expression -> {
          encodeSerializableElement(__desc, 65, Hoisted.valueExpressionSer, __d.value)
        }
        is Extension.Value.ParameterDefinition -> {
          encodeSerializableElement(__desc, 66, Hoisted.valueParameterDefinitionSer, __d.value)
        }
        is Extension.Value.RelatedArtifact -> {
          encodeSerializableElement(__desc, 67, Hoisted.valueRelatedArtifactSer, __d.value)
        }
        is Extension.Value.TriggerDefinition -> {
          encodeSerializableElement(__desc, 68, Hoisted.valueTriggerDefinitionSer, __d.value)
        }
        is Extension.Value.UsageContext -> {
          encodeSerializableElement(__desc, 69, Hoisted.valueUsageContextSer, __d.value)
        }
        is Extension.Value.Availability -> {
          encodeSerializableElement(__desc, 70, Hoisted.valueAvailabilitySer, __d.value)
        }
        is Extension.Value.ExtendedContactDetail -> {
          encodeSerializableElement(__desc, 71, Hoisted.valueExtendedContactDetailSer, __d.value)
        }
        is Extension.Value.Dosage -> {
          encodeSerializableElement(__desc, 72, Hoisted.valueDosageSer, __d.value)
        }
        is Extension.Value.Meta -> {
          encodeSerializableElement(__desc, 73, Hoisted.valueMetaSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Extension.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Extension.Value {
    val __desc = descriptor
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> valueBase64Binary = decoder.decodeStringElement(__desc, 0)
        1 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> valueBoolean = decoder.decodeBooleanElement(__desc, 2)
        3 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> valueCanonical = decoder.decodeStringElement(__desc, 4)
        5 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> valueCode = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 -> valueDate = decoder.decodeStringElement(__desc, 8)
        9 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 -> valueDateTime = decoder.decodeStringElement(__desc, 10)
        11 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 12, BigDecimalSerializer, null)
        13 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 -> valueId = decoder.decodeStringElement(__desc, 14)
        15 ->
          _valueId = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.elementSer, null)
        16 -> valueInstant = decoder.decodeStringElement(__desc, 16)
        17 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.elementSer, null)
        18 -> valueInteger = decoder.decodeIntElement(__desc, 18)
        19 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.elementSer, null)
        20 -> valueInteger64 = decoder.decodeStringElement(__desc, 20)
        21 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.elementSer, null)
        22 -> valueMarkdown = decoder.decodeStringElement(__desc, 22)
        23 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.elementSer, null)
        24 -> valueOid = decoder.decodeStringElement(__desc, 24)
        25 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.elementSer, null)
        26 -> valuePositiveInt = decoder.decodeIntElement(__desc, 26)
        27 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.elementSer, null)
        28 -> valueString = decoder.decodeStringElement(__desc, 28)
        29 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.elementSer, null)
        30 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 30, LocalTimeSerializer, null)
        31 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.elementSer, null)
        32 -> valueUnsignedInt = decoder.decodeIntElement(__desc, 32)
        33 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.elementSer, null)
        34 -> valueUri = decoder.decodeStringElement(__desc, 34)
        35 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.elementSer, null)
        36 -> valueUrl = decoder.decodeStringElement(__desc, 36)
        37 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.elementSer, null)
        38 -> valueUuid = decoder.decodeStringElement(__desc, 38)
        39 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.elementSer, null)
        40 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.valueAddressSer, null)
        41 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.valueAgeSer, null)
        42 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.valueAnnotationSer, null)
        43 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.valueAttachmentSer, null)
        44 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              44,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        45 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              45,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        46 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.valueCodingSer, null)
        47 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              47,
              Hoisted.valueContactPointSer,
              null,
            )
        48 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.valueCountSer, null)
        49 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.valueDistanceSer, null)
        50 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.valueDurationSer, null)
        51 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.valueHumanNameSer, null)
        52 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.valueIdentifierSer, null)
        53 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.valueMoneySer, null)
        54 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.valuePeriodSer, null)
        55 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.valueQuantitySer, null)
        56 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.valueRangeSer, null)
        57 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.valueRatioSer, null)
        58 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.valueRatioRangeSer, null)
        59 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.valueReferenceSer, null)
        60 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.valueSampledDataSer, null)
        61 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.valueSignatureSer, null)
        62 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.valueTimingSer, null)
        63 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              63,
              Hoisted.valueContactDetailSer,
              null,
            )
        64 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              64,
              Hoisted.valueDataRequirementSer,
              null,
            )
        65 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, 65, Hoisted.valueExpressionSer, null)
        66 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              66,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        67 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              67,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        68 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              68,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        69 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              69,
              Hoisted.valueUsageContextSer,
              null,
            )
        70 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              70,
              Hoisted.valueAvailabilitySer,
              null,
            )
        71 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              71,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        72 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, 72, Hoisted.valueDosageSer, null)
        73 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, 73, Hoisted.valueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Extension.Value: " + __i)
      }
    }
    return Extension.Value.from(
      Base64Binary.of(valueBase64Binary, _valueBase64Binary),
      R5Boolean.of(valueBoolean, _valueBoolean),
      Canonical.of(valueCanonical, _valueCanonical),
      Code.of(valueCode, _valueCode),
      Date.of(FhirDate.fromString(valueDate), _valueDate),
      DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
      Decimal.of(valueDecimal, _valueDecimal),
      Id.of(valueId, _valueId),
      Instant.of(FhirDateTime.fromString(valueInstant), _valueInstant),
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
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

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

    public val valueDataRequirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val valueExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val valueParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val valueRelatedArtifactSer: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val valueTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val valueUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val valueAvailabilitySer: KSerializer<Availability> = Availability.serializer()

    public val valueExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val valueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val valueMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}

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
      element("valueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueInteger64",
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
      element(
        "valueAvailability",
        lazyDescriptor { Availability.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueExtendedContactDetail",
        lazyDescriptor { ExtendedContactDetail.serializer().descriptor },
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> url = decoder.decodeStringElement(__desc, 2)
        3 -> valueBase64Binary = decoder.decodeStringElement(__desc, 3)
        4 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueBase64BinarySer, null)
        5 -> valueBoolean = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueBase64BinarySer, null)
        7 -> valueCanonical = decoder.decodeStringElement(__desc, 7)
        8 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueBase64BinarySer, null)
        9 -> valueCode = decoder.decodeStringElement(__desc, 9)
        10 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.valueBase64BinarySer,
              null,
            )
        11 -> valueDate = decoder.decodeStringElement(__desc, 11)
        12 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.valueBase64BinarySer,
              null,
            )
        13 -> valueDateTime = decoder.decodeStringElement(__desc, 13)
        14 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.valueBase64BinarySer,
              null,
            )
        15 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 15, BigDecimalSerializer, null)
        16 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.valueBase64BinarySer,
              null,
            )
        17 -> valueId = decoder.decodeStringElement(__desc, 17)
        18 ->
          _valueId =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.valueBase64BinarySer,
              null,
            )
        19 -> valueInstant = decoder.decodeStringElement(__desc, 19)
        20 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(
              __desc,
              20,
              Hoisted.valueBase64BinarySer,
              null,
            )
        21 -> valueInteger = decoder.decodeIntElement(__desc, 21)
        22 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.valueBase64BinarySer,
              null,
            )
        23 -> valueInteger64 = decoder.decodeStringElement(__desc, 23)
        24 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(
              __desc,
              24,
              Hoisted.valueBase64BinarySer,
              null,
            )
        25 -> valueMarkdown = decoder.decodeStringElement(__desc, 25)
        26 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.valueBase64BinarySer,
              null,
            )
        27 -> valueOid = decoder.decodeStringElement(__desc, 27)
        28 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(
              __desc,
              28,
              Hoisted.valueBase64BinarySer,
              null,
            )
        29 -> valuePositiveInt = decoder.decodeIntElement(__desc, 29)
        30 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              30,
              Hoisted.valueBase64BinarySer,
              null,
            )
        31 -> valueString = decoder.decodeStringElement(__desc, 31)
        32 ->
          _valueString =
            decoder.decodeNullableSerializableElement(
              __desc,
              32,
              Hoisted.valueBase64BinarySer,
              null,
            )
        33 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 33, LocalTimeSerializer, null)
        34 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              34,
              Hoisted.valueBase64BinarySer,
              null,
            )
        35 -> valueUnsignedInt = decoder.decodeIntElement(__desc, 35)
        36 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              36,
              Hoisted.valueBase64BinarySer,
              null,
            )
        37 -> valueUri = decoder.decodeStringElement(__desc, 37)
        38 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              38,
              Hoisted.valueBase64BinarySer,
              null,
            )
        39 -> valueUrl = decoder.decodeStringElement(__desc, 39)
        40 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(
              __desc,
              40,
              Hoisted.valueBase64BinarySer,
              null,
            )
        41 -> valueUuid = decoder.decodeStringElement(__desc, 41)
        42 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(
              __desc,
              42,
              Hoisted.valueBase64BinarySer,
              null,
            )
        43 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.valueAddressSer, null)
        44 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.valueAgeSer, null)
        45 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.valueAnnotationSer, null)
        46 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.valueAttachmentSer, null)
        47 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              47,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        48 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              48,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        49 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.valueCodingSer, null)
        50 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              50,
              Hoisted.valueContactPointSer,
              null,
            )
        51 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.valueCountSer, null)
        52 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.valueDistanceSer, null)
        53 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.valueDurationSer, null)
        54 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.valueHumanNameSer, null)
        55 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.valueIdentifierSer, null)
        56 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.valueMoneySer, null)
        57 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.valuePeriodSer, null)
        58 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.valueQuantitySer, null)
        59 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.valueRangeSer, null)
        60 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.valueRatioSer, null)
        61 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.valueRatioRangeSer, null)
        62 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.valueReferenceSer, null)
        63 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 63, Hoisted.valueSampledDataSer, null)
        64 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.valueSignatureSer, null)
        65 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, 65, Hoisted.valueTimingSer, null)
        66 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              66,
              Hoisted.valueContactDetailSer,
              null,
            )
        67 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              67,
              Hoisted.valueDataRequirementSer,
              null,
            )
        68 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, 68, Hoisted.valueExpressionSer, null)
        69 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              69,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        70 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              70,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        71 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              71,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        72 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              72,
              Hoisted.valueUsageContextSer,
              null,
            )
        73 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              73,
              Hoisted.valueAvailabilitySer,
              null,
            )
        74 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              74,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        75 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, 75, Hoisted.valueDosageSer, null)
        76 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, 76, Hoisted.valueMetaSer, null)
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
          R5Boolean.of(valueBoolean, _valueBoolean),
          Canonical.of(valueCanonical, _valueCanonical),
          Code.of(valueCode, _valueCode),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(FhirDateTime.fromString(valueInstant), _valueInstant),
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
      is Extension.Value.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 24, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 28, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 29, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 30, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 32, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 33, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 34, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 35, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 36, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 38, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 40, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 41, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 42, Hoisted.valueBase64BinarySer, it)
        }
      }
      is Extension.Value.Address -> {
        encoder.encodeSerializableElement(__desc, 43, Hoisted.valueAddressSer, __d.value)
      }
      is Extension.Value.Age -> {
        encoder.encodeSerializableElement(__desc, 44, Hoisted.valueAgeSer, __d.value)
      }
      is Extension.Value.Annotation -> {
        encoder.encodeSerializableElement(__desc, 45, Hoisted.valueAnnotationSer, __d.value)
      }
      is Extension.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 46, Hoisted.valueAttachmentSer, __d.value)
      }
      is Extension.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 47, Hoisted.valueCodeableConceptSer, __d.value)
      }
      is Extension.Value.CodeableReference -> {
        encoder.encodeSerializableElement(__desc, 48, Hoisted.valueCodeableReferenceSer, __d.value)
      }
      is Extension.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 49, Hoisted.valueCodingSer, __d.value)
      }
      is Extension.Value.ContactPoint -> {
        encoder.encodeSerializableElement(__desc, 50, Hoisted.valueContactPointSer, __d.value)
      }
      is Extension.Value.Count -> {
        encoder.encodeSerializableElement(__desc, 51, Hoisted.valueCountSer, __d.value)
      }
      is Extension.Value.Distance -> {
        encoder.encodeSerializableElement(__desc, 52, Hoisted.valueDistanceSer, __d.value)
      }
      is Extension.Value.Duration -> {
        encoder.encodeSerializableElement(__desc, 53, Hoisted.valueDurationSer, __d.value)
      }
      is Extension.Value.HumanName -> {
        encoder.encodeSerializableElement(__desc, 54, Hoisted.valueHumanNameSer, __d.value)
      }
      is Extension.Value.Identifier -> {
        encoder.encodeSerializableElement(__desc, 55, Hoisted.valueIdentifierSer, __d.value)
      }
      is Extension.Value.Money -> {
        encoder.encodeSerializableElement(__desc, 56, Hoisted.valueMoneySer, __d.value)
      }
      is Extension.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 57, Hoisted.valuePeriodSer, __d.value)
      }
      is Extension.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 58, Hoisted.valueQuantitySer, __d.value)
      }
      is Extension.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 59, Hoisted.valueRangeSer, __d.value)
      }
      is Extension.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 60, Hoisted.valueRatioSer, __d.value)
      }
      is Extension.Value.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 61, Hoisted.valueRatioRangeSer, __d.value)
      }
      is Extension.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 62, Hoisted.valueReferenceSer, __d.value)
      }
      is Extension.Value.SampledData -> {
        encoder.encodeSerializableElement(__desc, 63, Hoisted.valueSampledDataSer, __d.value)
      }
      is Extension.Value.Signature -> {
        encoder.encodeSerializableElement(__desc, 64, Hoisted.valueSignatureSer, __d.value)
      }
      is Extension.Value.Timing -> {
        encoder.encodeSerializableElement(__desc, 65, Hoisted.valueTimingSer, __d.value)
      }
      is Extension.Value.ContactDetail -> {
        encoder.encodeSerializableElement(__desc, 66, Hoisted.valueContactDetailSer, __d.value)
      }
      is Extension.Value.DataRequirement -> {
        encoder.encodeSerializableElement(__desc, 67, Hoisted.valueDataRequirementSer, __d.value)
      }
      is Extension.Value.Expression -> {
        encoder.encodeSerializableElement(__desc, 68, Hoisted.valueExpressionSer, __d.value)
      }
      is Extension.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          69,
          Hoisted.valueParameterDefinitionSer,
          __d.value,
        )
      }
      is Extension.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(__desc, 70, Hoisted.valueRelatedArtifactSer, __d.value)
      }
      is Extension.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(__desc, 71, Hoisted.valueTriggerDefinitionSer, __d.value)
      }
      is Extension.Value.UsageContext -> {
        encoder.encodeSerializableElement(__desc, 72, Hoisted.valueUsageContextSer, __d.value)
      }
      is Extension.Value.Availability -> {
        encoder.encodeSerializableElement(__desc, 73, Hoisted.valueAvailabilitySer, __d.value)
      }
      is Extension.Value.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          74,
          Hoisted.valueExtendedContactDetailSer,
          __d.value,
        )
      }
      is Extension.Value.Dosage -> {
        encoder.encodeSerializableElement(__desc, 75, Hoisted.valueDosageSer, __d.value)
      }
      is Extension.Value.Meta -> {
        encoder.encodeSerializableElement(__desc, 76, Hoisted.valueMetaSer, __d.value)
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

    public val valueDataRequirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val valueExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val valueParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val valueRelatedArtifactSer: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val valueTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val valueUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val valueAvailabilitySer: KSerializer<Availability> = Availability.serializer()

    public val valueExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val valueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val valueMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}
