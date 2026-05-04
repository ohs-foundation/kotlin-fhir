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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.ElementDefinition
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.StructureDefinition
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.FHIRVersion
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
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

internal object StructureDefinitionMappingSerializer : KSerializer<StructureDefinition.Mapping> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Mapping") {
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
      element("identity", KotlinString.serializer().descriptor, isOptional = true)
      element("_identity", Element.serializer().descriptor, isOptional = true)
      element("uri", KotlinString.serializer().descriptor, isOptional = true)
      element("_uri", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): StructureDefinition.Mapping =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Mapping) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureDefinition.Mapping {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identity: KotlinString? = null
    var _identity: Element? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> identity = decoder.decodeStringElement(__desc, 3)
        4 ->
          _identity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.identitySer, null)
        5 -> uri = decoder.decodeStringElement(__desc, 5)
        6 -> _uri = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.identitySer, null)
        7 -> name = decoder.decodeStringElement(__desc, 7)
        8 -> _name = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.identitySer, null)
        9 -> comment = decoder.decodeStringElement(__desc, 9)
        10 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.identitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mapping: " + __i)
      }
    }
    return StructureDefinition.Mapping(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identity = Id.of(identity, _identity)!!,
      uri = Uri.of(uri, _uri),
      name = R5String.of(name, _name),
      comment = R5String.of(comment, _comment),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureDefinition.Mapping) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.identity.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.identity.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.identitySer, it)
    }
    ((value.uri?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.identitySer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.identitySer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.identitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identitySer: KSerializer<Element> = Element.serializer()
  }
}

internal object StructureDefinitionContextSerializer : KSerializer<StructureDefinition.Context> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Context") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): StructureDefinition.Context =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Context) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureDefinition.Context {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> expression = decoder.decodeStringElement(__desc, 5)
        6 ->
          _expression = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Context: " + __i)
      }
    }
    return StructureDefinition.Context(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(StructureDefinition.ExtensionContextType.fromCode(type!!), _type),
      expression = R5String.of(expression, _expression)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureDefinition.Context) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    ((value.expression.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.expression.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object StructureDefinitionSnapshotSerializer : KSerializer<StructureDefinition.Snapshot> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Snapshot") {
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
      element(
        "element",
        listSerialDescriptor(ElementDefinition.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): StructureDefinition.Snapshot =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Snapshot) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureDefinition.Snapshot {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var element: List<ElementDefinition>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          element = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Snapshot: " + __i)
      }
    }
    return StructureDefinition.Snapshot(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      element = element ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureDefinition.Snapshot) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.element.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.elementSer, value.element)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val elementSerInner: KSerializer<ElementDefinition> = ElementDefinition.serializer()

    public val elementSer: KSerializer<List<ElementDefinition>> =
      ListSerializer(Hoisted.elementSerInner)
  }
}

internal object StructureDefinitionDifferentialSerializer :
  KSerializer<StructureDefinition.Differential> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Differential") {
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
      element(
        "element",
        listSerialDescriptor(ElementDefinition.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): StructureDefinition.Differential =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Differential) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureDefinition.Differential {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var element: List<ElementDefinition>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          element = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Differential: " + __i)
      }
    }
    return StructureDefinition.Differential(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      element = element ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureDefinition.Differential) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.element.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.elementSer, value.element)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val elementSerInner: KSerializer<ElementDefinition> = ElementDefinition.serializer()

    public val elementSer: KSerializer<List<ElementDefinition>> =
      ListSerializer(Hoisted.elementSerInner)
  }
}

