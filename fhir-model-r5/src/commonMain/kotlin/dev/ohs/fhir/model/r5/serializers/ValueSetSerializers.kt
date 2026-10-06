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
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.ValueSet
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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
      optionalElement("property", stringNullableListSerializer.descriptor)
      optionalElement("_property", ElementSerializer.nullableListSerializer.descriptor)
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
      var `property`: List<KotlinString?>? = null
      var _property: List<Element?>? = null
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
          9 ->
            `property` =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          10 ->
            _property =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
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
        inactive = R5Boolean.of(inactive, _inactive),
        include = include ?: listOf(),
        exclude = exclude ?: listOf(),
        `property` =
          (kotlin.collections.List(maxOf(`property`?.size ?: 0, _property?.size ?: 0)) { index ->
            R5String.of(`property`?.getOrNull(index), _property?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'property' on ValueSet.Compose has neither a value nor an id/extension"
              )
          }),
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
      if (value.`property`.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          stringNullableListSerializer,
          value.`property`.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 10, value.`property`)
      }
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
      optionalElement("copyright", KotlinString.serializer().descriptor)
      optionalElement("_copyright", ElementSerializer.descriptor)
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
      var copyright: KotlinString? = null
      var _copyright: Element? = null
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
          11 -> copyright = decodeStringElement(descriptor, i)
          12 ->
            _copyright = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Include: " + i)
        }
      }
      ValueSet.Compose.Include(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        system = Uri.of(system, _system),
        version = R5String.of(version, _version),
        concept = concept ?: listOf(),
        filter = filter ?: listOf(),
        valueSet =
          (kotlin.collections.List(maxOf(valueSet?.size ?: 0, _valueSet?.size ?: 0)) { index ->
            Canonical.of(valueSet?.getOrNull(index), _valueSet?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'valueSet' on ValueSet.Compose.Include has neither a value nor an id/extension"
              )
          }),
        copyright = R5String.of(copyright, _copyright),
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
      encodeStringIfNotNull(descriptor, 11, value.copyright?.value)
      encodeElementIfNotNull(descriptor, 12, value.copyright)
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
        display = R5String.of(display, _display),
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
      optionalElement("additionalUse", CodingSerializer.listSerializer.descriptor)
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
      var additionalUse: List<Coding>? = null
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
          6 ->
            additionalUse =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          7 -> `value` = decodeStringElement(descriptor, i)
          8 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Designation: " + i)
        }
      }
      ValueSet.Compose.Include.Concept.Designation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        language = Code.of(language, _language),
        use = use,
        additionalUse = additionalUse ?: listOf(),
        `value` =
          R5String.of(`value`, _value)
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
      encodeStringIfNotNull(descriptor, 3, value.language?.value)
      encodeElementIfNotNull(descriptor, 4, value.language)
      encodeSerializableIfNotNull(descriptor, 5, CodingSerializer, value.use)
      if (value.additionalUse.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodingSerializer.listSerializer,
          value.additionalUse,
        )
      encodeStringIfNotNull(descriptor, 7, value.`value`.value)
      encodeElementIfNotNull(descriptor, 8, value.`value`)
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
          R5String.of(`value`, _value)
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
      optionalElement("next", KotlinString.serializer().descriptor)
      optionalElement("_next", ElementSerializer.descriptor)
      optionalElement("timestamp", KotlinString.serializer().descriptor)
      optionalElement("_timestamp", ElementSerializer.descriptor)
      optionalElement("total", Int.serializer().descriptor)
      optionalElement("_total", ElementSerializer.descriptor)
      optionalElement("offset", Int.serializer().descriptor)
      optionalElement("_offset", ElementSerializer.descriptor)
      optionalElement("parameter", ValueSetExpansionParameterSerializer.listSerializer.descriptor)
      optionalElement("property", ValueSetExpansionPropertySerializer.listSerializer.descriptor)
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
      var next: KotlinString? = null
      var _next: Element? = null
      var timestamp: KotlinString? = null
      var _timestamp: Element? = null
      var total: Int? = null
      var _total: Element? = null
      var offset: Int? = null
      var _offset: Element? = null
      var parameter: List<ValueSet.Expansion.Parameter>? = null
      var `property`: List<ValueSet.Expansion.Property>? = null
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
          5 -> next = decodeStringElement(descriptor, i)
          6 -> _next = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> timestamp = decodeStringElement(descriptor, i)
          8 ->
            _timestamp = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> total = decodeIntElement(descriptor, i)
          10 -> _total = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> offset = decodeIntElement(descriptor, i)
          12 -> _offset = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            parameter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetExpansionParameterSerializer.listSerializer,
                null,
              )
          14 ->
            `property` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetExpansionPropertySerializer.listSerializer,
                null,
              )
          15 ->
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
        next = Uri.of(next, _next),
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
        `property` = `property` ?: listOf(),
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
      encodeStringIfNotNull(descriptor, 5, value.next?.value)
      encodeElementIfNotNull(descriptor, 6, value.next)
      encodeStringIfNotNull(descriptor, 7, value.timestamp.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.timestamp)
      encodeIntIfNotNull(descriptor, 9, value.total?.value)
      encodeElementIfNotNull(descriptor, 10, value.total)
      encodeIntIfNotNull(descriptor, 11, value.offset?.value)
      encodeElementIfNotNull(descriptor, 12, value.offset)
      if (value.parameter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          ValueSetExpansionParameterSerializer.listSerializer,
          value.parameter,
        )
      if (value.`property`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          ValueSetExpansionPropertySerializer.listSerializer,
          value.`property`,
        )
      if (value.contains.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
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
          R5String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on ValueSet.Expansion.Parameter"
            ),
        `value` =
          ValueSet.Expansion.Parameter.Value.from(
            R5String.of(valueString, _valueString),
            R5Boolean.of(valueBoolean, _valueBoolean),
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

internal object ValueSetExpansionPropertySerializer : KSerializer<ValueSet.Expansion.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("uri", KotlinString.serializer().descriptor)
      optionalElement("_uri", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ValueSet.Expansion.Property>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Property =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var uri: KotlinString? = null
      var _uri: Element? = null
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
          5 -> uri = decodeStringElement(descriptor, i)
          6 -> _uri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      ValueSet.Expansion.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Code.of(code, _code)
            ?: throw SerializationException(
              "Missing required property 'code' on ValueSet.Expansion.Property"
            ),
        uri = Uri.of(uri, _uri),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Property) {
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
      encodeStringIfNotNull(descriptor, 5, value.uri?.value)
      encodeElementIfNotNull(descriptor, 6, value.uri)
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
        "property",
        ValueSetExpansionContainsPropertySerializer.listSerializer.descriptor,
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
      var `property`: List<ValueSet.Expansion.Contains.Property>? = null
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
            `property` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetExpansionContainsPropertySerializer.listSerializer,
                null,
              )
          17 ->
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
        `abstract` = R5Boolean.of(`abstract`, _abstract),
        inactive = R5Boolean.of(inactive, _inactive),
        version = R5String.of(version, _version),
        code = Code.of(code, _code),
        display = R5String.of(display, _display),
        designation = designation ?: listOf(),
        `property` = `property` ?: listOf(),
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
      if (value.`property`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          ValueSetExpansionContainsPropertySerializer.listSerializer,
          value.`property`,
        )
      if (value.contains.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          17,
          ValueSetExpansionContainsSerializer.listSerializer,
          value.contains,
        )
    }
  }
}

