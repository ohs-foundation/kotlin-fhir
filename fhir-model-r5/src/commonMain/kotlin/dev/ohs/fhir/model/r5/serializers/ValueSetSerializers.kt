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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
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
import kotlinx.serialization.builtins.nullable
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
      element(
        "property",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_property", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Compose =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Compose {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> lockedDate = decoder.decodeStringElement(descriptor, i)
        4 ->
          _lockedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lockedDateSer, null)
        5 -> inactive = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _inactive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lockedDateSer, null)
        7 ->
          include =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.includeSer, null)
        8 ->
          exclude =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.includeSer, null)
        9 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        10 ->
          _property =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Compose: " + i)
      }
    }
    return ValueSet.Compose(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      lockedDate = Date.of(FhirDate.fromString(lockedDate), _lockedDate),
      inactive = R5Boolean.of(inactive, _inactive),
      include = include ?: listOf(),
      exclude = exclude ?: listOf(),
      `property` =
        (kotlin.collections.List(maxOf(`property`?.size ?: 0, _property?.size ?: 0)) { index ->
          R5String.of(`property`?.getOrNull(index)?.let { it }, _property?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ValueSet.Compose) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.lockedDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.lockedDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.lockedDateSer, it)
    }
    ((value.inactive?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.inactive?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.lockedDateSer, it)
    }
    if (value.include.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.includeSer, value.include)
    if (value.exclude.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.includeSer, value.exclude)
    (value.`property`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.propertySer, it)
    }
    (value.`property`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.propertySer2, it)
    }
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

    public val propertySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val propertySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.propertySerInner).nullable)

    public val propertySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.lockedDateSer).nullable)
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
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Compose.Include {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> system = decoder.decodeStringElement(descriptor, i)
        4 ->
          _system =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        5 -> version = decoder.decodeStringElement(descriptor, i)
        6 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        7 ->
          concept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conceptSer, null)
        8 ->
          filter = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.filterSer, null)
        9 ->
          valueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSetSer, null)
        10 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSetSer2, null)
        11 -> copyright = decoder.decodeStringElement(descriptor, i)
        12 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Include: " + i)
      }
    }
    return ValueSet.Compose.Include(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      system = Uri.of(system, _system),
      version = R5String.of(version, _version),
      concept = concept ?: listOf(),
      filter = filter ?: listOf(),
      valueSet =
        (kotlin.collections.List(maxOf(valueSet?.size ?: 0, _valueSet?.size ?: 0)) { index ->
          Canonical.of(valueSet?.getOrNull(index)?.let { it }, _valueSet?.getOrNull(index))!!
        }),
      copyright = R5String.of(copyright, _copyright),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ValueSet.Compose.Include) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.system?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.systemSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.systemSer, it)
    }
    if (value.concept.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.conceptSer, value.concept)
    if (value.filter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.filterSer, value.filter)
    (value.valueSet.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueSetSer, it)
    }
    (value.valueSet.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueSetSer2, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.systemSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Compose.Include.Concept {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var designation: List<ValueSet.Compose.Include.Concept.Designation>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> display = decoder.decodeStringElement(descriptor, i)
        6 ->
          _display = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 ->
          designation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.designationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Concept: " + i)
      }
    }
    return ValueSet.Compose.Include.Concept(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      display = R5String.of(display, _display),
      designation = designation ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ValueSet.Compose.Include.Concept,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
    if (value.designation.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.designationSer, value.designation)
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
      element(
        "additionalUse",
        listSerialDescriptor(Coding.serializer().descriptor),
        isOptional = true,
      )
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept.Designation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept.Designation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ValueSet.Compose.Include.Concept.Designation {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> language = decoder.decodeStringElement(descriptor, i)
        4 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        5 -> use = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        6 ->
          additionalUse =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.additionalUseSer, null)
        7 -> `value` = decoder.decodeStringElement(descriptor, i)
        8 ->
          _value =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Designation: " + i)
      }
    }
    return ValueSet.Compose.Include.Concept.Designation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = Code.of(language, _language),
      use = use,
      additionalUse = additionalUse ?: listOf(),
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ValueSet.Compose.Include.Concept.Designation,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.language?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.languageSer, it)
    }
    (value.use)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.useSer, it) }
    if (value.additionalUse.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        Hoisted.additionalUseSer,
        value.additionalUse,
      )
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.languageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val languageSer: KSerializer<Element> = Element.serializer()

    public val useSer: KSerializer<Coding> = Coding.serializer()

    public val additionalUseSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.useSer)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Filter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Compose.Include.Filter {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> `property` = decoder.decodeStringElement(descriptor, i)
        4 ->
          _property =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        5 -> op = decoder.decodeStringElement(descriptor, i)
        6 ->
          _op = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        7 -> `value` = decoder.decodeStringElement(descriptor, i)
        8 ->
          _value =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + i)
      }
    }
    return ValueSet.Compose.Include.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `property` = Code.of(`property`, _property)!!,
      op = Enumeration.of(ValueSet.FilterOperator.fromCode(op!!), _op),
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ValueSet.Compose.Include.Filter,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.`property`.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.`property`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.propertySer, it)
    }
    ((value.op.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.op.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.propertySer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.propertySer, it)
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
      element("next", KotlinString.serializer().descriptor, isOptional = true)
      element("_next", Element.serializer().descriptor, isOptional = true)
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
        "property",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Expansion.Property.serializer().descriptor }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Expansion {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> identifier = decoder.decodeStringElement(descriptor, i)
        4 ->
          _identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        5 -> next = decoder.decodeStringElement(descriptor, i)
        6 ->
          _next =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        7 -> timestamp = decoder.decodeStringElement(descriptor, i)
        8 ->
          _timestamp =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        9 -> total = decoder.decodeIntElement(descriptor, i)
        10 ->
          _total =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> offset = decoder.decodeIntElement(descriptor, i)
        12 ->
          _offset =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 ->
          parameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parameterSer, null)
        14 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        15 ->
          contains =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Expansion: " + i)
      }
    }
    return ValueSet.Expansion(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = Uri.of(identifier, _identifier),
      next = Uri.of(next, _next),
      timestamp = DateTime.of(FhirDateTime.fromString(timestamp), _timestamp)!!,
      total = Integer.of(total, _total),
      offset = Integer.of(offset, _offset),
      parameter = parameter ?: listOf(),
      `property` = `property` ?: listOf(),
      contains = contains ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ValueSet.Expansion) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.identifier?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.identifier?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.identifierSer, it)
    }
    ((value.next?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.next?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.identifierSer, it)
    }
    ((value.timestamp.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.timestamp.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.identifierSer, it)
    }
    ((value.total?.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
    (value.total?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.identifierSer, it)
    }
    ((value.offset?.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
    (value.offset?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.identifierSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.parameterSer, value.parameter)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.propertySer, value.`property`)
    if (value.contains.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.containsSer, value.contains)
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

    public val propertySerInner: KSerializer<ValueSet.Expansion.Property> =
      ValueSet.Expansion.Property.serializer()

    public val propertySer: KSerializer<List<ValueSet.Expansion.Property>> =
      ListSerializer(Hoisted.propertySerInner)

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
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element("valueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUri", Element.serializer().descriptor, isOptional = true)
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Parameter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Parameter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Expansion.Parameter {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> valueString = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        9 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        10 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        11 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        12 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        13 -> valueUri = decoder.decodeStringElement(descriptor, i)
        14 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        15 -> valueCode = decoder.decodeStringElement(descriptor, i)
        16 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        17 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    return ValueSet.Expansion.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      `value` =
        ValueSet.Expansion.Parameter.Value.from(
          R5String.of(valueString, _valueString),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          Decimal.of(valueDecimal, _valueDecimal),
          Uri.of(valueUri, _valueUri),
          Code.of(valueCode, _valueCode),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ValueSet.Expansion.Parameter) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    when (val choice = value.`value`) {
      null -> {}
      is ValueSet.Expansion.Parameter.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 11, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, Hoisted.nameSer, it)
        }
      }
      is ValueSet.Expansion.Parameter.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.nameSer, it)
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

