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
import dev.ohs.fhir.model.r5.Enumeration
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
import dev.ohs.fhir.model.r5.Narrative
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
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.SampledData
import dev.ohs.fhir.model.r5.Signature
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Task
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

internal object TaskPerformerSerializer : KSerializer<Task.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Task.Performer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Task.Performer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var function: CodeableConcept? = null
      var actor: Reference? = null
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
          3 ->
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Performer: " + i)
        }
      }
      Task.Performer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        function = function,
        actor =
          actor
            ?: throw SerializationException("Missing required property 'actor' on Task.Performer"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Task.Performer) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.function)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object TaskRestrictionSerializer : KSerializer<Task.Restriction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Restriction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("repetitions", Int.serializer().descriptor)
      optionalElement("_repetitions", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("recipient", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Task.Restriction>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Task.Restriction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var repetitions: Int? = null
      var _repetitions: Element? = null
      var period: Period? = null
      var recipient: List<Reference>? = null
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
          3 -> repetitions = decodeIntElement(descriptor, i)
          4 ->
            _repetitions = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          6 ->
            recipient =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Restriction: " + i)
        }
      }
      Task.Restriction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        repetitions = PositiveInt.of(repetitions, _repetitions),
        period = period,
        recipient = recipient ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Task.Restriction) {
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
      encodeIntIfNotNull(descriptor, 3, value.repetitions?.value)
      encodeElementIfNotNull(descriptor, 4, value.repetitions)
      encodeSerializableIfNotNull(descriptor, 5, PeriodSerializer, value.period)
      if (value.recipient.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ReferenceSerializer.listSerializer,
          value.recipient,
        )
    }
  }
}

