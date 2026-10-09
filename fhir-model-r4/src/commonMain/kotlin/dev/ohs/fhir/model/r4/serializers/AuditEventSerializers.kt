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
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.AuditEventAction
import dev.ohs.fhir.model.r4.terminologies.AuditEventAgentNetworkType
import dev.ohs.fhir.model.r4.terminologies.AuditEventOutcome
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object AuditEventAgentSerializer : FhirSerializer<AuditEvent.Agent> {
  override val descriptor: SerialDescriptor = buildDescriptor("Agent", this)

  @JvmField internal val listSerializer: KSerializer<List<AuditEvent.Agent>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("role", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("who", ReferenceSerializer.descriptor)
    b.strPrim("altId")
    b.strPrim("name")
    b.boolPrim("requestor")
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.strPrimList("policy")
    b.optionalElement("media", CodingSerializer.descriptor)
    b.optionalElement("network", AuditEventAgentNetworkSerializer.descriptor)
    b.optionalElement("purposeOfUse", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AuditEvent.Agent {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          who =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 -> altId = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _altId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> requestor = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _requestor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        13 ->
          policy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _policy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          media =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        16 ->
          network =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventAgentNetworkSerializer,
              null,
            )
        17 ->
          purposeOfUse =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val policy_ =
      List(maxSize(policy, _policy)) { index ->
        entryRequired(Uri.of(at(policy, index), at(_policy, index)), "AuditEvent.Agent", "policy")
      }
    return AuditEvent.Agent(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      role = listOrEmpty(role),
      who = who,
      altId = R4String.of(altId, _altId),
      name = R4String.of(name, _name),
      requestor = required(R4Boolean.of(requestor, _requestor), "AuditEvent.Agent", "requestor"),
      location = location,
      policy = policy_,
      media = media,
      network = network,
      purposeOfUse = listOrEmpty(purposeOfUse),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Agent) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.role,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.who)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.altId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.altId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.name)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, value.requestor.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.requestor)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      ReferenceSerializer,
      value.location,
    )
    if (!value.policy.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13,
        stringNullableListSerializer,
        value.policy.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 14, value.policy)
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 15, CodingSerializer, value.media)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16,
      AuditEventAgentNetworkSerializer,
      value.network,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17,
      CodeableConceptSerializer.listSerializer,
      value.purposeOfUse,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AuditEventAgentNetworkSerializer : FhirSerializer<AuditEvent.Agent.Network> {
  override val descriptor: SerialDescriptor = buildDescriptor("Network", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AuditEvent.Agent.Network>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("address")
    b.strPrim("type")
  }

  override fun deserialize(decoder: Decoder): AuditEvent.Agent.Network {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var address: KotlinString? = null
    var _address: Element? = null
    var type: AuditEventAgentNetworkType? = null
    var _type: Element? = null
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
        3 -> address = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _address =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          type =
            AuditEventAgentNetworkType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AuditEvent.Agent.Network(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      address = R4String.of(address, _address),
      type = Enumeration.of(type, _type),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Agent.Network) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.address?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.address)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AuditEventSourceSerializer : FhirSerializer<AuditEvent.Source> {
  override val descriptor: SerialDescriptor = buildDescriptor("Source", this)

  @JvmField internal val listSerializer: KSerializer<List<AuditEvent.Source>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("site")
    b.optionalElement("observer", ReferenceSerializer.descriptor)
    b.optionalElement("type", CodingSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AuditEvent.Source {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: KotlinString? = null
    var _site: Element? = null
    var observer: Reference? = null
    var type: List<Coding>? = null
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
        3 -> site = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _site =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          observer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AuditEvent.Source(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      site = R4String.of(site, _site),
      observer = required(observer, "AuditEvent.Source", "observer"),
      type = listOrEmpty(type),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Source) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.site?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.site)
    compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.observer)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      CodingSerializer.listSerializer,
      value.type,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AuditEventEntitySerializer : FhirSerializer<AuditEvent.Entity> {
  override val descriptor: SerialDescriptor = buildDescriptor("Entity", this)

  @JvmField internal val listSerializer: KSerializer<List<AuditEvent.Entity>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("what", ReferenceSerializer.descriptor)
    b.optionalElement("type", CodingSerializer.descriptor)
    b.optionalElement("role", CodingSerializer.descriptor)
    b.optionalElement("lifecycle", CodingSerializer.descriptor)
    b.optionalElement("securityLabel", CodingSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("description")
    b.strPrim("query")
    b.optionalElement("detail", AuditEventEntityDetailSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AuditEvent.Entity {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 ->
          what =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        5 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        6 ->
          lifecycle =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        7 ->
          securityLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        8 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> query = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _query =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventEntityDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AuditEvent.Entity(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      what = what,
      type = type,
      role = role,
      lifecycle = lifecycle,
      securityLabel = listOrEmpty(securityLabel),
      name = R4String.of(name, _name),
      description = R4String.of(description, _description),
      query = Base64Binary.of(query, _query),
      detail = listOrEmpty(detail),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.what)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, CodingSerializer, value.type)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, CodingSerializer, value.role)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, CodingSerializer, value.lifecycle)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodingSerializer.listSerializer,
      value.securityLabel,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.query?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.query)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      AuditEventEntityDetailSerializer.listSerializer,
      value.detail,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AuditEventEntityDetailSerializer : FhirSerializer<AuditEvent.Entity.Detail> {
  override val descriptor: SerialDescriptor = buildDescriptor("Detail", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AuditEvent.Entity.Detail>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("valueString")
    b.strPrim("valueBase64Binary")
  }

  override fun deserialize(decoder: Decoder): AuditEvent.Entity.Detail {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> valueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _valueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AuditEvent.Entity.Detail(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(R4String.of(type, _type), "AuditEvent.Entity.Detail", "type"),
      `value` =
        required(
          AuditEvent.Entity.Detail.Value.from(
            R4String.of(valueString, _valueString),
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          ),
          "AuditEvent.Entity.Detail",
          "value",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity.Detail) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    when (val choice = value.`value`) {
      is AuditEvent.Entity.Detail.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is AuditEvent.Entity.Detail.Value.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AuditEventSerializer : FhirResourceSerializer<AuditEvent> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("AuditEvent")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodingSerializer.descriptor)
    b.optionalElement("subtype", CodingSerializer.listSerializer.descriptor)
    b.strPrim("action")
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.strPrim("recorded")
    b.strPrim("outcome")
    b.strPrim("outcomeDesc")
    b.optionalElement("purposeOfEvent", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("agent", AuditEventAgentSerializer.listSerializer.descriptor)
    b.optionalElement("source", AuditEventSourceSerializer.descriptor)
    b.optionalElement("entity", AuditEventEntitySerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var action: AuditEventAction? = null
    var _action: Element? = null
    var period: Period? = null
    var recorded: FhirDateTime? = null
    var _recorded: Element? = null
    var outcome: AuditEventOutcome? = null
    var _outcome: Element? = null
    var outcomeDesc: KotlinString? = null
    var _outcomeDesc: Element? = null
    var purposeOfEvent: List<CodeableConcept>? = null
    var agent: List<AuditEvent.Agent>? = null
    var source: AuditEvent.Source? = null
    var entity: List<AuditEvent.Entity>? = null
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
        10 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        11 ->
          subtype =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        12 ->
          action = AuditEventAction.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        15 ->
          recorded = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _recorded =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          outcome = AuditEventOutcome.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> outcomeDesc = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _outcomeDesc =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          purposeOfEvent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        22 ->
          agent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventAgentSerializer.listSerializer,
              null,
            )
        23 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventSourceSerializer,
              null,
            )
        24 ->
          entity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventEntitySerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return AuditEvent(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "AuditEvent", "type"),
      subtype = listOrEmpty(subtype),
      action = Enumeration.of(action, _action),
      period = period,
      recorded = required(Instant.of(recorded, _recorded), "AuditEvent", "recorded"),
      outcome = Enumeration.of(outcome, _outcome),
      outcomeDesc = R4String.of(outcomeDesc, _outcomeDesc),
      purposeOfEvent = listOrEmpty(purposeOfEvent),
      agent = listOrEmpty(agent),
      source = required(source, "AuditEvent", "source"),
      entity = listOrEmpty(entity),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AuditEvent,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      10 + descriptorOffset,
      CodingSerializer,
      value.type,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11 + descriptorOffset,
      CodingSerializer.listSerializer,
      value.subtype,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.action?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.action)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.recorded.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.recorded)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.outcome?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.outcome)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.outcomeDesc?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.outcomeDesc)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.purposeOfEvent,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      AuditEventAgentSerializer.listSerializer,
      value.agent,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      AuditEventSourceSerializer,
      value.source,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24 + descriptorOffset,
      AuditEventEntitySerializer.listSerializer,
      value.entity,
    )
  }
}
