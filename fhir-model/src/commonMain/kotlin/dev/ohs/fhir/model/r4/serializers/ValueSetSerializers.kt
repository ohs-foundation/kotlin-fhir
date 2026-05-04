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

package dev.ohs.fhir.model.r4.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.terminologies.CommonLanguages
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
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

internal object ValueSetComposeSerializer : KSerializer<ValueSet.Compose> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Compose") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("lockedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lockedDate", Element.serializer().descriptor, isOptional = true)
      element("inactive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_inactive", Element.serializer().descriptor, isOptional = true)
      element(
        "include",
        listSerialDescriptor(lazyDescriptor { ValueSet.Compose.Include.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "exclude",
        listSerialDescriptor(lazyDescriptor { ValueSet.Compose.Include.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ValueSet.Compose =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ValueSet.Compose {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> lockedDate = decoder.decodeStringElement(__desc, 3)
        4 ->
          _lockedDate =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.lockedDateSer, null)
        5 -> inactive = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _inactive =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.lockedDateSer, null)
        7 ->
          include = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.includeSer, null)
        8 ->
          exclude = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.includeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Compose: " + __i)
      }
    }
    return ValueSet.Compose(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      lockedDate = Date.of(FhirDate.fromString(lockedDate), _lockedDate),
      inactive = R4Boolean.of(inactive, _inactive),
      include = include ?: listOf(),
      exclude = exclude ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ValueSet.Compose) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.lockedDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.lockedDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.lockedDateSer, it)
    }
    ((value.inactive?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.inactive?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.lockedDateSer, it)
    }
    if (value.include.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.includeSer, value.include)
    if (value.exclude.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.includeSer, value.exclude)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val lockedDateSer: KSerializer<Element> = Element.serializer()

    public val includeSerInner: KSerializer<ValueSet.Compose.Include> =
      ValueSet.Compose.Include.serializer()

    public val includeSer: KSerializer<List<ValueSet.Compose.Include>> =
      ListSerializer(Hoisted.includeSerInner)
  }
}

internal object ValueSetComposeIncludeSerializer : KSerializer<ValueSet.Compose.Include> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Include") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("system", KotlinString.serializer().descriptor, isOptional = true)
      element("_system", Element.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element(
        "concept",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Compose.Include.Concept.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "filter",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Compose.Include.Filter.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "valueSet",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_valueSet", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ValueSet.Compose.Include {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> system = decoder.decodeStringElement(__desc, 3)
        4 -> _system = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.systemSer, null)
        5 -> version = decoder.decodeStringElement(__desc, 5)
        6 ->
          _version = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.systemSer, null)
        7 ->
          concept = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.conceptSer, null)
        8 -> filter = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.filterSer, null)
        9 ->
          valueSet = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueSetSer, null)
        10 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueSetSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Include: " + __i)
      }
    }
    return ValueSet.Compose.Include(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      system = Uri.of(system, _system),
      version = R4String.of(version, _version),
      concept = concept ?: listOf(),
      filter = filter ?: listOf(),
      valueSet =
        (kotlin.collections.List(maxOf(valueSet?.size ?: 0, _valueSet?.size ?: 0)) { __i ->
          Canonical.of(valueSet?.getOrNull(__i)?.let { it }, _valueSet?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ValueSet.Compose.Include) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.system?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.systemSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.systemSer, it)
    }
    if (value.concept.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.conceptSer, value.concept)
    if (value.filter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.filterSer, value.filter)
    (value.valueSet.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.valueSetSer, it)
    }
    (value.valueSet.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.valueSetSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val systemSer: KSerializer<Element> = Element.serializer()

    public val conceptSerInner: KSerializer<ValueSet.Compose.Include.Concept> =
      ValueSet.Compose.Include.Concept.serializer()

    public val conceptSer: KSerializer<List<ValueSet.Compose.Include.Concept>> =
      ListSerializer(Hoisted.conceptSerInner)

    public val filterSerInner: KSerializer<ValueSet.Compose.Include.Filter> =
      ValueSet.Compose.Include.Filter.serializer()

    public val filterSer: KSerializer<List<ValueSet.Compose.Include.Filter>> =
      ListSerializer(Hoisted.filterSerInner)

    public val valueSetSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val valueSetSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.valueSetSerInner).nullable)

    public val valueSetSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.systemSer).nullable)
  }
}

