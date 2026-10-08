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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DataRequirement
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.FHIRAllTypes
import dev.ohs.fhir.model.r4b.terminologies.SortDirection
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object DataRequirementCodeFilterSerializer : KSerializer<DataRequirement.CodeFilter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CodeFilter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("searchParam", KotlinString.serializer().descriptor)
      optionalElement("_searchParam", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueSet", KotlinString.serializer().descriptor)
      optionalElement("_valueSet", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("code", listSerialDescriptor(lazyDescriptor { CodingSerializer.descriptor }))
    }

  internal val listSerializer: KSerializer<List<DataRequirement.CodeFilter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.CodeFilter {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        2 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> searchParam = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _searchParam =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CodeFilter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DataRequirement.CodeFilter(
      id = id,
      extension = extension ?: listOf(),
      path = R4bString.of(path, _path),
      searchParam = R4bString.of(searchParam, _searchParam),
      valueSet = Canonical.of(valueSet, _valueSet),
      code = code ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.CodeFilter) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.path?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.path)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.searchParam?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.searchParam)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.valueSet?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.valueSet)
    if (value.code.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        CodingSerializer.listSerializer,
        value.code,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DataRequirementDateFilterSerializer : KSerializer<DataRequirement.DateFilter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DateFilter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("searchParam", KotlinString.serializer().descriptor)
      optionalElement("_searchParam", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("valuePeriod", lazyDescriptor { PeriodSerializer.descriptor })
      optionalElement("valueDuration", lazyDescriptor { DurationSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<DataRequirement.DateFilter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.DateFilter {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        2 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> searchParam = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _searchParam =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> valueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        9 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DateFilter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DataRequirement.DateFilter(
      id = id,
      extension = extension ?: listOf(),
      path = R4bString.of(path, _path),
      searchParam = R4bString.of(searchParam, _searchParam),
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.path?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.path)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.searchParam?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.searchParam)
    when (val choice = value.`value`) {
      null -> {}
      is DataRequirement.DateFilter.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is DataRequirement.DateFilter.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, PeriodSerializer, choice.value)
      }
      is DataRequirement.DateFilter.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, DurationSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DataRequirementSortSerializer : KSerializer<DataRequirement.Sort> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Sort") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("direction", KotlinString.serializer().descriptor)
      optionalElement("_direction", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<DataRequirement.Sort>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement.Sort {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var direction: KotlinString? = null
    var _direction: Element? = null
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
        2 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> direction = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _direction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Sort: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DataRequirement.Sort(
      id = id,
      extension = extension ?: listOf(),
      path =
        R4bString.of(path, _path)
          ?: throw SerializationException(
            "Missing required property 'path' on DataRequirement.Sort"
          ),
      direction =
        Enumeration.of(
          if (direction != null) SortDirection.fromCode(direction) else null,
          _direction,
        )
          ?: throw SerializationException(
            "Missing required property 'direction' on DataRequirement.Sort"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Sort) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.path.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.path)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.direction.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.direction)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DataRequirementSerializer : KSerializer<DataRequirement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DataRequirement") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("profile", stringNullableListSerializer.descriptor)
      optionalElement(
        "_profile",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement(
        "subjectCodeableConcept",
        lazyDescriptor { CodeableConceptSerializer.descriptor },
      )
      optionalElement("subjectReference", lazyDescriptor { ReferenceSerializer.descriptor })
      optionalElement("mustSupport", stringNullableListSerializer.descriptor)
      optionalElement(
        "_mustSupport",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement("codeFilter", DataRequirementCodeFilterSerializer.listSerializer.descriptor)
      optionalElement("dateFilter", DataRequirementDateFilterSerializer.listSerializer.descriptor)
      optionalElement("limit", Int.serializer().descriptor)
      optionalElement("_limit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("sort", DataRequirementSortSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DataRequirement>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DataRequirement {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        2 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 ->
          profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        5 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        6 ->
          subjectCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          subjectReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 ->
          mustSupport =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _mustSupport =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 ->
          codeFilter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementCodeFilterSerializer.listSerializer,
              null,
            )
        11 ->
          dateFilter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementDateFilterSerializer.listSerializer,
              null,
            )
        12 -> limit = compositeDecoder.decodeIntElement(descriptor, i)
        13 ->
          _limit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          sort =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSortSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DataRequirement: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DataRequirement(
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
        (kotlin.collections.List(maxOf(mustSupport?.size ?: 0, _mustSupport?.size ?: 0)) { index ->
          R4bString.of(mustSupport?.getOrNull(index), _mustSupport?.getOrNull(index))
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.type)
    if (value.profile.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        4,
        stringNullableListSerializer,
        value.profile.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 5, value.profile)
    }
    when (val choice = value.subject) {
      null -> {}
      is DataRequirement.Subject.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is DataRequirement.Subject.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
    }
    if (value.mustSupport.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.mustSupport.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.mustSupport)
    }
    if (value.codeFilter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        DataRequirementCodeFilterSerializer.listSerializer,
        value.codeFilter,
      )
    if (value.dateFilter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        DataRequirementDateFilterSerializer.listSerializer,
        value.dateFilter,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 12, value.limit?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.limit)
    if (value.sort.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        14,
        DataRequirementSortSerializer.listSerializer,
        value.sort,
      )
    compositeEncoder.endStructure(descriptor)
  }
}
