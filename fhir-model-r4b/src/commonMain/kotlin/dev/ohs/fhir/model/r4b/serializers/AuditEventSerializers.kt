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

import dev.ohs.fhir.model.r4b.AuditEvent
import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object AuditEventAgentSerializer : KSerializer<AuditEvent.Agent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Agent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("who", ReferenceSerializer.descriptor)
      optionalElement("altId", KotlinString.serializer().descriptor)
      optionalElement("_altId", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("requestor", KotlinBoolean.serializer().descriptor)
      optionalElement("_requestor", ElementSerializer.descriptor)
      optionalElement("location", ReferenceSerializer.descriptor)
      optionalElement("policy", stringNullableListSerializer.descriptor)
      optionalElement("_policy", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("media", CodingSerializer.descriptor)
      optionalElement("network", AuditEventAgentNetworkSerializer.descriptor)
      optionalElement("purposeOfUse", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Agent>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Agent =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var role: List<CodeableConcept>? = null
      var who: Reference? = null
      var altId: KotlinString? = null
      var _altId: Element? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var requestor: KotlinBoolean? = null
      var _requestor: Element? = null
      var location: Reference? = null
      var policy: List<KotlinString?>? = null
      var _policy: List<Element?>? = null
      var media: Coding? = null
      var network: AuditEvent.Agent.Network? = null
      var purposeOfUse: List<CodeableConcept>? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            role =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 -> who = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> altId = decodeStringElement(descriptor, i)
          7 -> _altId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> name = decodeStringElement(descriptor, i)
          9 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> requestor = decodeBooleanElement(descriptor, i)
          11 ->
            _requestor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            location = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          13 ->
            policy =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          14 ->
            _policy =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          15 -> media = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          16 ->
            network =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AuditEventAgentNetworkSerializer,
                null,
              )
          17 ->
            purposeOfUse =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Agent: " + i)
        }
      }
      AuditEvent.Agent(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        role = role ?: listOf(),
        who = who,
        altId = R4bString.of(altId, _altId),
        name = R4bString.of(name, _name),
        requestor =
          R4bBoolean.of(requestor, _requestor)
            ?: throw SerializationException(
              "Missing required property 'requestor' on AuditEvent.Agent"
            ),
        location = location,
        policy =
          (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { index ->
            Uri.of(policy?.getOrNull(index), _policy?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'policy' on AuditEvent.Agent has neither a value nor an id/extension"
              )
          }),
        media = media,
        network = network,
        purposeOfUse = purposeOfUse ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Agent) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      if (value.role.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.role,
        )
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.who)
      encodeStringIfNotNull(descriptor, 6, value.altId?.value)
      encodeElementIfNotNull(descriptor, 7, value.altId)
      encodeStringIfNotNull(descriptor, 8, value.name?.value)
      encodeElementIfNotNull(descriptor, 9, value.name)
      encodeBooleanIfNotNull(descriptor, 10, value.requestor.value)
      encodeElementIfNotNull(descriptor, 11, value.requestor)
      encodeSerializableIfNotNull(descriptor, 12, ReferenceSerializer, value.location)
      if (value.policy.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          13,
          stringNullableListSerializer,
          value.policy.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 14, value.policy)
      }
      encodeSerializableIfNotNull(descriptor, 15, CodingSerializer, value.media)
      encodeSerializableIfNotNull(descriptor, 16, AuditEventAgentNetworkSerializer, value.network)
      if (value.purposeOfUse.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          17,
          CodeableConceptSerializer.listSerializer,
          value.purposeOfUse,
        )
    }
  }
}

internal object AuditEventAgentNetworkSerializer : KSerializer<AuditEvent.Agent.Network> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Network") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("address", KotlinString.serializer().descriptor)
      optionalElement("_address", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Agent.Network>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Agent.Network =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var address: KotlinString? = null
      var _address: Element? = null
      var type: KotlinString? = null
      var _type: Element? = null
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
          3 -> address = decodeStringElement(descriptor, i)
          4 -> _address = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeStringElement(descriptor, i)
          6 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Network: " + i)
        }
      }
      AuditEvent.Agent.Network(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        address = R4bString.of(address, _address),
        type =
          Enumeration.of(
            if (type != null) AuditEvent.AuditEventAgentNetworkType.fromCode(type) else null,
            _type,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Agent.Network) {
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
      encodeStringIfNotNull(descriptor, 3, value.address?.value)
      encodeElementIfNotNull(descriptor, 4, value.address)
      encodeStringIfNotNull(descriptor, 5, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.type)
    }
  }
}

