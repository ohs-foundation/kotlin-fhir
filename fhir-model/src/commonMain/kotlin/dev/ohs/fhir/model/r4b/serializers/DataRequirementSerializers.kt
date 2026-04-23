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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.CodeFilter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DataRequirement.CodeFilter {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> path = decoder.decodeStringElement(__desc, 2)
        3 -> _path = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.pathSer, null)
        4 -> searchParam = decoder.decodeStringElement(__desc, 4)
        5 ->
          _searchParam = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.pathSer, null)
        6 -> valueSet = decoder.decodeStringElement(__desc, 6)
        7 -> _valueSet = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.pathSer, null)
        8 -> code = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CodeFilter: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DataRequirement.CodeFilter) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.path?.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.pathSer, it)
    }
    ((value.searchParam?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.searchParam?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.pathSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.pathSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, value.code)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.DateFilter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DataRequirement.DateFilter {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> path = decoder.decodeStringElement(__desc, 2)
        3 -> _path = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.pathSer, null)
        4 -> searchParam = decoder.decodeStringElement(__desc, 4)
        5 ->
          _searchParam = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.pathSer, null)
        6 -> valueDateTime = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.pathSer, null)
        8 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valuePeriodSer, null)
        9 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueDurationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DateFilter: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DataRequirement.DateFilter) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.path?.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.pathSer, it)
    }
    ((value.searchParam?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.searchParam?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.pathSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is DataRequirement.DateFilter.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.pathSer, it)
        }
      }
      is DataRequirement.DateFilter.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.valuePeriodSer, __d.value)
      }
      is DataRequirement.DateFilter.Value.Duration -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.valueDurationSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Sort) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DataRequirement.Sort {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var direction: KotlinString? = null
    var _direction: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> path = decoder.decodeStringElement(__desc, 2)
        3 -> _path = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.pathSer, null)
        4 -> direction = decoder.decodeStringElement(__desc, 4)
        5 ->
          _direction = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.pathSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Sort: " + __i)
      }
    }
    return DataRequirement.Sort(
      id = id,
      extension = extension ?: listOf(),
      path = R4bString.of(path, _path)!!,
      direction = Enumeration.of(DataRequirement.SortDirection.fromCode(direction!!), _direction),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DataRequirement.Sort) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.path.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.pathSer, it)
    }
    ((value.direction.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.direction.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.pathSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DataRequirementSubjectSerializer : KSerializer<DataRequirement.Subject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DataRequirement.Subject") {
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
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Subject) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is DataRequirement.Subject.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.subjectCodeableConceptSer, __d.value)
        }
        is DataRequirement.Subject.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): DataRequirement.Subject =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): DataRequirement.Subject {
    val __desc = descriptor
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        1 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DataRequirement.Subject: " + __i)
      }
    }
    return DataRequirement.Subject.from(subjectCodeableConcept, subjectReference)!!
  }

  private object Hoisted {
    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object DataRequirementDateFilterValueSerializer :
  KSerializer<DataRequirement.DateFilter.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DataRequirement.DateFilter.Value") {
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valuePeriod", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
      element(
        "valueDuration",
        lazyDescriptor { Duration.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun serialize(encoder: Encoder, `value`: DataRequirement.DateFilter.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is DataRequirement.DateFilter.Value.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is DataRequirement.DateFilter.Value.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.valuePeriodSer, __d.value)
        }
        is DataRequirement.DateFilter.Value.Duration -> {
          encodeSerializableElement(__desc, 3, Hoisted.valueDurationSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): DataRequirement.DateFilter.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): DataRequirement.DateFilter.Value {
    val __desc = descriptor
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valuePeriod: Period? = null
    var valueDuration: Duration? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> valueDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.valuePeriodSer, null)
        3 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.valueDurationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding DataRequirement.DateFilter.Value: " + __i
          )
      }
    }
    return DataRequirement.DateFilter.Value.from(
      DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
      valuePeriod,
      valueDuration,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueDurationSer: KSerializer<Duration> = Duration.serializer()
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DataRequirement) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DataRequirement {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(__desc, 2)
        3 -> _type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          profile = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.profileSer, null)
        5 ->
          _profile = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.profileSer2, null)
        6 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        7 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.subjectReferenceSer, null)
        8 ->
          mustSupport =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.profileSer, null)
        9 ->
          _mustSupport =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.profileSer2, null)
        10 ->
          codeFilter =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.codeFilterSer, null)
        11 ->
          dateFilter =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.dateFilterSer, null)
        12 -> limit = decoder.decodeIntElement(__desc, 12)
        13 -> _limit = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.typeSer, null)
        14 -> sort = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.sortSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DataRequirement: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DataRequirement) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.profileSer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.profileSer2, it)
    }
    when (val __d = value.subject) {
      null -> {}
      is DataRequirement.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.subjectCodeableConceptSer, __d.value)
      }
      is DataRequirement.Subject.Reference -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.subjectReferenceSer, __d.value)
      }
    }
    (value.mustSupport.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.profileSer, it)
    }
    (value.mustSupport.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.profileSer2, it)
    }
    if (value.codeFilter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.codeFilterSer, value.codeFilter)
    if (value.dateFilter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.dateFilterSer, value.dateFilter)
    ((value.limit?.value))?.let { encoder.encodeIntElement(__desc, 12, it) }
    (value.limit?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.typeSer, it)
    }
    if (value.sort.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.sortSer, value.sort)
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
