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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Node) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GraphDefinition.Node {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> nodeId = decoder.decodeStringElement(__desc, 3)
        4 -> _nodeId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nodeIdSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nodeIdSer, null)
        7 -> type = decoder.decodeStringElement(__desc, 7)
        8 -> _type = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nodeIdSer, null)
        9 -> profile = decoder.decodeStringElement(__desc, 9)
        10 ->
          _profile = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.nodeIdSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Node: " + __i)
      }
    }
    return GraphDefinition.Node(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      nodeId = Id.of(nodeId, _nodeId)!!,
      description = R5String.of(description, _description),
      type =
        Enumeration.of(GraphDefinition.VersionIndependentResourceTypesAll.fromCode(type!!), _type),
      profile = Canonical.of(profile, _profile),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GraphDefinition.Node) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.nodeId.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.nodeId.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nodeIdSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nodeIdSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nodeIdSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nodeIdSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GraphDefinition.Link {
    val __desc = descriptor
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
        5 -> min = decoder.decodeIntElement(__desc, 5)
        6 ->
          _min = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        7 -> max = decoder.decodeStringElement(__desc, 7)
        8 ->
          _max = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.descriptionSer, null)
        9 -> sourceId = decoder.decodeStringElement(__desc, 9)
        10 ->
          _sourceId =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.descriptionSer, null)
        11 -> path = decoder.decodeStringElement(__desc, 11)
        12 ->
          _path =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.descriptionSer, null)
        13 -> sliceName = decoder.decodeStringElement(__desc, 13)
        14 ->
          _sliceName =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.descriptionSer, null)
        15 -> targetId = decoder.decodeStringElement(__desc, 15)
        16 ->
          _targetId =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.descriptionSer, null)
        17 -> params = decoder.decodeStringElement(__desc, 17)
        18 ->
          _params =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.descriptionSer, null)
        19 ->
          compartment =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.compartmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + __i)
      }
    }
    return GraphDefinition.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R5String.of(description, _description),
      min = Integer.of(min, _min),
      max = R5String.of(max, _max),
      sourceId = Id.of(sourceId, _sourceId)!!,
      path = R5String.of(path, _path),
      sliceName = R5String.of(sliceName, _sliceName),
      targetId = Id.of(targetId, _targetId)!!,
      params = R5String.of(params, _params),
      compartment = compartment ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GraphDefinition.Link) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    ((value.min?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.min?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
    }
    ((value.sourceId.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.sourceId.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.descriptionSer, it)
    }
    ((value.path?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.descriptionSer, it)
    }
    ((value.sliceName?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.sliceName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.descriptionSer, it)
    }
    ((value.targetId.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.targetId.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.descriptionSer, it)
    }
    ((value.params?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.params?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.descriptionSer, it)
    }
    if (value.compartment.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.compartmentSer, value.compartment)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Compartment) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GraphDefinition.Link.Compartment {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> use = decoder.decodeStringElement(__desc, 3)
        4 -> _use = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.useSer, null)
        5 -> rule = decoder.decodeStringElement(__desc, 5)
        6 -> _rule = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.useSer, null)
        7 -> code = decoder.decodeStringElement(__desc, 7)
        8 -> _code = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.useSer, null)
        9 -> expression = decoder.decodeStringElement(__desc, 9)
        10 ->
          _expression = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.useSer, null)
        11 -> description = decoder.decodeStringElement(__desc, 11)
        12 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.useSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Compartment: " + __i)
      }
    }
    return GraphDefinition.Link.Compartment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      use = Enumeration.of(GraphDefinition.GraphCompartmentUse.fromCode(use!!), _use),
      rule = Enumeration.of(GraphDefinition.GraphCompartmentRule.fromCode(rule!!), _rule),
      code = Enumeration.of(GraphDefinition.CompartmentType.fromCode(code!!), _code),
      expression = R5String.of(expression, _expression),
      description = R5String.of(description, _description),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GraphDefinition.Link.Compartment) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.use.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.useSer, it)
    }
    ((value.rule.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.rule.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.useSer, it)
    }
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.useSer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.useSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.useSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val useSer: KSerializer<Element> = Element.serializer()
  }
}

internal object GraphDefinitionVersionAlgorithmSerializer :
  KSerializer<GraphDefinition.VersionAlgorithm> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GraphDefinition.VersionAlgorithm") {
      element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.VersionAlgorithm) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is GraphDefinition.VersionAlgorithm.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is GraphDefinition.VersionAlgorithm.Coding -> {
          encodeSerializableElement(__desc, 2, Hoisted.versionAlgorithmCodingSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): GraphDefinition.VersionAlgorithm =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): GraphDefinition.VersionAlgorithm {
    val __desc = descriptor
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 0)
        1 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              2,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding GraphDefinition.VersionAlgorithm: " + __i
          )
      }
    }
    return GraphDefinition.VersionAlgorithm.from(
      R5String.of(versionAlgorithmString, _versionAlgorithmString),
      versionAlgorithmCoding,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object GraphDefinitionSerializer : KSerializer<GraphDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GraphDefinition") {
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
      element("start", KotlinString.serializer().descriptor, isOptional = true)
      element("_start", Element.serializer().descriptor, isOptional = true)
      element(
        "node",
        listSerialDescriptor(lazyDescriptor { GraphDefinition.Node.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "link",
        listSerialDescriptor(lazyDescriptor { GraphDefinition.Link.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): GraphDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): GraphDefinition {
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
    var start: KotlinString? = null
    var _start: Element? = null
    var node: List<GraphDefinition.Node>? = null
    var link: List<GraphDefinition.Link>? = null
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
        42 -> start = decoder.decodeStringElement(__desc, 42)
        43 ->
          _start =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 -> node = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.nodeSer, null)
        45 -> link = decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.linkSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding GraphDefinition: " + __i)
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
      start = Id.of(start, _start),
      node = node ?: listOf(),
      link = link ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GraphDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "GraphDefinition")
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
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is GraphDefinition.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is GraphDefinition.VersionAlgorithm.Coding -> {
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
    ((value.start?.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    if (value.node.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.nodeSer, value.node)
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.linkSer, value.link)
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