internal object ValueSetExpansionPropertySerializer : KSerializer<ValueSet.Expansion.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
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
      element("uri", KotlinString.serializer().descriptor, isOptional = true)
      element("_uri", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Property =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Property) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Expansion.Property {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> uri = decoder.decodeStringElement(descriptor, i)
        6 -> _uri = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    return ValueSet.Expansion.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      uri = Uri.of(uri, _uri),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ValueSet.Expansion.Property) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.uri?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()
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
        "property",
        listSerialDescriptor(
          lazyDescriptor { ValueSet.Expansion.Contains.Property.serializer().descriptor }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Expansion.Contains {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> system = decoder.decodeStringElement(descriptor, i)
        4 ->
          _system =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        5 -> `abstract` = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _abstract =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        7 -> inactive = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _inactive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        9 -> version = decoder.decodeStringElement(descriptor, i)
        10 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        11 -> code = decoder.decodeStringElement(descriptor, i)
        12 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        13 -> display = decoder.decodeStringElement(descriptor, i)
        14 ->
          _display =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        15 ->
          designation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.designationSer, null)
        16 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        17 ->
          contains =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contains: " + i)
      }
    }
    return ValueSet.Expansion.Contains(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ValueSet.Expansion.Contains) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.system?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.systemSer, it)
    }
    ((value.`abstract`?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.`abstract`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.systemSer, it)
    }
    ((value.inactive?.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
    (value.inactive?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.systemSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.systemSer, it)
    }
    ((value.code?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.systemSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.systemSer, it)
    }
    if (value.designation.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.designationSer, value.designation)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.propertySer, value.`property`)
    if (value.contains.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.containsSer, value.contains)
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

    public val propertySerInner: KSerializer<ValueSet.Expansion.Contains.Property> =
      ValueSet.Expansion.Contains.Property.serializer()

    public val propertySer: KSerializer<List<ValueSet.Expansion.Contains.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val containsSerInner: KSerializer<ValueSet.Expansion.Contains> =
      ValueSet.Expansion.Contains.serializer()

    public val containsSer: KSerializer<List<ValueSet.Expansion.Contains>> =
      ListSerializer(Hoisted.containsSerInner)
  }
}

