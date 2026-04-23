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
import dev.ohs.fhir.model.r5.ElementDefinition
import dev.ohs.fhir.model.r5.Enumeration
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
import dev.ohs.fhir.model.r5.terminologies.BindingStrength
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Slicing {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          discriminator =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.discriminatorSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> ordered = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _ordered =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        7 -> rules = decoder.decodeStringElement(__desc, 7)
        8 ->
          _rules =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Slicing: " + __i)
      }
    }
    return ElementDefinition.Slicing(
      id = id,
      extension = extension ?: listOf(),
      discriminator = discriminator ?: listOf(),
      description = R5String.of(description, _description),
      ordered = R5Boolean.of(ordered, _ordered),
      rules = Enumeration.of(ElementDefinition.SlicingRules.fromCode(rules!!), _rules),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ElementDefinition.Slicing) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.discriminator.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.discriminatorSer, value.discriminator)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    ((value.ordered?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.ordered?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    ((value.rules.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.rules.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing.Discriminator) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Slicing.Discriminator {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var path: KotlinString? = null
    var _path: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(__desc, 2)
        3 -> _type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> path = decoder.decodeStringElement(__desc, 4)
        5 -> _path = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Discriminator: " + __i)
      }
    }
    return ElementDefinition.Slicing.Discriminator(
      id = id,
      extension = extension ?: listOf(),
      type = Enumeration.of(ElementDefinition.DiscriminatorType.fromCode(type!!), _type),
      path = R5String.of(path, _path)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ElementDefinition.Slicing.Discriminator,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it)
    }
    ((value.path.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Base) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Base {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> path = decoder.decodeStringElement(__desc, 2)
        3 -> _path = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.pathSer, null)
        4 -> min = decoder.decodeIntElement(__desc, 4)
        5 -> _min = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.pathSer, null)
        6 -> max = decoder.decodeStringElement(__desc, 6)
        7 -> _max = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.pathSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Base: " + __i)
      }
    }
    return ElementDefinition.Base(
      id = id,
      extension = extension ?: listOf(),
      path = R5String.of(path, _path)!!,
      min = UnsignedInt.of(min, _min)!!,
      max = R5String.of(max, _max)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ElementDefinition.Base) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.path.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.pathSer, it)
    }
    ((value.min.value))?.let { encoder.encodeIntElement(__desc, 4, it) }
    (value.min.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.pathSer, it)
    }
    ((value.max.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.max.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.pathSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Type) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Type {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> code = decoder.decodeStringElement(__desc, 2)
        3 -> _code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          profile = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.profileSer, null)
        5 ->
          _profile = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.profileSer2, null)
        6 ->
          targetProfile =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.profileSer, null)
        7 ->
          _targetProfile =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.profileSer2, null)
        8 ->
          aggregation =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.profileSer, null)
        9 ->
          _aggregation =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.profileSer2, null)
        10 -> versioning = decoder.decodeStringElement(__desc, 10)
        11 ->
          _versioning = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Type: " + __i)
      }
    }
    return ElementDefinition.Type(
      id = id,
      extension = extension ?: listOf(),
      code = Uri.of(code, _code)!!,
      profile =
        (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { __i ->
          Canonical.of(profile?.getOrNull(__i)?.let { it }, _profile?.getOrNull(__i))!!
        }),
      targetProfile =
        (kotlin.collections.List(maxOf(targetProfile?.size ?: 0, _targetProfile?.size ?: 0)) { __i
          ->
          Canonical.of(targetProfile?.getOrNull(__i)?.let { it }, _targetProfile?.getOrNull(__i))!!
        }),
      aggregation =
        (kotlin.collections.List(maxOf(aggregation?.size ?: 0, _aggregation?.size ?: 0)) { __i ->
          Enumeration.of(
            ElementDefinition.AggregationMode.fromCode(aggregation?.getOrNull(__i)!!),
            _aggregation?.getOrNull(__i),
          )
        }),
      versioning =
        versioning?.let {
          Enumeration.of(ElementDefinition.ReferenceVersionRules.fromCode(it), _versioning)
        },
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ElementDefinition.Type) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.code.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.profileSer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.profileSer2, it)
    }
    (value.targetProfile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.profileSer, it)
    }
    (value.targetProfile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.profileSer2, it)
    }
    (value.aggregation.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.profileSer, it)
    }
    (value.aggregation.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.profileSer2, it)
    }
    ((value.versioning?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.versioning?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.codeSer, it)
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
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Example =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Example) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Example {
    val __desc = descriptor
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
        2 -> label = decoder.decodeStringElement(__desc, 2)
        3 -> _label = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.labelSer, null)
        4 -> valueBase64Binary = decoder.decodeStringElement(__desc, 4)
        5 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.labelSer, null)
        6 -> valueBoolean = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.labelSer, null)
        8 -> valueCanonical = decoder.decodeStringElement(__desc, 8)
        9 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.labelSer, null)
        10 -> valueCode = decoder.decodeStringElement(__desc, 10)
        11 ->
          _valueCode = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.labelSer, null)
        12 -> valueDate = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueDate = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.labelSer, null)
        14 -> valueDateTime = decoder.decodeStringElement(__desc, 14)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.labelSer, null)
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 16, BigDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.labelSer, null)
        18 -> valueId = decoder.decodeStringElement(__desc, 18)
        19 ->
          _valueId = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.labelSer, null)
        20 -> valueInstant = decoder.decodeStringElement(__desc, 20)
        21 ->
          _valueInstant =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.labelSer, null)
        22 -> valueInteger = decoder.decodeIntElement(__desc, 22)
        23 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.labelSer, null)
        24 -> valueInteger64 = decoder.decodeStringElement(__desc, 24)
        25 ->
          _valueInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.labelSer, null)
        26 -> valueMarkdown = decoder.decodeStringElement(__desc, 26)
        27 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.labelSer, null)
        28 -> valueOid = decoder.decodeStringElement(__desc, 28)
        29 ->
          _valueOid = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.labelSer, null)
        30 -> valuePositiveInt = decoder.decodeIntElement(__desc, 30)
        31 ->
          _valuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.labelSer, null)
        32 -> valueString = decoder.decodeStringElement(__desc, 32)
        33 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.labelSer, null)
        34 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 34, LocalTimeSerializer, null)
        35 ->
          _valueTime = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.labelSer, null)
        36 -> valueUnsignedInt = decoder.decodeIntElement(__desc, 36)
        37 ->
          _valueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.labelSer, null)
        38 -> valueUri = decoder.decodeStringElement(__desc, 38)
        39 ->
          _valueUri = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.labelSer, null)
        40 -> valueUrl = decoder.decodeStringElement(__desc, 40)
        41 ->
          _valueUrl = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.labelSer, null)
        42 -> valueUuid = decoder.decodeStringElement(__desc, 42)
        43 ->
          _valueUuid = decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.labelSer, null)
        44 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.valueAddressSer, null)
        45 ->
          valueAge =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.valueAgeSer, null)
        46 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.valueAnnotationSer, null)
        47 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.valueAttachmentSer, null)
        48 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              48,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        49 ->
          valueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              49,
              Hoisted.valueCodeableReferenceSer,
              null,
            )
        50 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.valueCodingSer, null)
        51 ->
          valueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              51,
              Hoisted.valueContactPointSer,
              null,
            )
        52 ->
          valueCount =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.valueCountSer, null)
        53 ->
          valueDistance =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.valueDistanceSer, null)
        54 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.valueDurationSer, null)
        55 ->
          valueHumanName =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.valueHumanNameSer, null)
        56 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.valueIdentifierSer, null)
        57 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.valueMoneySer, null)
        58 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.valuePeriodSer, null)
        59 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.valueQuantitySer, null)
        60 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.valueRangeSer, null)
        61 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.valueRatioSer, null)
        62 ->
          valueRatioRange =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.valueRatioRangeSer, null)
        63 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 63, Hoisted.valueReferenceSer, null)
        64 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.valueSampledDataSer, null)
        65 ->
          valueSignature =
            decoder.decodeNullableSerializableElement(__desc, 65, Hoisted.valueSignatureSer, null)
        66 ->
          valueTiming =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.valueTimingSer, null)
        67 ->
          valueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              67,
              Hoisted.valueContactDetailSer,
              null,
            )
        68 ->
          valueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              68,
              Hoisted.valueDataRequirementSer,
              null,
            )
        69 ->
          valueExpression =
            decoder.decodeNullableSerializableElement(__desc, 69, Hoisted.valueExpressionSer, null)
        70 ->
          valueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              70,
              Hoisted.valueParameterDefinitionSer,
              null,
            )
        71 ->
          valueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              71,
              Hoisted.valueRelatedArtifactSer,
              null,
            )
        72 ->
          valueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              72,
              Hoisted.valueTriggerDefinitionSer,
              null,
            )
        73 ->
          valueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              73,
              Hoisted.valueUsageContextSer,
              null,
            )
        74 ->
          valueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              74,
              Hoisted.valueAvailabilitySer,
              null,
            )
        75 ->
          valueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              75,
              Hoisted.valueExtendedContactDetailSer,
              null,
            )
        76 ->
          valueDosage =
            decoder.decodeNullableSerializableElement(__desc, 76, Hoisted.valueDosageSer, null)
        77 ->
          valueMeta =
            decoder.decodeNullableSerializableElement(__desc, 77, Hoisted.valueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Example: " + __i)
      }
    }
    return ElementDefinition.Example(
      id = id,
      extension = extension ?: listOf(),
      label = R5String.of(label, _label)!!,
      `value` =
        ElementDefinition.Example.Value.from(
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
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ElementDefinition.Example) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.label.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.label.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.labelSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is ElementDefinition.Example.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 16, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 19, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 25, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 27, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 29, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 30, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 31, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 33, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 34, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 35, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 36, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 37, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 39, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 41, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 43, Hoisted.labelSer, it)
        }
      }
      is ElementDefinition.Example.Value.Address -> {
        encoder.encodeSerializableElement(__desc, 44, Hoisted.valueAddressSer, __d.value)
      }
      is ElementDefinition.Example.Value.Age -> {
        encoder.encodeSerializableElement(__desc, 45, Hoisted.valueAgeSer, __d.value)
      }
      is ElementDefinition.Example.Value.Annotation -> {
        encoder.encodeSerializableElement(__desc, 46, Hoisted.valueAnnotationSer, __d.value)
      }
      is ElementDefinition.Example.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 47, Hoisted.valueAttachmentSer, __d.value)
      }
      is ElementDefinition.Example.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 48, Hoisted.valueCodeableConceptSer, __d.value)
      }
      is ElementDefinition.Example.Value.CodeableReference -> {
        encoder.encodeSerializableElement(__desc, 49, Hoisted.valueCodeableReferenceSer, __d.value)
      }
      is ElementDefinition.Example.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 50, Hoisted.valueCodingSer, __d.value)
      }
      is ElementDefinition.Example.Value.ContactPoint -> {
        encoder.encodeSerializableElement(__desc, 51, Hoisted.valueContactPointSer, __d.value)
      }
      is ElementDefinition.Example.Value.Count -> {
        encoder.encodeSerializableElement(__desc, 52, Hoisted.valueCountSer, __d.value)
      }
      is ElementDefinition.Example.Value.Distance -> {
        encoder.encodeSerializableElement(__desc, 53, Hoisted.valueDistanceSer, __d.value)
      }
      is ElementDefinition.Example.Value.Duration -> {
        encoder.encodeSerializableElement(__desc, 54, Hoisted.valueDurationSer, __d.value)
      }
      is ElementDefinition.Example.Value.HumanName -> {
        encoder.encodeSerializableElement(__desc, 55, Hoisted.valueHumanNameSer, __d.value)
      }
      is ElementDefinition.Example.Value.Identifier -> {
        encoder.encodeSerializableElement(__desc, 56, Hoisted.valueIdentifierSer, __d.value)
      }
      is ElementDefinition.Example.Value.Money -> {
        encoder.encodeSerializableElement(__desc, 57, Hoisted.valueMoneySer, __d.value)
      }
      is ElementDefinition.Example.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 58, Hoisted.valuePeriodSer, __d.value)
      }
      is ElementDefinition.Example.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 59, Hoisted.valueQuantitySer, __d.value)
      }
      is ElementDefinition.Example.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 60, Hoisted.valueRangeSer, __d.value)
      }
      is ElementDefinition.Example.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 61, Hoisted.valueRatioSer, __d.value)
      }
      is ElementDefinition.Example.Value.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 62, Hoisted.valueRatioRangeSer, __d.value)
      }
      is ElementDefinition.Example.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 63, Hoisted.valueReferenceSer, __d.value)
      }
      is ElementDefinition.Example.Value.SampledData -> {
        encoder.encodeSerializableElement(__desc, 64, Hoisted.valueSampledDataSer, __d.value)
      }
      is ElementDefinition.Example.Value.Signature -> {
        encoder.encodeSerializableElement(__desc, 65, Hoisted.valueSignatureSer, __d.value)
      }
      is ElementDefinition.Example.Value.Timing -> {
        encoder.encodeSerializableElement(__desc, 66, Hoisted.valueTimingSer, __d.value)
      }
      is ElementDefinition.Example.Value.ContactDetail -> {
        encoder.encodeSerializableElement(__desc, 67, Hoisted.valueContactDetailSer, __d.value)
      }
      is ElementDefinition.Example.Value.DataRequirement -> {
        encoder.encodeSerializableElement(__desc, 68, Hoisted.valueDataRequirementSer, __d.value)
      }
      is ElementDefinition.Example.Value.Expression -> {
        encoder.encodeSerializableElement(__desc, 69, Hoisted.valueExpressionSer, __d.value)
      }
      is ElementDefinition.Example.Value.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          70,
          Hoisted.valueParameterDefinitionSer,
          __d.value,
        )
      }
      is ElementDefinition.Example.Value.RelatedArtifact -> {
        encoder.encodeSerializableElement(__desc, 71, Hoisted.valueRelatedArtifactSer, __d.value)
      }
      is ElementDefinition.Example.Value.TriggerDefinition -> {
        encoder.encodeSerializableElement(__desc, 72, Hoisted.valueTriggerDefinitionSer, __d.value)
      }
      is ElementDefinition.Example.Value.UsageContext -> {
        encoder.encodeSerializableElement(__desc, 73, Hoisted.valueUsageContextSer, __d.value)
      }
      is ElementDefinition.Example.Value.Availability -> {
        encoder.encodeSerializableElement(__desc, 74, Hoisted.valueAvailabilitySer, __d.value)
      }
      is ElementDefinition.Example.Value.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          75,
          Hoisted.valueExtendedContactDetailSer,
          __d.value,
        )
      }
      is ElementDefinition.Example.Value.Dosage -> {
        encoder.encodeSerializableElement(__desc, 76, Hoisted.valueDosageSer, __d.value)
      }
      is ElementDefinition.Example.Value.Meta -> {
        encoder.encodeSerializableElement(__desc, 77, Hoisted.valueMetaSer, __d.value)
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
      element("suppress", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_suppress", Element.serializer().descriptor, isOptional = true)
      element("human", KotlinString.serializer().descriptor, isOptional = true)
      element("_human", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
      element("source", KotlinString.serializer().descriptor, isOptional = true)
      element("_source", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Constraint =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Constraint) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Constraint {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> key = decoder.decodeStringElement(__desc, 2)
        3 -> _key = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.keySer, null)
        4 -> requirements = decoder.decodeStringElement(__desc, 4)
        5 ->
          _requirements = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.keySer, null)
        6 -> severity = decoder.decodeStringElement(__desc, 6)
        7 -> _severity = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.keySer, null)
        8 -> suppress = decoder.decodeBooleanElement(__desc, 8)
        9 -> _suppress = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.keySer, null)
        10 -> human = decoder.decodeStringElement(__desc, 10)
        11 -> _human = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.keySer, null)
        12 -> expression = decoder.decodeStringElement(__desc, 12)
        13 ->
          _expression = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.keySer, null)
        14 -> source = decoder.decodeStringElement(__desc, 14)
        15 -> _source = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.keySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Constraint: " + __i)
      }
    }
    return ElementDefinition.Constraint(
      id = id,
      extension = extension ?: listOf(),
      key = Id.of(key, _key)!!,
      requirements = Markdown.of(requirements, _requirements),
      severity =
        Enumeration.of(ElementDefinition.ConstraintSeverity.fromCode(severity!!), _severity),
      suppress = R5Boolean.of(suppress, _suppress),
      human = R5String.of(human, _human)!!,
      expression = R5String.of(expression, _expression),
      source = Canonical.of(source, _source),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ElementDefinition.Constraint) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.key.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.key.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.keySer, it)
    }
    ((value.requirements?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.requirements?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.keySer, it)
    }
    ((value.severity.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.severity.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.keySer, it)
    }
    ((value.suppress?.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
    (value.suppress?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.keySer, it)
    }
    ((value.human.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.human.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.keySer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.keySer, it)
    }
    ((value.source?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.keySer, it)
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
      element(
        "additional",
        listSerialDescriptor(
          lazyDescriptor { ElementDefinition.Binding.Additional.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Binding =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Binding) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Binding {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> strength = decoder.decodeStringElement(__desc, 2)
        3 ->
          _strength =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.strengthSer, null)
        4 -> description = decoder.decodeStringElement(__desc, 4)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.strengthSer, null)
        6 -> valueSet = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.strengthSer, null)
        8 ->
          additional =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.additionalSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Binding: " + __i)
      }
    }
    return ElementDefinition.Binding(
      id = id,
      extension = extension ?: listOf(),
      strength = Enumeration.of(BindingStrength.fromCode(strength!!), _strength),
      description = Markdown.of(description, _description),
      valueSet = Canonical.of(valueSet, _valueSet),
      additional = additional ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ElementDefinition.Binding) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.strength.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.strength.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.strengthSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.strengthSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.strengthSer, it)
    }
    if (value.additional.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.additionalSer, value.additional)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val strengthSer: KSerializer<Element> = Element.serializer()

    public val additionalSerInner: KSerializer<ElementDefinition.Binding.Additional> =
      ElementDefinition.Binding.Additional.serializer()

    public val additionalSer: KSerializer<List<ElementDefinition.Binding.Additional>> =
      ListSerializer(Hoisted.additionalSerInner)
  }
}

