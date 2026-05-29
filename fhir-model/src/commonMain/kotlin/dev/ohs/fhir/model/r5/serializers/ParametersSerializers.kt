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

@file:OptIn(ExperimentalSerializationApi::class)

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
      element("valueAddress", Address.serializer().descriptor, isOptional = true)
      element("valueAge", Age.serializer().descriptor, isOptional = true)
      element("valueAnnotation", Annotation.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "valueCodeableReference",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
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
      element("valueRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("valueSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("valueSignature", Signature.serializer().descriptor, isOptional = true)
      element("valueTiming", Timing.serializer().descriptor, isOptional = true)
      element("valueContactDetail", ContactDetail.serializer().descriptor, isOptional = true)
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
      element("valueAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "valueExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("valueDosage", Dosage.serializer().descriptor, isOptional = true)
      element("valueMeta", Meta.serializer().descriptor, isOptional = true)
      element("resource", lazyDescriptor { Resource.serializer().descriptor }, isOptional = true)
      element(
        "part",
        listSerialDescriptor(lazyDescriptor { Parameters.Parameter.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Parameters.Parameter =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Parameters.Parameter) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
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
    var resource: Resource? = null
    var part: List<Parameters.Parameter>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        9 -> valueCanonical = decoder.decodeStringElement(descriptor, i)
        10 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        11 -> valueCode = decoder.decodeStringElement(descriptor, i)
        12 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        13 -> valueDate = decoder.decodeStringElement(descriptor, i)
        14 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        15 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        16 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        17 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        18 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        19 -> valueId = decoder.decodeStringElement(descriptor, i)
        20 ->
          _valueId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        21 -> valueInstant = decoder.decodeStringElement(descriptor, i)
        22 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        23 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        24 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        25 -> valueInteger64 = decoder.decodeStringElement(descriptor, i)
        26 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        27 -> valueMarkdown = decoder.decodeStringElement(descriptor, i)
        28 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        29 -> valueOid = decoder.decodeStringElement(descriptor, i)
        30 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        31 -> valuePositiveInt = decoder.decodeIntElement(descriptor, i)
        32 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        33 -> valueString = decoder.decodeStringElement(descriptor, i)
        34 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        35 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        36 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        37 -> valueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        38 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        39 -> valueUri = decoder.decodeStringElement(descriptor, i)
        40 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        41 -> valueUrl = decoder.decodeStringElement(descriptor, i)
        42 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        43 -> valueUuid = decoder.decodeStringElement(descriptor, i)
        44 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        45 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAddressSer, null)
        46 ->
          valueAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAgeSer, null)
        47 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAnnotationSer,
              null,
            )
        48 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        49 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        50 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        51 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        52 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactPointSer,
              null,
            )
        53 ->
          valueCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCountSer, null)
        54 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDistanceSer, null)
        55 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDurationSer, null)
        56 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueHumanNameSer,
              null,
            )
        57 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueIdentifierSer,
              null,
            )
        58 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMoneySer, null)
        59 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        60 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        61 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        62 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        63 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRatioRangeSer,
              null,
            )
        64 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        65 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSampledDataSer,
              null,
            )
        66 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSignatureSer,
              null,
            )
        67 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueTimingSer, null)
        68 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactDetailSer,
              null,
            )
        69 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        70 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExpressionSer,
              null,
            )
        71 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        72 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        73 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        74 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueUsageContextSer,
              null,
            )
        75 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAvailabilitySer,
              null,
            )
        76 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        77 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDosageSer, null)
        78 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMetaSer, null)
        79 ->
          resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        80 -> part = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    return Parameters.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      `value` =
        Parameters.Parameter.Value.from(
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
      resource = resource,
      part = part ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Parameters.Parameter) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    when (val choice = value.`value`) {
      null -> {}
      is Parameters.Parameter.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 15, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 17, BigDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 19, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 20, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 21, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 22, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 23, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 24, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Integer64 -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 25, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 26, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 27, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 28, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Oid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 29, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 30, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 31, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 32, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 33, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 34, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 35, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 36, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 37, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 38, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 39, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 40, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 41, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 42, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Uuid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 43, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 44, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Address -> {
        encoder.encodeSerializableElement(descriptor, 45, Hoisted.valueAddressSer, choice.value)
      }
      is Parameters.Parameter.Value.Age -> {
        encoder.encodeSerializableElement(descriptor, 46, Hoisted.valueAgeSer, choice.value)
      }
      is Parameters.Parameter.Value.Annotation -> {
        encoder.encodeSerializableElement(descriptor, 47, Hoisted.valueAnnotationSer, choice.value)
      }
      is Parameters.Parameter.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 48, Hoisted.valueAttachmentSer, choice.value)
      }
      is Parameters.Parameter.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          49,
          Hoisted.valueCodeableConceptSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.CodeableReference -> {
        encoder.encodeSerializableElement(
          descriptor,
          50,
          Hoisted.valueCodeableReferenceSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 51, Hoisted.valueCodingSer, choice.value)
      }
      is Parameters.Parameter.Value.ContactPoint -> {
        encoder.encodeSerializableElement(
          descriptor,
          52,
          Hoisted.valueContactPointSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Count -> {
        encoder.encodeSerializableElement(descriptor, 53, Hoisted.valueCountSer, choice.value)
      }
      is Parameters.Parameter.Value.Distance -> {
        encoder.encodeSerializableElement(descriptor, 54, Hoisted.valueDistanceSer, choice.value)
      }
      is Parameters.Parameter.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 55, Hoisted.valueDurationSer, choice.value)
      }
      is Parameters.Parameter.Value.HumanName -> {
        encoder.encodeSerializableElement(descriptor, 56, Hoisted.valueHumanNameSer, choice.value)
      }
      is Parameters.Parameter.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 57, Hoisted.valueIdentifierSer, choice.value)
      }
      is Parameters.Parameter.Value.Money -> {
        encoder.encodeSerializableElement(descriptor, 58, Hoisted.valueMoneySer, choice.value)
      }
      is Parameters.Parameter.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 59, Hoisted.valuePeriodSer, choice.value)
      }
      is Parameters.Parameter.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 60, Hoisted.valueQuantitySer, choice.value)
      }
      is Parameters.Parameter.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 61, Hoisted.valueRangeSer, choice.value)
      }
      is Parameters.Parameter.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 62, Hoisted.valueRatioSer, choice.value)
      }
      is Parameters.Parameter.Value.RatioRange -> {
        encoder.encodeSerializableElement(descriptor, 63, Hoisted.valueRatioRangeSer, choice.value)
      }
      is Parameters.Parameter.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 64, Hoisted.valueReferenceSer, choice.value)
      }
      is Parameters.Parameter.Value.SampledData -> {
        encoder.encodeSerializableElement(descriptor, 65, Hoisted.valueSampledDataSer, choice.value)
      }
      is Parameters.Parameter.Value.Signature -> {
        encoder.encodeSerializableElement(descriptor, 66, Hoisted.valueSignatureSer, choice.value)
      }
      is Parameters.Parameter.Value.Timing -> {
        encoder.encodeSerializableElement(descriptor, 67, Hoisted.valueTimingSer, choice.value)
      }
      is Parameters.Parameter.Value.ContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          68,
          Hoisted.valueContactDetailSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          69,
          Hoisted.valueDataRequirementSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Expression -> {
        encoder.encodeSerializableElement(descriptor, 70, Hoisted.valueExpressionSer, choice.value)
      }
      is Parameters.Parameter.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          71,
          Hoisted.valueParameterDefinitionSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          descriptor,
          72,
          Hoisted.valueRelatedArtifactSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          73,
          Hoisted.valueTriggerDefinitionSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.UsageContext -> {
        encoder.encodeSerializableElement(
          descriptor,
          74,
          Hoisted.valueUsageContextSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Availability -> {
        encoder.encodeSerializableElement(
          descriptor,
          75,
          Hoisted.valueAvailabilitySer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          76,
          Hoisted.valueExtendedContactDetailSer,
          choice.value,
        )
      }
      is Parameters.Parameter.Value.Dosage -> {
        encoder.encodeSerializableElement(descriptor, 77, Hoisted.valueDosageSer, choice.value)
      }
      is Parameters.Parameter.Value.Meta -> {
        encoder.encodeSerializableElement(descriptor, 78, Hoisted.valueMetaSer, choice.value)
      }
    }
    (value.resource)?.let {
      encoder.encodeSerializableElement(descriptor, 79, Hoisted.resourceSer, it)
    }
    if (value.part.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 80, Hoisted.partSer, value.part)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

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

    public val resourceSer: KSerializer<Resource> = Resource.serializer()

    public val partSerInner: KSerializer<Parameters.Parameter> = Parameters.Parameter.serializer()

    public val partSer: KSerializer<List<Parameters.Parameter>> =
      ListSerializer(Hoisted.partSerInner)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 ->
          parameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parameterSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6 + descriptorOffset,
        Hoisted.parameterSer,
        value.parameter,
      )
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val parameterSerInner: KSerializer<Parameters.Parameter> =
      Parameters.Parameter.serializer()

    public val parameterSer: KSerializer<List<Parameters.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)
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
