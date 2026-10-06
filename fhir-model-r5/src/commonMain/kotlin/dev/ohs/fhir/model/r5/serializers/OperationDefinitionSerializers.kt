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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("use", KotlinString.serializer().descriptor)
      optionalElement("_use", ElementSerializer.descriptor)
      optionalElement("scope", stringNullableListSerializer.descriptor)
      optionalElement("_scope", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("min", Int.serializer().descriptor)
      optionalElement("_min", ElementSerializer.descriptor)
      optionalElement("max", KotlinString.serializer().descriptor)
      optionalElement("_max", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("allowedType", stringNullableListSerializer.descriptor)
      optionalElement("_allowedType", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("targetProfile", stringNullableListSerializer.descriptor)
      optionalElement("_targetProfile", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("searchType", KotlinString.serializer().descriptor)
      optionalElement("_searchType", ElementSerializer.descriptor)
      optionalElement("binding", OperationDefinitionParameterBindingSerializer.descriptor)
      optionalElement(
        "referencedFrom",
        OperationDefinitionParameterReferencedFromSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "part",
        listSerialDescriptor(lazyDescriptor { OperationDefinitionParameterSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter =
    decoder.decodeStructure(descriptor) {
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> use = decodeStringElement(descriptor, i)
          6 -> _use = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            scope =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          8 ->
            _scope =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 -> min = decodeIntElement(descriptor, i)
          10 -> _min = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> max = decodeStringElement(descriptor, i)
          12 -> _max = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> documentation = decodeStringElement(descriptor, i)
          14 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> type = decodeStringElement(descriptor, i)
          16 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 ->
            allowedType =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          18 ->
            _allowedType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          19 ->
            targetProfile =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          20 ->
            _targetProfile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          21 -> searchType = decodeStringElement(descriptor, i)
          22 ->
            _searchType = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          23 ->
            binding =
              decodeNullableSerializableElement(
                descriptor,
                i,
                OperationDefinitionParameterBindingSerializer,
                null,
              )
          24 ->
            referencedFrom =
              decodeNullableSerializableElement(
                descriptor,
                i,
                OperationDefinitionParameterReferencedFromSerializer.listSerializer,
                null,
              )
          25 ->
            part =
              decodeNullableSerializableElement(
                descriptor,
                i,
                OperationDefinitionParameterSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      OperationDefinition.Parameter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          Code.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on OperationDefinition.Parameter"
            ),
        use =
          Enumeration.of(
            if (use != null) OperationDefinition.OperationParameterUse.fromCode(use) else null,
            _use,
          )
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
        type = Enumeration.of(if (type != null) FHIRTypes.fromCode(type) else null, _type),
        allowedType =
          (kotlin.collections.List(maxOf(allowedType?.size ?: 0, _allowedType?.size ?: 0)) { index
            ->
            Enumeration.of(
              allowedType?.getOrNull(index)?.let { FHIRTypes.fromCode(it) },
              _allowedType?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'allowedType' on OperationDefinition.Parameter has neither a value nor an id/extension"
              )
          }),
        targetProfile =
          (kotlin.collections.List(maxOf(targetProfile?.size ?: 0, _targetProfile?.size ?: 0)) {
            index ->
            Canonical.of(targetProfile?.getOrNull(index), _targetProfile?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'targetProfile' on OperationDefinition.Parameter has neither a value nor an id/extension"
              )
          }),
        searchType =
          Enumeration.of(
            if (searchType != null) SearchParamType.fromCode(searchType) else null,
            _searchType,
          ),
        binding = binding,
        referencedFrom = referencedFrom ?: listOf(),
        part = part ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter) {
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
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.use.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.use)
      if (value.scope.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          stringNullableListSerializer,
          value.scope.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 8, value.scope)
      }
      encodeIntIfNotNull(descriptor, 9, value.min.value)
      encodeElementIfNotNull(descriptor, 10, value.min)
      encodeStringIfNotNull(descriptor, 11, value.max.value)
      encodeElementIfNotNull(descriptor, 12, value.max)
      encodeStringIfNotNull(descriptor, 13, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 14, value.documentation)
      encodeStringIfNotNull(descriptor, 15, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 16, value.type)
      if (value.allowedType.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          17,
          stringNullableListSerializer,
          value.allowedType.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 18, value.allowedType)
      }
      if (value.targetProfile.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          19,
          stringNullableListSerializer,
          value.targetProfile.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 20, value.targetProfile)
      }
      encodeStringIfNotNull(descriptor, 21, value.searchType?.value?.code)
      encodeElementIfNotNull(descriptor, 22, value.searchType)
      encodeSerializableIfNotNull(
        descriptor,
        23,
        OperationDefinitionParameterBindingSerializer,
        value.binding,
      )
      if (value.referencedFrom.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          24,
          OperationDefinitionParameterReferencedFromSerializer.listSerializer,
          value.referencedFrom,
        )
      if (value.part.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          25,
          OperationDefinitionParameterSerializer.listSerializer,
          value.part,
        )
    }
  }
}

internal object OperationDefinitionParameterBindingSerializer :
  KSerializer<OperationDefinition.Parameter.Binding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Binding") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("strength", KotlinString.serializer().descriptor)
      optionalElement("_strength", ElementSerializer.descriptor)
      optionalElement("valueSet", KotlinString.serializer().descriptor)
      optionalElement("_valueSet", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter.Binding>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.Binding =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var strength: KotlinString? = null
      var _strength: Element? = null
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
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> strength = decodeStringElement(descriptor, i)
          4 -> _strength = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> valueSet = decodeStringElement(descriptor, i)
          6 -> _valueSet = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Binding: " + i)
        }
      }
      OperationDefinition.Parameter.Binding(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        strength =
          Enumeration.of(
            if (strength != null) BindingStrength.fromCode(strength) else null,
            _strength,
          )
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

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.Binding) {
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
      encodeStringIfNotNull(descriptor, 3, value.strength.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.strength)
      encodeStringIfNotNull(descriptor, 5, value.valueSet.value)
      encodeElementIfNotNull(descriptor, 6, value.valueSet)
    }
  }
}