internal object ElementDefinitionBindingAdditionalSerializer :
  KSerializer<ElementDefinition.Binding.Additional> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Additional") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element("shortDoco", KotlinString.serializer().descriptor, isOptional = true)
      element("_shortDoco", Element.serializer().descriptor, isOptional = true)
      element(
        "usage",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element("any", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_any", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ElementDefinition.Binding.Additional =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Binding.Additional) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Binding.Additional {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> purpose = decoder.decodeStringElement(__desc, 2)
        3 ->
          _purpose = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.purposeSer, null)
        4 -> valueSet = decoder.decodeStringElement(__desc, 4)
        5 ->
          _valueSet = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.purposeSer, null)
        6 -> documentation = decoder.decodeStringElement(__desc, 6)
        7 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.purposeSer, null)
        8 -> shortDoco = decoder.decodeStringElement(__desc, 8)
        9 ->
          _shortDoco =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.purposeSer, null)
        10 -> usage = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.usageSer, null)
        11 -> any = decoder.decodeBooleanElement(__desc, 11)
        12 -> _any = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.purposeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Additional: " + __i)
      }
    }
    return ElementDefinition.Binding.Additional(
      id = id,
      extension = extension ?: listOf(),
      purpose =
        Enumeration.of(ElementDefinition.AdditionalBindingPurposeVS.fromCode(purpose!!), _purpose),
      valueSet = Canonical.of(valueSet, _valueSet)!!,
      documentation = Markdown.of(documentation, _documentation),
      shortDoco = R5String.of(shortDoco, _shortDoco),
      usage = usage ?: listOf(),
      any = R5Boolean.of(any, _any),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ElementDefinition.Binding.Additional,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.purpose.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.purpose.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.purposeSer, it)
    }
    ((value.valueSet.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.valueSet.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.purposeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.purposeSer, it)
    }
    ((value.shortDoco?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.shortDoco?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.purposeSer, it)
    }
    if (value.usage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.usageSer, value.usage)
    ((value.any?.value))?.let { encoder.encodeBooleanElement(__desc, 11, it) }
    (value.any?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.purposeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val purposeSer: KSerializer<Element> = Element.serializer()

    public val usageSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val usageSer: KSerializer<List<UsageContext>> = ListSerializer(Hoisted.usageSerInner)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Mapping) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Mapping {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> identity = decoder.decodeStringElement(__desc, 2)
        3 ->
          _identity =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identitySer, null)
        4 -> language = decoder.decodeStringElement(__desc, 4)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.identitySer, null)
        6 -> map = decoder.decodeStringElement(__desc, 6)
        7 -> _map = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.identitySer, null)
        8 -> comment = decoder.decodeStringElement(__desc, 8)
        9 ->
          _comment = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.identitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mapping: " + __i)
      }
    }
    return ElementDefinition.Mapping(
      id = id,
      extension = extension ?: listOf(),
      identity = Id.of(identity, _identity)!!,
      language = Code.of(language, _language),
      map = R5String.of(map, _map)!!,
      comment = Markdown.of(comment, _comment),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ElementDefinition.Mapping) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.identity.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.identity.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identitySer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.identitySer, it)
    }
    ((value.map.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.map.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.identitySer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.identitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identitySer: KSerializer<Element> = Element.serializer()
  }
}

internal object ElementDefinitionDefaultValueSerializer :
  KSerializer<ElementDefinition.DefaultValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ElementDefinition.DefaultValue") {
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
      element("defaultValueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_defaultValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("defaultValueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueId", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueInstant", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_defaultValueInteger", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueInteger64", Element.serializer().descriptor, isOptional = true)
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
      element("defaultValueAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "defaultValueExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("defaultValueDosage", Dosage.serializer().descriptor, isOptional = true)
      element("defaultValueMeta", Meta.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.DefaultValue) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ElementDefinition.DefaultValue.Base64Binary -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Code -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 8, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 10, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 12, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Id -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 14, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 15, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Instant -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 16, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 17, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 18, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 19, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Integer64 -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 20, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 21, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Markdown -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 22, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 23, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Oid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 24, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 25, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.PositiveInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 26, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 27, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 28, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 29, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 30, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 31, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.UnsignedInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 32, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 33, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Uri -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 34, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 35, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Url -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 36, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 37, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Uuid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 38, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 39, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.DefaultValue.Address -> {
          encodeSerializableElement(__desc, 40, Hoisted.defaultValueAddressSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Age -> {
          encodeSerializableElement(__desc, 41, Hoisted.defaultValueAgeSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Annotation -> {
          encodeSerializableElement(__desc, 42, Hoisted.defaultValueAnnotationSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Attachment -> {
          encodeSerializableElement(__desc, 43, Hoisted.defaultValueAttachmentSer, __d.value)
        }
        is ElementDefinition.DefaultValue.CodeableConcept -> {
          encodeSerializableElement(__desc, 44, Hoisted.defaultValueCodeableConceptSer, __d.value)
        }
        is ElementDefinition.DefaultValue.CodeableReference -> {
          encodeSerializableElement(__desc, 45, Hoisted.defaultValueCodeableReferenceSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Coding -> {
          encodeSerializableElement(__desc, 46, Hoisted.defaultValueCodingSer, __d.value)
        }
        is ElementDefinition.DefaultValue.ContactPoint -> {
          encodeSerializableElement(__desc, 47, Hoisted.defaultValueContactPointSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Count -> {
          encodeSerializableElement(__desc, 48, Hoisted.defaultValueCountSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Distance -> {
          encodeSerializableElement(__desc, 49, Hoisted.defaultValueDistanceSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Duration -> {
          encodeSerializableElement(__desc, 50, Hoisted.defaultValueDurationSer, __d.value)
        }
        is ElementDefinition.DefaultValue.HumanName -> {
          encodeSerializableElement(__desc, 51, Hoisted.defaultValueHumanNameSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Identifier -> {
          encodeSerializableElement(__desc, 52, Hoisted.defaultValueIdentifierSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Money -> {
          encodeSerializableElement(__desc, 53, Hoisted.defaultValueMoneySer, __d.value)
        }
        is ElementDefinition.DefaultValue.Period -> {
          encodeSerializableElement(__desc, 54, Hoisted.defaultValuePeriodSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Quantity -> {
          encodeSerializableElement(__desc, 55, Hoisted.defaultValueQuantitySer, __d.value)
        }
        is ElementDefinition.DefaultValue.Range -> {
          encodeSerializableElement(__desc, 56, Hoisted.defaultValueRangeSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Ratio -> {
          encodeSerializableElement(__desc, 57, Hoisted.defaultValueRatioSer, __d.value)
        }
        is ElementDefinition.DefaultValue.RatioRange -> {
          encodeSerializableElement(__desc, 58, Hoisted.defaultValueRatioRangeSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Reference -> {
          encodeSerializableElement(__desc, 59, Hoisted.defaultValueReferenceSer, __d.value)
        }
        is ElementDefinition.DefaultValue.SampledData -> {
          encodeSerializableElement(__desc, 60, Hoisted.defaultValueSampledDataSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Signature -> {
          encodeSerializableElement(__desc, 61, Hoisted.defaultValueSignatureSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Timing -> {
          encodeSerializableElement(__desc, 62, Hoisted.defaultValueTimingSer, __d.value)
        }
        is ElementDefinition.DefaultValue.ContactDetail -> {
          encodeSerializableElement(__desc, 63, Hoisted.defaultValueContactDetailSer, __d.value)
        }
        is ElementDefinition.DefaultValue.DataRequirement -> {
          encodeSerializableElement(__desc, 64, Hoisted.defaultValueDataRequirementSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Expression -> {
          encodeSerializableElement(__desc, 65, Hoisted.defaultValueExpressionSer, __d.value)
        }
        is ElementDefinition.DefaultValue.ParameterDefinition -> {
          encodeSerializableElement(
            __desc,
            66,
            Hoisted.defaultValueParameterDefinitionSer,
            __d.value,
          )
        }
        is ElementDefinition.DefaultValue.RelatedArtifact -> {
          encodeSerializableElement(__desc, 67, Hoisted.defaultValueRelatedArtifactSer, __d.value)
        }
        is ElementDefinition.DefaultValue.TriggerDefinition -> {
          encodeSerializableElement(__desc, 68, Hoisted.defaultValueTriggerDefinitionSer, __d.value)
        }
        is ElementDefinition.DefaultValue.UsageContext -> {
          encodeSerializableElement(__desc, 69, Hoisted.defaultValueUsageContextSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Availability -> {
          encodeSerializableElement(__desc, 70, Hoisted.defaultValueAvailabilitySer, __d.value)
        }
        is ElementDefinition.DefaultValue.ExtendedContactDetail -> {
          encodeSerializableElement(
            __desc,
            71,
            Hoisted.defaultValueExtendedContactDetailSer,
            __d.value,
          )
        }
        is ElementDefinition.DefaultValue.Dosage -> {
          encodeSerializableElement(__desc, 72, Hoisted.defaultValueDosageSer, __d.value)
        }
        is ElementDefinition.DefaultValue.Meta -> {
          encodeSerializableElement(__desc, 73, Hoisted.defaultValueMetaSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.DefaultValue =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.DefaultValue {
    val __desc = descriptor
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
    var defaultValueDecimal: BigDecimal? = null
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> defaultValueBase64Binary = decoder.decodeStringElement(__desc, 0)
        1 ->
          _defaultValueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> defaultValueBoolean = decoder.decodeBooleanElement(__desc, 2)
        3 ->
          _defaultValueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> defaultValueCanonical = decoder.decodeStringElement(__desc, 4)
        5 ->
          _defaultValueCanonical =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> defaultValueCode = decoder.decodeStringElement(__desc, 6)
        7 ->
          _defaultValueCode =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 -> defaultValueDate = decoder.decodeStringElement(__desc, 8)
        9 ->
          _defaultValueDate =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 -> defaultValueDateTime = decoder.decodeStringElement(__desc, 10)
        11 ->
          _defaultValueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 ->
          defaultValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 12, BigDecimalSerializer, null)
        13 ->
          _defaultValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 -> defaultValueId = decoder.decodeStringElement(__desc, 14)
        15 ->
          _defaultValueId =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.elementSer, null)
        16 -> defaultValueInstant = decoder.decodeStringElement(__desc, 16)
        17 ->
          _defaultValueInstant =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.elementSer, null)
        18 -> defaultValueInteger = decoder.decodeIntElement(__desc, 18)
        19 ->
          _defaultValueInteger =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.elementSer, null)
        20 -> defaultValueInteger64 = decoder.decodeStringElement(__desc, 20)
        21 ->
          _defaultValueInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.elementSer, null)
        22 -> defaultValueMarkdown = decoder.decodeStringElement(__desc, 22)
        23 ->
          _defaultValueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.elementSer, null)
        24 -> defaultValueOid = decoder.decodeStringElement(__desc, 24)
        25 ->
          _defaultValueOid =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.elementSer, null)
        26 -> defaultValuePositiveInt = decoder.decodeIntElement(__desc, 26)
        27 ->
          _defaultValuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.elementSer, null)
        28 -> defaultValueString = decoder.decodeStringElement(__desc, 28)
        29 ->
          _defaultValueString =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.elementSer, null)
        30 ->
          defaultValueTime =
            decoder.decodeNullableSerializableElement(__desc, 30, LocalTimeSerializer, null)
        31 ->
          _defaultValueTime =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.elementSer, null)
        32 -> defaultValueUnsignedInt = decoder.decodeIntElement(__desc, 32)
        33 ->
          _defaultValueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.elementSer, null)
        34 -> defaultValueUri = decoder.decodeStringElement(__desc, 34)
        35 ->
          _defaultValueUri =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.elementSer, null)
        36 -> defaultValueUrl = decoder.decodeStringElement(__desc, 36)
        37 ->
          _defaultValueUrl =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.elementSer, null)
        38 -> defaultValueUuid = decoder.decodeStringElement(__desc, 38)
        39 ->
          _defaultValueUuid =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.elementSer, null)
        40 ->
          defaultValueAddress =
            decoder.decodeNullableSerializableElement(
              __desc,
              40,
              Hoisted.defaultValueAddressSer,
              null,
            )
        41 ->
          defaultValueAge =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.defaultValueAgeSer, null)
        42 ->
          defaultValueAnnotation =
            decoder.decodeNullableSerializableElement(
              __desc,
              42,
              Hoisted.defaultValueAnnotationSer,
              null,
            )
        43 ->
          defaultValueAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              43,
              Hoisted.defaultValueAttachmentSer,
              null,
            )
        44 ->
          defaultValueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              44,
              Hoisted.defaultValueCodeableConceptSer,
              null,
            )
        45 ->
          defaultValueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              45,
              Hoisted.defaultValueCodeableReferenceSer,
              null,
            )
        46 ->
          defaultValueCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              46,
              Hoisted.defaultValueCodingSer,
              null,
            )
        47 ->
          defaultValueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              47,
              Hoisted.defaultValueContactPointSer,
              null,
            )
        48 ->
          defaultValueCount =
            decoder.decodeNullableSerializableElement(
              __desc,
              48,
              Hoisted.defaultValueCountSer,
              null,
            )
        49 ->
          defaultValueDistance =
            decoder.decodeNullableSerializableElement(
              __desc,
              49,
              Hoisted.defaultValueDistanceSer,
              null,
            )
        50 ->
          defaultValueDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              50,
              Hoisted.defaultValueDurationSer,
              null,
            )
        51 ->
          defaultValueHumanName =
            decoder.decodeNullableSerializableElement(
              __desc,
              51,
              Hoisted.defaultValueHumanNameSer,
              null,
            )
        52 ->
          defaultValueIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              52,
              Hoisted.defaultValueIdentifierSer,
              null,
            )
        53 ->
          defaultValueMoney =
            decoder.decodeNullableSerializableElement(
              __desc,
              53,
              Hoisted.defaultValueMoneySer,
              null,
            )
        54 ->
          defaultValuePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              54,
              Hoisted.defaultValuePeriodSer,
              null,
            )
        55 ->
          defaultValueQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              55,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        56 ->
          defaultValueRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              56,
              Hoisted.defaultValueRangeSer,
              null,
            )
        57 ->
          defaultValueRatio =
            decoder.decodeNullableSerializableElement(
              __desc,
              57,
              Hoisted.defaultValueRatioSer,
              null,
            )
        58 ->
          defaultValueRatioRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              58,
              Hoisted.defaultValueRatioRangeSer,
              null,
            )
        59 ->
          defaultValueReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              59,
              Hoisted.defaultValueReferenceSer,
              null,
            )
        60 ->
          defaultValueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              60,
              Hoisted.defaultValueSampledDataSer,
              null,
            )
        61 ->
          defaultValueSignature =
            decoder.decodeNullableSerializableElement(
              __desc,
              61,
              Hoisted.defaultValueSignatureSer,
              null,
            )
        62 ->
          defaultValueTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              62,
              Hoisted.defaultValueTimingSer,
              null,
            )
        63 ->
          defaultValueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              63,
              Hoisted.defaultValueContactDetailSer,
              null,
            )
        64 ->
          defaultValueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              64,
              Hoisted.defaultValueDataRequirementSer,
              null,
            )
        65 ->
          defaultValueExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              65,
              Hoisted.defaultValueExpressionSer,
              null,
            )
        66 ->
          defaultValueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              66,
              Hoisted.defaultValueParameterDefinitionSer,
              null,
            )
        67 ->
          defaultValueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              67,
              Hoisted.defaultValueRelatedArtifactSer,
              null,
            )
        68 ->
          defaultValueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              68,
              Hoisted.defaultValueTriggerDefinitionSer,
              null,
            )
        69 ->
          defaultValueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              69,
              Hoisted.defaultValueUsageContextSer,
              null,
            )
        70 ->
          defaultValueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              70,
              Hoisted.defaultValueAvailabilitySer,
              null,
            )
        71 ->
          defaultValueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              71,
              Hoisted.defaultValueExtendedContactDetailSer,
              null,
            )
        72 ->
          defaultValueDosage =
            decoder.decodeNullableSerializableElement(
              __desc,
              72,
              Hoisted.defaultValueDosageSer,
              null,
            )
        73 ->
          defaultValueMeta =
            decoder.decodeNullableSerializableElement(__desc, 73, Hoisted.defaultValueMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ElementDefinition.DefaultValue: " + __i
          )
      }
    }
    return ElementDefinition.DefaultValue.from(
      Base64Binary.of(defaultValueBase64Binary, _defaultValueBase64Binary),
      R5Boolean.of(defaultValueBoolean, _defaultValueBoolean),
      Canonical.of(defaultValueCanonical, _defaultValueCanonical),
      Code.of(defaultValueCode, _defaultValueCode),
      Date.of(FhirDate.fromString(defaultValueDate), _defaultValueDate),
      DateTime.of(FhirDateTime.fromString(defaultValueDateTime), _defaultValueDateTime),
      Decimal.of(defaultValueDecimal, _defaultValueDecimal),
      Id.of(defaultValueId, _defaultValueId),
      Instant.of(FhirDateTime.fromString(defaultValueInstant), _defaultValueInstant),
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
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val defaultValueAddressSer: KSerializer<Address> = Address.serializer()

    public val defaultValueAgeSer: KSerializer<Age> = Age.serializer()

    public val defaultValueAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val defaultValueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val defaultValueCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val defaultValueCodeableReferenceSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val defaultValueCodingSer: KSerializer<Coding> = Coding.serializer()

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

    public val defaultValueAvailabilitySer: KSerializer<Availability> = Availability.serializer()

    public val defaultValueExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val defaultValueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val defaultValueMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}

