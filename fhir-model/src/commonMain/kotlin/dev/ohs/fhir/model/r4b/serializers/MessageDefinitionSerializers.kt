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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.MessageDefinition
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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

internal object MessageDefinitionFocusSerializer : KSerializer<MessageDefinition.Focus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Focus") {
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
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", Element.serializer().descriptor, isOptional = true)
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", Element.serializer().descriptor, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MessageDefinition.Focus =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.Focus) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MessageDefinition.Focus {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, __i)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> profile = decoder.decodeStringElement(__desc, __i)
        6 ->
          _profile = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        7 -> min = decoder.decodeIntElement(__desc, __i)
        8 -> _min = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        9 -> max = decoder.decodeStringElement(__desc, __i)
        10 -> _max = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Focus: " + __i)
      }
    }
    return MessageDefinition.Focus(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(ResourceType.fromCode(code!!), _code),
      profile = Canonical.of(profile, _profile),
      min = UnsignedInt.of(min, _min)!!,
      max = R4bString.of(max, _max),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MessageDefinition.Focus) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    ((value.min.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.min.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MessageDefinitionAllowedResponseSerializer :
  KSerializer<MessageDefinition.AllowedResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AllowedResponse") {
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
      element("message", KotlinString.serializer().descriptor, isOptional = true)
      element("_message", Element.serializer().descriptor, isOptional = true)
      element("situation", KotlinString.serializer().descriptor, isOptional = true)
      element("_situation", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MessageDefinition.AllowedResponse =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.AllowedResponse) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MessageDefinition.AllowedResponse {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var message: KotlinString? = null
    var _message: Element? = null
    var situation: KotlinString? = null
    var _situation: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> message = decoder.decodeStringElement(__desc, __i)
        4 ->
          _message =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.messageSer, null)
        5 -> situation = decoder.decodeStringElement(__desc, __i)
        6 ->
          _situation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.messageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AllowedResponse: " + __i)
      }
    }
    return MessageDefinition.AllowedResponse(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      message = Canonical.of(message, _message)!!,
      situation = Markdown.of(situation, _situation),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MessageDefinition.AllowedResponse) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.message.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.message.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.messageSer, it)
    }
    ((value.situation?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.situation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.messageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val messageSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MessageDefinitionSerializer : KSerializer<MessageDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MessageDefinition") {
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
    b.element(
      "replaces",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_replaces", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
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
    b.element("base", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_base", Element.serializer().descriptor, isOptional = true)
    b.element(
      "parent",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_parent", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("eventCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("eventUri", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_eventUri", Element.serializer().descriptor, isOptional = true)
    b.element("category", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_category", Element.serializer().descriptor, isOptional = true)
    b.element(
      "focus",
      listSerialDescriptor(lazyDescriptor { MessageDefinition.Focus.serializer().descriptor }),
      isOptional = true,
    )
    b.element("responseRequired", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_responseRequired", Element.serializer().descriptor, isOptional = true)
    b.element(
      "allowedResponse",
      listSerialDescriptor(
        lazyDescriptor { MessageDefinition.AllowedResponse.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "graph",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_graph", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): MessageDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MessageDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MessageDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): MessageDefinition {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 -> url = decoder.decodeStringElement(__desc, __i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(__desc, __i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(__desc, __i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(__desc, __i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 ->
          replaces =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.replacesSer, null)
        20 ->
          _replaces =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.replacesSer2, null)
        21 -> status = decoder.decodeStringElement(__desc, __i)
        22 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> experimental = decoder.decodeBooleanElement(__desc, __i)
        24 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 -> date = decoder.decodeStringElement(__desc, __i)
        26 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 -> publisher = decoder.decodeStringElement(__desc, __i)
        28 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        29 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        30 -> description = decoder.decodeStringElement(__desc, __i)
        31 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useContextSer, null)
        33 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        34 -> purpose = decoder.decodeStringElement(__desc, __i)
        35 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        36 -> copyright = decoder.decodeStringElement(__desc, __i)
        37 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        38 -> base = decoder.decodeStringElement(__desc, __i)
        39 ->
          _base =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        40 ->
          parent = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.replacesSer, null)
        41 ->
          _parent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.replacesSer2, null)
        42 ->
          eventCoding =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eventCodingSer, null)
        43 -> eventUri = decoder.decodeStringElement(__desc, __i)
        44 ->
          _eventUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        45 -> category = decoder.decodeStringElement(__desc, __i)
        46 ->
          _category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        47 -> focus = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.focusSer, null)
        48 -> responseRequired = decoder.decodeStringElement(__desc, __i)
        49 ->
          _responseRequired =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        50 ->
          allowedResponse =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.allowedResponseSer, null)
        51 ->
          graph = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.replacesSer, null)
        52 ->
          _graph =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.replacesSer2, null)
        else -> throw SerializationException("Unexpected index decoding MessageDefinition: " + __i)
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
        (kotlin.collections.List(maxOf(replaces?.size ?: 0, _replaces?.size ?: 0)) { __i ->
          Canonical.of(replaces?.getOrNull(__i)?.let { it }, _replaces?.getOrNull(__i))!!
        }),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date)!!,
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      base = Canonical.of(base, _base),
      parent =
        (kotlin.collections.List(maxOf(parent?.size ?: 0, _parent?.size ?: 0)) { __i ->
          Canonical.of(parent?.getOrNull(__i)?.let { it }, _parent?.getOrNull(__i))!!
        }),
      event = MessageDefinition.Event.from(eventCoding, Uri.of(eventUri, _eventUri))!!,
      category =
        category?.let {
          Enumeration.of(MessageDefinition.MessageSignificanceCategory.fromCode(it), _category)
        },
      focus = focus ?: listOf(),
      responseRequired =
        responseRequired?.let {
          Enumeration.of(
            MessageDefinition.MessageheaderResponseRequest.fromCode(it),
            _responseRequired,
          )
        },
      allowedResponse = allowedResponse ?: listOf(),
      graph =
        (kotlin.collections.List(maxOf(graph?.size ?: 0, _graph?.size ?: 0)) { __i ->
          Canonical.of(graph?.getOrNull(__i)?.let { it }, _graph?.getOrNull(__i))!!
        }),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: MessageDefinition,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.replaces.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.replacesSer, it)
    }
    (value.replaces.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.replacesSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 23 + __off, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 25 + __off, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 27 + __off, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 30 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        33 + __off,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 34 + __off, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 36 + __off, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.base?.value))?.let { encoder.encodeStringElement(__desc, 38 + __off, it) }
    (value.base?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.parent.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.replacesSer, it)
    }
    (value.parent.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.replacesSer2, it)
    }
    when (val __d = value.event) {
      null -> {}
      is MessageDefinition.Event.Coding -> {
        encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.eventCodingSer, __d.value)
      }
      is MessageDefinition.Event.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 43 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.category?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 45 + __off, it)
    }
    (value.category?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.focusSer, value.focus)
    ((value.responseRequired?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 48 + __off, it)
    }
    (value.responseRequired?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.allowedResponse.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        50 + __off,
        Hoisted.allowedResponseSer,
        value.allowedResponse,
      )
    (value.graph.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 51 + __off, Hoisted.replacesSer, it)
    }
    (value.graph.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 52 + __off, Hoisted.replacesSer2, it)
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

    public val replacesSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val replacesSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.replacesSerInner).nullable)

    public val replacesSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val eventCodingSer: KSerializer<Coding> = Coding.serializer()

    public val focusSerInner: KSerializer<MessageDefinition.Focus> =
      MessageDefinition.Focus.serializer()

    public val focusSer: KSerializer<List<MessageDefinition.Focus>> =
      ListSerializer(Hoisted.focusSerInner)

    public val allowedResponseSerInner: KSerializer<MessageDefinition.AllowedResponse> =
      MessageDefinition.AllowedResponse.serializer()

    public val allowedResponseSer: KSerializer<List<MessageDefinition.AllowedResponse>> =
      ListSerializer(Hoisted.allowedResponseSerInner)
  }
}

internal object MessageDefinitionPolymorphicSerializer : KSerializer<MessageDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MessageDefinition") {
      MessageDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MessageDefinition) {
    encoder.encodeStructure(descriptor) {
      MessageDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MessageDefinition =
    decoder.decodeStructure(descriptor) {
      MessageDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
