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
import kotlinx.serialization.builtins.nullable
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

internal object ElementDefinitionSlicingSerializer : KSerializer<ElementDefinition.Slicing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Slicing") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "discriminator",
        listSerialDescriptor(
          lazyDescriptor { ElementDefinition.Slicing.Discriminator.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("ordered", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_ordered", Element.serializer().descriptor, isOptional = true)
      element("rules", KotlinString.serializer().descriptor, isOptional = true)
      element("_rules", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Slicing =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ElementDefinition.Slicing {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          discriminator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.discriminatorSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> ordered = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _ordered =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        7 -> rules = decoder.decodeStringElement(descriptor, i)
        8 ->
          _rules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Slicing: " + i)
      }
    }
    return ElementDefinition.Slicing(
      id = id,
      extension = extension ?: listOf(),
      discriminator = discriminator ?: listOf(),
      description = R4bString.of(description, _description),
      ordered = R4bBoolean.of(ordered, _ordered),
      rules =
        Enumeration.of(
          ElementDefinition.SlicingRules.fromCode(
            rules
              ?: throw SerializationException(
                "Missing required property 'rules' on ElementDefinition.Slicing"
              )
          ),
          _rules,
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ElementDefinition.Slicing) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.discriminator.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.discriminatorSer,
        value.discriminator,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    ((value.ordered?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.ordered?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.descriptionSer, it)
    }
    ((value.rules.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.rules.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val discriminatorSerInner: KSerializer<ElementDefinition.Slicing.Discriminator> =
      ElementDefinition.Slicing.Discriminator.serializer()

    public val discriminatorSer: KSerializer<List<ElementDefinition.Slicing.Discriminator>> =
      ListSerializer(Hoisted.discriminatorSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ElementDefinitionSlicingDiscriminatorSerializer :
  KSerializer<ElementDefinition.Slicing.Discriminator> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Discriminator") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Slicing.Discriminator =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing.Discriminator) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ElementDefinition.Slicing.Discriminator {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var path: KotlinString? = null
    var _path: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(descriptor, i)
        3 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> path = decoder.decodeStringElement(descriptor, i)
        5 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Discriminator: " + i)
      }
    }
    return ElementDefinition.Slicing.Discriminator(
      id = id,
      extension = extension ?: listOf(),
      type =
        Enumeration.of(
          ElementDefinition.DiscriminatorType.fromCode(
            type
              ?: throw SerializationException(
                "Missing required property 'type' on ElementDefinition.Slicing.Discriminator"
              )
          ),
          _type,
        ),
      path =
        R4bString.of(path, _path)
          ?: throw SerializationException(
            "Missing required property 'path' on ElementDefinition.Slicing.Discriminator"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ElementDefinition.Slicing.Discriminator,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it)
    }
    ((value.path.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ElementDefinitionBaseSerializer : KSerializer<ElementDefinition.Base> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Base") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", Element.serializer().descriptor, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Base =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Base) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ElementDefinition.Base {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> path = decoder.decodeStringElement(descriptor, i)
        3 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        4 -> min = decoder.decodeIntElement(descriptor, i)
        5 -> _min = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        6 -> max = decoder.decodeStringElement(descriptor, i)
        7 -> _max = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Base: " + i)
      }
    }
    return ElementDefinition.Base(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ElementDefinition.Base) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.path.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.pathSer, it)
    }
    ((value.min.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
    (value.min.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.pathSer, it)
    }
    ((value.max.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.max.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.pathSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ElementDefinitionTypeSerializer : KSerializer<ElementDefinition.Type> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Type") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element(
        "profile",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_profile", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "targetProfile",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_targetProfile",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "aggregation",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_aggregation",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("versioning", KotlinString.serializer().descriptor, isOptional = true)
      element("_versioning", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Type =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Type) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ElementDefinition.Type {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> code = decoder.decodeStringElement(descriptor, i)
        3 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        5 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer2, null)
        6 ->
          targetProfile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        7 ->
          _targetProfile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer2, null)
        8 ->
          aggregation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        9 ->
          _aggregation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer2, null)
        10 -> versioning = decoder.decodeStringElement(descriptor, i)
        11 ->
          _versioning =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Type: " + i)
      }
    }
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
          Canonical.of(profile?.getOrNull(index)?.let { it }, _profile?.getOrNull(index))!!
        }),
      targetProfile =
        (kotlin.collections.List(maxOf(targetProfile?.size ?: 0, _targetProfile?.size ?: 0)) { index
          ->
          Canonical.of(
            targetProfile?.getOrNull(index)?.let { it },
            _targetProfile?.getOrNull(index),
          )!!
        }),
      aggregation =
        (kotlin.collections.List(maxOf(aggregation?.size ?: 0, _aggregation?.size ?: 0)) { index ->
          Enumeration.of(
            ElementDefinition.AggregationMode.fromCode(aggregation?.getOrNull(index)!!),
            _aggregation?.getOrNull(index),
          )
        }),
      versioning =
        versioning?.let {
          Enumeration.of(ElementDefinition.ReferenceVersionRules.fromCode(it), _versioning)
        },
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ElementDefinition.Type) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.profileSer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.profileSer2, it)
    }
    (value.targetProfile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.profileSer, it)
    }
    (value.targetProfile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.profileSer2, it)
    }
    (value.aggregation.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.profileSer, it)
    }
    (value.aggregation.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.profileSer2, it)
    }
    ((value.versioning?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.versioning?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val profileSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val profileSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.profileSerInner).nullable)

    public val profileSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.codeSer).nullable)
  }
}

