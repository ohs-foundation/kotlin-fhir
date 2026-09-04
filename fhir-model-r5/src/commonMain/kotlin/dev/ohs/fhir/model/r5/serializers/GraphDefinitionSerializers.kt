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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.GraphDefinition
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
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

internal object GraphDefinitionNodeSerializer : KSerializer<GraphDefinition.Node> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Node") {
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
      element("nodeId", KotlinString.serializer().descriptor, isOptional = true)
      element("_nodeId", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): GraphDefinition.Node =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Node) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): GraphDefinition.Node {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var nodeId: KotlinString? = null
    var _nodeId: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> nodeId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _nodeId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nodeIdSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nodeIdSer, null)
        7 -> type = decoder.decodeStringElement(descriptor, i)
        8 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nodeIdSer, null)
        9 -> profile = decoder.decodeStringElement(descriptor, i)
        10 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nodeIdSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Node: " + i)
      }
    }
    return GraphDefinition.Node(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      nodeId =
        Id.of(nodeId, _nodeId)
          ?: throw SerializationException(
            "Missing required property 'nodeId' on GraphDefinition.Node"
          ),
      description = R5String.of(description, _description),
      type =
        Enumeration.of(
          type?.let { GraphDefinition.VersionIndependentResourceTypesAll.fromCode(it) },
          _type,
        )
          ?: throw SerializationException(
            "Missing required property 'type' on GraphDefinition.Node"
          ),
      profile = Canonical.of(profile, _profile),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: GraphDefinition.Node) {
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
    ((value.nodeId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.nodeId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nodeIdSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nodeIdSer, it)
    }
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.nodeIdSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.nodeIdSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nodeIdSer: KSerializer<Element> = Element.serializer()
  }
}

internal object GraphDefinitionLinkSerializer : KSerializer<GraphDefinition.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
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
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", Element.serializer().descriptor, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", Element.serializer().descriptor, isOptional = true)
      element("sourceId", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceId", Element.serializer().descriptor, isOptional = true)
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element("sliceName", KotlinString.serializer().descriptor, isOptional = true)
      element("_sliceName", Element.serializer().descriptor, isOptional = true)
      element("targetId", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetId", Element.serializer().descriptor, isOptional = true)
      element("params", KotlinString.serializer().descriptor, isOptional = true)
      element("_params", Element.serializer().descriptor, isOptional = true)
      element(
        "compartment",
        listSerialDescriptor(
          lazyDescriptor { GraphDefinition.Link.Compartment.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): GraphDefinition.Link {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var sliceName: KotlinString? = null
    var _sliceName: Element? = null
    var targetId: KotlinString? = null
    var _targetId: Element? = null
    var params: KotlinString? = null
    var _params: Element? = null
    var compartment: List<GraphDefinition.Link.Compartment>? = null
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
        5 -> min = decoder.decodeIntElement(descriptor, i)
        6 ->
          _min =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        7 -> max = decoder.decodeStringElement(descriptor, i)
        8 ->
          _max =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        9 -> sourceId = decoder.decodeStringElement(descriptor, i)
        10 ->
          _sourceId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        11 -> path = decoder.decodeStringElement(descriptor, i)
        12 ->
          _path =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        13 -> sliceName = decoder.decodeStringElement(descriptor, i)
        14 ->
          _sliceName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        15 -> targetId = decoder.decodeStringElement(descriptor, i)
        16 ->
          _targetId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        17 -> params = decoder.decodeStringElement(descriptor, i)
        18 ->
          _params =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        19 ->
          compartment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.compartmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + i)
      }
    }
    return GraphDefinition.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R5String.of(description, _description),
      min = Integer.of(min, _min),
      max = R5String.of(max, _max),
      sourceId =
        Id.of(sourceId, _sourceId)
          ?: throw SerializationException(
            "Missing required property 'sourceId' on GraphDefinition.Link"
          ),
      path = R5String.of(path, _path),
      sliceName = R5String.of(sliceName, _sliceName),
      targetId =
        Id.of(targetId, _targetId)
          ?: throw SerializationException(
            "Missing required property 'targetId' on GraphDefinition.Link"
          ),
      params = R5String.of(params, _params),
      compartment = compartment ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: GraphDefinition.Link) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    ((value.min?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.min?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.descriptionSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.descriptionSer, it)
    }
    ((value.sourceId.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.sourceId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.descriptionSer, it)
    }
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.descriptionSer, it)
    }
    ((value.sliceName?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.sliceName?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.descriptionSer, it)
    }
    ((value.targetId.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.targetId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.descriptionSer, it)
    }
    ((value.params?.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
    (value.params?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.descriptionSer, it)
    }
    if (value.compartment.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.compartmentSer, value.compartment)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val compartmentSerInner: KSerializer<GraphDefinition.Link.Compartment> =
      GraphDefinition.Link.Compartment.serializer()

    public val compartmentSer: KSerializer<List<GraphDefinition.Link.Compartment>> =
      ListSerializer(Hoisted.compartmentSerInner)
  }
}

