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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(descriptor, i)
        4 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        5 -> sliceName = decoder.decodeStringElement(descriptor, i)
        6 ->
          _sliceName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        7 -> min = decoder.decodeIntElement(descriptor, i)
        8 -> _min = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        9 -> max = decoder.decodeStringElement(descriptor, i)
        10 -> _max = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        11 -> description = decoder.decodeStringElement(descriptor, i)
        12 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        13 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + i)
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
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.pathSer, it)
    }
    ((value.sliceName?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.sliceName?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.pathSer, it)
    }
    ((value.min?.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.min?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.pathSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.pathSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.pathSer, it)
    }
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.targetSer, value.target)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): GraphDefinition.Link.Target {
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
        5 -> params = decoder.decodeStringElement(descriptor, i)
        6 ->
          _params = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> profile = decoder.decodeStringElement(descriptor, i)
        8 ->
          _profile = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        9 ->
          compartment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.compartmentSer, null)
        10 -> link = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + i)
      }
    }
    return GraphDefinition.Link.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(type?.let { ResourceType.fromCode(it) }, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on GraphDefinition.Link.Target"
          ),
      params = R4String.of(params, _params),
      profile = Canonical.of(profile, _profile),
      compartment = compartment ?: listOf(),
      link = link ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: GraphDefinition.Link.Target) {
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
    ((value.params?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.params?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, it)
    }
    if (value.compartment.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.compartmentSer, value.compartment)
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.linkSer, value.link)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target.Compartment) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): GraphDefinition.Link.Target.Compartment {
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
        5 -> code = decoder.decodeStringElement(descriptor, i)
        6 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        7 -> rule = decoder.decodeStringElement(descriptor, i)
        8 -> _rule = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
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
    return GraphDefinition.Link.Target.Compartment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      use =
        Enumeration.of(use?.let { GraphDefinition.GraphCompartmentUse.fromCode(it) }, _use)
          ?: throw SerializationException(
            "Missing required property 'use' on GraphDefinition.Link.Target.Compartment"
          ),
      code =
        Enumeration.of(code?.let { GraphDefinition.CompartmentType.fromCode(it) }, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on GraphDefinition.Link.Target.Compartment"
          ),
      rule =
        Enumeration.of(rule?.let { GraphDefinition.GraphCompartmentRule.fromCode(it) }, _rule)
          ?: throw SerializationException(
            "Missing required property 'rule' on GraphDefinition.Link.Target.Compartment"
          ),
      expression = R4String.of(expression, _expression),
      description = R4String.of(description, _description),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: GraphDefinition.Link.Target.Compartment,
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
    ((value.use.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.useSer, it)
    }
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.useSer, it)
    }
    ((value.rule.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.rule.toElement())?.let {
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
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
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
    b.element("start", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_start", Element.serializer().descriptor, isOptional = true)
    b.element("profile", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_profile", Element.serializer().descriptor, isOptional = true)
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
        16 -> status = decoder.decodeStringElement(descriptor, i)
        17 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        19 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> date = decoder.decodeStringElement(descriptor, i)
        21 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> publisher = decoder.decodeStringElement(descriptor, i)
        23 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        25 -> description = decoder.decodeStringElement(descriptor, i)
        26 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        28 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        29 -> purpose = decoder.decodeStringElement(descriptor, i)
        30 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 -> start = decoder.decodeStringElement(descriptor, i)
        32 ->
          _start =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> profile = decoder.decodeStringElement(descriptor, i)
        34 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> link = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkSer, null)
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
      version = R4String.of(version, _version),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on GraphDefinition"),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on GraphDefinition"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      start =
        Enumeration.of(start?.let { ResourceType.fromCode(it) }, _start)
          ?: throw SerializationException("Missing required property 'start' on GraphDefinition"),
      profile = Canonical.of(profile, _profile),
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.start.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.start.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.profile?.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
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
