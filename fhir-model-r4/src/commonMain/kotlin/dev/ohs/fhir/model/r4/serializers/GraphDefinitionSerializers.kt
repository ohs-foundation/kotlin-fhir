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
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.GraphDefinition
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("sliceName", KotlinString.serializer().descriptor)
      optionalElement("_sliceName", ElementSerializer.descriptor)
      optionalElement("min", Int.serializer().descriptor)
      optionalElement("_min", ElementSerializer.descriptor)
      optionalElement("max", KotlinString.serializer().descriptor)
      optionalElement("_max", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("target", GraphDefinitionLinkTargetSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<GraphDefinition.Link>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): GraphDefinition.Link =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> path = decodeStringElement(descriptor, i)
          4 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> sliceName = decodeStringElement(descriptor, i)
          6 ->
            _sliceName = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> min = decodeIntElement(descriptor, i)
          8 -> _min = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> max = decodeStringElement(descriptor, i)
          10 -> _max = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> description = decodeStringElement(descriptor, i)
          12 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            target =
              decodeNullableSerializableElement(
                descriptor,
                i,
                GraphDefinitionLinkTargetSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Link: " + i)
        }
      }
      GraphDefinition.Link(
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

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.path?.value)
      encodeElementIfNotNull(descriptor, 4, value.path)
      encodeStringIfNotNull(descriptor, 5, value.sliceName?.value)
      encodeElementIfNotNull(descriptor, 6, value.sliceName)
      encodeIntIfNotNull(descriptor, 7, value.min?.value)
      encodeElementIfNotNull(descriptor, 8, value.min)
      encodeStringIfNotNull(descriptor, 9, value.max?.value)
      encodeElementIfNotNull(descriptor, 10, value.max)
      encodeStringIfNotNull(descriptor, 11, value.description?.value)
      encodeElementIfNotNull(descriptor, 12, value.description)
      if (value.target.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          GraphDefinitionLinkTargetSerializer.listSerializer,
          value.target,
        )
    }
  }
}

internal object GraphDefinitionLinkTargetSerializer : KSerializer<GraphDefinition.Link.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("params", KotlinString.serializer().descriptor)
      optionalElement("_params", ElementSerializer.descriptor)
      optionalElement("profile", KotlinString.serializer().descriptor)
      optionalElement("_profile", ElementSerializer.descriptor)
      optionalElement(
        "compartment",
        GraphDefinitionLinkTargetCompartmentSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "link",
        listSerialDescriptor(lazyDescriptor { GraphDefinitionLinkSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<GraphDefinition.Link.Target>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Target =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> params = decodeStringElement(descriptor, i)
          6 -> _params = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> profile = decodeStringElement(descriptor, i)
          8 -> _profile = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            compartment =
              decodeNullableSerializableElement(
                descriptor,
                i,
                GraphDefinitionLinkTargetCompartmentSerializer.listSerializer,
                null,
              )
          10 ->
            link =
              decodeNullableSerializableElement(
                descriptor,
                i,
                GraphDefinitionLinkSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Target: " + i)
        }
      }
      GraphDefinition.Link.Target(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(if (type != null) ResourceType.fromCode(type) else null, _type)
            ?: throw SerializationException(
              "Missing required property 'type' on GraphDefinition.Link.Target"
            ),
        params = R4String.of(params, _params),
        profile = Canonical.of(profile, _profile),
        compartment = compartment ?: listOf(),
        link = link ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.params?.value)
      encodeElementIfNotNull(descriptor, 6, value.params)
      encodeStringIfNotNull(descriptor, 7, value.profile?.value)
      encodeElementIfNotNull(descriptor, 8, value.profile)
      if (value.compartment.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          GraphDefinitionLinkTargetCompartmentSerializer.listSerializer,
          value.compartment,
        )
      if (value.link.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          GraphDefinitionLinkSerializer.listSerializer,
          value.link,
        )
    }
  }
}

