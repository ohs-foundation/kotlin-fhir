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
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.MessageDefinition
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> profile = decoder.decodeStringElement(__desc, 5)
        6 -> _profile = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 -> min = decoder.decodeIntElement(__desc, 7)
        8 -> _min = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        9 -> max = decoder.decodeStringElement(__desc, 9)
        10 -> _max = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.codeSer, null)
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
      max = R4String.of(max, _max),
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> message = decoder.decodeStringElement(__desc, 3)
        4 ->
          _message = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.messageSer, null)
        5 -> situation = decoder.decodeStringElement(__desc, 5)
        6 ->
          _situation =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.messageSer, null)
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element(
        "replaces",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_replaces", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
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
      element("base", KotlinString.serializer().descriptor, isOptional = true)
      element("_base", Element.serializer().descriptor, isOptional = true)
      element(
        "parent",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_parent", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("eventCoding", Coding.serializer().descriptor, isOptional = true)
      element("eventUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_eventUri", Element.serializer().descriptor, isOptional = true)
      element("category", KotlinString.serializer().descriptor, isOptional = true)
      element("_category", Element.serializer().descriptor, isOptional = true)
      element(
        "focus",
        listSerialDescriptor(lazyDescriptor { MessageDefinition.Focus.serializer().descriptor }),
        isOptional = true,
      )
      element("responseRequired", KotlinString.serializer().descriptor, isOptional = true)
      element("_responseRequired", Element.serializer().descriptor, isOptional = true)
      element(
        "allowedResponse",
        listSerialDescriptor(
          lazyDescriptor { MessageDefinition.AllowedResponse.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "graph",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_graph", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MessageDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MessageDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MessageDefinition {
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
        16 -> name = decoder.decodeStringElement(__desc, 16)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> title = decoder.decodeStringElement(__desc, 18)
        19 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          replaces =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.replacesSer, null)
        21 ->
          _replaces =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.replacesSer2, null)
        22 -> status = decoder.decodeStringElement(__desc, 22)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(__desc, 24)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(__desc, 26)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(__desc, 28)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(__desc, 31)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.useContextSer, null)
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.jurisdictionSer, null)
        35 -> purpose = decoder.decodeStringElement(__desc, 35)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 -> copyright = decoder.decodeStringElement(__desc, 37)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 -> base = decoder.decodeStringElement(__desc, 39)
        40 ->
          _base =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.implicitRulesSer, null)
        41 ->
          parent = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.replacesSer, null)
        42 ->
          _parent =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.replacesSer2, null)
        43 ->
          eventCoding =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.eventCodingSer, null)
        44 -> eventUri = decoder.decodeStringElement(__desc, 44)
        45 ->
          _eventUri =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 -> category = decoder.decodeStringElement(__desc, 46)
        47 ->
          _category =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.implicitRulesSer, null)
        48 -> focus = decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.focusSer, null)
        49 -> responseRequired = decoder.decodeStringElement(__desc, 49)
        50 ->
          _responseRequired =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.implicitRulesSer, null)
        51 ->
          allowedResponse =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.allowedResponseSer, null)
        52 ->
          graph = decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.replacesSer, null)
        53 ->
          _graph = decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.replacesSer2, null)
        CompositeDecoder.DECODE_DONE -> break
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      replaces =
        (kotlin.collections.List(maxOf(replaces?.size ?: 0, _replaces?.size ?: 0)) { __i ->
          Canonical.of(replaces?.getOrNull(__i)?.let { it }, _replaces?.getOrNull(__i))!!
        }),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MessageDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MessageDefinition")
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
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.replaces.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.replacesSer, it)
    }
    (value.replaces.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.replacesSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 24, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
    }
    ((value.base?.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
    (value.base?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.implicitRulesSer, it)
    }
    (value.parent.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.replacesSer, it)
    }
    (value.parent.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.replacesSer2, it)
    }
    when (val __d = value.event) {
      null -> {}
      is MessageDefinition.Event.Coding -> {
        encoder.encodeSerializableElement(__desc, 43, Hoisted.eventCodingSer, __d.value)
      }
      is MessageDefinition.Event.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 44, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.category?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 46, it) }
    (value.category?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.implicitRulesSer, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.focusSer, value.focus)
    ((value.responseRequired?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 49, it)
    }
    (value.responseRequired?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 50, Hoisted.implicitRulesSer, it)
    }
    if (value.allowedResponse.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        51,
        Hoisted.allowedResponseSer,
        value.allowedResponse,
      )
    (value.graph.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 52, Hoisted.replacesSer, it)
    }
    (value.graph.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 53, Hoisted.replacesSer2, it)
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