internal object ValueSetComposeIncludeConceptSerializer :
  KSerializer<ValueSet.Compose.Include.Concept> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Concept") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
      element(
        "designation",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Compose.Include.Concept.Designation.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ValueSet.Compose.Include.Concept {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var designation: List<ValueSet.Compose.Include.Concept.Designation>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> display = decoder.decodeStringElement(__desc, 5)
        6 -> _display = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 ->
          designation =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.designationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Concept: " + __i)
      }
    }
    return ValueSet.Compose.Include.Concept(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      display = R4String.of(display, _display),
      designation = designation ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ValueSet.Compose.Include.Concept) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    if (value.designation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.designationSer, value.designation)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val designationSerInner: KSerializer<ValueSet.Compose.Include.Concept.Designation> =
      ValueSet.Compose.Include.Concept.Designation.serializer()

    public val designationSer: KSerializer<List<ValueSet.Compose.Include.Concept.Designation>> =
      ListSerializer(Hoisted.designationSerInner)
  }
}

internal object ValueSetComposeIncludeConceptDesignationSerializer :
  KSerializer<ValueSet.Compose.Include.Concept.Designation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Designation") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("use", Coding.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept.Designation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept.Designation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ValueSet.Compose.Include.Concept.Designation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var use: Coding? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> language = decoder.decodeStringElement(__desc, 3)
        4 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.languageSer, null)
        5 -> use = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.useSer, null)
        6 -> `value` = decoder.decodeStringElement(__desc, 6)
        7 ->
          _value = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Designation: " + __i)
      }
    }
    return ValueSet.Compose.Include.Concept.Designation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = language?.let { Enumeration.of(CommonLanguages.fromCode(it), _language) },
      use = use,
      `value` = R4String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ValueSet.Compose.Include.Concept.Designation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.language?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.languageSer, it)
    }
    (value.use)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.useSer, it) }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.languageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val languageSer: KSerializer<Element> = Element.serializer()

    public val useSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object ValueSetComposeIncludeFilterSerializer :
  KSerializer<ValueSet.Compose.Include.Filter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Filter") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("property", KotlinString.serializer().descriptor, isOptional = true)
      element("_property", Element.serializer().descriptor, isOptional = true)
      element("op", KotlinString.serializer().descriptor, isOptional = true)
      element("_op", Element.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Filter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Filter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ValueSet.Compose.Include.Filter {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> `property` = decoder.decodeStringElement(__desc, 3)
        4 ->
          _property =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.propertySer, null)
        5 -> op = decoder.decodeStringElement(__desc, 5)
        6 -> _op = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.propertySer, null)
        7 -> `value` = decoder.decodeStringElement(__desc, 7)
        8 ->
          _value = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.propertySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + __i)
      }
    }
    return ValueSet.Compose.Include.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `property` = Code.of(`property`, _property)!!,
      op = Enumeration.of(ValueSet.FilterOperator.fromCode(op!!), _op),
      `value` = R4String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ValueSet.Compose.Include.Filter) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.`property`.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.`property`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.propertySer, it)
    }
    ((value.op.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.op.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.propertySer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.propertySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val propertySer: KSerializer<Element> = Element.serializer()
  }
}

