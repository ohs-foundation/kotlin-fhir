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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object DataRequirementCodeFilterSerializer : KSerializer<DataRequirement.CodeFilter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CodeFilter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("searchParam", KotlinString.serializer().descriptor)
      optionalElement("_searchParam", ElementSerializer.descriptor)
      optionalElement("valueSet", KotlinString.serializer().descriptor)
      optionalElement("_valueSet", ElementSerializer.descriptor)
      optionalElement("code", CodingSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DataRequirement.CodeFilter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.CodeFilter =
    decoder.decodeStructure(descriptor) {
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
          2 -> path = decodeStringElement(descriptor, i)
          3 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> searchParam = decodeStringElement(descriptor, i)
          5 ->
            _searchParam = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> valueSet = decodeStringElement(descriptor, i)
          7 -> _valueSet = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CodeFilter: " + i)
        }
      }
      DataRequirement.CodeFilter(
        id = id,
        extension = extension ?: listOf(),
        path = R4String.of(path, _path),
        searchParam = R4String.of(searchParam, _searchParam),
        valueSet = Canonical.of(valueSet, _valueSet),
        code = code ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.CodeFilter) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.path?.value)
      encodeElementIfNotNull(descriptor, 3, value.path)
      encodeStringIfNotNull(descriptor, 4, value.searchParam?.value)
      encodeElementIfNotNull(descriptor, 5, value.searchParam)
      encodeStringIfNotNull(descriptor, 6, value.valueSet?.value)
      encodeElementIfNotNull(descriptor, 7, value.valueSet)
      if (value.code.isNotEmpty())
        encodeSerializableElement(descriptor, 8, CodingSerializer.listSerializer, value.code)
    }
  }
}

internal object DataRequirementDateFilterSerializer : KSerializer<DataRequirement.DateFilter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DateFilter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("searchParam", KotlinString.serializer().descriptor)
      optionalElement("_searchParam", ElementSerializer.descriptor)
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", ElementSerializer.descriptor)
      optionalElement("valuePeriod", PeriodSerializer.descriptor)
      optionalElement("valueDuration", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DataRequirement.DateFilter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.DateFilter =
    decoder.decodeStructure(descriptor) {
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
          2 -> path = decodeStringElement(descriptor, i)
          3 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> searchParam = decodeStringElement(descriptor, i)
          5 ->
            _searchParam = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> valueDateTime = decodeStringElement(descriptor, i)
          7 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          9 ->
            valueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DateFilter: " + i)
        }
      }
      DataRequirement.DateFilter(
        id = id,
        extension = extension ?: listOf(),
        path = R4String.of(path, _path),
        searchParam = R4String.of(searchParam, _searchParam),
        `value` =
          DataRequirement.DateFilter.Value.from(
            DateTime.of(
              if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
              _valueDateTime,
            ),
            valuePeriod,
            valueDuration,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.DateFilter) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.path?.value)
      encodeElementIfNotNull(descriptor, 3, value.path)
      encodeStringIfNotNull(descriptor, 4, value.searchParam?.value)
      encodeElementIfNotNull(descriptor, 5, value.searchParam)
      when (val choice = value.`value`) {
        null -> {}
        is DataRequirement.DateFilter.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is DataRequirement.DateFilter.Value.Period -> {
          encodeSerializableElement(descriptor, 8, PeriodSerializer, choice.value)
        }
        is DataRequirement.DateFilter.Value.Duration -> {
          encodeSerializableElement(descriptor, 9, DurationSerializer, choice.value)
        }
      }
    }
  }
}

