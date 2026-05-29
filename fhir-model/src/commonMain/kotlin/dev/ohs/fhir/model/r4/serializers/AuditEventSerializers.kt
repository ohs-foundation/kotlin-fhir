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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.AuditEvent
import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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

internal object AuditEventAgentSerializer : KSerializer<AuditEvent.Agent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Agent") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "role",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("who", Reference.serializer().descriptor, isOptional = true)
      element("altId", KotlinString.serializer().descriptor, isOptional = true)
      element("_altId", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("requestor", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_requestor", Element.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element(
        "policy",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_policy", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("media", Coding.serializer().descriptor, isOptional = true)
      element(
        "network",
        lazyDescriptor { AuditEvent.Agent.Network.serializer().descriptor },
        isOptional = true,
      )
      element(
        "purposeOfUse",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): AuditEvent.Agent =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Agent) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AuditEvent.Agent {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        5 -> who = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whoSer, null)
        6 -> altId = decoder.decodeStringElement(descriptor, i)
        7 ->
          _altId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.altIdSer, null)
        8 -> name = decoder.decodeStringElement(descriptor, i)
        9 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.altIdSer, null)
        10 -> requestor = decoder.decodeBooleanElement(descriptor, i)
        11 ->
          _requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.altIdSer, null)
        12 ->
          location = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whoSer, null)
        13 ->
          policy = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policySer, null)
        14 ->
          _policy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policySer2, null)
        15 ->
          media = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mediaSer, null)
        16 ->
          network =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.networkSer, null)
        17 ->
          purposeOfUse =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Agent: " + i)
      }
    }
    return AuditEvent.Agent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      role = role ?: listOf(),
      who = who,
      altId = R4String.of(altId, _altId),
      name = R4String.of(name, _name),
      requestor = R4Boolean.of(requestor, _requestor)!!,
      location = location,
      policy =
        (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { index ->
          Uri.of(policy?.getOrNull(index)?.let { it }, _policy?.getOrNull(index))!!
        }),
      media = media,
      network = network,
      purposeOfUse = purposeOfUse ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AuditEvent.Agent) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    if (value.role.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.roleSer, value.role)
    (value.who)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.whoSer, it) }
    ((value.altId?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.altId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.altIdSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.altIdSer, it)
    }
    ((value.requestor.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
    (value.requestor.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.altIdSer, it)
    }
    (value.location)?.let { encoder.encodeSerializableElement(descriptor, 12, Hoisted.whoSer, it) }
    (value.policy.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.policySer, it)
    }
    (value.policy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.policySer2, it)
    }
    (value.media)?.let { encoder.encodeSerializableElement(descriptor, 15, Hoisted.mediaSer, it) }
    (value.network)?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.networkSer, it)
    }
    if (value.purposeOfUse.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.roleSer, value.purposeOfUse)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val roleSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val whoSer: KSerializer<Reference> = Reference.serializer()

    public val altIdSer: KSerializer<Element> = Element.serializer()

    public val policySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val policySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.policySerInner).nullable)

    public val policySer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.altIdSer).nullable)

    public val mediaSer: KSerializer<Coding> = Coding.serializer()

    public val networkSer: KSerializer<AuditEvent.Agent.Network> =
      AuditEvent.Agent.Network.serializer()
  }
}

internal object AuditEventAgentNetworkSerializer : KSerializer<AuditEvent.Agent.Network> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Network") {
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
      element("address", KotlinString.serializer().descriptor, isOptional = true)
      element("_address", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AuditEvent.Agent.Network =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Agent.Network) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AuditEvent.Agent.Network {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var address: KotlinString? = null
    var _address: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> address = decoder.decodeStringElement(descriptor, i)
        4 ->
          _address =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressSer, null)
        5 -> type = decoder.decodeStringElement(descriptor, i)
        6 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Network: " + i)
      }
    }
    return AuditEvent.Agent.Network(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      address = R4String.of(address, _address),
      type = type?.let { Enumeration.of(AuditEvent.AuditEventAgentNetworkType.fromCode(it), _type) },
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AuditEvent.Agent.Network) {
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
    ((value.address?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.address?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.addressSer, it)
    }
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.addressSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val addressSer: KSerializer<Element> = Element.serializer()
  }
}

