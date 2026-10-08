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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MessageDefinition
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.MessageSignificanceCategory
import dev.ohs.fhir.model.r5.terminologies.MessageheaderResponseRequest
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.ResourceType
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

  override fun deserialize(decoder: Decoder): MessageDefinition.Focus {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> profile = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Focus: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MessageDefinition.Focus(
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
      max = R5String.of(max, _max),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.Focus) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.profile?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.profile)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.min.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.max?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.max)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MessageDefinition.AllowedResponse {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var message: KotlinString? = null
    var _message: Element? = null
    var situation: KotlinString? = null
    var _situation: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> message = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _message =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> situation = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _situation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AllowedResponse: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MessageDefinition.AllowedResponse(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.message.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.message)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.situation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.situation)
    compositeEncoder.endStructure(descriptor)
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
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
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
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
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
    b.optionalElement("graph", KotlinString.serializer().descriptor)
    b.optionalElement("_graph", ElementSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
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
    var graph: KotlinString? = null
    var _graph: Element? = null
    while (true) {
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> versionAlgorithmString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          versionAlgorithmCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        18 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          replaces =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        23 ->
          _replaces =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        24 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        36 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        37 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> copyrightLabel = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _copyrightLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> base = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _base =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          parent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _parent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 ->
          eventCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        48 -> eventUri = compositeDecoder.decodeStringElement(descriptor, i)
        49 ->
          _eventUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        50 -> category = compositeDecoder.decodeStringElement(descriptor, i)
        51 ->
          _category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        52 ->
          focus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageDefinitionFocusSerializer.listSerializer,
              null,
            )
        53 -> responseRequired = compositeDecoder.decodeStringElement(descriptor, i)
        54 ->
          _responseRequired =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        55 ->
          allowedResponse =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageDefinitionAllowedResponseSerializer.listSerializer,
              null,
            )
        56 -> graph = compositeDecoder.decodeStringElement(descriptor, i)
        57 ->
          _graph =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        MessageDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
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
      experimental = R5Boolean.of(experimental, _experimental),
      date =
        DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date)
          ?: throw SerializationException("Missing required property 'date' on MessageDefinition"),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
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
          if (category != null) MessageSignificanceCategory.fromCode(category) else null,
          _category,
        ),
      focus = focus ?: listOf(),
      responseRequired =
        Enumeration.of(
          if (responseRequired != null) MessageheaderResponseRequest.fromCode(responseRequired)
          else null,
          _responseRequired,
        ),
      allowedResponse = allowedResponse ?: listOf(),
      graph = Canonical.of(graph, _graph),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MessageDefinition,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is MessageDefinition.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is MessageDefinition.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    if (value.replaces.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        22 + descriptorOffset,
        stringNullableListSerializer,
        value.replaces.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 23 + descriptorOffset, value.replaces)
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.date.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.copyrightLabel?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyrightLabel)
    compositeEncoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, value.base?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.base)
    if (value.parent.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        value.parent.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 46 + descriptorOffset, value.parent)
    }
    when (val choice = value.event) {
      is MessageDefinition.Event.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          47 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
      is MessageDefinition.Event.Uri -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          48 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 49 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      50 + descriptorOffset,
      value.category?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 51 + descriptorOffset, value.category)
    if (value.focus.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        MessageDefinitionFocusSerializer.listSerializer,
        value.focus,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      53 + descriptorOffset,
      value.responseRequired?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      54 + descriptorOffset,
      value.responseRequired,
    )
    if (value.allowedResponse.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        MessageDefinitionAllowedResponseSerializer.listSerializer,
        value.allowedResponse,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 56 + descriptorOffset, value.graph?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 57 + descriptorOffset, value.graph)
  }
}