internal object ElementDefinitionFixedSerializer : KSerializer<ElementDefinition.Fixed> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ElementDefinition.Fixed") {
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
      element("fixedDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_fixedDecimal", Element.serializer().descriptor, isOptional = true)
      element("fixedId", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedId", Element.serializer().descriptor, isOptional = true)
      element("fixedInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedInstant", Element.serializer().descriptor, isOptional = true)
      element("fixedInteger", Int.serializer().descriptor, isOptional = true)
      element("_fixedInteger", Element.serializer().descriptor, isOptional = true)
      element("fixedInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedInteger64", Element.serializer().descriptor, isOptional = true)
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
      element("fixedAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "fixedExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("fixedDosage", Dosage.serializer().descriptor, isOptional = true)
      element("fixedMeta", Meta.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Fixed) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ElementDefinition.Fixed.Base64Binary -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Code -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 8, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 10, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 12, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Id -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 14, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 15, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Instant -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 16, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 17, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 18, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 19, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Integer64 -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 20, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 21, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Markdown -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 22, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 23, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Oid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 24, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 25, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.PositiveInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 26, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 27, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 28, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 29, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 30, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 31, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.UnsignedInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 32, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 33, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Uri -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 34, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 35, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Url -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 36, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 37, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Uuid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 38, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 39, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Fixed.Address -> {
          encodeSerializableElement(__desc, 40, Hoisted.fixedAddressSer, __d.value)
        }
        is ElementDefinition.Fixed.Age -> {
          encodeSerializableElement(__desc, 41, Hoisted.fixedAgeSer, __d.value)
        }
        is ElementDefinition.Fixed.Annotation -> {
          encodeSerializableElement(__desc, 42, Hoisted.fixedAnnotationSer, __d.value)
        }
        is ElementDefinition.Fixed.Attachment -> {
          encodeSerializableElement(__desc, 43, Hoisted.fixedAttachmentSer, __d.value)
        }
        is ElementDefinition.Fixed.CodeableConcept -> {
          encodeSerializableElement(__desc, 44, Hoisted.fixedCodeableConceptSer, __d.value)
        }
        is ElementDefinition.Fixed.CodeableReference -> {
          encodeSerializableElement(__desc, 45, Hoisted.fixedCodeableReferenceSer, __d.value)
        }
        is ElementDefinition.Fixed.Coding -> {
          encodeSerializableElement(__desc, 46, Hoisted.fixedCodingSer, __d.value)
        }
        is ElementDefinition.Fixed.ContactPoint -> {
          encodeSerializableElement(__desc, 47, Hoisted.fixedContactPointSer, __d.value)
        }
        is ElementDefinition.Fixed.Count -> {
          encodeSerializableElement(__desc, 48, Hoisted.fixedCountSer, __d.value)
        }
        is ElementDefinition.Fixed.Distance -> {
          encodeSerializableElement(__desc, 49, Hoisted.fixedDistanceSer, __d.value)
        }
        is ElementDefinition.Fixed.Duration -> {
          encodeSerializableElement(__desc, 50, Hoisted.fixedDurationSer, __d.value)
        }
        is ElementDefinition.Fixed.HumanName -> {
          encodeSerializableElement(__desc, 51, Hoisted.fixedHumanNameSer, __d.value)
        }
        is ElementDefinition.Fixed.Identifier -> {
          encodeSerializableElement(__desc, 52, Hoisted.fixedIdentifierSer, __d.value)
        }
        is ElementDefinition.Fixed.Money -> {
          encodeSerializableElement(__desc, 53, Hoisted.fixedMoneySer, __d.value)
        }
        is ElementDefinition.Fixed.Period -> {
          encodeSerializableElement(__desc, 54, Hoisted.fixedPeriodSer, __d.value)
        }
        is ElementDefinition.Fixed.Quantity -> {
          encodeSerializableElement(__desc, 55, Hoisted.fixedQuantitySer, __d.value)
        }
        is ElementDefinition.Fixed.Range -> {
          encodeSerializableElement(__desc, 56, Hoisted.fixedRangeSer, __d.value)
        }
        is ElementDefinition.Fixed.Ratio -> {
          encodeSerializableElement(__desc, 57, Hoisted.fixedRatioSer, __d.value)
        }
        is ElementDefinition.Fixed.RatioRange -> {
          encodeSerializableElement(__desc, 58, Hoisted.fixedRatioRangeSer, __d.value)
        }
        is ElementDefinition.Fixed.Reference -> {
          encodeSerializableElement(__desc, 59, Hoisted.fixedReferenceSer, __d.value)
        }
        is ElementDefinition.Fixed.SampledData -> {
          encodeSerializableElement(__desc, 60, Hoisted.fixedSampledDataSer, __d.value)
        }
        is ElementDefinition.Fixed.Signature -> {
          encodeSerializableElement(__desc, 61, Hoisted.fixedSignatureSer, __d.value)
        }
        is ElementDefinition.Fixed.Timing -> {
          encodeSerializableElement(__desc, 62, Hoisted.fixedTimingSer, __d.value)
        }
        is ElementDefinition.Fixed.ContactDetail -> {
          encodeSerializableElement(__desc, 63, Hoisted.fixedContactDetailSer, __d.value)
        }
        is ElementDefinition.Fixed.DataRequirement -> {
          encodeSerializableElement(__desc, 64, Hoisted.fixedDataRequirementSer, __d.value)
        }
        is ElementDefinition.Fixed.Expression -> {
          encodeSerializableElement(__desc, 65, Hoisted.fixedExpressionSer, __d.value)
        }
        is ElementDefinition.Fixed.ParameterDefinition -> {
          encodeSerializableElement(__desc, 66, Hoisted.fixedParameterDefinitionSer, __d.value)
        }
        is ElementDefinition.Fixed.RelatedArtifact -> {
          encodeSerializableElement(__desc, 67, Hoisted.fixedRelatedArtifactSer, __d.value)
        }
        is ElementDefinition.Fixed.TriggerDefinition -> {
          encodeSerializableElement(__desc, 68, Hoisted.fixedTriggerDefinitionSer, __d.value)
        }
        is ElementDefinition.Fixed.UsageContext -> {
          encodeSerializableElement(__desc, 69, Hoisted.fixedUsageContextSer, __d.value)
        }
        is ElementDefinition.Fixed.Availability -> {
          encodeSerializableElement(__desc, 70, Hoisted.fixedAvailabilitySer, __d.value)
        }
        is ElementDefinition.Fixed.ExtendedContactDetail -> {
          encodeSerializableElement(__desc, 71, Hoisted.fixedExtendedContactDetailSer, __d.value)
        }
        is ElementDefinition.Fixed.Dosage -> {
          encodeSerializableElement(__desc, 72, Hoisted.fixedDosageSer, __d.value)
        }
        is ElementDefinition.Fixed.Meta -> {
          encodeSerializableElement(__desc, 73, Hoisted.fixedMetaSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Fixed =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Fixed {
    val __desc = descriptor
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
    var fixedDecimal: BigDecimal? = null
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> fixedBase64Binary = decoder.decodeStringElement(__desc, 0)
        1 ->
          _fixedBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> fixedBoolean = decoder.decodeBooleanElement(__desc, 2)
        3 ->
          _fixedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> fixedCanonical = decoder.decodeStringElement(__desc, 4)
        5 ->
          _fixedCanonical =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> fixedCode = decoder.decodeStringElement(__desc, 6)
        7 ->
          _fixedCode =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 -> fixedDate = decoder.decodeStringElement(__desc, 8)
        9 ->
          _fixedDate =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 -> fixedDateTime = decoder.decodeStringElement(__desc, 10)
        11 ->
          _fixedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 ->
          fixedDecimal =
            decoder.decodeNullableSerializableElement(__desc, 12, BigDecimalSerializer, null)
        13 ->
          _fixedDecimal =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 -> fixedId = decoder.decodeStringElement(__desc, 14)
        15 ->
          _fixedId = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.elementSer, null)
        16 -> fixedInstant = decoder.decodeStringElement(__desc, 16)
        17 ->
          _fixedInstant =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.elementSer, null)
        18 -> fixedInteger = decoder.decodeIntElement(__desc, 18)
        19 ->
          _fixedInteger =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.elementSer, null)
        20 -> fixedInteger64 = decoder.decodeStringElement(__desc, 20)
        21 ->
          _fixedInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.elementSer, null)
        22 -> fixedMarkdown = decoder.decodeStringElement(__desc, 22)
        23 ->
          _fixedMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.elementSer, null)
        24 -> fixedOid = decoder.decodeStringElement(__desc, 24)
        25 ->
          _fixedOid =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.elementSer, null)
        26 -> fixedPositiveInt = decoder.decodeIntElement(__desc, 26)
        27 ->
          _fixedPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.elementSer, null)
        28 -> fixedString = decoder.decodeStringElement(__desc, 28)
        29 ->
          _fixedString =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.elementSer, null)
        30 ->
          fixedTime =
            decoder.decodeNullableSerializableElement(__desc, 30, LocalTimeSerializer, null)
        31 ->
          _fixedTime =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.elementSer, null)
        32 -> fixedUnsignedInt = decoder.decodeIntElement(__desc, 32)
        33 ->
          _fixedUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.elementSer, null)
        34 -> fixedUri = decoder.decodeStringElement(__desc, 34)
        35 ->
          _fixedUri =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.elementSer, null)
        36 -> fixedUrl = decoder.decodeStringElement(__desc, 36)
        37 ->
          _fixedUrl =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.elementSer, null)
        38 -> fixedUuid = decoder.decodeStringElement(__desc, 38)
        39 ->
          _fixedUuid =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.elementSer, null)
        40 ->
          fixedAddress =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.fixedAddressSer, null)
        41 ->
          fixedAge =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.fixedAgeSer, null)
        42 ->
          fixedAnnotation =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.fixedAnnotationSer, null)
        43 ->
          fixedAttachment =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.fixedAttachmentSer, null)
        44 ->
          fixedCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              44,
              Hoisted.fixedCodeableConceptSer,
              null,
            )
        45 ->
          fixedCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              45,
              Hoisted.fixedCodeableReferenceSer,
              null,
            )
        46 ->
          fixedCoding =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.fixedCodingSer, null)
        47 ->
          fixedContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              47,
              Hoisted.fixedContactPointSer,
              null,
            )
        48 ->
          fixedCount =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.fixedCountSer, null)
        49 ->
          fixedDistance =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.fixedDistanceSer, null)
        50 ->
          fixedDuration =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.fixedDurationSer, null)
        51 ->
          fixedHumanName =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.fixedHumanNameSer, null)
        52 ->
          fixedIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.fixedIdentifierSer, null)
        53 ->
          fixedMoney =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.fixedMoneySer, null)
        54 ->
          fixedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.fixedPeriodSer, null)
        55 ->
          fixedQuantity =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.fixedQuantitySer, null)
        56 ->
          fixedRange =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.fixedRangeSer, null)
        57 ->
          fixedRatio =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.fixedRatioSer, null)
        58 ->
          fixedRatioRange =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.fixedRatioRangeSer, null)
        59 ->
          fixedReference =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.fixedReferenceSer, null)
        60 ->
          fixedSampledData =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.fixedSampledDataSer, null)
        61 ->
          fixedSignature =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.fixedSignatureSer, null)
        62 ->
          fixedTiming =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.fixedTimingSer, null)
        63 ->
          fixedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              63,
              Hoisted.fixedContactDetailSer,
              null,
            )
        64 ->
          fixedDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              64,
              Hoisted.fixedDataRequirementSer,
              null,
            )
        65 ->
          fixedExpression =
            decoder.decodeNullableSerializableElement(__desc, 65, Hoisted.fixedExpressionSer, null)
        66 ->
          fixedParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              66,
              Hoisted.fixedParameterDefinitionSer,
              null,
            )
        67 ->
          fixedRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              67,
              Hoisted.fixedRelatedArtifactSer,
              null,
            )
        68 ->
          fixedTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              68,
              Hoisted.fixedTriggerDefinitionSer,
              null,
            )
        69 ->
          fixedUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              69,
              Hoisted.fixedUsageContextSer,
              null,
            )
        70 ->
          fixedAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              70,
              Hoisted.fixedAvailabilitySer,
              null,
            )
        71 ->
          fixedExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              71,
              Hoisted.fixedExtendedContactDetailSer,
              null,
            )
        72 ->
          fixedDosage =
            decoder.decodeNullableSerializableElement(__desc, 72, Hoisted.fixedDosageSer, null)
        73 ->
          fixedMeta =
            decoder.decodeNullableSerializableElement(__desc, 73, Hoisted.fixedMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ElementDefinition.Fixed: " + __i)
      }
    }
    return ElementDefinition.Fixed.from(
      Base64Binary.of(fixedBase64Binary, _fixedBase64Binary),
      R5Boolean.of(fixedBoolean, _fixedBoolean),
      Canonical.of(fixedCanonical, _fixedCanonical),
      Code.of(fixedCode, _fixedCode),
      Date.of(FhirDate.fromString(fixedDate), _fixedDate),
      DateTime.of(FhirDateTime.fromString(fixedDateTime), _fixedDateTime),
      Decimal.of(fixedDecimal, _fixedDecimal),
      Id.of(fixedId, _fixedId),
      Instant.of(FhirDateTime.fromString(fixedInstant), _fixedInstant),
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
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val fixedAddressSer: KSerializer<Address> = Address.serializer()

    public val fixedAgeSer: KSerializer<Age> = Age.serializer()

    public val fixedAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val fixedAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val fixedCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val fixedCodeableReferenceSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val fixedCodingSer: KSerializer<Coding> = Coding.serializer()

    public val fixedContactPointSer: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val fixedCountSer: KSerializer<Count> = Count.serializer()

    public val fixedDistanceSer: KSerializer<Distance> = Distance.serializer()

    public val fixedDurationSer: KSerializer<Duration> = Duration.serializer()

    public val fixedHumanNameSer: KSerializer<HumanName> = HumanName.serializer()

    public val fixedIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val fixedMoneySer: KSerializer<Money> = Money.serializer()

    public val fixedPeriodSer: KSerializer<Period> = Period.serializer()

    public val fixedQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val fixedRangeSer: KSerializer<Range> = Range.serializer()

    public val fixedRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val fixedRatioRangeSer: KSerializer<RatioRange> = RatioRange.serializer()

    public val fixedReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val fixedSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val fixedSignatureSer: KSerializer<Signature> = Signature.serializer()

    public val fixedTimingSer: KSerializer<Timing> = Timing.serializer()

    public val fixedContactDetailSer: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val fixedDataRequirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val fixedExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val fixedParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val fixedRelatedArtifactSer: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val fixedTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val fixedUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val fixedAvailabilitySer: KSerializer<Availability> = Availability.serializer()

    public val fixedExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val fixedDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val fixedMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}