internal object TaskInputSerializer : KSerializer<Task.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
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
    }

  internal val listSerializer: KSerializer<List<Task.Input>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Task.Input =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> valueBase64Binary = decodeStringElement(descriptor, i)
          5 ->
            _valueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> valueBoolean = decodeBooleanElement(descriptor, i)
          7 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueCanonical = decodeStringElement(descriptor, i)
          9 ->
            _valueCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueCode = decodeStringElement(descriptor, i)
          11 ->
            _valueCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueDate = decodeStringElement(descriptor, i)
          13 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> valueDateTime = decodeStringElement(descriptor, i)
          15 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          17 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 -> valueId = decodeStringElement(descriptor, i)
          19 -> _valueId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          20 -> valueInstant = decodeStringElement(descriptor, i)
          21 ->
            _valueInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          22 -> valueInteger = decodeIntElement(descriptor, i)
          23 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 -> valueInteger64 = decodeStringElement(descriptor, i)
          25 ->
            _valueInteger64 =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          26 -> valueMarkdown = decodeStringElement(descriptor, i)
          27 ->
            _valueMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          28 -> valueOid = decodeStringElement(descriptor, i)
          29 ->
            _valueOid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          30 -> valuePositiveInt = decodeIntElement(descriptor, i)
          31 ->
            _valuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          32 -> valueString = decodeStringElement(descriptor, i)
          33 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          34 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          35 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          36 -> valueUnsignedInt = decodeIntElement(descriptor, i)
          37 ->
            _valueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          38 -> valueUri = decodeStringElement(descriptor, i)
          39 ->
            _valueUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          40 -> valueUrl = decodeStringElement(descriptor, i)
          41 ->
            _valueUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          42 -> valueUuid = decodeStringElement(descriptor, i)
          43 ->
            _valueUuid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          44 ->
            valueAddress = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          45 -> valueAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          46 ->
            valueAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          47 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          48 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          49 ->
            valueCodeableReference =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          50 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          51 ->
            valueContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          52 -> valueCount = decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          53 ->
            valueDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          54 ->
            valueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          55 ->
            valueHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          56 ->
            valueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          57 -> valueMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          58 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          59 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          60 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          61 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          62 ->
            valueRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          63 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          64 ->
            valueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          65 ->
            valueSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          66 ->
            valueTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          67 ->
            valueContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          68 ->
            valueDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          69 ->
            valueExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          70 ->
            valueParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          71 ->
            valueRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          72 ->
            valueTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          73 ->
            valueUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          74 ->
            valueAvailability =
              decodeNullableSerializableElement(descriptor, i, AvailabilitySerializer, null)
          75 ->
            valueExtendedContactDetail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtendedContactDetailSerializer,
                null,
              )
          76 ->
            valueDosage = decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          77 -> valueMeta = decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Input: " + i)
        }
      }
      Task.Input(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type ?: throw SerializationException("Missing required property 'type' on Task.Input"),
        `value` =
          Task.Input.Value.from(
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
          ) ?: throw SerializationException("Missing required property 'value' on Task.Input"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Task.Input) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        is Task.Input.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is Task.Input.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is Task.Input.Value.Canonical -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is Task.Input.Value.Code -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is Task.Input.Value.Date -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is Task.Input.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is Task.Input.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 16, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 17, choice.value)
        }
        is Task.Input.Value.Id -> {
          encodeStringIfNotNull(descriptor, 18, choice.value.value)
          encodeElementIfNotNull(descriptor, 19, choice.value)
        }
        is Task.Input.Value.Instant -> {
          encodeStringIfNotNull(descriptor, 20, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 21, choice.value)
        }
        is Task.Input.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 22, choice.value.value)
          encodeElementIfNotNull(descriptor, 23, choice.value)
        }
        is Task.Input.Value.Integer64 -> {
          encodeStringIfNotNull(descriptor, 24, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 25, choice.value)
        }
        is Task.Input.Value.Markdown -> {
          encodeStringIfNotNull(descriptor, 26, choice.value.value)
          encodeElementIfNotNull(descriptor, 27, choice.value)
        }
        is Task.Input.Value.Oid -> {
          encodeStringIfNotNull(descriptor, 28, choice.value.value)
          encodeElementIfNotNull(descriptor, 29, choice.value)
        }
        is Task.Input.Value.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 30, choice.value.value)
          encodeElementIfNotNull(descriptor, 31, choice.value)
        }
        is Task.Input.Value.String -> {
          encodeStringIfNotNull(descriptor, 32, choice.value.value)
          encodeElementIfNotNull(descriptor, 33, choice.value)
        }
        is Task.Input.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 34, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 35, choice.value)
        }
        is Task.Input.Value.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 36, choice.value.value)
          encodeElementIfNotNull(descriptor, 37, choice.value)
        }
        is Task.Input.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 38, choice.value.value)
          encodeElementIfNotNull(descriptor, 39, choice.value)
        }
        is Task.Input.Value.Url -> {
          encodeStringIfNotNull(descriptor, 40, choice.value.value)
          encodeElementIfNotNull(descriptor, 41, choice.value)
        }
        is Task.Input.Value.Uuid -> {
          encodeStringIfNotNull(descriptor, 42, choice.value.value)
          encodeElementIfNotNull(descriptor, 43, choice.value)
        }
        is Task.Input.Value.Address -> {
          encodeSerializableElement(descriptor, 44, AddressSerializer, choice.value)
        }
        is Task.Input.Value.Age -> {
          encodeSerializableElement(descriptor, 45, AgeSerializer, choice.value)
        }
        is Task.Input.Value.Annotation -> {
          encodeSerializableElement(descriptor, 46, AnnotationSerializer, choice.value)
        }
        is Task.Input.Value.Attachment -> {
          encodeSerializableElement(descriptor, 47, AttachmentSerializer, choice.value)
        }
        is Task.Input.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 48, CodeableConceptSerializer, choice.value)
        }
        is Task.Input.Value.CodeableReference -> {
          encodeSerializableElement(descriptor, 49, CodeableReferenceSerializer, choice.value)
        }
        is Task.Input.Value.Coding -> {
          encodeSerializableElement(descriptor, 50, CodingSerializer, choice.value)
        }
        is Task.Input.Value.ContactPoint -> {
          encodeSerializableElement(descriptor, 51, ContactPointSerializer, choice.value)
        }
        is Task.Input.Value.Count -> {
          encodeSerializableElement(descriptor, 52, CountSerializer, choice.value)
        }
        is Task.Input.Value.Distance -> {
          encodeSerializableElement(descriptor, 53, DistanceSerializer, choice.value)
        }
        is Task.Input.Value.Duration -> {
          encodeSerializableElement(descriptor, 54, DurationSerializer, choice.value)
        }
        is Task.Input.Value.HumanName -> {
          encodeSerializableElement(descriptor, 55, HumanNameSerializer, choice.value)
        }
        is Task.Input.Value.Identifier -> {
          encodeSerializableElement(descriptor, 56, IdentifierSerializer, choice.value)
        }
        is Task.Input.Value.Money -> {
          encodeSerializableElement(descriptor, 57, MoneySerializer, choice.value)
        }
        is Task.Input.Value.Period -> {
          encodeSerializableElement(descriptor, 58, PeriodSerializer, choice.value)
        }
        is Task.Input.Value.Quantity -> {
          encodeSerializableElement(descriptor, 59, QuantitySerializer, choice.value)
        }
        is Task.Input.Value.Range -> {
          encodeSerializableElement(descriptor, 60, RangeSerializer, choice.value)
        }
        is Task.Input.Value.Ratio -> {
          encodeSerializableElement(descriptor, 61, RatioSerializer, choice.value)
        }
        is Task.Input.Value.RatioRange -> {
          encodeSerializableElement(descriptor, 62, RatioRangeSerializer, choice.value)
        }
        is Task.Input.Value.Reference -> {
          encodeSerializableElement(descriptor, 63, ReferenceSerializer, choice.value)
        }
        is Task.Input.Value.SampledData -> {
          encodeSerializableElement(descriptor, 64, SampledDataSerializer, choice.value)
        }
        is Task.Input.Value.Signature -> {
          encodeSerializableElement(descriptor, 65, SignatureSerializer, choice.value)
        }
        is Task.Input.Value.Timing -> {
          encodeSerializableElement(descriptor, 66, TimingSerializer, choice.value)
        }
        is Task.Input.Value.ContactDetail -> {
          encodeSerializableElement(descriptor, 67, ContactDetailSerializer, choice.value)
        }
        is Task.Input.Value.DataRequirement -> {
          encodeSerializableElement(descriptor, 68, DataRequirementSerializer, choice.value)
        }
        is Task.Input.Value.Expression -> {
          encodeSerializableElement(descriptor, 69, ExpressionSerializer, choice.value)
        }
        is Task.Input.Value.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 70, ParameterDefinitionSerializer, choice.value)
        }
        is Task.Input.Value.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 71, RelatedArtifactSerializer, choice.value)
        }
        is Task.Input.Value.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 72, TriggerDefinitionSerializer, choice.value)
        }
        is Task.Input.Value.UsageContext -> {
          encodeSerializableElement(descriptor, 73, UsageContextSerializer, choice.value)
        }
        is Task.Input.Value.Availability -> {
          encodeSerializableElement(descriptor, 74, AvailabilitySerializer, choice.value)
        }
        is Task.Input.Value.ExtendedContactDetail -> {
          encodeSerializableElement(descriptor, 75, ExtendedContactDetailSerializer, choice.value)
        }
        is Task.Input.Value.Dosage -> {
          encodeSerializableElement(descriptor, 76, DosageSerializer, choice.value)
        }
        is Task.Input.Value.Meta -> {
          encodeSerializableElement(descriptor, 77, MetaSerializer, choice.value)
        }
      }
    }
  }
}

