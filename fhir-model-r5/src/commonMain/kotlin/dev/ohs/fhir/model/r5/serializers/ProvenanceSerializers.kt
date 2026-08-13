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
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Provenance.Agent) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Provenance.Agent {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var role: List<CodeableConcept>? = null
    var who: Reference? = null
    var onBehalfOf: Reference? = null
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
        6 ->
          onBehalfOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whoSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Agent: " + i)
      }
    }
    return Provenance.Agent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      role = role ?: listOf(),
      who =
        who ?: throw SerializationException("Missing required property 'who' on Provenance.Agent"),
      onBehalfOf = onBehalfOf,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Provenance.Agent) {
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
    (value.onBehalfOf)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.whoSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Provenance.Entity) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Provenance.Entity {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: String? = null
    var _role: Element? = null
    var what: Reference? = null
    var agent: List<Provenance.Agent>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeStringElement(descriptor, i)
        4 -> _role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        5 -> what = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whatSer, null)
        6 ->
          agent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.agentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entity: " + i)
      }
    }
    return Provenance.Entity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role =
        Enumeration.of(
          Provenance.ProvenanceEntityRole.fromCode(
            role
              ?: throw SerializationException(
                "Missing required property 'role' on Provenance.Entity"
              )
          ),
          _role,
        ),
      what =
        what
          ?: throw SerializationException("Missing required property 'what' on Provenance.Entity"),
      agent = agent ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Provenance.Entity) {
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
    ((value.role.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.role.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.roleSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.whatSer, value.what)
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.agentSer, value.agent)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Provenance) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Provenance")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Provenance {
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
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        11 ->
          occurredPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurredPeriodSer,
              null,
            )
        12 -> occurredDateTime = decoder.decodeStringElement(descriptor, i)
        13 ->
          _occurredDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> recorded = decoder.decodeStringElement(descriptor, i)
        15 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          policy = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policySer, null)
        17 ->
          _policy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policySer2, null)
        18 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSerInner, null)
        19 ->
          authorization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authorizationSer, null)
        20 ->
          activity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.activitySer, null)
        21 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        22 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSerInner, null)
        23 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSerInner, null)
        24 ->
          agent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.agentSer, null)
        25 ->
          entity = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entitySer, null)
        26 ->
          signature =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.signatureSer, null)
        else -> throw SerializationException("Unexpected index decoding Provenance: " + i)
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
          DateTime.of(occurredDateTime?.let { FhirDateTime.fromString(it) }, _occurredDateTime),
        ),
      recorded = Instant.of(recorded?.let { FhirDateTime.fromString(it) }, _recorded),
      policy =
        (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { index ->
          Uri.of(policy?.getOrNull(index)?.let { it }, _policy?.getOrNull(index))!!
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Provenance,
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
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.targetSer,
        value.target,
      )
    when (val choice = value.occurred) {
      null -> {}
      is Provenance.Occurred.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          11 + descriptorOffset,
          Hoisted.occurredPeriodSer,
          choice.value,
        )
      }
      is Provenance.Occurred.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            13 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.recorded?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.policy.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.policySer, it)
    }
    (value.policy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.policySer2, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.targetSerInner,
        it,
      )
    }
    if (value.authorization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.authorizationSer,
        value.authorization,
      )
    (value.activity)?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, Hoisted.activitySer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.targetSer,
        value.basedOn,
      )
    (value.patient)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.targetSerInner,
        it,
      )
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.targetSerInner,
        it,
      )
    }
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.agentSer,
        value.agent,
      )
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.entitySer,
        value.entity,
      )
    if (value.signature.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.signatureSer,
        value.signature,
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
    encoder.encodeStructure(descriptor) {
      ProvenanceSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Provenance =
    decoder.decodeStructure(descriptor) {
      ProvenanceSerializer.deserializeInternal(this, descriptor, 0)
    }
}
