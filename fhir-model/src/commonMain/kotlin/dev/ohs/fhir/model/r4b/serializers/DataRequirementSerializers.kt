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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

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
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

  override fun deserialize(decoder: Decoder): DataRequirement.CodeFilter =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.CodeFilter) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> path = decoder.decodeStringElement(descriptor, i)
        3 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        4 -> searchParam = decoder.decodeStringElement(descriptor, i)
        5 ->
          _searchParam =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        6 -> valueSet = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        8 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CodeFilter: " + i)
      }
    }
    return DataRequirement.CodeFilter(
      id = id,
      extension = extension ?: listOf(),
      path = R4bString.of(path, _path),
      searchParam = R4bString.of(searchParam, _searchParam),
      valueSet = Canonical.of(valueSet, _valueSet),
      code = code ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DataRequirement.CodeFilter) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.pathSer, it)
    }
    ((value.searchParam?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.searchParam?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.pathSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.pathSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.codeSer, value.code)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()

    public val codeSerInner: KSerializer<Coding> = Coding.serializer()

    public val codeSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.codeSerInner)
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

  override fun deserialize(decoder: Decoder): DataRequirement.DateFilter =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.DateFilter) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> path = decoder.decodeStringElement(descriptor, i)
        3 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        4 -> searchParam = decoder.decodeStringElement(descriptor, i)
        5 ->
          _searchParam =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        6 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        8 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        9 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDurationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DateFilter: " + i)
      }
    }
    return DataRequirement.DateFilter(
      id = id,
      extension = extension ?: listOf(),
      path = R4bString.of(path, _path),
      searchParam = R4bString.of(searchParam, _searchParam),
      `value` =
        DataRequirement.DateFilter.Value.from(
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          valuePeriod,
          valueDuration,
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DataRequirement.DateFilter) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.pathSer, it)
    }
    ((value.searchParam?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.searchParam?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.pathSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is DataRequirement.DateFilter.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.pathSer, it)
        }
      }
      is DataRequirement.DateFilter.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.valuePeriodSer, __d.value)
      }
      is DataRequirement.DateFilter.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueDurationSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueDurationSer: KSerializer<Duration> = Duration.serializer()
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

  override fun deserialize(decoder: Decoder): DataRequirement.Sort =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Sort) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> path = decoder.decodeStringElement(descriptor, i)
        3 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        4 -> direction = decoder.decodeStringElement(descriptor, i)
        5 ->
          _direction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Sort: " + i)
      }
    }
    return DataRequirement.Sort(
      id = id,
      extension = extension ?: listOf(),
      path = R4bString.of(path, _path)!!,
      direction = Enumeration.of(DataRequirement.SortDirection.fromCode(direction!!), _direction),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DataRequirement.Sort) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.path.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.pathSer, it)
    }
    ((value.direction.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.direction.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.pathSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()
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

  override fun deserialize(decoder: Decoder): DataRequirement =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: DataRequirement) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(descriptor, i)
        3 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        5 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer2, null)
        6 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        7 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
        8 ->
          mustSupport =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        9 ->
          _mustSupport =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer2, null)
        10 ->
          codeFilter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeFilterSer, null)
        11 ->
          dateFilter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateFilterSer, null)
        12 -> limit = decoder.decodeIntElement(descriptor, i)
        13 ->
          _limit = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 -> sort = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sortSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DataRequirement: " + i)
      }
    }
    return DataRequirement(
      id = id,
      extension = extension ?: listOf(),
      type = Enumeration.of(FHIRAllTypes.fromCode(type!!), _type),
      profile =
        (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { __i ->
          Canonical.of(profile?.getOrNull(__i)?.let { it }, _profile?.getOrNull(__i))!!
        }),
      subject = DataRequirement.Subject.from(subjectCodeableConcept, subjectReference),
      mustSupport =
        (kotlin.collections.List(maxOf(mustSupport?.size ?: 0, _mustSupport?.size ?: 0)) { __i ->
          R4bString.of(mustSupport?.getOrNull(__i)?.let { it }, _mustSupport?.getOrNull(__i))!!
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.profileSer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.profileSer2, it)
    }
    when (val __d = value.subject) {
      null -> {}
      is DataRequirement.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          6,
          Hoisted.subjectCodeableConceptSer,
          __d.value,
        )
      }
      is DataRequirement.Subject.Reference -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.subjectReferenceSer, __d.value)
      }
    }
    (value.mustSupport.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.profileSer, it)
    }
    (value.mustSupport.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.profileSer2, it)
    }
    if (value.codeFilter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.codeFilterSer, value.codeFilter)
    if (value.dateFilter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.dateFilterSer, value.dateFilter)
    ((value.limit?.value))?.let { encoder.encodeIntElement(descriptor, 12, it) }
    (value.limit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.typeSer, it)
    }
    if (value.sort.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.sortSer, value.sort)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val profileSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val profileSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.profileSerInner).nullable)

    public val profileSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.typeSer).nullable)

    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val codeFilterSerInner: KSerializer<DataRequirement.CodeFilter> =
      DataRequirement.CodeFilter.serializer()

    public val codeFilterSer: KSerializer<List<DataRequirement.CodeFilter>> =
      ListSerializer(Hoisted.codeFilterSerInner)

    public val dateFilterSerInner: KSerializer<DataRequirement.DateFilter> =
      DataRequirement.DateFilter.serializer()

    public val dateFilterSer: KSerializer<List<DataRequirement.DateFilter>> =
      ListSerializer(Hoisted.dateFilterSerInner)

    public val sortSerInner: KSerializer<DataRequirement.Sort> = DataRequirement.Sort.serializer()

    public val sortSer: KSerializer<List<DataRequirement.Sort>> =
      ListSerializer(Hoisted.sortSerInner)
  }
}
