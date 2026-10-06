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
import dev.ohs.fhir.model.r4b.ElementDefinition
import dev.ohs.fhir.model.r4b.Enumeration
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
import dev.ohs.fhir.model.r4b.terminologies.BindingStrength
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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ElementDefinitionSlicingSerializer : KSerializer<ElementDefinition.Slicing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Slicing") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "discriminator",
        ElementDefinitionSlicingDiscriminatorSerializer.listSerializer.descriptor,
      )
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("ordered", KotlinBoolean.serializer().descriptor)
      optionalElement("_ordered", ElementSerializer.descriptor)
      optionalElement("rules", KotlinString.serializer().descriptor)
      optionalElement("_rules", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Slicing>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Slicing =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var discriminator: List<ElementDefinition.Slicing.Discriminator>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var ordered: KotlinBoolean? = null
      var _ordered: Element? = null
      var rules: KotlinString? = null
      var _rules: Element? = null
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
            discriminator =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionSlicingDiscriminatorSerializer.listSerializer,
                null,
              )
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> ordered = decodeBooleanElement(descriptor, i)
          6 -> _ordered = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> rules = decodeStringElement(descriptor, i)
          8 -> _rules = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Slicing: " + i)
        }
      }
      ElementDefinition.Slicing(
        id = id,
        extension = extension ?: listOf(),
        discriminator = discriminator ?: listOf(),
        description = R4bString.of(description, _description),
        ordered = R4bBoolean.of(ordered, _ordered),
        rules =
          Enumeration.of(
            if (rules != null) ElementDefinition.SlicingRules.fromCode(rules) else null,
            _rules,
          )
            ?: throw SerializationException(
              "Missing required property 'rules' on ElementDefinition.Slicing"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.discriminator.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ElementDefinitionSlicingDiscriminatorSerializer.listSerializer,
          value.discriminator,
        )
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeBooleanIfNotNull(descriptor, 5, value.ordered?.value)
      encodeElementIfNotNull(descriptor, 6, value.ordered)
      encodeStringIfNotNull(descriptor, 7, value.rules.value?.code)
      encodeElementIfNotNull(descriptor, 8, value.rules)
    }
  }
}

internal object ElementDefinitionSlicingDiscriminatorSerializer :
  KSerializer<ElementDefinition.Slicing.Discriminator> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Discriminator") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Slicing.Discriminator>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Slicing.Discriminator =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var path: KotlinString? = null
      var _path: Element? = null
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
          2 -> type = decodeStringElement(descriptor, i)
          3 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> path = decodeStringElement(descriptor, i)
          5 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Discriminator: " + i)
        }
      }
      ElementDefinition.Slicing.Discriminator(
        id = id,
        extension = extension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) ElementDefinition.DiscriminatorType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on ElementDefinition.Slicing.Discriminator"
            ),
        path =
          R4bString.of(path, _path)
            ?: throw SerializationException(
              "Missing required property 'path' on ElementDefinition.Slicing.Discriminator"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing.Discriminator) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.type)
      encodeStringIfNotNull(descriptor, 4, value.path.value)
      encodeElementIfNotNull(descriptor, 5, value.path)
    }
  }
}

internal object ElementDefinitionBaseSerializer : KSerializer<ElementDefinition.Base> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Base") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("min", Int.serializer().descriptor)
      optionalElement("_min", ElementSerializer.descriptor)
      optionalElement("max", KotlinString.serializer().descriptor)
      optionalElement("_max", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Base>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Base =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var path: KotlinString? = null
      var _path: Element? = null
      var min: Int? = null
      var _min: Element? = null
      var max: KotlinString? = null
      var _max: Element? = null
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
          2 -> path = decodeStringElement(descriptor, i)
          3 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> min = decodeIntElement(descriptor, i)
          5 -> _min = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> max = decodeStringElement(descriptor, i)
          7 -> _max = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Base: " + i)
        }
      }
      ElementDefinition.Base(
        id = id,
        extension = extension ?: listOf(),
        path =
          R4bString.of(path, _path)
            ?: throw SerializationException(
              "Missing required property 'path' on ElementDefinition.Base"
            ),
        min =
          UnsignedInt.of(min, _min)
            ?: throw SerializationException(
              "Missing required property 'min' on ElementDefinition.Base"
            ),
        max =
          R4bString.of(max, _max)
            ?: throw SerializationException(
              "Missing required property 'max' on ElementDefinition.Base"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Base) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.path.value)
      encodeElementIfNotNull(descriptor, 3, value.path)
      encodeIntIfNotNull(descriptor, 4, value.min.value)
      encodeElementIfNotNull(descriptor, 5, value.min)
      encodeStringIfNotNull(descriptor, 6, value.max.value)
      encodeElementIfNotNull(descriptor, 7, value.max)
    }
  }
}

internal object ElementDefinitionTypeSerializer : KSerializer<ElementDefinition.Type> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Type") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("profile", stringNullableListSerializer.descriptor)
      optionalElement("_profile", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("targetProfile", stringNullableListSerializer.descriptor)
      optionalElement("_targetProfile", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("aggregation", stringNullableListSerializer.descriptor)
      optionalElement("_aggregation", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("versioning", KotlinString.serializer().descriptor)
      optionalElement("_versioning", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Type>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Type =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var profile: List<KotlinString?>? = null
      var _profile: List<Element?>? = null
      var targetProfile: List<KotlinString?>? = null
      var _targetProfile: List<Element?>? = null
      var aggregation: List<KotlinString?>? = null
      var _aggregation: List<Element?>? = null
      var versioning: KotlinString? = null
      var _versioning: Element? = null
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
          2 -> code = decodeStringElement(descriptor, i)
          3 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 ->
            profile =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          5 ->
            _profile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          6 ->
            targetProfile =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          7 ->
            _targetProfile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          8 ->
            aggregation =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          9 ->
            _aggregation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          10 -> versioning = decodeStringElement(descriptor, i)
          11 ->
            _versioning = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Type: " + i)
        }
      }
      ElementDefinition.Type(
        id = id,
        extension = extension ?: listOf(),
        code =
          Uri.of(code, _code)
            ?: throw SerializationException(
              "Missing required property 'code' on ElementDefinition.Type"
            ),
        profile =
          (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { index ->
            Canonical.of(profile?.getOrNull(index), _profile?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'profile' on ElementDefinition.Type has neither a value nor an id/extension"
              )
          }),
        targetProfile =
          (kotlin.collections.List(maxOf(targetProfile?.size ?: 0, _targetProfile?.size ?: 0)) {
            index ->
            Canonical.of(targetProfile?.getOrNull(index), _targetProfile?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'targetProfile' on ElementDefinition.Type has neither a value nor an id/extension"
              )
          }),
        aggregation =
          (kotlin.collections.List(maxOf(aggregation?.size ?: 0, _aggregation?.size ?: 0)) { index
            ->
            Enumeration.of(
              aggregation?.getOrNull(index)?.let { ElementDefinition.AggregationMode.fromCode(it) },
              _aggregation?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'aggregation' on ElementDefinition.Type has neither a value nor an id/extension"
              )
          }),
        versioning =
          Enumeration.of(
            if (versioning != null) ElementDefinition.ReferenceVersionRules.fromCode(versioning)
            else null,
            _versioning,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Type) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.code.value)
      encodeElementIfNotNull(descriptor, 3, value.code)
      if (value.profile.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          4,
          stringNullableListSerializer,
          value.profile.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 5, value.profile)
      }
      if (value.targetProfile.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          6,
          stringNullableListSerializer,
          value.targetProfile.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 7, value.targetProfile)
      }
      if (value.aggregation.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          8,
          stringNullableListSerializer,
          value.aggregation.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 9, value.aggregation)
      }
      encodeStringIfNotNull(descriptor, 10, value.versioning?.value?.code)
      encodeElementIfNotNull(descriptor, 11, value.versioning)
    }
  }
}

