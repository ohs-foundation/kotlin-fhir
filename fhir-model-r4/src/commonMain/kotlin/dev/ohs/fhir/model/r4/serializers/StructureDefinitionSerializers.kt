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
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.ElementDefinition
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.StructureDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.FHIRVersion
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Mapping) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): StructureDefinition.Mapping {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> identity = decoder.decodeStringElement(descriptor, i)
        4 ->
          _identity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identitySer, null)
        5 -> uri = decoder.decodeStringElement(descriptor, i)
        6 ->
          _uri = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identitySer, null)
        7 -> name = decoder.decodeStringElement(descriptor, i)
        8 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identitySer, null)
        9 -> comment = decoder.decodeStringElement(descriptor, i)
        10 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mapping: " + i)
      }
    }
    return StructureDefinition.Mapping(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identity =
        Id.of(identity, _identity)
          ?: throw SerializationException(
            "Missing required property 'identity' on StructureDefinition.Mapping"
          ),
      uri = Uri.of(uri, _uri),
      name = R4String.of(name, _name),
      comment = R4String.of(comment, _comment),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: StructureDefinition.Mapping) {
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
    ((value.identity.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.identity.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.identitySer, it)
    }
    ((value.uri?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.identitySer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.identitySer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.identitySer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Context) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): StructureDefinition.Context {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> expression = decoder.decodeStringElement(descriptor, i)
        6 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Context: " + i)
      }
    }
    return StructureDefinition.Context(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          StructureDefinition.ExtensionContextType.fromCode(
            type
              ?: throw SerializationException(
                "Missing required property 'type' on StructureDefinition.Context"
              )
          ),
          _type,
        ),
      expression =
        R4String.of(expression, _expression)
          ?: throw SerializationException(
            "Missing required property 'expression' on StructureDefinition.Context"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: StructureDefinition.Context) {
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
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.expression.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.expression.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Snapshot) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): StructureDefinition.Snapshot {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var element: List<ElementDefinition>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          element =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Snapshot: " + i)
      }
    }
    return StructureDefinition.Snapshot(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      element = element ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: StructureDefinition.Snapshot) {
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
    if (value.element.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.elementSer, value.element)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Differential) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): StructureDefinition.Differential {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var element: List<ElementDefinition>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          element =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Differential: " + i)
      }
    }
    return StructureDefinition.Differential(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      element = element ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: StructureDefinition.Differential,
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
    if (value.element.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.elementSer, value.element)
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
    b.element("keyword", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
    b.element("fhirVersion", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_fhirVersion", Element.serializer().descriptor, isOptional = true)
    b.element(
      "mapping",
      listSerialDescriptor(lazyDescriptor { StructureDefinition.Mapping.serializer().descriptor }),
      isOptional = true,
    )
    b.element("kind", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_kind", Element.serializer().descriptor, isOptional = true)
    b.element("abstract", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_abstract", Element.serializer().descriptor, isOptional = true)
    b.element(
      "context",
      listSerialDescriptor(lazyDescriptor { StructureDefinition.Context.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "contextInvariant",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_contextInvariant",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("baseDefinition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_baseDefinition", Element.serializer().descriptor, isOptional = true)
    b.element("derivation", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_derivation", Element.serializer().descriptor, isOptional = true)
    b.element(
      "snapshot",
      lazyDescriptor { StructureDefinition.Snapshot.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "differential",
      lazyDescriptor { StructureDefinition.Differential.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): StructureDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "StructureDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): StructureDefinition {
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
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
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
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> publisher = decoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        28 -> description = decoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        32 -> purpose = decoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 -> copyright = decoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 ->
          keyword =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keywordSer, null)
        37 -> fhirVersion = decoder.decodeStringElement(descriptor, i)
        38 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 ->
          mapping =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mappingSer, null)
        40 -> kind = decoder.decodeStringElement(descriptor, i)
        41 ->
          _kind =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        42 -> `abstract` = decoder.decodeBooleanElement(descriptor, i)
        43 ->
          _abstract =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        44 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contextSer, null)
        45 ->
          contextInvariant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contextInvariantSer,
              null,
            )
        46 ->
          _contextInvariant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contextInvariantSer2,
              null,
            )
        47 -> type = decoder.decodeStringElement(descriptor, i)
        48 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        49 -> baseDefinition = decoder.decodeStringElement(descriptor, i)
        50 ->
          _baseDefinition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        51 -> derivation = decoder.decodeStringElement(descriptor, i)
        52 ->
          _derivation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        53 ->
          snapshot =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.snapshotSer, null)
        54 ->
          differential =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.differentialSer, null)
        else -> throw SerializationException("Unexpected index decoding StructureDefinition: " + i)
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
      url =
        Uri.of(url, _url)
          ?: throw SerializationException("Missing required property 'url' on StructureDefinition"),
      identifier = identifier ?: listOf(),
      version = R4String.of(version, _version),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on StructureDefinition"
          ),
      title = R4String.of(title, _title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on StructureDefinition"
              )
          ),
          _status,
        ),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      keyword = keyword ?: listOf(),
      fhirVersion = fhirVersion?.let { Enumeration.of(FHIRVersion.fromCode(it), _fhirVersion) },
      mapping = mapping ?: listOf(),
      kind =
        Enumeration.of(
          StructureDefinition.StructureDefinitionKind.fromCode(
            kind
              ?: throw SerializationException(
                "Missing required property 'kind' on StructureDefinition"
              )
          ),
          _kind,
        ),
      `abstract` =
        R4Boolean.of(`abstract`, _abstract)
          ?: throw SerializationException(
            "Missing required property 'abstract' on StructureDefinition"
          ),
      context = context ?: listOf(),
      contextInvariant =
        (kotlin.collections.List(
          maxOf(contextInvariant?.size ?: 0, _contextInvariant?.size ?: 0)
        ) { index ->
          R4String.of(
            contextInvariant?.getOrNull(index)?.let { it },
            _contextInvariant?.getOrNull(index),
          )!!
        }),
      type =
        Uri.of(type, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on StructureDefinition"
          ),
      baseDefinition = Canonical.of(baseDefinition, _baseDefinition),
      derivation =
        derivation?.let {
          Enumeration.of(StructureDefinition.TypeDerivationRule.fromCode(it), _derivation)
        },
      snapshot = snapshot,
      differential = differential,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: StructureDefinition,
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
    ((value.url.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url.toElement())?.let {
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.keywordSer,
        value.keyword,
      )
    ((value.fhirVersion?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.fhirVersion?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.mapping.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.mappingSer,
        value.mapping,
      )
    ((value.kind.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 40 + descriptorOffset, it)
    }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.`abstract`.value))?.let {
      encoder.encodeBooleanElement(descriptor, 42 + descriptorOffset, it)
    }
    (value.`abstract`.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.contextSer,
        value.context,
      )
    (value.contextInvariant.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.contextInvariantSer,
        it,
      )
    }
    (value.contextInvariant.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.contextInvariantSer2,
        it,
      )
    }
    ((value.type.value))?.let { encoder.encodeStringElement(descriptor, 47 + descriptorOffset, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.baseDefinition?.value))?.let {
      encoder.encodeStringElement(descriptor, 49 + descriptorOffset, it)
    }
    (value.baseDefinition?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.derivation?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 51 + descriptorOffset, it)
    }
    (value.derivation?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.snapshot)?.let {
      encoder.encodeSerializableElement(descriptor, 53 + descriptorOffset, Hoisted.snapshotSer, it)
    }
    (value.differential)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.differentialSer,
        it,
      )
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

    public val keywordSerInner: KSerializer<Coding> = Coding.serializer()

    public val keywordSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.keywordSerInner)

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

internal object StructureDefinitionPolymorphicSerializer : KSerializer<StructureDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureDefinition") {
      StructureDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition) {
    encoder.encodeStructure(descriptor) {
      StructureDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): StructureDefinition =
    decoder.decodeStructure(descriptor) {
      StructureDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