internal object ElementDefinitionExampleSerializer : KSerializer<ElementDefinition.Example> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Example") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("label", KotlinString.serializer().descriptor, isOptional = true)
      element("_label", Element.serializer().descriptor, isOptional = true)
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
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
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
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Example =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Example) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ElementDefinition.Example {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> label = decoder.decodeStringElement(descriptor, i)
        3 ->
          _label = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        4 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        5 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        6 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        8 -> valueCanonical = decoder.decodeStringElement(descriptor, i)
        9 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        10 -> valueCode = decoder.decodeStringElement(descriptor, i)
        11 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        12 -> valueDate = decoder.decodeStringElement(descriptor, i)
        13 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        14 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        18 -> valueId = decoder.decodeStringElement(descriptor, i)
        19 ->
          _valueId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        20 -> valueInstant = decoder.decodeStringElement(descriptor, i)
        21 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        22 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        23 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        24 -> valueMarkdown = decoder.decodeStringElement(descriptor, i)
        25 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        26 -> valueOid = decoder.decodeStringElement(descriptor, i)
        27 ->
          _valueOid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        28 -> valuePositiveInt = decoder.decodeIntElement(descriptor, i)
        29 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        30 -> valueString = decoder.decodeStringElement(descriptor, i)
        31 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        32 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        33 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        34 -> valueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        35 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        36 -> valueUri = decoder.decodeStringElement(descriptor, i)
        37 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        38 -> valueUrl = decoder.decodeStringElement(descriptor, i)
        39 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        40 -> valueUuid = decoder.decodeStringElement(descriptor, i)
        41 ->
          _valueUuid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        42 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAddressSer, null)
        43 ->
          valueAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueAgeSer, null)
        44 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAnnotationSer,
              null,
            )
        45 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        46 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        47 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        48 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        49 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactPointSer,
              null,
            )
        50 ->
          valueCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCountSer, null)
        51 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDistanceSer, null)
        52 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDurationSer, null)
        53 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueHumanNameSer,
              null,
            )
        54 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueIdentifierSer,
              null,
            )
        55 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMoneySer, null)
        56 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        57 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        58 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        59 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        60 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRatioRangeSer,
              null,
            )
        61 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        62 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSampledDataSer,
              null,
            )
        63 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSignatureSer,
              null,
            )
        64 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueTimingSer, null)
        65 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContactDetailSer,
              null,
            )
        66 ->
          valueContributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueContributorSer,
              null,
            )
        67 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueDataRequirementSer,
              null,
            )
        68 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueExpressionSer,
              null,
            )
        69 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        70 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        71 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        72 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueUsageContextSer,
              null,
            )
        73 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDosageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Example: " + i)
      }
    }
    return ElementDefinition.Example(
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
          Date.of(valueDate?.let { FhirDate.fromString(it) }, _valueDate),
          DateTime.of(valueDateTime?.let { FhirDateTime.fromString(it) }, _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Id.of(valueId, _valueId),
          Instant.of(valueInstant?.let { FhirDateTime.fromString(it) }, _valueInstant),
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ElementDefinition.Example) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.label.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.label.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.labelSer, it)
    }
    when (val choice = value.`value`) {
      is ElementDefinition.Example.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 16, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 17, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 18, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 19, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 20, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 21, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 22, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 23, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 24, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 25, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Oid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 26, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 27, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 28, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 29, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 30, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 31, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 32, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 33, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 34, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 35, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 36, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 37, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 38, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 39, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Uuid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 40, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 41, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Address -> {
        encoder.encodeSerializableElement(descriptor, 42, Hoisted.valueAddressSer, choice.value)
      }
      is ElementDefinition.Example.Value.Age -> {
        encoder.encodeSerializableElement(descriptor, 43, Hoisted.valueAgeSer, choice.value)
      }
      is ElementDefinition.Example.Value.Annotation -> {
        encoder.encodeSerializableElement(descriptor, 44, Hoisted.valueAnnotationSer, choice.value)
      }
      is ElementDefinition.Example.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 45, Hoisted.valueAttachmentSer, choice.value)
      }
      is ElementDefinition.Example.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          46,
          Hoisted.valueCodeableConceptSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.CodeableReference -> {
        encoder.encodeSerializableElement(
          descriptor,
          47,
          Hoisted.valueCodeableReferenceSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 48, Hoisted.valueCodingSer, choice.value)
      }
      is ElementDefinition.Example.Value.ContactPoint -> {
        encoder.encodeSerializableElement(
          descriptor,
          49,
          Hoisted.valueContactPointSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Count -> {
        encoder.encodeSerializableElement(descriptor, 50, Hoisted.valueCountSer, choice.value)
      }
      is ElementDefinition.Example.Value.Distance -> {
        encoder.encodeSerializableElement(descriptor, 51, Hoisted.valueDistanceSer, choice.value)
      }
      is ElementDefinition.Example.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 52, Hoisted.valueDurationSer, choice.value)
      }
      is ElementDefinition.Example.Value.HumanName -> {
        encoder.encodeSerializableElement(descriptor, 53, Hoisted.valueHumanNameSer, choice.value)
      }
      is ElementDefinition.Example.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 54, Hoisted.valueIdentifierSer, choice.value)
      }
      is ElementDefinition.Example.Value.Money -> {
        encoder.encodeSerializableElement(descriptor, 55, Hoisted.valueMoneySer, choice.value)
      }
      is ElementDefinition.Example.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 56, Hoisted.valuePeriodSer, choice.value)
      }
      is ElementDefinition.Example.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 57, Hoisted.valueQuantitySer, choice.value)
      }
      is ElementDefinition.Example.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 58, Hoisted.valueRangeSer, choice.value)
      }
      is ElementDefinition.Example.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 59, Hoisted.valueRatioSer, choice.value)
      }
      is ElementDefinition.Example.Value.RatioRange -> {
        encoder.encodeSerializableElement(descriptor, 60, Hoisted.valueRatioRangeSer, choice.value)
      }
      is ElementDefinition.Example.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 61, Hoisted.valueReferenceSer, choice.value)
      }
      is ElementDefinition.Example.Value.SampledData -> {
        encoder.encodeSerializableElement(descriptor, 62, Hoisted.valueSampledDataSer, choice.value)
      }
      is ElementDefinition.Example.Value.Signature -> {
        encoder.encodeSerializableElement(descriptor, 63, Hoisted.valueSignatureSer, choice.value)
      }
      is ElementDefinition.Example.Value.Timing -> {
        encoder.encodeSerializableElement(descriptor, 64, Hoisted.valueTimingSer, choice.value)
      }
      is ElementDefinition.Example.Value.ContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          65,
          Hoisted.valueContactDetailSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Contributor -> {
        encoder.encodeSerializableElement(descriptor, 66, Hoisted.valueContributorSer, choice.value)
      }
      is ElementDefinition.Example.Value.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          67,
          Hoisted.valueDataRequirementSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Expression -> {
        encoder.encodeSerializableElement(descriptor, 68, Hoisted.valueExpressionSer, choice.value)
      }
      is ElementDefinition.Example.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          69,
          Hoisted.valueParameterDefinitionSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          descriptor,
          70,
          Hoisted.valueRelatedArtifactSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          71,
          Hoisted.valueTriggerDefinitionSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.UsageContext -> {
        encoder.encodeSerializableElement(
          descriptor,
          72,
          Hoisted.valueUsageContextSer,
          choice.value,
        )
      }
      is ElementDefinition.Example.Value.Dosage -> {
        encoder.encodeSerializableElement(descriptor, 73, Hoisted.valueDosageSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val labelSer: KSerializer<Element> = Element.serializer()

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

internal object ElementDefinitionConstraintSerializer : KSerializer<ElementDefinition.Constraint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Constraint") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("key", KotlinString.serializer().descriptor, isOptional = true)
      element("_key", Element.serializer().descriptor, isOptional = true)
      element("requirements", KotlinString.serializer().descriptor, isOptional = true)
      element("_requirements", Element.serializer().descriptor, isOptional = true)
      element("severity", KotlinString.serializer().descriptor, isOptional = true)
      element("_severity", Element.serializer().descriptor, isOptional = true)
      element("human", KotlinString.serializer().descriptor, isOptional = true)
      element("_human", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
      element("xpath", KotlinString.serializer().descriptor, isOptional = true)
      element("_xpath", Element.serializer().descriptor, isOptional = true)
      element("source", KotlinString.serializer().descriptor, isOptional = true)
      element("_source", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Constraint =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Constraint) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ElementDefinition.Constraint {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> key = decoder.decodeStringElement(descriptor, i)
        3 -> _key = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        4 -> requirements = decoder.decodeStringElement(descriptor, i)
        5 ->
          _requirements =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        6 -> severity = decoder.decodeStringElement(descriptor, i)
        7 ->
          _severity = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        8 -> human = decoder.decodeStringElement(descriptor, i)
        9 -> _human = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        10 -> expression = decoder.decodeStringElement(descriptor, i)
        11 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        12 -> xpath = decoder.decodeStringElement(descriptor, i)
        13 ->
          _xpath = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        14 -> source = decoder.decodeStringElement(descriptor, i)
        15 ->
          _source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Constraint: " + i)
      }
    }
    return ElementDefinition.Constraint(
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
          ElementDefinition.ConstraintSeverity.fromCode(
            severity
              ?: throw SerializationException(
                "Missing required property 'severity' on ElementDefinition.Constraint"
              )
          ),
          _severity,
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ElementDefinition.Constraint) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.key.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.key.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.keySer, it)
    }
    ((value.requirements?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.requirements?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.keySer, it)
    }
    ((value.severity.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.severity.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.keySer, it)
    }
    ((value.human.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.human.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.keySer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.keySer, it)
    }
    ((value.xpath?.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.xpath?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.keySer, it)
    }
    ((value.source?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.keySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val keySer: KSerializer<Element> = Element.serializer()
  }
}

internal object ElementDefinitionBindingSerializer : KSerializer<ElementDefinition.Binding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Binding") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("strength", KotlinString.serializer().descriptor, isOptional = true)
      element("_strength", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Binding =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Binding) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ElementDefinition.Binding {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var strength: KotlinString? = null
    var _strength: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> strength = decoder.decodeStringElement(descriptor, i)
        3 ->
          _strength =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        4 -> description = decoder.decodeStringElement(descriptor, i)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        6 -> valueSet = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Binding: " + i)
      }
    }
    return ElementDefinition.Binding(
      id = id,
      extension = extension ?: listOf(),
      strength =
        Enumeration.of(
          BindingStrength.fromCode(
            strength
              ?: throw SerializationException(
                "Missing required property 'strength' on ElementDefinition.Binding"
              )
          ),
          _strength,
        ),
      description = R4bString.of(description, _description),
      valueSet = Canonical.of(valueSet, _valueSet),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ElementDefinition.Binding) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.strength.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.strength.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.strengthSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.strengthSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.strengthSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val strengthSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ElementDefinitionMappingSerializer : KSerializer<ElementDefinition.Mapping> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Mapping") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("identity", KotlinString.serializer().descriptor, isOptional = true)
      element("_identity", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("map", KotlinString.serializer().descriptor, isOptional = true)
      element("_map", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Mapping =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Mapping) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ElementDefinition.Mapping {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> identity = decoder.decodeStringElement(descriptor, i)
        3 ->
          _identity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identitySer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identitySer, null)
        6 -> map = decoder.decodeStringElement(descriptor, i)
        7 ->
          _map = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identitySer, null)
        8 -> comment = decoder.decodeStringElement(descriptor, i)
        9 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mapping: " + i)
      }
    }
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
        R4bString.of(map, _map)
          ?: throw SerializationException(
            "Missing required property 'map' on ElementDefinition.Mapping"
          ),
      comment = R4bString.of(comment, _comment),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ElementDefinition.Mapping) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.identity.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.identity.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identitySer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.identitySer, it)
    }
    ((value.map.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.map.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.identitySer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.identitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identitySer: KSerializer<Element> = Element.serializer()
  }
}