internal object TaskOutputSerializer : KSerializer<Task.Output> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Output") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
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
    }

  internal val listSerializer: KSerializer<List<Task.Output>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Task.Output =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> valueBase64Binary = decodeStringElement(descriptor, i)
          5 ->
            _valueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> valueBoolean = decodeBooleanElement(descriptor, i)
          7 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueCanonical = decodeStringElement(descriptor, i)
          9 ->
            _valueCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueCode = decodeStringElement(descriptor, i)
          11 ->
            _valueCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueDate = decodeStringElement(descriptor, i)
          13 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> valueDateTime = decodeStringElement(descriptor, i)
          15 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          17 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 -> valueId = decodeStringElement(descriptor, i)
          19 -> _valueId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          20 -> valueInstant = decodeStringElement(descriptor, i)
          21 ->
            _valueInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          22 -> valueInteger = decodeIntElement(descriptor, i)
          23 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 -> valueInteger64 = decodeStringElement(descriptor, i)
          25 ->
            _valueInteger64 =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          26 -> valueMarkdown = decodeStringElement(descriptor, i)
          27 ->
            _valueMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          28 -> valueOid = decodeStringElement(descriptor, i)
          29 ->
            _valueOid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          30 -> valuePositiveInt = decodeIntElement(descriptor, i)
          31 ->
            _valuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          32 -> valueString = decodeStringElement(descriptor, i)
          33 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          34 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          35 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          36 -> valueUnsignedInt = decodeIntElement(descriptor, i)
          37 ->
            _valueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          38 -> valueUri = decodeStringElement(descriptor, i)
          39 ->
            _valueUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          40 -> valueUrl = decodeStringElement(descriptor, i)
          41 ->
            _valueUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          42 -> valueUuid = decodeStringElement(descriptor, i)
          43 ->
            _valueUuid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          44 ->
            valueAddress = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          45 -> valueAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          46 ->
            valueAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          47 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          48 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          49 ->
            valueCodeableReference =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          50 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          51 ->
            valueContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          52 -> valueCount = decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          53 ->
            valueDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          54 ->
            valueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          55 ->
            valueHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          56 ->
            valueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          57 -> valueMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          58 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          59 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          60 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          61 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          62 ->
            valueRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          63 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          64 ->
            valueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          65 ->
            valueSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          66 ->
            valueTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          67 ->
            valueContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          68 ->
            valueDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          69 ->
            valueExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          70 ->
            valueParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          71 ->
            valueRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          72 ->
            valueTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          73 ->
            valueUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          74 ->
            valueAvailability =
              decodeNullableSerializableElement(descriptor, i, AvailabilitySerializer, null)
          75 ->
            valueExtendedContactDetail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtendedContactDetailSerializer,
                null,
              )
          76 ->
            valueDosage = decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          77 -> valueMeta = decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Output: " + i)
        }
      }
      Task.Output(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type ?: throw SerializationException("Missing required property 'type' on Task.Output"),
        `value` =
          Task.Output.Value.from(
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
          ) ?: throw SerializationException("Missing required property 'value' on Task.Output"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Task.Output) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        is Task.Output.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is Task.Output.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is Task.Output.Value.Canonical -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is Task.Output.Value.Code -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is Task.Output.Value.Date -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is Task.Output.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is Task.Output.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 16, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 17, choice.value)
        }
        is Task.Output.Value.Id -> {
          encodeStringIfNotNull(descriptor, 18, choice.value.value)
          encodeElementIfNotNull(descriptor, 19, choice.value)
        }
        is Task.Output.Value.Instant -> {
          encodeStringIfNotNull(descriptor, 20, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 21, choice.value)
        }
        is Task.Output.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 22, choice.value.value)
          encodeElementIfNotNull(descriptor, 23, choice.value)
        }
        is Task.Output.Value.Integer64 -> {
          encodeStringIfNotNull(descriptor, 24, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 25, choice.value)
        }
        is Task.Output.Value.Markdown -> {
          encodeStringIfNotNull(descriptor, 26, choice.value.value)
          encodeElementIfNotNull(descriptor, 27, choice.value)
        }
        is Task.Output.Value.Oid -> {
          encodeStringIfNotNull(descriptor, 28, choice.value.value)
          encodeElementIfNotNull(descriptor, 29, choice.value)
        }
        is Task.Output.Value.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 30, choice.value.value)
          encodeElementIfNotNull(descriptor, 31, choice.value)
        }
        is Task.Output.Value.String -> {
          encodeStringIfNotNull(descriptor, 32, choice.value.value)
          encodeElementIfNotNull(descriptor, 33, choice.value)
        }
        is Task.Output.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 34, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 35, choice.value)
        }
        is Task.Output.Value.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 36, choice.value.value)
          encodeElementIfNotNull(descriptor, 37, choice.value)
        }
        is Task.Output.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 38, choice.value.value)
          encodeElementIfNotNull(descriptor, 39, choice.value)
        }
        is Task.Output.Value.Url -> {
          encodeStringIfNotNull(descriptor, 40, choice.value.value)
          encodeElementIfNotNull(descriptor, 41, choice.value)
        }
        is Task.Output.Value.Uuid -> {
          encodeStringIfNotNull(descriptor, 42, choice.value.value)
          encodeElementIfNotNull(descriptor, 43, choice.value)
        }
        is Task.Output.Value.Address -> {
          encodeSerializableElement(descriptor, 44, AddressSerializer, choice.value)
        }
        is Task.Output.Value.Age -> {
          encodeSerializableElement(descriptor, 45, AgeSerializer, choice.value)
        }
        is Task.Output.Value.Annotation -> {
          encodeSerializableElement(descriptor, 46, AnnotationSerializer, choice.value)
        }
        is Task.Output.Value.Attachment -> {
          encodeSerializableElement(descriptor, 47, AttachmentSerializer, choice.value)
        }
        is Task.Output.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 48, CodeableConceptSerializer, choice.value)
        }
        is Task.Output.Value.CodeableReference -> {
          encodeSerializableElement(descriptor, 49, CodeableReferenceSerializer, choice.value)
        }
        is Task.Output.Value.Coding -> {
          encodeSerializableElement(descriptor, 50, CodingSerializer, choice.value)
        }
        is Task.Output.Value.ContactPoint -> {
          encodeSerializableElement(descriptor, 51, ContactPointSerializer, choice.value)
        }
        is Task.Output.Value.Count -> {
          encodeSerializableElement(descriptor, 52, CountSerializer, choice.value)
        }
        is Task.Output.Value.Distance -> {
          encodeSerializableElement(descriptor, 53, DistanceSerializer, choice.value)
        }
        is Task.Output.Value.Duration -> {
          encodeSerializableElement(descriptor, 54, DurationSerializer, choice.value)
        }
        is Task.Output.Value.HumanName -> {
          encodeSerializableElement(descriptor, 55, HumanNameSerializer, choice.value)
        }
        is Task.Output.Value.Identifier -> {
          encodeSerializableElement(descriptor, 56, IdentifierSerializer, choice.value)
        }
        is Task.Output.Value.Money -> {
          encodeSerializableElement(descriptor, 57, MoneySerializer, choice.value)
        }
        is Task.Output.Value.Period -> {
          encodeSerializableElement(descriptor, 58, PeriodSerializer, choice.value)
        }
        is Task.Output.Value.Quantity -> {
          encodeSerializableElement(descriptor, 59, QuantitySerializer, choice.value)
        }
        is Task.Output.Value.Range -> {
          encodeSerializableElement(descriptor, 60, RangeSerializer, choice.value)
        }
        is Task.Output.Value.Ratio -> {
          encodeSerializableElement(descriptor, 61, RatioSerializer, choice.value)
        }
        is Task.Output.Value.RatioRange -> {
          encodeSerializableElement(descriptor, 62, RatioRangeSerializer, choice.value)
        }
        is Task.Output.Value.Reference -> {
          encodeSerializableElement(descriptor, 63, ReferenceSerializer, choice.value)
        }
        is Task.Output.Value.SampledData -> {
          encodeSerializableElement(descriptor, 64, SampledDataSerializer, choice.value)
        }
        is Task.Output.Value.Signature -> {
          encodeSerializableElement(descriptor, 65, SignatureSerializer, choice.value)
        }
        is Task.Output.Value.Timing -> {
          encodeSerializableElement(descriptor, 66, TimingSerializer, choice.value)
        }
        is Task.Output.Value.ContactDetail -> {
          encodeSerializableElement(descriptor, 67, ContactDetailSerializer, choice.value)
        }
        is Task.Output.Value.DataRequirement -> {
          encodeSerializableElement(descriptor, 68, DataRequirementSerializer, choice.value)
        }
        is Task.Output.Value.Expression -> {
          encodeSerializableElement(descriptor, 69, ExpressionSerializer, choice.value)
        }
        is Task.Output.Value.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 70, ParameterDefinitionSerializer, choice.value)
        }
        is Task.Output.Value.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 71, RelatedArtifactSerializer, choice.value)
        }
        is Task.Output.Value.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 72, TriggerDefinitionSerializer, choice.value)
        }
        is Task.Output.Value.UsageContext -> {
          encodeSerializableElement(descriptor, 73, UsageContextSerializer, choice.value)
        }
        is Task.Output.Value.Availability -> {
          encodeSerializableElement(descriptor, 74, AvailabilitySerializer, choice.value)
        }
        is Task.Output.Value.ExtendedContactDetail -> {
          encodeSerializableElement(descriptor, 75, ExtendedContactDetailSerializer, choice.value)
        }
        is Task.Output.Value.Dosage -> {
          encodeSerializableElement(descriptor, 76, DosageSerializer, choice.value)
        }
        is Task.Output.Value.Meta -> {
          encodeSerializableElement(descriptor, 77, MetaSerializer, choice.value)
        }
      }
    }
  }
}

