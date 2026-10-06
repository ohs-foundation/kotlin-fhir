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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.MessageDefinition
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
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

internal object MessageDefinitionFocusSerializer : KSerializer<MessageDefinition.Focus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Focus") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("profile", KotlinString.serializer().descriptor)
      optionalElement("_profile", ElementSerializer.descriptor)
      optionalElement("min", Int.serializer().descriptor)
      optionalElement("_min", ElementSerializer.descriptor)
      optionalElement("max", KotlinString.serializer().descriptor)
      optionalElement("_max", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MessageDefinition.Focus>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageDefinition.Focus =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var profile: KotlinString? = null
      var _profile: Element? = null
      var min: Int? = null
      var _min: Element? = null
      var max: KotlinString? = null
      var _max: Element? = null
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
          3 -> code = decodeStringElement(descriptor, i)
          4 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> profile = decodeStringElement(descriptor, i)
          6 -> _profile = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> min = decodeIntElement(descriptor, i)
          8 -> _min = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> max = decodeStringElement(descriptor, i)
          10 -> _max = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Focus: " + i)
        }
      }
      MessageDefinition.Focus(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Enumeration.of(if (code != null) ResourceType.fromCode(code) else null, _code)
            ?: throw SerializationException(
              "Missing required property 'code' on MessageDefinition.Focus"
            ),
        profile = Canonical.of(profile, _profile),
        min =
          UnsignedInt.of(min, _min)
            ?: throw SerializationException(
              "Missing required property 'min' on MessageDefinition.Focus"
            ),
        max = R4bString.of(max, _max),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.Focus) {
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
      encodeStringIfNotNull(descriptor, 3, value.code.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.code)
      encodeStringIfNotNull(descriptor, 5, value.profile?.value)
      encodeElementIfNotNull(descriptor, 6, value.profile)
      encodeIntIfNotNull(descriptor, 7, value.min.value)
      encodeElementIfNotNull(descriptor, 8, value.min)
      encodeStringIfNotNull(descriptor, 9, value.max?.value)
      encodeElementIfNotNull(descriptor, 10, value.max)
    }
  }
}

internal object MessageDefinitionAllowedResponseSerializer :
  KSerializer<MessageDefinition.AllowedResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AllowedResponse") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("message", KotlinString.serializer().descriptor)
      optionalElement("_message", ElementSerializer.descriptor)
      optionalElement("situation", KotlinString.serializer().descriptor)
      optionalElement("_situation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MessageDefinition.AllowedResponse>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageDefinition.AllowedResponse =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var message: KotlinString? = null
      var _message: Element? = null
      var situation: KotlinString? = null
      var _situation: Element? = null
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
          3 -> message = decodeStringElement(descriptor, i)
          4 -> _message = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> situation = decodeStringElement(descriptor, i)
          6 ->
            _situation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding AllowedResponse: " + i)
        }
      }
      MessageDefinition.AllowedResponse(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        message =
          Canonical.of(message, _message)
            ?: throw SerializationException(
              "Missing required property 'message' on MessageDefinition.AllowedResponse"
            ),
        situation = Markdown.of(situation, _situation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.AllowedResponse) {
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
      encodeStringIfNotNull(descriptor, 3, value.message.value)
      encodeElementIfNotNull(descriptor, 4, value.message)
      encodeStringIfNotNull(descriptor, 5, value.situation?.value)
      encodeElementIfNotNull(descriptor, 6, value.situation)
    }
  }
}