internal object StructureDefinitionSerializer : KSerializer<StructureDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureDefinition") {
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
      element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
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
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
      element("keyword", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element("fhirVersion", KotlinString.serializer().descriptor, isOptional = true)
      element("_fhirVersion", Element.serializer().descriptor, isOptional = true)
      element(
        "mapping",
        listSerialDescriptor(
          lazyDescriptor { StructureDefinition.Mapping.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("kind", KotlinString.serializer().descriptor, isOptional = true)
      element("_kind", Element.serializer().descriptor, isOptional = true)
      element("abstract", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_abstract", Element.serializer().descriptor, isOptional = true)
      element(
        "context",
        listSerialDescriptor(
          lazyDescriptor { StructureDefinition.Context.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "contextInvariant",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_contextInvariant",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("baseDefinition", KotlinString.serializer().descriptor, isOptional = true)
      element("_baseDefinition", Element.serializer().descriptor, isOptional = true)
      element("derivation", KotlinString.serializer().descriptor, isOptional = true)
      element("_derivation", Element.serializer().descriptor, isOptional = true)
      element(
        "snapshot",
        lazyDescriptor { StructureDefinition.Snapshot.serializer().descriptor },
        isOptional = true,
      )
      element(
        "differential",
        lazyDescriptor { StructureDefinition.Differential.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): StructureDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): StructureDefinition {
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
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var keyword: List<Coding>? = null
    var fhirVersion: KotlinString? = null
    var _fhirVersion: Element? = null
    var mapping: List<StructureDefinition.Mapping>? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var `abstract`: KotlinBoolean? = null
    var _abstract: Element? = null
    var context: List<StructureDefinition.Context>? = null
    var contextInvariant: List<KotlinString?>? = null
    var _contextInvariant: List<Element?>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var baseDefinition: KotlinString? = null
    var _baseDefinition: Element? = null
    var derivation: KotlinString? = null
    var _derivation: Element? = null
    var snapshot: StructureDefinition.Snapshot? = null
    var differential: StructureDefinition.Differential? = null
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
        16 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 16)
        17 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        19 -> name = decoder.decodeStringElement(__desc, 19)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> title = decoder.decodeStringElement(__desc, 21)
        22 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> status = decoder.decodeStringElement(__desc, 23)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> experimental = decoder.decodeBooleanElement(__desc, 25)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> date = decoder.decodeStringElement(__desc, 27)
        28 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> publisher = decoder.decodeStringElement(__desc, 29)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.contactSer, null)
        32 -> description = decoder.decodeStringElement(__desc, 32)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.useContextSer, null)
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.jurisdictionSer, null)
        36 -> purpose = decoder.decodeStringElement(__desc, 36)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> copyright = decoder.decodeStringElement(__desc, 38)
        39 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> copyrightLabel = decoder.decodeStringElement(__desc, 40)
        41 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 ->
          keyword = decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.keywordSer, null)
        43 -> fhirVersion = decoder.decodeStringElement(__desc, 43)
        44 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.implicitRulesSer, null)
        45 ->
          mapping = decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.mappingSer, null)
        46 -> kind = decoder.decodeStringElement(__desc, 46)
        47 ->
          _kind =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.implicitRulesSer, null)
        48 -> `abstract` = decoder.decodeBooleanElement(__desc, 48)
        49 ->
          _abstract =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.implicitRulesSer, null)
        50 ->
          context = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.contextSer, null)
        51 ->
          contextInvariant =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.contextInvariantSer, null)
        52 ->
          _contextInvariant =
            decoder.decodeNullableSerializableElement(
              __desc,
              52,
              Hoisted.contextInvariantSer2,
              null,
            )
        53 -> type = decoder.decodeStringElement(__desc, 53)
        54 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.implicitRulesSer, null)
        55 -> baseDefinition = decoder.decodeStringElement(__desc, 55)
        56 ->
          _baseDefinition =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.implicitRulesSer, null)
        57 -> derivation = decoder.decodeStringElement(__desc, 57)
        58 ->
          _derivation =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.implicitRulesSer, null)
        59 ->
          snapshot =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.snapshotSer, null)
        60 ->
          differential =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.differentialSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding StructureDefinition: " + __i)
      }
    }
    return StructureDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url)!!,
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        StructureDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name)!!,
      title = R5String.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      keyword = keyword ?: listOf(),
      fhirVersion = fhirVersion?.let { Enumeration.of(FHIRVersion.fromCode(it), _fhirVersion) },
      mapping = mapping ?: listOf(),
      kind = Enumeration.of(StructureDefinition.StructureDefinitionKind.fromCode(kind!!), _kind),
      `abstract` = R5Boolean.of(`abstract`, _abstract)!!,
      context = context ?: listOf(),
      contextInvariant =
        (kotlin.collections.List(
          maxOf(contextInvariant?.size ?: 0, _contextInvariant?.size ?: 0)
        ) { __i ->
          R5String.of(
            contextInvariant?.getOrNull(__i)?.let { it },
            _contextInvariant?.getOrNull(__i),
          )!!
        }),
      type = Uri.of(type, _type)!!,
      baseDefinition = Canonical.of(baseDefinition, _baseDefinition),
      derivation =
        derivation?.let {
          Enumeration.of(StructureDefinition.TypeDerivationRule.fromCode(it), _derivation)
        },
      snapshot = snapshot,
      differential = differential,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "StructureDefinition")
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
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is StructureDefinition.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is StructureDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.versionAlgorithmCodingSer, __d.value)
      }
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 25, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.keywordSer, value.keyword)
    ((value.fhirVersion?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 43, it) }
    (value.fhirVersion?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.implicitRulesSer, it)
    }
    if (value.mapping.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.mappingSer, value.mapping)
    ((value.kind.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 46, it) }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.implicitRulesSer, it)
    }
    ((value.`abstract`.value))?.let { encoder.encodeBooleanElement(__desc, 48, it) }
    (value.`abstract`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.implicitRulesSer, it)
    }
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.contextSer, value.context)
    (value.contextInvariant.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 51, Hoisted.contextInvariantSer, it)
    }
    (value.contextInvariant.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 52, Hoisted.contextInvariantSer2, it)
    }
    ((value.type.value))?.let { encoder.encodeStringElement(__desc, 53, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 54, Hoisted.implicitRulesSer, it)
    }
    ((value.baseDefinition?.value))?.let { encoder.encodeStringElement(__desc, 55, it) }
    (value.baseDefinition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 56, Hoisted.implicitRulesSer, it)
    }
    ((value.derivation?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 57, it) }
    (value.derivation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 58, Hoisted.implicitRulesSer, it)
    }
    (value.snapshot)?.let { encoder.encodeSerializableElement(__desc, 59, Hoisted.snapshotSer, it) }
    (value.differential)?.let {
      encoder.encodeSerializableElement(__desc, 60, Hoisted.differentialSer, it)
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

    public val keywordSer: KSerializer<List<Coding>> =
      ListSerializer(Hoisted.versionAlgorithmCodingSer)

    public val mappingSerInner: KSerializer<StructureDefinition.Mapping> =
      StructureDefinition.Mapping.serializer()

    public val mappingSer: KSerializer<List<StructureDefinition.Mapping>> =
      ListSerializer(Hoisted.mappingSerInner)

    public val contextSerInner: KSerializer<StructureDefinition.Context> =
      StructureDefinition.Context.serializer()

    public val contextSer: KSerializer<List<StructureDefinition.Context>> =
      ListSerializer(Hoisted.contextSerInner)

    public val contextInvariantSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val contextInvariantSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.contextInvariantSerInner).nullable)

    public val contextInvariantSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val snapshotSer: KSerializer<StructureDefinition.Snapshot> =
      StructureDefinition.Snapshot.serializer()

    public val differentialSer: KSerializer<StructureDefinition.Differential> =
      StructureDefinition.Differential.serializer()
  }
}