internal object ValueSetExpansionContainsPropertySerializer :
  KSerializer<ValueSet.Expansion.Contains.Property> {
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
      optionalElement(
        "subProperty",
        ValueSetExpansionContainsPropertySubPropertySerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ValueSet.Expansion.Contains.Property>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains.Property =
    decoder.decodeStructure(descriptor) {
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
      var subProperty: List<ValueSet.Expansion.Contains.Property.SubProperty>? = null
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
          5 -> valueCode = decodeStringElement(descriptor, i)
          6 ->
            _valueCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          8 -> valueString = decodeStringElement(descriptor, i)
          9 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueInteger = decodeIntElement(descriptor, i)
          11 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueBoolean = decodeBooleanElement(descriptor, i)
          13 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> valueDateTime = decodeStringElement(descriptor, i)
          15 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          17 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 ->
            subProperty =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ValueSetExpansionContainsPropertySubPropertySerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      ValueSet.Expansion.Contains.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Code.of(code, _code)
            ?: throw SerializationException(
              "Missing required property 'code' on ValueSet.Expansion.Contains.Property"
            ),
        `value` =
          ValueSet.Expansion.Contains.Property.Value.from(
            Code.of(valueCode, _valueCode),
            valueCoding,
            R5String.of(valueString, _valueString),
            Integer.of(valueInteger, _valueInteger),
            R5Boolean.of(valueBoolean, _valueBoolean),
            DateTime.of(
              if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
              _valueDateTime,
            ),
            Decimal.of(valueDecimal, _valueDecimal),
          )
            ?: throw SerializationException(
              "Missing required property 'value' on ValueSet.Expansion.Contains.Property"
            ),
        subProperty = subProperty ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains.Property) {
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
      when (val choice = value.`value`) {
        is ValueSet.Expansion.Contains.Property.Value.Code -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.Value.Coding -> {
          encodeSerializableElement(descriptor, 7, CodingSerializer, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.Value.String -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 12, choice.value.value)
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 16, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 17, choice.value)
        }
      }
      if (value.subProperty.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          ValueSetExpansionContainsPropertySubPropertySerializer.listSerializer,
          value.subProperty,
        )
    }
  }
}