internal object AuditEventSourceSerializer : KSerializer<AuditEvent.Source> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Source") {
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
      element("site", KotlinString.serializer().descriptor, isOptional = true)
      element("_site", Element.serializer().descriptor, isOptional = true)
      element("observer", Reference.serializer().descriptor, isOptional = true)
      element("type", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AuditEvent.Source =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Source) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AuditEvent.Source {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: KotlinString? = null
    var _site: Element? = null
    var observer: Reference? = null
    var type: List<Coding>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> site = decoder.decodeStringElement(descriptor, i)
        4 -> _site = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.siteSer, null)
        5 ->
          observer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.observerSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Source: " + i)
      }
    }
    return AuditEvent.Source(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      site = R4String.of(site, _site),
      observer = observer!!,
      type = type ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AuditEvent.Source) {
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
    ((value.site?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.site?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.siteSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.observerSer, value.observer)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, value.type)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val siteSer: KSerializer<Element> = Element.serializer()

    public val observerSer: KSerializer<Reference> = Reference.serializer()

    public val typeSerInner: KSerializer<Coding> = Coding.serializer()

    public val typeSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.typeSerInner)
  }
}

internal object AuditEventEntitySerializer : KSerializer<AuditEvent.Entity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entity") {
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
      element("what", Reference.serializer().descriptor, isOptional = true)
      element("type", Coding.serializer().descriptor, isOptional = true)
      element("role", Coding.serializer().descriptor, isOptional = true)
      element("lifecycle", Coding.serializer().descriptor, isOptional = true)
      element(
        "securityLabel",
        listSerialDescriptor(Coding.serializer().descriptor),
        isOptional = true,
      )
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("query", KotlinString.serializer().descriptor, isOptional = true)
      element("_query", Element.serializer().descriptor, isOptional = true)
      element(
        "detail",
        listSerialDescriptor(lazyDescriptor { AuditEvent.Entity.Detail.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): AuditEvent.Entity =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AuditEvent.Entity {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> what = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whatSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 ->
          lifecycle =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securityLabelSer, null)
        8 -> name = decoder.decodeStringElement(descriptor, i)
        9 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        10 -> description = decoder.decodeStringElement(descriptor, i)
        11 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        12 -> query = decoder.decodeStringElement(descriptor, i)
        13 ->
          _query = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        14 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entity: " + i)
      }
    }
    return AuditEvent.Entity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      what = what,
      type = type,
      role = role,
      lifecycle = lifecycle,
      securityLabel = securityLabel ?: listOf(),
      name = R4String.of(name, _name),
      description = R4String.of(description, _description),
      query = Base64Binary.of(query, _query),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AuditEvent.Entity) {
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
    (value.what)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.whatSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    (value.lifecycle)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        Hoisted.securityLabelSer,
        value.securityLabel,
      )
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.nameSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.nameSer, it)
    }
    ((value.query?.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.query?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.nameSer, it)
    }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val whatSer: KSerializer<Reference> = Reference.serializer()

    public val typeSer: KSerializer<Coding> = Coding.serializer()

    public val securityLabelSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.typeSer)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val detailSerInner: KSerializer<AuditEvent.Entity.Detail> =
      AuditEvent.Entity.Detail.serializer()

    public val detailSer: KSerializer<List<AuditEvent.Entity.Detail>> =
      ListSerializer(Hoisted.detailSerInner)
  }
}