internal object ElementDefinitionPatternSerializer : KSerializer<ElementDefinition.Pattern> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ElementDefinition.Pattern") {
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
      element("patternDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_patternDecimal", Element.serializer().descriptor, isOptional = true)
      element("patternId", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternId", Element.serializer().descriptor, isOptional = true)
      element("patternInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternInstant", Element.serializer().descriptor, isOptional = true)
      element("patternInteger", Int.serializer().descriptor, isOptional = true)
      element("_patternInteger", Element.serializer().descriptor, isOptional = true)
      element("patternInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternInteger64", Element.serializer().descriptor, isOptional = true)
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
      element("patternAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "patternExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("patternDosage", Dosage.serializer().descriptor, isOptional = true)
      element("patternMeta", Meta.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Pattern) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ElementDefinition.Pattern.Base64Binary -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Code -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 8, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 10, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 12, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Id -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 14, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 15, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Instant -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 16, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 17, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 18, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 19, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Integer64 -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 20, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 21, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Markdown -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 22, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 23, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Oid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 24, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 25, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.PositiveInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 26, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 27, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 28, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 29, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 30, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 31, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.UnsignedInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 32, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 33, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Uri -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 34, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 35, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Url -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 36, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 37, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Uuid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 38, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 39, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Pattern.Address -> {
          encodeSerializableElement(__desc, 40, Hoisted.patternAddressSer, __d.value)
        }
        is ElementDefinition.Pattern.Age -> {
          encodeSerializableElement(__desc, 41, Hoisted.patternAgeSer, __d.value)
        }
        is ElementDefinition.Pattern.Annotation -> {
          encodeSerializableElement(__desc, 42, Hoisted.patternAnnotationSer, __d.value)
        }
        is ElementDefinition.Pattern.Attachment -> {
          encodeSerializableElement(__desc, 43, Hoisted.patternAttachmentSer, __d.value)
        }
        is ElementDefinition.Pattern.CodeableConcept -> {
          encodeSerializableElement(__desc, 44, Hoisted.patternCodeableConceptSer, __d.value)
        }
        is ElementDefinition.Pattern.CodeableReference -> {
          encodeSerializableElement(__desc, 45, Hoisted.patternCodeableReferenceSer, __d.value)
        }
        is ElementDefinition.Pattern.Coding -> {
          encodeSerializableElement(__desc, 46, Hoisted.patternCodingSer, __d.value)
        }
        is ElementDefinition.Pattern.ContactPoint -> {
          encodeSerializableElement(__desc, 47, Hoisted.patternContactPointSer, __d.value)
        }
        is ElementDefinition.Pattern.Count -> {
          encodeSerializableElement(__desc, 48, Hoisted.patternCountSer, __d.value)
        }
        is ElementDefinition.Pattern.Distance -> {
          encodeSerializableElement(__desc, 49, Hoisted.patternDistanceSer, __d.value)
        }
        is ElementDefinition.Pattern.Duration -> {
          encodeSerializableElement(__desc, 50, Hoisted.patternDurationSer, __d.value)
        }
        is ElementDefinition.Pattern.HumanName -> {
          encodeSerializableElement(__desc, 51, Hoisted.patternHumanNameSer, __d.value)
        }
        is ElementDefinition.Pattern.Identifier -> {
          encodeSerializableElement(__desc, 52, Hoisted.patternIdentifierSer, __d.value)
        }
        is ElementDefinition.Pattern.Money -> {
          encodeSerializableElement(__desc, 53, Hoisted.patternMoneySer, __d.value)
        }
        is ElementDefinition.Pattern.Period -> {
          encodeSerializableElement(__desc, 54, Hoisted.patternPeriodSer, __d.value)
        }
        is ElementDefinition.Pattern.Quantity -> {
          encodeSerializableElement(__desc, 55, Hoisted.patternQuantitySer, __d.value)
        }
        is ElementDefinition.Pattern.Range -> {
          encodeSerializableElement(__desc, 56, Hoisted.patternRangeSer, __d.value)
        }
        is ElementDefinition.Pattern.Ratio -> {
          encodeSerializableElement(__desc, 57, Hoisted.patternRatioSer, __d.value)
        }
        is ElementDefinition.Pattern.RatioRange -> {
          encodeSerializableElement(__desc, 58, Hoisted.patternRatioRangeSer, __d.value)
        }
        is ElementDefinition.Pattern.Reference -> {
          encodeSerializableElement(__desc, 59, Hoisted.patternReferenceSer, __d.value)
        }
        is ElementDefinition.Pattern.SampledData -> {
          encodeSerializableElement(__desc, 60, Hoisted.patternSampledDataSer, __d.value)
        }
        is ElementDefinition.Pattern.Signature -> {
          encodeSerializableElement(__desc, 61, Hoisted.patternSignatureSer, __d.value)
        }
        is ElementDefinition.Pattern.Timing -> {
          encodeSerializableElement(__desc, 62, Hoisted.patternTimingSer, __d.value)
        }
        is ElementDefinition.Pattern.ContactDetail -> {
          encodeSerializableElement(__desc, 63, Hoisted.patternContactDetailSer, __d.value)
        }
        is ElementDefinition.Pattern.DataRequirement -> {
          encodeSerializableElement(__desc, 64, Hoisted.patternDataRequirementSer, __d.value)
        }
        is ElementDefinition.Pattern.Expression -> {
          encodeSerializableElement(__desc, 65, Hoisted.patternExpressionSer, __d.value)
        }
        is ElementDefinition.Pattern.ParameterDefinition -> {
          encodeSerializableElement(__desc, 66, Hoisted.patternParameterDefinitionSer, __d.value)
        }
        is ElementDefinition.Pattern.RelatedArtifact -> {
          encodeSerializableElement(__desc, 67, Hoisted.patternRelatedArtifactSer, __d.value)
        }
        is ElementDefinition.Pattern.TriggerDefinition -> {
          encodeSerializableElement(__desc, 68, Hoisted.patternTriggerDefinitionSer, __d.value)
        }
        is ElementDefinition.Pattern.UsageContext -> {
          encodeSerializableElement(__desc, 69, Hoisted.patternUsageContextSer, __d.value)
        }
        is ElementDefinition.Pattern.Availability -> {
          encodeSerializableElement(__desc, 70, Hoisted.patternAvailabilitySer, __d.value)
        }
        is ElementDefinition.Pattern.ExtendedContactDetail -> {
          encodeSerializableElement(__desc, 71, Hoisted.patternExtendedContactDetailSer, __d.value)
        }
        is ElementDefinition.Pattern.Dosage -> {
          encodeSerializableElement(__desc, 72, Hoisted.patternDosageSer, __d.value)
        }
        is ElementDefinition.Pattern.Meta -> {
          encodeSerializableElement(__desc, 73, Hoisted.patternMetaSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Pattern =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Pattern {
    val __desc = descriptor
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
    var patternDecimal: BigDecimal? = null
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> patternBase64Binary = decoder.decodeStringElement(__desc, 0)
        1 ->
          _patternBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> patternBoolean = decoder.decodeBooleanElement(__desc, 2)
        3 ->
          _patternBoolean =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> patternCanonical = decoder.decodeStringElement(__desc, 4)
        5 ->
          _patternCanonical =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> patternCode = decoder.decodeStringElement(__desc, 6)
        7 ->
          _patternCode =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 -> patternDate = decoder.decodeStringElement(__desc, 8)
        9 ->
          _patternDate =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 -> patternDateTime = decoder.decodeStringElement(__desc, 10)
        11 ->
          _patternDateTime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 ->
          patternDecimal =
            decoder.decodeNullableSerializableElement(__desc, 12, BigDecimalSerializer, null)
        13 ->
          _patternDecimal =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 -> patternId = decoder.decodeStringElement(__desc, 14)
        15 ->
          _patternId =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.elementSer, null)
        16 -> patternInstant = decoder.decodeStringElement(__desc, 16)
        17 ->
          _patternInstant =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.elementSer, null)
        18 -> patternInteger = decoder.decodeIntElement(__desc, 18)
        19 ->
          _patternInteger =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.elementSer, null)
        20 -> patternInteger64 = decoder.decodeStringElement(__desc, 20)
        21 ->
          _patternInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.elementSer, null)
        22 -> patternMarkdown = decoder.decodeStringElement(__desc, 22)
        23 ->
          _patternMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.elementSer, null)
        24 -> patternOid = decoder.decodeStringElement(__desc, 24)
        25 ->
          _patternOid =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.elementSer, null)
        26 -> patternPositiveInt = decoder.decodeIntElement(__desc, 26)
        27 ->
          _patternPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.elementSer, null)
        28 -> patternString = decoder.decodeStringElement(__desc, 28)
        29 ->
          _patternString =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.elementSer, null)
        30 ->
          patternTime =
            decoder.decodeNullableSerializableElement(__desc, 30, LocalTimeSerializer, null)
        31 ->
          _patternTime =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.elementSer, null)
        32 -> patternUnsignedInt = decoder.decodeIntElement(__desc, 32)
        33 ->
          _patternUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.elementSer, null)
        34 -> patternUri = decoder.decodeStringElement(__desc, 34)
        35 ->
          _patternUri =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.elementSer, null)
        36 -> patternUrl = decoder.decodeStringElement(__desc, 36)
        37 ->
          _patternUrl =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.elementSer, null)
        38 -> patternUuid = decoder.decodeStringElement(__desc, 38)
        39 ->
          _patternUuid =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.elementSer, null)
        40 ->
          patternAddress =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.patternAddressSer, null)
        41 ->
          patternAge =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.patternAgeSer, null)
        42 ->
          patternAnnotation =
            decoder.decodeNullableSerializableElement(
              __desc,
              42,
              Hoisted.patternAnnotationSer,
              null,
            )
        43 ->
          patternAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              43,
              Hoisted.patternAttachmentSer,
              null,
            )
        44 ->
          patternCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              44,
              Hoisted.patternCodeableConceptSer,
              null,
            )
        45 ->
          patternCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              45,
              Hoisted.patternCodeableReferenceSer,
              null,
            )
        46 ->
          patternCoding =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.patternCodingSer, null)
        47 ->
          patternContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              47,
              Hoisted.patternContactPointSer,
              null,
            )
        48 ->
          patternCount =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.patternCountSer, null)
        49 ->
          patternDistance =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.patternDistanceSer, null)
        50 ->
          patternDuration =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.patternDurationSer, null)
        51 ->
          patternHumanName =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.patternHumanNameSer, null)
        52 ->
          patternIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              52,
              Hoisted.patternIdentifierSer,
              null,
            )
        53 ->
          patternMoney =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.patternMoneySer, null)
        54 ->
          patternPeriod =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.patternPeriodSer, null)
        55 ->
          patternQuantity =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.patternQuantitySer, null)
        56 ->
          patternRange =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.patternRangeSer, null)
        57 ->
          patternRatio =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.patternRatioSer, null)
        58 ->
          patternRatioRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              58,
              Hoisted.patternRatioRangeSer,
              null,
            )
        59 ->
          patternReference =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.patternReferenceSer, null)
        60 ->
          patternSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              60,
              Hoisted.patternSampledDataSer,
              null,
            )
        61 ->
          patternSignature =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.patternSignatureSer, null)
        62 ->
          patternTiming =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.patternTimingSer, null)
        63 ->
          patternContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              63,
              Hoisted.patternContactDetailSer,
              null,
            )
        64 ->
          patternDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              64,
              Hoisted.patternDataRequirementSer,
              null,
            )
        65 ->
          patternExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              65,
              Hoisted.patternExpressionSer,
              null,
            )
        66 ->
          patternParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              66,
              Hoisted.patternParameterDefinitionSer,
              null,
            )
        67 ->
          patternRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              67,
              Hoisted.patternRelatedArtifactSer,
              null,
            )
        68 ->
          patternTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              68,
              Hoisted.patternTriggerDefinitionSer,
              null,
            )
        69 ->
          patternUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              69,
              Hoisted.patternUsageContextSer,
              null,
            )
        70 ->
          patternAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              70,
              Hoisted.patternAvailabilitySer,
              null,
            )
        71 ->
          patternExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              71,
              Hoisted.patternExtendedContactDetailSer,
              null,
            )
        72 ->
          patternDosage =
            decoder.decodeNullableSerializableElement(__desc, 72, Hoisted.patternDosageSer, null)
        73 ->
          patternMeta =
            decoder.decodeNullableSerializableElement(__desc, 73, Hoisted.patternMetaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ElementDefinition.Pattern: " + __i
          )
      }
    }
    return ElementDefinition.Pattern.from(
      Base64Binary.of(patternBase64Binary, _patternBase64Binary),
      R5Boolean.of(patternBoolean, _patternBoolean),
      Canonical.of(patternCanonical, _patternCanonical),
      Code.of(patternCode, _patternCode),
      Date.of(FhirDate.fromString(patternDate), _patternDate),
      DateTime.of(FhirDateTime.fromString(patternDateTime), _patternDateTime),
      Decimal.of(patternDecimal, _patternDecimal),
      Id.of(patternId, _patternId),
      Instant.of(FhirDateTime.fromString(patternInstant), _patternInstant),
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
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val patternAddressSer: KSerializer<Address> = Address.serializer()

    public val patternAgeSer: KSerializer<Age> = Age.serializer()

    public val patternAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val patternAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val patternCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val patternCodeableReferenceSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val patternCodingSer: KSerializer<Coding> = Coding.serializer()

    public val patternContactPointSer: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val patternCountSer: KSerializer<Count> = Count.serializer()

    public val patternDistanceSer: KSerializer<Distance> = Distance.serializer()

    public val patternDurationSer: KSerializer<Duration> = Duration.serializer()

    public val patternHumanNameSer: KSerializer<HumanName> = HumanName.serializer()

    public val patternIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val patternMoneySer: KSerializer<Money> = Money.serializer()

    public val patternPeriodSer: KSerializer<Period> = Period.serializer()

    public val patternQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val patternRangeSer: KSerializer<Range> = Range.serializer()

    public val patternRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val patternRatioRangeSer: KSerializer<RatioRange> = RatioRange.serializer()

    public val patternReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val patternSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val patternSignatureSer: KSerializer<Signature> = Signature.serializer()

    public val patternTimingSer: KSerializer<Timing> = Timing.serializer()

    public val patternContactDetailSer: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val patternDataRequirementSer: KSerializer<DataRequirement> =
      DataRequirement.serializer()

    public val patternExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val patternParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val patternRelatedArtifactSer: KSerializer<RelatedArtifact> =
      RelatedArtifact.serializer()

    public val patternTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val patternUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val patternAvailabilitySer: KSerializer<Availability> = Availability.serializer()

    public val patternExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val patternDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val patternMetaSer: KSerializer<Meta> = Meta.serializer()
  }
}

