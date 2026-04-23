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
import dev.ohs.fhir.model.r4.GraphDefinition
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
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
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element("sliceName", KotlinString.serializer().descriptor, isOptional = true)
      element("_sliceName", Element.serializer().descriptor, isOptional = true)
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", Element.serializer().descriptor, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "target",
        listSerialDescriptor(
          lazyDescriptor { GraphDefinition.Link.Target.serializer().descriptor }
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
    var path: KotlinString? = null
    var _path: Element? = null
    var sliceName: KotlinString? = null
    var _sliceName: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var target: List<GraphDefinition.Link.Target>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(__desc, 3)
        4 -> _path = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.pathSer, null)
        5 -> sliceName = decoder.decodeStringElement(__desc, 5)
        6 ->
          _sliceName = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.pathSer, null)
        7 -> min = decoder.decodeIntElement(__desc, 7)
        8 -> _min = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.pathSer, null)
        9 -> max = decoder.decodeStringElement(__desc, 9)
        10 -> _max = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.pathSer, null)
        11 -> description = decoder.decodeStringElement(__desc, 11)
        12 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.pathSer, null)
        13 ->
          target = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + __i)
      }
    }
    return GraphDefinition.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path = R4String.of(path, _path),
      sliceName = R4String.of(sliceName, _sliceName),
      min = Integer.of(min, _min),
      max = R4String.of(max, _max),
      description = R4String.of(description, _description),
      target = target ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GraphDefinition.Link) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.path?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.pathSer, it)
    }
    ((value.sliceName?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.sliceName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.pathSer, it)
    }
    ((value.min?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.min?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.pathSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.pathSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.pathSer, it)
    }
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.targetSer, value.target)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()

    public val targetSerInner: KSerializer<GraphDefinition.Link.Target> =
      GraphDefinition.Link.Target.serializer()

    public val targetSer: KSerializer<List<GraphDefinition.Link.Target>> =
      ListSerializer(Hoisted.targetSerInner)
  }
}

internal object GraphDefinitionLinkTargetSerializer : KSerializer<GraphDefinition.Link.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
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
      element("params", KotlinString.serializer().descriptor, isOptional = true)
      element("_params", Element.serializer().descriptor, isOptional = true)
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", Element.serializer().descriptor, isOptional = true)
      element(
        "compartment",
        listSerialDescriptor(
          lazyDescriptor { GraphDefinition.Link.Target.Compartment.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "link",
        listSerialDescriptor(lazyDescriptor { GraphDefinition.Link.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Target =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GraphDefinition.Link.Target {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var params: KotlinString? = null
    var _params: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    var compartment: List<GraphDefinition.Link.Target.Compartment>? = null
    var link: List<GraphDefinition.Link>? = null
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
        5 -> params = decoder.decodeStringElement(__desc, 5)
        6 -> _params = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 -> profile = decoder.decodeStringElement(__desc, 7)
        8 -> _profile = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSer, null)
        9 ->
          compartment =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.compartmentSer, null)
        10 -> link = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.linkSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + __i)
      }
    }
    return GraphDefinition.Link.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(ResourceType.fromCode(type!!), _type),
      params = R4String.of(params, _params),
      profile = Canonical.of(profile, _profile),
      compartment = compartment ?: listOf(),
      link = link ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GraphDefinition.Link.Target) {
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
    ((value.params?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.params?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it)
    }
    if (value.compartment.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.compartmentSer, value.compartment)
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.linkSer, value.link)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val compartmentSerInner: KSerializer<GraphDefinition.Link.Target.Compartment> =
      GraphDefinition.Link.Target.Compartment.serializer()

    public val compartmentSer: KSerializer<List<GraphDefinition.Link.Target.Compartment>> =
      ListSerializer(Hoisted.compartmentSerInner)

    public val linkSerInner: KSerializer<GraphDefinition.Link> = GraphDefinition.Link.serializer()

    public val linkSer: KSerializer<List<GraphDefinition.Link>> =
      ListSerializer(Hoisted.linkSerInner)
  }
}

internal object GraphDefinitionLinkTargetCompartmentSerializer :
  KSerializer<GraphDefinition.Link.Target.Compartment> {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("rule", KotlinString.serializer().descriptor, isOptional = true)
      element("_rule", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Target.Compartment =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target.Compartment) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GraphDefinition.Link.Target.Compartment {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var rule: KotlinString? = null
    var _rule: Element? = null
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
        5 -> code = decoder.decodeStringElement(__desc, 5)
        6 -> _code = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.useSer, null)
        7 -> rule = decoder.decodeStringElement(__desc, 7)
        8 -> _rule = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.useSer, null)
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
    return GraphDefinition.Link.Target.Compartment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      use = Enumeration.of(GraphDefinition.GraphCompartmentUse.fromCode(use!!), _use),
      code = Enumeration.of(GraphDefinition.CompartmentType.fromCode(code!!), _code),
      rule = Enumeration.of(GraphDefinition.GraphCompartmentRule.fromCode(rule!!), _rule),
      expression = R4String.of(expression, _expression),
      description = R4String.of(description, _description),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: GraphDefinition.Link.Target.Compartment,
  ) {
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
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.useSer, it)
    }
    ((value.rule.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.rule.toElement())?.let {
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
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
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
      element("start", KotlinString.serializer().descriptor, isOptional = true)
      element("_start", Element.serializer().descriptor, isOptional = true)
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", Element.serializer().descriptor, isOptional = true)
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
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
    var start: KotlinString? = null
    var _start: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
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
        13 -> version = decoder.decodeStringElement(__desc, 13)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(__desc, 15)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 -> status = decoder.decodeStringElement(__desc, 17)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 -> experimental = decoder.decodeBooleanElement(__desc, 19)
        20 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> date = decoder.decodeStringElement(__desc, 21)
        22 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> publisher = decoder.decodeStringElement(__desc, 23)
        24 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.contactSer, null)
        26 -> description = decoder.decodeStringElement(__desc, 26)
        27 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.useContextSer, null)
        29 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.jurisdictionSer, null)
        30 -> purpose = decoder.decodeStringElement(__desc, 30)
        31 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 -> start = decoder.decodeStringElement(__desc, 32)
        33 ->
          _start =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 -> profile = decoder.decodeStringElement(__desc, 34)
        35 ->
          _profile =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> link = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.linkSer, null)
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name)!!,
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      start = Enumeration.of(ResourceType.fromCode(start!!), _start),
      profile = Canonical.of(profile, _profile),
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
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 19, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    ((value.start.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.start.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.linkSer, value.link)
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

    public val linkSerInner: KSerializer<GraphDefinition.Link> = GraphDefinition.Link.serializer()

    public val linkSer: KSerializer<List<GraphDefinition.Link>> =
      ListSerializer(Hoisted.linkSerInner)
  }
}
