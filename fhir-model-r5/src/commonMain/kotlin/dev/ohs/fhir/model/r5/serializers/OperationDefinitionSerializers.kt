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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.OperationDefinition
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.BindingStrength
import dev.ohs.fhir.model.r5.terminologies.FHIRTypes
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
      element(
        "scope",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_scope", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", Element.serializer().descriptor, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element(
        "allowedType",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_allowedType",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
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

  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): OperationDefinition.Parameter {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var scope: List<KotlinString?>? = null
    var _scope: List<Element?>? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var allowedType: List<KotlinString?>? = null
    var _allowedType: List<Element?>? = null
    var targetProfile: List<KotlinString?>? = null
    var _targetProfile: List<Element?>? = null
    var searchType: KotlinString? = null
    var _searchType: Element? = null
    var binding: OperationDefinition.Parameter.Binding? = null
    var referencedFrom: List<OperationDefinition.Parameter.ReferencedFrom>? = null
    var part: List<OperationDefinition.Parameter>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> use = decoder.decodeStringElement(descriptor, i)
        6 ->
          _use = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 ->
          scope =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        8 ->
          _scope =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 -> min = decoder.decodeIntElement(descriptor, i)
        10 ->
          _min = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 -> max = decoder.decodeStringElement(descriptor, i)
        12 ->
          _max = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> documentation = decoder.decodeStringElement(descriptor, i)
        14 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> type = decoder.decodeStringElement(descriptor, i)
        16 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          allowedType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        18 ->
          _allowedType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        19 ->
          targetProfile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        20 ->
          _targetProfile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        21 -> searchType = decoder.decodeStringElement(descriptor, i)
        22 ->
          _searchType =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          binding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterBindingSerializer,
              null,
            )
        24 ->
          referencedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterReferencedFromSerializer.listSerializer,
              null,
            )
        25 ->
          part =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    return OperationDefinition.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        Code.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on OperationDefinition.Parameter"
          ),
      use =
        Enumeration.of(use?.let { OperationDefinition.OperationParameterUse.fromCode(it) }, _use)
          ?: throw SerializationException(
            "Missing required property 'use' on OperationDefinition.Parameter"
          ),
      scope =
        (kotlin.collections.List(maxOf(scope?.size ?: 0, _scope?.size ?: 0)) { index ->
          Enumeration.of(
            scope?.getOrNull(index)?.let {
              OperationDefinition.OperationParameterScope.fromCode(it)
            },
            _scope?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'scope' on OperationDefinition.Parameter has neither a value nor an id/extension"
            )
        }),
      min =
        Integer.of(min, _min)
          ?: throw SerializationException(
            "Missing required property 'min' on OperationDefinition.Parameter"
          ),
      max =
        R5String.of(max, _max)
          ?: throw SerializationException(
            "Missing required property 'max' on OperationDefinition.Parameter"
          ),
      documentation = Markdown.of(documentation, _documentation),
      type = Enumeration.of(type?.let { FHIRTypes.fromCode(it) }, _type),
      allowedType =
        (kotlin.collections.List(maxOf(allowedType?.size ?: 0, _allowedType?.size ?: 0)) { index ->
          Enumeration.of(
            allowedType?.getOrNull(index)?.let { FHIRTypes.fromCode(it) },
            _allowedType?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'allowedType' on OperationDefinition.Parameter has neither a value nor an id/extension"
            )
        }),
      targetProfile =
        (kotlin.collections.List(maxOf(targetProfile?.size ?: 0, _targetProfile?.size ?: 0)) { index
          ->
          Canonical.of(
            targetProfile?.getOrNull(index)?.let { it },
            _targetProfile?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'targetProfile' on OperationDefinition.Parameter has neither a value nor an id/extension"
            )
        }),
      searchType = Enumeration.of(searchType?.let { SearchParamType.fromCode(it) }, _searchType),
      binding = binding,
      referencedFrom = referencedFrom ?: listOf(),
      part = part ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: OperationDefinition.Parameter) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.use.value?.code))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    (value.scope.map { it.value?.code }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, stringNullableListSerializer, it)
    }
    (value.scope.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer.nullableListSerializer, it)
    }
    ((value.min.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
    (value.min.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
    ((value.max.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.max.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, ElementSerializer, it)
    }
    ((value.type?.value?.code))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, ElementSerializer, it)
    }
    (value.allowedType.map { it.value?.code }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 17, stringNullableListSerializer, it)
    }
    (value.allowedType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.targetProfile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 19, stringNullableListSerializer, it)
    }
    (value.targetProfile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    ((value.searchType?.value?.code))?.let { encoder.encodeStringElement(descriptor, 21, it) }
    (value.searchType?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 22, ElementSerializer, it)
    }
    (value.binding)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23,
        OperationDefinitionParameterBindingSerializer,
        it,
      )
    }
    if (value.referencedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24,
        OperationDefinitionParameterReferencedFromSerializer.listSerializer,
        value.referencedFrom,
      )
    if (value.part.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25,
        OperationDefinitionParameterSerializer.listSerializer,
        value.part,
      )
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

  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter.Binding>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.Binding =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.Binding) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): OperationDefinition.Parameter.Binding {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var strength: KotlinString? = null
    var _strength: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> strength = decoder.decodeStringElement(descriptor, i)
        4 ->
          _strength =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> valueSet = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Binding: " + i)
      }
    }
    return OperationDefinition.Parameter.Binding(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      strength =
        Enumeration.of(strength?.let { BindingStrength.fromCode(it) }, _strength)
          ?: throw SerializationException(
            "Missing required property 'strength' on OperationDefinition.Parameter.Binding"
          ),
      valueSet =
        Canonical.of(valueSet, _valueSet)
          ?: throw SerializationException(
            "Missing required property 'valueSet' on OperationDefinition.Parameter.Binding"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: OperationDefinition.Parameter.Binding,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.strength.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.strength.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.valueSet.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.valueSet.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter.ReferencedFrom>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.ReferencedFrom =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.ReferencedFrom) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): OperationDefinition.Parameter.ReferencedFrom {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> source = decoder.decodeStringElement(descriptor, i)
        4 ->
          _source =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> sourceId = decoder.decodeStringElement(descriptor, i)
        6 ->
          _sourceId =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferencedFrom: " + i)
      }
    }
    return OperationDefinition.Parameter.ReferencedFrom(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      source =
        R5String.of(source, _source)
          ?: throw SerializationException(
            "Missing required property 'source' on OperationDefinition.Parameter.ReferencedFrom"
          ),
      sourceId = R5String.of(sourceId, _sourceId),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: OperationDefinition.Parameter.ReferencedFrom,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.source.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.source.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.sourceId?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.sourceId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<OperationDefinition.Overload>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationDefinition.Overload =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Overload) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): OperationDefinition.Overload {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var parameterName: List<KotlinString?>? = null
    var _parameterName: List<Element?>? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          parameterName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        4 ->
          _parameterName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 -> comment = decoder.decodeStringElement(descriptor, i)
        6 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Overload: " + i)
      }
    }
    return OperationDefinition.Overload(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      parameterName =
        (kotlin.collections.List(maxOf(parameterName?.size ?: 0, _parameterName?.size ?: 0)) { index
          ->
          R5String.of(parameterName?.getOrNull(index)?.let { it }, _parameterName?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'parameterName' on OperationDefinition.Overload has neither a value nor an id/extension"
            )
        }),
      comment = R5String.of(comment, _comment),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: OperationDefinition.Overload) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.parameterName.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, stringNullableListSerializer, it)
    }
    (value.parameterName.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer.nullableListSerializer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
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
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "OperationDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): OperationDefinition {
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
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
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
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> kind = decoder.decodeStringElement(descriptor, i)
        25 ->
          _kind = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> date = decoder.decodeStringElement(descriptor, i)
        29 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> publisher = decoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 -> description = decoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        37 -> purpose = decoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> copyright = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        42 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 -> affectsState = decoder.decodeBooleanElement(descriptor, i)
        44 ->
          _affectsState =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 -> code = decoder.decodeStringElement(descriptor, i)
        46 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 -> comment = decoder.decodeStringElement(descriptor, i)
        48 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        49 -> base = decoder.decodeStringElement(descriptor, i)
        50 ->
          _base = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        51 ->
          resource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        52 ->
          _resource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        53 -> system = decoder.decodeBooleanElement(descriptor, i)
        54 ->
          _system =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        55 -> type = decoder.decodeBooleanElement(descriptor, i)
        56 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        57 -> instance = decoder.decodeBooleanElement(descriptor, i)
        58 ->
          _instance =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        59 -> inputProfile = decoder.decodeStringElement(descriptor, i)
        60 ->
          _inputProfile =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        61 -> outputProfile = decoder.decodeStringElement(descriptor, i)
        62 ->
          _outputProfile =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        63 ->
          parameter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterSerializer.listSerializer,
              null,
            )
        64 ->
          overload =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionOverloadSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding OperationDefinition: " + i)
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
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        OperationDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on OperationDefinition"
          ),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on OperationDefinition"
          ),
      kind =
        Enumeration.of(kind?.let { OperationDefinition.OperationKind.fromCode(it) }, _kind)
          ?: throw SerializationException(
            "Missing required property 'kind' on OperationDefinition"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      affectsState = R5Boolean.of(affectsState, _affectsState),
      code =
        Code.of(code, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on OperationDefinition"
          ),
      comment = Markdown.of(comment, _comment),
      base = Canonical.of(base, _base),
      resource =
        (kotlin.collections.List(maxOf(resource?.size ?: 0, _resource?.size ?: 0)) { index ->
          Enumeration.of(
            resource?.getOrNull(index)?.let {
              OperationDefinition.VersionIndependentResourceTypesAll.fromCode(it)
            },
            _resource?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'resource' on OperationDefinition has neither a value nor an id/extension"
            )
        }),
      system =
        R5Boolean.of(system, _system)
          ?: throw SerializationException(
            "Missing required property 'system' on OperationDefinition"
          ),
      type =
        R5Boolean.of(type, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on OperationDefinition"
          ),
      instance =
        R5Boolean.of(instance, _instance)
          ?: throw SerializationException(
            "Missing required property 'instance' on OperationDefinition"
          ),
      inputProfile = Canonical.of(inputProfile, _inputProfile),
      outputProfile = Canonical.of(outputProfile, _outputProfile),
      parameter = parameter ?: listOf(),
      overload = overload ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: OperationDefinition,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, ElementSerializer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ElementSerializer, it)
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is OperationDefinition.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
      is OperationDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, ElementSerializer, it)
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, ElementSerializer, it)
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ElementSerializer, it)
    }
    ((value.kind.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, ElementSerializer, it)
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, ElementSerializer, it)
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, ElementSerializer, it)
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 31 + descriptorOffset, ElementSerializer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 34 + descriptorOffset, ElementSerializer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, ElementSerializer, it)
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 40 + descriptorOffset, ElementSerializer, it)
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 42 + descriptorOffset, ElementSerializer, it)
    }
    ((value.affectsState?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.affectsState?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 44 + descriptorOffset, ElementSerializer, it)
    }
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 45 + descriptorOffset, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 46 + descriptorOffset, ElementSerializer, it)
    }
    ((value.comment?.value))?.let {
      encoder.encodeStringElement(descriptor, 47 + descriptorOffset, it)
    }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 48 + descriptorOffset, ElementSerializer, it)
    }
    ((value.base?.value))?.let {
      encoder.encodeStringElement(descriptor, 49 + descriptorOffset, it)
    }
    (value.base?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 50 + descriptorOffset, ElementSerializer, it)
    }
    (value.resource.map { it.value?.code }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.resource.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    ((value.system.value))?.let {
      encoder.encodeBooleanElement(descriptor, 53 + descriptorOffset, it)
    }
    (value.system.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 54 + descriptorOffset, ElementSerializer, it)
    }
    ((value.type.value))?.let {
      encoder.encodeBooleanElement(descriptor, 55 + descriptorOffset, it)
    }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 56 + descriptorOffset, ElementSerializer, it)
    }
    ((value.instance.value))?.let {
      encoder.encodeBooleanElement(descriptor, 57 + descriptorOffset, it)
    }
    (value.instance.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 58 + descriptorOffset, ElementSerializer, it)
    }
    ((value.inputProfile?.value))?.let {
      encoder.encodeStringElement(descriptor, 59 + descriptorOffset, it)
    }
    (value.inputProfile?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 60 + descriptorOffset, ElementSerializer, it)
    }
    ((value.outputProfile?.value))?.let {
      encoder.encodeStringElement(descriptor, 61 + descriptorOffset, it)
    }
    (value.outputProfile?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 62 + descriptorOffset, ElementSerializer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        OperationDefinitionParameterSerializer.listSerializer,
        value.parameter,
      )
    if (value.overload.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        64 + descriptorOffset,
        OperationDefinitionOverloadSerializer.listSerializer,
        value.overload,
      )
  }
}

internal object OperationDefinitionPolymorphicSerializer : KSerializer<OperationDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OperationDefinition") {
      OperationDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition) {
    encoder.encodeStructure(descriptor) {
      OperationDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): OperationDefinition =
    decoder.decodeStructure(descriptor) {
      OperationDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
