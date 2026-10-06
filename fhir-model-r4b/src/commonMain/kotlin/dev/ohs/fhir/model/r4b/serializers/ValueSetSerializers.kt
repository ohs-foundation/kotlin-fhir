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

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.ExtensibleEnumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.ValueSet
import dev.ohs.fhir.model.r4b.terminologies.CommonLanguages
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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

  override fun deserialize(decoder: Decoder): ValueSet.Compose =
    decoder.decodeStructure(descriptor) {
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
          3 -> lockedDate = decodeStringElement(descriptor, i)
          4 ->
            _lockedDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> inactive = decodeBooleanElement(descriptor, i)
          6 -> _inactive = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            include =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetComposeIncludeSerializer.listSerializer,
                null,
              )
          8 ->
            exclude =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetComposeIncludeSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Compose: " + i)
        }
      }
      ValueSet.Compose(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        lockedDate =
          Date.of(if (lockedDate != null) FhirDate.fromString(lockedDate) else null, _lockedDate),
        inactive = R4bBoolean.of(inactive, _inactive),
        include = include ?: listOf(),
        exclude = exclude ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose) {
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
      encodeStringIfNotNull(descriptor, 3, value.lockedDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 4, value.lockedDate)
      encodeBooleanIfNotNull(descriptor, 5, value.inactive?.value)
      encodeElementIfNotNull(descriptor, 6, value.inactive)
      if (value.include.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          ValueSetComposeIncludeSerializer.listSerializer,
          value.include,
        )
      if (value.exclude.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          ValueSetComposeIncludeSerializer.listSerializer,
          value.exclude,
        )
    }
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

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include =
    decoder.decodeStructure(descriptor) {
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
          3 -> system = decodeStringElement(descriptor, i)
          4 -> _system = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> version = decodeStringElement(descriptor, i)
          6 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            concept =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetComposeIncludeConceptSerializer.listSerializer,
                null,
              )
          8 ->
            filter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetComposeIncludeFilterSerializer.listSerializer,
                null,
              )
          9 ->
            valueSet =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          10 ->
            _valueSet =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Include: " + i)
        }
      }
      ValueSet.Compose.Include(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        system = Uri.of(system, _system),
        version = R4bString.of(version, _version),
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
      encodeStringIfNotNull(descriptor, 3, value.system?.value)
      encodeElementIfNotNull(descriptor, 4, value.system)
      encodeStringIfNotNull(descriptor, 5, value.version?.value)
      encodeElementIfNotNull(descriptor, 6, value.version)
      if (value.concept.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          ValueSetComposeIncludeConceptSerializer.listSerializer,
          value.concept,
        )
      if (value.filter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          ValueSetComposeIncludeFilterSerializer.listSerializer,
          value.filter,
        )
      if (value.valueSet.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          stringNullableListSerializer,
          value.valueSet.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 10, value.valueSet)
      }
    }
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

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var display: KotlinString? = null
      var _display: Element? = null
      var designation: List<ValueSet.Compose.Include.Concept.Designation>? = null
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
          3 -> code = decodeStringElement(descriptor, i)
          4 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> display = decodeStringElement(descriptor, i)
          6 -> _display = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            designation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetComposeIncludeConceptDesignationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Concept: " + i)
        }
      }
      ValueSet.Compose.Include.Concept(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Code.of(code, _code)
            ?: throw SerializationException(
              "Missing required property 'code' on ValueSet.Compose.Include.Concept"
            ),
        display = R4bString.of(display, _display),
        designation = designation ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept) {
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
      encodeStringIfNotNull(descriptor, 3, value.code.value)
      encodeElementIfNotNull(descriptor, 4, value.code)
      encodeStringIfNotNull(descriptor, 5, value.display?.value)
      encodeElementIfNotNull(descriptor, 6, value.display)
      if (value.designation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          ValueSetComposeIncludeConceptDesignationSerializer.listSerializer,
          value.designation,
        )
    }
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

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept.Designation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var language: KotlinString? = null
      var _language: Element? = null
      var use: Coding? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
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
          3 -> language = decodeStringElement(descriptor, i)
          4 -> _language = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> use = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          6 -> `value` = decodeStringElement(descriptor, i)
          7 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Designation: " + i)
        }
      }
      ValueSet.Compose.Include.Concept.Designation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        language = ExtensibleEnumeration.of<CommonLanguages>(language, _language),
        use = use,
        `value` =
          R4bString.of(`value`, _value)
            ?: throw SerializationException(
              "Missing required property 'value' on ValueSet.Compose.Include.Concept.Designation"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept.Designation) {
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
      encodeStringIfNotNull(descriptor, 3, value.language?.code)
      encodeElementIfNotNull(descriptor, 4, value.language)
      encodeSerializableIfNotNull(descriptor, 5, CodingSerializer, value.use)
      encodeStringIfNotNull(descriptor, 6, value.`value`.value)
      encodeElementIfNotNull(descriptor, 7, value.`value`)
    }
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

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Filter =
    decoder.decodeStructure(descriptor) {
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
          3 -> `property` = decodeStringElement(descriptor, i)
          4 -> _property = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> op = decodeStringElement(descriptor, i)
          6 -> _op = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> `value` = decodeStringElement(descriptor, i)
          8 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Filter: " + i)
        }
      }
      ValueSet.Compose.Include.Filter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `property` =
          Code.of(`property`, _property)
            ?: throw SerializationException(
              "Missing required property 'property' on ValueSet.Compose.Include.Filter"
            ),
        op =
          Enumeration.of(if (op != null) ValueSet.FilterOperator.fromCode(op) else null, _op)
            ?: throw SerializationException(
              "Missing required property 'op' on ValueSet.Compose.Include.Filter"
            ),
        `value` =
          R4bString.of(`value`, _value)
            ?: throw SerializationException(
              "Missing required property 'value' on ValueSet.Compose.Include.Filter"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Filter) {
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
      encodeStringIfNotNull(descriptor, 3, value.`property`.value)
      encodeElementIfNotNull(descriptor, 4, value.`property`)
      encodeStringIfNotNull(descriptor, 5, value.op.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.op)
      encodeStringIfNotNull(descriptor, 7, value.`value`.value)
      encodeElementIfNotNull(descriptor, 8, value.`value`)
    }
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

  override fun deserialize(decoder: Decoder): ValueSet.Expansion =
    decoder.decodeStructure(descriptor) {
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
          3 -> identifier = decodeStringElement(descriptor, i)
          4 ->
            _identifier = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> timestamp = decodeStringElement(descriptor, i)
          6 ->
            _timestamp = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> total = decodeIntElement(descriptor, i)
          8 -> _total = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> offset = decodeIntElement(descriptor, i)
          10 -> _offset = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            parameter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetExpansionParameterSerializer.listSerializer,
                null,
              )
          12 ->
            contains =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetExpansionContainsSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Expansion: " + i)
        }
      }
      ValueSet.Expansion(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = Uri.of(identifier, _identifier),
        timestamp =
          DateTime.of(
            if (timestamp != null) FhirDateTime.fromString(timestamp) else null,
            _timestamp,
          )
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
      encodeStringIfNotNull(descriptor, 3, value.identifier?.value)
      encodeElementIfNotNull(descriptor, 4, value.identifier)
      encodeStringIfNotNull(descriptor, 5, value.timestamp.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.timestamp)
      encodeIntIfNotNull(descriptor, 7, value.total?.value)
      encodeElementIfNotNull(descriptor, 8, value.total)
      encodeIntIfNotNull(descriptor, 9, value.offset?.value)
      encodeElementIfNotNull(descriptor, 10, value.offset)
      if (value.parameter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          ValueSetExpansionParameterSerializer.listSerializer,
          value.parameter,
        )
      if (value.contains.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          ValueSetExpansionContainsSerializer.listSerializer,
          value.contains,
        )
    }
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

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Parameter =
    decoder.decodeStructure(descriptor) {
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
          5 -> valueString = decodeStringElement(descriptor, i)
          6 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> valueBoolean = decodeBooleanElement(descriptor, i)
          8 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> valueInteger = decodeIntElement(descriptor, i)
          10 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          12 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> valueUri = decodeStringElement(descriptor, i)
          14 ->
            _valueUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> valueCode = decodeStringElement(descriptor, i)
          16 ->
            _valueCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> valueDateTime = decodeStringElement(descriptor, i)
          18 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      ValueSet.Expansion.Parameter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R4bString.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on ValueSet.Expansion.Parameter"
            ),
        `value` =
          ValueSet.Expansion.Parameter.Value.from(
            R4bString.of(valueString, _valueString),
            R4bBoolean.of(valueBoolean, _valueBoolean),
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
      when (val choice = value.`value`) {
        null -> {}
        is ValueSet.Expansion.Parameter.Value.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is ValueSet.Expansion.Parameter.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is ValueSet.Expansion.Parameter.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is ValueSet.Expansion.Parameter.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 11, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is ValueSet.Expansion.Parameter.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 13, choice.value.value)
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
        is ValueSet.Expansion.Parameter.Value.Code -> {
          encodeStringIfNotNull(descriptor, 15, choice.value.value)
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is ValueSet.Expansion.Parameter.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 17, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
      }
    }
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

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains =
    decoder.decodeStructure(descriptor) {
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
          3 -> system = decodeStringElement(descriptor, i)
          4 -> _system = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> `abstract` = decodeBooleanElement(descriptor, i)
          6 -> _abstract = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> inactive = decodeBooleanElement(descriptor, i)
          8 -> _inactive = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> version = decodeStringElement(descriptor, i)
          10 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> code = decodeStringElement(descriptor, i)
          12 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> display = decodeStringElement(descriptor, i)
          14 -> _display = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            designation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetComposeIncludeConceptDesignationSerializer.listSerializer,
                null,
              )
          16 ->
            contains =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetExpansionContainsSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Contains: " + i)
        }
      }
      ValueSet.Expansion.Contains(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        system = Uri.of(system, _system),
        `abstract` = R4bBoolean.of(`abstract`, _abstract),
        inactive = R4bBoolean.of(inactive, _inactive),
        version = R4bString.of(version, _version),
        code = Code.of(code, _code),
        display = R4bString.of(display, _display),
        designation = designation ?: listOf(),
        contains = contains ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains) {
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
      encodeStringIfNotNull(descriptor, 3, value.system?.value)
      encodeElementIfNotNull(descriptor, 4, value.system)
      encodeBooleanIfNotNull(descriptor, 5, value.`abstract`?.value)
      encodeElementIfNotNull(descriptor, 6, value.`abstract`)
      encodeBooleanIfNotNull(descriptor, 7, value.inactive?.value)
      encodeElementIfNotNull(descriptor, 8, value.inactive)
      encodeStringIfNotNull(descriptor, 9, value.version?.value)
      encodeElementIfNotNull(descriptor, 10, value.version)
      encodeStringIfNotNull(descriptor, 11, value.code?.value)
      encodeElementIfNotNull(descriptor, 12, value.code)
      encodeStringIfNotNull(descriptor, 13, value.display?.value)
      encodeElementIfNotNull(descriptor, 14, value.display)
      if (value.designation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          ValueSetComposeIncludeConceptDesignationSerializer.listSerializer,
          value.designation,
        )
      if (value.contains.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          ValueSetExpansionContainsSerializer.listSerializer,
          value.contains,
        )
    }
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
    decoder: CompositeDecoder,
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
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> publisher = decoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = decoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> immutable = decoder.decodeBooleanElement(descriptor, i)
        33 ->
          _immutable =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> purpose = decoder.decodeStringElement(descriptor, i)
        35 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 -> copyright = decoder.decodeStringElement(descriptor, i)
        37 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 ->
          compose =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeSerializer,
              null,
            )
        39 ->
          expansion =
            decoder.decodeNullableSerializableElement(
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on ValueSet"),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      immutable = R4bBoolean.of(immutable, _immutable),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      compose = compose,
      expansion = expansion,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ValueSet,
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
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 21 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeBooleanIfNotNull(descriptor, 32 + descriptorOffset, value.immutable?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.immutable)
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 36 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.copyright)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      ValueSetComposeSerializer,
      value.compose,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      ValueSetExpansionSerializer,
      value.expansion,
    )
  }
}