internal object MessageDefinitionSerializer : FhirResourceSerializer<MessageDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MessageDefinition")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("replaces", stringNullableListSerializer.descriptor)
    b.optionalElement("_replaces", ElementSerializer.nullableListSerializer.descriptor)
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
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("base", KotlinString.serializer().descriptor)
    b.optionalElement("_base", ElementSerializer.descriptor)
    b.optionalElement("parent", stringNullableListSerializer.descriptor)
    b.optionalElement("_parent", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("eventCoding", CodingSerializer.descriptor)
    b.optionalElement("eventUri", KotlinString.serializer().descriptor)
    b.optionalElement("_eventUri", ElementSerializer.descriptor)
    b.optionalElement("category", KotlinString.serializer().descriptor)
    b.optionalElement("_category", ElementSerializer.descriptor)
    b.optionalElement("focus", MessageDefinitionFocusSerializer.listSerializer.descriptor)
    b.optionalElement("responseRequired", KotlinString.serializer().descriptor)
    b.optionalElement("_responseRequired", ElementSerializer.descriptor)
    b.optionalElement(
      "allowedResponse",
      MessageDefinitionAllowedResponseSerializer.listSerializer.descriptor,
    )
    b.optionalElement("graph", stringNullableListSerializer.descriptor)
    b.optionalElement("_graph", ElementSerializer.nullableListSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MessageDefinition {
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
    var replaces: List<KotlinString?>? = null
    var _replaces: List<Element?>? = null
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
    var base: KotlinString? = null
    var _base: Element? = null
    var parent: List<KotlinString?>? = null
    var _parent: List<Element?>? = null
    var eventCoding: Coding? = null
    var eventUri: KotlinString? = null
    var _eventUri: Element? = null
    var category: KotlinString? = null
    var _category: Element? = null
    var focus: List<MessageDefinition.Focus>? = null
    var responseRequired: KotlinString? = null
    var _responseRequired: Element? = null
    var allowedResponse: List<MessageDefinition.AllowedResponse>? = null
    var graph: List<KotlinString?>? = null
    var _graph: List<Element?>? = null
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
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        20 ->
          _replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        21 -> status = decoder.decodeStringElement(descriptor, i)
        22 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> date = decoder.decodeStringElement(descriptor, i)
        26 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> publisher = decoder.decodeStringElement(descriptor, i)
        28 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        30 -> description = decoder.decodeStringElement(descriptor, i)
        31 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        33 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        34 -> purpose = decoder.decodeStringElement(descriptor, i)
        35 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 -> copyright = decoder.decodeStringElement(descriptor, i)
        37 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 -> base = decoder.decodeStringElement(descriptor, i)
        39 ->
          _base = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 ->
          parent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        41 ->
          _parent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        42 ->
          eventCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        43 -> eventUri = decoder.decodeStringElement(descriptor, i)
        44 ->
          _eventUri =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 -> category = decoder.decodeStringElement(descriptor, i)
        46 ->
          _category =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageDefinitionFocusSerializer.listSerializer,
              null,
            )
        48 -> responseRequired = decoder.decodeStringElement(descriptor, i)
        49 ->
          _responseRequired =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        50 ->
          allowedResponse =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageDefinitionAllowedResponseSerializer.listSerializer,
              null,
            )
        51 ->
          graph =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        52 ->
          _graph =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MessageDefinition: " + i)
      }
    }
    return MessageDefinition(
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      replaces =
        (kotlin.collections.List(maxOf(replaces?.size ?: 0, _replaces?.size ?: 0)) { index ->
          Canonical.of(replaces?.getOrNull(index), _replaces?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'replaces' on MessageDefinition has neither a value nor an id/extension"
            )
        }),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on MessageDefinition"
          ),
      experimental = R4bBoolean.of(experimental, _experimental),
      date =
        DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date)
          ?: throw SerializationException("Missing required property 'date' on MessageDefinition"),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      base = Canonical.of(base, _base),
      parent =
        (kotlin.collections.List(maxOf(parent?.size ?: 0, _parent?.size ?: 0)) { index ->
          Canonical.of(parent?.getOrNull(index), _parent?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'parent' on MessageDefinition has neither a value nor an id/extension"
            )
        }),
      event =
        MessageDefinition.Event.from(eventCoding, Uri.of(eventUri, _eventUri))
          ?: throw SerializationException("Missing required property 'event' on MessageDefinition"),
      category =
        Enumeration.of(
          if (category != null) MessageDefinition.MessageSignificanceCategory.fromCode(category)
          else null,
          _category,
        ),
      focus = focus ?: listOf(),
      responseRequired =
        Enumeration.of(
          if (responseRequired != null)
            MessageDefinition.MessageheaderResponseRequest.fromCode(responseRequired)
          else null,
          _responseRequired,
        ),
      allowedResponse = allowedResponse ?: listOf(),
      graph =
        (kotlin.collections.List(maxOf(graph?.size ?: 0, _graph?.size ?: 0)) { index ->
          Canonical.of(graph?.getOrNull(index), _graph?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'graph' on MessageDefinition has neither a value nor an id/extension"
            )
        }),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MessageDefinition,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    if (value.replaces.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        19 + descriptorOffset,
        stringNullableListSerializer,
        value.replaces.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 20 + descriptorOffset, value.replaces)
    }
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 23 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.date.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 36 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 38 + descriptorOffset, value.base?.value)
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.base)
    if (value.parent.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        40 + descriptorOffset,
        stringNullableListSerializer,
        value.parent.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 41 + descriptorOffset, value.parent)
    }
    when (val choice = value.event) {
      is MessageDefinition.Event.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          42 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
      is MessageDefinition.Event.Uri -> {
        encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 45 + descriptorOffset, value.category?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.category)
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        MessageDefinitionFocusSerializer.listSerializer,
        value.focus,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      48 + descriptorOffset,
      value.responseRequired?.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 49 + descriptorOffset, value.responseRequired)
    if (value.allowedResponse.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        MessageDefinitionAllowedResponseSerializer.listSerializer,
        value.allowedResponse,
      )
    if (value.graph.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        51 + descriptorOffset,
        stringNullableListSerializer,
        value.graph.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 52 + descriptorOffset, value.graph)
    }
  }
}
