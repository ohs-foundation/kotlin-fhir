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
import dev.ohs.fhir.model.r4.terminologies.OperationKind
import dev.ohs.fhir.model.r4.terminologies.OperationParameterUse
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

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> use = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          targetProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        16 ->
          _targetProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        17 -> searchType = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _searchType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          binding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterBindingSerializer,
              null,
            )
        20 ->
          referencedFrom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterReferencedFromSerializer.listSerializer,
              null,
            )
        21 ->
          part =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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
        Enumeration.of(if (use != null) OperationParameterUse.fromCode(use) else null, _use)
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
        (kotlin.collections.List(maxOf(targetProfile?.size ?: 0, _targetProfile?.size ?: 0)) { index
          ->
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.use.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.use)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.min.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.max.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.max)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.documentation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.type)
    if (value.targetProfile.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        15,
        stringNullableListSerializer,
        value.targetProfile.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 16, value.targetProfile)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 17, value.searchType?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.searchType)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19,
      OperationDefinitionParameterBindingSerializer,
      value.binding,
    )
    if (value.referencedFrom.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20,
        OperationDefinitionParameterReferencedFromSerializer.listSerializer,
        value.referencedFrom,
      )
    if (value.part.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21,
        OperationDefinitionParameterSerializer.listSerializer,
        value.part,
      )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.Binding {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var strength: KotlinString? = null
    var _strength: Element? = null
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
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> strength = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _strength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
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
    return OperationDefinition.Parameter.Binding(
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.strength.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.strength)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.valueSet.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.valueSet)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.ReferencedFrom {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
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
        3 -> source = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> sourceId = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _sourceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferencedFrom: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return OperationDefinition.Parameter.ReferencedFrom(
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.source.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.source)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.sourceId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.sourceId)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): OperationDefinition.Overload {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var parameterName: List<KotlinString?>? = null
    var _parameterName: List<Element?>? = null
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
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          parameterName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        4 ->
          _parameterName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Overload: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return OperationDefinition.Overload(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      parameterName =
        (kotlin.collections.List(maxOf(parameterName?.size ?: 0, _parameterName?.size ?: 0)) { index
          ->
          R4String.of(parameterName?.getOrNull(index), _parameterName?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'parameterName' on OperationDefinition.Overload has neither a value nor an id/extension"
            )
        }),
      comment = R4String.of(comment, _comment),
    )
  }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Overload) {
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
    if (value.parameterName.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        3,
        stringNullableListSerializer,
        value.parameterName.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 4, value.parameterName)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.comment)
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
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
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> kind = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _kind =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        23 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        29 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        32 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        33 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 -> affectsState = compositeDecoder.decodeBooleanElement(descriptor, i)
        36 ->
          _affectsState =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> base = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _base =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        44 ->
          _resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        45 -> system = compositeDecoder.decodeBooleanElement(descriptor, i)
        46 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 -> type = compositeDecoder.decodeBooleanElement(descriptor, i)
        48 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 -> instance = compositeDecoder.decodeBooleanElement(descriptor, i)
        50 ->
          _instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        51 -> inputProfile = compositeDecoder.decodeStringElement(descriptor, i)
        52 ->
          _inputProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        53 -> outputProfile = compositeDecoder.decodeStringElement(descriptor, i)
        54 ->
          _outputProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        55 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterSerializer.listSerializer,
              null,
            )
        56 ->
          overload =
            compositeDecoder.decodeNullableSerializableElement(
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
        Enumeration.of(if (kind != null) OperationKind.fromCode(kind) else null, _kind)
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: OperationDefinition,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.kind.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.kind)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.purpose)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.affectsState?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.affectsState)
    compositeEncoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.comment)
    compositeEncoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.base?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.base)
    if (value.resource.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        43 + descriptorOffset,
        stringNullableListSerializer,
        value.resource.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 44 + descriptorOffset, value.resource)
    }
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 45 + descriptorOffset, value.system.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.system)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 47 + descriptorOffset, value.type.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.type)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 49 + descriptorOffset, value.instance.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.instance)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      51 + descriptorOffset,
      value.inputProfile?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 52 + descriptorOffset, value.inputProfile)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      53 + descriptorOffset,
      value.outputProfile?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 54 + descriptorOffset, value.outputProfile)
    if (value.parameter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        OperationDefinitionParameterSerializer.listSerializer,
        value.parameter,
      )
    if (value.overload.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        OperationDefinitionOverloadSerializer.listSerializer,
        value.overload,
      )
  }
}