internal object OperationDefinitionParameterReferencedFromSerializer :
  KSerializer<OperationDefinition.Parameter.ReferencedFrom> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferencedFrom") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("source", KotlinString.serializer().descriptor)
      optionalElement("_source", ElementSerializer.descriptor)
      optionalElement("sourceId", KotlinString.serializer().descriptor)
      optionalElement("_sourceId", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter.ReferencedFrom>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.ReferencedFrom =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var source: KotlinString? = null
      var _source: Element? = null
      var sourceId: KotlinString? = null
      var _sourceId: Element? = null
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
          3 -> source = decodeStringElement(descriptor, i)
          4 -> _source = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> sourceId = decodeStringElement(descriptor, i)
          6 -> _sourceId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ReferencedFrom: " + i)
        }
      }
      OperationDefinition.Parameter.ReferencedFrom(
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

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.ReferencedFrom) {
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
      encodeStringIfNotNull(descriptor, 3, value.source.value)
      encodeElementIfNotNull(descriptor, 4, value.source)
      encodeStringIfNotNull(descriptor, 5, value.sourceId?.value)
      encodeElementIfNotNull(descriptor, 6, value.sourceId)
    }
  }
}

internal object OperationDefinitionOverloadSerializer : KSerializer<OperationDefinition.Overload> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Overload") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("parameterName", stringNullableListSerializer.descriptor)
      optionalElement("_parameterName", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("comment", KotlinString.serializer().descriptor)
      optionalElement("_comment", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<OperationDefinition.Overload>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationDefinition.Overload =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var parameterName: List<KotlinString?>? = null
      var _parameterName: List<Element?>? = null
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
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            parameterName =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          4 ->
            _parameterName =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          5 -> comment = decodeStringElement(descriptor, i)
          6 -> _comment = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Overload: " + i)
        }
      }
      OperationDefinition.Overload(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        parameterName =
          (kotlin.collections.List(maxOf(parameterName?.size ?: 0, _parameterName?.size ?: 0)) {
            index ->
            R5String.of(parameterName?.getOrNull(index), _parameterName?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'parameterName' on OperationDefinition.Overload has neither a value nor an id/extension"
              )
          }),
        comment = R5String.of(comment, _comment),
      )
    }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Overload) {
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
      if (value.parameterName.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          3,
          stringNullableListSerializer,
          value.parameterName.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 4, value.parameterName)
      }
      encodeStringIfNotNull(descriptor, 5, value.comment?.value)
      encodeElementIfNotNull(descriptor, 6, value.comment)
    }
  }
}