internal object GraphDefinitionLinkCompartmentSerializer :
  KSerializer<GraphDefinition.Link.Compartment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Compartment") {
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
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", Element.serializer().descriptor, isOptional = true)
      element("rule", KotlinString.serializer().descriptor, isOptional = true)
      element("_rule", Element.serializer().descriptor, isOptional = true)
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Compartment =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Compartment) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): GraphDefinition.Link.Compartment {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var rule: KotlinString? = null
    var _rule: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> use = decoder.decodeStringElement(descriptor, i)
        4 -> _use = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        5 -> rule = decoder.decodeStringElement(descriptor, i)
        6 -> _rule = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        7 -> code = decoder.decodeStringElement(descriptor, i)
        8 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        9 -> expression = decoder.decodeStringElement(descriptor, i)
        10 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        11 -> description = decoder.decodeStringElement(descriptor, i)
        12 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Compartment: " + i)
      }
    }
    return GraphDefinition.Link.Compartment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      use =
        Enumeration.of(use?.let { GraphDefinition.GraphCompartmentUse.fromCode(it) }, _use)
          ?: throw SerializationException(
            "Missing required property 'use' on GraphDefinition.Link.Compartment"
          ),
      rule =
        Enumeration.of(rule?.let { GraphDefinition.GraphCompartmentRule.fromCode(it) }, _rule)
          ?: throw SerializationException(
            "Missing required property 'rule' on GraphDefinition.Link.Compartment"
          ),
      code =
        Enumeration.of(code?.let { GraphDefinition.CompartmentType.fromCode(it) }, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on GraphDefinition.Link.Compartment"
          ),
      expression = R5String.of(expression, _expression),
      description = R5String.of(description, _description),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: GraphDefinition.Link.Compartment,
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
    ((value.use.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.useSer, it)
    }
    ((value.rule.value?.code))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.rule.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.useSer, it)
    }
    ((value.code.value?.code))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.useSer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.useSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.useSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val useSer: KSerializer<Element> = Element.serializer()
  }
}

internal object GraphDefinitionSerializer : KSerializer<GraphDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GraphDefinition") {
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
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element("start", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_start", Element.serializer().descriptor, isOptional = true)
    b.element(
      "node",
      listSerialDescriptor(lazyDescriptor { GraphDefinition.Node.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "link",
      listSerialDescriptor(lazyDescriptor { GraphDefinition.Link.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): GraphDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "GraphDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): GraphDefinition {
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
    var start: KotlinString? = null
    var _start: Element? = null
    var node: List<GraphDefinition.Node>? = null
    var link: List<GraphDefinition.Link>? = null
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
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> start = decoder.decodeStringElement(descriptor, i)
        42 ->
          _start =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> node = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nodeSer, null)
        44 -> link = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkSer, null)
        else -> throw SerializationException("Unexpected index decoding GraphDefinition: " + i)
      }
    }
    return GraphDefinition(
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
        GraphDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on GraphDefinition"),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on GraphDefinition"),
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
      start = Id.of(start, _start),
      node = node ?: listOf(),
      link = link ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: GraphDefinition,
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
      is GraphDefinition.VersionAlgorithm.String -> {
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
      is GraphDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it) }
    (value.name.toElement())?.let {
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
    ((value.status.value?.code))?.let {
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
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.start?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.node.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.nodeSer,
        value.node,
      )
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.linkSer,
        value.link,
      )
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

    public val nodeSerInner: KSerializer<GraphDefinition.Node> = GraphDefinition.Node.serializer()

    public val nodeSer: KSerializer<List<GraphDefinition.Node>> =
      ListSerializer(Hoisted.nodeSerInner)

    public val linkSerInner: KSerializer<GraphDefinition.Link> = GraphDefinition.Link.serializer()

    public val linkSer: KSerializer<List<GraphDefinition.Link>> =
      ListSerializer(Hoisted.linkSerInner)
  }
}

internal object GraphDefinitionPolymorphicSerializer : KSerializer<GraphDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GraphDefinition") {
      GraphDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition) {
    encoder.encodeStructure(descriptor) {
      GraphDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): GraphDefinition =
    decoder.decodeStructure(descriptor) {
      GraphDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
