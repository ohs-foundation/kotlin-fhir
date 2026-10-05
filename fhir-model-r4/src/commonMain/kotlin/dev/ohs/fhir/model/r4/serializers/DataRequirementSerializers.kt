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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.FHIRAllTypes
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
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object DataRequirementCodeFilterSerializer : KSerializer<DataRequirement.CodeFilter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CodeFilter") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("searchParam", KotlinString.serializer().descriptor, isOptional = true)
      element("_searchParam", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element(
        "code",
        listSerialDescriptor(lazyDescriptor { Coding.serializer().descriptor }),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<DataRequirement.CodeFilter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.CodeFilter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.CodeFilter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DataRequirement.CodeFilter {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var searchParam: KotlinString? = null
    var _searchParam: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var code: List<Coding>? = null
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
        2 -> path = decoder.decodeStringElement(descriptor, i)
        3 ->
          _path = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> searchParam = decoder.decodeStringElement(descriptor, i)
        5 ->
          _searchParam =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> valueSet = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CodeFilter: " + i)
      }
    }
    return DataRequirement.CodeFilter(
      id = id,
      extension = extension ?: listOf(),
      path = R4String.of(path, _path),
      searchParam = R4String.of(searchParam, _searchParam),
      valueSet = Canonical.of(valueSet, _valueSet),
      code = code ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DataRequirement.CodeFilter) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, ElementSerializer, it)
    }
    ((value.searchParam?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.searchParam?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, CodingSerializer.listSerializer, value.code)
  }
}

internal object DataRequirementDateFilterSerializer : KSerializer<DataRequirement.DateFilter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DateFilter") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("searchParam", KotlinString.serializer().descriptor, isOptional = true)
      element("_searchParam", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_valueDateTime",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("valuePeriod", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
      element(
        "valueDuration",
        lazyDescriptor { Duration.serializer().descriptor },
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<DataRequirement.DateFilter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.DateFilter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.DateFilter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DataRequirement.DateFilter {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var searchParam: KotlinString? = null
    var _searchParam: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valuePeriod: Period? = null
    var valueDuration: Duration? = null
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
        2 -> path = decoder.decodeStringElement(descriptor, i)
        3 ->
          _path = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> searchParam = decoder.decodeStringElement(descriptor, i)
        5 ->
          _searchParam =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        9 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DateFilter: " + i)
      }
    }
    return DataRequirement.DateFilter(
      id = id,
      extension = extension ?: listOf(),
      path = R4String.of(path, _path),
      searchParam = R4String.of(searchParam, _searchParam),
      `value` =
        DataRequirement.DateFilter.Value.from(
          DateTime.of(valueDateTime?.let { FhirDateTime.fromString(it) }, _valueDateTime),
          valuePeriod,
          valueDuration,
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DataRequirement.DateFilter) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, ElementSerializer, it)
    }
    ((value.searchParam?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.searchParam?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    when (val choice = value.`value`) {
      null -> {}
      is DataRequirement.DateFilter.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
        }
      }
      is DataRequirement.DateFilter.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 8, PeriodSerializer, choice.value)
      }
      is DataRequirement.DateFilter.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 9, DurationSerializer, choice.value)
      }
    }
  }
}

internal object DataRequirementSortSerializer : KSerializer<DataRequirement.Sort> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Sort") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("direction", KotlinString.serializer().descriptor, isOptional = true)
      element("_direction", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<DataRequirement.Sort>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.Sort =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Sort) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DataRequirement.Sort {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var direction: KotlinString? = null
    var _direction: Element? = null
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
        2 -> path = decoder.decodeStringElement(descriptor, i)
        3 ->
          _path = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> direction = decoder.decodeStringElement(descriptor, i)
        5 ->
          _direction =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Sort: " + i)
      }
    }
    return DataRequirement.Sort(
      id = id,
      extension = extension ?: listOf(),
      path =
        R4String.of(path, _path)
          ?: throw SerializationException(
            "Missing required property 'path' on DataRequirement.Sort"
          ),
      direction =
        Enumeration.of(direction?.let { DataRequirement.SortDirection.fromCode(it) }, _direction)
          ?: throw SerializationException(
            "Missing required property 'direction' on DataRequirement.Sort"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DataRequirement.Sort) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    ((value.path.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, ElementSerializer, it)
    }
    ((value.direction.value?.code))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.direction.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
  }
}