internal object TaskSerializer : FhirResourceSerializer<Task> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Task")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", KotlinString.serializer().descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.descriptor)
    b.optionalElement("instantiatesUri", KotlinString.serializer().descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableReferenceSerializer.descriptor)
    b.optionalElement("businessStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("intent", KotlinString.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("priority", KotlinString.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_doNotPerform", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.descriptor)
    b.optionalElement("for", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("requestedPeriod", PeriodSerializer.descriptor)
    b.optionalElement("executionPeriod", PeriodSerializer.descriptor)
    b.optionalElement("authoredOn", KotlinString.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("lastModified", KotlinString.serializer().descriptor)
    b.optionalElement("_lastModified", ElementSerializer.descriptor)
    b.optionalElement("requester", ReferenceSerializer.descriptor)
    b.optionalElement("requestedPerformer", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("owner", ReferenceSerializer.descriptor)
    b.optionalElement("performer", TaskPerformerSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("insurance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("relevantHistory", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("restriction", TaskRestrictionSerializer.descriptor)
    b.optionalElement("input", TaskInputSerializer.listSerializer.descriptor)
    b.optionalElement("output", TaskOutputSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Task {
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var instantiatesCanonical: KotlinString? = null
    var _instantiatesCanonical: Element? = null
    var instantiatesUri: KotlinString? = null
    var _instantiatesUri: Element? = null
    var basedOn: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: CodeableReference? = null
    var businessStatus: CodeableConcept? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var code: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var focus: Reference? = null
    var `for`: Reference? = null
    var encounter: Reference? = null
    var requestedPeriod: Period? = null
    var executionPeriod: Period? = null
    var authoredOn: KotlinString? = null
    var _authoredOn: Element? = null
    var lastModified: KotlinString? = null
    var _lastModified: Element? = null
    var requester: Reference? = null
    var requestedPerformer: List<CodeableReference>? = null
    var owner: Reference? = null
    var performer: List<Task.Performer>? = null
    var location: Reference? = null
    var reason: List<CodeableReference>? = null
    var insurance: List<Reference>? = null
    var note: List<Annotation>? = null
    var relevantHistory: List<Reference>? = null
    var restriction: Task.Restriction? = null
    var input: List<Task.Input>? = null
    var output: List<Task.Output>? = null
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
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> instantiatesCanonical = decoder.decodeStringElement(descriptor, i)
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> instantiatesUri = decoder.decodeStringElement(descriptor, i)
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        17 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          statusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        21 ->
          businessStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        22 -> intent = decoder.decodeStringElement(descriptor, i)
        23 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> priority = decoder.decodeStringElement(descriptor, i)
        25 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        27 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        29 -> description = decoder.decodeStringElement(descriptor, i)
        30 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          focus =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        32 ->
          `for` =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        33 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        34 ->
          requestedPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        35 ->
          executionPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        36 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        37 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 -> lastModified = decoder.decodeStringElement(descriptor, i)
        39 ->
          _lastModified =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        41 ->
          requestedPerformer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        42 ->
          owner =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        43 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TaskPerformerSerializer.listSerializer,
              null,
            )
        44 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        45 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        46 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        47 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        48 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        49 ->
          restriction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TaskRestrictionSerializer,
              null,
            )
        50 ->
          input =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TaskInputSerializer.listSerializer,
              null,
            )
        51 ->
          output =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TaskOutputSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Task: " + i)
      }
    }
    return Task(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical = Canonical.of(instantiatesCanonical, _instantiatesCanonical),
      instantiatesUri = Uri.of(instantiatesUri, _instantiatesUri),
      basedOn = basedOn ?: listOf(),
      groupIdentifier = groupIdentifier,
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(if (status != null) Task.TaskStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Task"),
      statusReason = statusReason,
      businessStatus = businessStatus,
      intent =
        Enumeration.of(if (intent != null) Task.TaskIntent.fromCode(intent) else null, _intent)
          ?: throw SerializationException("Missing required property 'intent' on Task"),
      priority =
        Enumeration.of(
          if (priority != null) Task.RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      code = code,
      description = R5String.of(description, _description),
      focus = focus,
      `for` = `for`,
      encounter = encounter,
      requestedPeriod = requestedPeriod,
      executionPeriod = executionPeriod,
      authoredOn =
        DateTime.of(
          if (authoredOn != null) FhirDateTime.fromString(authoredOn) else null,
          _authoredOn,
        ),
      lastModified =
        DateTime.of(
          if (lastModified != null) FhirDateTime.fromString(lastModified) else null,
          _lastModified,
        ),
      requester = requester,
      requestedPerformer = requestedPerformer ?: listOf(),
      owner = owner,
      performer = performer ?: listOf(),
      location = location,
      reason = reason ?: listOf(),
      insurance = insurance ?: listOf(),
      note = note ?: listOf(),
      relevantHistory = relevantHistory ?: listOf(),
      restriction = restriction,
      input = input ?: listOf(),
      output = output ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Task,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.instantiatesCanonical?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.instantiatesCanonical)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.instantiatesUri?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.instantiatesUri)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      CodeableReferenceSerializer,
      value.statusReason,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      CodeableConceptSerializer,
      value.businessStatus,
    )
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.intent)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.priority)
    encoder.encodeBooleanIfNotNull(descriptor, 26 + descriptorOffset, value.doNotPerform?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.doNotPerform)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.description)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.focus,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.`for`,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      PeriodSerializer,
      value.requestedPeriod,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      PeriodSerializer,
      value.executionPeriod,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.authoredOn)
    encoder.encodeStringIfNotNull(
      descriptor,
      38 + descriptorOffset,
      value.lastModified?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.lastModified)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    if (value.requestedPerformer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.requestedPerformer,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        TaskPerformerSerializer.listSerializer,
        value.performer,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.insurance,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.relevantHistory,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      TaskRestrictionSerializer,
      value.restriction,
    )
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        TaskInputSerializer.listSerializer,
        value.input,
      )
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        TaskOutputSerializer.listSerializer,
        value.output,
      )
  }
}