internal object ElementDefinitionExampleValueSerializer :
  KSerializer<ElementDefinition.Example.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ElementDefinition.Example.Value") {
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
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Example.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ElementDefinition.Example.Value.Base64Binary -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Code -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 8, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 10, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 12, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Id -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 14, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 15, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Instant -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 16, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 17, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 18, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 19, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Integer64 -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 20, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 21, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Markdown -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 22, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 23, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Oid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 24, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 25, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.PositiveInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 26, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 27, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 28, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 29, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 30, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 31, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.UnsignedInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 32, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 33, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Uri -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 34, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 35, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Url -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 36, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 37, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Uuid -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 38, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 39, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.Example.Value.Address -> {
          encodeSerializableElement(__desc, 40, Hoisted.valueAddressSer, __d.value)
        }
        is ElementDefinition.Example.Value.Age -> {
          encodeSerializableElement(__desc, 41, Hoisted.valueAgeSer, __d.value)
        }
        is ElementDefinition.Example.Value.Annotation -> {
          encodeSerializableElement(__desc, 42, Hoisted.valueAnnotationSer, __d.value)
        }
        is ElementDefinition.Example.Value.Attachment -> {
          encodeSerializableElement(__desc, 43, Hoisted.valueAttachmentSer, __d.value)
        }
        is ElementDefinition.Example.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 44, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is ElementDefinition.Example.Value.CodeableReference -> {
          encodeSerializableElement(__desc, 45, Hoisted.valueCodeableReferenceSer, __d.value)
        }
        is ElementDefinition.Example.Value.Coding -> {
          encodeSerializableElement(__desc, 46, Hoisted.valueCodingSer, __d.value)
        }
        is ElementDefinition.Example.Value.ContactPoint -> {
          encodeSerializableElement(__desc, 47, Hoisted.valueContactPointSer, __d.value)
        }
        is ElementDefinition.Example.Value.Count -> {
          encodeSerializableElement(__desc, 48, Hoisted.valueCountSer, __d.value)
        }
        is ElementDefinition.Example.Value.Distance -> {
          encodeSerializableElement(__desc, 49, Hoisted.valueDistanceSer, __d.value)
        }
        is ElementDefinition.Example.Value.Duration -> {
          encodeSerializableElement(__desc, 50, Hoisted.valueDurationSer, __d.value)
        }
        is ElementDefinition.Example.Value.HumanName -> {
          encodeSerializableElement(__desc, 51, Hoisted.valueHumanNameSer, __d.value)
        }
        is ElementDefinition.Example.Value.Identifier -> {
          encodeSerializableElement(__desc, 52, Hoisted.valueIdentifierSer, __d.value)
        }
        is ElementDefinition.Example.Value.Money -> {
          encodeSerializableElement(__desc, 53, Hoisted.valueMoneySer, __d.value)
        }
        is ElementDefinition.Example.Value.Period -> {
          encodeSerializableElement(__desc, 54, Hoisted.valuePeriodSer, __d.value)
        }
        is ElementDefinition.Example.Value.Quantity -> {
          encodeSerializableElement(__desc, 55, Hoisted.valueQuantitySer, __d.value)
        }
        is ElementDefinition.Example.Value.Range -> {
          encodeSerializableElement(__desc, 56, Hoisted.valueRangeSer, __d.value)
        }
        is ElementDefinition.Example.Value.Ratio -> {
          encodeSerializableElement(__desc, 57, Hoisted.valueRatioSer, __d.value)
        }
        is ElementDefinition.Example.Value.RatioRange -> {
          encodeSerializableElement(__desc, 58, Hoisted.valueRatioRangeSer, __d.value)
        }
        is ElementDefinition.Example.Value.Reference -> {
          encodeSerializableElement(__desc, 59, Hoisted.valueReferenceSer, __d.value)
        }
        is ElementDefinition.Example.Value.SampledData -> {
          encodeSerializableElement(__desc, 60, Hoisted.valueSampledDataSer, __d.value)
        }
        is ElementDefinition.Example.Value.Signature -> {
          encodeSerializableElement(__desc, 61, Hoisted.valueSignatureSer, __d.value)
        }
        is ElementDefinition.Example.Value.Timing -> {
          encodeSerializableElement(__desc, 62, Hoisted.valueTimingSer, __d.value)
        }
        is ElementDefinition.Example.Value.ContactDetail -> {
          encodeSerializableElement(__desc, 63, Hoisted.valueContactDetailSer, __d.value)
        }
        is ElementDefinition.Example.Value.DataRequirement -> {
          encodeSerializableElement(__desc, 64, Hoisted.valueDataRequirementSer, __d.value)
        }
        is ElementDefinition.Example.Value.Expression -> {
          encodeSerializableElement(__desc, 65, Hoisted.valueExpressionSer, __d.value)
        }
        is ElementDefinition.Example.Value.ParameterDefinition -> {
          encodeSerializableElement(__desc, 66, Hoisted.valueParameterDefinitionSer, __d.value)
        }
        is ElementDefinition.Example.Value.RelatedArtifact -> {
          encodeSerializableElement(__desc, 67, Hoisted.valueRelatedArtifactSer, __d.value)
        }
        is ElementDefinition.Example.Value.TriggerDefinition -> {
          encodeSerializableElement(__desc, 68, Hoisted.valueTriggerDefinitionSer, __d.value)
        }
        is ElementDefinition.Example.Value.UsageContext -> {
          encodeSerializableElement(__desc, 69, Hoisted.valueUsageContextSer, __d.value)
        }
        is ElementDefinition.Example.Value.Availability -> {
          encodeSerializableElement(__desc, 70, Hoisted.valueAvailabilitySer, __d.value)
        }
        is ElementDefinition.Example.Value.ExtendedContactDetail -> {
          encodeSerializableElement(__desc, 71, Hoisted.valueExtendedContactDetailSer, __d.value)
        }
        is ElementDefinition.Example.Value.Dosage -> {
          encodeSerializableElement(__desc, 72, Hoisted.valueDosageSer, __d.value)
        }
        is ElementDefinition.Example.Value.Meta -> {
          encodeSerializableElement(__desc, 73, Hoisted.valueMetaSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Example.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.Example.Value {
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
        else ->
          throw SerializationException(
            "Unexpected index decoding ElementDefinition.Example.Value: " + __i
          )
      }
    }
    return ElementDefinition.Example.Value.from(
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

internal object ElementDefinitionMinValueSerializer : KSerializer<ElementDefinition.MinValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ElementDefinition.MinValue") {
      element("minValueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_minValueDate", Element.serializer().descriptor, isOptional = true)
      element("minValueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_minValueDateTime", Element.serializer().descriptor, isOptional = true)
      element("minValueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_minValueInstant", Element.serializer().descriptor, isOptional = true)
      element("minValueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_minValueTime", Element.serializer().descriptor, isOptional = true)
      element("minValueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_minValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("minValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_minValueInteger", Element.serializer().descriptor, isOptional = true)
      element("minValueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_minValueInteger64", Element.serializer().descriptor, isOptional = true)
      element("minValuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_minValuePositiveInt", Element.serializer().descriptor, isOptional = true)
      element("minValueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_minValueUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("minValueQuantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.MinValue) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ElementDefinition.MinValue.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.Instant -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.Time -> {
          ((__d.value.value))?.let { encodeSerializableElement(__desc, 6, LocalTimeSerializer, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 8, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 10, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.Integer64 -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 12, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.PositiveInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 14, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 15, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.UnsignedInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 16, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 17, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MinValue.Quantity -> {
          encodeSerializableElement(__desc, 18, Hoisted.minValueQuantitySer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.MinValue =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.MinValue {
    val __desc = descriptor
    var minValueDate: KotlinString? = null
    var _minValueDate: Element? = null
    var minValueDateTime: KotlinString? = null
    var _minValueDateTime: Element? = null
    var minValueInstant: KotlinString? = null
    var _minValueInstant: Element? = null
    var minValueTime: LocalTime? = null
    var _minValueTime: Element? = null
    var minValueDecimal: BigDecimal? = null
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> minValueDate = decoder.decodeStringElement(__desc, 0)
        1 ->
          _minValueDate =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> minValueDateTime = decoder.decodeStringElement(__desc, 2)
        3 ->
          _minValueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> minValueInstant = decoder.decodeStringElement(__desc, 4)
        5 ->
          _minValueInstant =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 ->
          minValueTime =
            decoder.decodeNullableSerializableElement(__desc, 6, LocalTimeSerializer, null)
        7 ->
          _minValueTime =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 ->
          minValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 8, BigDecimalSerializer, null)
        9 ->
          _minValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 -> minValueInteger = decoder.decodeIntElement(__desc, 10)
        11 ->
          _minValueInteger =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 -> minValueInteger64 = decoder.decodeStringElement(__desc, 12)
        13 ->
          _minValueInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 -> minValuePositiveInt = decoder.decodeIntElement(__desc, 14)
        15 ->
          _minValuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.elementSer, null)
        16 -> minValueUnsignedInt = decoder.decodeIntElement(__desc, 16)
        17 ->
          _minValueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.elementSer, null)
        18 ->
          minValueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.minValueQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ElementDefinition.MinValue: " + __i
          )
      }
    }
    return ElementDefinition.MinValue.from(
      Date.of(FhirDate.fromString(minValueDate), _minValueDate),
      DateTime.of(FhirDateTime.fromString(minValueDateTime), _minValueDateTime),
      Instant.of(FhirDateTime.fromString(minValueInstant), _minValueInstant),
      Time.of(minValueTime, _minValueTime),
      Decimal.of(minValueDecimal, _minValueDecimal),
      Integer.of(minValueInteger, _minValueInteger),
      Integer64.of(minValueInteger64?.toLong(), _minValueInteger64),
      PositiveInt.of(minValuePositiveInt, _minValuePositiveInt),
      UnsignedInt.of(minValueUnsignedInt, _minValueUnsignedInt),
      minValueQuantity,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val minValueQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object ElementDefinitionMaxValueSerializer : KSerializer<ElementDefinition.MaxValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ElementDefinition.MaxValue") {
      element("maxValueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_maxValueDate", Element.serializer().descriptor, isOptional = true)
      element("maxValueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_maxValueDateTime", Element.serializer().descriptor, isOptional = true)
      element("maxValueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_maxValueInstant", Element.serializer().descriptor, isOptional = true)
      element("maxValueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_maxValueTime", Element.serializer().descriptor, isOptional = true)
      element("maxValueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_maxValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("maxValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_maxValueInteger", Element.serializer().descriptor, isOptional = true)
      element("maxValueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_maxValueInteger64", Element.serializer().descriptor, isOptional = true)
      element("maxValuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_maxValuePositiveInt", Element.serializer().descriptor, isOptional = true)
      element("maxValueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_maxValueUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("maxValueQuantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.MaxValue) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ElementDefinition.MaxValue.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.Instant -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.Time -> {
          ((__d.value.value))?.let { encodeSerializableElement(__desc, 6, LocalTimeSerializer, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 8, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 10, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.Integer64 -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 12, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.PositiveInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 14, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 15, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.UnsignedInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 16, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 17, Hoisted.elementSer, it)
          }
        }
        is ElementDefinition.MaxValue.Quantity -> {
          encodeSerializableElement(__desc, 18, Hoisted.maxValueQuantitySer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.MaxValue =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ElementDefinition.MaxValue {
    val __desc = descriptor
    var maxValueDate: KotlinString? = null
    var _maxValueDate: Element? = null
    var maxValueDateTime: KotlinString? = null
    var _maxValueDateTime: Element? = null
    var maxValueInstant: KotlinString? = null
    var _maxValueInstant: Element? = null
    var maxValueTime: LocalTime? = null
    var _maxValueTime: Element? = null
    var maxValueDecimal: BigDecimal? = null
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> maxValueDate = decoder.decodeStringElement(__desc, 0)
        1 ->
          _maxValueDate =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> maxValueDateTime = decoder.decodeStringElement(__desc, 2)
        3 ->
          _maxValueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> maxValueInstant = decoder.decodeStringElement(__desc, 4)
        5 ->
          _maxValueInstant =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 ->
          maxValueTime =
            decoder.decodeNullableSerializableElement(__desc, 6, LocalTimeSerializer, null)
        7 ->
          _maxValueTime =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 ->
          maxValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 8, BigDecimalSerializer, null)
        9 ->
          _maxValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 -> maxValueInteger = decoder.decodeIntElement(__desc, 10)
        11 ->
          _maxValueInteger =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 -> maxValueInteger64 = decoder.decodeStringElement(__desc, 12)
        13 ->
          _maxValueInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 -> maxValuePositiveInt = decoder.decodeIntElement(__desc, 14)
        15 ->
          _maxValuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.elementSer, null)
        16 -> maxValueUnsignedInt = decoder.decodeIntElement(__desc, 16)
        17 ->
          _maxValueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.elementSer, null)
        18 ->
          maxValueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.maxValueQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ElementDefinition.MaxValue: " + __i
          )
      }
    }
    return ElementDefinition.MaxValue.from(
      Date.of(FhirDate.fromString(maxValueDate), _maxValueDate),
      DateTime.of(FhirDateTime.fromString(maxValueDateTime), _maxValueDateTime),
      Instant.of(FhirDateTime.fromString(maxValueInstant), _maxValueInstant),
      Time.of(maxValueTime, _maxValueTime),
      Decimal.of(maxValueDecimal, _maxValueDecimal),
      Integer.of(maxValueInteger, _maxValueInteger),
      Integer64.of(maxValueInteger64?.toLong(), _maxValueInteger64),
      PositiveInt.of(maxValuePositiveInt, _maxValuePositiveInt),
      UnsignedInt.of(maxValueUnsignedInt, _maxValueUnsignedInt),
      maxValueQuantity,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val maxValueQuantitySer: KSerializer<Quantity> = Quantity.serializer()
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
      element("defaultValueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_defaultValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("defaultValueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueId", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueInstant", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_defaultValueInteger", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueInteger64", Element.serializer().descriptor, isOptional = true)
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
      element("defaultValueAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "defaultValueExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("defaultValueDosage", Dosage.serializer().descriptor, isOptional = true)
      element("defaultValueMeta", Meta.serializer().descriptor, isOptional = true)
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
      element("fixedDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_fixedDecimal", Element.serializer().descriptor, isOptional = true)
      element("fixedId", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedId", Element.serializer().descriptor, isOptional = true)
      element("fixedInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedInstant", Element.serializer().descriptor, isOptional = true)
      element("fixedInteger", Int.serializer().descriptor, isOptional = true)
      element("_fixedInteger", Element.serializer().descriptor, isOptional = true)
      element("fixedInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_fixedInteger64", Element.serializer().descriptor, isOptional = true)
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
      element("fixedAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "fixedExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("fixedDosage", Dosage.serializer().descriptor, isOptional = true)
      element("fixedMeta", Meta.serializer().descriptor, isOptional = true)
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
      element("patternDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_patternDecimal", Element.serializer().descriptor, isOptional = true)
      element("patternId", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternId", Element.serializer().descriptor, isOptional = true)
      element("patternInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternInstant", Element.serializer().descriptor, isOptional = true)
      element("patternInteger", Int.serializer().descriptor, isOptional = true)
      element("_patternInteger", Element.serializer().descriptor, isOptional = true)
      element("patternInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_patternInteger64", Element.serializer().descriptor, isOptional = true)
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
      element("patternAvailability", Availability.serializer().descriptor, isOptional = true)
      element(
        "patternExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element("patternDosage", Dosage.serializer().descriptor, isOptional = true)
      element("patternMeta", Meta.serializer().descriptor, isOptional = true)
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
      element("minValueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_minValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("minValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_minValueInteger", Element.serializer().descriptor, isOptional = true)
      element("minValueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_minValueInteger64", Element.serializer().descriptor, isOptional = true)
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
      element("maxValueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_maxValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("maxValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_maxValueInteger", Element.serializer().descriptor, isOptional = true)
      element("maxValueInteger64", KotlinString.serializer().descriptor, isOptional = true)
      element("_maxValueInteger64", Element.serializer().descriptor, isOptional = true)
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
      element("mustHaveValue", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_mustHaveValue", Element.serializer().descriptor, isOptional = true)
      element(
        "valueAlternatives",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_valueAlternatives",
        listSerialDescriptor(Element.serializer().descriptor),
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ElementDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ElementDefinition {
    val __desc = descriptor
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
    var defaultValueDecimal: BigDecimal? = null
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
    var fixedDecimal: BigDecimal? = null
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
    var patternDecimal: BigDecimal? = null
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
    var minValueDecimal: BigDecimal? = null
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
    var maxValueDecimal: BigDecimal? = null
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(__desc, 3)
        4 -> _path = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.pathSer, null)
        5 ->
          representation =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.representationSer, null)
        6 ->
          _representation =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.representationSer2, null)
        7 -> sliceName = decoder.decodeStringElement(__desc, 7)
        8 ->
          _sliceName = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.pathSer, null)
        9 -> sliceIsConstraining = decoder.decodeBooleanElement(__desc, 9)
        10 ->
          _sliceIsConstraining =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.pathSer, null)
        11 -> label = decoder.decodeStringElement(__desc, 11)
        12 -> _label = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.pathSer, null)
        13 -> code = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.codeSer, null)
        14 ->
          slicing = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.slicingSer, null)
        15 -> short = decoder.decodeStringElement(__desc, 15)
        16 -> _short = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.pathSer, null)
        17 -> definition = decoder.decodeStringElement(__desc, 17)
        18 ->
          _definition = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.pathSer, null)
        19 -> comment = decoder.decodeStringElement(__desc, 19)
        20 ->
          _comment = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.pathSer, null)
        21 -> requirements = decoder.decodeStringElement(__desc, 21)
        22 ->
          _requirements =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.pathSer, null)
        23 ->
          alias =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.representationSer, null)
        24 ->
          _alias =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.representationSer2, null)
        25 -> min = decoder.decodeIntElement(__desc, 25)
        26 -> _min = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.pathSer, null)
        27 -> max = decoder.decodeStringElement(__desc, 27)
        28 -> _max = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.pathSer, null)
        29 -> base = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.baseSer, null)
        30 -> contentReference = decoder.decodeStringElement(__desc, 30)
        31 ->
          _contentReference =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.pathSer, null)
        32 -> type = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.typeSer, null)
        33 -> defaultValueBase64Binary = decoder.decodeStringElement(__desc, 33)
        34 ->
          _defaultValueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.pathSer, null)
        35 -> defaultValueBoolean = decoder.decodeBooleanElement(__desc, 35)
        36 ->
          _defaultValueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.pathSer, null)
        37 -> defaultValueCanonical = decoder.decodeStringElement(__desc, 37)
        38 ->
          _defaultValueCanonical =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.pathSer, null)
        39 -> defaultValueCode = decoder.decodeStringElement(__desc, 39)
        40 ->
          _defaultValueCode =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.pathSer, null)
        41 -> defaultValueDate = decoder.decodeStringElement(__desc, 41)
        42 ->
          _defaultValueDate =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.pathSer, null)
        43 -> defaultValueDateTime = decoder.decodeStringElement(__desc, 43)
        44 ->
          _defaultValueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.pathSer, null)
        45 ->
          defaultValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 45, BigDecimalSerializer, null)
        46 ->
          _defaultValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.pathSer, null)
        47 -> defaultValueId = decoder.decodeStringElement(__desc, 47)
        48 ->
          _defaultValueId =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.pathSer, null)
        49 -> defaultValueInstant = decoder.decodeStringElement(__desc, 49)
        50 ->
          _defaultValueInstant =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.pathSer, null)
        51 -> defaultValueInteger = decoder.decodeIntElement(__desc, 51)
        52 ->
          _defaultValueInteger =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.pathSer, null)
        53 -> defaultValueInteger64 = decoder.decodeStringElement(__desc, 53)
        54 ->
          _defaultValueInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.pathSer, null)
        55 -> defaultValueMarkdown = decoder.decodeStringElement(__desc, 55)
        56 ->
          _defaultValueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.pathSer, null)
        57 -> defaultValueOid = decoder.decodeStringElement(__desc, 57)
        58 ->
          _defaultValueOid =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.pathSer, null)
        59 -> defaultValuePositiveInt = decoder.decodeIntElement(__desc, 59)
        60 ->
          _defaultValuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.pathSer, null)
        61 -> defaultValueString = decoder.decodeStringElement(__desc, 61)
        62 ->
          _defaultValueString =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.pathSer, null)
        63 ->
          defaultValueTime =
            decoder.decodeNullableSerializableElement(__desc, 63, LocalTimeSerializer, null)
        64 ->
          _defaultValueTime =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.pathSer, null)
        65 -> defaultValueUnsignedInt = decoder.decodeIntElement(__desc, 65)
        66 ->
          _defaultValueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.pathSer, null)
        67 -> defaultValueUri = decoder.decodeStringElement(__desc, 67)
        68 ->
          _defaultValueUri =
            decoder.decodeNullableSerializableElement(__desc, 68, Hoisted.pathSer, null)
        69 -> defaultValueUrl = decoder.decodeStringElement(__desc, 69)
        70 ->
          _defaultValueUrl =
            decoder.decodeNullableSerializableElement(__desc, 70, Hoisted.pathSer, null)
        71 -> defaultValueUuid = decoder.decodeStringElement(__desc, 71)
        72 ->
          _defaultValueUuid =
            decoder.decodeNullableSerializableElement(__desc, 72, Hoisted.pathSer, null)
        73 ->
          defaultValueAddress =
            decoder.decodeNullableSerializableElement(
              __desc,
              73,
              Hoisted.defaultValueAddressSer,
              null,
            )
        74 ->
          defaultValueAge =
            decoder.decodeNullableSerializableElement(__desc, 74, Hoisted.defaultValueAgeSer, null)
        75 ->
          defaultValueAnnotation =
            decoder.decodeNullableSerializableElement(
              __desc,
              75,
              Hoisted.defaultValueAnnotationSer,
              null,
            )
        76 ->
          defaultValueAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              76,
              Hoisted.defaultValueAttachmentSer,
              null,
            )
        77 ->
          defaultValueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              77,
              Hoisted.defaultValueCodeableConceptSer,
              null,
            )
        78 ->
          defaultValueCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              78,
              Hoisted.defaultValueCodeableReferenceSer,
              null,
            )
        79 ->
          defaultValueCoding =
            decoder.decodeNullableSerializableElement(__desc, 79, Hoisted.codeSerInner, null)
        80 ->
          defaultValueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              80,
              Hoisted.defaultValueContactPointSer,
              null,
            )
        81 ->
          defaultValueCount =
            decoder.decodeNullableSerializableElement(
              __desc,
              81,
              Hoisted.defaultValueCountSer,
              null,
            )
        82 ->
          defaultValueDistance =
            decoder.decodeNullableSerializableElement(
              __desc,
              82,
              Hoisted.defaultValueDistanceSer,
              null,
            )
        83 ->
          defaultValueDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              83,
              Hoisted.defaultValueDurationSer,
              null,
            )
        84 ->
          defaultValueHumanName =
            decoder.decodeNullableSerializableElement(
              __desc,
              84,
              Hoisted.defaultValueHumanNameSer,
              null,
            )
        85 ->
          defaultValueIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              85,
              Hoisted.defaultValueIdentifierSer,
              null,
            )
        86 ->
          defaultValueMoney =
            decoder.decodeNullableSerializableElement(
              __desc,
              86,
              Hoisted.defaultValueMoneySer,
              null,
            )
        87 ->
          defaultValuePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              87,
              Hoisted.defaultValuePeriodSer,
              null,
            )
        88 ->
          defaultValueQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              88,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        89 ->
          defaultValueRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              89,
              Hoisted.defaultValueRangeSer,
              null,
            )
        90 ->
          defaultValueRatio =
            decoder.decodeNullableSerializableElement(
              __desc,
              90,
              Hoisted.defaultValueRatioSer,
              null,
            )
        91 ->
          defaultValueRatioRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              91,
              Hoisted.defaultValueRatioRangeSer,
              null,
            )
        92 ->
          defaultValueReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              92,
              Hoisted.defaultValueReferenceSer,
              null,
            )
        93 ->
          defaultValueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              93,
              Hoisted.defaultValueSampledDataSer,
              null,
            )
        94 ->
          defaultValueSignature =
            decoder.decodeNullableSerializableElement(
              __desc,
              94,
              Hoisted.defaultValueSignatureSer,
              null,
            )
        95 ->
          defaultValueTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              95,
              Hoisted.defaultValueTimingSer,
              null,
            )
        96 ->
          defaultValueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              96,
              Hoisted.defaultValueContactDetailSer,
              null,
            )
        97 ->
          defaultValueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              97,
              Hoisted.defaultValueDataRequirementSer,
              null,
            )
        98 ->
          defaultValueExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              98,
              Hoisted.defaultValueExpressionSer,
              null,
            )
        99 ->
          defaultValueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              99,
              Hoisted.defaultValueParameterDefinitionSer,
              null,
            )
        100 ->
          defaultValueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              100,
              Hoisted.defaultValueRelatedArtifactSer,
              null,
            )
        101 ->
          defaultValueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              101,
              Hoisted.defaultValueTriggerDefinitionSer,
              null,
            )
        102 ->
          defaultValueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              102,
              Hoisted.defaultValueUsageContextSer,
              null,
            )
        103 ->
          defaultValueAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              103,
              Hoisted.defaultValueAvailabilitySer,
              null,
            )
        104 ->
          defaultValueExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              104,
              Hoisted.defaultValueExtendedContactDetailSer,
              null,
            )
        105 ->
          defaultValueDosage =
            decoder.decodeNullableSerializableElement(
              __desc,
              105,
              Hoisted.defaultValueDosageSer,
              null,
            )
        106 ->
          defaultValueMeta =
            decoder.decodeNullableSerializableElement(
              __desc,
              106,
              Hoisted.defaultValueMetaSer,
              null,
            )
        107 -> meaningWhenMissing = decoder.decodeStringElement(__desc, 107)
        108 ->
          _meaningWhenMissing =
            decoder.decodeNullableSerializableElement(__desc, 108, Hoisted.pathSer, null)
        109 -> orderMeaning = decoder.decodeStringElement(__desc, 109)
        110 ->
          _orderMeaning =
            decoder.decodeNullableSerializableElement(__desc, 110, Hoisted.pathSer, null)
        111 -> fixedBase64Binary = decoder.decodeStringElement(__desc, 111)
        112 ->
          _fixedBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 112, Hoisted.pathSer, null)
        113 -> fixedBoolean = decoder.decodeBooleanElement(__desc, 113)
        114 ->
          _fixedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 114, Hoisted.pathSer, null)
        115 -> fixedCanonical = decoder.decodeStringElement(__desc, 115)
        116 ->
          _fixedCanonical =
            decoder.decodeNullableSerializableElement(__desc, 116, Hoisted.pathSer, null)
        117 -> fixedCode = decoder.decodeStringElement(__desc, 117)
        118 ->
          _fixedCode = decoder.decodeNullableSerializableElement(__desc, 118, Hoisted.pathSer, null)
        119 -> fixedDate = decoder.decodeStringElement(__desc, 119)
        120 ->
          _fixedDate = decoder.decodeNullableSerializableElement(__desc, 120, Hoisted.pathSer, null)
        121 -> fixedDateTime = decoder.decodeStringElement(__desc, 121)
        122 ->
          _fixedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 122, Hoisted.pathSer, null)
        123 ->
          fixedDecimal =
            decoder.decodeNullableSerializableElement(__desc, 123, BigDecimalSerializer, null)
        124 ->
          _fixedDecimal =
            decoder.decodeNullableSerializableElement(__desc, 124, Hoisted.pathSer, null)
        125 -> fixedId = decoder.decodeStringElement(__desc, 125)
        126 ->
          _fixedId = decoder.decodeNullableSerializableElement(__desc, 126, Hoisted.pathSer, null)
        127 -> fixedInstant = decoder.decodeStringElement(__desc, 127)
        128 ->
          _fixedInstant =
            decoder.decodeNullableSerializableElement(__desc, 128, Hoisted.pathSer, null)
        129 -> fixedInteger = decoder.decodeIntElement(__desc, 129)
        130 ->
          _fixedInteger =
            decoder.decodeNullableSerializableElement(__desc, 130, Hoisted.pathSer, null)
        131 -> fixedInteger64 = decoder.decodeStringElement(__desc, 131)
        132 ->
          _fixedInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 132, Hoisted.pathSer, null)
        133 -> fixedMarkdown = decoder.decodeStringElement(__desc, 133)
        134 ->
          _fixedMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 134, Hoisted.pathSer, null)
        135 -> fixedOid = decoder.decodeStringElement(__desc, 135)
        136 ->
          _fixedOid = decoder.decodeNullableSerializableElement(__desc, 136, Hoisted.pathSer, null)
        137 -> fixedPositiveInt = decoder.decodeIntElement(__desc, 137)
        138 ->
          _fixedPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 138, Hoisted.pathSer, null)
        139 -> fixedString = decoder.decodeStringElement(__desc, 139)
        140 ->
          _fixedString =
            decoder.decodeNullableSerializableElement(__desc, 140, Hoisted.pathSer, null)
        141 ->
          fixedTime =
            decoder.decodeNullableSerializableElement(__desc, 141, LocalTimeSerializer, null)
        142 ->
          _fixedTime = decoder.decodeNullableSerializableElement(__desc, 142, Hoisted.pathSer, null)
        143 -> fixedUnsignedInt = decoder.decodeIntElement(__desc, 143)
        144 ->
          _fixedUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 144, Hoisted.pathSer, null)
        145 -> fixedUri = decoder.decodeStringElement(__desc, 145)
        146 ->
          _fixedUri = decoder.decodeNullableSerializableElement(__desc, 146, Hoisted.pathSer, null)
        147 -> fixedUrl = decoder.decodeStringElement(__desc, 147)
        148 ->
          _fixedUrl = decoder.decodeNullableSerializableElement(__desc, 148, Hoisted.pathSer, null)
        149 -> fixedUuid = decoder.decodeStringElement(__desc, 149)
        150 ->
          _fixedUuid = decoder.decodeNullableSerializableElement(__desc, 150, Hoisted.pathSer, null)
        151 ->
          fixedAddress =
            decoder.decodeNullableSerializableElement(
              __desc,
              151,
              Hoisted.defaultValueAddressSer,
              null,
            )
        152 ->
          fixedAge =
            decoder.decodeNullableSerializableElement(__desc, 152, Hoisted.defaultValueAgeSer, null)
        153 ->
          fixedAnnotation =
            decoder.decodeNullableSerializableElement(
              __desc,
              153,
              Hoisted.defaultValueAnnotationSer,
              null,
            )
        154 ->
          fixedAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              154,
              Hoisted.defaultValueAttachmentSer,
              null,
            )
        155 ->
          fixedCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              155,
              Hoisted.defaultValueCodeableConceptSer,
              null,
            )
        156 ->
          fixedCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              156,
              Hoisted.defaultValueCodeableReferenceSer,
              null,
            )
        157 ->
          fixedCoding =
            decoder.decodeNullableSerializableElement(__desc, 157, Hoisted.codeSerInner, null)
        158 ->
          fixedContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              158,
              Hoisted.defaultValueContactPointSer,
              null,
            )
        159 ->
          fixedCount =
            decoder.decodeNullableSerializableElement(
              __desc,
              159,
              Hoisted.defaultValueCountSer,
              null,
            )
        160 ->
          fixedDistance =
            decoder.decodeNullableSerializableElement(
              __desc,
              160,
              Hoisted.defaultValueDistanceSer,
              null,
            )
        161 ->
          fixedDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              161,
              Hoisted.defaultValueDurationSer,
              null,
            )
        162 ->
          fixedHumanName =
            decoder.decodeNullableSerializableElement(
              __desc,
              162,
              Hoisted.defaultValueHumanNameSer,
              null,
            )
        163 ->
          fixedIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              163,
              Hoisted.defaultValueIdentifierSer,
              null,
            )
        164 ->
          fixedMoney =
            decoder.decodeNullableSerializableElement(
              __desc,
              164,
              Hoisted.defaultValueMoneySer,
              null,
            )
        165 ->
          fixedPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              165,
              Hoisted.defaultValuePeriodSer,
              null,
            )
        166 ->
          fixedQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              166,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        167 ->
          fixedRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              167,
              Hoisted.defaultValueRangeSer,
              null,
            )
        168 ->
          fixedRatio =
            decoder.decodeNullableSerializableElement(
              __desc,
              168,
              Hoisted.defaultValueRatioSer,
              null,
            )
        169 ->
          fixedRatioRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              169,
              Hoisted.defaultValueRatioRangeSer,
              null,
            )
        170 ->
          fixedReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              170,
              Hoisted.defaultValueReferenceSer,
              null,
            )
        171 ->
          fixedSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              171,
              Hoisted.defaultValueSampledDataSer,
              null,
            )
        172 ->
          fixedSignature =
            decoder.decodeNullableSerializableElement(
              __desc,
              172,
              Hoisted.defaultValueSignatureSer,
              null,
            )
        173 ->
          fixedTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              173,
              Hoisted.defaultValueTimingSer,
              null,
            )
        174 ->
          fixedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              174,
              Hoisted.defaultValueContactDetailSer,
              null,
            )
        175 ->
          fixedDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              175,
              Hoisted.defaultValueDataRequirementSer,
              null,
            )
        176 ->
          fixedExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              176,
              Hoisted.defaultValueExpressionSer,
              null,
            )
        177 ->
          fixedParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              177,
              Hoisted.defaultValueParameterDefinitionSer,
              null,
            )
        178 ->
          fixedRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              178,
              Hoisted.defaultValueRelatedArtifactSer,
              null,
            )
        179 ->
          fixedTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              179,
              Hoisted.defaultValueTriggerDefinitionSer,
              null,
            )
        180 ->
          fixedUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              180,
              Hoisted.defaultValueUsageContextSer,
              null,
            )
        181 ->
          fixedAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              181,
              Hoisted.defaultValueAvailabilitySer,
              null,
            )
        182 ->
          fixedExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              182,
              Hoisted.defaultValueExtendedContactDetailSer,
              null,
            )
        183 ->
          fixedDosage =
            decoder.decodeNullableSerializableElement(
              __desc,
              183,
              Hoisted.defaultValueDosageSer,
              null,
            )
        184 ->
          fixedMeta =
            decoder.decodeNullableSerializableElement(
              __desc,
              184,
              Hoisted.defaultValueMetaSer,
              null,
            )
        185 -> patternBase64Binary = decoder.decodeStringElement(__desc, 185)
        186 ->
          _patternBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 186, Hoisted.pathSer, null)
        187 -> patternBoolean = decoder.decodeBooleanElement(__desc, 187)
        188 ->
          _patternBoolean =
            decoder.decodeNullableSerializableElement(__desc, 188, Hoisted.pathSer, null)
        189 -> patternCanonical = decoder.decodeStringElement(__desc, 189)
        190 ->
          _patternCanonical =
            decoder.decodeNullableSerializableElement(__desc, 190, Hoisted.pathSer, null)
        191 -> patternCode = decoder.decodeStringElement(__desc, 191)
        192 ->
          _patternCode =
            decoder.decodeNullableSerializableElement(__desc, 192, Hoisted.pathSer, null)
        193 -> patternDate = decoder.decodeStringElement(__desc, 193)
        194 ->
          _patternDate =
            decoder.decodeNullableSerializableElement(__desc, 194, Hoisted.pathSer, null)
        195 -> patternDateTime = decoder.decodeStringElement(__desc, 195)
        196 ->
          _patternDateTime =
            decoder.decodeNullableSerializableElement(__desc, 196, Hoisted.pathSer, null)
        197 ->
          patternDecimal =
            decoder.decodeNullableSerializableElement(__desc, 197, BigDecimalSerializer, null)
        198 ->
          _patternDecimal =
            decoder.decodeNullableSerializableElement(__desc, 198, Hoisted.pathSer, null)
        199 -> patternId = decoder.decodeStringElement(__desc, 199)
        200 ->
          _patternId = decoder.decodeNullableSerializableElement(__desc, 200, Hoisted.pathSer, null)
        201 -> patternInstant = decoder.decodeStringElement(__desc, 201)
        202 ->
          _patternInstant =
            decoder.decodeNullableSerializableElement(__desc, 202, Hoisted.pathSer, null)
        203 -> patternInteger = decoder.decodeIntElement(__desc, 203)
        204 ->
          _patternInteger =
            decoder.decodeNullableSerializableElement(__desc, 204, Hoisted.pathSer, null)
        205 -> patternInteger64 = decoder.decodeStringElement(__desc, 205)
        206 ->
          _patternInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 206, Hoisted.pathSer, null)
        207 -> patternMarkdown = decoder.decodeStringElement(__desc, 207)
        208 ->
          _patternMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 208, Hoisted.pathSer, null)
        209 -> patternOid = decoder.decodeStringElement(__desc, 209)
        210 ->
          _patternOid =
            decoder.decodeNullableSerializableElement(__desc, 210, Hoisted.pathSer, null)
        211 -> patternPositiveInt = decoder.decodeIntElement(__desc, 211)
        212 ->
          _patternPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 212, Hoisted.pathSer, null)
        213 -> patternString = decoder.decodeStringElement(__desc, 213)
        214 ->
          _patternString =
            decoder.decodeNullableSerializableElement(__desc, 214, Hoisted.pathSer, null)
        215 ->
          patternTime =
            decoder.decodeNullableSerializableElement(__desc, 215, LocalTimeSerializer, null)
        216 ->
          _patternTime =
            decoder.decodeNullableSerializableElement(__desc, 216, Hoisted.pathSer, null)
        217 -> patternUnsignedInt = decoder.decodeIntElement(__desc, 217)
        218 ->
          _patternUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 218, Hoisted.pathSer, null)
        219 -> patternUri = decoder.decodeStringElement(__desc, 219)
        220 ->
          _patternUri =
            decoder.decodeNullableSerializableElement(__desc, 220, Hoisted.pathSer, null)
        221 -> patternUrl = decoder.decodeStringElement(__desc, 221)
        222 ->
          _patternUrl =
            decoder.decodeNullableSerializableElement(__desc, 222, Hoisted.pathSer, null)
        223 -> patternUuid = decoder.decodeStringElement(__desc, 223)
        224 ->
          _patternUuid =
            decoder.decodeNullableSerializableElement(__desc, 224, Hoisted.pathSer, null)
        225 ->
          patternAddress =
            decoder.decodeNullableSerializableElement(
              __desc,
              225,
              Hoisted.defaultValueAddressSer,
              null,
            )
        226 ->
          patternAge =
            decoder.decodeNullableSerializableElement(__desc, 226, Hoisted.defaultValueAgeSer, null)
        227 ->
          patternAnnotation =
            decoder.decodeNullableSerializableElement(
              __desc,
              227,
              Hoisted.defaultValueAnnotationSer,
              null,
            )
        228 ->
          patternAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              228,
              Hoisted.defaultValueAttachmentSer,
              null,
            )
        229 ->
          patternCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              229,
              Hoisted.defaultValueCodeableConceptSer,
              null,
            )
        230 ->
          patternCodeableReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              230,
              Hoisted.defaultValueCodeableReferenceSer,
              null,
            )
        231 ->
          patternCoding =
            decoder.decodeNullableSerializableElement(__desc, 231, Hoisted.codeSerInner, null)
        232 ->
          patternContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              232,
              Hoisted.defaultValueContactPointSer,
              null,
            )
        233 ->
          patternCount =
            decoder.decodeNullableSerializableElement(
              __desc,
              233,
              Hoisted.defaultValueCountSer,
              null,
            )
        234 ->
          patternDistance =
            decoder.decodeNullableSerializableElement(
              __desc,
              234,
              Hoisted.defaultValueDistanceSer,
              null,
            )
        235 ->
          patternDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              235,
              Hoisted.defaultValueDurationSer,
              null,
            )
        236 ->
          patternHumanName =
            decoder.decodeNullableSerializableElement(
              __desc,
              236,
              Hoisted.defaultValueHumanNameSer,
              null,
            )
        237 ->
          patternIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              237,
              Hoisted.defaultValueIdentifierSer,
              null,
            )
        238 ->
          patternMoney =
            decoder.decodeNullableSerializableElement(
              __desc,
              238,
              Hoisted.defaultValueMoneySer,
              null,
            )
        239 ->
          patternPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              239,
              Hoisted.defaultValuePeriodSer,
              null,
            )
        240 ->
          patternQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              240,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        241 ->
          patternRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              241,
              Hoisted.defaultValueRangeSer,
              null,
            )
        242 ->
          patternRatio =
            decoder.decodeNullableSerializableElement(
              __desc,
              242,
              Hoisted.defaultValueRatioSer,
              null,
            )
        243 ->
          patternRatioRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              243,
              Hoisted.defaultValueRatioRangeSer,
              null,
            )
        244 ->
          patternReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              244,
              Hoisted.defaultValueReferenceSer,
              null,
            )
        245 ->
          patternSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              245,
              Hoisted.defaultValueSampledDataSer,
              null,
            )
        246 ->
          patternSignature =
            decoder.decodeNullableSerializableElement(
              __desc,
              246,
              Hoisted.defaultValueSignatureSer,
              null,
            )
        247 ->
          patternTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              247,
              Hoisted.defaultValueTimingSer,
              null,
            )
        248 ->
          patternContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              248,
              Hoisted.defaultValueContactDetailSer,
              null,
            )
        249 ->
          patternDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              249,
              Hoisted.defaultValueDataRequirementSer,
              null,
            )
        250 ->
          patternExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              250,
              Hoisted.defaultValueExpressionSer,
              null,
            )
        251 ->
          patternParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              251,
              Hoisted.defaultValueParameterDefinitionSer,
              null,
            )
        252 ->
          patternRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              252,
              Hoisted.defaultValueRelatedArtifactSer,
              null,
            )
        253 ->
          patternTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              253,
              Hoisted.defaultValueTriggerDefinitionSer,
              null,
            )
        254 ->
          patternUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              254,
              Hoisted.defaultValueUsageContextSer,
              null,
            )
        255 ->
          patternAvailability =
            decoder.decodeNullableSerializableElement(
              __desc,
              255,
              Hoisted.defaultValueAvailabilitySer,
              null,
            )
        256 ->
          patternExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              256,
              Hoisted.defaultValueExtendedContactDetailSer,
              null,
            )
        257 ->
          patternDosage =
            decoder.decodeNullableSerializableElement(
              __desc,
              257,
              Hoisted.defaultValueDosageSer,
              null,
            )
        258 ->
          patternMeta =
            decoder.decodeNullableSerializableElement(
              __desc,
              258,
              Hoisted.defaultValueMetaSer,
              null,
            )
        259 ->
          example = decoder.decodeNullableSerializableElement(__desc, 259, Hoisted.exampleSer, null)
        260 -> minValueDate = decoder.decodeStringElement(__desc, 260)
        261 ->
          _minValueDate =
            decoder.decodeNullableSerializableElement(__desc, 261, Hoisted.pathSer, null)
        262 -> minValueDateTime = decoder.decodeStringElement(__desc, 262)
        263 ->
          _minValueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 263, Hoisted.pathSer, null)
        264 -> minValueInstant = decoder.decodeStringElement(__desc, 264)
        265 ->
          _minValueInstant =
            decoder.decodeNullableSerializableElement(__desc, 265, Hoisted.pathSer, null)
        266 ->
          minValueTime =
            decoder.decodeNullableSerializableElement(__desc, 266, LocalTimeSerializer, null)
        267 ->
          _minValueTime =
            decoder.decodeNullableSerializableElement(__desc, 267, Hoisted.pathSer, null)
        268 ->
          minValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 268, BigDecimalSerializer, null)
        269 ->
          _minValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 269, Hoisted.pathSer, null)
        270 -> minValueInteger = decoder.decodeIntElement(__desc, 270)
        271 ->
          _minValueInteger =
            decoder.decodeNullableSerializableElement(__desc, 271, Hoisted.pathSer, null)
        272 -> minValueInteger64 = decoder.decodeStringElement(__desc, 272)
        273 ->
          _minValueInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 273, Hoisted.pathSer, null)
        274 -> minValuePositiveInt = decoder.decodeIntElement(__desc, 274)
        275 ->
          _minValuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 275, Hoisted.pathSer, null)
        276 -> minValueUnsignedInt = decoder.decodeIntElement(__desc, 276)
        277 ->
          _minValueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 277, Hoisted.pathSer, null)
        278 ->
          minValueQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              278,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        279 -> maxValueDate = decoder.decodeStringElement(__desc, 279)
        280 ->
          _maxValueDate =
            decoder.decodeNullableSerializableElement(__desc, 280, Hoisted.pathSer, null)
        281 -> maxValueDateTime = decoder.decodeStringElement(__desc, 281)
        282 ->
          _maxValueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 282, Hoisted.pathSer, null)
        283 -> maxValueInstant = decoder.decodeStringElement(__desc, 283)
        284 ->
          _maxValueInstant =
            decoder.decodeNullableSerializableElement(__desc, 284, Hoisted.pathSer, null)
        285 ->
          maxValueTime =
            decoder.decodeNullableSerializableElement(__desc, 285, LocalTimeSerializer, null)
        286 ->
          _maxValueTime =
            decoder.decodeNullableSerializableElement(__desc, 286, Hoisted.pathSer, null)
        287 ->
          maxValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 287, BigDecimalSerializer, null)
        288 ->
          _maxValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 288, Hoisted.pathSer, null)
        289 -> maxValueInteger = decoder.decodeIntElement(__desc, 289)
        290 ->
          _maxValueInteger =
            decoder.decodeNullableSerializableElement(__desc, 290, Hoisted.pathSer, null)
        291 -> maxValueInteger64 = decoder.decodeStringElement(__desc, 291)
        292 ->
          _maxValueInteger64 =
            decoder.decodeNullableSerializableElement(__desc, 292, Hoisted.pathSer, null)
        293 -> maxValuePositiveInt = decoder.decodeIntElement(__desc, 293)
        294 ->
          _maxValuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 294, Hoisted.pathSer, null)
        295 -> maxValueUnsignedInt = decoder.decodeIntElement(__desc, 295)
        296 ->
          _maxValueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, 296, Hoisted.pathSer, null)
        297 ->
          maxValueQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              297,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        298 -> maxLength = decoder.decodeIntElement(__desc, 298)
        299 ->
          _maxLength = decoder.decodeNullableSerializableElement(__desc, 299, Hoisted.pathSer, null)
        300 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 300, Hoisted.representationSer, null)
        301 ->
          _condition =
            decoder.decodeNullableSerializableElement(__desc, 301, Hoisted.representationSer2, null)
        302 ->
          constraint =
            decoder.decodeNullableSerializableElement(__desc, 302, Hoisted.constraintSer, null)
        303 -> mustHaveValue = decoder.decodeBooleanElement(__desc, 303)
        304 ->
          _mustHaveValue =
            decoder.decodeNullableSerializableElement(__desc, 304, Hoisted.pathSer, null)
        305 ->
          valueAlternatives =
            decoder.decodeNullableSerializableElement(__desc, 305, Hoisted.representationSer, null)
        306 ->
          _valueAlternatives =
            decoder.decodeNullableSerializableElement(__desc, 306, Hoisted.representationSer2, null)
        307 -> mustSupport = decoder.decodeBooleanElement(__desc, 307)
        308 ->
          _mustSupport =
            decoder.decodeNullableSerializableElement(__desc, 308, Hoisted.pathSer, null)
        309 -> isModifier = decoder.decodeBooleanElement(__desc, 309)
        310 ->
          _isModifier =
            decoder.decodeNullableSerializableElement(__desc, 310, Hoisted.pathSer, null)
        311 -> isModifierReason = decoder.decodeStringElement(__desc, 311)
        312 ->
          _isModifierReason =
            decoder.decodeNullableSerializableElement(__desc, 312, Hoisted.pathSer, null)
        313 -> isSummary = decoder.decodeBooleanElement(__desc, 313)
        314 ->
          _isSummary = decoder.decodeNullableSerializableElement(__desc, 314, Hoisted.pathSer, null)
        315 ->
          binding = decoder.decodeNullableSerializableElement(__desc, 315, Hoisted.bindingSer, null)
        316 ->
          mapping = decoder.decodeNullableSerializableElement(__desc, 316, Hoisted.mappingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ElementDefinition: " + __i)
      }
    }
    return ElementDefinition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path = R5String.of(path, _path)!!,
      representation =
        (kotlin.collections.List(maxOf(representation?.size ?: 0, _representation?.size ?: 0)) { __i
          ->
          Enumeration.of(
            ElementDefinition.PropertyRepresentation.fromCode(representation?.getOrNull(__i)!!),
            _representation?.getOrNull(__i),
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
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { __i ->
          R5String.of(alias?.getOrNull(__i)?.let { it }, _alias?.getOrNull(__i))!!
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
          Date.of(FhirDate.fromString(defaultValueDate), _defaultValueDate),
          DateTime.of(FhirDateTime.fromString(defaultValueDateTime), _defaultValueDateTime),
          Decimal.of(defaultValueDecimal, _defaultValueDecimal),
          Id.of(defaultValueId, _defaultValueId),
          Instant.of(FhirDateTime.fromString(defaultValueInstant), _defaultValueInstant),
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
          Date.of(FhirDate.fromString(fixedDate), _fixedDate),
          DateTime.of(FhirDateTime.fromString(fixedDateTime), _fixedDateTime),
          Decimal.of(fixedDecimal, _fixedDecimal),
          Id.of(fixedId, _fixedId),
          Instant.of(FhirDateTime.fromString(fixedInstant), _fixedInstant),
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
          Date.of(FhirDate.fromString(patternDate), _patternDate),
          DateTime.of(FhirDateTime.fromString(patternDateTime), _patternDateTime),
          Decimal.of(patternDecimal, _patternDecimal),
          Id.of(patternId, _patternId),
          Instant.of(FhirDateTime.fromString(patternInstant), _patternInstant),
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
          Date.of(FhirDate.fromString(minValueDate), _minValueDate),
          DateTime.of(FhirDateTime.fromString(minValueDateTime), _minValueDateTime),
          Instant.of(FhirDateTime.fromString(minValueInstant), _minValueInstant),
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
          Date.of(FhirDate.fromString(maxValueDate), _maxValueDate),
          DateTime.of(FhirDateTime.fromString(maxValueDateTime), _maxValueDateTime),
          Instant.of(FhirDateTime.fromString(maxValueInstant), _maxValueInstant),
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
        (kotlin.collections.List(maxOf(condition?.size ?: 0, _condition?.size ?: 0)) { __i ->
          Id.of(condition?.getOrNull(__i)?.let { it }, _condition?.getOrNull(__i))!!
        }),
      constraint = constraint ?: listOf(),
      mustHaveValue = R5Boolean.of(mustHaveValue, _mustHaveValue),
      valueAlternatives =
        (kotlin.collections.List(
          maxOf(valueAlternatives?.size ?: 0, _valueAlternatives?.size ?: 0)
        ) { __i ->
          Canonical.of(
            valueAlternatives?.getOrNull(__i)?.let { it },
            _valueAlternatives?.getOrNull(__i),
          )!!
        }),
      mustSupport = R5Boolean.of(mustSupport, _mustSupport),
      isModifier = R5Boolean.of(isModifier, _isModifier),
      isModifierReason = R5String.of(isModifierReason, _isModifierReason),
      isSummary = R5Boolean.of(isSummary, _isSummary),
      binding = binding,
      mapping = mapping ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ElementDefinition) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.path.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.pathSer, it)
    }
    (value.representation.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.representationSer, it)
    }
    (value.representation.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.representationSer2, it)
    }
    ((value.sliceName?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.sliceName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.pathSer, it)
    }
    ((value.sliceIsConstraining?.value))?.let { encoder.encodeBooleanElement(__desc, 9, it) }
    (value.sliceIsConstraining?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.pathSer, it)
    }
    ((value.label?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.pathSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.codeSer, value.code)
    (value.slicing)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.slicingSer, it) }
    ((value.short?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.short?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.pathSer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.pathSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.pathSer, it)
    }
    ((value.requirements?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.requirements?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.pathSer, it)
    }
    (value.alias.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.representationSer, it)
    }
    (value.alias.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.representationSer2, it)
    }
    ((value.min?.value))?.let { encoder.encodeIntElement(__desc, 25, it) }
    (value.min?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.pathSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.pathSer, it)
    }
    (value.base)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.baseSer, it) }
    ((value.contentReference?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.contentReference?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.pathSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.typeSer, value.type)
    when (val __d = value.defaultValue) {
      null -> {}
      is ElementDefinition.DefaultValue.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 34, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 35, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 36, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 38, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 40, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 41, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 42, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 43, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 44, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 45, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 46, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 47, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 48, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 49, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 50, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 51, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 52, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 53, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 54, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 55, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 56, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 57, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 58, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 59, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 60, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 61, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 62, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 63, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 64, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 65, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 66, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 67, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 68, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 69, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 70, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 71, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 72, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.DefaultValue.Address -> {
        encoder.encodeSerializableElement(__desc, 73, Hoisted.defaultValueAddressSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Age -> {
        encoder.encodeSerializableElement(__desc, 74, Hoisted.defaultValueAgeSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Annotation -> {
        encoder.encodeSerializableElement(__desc, 75, Hoisted.defaultValueAnnotationSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Attachment -> {
        encoder.encodeSerializableElement(__desc, 76, Hoisted.defaultValueAttachmentSer, __d.value)
      }
      is ElementDefinition.DefaultValue.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          77,
          Hoisted.defaultValueCodeableConceptSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.CodeableReference -> {
        encoder.encodeSerializableElement(
          __desc,
          78,
          Hoisted.defaultValueCodeableReferenceSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.Coding -> {
        encoder.encodeSerializableElement(__desc, 79, Hoisted.codeSerInner, __d.value)
      }
      is ElementDefinition.DefaultValue.ContactPoint -> {
        encoder.encodeSerializableElement(
          __desc,
          80,
          Hoisted.defaultValueContactPointSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.Count -> {
        encoder.encodeSerializableElement(__desc, 81, Hoisted.defaultValueCountSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Distance -> {
        encoder.encodeSerializableElement(__desc, 82, Hoisted.defaultValueDistanceSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Duration -> {
        encoder.encodeSerializableElement(__desc, 83, Hoisted.defaultValueDurationSer, __d.value)
      }
      is ElementDefinition.DefaultValue.HumanName -> {
        encoder.encodeSerializableElement(__desc, 84, Hoisted.defaultValueHumanNameSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Identifier -> {
        encoder.encodeSerializableElement(__desc, 85, Hoisted.defaultValueIdentifierSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Money -> {
        encoder.encodeSerializableElement(__desc, 86, Hoisted.defaultValueMoneySer, __d.value)
      }
      is ElementDefinition.DefaultValue.Period -> {
        encoder.encodeSerializableElement(__desc, 87, Hoisted.defaultValuePeriodSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Quantity -> {
        encoder.encodeSerializableElement(__desc, 88, Hoisted.defaultValueQuantitySer, __d.value)
      }
      is ElementDefinition.DefaultValue.Range -> {
        encoder.encodeSerializableElement(__desc, 89, Hoisted.defaultValueRangeSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Ratio -> {
        encoder.encodeSerializableElement(__desc, 90, Hoisted.defaultValueRatioSer, __d.value)
      }
      is ElementDefinition.DefaultValue.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 91, Hoisted.defaultValueRatioRangeSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Reference -> {
        encoder.encodeSerializableElement(__desc, 92, Hoisted.defaultValueReferenceSer, __d.value)
      }
      is ElementDefinition.DefaultValue.SampledData -> {
        encoder.encodeSerializableElement(__desc, 93, Hoisted.defaultValueSampledDataSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Signature -> {
        encoder.encodeSerializableElement(__desc, 94, Hoisted.defaultValueSignatureSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Timing -> {
        encoder.encodeSerializableElement(__desc, 95, Hoisted.defaultValueTimingSer, __d.value)
      }
      is ElementDefinition.DefaultValue.ContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          96,
          Hoisted.defaultValueContactDetailSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.DataRequirement -> {
        encoder.encodeSerializableElement(
          __desc,
          97,
          Hoisted.defaultValueDataRequirementSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.Expression -> {
        encoder.encodeSerializableElement(__desc, 98, Hoisted.defaultValueExpressionSer, __d.value)
      }
      is ElementDefinition.DefaultValue.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          99,
          Hoisted.defaultValueParameterDefinitionSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          __desc,
          100,
          Hoisted.defaultValueRelatedArtifactSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          101,
          Hoisted.defaultValueTriggerDefinitionSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.UsageContext -> {
        encoder.encodeSerializableElement(
          __desc,
          102,
          Hoisted.defaultValueUsageContextSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.Availability -> {
        encoder.encodeSerializableElement(
          __desc,
          103,
          Hoisted.defaultValueAvailabilitySer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          104,
          Hoisted.defaultValueExtendedContactDetailSer,
          __d.value,
        )
      }
      is ElementDefinition.DefaultValue.Dosage -> {
        encoder.encodeSerializableElement(__desc, 105, Hoisted.defaultValueDosageSer, __d.value)
      }
      is ElementDefinition.DefaultValue.Meta -> {
        encoder.encodeSerializableElement(__desc, 106, Hoisted.defaultValueMetaSer, __d.value)
      }
    }
    ((value.meaningWhenMissing?.value))?.let { encoder.encodeStringElement(__desc, 107, it) }
    (value.meaningWhenMissing?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 108, Hoisted.pathSer, it)
    }
    ((value.orderMeaning?.value))?.let { encoder.encodeStringElement(__desc, 109, it) }
    (value.orderMeaning?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 110, Hoisted.pathSer, it)
    }
    when (val __d = value.fixed) {
      null -> {}
      is ElementDefinition.Fixed.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 111, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 112, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 113, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 114, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 115, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 116, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 117, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 118, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 119, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 120, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 121, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 122, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 123, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 124, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 125, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 126, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 127, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 128, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 129, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 130, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 131, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 132, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 133, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 134, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 135, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 136, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 137, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 138, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 139, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 140, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 141, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 142, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 143, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 144, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 145, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 146, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 147, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 148, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 149, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 150, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Fixed.Address -> {
        encoder.encodeSerializableElement(__desc, 151, Hoisted.defaultValueAddressSer, __d.value)
      }
      is ElementDefinition.Fixed.Age -> {
        encoder.encodeSerializableElement(__desc, 152, Hoisted.defaultValueAgeSer, __d.value)
      }
      is ElementDefinition.Fixed.Annotation -> {
        encoder.encodeSerializableElement(__desc, 153, Hoisted.defaultValueAnnotationSer, __d.value)
      }
      is ElementDefinition.Fixed.Attachment -> {
        encoder.encodeSerializableElement(__desc, 154, Hoisted.defaultValueAttachmentSer, __d.value)
      }
      is ElementDefinition.Fixed.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          155,
          Hoisted.defaultValueCodeableConceptSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.CodeableReference -> {
        encoder.encodeSerializableElement(
          __desc,
          156,
          Hoisted.defaultValueCodeableReferenceSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.Coding -> {
        encoder.encodeSerializableElement(__desc, 157, Hoisted.codeSerInner, __d.value)
      }
      is ElementDefinition.Fixed.ContactPoint -> {
        encoder.encodeSerializableElement(
          __desc,
          158,
          Hoisted.defaultValueContactPointSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.Count -> {
        encoder.encodeSerializableElement(__desc, 159, Hoisted.defaultValueCountSer, __d.value)
      }
      is ElementDefinition.Fixed.Distance -> {
        encoder.encodeSerializableElement(__desc, 160, Hoisted.defaultValueDistanceSer, __d.value)
      }
      is ElementDefinition.Fixed.Duration -> {
        encoder.encodeSerializableElement(__desc, 161, Hoisted.defaultValueDurationSer, __d.value)
      }
      is ElementDefinition.Fixed.HumanName -> {
        encoder.encodeSerializableElement(__desc, 162, Hoisted.defaultValueHumanNameSer, __d.value)
      }
      is ElementDefinition.Fixed.Identifier -> {
        encoder.encodeSerializableElement(__desc, 163, Hoisted.defaultValueIdentifierSer, __d.value)
      }
      is ElementDefinition.Fixed.Money -> {
        encoder.encodeSerializableElement(__desc, 164, Hoisted.defaultValueMoneySer, __d.value)
      }
      is ElementDefinition.Fixed.Period -> {
        encoder.encodeSerializableElement(__desc, 165, Hoisted.defaultValuePeriodSer, __d.value)
      }
      is ElementDefinition.Fixed.Quantity -> {
        encoder.encodeSerializableElement(__desc, 166, Hoisted.defaultValueQuantitySer, __d.value)
      }
      is ElementDefinition.Fixed.Range -> {
        encoder.encodeSerializableElement(__desc, 167, Hoisted.defaultValueRangeSer, __d.value)
      }
      is ElementDefinition.Fixed.Ratio -> {
        encoder.encodeSerializableElement(__desc, 168, Hoisted.defaultValueRatioSer, __d.value)
      }
      is ElementDefinition.Fixed.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 169, Hoisted.defaultValueRatioRangeSer, __d.value)
      }
      is ElementDefinition.Fixed.Reference -> {
        encoder.encodeSerializableElement(__desc, 170, Hoisted.defaultValueReferenceSer, __d.value)
      }
      is ElementDefinition.Fixed.SampledData -> {
        encoder.encodeSerializableElement(
          __desc,
          171,
          Hoisted.defaultValueSampledDataSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.Signature -> {
        encoder.encodeSerializableElement(__desc, 172, Hoisted.defaultValueSignatureSer, __d.value)
      }
      is ElementDefinition.Fixed.Timing -> {
        encoder.encodeSerializableElement(__desc, 173, Hoisted.defaultValueTimingSer, __d.value)
      }
      is ElementDefinition.Fixed.ContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          174,
          Hoisted.defaultValueContactDetailSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.DataRequirement -> {
        encoder.encodeSerializableElement(
          __desc,
          175,
          Hoisted.defaultValueDataRequirementSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.Expression -> {
        encoder.encodeSerializableElement(__desc, 176, Hoisted.defaultValueExpressionSer, __d.value)
      }
      is ElementDefinition.Fixed.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          177,
          Hoisted.defaultValueParameterDefinitionSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          __desc,
          178,
          Hoisted.defaultValueRelatedArtifactSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          179,
          Hoisted.defaultValueTriggerDefinitionSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.UsageContext -> {
        encoder.encodeSerializableElement(
          __desc,
          180,
          Hoisted.defaultValueUsageContextSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.Availability -> {
        encoder.encodeSerializableElement(
          __desc,
          181,
          Hoisted.defaultValueAvailabilitySer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          182,
          Hoisted.defaultValueExtendedContactDetailSer,
          __d.value,
        )
      }
      is ElementDefinition.Fixed.Dosage -> {
        encoder.encodeSerializableElement(__desc, 183, Hoisted.defaultValueDosageSer, __d.value)
      }
      is ElementDefinition.Fixed.Meta -> {
        encoder.encodeSerializableElement(__desc, 184, Hoisted.defaultValueMetaSer, __d.value)
      }
    }
    when (val __d = value.pattern) {
      null -> {}
      is ElementDefinition.Pattern.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 185, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 186, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 187, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 188, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 189, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 190, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 191, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 192, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 193, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 194, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 195, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 196, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 197, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 198, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 199, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 200, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 201, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 202, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 203, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 204, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 205, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 206, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 207, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 208, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 209, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 210, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 211, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 212, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 213, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 214, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 215, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 216, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 217, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 218, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 219, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 220, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 221, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 222, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 223, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 224, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.Pattern.Address -> {
        encoder.encodeSerializableElement(__desc, 225, Hoisted.defaultValueAddressSer, __d.value)
      }
      is ElementDefinition.Pattern.Age -> {
        encoder.encodeSerializableElement(__desc, 226, Hoisted.defaultValueAgeSer, __d.value)
      }
      is ElementDefinition.Pattern.Annotation -> {
        encoder.encodeSerializableElement(__desc, 227, Hoisted.defaultValueAnnotationSer, __d.value)
      }
      is ElementDefinition.Pattern.Attachment -> {
        encoder.encodeSerializableElement(__desc, 228, Hoisted.defaultValueAttachmentSer, __d.value)
      }
      is ElementDefinition.Pattern.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          229,
          Hoisted.defaultValueCodeableConceptSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.CodeableReference -> {
        encoder.encodeSerializableElement(
          __desc,
          230,
          Hoisted.defaultValueCodeableReferenceSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.Coding -> {
        encoder.encodeSerializableElement(__desc, 231, Hoisted.codeSerInner, __d.value)
      }
      is ElementDefinition.Pattern.ContactPoint -> {
        encoder.encodeSerializableElement(
          __desc,
          232,
          Hoisted.defaultValueContactPointSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.Count -> {
        encoder.encodeSerializableElement(__desc, 233, Hoisted.defaultValueCountSer, __d.value)
      }
      is ElementDefinition.Pattern.Distance -> {
        encoder.encodeSerializableElement(__desc, 234, Hoisted.defaultValueDistanceSer, __d.value)
      }
      is ElementDefinition.Pattern.Duration -> {
        encoder.encodeSerializableElement(__desc, 235, Hoisted.defaultValueDurationSer, __d.value)
      }
      is ElementDefinition.Pattern.HumanName -> {
        encoder.encodeSerializableElement(__desc, 236, Hoisted.defaultValueHumanNameSer, __d.value)
      }
      is ElementDefinition.Pattern.Identifier -> {
        encoder.encodeSerializableElement(__desc, 237, Hoisted.defaultValueIdentifierSer, __d.value)
      }
      is ElementDefinition.Pattern.Money -> {
        encoder.encodeSerializableElement(__desc, 238, Hoisted.defaultValueMoneySer, __d.value)
      }
      is ElementDefinition.Pattern.Period -> {
        encoder.encodeSerializableElement(__desc, 239, Hoisted.defaultValuePeriodSer, __d.value)
      }
      is ElementDefinition.Pattern.Quantity -> {
        encoder.encodeSerializableElement(__desc, 240, Hoisted.defaultValueQuantitySer, __d.value)
      }
      is ElementDefinition.Pattern.Range -> {
        encoder.encodeSerializableElement(__desc, 241, Hoisted.defaultValueRangeSer, __d.value)
      }
      is ElementDefinition.Pattern.Ratio -> {
        encoder.encodeSerializableElement(__desc, 242, Hoisted.defaultValueRatioSer, __d.value)
      }
      is ElementDefinition.Pattern.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 243, Hoisted.defaultValueRatioRangeSer, __d.value)
      }
      is ElementDefinition.Pattern.Reference -> {
        encoder.encodeSerializableElement(__desc, 244, Hoisted.defaultValueReferenceSer, __d.value)
      }
      is ElementDefinition.Pattern.SampledData -> {
        encoder.encodeSerializableElement(
          __desc,
          245,
          Hoisted.defaultValueSampledDataSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.Signature -> {
        encoder.encodeSerializableElement(__desc, 246, Hoisted.defaultValueSignatureSer, __d.value)
      }
      is ElementDefinition.Pattern.Timing -> {
        encoder.encodeSerializableElement(__desc, 247, Hoisted.defaultValueTimingSer, __d.value)
      }
      is ElementDefinition.Pattern.ContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          248,
          Hoisted.defaultValueContactDetailSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.DataRequirement -> {
        encoder.encodeSerializableElement(
          __desc,
          249,
          Hoisted.defaultValueDataRequirementSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.Expression -> {
        encoder.encodeSerializableElement(__desc, 250, Hoisted.defaultValueExpressionSer, __d.value)
      }
      is ElementDefinition.Pattern.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          251,
          Hoisted.defaultValueParameterDefinitionSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          __desc,
          252,
          Hoisted.defaultValueRelatedArtifactSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          253,
          Hoisted.defaultValueTriggerDefinitionSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.UsageContext -> {
        encoder.encodeSerializableElement(
          __desc,
          254,
          Hoisted.defaultValueUsageContextSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.Availability -> {
        encoder.encodeSerializableElement(
          __desc,
          255,
          Hoisted.defaultValueAvailabilitySer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          256,
          Hoisted.defaultValueExtendedContactDetailSer,
          __d.value,
        )
      }
      is ElementDefinition.Pattern.Dosage -> {
        encoder.encodeSerializableElement(__desc, 257, Hoisted.defaultValueDosageSer, __d.value)
      }
      is ElementDefinition.Pattern.Meta -> {
        encoder.encodeSerializableElement(__desc, 258, Hoisted.defaultValueMetaSer, __d.value)
      }
    }
    if (value.example.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 259, Hoisted.exampleSer, value.example)
    when (val __d = value.minValue) {
      null -> {}
      is ElementDefinition.MinValue.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 260, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 261, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 262, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 263, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 264, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 265, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 266, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 267, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 268, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 269, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 270, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 271, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 272, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 273, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 274, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 275, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 276, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 277, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MinValue.Quantity -> {
        encoder.encodeSerializableElement(__desc, 278, Hoisted.defaultValueQuantitySer, __d.value)
      }
    }
    when (val __d = value.maxValue) {
      null -> {}
      is ElementDefinition.MaxValue.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 279, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 280, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 281, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 282, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 283, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 284, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 285, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 286, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 287, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 288, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 289, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 290, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Integer64 -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 291, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 292, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 293, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 294, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 295, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 296, Hoisted.pathSer, it)
        }
      }
      is ElementDefinition.MaxValue.Quantity -> {
        encoder.encodeSerializableElement(__desc, 297, Hoisted.defaultValueQuantitySer, __d.value)
      }
    }
    ((value.maxLength?.value))?.let { encoder.encodeIntElement(__desc, 298, it) }
    (value.maxLength?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 299, Hoisted.pathSer, it)
    }
    (value.condition.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 300, Hoisted.representationSer, it)
    }
    (value.condition.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 301, Hoisted.representationSer2, it)
    }
    if (value.constraint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 302, Hoisted.constraintSer, value.constraint)
    ((value.mustHaveValue?.value))?.let { encoder.encodeBooleanElement(__desc, 303, it) }
    (value.mustHaveValue?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 304, Hoisted.pathSer, it)
    }
    (value.valueAlternatives.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 305, Hoisted.representationSer, it)
    }
    (value.valueAlternatives.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 306, Hoisted.representationSer2, it)
    }
    ((value.mustSupport?.value))?.let { encoder.encodeBooleanElement(__desc, 307, it) }
    (value.mustSupport?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 308, Hoisted.pathSer, it)
    }
    ((value.isModifier?.value))?.let { encoder.encodeBooleanElement(__desc, 309, it) }
    (value.isModifier?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 310, Hoisted.pathSer, it)
    }
    ((value.isModifierReason?.value))?.let { encoder.encodeStringElement(__desc, 311, it) }
    (value.isModifierReason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 312, Hoisted.pathSer, it)
    }
    ((value.isSummary?.value))?.let { encoder.encodeBooleanElement(__desc, 313, it) }
    (value.isSummary?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 314, Hoisted.pathSer, it)
    }
    (value.binding)?.let { encoder.encodeSerializableElement(__desc, 315, Hoisted.bindingSer, it) }
    if (value.mapping.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 316, Hoisted.mappingSer, value.mapping)
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

    public val defaultValueAvailabilitySer: KSerializer<Availability> = Availability.serializer()

    public val defaultValueExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val defaultValueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val defaultValueMetaSer: KSerializer<Meta> = Meta.serializer()

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