internal object ValueSetExpansionSerializer : KSerializer<ValueSet.Expansion> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Expansion") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("identifier", KotlinString.serializer().descriptor, isOptional = true)
      element("_identifier", Element.serializer().descriptor, isOptional = true)
      element("timestamp", KotlinString.serializer().descriptor, isOptional = true)
      element("_timestamp", Element.serializer().descriptor, isOptional = true)
      element("total", Int.serializer().descriptor, isOptional = true)
      element("_total", Element.serializer().descriptor, isOptional = true)
      element("offset", Int.serializer().descriptor, isOptional = true)
      element("_offset", Element.serializer().descriptor, isOptional = true)
      element(
        "parameter",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Expansion.Parameter.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "contains",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Expansion.Contains.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ValueSet.Expansion {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> identifier = decoder.decodeStringElement(__desc, 3)
        4 ->
          _identifier =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.identifierSer, null)
        5 -> timestamp = decoder.decodeStringElement(__desc, 5)
        6 ->
          _timestamp =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.identifierSer, null)
        7 -> total = decoder.decodeIntElement(__desc, 7)
        8 ->
          _total = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.identifierSer, null)
        9 -> offset = decoder.decodeIntElement(__desc, 9)
        10 ->
          _offset =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.identifierSer, null)
        11 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.parameterSer, null)
        12 ->
          contains =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.containsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Expansion: " + __i)
      }
    }
    return ValueSet.Expansion(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = Uri.of(identifier, _identifier),
      timestamp = DateTime.of(FhirDateTime.fromString(timestamp), _timestamp)!!,
      total = Integer.of(total, _total),
      offset = Integer.of(offset, _offset),
      parameter = parameter ?: listOf(),
      contains = contains ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ValueSet.Expansion) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.identifier?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.identifier?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.identifierSer, it)
    }
    ((value.timestamp.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.timestamp.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.identifierSer, it)
    }
    ((value.total?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.total?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.identifierSer, it)
    }
    ((value.offset?.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
    (value.offset?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.identifierSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.parameterSer, value.parameter)
    if (value.contains.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.containsSer, value.contains)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Element> = Element.serializer()

    public val parameterSerInner: KSerializer<ValueSet.Expansion.Parameter> =
      ValueSet.Expansion.Parameter.serializer()

    public val parameterSer: KSerializer<List<ValueSet.Expansion.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)

    public val containsSerInner: KSerializer<ValueSet.Expansion.Contains> =
      ValueSet.Expansion.Contains.serializer()

    public val containsSer: KSerializer<List<ValueSet.Expansion.Contains>> =
      ListSerializer(Hoisted.containsSerInner)
  }
}

