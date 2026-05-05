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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.OperationDefinition
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.BindingStrength
import dev.ohs.fhir.model.r4b.terminologies.FHIRAllTypes
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object OperationDefinitionParameterSerializer :
  KSerializer<OperationDefinition.Parameter> {
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
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", Element.serializer().descriptor, isOptional = true)
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", Element.serializer().descriptor, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
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
      element("searchType", KotlinString.serializer().descriptor, isOptional = true)
      element("_searchType", Element.serializer().descriptor, isOptional = true)
      element(
        "binding",
        lazyDescriptor { OperationDefinition.Parameter.Binding.serializer().descriptor },
        isOptional = true,
      )
      element(
        "referencedFrom",
        listSerialDescriptor(
          lazyDescriptor { OperationDefinition.Parameter.ReferencedFrom.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "part",
        listSerialDescriptor(
          lazyDescriptor { OperationDefinition.Parameter.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): OperationDefinition.Parameter {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var targetProfile: List<KotlinString?>? = null
    var _targetProfile: List<Element?>? = null
    var searchType: KotlinString? = null
    var _searchType: Element? = null
    var binding: OperationDefinition.Parameter.Binding? = null
    var referencedFrom: List<OperationDefinition.Parameter.ReferencedFrom>? = null
    var part: List<OperationDefinition.Parameter>? = null
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
        5 -> use = decoder.decodeStringElement(__desc, __i)
        6 -> _use = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        7 -> min = decoder.decodeIntElement(__desc, __i)
        8 -> _min = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        9 -> max = decoder.decodeStringElement(__desc, __i)
        10 -> _max = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        11 -> documentation = decoder.decodeStringElement(__desc, __i)
        12 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        13 -> type = decoder.decodeStringElement(__desc, __i)
        14 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        15 ->
          targetProfile =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetProfileSer, null)
        16 ->
          _targetProfile =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetProfileSer2, null)
        17 -> searchType = decoder.decodeStringElement(__desc, __i)
        18 ->
          _searchType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        19 ->
          binding = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.bindingSer, null)
        20 ->
          referencedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referencedFromSer, null)
        21 -> part = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return OperationDefinition.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Code.of(name, _name)!!,
      use = Enumeration.of(OperationDefinition.OperationParameterUse.fromCode(use!!), _use),
      min = Integer.of(min, _min)!!,
      max = R4bString.of(max, _max)!!,
      documentation = R4bString.of(documentation, _documentation),
      type = type?.let { Enumeration.of(FHIRAllTypes.fromCode(it), _type) },
      targetProfile =
        (kotlin.collections.List(maxOf(targetProfile?.size ?: 0, _targetProfile?.size ?: 0)) { __i
          ->
          Canonical.of(targetProfile?.getOrNull(__i)?.let { it }, _targetProfile?.getOrNull(__i))!!
        }),
      searchType = searchType?.let { Enumeration.of(SearchParamType.fromCode(it), _searchType) },
      binding = binding,
      referencedFrom = referencedFrom ?: listOf(),
      part = part ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: OperationDefinition.Parameter) {
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
    ((value.use.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    ((value.min.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.min.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
    }
    ((value.max.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.max.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.nameSer, it)
    }
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.nameSer, it)
    }
    (value.targetProfile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.targetProfileSer, it)
    }
    (value.targetProfile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.targetProfileSer2, it)
    }
    ((value.searchType?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.searchType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.nameSer, it)
    }
    (value.binding)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.bindingSer, it) }
    if (value.referencedFrom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.referencedFromSer, value.referencedFrom)
    if (value.part.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.partSer, value.part)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val targetProfileSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val targetProfileSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.targetProfileSerInner).nullable)

    public val targetProfileSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.nameSer).nullable)

    public val bindingSer: KSerializer<OperationDefinition.Parameter.Binding> =
      OperationDefinition.Parameter.Binding.serializer()

    public val referencedFromSerInner: KSerializer<OperationDefinition.Parameter.ReferencedFrom> =
      OperationDefinition.Parameter.ReferencedFrom.serializer()

    public val referencedFromSer: KSerializer<List<OperationDefinition.Parameter.ReferencedFrom>> =
      ListSerializer(Hoisted.referencedFromSerInner)

    public val partSerInner: KSerializer<OperationDefinition.Parameter> =
      OperationDefinition.Parameter.serializer()

    public val partSer: KSerializer<List<OperationDefinition.Parameter>> =
      ListSerializer(Hoisted.partSerInner)
  }
}

internal object OperationDefinitionParameterBindingSerializer :
  KSerializer<OperationDefinition.Parameter.Binding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Binding") {
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
      element("strength", KotlinString.serializer().descriptor, isOptional = true)
      element("_strength", Element.serializer().descriptor, isOptional = true)
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.Binding =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.Binding) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): OperationDefinition.Parameter.Binding {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var strength: KotlinString? = null
    var _strength: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> strength = decoder.decodeStringElement(__desc, __i)
        4 ->
          _strength =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.strengthSer, null)
        5 -> valueSet = decoder.decodeStringElement(__desc, __i)
        6 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Binding: " + __i)
      }
    }
    return OperationDefinition.Parameter.Binding(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      strength = Enumeration.of(BindingStrength.fromCode(strength!!), _strength),
      valueSet = Canonical.of(valueSet, _valueSet)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: OperationDefinition.Parameter.Binding,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.strength.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.strength.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.strengthSer, it)
    }
    ((value.valueSet.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.valueSet.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.strengthSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val strengthSer: KSerializer<Element> = Element.serializer()
  }
}