internal object AuditEventEntityDetailSerializer : KSerializer<AuditEvent.Entity.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
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
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueBase64Binary", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AuditEvent.Entity.Detail =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity.Detail) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AuditEvent.Entity.Detail {
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
        5 -> valueString = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        8 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    return AuditEvent.Entity.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = R4String.of(type, _type)!!,
      `value` =
        AuditEvent.Entity.Detail.Value.from(
          R4String.of(valueString, _valueString),
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
        )!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AuditEvent.Entity.Detail) {
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
    ((value.type.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    when (val choice = value.`value`) {
      is AuditEvent.Entity.Detail.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object AuditEventSerializer : KSerializer<AuditEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AuditEvent") {
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
    b.element("type", Coding.serializer().descriptor, isOptional = true)
    b.element("subtype", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
    b.element("action", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_action", Element.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("recorded", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_recorded", Element.serializer().descriptor, isOptional = true)
    b.element("outcome", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outcome", Element.serializer().descriptor, isOptional = true)
    b.element("outcomeDesc", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outcomeDesc", Element.serializer().descriptor, isOptional = true)
    b.element(
      "purposeOfEvent",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "agent",
      listSerialDescriptor(lazyDescriptor { AuditEvent.Agent.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "source",
      lazyDescriptor { AuditEvent.Source.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "entity",
      listSerialDescriptor(lazyDescriptor { AuditEvent.Entity.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): AuditEvent =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "AuditEvent")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        10 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        11 ->
          subtype =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subtypeSer, null)
        12 -> action = decoder.decodeStringElement(descriptor, i)
        13 ->
          _action =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        15 -> recorded = decoder.decodeStringElement(descriptor, i)
        16 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> outcome = decoder.decodeStringElement(descriptor, i)
        18 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> outcomeDesc = decoder.decodeStringElement(descriptor, i)
        20 ->
          _outcomeDesc =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          purposeOfEvent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.purposeOfEventSer,
              null,
            )
        22 ->
          agent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.agentSer, null)
        23 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        24 ->
          entity = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entitySer, null)
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
      type = type!!,
      subtype = subtype ?: listOf(),
      action = action?.let { Enumeration.of(AuditEvent.AuditEventAction.fromCode(it), _action) },
      period = period,
      recorded = Instant.of(FhirDateTime.fromString(recorded), _recorded)!!,
      outcome =
        outcome?.let { Enumeration.of(AuditEvent.AuditEventOutcome.fromCode(it), _outcome) },
      outcomeDesc = R4String.of(outcomeDesc, _outcomeDesc),
      purposeOfEvent = purposeOfEvent ?: listOf(),
      agent = agent ?: listOf(),
      source = source!!,
      entity = entity ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AuditEvent,
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
    encoder.encodeSerializableElement(
      descriptor,
      10 + descriptorOffset,
      Hoisted.typeSer,
      value.type,
    )
    if (value.subtype.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.subtypeSer,
        value.subtype,
      )
    ((value.action?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.action?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.periodSer, it)
    }
    ((value.recorded.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.recorded.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.outcome?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.outcome?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.outcomeDesc?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.outcomeDesc?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.purposeOfEvent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.purposeOfEventSer,
        value.purposeOfEvent,
      )
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.agentSer,
        value.agent,
      )
    encoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      Hoisted.sourceSer,
      value.source,
    )
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.entitySer,
        value.entity,
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

    public val typeSer: KSerializer<Coding> = Coding.serializer()

    public val subtypeSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.typeSer)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val purposeOfEventSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val purposeOfEventSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.purposeOfEventSerInner)

    public val agentSerInner: KSerializer<AuditEvent.Agent> = AuditEvent.Agent.serializer()

    public val agentSer: KSerializer<List<AuditEvent.Agent>> = ListSerializer(Hoisted.agentSerInner)

    public val sourceSer: KSerializer<AuditEvent.Source> = AuditEvent.Source.serializer()

    public val entitySerInner: KSerializer<AuditEvent.Entity> = AuditEvent.Entity.serializer()

    public val entitySer: KSerializer<List<AuditEvent.Entity>> =
      ListSerializer(Hoisted.entitySerInner)
  }
}

internal object AuditEventPolymorphicSerializer : KSerializer<AuditEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AuditEvent") { AuditEventSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent) {
    encoder.encodeStructure(descriptor) {
      AuditEventSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): AuditEvent =
    decoder.decodeStructure(descriptor) {
      AuditEventSerializer.deserializeInternal(this, descriptor, 0)
    }
}