internal object ElementDefinitionExampleSerializer : KSerializer<ElementDefinition.Example> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Example") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("label", KotlinString.serializer().descriptor)
      optionalElement("_label", ElementSerializer.descriptor)
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
      optionalElement("valueContributor", ContributorSerializer.descriptor)
      optionalElement("valueDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("valueExpression", ExpressionSerializer.descriptor)
      optionalElement("valueParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("valueRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("valueTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("valueUsageContext", UsageContextSerializer.descriptor)
      optionalElement("valueDosage", DosageSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Example>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Example =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var label: KotlinString? = null
      var _label: Element? = null
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
          2 -> label = decodeStringElement(descriptor, i)
          3 -> _label = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
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
          24 -> valueMarkdown = decodeStringElement(descriptor, i)
          25 ->
            _valueMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          26 -> valueOid = decodeStringElement(descriptor, i)
          27 ->
            _valueOid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          28 -> valuePositiveInt = decodeIntElement(descriptor, i)
          29 ->
            _valuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          30 -> valueString = decodeStringElement(descriptor, i)
          31 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          32 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          33 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          34 -> valueUnsignedInt = decodeIntElement(descriptor, i)
          35 ->
            _valueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          36 -> valueUri = decodeStringElement(descriptor, i)
          37 ->
            _valueUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          38 -> valueUrl = decodeStringElement(descriptor, i)
          39 ->
            _valueUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          40 -> valueUuid = decodeStringElement(descriptor, i)
          41 ->
            _valueUuid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          42 ->
            valueAddress = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          43 -> valueAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          44 ->
            valueAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          45 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          46 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          47 ->
            valueCodeableReference =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          48 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          49 ->
            valueContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          50 -> valueCount = decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          51 ->
            valueDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          52 ->
            valueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          53 ->
            valueHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          54 ->
            valueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          55 -> valueMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          56 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          57 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          58 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          59 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          60 ->
            valueRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          61 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          62 ->
            valueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          63 ->
            valueSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          64 ->
            valueTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          65 ->
            valueContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          66 ->
            valueContributor =
              decodeNullableSerializableElement(descriptor, i, ContributorSerializer, null)
          67 ->
            valueDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          68 ->
            valueExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          69 ->
            valueParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          70 ->
            valueRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          71 ->
            valueTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          72 ->
            valueUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          73 ->
            valueDosage = decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Example: " + i)
        }
      }
      ElementDefinition.Example(
        id = id,
        extension = extension ?: listOf(),
        label =
          R4bString.of(label, _label)
            ?: throw SerializationException(
              "Missing required property 'label' on ElementDefinition.Example"
            ),
        `value` =
          ElementDefinition.Example.Value.from(
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
          )
            ?: throw SerializationException(
              "Missing required property 'value' on ElementDefinition.Example"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Example) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.label.value)
      encodeElementIfNotNull(descriptor, 3, value.label)
      when (val choice = value.`value`) {
        is ElementDefinition.Example.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is ElementDefinition.Example.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is ElementDefinition.Example.Value.Canonical -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is ElementDefinition.Example.Value.Code -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is ElementDefinition.Example.Value.Date -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is ElementDefinition.Example.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is ElementDefinition.Example.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 16, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 17, choice.value)
        }
        is ElementDefinition.Example.Value.Id -> {
          encodeStringIfNotNull(descriptor, 18, choice.value.value)
          encodeElementIfNotNull(descriptor, 19, choice.value)
        }
        is ElementDefinition.Example.Value.Instant -> {
          encodeStringIfNotNull(descriptor, 20, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 21, choice.value)
        }
        is ElementDefinition.Example.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 22, choice.value.value)
          encodeElementIfNotNull(descriptor, 23, choice.value)
        }
        is ElementDefinition.Example.Value.Markdown -> {
          encodeStringIfNotNull(descriptor, 24, choice.value.value)
          encodeElementIfNotNull(descriptor, 25, choice.value)
        }
        is ElementDefinition.Example.Value.Oid -> {
          encodeStringIfNotNull(descriptor, 26, choice.value.value)
          encodeElementIfNotNull(descriptor, 27, choice.value)
        }
        is ElementDefinition.Example.Value.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 28, choice.value.value)
          encodeElementIfNotNull(descriptor, 29, choice.value)
        }
        is ElementDefinition.Example.Value.String -> {
          encodeStringIfNotNull(descriptor, 30, choice.value.value)
          encodeElementIfNotNull(descriptor, 31, choice.value)
        }
        is ElementDefinition.Example.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 32, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 33, choice.value)
        }
        is ElementDefinition.Example.Value.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 34, choice.value.value)
          encodeElementIfNotNull(descriptor, 35, choice.value)
        }
        is ElementDefinition.Example.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 36, choice.value.value)
          encodeElementIfNotNull(descriptor, 37, choice.value)
        }
        is ElementDefinition.Example.Value.Url -> {
          encodeStringIfNotNull(descriptor, 38, choice.value.value)
          encodeElementIfNotNull(descriptor, 39, choice.value)
        }
        is ElementDefinition.Example.Value.Uuid -> {
          encodeStringIfNotNull(descriptor, 40, choice.value.value)
          encodeElementIfNotNull(descriptor, 41, choice.value)
        }
        is ElementDefinition.Example.Value.Address -> {
          encodeSerializableElement(descriptor, 42, AddressSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Age -> {
          encodeSerializableElement(descriptor, 43, AgeSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Annotation -> {
          encodeSerializableElement(descriptor, 44, AnnotationSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Attachment -> {
          encodeSerializableElement(descriptor, 45, AttachmentSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 46, CodeableConceptSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.CodeableReference -> {
          encodeSerializableElement(descriptor, 47, CodeableReferenceSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Coding -> {
          encodeSerializableElement(descriptor, 48, CodingSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.ContactPoint -> {
          encodeSerializableElement(descriptor, 49, ContactPointSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Count -> {
          encodeSerializableElement(descriptor, 50, CountSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Distance -> {
          encodeSerializableElement(descriptor, 51, DistanceSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Duration -> {
          encodeSerializableElement(descriptor, 52, DurationSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.HumanName -> {
          encodeSerializableElement(descriptor, 53, HumanNameSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Identifier -> {
          encodeSerializableElement(descriptor, 54, IdentifierSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Money -> {
          encodeSerializableElement(descriptor, 55, MoneySerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Period -> {
          encodeSerializableElement(descriptor, 56, PeriodSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Quantity -> {
          encodeSerializableElement(descriptor, 57, QuantitySerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Range -> {
          encodeSerializableElement(descriptor, 58, RangeSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Ratio -> {
          encodeSerializableElement(descriptor, 59, RatioSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.RatioRange -> {
          encodeSerializableElement(descriptor, 60, RatioRangeSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Reference -> {
          encodeSerializableElement(descriptor, 61, ReferenceSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.SampledData -> {
          encodeSerializableElement(descriptor, 62, SampledDataSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Signature -> {
          encodeSerializableElement(descriptor, 63, SignatureSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Timing -> {
          encodeSerializableElement(descriptor, 64, TimingSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.ContactDetail -> {
          encodeSerializableElement(descriptor, 65, ContactDetailSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Contributor -> {
          encodeSerializableElement(descriptor, 66, ContributorSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.DataRequirement -> {
          encodeSerializableElement(descriptor, 67, DataRequirementSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Expression -> {
          encodeSerializableElement(descriptor, 68, ExpressionSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 69, ParameterDefinitionSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 70, RelatedArtifactSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 71, TriggerDefinitionSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.UsageContext -> {
          encodeSerializableElement(descriptor, 72, UsageContextSerializer, choice.value)
        }
        is ElementDefinition.Example.Value.Dosage -> {
          encodeSerializableElement(descriptor, 73, DosageSerializer, choice.value)
        }
      }
    }
  }
}

internal object ElementDefinitionConstraintSerializer : KSerializer<ElementDefinition.Constraint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Constraint") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("key", KotlinString.serializer().descriptor)
      optionalElement("_key", ElementSerializer.descriptor)
      optionalElement("requirements", KotlinString.serializer().descriptor)
      optionalElement("_requirements", ElementSerializer.descriptor)
      optionalElement("severity", KotlinString.serializer().descriptor)
      optionalElement("_severity", ElementSerializer.descriptor)
      optionalElement("human", KotlinString.serializer().descriptor)
      optionalElement("_human", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
      optionalElement("xpath", KotlinString.serializer().descriptor)
      optionalElement("_xpath", ElementSerializer.descriptor)
      optionalElement("source", KotlinString.serializer().descriptor)
      optionalElement("_source", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Constraint>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Constraint =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var key: KotlinString? = null
      var _key: Element? = null
      var requirements: KotlinString? = null
      var _requirements: Element? = null
      var severity: KotlinString? = null
      var _severity: Element? = null
      var human: KotlinString? = null
      var _human: Element? = null
      var expression: KotlinString? = null
      var _expression: Element? = null
      var xpath: KotlinString? = null
      var _xpath: Element? = null
      var source: KotlinString? = null
      var _source: Element? = null
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
          2 -> key = decodeStringElement(descriptor, i)
          3 -> _key = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> requirements = decodeStringElement(descriptor, i)
          5 ->
            _requirements =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> severity = decodeStringElement(descriptor, i)
          7 -> _severity = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> human = decodeStringElement(descriptor, i)
          9 -> _human = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> expression = decodeStringElement(descriptor, i)
          11 ->
            _expression = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> xpath = decodeStringElement(descriptor, i)
          13 -> _xpath = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> source = decodeStringElement(descriptor, i)
          15 -> _source = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Constraint: " + i)
        }
      }
      ElementDefinition.Constraint(
        id = id,
        extension = extension ?: listOf(),
        key =
          Id.of(key, _key)
            ?: throw SerializationException(
              "Missing required property 'key' on ElementDefinition.Constraint"
            ),
        requirements = R4bString.of(requirements, _requirements),
        severity =
          Enumeration.of(
            if (severity != null) ElementDefinition.ConstraintSeverity.fromCode(severity) else null,
            _severity,
          )
            ?: throw SerializationException(
              "Missing required property 'severity' on ElementDefinition.Constraint"
            ),
        human =
          R4bString.of(human, _human)
            ?: throw SerializationException(
              "Missing required property 'human' on ElementDefinition.Constraint"
            ),
        expression = R4bString.of(expression, _expression),
        xpath = R4bString.of(xpath, _xpath),
        source = Canonical.of(source, _source),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Constraint) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.key.value)
      encodeElementIfNotNull(descriptor, 3, value.key)
      encodeStringIfNotNull(descriptor, 4, value.requirements?.value)
      encodeElementIfNotNull(descriptor, 5, value.requirements)
      encodeStringIfNotNull(descriptor, 6, value.severity.value?.code)
      encodeElementIfNotNull(descriptor, 7, value.severity)
      encodeStringIfNotNull(descriptor, 8, value.human.value)
      encodeElementIfNotNull(descriptor, 9, value.human)
      encodeStringIfNotNull(descriptor, 10, value.expression?.value)
      encodeElementIfNotNull(descriptor, 11, value.expression)
      encodeStringIfNotNull(descriptor, 12, value.xpath?.value)
      encodeElementIfNotNull(descriptor, 13, value.xpath)
      encodeStringIfNotNull(descriptor, 14, value.source?.value)
      encodeElementIfNotNull(descriptor, 15, value.source)
    }
  }
}

internal object ElementDefinitionBindingSerializer : KSerializer<ElementDefinition.Binding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Binding") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("strength", KotlinString.serializer().descriptor)
      optionalElement("_strength", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("valueSet", KotlinString.serializer().descriptor)
      optionalElement("_valueSet", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Binding>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Binding =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var strength: KotlinString? = null
      var _strength: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var valueSet: KotlinString? = null
      var _valueSet: Element? = null
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
          2 -> strength = decodeStringElement(descriptor, i)
          3 -> _strength = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> description = decodeStringElement(descriptor, i)
          5 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> valueSet = decodeStringElement(descriptor, i)
          7 -> _valueSet = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Binding: " + i)
        }
      }
      ElementDefinition.Binding(
        id = id,
        extension = extension ?: listOf(),
        strength =
          Enumeration.of(
            if (strength != null) BindingStrength.fromCode(strength) else null,
            _strength,
          )
            ?: throw SerializationException(
              "Missing required property 'strength' on ElementDefinition.Binding"
            ),
        description = R4bString.of(description, _description),
        valueSet = Canonical.of(valueSet, _valueSet),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Binding) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.strength.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.strength)
      encodeStringIfNotNull(descriptor, 4, value.description?.value)
      encodeElementIfNotNull(descriptor, 5, value.description)
      encodeStringIfNotNull(descriptor, 6, value.valueSet?.value)
      encodeElementIfNotNull(descriptor, 7, value.valueSet)
    }
  }
}

internal object ElementDefinitionMappingSerializer : KSerializer<ElementDefinition.Mapping> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Mapping") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identity", KotlinString.serializer().descriptor)
      optionalElement("_identity", ElementSerializer.descriptor)
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", ElementSerializer.descriptor)
      optionalElement("map", KotlinString.serializer().descriptor)
      optionalElement("_map", ElementSerializer.descriptor)
      optionalElement("comment", KotlinString.serializer().descriptor)
      optionalElement("_comment", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Mapping>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Mapping =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var identity: KotlinString? = null
      var _identity: Element? = null
      var language: KotlinString? = null
      var _language: Element? = null
      var map: KotlinString? = null
      var _map: Element? = null
      var comment: KotlinString? = null
      var _comment: Element? = null
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
          2 -> identity = decodeStringElement(descriptor, i)
          3 -> _identity = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> language = decodeStringElement(descriptor, i)
          5 -> _language = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> map = decodeStringElement(descriptor, i)
          7 -> _map = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> comment = decodeStringElement(descriptor, i)
          9 -> _comment = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Mapping: " + i)
        }
      }
      ElementDefinition.Mapping(
        id = id,
        extension = extension ?: listOf(),
        identity =
          Id.of(identity, _identity)
            ?: throw SerializationException(
              "Missing required property 'identity' on ElementDefinition.Mapping"
            ),
        language = Code.of(language, _language),
        map =
          R4bString.of(map, _map)
            ?: throw SerializationException(
              "Missing required property 'map' on ElementDefinition.Mapping"
            ),
        comment = R4bString.of(comment, _comment),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Mapping) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.identity.value)
      encodeElementIfNotNull(descriptor, 3, value.identity)
      encodeStringIfNotNull(descriptor, 4, value.language?.value)
      encodeElementIfNotNull(descriptor, 5, value.language)
      encodeStringIfNotNull(descriptor, 6, value.map.value)
      encodeElementIfNotNull(descriptor, 7, value.map)
      encodeStringIfNotNull(descriptor, 8, value.comment?.value)
      encodeElementIfNotNull(descriptor, 9, value.comment)
    }
  }
}

internal object ElementDefinitionSerializer : KSerializer<ElementDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ElementDefinition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("representation", stringNullableListSerializer.descriptor)
      optionalElement("_representation", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("sliceName", KotlinString.serializer().descriptor)
      optionalElement("_sliceName", ElementSerializer.descriptor)
      optionalElement("sliceIsConstraining", KotlinBoolean.serializer().descriptor)
      optionalElement("_sliceIsConstraining", ElementSerializer.descriptor)
      optionalElement("label", KotlinString.serializer().descriptor)
      optionalElement("_label", ElementSerializer.descriptor)
      optionalElement("code", CodingSerializer.listSerializer.descriptor)
      optionalElement("slicing", ElementDefinitionSlicingSerializer.descriptor)
      optionalElement("short", KotlinString.serializer().descriptor)
      optionalElement("_short", ElementSerializer.descriptor)
      optionalElement("definition", KotlinString.serializer().descriptor)
      optionalElement("_definition", ElementSerializer.descriptor)
      optionalElement("comment", KotlinString.serializer().descriptor)
      optionalElement("_comment", ElementSerializer.descriptor)
      optionalElement("requirements", KotlinString.serializer().descriptor)
      optionalElement("_requirements", ElementSerializer.descriptor)
      optionalElement("alias", stringNullableListSerializer.descriptor)
      optionalElement("_alias", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("min", Int.serializer().descriptor)
      optionalElement("_min", ElementSerializer.descriptor)
      optionalElement("max", KotlinString.serializer().descriptor)
      optionalElement("_max", ElementSerializer.descriptor)
      optionalElement("base", ElementDefinitionBaseSerializer.descriptor)
      optionalElement("contentReference", KotlinString.serializer().descriptor)
      optionalElement("_contentReference", ElementSerializer.descriptor)
      optionalElement("type", ElementDefinitionTypeSerializer.listSerializer.descriptor)
      optionalElement("defaultValueBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueBase64Binary", ElementSerializer.descriptor)
      optionalElement("defaultValueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_defaultValueBoolean", ElementSerializer.descriptor)
      optionalElement("defaultValueCanonical", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueCanonical", ElementSerializer.descriptor)
      optionalElement("defaultValueCode", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueCode", ElementSerializer.descriptor)
      optionalElement("defaultValueDate", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueDate", ElementSerializer.descriptor)
      optionalElement("defaultValueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueDateTime", ElementSerializer.descriptor)
      optionalElement("defaultValueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_defaultValueDecimal", ElementSerializer.descriptor)
      optionalElement("defaultValueId", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueId", ElementSerializer.descriptor)
      optionalElement("defaultValueInstant", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueInstant", ElementSerializer.descriptor)
      optionalElement("defaultValueInteger", Int.serializer().descriptor)
      optionalElement("_defaultValueInteger", ElementSerializer.descriptor)
      optionalElement("defaultValueMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueMarkdown", ElementSerializer.descriptor)
      optionalElement("defaultValueOid", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueOid", ElementSerializer.descriptor)
      optionalElement("defaultValuePositiveInt", Int.serializer().descriptor)
      optionalElement("_defaultValuePositiveInt", ElementSerializer.descriptor)
      optionalElement("defaultValueString", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueString", ElementSerializer.descriptor)
      optionalElement("defaultValueTime", LocalTimeSerializer.descriptor)
      optionalElement("_defaultValueTime", ElementSerializer.descriptor)
      optionalElement("defaultValueUnsignedInt", Int.serializer().descriptor)
      optionalElement("_defaultValueUnsignedInt", ElementSerializer.descriptor)
      optionalElement("defaultValueUri", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueUri", ElementSerializer.descriptor)
      optionalElement("defaultValueUrl", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueUrl", ElementSerializer.descriptor)
      optionalElement("defaultValueUuid", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueUuid", ElementSerializer.descriptor)
      optionalElement("defaultValueAddress", AddressSerializer.descriptor)
      optionalElement("defaultValueAge", AgeSerializer.descriptor)
      optionalElement("defaultValueAnnotation", AnnotationSerializer.descriptor)
      optionalElement("defaultValueAttachment", AttachmentSerializer.descriptor)
      optionalElement("defaultValueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("defaultValueCodeableReference", CodeableReferenceSerializer.descriptor)
      optionalElement("defaultValueCoding", CodingSerializer.descriptor)
      optionalElement("defaultValueContactPoint", ContactPointSerializer.descriptor)
      optionalElement("defaultValueCount", CountSerializer.descriptor)
      optionalElement("defaultValueDistance", DistanceSerializer.descriptor)
      optionalElement("defaultValueDuration", DurationSerializer.descriptor)
      optionalElement("defaultValueHumanName", HumanNameSerializer.descriptor)
      optionalElement("defaultValueIdentifier", IdentifierSerializer.descriptor)
      optionalElement("defaultValueMoney", MoneySerializer.descriptor)
      optionalElement("defaultValuePeriod", PeriodSerializer.descriptor)
      optionalElement("defaultValueQuantity", QuantitySerializer.descriptor)
      optionalElement("defaultValueRange", RangeSerializer.descriptor)
      optionalElement("defaultValueRatio", RatioSerializer.descriptor)
      optionalElement("defaultValueRatioRange", RatioRangeSerializer.descriptor)
      optionalElement("defaultValueReference", ReferenceSerializer.descriptor)
      optionalElement("defaultValueSampledData", SampledDataSerializer.descriptor)
      optionalElement("defaultValueSignature", SignatureSerializer.descriptor)
      optionalElement("defaultValueTiming", TimingSerializer.descriptor)
      optionalElement("defaultValueContactDetail", ContactDetailSerializer.descriptor)
      optionalElement("defaultValueContributor", ContributorSerializer.descriptor)
      optionalElement("defaultValueDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("defaultValueExpression", ExpressionSerializer.descriptor)
      optionalElement("defaultValueParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("defaultValueRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("defaultValueTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("defaultValueUsageContext", UsageContextSerializer.descriptor)
      optionalElement("defaultValueDosage", DosageSerializer.descriptor)
      optionalElement("meaningWhenMissing", KotlinString.serializer().descriptor)
      optionalElement("_meaningWhenMissing", ElementSerializer.descriptor)
      optionalElement("orderMeaning", KotlinString.serializer().descriptor)
      optionalElement("_orderMeaning", ElementSerializer.descriptor)
      optionalElement("fixedBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_fixedBase64Binary", ElementSerializer.descriptor)
      optionalElement("fixedBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_fixedBoolean", ElementSerializer.descriptor)
      optionalElement("fixedCanonical", KotlinString.serializer().descriptor)
      optionalElement("_fixedCanonical", ElementSerializer.descriptor)
      optionalElement("fixedCode", KotlinString.serializer().descriptor)
      optionalElement("_fixedCode", ElementSerializer.descriptor)
      optionalElement("fixedDate", KotlinString.serializer().descriptor)
      optionalElement("_fixedDate", ElementSerializer.descriptor)
      optionalElement("fixedDateTime", KotlinString.serializer().descriptor)
      optionalElement("_fixedDateTime", ElementSerializer.descriptor)
      optionalElement("fixedDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_fixedDecimal", ElementSerializer.descriptor)
      optionalElement("fixedId", KotlinString.serializer().descriptor)
      optionalElement("_fixedId", ElementSerializer.descriptor)
      optionalElement("fixedInstant", KotlinString.serializer().descriptor)
      optionalElement("_fixedInstant", ElementSerializer.descriptor)
      optionalElement("fixedInteger", Int.serializer().descriptor)
      optionalElement("_fixedInteger", ElementSerializer.descriptor)
      optionalElement("fixedMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_fixedMarkdown", ElementSerializer.descriptor)
      optionalElement("fixedOid", KotlinString.serializer().descriptor)
      optionalElement("_fixedOid", ElementSerializer.descriptor)
      optionalElement("fixedPositiveInt", Int.serializer().descriptor)
      optionalElement("_fixedPositiveInt", ElementSerializer.descriptor)
      optionalElement("fixedString", KotlinString.serializer().descriptor)
      optionalElement("_fixedString", ElementSerializer.descriptor)
      optionalElement("fixedTime", LocalTimeSerializer.descriptor)
      optionalElement("_fixedTime", ElementSerializer.descriptor)
      optionalElement("fixedUnsignedInt", Int.serializer().descriptor)
      optionalElement("_fixedUnsignedInt", ElementSerializer.descriptor)
      optionalElement("fixedUri", KotlinString.serializer().descriptor)
      optionalElement("_fixedUri", ElementSerializer.descriptor)
      optionalElement("fixedUrl", KotlinString.serializer().descriptor)
      optionalElement("_fixedUrl", ElementSerializer.descriptor)
      optionalElement("fixedUuid", KotlinString.serializer().descriptor)
      optionalElement("_fixedUuid", ElementSerializer.descriptor)
      optionalElement("fixedAddress", AddressSerializer.descriptor)
      optionalElement("fixedAge", AgeSerializer.descriptor)
      optionalElement("fixedAnnotation", AnnotationSerializer.descriptor)
      optionalElement("fixedAttachment", AttachmentSerializer.descriptor)
      optionalElement("fixedCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("fixedCodeableReference", CodeableReferenceSerializer.descriptor)
      optionalElement("fixedCoding", CodingSerializer.descriptor)
      optionalElement("fixedContactPoint", ContactPointSerializer.descriptor)
      optionalElement("fixedCount", CountSerializer.descriptor)
      optionalElement("fixedDistance", DistanceSerializer.descriptor)
      optionalElement("fixedDuration", DurationSerializer.descriptor)
      optionalElement("fixedHumanName", HumanNameSerializer.descriptor)
      optionalElement("fixedIdentifier", IdentifierSerializer.descriptor)
      optionalElement("fixedMoney", MoneySerializer.descriptor)
      optionalElement("fixedPeriod", PeriodSerializer.descriptor)
      optionalElement("fixedQuantity", QuantitySerializer.descriptor)
      optionalElement("fixedRange", RangeSerializer.descriptor)
      optionalElement("fixedRatio", RatioSerializer.descriptor)
      optionalElement("fixedRatioRange", RatioRangeSerializer.descriptor)
      optionalElement("fixedReference", ReferenceSerializer.descriptor)
      optionalElement("fixedSampledData", SampledDataSerializer.descriptor)
      optionalElement("fixedSignature", SignatureSerializer.descriptor)
      optionalElement("fixedTiming", TimingSerializer.descriptor)
      optionalElement("fixedContactDetail", ContactDetailSerializer.descriptor)
      optionalElement("fixedContributor", ContributorSerializer.descriptor)
      optionalElement("fixedDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("fixedExpression", ExpressionSerializer.descriptor)
      optionalElement("fixedParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("fixedRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("fixedTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("fixedUsageContext", UsageContextSerializer.descriptor)
      optionalElement("fixedDosage", DosageSerializer.descriptor)
      optionalElement("patternBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_patternBase64Binary", ElementSerializer.descriptor)
      optionalElement("patternBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_patternBoolean", ElementSerializer.descriptor)
      optionalElement("patternCanonical", KotlinString.serializer().descriptor)
      optionalElement("_patternCanonical", ElementSerializer.descriptor)
      optionalElement("patternCode", KotlinString.serializer().descriptor)
      optionalElement("_patternCode", ElementSerializer.descriptor)
      optionalElement("patternDate", KotlinString.serializer().descriptor)
      optionalElement("_patternDate", ElementSerializer.descriptor)
      optionalElement("patternDateTime", KotlinString.serializer().descriptor)
      optionalElement("_patternDateTime", ElementSerializer.descriptor)
      optionalElement("patternDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_patternDecimal", ElementSerializer.descriptor)
      optionalElement("patternId", KotlinString.serializer().descriptor)
      optionalElement("_patternId", ElementSerializer.descriptor)
      optionalElement("patternInstant", KotlinString.serializer().descriptor)
      optionalElement("_patternInstant", ElementSerializer.descriptor)
      optionalElement("patternInteger", Int.serializer().descriptor)
      optionalElement("_patternInteger", ElementSerializer.descriptor)
      optionalElement("patternMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_patternMarkdown", ElementSerializer.descriptor)
      optionalElement("patternOid", KotlinString.serializer().descriptor)
      optionalElement("_patternOid", ElementSerializer.descriptor)
      optionalElement("patternPositiveInt", Int.serializer().descriptor)
      optionalElement("_patternPositiveInt", ElementSerializer.descriptor)
      optionalElement("patternString", KotlinString.serializer().descriptor)
      optionalElement("_patternString", ElementSerializer.descriptor)
      optionalElement("patternTime", LocalTimeSerializer.descriptor)
      optionalElement("_patternTime", ElementSerializer.descriptor)
      optionalElement("patternUnsignedInt", Int.serializer().descriptor)
      optionalElement("_patternUnsignedInt", ElementSerializer.descriptor)
      optionalElement("patternUri", KotlinString.serializer().descriptor)
      optionalElement("_patternUri", ElementSerializer.descriptor)
      optionalElement("patternUrl", KotlinString.serializer().descriptor)
      optionalElement("_patternUrl", ElementSerializer.descriptor)
      optionalElement("patternUuid", KotlinString.serializer().descriptor)
      optionalElement("_patternUuid", ElementSerializer.descriptor)
      optionalElement("patternAddress", AddressSerializer.descriptor)
      optionalElement("patternAge", AgeSerializer.descriptor)
      optionalElement("patternAnnotation", AnnotationSerializer.descriptor)
      optionalElement("patternAttachment", AttachmentSerializer.descriptor)
      optionalElement("patternCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("patternCodeableReference", CodeableReferenceSerializer.descriptor)
      optionalElement("patternCoding", CodingSerializer.descriptor)
      optionalElement("patternContactPoint", ContactPointSerializer.descriptor)
      optionalElement("patternCount", CountSerializer.descriptor)
      optionalElement("patternDistance", DistanceSerializer.descriptor)
      optionalElement("patternDuration", DurationSerializer.descriptor)
      optionalElement("patternHumanName", HumanNameSerializer.descriptor)
      optionalElement("patternIdentifier", IdentifierSerializer.descriptor)
      optionalElement("patternMoney", MoneySerializer.descriptor)
      optionalElement("patternPeriod", PeriodSerializer.descriptor)
      optionalElement("patternQuantity", QuantitySerializer.descriptor)
      optionalElement("patternRange", RangeSerializer.descriptor)
      optionalElement("patternRatio", RatioSerializer.descriptor)
      optionalElement("patternRatioRange", RatioRangeSerializer.descriptor)
      optionalElement("patternReference", ReferenceSerializer.descriptor)
      optionalElement("patternSampledData", SampledDataSerializer.descriptor)
      optionalElement("patternSignature", SignatureSerializer.descriptor)
      optionalElement("patternTiming", TimingSerializer.descriptor)
      optionalElement("patternContactDetail", ContactDetailSerializer.descriptor)
      optionalElement("patternContributor", ContributorSerializer.descriptor)
      optionalElement("patternDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("patternExpression", ExpressionSerializer.descriptor)
      optionalElement("patternParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("patternRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("patternTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("patternUsageContext", UsageContextSerializer.descriptor)
      optionalElement("patternDosage", DosageSerializer.descriptor)
      optionalElement("example", ElementDefinitionExampleSerializer.listSerializer.descriptor)
      optionalElement("minValueDate", KotlinString.serializer().descriptor)
      optionalElement("_minValueDate", ElementSerializer.descriptor)
      optionalElement("minValueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_minValueDateTime", ElementSerializer.descriptor)
      optionalElement("minValueInstant", KotlinString.serializer().descriptor)
      optionalElement("_minValueInstant", ElementSerializer.descriptor)
      optionalElement("minValueTime", LocalTimeSerializer.descriptor)
      optionalElement("_minValueTime", ElementSerializer.descriptor)
      optionalElement("minValueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_minValueDecimal", ElementSerializer.descriptor)
      optionalElement("minValueInteger", Int.serializer().descriptor)
      optionalElement("_minValueInteger", ElementSerializer.descriptor)
      optionalElement("minValuePositiveInt", Int.serializer().descriptor)
      optionalElement("_minValuePositiveInt", ElementSerializer.descriptor)
      optionalElement("minValueUnsignedInt", Int.serializer().descriptor)
      optionalElement("_minValueUnsignedInt", ElementSerializer.descriptor)
      optionalElement("minValueQuantity", QuantitySerializer.descriptor)
      optionalElement("maxValueDate", KotlinString.serializer().descriptor)
      optionalElement("_maxValueDate", ElementSerializer.descriptor)
      optionalElement("maxValueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_maxValueDateTime", ElementSerializer.descriptor)
      optionalElement("maxValueInstant", KotlinString.serializer().descriptor)
      optionalElement("_maxValueInstant", ElementSerializer.descriptor)
      optionalElement("maxValueTime", LocalTimeSerializer.descriptor)
      optionalElement("_maxValueTime", ElementSerializer.descriptor)
      optionalElement("maxValueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_maxValueDecimal", ElementSerializer.descriptor)
      optionalElement("maxValueInteger", Int.serializer().descriptor)
      optionalElement("_maxValueInteger", ElementSerializer.descriptor)
      optionalElement("maxValuePositiveInt", Int.serializer().descriptor)
      optionalElement("_maxValuePositiveInt", ElementSerializer.descriptor)
      optionalElement("maxValueUnsignedInt", Int.serializer().descriptor)
      optionalElement("_maxValueUnsignedInt", ElementSerializer.descriptor)
      optionalElement("maxValueQuantity", QuantitySerializer.descriptor)
      optionalElement("maxLength", Int.serializer().descriptor)
      optionalElement("_maxLength", ElementSerializer.descriptor)
      optionalElement("condition", stringNullableListSerializer.descriptor)
      optionalElement("_condition", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("constraint", ElementDefinitionConstraintSerializer.listSerializer.descriptor)
      optionalElement("mustSupport", KotlinBoolean.serializer().descriptor)
      optionalElement("_mustSupport", ElementSerializer.descriptor)
      optionalElement("isModifier", KotlinBoolean.serializer().descriptor)
      optionalElement("_isModifier", ElementSerializer.descriptor)
      optionalElement("isModifierReason", KotlinString.serializer().descriptor)
      optionalElement("_isModifierReason", ElementSerializer.descriptor)
      optionalElement("isSummary", KotlinBoolean.serializer().descriptor)
      optionalElement("_isSummary", ElementSerializer.descriptor)
      optionalElement("binding", ElementDefinitionBindingSerializer.descriptor)
      optionalElement("mapping", ElementDefinitionMappingSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var path: KotlinString? = null
      var _path: Element? = null
      var representation: List<KotlinString?>? = null
      var _representation: List<Element?>? = null
      var sliceName: KotlinString? = null
      var _sliceName: Element? = null
      var sliceIsConstraining: KotlinBoolean? = null
      var _sliceIsConstraining: Element? = null
      var label: KotlinString? = null
      var _label: Element? = null
      var code: List<Coding>? = null
      var slicing: ElementDefinition.Slicing? = null
      var short: KotlinString? = null
      var _short: Element? = null
      var definition: KotlinString? = null
      var _definition: Element? = null
      var comment: KotlinString? = null
      var _comment: Element? = null
      var requirements: KotlinString? = null
      var _requirements: Element? = null
      var alias: List<KotlinString?>? = null
      var _alias: List<Element?>? = null
      var min: Int? = null
      var _min: Element? = null
      var max: KotlinString? = null
      var _max: Element? = null
      var base: ElementDefinition.Base? = null
      var contentReference: KotlinString? = null
      var _contentReference: Element? = null
      var type: List<ElementDefinition.Type>? = null
      var defaultValueBase64Binary: KotlinString? = null
      var _defaultValueBase64Binary: Element? = null
      var defaultValueBoolean: KotlinBoolean? = null
      var _defaultValueBoolean: Element? = null
      var defaultValueCanonical: KotlinString? = null
      var _defaultValueCanonical: Element? = null
      var defaultValueCode: KotlinString? = null
      var _defaultValueCode: Element? = null
      var defaultValueDate: KotlinString? = null
      var _defaultValueDate: Element? = null
      var defaultValueDateTime: KotlinString? = null
      var _defaultValueDateTime: Element? = null
      var defaultValueDecimal: FhirDecimal? = null
      var _defaultValueDecimal: Element? = null
      var defaultValueId: KotlinString? = null
      var _defaultValueId: Element? = null
      var defaultValueInstant: KotlinString? = null
      var _defaultValueInstant: Element? = null
      var defaultValueInteger: Int? = null
      var _defaultValueInteger: Element? = null
      var defaultValueMarkdown: KotlinString? = null
      var _defaultValueMarkdown: Element? = null
      var defaultValueOid: KotlinString? = null
      var _defaultValueOid: Element? = null
      var defaultValuePositiveInt: Int? = null
      var _defaultValuePositiveInt: Element? = null
      var defaultValueString: KotlinString? = null
      var _defaultValueString: Element? = null
      var defaultValueTime: LocalTime? = null
      var _defaultValueTime: Element? = null
      var defaultValueUnsignedInt: Int? = null
      var _defaultValueUnsignedInt: Element? = null
      var defaultValueUri: KotlinString? = null
      var _defaultValueUri: Element? = null
      var defaultValueUrl: KotlinString? = null
      var _defaultValueUrl: Element? = null
      var defaultValueUuid: KotlinString? = null
      var _defaultValueUuid: Element? = null
      var defaultValueAddress: Address? = null
      var defaultValueAge: Age? = null
      var defaultValueAnnotation: Annotation? = null
      var defaultValueAttachment: Attachment? = null
      var defaultValueCodeableConcept: CodeableConcept? = null
      var defaultValueCodeableReference: CodeableReference? = null
      var defaultValueCoding: Coding? = null
      var defaultValueContactPoint: ContactPoint? = null
      var defaultValueCount: Count? = null
      var defaultValueDistance: Distance? = null
      var defaultValueDuration: Duration? = null
      var defaultValueHumanName: HumanName? = null
      var defaultValueIdentifier: Identifier? = null
      var defaultValueMoney: Money? = null
      var defaultValuePeriod: Period? = null
      var defaultValueQuantity: Quantity? = null
      var defaultValueRange: Range? = null
      var defaultValueRatio: Ratio? = null
      var defaultValueRatioRange: RatioRange? = null
      var defaultValueReference: Reference? = null
      var defaultValueSampledData: SampledData? = null
      var defaultValueSignature: Signature? = null
      var defaultValueTiming: Timing? = null
      var defaultValueContactDetail: ContactDetail? = null
      var defaultValueContributor: Contributor? = null
      var defaultValueDataRequirement: DataRequirement? = null
      var defaultValueExpression: Expression? = null
      var defaultValueParameterDefinition: ParameterDefinition? = null
      var defaultValueRelatedArtifact: RelatedArtifact? = null
      var defaultValueTriggerDefinition: TriggerDefinition? = null
      var defaultValueUsageContext: UsageContext? = null
      var defaultValueDosage: Dosage? = null
      var meaningWhenMissing: KotlinString? = null
      var _meaningWhenMissing: Element? = null
      var orderMeaning: KotlinString? = null
      var _orderMeaning: Element? = null
      var fixedBase64Binary: KotlinString? = null
      var _fixedBase64Binary: Element? = null
      var fixedBoolean: KotlinBoolean? = null
      var _fixedBoolean: Element? = null
      var fixedCanonical: KotlinString? = null
      var _fixedCanonical: Element? = null
      var fixedCode: KotlinString? = null
      var _fixedCode: Element? = null
      var fixedDate: KotlinString? = null
      var _fixedDate: Element? = null
      var fixedDateTime: KotlinString? = null
      var _fixedDateTime: Element? = null
      var fixedDecimal: FhirDecimal? = null
      var _fixedDecimal: Element? = null
      var fixedId: KotlinString? = null
      var _fixedId: Element? = null
      var fixedInstant: KotlinString? = null
      var _fixedInstant: Element? = null
      var fixedInteger: Int? = null
      var _fixedInteger: Element? = null
      var fixedMarkdown: KotlinString? = null
      var _fixedMarkdown: Element? = null
      var fixedOid: KotlinString? = null
      var _fixedOid: Element? = null
      var fixedPositiveInt: Int? = null
      var _fixedPositiveInt: Element? = null
      var fixedString: KotlinString? = null
      var _fixedString: Element? = null
      var fixedTime: LocalTime? = null
      var _fixedTime: Element? = null
      var fixedUnsignedInt: Int? = null
      var _fixedUnsignedInt: Element? = null
      var fixedUri: KotlinString? = null
      var _fixedUri: Element? = null
      var fixedUrl: KotlinString? = null
      var _fixedUrl: Element? = null
      var fixedUuid: KotlinString? = null
      var _fixedUuid: Element? = null
      var fixedAddress: Address? = null
      var fixedAge: Age? = null
      var fixedAnnotation: Annotation? = null
      var fixedAttachment: Attachment? = null
      var fixedCodeableConcept: CodeableConcept? = null
      var fixedCodeableReference: CodeableReference? = null
      var fixedCoding: Coding? = null
      var fixedContactPoint: ContactPoint? = null
      var fixedCount: Count? = null
      var fixedDistance: Distance? = null
      var fixedDuration: Duration? = null
      var fixedHumanName: HumanName? = null
      var fixedIdentifier: Identifier? = null
      var fixedMoney: Money? = null
      var fixedPeriod: Period? = null
      var fixedQuantity: Quantity? = null
      var fixedRange: Range? = null
      var fixedRatio: Ratio? = null
      var fixedRatioRange: RatioRange? = null
      var fixedReference: Reference? = null
      var fixedSampledData: SampledData? = null
      var fixedSignature: Signature? = null
      var fixedTiming: Timing? = null
      var fixedContactDetail: ContactDetail? = null
      var fixedContributor: Contributor? = null
      var fixedDataRequirement: DataRequirement? = null
      var fixedExpression: Expression? = null
      var fixedParameterDefinition: ParameterDefinition? = null
      var fixedRelatedArtifact: RelatedArtifact? = null
      var fixedTriggerDefinition: TriggerDefinition? = null
      var fixedUsageContext: UsageContext? = null
      var fixedDosage: Dosage? = null
      var patternBase64Binary: KotlinString? = null
      var _patternBase64Binary: Element? = null
      var patternBoolean: KotlinBoolean? = null
      var _patternBoolean: Element? = null
      var patternCanonical: KotlinString? = null
      var _patternCanonical: Element? = null
      var patternCode: KotlinString? = null
      var _patternCode: Element? = null
      var patternDate: KotlinString? = null
      var _patternDate: Element? = null
      var patternDateTime: KotlinString? = null
      var _patternDateTime: Element? = null
      var patternDecimal: FhirDecimal? = null
      var _patternDecimal: Element? = null
      var patternId: KotlinString? = null
      var _patternId: Element? = null
      var patternInstant: KotlinString? = null
      var _patternInstant: Element? = null
      var patternInteger: Int? = null
      var _patternInteger: Element? = null
      var patternMarkdown: KotlinString? = null
      var _patternMarkdown: Element? = null
      var patternOid: KotlinString? = null
      var _patternOid: Element? = null
      var patternPositiveInt: Int? = null
      var _patternPositiveInt: Element? = null
      var patternString: KotlinString? = null
      var _patternString: Element? = null
      var patternTime: LocalTime? = null
      var _patternTime: Element? = null
      var patternUnsignedInt: Int? = null
      var _patternUnsignedInt: Element? = null
      var patternUri: KotlinString? = null
      var _patternUri: Element? = null
      var patternUrl: KotlinString? = null
      var _patternUrl: Element? = null
      var patternUuid: KotlinString? = null
      var _patternUuid: Element? = null
      var patternAddress: Address? = null
      var patternAge: Age? = null
      var patternAnnotation: Annotation? = null
      var patternAttachment: Attachment? = null
      var patternCodeableConcept: CodeableConcept? = null
      var patternCodeableReference: CodeableReference? = null
      var patternCoding: Coding? = null
      var patternContactPoint: ContactPoint? = null
      var patternCount: Count? = null
      var patternDistance: Distance? = null
      var patternDuration: Duration? = null
      var patternHumanName: HumanName? = null
      var patternIdentifier: Identifier? = null
      var patternMoney: Money? = null
      var patternPeriod: Period? = null
      var patternQuantity: Quantity? = null
      var patternRange: Range? = null
      var patternRatio: Ratio? = null
      var patternRatioRange: RatioRange? = null
      var patternReference: Reference? = null
      var patternSampledData: SampledData? = null
      var patternSignature: Signature? = null
      var patternTiming: Timing? = null
      var patternContactDetail: ContactDetail? = null
      var patternContributor: Contributor? = null
      var patternDataRequirement: DataRequirement? = null
      var patternExpression: Expression? = null
      var patternParameterDefinition: ParameterDefinition? = null
      var patternRelatedArtifact: RelatedArtifact? = null
      var patternTriggerDefinition: TriggerDefinition? = null
      var patternUsageContext: UsageContext? = null
      var patternDosage: Dosage? = null
      var example: List<ElementDefinition.Example>? = null
      var minValueDate: KotlinString? = null
      var _minValueDate: Element? = null
      var minValueDateTime: KotlinString? = null
      var _minValueDateTime: Element? = null
      var minValueInstant: KotlinString? = null
      var _minValueInstant: Element? = null
      var minValueTime: LocalTime? = null
      var _minValueTime: Element? = null
      var minValueDecimal: FhirDecimal? = null
      var _minValueDecimal: Element? = null
      var minValueInteger: Int? = null
      var _minValueInteger: Element? = null
      var minValuePositiveInt: Int? = null
      var _minValuePositiveInt: Element? = null
      var minValueUnsignedInt: Int? = null
      var _minValueUnsignedInt: Element? = null
      var minValueQuantity: Quantity? = null
      var maxValueDate: KotlinString? = null
      var _maxValueDate: Element? = null
      var maxValueDateTime: KotlinString? = null
      var _maxValueDateTime: Element? = null
      var maxValueInstant: KotlinString? = null
      var _maxValueInstant: Element? = null
      var maxValueTime: LocalTime? = null
      var _maxValueTime: Element? = null
      var maxValueDecimal: FhirDecimal? = null
      var _maxValueDecimal: Element? = null
      var maxValueInteger: Int? = null
      var _maxValueInteger: Element? = null
      var maxValuePositiveInt: Int? = null
      var _maxValuePositiveInt: Element? = null
      var maxValueUnsignedInt: Int? = null
      var _maxValueUnsignedInt: Element? = null
      var maxValueQuantity: Quantity? = null
      var maxLength: Int? = null
      var _maxLength: Element? = null
      var condition: List<KotlinString?>? = null
      var _condition: List<Element?>? = null
      var constraint: List<ElementDefinition.Constraint>? = null
      var mustSupport: KotlinBoolean? = null
      var _mustSupport: Element? = null
      var isModifier: KotlinBoolean? = null
      var _isModifier: Element? = null
      var isModifierReason: KotlinString? = null
      var _isModifierReason: Element? = null
      var isSummary: KotlinBoolean? = null
      var _isSummary: Element? = null
      var binding: ElementDefinition.Binding? = null
      var mapping: List<ElementDefinition.Mapping>? = null
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
          3 -> path = decodeStringElement(descriptor, i)
          4 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            representation =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          6 ->
            _representation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          7 -> sliceName = decodeStringElement(descriptor, i)
          8 ->
            _sliceName = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> sliceIsConstraining = decodeBooleanElement(descriptor, i)
          10 ->
            _sliceIsConstraining =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> label = decodeStringElement(descriptor, i)
          12 -> _label = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          14 ->
            slicing =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionSlicingSerializer,
                null,
              )
          15 -> short = decodeStringElement(descriptor, i)
          16 -> _short = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> definition = decodeStringElement(descriptor, i)
          18 ->
            _definition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 -> comment = decodeStringElement(descriptor, i)
          20 -> _comment = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          21 -> requirements = decodeStringElement(descriptor, i)
          22 ->
            _requirements =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          23 ->
            alias =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          24 ->
            _alias =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          25 -> min = decodeIntElement(descriptor, i)
          26 -> _min = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          27 -> max = decodeStringElement(descriptor, i)
          28 -> _max = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          29 ->
            base =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionBaseSerializer,
                null,
              )
          30 -> contentReference = decodeStringElement(descriptor, i)
          31 ->
            _contentReference =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          32 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionTypeSerializer.listSerializer,
                null,
              )
          33 -> defaultValueBase64Binary = decodeStringElement(descriptor, i)
          34 ->
            _defaultValueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          35 -> defaultValueBoolean = decodeBooleanElement(descriptor, i)
          36 ->
            _defaultValueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          37 -> defaultValueCanonical = decodeStringElement(descriptor, i)
          38 ->
            _defaultValueCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          39 -> defaultValueCode = decodeStringElement(descriptor, i)
          40 ->
            _defaultValueCode =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          41 -> defaultValueDate = decodeStringElement(descriptor, i)
          42 ->
            _defaultValueDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          43 -> defaultValueDateTime = decodeStringElement(descriptor, i)
          44 ->
            _defaultValueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          45 ->
            defaultValueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          46 ->
            _defaultValueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          47 -> defaultValueId = decodeStringElement(descriptor, i)
          48 ->
            _defaultValueId =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          49 -> defaultValueInstant = decodeStringElement(descriptor, i)
          50 ->
            _defaultValueInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          51 -> defaultValueInteger = decodeIntElement(descriptor, i)
          52 ->
            _defaultValueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          53 -> defaultValueMarkdown = decodeStringElement(descriptor, i)
          54 ->
            _defaultValueMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          55 -> defaultValueOid = decodeStringElement(descriptor, i)
          56 ->
            _defaultValueOid =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          57 -> defaultValuePositiveInt = decodeIntElement(descriptor, i)
          58 ->
            _defaultValuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          59 -> defaultValueString = decodeStringElement(descriptor, i)
          60 ->
            _defaultValueString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          61 ->
            defaultValueTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          62 ->
            _defaultValueTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          63 -> defaultValueUnsignedInt = decodeIntElement(descriptor, i)
          64 ->
            _defaultValueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          65 -> defaultValueUri = decodeStringElement(descriptor, i)
          66 ->
            _defaultValueUri =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          67 -> defaultValueUrl = decodeStringElement(descriptor, i)
          68 ->
            _defaultValueUrl =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          69 -> defaultValueUuid = decodeStringElement(descriptor, i)
          70 ->
            _defaultValueUuid =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          71 ->
            defaultValueAddress =
              decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          72 ->
            defaultValueAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          73 ->
            defaultValueAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          74 ->
            defaultValueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          75 ->
            defaultValueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          76 ->
            defaultValueCodeableReference =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          77 ->
            defaultValueCoding =
              decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          78 ->
            defaultValueContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          79 ->
            defaultValueCount =
              decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          80 ->
            defaultValueDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          81 ->
            defaultValueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          82 ->
            defaultValueHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          83 ->
            defaultValueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          84 ->
            defaultValueMoney =
              decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          85 ->
            defaultValuePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          86 ->
            defaultValueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          87 ->
            defaultValueRange =
              decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          88 ->
            defaultValueRatio =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          89 ->
            defaultValueRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          90 ->
            defaultValueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          91 ->
            defaultValueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          92 ->
            defaultValueSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          93 ->
            defaultValueTiming =
              decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          94 ->
            defaultValueContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          95 ->
            defaultValueContributor =
              decodeNullableSerializableElement(descriptor, i, ContributorSerializer, null)
          96 ->
            defaultValueDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          97 ->
            defaultValueExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          98 ->
            defaultValueParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          99 ->
            defaultValueRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          100 ->
            defaultValueTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          101 ->
            defaultValueUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          102 ->
            defaultValueDosage =
              decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          103 -> meaningWhenMissing = decodeStringElement(descriptor, i)
          104 ->
            _meaningWhenMissing =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          105 -> orderMeaning = decodeStringElement(descriptor, i)
          106 ->
            _orderMeaning =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          107 -> fixedBase64Binary = decodeStringElement(descriptor, i)
          108 ->
            _fixedBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          109 -> fixedBoolean = decodeBooleanElement(descriptor, i)
          110 ->
            _fixedBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          111 -> fixedCanonical = decodeStringElement(descriptor, i)
          112 ->
            _fixedCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          113 -> fixedCode = decodeStringElement(descriptor, i)
          114 ->
            _fixedCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          115 -> fixedDate = decodeStringElement(descriptor, i)
          116 ->
            _fixedDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          117 -> fixedDateTime = decodeStringElement(descriptor, i)
          118 ->
            _fixedDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          119 ->
            fixedDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          120 ->
            _fixedDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          121 -> fixedId = decodeStringElement(descriptor, i)
          122 ->
            _fixedId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          123 -> fixedInstant = decodeStringElement(descriptor, i)
          124 ->
            _fixedInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          125 -> fixedInteger = decodeIntElement(descriptor, i)
          126 ->
            _fixedInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          127 -> fixedMarkdown = decodeStringElement(descriptor, i)
          128 ->
            _fixedMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          129 -> fixedOid = decodeStringElement(descriptor, i)
          130 ->
            _fixedOid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          131 -> fixedPositiveInt = decodeIntElement(descriptor, i)
          132 ->
            _fixedPositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          133 -> fixedString = decodeStringElement(descriptor, i)
          134 ->
            _fixedString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          135 ->
            fixedTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          136 ->
            _fixedTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          137 -> fixedUnsignedInt = decodeIntElement(descriptor, i)
          138 ->
            _fixedUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          139 -> fixedUri = decodeStringElement(descriptor, i)
          140 ->
            _fixedUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          141 -> fixedUrl = decodeStringElement(descriptor, i)
          142 ->
            _fixedUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          143 -> fixedUuid = decodeStringElement(descriptor, i)
          144 ->
            _fixedUuid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          145 ->
            fixedAddress = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          146 -> fixedAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          147 ->
            fixedAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          148 ->
            fixedAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          149 ->
            fixedCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          150 ->
            fixedCodeableReference =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          151 ->
            fixedCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          152 ->
            fixedContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          153 ->
            fixedCount = decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          154 ->
            fixedDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          155 ->
            fixedDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          156 ->
            fixedHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          157 ->
            fixedIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          158 ->
            fixedMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          159 ->
            fixedPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          160 ->
            fixedQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          161 ->
            fixedRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          162 ->
            fixedRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          163 ->
            fixedRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          164 ->
            fixedReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          165 ->
            fixedSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          166 ->
            fixedSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          167 ->
            fixedTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          168 ->
            fixedContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          169 ->
            fixedContributor =
              decodeNullableSerializableElement(descriptor, i, ContributorSerializer, null)
          170 ->
            fixedDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          171 ->
            fixedExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          172 ->
            fixedParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          173 ->
            fixedRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          174 ->
            fixedTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          175 ->
            fixedUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          176 ->
            fixedDosage = decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          177 -> patternBase64Binary = decodeStringElement(descriptor, i)
          178 ->
            _patternBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          179 -> patternBoolean = decodeBooleanElement(descriptor, i)
          180 ->
            _patternBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          181 -> patternCanonical = decodeStringElement(descriptor, i)
          182 ->
            _patternCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          183 -> patternCode = decodeStringElement(descriptor, i)
          184 ->
            _patternCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          185 -> patternDate = decodeStringElement(descriptor, i)
          186 ->
            _patternDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          187 -> patternDateTime = decodeStringElement(descriptor, i)
          188 ->
            _patternDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          189 ->
            patternDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          190 ->
            _patternDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          191 -> patternId = decodeStringElement(descriptor, i)
          192 ->
            _patternId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          193 -> patternInstant = decodeStringElement(descriptor, i)
          194 ->
            _patternInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          195 -> patternInteger = decodeIntElement(descriptor, i)
          196 ->
            _patternInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          197 -> patternMarkdown = decodeStringElement(descriptor, i)
          198 ->
            _patternMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          199 -> patternOid = decodeStringElement(descriptor, i)
          200 ->
            _patternOid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          201 -> patternPositiveInt = decodeIntElement(descriptor, i)
          202 ->
            _patternPositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          203 -> patternString = decodeStringElement(descriptor, i)
          204 ->
            _patternString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          205 ->
            patternTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          206 ->
            _patternTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          207 -> patternUnsignedInt = decodeIntElement(descriptor, i)
          208 ->
            _patternUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          209 -> patternUri = decodeStringElement(descriptor, i)
          210 ->
            _patternUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          211 -> patternUrl = decodeStringElement(descriptor, i)
          212 ->
            _patternUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          213 -> patternUuid = decodeStringElement(descriptor, i)
          214 ->
            _patternUuid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          215 ->
            patternAddress =
              decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          216 -> patternAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          217 ->
            patternAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          218 ->
            patternAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          219 ->
            patternCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          220 ->
            patternCodeableReference =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          221 ->
            patternCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          222 ->
            patternContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          223 ->
            patternCount = decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          224 ->
            patternDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          225 ->
            patternDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          226 ->
            patternHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          227 ->
            patternIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          228 ->
            patternMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          229 ->
            patternPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          230 ->
            patternQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          231 ->
            patternRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          232 ->
            patternRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          233 ->
            patternRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          234 ->
            patternReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          235 ->
            patternSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          236 ->
            patternSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          237 ->
            patternTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          238 ->
            patternContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          239 ->
            patternContributor =
              decodeNullableSerializableElement(descriptor, i, ContributorSerializer, null)
          240 ->
            patternDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          241 ->
            patternExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          242 ->
            patternParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          243 ->
            patternRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          244 ->
            patternTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          245 ->
            patternUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          246 ->
            patternDosage = decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          247 ->
            example =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionExampleSerializer.listSerializer,
                null,
              )
          248 -> minValueDate = decodeStringElement(descriptor, i)
          249 ->
            _minValueDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          250 -> minValueDateTime = decodeStringElement(descriptor, i)
          251 ->
            _minValueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          252 -> minValueInstant = decodeStringElement(descriptor, i)
          253 ->
            _minValueInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          254 ->
            minValueTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          255 ->
            _minValueTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          256 ->
            minValueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          257 ->
            _minValueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          258 -> minValueInteger = decodeIntElement(descriptor, i)
          259 ->
            _minValueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          260 -> minValuePositiveInt = decodeIntElement(descriptor, i)
          261 ->
            _minValuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          262 -> minValueUnsignedInt = decodeIntElement(descriptor, i)
          263 ->
            _minValueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          264 ->
            minValueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          265 -> maxValueDate = decodeStringElement(descriptor, i)
          266 ->
            _maxValueDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          267 -> maxValueDateTime = decodeStringElement(descriptor, i)
          268 ->
            _maxValueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          269 -> maxValueInstant = decodeStringElement(descriptor, i)
          270 ->
            _maxValueInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          271 ->
            maxValueTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          272 ->
            _maxValueTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          273 ->
            maxValueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          274 ->
            _maxValueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          275 -> maxValueInteger = decodeIntElement(descriptor, i)
          276 ->
            _maxValueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          277 -> maxValuePositiveInt = decodeIntElement(descriptor, i)
          278 ->
            _maxValuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          279 -> maxValueUnsignedInt = decodeIntElement(descriptor, i)
          280 ->
            _maxValueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          281 ->
            maxValueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          282 -> maxLength = decodeIntElement(descriptor, i)
          283 ->
            _maxLength = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          284 ->
            condition =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          285 ->
            _condition =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          286 ->
            constraint =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionConstraintSerializer.listSerializer,
                null,
              )
          287 -> mustSupport = decodeBooleanElement(descriptor, i)
          288 ->
            _mustSupport = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          289 -> isModifier = decodeBooleanElement(descriptor, i)
          290 ->
            _isModifier = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          291 -> isModifierReason = decodeStringElement(descriptor, i)
          292 ->
            _isModifierReason =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          293 -> isSummary = decodeBooleanElement(descriptor, i)
          294 ->
            _isSummary = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          295 ->
            binding =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionBindingSerializer,
                null,
              )
          296 ->
            mapping =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionMappingSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ElementDefinition: " + i)
        }
      }
      ElementDefinition(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        path =
          R4bString.of(path, _path)
            ?: throw SerializationException(
              "Missing required property 'path' on ElementDefinition"
            ),
        representation =
          (kotlin.collections.List(maxOf(representation?.size ?: 0, _representation?.size ?: 0)) {
            index ->
            Enumeration.of(
              representation?.getOrNull(index)?.let {
                ElementDefinition.PropertyRepresentation.fromCode(it)
              },
              _representation?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'representation' on ElementDefinition has neither a value nor an id/extension"
              )
          }),
        sliceName = R4bString.of(sliceName, _sliceName),
        sliceIsConstraining = R4bBoolean.of(sliceIsConstraining, _sliceIsConstraining),
        label = R4bString.of(label, _label),
        code = code ?: listOf(),
        slicing = slicing,
        short = R4bString.of(short, _short),
        definition = Markdown.of(definition, _definition),
        comment = Markdown.of(comment, _comment),
        requirements = Markdown.of(requirements, _requirements),
        alias =
          (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
            R4bString.of(alias?.getOrNull(index), _alias?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'alias' on ElementDefinition has neither a value nor an id/extension"
              )
          }),
        min = UnsignedInt.of(min, _min),
        max = R4bString.of(max, _max),
        base = base,
        contentReference = Uri.of(contentReference, _contentReference),
        type = type ?: listOf(),
        defaultValue =
          ElementDefinition.DefaultValue.from(
            Base64Binary.of(defaultValueBase64Binary, _defaultValueBase64Binary),
            R4bBoolean.of(defaultValueBoolean, _defaultValueBoolean),
            Canonical.of(defaultValueCanonical, _defaultValueCanonical),
            Code.of(defaultValueCode, _defaultValueCode),
            Date.of(
              if (defaultValueDate != null) FhirDate.fromString(defaultValueDate) else null,
              _defaultValueDate,
            ),
            DateTime.of(
              if (defaultValueDateTime != null) FhirDateTime.fromString(defaultValueDateTime)
              else null,
              _defaultValueDateTime,
            ),
            Decimal.of(defaultValueDecimal, _defaultValueDecimal),
            Id.of(defaultValueId, _defaultValueId),
            Instant.of(
              if (defaultValueInstant != null) FhirDateTime.fromString(defaultValueInstant)
              else null,
              _defaultValueInstant,
            ),
            Integer.of(defaultValueInteger, _defaultValueInteger),
            Markdown.of(defaultValueMarkdown, _defaultValueMarkdown),
            Oid.of(defaultValueOid, _defaultValueOid),
            PositiveInt.of(defaultValuePositiveInt, _defaultValuePositiveInt),
            R4bString.of(defaultValueString, _defaultValueString),
            Time.of(defaultValueTime, _defaultValueTime),
            UnsignedInt.of(defaultValueUnsignedInt, _defaultValueUnsignedInt),
            Uri.of(defaultValueUri, _defaultValueUri),
            Url.of(defaultValueUrl, _defaultValueUrl),
            Uuid.of(defaultValueUuid, _defaultValueUuid),
            defaultValueAddress,
            defaultValueAge,
            defaultValueAnnotation,
            defaultValueAttachment,
            defaultValueCodeableConcept,
            defaultValueCodeableReference,
            defaultValueCoding,
            defaultValueContactPoint,
            defaultValueCount,
            defaultValueDistance,
            defaultValueDuration,
            defaultValueHumanName,
            defaultValueIdentifier,
            defaultValueMoney,
            defaultValuePeriod,
            defaultValueQuantity,
            defaultValueRange,
            defaultValueRatio,
            defaultValueRatioRange,
            defaultValueReference,
            defaultValueSampledData,
            defaultValueSignature,
            defaultValueTiming,
            defaultValueContactDetail,
            defaultValueContributor,
            defaultValueDataRequirement,
            defaultValueExpression,
            defaultValueParameterDefinition,
            defaultValueRelatedArtifact,
            defaultValueTriggerDefinition,
            defaultValueUsageContext,
            defaultValueDosage,
          ),
        meaningWhenMissing = Markdown.of(meaningWhenMissing, _meaningWhenMissing),
        orderMeaning = R4bString.of(orderMeaning, _orderMeaning),
        fixed =
          ElementDefinition.Fixed.from(
            Base64Binary.of(fixedBase64Binary, _fixedBase64Binary),
            R4bBoolean.of(fixedBoolean, _fixedBoolean),
            Canonical.of(fixedCanonical, _fixedCanonical),
            Code.of(fixedCode, _fixedCode),
            Date.of(if (fixedDate != null) FhirDate.fromString(fixedDate) else null, _fixedDate),
            DateTime.of(
              if (fixedDateTime != null) FhirDateTime.fromString(fixedDateTime) else null,
              _fixedDateTime,
            ),
            Decimal.of(fixedDecimal, _fixedDecimal),
            Id.of(fixedId, _fixedId),
            Instant.of(
              if (fixedInstant != null) FhirDateTime.fromString(fixedInstant) else null,
              _fixedInstant,
            ),
            Integer.of(fixedInteger, _fixedInteger),
            Markdown.of(fixedMarkdown, _fixedMarkdown),
            Oid.of(fixedOid, _fixedOid),
            PositiveInt.of(fixedPositiveInt, _fixedPositiveInt),
            R4bString.of(fixedString, _fixedString),
            Time.of(fixedTime, _fixedTime),
            UnsignedInt.of(fixedUnsignedInt, _fixedUnsignedInt),
            Uri.of(fixedUri, _fixedUri),
            Url.of(fixedUrl, _fixedUrl),
            Uuid.of(fixedUuid, _fixedUuid),
            fixedAddress,
            fixedAge,
            fixedAnnotation,
            fixedAttachment,
            fixedCodeableConcept,
            fixedCodeableReference,
            fixedCoding,
            fixedContactPoint,
            fixedCount,
            fixedDistance,
            fixedDuration,
            fixedHumanName,
            fixedIdentifier,
            fixedMoney,
            fixedPeriod,
            fixedQuantity,
            fixedRange,
            fixedRatio,
            fixedRatioRange,
            fixedReference,
            fixedSampledData,
            fixedSignature,
            fixedTiming,
            fixedContactDetail,
            fixedContributor,
            fixedDataRequirement,
            fixedExpression,
            fixedParameterDefinition,
            fixedRelatedArtifact,
            fixedTriggerDefinition,
            fixedUsageContext,
            fixedDosage,
          ),
        pattern =
          ElementDefinition.Pattern.from(
            Base64Binary.of(patternBase64Binary, _patternBase64Binary),
            R4bBoolean.of(patternBoolean, _patternBoolean),
            Canonical.of(patternCanonical, _patternCanonical),
            Code.of(patternCode, _patternCode),
            Date.of(
              if (patternDate != null) FhirDate.fromString(patternDate) else null,
              _patternDate,
            ),
            DateTime.of(
              if (patternDateTime != null) FhirDateTime.fromString(patternDateTime) else null,
              _patternDateTime,
            ),
            Decimal.of(patternDecimal, _patternDecimal),
            Id.of(patternId, _patternId),
            Instant.of(
              if (patternInstant != null) FhirDateTime.fromString(patternInstant) else null,
              _patternInstant,
            ),
            Integer.of(patternInteger, _patternInteger),
            Markdown.of(patternMarkdown, _patternMarkdown),
            Oid.of(patternOid, _patternOid),
            PositiveInt.of(patternPositiveInt, _patternPositiveInt),
            R4bString.of(patternString, _patternString),
            Time.of(patternTime, _patternTime),
            UnsignedInt.of(patternUnsignedInt, _patternUnsignedInt),
            Uri.of(patternUri, _patternUri),
            Url.of(patternUrl, _patternUrl),
            Uuid.of(patternUuid, _patternUuid),
            patternAddress,
            patternAge,
            patternAnnotation,
            patternAttachment,
            patternCodeableConcept,
            patternCodeableReference,
            patternCoding,
            patternContactPoint,
            patternCount,
            patternDistance,
            patternDuration,
            patternHumanName,
            patternIdentifier,
            patternMoney,
            patternPeriod,
            patternQuantity,
            patternRange,
            patternRatio,
            patternRatioRange,
            patternReference,
            patternSampledData,
            patternSignature,
            patternTiming,
            patternContactDetail,
            patternContributor,
            patternDataRequirement,
            patternExpression,
            patternParameterDefinition,
            patternRelatedArtifact,
            patternTriggerDefinition,
            patternUsageContext,
            patternDosage,
          ),
        example = example ?: listOf(),
        minValue =
          ElementDefinition.MinValue.from(
            Date.of(
              if (minValueDate != null) FhirDate.fromString(minValueDate) else null,
              _minValueDate,
            ),
            DateTime.of(
              if (minValueDateTime != null) FhirDateTime.fromString(minValueDateTime) else null,
              _minValueDateTime,
            ),
            Instant.of(
              if (minValueInstant != null) FhirDateTime.fromString(minValueInstant) else null,
              _minValueInstant,
            ),
            Time.of(minValueTime, _minValueTime),
            Decimal.of(minValueDecimal, _minValueDecimal),
            Integer.of(minValueInteger, _minValueInteger),
            PositiveInt.of(minValuePositiveInt, _minValuePositiveInt),
            UnsignedInt.of(minValueUnsignedInt, _minValueUnsignedInt),
            minValueQuantity,
          ),
        maxValue =
          ElementDefinition.MaxValue.from(
            Date.of(
              if (maxValueDate != null) FhirDate.fromString(maxValueDate) else null,
              _maxValueDate,
            ),
            DateTime.of(
              if (maxValueDateTime != null) FhirDateTime.fromString(maxValueDateTime) else null,
              _maxValueDateTime,
            ),
            Instant.of(
              if (maxValueInstant != null) FhirDateTime.fromString(maxValueInstant) else null,
              _maxValueInstant,
            ),
            Time.of(maxValueTime, _maxValueTime),
            Decimal.of(maxValueDecimal, _maxValueDecimal),
            Integer.of(maxValueInteger, _maxValueInteger),
            PositiveInt.of(maxValuePositiveInt, _maxValuePositiveInt),
            UnsignedInt.of(maxValueUnsignedInt, _maxValueUnsignedInt),
            maxValueQuantity,
          ),
        maxLength = Integer.of(maxLength, _maxLength),
        condition =
          (kotlin.collections.List(maxOf(condition?.size ?: 0, _condition?.size ?: 0)) { index ->
            Id.of(condition?.getOrNull(index), _condition?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'condition' on ElementDefinition has neither a value nor an id/extension"
              )
          }),
        constraint = constraint ?: listOf(),
        mustSupport = R4bBoolean.of(mustSupport, _mustSupport),
        isModifier = R4bBoolean.of(isModifier, _isModifier),
        isModifierReason = R4bString.of(isModifierReason, _isModifierReason),
        isSummary = R4bBoolean.of(isSummary, _isSummary),
        binding = binding,
        mapping = mapping ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition) {
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
      encodeStringIfNotNull(descriptor, 3, value.path.value)
      encodeElementIfNotNull(descriptor, 4, value.path)
      if (value.representation.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          stringNullableListSerializer,
          value.representation.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 6, value.representation)
      }
      encodeStringIfNotNull(descriptor, 7, value.sliceName?.value)
      encodeElementIfNotNull(descriptor, 8, value.sliceName)
      encodeBooleanIfNotNull(descriptor, 9, value.sliceIsConstraining?.value)
      encodeElementIfNotNull(descriptor, 10, value.sliceIsConstraining)
      encodeStringIfNotNull(descriptor, 11, value.label?.value)
      encodeElementIfNotNull(descriptor, 12, value.label)
      if (value.code.isNotEmpty())
        encodeSerializableElement(descriptor, 13, CodingSerializer.listSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 14, ElementDefinitionSlicingSerializer, value.slicing)
      encodeStringIfNotNull(descriptor, 15, value.short?.value)
      encodeElementIfNotNull(descriptor, 16, value.short)
      encodeStringIfNotNull(descriptor, 17, value.definition?.value)
      encodeElementIfNotNull(descriptor, 18, value.definition)
      encodeStringIfNotNull(descriptor, 19, value.comment?.value)
      encodeElementIfNotNull(descriptor, 20, value.comment)
      encodeStringIfNotNull(descriptor, 21, value.requirements?.value)
      encodeElementIfNotNull(descriptor, 22, value.requirements)
      if (value.alias.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          23,
          stringNullableListSerializer,
          value.alias.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 24, value.alias)
      }
      encodeIntIfNotNull(descriptor, 25, value.min?.value)
      encodeElementIfNotNull(descriptor, 26, value.min)
      encodeStringIfNotNull(descriptor, 27, value.max?.value)
      encodeElementIfNotNull(descriptor, 28, value.max)
      encodeSerializableIfNotNull(descriptor, 29, ElementDefinitionBaseSerializer, value.base)
      encodeStringIfNotNull(descriptor, 30, value.contentReference?.value)
      encodeElementIfNotNull(descriptor, 31, value.contentReference)
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          32,
          ElementDefinitionTypeSerializer.listSerializer,
          value.type,
        )
      when (val choice = value.defaultValue) {
        null -> {}
        is ElementDefinition.DefaultValue.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 33, choice.value.value)
          encodeElementIfNotNull(descriptor, 34, choice.value)
        }
        is ElementDefinition.DefaultValue.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 35, choice.value.value)
          encodeElementIfNotNull(descriptor, 36, choice.value)
        }
        is ElementDefinition.DefaultValue.Canonical -> {
          encodeStringIfNotNull(descriptor, 37, choice.value.value)
          encodeElementIfNotNull(descriptor, 38, choice.value)
        }
        is ElementDefinition.DefaultValue.Code -> {
          encodeStringIfNotNull(descriptor, 39, choice.value.value)
          encodeElementIfNotNull(descriptor, 40, choice.value)
        }
        is ElementDefinition.DefaultValue.Date -> {
          encodeStringIfNotNull(descriptor, 41, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 42, choice.value)
        }
        is ElementDefinition.DefaultValue.DateTime -> {
          encodeStringIfNotNull(descriptor, 43, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 44, choice.value)
        }
        is ElementDefinition.DefaultValue.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 45, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 46, choice.value)
        }
        is ElementDefinition.DefaultValue.Id -> {
          encodeStringIfNotNull(descriptor, 47, choice.value.value)
          encodeElementIfNotNull(descriptor, 48, choice.value)
        }
        is ElementDefinition.DefaultValue.Instant -> {
          encodeStringIfNotNull(descriptor, 49, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 50, choice.value)
        }
        is ElementDefinition.DefaultValue.Integer -> {
          encodeIntIfNotNull(descriptor, 51, choice.value.value)
          encodeElementIfNotNull(descriptor, 52, choice.value)
        }
        is ElementDefinition.DefaultValue.Markdown -> {
          encodeStringIfNotNull(descriptor, 53, choice.value.value)
          encodeElementIfNotNull(descriptor, 54, choice.value)
        }
        is ElementDefinition.DefaultValue.Oid -> {
          encodeStringIfNotNull(descriptor, 55, choice.value.value)
          encodeElementIfNotNull(descriptor, 56, choice.value)
        }
        is ElementDefinition.DefaultValue.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 57, choice.value.value)
          encodeElementIfNotNull(descriptor, 58, choice.value)
        }
        is ElementDefinition.DefaultValue.String -> {
          encodeStringIfNotNull(descriptor, 59, choice.value.value)
          encodeElementIfNotNull(descriptor, 60, choice.value)
        }
        is ElementDefinition.DefaultValue.Time -> {
          encodeSerializableIfNotNull(descriptor, 61, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 62, choice.value)
        }
        is ElementDefinition.DefaultValue.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 63, choice.value.value)
          encodeElementIfNotNull(descriptor, 64, choice.value)
        }
        is ElementDefinition.DefaultValue.Uri -> {
          encodeStringIfNotNull(descriptor, 65, choice.value.value)
          encodeElementIfNotNull(descriptor, 66, choice.value)
        }
        is ElementDefinition.DefaultValue.Url -> {
          encodeStringIfNotNull(descriptor, 67, choice.value.value)
          encodeElementIfNotNull(descriptor, 68, choice.value)
        }
        is ElementDefinition.DefaultValue.Uuid -> {
          encodeStringIfNotNull(descriptor, 69, choice.value.value)
          encodeElementIfNotNull(descriptor, 70, choice.value)
        }
        is ElementDefinition.DefaultValue.Address -> {
          encodeSerializableElement(descriptor, 71, AddressSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Age -> {
          encodeSerializableElement(descriptor, 72, AgeSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Annotation -> {
          encodeSerializableElement(descriptor, 73, AnnotationSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Attachment -> {
          encodeSerializableElement(descriptor, 74, AttachmentSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.CodeableConcept -> {
          encodeSerializableElement(descriptor, 75, CodeableConceptSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.CodeableReference -> {
          encodeSerializableElement(descriptor, 76, CodeableReferenceSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Coding -> {
          encodeSerializableElement(descriptor, 77, CodingSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.ContactPoint -> {
          encodeSerializableElement(descriptor, 78, ContactPointSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Count -> {
          encodeSerializableElement(descriptor, 79, CountSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Distance -> {
          encodeSerializableElement(descriptor, 80, DistanceSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Duration -> {
          encodeSerializableElement(descriptor, 81, DurationSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.HumanName -> {
          encodeSerializableElement(descriptor, 82, HumanNameSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Identifier -> {
          encodeSerializableElement(descriptor, 83, IdentifierSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Money -> {
          encodeSerializableElement(descriptor, 84, MoneySerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Period -> {
          encodeSerializableElement(descriptor, 85, PeriodSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Quantity -> {
          encodeSerializableElement(descriptor, 86, QuantitySerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Range -> {
          encodeSerializableElement(descriptor, 87, RangeSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Ratio -> {
          encodeSerializableElement(descriptor, 88, RatioSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.RatioRange -> {
          encodeSerializableElement(descriptor, 89, RatioRangeSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Reference -> {
          encodeSerializableElement(descriptor, 90, ReferenceSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.SampledData -> {
          encodeSerializableElement(descriptor, 91, SampledDataSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Signature -> {
          encodeSerializableElement(descriptor, 92, SignatureSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Timing -> {
          encodeSerializableElement(descriptor, 93, TimingSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.ContactDetail -> {
          encodeSerializableElement(descriptor, 94, ContactDetailSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Contributor -> {
          encodeSerializableElement(descriptor, 95, ContributorSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.DataRequirement -> {
          encodeSerializableElement(descriptor, 96, DataRequirementSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Expression -> {
          encodeSerializableElement(descriptor, 97, ExpressionSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 98, ParameterDefinitionSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 99, RelatedArtifactSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 100, TriggerDefinitionSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.UsageContext -> {
          encodeSerializableElement(descriptor, 101, UsageContextSerializer, choice.value)
        }
        is ElementDefinition.DefaultValue.Dosage -> {
          encodeSerializableElement(descriptor, 102, DosageSerializer, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 103, value.meaningWhenMissing?.value)
      encodeElementIfNotNull(descriptor, 104, value.meaningWhenMissing)
      encodeStringIfNotNull(descriptor, 105, value.orderMeaning?.value)
      encodeElementIfNotNull(descriptor, 106, value.orderMeaning)
      when (val choice = value.fixed) {
        null -> {}
        is ElementDefinition.Fixed.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 107, choice.value.value)
          encodeElementIfNotNull(descriptor, 108, choice.value)
        }
        is ElementDefinition.Fixed.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 109, choice.value.value)
          encodeElementIfNotNull(descriptor, 110, choice.value)
        }
        is ElementDefinition.Fixed.Canonical -> {
          encodeStringIfNotNull(descriptor, 111, choice.value.value)
          encodeElementIfNotNull(descriptor, 112, choice.value)
        }
        is ElementDefinition.Fixed.Code -> {
          encodeStringIfNotNull(descriptor, 113, choice.value.value)
          encodeElementIfNotNull(descriptor, 114, choice.value)
        }
        is ElementDefinition.Fixed.Date -> {
          encodeStringIfNotNull(descriptor, 115, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 116, choice.value)
        }
        is ElementDefinition.Fixed.DateTime -> {
          encodeStringIfNotNull(descriptor, 117, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 118, choice.value)
        }
        is ElementDefinition.Fixed.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 119, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 120, choice.value)
        }
        is ElementDefinition.Fixed.Id -> {
          encodeStringIfNotNull(descriptor, 121, choice.value.value)
          encodeElementIfNotNull(descriptor, 122, choice.value)
        }
        is ElementDefinition.Fixed.Instant -> {
          encodeStringIfNotNull(descriptor, 123, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 124, choice.value)
        }
        is ElementDefinition.Fixed.Integer -> {
          encodeIntIfNotNull(descriptor, 125, choice.value.value)
          encodeElementIfNotNull(descriptor, 126, choice.value)
        }
        is ElementDefinition.Fixed.Markdown -> {
          encodeStringIfNotNull(descriptor, 127, choice.value.value)
          encodeElementIfNotNull(descriptor, 128, choice.value)
        }
        is ElementDefinition.Fixed.Oid -> {
          encodeStringIfNotNull(descriptor, 129, choice.value.value)
          encodeElementIfNotNull(descriptor, 130, choice.value)
        }
        is ElementDefinition.Fixed.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 131, choice.value.value)
          encodeElementIfNotNull(descriptor, 132, choice.value)
        }
        is ElementDefinition.Fixed.String -> {
          encodeStringIfNotNull(descriptor, 133, choice.value.value)
          encodeElementIfNotNull(descriptor, 134, choice.value)
        }
        is ElementDefinition.Fixed.Time -> {
          encodeSerializableIfNotNull(descriptor, 135, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 136, choice.value)
        }
        is ElementDefinition.Fixed.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 137, choice.value.value)
          encodeElementIfNotNull(descriptor, 138, choice.value)
        }
        is ElementDefinition.Fixed.Uri -> {
          encodeStringIfNotNull(descriptor, 139, choice.value.value)
          encodeElementIfNotNull(descriptor, 140, choice.value)
        }
        is ElementDefinition.Fixed.Url -> {
          encodeStringIfNotNull(descriptor, 141, choice.value.value)
          encodeElementIfNotNull(descriptor, 142, choice.value)
        }
        is ElementDefinition.Fixed.Uuid -> {
          encodeStringIfNotNull(descriptor, 143, choice.value.value)
          encodeElementIfNotNull(descriptor, 144, choice.value)
        }
        is ElementDefinition.Fixed.Address -> {
          encodeSerializableElement(descriptor, 145, AddressSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Age -> {
          encodeSerializableElement(descriptor, 146, AgeSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Annotation -> {
          encodeSerializableElement(descriptor, 147, AnnotationSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Attachment -> {
          encodeSerializableElement(descriptor, 148, AttachmentSerializer, choice.value)
        }
        is ElementDefinition.Fixed.CodeableConcept -> {
          encodeSerializableElement(descriptor, 149, CodeableConceptSerializer, choice.value)
        }
        is ElementDefinition.Fixed.CodeableReference -> {
          encodeSerializableElement(descriptor, 150, CodeableReferenceSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Coding -> {
          encodeSerializableElement(descriptor, 151, CodingSerializer, choice.value)
        }
        is ElementDefinition.Fixed.ContactPoint -> {
          encodeSerializableElement(descriptor, 152, ContactPointSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Count -> {
          encodeSerializableElement(descriptor, 153, CountSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Distance -> {
          encodeSerializableElement(descriptor, 154, DistanceSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Duration -> {
          encodeSerializableElement(descriptor, 155, DurationSerializer, choice.value)
        }
        is ElementDefinition.Fixed.HumanName -> {
          encodeSerializableElement(descriptor, 156, HumanNameSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Identifier -> {
          encodeSerializableElement(descriptor, 157, IdentifierSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Money -> {
          encodeSerializableElement(descriptor, 158, MoneySerializer, choice.value)
        }
        is ElementDefinition.Fixed.Period -> {
          encodeSerializableElement(descriptor, 159, PeriodSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Quantity -> {
          encodeSerializableElement(descriptor, 160, QuantitySerializer, choice.value)
        }
        is ElementDefinition.Fixed.Range -> {
          encodeSerializableElement(descriptor, 161, RangeSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Ratio -> {
          encodeSerializableElement(descriptor, 162, RatioSerializer, choice.value)
        }
        is ElementDefinition.Fixed.RatioRange -> {
          encodeSerializableElement(descriptor, 163, RatioRangeSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Reference -> {
          encodeSerializableElement(descriptor, 164, ReferenceSerializer, choice.value)
        }
        is ElementDefinition.Fixed.SampledData -> {
          encodeSerializableElement(descriptor, 165, SampledDataSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Signature -> {
          encodeSerializableElement(descriptor, 166, SignatureSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Timing -> {
          encodeSerializableElement(descriptor, 167, TimingSerializer, choice.value)
        }
        is ElementDefinition.Fixed.ContactDetail -> {
          encodeSerializableElement(descriptor, 168, ContactDetailSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Contributor -> {
          encodeSerializableElement(descriptor, 169, ContributorSerializer, choice.value)
        }
        is ElementDefinition.Fixed.DataRequirement -> {
          encodeSerializableElement(descriptor, 170, DataRequirementSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Expression -> {
          encodeSerializableElement(descriptor, 171, ExpressionSerializer, choice.value)
        }
        is ElementDefinition.Fixed.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 172, ParameterDefinitionSerializer, choice.value)
        }
        is ElementDefinition.Fixed.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 173, RelatedArtifactSerializer, choice.value)
        }
        is ElementDefinition.Fixed.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 174, TriggerDefinitionSerializer, choice.value)
        }
        is ElementDefinition.Fixed.UsageContext -> {
          encodeSerializableElement(descriptor, 175, UsageContextSerializer, choice.value)
        }
        is ElementDefinition.Fixed.Dosage -> {
          encodeSerializableElement(descriptor, 176, DosageSerializer, choice.value)
        }
      }
      when (val choice = value.pattern) {
        null -> {}
        is ElementDefinition.Pattern.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 177, choice.value.value)
          encodeElementIfNotNull(descriptor, 178, choice.value)
        }
        is ElementDefinition.Pattern.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 179, choice.value.value)
          encodeElementIfNotNull(descriptor, 180, choice.value)
        }
        is ElementDefinition.Pattern.Canonical -> {
          encodeStringIfNotNull(descriptor, 181, choice.value.value)
          encodeElementIfNotNull(descriptor, 182, choice.value)
        }
        is ElementDefinition.Pattern.Code -> {
          encodeStringIfNotNull(descriptor, 183, choice.value.value)
          encodeElementIfNotNull(descriptor, 184, choice.value)
        }
        is ElementDefinition.Pattern.Date -> {
          encodeStringIfNotNull(descriptor, 185, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 186, choice.value)
        }
        is ElementDefinition.Pattern.DateTime -> {
          encodeStringIfNotNull(descriptor, 187, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 188, choice.value)
        }
        is ElementDefinition.Pattern.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 189, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 190, choice.value)
        }
        is ElementDefinition.Pattern.Id -> {
          encodeStringIfNotNull(descriptor, 191, choice.value.value)
          encodeElementIfNotNull(descriptor, 192, choice.value)
        }
        is ElementDefinition.Pattern.Instant -> {
          encodeStringIfNotNull(descriptor, 193, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 194, choice.value)
        }
        is ElementDefinition.Pattern.Integer -> {
          encodeIntIfNotNull(descriptor, 195, choice.value.value)
          encodeElementIfNotNull(descriptor, 196, choice.value)
        }
        is ElementDefinition.Pattern.Markdown -> {
          encodeStringIfNotNull(descriptor, 197, choice.value.value)
          encodeElementIfNotNull(descriptor, 198, choice.value)
        }
        is ElementDefinition.Pattern.Oid -> {
          encodeStringIfNotNull(descriptor, 199, choice.value.value)
          encodeElementIfNotNull(descriptor, 200, choice.value)
        }
        is ElementDefinition.Pattern.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 201, choice.value.value)
          encodeElementIfNotNull(descriptor, 202, choice.value)
        }
        is ElementDefinition.Pattern.String -> {
          encodeStringIfNotNull(descriptor, 203, choice.value.value)
          encodeElementIfNotNull(descriptor, 204, choice.value)
        }
        is ElementDefinition.Pattern.Time -> {
          encodeSerializableIfNotNull(descriptor, 205, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 206, choice.value)
        }
        is ElementDefinition.Pattern.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 207, choice.value.value)
          encodeElementIfNotNull(descriptor, 208, choice.value)
        }
        is ElementDefinition.Pattern.Uri -> {
          encodeStringIfNotNull(descriptor, 209, choice.value.value)
          encodeElementIfNotNull(descriptor, 210, choice.value)
        }
        is ElementDefinition.Pattern.Url -> {
          encodeStringIfNotNull(descriptor, 211, choice.value.value)
          encodeElementIfNotNull(descriptor, 212, choice.value)
        }
        is ElementDefinition.Pattern.Uuid -> {
          encodeStringIfNotNull(descriptor, 213, choice.value.value)
          encodeElementIfNotNull(descriptor, 214, choice.value)
        }
        is ElementDefinition.Pattern.Address -> {
          encodeSerializableElement(descriptor, 215, AddressSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Age -> {
          encodeSerializableElement(descriptor, 216, AgeSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Annotation -> {
          encodeSerializableElement(descriptor, 217, AnnotationSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Attachment -> {
          encodeSerializableElement(descriptor, 218, AttachmentSerializer, choice.value)
        }
        is ElementDefinition.Pattern.CodeableConcept -> {
          encodeSerializableElement(descriptor, 219, CodeableConceptSerializer, choice.value)
        }
        is ElementDefinition.Pattern.CodeableReference -> {
          encodeSerializableElement(descriptor, 220, CodeableReferenceSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Coding -> {
          encodeSerializableElement(descriptor, 221, CodingSerializer, choice.value)
        }
        is ElementDefinition.Pattern.ContactPoint -> {
          encodeSerializableElement(descriptor, 222, ContactPointSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Count -> {
          encodeSerializableElement(descriptor, 223, CountSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Distance -> {
          encodeSerializableElement(descriptor, 224, DistanceSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Duration -> {
          encodeSerializableElement(descriptor, 225, DurationSerializer, choice.value)
        }
        is ElementDefinition.Pattern.HumanName -> {
          encodeSerializableElement(descriptor, 226, HumanNameSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Identifier -> {
          encodeSerializableElement(descriptor, 227, IdentifierSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Money -> {
          encodeSerializableElement(descriptor, 228, MoneySerializer, choice.value)
        }
        is ElementDefinition.Pattern.Period -> {
          encodeSerializableElement(descriptor, 229, PeriodSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Quantity -> {
          encodeSerializableElement(descriptor, 230, QuantitySerializer, choice.value)
        }
        is ElementDefinition.Pattern.Range -> {
          encodeSerializableElement(descriptor, 231, RangeSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Ratio -> {
          encodeSerializableElement(descriptor, 232, RatioSerializer, choice.value)
        }
        is ElementDefinition.Pattern.RatioRange -> {
          encodeSerializableElement(descriptor, 233, RatioRangeSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Reference -> {
          encodeSerializableElement(descriptor, 234, ReferenceSerializer, choice.value)
        }
        is ElementDefinition.Pattern.SampledData -> {
          encodeSerializableElement(descriptor, 235, SampledDataSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Signature -> {
          encodeSerializableElement(descriptor, 236, SignatureSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Timing -> {
          encodeSerializableElement(descriptor, 237, TimingSerializer, choice.value)
        }
        is ElementDefinition.Pattern.ContactDetail -> {
          encodeSerializableElement(descriptor, 238, ContactDetailSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Contributor -> {
          encodeSerializableElement(descriptor, 239, ContributorSerializer, choice.value)
        }
        is ElementDefinition.Pattern.DataRequirement -> {
          encodeSerializableElement(descriptor, 240, DataRequirementSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Expression -> {
          encodeSerializableElement(descriptor, 241, ExpressionSerializer, choice.value)
        }
        is ElementDefinition.Pattern.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 242, ParameterDefinitionSerializer, choice.value)
        }
        is ElementDefinition.Pattern.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 243, RelatedArtifactSerializer, choice.value)
        }
        is ElementDefinition.Pattern.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 244, TriggerDefinitionSerializer, choice.value)
        }
        is ElementDefinition.Pattern.UsageContext -> {
          encodeSerializableElement(descriptor, 245, UsageContextSerializer, choice.value)
        }
        is ElementDefinition.Pattern.Dosage -> {
          encodeSerializableElement(descriptor, 246, DosageSerializer, choice.value)
        }
      }
      if (value.example.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          247,
          ElementDefinitionExampleSerializer.listSerializer,
          value.example,
        )
      when (val choice = value.minValue) {
        null -> {}
        is ElementDefinition.MinValue.Date -> {
          encodeStringIfNotNull(descriptor, 248, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 249, choice.value)
        }
        is ElementDefinition.MinValue.DateTime -> {
          encodeStringIfNotNull(descriptor, 250, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 251, choice.value)
        }
        is ElementDefinition.MinValue.Instant -> {
          encodeStringIfNotNull(descriptor, 252, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 253, choice.value)
        }
        is ElementDefinition.MinValue.Time -> {
          encodeSerializableIfNotNull(descriptor, 254, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 255, choice.value)
        }
        is ElementDefinition.MinValue.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 256, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 257, choice.value)
        }
        is ElementDefinition.MinValue.Integer -> {
          encodeIntIfNotNull(descriptor, 258, choice.value.value)
          encodeElementIfNotNull(descriptor, 259, choice.value)
        }
        is ElementDefinition.MinValue.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 260, choice.value.value)
          encodeElementIfNotNull(descriptor, 261, choice.value)
        }
        is ElementDefinition.MinValue.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 262, choice.value.value)
          encodeElementIfNotNull(descriptor, 263, choice.value)
        }
        is ElementDefinition.MinValue.Quantity -> {
          encodeSerializableElement(descriptor, 264, QuantitySerializer, choice.value)
        }
      }
      when (val choice = value.maxValue) {
        null -> {}
        is ElementDefinition.MaxValue.Date -> {
          encodeStringIfNotNull(descriptor, 265, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 266, choice.value)
        }
        is ElementDefinition.MaxValue.DateTime -> {
          encodeStringIfNotNull(descriptor, 267, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 268, choice.value)
        }
        is ElementDefinition.MaxValue.Instant -> {
          encodeStringIfNotNull(descriptor, 269, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 270, choice.value)
        }
        is ElementDefinition.MaxValue.Time -> {
          encodeSerializableIfNotNull(descriptor, 271, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 272, choice.value)
        }
        is ElementDefinition.MaxValue.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 273, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 274, choice.value)
        }
        is ElementDefinition.MaxValue.Integer -> {
          encodeIntIfNotNull(descriptor, 275, choice.value.value)
          encodeElementIfNotNull(descriptor, 276, choice.value)
        }
        is ElementDefinition.MaxValue.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 277, choice.value.value)
          encodeElementIfNotNull(descriptor, 278, choice.value)
        }
        is ElementDefinition.MaxValue.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 279, choice.value.value)
          encodeElementIfNotNull(descriptor, 280, choice.value)
        }
        is ElementDefinition.MaxValue.Quantity -> {
          encodeSerializableElement(descriptor, 281, QuantitySerializer, choice.value)
        }
      }
      encodeIntIfNotNull(descriptor, 282, value.maxLength?.value)
      encodeElementIfNotNull(descriptor, 283, value.maxLength)
      if (value.condition.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          284,
          stringNullableListSerializer,
          value.condition.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 285, value.condition)
      }
      if (value.constraint.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          286,
          ElementDefinitionConstraintSerializer.listSerializer,
          value.constraint,
        )
      encodeBooleanIfNotNull(descriptor, 287, value.mustSupport?.value)
      encodeElementIfNotNull(descriptor, 288, value.mustSupport)
      encodeBooleanIfNotNull(descriptor, 289, value.isModifier?.value)
      encodeElementIfNotNull(descriptor, 290, value.isModifier)
      encodeStringIfNotNull(descriptor, 291, value.isModifierReason?.value)
      encodeElementIfNotNull(descriptor, 292, value.isModifierReason)
      encodeBooleanIfNotNull(descriptor, 293, value.isSummary?.value)
      encodeElementIfNotNull(descriptor, 294, value.isSummary)
      encodeSerializableIfNotNull(
        descriptor,
        295,
        ElementDefinitionBindingSerializer,
        value.binding,
      )
      if (value.mapping.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          296,
          ElementDefinitionMappingSerializer.listSerializer,
          value.mapping,
        )
    }
  }
}
