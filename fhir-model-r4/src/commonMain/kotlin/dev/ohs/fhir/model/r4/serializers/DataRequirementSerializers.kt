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
import dev.ohs.fhir.model.r4.terminologies.SortDirection
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object DataRequirementCodeFilterSerializer : FhirSerializer<DataRequirement.CodeFilter> {
  override val descriptor: SerialDescriptor = buildDescriptor("CodeFilter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DataRequirement.CodeFilter>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("path")
    b.strPrim("searchParam")
    b.strPrim("valueSet")
    b.optionalElement(
      "code",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.CodingSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): DataRequirement.CodeFilter {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DataRequirement.CodeFilter(
      id = id,
      extension = listOrEmpty(extension),
      path = R4String.of(path, _path),
      searchParam = R4String.of(searchParam, _searchParam),
      valueSet = Canonical.of(valueSet, _valueSet),
      code = listOrEmpty(code),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.CodeFilter) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      CodingSerializer.listSerializer,
      value.code,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DataRequirementDateFilterSerializer : FhirSerializer<DataRequirement.DateFilter> {
  override val descriptor: SerialDescriptor = buildDescriptor("DateFilter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DataRequirement.DateFilter>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("path")
    b.strPrim("searchParam")
    b.strPrim("valueDateTime")
    b.optionalElement("valuePeriod", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
    b.optionalElement("valueDuration", lazyDescriptor(LazyDescriptorId.DurationSerializer))
  }

  override fun deserialize(decoder: Decoder): DataRequirement.DateFilter {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var searchParam: KotlinString? = null
    var _searchParam: Element? = null
    var valueDateTime: FhirDateTime? = null
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
        6 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DataRequirement.DateFilter(
      id = id,
      extension = listOrEmpty(extension),
      path = R4String.of(path, _path),
      searchParam = R4String.of(searchParam, _searchParam),
      `value` =
        DataRequirement.DateFilter.Value.from(
          DateTime.of(valueDateTime, _valueDateTime),
          valuePeriod,
          valueDuration,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.DateFilter) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
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

internal object DataRequirementSortSerializer : FhirSerializer<DataRequirement.Sort> {
  override val descriptor: SerialDescriptor = buildDescriptor("Sort", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DataRequirement.Sort>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("path")
    b.strPrim("direction")
  }

  override fun deserialize(decoder: Decoder): DataRequirement.Sort {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var direction: SortDirection? = null
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
        4 -> direction = SortDirection.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _direction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DataRequirement.Sort(
      id = id,
      extension = listOrEmpty(extension),
      path = required(R4String.of(path, _path), "DataRequirement.Sort", "path"),
      direction =
        required(Enumeration.of(direction, _direction), "DataRequirement.Sort", "direction"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Sort) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
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

internal object DataRequirementSerializer : FhirSerializer<DataRequirement> {
  override val descriptor: SerialDescriptor = buildDescriptor("DataRequirement", this)

  @JvmField internal val listSerializer: KSerializer<List<DataRequirement>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("type")
    b.strPrimList("profile")
    b.optionalElement(
      "subjectCodeableConcept",
      lazyDescriptor(LazyDescriptorId.CodeableConceptSerializer),
    )
    b.optionalElement("subjectReference", lazyDescriptor(LazyDescriptorId.ReferenceSerializer))
    b.strPrimList("mustSupport")
    b.optionalElement("codeFilter", DataRequirementCodeFilterSerializer.listSerializer.descriptor)
    b.optionalElement("dateFilter", DataRequirementDateFilterSerializer.listSerializer.descriptor)
    b.intPrim("limit")
    b.optionalElement("sort", DataRequirementSortSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DataRequirement {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: FHIRAllTypes? = null
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
        2 -> type = FHIRAllTypes.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val profile_ =
      List(maxSize(profile, _profile)) { index ->
        entryRequired(
          Canonical.of(at(profile, index), at(_profile, index)),
          "DataRequirement",
          "profile",
        )
      }
    val mustSupport_ =
      List(maxSize(mustSupport, _mustSupport)) { index ->
        entryRequired(
          R4String.of(at(mustSupport, index), at(_mustSupport, index)),
          "DataRequirement",
          "mustSupport",
        )
      }
    return DataRequirement(
      id = id,
      extension = listOrEmpty(extension),
      type = required(Enumeration.of(type, _type), "DataRequirement", "type"),
      profile = profile_,
      subject = DataRequirement.Subject.from(subjectCodeableConcept, subjectReference),
      mustSupport = mustSupport_,
      codeFilter = listOrEmpty(codeFilter),
      dateFilter = listOrEmpty(dateFilter),
      limit = PositiveInt.of(limit, _limit),
      sort = listOrEmpty(sort),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DataRequirement) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.type)
    if (!value.profile.isEmpty()) {
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
    if (!value.mustSupport.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.mustSupport.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.mustSupport)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      DataRequirementCodeFilterSerializer.listSerializer,
      value.codeFilter,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      DataRequirementDateFilterSerializer.listSerializer,
      value.dateFilter,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 12, value.limit?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.limit)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      DataRequirementSortSerializer.listSerializer,
      value.sort,
    )
    compositeEncoder.endStructure(descriptor)
  }
}
