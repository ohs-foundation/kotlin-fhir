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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.TerminologyCapabilities
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object TerminologyCapabilitiesSoftwareSerializer :
  KSerializer<TerminologyCapabilities.Software> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Software") {
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
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Software =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Software) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TerminologyCapabilities.Software {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
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
        5 -> version = decoder.decodeStringElement(descriptor, i)
        6 ->
          _version = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Software: " + i)
      }
    }
    return TerminologyCapabilities.Software(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on TerminologyCapabilities.Software"
          ),
      version = R4String.of(version, _version),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Software,
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TerminologyCapabilitiesImplementationSerializer :
  KSerializer<TerminologyCapabilities.Implementation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Implementation") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Implementation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Implementation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): TerminologyCapabilities.Implementation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> url = decoder.decodeStringElement(descriptor, i)
        6 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Implementation: " + i)
      }
    }
    return TerminologyCapabilities.Implementation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description =
        R4String.of(description, _description)
          ?: throw SerializationException(
            "Missing required property 'description' on TerminologyCapabilities.Implementation"
          ),
      url = Url.of(url, _url),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Implementation,
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
    ((value.description.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TerminologyCapabilitiesCodeSystemSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CodeSystem") {
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
      element("uri", KotlinString.serializer().descriptor, isOptional = true)
      element("_uri", Element.serializer().descriptor, isOptional = true)
      element(
        "version",
        listSerialDescriptor(
          lazyDescriptor { TerminologyCapabilities.CodeSystem.Version.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("subsumption", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_subsumption", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TerminologyCapabilities.CodeSystem {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var version: List<TerminologyCapabilities.CodeSystem.Version>? = null
    var subsumption: KotlinBoolean? = null
    var _subsumption: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> uri = decoder.decodeStringElement(descriptor, i)
        4 -> _uri = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uriSer, null)
        5 ->
          version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionSer, null)
        6 -> subsumption = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _subsumption =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uriSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CodeSystem: " + i)
      }
    }
    return TerminologyCapabilities.CodeSystem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      uri = Canonical.of(uri, _uri),
      version = version ?: listOf(),
      subsumption = R4Boolean.of(subsumption, _subsumption),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.CodeSystem,
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
    ((value.uri?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.uriSer, it)
    }
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.versionSer, value.version)
    ((value.subsumption?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.subsumption?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.uriSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val uriSer: KSerializer<Element> = Element.serializer()

    public val versionSerInner: KSerializer<TerminologyCapabilities.CodeSystem.Version> =
      TerminologyCapabilities.CodeSystem.Version.serializer()

    public val versionSer: KSerializer<List<TerminologyCapabilities.CodeSystem.Version>> =
      ListSerializer(Hoisted.versionSerInner)
  }
}

internal object TerminologyCapabilitiesCodeSystemVersionSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem.Version> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Version") {
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
      element("isDefault", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isDefault", Element.serializer().descriptor, isOptional = true)
      element("compositional", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_compositional", Element.serializer().descriptor, isOptional = true)
      element(
        "language",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_language", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "filter",
        listSerialDescriptor(
          lazyDescriptor {
            TerminologyCapabilities.CodeSystem.Version.Filter.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_property", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem.Version) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): TerminologyCapabilities.CodeSystem.Version {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var isDefault: KotlinBoolean? = null
    var _isDefault: Element? = null
    var compositional: KotlinBoolean? = null
    var _compositional: Element? = null
    var language: List<KotlinString?>? = null
    var _language: List<Element?>? = null
    var filter: List<TerminologyCapabilities.CodeSystem.Version.Filter>? = null
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
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> isDefault = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _isDefault =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 -> compositional = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _compositional =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        9 ->
          language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        10 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer2, null)
        11 ->
          filter = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.filterSer, null)
        12 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        13 ->
          _property =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + i)
      }
    }
    return TerminologyCapabilities.CodeSystem.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = R4String.of(code, _code),
      isDefault = R4Boolean.of(isDefault, _isDefault),
      compositional = R4Boolean.of(compositional, _compositional),
      language =
        (kotlin.collections.List(maxOf(language?.size ?: 0, _language?.size ?: 0)) { index ->
          Code.of(language?.getOrNull(index)?.let { it }, _language?.getOrNull(index))!!
        }),
      filter = filter ?: listOf(),
      `property` =
        (kotlin.collections.List(maxOf(`property`?.size ?: 0, _property?.size ?: 0)) { index ->
          Code.of(`property`?.getOrNull(index)?.let { it }, _property?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.CodeSystem.Version,
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
    ((value.code?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.isDefault?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.isDefault?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
    ((value.compositional?.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
    (value.compositional?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.codeSer, it)
    }
    (value.language.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.languageSer, it)
    }
    (value.language.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.languageSer2, it)
    }
    if (value.filter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.filterSer, value.filter)
    (value.`property`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.languageSer, it)
    }
    (value.`property`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.languageSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val languageSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val languageSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.languageSerInner).nullable)

    public val languageSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.codeSer).nullable)

    public val filterSerInner: KSerializer<TerminologyCapabilities.CodeSystem.Version.Filter> =
      TerminologyCapabilities.CodeSystem.Version.Filter.serializer()

    public val filterSer: KSerializer<List<TerminologyCapabilities.CodeSystem.Version.Filter>> =
      ListSerializer(Hoisted.filterSerInner)
  }
}

