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

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Provenance
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Signature
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.String
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

internal object ProvenanceAgentSerializer : KSerializer<Provenance.Agent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Agent") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("onBehalfOf", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Provenance.Agent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Provenance.Agent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Provenance.Agent {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var role: List<CodeableConcept>? = null
    var who: Reference? = null
    var onBehalfOf: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.roleSer, null)
        5 -> who = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.whoSer, null)
        6 ->
          onBehalfOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.whoSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Agent: " + __i)
      }
    }
    return Provenance.Agent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      role = role ?: listOf(),
      who = who!!,
      onBehalfOf = onBehalfOf,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Provenance.Agent) {
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
    (value.onBehalfOf)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.whoSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val roleSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val whoSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ProvenanceEntitySerializer : KSerializer<Provenance.Entity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entity") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("role", String.serializer().descriptor, isOptional = true)
      element("_role", Element.serializer().descriptor, isOptional = true)
      element("what", Reference.serializer().descriptor, isOptional = true)
      element(
        "agent",
        listSerialDescriptor(lazyDescriptor { Provenance.Agent.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Provenance.Entity =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Provenance.Entity) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Provenance.Entity {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: String? = null
    var _role: Element? = null
    var what: Reference? = null
    var agent: List<Provenance.Agent>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeStringElement(__desc, __i)
        4 -> _role = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.roleSer, null)
        5 -> what = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.whatSer, null)
        6 -> agent = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.agentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entity: " + __i)
      }
    }
    return Provenance.Entity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role = Enumeration.of(Provenance.ProvenanceEntityRole.fromCode(role!!), _role),
      what = what!!,
      agent = agent ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Provenance.Entity) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.role.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.role.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.roleSer, it)
    }
    (value.what)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.whatSer, it) }
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.agentSer, value.agent)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val roleSer: KSerializer<Element> = Element.serializer()

    public val whatSer: KSerializer<Reference> = Reference.serializer()

    public val agentSerInner: KSerializer<Provenance.Agent> = Provenance.Agent.serializer()

    public val agentSer: KSerializer<List<Provenance.Agent>> = ListSerializer(Hoisted.agentSerInner)
  }
}

internal object ProvenanceSerializer : KSerializer<Provenance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Provenance") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("target", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("occurredPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("occurredDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_occurredDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("recorded", String.serializer().descriptor, isOptional = true)
    b.element("_recorded", Element.serializer().descriptor, isOptional = true)
    b.element("policy", listSerialDescriptor(String.serializer().descriptor), isOptional = true)
    b.element("_policy", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("activity", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "agent",
      listSerialDescriptor(lazyDescriptor { Provenance.Agent.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "entity",
      listSerialDescriptor(lazyDescriptor { Provenance.Entity.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "signature",
      listSerialDescriptor(Signature.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Provenance =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Provenance) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Provenance")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Provenance {
    val __desc = desc
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var target: List<Reference>? = null
    var occurredPeriod: Period? = null
    var occurredDateTime: String? = null
    var _occurredDateTime: Element? = null
    var recorded: String? = null
    var _recorded: Element? = null
    var policy: List<String?>? = null
    var _policy: List<Element?>? = null
    var location: Reference? = null
    var reason: List<CodeableConcept>? = null
    var activity: CodeableConcept? = null
    var agent: List<Provenance.Agent>? = null
    var entity: List<Provenance.Entity>? = null
    var signature: List<Signature>? = null
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
        10 ->
          target = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetSer, null)
        11 ->
          occurredPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.occurredPeriodSer, null)
        12 -> occurredDateTime = decoder.decodeStringElement(__desc, __i)
        13 ->
          _occurredDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 -> recorded = decoder.decodeStringElement(__desc, __i)
        15 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 ->
          policy = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.policySer, null)
        17 ->
          _policy = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.policySer2, null)
        18 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetSerInner, null)
        19 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        20 ->
          activity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSerInner, null)
        21 -> agent = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.agentSer, null)
        22 ->
          entity = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.entitySer, null)
        23 ->
          signature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.signatureSer, null)
        else -> throw SerializationException("Unexpected index decoding Provenance: " + __i)
      }
    }
    return Provenance(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      target = target ?: listOf(),
      occurred =
        Provenance.Occurred.from(
          occurredPeriod,
          DateTime.of(FhirDateTime.fromString(occurredDateTime), _occurredDateTime),
        ),
      recorded = Instant.of(FhirDateTime.fromString(recorded), _recorded)!!,
      policy =
        (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { __i ->
          Uri.of(policy?.getOrNull(__i)?.let { it }, _policy?.getOrNull(__i))!!
        }),
      location = location,
      reason = reason ?: listOf(),
      activity = activity,
      agent = agent ?: listOf(),
      entity = entity ?: listOf(),
      signature = signature ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Provenance,
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
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.targetSer, value.target)
    when (val __d = value.occurred) {
      null -> {}
      is Provenance.Occurred.Period -> {
        encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.occurredPeriodSer, __d.value)
      }
      is Provenance.Occurred.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.recorded.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 14 + __off, it)
    }
    (value.recorded.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.policy.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.policySer, it)
    }
    (value.policy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.policySer2, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.targetSerInner, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.reasonSer, value.reason)
    (value.activity)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.reasonSerInner, it)
    }
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.agentSer, value.agent)
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.entitySer, value.entity)
    if (value.signature.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.signatureSer, value.signature)
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

    public val targetSerInner: KSerializer<Reference> = Reference.serializer()

    public val targetSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.targetSerInner)

    public val occurredPeriodSer: KSerializer<Period> = Period.serializer()

    public val policySerInner: KSerializer<String> = String.serializer()

    public val policySer: KSerializer<List<String?>> =
      ListSerializer((Hoisted.policySerInner).nullable)

    public val policySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val reasonSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val agentSerInner: KSerializer<Provenance.Agent> = Provenance.Agent.serializer()

    public val agentSer: KSerializer<List<Provenance.Agent>> = ListSerializer(Hoisted.agentSerInner)

    public val entitySerInner: KSerializer<Provenance.Entity> = Provenance.Entity.serializer()

    public val entitySer: KSerializer<List<Provenance.Entity>> =
      ListSerializer(Hoisted.entitySerInner)

    public val signatureSerInner: KSerializer<Signature> = Signature.serializer()

    public val signatureSer: KSerializer<List<Signature>> =
      ListSerializer(Hoisted.signatureSerInner)
  }
}

internal object ProvenancePolymorphicSerializer : KSerializer<Provenance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Provenance") { ProvenanceSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Provenance) {
    encoder.encodeStructure(descriptor) {
      ProvenanceSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Provenance =
    decoder.decodeStructure(descriptor) {
      ProvenanceSerializer.deserializeJson(this, descriptor, 0)
    }
}
