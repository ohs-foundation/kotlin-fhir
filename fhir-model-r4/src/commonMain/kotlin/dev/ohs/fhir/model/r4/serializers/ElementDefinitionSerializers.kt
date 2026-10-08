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
import dev.ohs.fhir.model.r4.ElementDefinition
import dev.ohs.fhir.model.r4.Enumeration
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
import dev.ohs.fhir.model.r4.terminologies.AggregationMode
import dev.ohs.fhir.model.r4.terminologies.BindingStrength
import dev.ohs.fhir.model.r4.terminologies.ConstraintSeverity
import dev.ohs.fhir.model.r4.terminologies.DiscriminatorType
import dev.ohs.fhir.model.r4.terminologies.PropertyRepresentation
import dev.ohs.fhir.model.r4.terminologies.ReferenceVersionRules
import dev.ohs.fhir.model.r4.terminologies.SlicingRules
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
      description = R4String.of(description, _description),
      ordered = R4Boolean.of(ordered, _ordered),
      rules =
        Enumeration.of(if (rules != null) SlicingRules.fromCode(rules) else null, _rules)
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
        Enumeration.of(if (type != null) DiscriminatorType.fromCode(type) else null, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on ElementDefinition.Slicing.Discriminator"
          ),
      path =
        R4String.of(path, _path)
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
        R4String.of(path, _path)
          ?: throw SerializationException(
            "Missing required property 'path' on ElementDefinition.Base"
          ),
      min =
        UnsignedInt.of(min, _min)
          ?: throw SerializationException(
            "Missing required property 'min' on ElementDefinition.Base"
          ),
      max =
        R4String.of(max, _max)
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
            aggregation?.getOrNull(index)?.let { AggregationMode.fromCode(it) },
            _aggregation?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'aggregation' on ElementDefinition.Type has neither a value nor an id/extension"
            )
        }),
      versioning =
        Enumeration.of(
          if (versioning != null) ReferenceVersionRules.fromCode(versioning) else null,
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
        24 -> valueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _valueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> valueOid = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _valueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> valuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        29 ->
          _valuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        33 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> valueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        35 ->
          _valueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> valueUri = compositeDecoder.decodeStringElement(descriptor, i)
        37 ->
          _valueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 -> valueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _valueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 -> valueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _valueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 ->
          valueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        43 ->
          valueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        44 ->
          valueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        45 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        46 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        47 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        48 ->
          valueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        49 ->
          valueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        50 ->
          valueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        51 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        52 ->
          valueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        53 ->
          valueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        54 ->
          valueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        55 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        56 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        57 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        58 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        59 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        60 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        61 ->
          valueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        62 ->
          valueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        63 ->
          valueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        64 ->
          valueContributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContributorSerializer,
              null,
            )
        65 ->
          valueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        66 ->
          valueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        67 ->
          valueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        68 ->
          valueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        69 ->
          valueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        70 ->
          valueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        71 ->
          valueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        72 ->
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
        R4String.of(label, _label)
          ?: throw SerializationException(
            "Missing required property 'label' on ElementDefinition.Example"
          ),
      `value` =
        ElementDefinition.Example.Value.from(
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
      is ElementDefinition.Example.Value.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 24, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 25, choice.value)
      }
      is ElementDefinition.Example.Value.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 26, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 27, choice.value)
      }
      is ElementDefinition.Example.Value.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 28, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 29, choice.value)
      }
      is ElementDefinition.Example.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 30, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 31, choice.value)
      }
      is ElementDefinition.Example.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          32,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 33, choice.value)
      }
      is ElementDefinition.Example.Value.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 34, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 35, choice.value)
      }
      is ElementDefinition.Example.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 36, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 37, choice.value)
      }
      is ElementDefinition.Example.Value.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 38, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 39, choice.value)
      }
      is ElementDefinition.Example.Value.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 40, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 41, choice.value)
      }
      is ElementDefinition.Example.Value.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 42, AddressSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 43, AgeSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          44,
          AnnotationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          45,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          46,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 47, CodingSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          48,
          ContactPointSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 49, CountSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 50, DistanceSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 51, DurationSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          52,
          HumanNameSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          53,
          IdentifierSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 54, MoneySerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 55, PeriodSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 56, QuantitySerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 57, RangeSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 58, RatioSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          59,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          60,
          SampledDataSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          61,
          SignatureSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 62, TimingSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          63,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Contributor -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          64,
          ContributorSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          65,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          66,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          67,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          68,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          69,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          70,
          UsageContextSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 71, DosageSerializer, choice.value)
      }
      is ElementDefinition.Example.Value.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 72, MetaSerializer, choice.value)
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
    var human: KotlinString? = null
    var _human: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var xpath: KotlinString? = null
    var _xpath: Element? = null
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
        8 -> human = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _human =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> xpath = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _xpath =
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
      requirements = R4String.of(requirements, _requirements),
      severity =
        Enumeration.of(
          if (severity != null) ConstraintSeverity.fromCode(severity) else null,
          _severity,
        )
          ?: throw SerializationException(
            "Missing required property 'severity' on ElementDefinition.Constraint"
          ),
      human =
        R4String.of(human, _human)
          ?: throw SerializationException(
            "Missing required property 'human' on ElementDefinition.Constraint"
          ),
      expression = R4String.of(expression, _expression),
      xpath = R4String.of(xpath, _xpath),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.human.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.human)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.expression?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.expression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.xpath?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.xpath)
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
      description = R4String.of(description, _description),
      valueSet = Canonical.of(valueSet, _valueSet),
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
        R4String.of(map, _map)
          ?: throw SerializationException(
            "Missing required property 'map' on ElementDefinition.Mapping"
          ),
      comment = R4String.of(comment, _comment),
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
        53 -> defaultValueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        54 ->
          _defaultValueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        55 -> defaultValueOid = compositeDecoder.decodeStringElement(descriptor, i)
        56 ->
          _defaultValueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        57 -> defaultValuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        58 ->
          _defaultValuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        59 -> defaultValueString = compositeDecoder.decodeStringElement(descriptor, i)
        60 ->
          _defaultValueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        61 ->
          defaultValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        62 ->
          _defaultValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        63 -> defaultValueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        64 ->
          _defaultValueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        65 -> defaultValueUri = compositeDecoder.decodeStringElement(descriptor, i)
        66 ->
          _defaultValueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        67 -> defaultValueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        68 ->
          _defaultValueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        69 -> defaultValueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        70 ->
          _defaultValueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        71 ->
          defaultValueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        72 ->
          defaultValueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        73 ->
          defaultValueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        74 ->
          defaultValueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        75 ->
          defaultValueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        76 ->
          defaultValueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        77 ->
          defaultValueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        78 ->
          defaultValueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        79 ->
          defaultValueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        80 ->
          defaultValueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        81 ->
          defaultValueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        82 ->
          defaultValueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        83 ->
          defaultValueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        84 ->
          defaultValuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        85 ->
          defaultValueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        86 ->
          defaultValueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        87 ->
          defaultValueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        88 ->
          defaultValueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        89 ->
          defaultValueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        90 ->
          defaultValueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        91 ->
          defaultValueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        92 ->
          defaultValueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        93 ->
          defaultValueContributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContributorSerializer,
              null,
            )
        94 ->
          defaultValueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        95 ->
          defaultValueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        96 ->
          defaultValueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        97 ->
          defaultValueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        98 ->
          defaultValueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        99 ->
          defaultValueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        100 ->
          defaultValueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        101 ->
          defaultValueMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        102 -> meaningWhenMissing = compositeDecoder.decodeStringElement(descriptor, i)
        103 ->
          _meaningWhenMissing =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        104 -> orderMeaning = compositeDecoder.decodeStringElement(descriptor, i)
        105 ->
          _orderMeaning =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        106 -> fixedBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        107 ->
          _fixedBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        108 -> fixedBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        109 ->
          _fixedBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        110 -> fixedCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        111 ->
          _fixedCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        112 -> fixedCode = compositeDecoder.decodeStringElement(descriptor, i)
        113 ->
          _fixedCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        114 -> fixedDate = compositeDecoder.decodeStringElement(descriptor, i)
        115 ->
          _fixedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        116 -> fixedDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        117 ->
          _fixedDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        118 ->
          fixedDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        119 ->
          _fixedDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        120 -> fixedId = compositeDecoder.decodeStringElement(descriptor, i)
        121 ->
          _fixedId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        122 -> fixedInstant = compositeDecoder.decodeStringElement(descriptor, i)
        123 ->
          _fixedInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        124 -> fixedInteger = compositeDecoder.decodeIntElement(descriptor, i)
        125 ->
          _fixedInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        126 -> fixedMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        127 ->
          _fixedMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        128 -> fixedOid = compositeDecoder.decodeStringElement(descriptor, i)
        129 ->
          _fixedOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        130 -> fixedPositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        131 ->
          _fixedPositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        132 -> fixedString = compositeDecoder.decodeStringElement(descriptor, i)
        133 ->
          _fixedString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        134 ->
          fixedTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        135 ->
          _fixedTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        136 -> fixedUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        137 ->
          _fixedUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        138 -> fixedUri = compositeDecoder.decodeStringElement(descriptor, i)
        139 ->
          _fixedUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        140 -> fixedUrl = compositeDecoder.decodeStringElement(descriptor, i)
        141 ->
          _fixedUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        142 -> fixedUuid = compositeDecoder.decodeStringElement(descriptor, i)
        143 ->
          _fixedUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        144 ->
          fixedAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        145 ->
          fixedAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        146 ->
          fixedAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        147 ->
          fixedAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        148 ->
          fixedCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        149 ->
          fixedCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        150 ->
          fixedContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        151 ->
          fixedCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        152 ->
          fixedDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        153 ->
          fixedDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        154 ->
          fixedHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        155 ->
          fixedIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        156 ->
          fixedMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        157 ->
          fixedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        158 ->
          fixedQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        159 ->
          fixedRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        160 ->
          fixedRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        161 ->
          fixedReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        162 ->
          fixedSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        163 ->
          fixedSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        164 ->
          fixedTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        165 ->
          fixedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        166 ->
          fixedContributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContributorSerializer,
              null,
            )
        167 ->
          fixedDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        168 ->
          fixedExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        169 ->
          fixedParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        170 ->
          fixedRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        171 ->
          fixedTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        172 ->
          fixedUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        173 ->
          fixedDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        174 ->
          fixedMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        175 -> patternBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        176 ->
          _patternBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        177 -> patternBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        178 ->
          _patternBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        179 -> patternCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        180 ->
          _patternCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        181 -> patternCode = compositeDecoder.decodeStringElement(descriptor, i)
        182 ->
          _patternCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        183 -> patternDate = compositeDecoder.decodeStringElement(descriptor, i)
        184 ->
          _patternDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        185 -> patternDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        186 ->
          _patternDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        187 ->
          patternDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        188 ->
          _patternDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        189 -> patternId = compositeDecoder.decodeStringElement(descriptor, i)
        190 ->
          _patternId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        191 -> patternInstant = compositeDecoder.decodeStringElement(descriptor, i)
        192 ->
          _patternInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        193 -> patternInteger = compositeDecoder.decodeIntElement(descriptor, i)
        194 ->
          _patternInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        195 -> patternMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        196 ->
          _patternMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        197 -> patternOid = compositeDecoder.decodeStringElement(descriptor, i)
        198 ->
          _patternOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        199 -> patternPositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        200 ->
          _patternPositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        201 -> patternString = compositeDecoder.decodeStringElement(descriptor, i)
        202 ->
          _patternString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        203 ->
          patternTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        204 ->
          _patternTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        205 -> patternUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        206 ->
          _patternUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        207 -> patternUri = compositeDecoder.decodeStringElement(descriptor, i)
        208 ->
          _patternUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        209 -> patternUrl = compositeDecoder.decodeStringElement(descriptor, i)
        210 ->
          _patternUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        211 -> patternUuid = compositeDecoder.decodeStringElement(descriptor, i)
        212 ->
          _patternUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        213 ->
          patternAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        214 ->
          patternAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        215 ->
          patternAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        216 ->
          patternAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        217 ->
          patternCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        218 ->
          patternCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        219 ->
          patternContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        220 ->
          patternCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        221 ->
          patternDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        222 ->
          patternDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        223 ->
          patternHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        224 ->
          patternIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        225 ->
          patternMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        226 ->
          patternPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        227 ->
          patternQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        228 ->
          patternRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        229 ->
          patternRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        230 ->
          patternReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        231 ->
          patternSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        232 ->
          patternSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        233 ->
          patternTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        234 ->
          patternContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        235 ->
          patternContributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContributorSerializer,
              null,
            )
        236 ->
          patternDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        237 ->
          patternExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        238 ->
          patternParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        239 ->
          patternRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        240 ->
          patternTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        241 ->
          patternUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        242 ->
          patternDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        243 ->
          patternMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        244 ->
          example =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionExampleSerializer.listSerializer,
              null,
            )
        245 -> minValueDate = compositeDecoder.decodeStringElement(descriptor, i)
        246 ->
          _minValueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        247 -> minValueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        248 ->
          _minValueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        249 -> minValueInstant = compositeDecoder.decodeStringElement(descriptor, i)
        250 ->
          _minValueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        251 ->
          minValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        252 ->
          _minValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        253 ->
          minValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        254 ->
          _minValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        255 -> minValueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        256 ->
          _minValueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        257 -> minValuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        258 ->
          _minValuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        259 -> minValueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        260 ->
          _minValueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        261 ->
          minValueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        262 -> maxValueDate = compositeDecoder.decodeStringElement(descriptor, i)
        263 ->
          _maxValueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        264 -> maxValueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        265 ->
          _maxValueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        266 -> maxValueInstant = compositeDecoder.decodeStringElement(descriptor, i)
        267 ->
          _maxValueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        268 ->
          maxValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        269 ->
          _maxValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        270 ->
          maxValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        271 ->
          _maxValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        272 -> maxValueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        273 ->
          _maxValueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        274 -> maxValuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        275 ->
          _maxValuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        276 -> maxValueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        277 ->
          _maxValueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        278 ->
          maxValueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        279 -> maxLength = compositeDecoder.decodeIntElement(descriptor, i)
        280 ->
          _maxLength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        281 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        282 ->
          _condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        283 ->
          constraint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionConstraintSerializer.listSerializer,
              null,
            )
        284 -> mustSupport = compositeDecoder.decodeBooleanElement(descriptor, i)
        285 ->
          _mustSupport =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        286 -> isModifier = compositeDecoder.decodeBooleanElement(descriptor, i)
        287 ->
          _isModifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        288 -> isModifierReason = compositeDecoder.decodeStringElement(descriptor, i)
        289 ->
          _isModifierReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        290 -> isSummary = compositeDecoder.decodeBooleanElement(descriptor, i)
        291 ->
          _isSummary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        292 ->
          binding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionBindingSerializer,
              null,
            )
        293 ->
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
        R4String.of(path, _path)
          ?: throw SerializationException("Missing required property 'path' on ElementDefinition"),
      representation =
        (kotlin.collections.List(maxOf(representation?.size ?: 0, _representation?.size ?: 0)) {
          index ->
          Enumeration.of(
            representation?.getOrNull(index)?.let { PropertyRepresentation.fromCode(it) },
            _representation?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'representation' on ElementDefinition has neither a value nor an id/extension"
            )
        }),
      sliceName = R4String.of(sliceName, _sliceName),
      sliceIsConstraining = R4Boolean.of(sliceIsConstraining, _sliceIsConstraining),
      label = R4String.of(label, _label),
      code = code ?: listOf(),
      slicing = slicing,
      short = R4String.of(short, _short),
      definition = Markdown.of(definition, _definition),
      comment = Markdown.of(comment, _comment),
      requirements = Markdown.of(requirements, _requirements),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
          R4String.of(alias?.getOrNull(index), _alias?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'alias' on ElementDefinition has neither a value nor an id/extension"
            )
        }),
      min = UnsignedInt.of(min, _min),
      max = R4String.of(max, _max),
      base = base,
      contentReference = Uri.of(contentReference, _contentReference),
      type = type ?: listOf(),
      defaultValue =
        ElementDefinition.DefaultValue.from(
          Base64Binary.of(defaultValueBase64Binary, _defaultValueBase64Binary),
          R4Boolean.of(defaultValueBoolean, _defaultValueBoolean),
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
          Markdown.of(defaultValueMarkdown, _defaultValueMarkdown),
          Oid.of(defaultValueOid, _defaultValueOid),
          PositiveInt.of(defaultValuePositiveInt, _defaultValuePositiveInt),
          R4String.of(defaultValueString, _defaultValueString),
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
          defaultValueMeta,
        ),
      meaningWhenMissing = Markdown.of(meaningWhenMissing, _meaningWhenMissing),
      orderMeaning = R4String.of(orderMeaning, _orderMeaning),
      fixed =
        ElementDefinition.Fixed.from(
          Base64Binary.of(fixedBase64Binary, _fixedBase64Binary),
          R4Boolean.of(fixedBoolean, _fixedBoolean),
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
          R4String.of(fixedString, _fixedString),
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
          fixedMeta,
        ),
      pattern =
        ElementDefinition.Pattern.from(
          Base64Binary.of(patternBase64Binary, _patternBase64Binary),
          R4Boolean.of(patternBoolean, _patternBoolean),
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
          R4String.of(patternString, _patternString),
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
      mustSupport = R4Boolean.of(mustSupport, _mustSupport),
      isModifier = R4Boolean.of(isModifier, _isModifier),
      isModifierReason = R4String.of(isModifierReason, _isModifierReason),
      isSummary = R4Boolean.of(isSummary, _isSummary),
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
      is ElementDefinition.DefaultValue.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 53, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 54, choice.value)
      }
      is ElementDefinition.DefaultValue.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 55, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 56, choice.value)
      }
      is ElementDefinition.DefaultValue.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 57, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 58, choice.value)
      }
      is ElementDefinition.DefaultValue.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 59, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 60, choice.value)
      }
      is ElementDefinition.DefaultValue.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          61,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 62, choice.value)
      }
      is ElementDefinition.DefaultValue.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 63, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 64, choice.value)
      }
      is ElementDefinition.DefaultValue.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 65, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 66, choice.value)
      }
      is ElementDefinition.DefaultValue.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 67, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 68, choice.value)
      }
      is ElementDefinition.DefaultValue.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 69, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 70, choice.value)
      }
      is ElementDefinition.DefaultValue.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 71, AddressSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 72, AgeSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          73,
          AnnotationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          74,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          75,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 76, CodingSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          77,
          ContactPointSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 78, CountSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 79, DistanceSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 80, DurationSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          81,
          HumanNameSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          82,
          IdentifierSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 83, MoneySerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 84, PeriodSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 85, QuantitySerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 86, RangeSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 87, RatioSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          88,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          89,
          SampledDataSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          90,
          SignatureSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 91, TimingSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          92,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Contributor -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          93,
          ContributorSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          94,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          95,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          96,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          97,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          98,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          99,
          UsageContextSerializer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 100, DosageSerializer, choice.value)
      }
      is ElementDefinition.DefaultValue.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 101, MetaSerializer, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 102, value.meaningWhenMissing?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 103, value.meaningWhenMissing)
    compositeEncoder.encodeStringIfNotNull(descriptor, 104, value.orderMeaning?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 105, value.orderMeaning)
    when (val choice = value.fixed) {
      null -> {}
      is ElementDefinition.Fixed.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 106, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 107, choice.value)
      }
      is ElementDefinition.Fixed.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 108, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 109, choice.value)
      }
      is ElementDefinition.Fixed.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 110, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 111, choice.value)
      }
      is ElementDefinition.Fixed.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 112, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 113, choice.value)
      }
      is ElementDefinition.Fixed.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 114, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 115, choice.value)
      }
      is ElementDefinition.Fixed.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 116, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 117, choice.value)
      }
      is ElementDefinition.Fixed.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          118,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 119, choice.value)
      }
      is ElementDefinition.Fixed.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 120, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 121, choice.value)
      }
      is ElementDefinition.Fixed.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 122, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 123, choice.value)
      }
      is ElementDefinition.Fixed.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 124, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 125, choice.value)
      }
      is ElementDefinition.Fixed.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 126, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 127, choice.value)
      }
      is ElementDefinition.Fixed.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 128, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 129, choice.value)
      }
      is ElementDefinition.Fixed.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 130, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 131, choice.value)
      }
      is ElementDefinition.Fixed.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 132, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 133, choice.value)
      }
      is ElementDefinition.Fixed.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          134,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 135, choice.value)
      }
      is ElementDefinition.Fixed.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 136, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 137, choice.value)
      }
      is ElementDefinition.Fixed.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 138, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 139, choice.value)
      }
      is ElementDefinition.Fixed.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 140, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 141, choice.value)
      }
      is ElementDefinition.Fixed.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 142, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 143, choice.value)
      }
      is ElementDefinition.Fixed.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 144, AddressSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 145, AgeSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          146,
          AnnotationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          147,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          148,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 149, CodingSerializer, choice.value)
      }
      is ElementDefinition.Fixed.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          150,
          ContactPointSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 151, CountSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Distance -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          152,
          DistanceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Duration -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          153,
          DurationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          154,
          HumanNameSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          155,
          IdentifierSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 156, MoneySerializer, choice.value)
      }
      is ElementDefinition.Fixed.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 157, PeriodSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          158,
          QuantitySerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 159, RangeSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 160, RatioSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          161,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          162,
          SampledDataSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          163,
          SignatureSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 164, TimingSerializer, choice.value)
      }
      is ElementDefinition.Fixed.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          165,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Contributor -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          166,
          ContributorSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          167,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          168,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          169,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          170,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          171,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          172,
          UsageContextSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 173, DosageSerializer, choice.value)
      }
      is ElementDefinition.Fixed.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 174, MetaSerializer, choice.value)
      }
    }
    when (val choice = value.pattern) {
      null -> {}
      is ElementDefinition.Pattern.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 175, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 176, choice.value)
      }
      is ElementDefinition.Pattern.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 177, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 178, choice.value)
      }
      is ElementDefinition.Pattern.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 179, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 180, choice.value)
      }
      is ElementDefinition.Pattern.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 181, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 182, choice.value)
      }
      is ElementDefinition.Pattern.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 183, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 184, choice.value)
      }
      is ElementDefinition.Pattern.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 185, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 186, choice.value)
      }
      is ElementDefinition.Pattern.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          187,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 188, choice.value)
      }
      is ElementDefinition.Pattern.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 189, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 190, choice.value)
      }
      is ElementDefinition.Pattern.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 191, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 192, choice.value)
      }
      is ElementDefinition.Pattern.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 193, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 194, choice.value)
      }
      is ElementDefinition.Pattern.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 195, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 196, choice.value)
      }
      is ElementDefinition.Pattern.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 197, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 198, choice.value)
      }
      is ElementDefinition.Pattern.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 199, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 200, choice.value)
      }
      is ElementDefinition.Pattern.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 201, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 202, choice.value)
      }
      is ElementDefinition.Pattern.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          203,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 204, choice.value)
      }
      is ElementDefinition.Pattern.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 205, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 206, choice.value)
      }
      is ElementDefinition.Pattern.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 207, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 208, choice.value)
      }
      is ElementDefinition.Pattern.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 209, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 210, choice.value)
      }
      is ElementDefinition.Pattern.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 211, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 212, choice.value)
      }
      is ElementDefinition.Pattern.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 213, AddressSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 214, AgeSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          215,
          AnnotationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          216,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          217,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 218, CodingSerializer, choice.value)
      }
      is ElementDefinition.Pattern.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          219,
          ContactPointSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 220, CountSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Distance -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          221,
          DistanceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Duration -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          222,
          DurationSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          223,
          HumanNameSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          224,
          IdentifierSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 225, MoneySerializer, choice.value)
      }
      is ElementDefinition.Pattern.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 226, PeriodSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          227,
          QuantitySerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 228, RangeSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 229, RatioSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          230,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          231,
          SampledDataSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          232,
          SignatureSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 233, TimingSerializer, choice.value)
      }
      is ElementDefinition.Pattern.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          234,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Contributor -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          235,
          ContributorSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          236,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          237,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          238,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          239,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          240,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          241,
          UsageContextSerializer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 242, DosageSerializer, choice.value)
      }
      is ElementDefinition.Pattern.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 243, MetaSerializer, choice.value)
      }
    }
    if (value.example.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        244,
        ElementDefinitionExampleSerializer.listSerializer,
        value.example,
      )
    when (val choice = value.minValue) {
      null -> {}
      is ElementDefinition.MinValue.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 245, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 246, choice.value)
      }
      is ElementDefinition.MinValue.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 247, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 248, choice.value)
      }
      is ElementDefinition.MinValue.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 249, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 250, choice.value)
      }
      is ElementDefinition.MinValue.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          251,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 252, choice.value)
      }
      is ElementDefinition.MinValue.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          253,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 254, choice.value)
      }
      is ElementDefinition.MinValue.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 255, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 256, choice.value)
      }
      is ElementDefinition.MinValue.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 257, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 258, choice.value)
      }
      is ElementDefinition.MinValue.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 259, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 260, choice.value)
      }
      is ElementDefinition.MinValue.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          261,
          QuantitySerializer,
          choice.value,
        )
      }
    }
    when (val choice = value.maxValue) {
      null -> {}
      is ElementDefinition.MaxValue.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 262, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 263, choice.value)
      }
      is ElementDefinition.MaxValue.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 264, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 265, choice.value)
      }
      is ElementDefinition.MaxValue.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 266, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 267, choice.value)
      }
      is ElementDefinition.MaxValue.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          268,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 269, choice.value)
      }
      is ElementDefinition.MaxValue.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          270,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 271, choice.value)
      }
      is ElementDefinition.MaxValue.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 272, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 273, choice.value)
      }
      is ElementDefinition.MaxValue.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 274, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 275, choice.value)
      }
      is ElementDefinition.MaxValue.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 276, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 277, choice.value)
      }
      is ElementDefinition.MaxValue.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          278,
          QuantitySerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 279, value.maxLength?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 280, value.maxLength)
    if (value.condition.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        281,
        stringNullableListSerializer,
        value.condition.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 282, value.condition)
    }
    if (value.constraint.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        283,
        ElementDefinitionConstraintSerializer.listSerializer,
        value.constraint,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 284, value.mustSupport?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 285, value.mustSupport)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 286, value.isModifier?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 287, value.isModifier)
    compositeEncoder.encodeStringIfNotNull(descriptor, 288, value.isModifierReason?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 289, value.isModifierReason)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 290, value.isSummary?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 291, value.isSummary)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      292,
      ElementDefinitionBindingSerializer,
      value.binding,
    )
    if (value.mapping.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        293,
        ElementDefinitionMappingSerializer.listSerializer,
        value.mapping,
      )
    compositeEncoder.endStructure(descriptor)
  }
}