internal object AuditEventSourceSerializer : KSerializer<AuditEvent.Source> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Source") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("site", KotlinString.serializer().descriptor)
      optionalElement("_site", ElementSerializer.descriptor)
      optionalElement("observer", ReferenceSerializer.descriptor)
      optionalElement("type", CodingSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Source>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Source =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var site: KotlinString? = null
      var _site: Element? = null
      var observer: Reference? = null
      var type: List<Coding>? = null
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
          3 -> site = decodeStringElement(descriptor, i)
          4 -> _site = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            observer = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Source: " + i)
        }
      }
      AuditEvent.Source(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        site = R4bString.of(site, _site),
        observer =
          observer
            ?: throw SerializationException(
              "Missing required property 'observer' on AuditEvent.Source"
            ),
        type = type ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Source) {
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
      encodeStringIfNotNull(descriptor, 3, value.site?.value)
      encodeElementIfNotNull(descriptor, 4, value.site)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.observer)
      if (value.type.isNotEmpty())
        encodeSerializableElement(descriptor, 6, CodingSerializer.listSerializer, value.type)
    }
  }
}

internal object AuditEventEntitySerializer : KSerializer<AuditEvent.Entity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entity") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("what", ReferenceSerializer.descriptor)
      optionalElement("type", CodingSerializer.descriptor)
      optionalElement("role", CodingSerializer.descriptor)
      optionalElement("lifecycle", CodingSerializer.descriptor)
      optionalElement("securityLabel", CodingSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("query", KotlinString.serializer().descriptor)
      optionalElement("_query", ElementSerializer.descriptor)
      optionalElement("detail", AuditEventEntityDetailSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Entity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Entity =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var what: Reference? = null
      var type: Coding? = null
      var role: Coding? = null
      var lifecycle: Coding? = null
      var securityLabel: List<Coding>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var query: KotlinString? = null
      var _query: Element? = null
      var detail: List<AuditEvent.Entity.Detail>? = null
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
          3 -> what = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> type = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          5 -> role = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          6 -> lifecycle = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          7 ->
            securityLabel =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          8 -> name = decodeStringElement(descriptor, i)
          9 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> description = decodeStringElement(descriptor, i)
          11 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> query = decodeStringElement(descriptor, i)
          13 -> _query = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AuditEventEntityDetailSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Entity: " + i)
        }
      }
      AuditEvent.Entity(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        what = what,
        type = type,
        role = role,
        lifecycle = lifecycle,
        securityLabel = securityLabel ?: listOf(),
        name = R4bString.of(name, _name),
        description = R4bString.of(description, _description),
        query = Base64Binary.of(query, _query),
        detail = detail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.what)
      encodeSerializableIfNotNull(descriptor, 4, CodingSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 5, CodingSerializer, value.role)
      encodeSerializableIfNotNull(descriptor, 6, CodingSerializer, value.lifecycle)
      if (value.securityLabel.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodingSerializer.listSerializer,
          value.securityLabel,
        )
      encodeStringIfNotNull(descriptor, 8, value.name?.value)
      encodeElementIfNotNull(descriptor, 9, value.name)
      encodeStringIfNotNull(descriptor, 10, value.description?.value)
      encodeElementIfNotNull(descriptor, 11, value.description)
      encodeStringIfNotNull(descriptor, 12, value.query?.value)
      encodeElementIfNotNull(descriptor, 13, value.query)
      if (value.detail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          AuditEventEntityDetailSerializer.listSerializer,
          value.detail,
        )
    }
  }
}

internal object AuditEventEntityDetailSerializer : KSerializer<AuditEvent.Entity.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_valueBase64Binary", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Entity.Detail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Entity.Detail =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var valueString: KotlinString? = null
      var _valueString: Element? = null
      var valueBase64Binary: KotlinString? = null
      var _valueBase64Binary: Element? = null
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
          5 -> valueString = decodeStringElement(descriptor, i)
          6 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> valueBase64Binary = decodeStringElement(descriptor, i)
          8 ->
            _valueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Detail: " + i)
        }
      }
      AuditEvent.Entity.Detail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          R4bString.of(type, _type)
            ?: throw SerializationException(
              "Missing required property 'type' on AuditEvent.Entity.Detail"
            ),
        `value` =
          AuditEvent.Entity.Detail.Value.from(
            R4bString.of(valueString, _valueString),
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          )
            ?: throw SerializationException(
              "Missing required property 'value' on AuditEvent.Entity.Detail"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity.Detail) {
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
      encodeStringIfNotNull(descriptor, 3, value.type.value)
      encodeElementIfNotNull(descriptor, 4, value.type)
      when (val choice = value.`value`) {
        is AuditEvent.Entity.Detail.Value.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
      }
    }
  }
}

