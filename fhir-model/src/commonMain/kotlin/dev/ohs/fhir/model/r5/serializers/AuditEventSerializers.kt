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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.AuditEvent
import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object AuditEventOutcomeSerializer : KSerializer<AuditEvent.Outcome> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Outcome") {
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
      element("code", Coding.serializer().descriptor, isOptional = true)
      element(
        "detail",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): AuditEvent.Outcome =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Outcome) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AuditEvent.Outcome {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: Coding? = null
    var detail: List<CodeableConcept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Outcome: " + i)
      }
    }
    return AuditEvent.Outcome(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AuditEvent.Outcome) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Coding> = Coding.serializer()

    public val detailSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val detailSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.detailSerInner)
  }
}

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
      element("requestor", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_requestor", Element.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element(
        "policy",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_policy", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("networkReference", Reference.serializer().descriptor, isOptional = true)
      element("networkUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_networkUri", Element.serializer().descriptor, isOptional = true)
      element("networkString", KotlinString.serializer().descriptor, isOptional = true)
      element("_networkString", Element.serializer().descriptor, isOptional = true)
      element(
        "authorization",
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
    var requestor: KotlinBoolean? = null
    var _requestor: Element? = null
    var location: Reference? = null
    var policy: List<KotlinString?>? = null
    var _policy: List<Element?>? = null
    var networkReference: Reference? = null
    var networkUri: KotlinString? = null
    var _networkUri: Element? = null
    var networkString: KotlinString? = null
    var _networkString: Element? = null
    var authorization: List<CodeableConcept>? = null
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
        6 -> requestor = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestorSer, null)
        8 ->
          location = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whoSer, null)
        9 ->
          policy = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policySer, null)
        10 ->
          _policy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policySer2, null)
        11 ->
          networkReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whoSer, null)
        12 -> networkUri = decoder.decodeStringElement(descriptor, i)
        13 ->
          _networkUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestorSer, null)
        14 -> networkString = decoder.decodeStringElement(descriptor, i)
        15 ->
          _networkString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestorSer, null)
        16 ->
          authorization =
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
      who = who!!,
      requestor = R5Boolean.of(requestor, _requestor),
      location = location,
      policy =
        (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { index ->
          Uri.of(policy?.getOrNull(index)?.let { it }, _policy?.getOrNull(index))!!
        }),
      network =
        AuditEvent.Agent.Network.from(
          networkReference,
          Uri.of(networkUri, _networkUri),
          R5String.of(networkString, _networkString),
        ),
      authorization = authorization ?: listOf(),
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
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.whoSer, value.who)
    ((value.requestor?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.requestor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.requestorSer, it)
    }
    (value.location)?.let { encoder.encodeSerializableElement(descriptor, 8, Hoisted.whoSer, it) }
    (value.policy.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.policySer, it)
    }
    (value.policy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.policySer2, it)
    }
    when (val choice = value.network) {
      null -> {}
      is AuditEvent.Agent.Network.Reference -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.whoSer, choice.value)
      }
      is AuditEvent.Agent.Network.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.requestorSer, it)
        }
      }
      is AuditEvent.Agent.Network.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.requestorSer, it)
        }
      }
    }
    if (value.authorization.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.roleSer, value.authorization)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val roleSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val whoSer: KSerializer<Reference> = Reference.serializer()

    public val requestorSer: KSerializer<Element> = Element.serializer()

    public val policySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val policySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.policySerInner).nullable)

    public val policySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.requestorSer).nullable)
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
      element("site", Reference.serializer().descriptor, isOptional = true)
      element("observer", Reference.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
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
    var site: Reference? = null
    var observer: Reference? = null
    var type: List<CodeableConcept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> site = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.siteSer, null)
        4 ->
          observer = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.siteSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Source: " + i)
      }
    }
    return AuditEvent.Source(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      site = site,
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
    (value.site)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.siteSer, it) }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.siteSer, value.observer)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, value.type)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val siteSer: KSerializer<Reference> = Reference.serializer()

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)
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
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "securityLabel",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("query", KotlinString.serializer().descriptor, isOptional = true)
      element("_query", Element.serializer().descriptor, isOptional = true)
      element(
        "detail",
        listSerialDescriptor(lazyDescriptor { AuditEvent.Entity.Detail.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "agent",
        listSerialDescriptor(lazyDescriptor { AuditEvent.Agent.serializer().descriptor }),
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
    var role: CodeableConcept? = null
    var securityLabel: List<CodeableConcept>? = null
    var query: KotlinString? = null
    var _query: Element? = null
    var detail: List<AuditEvent.Entity.Detail>? = null
    var agent: List<AuditEvent.Agent>? = null
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
        4 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        5 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securityLabelSer, null)
        6 -> query = decoder.decodeStringElement(descriptor, i)
        7 ->
          _query = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.querySer, null)
        8 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        9 ->
          agent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.agentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entity: " + i)
      }
    }
    return AuditEvent.Entity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      what = what,
      role = role,
      securityLabel = securityLabel ?: listOf(),
      query = Base64Binary.of(query, _query),
      detail = detail ?: listOf(),
      agent = agent ?: listOf(),
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
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.roleSer, it) }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        Hoisted.securityLabelSer,
        value.securityLabel,
      )
    ((value.query?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.query?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.querySer, it)
    }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.detailSer, value.detail)
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.agentSer, value.agent)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val whatSer: KSerializer<Reference> = Reference.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val securityLabelSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.roleSer)

    public val querySer: KSerializer<Element> = Element.serializer()

    public val detailSerInner: KSerializer<AuditEvent.Entity.Detail> =
      AuditEvent.Entity.Detail.serializer()

    public val detailSer: KSerializer<List<AuditEvent.Entity.Detail>> =
      ListSerializer(Hoisted.detailSerInner)

    public val agentSerInner: KSerializer<AuditEvent.Agent> = AuditEvent.Agent.serializer()

    public val agentSer: KSerializer<List<AuditEvent.Agent>> = ListSerializer(Hoisted.agentSerInner)
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valuePeriod", Period.serializer().descriptor, isOptional = true)
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
    var type: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueRange: Range? = null
    var valueRatio: Ratio? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valuePeriod: Period? = null
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
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> valueString = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        10 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        12 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        13 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        14 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        15 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        16 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        17 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        18 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        19 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        20 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    return AuditEvent.Entity.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        AuditEvent.Entity.Detail.Value.from(
          valueQuantity,
          valueCodeableConcept,
          R5String.of(valueString, _valueString),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          valueRange,
          valueRatio,
          Time.of(valueTime, _valueTime),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          valuePeriod,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.`value`) {
      is AuditEvent.Entity.Detail.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueQuantitySer, choice.value)
      }
      is AuditEvent.Entity.Detail.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, choice.value)
      }
      is AuditEvent.Entity.Detail.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueRangeSer, choice.value)
      }
      is AuditEvent.Entity.Detail.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 13, Hoisted.valueRatioSer, choice.value)
      }
      is AuditEvent.Entity.Detail.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 14, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 16, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 17, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 18, Hoisted.valuePeriodSer, choice.value)
      }
      is AuditEvent.Entity.Detail.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 19, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 20, Hoisted.valueStringSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueStringSer: KSerializer<Element> = Element.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()
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
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("action", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_action", Element.serializer().descriptor, isOptional = true)
    b.element("severity", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_severity", Element.serializer().descriptor, isOptional = true)
    b.element("occurredPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("occurredDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurredDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("recorded", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_recorded", Element.serializer().descriptor, isOptional = true)
    b.element(
      "outcome",
      lazyDescriptor { AuditEvent.Outcome.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "authorization",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
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
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var action: KotlinString? = null
    var _action: Element? = null
    var severity: KotlinString? = null
    var _severity: Element? = null
    var occurredPeriod: Period? = null
    var occurredDateTime: KotlinString? = null
    var _occurredDateTime: Element? = null
    var recorded: KotlinString? = null
    var _recorded: Element? = null
    var outcome: AuditEvent.Outcome? = null
    var authorization: List<CodeableConcept>? = null
    var basedOn: List<Reference>? = null
    var patient: Reference? = null
    var encounter: Reference? = null
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
        10 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        11 ->
          code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        12 -> action = decoder.decodeStringElement(descriptor, i)
        13 ->
          _action =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> severity = decoder.decodeStringElement(descriptor, i)
        15 ->
          _severity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          occurredPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurredPeriodSer,
              null,
            )
        17 -> occurredDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _occurredDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> recorded = decoder.decodeStringElement(descriptor, i)
        20 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.outcomeSer, null)
        22 ->
          authorization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        23 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        24 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        25 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        26 ->
          agent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.agentSer, null)
        27 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        28 ->
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
      category = category ?: listOf(),
      code = code!!,
      action = action?.let { Enumeration.of(AuditEvent.AuditEventAction.fromCode(it), _action) },
      severity =
        severity?.let { Enumeration.of(AuditEvent.AuditEventSeverity.fromCode(it), _severity) },
      occurred =
        AuditEvent.Occurred.from(
          occurredPeriod,
          DateTime.of(FhirDateTime.fromString(occurredDateTime), _occurredDateTime),
        ),
      recorded = Instant.of(FhirDateTime.fromString(recorded), _recorded)!!,
      outcome = outcome,
      authorization = authorization ?: listOf(),
      basedOn = basedOn ?: listOf(),
      patient = patient,
      encounter = encounter,
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      Hoisted.categorySerInner,
      value.code,
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
    ((value.severity?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.severity?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.occurred) {
      null -> {}
      is AuditEvent.Occurred.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          16 + descriptorOffset,
          Hoisted.occurredPeriodSer,
          choice.value,
        )
      }
      is AuditEvent.Occurred.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            18 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.recorded.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.recorded.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.outcome)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.outcomeSer, it)
    }
    if (value.authorization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.categorySer,
        value.authorization,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    (value.patient)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.agentSer,
        value.agent,
      )
    encoder.encodeSerializableElement(
      descriptor,
      27 + descriptorOffset,
      Hoisted.sourceSer,
      value.source,
    )
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val occurredPeriodSer: KSerializer<Period> = Period.serializer()

    public val outcomeSer: KSerializer<AuditEvent.Outcome> = AuditEvent.Outcome.serializer()

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

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
