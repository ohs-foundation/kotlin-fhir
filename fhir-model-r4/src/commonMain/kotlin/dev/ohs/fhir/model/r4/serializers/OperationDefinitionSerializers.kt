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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.OperationDefinition
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.BindingStrength
import dev.ohs.fhir.model.r4.terminologies.FHIRAllTypes
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
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
      optionalElement("min", Int.serializer().descriptor)
      optionalElement("_min", ElementSerializer.descriptor)
      optionalElement("max", KotlinString.serializer().descriptor)
      optionalElement("_max", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
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
          7 -> min = decodeIntElement(descriptor, i)
          8 -> _min = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> max = decodeStringElement(descriptor, i)
          10 -> _max = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> documentation = decodeStringElement(descriptor, i)
          12 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> type = decodeStringElement(descriptor, i)
          14 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            targetProfile =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          16 ->
            _targetProfile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          17 -> searchType = decodeStringElement(descriptor, i)
          18 ->
            _searchType = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 ->
            binding =
              decodeNullableSerializableElement(
                descriptor,
                i,
                OperationDefinitionParameterBindingSerializer,
                null,
              )
          20 ->
            referencedFrom =
              decodeNullableSerializableElement(
                descriptor,
                i,
                OperationDefinitionParameterReferencedFromSerializer.listSerializer,
                null,
              )
          21 ->
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
        min =
          Integer.of(min, _min)
            ?: throw SerializationException(
              "Missing required property 'min' on OperationDefinition.Parameter"
            ),
        max =
          R4String.of(max, _max)
            ?: throw SerializationException(
              "Missing required property 'max' on OperationDefinition.Parameter"
            ),
        documentation = R4String.of(documentation, _documentation),
        type = Enumeration.of(if (type != null) FHIRAllTypes.fromCode(type) else null, _type),
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
      encodeIntIfNotNull(descriptor, 7, value.min.value)
      encodeElementIfNotNull(descriptor, 8, value.min)
      encodeStringIfNotNull(descriptor, 9, value.max.value)
      encodeElementIfNotNull(descriptor, 10, value.max)
      encodeStringIfNotNull(descriptor, 11, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 12, value.documentation)
      encodeStringIfNotNull(descriptor, 13, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 14, value.type)
      if (value.targetProfile.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          15,
          stringNullableListSerializer,
          value.targetProfile.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 16, value.targetProfile)
      }
      encodeStringIfNotNull(descriptor, 17, value.searchType?.value?.code)
      encodeElementIfNotNull(descriptor, 18, value.searchType)
      encodeSerializableIfNotNull(
        descriptor,
        19,
        OperationDefinitionParameterBindingSerializer,
        value.binding,
      )
      if (value.referencedFrom.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          20,
          OperationDefinitionParameterReferencedFromSerializer.listSerializer,
          value.referencedFrom,
        )
      if (value.part.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          21,
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
          R4String.of(source, _source)
            ?: throw SerializationException(
              "Missing required property 'source' on OperationDefinition.Parameter.ReferencedFrom"
            ),
        sourceId = R4String.of(sourceId, _sourceId),
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
            R4String.of(parameterName?.getOrNull(index), _parameterName?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'parameterName' on OperationDefinition.Overload has neither a value nor an id/extension"
              )
          }),
        comment = R4String.of(comment, _comment),
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
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
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
        12 -> version = decoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> title = decoder.decodeStringElement(descriptor, i)
        17 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> kind = decoder.decodeStringElement(descriptor, i)
        21 ->
          _kind = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        23 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> date = decoder.decodeStringElement(descriptor, i)
        25 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> publisher = decoder.decodeStringElement(descriptor, i)
        27 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        29 -> description = decoder.decodeStringElement(descriptor, i)
        30 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        32 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        33 -> purpose = decoder.decodeStringElement(descriptor, i)
        34 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> affectsState = decoder.decodeBooleanElement(descriptor, i)
        36 ->
          _affectsState =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> code = decoder.decodeStringElement(descriptor, i)
        38 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> comment = decoder.decodeStringElement(descriptor, i)
        40 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 -> base = decoder.decodeStringElement(descriptor, i)
        42 ->
          _base = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          resource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        44 ->
          _resource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        45 -> system = decoder.decodeBooleanElement(descriptor, i)
        46 ->
          _system =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 -> type = decoder.decodeBooleanElement(descriptor, i)
        48 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        49 -> instance = decoder.decodeBooleanElement(descriptor, i)
        50 ->
          _instance =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        51 -> inputProfile = decoder.decodeStringElement(descriptor, i)
        52 ->
          _inputProfile =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        53 -> outputProfile = decoder.decodeStringElement(descriptor, i)
        54 ->
          _outputProfile =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        55 ->
          parameter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterSerializer.listSerializer,
              null,
            )
        56 ->
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
      version = R4String.of(version, _version),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on OperationDefinition"
          ),
      title = R4String.of(title, _title),
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
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      affectsState = R4Boolean.of(affectsState, _affectsState),
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
            resource?.getOrNull(index)?.let { ResourceType.fromCode(it) },
            _resource?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'resource' on OperationDefinition has neither a value nor an id/extension"
            )
        }),
      system =
        R4Boolean.of(system, _system)
          ?: throw SerializationException(
            "Missing required property 'system' on OperationDefinition"
          ),
      type =
        R4Boolean.of(type, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on OperationDefinition"
          ),
      instance =
        R4Boolean.of(instance, _instance)
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
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name.value)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.kind.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.kind)
    encoder.encodeBooleanIfNotNull(descriptor, 22 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.purpose)
    encoder.encodeBooleanIfNotNull(descriptor, 35 + descriptorOffset, value.affectsState?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.affectsState)
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.code.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.code)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.comment?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.comment)
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.base?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.base)
    if (value.resource.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        43 + descriptorOffset,
        stringNullableListSerializer,
        value.resource.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 44 + descriptorOffset, value.resource)
    }
    encoder.encodeBooleanIfNotNull(descriptor, 45 + descriptorOffset, value.system.value)
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.system)
    encoder.encodeBooleanIfNotNull(descriptor, 47 + descriptorOffset, value.type.value)
    encoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.type)
    encoder.encodeBooleanIfNotNull(descriptor, 49 + descriptorOffset, value.instance.value)
    encoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.instance)
    encoder.encodeStringIfNotNull(descriptor, 51 + descriptorOffset, value.inputProfile?.value)
    encoder.encodeElementIfNotNull(descriptor, 52 + descriptorOffset, value.inputProfile)
    encoder.encodeStringIfNotNull(descriptor, 53 + descriptorOffset, value.outputProfile?.value)
    encoder.encodeElementIfNotNull(descriptor, 54 + descriptorOffset, value.outputProfile)
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        OperationDefinitionParameterSerializer.listSerializer,
        value.parameter,
      )
    if (value.overload.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        OperationDefinitionOverloadSerializer.listSerializer,
        value.overload,
      )
  }
}