internal object DataRequirementSerializer : KSerializer<DataRequirement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DataRequirement") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element(
        "profile",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_profile",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "subjectCodeableConcept",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element(
        "subjectReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element(
        "mustSupport",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_mustSupport",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "codeFilter",
        listSerialDescriptor(lazyDescriptor { DataRequirement.CodeFilter.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "dateFilter",
        listSerialDescriptor(lazyDescriptor { DataRequirement.DateFilter.serializer().descriptor }),
        isOptional = true,
      )
      element("limit", Int.serializer().descriptor, isOptional = true)
      element("_limit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element(
        "sort",
        listSerialDescriptor(lazyDescriptor { DataRequirement.Sort.serializer().descriptor }),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<DataRequirement>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DataRequirement {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var profile: List<KotlinString?>? = null
    var _profile: List<Element?>? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var mustSupport: List<KotlinString?>? = null
    var _mustSupport: List<Element?>? = null
    var codeFilter: List<DataRequirement.CodeFilter>? = null
    var dateFilter: List<DataRequirement.DateFilter>? = null
    var limit: Int? = null
    var _limit: Element? = null
    var sort: List<DataRequirement.Sort>? = null
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
        2 -> type = decoder.decodeStringElement(descriptor, i)
        3 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 ->
          profile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        5 ->
          _profile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        6 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        8 ->
          mustSupport =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _mustSupport =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 ->
          codeFilter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementCodeFilterSerializer.listSerializer,
              null,
            )
        11 ->
          dateFilter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementDateFilterSerializer.listSerializer,
              null,
            )
        12 -> limit = decoder.decodeIntElement(descriptor, i)
        13 ->
          _limit = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          sort =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSortSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DataRequirement: " + i)
      }
    }
    return DataRequirement(
      id = id,
      extension = extension ?: listOf(),
      type =
        Enumeration.of(type?.let { FHIRAllTypes.fromCode(it) }, _type)
          ?: throw SerializationException("Missing required property 'type' on DataRequirement"),
      profile =
        (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { index ->
          Canonical.of(profile?.getOrNull(index)?.let { it }, _profile?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'profile' on DataRequirement has neither a value nor an id/extension"
            )
        }),
      subject = DataRequirement.Subject.from(subjectCodeableConcept, subjectReference),
      mustSupport =
        (kotlin.collections.List(maxOf(mustSupport?.size ?: 0, _mustSupport?.size ?: 0)) { index ->
          R4String.of(mustSupport?.getOrNull(index)?.let { it }, _mustSupport?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'mustSupport' on DataRequirement has neither a value nor an id/extension"
            )
        }),
      codeFilter = codeFilter ?: listOf(),
      dateFilter = dateFilter ?: listOf(),
      limit = PositiveInt.of(limit, _limit),
      sort = sort ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DataRequirement) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, ElementSerializer, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, stringNullableListSerializer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer.nullableListSerializer, it)
    }
    when (val choice = value.subject) {
      null -> {}
      is DataRequirement.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
      }
      is DataRequirement.Subject.Reference -> {
        encoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
    }
    (value.mustSupport.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, stringNullableListSerializer, it)
    }
    (value.mustSupport.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer.nullableListSerializer, it)
    }
    if (value.codeFilter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        DataRequirementCodeFilterSerializer.listSerializer,
        value.codeFilter,
      )
    if (value.dateFilter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        DataRequirementDateFilterSerializer.listSerializer,
        value.dateFilter,
      )
    ((value.limit?.value))?.let { encoder.encodeIntElement(descriptor, 12, it) }
    (value.limit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
    }
    if (value.sort.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        DataRequirementSortSerializer.listSerializer,
        value.sort,
      )
  }
}