internal object ValueSetExpansionContainsPropertySerializer :
  KSerializer<ValueSet.Expansion.Contains.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
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
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element(
        "subProperty",
        listSerialDescriptor(
          lazyDescriptor {
            ValueSet.Expansion.Contains.Property.SubProperty.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains.Property =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains.Property) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Expansion.Contains.Property {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> valueCode = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        8 -> valueString = decoder.decodeStringElement(descriptor, i)
        9 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        10 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        12 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        14 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        18 ->
          subProperty =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subPropertySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    return ValueSet.Expansion.Contains.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      `value` =
        ValueSet.Expansion.Contains.Property.Value.from(
          Code.of(valueCode, _valueCode),
          valueCoding,
          R5String.of(valueString, _valueString),
          Integer.of(valueInteger, _valueInteger),
          R5Boolean.of(valueBoolean, _valueBoolean),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
        )!!,
      subProperty = subProperty ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ValueSet.Expansion.Contains.Property,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    when (val choice = value.`value`) {
      is ValueSet.Expansion.Contains.Property.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueCodingSer, choice.value)
      }
      is ValueSet.Expansion.Contains.Property.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 16, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 17, Hoisted.codeSer, it)
        }
      }
    }
    if (value.subProperty.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.subPropertySer, value.subProperty)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val subPropertySerInner: KSerializer<ValueSet.Expansion.Contains.Property.SubProperty> =
      ValueSet.Expansion.Contains.Property.SubProperty.serializer()

    public val subPropertySer: KSerializer<List<ValueSet.Expansion.Contains.Property.SubProperty>> =
      ListSerializer(Hoisted.subPropertySerInner)
  }
}