internal object AuditEventSerializer : FhirResourceSerializer<AuditEvent> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("AuditEvent")

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
    b.optionalElement("type", CodingSerializer.descriptor)
    b.optionalElement("subtype", CodingSerializer.listSerializer.descriptor)
    b.optionalElement("action", KotlinString.serializer().descriptor)
    b.optionalElement("_action", ElementSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("recorded", KotlinString.serializer().descriptor)
    b.optionalElement("_recorded", ElementSerializer.descriptor)
    b.optionalElement("outcome", KotlinString.serializer().descriptor)
    b.optionalElement("_outcome", ElementSerializer.descriptor)
    b.optionalElement("outcomeDesc", KotlinString.serializer().descriptor)
    b.optionalElement("_outcomeDesc", ElementSerializer.descriptor)
    b.optionalElement("purposeOfEvent", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("agent", AuditEventAgentSerializer.listSerializer.descriptor)
    b.optionalElement("source", AuditEventSourceSerializer.descriptor)
    b.optionalElement("entity", AuditEventEntitySerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): AuditEvent {
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
    var type: Coding? = null
    var subtype: List<Coding>? = null
    var action: KotlinString? = null
    var _action: Element? = null
    var period: Period? = null
    var recorded: KotlinString? = null
    var _recorded: Element? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var outcomeDesc: KotlinString? = null
    var _outcomeDesc: Element? = null
    var purposeOfEvent: List<CodeableConcept>? = null
    var agent: List<AuditEvent.Agent>? = null
    var source: AuditEvent.Source? = null
    var entity: List<AuditEvent.Entity>? = null
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
        10 ->
          type = decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        11 ->
          subtype =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        12 -> action = decoder.decodeStringElement(descriptor, i)
        13 ->
          _action =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        15 -> recorded = decoder.decodeStringElement(descriptor, i)
        16 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> outcome = decoder.decodeStringElement(descriptor, i)
        18 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> outcomeDesc = decoder.decodeStringElement(descriptor, i)
        20 ->
          _outcomeDesc =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          purposeOfEvent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        22 ->
          agent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventAgentSerializer.listSerializer,
              null,
            )
        23 ->
          source =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventSourceSerializer,
              null,
            )
        24 ->
          entity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventEntitySerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding AuditEvent: " + i)
      }
    }
    return AuditEvent(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: throw SerializationException("Missing required property 'type' on AuditEvent"),
      subtype = subtype ?: listOf(),
      action =
        Enumeration.of(
          if (action != null) AuditEvent.AuditEventAction.fromCode(action) else null,
          _action,
        ),
      period = period,
      recorded =
        Instant.of(if (recorded != null) FhirDateTime.fromString(recorded) else null, _recorded)
          ?: throw SerializationException("Missing required property 'recorded' on AuditEvent"),
      outcome =
        Enumeration.of(
          if (outcome != null) AuditEvent.AuditEventOutcome.fromCode(outcome) else null,
          _outcome,
        ),
      outcomeDesc = R4bString.of(outcomeDesc, _outcomeDesc),
      purposeOfEvent = purposeOfEvent ?: listOf(),
      agent = agent ?: listOf(),
      source =
        source ?: throw SerializationException("Missing required property 'source' on AuditEvent"),
      entity = entity ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AuditEvent,
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
    encoder.encodeSerializableElement(
      descriptor,
      10 + descriptorOffset,
      CodingSerializer,
      value.type,
    )
    if (value.subtype.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        CodingSerializer.listSerializer,
        value.subtype,
      )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.action?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.action)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.recorded.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.recorded)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.outcome?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.outcome)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.outcomeDesc?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.outcomeDesc)
    if (value.purposeOfEvent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.purposeOfEvent,
      )
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        AuditEventAgentSerializer.listSerializer,
        value.agent,
      )
    encoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      AuditEventSourceSerializer,
      value.source,
    )
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        AuditEventEntitySerializer.listSerializer,
        value.entity,
      )
  }
}