internal object OperationDefinitionParameterReferencedFromSerializer :
  KSerializer<OperationDefinition.Parameter.ReferencedFrom> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferencedFrom") {
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
      element("source", KotlinString.serializer().descriptor, isOptional = true)
      element("_source", Element.serializer().descriptor, isOptional = true)
      element("sourceId", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceId", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.ReferencedFrom =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.ReferencedFrom) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): OperationDefinition.Parameter.ReferencedFrom {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> source = decoder.decodeStringElement(__desc, __i)
        4 ->
          _source = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        5 -> sourceId = decoder.decodeStringElement(__desc, __i)
        6 ->
          _sourceId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferencedFrom: " + __i)
      }
    }
    return OperationDefinition.Parameter.ReferencedFrom(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      source = R4bString.of(source, _source)!!,
      sourceId = R4bString.of(sourceId, _sourceId),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: OperationDefinition.Parameter.ReferencedFrom,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.source.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.source.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sourceSer, it)
    }
    ((value.sourceId?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.sourceId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.sourceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sourceSer: KSerializer<Element> = Element.serializer()
  }
}

internal object OperationDefinitionOverloadSerializer : KSerializer<OperationDefinition.Overload> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Overload") {
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
      element(
        "parameterName",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_parameterName",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): OperationDefinition.Overload =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Overload) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): OperationDefinition.Overload {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var parameterName: List<KotlinString?>? = null
    var _parameterName: List<Element?>? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          parameterName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parameterNameSer, null)
        4 ->
          _parameterName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parameterNameSer2, null)
        5 -> comment = decoder.decodeStringElement(__desc, __i)
        6 ->
          _comment =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.parameterNameSerInner2,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Overload: " + __i)
      }
    }
    return OperationDefinition.Overload(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      parameterName =
        (kotlin.collections.List(maxOf(parameterName?.size ?: 0, _parameterName?.size ?: 0)) { __i
          ->
          R4bString.of(parameterName?.getOrNull(__i)?.let { it }, _parameterName?.getOrNull(__i))!!
        }),
      comment = R4bString.of(comment, _comment),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: OperationDefinition.Overload) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.parameterName.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.parameterNameSer, it)
    }
    (value.parameterName.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.parameterNameSer2, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.parameterNameSerInner2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val parameterNameSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val parameterNameSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.parameterNameSerInner).nullable)

    public val parameterNameSerInner2: KSerializer<Element> = Element.serializer()

    public val parameterNameSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.parameterNameSerInner2).nullable)
  }
}