internal object ValueSetExpansionContainsPropertySubPropertySerializer :
  KSerializer<ValueSet.Expansion.Contains.Property.SubProperty> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubProperty") {
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
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains.Property.SubProperty =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: ValueSet.Expansion.Contains.Property.SubProperty,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ValueSet.Expansion.Contains.Property.SubProperty {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> valueCode = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        8 -> valueString = decoder.decodeStringElement(descriptor, i)
        9 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        10 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        12 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        14 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubProperty: " + i)
      }
    }
    return ValueSet.Expansion.Contains.Property.SubProperty(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      `value` =
        ValueSet.Expansion.Contains.Property.SubProperty.Value.from(
          Code.of(valueCode, _valueCode),
          valueCoding,
          R5String.of(valueString, _valueString),
          Integer.of(valueInteger, _valueInteger),
          R5Boolean.of(valueBoolean, _valueBoolean),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
        )!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ValueSet.Expansion.Contains.Property.SubProperty,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    when (val choice = value.`value`) {
      is ValueSet.Expansion.Contains.Property.SubProperty.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.SubProperty.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueCodingSer, choice.value)
      }
      is ValueSet.Expansion.Contains.Property.SubProperty.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.SubProperty.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.SubProperty.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.SubProperty.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.codeSer, it)
        }
      }
      is ValueSet.Expansion.Contains.Property.SubProperty.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 16, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 17, Hoisted.codeSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object ValueSetScopeSerializer : KSerializer<ValueSet.Scope> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Scope") {
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
      element("inclusionCriteria", KotlinString.serializer().descriptor, isOptional = true)
      element("_inclusionCriteria", Element.serializer().descriptor, isOptional = true)
      element("exclusionCriteria", KotlinString.serializer().descriptor, isOptional = true)
      element("_exclusionCriteria", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ValueSet.Scope =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet.Scope) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ValueSet.Scope {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var inclusionCriteria: KotlinString? = null
    var _inclusionCriteria: Element? = null
    var exclusionCriteria: KotlinString? = null
    var _exclusionCriteria: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> inclusionCriteria = decoder.decodeStringElement(descriptor, i)
        4 ->
          _inclusionCriteria =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.inclusionCriteriaSer,
              null,
            )
        5 -> exclusionCriteria = decoder.decodeStringElement(descriptor, i)
        6 ->
          _exclusionCriteria =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.inclusionCriteriaSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Scope: " + i)
      }
    }
    return ValueSet.Scope(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      inclusionCriteria = R5String.of(inclusionCriteria, _inclusionCriteria),
      exclusionCriteria = R5String.of(exclusionCriteria, _exclusionCriteria),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ValueSet.Scope) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.inclusionCriteria?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.inclusionCriteria?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.inclusionCriteriaSer, it)
    }
    ((value.exclusionCriteria?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.exclusionCriteria?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.inclusionCriteriaSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val inclusionCriteriaSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ValueSetSerializer : KSerializer<ValueSet> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ValueSet") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("immutable", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_immutable", Element.serializer().descriptor, isOptional = true)
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "topic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "compose",
      lazyDescriptor { ValueSet.Compose.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "expansion",
      lazyDescriptor { ValueSet.Expansion.serializer().descriptor },
      isOptional = true,
    )
    b.element("scope", lazyDescriptor { ValueSet.Scope.serializer().descriptor }, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): ValueSet =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ValueSet) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ValueSet")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        35 -> immutable = decoder.decodeBooleanElement(descriptor, i)
        36 ->
          _immutable =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> purpose = decoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> copyright = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        42 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        44 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        46 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        47 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        48 ->
          topic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        49 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        50 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        51 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        52 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        53 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        54 ->
          compose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.composeSer, null)
        55 ->
          expansion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.expansionSer, null)
        56 ->
          scope = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scopeSer, null)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      immutable = R5Boolean.of(immutable, _immutable),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ValueSet,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is ValueSet.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ValueSet.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.immutable?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.immutable?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 45 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.compose)?.let {
      encoder.encodeSerializableElement(descriptor, 54 + descriptorOffset, Hoisted.composeSer, it)
    }
    (value.expansion)?.let {
      encoder.encodeSerializableElement(descriptor, 55 + descriptorOffset, Hoisted.expansionSer, it)
    }
    (value.scope)?.let {
      encoder.encodeSerializableElement(descriptor, 56 + descriptorOffset, Hoisted.scopeSer, it)
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

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val composeSer: KSerializer<ValueSet.Compose> = ValueSet.Compose.serializer()

    public val expansionSer: KSerializer<ValueSet.Expansion> = ValueSet.Expansion.serializer()

    public val scopeSer: KSerializer<ValueSet.Scope> = ValueSet.Scope.serializer()
  }
}

internal object ValueSetPolymorphicSerializer : KSerializer<ValueSet> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ValueSet") { ValueSetSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ValueSet) {
    encoder.encodeStructure(descriptor) {
      ValueSetSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ValueSet =
    decoder.decodeStructure(descriptor) {
      ValueSetSerializer.deserializeInternal(this, descriptor, 0)
    }
}
