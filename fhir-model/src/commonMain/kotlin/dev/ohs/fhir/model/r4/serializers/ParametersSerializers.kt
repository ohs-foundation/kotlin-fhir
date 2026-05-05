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
import dev.ohs.fhir.model.r4.Parameters
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
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

  override fun deserialize(decoder: Decoder): Parameters.Parameter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Parameters.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Parameters.Parameter {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 -> valueBase64Binary = decoder.decodeStringElement(__desc, __i)
        6 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        9 -> valueCanonical = decoder.decodeStringElement(__desc, __i)
        10 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        11 -> valueCode = decoder.decodeStringElement(__desc, __i)
        12 ->
          _valueCode = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        13 -> valueDate = decoder.decodeStringElement(__desc, __i)
        14 ->
          _valueDate = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        15 -> valueDateTime = decoder.decodeStringElement(__desc, __i)
        16 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        17 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        18 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        19 -> valueId = decoder.decodeStringElement(__desc, __i)
        20 ->
          _valueId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        21 -> valueInstant = decoder.decodeStringElement(__desc, __i)
        22 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        23 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        24 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        25 -> valueMarkdown = decoder.decodeStringElement(__desc, __i)
        26 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        27 -> valueOid = decoder.decodeStringElement(__desc, __i)
        28 ->
          _valueOid = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        29 -> valuePositiveInt = decoder.decodeIntElement(__desc, __i)
        30 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        31 -> valueString = decoder.decodeStringElement(__desc, __i)
        32 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        33 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        34 ->
          _valueTime = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        35 -> valueUnsignedInt = decoder.decodeIntElement(__desc, __i)
        36 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        37 -> valueUri = decoder.decodeStringElement(__desc, __i)
        38 ->
          _valueUri = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        39 -> valueUrl = decoder.decodeStringElement(__desc, __i)
        40 ->
          _valueUrl = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        41 -> valueUuid = decoder.decodeStringElement(__desc, __i)
        42 ->
          _valueUuid = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        43 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAddressSer, null)
        44 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAgeSer, null)
        45 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAnnotationSer, null)
        46 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        47 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        48 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCodingSer, null)
        49 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContactPointSer,
              null,
            )
        50 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCountSer, null)
        51 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDistanceSer, null)
        52 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDurationSer, null)
        53 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueHumanNameSer, null)
        54 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdentifierSer, null)
        55 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueMoneySer, null)
        56 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valuePeriodSer, null)
        57 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        58 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        59 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioSer, null)
        60 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueReferenceSer, null)
        61 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueSampledDataSer,
              null,
            )
        62 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSignatureSer, null)
        63 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueTimingSer, null)
        64 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContactDetailSer,
              null,
            )
        65 ->
          valueContributor =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueContributorSer,
              null,
            )
        66 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        67 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueExpressionSer, null)
        68 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        69 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        70 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        71 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueUsageContextSer,
              null,
            )
        72 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDosageSer, null)
        73 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueMetaSer, null)
        74 ->
          resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resourceSer, null)
        75 -> part = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return Parameters.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name)!!,
      `value` =
        Parameters.Parameter.Value.from(
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
      resource = resource,
      part = part ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Parameters.Parameter) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is Parameters.Parameter.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 17, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 23, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 24, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 28, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 29, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 30, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 32, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 33, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 34, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 35, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 36, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 38, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 40, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 41, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 42, Hoisted.nameSer, it)
        }
      }
      is Parameters.Parameter.Value.Address -> {
        encoder.encodeSerializableElement(__desc, 43, Hoisted.valueAddressSer, __d.value)
      }
      is Parameters.Parameter.Value.Age -> {
        encoder.encodeSerializableElement(__desc, 44, Hoisted.valueAgeSer, __d.value)
      }
      is Parameters.Parameter.Value.Annotation -> {
        encoder.encodeSerializableElement(__desc, 45, Hoisted.valueAnnotationSer, __d.value)
      }
      is Parameters.Parameter.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 46, Hoisted.valueAttachmentSer, __d.value)
      }
      is Parameters.Parameter.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 47, Hoisted.valueCodeableConceptSer, __d.value)
      }
      is Parameters.Parameter.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 48, Hoisted.valueCodingSer, __d.value)
      }
      is Parameters.Parameter.Value.ContactPoint -> {
        encoder.encodeSerializableElement(__desc, 49, Hoisted.valueContactPointSer, __d.value)
      }
      is Parameters.Parameter.Value.Count -> {
        encoder.encodeSerializableElement(__desc, 50, Hoisted.valueCountSer, __d.value)
      }
      is Parameters.Parameter.Value.Distance -> {
        encoder.encodeSerializableElement(__desc, 51, Hoisted.valueDistanceSer, __d.value)
      }
      is Parameters.Parameter.Value.Duration -> {
        encoder.encodeSerializableElement(__desc, 52, Hoisted.valueDurationSer, __d.value)
      }
      is Parameters.Parameter.Value.HumanName -> {
        encoder.encodeSerializableElement(__desc, 53, Hoisted.valueHumanNameSer, __d.value)
      }
      is Parameters.Parameter.Value.Identifier -> {
        encoder.encodeSerializableElement(__desc, 54, Hoisted.valueIdentifierSer, __d.value)
      }
      is Parameters.Parameter.Value.Money -> {
        encoder.encodeSerializableElement(__desc, 55, Hoisted.valueMoneySer, __d.value)
      }
      is Parameters.Parameter.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 56, Hoisted.valuePeriodSer, __d.value)
      }
      is Parameters.Parameter.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 57, Hoisted.valueQuantitySer, __d.value)
      }
      is Parameters.Parameter.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 58, Hoisted.valueRangeSer, __d.value)
      }
      is Parameters.Parameter.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 59, Hoisted.valueRatioSer, __d.value)
      }
      is Parameters.Parameter.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 60, Hoisted.valueReferenceSer, __d.value)
      }
      is Parameters.Parameter.Value.SampledData -> {
        encoder.encodeSerializableElement(__desc, 61, Hoisted.valueSampledDataSer, __d.value)
      }
      is Parameters.Parameter.Value.Signature -> {
        encoder.encodeSerializableElement(__desc, 62, Hoisted.valueSignatureSer, __d.value)
      }
      is Parameters.Parameter.Value.Timing -> {
        encoder.encodeSerializableElement(__desc, 63, Hoisted.valueTimingSer, __d.value)
      }
      is Parameters.Parameter.Value.ContactDetail -> {
        encoder.encodeSerializableElement(__desc, 64, Hoisted.valueContactDetailSer, __d.value)
      }
      is Parameters.Parameter.Value.Contributor -> {
        encoder.encodeSerializableElement(__desc, 65, Hoisted.valueContributorSer, __d.value)
      }
      is Parameters.Parameter.Value.DataRequirement -> {
        encoder.encodeSerializableElement(__desc, 66, Hoisted.valueDataRequirementSer, __d.value)
      }
      is Parameters.Parameter.Value.Expression -> {
        encoder.encodeSerializableElement(__desc, 67, Hoisted.valueExpressionSer, __d.value)
      }
      is Parameters.Parameter.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          68,
          Hoisted.valueParameterDefinitionSer,
          __d.value,
        )
      }
      is Parameters.Parameter.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(__desc, 69, Hoisted.valueRelatedArtifactSer, __d.value)
      }
      is Parameters.Parameter.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(__desc, 70, Hoisted.valueTriggerDefinitionSer, __d.value)
      }
      is Parameters.Parameter.Value.UsageContext -> {
        encoder.encodeSerializableElement(__desc, 71, Hoisted.valueUsageContextSer, __d.value)
      }
      is Parameters.Parameter.Value.Dosage -> {
        encoder.encodeSerializableElement(__desc, 72, Hoisted.valueDosageSer, __d.value)
      }
      is Parameters.Parameter.Value.Meta -> {
        encoder.encodeSerializableElement(__desc, 73, Hoisted.valueMetaSer, __d.value)
      }
    }
    (value.resource)?.let { encoder.encodeSerializableElement(__desc, 74, Hoisted.resourceSer, it) }
    if (value.part.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 75, Hoisted.partSer, value.part)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Parameters) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Parameters")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Parameters {
    val __desc = desc
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var parameter: List<Parameters.Parameter>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parameterSer, null)
        else -> throw SerializationException("Unexpected index decoding Parameters: " + __i)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Parameters,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.parameterSer, value.parameter)
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
      ParametersSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Parameters =
    decoder.decodeStructure(descriptor) {
      ParametersSerializer.deserializeJson(this, descriptor, 0)
    }
}
