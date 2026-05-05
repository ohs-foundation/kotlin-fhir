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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Software) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TerminologyCapabilities.Software {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
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
        5 -> version = decoder.decodeStringElement(__desc, 5)
        6 -> _version = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Software: " + __i)
      }
    }
    return TerminologyCapabilities.Software(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name)!!,
      version = R4String.of(version, _version),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TerminologyCapabilities.Software) {
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
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Implementation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TerminologyCapabilities.Implementation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> url = decoder.decodeStringElement(__desc, 5)
        6 ->
          _url = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Implementation: " + __i)
      }
    }
    return TerminologyCapabilities.Implementation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description)!!,
      url = Url.of(url, _url),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Implementation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TerminologyCapabilities.CodeSystem {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var version: List<TerminologyCapabilities.CodeSystem.Version>? = null
    var subsumption: KotlinBoolean? = null
    var _subsumption: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> uri = decoder.decodeStringElement(__desc, 3)
        4 -> _uri = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.uriSer, null)
        5 ->
          version = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.versionSer, null)
        6 -> subsumption = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _subsumption = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.uriSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CodeSystem: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.CodeSystem,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.uri?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.uriSer, it)
    }
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.versionSer, value.version)
    ((value.subsumption?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.subsumption?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.uriSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem.Version) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): TerminologyCapabilities.CodeSystem.Version {
    val __desc = descriptor
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
        5 -> isDefault = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _isDefault = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 -> compositional = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _compositional =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        9 ->
          language = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.languageSer, null)
        10 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.languageSer2, null)
        11 ->
          filter = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.filterSer, null)
        12 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.languageSer, null)
        13 ->
          _property =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.languageSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + __i)
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
        (kotlin.collections.List(maxOf(language?.size ?: 0, _language?.size ?: 0)) { __i ->
          Code.of(language?.getOrNull(__i)?.let { it }, _language?.getOrNull(__i))!!
        }),
      filter = filter ?: listOf(),
      `property` =
        (kotlin.collections.List(maxOf(`property`?.size ?: 0, _property?.size ?: 0)) { __i ->
          Code.of(`property`?.getOrNull(__i)?.let { it }, _property?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.CodeSystem.Version,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.isDefault?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.isDefault?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    ((value.compositional?.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
    (value.compositional?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
    (value.language.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.languageSer, it)
    }
    (value.language.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.languageSer2, it)
    }
    if (value.filter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.filterSer, value.filter)
    (value.`property`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.languageSer, it)
    }
    (value.`property`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.languageSer2, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: TerminologyCapabilities.CodeSystem.Version.Filter,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): TerminologyCapabilities.CodeSystem.Version.Filter {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var op: List<KotlinString?>? = null
    var _op: List<Element?>? = null
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
        5 -> op = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.opSer, null)
        6 -> _op = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.opSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + __i)
      }
    }
    return TerminologyCapabilities.CodeSystem.Version.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      op =
        (kotlin.collections.List(maxOf(op?.size ?: 0, _op?.size ?: 0)) { __i ->
          Code.of(op?.getOrNull(__i)?.let { it }, _op?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.CodeSystem.Version.Filter,
  ) {
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
    (value.op.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.opSer, it)
    }
    (value.op.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.opSer2, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TerminologyCapabilities.Expansion {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> hierarchical = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _hierarchical =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.hierarchicalSer, null)
        5 -> paging = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _paging =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.hierarchicalSer, null)
        7 -> incomplete = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _incomplete =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.hierarchicalSer, null)
        9 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.parameterSer, null)
        10 -> textFilter = decoder.decodeStringElement(__desc, 10)
        11 ->
          _textFilter =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.hierarchicalSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Expansion: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TerminologyCapabilities.Expansion) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.hierarchical?.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.hierarchical?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.hierarchicalSer, it)
    }
    ((value.paging?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.paging?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.hierarchicalSer, it)
    }
    ((value.incomplete?.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
    (value.incomplete?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.hierarchicalSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.parameterSer, value.parameter)
    ((value.textFilter?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.textFilter?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.hierarchicalSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): TerminologyCapabilities.Expansion.Parameter {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        5 -> documentation = decoder.decodeStringElement(__desc, 5)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return TerminologyCapabilities.Expansion.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Code.of(name, _name)!!,
      documentation = R4String.of(documentation, _documentation),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Expansion.Parameter,
  ) {
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
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.ValidateCode) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TerminologyCapabilities.ValidateCode {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var translations: KotlinBoolean? = null
    var _translations: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> translations = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _translations =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.translationsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ValidateCode: " + __i)
      }
    }
    return TerminologyCapabilities.ValidateCode(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      translations = R4Boolean.of(translations, _translations)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.ValidateCode,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.translations.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.translations.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.translationsSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Translation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TerminologyCapabilities.Translation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var needsMap: KotlinBoolean? = null
    var _needsMap: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> needsMap = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _needsMap =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.needsMapSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Translation: " + __i)
      }
    }
    return TerminologyCapabilities.Translation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      needsMap = R4Boolean.of(needsMap, _needsMap)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: TerminologyCapabilities.Translation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.needsMap.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.needsMap.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.needsMapSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Closure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TerminologyCapabilities.Closure {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var translation: KotlinBoolean? = null
    var _translation: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> translation = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _translation =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.translationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Closure: " + __i)
      }
    }
    return TerminologyCapabilities.Closure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      translation = R4Boolean.of(translation, _translation),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TerminologyCapabilities.Closure) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.translation?.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.translation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.translationSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "TerminologyCapabilities")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): TerminologyCapabilities {
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
        13 -> version = decoder.decodeStringElement(__desc, 13)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(__desc, 15)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(__desc, 17)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 -> status = decoder.decodeStringElement(__desc, 19)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> experimental = decoder.decodeBooleanElement(__desc, 21)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> date = decoder.decodeStringElement(__desc, 23)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> publisher = decoder.decodeStringElement(__desc, 25)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.contactSer, null)
        28 -> description = decoder.decodeStringElement(__desc, 28)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.useContextSer, null)
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.jurisdictionSer, null)
        32 -> purpose = decoder.decodeStringElement(__desc, 32)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 -> copyright = decoder.decodeStringElement(__desc, 34)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> kind = decoder.decodeStringElement(__desc, 36)
        37 ->
          _kind =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 ->
          software =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.softwareSer, null)
        39 ->
          implementation =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implementationSer, null)
        40 -> lockedDate = decoder.decodeBooleanElement(__desc, 40)
        41 ->
          _lockedDate =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 ->
          codeSystem =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.codeSystemSer, null)
        43 ->
          expansion =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.expansionSer, null)
        44 -> codeSearch = decoder.decodeStringElement(__desc, 44)
        45 ->
          _codeSearch =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 ->
          validateCode =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.validateCodeSer, null)
        47 ->
          translation =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.translationSer, null)
        48 ->
          closure = decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.closureSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding TerminologyCapabilities: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date)!!,
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      kind =
        Enumeration.of(TerminologyCapabilities.CapabilityStatementKind.fromCode(kind!!), _kind),
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

  internal fun serializeJson(encoder: CompositeEncoder, `value`: TerminologyCapabilities) {
    val __desc = descriptor
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
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 21, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    ((value.kind.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    (value.software)?.let { encoder.encodeSerializableElement(__desc, 38, Hoisted.softwareSer, it) }
    (value.implementation)?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implementationSer, it)
    }
    ((value.lockedDate?.value))?.let { encoder.encodeBooleanElement(__desc, 40, it) }
    (value.lockedDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    if (value.codeSystem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.codeSystemSer, value.codeSystem)
    (value.expansion)?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.expansionSer, it)
    }
    ((value.codeSearch?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 44, it) }
    (value.codeSearch?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
    }
    (value.validateCode)?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.validateCodeSer, it)
    }
    (value.translation)?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.translationSer, it)
    }
    (value.closure)?.let { encoder.encodeSerializableElement(__desc, 48, Hoisted.closureSer, it) }
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
      TerminologyCapabilitiesSerializer.serializeJson(this, value)
    }
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities =
    decoder.decodeStructure(descriptor) { TerminologyCapabilitiesSerializer.deserializeJson(this) }
}