internal object ElementDefinitionSerializer : KSerializer<ElementDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ElementDefinition") {
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
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element(
        "representation",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_representation",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("sliceName", KotlinString.serializer().descriptor, isOptional = true)
      element("_sliceName", Element.serializer().descriptor, isOptional = true)
      element("sliceIsConstraining", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_sliceIsConstraining", Element.serializer().descriptor, isOptional = true)
      element("label", KotlinString.serializer().descriptor, isOptional = true)
      element("_label", Element.serializer().descriptor, isOptional = true)
      element("code", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element(
        "slicing",
        lazyDescriptor { ElementDefinition.Slicing.serializer().descriptor },
        isOptional = true,
      )
      element("short", KotlinString.serializer().descriptor, isOptional = true)
      element("_short", Element.serializer().descriptor, isOptional = true)
      element("definition", KotlinString.serializer().descriptor, isOptional = true)
      element("_definition", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element("requirements", KotlinString.serializer().descriptor, isOptional = true)
      element("_requirements", Element.serializer().descriptor, isOptional = true)
      element(
        "alias",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_alias", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", Element.serializer().descriptor, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", Element.serializer().descriptor, isOptional = true)
      element(
        "base",
        lazyDescriptor { ElementDefinition.Base.serializer().descriptor },
        isOptional = true,
      )
      element("contentReference", KotlinString.serializer().descriptor, isOptional = true)
      element("_contentReference", Element.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(lazyDescriptor { ElementDefinition.Type.serializer().descriptor }),
        isOptional = true,
      )
      element("defaultValueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueBase64Binary", Element.serializer().descriptor, isOptional = true)
      element("defaultValueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_defaultValueBoolean", Element.serializer().descriptor, isOptional = true)
      element("defaultValueCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueCanonical", Element.serializer().descriptor, isOptional = true)
      element("defaultValueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueCode", Element.serializer().descriptor, isOptional = true)
      element("defaultValueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueDate", Element.serializer().descriptor, isOptional = true)
      element("defaultValueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueDateTime", Element.serializer().descriptor, isOptional = true)
      element("defaultValueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_defaultValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("defaultValueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueId", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueInstant", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_defaultValueInteger", Element.serializer().descriptor, isOptional = true)
      element("defaultValueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueMarkdown", Element.serializer().descriptor, isOptional = true)
      element("defaultValueOid", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueOid", Element.serializer().descriptor, isOptional = true)
      element("defaultValuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_defaultValuePositiveInt", Element.serializer().descriptor, isOptional = true)
      element("defaultValueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueString", Element.serializer().descriptor, isOptional = true)
      element("defaultValueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_defaultValueTime", Element.serializer().descriptor, isOptional = true)
      element("defaultValueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_defaultValueUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("defaultValueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueUri", Element.serializer().descriptor, isOptional = true)
      element("defaultValueUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueUrl", Element.serializer().descriptor, isOptional = true)
      element("defaultValueUuid", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueUuid", Element.serializer().descriptor, isOptional = true)
      element("defaultValueAddress", Address.serializer().descriptor, isOptional = true)
      element("defaultValueAge", Age.serializer().descriptor, isOptional = true)
      element("defaultValueAnnotation", Annotation.serializer().descriptor, isOptional = true)
      element("defaultValueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element(
        "defaultValueCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element(
        "defaultValueCodeableReference",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
      element("defaultValueCoding", Coding.serializer().descriptor, isOptional = true)
      element("defaultValueContactPoint", ContactPoint.serializer().descriptor, isOptional = true)
      element("defaultValueCount", Count.serializer().descriptor, isOptional = true)
      element("defaultValueDistance", Distance.serializer().descriptor, isOptional = true)
      element("defaultValueDuration", Duration.serializer().descriptor, isOptional = true)
      element("defaultValueHumanName", HumanName.serializer().descriptor, isOptional = true)
      element("defaultValueIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("defaultValueMoney", Money.serializer().descriptor, isOptional = true)
      element("defaultValuePeriod", Period.serializer().descriptor, isOptional = true)
      element("defaultValueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("defaultValueRange", Range.serializer().descriptor, isOptional = true)
      element("defaultValueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("defaultValueRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element("defaultValueReference", Reference.serializer().descriptor, isOptional = true)
      element("defaultValueSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("defaultValueSignature", Signature.serializer().descriptor, isOptional = true)
      element("defaultValueTiming", Timing.serializer().descriptor, isOptional = true)
      element("defaultValueContactDetail", ContactDetail.serializer().descriptor, isOptional = true)
      element("defaultValueContributor", Contributor.serializer().descriptor, isOptional = true)
      element(
        "defaultValueDataRequirement",
        DataRequirement.serializer().descriptor,
        isOptional = true,
      )
      element("defaultValueExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "defaultValueParameterDefinition",
        ParameterDefinition.serializer().descriptor,
        isOptional = true,
      )
      element(
        "defaultValueRelatedArtifact",
        RelatedArtifact.serializer().descriptor,
        isOptional = true,
      )
      element(
        "defaultValueTriggerDefinition",
        TriggerDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("defaultValueUsageContext", UsageContext.serializer().descriptor, isOptional = true)
      element("defaultValueDosage", Dosage.serializer().descriptor, isOptional = true)
      element("meaningWhenMissing", KotlinString.serializer().descriptor, isOptional = true)
      element("_meaningWhenMissing", Element.serializer().descriptor, isOptional = true)
      element("orderMeaning", KotlinString.serializer().descriptor, isOptional = true)
      element("_orderMeaning", Element.serializer().descriptor, isOptional = true)
      element("fixedBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedBase64Binary", Element.serializer().descriptor, isOptional = true)
      element("fixedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_fixedBoolean", Element.serializer().descriptor, isOptional = true)
      element("fixedCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedCanonical", Element.serializer().descriptor, isOptional = true)
      element("fixedCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedCode", Element.serializer().descriptor, isOptional = true)
      element("fixedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedDate", Element.serializer().descriptor, isOptional = true)
      element("fixedDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedDateTime", Element.serializer().descriptor, isOptional = true)
      element("fixedDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_fixedDecimal", Element.serializer().descriptor, isOptional = true)
      element("fixedId", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedId", Element.serializer().descriptor, isOptional = true)
      element("fixedInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedInstant", Element.serializer().descriptor, isOptional = true)
      element("fixedInteger", Int.serializer().descriptor, isOptional = true)
      element("_fixedInteger", Element.serializer().descriptor, isOptional = true)
      element("fixedMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedMarkdown", Element.serializer().descriptor, isOptional = true)
      element("fixedOid", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedOid", Element.serializer().descriptor, isOptional = true)
      element("fixedPositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_fixedPositiveInt", Element.serializer().descriptor, isOptional = true)
      element("fixedString", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedString", Element.serializer().descriptor, isOptional = true)
      element("fixedTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_fixedTime", Element.serializer().descriptor, isOptional = true)
      element("fixedUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_fixedUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("fixedUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedUri", Element.serializer().descriptor, isOptional = true)
      element("fixedUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedUrl", Element.serializer().descriptor, isOptional = true)
      element("fixedUuid", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedUuid", Element.serializer().descriptor, isOptional = true)
      element("fixedAddress", Address.serializer().descriptor, isOptional = true)
      element("fixedAge", Age.serializer().descriptor, isOptional = true)
      element("fixedAnnotation", Annotation.serializer().descriptor, isOptional = true)
      element("fixedAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("fixedCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "fixedCodeableReference",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
      element("fixedCoding", Coding.serializer().descriptor, isOptional = true)
      element("fixedContactPoint", ContactPoint.serializer().descriptor, isOptional = true)
      element("fixedCount", Count.serializer().descriptor, isOptional = true)
      element("fixedDistance", Distance.serializer().descriptor, isOptional = true)
      element("fixedDuration", Duration.serializer().descriptor, isOptional = true)
      element("fixedHumanName", HumanName.serializer().descriptor, isOptional = true)
      element("fixedIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("fixedMoney", Money.serializer().descriptor, isOptional = true)
      element("fixedPeriod", Period.serializer().descriptor, isOptional = true)
      element("fixedQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("fixedRange", Range.serializer().descriptor, isOptional = true)
      element("fixedRatio", Ratio.serializer().descriptor, isOptional = true)
      element("fixedRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element("fixedReference", Reference.serializer().descriptor, isOptional = true)
      element("fixedSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("fixedSignature", Signature.serializer().descriptor, isOptional = true)
      element("fixedTiming", Timing.serializer().descriptor, isOptional = true)
      element("fixedContactDetail", ContactDetail.serializer().descriptor, isOptional = true)
      element("fixedContributor", Contributor.serializer().descriptor, isOptional = true)
      element("fixedDataRequirement", DataRequirement.serializer().descriptor, isOptional = true)
      element("fixedExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "fixedParameterDefinition",
        ParameterDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("fixedRelatedArtifact", RelatedArtifact.serializer().descriptor, isOptional = true)
      element(
        "fixedTriggerDefinition",
        TriggerDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("fixedUsageContext", UsageContext.serializer().descriptor, isOptional = true)
      element("fixedDosage", Dosage.serializer().descriptor, isOptional = true)
      element("patternBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternBase64Binary", Element.serializer().descriptor, isOptional = true)
      element("patternBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_patternBoolean", Element.serializer().descriptor, isOptional = true)
      element("patternCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternCanonical", Element.serializer().descriptor, isOptional = true)
      element("patternCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternCode", Element.serializer().descriptor, isOptional = true)
      element("patternDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternDate", Element.serializer().descriptor, isOptional = true)
      element("patternDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternDateTime", Element.serializer().descriptor, isOptional = true)
      element("patternDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_patternDecimal", Element.serializer().descriptor, isOptional = true)
      element("patternId", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternId", Element.serializer().descriptor, isOptional = true)
      element("patternInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternInstant", Element.serializer().descriptor, isOptional = true)
      element("patternInteger", Int.serializer().descriptor, isOptional = true)
      element("_patternInteger", Element.serializer().descriptor, isOptional = true)
      element("patternMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternMarkdown", Element.serializer().descriptor, isOptional = true)
      element("patternOid", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternOid", Element.serializer().descriptor, isOptional = true)
      element("patternPositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_patternPositiveInt", Element.serializer().descriptor, isOptional = true)
      element("patternString", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternString", Element.serializer().descriptor, isOptional = true)
      element("patternTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_patternTime", Element.serializer().descriptor, isOptional = true)
      element("patternUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_patternUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("patternUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternUri", Element.serializer().descriptor, isOptional = true)
      element("patternUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternUrl", Element.serializer().descriptor, isOptional = true)
      element("patternUuid", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternUuid", Element.serializer().descriptor, isOptional = true)
      element("patternAddress", Address.serializer().descriptor, isOptional = true)
      element("patternAge", Age.serializer().descriptor, isOptional = true)
      element("patternAnnotation", Annotation.serializer().descriptor, isOptional = true)
      element("patternAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("patternCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "patternCodeableReference",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
      element("patternCoding", Coding.serializer().descriptor, isOptional = true)
      element("patternContactPoint", ContactPoint.serializer().descriptor, isOptional = true)
      element("patternCount", Count.serializer().descriptor, isOptional = true)
      element("patternDistance", Distance.serializer().descriptor, isOptional = true)
      element("patternDuration", Duration.serializer().descriptor, isOptional = true)
      element("patternHumanName", HumanName.serializer().descriptor, isOptional = true)
      element("patternIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("patternMoney", Money.serializer().descriptor, isOptional = true)
      element("patternPeriod", Period.serializer().descriptor, isOptional = true)
      element("patternQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("patternRange", Range.serializer().descriptor, isOptional = true)
      element("patternRatio", Ratio.serializer().descriptor, isOptional = true)
      element("patternRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element("patternReference", Reference.serializer().descriptor, isOptional = true)
      element("patternSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("patternSignature", Signature.serializer().descriptor, isOptional = true)
      element("patternTiming", Timing.serializer().descriptor, isOptional = true)
      element("patternContactDetail", ContactDetail.serializer().descriptor, isOptional = true)
      element("patternContributor", Contributor.serializer().descriptor, isOptional = true)
      element("patternDataRequirement", DataRequirement.serializer().descriptor, isOptional = true)
      element("patternExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "patternParameterDefinition",
        ParameterDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("patternRelatedArtifact", RelatedArtifact.serializer().descriptor, isOptional = true)
      element(
        "patternTriggerDefinition",
        TriggerDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("patternUsageContext", UsageContext.serializer().descriptor, isOptional = true)
      element("patternDosage", Dosage.serializer().descriptor, isOptional = true)
      element(
        "example",
        listSerialDescriptor(lazyDescriptor { ElementDefinition.Example.serializer().descriptor }),
        isOptional = true,
      )
      element("minValueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_minValueDate", Element.serializer().descriptor, isOptional = true)
      element("minValueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_minValueDateTime", Element.serializer().descriptor, isOptional = true)
      element("minValueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_minValueInstant", Element.serializer().descriptor, isOptional = true)
      element("minValueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_minValueTime", Element.serializer().descriptor, isOptional = true)
      element("minValueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_minValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("minValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_minValueInteger", Element.serializer().descriptor, isOptional = true)
      element("minValuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_minValuePositiveInt", Element.serializer().descriptor, isOptional = true)
      element("minValueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_minValueUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("minValueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("maxValueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_maxValueDate", Element.serializer().descriptor, isOptional = true)
      element("maxValueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_maxValueDateTime", Element.serializer().descriptor, isOptional = true)
      element("maxValueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_maxValueInstant", Element.serializer().descriptor, isOptional = true)
      element("maxValueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_maxValueTime", Element.serializer().descriptor, isOptional = true)
      element("maxValueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_maxValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("maxValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_maxValueInteger", Element.serializer().descriptor, isOptional = true)
      element("maxValuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_maxValuePositiveInt", Element.serializer().descriptor, isOptional = true)
      element("maxValueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_maxValueUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("maxValueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("maxLength", Int.serializer().descriptor, isOptional = true)
      element("_maxLength", Element.serializer().descriptor, isOptional = true)
      element(
        "condition",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_condition",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "constraint",
        listSerialDescriptor(
          lazyDescriptor { ElementDefinition.Constraint.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("mustSupport", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_mustSupport", Element.serializer().descriptor, isOptional = true)
      element("isModifier", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isModifier", Element.serializer().descriptor, isOptional = true)
      element("isModifierReason", KotlinString.serializer().descriptor, isOptional = true)
      element("_isModifierReason", Element.serializer().descriptor, isOptional = true)
      element("isSummary", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isSummary", Element.serializer().descriptor, isOptional = true)
      element(
        "binding",
        lazyDescriptor { ElementDefinition.Binding.serializer().descriptor },
        isOptional = true,
      )
      element(
        "mapping",
        listSerialDescriptor(lazyDescriptor { ElementDefinition.Mapping.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ElementDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ElementDefinition {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(descriptor, i)
        4 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        5 ->
          representation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.representationSer,
              null,
            )
        6 ->
          _representation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.representationSer2,
              null,
            )
        7 -> sliceName = decoder.decodeStringElement(descriptor, i)
        8 ->
          _sliceName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        9 -> sliceIsConstraining = decoder.decodeBooleanElement(descriptor, i)
        10 ->
          _sliceIsConstraining =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        11 -> label = decoder.decodeStringElement(descriptor, i)
        12 ->
          _label = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        13 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        14 ->
          slicing =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.slicingSer, null)
        15 -> short = decoder.decodeStringElement(descriptor, i)
        16 ->
          _short = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        17 -> definition = decoder.decodeStringElement(descriptor, i)
        18 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        19 -> comment = decoder.decodeStringElement(descriptor, i)
        20 ->
          _comment = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        21 -> requirements = decoder.decodeStringElement(descriptor, i)
        22 ->
          _requirements =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        23 ->
          alias =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.representationSer,
              null,
            )
        24 ->
          _alias =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.representationSer2,
              null,
            )
        25 -> min = decoder.decodeIntElement(descriptor, i)
        26 -> _min = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        27 -> max = decoder.decodeStringElement(descriptor, i)
        28 -> _max = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        29 -> base = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer, null)
        30 -> contentReference = decoder.decodeStringElement(descriptor, i)
        31 ->
          _contentReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        32 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        33 -> defaultValueBase64Binary = decoder.decodeStringElement(descriptor, i)
        34 ->
          _defaultValueBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        35 -> defaultValueBoolean = decoder.decodeBooleanElement(descriptor, i)
        36 ->
          _defaultValueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        37 -> defaultValueCanonical = decoder.decodeStringElement(descriptor, i)
        38 ->
          _defaultValueCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        39 -> defaultValueCode = decoder.decodeStringElement(descriptor, i)
        40 ->
          _defaultValueCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        41 -> defaultValueDate = decoder.decodeStringElement(descriptor, i)
        42 ->
          _defaultValueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        43 -> defaultValueDateTime = decoder.decodeStringElement(descriptor, i)
        44 ->
          _defaultValueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        45 ->
          defaultValueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        46 ->
          _defaultValueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        47 -> defaultValueId = decoder.decodeStringElement(descriptor, i)
        48 ->
          _defaultValueId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        49 -> defaultValueInstant = decoder.decodeStringElement(descriptor, i)
        50 ->
          _defaultValueInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        51 -> defaultValueInteger = decoder.decodeIntElement(descriptor, i)
        52 ->
          _defaultValueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        53 -> defaultValueMarkdown = decoder.decodeStringElement(descriptor, i)
        54 ->
          _defaultValueMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        55 -> defaultValueOid = decoder.decodeStringElement(descriptor, i)
        56 ->
          _defaultValueOid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        57 -> defaultValuePositiveInt = decoder.decodeIntElement(descriptor, i)
        58 ->
          _defaultValuePositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        59 -> defaultValueString = decoder.decodeStringElement(descriptor, i)
        60 ->
          _defaultValueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        61 ->
          defaultValueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        62 ->
          _defaultValueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        63 -> defaultValueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        64 ->
          _defaultValueUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        65 -> defaultValueUri = decoder.decodeStringElement(descriptor, i)
        66 ->
          _defaultValueUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        67 -> defaultValueUrl = decoder.decodeStringElement(descriptor, i)
        68 ->
          _defaultValueUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        69 -> defaultValueUuid = decoder.decodeStringElement(descriptor, i)
        70 ->
          _defaultValueUuid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        71 ->
          defaultValueAddress =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAddressSer,
              null,
            )
        72 ->
          defaultValueAge =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAgeSer,
              null,
            )
        73 ->
          defaultValueAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAnnotationSer,
              null,
            )
        74 ->
          defaultValueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAttachmentSer,
              null,
            )
        75 ->
          defaultValueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCodeableConceptSer,
              null,
            )
        76 ->
          defaultValueCodeableReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCodeableReferenceSer,
              null,
            )
        77 ->
          defaultValueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSerInner, null)
        78 ->
          defaultValueContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContactPointSer,
              null,
            )
        79 ->
          defaultValueCount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCountSer,
              null,
            )
        80 ->
          defaultValueDistance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDistanceSer,
              null,
            )
        81 ->
          defaultValueDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDurationSer,
              null,
            )
        82 ->
          defaultValueHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueHumanNameSer,
              null,
            )
        83 ->
          defaultValueIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueIdentifierSer,
              null,
            )
        84 ->
          defaultValueMoney =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueMoneySer,
              null,
            )
        85 ->
          defaultValuePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValuePeriodSer,
              null,
            )
        86 ->
          defaultValueQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        87 ->
          defaultValueRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRangeSer,
              null,
            )
        88 ->
          defaultValueRatio =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRatioSer,
              null,
            )
        89 ->
          defaultValueRatioRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRatioRangeSer,
              null,
            )
        90 ->
          defaultValueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueReferenceSer,
              null,
            )
        91 ->
          defaultValueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueSampledDataSer,
              null,
            )
        92 ->
          defaultValueSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueSignatureSer,
              null,
            )
        93 ->
          defaultValueTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueTimingSer,
              null,
            )
        94 ->
          defaultValueContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContactDetailSer,
              null,
            )
        95 ->
          defaultValueContributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContributorSer,
              null,
            )
        96 ->
          defaultValueDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDataRequirementSer,
              null,
            )
        97 ->
          defaultValueExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueExpressionSer,
              null,
            )
        98 ->
          defaultValueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueParameterDefinitionSer,
              null,
            )
        99 ->
          defaultValueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRelatedArtifactSer,
              null,
            )
        100 ->
          defaultValueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueTriggerDefinitionSer,
              null,
            )
        101 ->
          defaultValueUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueUsageContextSer,
              null,
            )
        102 ->
          defaultValueDosage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDosageSer,
              null,
            )
        103 -> meaningWhenMissing = decoder.decodeStringElement(descriptor, i)
        104 ->
          _meaningWhenMissing =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        105 -> orderMeaning = decoder.decodeStringElement(descriptor, i)
        106 ->
          _orderMeaning =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        107 -> fixedBase64Binary = decoder.decodeStringElement(descriptor, i)
        108 ->
          _fixedBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        109 -> fixedBoolean = decoder.decodeBooleanElement(descriptor, i)
        110 ->
          _fixedBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        111 -> fixedCanonical = decoder.decodeStringElement(descriptor, i)
        112 ->
          _fixedCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        113 -> fixedCode = decoder.decodeStringElement(descriptor, i)
        114 ->
          _fixedCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        115 -> fixedDate = decoder.decodeStringElement(descriptor, i)
        116 ->
          _fixedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        117 -> fixedDateTime = decoder.decodeStringElement(descriptor, i)
        118 ->
          _fixedDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        119 ->
          fixedDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        120 ->
          _fixedDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        121 -> fixedId = decoder.decodeStringElement(descriptor, i)
        122 ->
          _fixedId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        123 -> fixedInstant = decoder.decodeStringElement(descriptor, i)
        124 ->
          _fixedInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        125 -> fixedInteger = decoder.decodeIntElement(descriptor, i)
        126 ->
          _fixedInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        127 -> fixedMarkdown = decoder.decodeStringElement(descriptor, i)
        128 ->
          _fixedMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        129 -> fixedOid = decoder.decodeStringElement(descriptor, i)
        130 ->
          _fixedOid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        131 -> fixedPositiveInt = decoder.decodeIntElement(descriptor, i)
        132 ->
          _fixedPositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        133 -> fixedString = decoder.decodeStringElement(descriptor, i)
        134 ->
          _fixedString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        135 ->
          fixedTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        136 ->
          _fixedTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        137 -> fixedUnsignedInt = decoder.decodeIntElement(descriptor, i)
        138 ->
          _fixedUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        139 -> fixedUri = decoder.decodeStringElement(descriptor, i)
        140 ->
          _fixedUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        141 -> fixedUrl = decoder.decodeStringElement(descriptor, i)
        142 ->
          _fixedUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        143 -> fixedUuid = decoder.decodeStringElement(descriptor, i)
        144 ->
          _fixedUuid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        145 ->
          fixedAddress =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAddressSer,
              null,
            )
        146 ->
          fixedAge =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAgeSer,
              null,
            )
        147 ->
          fixedAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAnnotationSer,
              null,
            )
        148 ->
          fixedAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAttachmentSer,
              null,
            )
        149 ->
          fixedCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCodeableConceptSer,
              null,
            )
        150 ->
          fixedCodeableReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCodeableReferenceSer,
              null,
            )
        151 ->
          fixedCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSerInner, null)
        152 ->
          fixedContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContactPointSer,
              null,
            )
        153 ->
          fixedCount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCountSer,
              null,
            )
        154 ->
          fixedDistance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDistanceSer,
              null,
            )
        155 ->
          fixedDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDurationSer,
              null,
            )
        156 ->
          fixedHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueHumanNameSer,
              null,
            )
        157 ->
          fixedIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueIdentifierSer,
              null,
            )
        158 ->
          fixedMoney =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueMoneySer,
              null,
            )
        159 ->
          fixedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValuePeriodSer,
              null,
            )
        160 ->
          fixedQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        161 ->
          fixedRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRangeSer,
              null,
            )
        162 ->
          fixedRatio =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRatioSer,
              null,
            )
        163 ->
          fixedRatioRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRatioRangeSer,
              null,
            )
        164 ->
          fixedReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueReferenceSer,
              null,
            )
        165 ->
          fixedSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueSampledDataSer,
              null,
            )
        166 ->
          fixedSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueSignatureSer,
              null,
            )
        167 ->
          fixedTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueTimingSer,
              null,
            )
        168 ->
          fixedContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContactDetailSer,
              null,
            )
        169 ->
          fixedContributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContributorSer,
              null,
            )
        170 ->
          fixedDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDataRequirementSer,
              null,
            )
        171 ->
          fixedExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueExpressionSer,
              null,
            )
        172 ->
          fixedParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueParameterDefinitionSer,
              null,
            )
        173 ->
          fixedRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRelatedArtifactSer,
              null,
            )
        174 ->
          fixedTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueTriggerDefinitionSer,
              null,
            )
        175 ->
          fixedUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueUsageContextSer,
              null,
            )
        176 ->
          fixedDosage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDosageSer,
              null,
            )
        177 -> patternBase64Binary = decoder.decodeStringElement(descriptor, i)
        178 ->
          _patternBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        179 -> patternBoolean = decoder.decodeBooleanElement(descriptor, i)
        180 ->
          _patternBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        181 -> patternCanonical = decoder.decodeStringElement(descriptor, i)
        182 ->
          _patternCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        183 -> patternCode = decoder.decodeStringElement(descriptor, i)
        184 ->
          _patternCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        185 -> patternDate = decoder.decodeStringElement(descriptor, i)
        186 ->
          _patternDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        187 -> patternDateTime = decoder.decodeStringElement(descriptor, i)
        188 ->
          _patternDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        189 ->
          patternDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        190 ->
          _patternDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        191 -> patternId = decoder.decodeStringElement(descriptor, i)
        192 ->
          _patternId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        193 -> patternInstant = decoder.decodeStringElement(descriptor, i)
        194 ->
          _patternInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        195 -> patternInteger = decoder.decodeIntElement(descriptor, i)
        196 ->
          _patternInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        197 -> patternMarkdown = decoder.decodeStringElement(descriptor, i)
        198 ->
          _patternMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        199 -> patternOid = decoder.decodeStringElement(descriptor, i)
        200 ->
          _patternOid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        201 -> patternPositiveInt = decoder.decodeIntElement(descriptor, i)
        202 ->
          _patternPositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        203 -> patternString = decoder.decodeStringElement(descriptor, i)
        204 ->
          _patternString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        205 ->
          patternTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        206 ->
          _patternTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        207 -> patternUnsignedInt = decoder.decodeIntElement(descriptor, i)
        208 ->
          _patternUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        209 -> patternUri = decoder.decodeStringElement(descriptor, i)
        210 ->
          _patternUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        211 -> patternUrl = decoder.decodeStringElement(descriptor, i)
        212 ->
          _patternUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        213 -> patternUuid = decoder.decodeStringElement(descriptor, i)
        214 ->
          _patternUuid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        215 ->
          patternAddress =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAddressSer,
              null,
            )
        216 ->
          patternAge =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAgeSer,
              null,
            )
        217 ->
          patternAnnotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAnnotationSer,
              null,
            )
        218 ->
          patternAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueAttachmentSer,
              null,
            )
        219 ->
          patternCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCodeableConceptSer,
              null,
            )
        220 ->
          patternCodeableReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCodeableReferenceSer,
              null,
            )
        221 ->
          patternCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSerInner, null)
        222 ->
          patternContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContactPointSer,
              null,
            )
        223 ->
          patternCount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueCountSer,
              null,
            )
        224 ->
          patternDistance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDistanceSer,
              null,
            )
        225 ->
          patternDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDurationSer,
              null,
            )
        226 ->
          patternHumanName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueHumanNameSer,
              null,
            )
        227 ->
          patternIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueIdentifierSer,
              null,
            )
        228 ->
          patternMoney =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueMoneySer,
              null,
            )
        229 ->
          patternPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValuePeriodSer,
              null,
            )
        230 ->
          patternQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        231 ->
          patternRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRangeSer,
              null,
            )
        232 ->
          patternRatio =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRatioSer,
              null,
            )
        233 ->
          patternRatioRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRatioRangeSer,
              null,
            )
        234 ->
          patternReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueReferenceSer,
              null,
            )
        235 ->
          patternSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueSampledDataSer,
              null,
            )
        236 ->
          patternSignature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueSignatureSer,
              null,
            )
        237 ->
          patternTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueTimingSer,
              null,
            )
        238 ->
          patternContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContactDetailSer,
              null,
            )
        239 ->
          patternContributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueContributorSer,
              null,
            )
        240 ->
          patternDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDataRequirementSer,
              null,
            )
        241 ->
          patternExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueExpressionSer,
              null,
            )
        242 ->
          patternParameterDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueParameterDefinitionSer,
              null,
            )
        243 ->
          patternRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueRelatedArtifactSer,
              null,
            )
        244 ->
          patternTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueTriggerDefinitionSer,
              null,
            )
        245 ->
          patternUsageContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueUsageContextSer,
              null,
            )
        246 ->
          patternDosage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueDosageSer,
              null,
            )
        247 ->
          example =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.exampleSer, null)
        248 -> minValueDate = decoder.decodeStringElement(descriptor, i)
        249 ->
          _minValueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        250 -> minValueDateTime = decoder.decodeStringElement(descriptor, i)
        251 ->
          _minValueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        252 -> minValueInstant = decoder.decodeStringElement(descriptor, i)
        253 ->
          _minValueInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        254 ->
          minValueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        255 ->
          _minValueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        256 ->
          minValueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        257 ->
          _minValueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        258 -> minValueInteger = decoder.decodeIntElement(descriptor, i)
        259 ->
          _minValueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        260 -> minValuePositiveInt = decoder.decodeIntElement(descriptor, i)
        261 ->
          _minValuePositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        262 -> minValueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        263 ->
          _minValueUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        264 ->
          minValueQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        265 -> maxValueDate = decoder.decodeStringElement(descriptor, i)
        266 ->
          _maxValueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        267 -> maxValueDateTime = decoder.decodeStringElement(descriptor, i)
        268 ->
          _maxValueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        269 -> maxValueInstant = decoder.decodeStringElement(descriptor, i)
        270 ->
          _maxValueInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        271 ->
          maxValueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        272 ->
          _maxValueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        273 ->
          maxValueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        274 ->
          _maxValueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        275 -> maxValueInteger = decoder.decodeIntElement(descriptor, i)
        276 ->
          _maxValueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        277 -> maxValuePositiveInt = decoder.decodeIntElement(descriptor, i)
        278 ->
          _maxValuePositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        279 -> maxValueUnsignedInt = decoder.decodeIntElement(descriptor, i)
        280 ->
          _maxValueUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        281 ->
          maxValueQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        282 -> maxLength = decoder.decodeIntElement(descriptor, i)
        283 ->
          _maxLength =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        284 ->
          condition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.representationSer,
              null,
            )
        285 ->
          _condition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.representationSer2,
              null,
            )
        286 ->
          constraint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.constraintSer, null)
        287 -> mustSupport = decoder.decodeBooleanElement(descriptor, i)
        288 ->
          _mustSupport =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        289 -> isModifier = decoder.decodeBooleanElement(descriptor, i)
        290 ->
          _isModifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        291 -> isModifierReason = decoder.decodeStringElement(descriptor, i)
        292 ->
          _isModifierReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        293 -> isSummary = decoder.decodeBooleanElement(descriptor, i)
        294 ->
          _isSummary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        295 ->
          binding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bindingSer, null)
        296 ->
          mapping =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mappingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ElementDefinition: " + i)
      }
    }
    return ElementDefinition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path =
        R4bString.of(path, _path)
          ?: throw SerializationException("Missing required property 'path' on ElementDefinition"),
      representation =
        (kotlin.collections.List(maxOf(representation?.size ?: 0, _representation?.size ?: 0)) {
          index ->
          Enumeration.of(
            ElementDefinition.PropertyRepresentation.fromCode(representation?.getOrNull(index)!!),
            _representation?.getOrNull(index),
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
          R4bString.of(alias?.getOrNull(index)?.let { it }, _alias?.getOrNull(index))!!
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
          Date.of(defaultValueDate?.let { FhirDate.fromString(it) }, _defaultValueDate),
          DateTime.of(
            defaultValueDateTime?.let { FhirDateTime.fromString(it) },
            _defaultValueDateTime,
          ),
          Decimal.of(defaultValueDecimal, _defaultValueDecimal),
          Id.of(defaultValueId, _defaultValueId),
          Instant.of(
            defaultValueInstant?.let { FhirDateTime.fromString(it) },
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
          Date.of(fixedDate?.let { FhirDate.fromString(it) }, _fixedDate),
          DateTime.of(fixedDateTime?.let { FhirDateTime.fromString(it) }, _fixedDateTime),
          Decimal.of(fixedDecimal, _fixedDecimal),
          Id.of(fixedId, _fixedId),
          Instant.of(fixedInstant?.let { FhirDateTime.fromString(it) }, _fixedInstant),
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
          Date.of(patternDate?.let { FhirDate.fromString(it) }, _patternDate),
          DateTime.of(patternDateTime?.let { FhirDateTime.fromString(it) }, _patternDateTime),
          Decimal.of(patternDecimal, _patternDecimal),
          Id.of(patternId, _patternId),
          Instant.of(patternInstant?.let { FhirDateTime.fromString(it) }, _patternInstant),
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
          Date.of(minValueDate?.let { FhirDate.fromString(it) }, _minValueDate),
          DateTime.of(minValueDateTime?.let { FhirDateTime.fromString(it) }, _minValueDateTime),
          Instant.of(minValueInstant?.let { FhirDateTime.fromString(it) }, _minValueInstant),
          Time.of(minValueTime, _minValueTime),
          Decimal.of(minValueDecimal, _minValueDecimal),
          Integer.of(minValueInteger, _minValueInteger),
          PositiveInt.of(minValuePositiveInt, _minValuePositiveInt),
          UnsignedInt.of(minValueUnsignedInt, _minValueUnsignedInt),
          minValueQuantity,
        ),
      maxValue =
        ElementDefinition.MaxValue.from(
          Date.of(maxValueDate?.let { FhirDate.fromString(it) }, _maxValueDate),
          DateTime.of(maxValueDateTime?.let { FhirDateTime.fromString(it) }, _maxValueDateTime),
          Instant.of(maxValueInstant?.let { FhirDateTime.fromString(it) }, _maxValueInstant),
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
          Id.of(condition?.getOrNull(index)?.let { it }, _condition?.getOrNull(index))!!
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ElementDefinition) {
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
    ((value.path.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.pathSer, it)
    }
    (value.representation.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.representationSer, it)
    }
    (value.representation.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.representationSer2, it)
    }
    ((value.sliceName?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.sliceName?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.pathSer, it)
    }
    ((value.sliceIsConstraining?.value))?.let { encoder.encodeBooleanElement(descriptor, 9, it) }
    (value.sliceIsConstraining?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.pathSer, it)
    }
    ((value.label?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.pathSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.codeSer, value.code)
    (value.slicing)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.slicingSer, it)
    }
    ((value.short?.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.short?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.pathSer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.pathSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(descriptor, 19, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.pathSer, it)
    }
    ((value.requirements?.value))?.let { encoder.encodeStringElement(descriptor, 21, it) }
    (value.requirements?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.pathSer, it)
    }
    (value.alias.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.representationSer, it)
    }
    (value.alias.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.representationSer2, it)
    }
    ((value.min?.value))?.let { encoder.encodeIntElement(descriptor, 25, it) }
    (value.min?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.pathSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(descriptor, 27, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.pathSer, it)
    }
    (value.base)?.let { encoder.encodeSerializableElement(descriptor, 29, Hoisted.baseSer, it) }
    ((value.contentReference?.value))?.let { encoder.encodeStringElement(descriptor, 30, it) }
    (value.contentReference?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 31, Hoisted.pathSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 32, Hoisted.typeSer, value.type)
    when (val choice = value.defaultValue) {
      null -> {}
      is ElementDefinition.DefaultValue.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 33, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 34, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 35, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 36, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 37, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 38, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 39, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 40, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 41, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 42, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 43, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 44, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 45, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 46, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 47, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 48, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 49, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 50, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 51, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 52, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 53, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 54, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Oid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 55, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 56, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 57, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 58, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 59, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 60, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 61, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 62, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 63, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 64, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 65, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 66, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 67, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 68, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Uuid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 69, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 70, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Address -> {
        encoder.encodeSerializableElement(
          descriptor,
          71,
          Hoisted.defaultValueAddressSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Age -> {
        encoder.encodeSerializableElement(descriptor, 72, Hoisted.defaultValueAgeSer, choice.value)
      }
      is ElementDefinition.DefaultValue.Annotation -> {
        encoder.encodeSerializableElement(
          descriptor,
          73,
          Hoisted.defaultValueAnnotationSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          74,
          Hoisted.defaultValueAttachmentSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          75,
          Hoisted.defaultValueCodeableConceptSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.CodeableReference -> {
        encoder.encodeSerializableElement(
          descriptor,
          76,
          Hoisted.defaultValueCodeableReferenceSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Coding -> {
        encoder.encodeSerializableElement(descriptor, 77, Hoisted.codeSerInner, choice.value)
      }
      is ElementDefinition.DefaultValue.ContactPoint -> {
        encoder.encodeSerializableElement(
          descriptor,
          78,
          Hoisted.defaultValueContactPointSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Count -> {
        encoder.encodeSerializableElement(
          descriptor,
          79,
          Hoisted.defaultValueCountSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Distance -> {
        encoder.encodeSerializableElement(
          descriptor,
          80,
          Hoisted.defaultValueDistanceSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          81,
          Hoisted.defaultValueDurationSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.HumanName -> {
        encoder.encodeSerializableElement(
          descriptor,
          82,
          Hoisted.defaultValueHumanNameSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Identifier -> {
        encoder.encodeSerializableElement(
          descriptor,
          83,
          Hoisted.defaultValueIdentifierSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Money -> {
        encoder.encodeSerializableElement(
          descriptor,
          84,
          Hoisted.defaultValueMoneySer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          85,
          Hoisted.defaultValuePeriodSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          86,
          Hoisted.defaultValueQuantitySer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          87,
          Hoisted.defaultValueRangeSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Ratio -> {
        encoder.encodeSerializableElement(
          descriptor,
          88,
          Hoisted.defaultValueRatioSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.RatioRange -> {
        encoder.encodeSerializableElement(
          descriptor,
          89,
          Hoisted.defaultValueRatioRangeSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          90,
          Hoisted.defaultValueReferenceSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.SampledData -> {
        encoder.encodeSerializableElement(
          descriptor,
          91,
          Hoisted.defaultValueSampledDataSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Signature -> {
        encoder.encodeSerializableElement(
          descriptor,
          92,
          Hoisted.defaultValueSignatureSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          93,
          Hoisted.defaultValueTimingSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.ContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          94,
          Hoisted.defaultValueContactDetailSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Contributor -> {
        encoder.encodeSerializableElement(
          descriptor,
          95,
          Hoisted.defaultValueContributorSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          96,
          Hoisted.defaultValueDataRequirementSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Expression -> {
        encoder.encodeSerializableElement(
          descriptor,
          97,
          Hoisted.defaultValueExpressionSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          98,
          Hoisted.defaultValueParameterDefinitionSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          descriptor,
          99,
          Hoisted.defaultValueRelatedArtifactSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          100,
          Hoisted.defaultValueTriggerDefinitionSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.UsageContext -> {
        encoder.encodeSerializableElement(
          descriptor,
          101,
          Hoisted.defaultValueUsageContextSer,
          choice.value,
        )
      }
      is ElementDefinition.DefaultValue.Dosage -> {
        encoder.encodeSerializableElement(
          descriptor,
          102,
          Hoisted.defaultValueDosageSer,
          choice.value,
        )
      }
    }
    ((value.meaningWhenMissing?.value))?.let { encoder.encodeStringElement(descriptor, 103, it) }
    (value.meaningWhenMissing?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 104, Hoisted.pathSer, it)
    }
    ((value.orderMeaning?.value))?.let { encoder.encodeStringElement(descriptor, 105, it) }
    (value.orderMeaning?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 106, Hoisted.pathSer, it)
    }
    when (val choice = value.fixed) {
      null -> {}
      is ElementDefinition.Fixed.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 107, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 108, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 109, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 110, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 111, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 112, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 113, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 114, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 115, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 116, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 117, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 118, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 119, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 120, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 121, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 122, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 123, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 124, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 125, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 126, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 127, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 128, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Oid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 129, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 130, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 131, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 132, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 133, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 134, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 135, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 136, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 137, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 138, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 139, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 140, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 141, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 142, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Uuid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 143, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 144, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Address -> {
        encoder.encodeSerializableElement(
          descriptor,
          145,
          Hoisted.defaultValueAddressSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Age -> {
        encoder.encodeSerializableElement(descriptor, 146, Hoisted.defaultValueAgeSer, choice.value)
      }
      is ElementDefinition.Fixed.Annotation -> {
        encoder.encodeSerializableElement(
          descriptor,
          147,
          Hoisted.defaultValueAnnotationSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          148,
          Hoisted.defaultValueAttachmentSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          149,
          Hoisted.defaultValueCodeableConceptSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.CodeableReference -> {
        encoder.encodeSerializableElement(
          descriptor,
          150,
          Hoisted.defaultValueCodeableReferenceSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Coding -> {
        encoder.encodeSerializableElement(descriptor, 151, Hoisted.codeSerInner, choice.value)
      }
      is ElementDefinition.Fixed.ContactPoint -> {
        encoder.encodeSerializableElement(
          descriptor,
          152,
          Hoisted.defaultValueContactPointSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Count -> {
        encoder.encodeSerializableElement(
          descriptor,
          153,
          Hoisted.defaultValueCountSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Distance -> {
        encoder.encodeSerializableElement(
          descriptor,
          154,
          Hoisted.defaultValueDistanceSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          155,
          Hoisted.defaultValueDurationSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.HumanName -> {
        encoder.encodeSerializableElement(
          descriptor,
          156,
          Hoisted.defaultValueHumanNameSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Identifier -> {
        encoder.encodeSerializableElement(
          descriptor,
          157,
          Hoisted.defaultValueIdentifierSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Money -> {
        encoder.encodeSerializableElement(
          descriptor,
          158,
          Hoisted.defaultValueMoneySer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          159,
          Hoisted.defaultValuePeriodSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          160,
          Hoisted.defaultValueQuantitySer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          161,
          Hoisted.defaultValueRangeSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Ratio -> {
        encoder.encodeSerializableElement(
          descriptor,
          162,
          Hoisted.defaultValueRatioSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.RatioRange -> {
        encoder.encodeSerializableElement(
          descriptor,
          163,
          Hoisted.defaultValueRatioRangeSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          164,
          Hoisted.defaultValueReferenceSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.SampledData -> {
        encoder.encodeSerializableElement(
          descriptor,
          165,
          Hoisted.defaultValueSampledDataSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Signature -> {
        encoder.encodeSerializableElement(
          descriptor,
          166,
          Hoisted.defaultValueSignatureSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          167,
          Hoisted.defaultValueTimingSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.ContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          168,
          Hoisted.defaultValueContactDetailSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Contributor -> {
        encoder.encodeSerializableElement(
          descriptor,
          169,
          Hoisted.defaultValueContributorSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          170,
          Hoisted.defaultValueDataRequirementSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Expression -> {
        encoder.encodeSerializableElement(
          descriptor,
          171,
          Hoisted.defaultValueExpressionSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          172,
          Hoisted.defaultValueParameterDefinitionSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          descriptor,
          173,
          Hoisted.defaultValueRelatedArtifactSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          174,
          Hoisted.defaultValueTriggerDefinitionSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.UsageContext -> {
        encoder.encodeSerializableElement(
          descriptor,
          175,
          Hoisted.defaultValueUsageContextSer,
          choice.value,
        )
      }
      is ElementDefinition.Fixed.Dosage -> {
        encoder.encodeSerializableElement(
          descriptor,
          176,
          Hoisted.defaultValueDosageSer,
          choice.value,
        )
      }
    }
    when (val choice = value.pattern) {
      null -> {}
      is ElementDefinition.Pattern.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 177, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 178, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 179, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 180, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 181, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 182, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 183, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 184, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 185, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 186, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 187, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 188, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 189, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 190, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 191, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 192, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 193, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 194, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 195, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 196, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 197, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 198, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Oid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 199, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 200, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 201, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 202, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 203, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 204, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 205, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 206, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 207, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 208, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 209, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 210, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 211, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 212, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Uuid -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 213, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 214, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Address -> {
        encoder.encodeSerializableElement(
          descriptor,
          215,
          Hoisted.defaultValueAddressSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Age -> {
        encoder.encodeSerializableElement(descriptor, 216, Hoisted.defaultValueAgeSer, choice.value)
      }
      is ElementDefinition.Pattern.Annotation -> {
        encoder.encodeSerializableElement(
          descriptor,
          217,
          Hoisted.defaultValueAnnotationSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          218,
          Hoisted.defaultValueAttachmentSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          219,
          Hoisted.defaultValueCodeableConceptSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.CodeableReference -> {
        encoder.encodeSerializableElement(
          descriptor,
          220,
          Hoisted.defaultValueCodeableReferenceSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Coding -> {
        encoder.encodeSerializableElement(descriptor, 221, Hoisted.codeSerInner, choice.value)
      }
      is ElementDefinition.Pattern.ContactPoint -> {
        encoder.encodeSerializableElement(
          descriptor,
          222,
          Hoisted.defaultValueContactPointSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Count -> {
        encoder.encodeSerializableElement(
          descriptor,
          223,
          Hoisted.defaultValueCountSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Distance -> {
        encoder.encodeSerializableElement(
          descriptor,
          224,
          Hoisted.defaultValueDistanceSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          225,
          Hoisted.defaultValueDurationSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.HumanName -> {
        encoder.encodeSerializableElement(
          descriptor,
          226,
          Hoisted.defaultValueHumanNameSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Identifier -> {
        encoder.encodeSerializableElement(
          descriptor,
          227,
          Hoisted.defaultValueIdentifierSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Money -> {
        encoder.encodeSerializableElement(
          descriptor,
          228,
          Hoisted.defaultValueMoneySer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          229,
          Hoisted.defaultValuePeriodSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          230,
          Hoisted.defaultValueQuantitySer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          231,
          Hoisted.defaultValueRangeSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Ratio -> {
        encoder.encodeSerializableElement(
          descriptor,
          232,
          Hoisted.defaultValueRatioSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.RatioRange -> {
        encoder.encodeSerializableElement(
          descriptor,
          233,
          Hoisted.defaultValueRatioRangeSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          234,
          Hoisted.defaultValueReferenceSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.SampledData -> {
        encoder.encodeSerializableElement(
          descriptor,
          235,
          Hoisted.defaultValueSampledDataSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Signature -> {
        encoder.encodeSerializableElement(
          descriptor,
          236,
          Hoisted.defaultValueSignatureSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          237,
          Hoisted.defaultValueTimingSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.ContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          238,
          Hoisted.defaultValueContactDetailSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Contributor -> {
        encoder.encodeSerializableElement(
          descriptor,
          239,
          Hoisted.defaultValueContributorSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          240,
          Hoisted.defaultValueDataRequirementSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Expression -> {
        encoder.encodeSerializableElement(
          descriptor,
          241,
          Hoisted.defaultValueExpressionSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          242,
          Hoisted.defaultValueParameterDefinitionSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          descriptor,
          243,
          Hoisted.defaultValueRelatedArtifactSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          descriptor,
          244,
          Hoisted.defaultValueTriggerDefinitionSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.UsageContext -> {
        encoder.encodeSerializableElement(
          descriptor,
          245,
          Hoisted.defaultValueUsageContextSer,
          choice.value,
        )
      }
      is ElementDefinition.Pattern.Dosage -> {
        encoder.encodeSerializableElement(
          descriptor,
          246,
          Hoisted.defaultValueDosageSer,
          choice.value,
        )
      }
    }
    if (value.example.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 247, Hoisted.exampleSer, value.example)
    when (val choice = value.minValue) {
      null -> {}
      is ElementDefinition.MinValue.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 248, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 249, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 250, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 251, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 252, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 253, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 254, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 255, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 256, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 257, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 258, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 259, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 260, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 261, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 262, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 263, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          264,
          Hoisted.defaultValueQuantitySer,
          choice.value,
        )
      }
    }
    when (val choice = value.maxValue) {
      null -> {}
      is ElementDefinition.MaxValue.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 265, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 266, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 267, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 268, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Instant -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 269, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 270, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 271, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 272, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 273, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 274, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 275, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 276, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 277, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 278, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 279, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 280, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          281,
          Hoisted.defaultValueQuantitySer,
          choice.value,
        )
      }
    }
    ((value.maxLength?.value))?.let { encoder.encodeIntElement(descriptor, 282, it) }
    (value.maxLength?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 283, Hoisted.pathSer, it)
    }
    (value.condition.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 284, Hoisted.representationSer, it)
    }
    (value.condition.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 285, Hoisted.representationSer2, it)
    }
    if (value.constraint.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 286, Hoisted.constraintSer, value.constraint)
    ((value.mustSupport?.value))?.let { encoder.encodeBooleanElement(descriptor, 287, it) }
    (value.mustSupport?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 288, Hoisted.pathSer, it)
    }
    ((value.isModifier?.value))?.let { encoder.encodeBooleanElement(descriptor, 289, it) }
    (value.isModifier?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 290, Hoisted.pathSer, it)
    }
    ((value.isModifierReason?.value))?.let { encoder.encodeStringElement(descriptor, 291, it) }
    (value.isModifierReason?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 292, Hoisted.pathSer, it)
    }
    ((value.isSummary?.value))?.let { encoder.encodeBooleanElement(descriptor, 293, it) }
    (value.isSummary?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 294, Hoisted.pathSer, it)
    }
    (value.binding)?.let {
      encoder.encodeSerializableElement(descriptor, 295, Hoisted.bindingSer, it)
    }
    if (value.mapping.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 296, Hoisted.mappingSer, value.mapping)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()

    public val representationSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val representationSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.representationSerInner).nullable)

    public val representationSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.pathSer).nullable)

    public val codeSerInner: KSerializer<Coding> = Coding.serializer()

    public val codeSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.codeSerInner)

    public val slicingSer: KSerializer<ElementDefinition.Slicing> =
      ElementDefinition.Slicing.serializer()

    public val baseSer: KSerializer<ElementDefinition.Base> = ElementDefinition.Base.serializer()

    public val typeSerInner: KSerializer<ElementDefinition.Type> =
      ElementDefinition.Type.serializer()

    public val typeSer: KSerializer<List<ElementDefinition.Type>> =
      ListSerializer(Hoisted.typeSerInner)

    public val defaultValueAddressSer: KSerializer<Address> = Address.serializer()

    public val defaultValueAgeSer: KSerializer<Age> = Age.serializer()

    public val defaultValueAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val defaultValueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val defaultValueCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val defaultValueCodeableReferenceSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val defaultValueContactPointSer: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val defaultValueCountSer: KSerializer<Count> = Count.serializer()

    public val defaultValueDistanceSer: KSerializer<Distance> = Distance.serializer()

    public val defaultValueDurationSer: KSerializer<Duration> = Duration.serializer()

    public val defaultValueHumanNameSer: KSerializer<HumanName> = HumanName.serializer()

    public val defaultValueIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val defaultValueMoneySer: KSerializer<Money> = Money.serializer()

    public val defaultValuePeriodSer: KSerializer<Period> = Period.serializer()

    public val defaultValueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val defaultValueRangeSer: KSerializer<Range> = Range.serializer()

    public val defaultValueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val defaultValueRatioRangeSer: KSerializer<RatioRange> = RatioRange.serializer()

    public val defaultValueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val defaultValueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val defaultValueSignatureSer: KSerializer<Signature> = Signature.serializer()

    public val defaultValueTimingSer: KSerializer<Timing> = Timing.serializer()

    public val defaultValueContactDetailSer: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val defaultValueContributorSer: KSerializer<Contributor> = Contributor.serializer()

    public val defaultValueDataRequirementSer: KSerializer<DataRequirement> =
      DataRequirement.serializer()

    public val defaultValueExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val defaultValueParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val defaultValueRelatedArtifactSer: KSerializer<RelatedArtifact> =
      RelatedArtifact.serializer()

    public val defaultValueTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val defaultValueUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val defaultValueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val exampleSerInner: KSerializer<ElementDefinition.Example> =
      ElementDefinition.Example.serializer()

    public val exampleSer: KSerializer<List<ElementDefinition.Example>> =
      ListSerializer(Hoisted.exampleSerInner)

    public val constraintSerInner: KSerializer<ElementDefinition.Constraint> =
      ElementDefinition.Constraint.serializer()

    public val constraintSer: KSerializer<List<ElementDefinition.Constraint>> =
      ListSerializer(Hoisted.constraintSerInner)

    public val bindingSer: KSerializer<ElementDefinition.Binding> =
      ElementDefinition.Binding.serializer()

    public val mappingSerInner: KSerializer<ElementDefinition.Mapping> =
      ElementDefinition.Mapping.serializer()

    public val mappingSer: KSerializer<List<ElementDefinition.Mapping>> =
      ListSerializer(Hoisted.mappingSerInner)
  }
}