internal object OperationDefinitionSerializer : FhirResourceSerializer<OperationDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("OperationDefinition")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("kind", KotlinString.serializer().descriptor)
    b.optionalElement("_kind", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
    b.optionalElement("affectsState", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_affectsState", ElementSerializer.descriptor)
    b.optionalElement("code", KotlinString.serializer().descriptor)
    b.optionalElement("_code", ElementSerializer.descriptor)
    b.optionalElement("comment", KotlinString.serializer().descriptor)
    b.optionalElement("_comment", ElementSerializer.descriptor)
    b.optionalElement("base", KotlinString.serializer().descriptor)
    b.optionalElement("_base", ElementSerializer.descriptor)
    b.optionalElement("resource", stringNullableListSerializer.descriptor)
    b.optionalElement("_resource", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("system", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_system", ElementSerializer.descriptor)
    b.optionalElement("type", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("instance", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_instance", ElementSerializer.descriptor)
    b.optionalElement("inputProfile", KotlinString.serializer().descriptor)
    b.optionalElement("_inputProfile", ElementSerializer.descriptor)
    b.optionalElement("outputProfile", KotlinString.serializer().descriptor)
    b.optionalElement("_outputProfile", ElementSerializer.descriptor)
    b.optionalElement("parameter", OperationDefinitionParameterSerializer.listSerializer.descriptor)
    b.optionalElement("overload", OperationDefinitionOverloadSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on OperationDefinition"
          ),
      kind =
        Enumeration.of(
          if (kind != null) OperationDefinition.OperationKind.fromCode(kind) else null,
          _kind,
        )
          ?: throw SerializationException(
            "Missing required property 'kind' on OperationDefinition"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: OperationDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is OperationDefinition.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
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
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.kind.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.kind)
    encoder.encodeBooleanIfNotNull(descriptor, 26 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.description)
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
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyrightLabel)
    encoder.encodeBooleanIfNotNull(descriptor, 43 + descriptorOffset, value.affectsState?.value)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.affectsState)
    encoder.encodeStringIfNotNull(descriptor, 45 + descriptorOffset, value.code.value)
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.code)
    encoder.encodeStringIfNotNull(descriptor, 47 + descriptorOffset, value.comment?.value)
    encoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.comment)
    encoder.encodeStringIfNotNull(descriptor, 49 + descriptorOffset, value.base?.value)
    encoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.base)
    if (value.resource.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        51 + descriptorOffset,
        stringNullableListSerializer,
        value.resource.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 52 + descriptorOffset, value.resource)
    }
    encoder.encodeBooleanIfNotNull(descriptor, 53 + descriptorOffset, value.system.value)
    encoder.encodeElementIfNotNull(descriptor, 54 + descriptorOffset, value.system)
    encoder.encodeBooleanIfNotNull(descriptor, 55 + descriptorOffset, value.type.value)
    encoder.encodeElementIfNotNull(descriptor, 56 + descriptorOffset, value.type)
    encoder.encodeBooleanIfNotNull(descriptor, 57 + descriptorOffset, value.instance.value)
    encoder.encodeElementIfNotNull(descriptor, 58 + descriptorOffset, value.instance)
    encoder.encodeStringIfNotNull(descriptor, 59 + descriptorOffset, value.inputProfile?.value)
    encoder.encodeElementIfNotNull(descriptor, 60 + descriptorOffset, value.inputProfile)
    encoder.encodeStringIfNotNull(descriptor, 61 + descriptorOffset, value.outputProfile?.value)
    encoder.encodeElementIfNotNull(descriptor, 62 + descriptorOffset, value.outputProfile)
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
