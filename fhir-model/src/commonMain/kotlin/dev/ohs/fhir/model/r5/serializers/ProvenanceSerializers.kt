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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Provenance
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Signature
import dev.ohs.fhir.model.r5.Uri
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
        6 -> onBehalfOf = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.whoSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeStringElement(__desc, 3)
        4 -> _role = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.roleSer, null)
        5 -> what = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.whatSer, null)
        6 -> agent = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.agentSer, null)
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
      "authorization",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("activity", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Provenance) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Provenance")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Provenance {
    val __desc = descriptor
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
    var authorization: List<CodeableReference>? = null
    var activity: CodeableConcept? = null
    var basedOn: List<Reference>? = null
    var patient: Reference? = null
    var encounter: Reference? = null
    var agent: List<Provenance.Agent>? = null
    var entity: List<Provenance.Entity>? = null
    var signature: List<Signature>? = null
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
          target = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.targetSer, null)
        12 ->
          occurredPeriod =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.occurredPeriodSer, null)
        13 -> occurredDateTime = decoder.decodeStringElement(__desc, 13)
        14 ->
          _occurredDateTime =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> recorded = decoder.decodeStringElement(__desc, 15)
        16 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          policy = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.policySer, null)
        18 ->
          _policy = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.policySer2, null)
        19 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.targetSerInner, null)
        20 ->
          authorization =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.authorizationSer, null)
        21 ->
          activity =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.activitySer, null)
        22 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.targetSer, null)
        23 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.targetSerInner, null)
        24 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.targetSerInner, null)
        25 -> agent = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.agentSer, null)
        26 ->
          entity = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.entitySer, null)
        27 ->
          signature =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.signatureSer, null)
        CompositeDecoder.DECODE_DONE -> break
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
      recorded = Instant.of(FhirDateTime.fromString(recorded), _recorded),
      policy =
        (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { __i ->
          Uri.of(policy?.getOrNull(__i)?.let { it }, _policy?.getOrNull(__i))!!
        }),
      location = location,
      authorization = authorization ?: listOf(),
      activity = activity,
      basedOn = basedOn ?: listOf(),
      patient = patient,
      encounter = encounter,
      agent = agent ?: listOf(),
      entity = entity ?: listOf(),
      signature = signature ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: Provenance) {
    val __desc = descriptor
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
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.targetSer, value.target)
    when (val __d = value.occurred) {
      null -> {}
      is Provenance.Occurred.Period -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.occurredPeriodSer, __d.value)
      }
      is Provenance.Occurred.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.recorded?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    (value.policy.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.policySer, it)
    }
    (value.policy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.policySer2, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.targetSerInner, it)
    }
    if (value.authorization.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.authorizationSer, value.authorization)
    (value.activity)?.let { encoder.encodeSerializableElement(__desc, 21, Hoisted.activitySer, it) }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.targetSer, value.basedOn)
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.targetSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.targetSerInner, it)
    }
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.agentSer, value.agent)
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.entitySer, value.entity)
    if (value.signature.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.signatureSer, value.signature)
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

    public val authorizationSerInner: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val authorizationSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.authorizationSerInner)

    public val activitySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

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
    encoder.encodeStructure(descriptor) { ProvenanceSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): Provenance =
    decoder.decodeStructure(descriptor) { ProvenanceSerializer.deserializeJson(this) }
}
