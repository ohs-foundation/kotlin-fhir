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
import dev.ohs.fhir.model.r4.CodeSystem
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.ExtensibleEnumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.CodeSystemContentMode
import dev.ohs.fhir.model.r4.terminologies.CodeSystemHierarchyMeaning
import dev.ohs.fhir.model.r4.terminologies.CommonLanguages
import dev.ohs.fhir.model.r4.terminologies.FilterOperator
import dev.ohs.fhir.model.r4.terminologies.PropertyType
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object CodeSystemFilterSerializer : KSerializer<CodeSystem.Filter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Filter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("operator", stringNullableListSerializer.descriptor)
      optionalElement("_operator", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CodeSystem.Filter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CodeSystem.Filter {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var `operator`: List<KotlinString?>? = null
    var _operator: List<Element?>? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
        3 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          `operator` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        8 ->
          _operator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CodeSystem.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Code.of(code, _code)
          ?: throw SerializationException("Missing required property 'code' on CodeSystem.Filter"),
      description = R4String.of(description, _description),
      `operator` =
        (kotlin.collections.List(maxOf(`operator`?.size ?: 0, _operator?.size ?: 0)) { index ->
          Enumeration.of(
            `operator`?.getOrNull(index)?.let { FilterOperator.fromCode(it) },
            _operator?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'operator' on CodeSystem.Filter has neither a value nor an id/extension"
            )
        }),
      `value` =
        R4String.of(`value`, _value)
          ?: throw SerializationException("Missing required property 'value' on CodeSystem.Filter"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Filter) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    if (value.`operator`.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        stringNullableListSerializer,
        value.`operator`.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.`operator`)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CodeSystemPropertySerializer : KSerializer<CodeSystem.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("uri", KotlinString.serializer().descriptor)
      optionalElement("_uri", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CodeSystem.Property>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CodeSystem.Property {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
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
        3 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> uri = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _uri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CodeSystem.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Code.of(code, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on CodeSystem.Property"
          ),
      uri = Uri.of(uri, _uri),
      description = R4String.of(description, _description),
      type =
        Enumeration.of(if (type != null) PropertyType.fromCode(type) else null, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on CodeSystem.Property"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Property) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.uri?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.uri)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.type)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CodeSystemConceptSerializer : KSerializer<CodeSystem.Concept> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Concept") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", ElementSerializer.descriptor)
      optionalElement("definition", KotlinString.serializer().descriptor)
      optionalElement("_definition", ElementSerializer.descriptor)
      optionalElement(
        "designation",
        CodeSystemConceptDesignationSerializer.listSerializer.descriptor,
      )
      optionalElement("property", CodeSystemConceptPropertySerializer.listSerializer.descriptor)
      optionalElement(
        "concept",
        listSerialDescriptor(lazyDescriptor { CodeSystemConceptSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<CodeSystem.Concept>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CodeSystem.Concept {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var designation: List<CodeSystem.Concept.Designation>? = null
    var `property`: List<CodeSystem.Concept.Property>? = null
    var concept: List<CodeSystem.Concept>? = null
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
        3 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> definition = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _definition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          designation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeSystemConceptDesignationSerializer.listSerializer,
              null,
            )
        10 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeSystemConceptPropertySerializer.listSerializer,
              null,
            )
        11 ->
          concept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeSystemConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Concept: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CodeSystem.Concept(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Code.of(code, _code)
          ?: throw SerializationException("Missing required property 'code' on CodeSystem.Concept"),
      display = R4String.of(display, _display),
      definition = R4String.of(definition, _definition),
      designation = designation ?: listOf(),
      `property` = `property` ?: listOf(),
      concept = concept ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.display)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.definition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.definition)
    if (value.designation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        CodeSystemConceptDesignationSerializer.listSerializer,
        value.designation,
      )
    if (value.`property`.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        CodeSystemConceptPropertySerializer.listSerializer,
        value.`property`,
      )
    if (value.concept.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        CodeSystemConceptSerializer.listSerializer,
        value.concept,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CodeSystemConceptDesignationSerializer :
  KSerializer<CodeSystem.Concept.Designation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Designation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", ElementSerializer.descriptor)
      optionalElement("use", CodingSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CodeSystem.Concept.Designation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CodeSystem.Concept.Designation {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var use: Coding? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
        3 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        6 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Designation: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CodeSystem.Concept.Designation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = ExtensibleEnumeration.of<CommonLanguages>(language, _language),
      use = use,
      `value` =
        R4String.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on CodeSystem.Concept.Designation"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Designation) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.language?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.language)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, CodingSerializer, value.use)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CodeSystemConceptPropertySerializer : KSerializer<CodeSystem.Concept.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("valueCode", KotlinString.serializer().descriptor)
      optionalElement("_valueCode", ElementSerializer.descriptor)
      optionalElement("valueCoding", CodingSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", ElementSerializer.descriptor)
      optionalElement("valueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_valueDecimal", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CodeSystem.Concept.Property>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CodeSystem.Concept.Property {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueCoding: Coding? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
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
        3 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        8 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        13 ->
          _valueBoolean =
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CodeSystem.Concept.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Code.of(code, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on CodeSystem.Concept.Property"
          ),
      `value` =
        CodeSystem.Concept.Property.Value.from(
          Code.of(valueCode, _valueCode),
          valueCoding,
          R4String.of(valueString, _valueString),
          Integer.of(valueInteger, _valueInteger),
          R4Boolean.of(valueBoolean, _valueBoolean),
          DateTime.of(
            if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
            _valueDateTime,
          ),
          Decimal.of(valueDecimal, _valueDecimal),
        )
          ?: throw SerializationException(
            "Missing required property 'value' on CodeSystem.Concept.Property"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Property) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    when (val choice = value.`value`) {
      is CodeSystem.Concept.Property.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is CodeSystem.Concept.Property.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, CodingSerializer, choice.value)
      }
      is CodeSystem.Concept.Property.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is CodeSystem.Concept.Property.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is CodeSystem.Concept.Property.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 12, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is CodeSystem.Concept.Property.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 15, choice.value)
      }
      is CodeSystem.Concept.Property.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          16,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 17, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CodeSystemSerializer : FhirResourceSerializer<CodeSystem> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CodeSystem")

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
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
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
    b.optionalElement("caseSensitive", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_caseSensitive", ElementSerializer.descriptor)
    b.optionalElement("valueSet", KotlinString.serializer().descriptor)
    b.optionalElement("_valueSet", ElementSerializer.descriptor)
    b.optionalElement("hierarchyMeaning", KotlinString.serializer().descriptor)
    b.optionalElement("_hierarchyMeaning", ElementSerializer.descriptor)
    b.optionalElement("compositional", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_compositional", ElementSerializer.descriptor)
    b.optionalElement("versionNeeded", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_versionNeeded", ElementSerializer.descriptor)
    b.optionalElement("content", KotlinString.serializer().descriptor)
    b.optionalElement("_content", ElementSerializer.descriptor)
    b.optionalElement("supplements", KotlinString.serializer().descriptor)
    b.optionalElement("_supplements", ElementSerializer.descriptor)
    b.optionalElement("count", Int.serializer().descriptor)
    b.optionalElement("_count", ElementSerializer.descriptor)
    b.optionalElement("filter", CodeSystemFilterSerializer.listSerializer.descriptor)
    b.optionalElement("property", CodeSystemPropertySerializer.listSerializer.descriptor)
    b.optionalElement("concept", CodeSystemConceptSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): CodeSystem {
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
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
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
    var caseSensitive: KotlinBoolean? = null
    var _caseSensitive: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var hierarchyMeaning: KotlinString? = null
    var _hierarchyMeaning: Element? = null
    var compositional: KotlinBoolean? = null
    var _compositional: Element? = null
    var versionNeeded: KotlinBoolean? = null
    var _versionNeeded: Element? = null
    var content: KotlinString? = null
    var _content: Element? = null
    var supplements: KotlinString? = null
    var _supplements: Element? = null
    var count: Int? = null
    var _count: Element? = null
    var filter: List<CodeSystem.Filter>? = null
    var `property`: List<CodeSystem.Property>? = null
    var concept: List<CodeSystem.Concept>? = null
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
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> caseSensitive = compositeDecoder.decodeBooleanElement(descriptor, i)
        37 ->
          _caseSensitive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 -> hierarchyMeaning = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _hierarchyMeaning =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 -> compositional = compositeDecoder.decodeBooleanElement(descriptor, i)
        43 ->
          _compositional =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 -> versionNeeded = compositeDecoder.decodeBooleanElement(descriptor, i)
        45 ->
          _versionNeeded =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        46 -> content = compositeDecoder.decodeStringElement(descriptor, i)
        47 ->
          _content =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        48 -> supplements = compositeDecoder.decodeStringElement(descriptor, i)
        49 ->
          _supplements =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        50 -> count = compositeDecoder.decodeIntElement(descriptor, i)
        51 ->
          _count =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        52 ->
          filter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeSystemFilterSerializer.listSerializer,
              null,
            )
        53 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeSystemPropertySerializer.listSerializer,
              null,
            )
        54 ->
          concept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeSystemConceptSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding CodeSystem: " + i)
      }
    }
    return CodeSystem(
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on CodeSystem"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      caseSensitive = R4Boolean.of(caseSensitive, _caseSensitive),
      valueSet = Canonical.of(valueSet, _valueSet),
      hierarchyMeaning =
        Enumeration.of(
          if (hierarchyMeaning != null) CodeSystemHierarchyMeaning.fromCode(hierarchyMeaning)
          else null,
          _hierarchyMeaning,
        ),
      compositional = R4Boolean.of(compositional, _compositional),
      versionNeeded = R4Boolean.of(versionNeeded, _versionNeeded),
      content =
        Enumeration.of(
          if (content != null) CodeSystemContentMode.fromCode(content) else null,
          _content,
        ) ?: throw SerializationException("Missing required property 'content' on CodeSystem"),
      supplements = Canonical.of(supplements, _supplements),
      count = UnsignedInt.of(count, _count),
      filter = filter ?: listOf(),
      `property` = `property` ?: listOf(),
      concept = concept ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CodeSystem,
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
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.caseSensitive?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.caseSensitive)
    compositeEncoder.encodeStringIfNotNull(descriptor, 38 + descriptorOffset, value.valueSet?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.valueSet)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      40 + descriptorOffset,
      value.hierarchyMeaning?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.hierarchyMeaning,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      42 + descriptorOffset,
      value.compositional?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.compositional)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      44 + descriptorOffset,
      value.versionNeeded?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, value.versionNeeded)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      46 + descriptorOffset,
      value.content.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, value.content)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      48 + descriptorOffset,
      value.supplements?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 49 + descriptorOffset, value.supplements)
    compositeEncoder.encodeIntIfNotNull(descriptor, 50 + descriptorOffset, value.count?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 51 + descriptorOffset, value.count)
    if (value.filter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        CodeSystemFilterSerializer.listSerializer,
        value.filter,
      )
    if (value.`property`.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        CodeSystemPropertySerializer.listSerializer,
        value.`property`,
      )
    if (value.concept.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        CodeSystemConceptSerializer.listSerializer,
        value.concept,
      )
  }
}