internal object ValueSetExpansionContainsPropertySubPropertySerializer :
  KSerializer<ValueSet.Expansion.Contains.Property.SubProperty> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubProperty") {
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

  internal val listSerializer: KSerializer<List<ValueSet.Expansion.Contains.Property.SubProperty>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains.Property.SubProperty =
    decoder.decodeStructure(descriptor) {
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
          5 -> valueCode = decodeStringElement(descriptor, i)
          6 ->
            _valueCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          8 -> valueString = decodeStringElement(descriptor, i)
          9 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueInteger = decodeIntElement(descriptor, i)
          11 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueBoolean = decodeBooleanElement(descriptor, i)
          13 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> valueDateTime = decodeStringElement(descriptor, i)
          15 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          17 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SubProperty: " + i)
        }
      }
      ValueSet.Expansion.Contains.Property.SubProperty(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Code.of(code, _code)
            ?: throw SerializationException(
              "Missing required property 'code' on ValueSet.Expansion.Contains.Property.SubProperty"
            ),
        `value` =
          ValueSet.Expansion.Contains.Property.SubProperty.Value.from(
            Code.of(valueCode, _valueCode),
            valueCoding,
            R5String.of(valueString, _valueString),
            Integer.of(valueInteger, _valueInteger),
            R5Boolean.of(valueBoolean, _valueBoolean),
            DateTime.of(
              if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
              _valueDateTime,
            ),
            Decimal.of(valueDecimal, _valueDecimal),
          )
            ?: throw SerializationException(
              "Missing required property 'value' on ValueSet.Expansion.Contains.Property.SubProperty"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: ValueSet.Expansion.Contains.Property.SubProperty,
  ) {
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
      when (val choice = value.`value`) {
        is ValueSet.Expansion.Contains.Property.SubProperty.Value.Code -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.SubProperty.Value.Coding -> {
          encodeSerializableElement(descriptor, 7, CodingSerializer, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.SubProperty.Value.String -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.SubProperty.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.SubProperty.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 12, choice.value.value)
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.SubProperty.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is ValueSet.Expansion.Contains.Property.SubProperty.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 16, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 17, choice.value)
        }
      }
    }
  }
}

internal object ValueSetScopeSerializer : KSerializer<ValueSet.Scope> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Scope") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("inclusionCriteria", KotlinString.serializer().descriptor)
      optionalElement("_inclusionCriteria", ElementSerializer.descriptor)
      optionalElement("exclusionCriteria", KotlinString.serializer().descriptor)
      optionalElement("_exclusionCriteria", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ValueSet.Scope>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ValueSet.Scope =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var inclusionCriteria: KotlinString? = null
      var _inclusionCriteria: Element? = null
      var exclusionCriteria: KotlinString? = null
      var _exclusionCriteria: Element? = null
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
          3 -> inclusionCriteria = decodeStringElement(descriptor, i)
          4 ->
            _inclusionCriteria =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> exclusionCriteria = decodeStringElement(descriptor, i)
          6 ->
            _exclusionCriteria =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Scope: " + i)
        }
      }
      ValueSet.Scope(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        inclusionCriteria = R5String.of(inclusionCriteria, _inclusionCriteria),
        exclusionCriteria = R5String.of(exclusionCriteria, _exclusionCriteria),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Scope) {
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
      encodeStringIfNotNull(descriptor, 3, value.inclusionCriteria?.value)
      encodeElementIfNotNull(descriptor, 4, value.inclusionCriteria)
      encodeStringIfNotNull(descriptor, 5, value.exclusionCriteria?.value)
      encodeElementIfNotNull(descriptor, 6, value.exclusionCriteria)
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
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
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
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("compose", ValueSetComposeSerializer.descriptor)
    b.optionalElement("expansion", ValueSetExpansionSerializer.descriptor)
    b.optionalElement("scope", ValueSetScopeSerializer.descriptor)
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var compose: ValueSet.Compose? = null
    var expansion: ValueSet.Expansion? = null
    var scope: ValueSet.Scope? = null
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
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> immutable = decoder.decodeBooleanElement(descriptor, i)
        36 ->
          _immutable =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
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
        43 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        44 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        46 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        48 ->
          topic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        49 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        50 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        51 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        52 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        53 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        54 ->
          compose =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetComposeSerializer,
              null,
            )
        55 ->
          expansion =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ValueSetExpansionSerializer,
              null,
            )
        56 ->
          scope =
            decoder.decodeNullableSerializableElement(descriptor, i, ValueSetScopeSerializer, null)
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        ValueSet.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on ValueSet"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      immutable = R5Boolean.of(immutable, _immutable),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      compose = compose,
      expansion = expansion,
      scope = scope,
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
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is ValueSet.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is ValueSet.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeBooleanIfNotNull(descriptor, 35 + descriptorOffset, value.immutable?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.immutable)
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyrightLabel)
    encoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      47 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      54 + descriptorOffset,
      ValueSetComposeSerializer,
      value.compose,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      55 + descriptorOffset,
      ValueSetExpansionSerializer,
      value.expansion,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      56 + descriptorOffset,
      ValueSetScopeSerializer,
      value.scope,
    )
  }
}
