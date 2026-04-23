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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Outcome) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AuditEvent.Outcome {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: Coding? = null
    var detail: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> detail = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Outcome: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: AuditEvent.Outcome) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.detailSer, value.detail)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Agent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AuditEvent.Agent {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.roleSer, null)
        5 -> who = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.whoSer, null)
        6 -> requestor = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _requestor =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.requestorSer, null)
        8 -> location = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.whoSer, null)
        9 -> policy = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.policySer, null)
        10 ->
          _policy = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.policySer2, null)
        11 ->
          networkReference =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.whoSer, null)
        12 -> networkUri = decoder.decodeStringElement(__desc, 12)
        13 ->
          _networkUri =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.requestorSer, null)
        14 -> networkString = decoder.decodeStringElement(__desc, 14)
        15 ->
          _networkString =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.requestorSer, null)
        16 ->
          authorization =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Agent: " + __i)
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
        (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { __i ->
          Uri.of(policy?.getOrNull(__i)?.let { it }, _policy?.getOrNull(__i))!!
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: AuditEvent.Agent) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.role.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.roleSer, value.role)
    (value.who)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.whoSer, it) }
    ((value.requestor?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.requestor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.requestorSer, it)
    }
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.whoSer, it) }
    (value.policy.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.policySer, it)
    }
    (value.policy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.policySer2, it)
    }
    when (val __d = value.network) {
      null -> {}
      is AuditEvent.Agent.Network.Reference -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.whoSer, __d.value)
      }
      is AuditEvent.Agent.Network.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.requestorSer, it)
        }
      }
      is AuditEvent.Agent.Network.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.requestorSer, it)
        }
      }
    }
    if (value.authorization.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.roleSer, value.authorization)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Source) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AuditEvent.Source {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: Reference? = null
    var observer: Reference? = null
    var type: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> site = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.siteSer, null)
        4 -> observer = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.siteSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Source: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: AuditEvent.Source) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.site)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.siteSer, it) }
    (value.observer)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.siteSer, it) }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, value.type)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AuditEvent.Entity {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> what = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.whatSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.roleSer, null)
        5 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.securityLabelSer, null)
        6 -> query = decoder.decodeStringElement(__desc, 6)
        7 -> _query = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.querySer, null)
        8 -> detail = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.detailSer, null)
        9 -> agent = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.agentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entity: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: AuditEvent.Entity) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.what)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.whatSer, it) }
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.roleSer, it) }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.securityLabelSer, value.securityLabel)
    ((value.query?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.query?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.querySer, it)
    }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.detailSer, value.detail)
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.agentSer, value.agent)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity.Detail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AuditEvent.Entity.Detail {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueQuantitySer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> valueString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueStringSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueStringSer, null)
        10 -> valueInteger = decoder.decodeIntElement(__desc, 10)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueStringSer, null)
        12 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueRangeSer, null)
        13 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.valueRatioSer, null)
        14 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 14, LocalTimeSerializer, null)
        15 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.valueStringSer, null)
        16 -> valueDateTime = decoder.decodeStringElement(__desc, 16)
        17 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.valueStringSer, null)
        18 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.valuePeriodSer, null)
        19 -> valueBase64Binary = decoder.decodeStringElement(__desc, 19)
        20 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.valueStringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: AuditEvent.Entity.Detail) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is AuditEvent.Entity.Detail.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.valueQuantitySer, __d.value)
      }
      is AuditEvent.Entity.Detail.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, __d.value)
      }
      is AuditEvent.Entity.Detail.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valueRangeSer, __d.value)
      }
      is AuditEvent.Entity.Detail.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 13, Hoisted.valueRatioSer, __d.value)
      }
      is AuditEvent.Entity.Detail.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 14, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.valueStringSer, it)
        }
      }
      is AuditEvent.Entity.Detail.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.valuePeriodSer, __d.value)
      }
      is AuditEvent.Entity.Detail.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.valueStringSer, it)
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

