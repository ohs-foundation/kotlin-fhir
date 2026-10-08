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
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.ExtensibleEnumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
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
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.terminologies.CommonLanguages
import dev.ohs.fhir.model.r4.terminologies.FilterOperator
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

internal object ValueSetComposeSerializer : KSerializer<ValueSet.Compose> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Compose") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("lockedDate", KotlinString.serializer().descriptor)
      optionalElement("_lockedDate", ElementSerializer.descriptor)
      optionalElement("inactive", KotlinBoolean.serializer().descriptor)
      optionalElement("_inactive", ElementSerializer.descriptor)
      optionalElement("include", ValueSetComposeIncludeSerializer.listSerializer.descriptor)
      optionalElement("exclude", ValueSetComposeIncludeSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ValueSet.Compose>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Compose {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var lockedDate: KotlinString? = null
    var _lockedDate: Element? = null
    var inactive: KotlinBoolean? = null
    var _inactive: Element? = null
    var include: List<ValueSet.Compose.Include>? = null
    var exclude: List<ValueSet.Compose.Include>? = null
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
        3 -> lockedDate = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _lockedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> inactive = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _inactive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          include =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeIncludeSerializer.listSerializer,
              null,
            )
        8 ->
          exclude =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeIncludeSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Compose: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ValueSet.Compose(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      lockedDate =
        Date.of(if (lockedDate != null) FhirDate.fromString(lockedDate) else null, _lockedDate),
      inactive = R4Boolean.of(inactive, _inactive),
      include = include ?: listOf(),
      exclude = exclude ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.lockedDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.lockedDate)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.inactive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.inactive)
    if (value.include.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        ValueSetComposeIncludeSerializer.listSerializer,
        value.include,
      )
    if (value.exclude.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        ValueSetComposeIncludeSerializer.listSerializer,
        value.exclude,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ValueSetComposeIncludeSerializer : KSerializer<ValueSet.Compose.Include> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Include") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("system", KotlinString.serializer().descriptor)
      optionalElement("_system", ElementSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
      optionalElement("concept", ValueSetComposeIncludeConceptSerializer.listSerializer.descriptor)
      optionalElement("filter", ValueSetComposeIncludeFilterSerializer.listSerializer.descriptor)
      optionalElement("valueSet", stringNullableListSerializer.descriptor)
      optionalElement("_valueSet", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ValueSet.Compose.Include>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var system: KotlinString? = null
    var _system: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var concept: List<ValueSet.Compose.Include.Concept>? = null
    var filter: List<ValueSet.Compose.Include.Filter>? = null
    var valueSet: List<KotlinString?>? = null
    var _valueSet: List<Element?>? = null
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
        3 -> system = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          concept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeIncludeConceptSerializer.listSerializer,
              null,
            )
        8 ->
          filter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeIncludeFilterSerializer.listSerializer,
              null,
            )
        9 ->
          valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        10 ->
          _valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Include: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ValueSet.Compose.Include(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      system = Uri.of(system, _system),
      version = R4String.of(version, _version),
      concept = concept ?: listOf(),
      filter = filter ?: listOf(),
      valueSet =
        (kotlin.collections.List(maxOf(valueSet?.size ?: 0, _valueSet?.size ?: 0)) { index ->
          Canonical.of(valueSet?.getOrNull(index), _valueSet?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'valueSet' on ValueSet.Compose.Include has neither a value nor an id/extension"
            )
        }),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.system?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.system)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.version)
    if (value.concept.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        ValueSetComposeIncludeConceptSerializer.listSerializer,
        value.concept,
      )
    if (value.filter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        ValueSetComposeIncludeFilterSerializer.listSerializer,
        value.filter,
      )
    if (value.valueSet.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        stringNullableListSerializer,
        value.valueSet.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.valueSet)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ValueSetComposeIncludeConceptSerializer :
  KSerializer<ValueSet.Compose.Include.Concept> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Concept") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", ElementSerializer.descriptor)
      optionalElement(
        "designation",
        ValueSetComposeIncludeConceptDesignationSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ValueSet.Compose.Include.Concept>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var designation: List<ValueSet.Compose.Include.Concept.Designation>? = null
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
        7 ->
          designation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeIncludeConceptDesignationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Concept: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ValueSet.Compose.Include.Concept(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Code.of(code, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on ValueSet.Compose.Include.Concept"
          ),
      display = R4String.of(display, _display),
      designation = designation ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept) {
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
    if (value.designation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        ValueSetComposeIncludeConceptDesignationSerializer.listSerializer,
        value.designation,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ValueSetComposeIncludeConceptDesignationSerializer :
  KSerializer<ValueSet.Compose.Include.Concept.Designation> {
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

  internal val listSerializer: KSerializer<List<ValueSet.Compose.Include.Concept.Designation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept.Designation {
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
    return ValueSet.Compose.Include.Concept.Designation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = ExtensibleEnumeration.of<CommonLanguages>(language, _language),
      use = use,
      `value` =
        R4String.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on ValueSet.Compose.Include.Concept.Designation"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept.Designation) {
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

internal object ValueSetComposeIncludeFilterSerializer :
  KSerializer<ValueSet.Compose.Include.Filter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Filter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("property", KotlinString.serializer().descriptor)
      optionalElement("_property", ElementSerializer.descriptor)
      optionalElement("op", KotlinString.serializer().descriptor)
      optionalElement("_op", ElementSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ValueSet.Compose.Include.Filter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Filter {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `property`: KotlinString? = null
    var _property: Element? = null
    var op: KotlinString? = null
    var _op: Element? = null
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
        3 -> `property` = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _property =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> op = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _op =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
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
    return ValueSet.Compose.Include.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `property` =
        Code.of(`property`, _property)
          ?: throw SerializationException(
            "Missing required property 'property' on ValueSet.Compose.Include.Filter"
          ),
      op =
        Enumeration.of(if (op != null) FilterOperator.fromCode(op) else null, _op)
          ?: throw SerializationException(
            "Missing required property 'op' on ValueSet.Compose.Include.Filter"
          ),
      `value` =
        R4String.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on ValueSet.Compose.Include.Filter"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Filter) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.`property`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.`property`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.op.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.op)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ValueSetExpansionSerializer : KSerializer<ValueSet.Expansion> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Expansion") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", KotlinString.serializer().descriptor)
      optionalElement("_identifier", ElementSerializer.descriptor)
      optionalElement("timestamp", KotlinString.serializer().descriptor)
      optionalElement("_timestamp", ElementSerializer.descriptor)
      optionalElement("total", Int.serializer().descriptor)
      optionalElement("_total", ElementSerializer.descriptor)
      optionalElement("offset", Int.serializer().descriptor)
      optionalElement("_offset", ElementSerializer.descriptor)
      optionalElement("parameter", ValueSetExpansionParameterSerializer.listSerializer.descriptor)
      optionalElement("contains", ValueSetExpansionContainsSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ValueSet.Expansion>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Expansion {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: KotlinString? = null
    var _identifier: Element? = null
    var timestamp: KotlinString? = null
    var _timestamp: Element? = null
    var total: Int? = null
    var _total: Element? = null
    var offset: Int? = null
    var _offset: Element? = null
    var parameter: List<ValueSet.Expansion.Parameter>? = null
    var contains: List<ValueSet.Expansion.Contains>? = null
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
        3 -> identifier = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> timestamp = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _timestamp =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> total = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _total =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> offset = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _offset =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetExpansionParameterSerializer.listSerializer,
              null,
            )
        12 ->
          contains =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetExpansionContainsSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Expansion: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ValueSet.Expansion(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = Uri.of(identifier, _identifier),
      timestamp =
        DateTime.of(if (timestamp != null) FhirDateTime.fromString(timestamp) else null, _timestamp)
          ?: throw SerializationException(
            "Missing required property 'timestamp' on ValueSet.Expansion"
          ),
      total = Integer.of(total, _total),
      offset = Integer.of(offset, _offset),
      parameter = parameter ?: listOf(),
      contains = contains ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.identifier?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.identifier)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.timestamp.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.timestamp)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.total?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.total)
    compositeEncoder.encodeIntIfNotNull(descriptor, 9, value.offset?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.offset)
    if (value.parameter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        ValueSetExpansionParameterSerializer.listSerializer,
        value.parameter,
      )
    if (value.contains.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        ValueSetExpansionContainsSerializer.listSerializer,
        value.contains,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ValueSetExpansionParameterSerializer : KSerializer<ValueSet.Expansion.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_valueDecimal", ElementSerializer.descriptor)
      optionalElement("valueUri", KotlinString.serializer().descriptor)
      optionalElement("_valueUri", ElementSerializer.descriptor)
      optionalElement("valueCode", KotlinString.serializer().descriptor)
      optionalElement("_valueCode", ElementSerializer.descriptor)
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ValueSet.Expansion.Parameter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Parameter {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
    var valueUri: KotlinString? = null
    var _valueUri: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
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
        5 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        12 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> valueUri = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _valueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> valueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ValueSet.Expansion.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on ValueSet.Expansion.Parameter"
          ),
      `value` =
        ValueSet.Expansion.Parameter.Value.from(
          R4String.of(valueString, _valueString),
          R4Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          Decimal.of(valueDecimal, _valueDecimal),
          Uri.of(valueUri, _valueUri),
          Code.of(valueCode, _valueCode),
          DateTime.of(
            if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
            _valueDateTime,
          ),
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Parameter) {
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
    when (val choice = value.`value`) {
      null -> {}
      is ValueSet.Expansion.Parameter.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is ValueSet.Expansion.Parameter.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is ValueSet.Expansion.Parameter.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is ValueSet.Expansion.Parameter.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          11,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is ValueSet.Expansion.Parameter.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 13, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is ValueSet.Expansion.Parameter.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 15, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is ValueSet.Expansion.Parameter.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 17, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ValueSetExpansionContainsSerializer : KSerializer<ValueSet.Expansion.Contains> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contains") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("system", KotlinString.serializer().descriptor)
      optionalElement("_system", ElementSerializer.descriptor)
      optionalElement("abstract", KotlinBoolean.serializer().descriptor)
      optionalElement("_abstract", ElementSerializer.descriptor)
      optionalElement("inactive", KotlinBoolean.serializer().descriptor)
      optionalElement("_inactive", ElementSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", ElementSerializer.descriptor)
      optionalElement(
        "designation",
        ValueSetComposeIncludeConceptDesignationSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "contains",
        listSerialDescriptor(lazyDescriptor { ValueSetExpansionContainsSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<ValueSet.Expansion.Contains>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var system: KotlinString? = null
    var _system: Element? = null
    var `abstract`: KotlinBoolean? = null
    var _abstract: Element? = null
    var inactive: KotlinBoolean? = null
    var _inactive: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var designation: List<ValueSet.Compose.Include.Concept.Designation>? = null
    var contains: List<ValueSet.Expansion.Contains>? = null
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
        3 -> system = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> `abstract` = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _abstract =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> inactive = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _inactive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          designation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeIncludeConceptDesignationSerializer.listSerializer,
              null,
            )
        16 ->
          contains =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetExpansionContainsSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contains: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ValueSet.Expansion.Contains(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      system = Uri.of(system, _system),
      `abstract` = R4Boolean.of(`abstract`, _abstract),
      inactive = R4Boolean.of(inactive, _inactive),
      version = R4String.of(version, _version),
      code = Code.of(code, _code),
      display = R4String.of(display, _display),
      designation = designation ?: listOf(),
      contains = contains ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.system?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.system)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.`abstract`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.`abstract`)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, value.inactive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.inactive)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.display)
    if (value.designation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15,
        ValueSetComposeIncludeConceptDesignationSerializer.listSerializer,
        value.designation,
      )
    if (value.contains.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16,
        ValueSetExpansionContainsSerializer.listSerializer,
        value.contains,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ValueSetSerializer : FhirResourceSerializer<ValueSet> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ValueSet")

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
    b.optionalElement("immutable", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_immutable", ElementSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("compose", ValueSetComposeSerializer.descriptor)
    b.optionalElement("expansion", ValueSetExpansionSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ValueSet {
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
    var immutable: KotlinBoolean? = null
    var _immutable: Element? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var compose: ValueSet.Compose? = null
    var expansion: ValueSet.Expansion? = null
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
        32 -> immutable = compositeDecoder.decodeBooleanElement(descriptor, i)
        33 ->
          _immutable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        37 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 ->
          compose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeSerializer,
              null,
            )
        39 ->
          expansion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetExpansionSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ValueSet: " + i)
      }
    }
    return ValueSet(
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
          ?: throw SerializationException("Missing required property 'status' on ValueSet"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      immutable = R4Boolean.of(immutable, _immutable),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      compose = compose,
      expansion = expansion,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ValueSet,
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
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      32 + descriptorOffset,
      value.immutable?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.immutable)
    compositeEncoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.copyright)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      ValueSetComposeSerializer,
      value.compose,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      ValueSetExpansionSerializer,
      value.expansion,
    )
  }
}