internal object TerminologyCapabilitiesCodeSystemVersionFilterSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem.Version.Filter> {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("op", listSerialDescriptor(KotlinString.serializer().descriptor), isOptional = true)
      element("_op", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version.Filter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: TerminologyCapabilities.CodeSystem.Version.Filter,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): TerminologyCapabilities.CodeSystem.Version.Filter {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var op: List<KotlinString?>? = null
    var _op: List<Element?>? = null
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
        5 -> op = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.opSer, null)
        6 -> _op = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.opSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + i)
      }
    }
    return TerminologyCapabilities.CodeSystem.Version.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Code.of(code, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on TerminologyCapabilities.CodeSystem.Version.Filter"
          ),
      op =
        (kotlin.collections.List(maxOf(op?.size ?: 0, _op?.size ?: 0)) { index ->
          Code.of(op?.getOrNull(index)?.let { it }, _op?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.CodeSystem.Version.Filter,
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
    (value.op.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.opSer, it)
    }
    (value.op.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.opSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val opSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val opSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.opSerInner).nullable)

    public val opSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.codeSer).nullable)
  }
}

internal object TerminologyCapabilitiesExpansionSerializer :
  KSerializer<TerminologyCapabilities.Expansion> {
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
      element("hierarchical", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_hierarchical", Element.serializer().descriptor, isOptional = true)
      element("paging", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_paging", Element.serializer().descriptor, isOptional = true)
      element("incomplete", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_incomplete", Element.serializer().descriptor, isOptional = true)
      element(
        "parameter",
        listSerialDescriptor(
          lazyDescriptor { TerminologyCapabilities.Expansion.Parameter.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("textFilter", KotlinString.serializer().descriptor, isOptional = true)
      element("_textFilter", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TerminologyCapabilities.Expansion {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var hierarchical: KotlinBoolean? = null
    var _hierarchical: Element? = null
    var paging: KotlinBoolean? = null
    var _paging: Element? = null
    var incomplete: KotlinBoolean? = null
    var _incomplete: Element? = null
    var parameter: List<TerminologyCapabilities.Expansion.Parameter>? = null
    var textFilter: KotlinString? = null
    var _textFilter: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> hierarchical = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _hierarchical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.hierarchicalSer, null)
        5 -> paging = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _paging =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.hierarchicalSer, null)
        7 -> incomplete = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _incomplete =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.hierarchicalSer, null)
        9 ->
          parameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parameterSer, null)
        10 -> textFilter = decoder.decodeStringElement(descriptor, i)
        11 ->
          _textFilter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.hierarchicalSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Expansion: " + i)
      }
    }
    return TerminologyCapabilities.Expansion(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      hierarchical = R4Boolean.of(hierarchical, _hierarchical),
      paging = R4Boolean.of(paging, _paging),
      incomplete = R4Boolean.of(incomplete, _incomplete),
      parameter = parameter ?: listOf(),
      textFilter = Markdown.of(textFilter, _textFilter),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Expansion,
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
    ((value.hierarchical?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.hierarchical?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.hierarchicalSer, it)
    }
    ((value.paging?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.paging?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.hierarchicalSer, it)
    }
    ((value.incomplete?.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
    (value.incomplete?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.hierarchicalSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.parameterSer, value.parameter)
    ((value.textFilter?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.textFilter?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.hierarchicalSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val hierarchicalSer: KSerializer<Element> = Element.serializer()

    public val parameterSerInner: KSerializer<TerminologyCapabilities.Expansion.Parameter> =
      TerminologyCapabilities.Expansion.Parameter.serializer()

    public val parameterSer: KSerializer<List<TerminologyCapabilities.Expansion.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)
  }
}

internal object TerminologyCapabilitiesExpansionParameterSerializer :
  KSerializer<TerminologyCapabilities.Expansion.Parameter> {
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
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion.Parameter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion.Parameter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): TerminologyCapabilities.Expansion.Parameter {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    return TerminologyCapabilities.Expansion.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        Code.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on TerminologyCapabilities.Expansion.Parameter"
          ),
      documentation = R4String.of(documentation, _documentation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Expansion.Parameter,
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TerminologyCapabilitiesValidateCodeSerializer :
  KSerializer<TerminologyCapabilities.ValidateCode> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ValidateCode") {
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
      element("translations", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_translations", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.ValidateCode =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.ValidateCode) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TerminologyCapabilities.ValidateCode {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var translations: KotlinBoolean? = null
    var _translations: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> translations = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _translations =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.translationsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ValidateCode: " + i)
      }
    }
    return TerminologyCapabilities.ValidateCode(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      translations =
        R4Boolean.of(translations, _translations)
          ?: throw SerializationException(
            "Missing required property 'translations' on TerminologyCapabilities.ValidateCode"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.ValidateCode,
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
    ((value.translations.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.translations.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.translationsSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val translationsSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TerminologyCapabilitiesTranslationSerializer :
  KSerializer<TerminologyCapabilities.Translation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Translation") {
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
      element("needsMap", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_needsMap", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Translation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Translation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TerminologyCapabilities.Translation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var needsMap: KotlinBoolean? = null
    var _needsMap: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> needsMap = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _needsMap =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.needsMapSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Translation: " + i)
      }
    }
    return TerminologyCapabilities.Translation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      needsMap =
        R4Boolean.of(needsMap, _needsMap)
          ?: throw SerializationException(
            "Missing required property 'needsMap' on TerminologyCapabilities.Translation"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Translation,
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
    ((value.needsMap.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.needsMap.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.needsMapSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val needsMapSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TerminologyCapabilitiesClosureSerializer :
  KSerializer<TerminologyCapabilities.Closure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Closure") {
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
      element("translation", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_translation", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Closure =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Closure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TerminologyCapabilities.Closure {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var translation: KotlinBoolean? = null
    var _translation: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> translation = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _translation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.translationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Closure: " + i)
      }
    }
    return TerminologyCapabilities.Closure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      translation = R4Boolean.of(translation, _translation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Closure,
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
    ((value.translation?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.translation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.translationSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val translationSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TerminologyCapabilitiesSerializer : KSerializer<TerminologyCapabilities> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TerminologyCapabilities") {
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
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
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
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("kind", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_kind", Element.serializer().descriptor, isOptional = true)
    b.element(
      "software",
      lazyDescriptor { TerminologyCapabilities.Software.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "implementation",
      lazyDescriptor { TerminologyCapabilities.Implementation.serializer().descriptor },
      isOptional = true,
    )
    b.element("lockedDate", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_lockedDate", Element.serializer().descriptor, isOptional = true)
    b.element(
      "codeSystem",
      listSerialDescriptor(
        lazyDescriptor { TerminologyCapabilities.CodeSystem.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "expansion",
      lazyDescriptor { TerminologyCapabilities.Expansion.serializer().descriptor },
      isOptional = true,
    )
    b.element("codeSearch", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_codeSearch", Element.serializer().descriptor, isOptional = true)
    b.element(
      "validateCode",
      lazyDescriptor { TerminologyCapabilities.ValidateCode.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "translation",
      lazyDescriptor { TerminologyCapabilities.Translation.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "closure",
      lazyDescriptor { TerminologyCapabilities.Closure.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "TerminologyCapabilities")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): TerminologyCapabilities {
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
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var software: TerminologyCapabilities.Software? = null
    var implementation: TerminologyCapabilities.Implementation? = null
    var lockedDate: KotlinBoolean? = null
    var _lockedDate: Element? = null
    var codeSystem: List<TerminologyCapabilities.CodeSystem>? = null
    var expansion: TerminologyCapabilities.Expansion? = null
    var codeSearch: KotlinString? = null
    var _codeSearch: Element? = null
    var validateCode: TerminologyCapabilities.ValidateCode? = null
    var translation: TerminologyCapabilities.Translation? = null
    var closure: TerminologyCapabilities.Closure? = null
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
        12 -> version = decoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 -> title = decoder.decodeStringElement(descriptor, i)
        17 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        21 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> date = decoder.decodeStringElement(descriptor, i)
        23 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> publisher = decoder.decodeStringElement(descriptor, i)
        25 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        27 -> description = decoder.decodeStringElement(descriptor, i)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        30 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        31 -> purpose = decoder.decodeStringElement(descriptor, i)
        32 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> copyright = decoder.decodeStringElement(descriptor, i)
        34 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> kind = decoder.decodeStringElement(descriptor, i)
        36 ->
          _kind =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 ->
          software =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.softwareSer, null)
        38 ->
          implementation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.implementationSer,
              null,
            )
        39 -> lockedDate = decoder.decodeBooleanElement(descriptor, i)
        40 ->
          _lockedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 ->
          codeSystem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSystemSer, null)
        42 ->
          expansion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.expansionSer, null)
        43 -> codeSearch = decoder.decodeStringElement(descriptor, i)
        44 ->
          _codeSearch =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 ->
          validateCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.validateCodeSer, null)
        46 ->
          translation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.translationSer, null)
        47 ->
          closure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.closureSer, null)
        else ->
          throw SerializationException("Unexpected index decoding TerminologyCapabilities: " + i)
      }
    }
    return TerminologyCapabilities(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on TerminologyCapabilities"
              )
          ),
          _status,
        ),
      experimental = R4Boolean.of(experimental, _experimental),
      date =
        DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date)
          ?: throw SerializationException(
            "Missing required property 'date' on TerminologyCapabilities"
          ),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      kind =
        Enumeration.of(
          TerminologyCapabilities.CapabilityStatementKind.fromCode(
            kind
              ?: throw SerializationException(
                "Missing required property 'kind' on TerminologyCapabilities"
              )
          ),
          _kind,
        ),
      software = software,
      implementation = implementation,
      lockedDate = R4Boolean.of(lockedDate, _lockedDate),
      codeSystem = codeSystem ?: listOf(),
      expansion = expansion,
      codeSearch =
        codeSearch?.let {
          Enumeration.of(TerminologyCapabilities.CodeSearchSupport.fromCode(it), _codeSearch)
        },
      validateCode = validateCode,
      translation = translation,
      closure = closure,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TerminologyCapabilities,
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
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.kind.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.software)?.let {
      encoder.encodeSerializableElement(descriptor, 37 + descriptorOffset, Hoisted.softwareSer, it)
    }
    (value.implementation)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implementationSer,
        it,
      )
    }
    ((value.lockedDate?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.lockedDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.codeSystem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.codeSystemSer,
        value.codeSystem,
      )
    (value.expansion)?.let {
      encoder.encodeSerializableElement(descriptor, 42 + descriptorOffset, Hoisted.expansionSer, it)
    }
    ((value.codeSearch?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.codeSearch?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.validateCode)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.validateCodeSer,
        it,
      )
    }
    (value.translation)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.translationSer,
        it,
      )
    }
    (value.closure)?.let {
      encoder.encodeSerializableElement(descriptor, 47 + descriptorOffset, Hoisted.closureSer, it)
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

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val softwareSer: KSerializer<TerminologyCapabilities.Software> =
      TerminologyCapabilities.Software.serializer()

    public val implementationSer: KSerializer<TerminologyCapabilities.Implementation> =
      TerminologyCapabilities.Implementation.serializer()

    public val codeSystemSerInner: KSerializer<TerminologyCapabilities.CodeSystem> =
      TerminologyCapabilities.CodeSystem.serializer()

    public val codeSystemSer: KSerializer<List<TerminologyCapabilities.CodeSystem>> =
      ListSerializer(Hoisted.codeSystemSerInner)

    public val expansionSer: KSerializer<TerminologyCapabilities.Expansion> =
      TerminologyCapabilities.Expansion.serializer()

    public val validateCodeSer: KSerializer<TerminologyCapabilities.ValidateCode> =
      TerminologyCapabilities.ValidateCode.serializer()

    public val translationSer: KSerializer<TerminologyCapabilities.Translation> =
      TerminologyCapabilities.Translation.serializer()

    public val closureSer: KSerializer<TerminologyCapabilities.Closure> =
      TerminologyCapabilities.Closure.serializer()
  }
}

internal object TerminologyCapabilitiesPolymorphicSerializer :
  KSerializer<TerminologyCapabilities> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TerminologyCapabilities") {
      TerminologyCapabilitiesSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities) {
    encoder.encodeStructure(descriptor) {
      TerminologyCapabilitiesSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities =
    decoder.decodeStructure(descriptor) {
      TerminologyCapabilitiesSerializer.deserializeInternal(this, descriptor, 0)
    }
}