internal object GraphDefinitionLinkTargetCompartmentSerializer :
  KSerializer<GraphDefinition.Link.Target.Compartment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Compartment") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("use", KotlinString.serializer().descriptor)
      optionalElement("_use", ElementSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("rule", KotlinString.serializer().descriptor)
      optionalElement("_rule", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<GraphDefinition.Link.Target.Compartment>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Target.Compartment =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> use = decodeStringElement(descriptor, i)
          4 -> _use = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> code = decodeStringElement(descriptor, i)
          6 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> rule = decodeStringElement(descriptor, i)
          8 -> _rule = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> expression = decodeStringElement(descriptor, i)
          10 ->
            _expression = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> description = decodeStringElement(descriptor, i)
          12 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Compartment: " + i)
        }
      }
      GraphDefinition.Link.Target.Compartment(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        use =
          Enumeration.of(
            if (use != null) GraphDefinition.GraphCompartmentUse.fromCode(use) else null,
            _use,
          )
            ?: throw SerializationException(
              "Missing required property 'use' on GraphDefinition.Link.Target.Compartment"
            ),
        code =
          Enumeration.of(
            if (code != null) GraphDefinition.CompartmentType.fromCode(code) else null,
            _code,
          )
            ?: throw SerializationException(
              "Missing required property 'code' on GraphDefinition.Link.Target.Compartment"
            ),
        rule =
          Enumeration.of(
            if (rule != null) GraphDefinition.GraphCompartmentRule.fromCode(rule) else null,
            _rule,
          )
            ?: throw SerializationException(
              "Missing required property 'rule' on GraphDefinition.Link.Target.Compartment"
            ),
        expression = R4String.of(expression, _expression),
        description = R4String.of(description, _description),
      )
    }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target.Compartment) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.use.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.use)
      encodeStringIfNotNull(descriptor, 5, value.code.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.code)
      encodeStringIfNotNull(descriptor, 7, value.rule.value?.code)
      encodeElementIfNotNull(descriptor, 8, value.rule)
      encodeStringIfNotNull(descriptor, 9, value.expression?.value)
      encodeElementIfNotNull(descriptor, 10, value.expression)
      encodeStringIfNotNull(descriptor, 11, value.description?.value)
      encodeElementIfNotNull(descriptor, 12, value.description)
    }
  }
}

internal object GraphDefinitionSerializer : FhirResourceSerializer<GraphDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("GraphDefinition")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("start", KotlinString.serializer().descriptor)
    b.optionalElement("_start", ElementSerializer.descriptor)
    b.optionalElement("profile", KotlinString.serializer().descriptor)
    b.optionalElement("_profile", ElementSerializer.descriptor)
    b.optionalElement("link", GraphDefinitionLinkSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 -> version = decoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> status = decoder.decodeStringElement(descriptor, i)
        17 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        19 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> date = decoder.decodeStringElement(descriptor, i)
        21 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> publisher = decoder.decodeStringElement(descriptor, i)
        23 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        25 -> description = decoder.decodeStringElement(descriptor, i)
        26 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        28 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        29 -> purpose = decoder.decodeStringElement(descriptor, i)
        30 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 -> start = decoder.decodeStringElement(descriptor, i)
        32 ->
          _start = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 -> profile = decoder.decodeStringElement(descriptor, i)
        34 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 ->
          link =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GraphDefinitionLinkSerializer.listSerializer,
              null,
            )
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
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on GraphDefinition"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      start =
        Enumeration.of(if (start != null) ResourceType.fromCode(start) else null, _start)
          ?: throw SerializationException("Missing required property 'start' on GraphDefinition"),
      profile = Canonical.of(profile, _profile),
      link = link ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: GraphDefinition,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name.value)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 18 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.start.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.start)
    encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.profile?.value)
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.profile)
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        GraphDefinitionLinkSerializer.listSerializer,
        value.link,
      )
  }
}
