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
import dev.ohs.fhir.model.r5.ElementDefinition
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
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
import dev.ohs.fhir.model.r5.terminologies.BindingStrength
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

  override fun deserialize(decoder: Decoder): ElementDefinition.Slicing {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          discriminator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionSlicingDiscriminatorSerializer.listSerializer,
              null,
            )
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> ordered = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _ordered =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> rules = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _rules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Slicing: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Slicing(
      id = id,
      extension = extension ?: listOf(),
      discriminator = discriminator ?: listOf(),
      description = R5String.of(description, _description),
      ordered = R5Boolean.of(ordered, _ordered),
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.discriminator.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ElementDefinitionSlicingDiscriminatorSerializer.listSerializer,
        value.discriminator,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.ordered?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.ordered)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.rules.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.rules)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): ElementDefinition.Slicing.Discriminator {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var path: KotlinString? = null
    var _path: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Discriminator: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Slicing.Discriminator(
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
        R5String.of(path, _path)
          ?: throw SerializationException(
            "Missing required property 'path' on ElementDefinition.Slicing.Discriminator"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing.Discriminator) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.path.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.path)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): ElementDefinition.Base {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        5 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Base: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Base(
      id = id,
      extension = extension ?: listOf(),
      path =
        R5String.of(path, _path)
          ?: throw SerializationException(
            "Missing required property 'path' on ElementDefinition.Base"
          ),
      min =
        UnsignedInt.of(min, _min)
          ?: throw SerializationException(
            "Missing required property 'min' on ElementDefinition.Base"
          ),
      max =
        R5String.of(max, _max)
          ?: throw SerializationException(
            "Missing required property 'max' on ElementDefinition.Base"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Base) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.path.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.path)
    compositeEncoder.encodeIntIfNotNull(descriptor, 4, value.min.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.max.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.max)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): ElementDefinition.Type {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 ->
          profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        5 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        6 ->
          targetProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        7 ->
          _targetProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        8 ->
          aggregation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _aggregation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 -> versioning = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _versioning =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Type: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Type(
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
        (kotlin.collections.List(maxOf(targetProfile?.size ?: 0, _targetProfile?.size ?: 0)) { index
          ->
          Canonical.of(targetProfile?.getOrNull(index), _targetProfile?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'targetProfile' on ElementDefinition.Type has neither a value nor an id/extension"
            )
        }),
      aggregation =
        (kotlin.collections.List(maxOf(aggregation?.size ?: 0, _aggregation?.size ?: 0)) { index ->
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.code)
    if (value.profile.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        4,
        stringNullableListSerializer,
        value.profile.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 5, value.profile)
    }
    if (value.targetProfile.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        6,
        stringNullableListSerializer,
        value.targetProfile.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 7, value.targetProfile)
    }
    if (value.aggregation.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.aggregation.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.aggregation)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.versioning?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.versioning)
    compositeEncoder.endStructure(descriptor)
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

  internal val listSerializer: KSerializer<List<ElementDefinition.Example>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Example {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> label = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _label =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> valueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _valueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        7 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> valueCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _valueCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> valueDate = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> valueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        17 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> valueId = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _valueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> valueInstant = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _valueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        23 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> valueInteger64 = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _valueInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> valueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _valueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> valueOid = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _valueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> valuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        31 ->
          _valuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        35 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> valueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        37 ->
          _valueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 -> valueUri = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _valueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 -> valueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _valueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 -> valueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        43 ->
          _valueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 ->
          valueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        45 ->
          valueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        46 ->
          valueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        47 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        48 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        49 ->
          valueCodeableReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        50 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        51 ->
          valueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        52 ->
          valueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        53 ->
          valueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        54 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        55 ->
          valueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        56 ->
          valueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        57 ->
          valueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        58 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        59 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        60 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        61 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        62 ->
          valueRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        63 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        64 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        65 ->
          valueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        66 ->
          valueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        67 ->
          valueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        68 ->
          valueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        69 ->
          valueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        70 ->
          valueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        73 ->
          valueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        74 ->
          valueAvailability =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilitySerializer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer,
              null,
            )
        76 ->
          valueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        77 ->
          valueMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Example: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Example(
      id = id,
      extension = extension ?: listOf(),
      label =
        R5String.of(label, _label)
          ?: throw SerializationException(
            "Missing required property 'label' on ElementDefinition.Example"
          ),
      `value` =
        ElementDefinition.Example.Value.from(
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
        )
          ?: throw SerializationException(
            "Missing required property 'value' on ElementDefinition.Example"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Example) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.label.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.label)
    when (val choice = value.`value`) {
      is ElementDefinition.Example.Value.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is ElementDefinition.Example.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is ElementDefinition.Example.Value.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is ElementDefinition.Example.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is ElementDefinition.Example.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is ElementDefinition.Example.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 15, choice.value)
      }
      is ElementDefinition.Example.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          16,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 17, choice.value)
      }
      is ElementDefinition.Example.Value.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 18, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 19, choice.value)
      }
      is ElementDefinition.Example.Value.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 20, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 21, choice.value)
      }
      is ElementDefinition.Example.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 22, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 23, choice.value)
      }
      is ElementDefinition.Example.Value.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 24, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 25, choice.value)
      }
      is ElementDefinition.Example.Value.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 26, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 27, choice.value)
      }
      is ElementDefinition.Example.Value.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 28, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 29, choice.value)
      }
      is ElementDefinition.Example.Value.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 30, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 31, choice.value)
      }
      is ElementDefinition.Example.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 32, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 33, choice.value)
      }
      is ElementDefinition.Example.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          34,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 35, choice.value)
      }
      is ElementDefinition.Example.Value.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 36, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 37, choice.value)
      }
      is ElementDefinition.Example.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 38, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 39, choice.value)
      }
      is ElementDefinition.Example.Value.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 40, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 41, choice.value)
      }
      is ElementDefinition.Example.Value.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 42, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 43, choice.value)
      }
      is ElementDefinition.Example.Value.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 44, AddressSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 45, AgeSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          46,
          AnnotationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          47,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          48,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.CodeableReference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          49,
          CodeableReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 50, CodingSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          51,
          ContactPointSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 52, CountSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 53, DistanceSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 54, DurationSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          55,
          HumanNameSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          56,
          IdentifierSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 57, MoneySerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 58, PeriodSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 59, QuantitySerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 60, RangeSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 61, RatioSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          62,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          63,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          64,
          SampledDataSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          65,
          SignatureSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 66, TimingSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          67,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          68,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          69,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          70,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          71,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          72,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          73,
          UsageContextSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Availability -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          74,
          AvailabilitySerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.ExtendedContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          75,
          ExtendedContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 76, DosageSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 77, MetaSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
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
      optionalElement("suppress", KotlinBoolean.serializer().descriptor)
      optionalElement("_suppress", ElementSerializer.descriptor)
      optionalElement("human", KotlinString.serializer().descriptor)
      optionalElement("_human", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
      optionalElement("source", KotlinString.serializer().descriptor)
      optionalElement("_source", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Constraint>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Constraint {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var key: KotlinString? = null
    var _key: Element? = null
    var requirements: KotlinString? = null
    var _requirements: Element? = null
    var severity: KotlinString? = null
    var _severity: Element? = null
    var suppress: KotlinBoolean? = null
    var _suppress: Element? = null
    var human: KotlinString? = null
    var _human: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var source: KotlinString? = null
    var _source: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> key = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _key =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> requirements = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _requirements =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> severity = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _severity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> suppress = compositeDecoder.decodeBooleanElement(descriptor, i)
        9 ->
          _suppress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> human = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _human =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> source = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Constraint: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Constraint(
      id = id,
      extension = extension ?: listOf(),
      key =
        Id.of(key, _key)
          ?: throw SerializationException(
            "Missing required property 'key' on ElementDefinition.Constraint"
          ),
      requirements = Markdown.of(requirements, _requirements),
      severity =
        Enumeration.of(
          if (severity != null) ElementDefinition.ConstraintSeverity.fromCode(severity) else null,
          _severity,
        )
          ?: throw SerializationException(
            "Missing required property 'severity' on ElementDefinition.Constraint"
          ),
      suppress = R5Boolean.of(suppress, _suppress),
      human =
        R5String.of(human, _human)
          ?: throw SerializationException(
            "Missing required property 'human' on ElementDefinition.Constraint"
          ),
      expression = R5String.of(expression, _expression),
      source = Canonical.of(source, _source),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Constraint) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.key.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.key)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.requirements?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.requirements)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.severity.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.severity)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 8, value.suppress?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.suppress)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.human.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.human)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.expression?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.expression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14, value.source?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.source)
    compositeEncoder.endStructure(descriptor)
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
      optionalElement(
        "additional",
        ElementDefinitionBindingAdditionalSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Binding>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Binding {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var strength: KotlinString? = null
    var _strength: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var additional: List<ElementDefinition.Binding.Additional>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> strength = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _strength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          additional =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionBindingAdditionalSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Binding: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Binding(
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
      description = Markdown.of(description, _description),
      valueSet = Canonical.of(valueSet, _valueSet),
      additional = additional ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Binding) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.strength.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.strength)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.valueSet?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.valueSet)
    if (value.additional.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        ElementDefinitionBindingAdditionalSerializer.listSerializer,
        value.additional,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ElementDefinitionBindingAdditionalSerializer :
  KSerializer<ElementDefinition.Binding.Additional> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Additional") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("purpose", KotlinString.serializer().descriptor)
      optionalElement("_purpose", ElementSerializer.descriptor)
      optionalElement("valueSet", KotlinString.serializer().descriptor)
      optionalElement("_valueSet", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
      optionalElement("shortDoco", KotlinString.serializer().descriptor)
      optionalElement("_shortDoco", ElementSerializer.descriptor)
      optionalElement("usage", UsageContextSerializer.listSerializer.descriptor)
      optionalElement("any", KotlinBoolean.serializer().descriptor)
      optionalElement("_any", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ElementDefinition.Binding.Additional>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ElementDefinition.Binding.Additional {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var shortDoco: KotlinString? = null
    var _shortDoco: Element? = null
    var usage: List<UsageContext>? = null
    var any: KotlinBoolean? = null
    var _any: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> shortDoco = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _shortDoco =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          usage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        11 -> any = compositeDecoder.decodeBooleanElement(descriptor, i)
        12 ->
          _any =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Additional: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Binding.Additional(
      id = id,
      extension = extension ?: listOf(),
      purpose =
        Enumeration.of(
          if (purpose != null) ElementDefinition.AdditionalBindingPurposeVS.fromCode(purpose)
          else null,
          _purpose,
        )
          ?: throw SerializationException(
            "Missing required property 'purpose' on ElementDefinition.Binding.Additional"
          ),
      valueSet =
        Canonical.of(valueSet, _valueSet)
          ?: throw SerializationException(
            "Missing required property 'valueSet' on ElementDefinition.Binding.Additional"
          ),
      documentation = Markdown.of(documentation, _documentation),
      shortDoco = R5String.of(shortDoco, _shortDoco),
      usage = usage ?: listOf(),
      any = R5Boolean.of(any, _any),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Binding.Additional) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.purpose.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.purpose)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.valueSet.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.valueSet)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.documentation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.shortDoco?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.shortDoco)
    if (value.usage.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        UsageContextSerializer.listSerializer,
        value.usage,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 11, value.any?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.any)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): ElementDefinition.Mapping {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> identity = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _identity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> map = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _map =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mapping: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition.Mapping(
      id = id,
      extension = extension ?: listOf(),
      identity =
        Id.of(identity, _identity)
          ?: throw SerializationException(
            "Missing required property 'identity' on ElementDefinition.Mapping"
          ),
      language = Code.of(language, _language),
      map =
        R5String.of(map, _map)
          ?: throw SerializationException(
            "Missing required property 'map' on ElementDefinition.Mapping"
          ),
      comment = Markdown.of(comment, _comment),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Mapping) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.identity.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.identity)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.language)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.map.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.map)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.comment)
    compositeEncoder.endStructure(descriptor)
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
      optionalElement("defaultValueInteger64", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueInteger64", ElementSerializer.descriptor)
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
      optionalElement("defaultValueDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("defaultValueExpression", ExpressionSerializer.descriptor)
      optionalElement("defaultValueParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("defaultValueRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("defaultValueTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("defaultValueUsageContext", UsageContextSerializer.descriptor)
      optionalElement("defaultValueAvailability", AvailabilitySerializer.descriptor)
      optionalElement(
        "defaultValueExtendedContactDetail",
        ExtendedContactDetailSerializer.descriptor,
      )
      optionalElement("defaultValueDosage", DosageSerializer.descriptor)
      optionalElement("defaultValueMeta", MetaSerializer.descriptor)
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
      optionalElement("fixedInteger64", KotlinString.serializer().descriptor)
      optionalElement("_fixedInteger64", ElementSerializer.descriptor)
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
      optionalElement("fixedDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("fixedExpression", ExpressionSerializer.descriptor)
      optionalElement("fixedParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("fixedRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("fixedTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("fixedUsageContext", UsageContextSerializer.descriptor)
      optionalElement("fixedAvailability", AvailabilitySerializer.descriptor)
      optionalElement("fixedExtendedContactDetail", ExtendedContactDetailSerializer.descriptor)
      optionalElement("fixedDosage", DosageSerializer.descriptor)
      optionalElement("fixedMeta", MetaSerializer.descriptor)
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
      optionalElement("patternInteger64", KotlinString.serializer().descriptor)
      optionalElement("_patternInteger64", ElementSerializer.descriptor)
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
      optionalElement("patternDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("patternExpression", ExpressionSerializer.descriptor)
      optionalElement("patternParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("patternRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("patternTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("patternUsageContext", UsageContextSerializer.descriptor)
      optionalElement("patternAvailability", AvailabilitySerializer.descriptor)
      optionalElement("patternExtendedContactDetail", ExtendedContactDetailSerializer.descriptor)
      optionalElement("patternDosage", DosageSerializer.descriptor)
      optionalElement("patternMeta", MetaSerializer.descriptor)
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
      optionalElement("minValueInteger64", KotlinString.serializer().descriptor)
      optionalElement("_minValueInteger64", ElementSerializer.descriptor)
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
      optionalElement("maxValueInteger64", KotlinString.serializer().descriptor)
      optionalElement("_maxValueInteger64", ElementSerializer.descriptor)
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
      optionalElement("mustHaveValue", KotlinBoolean.serializer().descriptor)
      optionalElement("_mustHaveValue", ElementSerializer.descriptor)
      optionalElement("valueAlternatives", stringNullableListSerializer.descriptor)
      optionalElement("_valueAlternatives", ElementSerializer.nullableListSerializer.descriptor)
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

  override fun deserialize(decoder: Decoder): ElementDefinition {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var defaultValueInteger64: KotlinString? = null
    var _defaultValueInteger64: Element? = null
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
    var defaultValueDataRequirement: DataRequirement? = null
    var defaultValueExpression: Expression? = null
    var defaultValueParameterDefinition: ParameterDefinition? = null
    var defaultValueRelatedArtifact: RelatedArtifact? = null
    var defaultValueTriggerDefinition: TriggerDefinition? = null
    var defaultValueUsageContext: UsageContext? = null
    var defaultValueAvailability: Availability? = null
    var defaultValueExtendedContactDetail: ExtendedContactDetail? = null
    var defaultValueDosage: Dosage? = null
    var defaultValueMeta: Meta? = null
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
    var fixedInteger64: KotlinString? = null
    var _fixedInteger64: Element? = null
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
    var fixedDataRequirement: DataRequirement? = null
    var fixedExpression: Expression? = null
    var fixedParameterDefinition: ParameterDefinition? = null
    var fixedRelatedArtifact: RelatedArtifact? = null
    var fixedTriggerDefinition: TriggerDefinition? = null
    var fixedUsageContext: UsageContext? = null
    var fixedAvailability: Availability? = null
    var fixedExtendedContactDetail: ExtendedContactDetail? = null
    var fixedDosage: Dosage? = null
    var fixedMeta: Meta? = null
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
    var patternInteger64: KotlinString? = null
    var _patternInteger64: Element? = null
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
    var patternDataRequirement: DataRequirement? = null
    var patternExpression: Expression? = null
    var patternParameterDefinition: ParameterDefinition? = null
    var patternRelatedArtifact: RelatedArtifact? = null
    var patternTriggerDefinition: TriggerDefinition? = null
    var patternUsageContext: UsageContext? = null
    var patternAvailability: Availability? = null
    var patternExtendedContactDetail: ExtendedContactDetail? = null
    var patternDosage: Dosage? = null
    var patternMeta: Meta? = null
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
    var minValueInteger64: KotlinString? = null
    var _minValueInteger64: Element? = null
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
    var maxValueInteger64: KotlinString? = null
    var _maxValueInteger64: Element? = null
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
    var mustHaveValue: KotlinBoolean? = null
    var _mustHaveValue: Element? = null
    var valueAlternatives: List<KotlinString?>? = null
    var _valueAlternatives: List<Element?>? = null
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          representation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        6 ->
          _representation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 -> sliceName = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _sliceName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> sliceIsConstraining = compositeDecoder.decodeBooleanElement(descriptor, i)
        10 ->
          _sliceIsConstraining =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> label = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _label =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        14 ->
          slicing =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionSlicingSerializer,
              null,
            )
        15 -> short = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _short =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> definition = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _definition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> requirements = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _requirements =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          alias =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        24 ->
          _alias =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        25 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        26 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 ->
          base =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionBaseSerializer,
              null,
            )
        30 -> contentReference = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _contentReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionTypeSerializer.listSerializer,
              null,
            )
        33 -> defaultValueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _defaultValueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 -> defaultValueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        36 ->
          _defaultValueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> defaultValueCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _defaultValueCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> defaultValueCode = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _defaultValueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> defaultValueDate = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _defaultValueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> defaultValueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _defaultValueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          defaultValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        46 ->
          _defaultValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 -> defaultValueId = compositeDecoder.decodeStringElement(descriptor, i)
        48 ->
          _defaultValueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 -> defaultValueInstant = compositeDecoder.decodeStringElement(descriptor, i)
        50 ->
          _defaultValueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        51 -> defaultValueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        52 ->
          _defaultValueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        53 -> defaultValueInteger64 = compositeDecoder.decodeStringElement(descriptor, i)
        54 ->
          _defaultValueInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        55 -> defaultValueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        56 ->
          _defaultValueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        57 -> defaultValueOid = compositeDecoder.decodeStringElement(descriptor, i)
        58 ->
          _defaultValueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        59 -> defaultValuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        60 ->
          _defaultValuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        61 -> defaultValueString = compositeDecoder.decodeStringElement(descriptor, i)
        62 ->
          _defaultValueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        63 ->
          defaultValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        64 ->
          _defaultValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        65 -> defaultValueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        66 ->
          _defaultValueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        67 -> defaultValueUri = compositeDecoder.decodeStringElement(descriptor, i)
        68 ->
          _defaultValueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        69 -> defaultValueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        70 ->
          _defaultValueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        71 -> defaultValueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        72 ->
          _defaultValueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        73 ->
          defaultValueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        74 ->
          defaultValueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        75 ->
          defaultValueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        76 ->
          defaultValueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        77 ->
          defaultValueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        78 ->
          defaultValueCodeableReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        79 ->
          defaultValueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        80 ->
          defaultValueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        81 ->
          defaultValueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        82 ->
          defaultValueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        83 ->
          defaultValueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        84 ->
          defaultValueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        85 ->
          defaultValueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        86 ->
          defaultValueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        87 ->
          defaultValuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        88 ->
          defaultValueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        89 ->
          defaultValueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        90 ->
          defaultValueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        91 ->
          defaultValueRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        92 ->
          defaultValueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        93 ->
          defaultValueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        94 ->
          defaultValueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        95 ->
          defaultValueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        96 ->
          defaultValueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        97 ->
          defaultValueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        98 ->
          defaultValueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        99 ->
          defaultValueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        100 ->
          defaultValueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        101 ->
          defaultValueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        102 ->
          defaultValueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        103 ->
          defaultValueAvailability =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilitySerializer,
              null,
            )
        104 ->
          defaultValueExtendedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer,
              null,
            )
        105 ->
          defaultValueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        106 ->
          defaultValueMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        107 -> meaningWhenMissing = compositeDecoder.decodeStringElement(descriptor, i)
        108 ->
          _meaningWhenMissing =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        109 -> orderMeaning = compositeDecoder.decodeStringElement(descriptor, i)
        110 ->
          _orderMeaning =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        111 -> fixedBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        112 ->
          _fixedBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        113 -> fixedBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        114 ->
          _fixedBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        115 -> fixedCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        116 ->
          _fixedCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        117 -> fixedCode = compositeDecoder.decodeStringElement(descriptor, i)
        118 ->
          _fixedCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        119 -> fixedDate = compositeDecoder.decodeStringElement(descriptor, i)
        120 ->
          _fixedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        121 -> fixedDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        122 ->
          _fixedDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        123 ->
          fixedDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        124 ->
          _fixedDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        125 -> fixedId = compositeDecoder.decodeStringElement(descriptor, i)
        126 ->
          _fixedId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        127 -> fixedInstant = compositeDecoder.decodeStringElement(descriptor, i)
        128 ->
          _fixedInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        129 -> fixedInteger = compositeDecoder.decodeIntElement(descriptor, i)
        130 ->
          _fixedInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        131 -> fixedInteger64 = compositeDecoder.decodeStringElement(descriptor, i)
        132 ->
          _fixedInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        133 -> fixedMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        134 ->
          _fixedMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        135 -> fixedOid = compositeDecoder.decodeStringElement(descriptor, i)
        136 ->
          _fixedOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        137 -> fixedPositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        138 ->
          _fixedPositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        139 -> fixedString = compositeDecoder.decodeStringElement(descriptor, i)
        140 ->
          _fixedString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        141 ->
          fixedTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        142 ->
          _fixedTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        143 -> fixedUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        144 ->
          _fixedUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        145 -> fixedUri = compositeDecoder.decodeStringElement(descriptor, i)
        146 ->
          _fixedUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        147 -> fixedUrl = compositeDecoder.decodeStringElement(descriptor, i)
        148 ->
          _fixedUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        149 -> fixedUuid = compositeDecoder.decodeStringElement(descriptor, i)
        150 ->
          _fixedUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        151 ->
          fixedAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        152 ->
          fixedAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        153 ->
          fixedAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        154 ->
          fixedAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        155 ->
          fixedCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        156 ->
          fixedCodeableReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        157 ->
          fixedCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        158 ->
          fixedContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        159 ->
          fixedCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        160 ->
          fixedDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        161 ->
          fixedDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        162 ->
          fixedHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        163 ->
          fixedIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        164 ->
          fixedMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        165 ->
          fixedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        166 ->
          fixedQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        167 ->
          fixedRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        168 ->
          fixedRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        169 ->
          fixedRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        170 ->
          fixedReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        171 ->
          fixedSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        172 ->
          fixedSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        173 ->
          fixedTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        174 ->
          fixedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        175 ->
          fixedDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        176 ->
          fixedExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        177 ->
          fixedParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        178 ->
          fixedRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        179 ->
          fixedTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        180 ->
          fixedUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        181 ->
          fixedAvailability =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilitySerializer,
              null,
            )
        182 ->
          fixedExtendedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer,
              null,
            )
        183 ->
          fixedDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        184 ->
          fixedMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        185 -> patternBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        186 ->
          _patternBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        187 -> patternBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        188 ->
          _patternBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        189 -> patternCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        190 ->
          _patternCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        191 -> patternCode = compositeDecoder.decodeStringElement(descriptor, i)
        192 ->
          _patternCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        193 -> patternDate = compositeDecoder.decodeStringElement(descriptor, i)
        194 ->
          _patternDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        195 -> patternDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        196 ->
          _patternDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        197 ->
          patternDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        198 ->
          _patternDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        199 -> patternId = compositeDecoder.decodeStringElement(descriptor, i)
        200 ->
          _patternId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        201 -> patternInstant = compositeDecoder.decodeStringElement(descriptor, i)
        202 ->
          _patternInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        203 -> patternInteger = compositeDecoder.decodeIntElement(descriptor, i)
        204 ->
          _patternInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        205 -> patternInteger64 = compositeDecoder.decodeStringElement(descriptor, i)
        206 ->
          _patternInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        207 -> patternMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        208 ->
          _patternMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        209 -> patternOid = compositeDecoder.decodeStringElement(descriptor, i)
        210 ->
          _patternOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        211 -> patternPositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        212 ->
          _patternPositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        213 -> patternString = compositeDecoder.decodeStringElement(descriptor, i)
        214 ->
          _patternString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        215 ->
          patternTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        216 ->
          _patternTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        217 -> patternUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        218 ->
          _patternUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        219 -> patternUri = compositeDecoder.decodeStringElement(descriptor, i)
        220 ->
          _patternUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        221 -> patternUrl = compositeDecoder.decodeStringElement(descriptor, i)
        222 ->
          _patternUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        223 -> patternUuid = compositeDecoder.decodeStringElement(descriptor, i)
        224 ->
          _patternUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        225 ->
          patternAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        226 ->
          patternAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        227 ->
          patternAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        228 ->
          patternAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        229 ->
          patternCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        230 ->
          patternCodeableReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        231 ->
          patternCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        232 ->
          patternContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        233 ->
          patternCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        234 ->
          patternDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        235 ->
          patternDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        236 ->
          patternHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        237 ->
          patternIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        238 ->
          patternMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        239 ->
          patternPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        240 ->
          patternQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        241 ->
          patternRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        242 ->
          patternRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        243 ->
          patternRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        244 ->
          patternReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        245 ->
          patternSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        246 ->
          patternSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        247 ->
          patternTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        248 ->
          patternContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        249 ->
          patternDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        250 ->
          patternExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        251 ->
          patternParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        252 ->
          patternRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        253 ->
          patternTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        254 ->
          patternUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        255 ->
          patternAvailability =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilitySerializer,
              null,
            )
        256 ->
          patternExtendedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer,
              null,
            )
        257 ->
          patternDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        258 ->
          patternMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        259 ->
          example =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionExampleSerializer.listSerializer,
              null,
            )
        260 -> minValueDate = compositeDecoder.decodeStringElement(descriptor, i)
        261 ->
          _minValueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        262 -> minValueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        263 ->
          _minValueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        264 -> minValueInstant = compositeDecoder.decodeStringElement(descriptor, i)
        265 ->
          _minValueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        266 ->
          minValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        267 ->
          _minValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        268 ->
          minValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        269 ->
          _minValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        270 -> minValueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        271 ->
          _minValueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        272 -> minValueInteger64 = compositeDecoder.decodeStringElement(descriptor, i)
        273 ->
          _minValueInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        274 -> minValuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        275 ->
          _minValuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        276 -> minValueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        277 ->
          _minValueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        278 ->
          minValueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        279 -> maxValueDate = compositeDecoder.decodeStringElement(descriptor, i)
        280 ->
          _maxValueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        281 -> maxValueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        282 ->
          _maxValueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        283 -> maxValueInstant = compositeDecoder.decodeStringElement(descriptor, i)
        284 ->
          _maxValueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        285 ->
          maxValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        286 ->
          _maxValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        287 ->
          maxValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        288 ->
          _maxValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        289 -> maxValueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        290 ->
          _maxValueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        291 -> maxValueInteger64 = compositeDecoder.decodeStringElement(descriptor, i)
        292 ->
          _maxValueInteger64 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        293 -> maxValuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        294 ->
          _maxValuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        295 -> maxValueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        296 ->
          _maxValueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        297 ->
          maxValueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        298 -> maxLength = compositeDecoder.decodeIntElement(descriptor, i)
        299 ->
          _maxLength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        300 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        301 ->
          _condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        302 ->
          constraint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionConstraintSerializer.listSerializer,
              null,
            )
        303 -> mustHaveValue = compositeDecoder.decodeBooleanElement(descriptor, i)
        304 ->
          _mustHaveValue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        305 ->
          valueAlternatives =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        306 ->
          _valueAlternatives =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        307 -> mustSupport = compositeDecoder.decodeBooleanElement(descriptor, i)
        308 ->
          _mustSupport =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        309 -> isModifier = compositeDecoder.decodeBooleanElement(descriptor, i)
        310 ->
          _isModifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        311 -> isModifierReason = compositeDecoder.decodeStringElement(descriptor, i)
        312 ->
          _isModifierReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        313 -> isSummary = compositeDecoder.decodeBooleanElement(descriptor, i)
        314 ->
          _isSummary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        315 ->
          binding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionBindingSerializer,
              null,
            )
        316 ->
          mapping =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionMappingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ElementDefinition: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ElementDefinition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path =
        R5String.of(path, _path)
          ?: throw SerializationException("Missing required property 'path' on ElementDefinition"),
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
      sliceName = R5String.of(sliceName, _sliceName),
      sliceIsConstraining = R5Boolean.of(sliceIsConstraining, _sliceIsConstraining),
      label = R5String.of(label, _label),
      code = code ?: listOf(),
      slicing = slicing,
      short = R5String.of(short, _short),
      definition = Markdown.of(definition, _definition),
      comment = Markdown.of(comment, _comment),
      requirements = Markdown.of(requirements, _requirements),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
          R5String.of(alias?.getOrNull(index), _alias?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'alias' on ElementDefinition has neither a value nor an id/extension"
            )
        }),
      min = UnsignedInt.of(min, _min),
      max = R5String.of(max, _max),
      base = base,
      contentReference = Uri.of(contentReference, _contentReference),
      type = type ?: listOf(),
      defaultValue =
        ElementDefinition.DefaultValue.from(
          Base64Binary.of(defaultValueBase64Binary, _defaultValueBase64Binary),
          R5Boolean.of(defaultValueBoolean, _defaultValueBoolean),
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
            if (defaultValueInstant != null) FhirDateTime.fromString(defaultValueInstant) else null,
            _defaultValueInstant,
          ),
          Integer.of(defaultValueInteger, _defaultValueInteger),
          Integer64.of(defaultValueInteger64?.toLong(), _defaultValueInteger64),
          Markdown.of(defaultValueMarkdown, _defaultValueMarkdown),
          Oid.of(defaultValueOid, _defaultValueOid),
          PositiveInt.of(defaultValuePositiveInt, _defaultValuePositiveInt),
          R5String.of(defaultValueString, _defaultValueString),
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
          defaultValueDataRequirement,
          defaultValueExpression,
          defaultValueParameterDefinition,
          defaultValueRelatedArtifact,
          defaultValueTriggerDefinition,
          defaultValueUsageContext,
          defaultValueAvailability,
          defaultValueExtendedContactDetail,
          defaultValueDosage,
          defaultValueMeta,
        ),
      meaningWhenMissing = Markdown.of(meaningWhenMissing, _meaningWhenMissing),
      orderMeaning = R5String.of(orderMeaning, _orderMeaning),
      fixed =
        ElementDefinition.Fixed.from(
          Base64Binary.of(fixedBase64Binary, _fixedBase64Binary),
          R5Boolean.of(fixedBoolean, _fixedBoolean),
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
          Integer64.of(fixedInteger64?.toLong(), _fixedInteger64),
          Markdown.of(fixedMarkdown, _fixedMarkdown),
          Oid.of(fixedOid, _fixedOid),
          PositiveInt.of(fixedPositiveInt, _fixedPositiveInt),
          R5String.of(fixedString, _fixedString),
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
          fixedDataRequirement,
          fixedExpression,
          fixedParameterDefinition,
          fixedRelatedArtifact,
          fixedTriggerDefinition,
          fixedUsageContext,
          fixedAvailability,
          fixedExtendedContactDetail,
          fixedDosage,
          fixedMeta,
        ),
      pattern =
        ElementDefinition.Pattern.from(
          Base64Binary.of(patternBase64Binary, _patternBase64Binary),
          R5Boolean.of(patternBoolean, _patternBoolean),
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
          Integer64.of(patternInteger64?.toLong(), _patternInteger64),
          Markdown.of(patternMarkdown, _patternMarkdown),
          Oid.of(patternOid, _patternOid),
          PositiveInt.of(patternPositiveInt, _patternPositiveInt),
          R5String.of(patternString, _patternString),
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
          patternDataRequirement,
          patternExpression,
          patternParameterDefinition,
          patternRelatedArtifact,
          patternTriggerDefinition,
          patternUsageContext,
          patternAvailability,
          patternExtendedContactDetail,
          patternDosage,
          patternMeta,
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
          Integer64.of(minValueInteger64?.toLong(), _minValueInteger64),
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
          Integer64.of(maxValueInteger64?.toLong(), _maxValueInteger64),
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
      mustHaveValue = R5Boolean.of(mustHaveValue, _mustHaveValue),
      valueAlternatives =
        (kotlin.collections.List(
          maxOf(valueAlternatives?.size ?: 0, _valueAlternatives?.size ?: 0)
        ) { index ->
          Canonical.of(valueAlternatives?.getOrNull(index), _valueAlternatives?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'valueAlternatives' on ElementDefinition has neither a value nor an id/extension"
            )
        }),
      mustSupport = R5Boolean.of(mustSupport, _mustSupport),
      isModifier = R5Boolean.of(isModifier, _isModifier),
      isModifierReason = R5String.of(isModifierReason, _isModifierReason),
      isSummary = R5Boolean.of(isSummary, _isSummary),
      binding = binding,
      mapping = mapping ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.path.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.path)
    if (value.representation.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        stringNullableListSerializer,
        value.representation.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.representation)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.sliceName?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.sliceName)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 9, value.sliceIsConstraining?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.sliceIsConstraining)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.label?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.label)
    if (value.code.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13,
        CodingSerializer.listSerializer,
        value.code,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      ElementDefinitionSlicingSerializer,
      value.slicing,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.short?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.short)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17, value.definition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.definition)
    compositeEncoder.encodeStringIfNotNull(descriptor, 19, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20, value.comment)
    compositeEncoder.encodeStringIfNotNull(descriptor, 21, value.requirements?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.requirements)
    if (value.alias.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        23,
        stringNullableListSerializer,
        value.alias.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 24, value.alias)
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 25, value.min?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 26, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 27, value.max?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 28, value.max)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29,
      ElementDefinitionBaseSerializer,
      value.base,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 30, value.contentReference?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 31, value.contentReference)
    if (value.type.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32,
        ElementDefinitionTypeSerializer.listSerializer,
        value.type,
      )
    when (val choice = value.defaultValue) {
      null -> {}
      is ElementDefinition.DefaultValue.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 33, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 34, choice.value)
      }
      is ElementDefinition.DefaultValue.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 35, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 36, choice.value)
      }
      is ElementDefinition.DefaultValue.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 37, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 38, choice.value)
      }
      is ElementDefinition.DefaultValue.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 39, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 40, choice.value)
      }
      is ElementDefinition.DefaultValue.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 41, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 42, choice.value)
      }
      is ElementDefinition.DefaultValue.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 43, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 44, choice.value)
      }
      is ElementDefinition.DefaultValue.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          45,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 46, choice.value)
      }
      is ElementDefinition.DefaultValue.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 47, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 48, choice.value)
      }
      is ElementDefinition.DefaultValue.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 49, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 50, choice.value)
      }
      is ElementDefinition.DefaultValue.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 51, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 52, choice.value)
      }
      is ElementDefinition.DefaultValue.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 53, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 54, choice.value)
      }
      is ElementDefinition.DefaultValue.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 55, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 56, choice.value)
      }
      is ElementDefinition.DefaultValue.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 57, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 58, choice.value)
      }
      is ElementDefinition.DefaultValue.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 59, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 60, choice.value)
      }
      is ElementDefinition.DefaultValue.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 61, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 62, choice.value)
      }
      is ElementDefinition.DefaultValue.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          63,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 64, choice.value)
      }
      is ElementDefinition.DefaultValue.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 65, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 66, choice.value)
      }
      is ElementDefinition.DefaultValue.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 67, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 68, choice.value)
      }
      is ElementDefinition.DefaultValue.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 69, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 70, choice.value)
      }
      is ElementDefinition.DefaultValue.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 71, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 72, choice.value)
      }
      is ElementDefinition.DefaultValue.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 73, AddressSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 74, AgeSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          75,
          AnnotationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          76,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          77,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.CodeableReference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          78,
          CodeableReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 79, CodingSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          80,
          ContactPointSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 81, CountSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 82, DistanceSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 83, DurationSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          84,
          HumanNameSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          85,
          IdentifierSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 86, MoneySerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 87, PeriodSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 88, QuantitySerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 89, RangeSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 90, RatioSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          91,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          92,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          93,
          SampledDataSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          94,
          SignatureSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 95, TimingSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          96,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          97,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          98,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          99,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          100,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          101,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          102,
          UsageContextSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Availability -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          103,
          AvailabilitySerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.ExtendedContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          104,
          ExtendedContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 105, DosageSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 106, MetaSerializer, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 107, value.meaningWhenMissing?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 108, value.meaningWhenMissing)
    compositeEncoder.encodeStringIfNotNull(descriptor, 109, value.orderMeaning?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 110, value.orderMeaning)
    when (val choice = value.fixed) {
      null -> {}
      is ElementDefinition.Fixed.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 111, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 112, choice.value)
      }
      is ElementDefinition.Fixed.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 113, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 114, choice.value)
      }
      is ElementDefinition.Fixed.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 115, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 116, choice.value)
      }
      is ElementDefinition.Fixed.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 117, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 118, choice.value)
      }
      is ElementDefinition.Fixed.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 119, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 120, choice.value)
      }
      is ElementDefinition.Fixed.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 121, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 122, choice.value)
      }
      is ElementDefinition.Fixed.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          123,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 124, choice.value)
      }
      is ElementDefinition.Fixed.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 125, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 126, choice.value)
      }
      is ElementDefinition.Fixed.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 127, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 128, choice.value)
      }
      is ElementDefinition.Fixed.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 129, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 130, choice.value)
      }
      is ElementDefinition.Fixed.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 131, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 132, choice.value)
      }
      is ElementDefinition.Fixed.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 133, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 134, choice.value)
      }
      is ElementDefinition.Fixed.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 135, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 136, choice.value)
      }
      is ElementDefinition.Fixed.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 137, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 138, choice.value)
      }
      is ElementDefinition.Fixed.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 139, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 140, choice.value)
      }
      is ElementDefinition.Fixed.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          141,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 142, choice.value)
      }
      is ElementDefinition.Fixed.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 143, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 144, choice.value)
      }
      is ElementDefinition.Fixed.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 145, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 146, choice.value)
      }
      is ElementDefinition.Fixed.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 147, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 148, choice.value)
      }
      is ElementDefinition.Fixed.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 149, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 150, choice.value)
      }
      is ElementDefinition.Fixed.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 151, AddressSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 152, AgeSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          153,
          AnnotationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          154,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          155,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.CodeableReference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          156,
          CodeableReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 157, CodingSerializer, choice.value)
      }
      is ElementDefinition.Fixed.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          158,
          ContactPointSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 159, CountSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Distance -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          160,
          DistanceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Duration -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          161,
          DurationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          162,
          HumanNameSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          163,
          IdentifierSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 164, MoneySerializer, choice.value)
      }
      is ElementDefinition.Fixed.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 165, PeriodSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          166,
          QuantitySerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 167, RangeSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 168, RatioSerializer, choice.value)
      }
      is ElementDefinition.Fixed.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          169,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          170,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          171,
          SampledDataSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          172,
          SignatureSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 173, TimingSerializer, choice.value)
      }
      is ElementDefinition.Fixed.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          174,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          175,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          176,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          177,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          178,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          179,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          180,
          UsageContextSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Availability -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          181,
          AvailabilitySerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.ExtendedContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          182,
          ExtendedContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 183, DosageSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 184, MetaSerializer, choice.value)
      }
    }
    when (val choice = value.pattern) {
      null -> {}
      is ElementDefinition.Pattern.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 185, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 186, choice.value)
      }
      is ElementDefinition.Pattern.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 187, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 188, choice.value)
      }
      is ElementDefinition.Pattern.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 189, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 190, choice.value)
      }
      is ElementDefinition.Pattern.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 191, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 192, choice.value)
      }
      is ElementDefinition.Pattern.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 193, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 194, choice.value)
      }
      is ElementDefinition.Pattern.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 195, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 196, choice.value)
      }
      is ElementDefinition.Pattern.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          197,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 198, choice.value)
      }
      is ElementDefinition.Pattern.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 199, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 200, choice.value)
      }
      is ElementDefinition.Pattern.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 201, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 202, choice.value)
      }
      is ElementDefinition.Pattern.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 203, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 204, choice.value)
      }
      is ElementDefinition.Pattern.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 205, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 206, choice.value)
      }
      is ElementDefinition.Pattern.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 207, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 208, choice.value)
      }
      is ElementDefinition.Pattern.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 209, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 210, choice.value)
      }
      is ElementDefinition.Pattern.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 211, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 212, choice.value)
      }
      is ElementDefinition.Pattern.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 213, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 214, choice.value)
      }
      is ElementDefinition.Pattern.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          215,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 216, choice.value)
      }
      is ElementDefinition.Pattern.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 217, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 218, choice.value)
      }
      is ElementDefinition.Pattern.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 219, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 220, choice.value)
      }
      is ElementDefinition.Pattern.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 221, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 222, choice.value)
      }
      is ElementDefinition.Pattern.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 223, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 224, choice.value)
      }
      is ElementDefinition.Pattern.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 225, AddressSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 226, AgeSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          227,
          AnnotationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          228,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          229,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.CodeableReference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          230,
          CodeableReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 231, CodingSerializer, choice.value)
      }
      is ElementDefinition.Pattern.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          232,
          ContactPointSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 233, CountSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Distance -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          234,
          DistanceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Duration -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          235,
          DurationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          236,
          HumanNameSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          237,
          IdentifierSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 238, MoneySerializer, choice.value)
      }
      is ElementDefinition.Pattern.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 239, PeriodSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          240,
          QuantitySerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 241, RangeSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 242, RatioSerializer, choice.value)
      }
      is ElementDefinition.Pattern.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          243,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          244,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          245,
          SampledDataSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          246,
          SignatureSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 247, TimingSerializer, choice.value)
      }
      is ElementDefinition.Pattern.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          248,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          249,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          250,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          251,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          252,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          253,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          254,
          UsageContextSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Availability -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          255,
          AvailabilitySerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.ExtendedContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          256,
          ExtendedContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 257, DosageSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 258, MetaSerializer, choice.value)
      }
    }
    if (value.example.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        259,
        ElementDefinitionExampleSerializer.listSerializer,
        value.example,
      )
    when (val choice = value.minValue) {
      null -> {}
      is ElementDefinition.MinValue.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 260, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 261, choice.value)
      }
      is ElementDefinition.MinValue.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 262, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 263, choice.value)
      }
      is ElementDefinition.MinValue.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 264, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 265, choice.value)
      }
      is ElementDefinition.MinValue.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          266,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 267, choice.value)
      }
      is ElementDefinition.MinValue.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          268,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 269, choice.value)
      }
      is ElementDefinition.MinValue.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 270, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 271, choice.value)
      }
      is ElementDefinition.MinValue.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 272, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 273, choice.value)
      }
      is ElementDefinition.MinValue.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 274, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 275, choice.value)
      }
      is ElementDefinition.MinValue.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 276, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 277, choice.value)
      }
      is ElementDefinition.MinValue.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          278,
          QuantitySerializer,
          choice.value,
        )
      }
    }
    when (val choice = value.maxValue) {
      null -> {}
      is ElementDefinition.MaxValue.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 279, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 280, choice.value)
      }
      is ElementDefinition.MaxValue.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 281, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 282, choice.value)
      }
      is ElementDefinition.MaxValue.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 283, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 284, choice.value)
      }
      is ElementDefinition.MaxValue.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          285,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 286, choice.value)
      }
      is ElementDefinition.MaxValue.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          287,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 288, choice.value)
      }
      is ElementDefinition.MaxValue.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 289, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 290, choice.value)
      }
      is ElementDefinition.MaxValue.Integer64 -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 291, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 292, choice.value)
      }
      is ElementDefinition.MaxValue.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 293, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 294, choice.value)
      }
      is ElementDefinition.MaxValue.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 295, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 296, choice.value)
      }
      is ElementDefinition.MaxValue.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          297,
          QuantitySerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 298, value.maxLength?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 299, value.maxLength)
    if (value.condition.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        300,
        stringNullableListSerializer,
        value.condition.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 301, value.condition)
    }
    if (value.constraint.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        302,
        ElementDefinitionConstraintSerializer.listSerializer,
        value.constraint,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 303, value.mustHaveValue?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 304, value.mustHaveValue)
    if (value.valueAlternatives.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        305,
        stringNullableListSerializer,
        value.valueAlternatives.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 306, value.valueAlternatives)
    }
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 307, value.mustSupport?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 308, value.mustSupport)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 309, value.isModifier?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 310, value.isModifier)
    compositeEncoder.encodeStringIfNotNull(descriptor, 311, value.isModifierReason?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 312, value.isModifierReason)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 313, value.isSummary?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 314, value.isSummary)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      315,
      ElementDefinitionBindingSerializer,
      value.binding,
    )
    if (value.mapping.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        316,
        ElementDefinitionMappingSerializer.listSerializer,
        value.mapping,
      )
    compositeEncoder.endStructure(descriptor)
  }
}