internal object AuditEventOccurredSerializer : KSerializer<AuditEvent.Occurred> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AuditEvent.Occurred") {
      element("occurredPeriod", Period.serializer().descriptor, isOptional = true)
      element("occurredDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurredDateTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Occurred) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is AuditEvent.Occurred.Period -> {
          encodeSerializableElement(__desc, 0, Hoisted.occurredPeriodSer, __d.value)
        }
        is AuditEvent.Occurred.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 1, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 2, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): AuditEvent.Occurred =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): AuditEvent.Occurred {
    val __desc = descriptor
    var occurredPeriod: Period? = null
    var occurredDateTime: KotlinString? = null
    var _occurredDateTime: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          occurredPeriod =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.occurredPeriodSer, null)
        1 -> occurredDateTime = decoder.decodeStringElement(__desc, 1)
        2 ->
          _occurredDateTime =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding AuditEvent.Occurred: " + __i)
      }
    }
    return AuditEvent.Occurred.from(
      occurredPeriod,
      DateTime.of(FhirDateTime.fromString(occurredDateTime), _occurredDateTime),
    )!!
  }

  private object Hoisted {
    public val occurredPeriodSer: KSerializer<Period> = Period.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object AuditEventAgentNetworkSerializer : KSerializer<AuditEvent.Agent.Network> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AuditEvent.Agent.Network") {
      element("networkReference", Reference.serializer().descriptor, isOptional = true)
      element("networkUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_networkUri", Element.serializer().descriptor, isOptional = true)
      element("networkString", KotlinString.serializer().descriptor, isOptional = true)
      element("_networkString", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Agent.Network) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is AuditEvent.Agent.Network.Reference -> {
          encodeSerializableElement(__desc, 0, Hoisted.networkReferenceSer, __d.value)
        }
        is AuditEvent.Agent.Network.Uri -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 1, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 2, Hoisted.elementSer, it)
          }
        }
        is AuditEvent.Agent.Network.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 3, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 4, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): AuditEvent.Agent.Network =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): AuditEvent.Agent.Network {
    val __desc = descriptor
    var networkReference: Reference? = null
    var networkUri: KotlinString? = null
    var _networkUri: Element? = null
    var networkString: KotlinString? = null
    var _networkString: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          networkReference =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.networkReferenceSer, null)
        1 -> networkUri = decoder.decodeStringElement(__desc, 1)
        2 ->
          _networkUri =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.elementSer, null)
        3 -> networkString = decoder.decodeStringElement(__desc, 3)
        4 ->
          _networkString =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding AuditEvent.Agent.Network: " + __i)
      }
    }
    return AuditEvent.Agent.Network.from(
      networkReference,
      Uri.of(networkUri, _networkUri),
      R5String.of(networkString, _networkString),
    )!!
  }

  private object Hoisted {
    public val networkReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object AuditEventEntityDetailValueSerializer :
  KSerializer<AuditEvent.Entity.Detail.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AuditEvent.Entity.Detail.Value") {
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

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Entity.Detail.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is AuditEvent.Entity.Detail.Value.Quantity -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueQuantitySer, __d.value)
        }
        is AuditEvent.Entity.Detail.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 1, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is AuditEvent.Entity.Detail.Value.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is AuditEvent.Entity.Detail.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is AuditEvent.Entity.Detail.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is AuditEvent.Entity.Detail.Value.Range -> {
          encodeSerializableElement(__desc, 8, Hoisted.valueRangeSer, __d.value)
        }
        is AuditEvent.Entity.Detail.Value.Ratio -> {
          encodeSerializableElement(__desc, 9, Hoisted.valueRatioSer, __d.value)
        }
        is AuditEvent.Entity.Detail.Value.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 10, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is AuditEvent.Entity.Detail.Value.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 12, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is AuditEvent.Entity.Detail.Value.Period -> {
          encodeSerializableElement(__desc, 14, Hoisted.valuePeriodSer, __d.value)
        }
        is AuditEvent.Entity.Detail.Value.Base64Binary -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 15, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 16, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): AuditEvent.Entity.Detail.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): AuditEvent.Entity.Detail.Value {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.valueQuantitySer, null)
        1 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        2 -> valueString = decoder.decodeStringElement(__desc, 2)
        3 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> valueBoolean = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> valueInteger = decoder.decodeIntElement(__desc, 6)
        7 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueRangeSer, null)
        9 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueRatioSer, null)
        10 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 10, LocalTimeSerializer, null)
        11 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 -> valueDateTime = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.valuePeriodSer, null)
        15 -> valueBase64Binary = decoder.decodeStringElement(__desc, 15)
        16 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding AuditEvent.Entity.Detail.Value: " + __i
          )
      }
    }
    return AuditEvent.Entity.Detail.Value.from(
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
    )!!
  }

  private object Hoisted {
    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object AuditEventSerializer : KSerializer<AuditEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AuditEvent") {
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
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("action", KotlinString.serializer().descriptor, isOptional = true)
      element("_action", Element.serializer().descriptor, isOptional = true)
      element("severity", KotlinString.serializer().descriptor, isOptional = true)
      element("_severity", Element.serializer().descriptor, isOptional = true)
      element("occurredPeriod", Period.serializer().descriptor, isOptional = true)
      element("occurredDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurredDateTime", Element.serializer().descriptor, isOptional = true)
      element("recorded", KotlinString.serializer().descriptor, isOptional = true)
      element("_recorded", Element.serializer().descriptor, isOptional = true)
      element(
        "outcome",
        lazyDescriptor { AuditEvent.Outcome.serializer().descriptor },
        isOptional = true,
      )
      element(
        "authorization",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element(
        "agent",
        listSerialDescriptor(lazyDescriptor { AuditEvent.Agent.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "source",
        lazyDescriptor { AuditEvent.Source.serializer().descriptor },
        isOptional = true,
      )
      element(
        "entity",
        listSerialDescriptor(lazyDescriptor { AuditEvent.Entity.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): AuditEvent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AuditEvent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): AuditEvent {
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
        11 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.categorySer, null)
        12 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.categorySerInner, null)
        13 -> action = decoder.decodeStringElement(__desc, 13)
        14 ->
          _action =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> severity = decoder.decodeStringElement(__desc, 15)
        16 ->
          _severity =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          occurredPeriod =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.occurredPeriodSer, null)
        18 -> occurredDateTime = decoder.decodeStringElement(__desc, 18)
        19 ->
          _occurredDateTime =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> recorded = decoder.decodeStringElement(__desc, 20)
        21 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          outcome = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.outcomeSer, null)
        23 ->
          authorization =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.categorySer, null)
        24 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.basedOnSer, null)
        25 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.basedOnSerInner, null)
        26 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.basedOnSerInner, null)
        27 -> agent = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.agentSer, null)
        28 ->
          source = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.sourceSer, null)
        29 ->
          entity = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.entitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AuditEvent: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: AuditEvent) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "AuditEvent")
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.categorySer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.categorySerInner, it)
    }
    ((value.action?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.action?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    ((value.severity?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.severity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.occurred) {
      null -> {}
      is AuditEvent.Occurred.Period -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.occurredPeriodSer, __d.value)
      }
      is AuditEvent.Occurred.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.recorded.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.recorded.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    (value.outcome)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.outcomeSer, it) }
    if (value.authorization.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.categorySer, value.authorization)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.basedOnSer, value.basedOn)
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.basedOnSerInner, it)
    }
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.agentSer, value.agent)
    (value.source)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.sourceSer, it) }
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.entitySer, value.entity)
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