internal object OperationDefinitionSerializer : KSerializer<OperationDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OperationDefinition") {
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
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("kind", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_kind", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("affectsState", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_affectsState", Element.serializer().descriptor, isOptional = true)
    b.element("code", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_code", Element.serializer().descriptor, isOptional = true)
    b.element("comment", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_comment", Element.serializer().descriptor, isOptional = true)
    b.element("base", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_base", Element.serializer().descriptor, isOptional = true)
    b.element(
      "resource",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_resource", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("system", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_system", Element.serializer().descriptor, isOptional = true)
    b.element("type", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("instance", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_instance", Element.serializer().descriptor, isOptional = true)
    b.element("inputProfile", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_inputProfile", Element.serializer().descriptor, isOptional = true)
    b.element("outputProfile", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outputProfile", Element.serializer().descriptor, isOptional = true)
    b.element(
      "parameter",
      listSerialDescriptor(
        lazyDescriptor { OperationDefinition.Parameter.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "overload",
      listSerialDescriptor(lazyDescriptor { OperationDefinition.Overload.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): OperationDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "OperationDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): OperationDefinition {
    val __desc = desc
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
    var url: KotlinString? = null
    var _url: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var affectsState: KotlinBoolean? = null
    var _affectsState: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var base: KotlinString? = null
    var _base: Element? = null
    var resource: List<KotlinString?>? = null
    var _resource: List<Element?>? = null
    var system: KotlinBoolean? = null
    var _system: Element? = null
    var type: KotlinBoolean? = null
    var _type: Element? = null
    var instance: KotlinBoolean? = null
    var _instance: Element? = null
    var inputProfile: KotlinString? = null
    var _inputProfile: Element? = null
    var outputProfile: KotlinString? = null
    var _outputProfile: Element? = null
    var parameter: List<OperationDefinition.Parameter>? = null
    var overload: List<OperationDefinition.Overload>? = null
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
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 -> url = decoder.decodeStringElement(__desc, __i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        12 -> version = decoder.decodeStringElement(__desc, __i)
        13 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 -> name = decoder.decodeStringElement(__desc, __i)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 -> title = decoder.decodeStringElement(__desc, __i)
        17 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 -> status = decoder.decodeStringElement(__desc, __i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> kind = decoder.decodeStringElement(__desc, __i)
        21 ->
          _kind =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> experimental = decoder.decodeBooleanElement(__desc, __i)
        23 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 -> date = decoder.decodeStringElement(__desc, __i)
        25 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        26 -> publisher = decoder.decodeStringElement(__desc, __i)
        27 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        29 -> description = decoder.decodeStringElement(__desc, __i)
        30 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        31 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useContextSer, null)
        32 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        33 -> purpose = decoder.decodeStringElement(__desc, __i)
        34 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        35 -> affectsState = decoder.decodeBooleanElement(__desc, __i)
        36 ->
          _affectsState =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        37 -> code = decoder.decodeStringElement(__desc, __i)
        38 ->
          _code =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        39 -> comment = decoder.decodeStringElement(__desc, __i)
        40 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        41 -> base = decoder.decodeStringElement(__desc, __i)
        42 ->
          _base =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        43 ->
          resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resourceSer, null)
        44 ->
          _resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resourceSer2, null)
        45 -> system = decoder.decodeBooleanElement(__desc, __i)
        46 ->
          _system =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        47 -> type = decoder.decodeBooleanElement(__desc, __i)
        48 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        49 -> instance = decoder.decodeBooleanElement(__desc, __i)
        50 ->
          _instance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        51 -> inputProfile = decoder.decodeStringElement(__desc, __i)
        52 ->
          _inputProfile =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        53 -> outputProfile = decoder.decodeStringElement(__desc, __i)
        54 ->
          _outputProfile =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        55 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parameterSer, null)
        56 ->
          overload =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.overloadSer, null)
        else ->
          throw SerializationException("Unexpected index decoding OperationDefinition: " + __i)
      }
    }
    return OperationDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name)!!,
      title = R4bString.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      kind = Enumeration.of(OperationDefinition.OperationKind.fromCode(kind!!), _kind),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      affectsState = R4bBoolean.of(affectsState, _affectsState),
      code = Code.of(code, _code)!!,
      comment = Markdown.of(comment, _comment),
      base = Canonical.of(base, _base),
      resource =
        (kotlin.collections.List(maxOf(resource?.size ?: 0, _resource?.size ?: 0)) { __i ->
          Enumeration.of(
            ResourceType.fromCode(resource?.getOrNull(__i)!!),
            _resource?.getOrNull(__i),
          )
        }),
      system = R4bBoolean.of(system, _system)!!,
      type = R4bBoolean.of(type, _type)!!,
      instance = R4bBoolean.of(instance, _instance)!!,
      inputProfile = Canonical.of(inputProfile, _inputProfile),
      outputProfile = Canonical.of(outputProfile, _outputProfile),
      parameter = parameter ?: listOf(),
      overload = overload ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: OperationDefinition,
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
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 16 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.kind.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 22 + __off, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 26 + __off, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 29 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        32 + __off,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 33 + __off, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.affectsState?.value))?.let { encoder.encodeBooleanElement(__desc, 35 + __off, it) }
    (value.affectsState?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.code.value))?.let { encoder.encodeStringElement(__desc, 37 + __off, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 39 + __off, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.base?.value))?.let { encoder.encodeStringElement(__desc, 41 + __off, it) }
    (value.base?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.resource.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.resourceSer, it)
    }
    (value.resource.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.resourceSer2, it)
    }
    ((value.system.value))?.let { encoder.encodeBooleanElement(__desc, 45 + __off, it) }
    (value.system.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.type.value))?.let { encoder.encodeBooleanElement(__desc, 47 + __off, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 48 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.instance.value))?.let { encoder.encodeBooleanElement(__desc, 49 + __off, it) }
    (value.instance.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 50 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.inputProfile?.value))?.let { encoder.encodeStringElement(__desc, 51 + __off, it) }
    (value.inputProfile?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 52 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.outputProfile?.value))?.let { encoder.encodeStringElement(__desc, 53 + __off, it) }
    (value.outputProfile?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 54 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 55 + __off, Hoisted.parameterSer, value.parameter)
    if (value.overload.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 56 + __off, Hoisted.overloadSer, value.overload)
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val resourceSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val resourceSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.resourceSerInner).nullable)

    public val resourceSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val parameterSerInner: KSerializer<OperationDefinition.Parameter> =
      OperationDefinition.Parameter.serializer()

    public val parameterSer: KSerializer<List<OperationDefinition.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)

    public val overloadSerInner: KSerializer<OperationDefinition.Overload> =
      OperationDefinition.Overload.serializer()

    public val overloadSer: KSerializer<List<OperationDefinition.Overload>> =
      ListSerializer(Hoisted.overloadSerInner)
  }
}

internal object OperationDefinitionPolymorphicSerializer : KSerializer<OperationDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OperationDefinition") {
      OperationDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition) {
    encoder.encodeStructure(descriptor) {
      OperationDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): OperationDefinition =
    decoder.decodeStructure(descriptor) {
      OperationDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