internal object ValueSetExpansionParameterSerializer : KSerializer<ValueSet.Expansion.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element("valueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUri", Element.serializer().descriptor, isOptional = true)
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Parameter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ValueSet.Expansion.Parameter {
    val __desc = descriptor
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
    var valueDecimal: BigDecimal? = null
    var _valueDecimal: Element? = null
    var valueUri: KotlinString? = null
    var _valueUri: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> valueString = decoder.decodeStringElement(__desc, 5)
        6 ->
          _valueString = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        9 -> valueInteger = decoder.decodeIntElement(__desc, 9)
        10 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.nameSer, null)
        11 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 11, BigDecimalSerializer, null)
        12 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.nameSer, null)
        13 -> valueUri = decoder.decodeStringElement(__desc, 13)
        14 ->
          _valueUri = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.nameSer, null)
        15 -> valueCode = decoder.decodeStringElement(__desc, 15)
        16 ->
          _valueCode = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.nameSer, null)
        17 -> valueDateTime = decoder.decodeStringElement(__desc, 17)
        18 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return ValueSet.Expansion.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name)!!,
      `value` =
        ValueSet.Expansion.Parameter.Value.from(
          R4String.of(valueString, _valueString),
          R4Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          Decimal.of(valueDecimal, _valueDecimal),
          Uri.of(valueUri, _valueUri),
          Code.of(valueCode, _valueCode),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
        ),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ValueSet.Expansion.Parameter) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is ValueSet.Expansion.Parameter.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 11, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.nameSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ValueSetExpansionContainsSerializer : KSerializer<ValueSet.Expansion.Contains> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contains") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("system", KotlinString.serializer().descriptor, isOptional = true)
      element("_system", Element.serializer().descriptor, isOptional = true)
      element("abstract", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_abstract", Element.serializer().descriptor, isOptional = true)
      element("inactive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_inactive", Element.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
      element(
        "designation",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Compose.Include.Concept.Designation.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "contains",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Expansion.Contains.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ValueSet.Expansion.Contains {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> system = decoder.decodeStringElement(__desc, 3)
        4 -> _system = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.systemSer, null)
        5 -> `abstract` = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _abstract = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.systemSer, null)
        7 -> inactive = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _inactive = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.systemSer, null)
        9 -> version = decoder.decodeStringElement(__desc, 9)
        10 ->
          _version = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.systemSer, null)
        11 -> code = decoder.decodeStringElement(__desc, 11)
        12 -> _code = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.systemSer, null)
        13 -> display = decoder.decodeStringElement(__desc, 13)
        14 ->
          _display = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.systemSer, null)
        15 ->
          designation =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.designationSer, null)
        16 ->
          contains =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.containsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contains: " + __i)
      }
    }
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ValueSet.Expansion.Contains) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.system?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.systemSer, it)
    }
    ((value.`abstract`?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.`abstract`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.systemSer, it)
    }
    ((value.inactive?.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
    (value.inactive?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.systemSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.systemSer, it)
    }
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.systemSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.systemSer, it)
    }
    if (value.designation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.designationSer, value.designation)
    if (value.contains.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.containsSer, value.contains)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val systemSer: KSerializer<Element> = Element.serializer()

    public val designationSerInner: KSerializer<ValueSet.Compose.Include.Concept.Designation> =
      ValueSet.Compose.Include.Concept.Designation.serializer()

    public val designationSer: KSerializer<List<ValueSet.Compose.Include.Concept.Designation>> =
      ListSerializer(Hoisted.designationSerInner)

    public val containsSerInner: KSerializer<ValueSet.Expansion.Contains> =
      ValueSet.Expansion.Contains.serializer()

    public val containsSer: KSerializer<List<ValueSet.Expansion.Contains>> =
      ListSerializer(Hoisted.containsSerInner)
  }
}

internal object ValueSetSerializer : KSerializer<ValueSet> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ValueSet") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("immutable", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_immutable", Element.serializer().descriptor, isOptional = true)
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element(
        "compose",
        lazyDescriptor { ValueSet.Compose.serializer().descriptor },
        isOptional = true,
      )
      element(
        "expansion",
        lazyDescriptor { ValueSet.Expansion.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ValueSet =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ValueSet {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> name = decoder.decodeStringElement(__desc, 16)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> title = decoder.decodeStringElement(__desc, 18)
        19 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> status = decoder.decodeStringElement(__desc, 20)
        21 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> experimental = decoder.decodeBooleanElement(__desc, 22)
        23 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> date = decoder.decodeStringElement(__desc, 24)
        25 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> publisher = decoder.decodeStringElement(__desc, 26)
        27 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.contactSer, null)
        29 -> description = decoder.decodeStringElement(__desc, 29)
        30 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.useContextSer, null)
        32 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.jurisdictionSer, null)
        33 -> immutable = decoder.decodeBooleanElement(__desc, 33)
        34 ->
          _immutable =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 -> purpose = decoder.decodeStringElement(__desc, 35)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 -> copyright = decoder.decodeStringElement(__desc, 37)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 ->
          compose = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.composeSer, null)
        40 ->
          expansion =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.expansionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ValueSet: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ValueSet) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ValueSet")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 22, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.immutable?.value))?.let { encoder.encodeBooleanElement(__desc, 33, it) }
    (value.immutable?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
    }
    (value.compose)?.let { encoder.encodeSerializableElement(__desc, 39, Hoisted.composeSer, it) }
    (value.expansion)?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.expansionSer, it)
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val composeSer: KSerializer<ValueSet.Compose> = ValueSet.Compose.serializer()

    public val expansionSer: KSerializer<ValueSet.Expansion> = ValueSet.Expansion.serializer()
  }
}