internal object DataRequirementSortSerializer : KSerializer<DataRequirement.Sort> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Sort") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("direction", KotlinString.serializer().descriptor)
      optionalElement("_direction", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DataRequirement.Sort>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.Sort =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var path: KotlinString? = null
      var _path: Element? = null
      var direction: KotlinString? = null
      var _direction: Element? = null
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
          2 -> path = decodeStringElement(descriptor, i)
          3 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> direction = decodeStringElement(descriptor, i)
          5 ->
            _direction = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Sort: " + i)
        }
      }
      DataRequirement.Sort(
        id = id,
        extension = extension ?: listOf(),
        path =
          R4String.of(path, _path)
            ?: throw SerializationException(
              "Missing required property 'path' on DataRequirement.Sort"
            ),
        direction =
          Enumeration.of(
            if (direction != null) DataRequirement.SortDirection.fromCode(direction) else null,
            _direction,
          )
            ?: throw SerializationException(
              "Missing required property 'direction' on DataRequirement.Sort"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Sort) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.path.value)
      encodeElementIfNotNull(descriptor, 3, value.path)
      encodeStringIfNotNull(descriptor, 4, value.direction.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.direction)
    }
  }
}

internal object DataRequirementSerializer : KSerializer<DataRequirement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DataRequirement") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("profile", stringNullableListSerializer.descriptor)
      optionalElement("_profile", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("subjectReference", ReferenceSerializer.descriptor)
      optionalElement("mustSupport", stringNullableListSerializer.descriptor)
      optionalElement("_mustSupport", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("codeFilter", DataRequirementCodeFilterSerializer.listSerializer.descriptor)
      optionalElement("dateFilter", DataRequirementDateFilterSerializer.listSerializer.descriptor)
      optionalElement("limit", Int.serializer().descriptor)
      optionalElement("_limit", ElementSerializer.descriptor)
      optionalElement("sort", DataRequirementSortSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DataRequirement>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement =
    decoder.decodeStructure(descriptor) {
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
          2 -> type = decodeStringElement(descriptor, i)
          3 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 ->
            profile =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          5 ->
            _profile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          6 ->
            subjectCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            subjectReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            mustSupport =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          9 ->
            _mustSupport =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          10 ->
            codeFilter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DataRequirementCodeFilterSerializer.listSerializer,
                null,
              )
          11 ->
            dateFilter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DataRequirementDateFilterSerializer.listSerializer,
                null,
              )
          12 -> limit = decodeIntElement(descriptor, i)
          13 -> _limit = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            sort =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DataRequirementSortSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DataRequirement: " + i)
        }
      }
      DataRequirement(
        id = id,
        extension = extension ?: listOf(),
        type =
          Enumeration.of(if (type != null) FHIRAllTypes.fromCode(type) else null, _type)
            ?: throw SerializationException("Missing required property 'type' on DataRequirement"),
        profile =
          (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { index ->
            Canonical.of(profile?.getOrNull(index), _profile?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'profile' on DataRequirement has neither a value nor an id/extension"
              )
          }),
        subject = DataRequirement.Subject.from(subjectCodeableConcept, subjectReference),
        mustSupport =
          (kotlin.collections.List(maxOf(mustSupport?.size ?: 0, _mustSupport?.size ?: 0)) { index
            ->
            R4String.of(mustSupport?.getOrNull(index), _mustSupport?.getOrNull(index))
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

  override fun serialize(encoder: Encoder, `value`: DataRequirement) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.type)
      if (value.profile.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          4,
          stringNullableListSerializer,
          value.profile.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 5, value.profile)
      }
      when (val choice = value.subject) {
        null -> {}
        is DataRequirement.Subject.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
        is DataRequirement.Subject.Reference -> {
          encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
        }
      }
      if (value.mustSupport.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          8,
          stringNullableListSerializer,
          value.mustSupport.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 9, value.mustSupport)
      }
      if (value.codeFilter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          DataRequirementCodeFilterSerializer.listSerializer,
          value.codeFilter,
        )
      if (value.dateFilter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          DataRequirementDateFilterSerializer.listSerializer,
          value.dateFilter,
        )
      encodeIntIfNotNull(descriptor, 12, value.limit?.value)
      encodeElementIfNotNull(descriptor, 13, value.limit)
      if (value.sort.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          DataRequirementSortSerializer.listSerializer,
          value.sort,
        )
    }
  }
}
