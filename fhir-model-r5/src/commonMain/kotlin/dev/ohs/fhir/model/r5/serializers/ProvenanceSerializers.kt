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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Provenance
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("who", ReferenceSerializer.descriptor)
      optionalElement("onBehalfOf", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Provenance.Agent>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Provenance.Agent =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var role: List<CodeableConcept>? = null
      var who: Reference? = null
      var onBehalfOf: Reference? = null
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
          6 ->
            onBehalfOf = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Agent: " + i)
        }
      }
      Provenance.Agent(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        role = role ?: listOf(),
        who =
          who
            ?: throw SerializationException("Missing required property 'who' on Provenance.Agent"),
        onBehalfOf = onBehalfOf,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Provenance.Agent) {
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
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.who)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.onBehalfOf)
    }
  }
}

internal object ProvenanceEntitySerializer : KSerializer<Provenance.Entity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entity") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("role", String.serializer().descriptor)
      optionalElement("_role", ElementSerializer.descriptor)
      optionalElement("what", ReferenceSerializer.descriptor)
      optionalElement(
        "agent",
        listSerialDescriptor(lazyDescriptor { ProvenanceAgentSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Provenance.Entity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Provenance.Entity =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var role: String? = null
      var _role: Element? = null
      var what: Reference? = null
      var agent: List<Provenance.Agent>? = null
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
          3 -> role = decodeStringElement(descriptor, i)
          4 -> _role = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> what = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 ->
            agent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ProvenanceAgentSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Entity: " + i)
        }
      }
      Provenance.Entity(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        role =
          Enumeration.of(
            if (role != null) Provenance.ProvenanceEntityRole.fromCode(role) else null,
            _role,
          )
            ?: throw SerializationException(
              "Missing required property 'role' on Provenance.Entity"
            ),
        what =
          what
            ?: throw SerializationException(
              "Missing required property 'what' on Provenance.Entity"
            ),
        agent = agent ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Provenance.Entity) {
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
      encodeStringIfNotNull(descriptor, 3, value.role.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.role)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.what)
      if (value.agent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ProvenanceAgentSerializer.listSerializer,
          value.agent,
        )
    }
  }
}

internal object ProvenanceSerializer : FhirResourceSerializer<Provenance> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Provenance")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("target", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("occurredPeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurredDateTime", String.serializer().descriptor)
    b.optionalElement("_occurredDateTime", ElementSerializer.descriptor)
    b.optionalElement("recorded", String.serializer().descriptor)
    b.optionalElement("_recorded", ElementSerializer.descriptor)
    b.optionalElement("policy", stringNullableListSerializer.descriptor)
    b.optionalElement("_policy", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("authorization", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("activity", CodeableConceptSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("agent", ProvenanceAgentSerializer.listSerializer.descriptor)
    b.optionalElement("entity", ProvenanceEntitySerializer.listSerializer.descriptor)
    b.optionalElement("signature", SignatureSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
          target =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        11 ->
          occurredPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        12 -> occurredDateTime = decoder.decodeStringElement(descriptor, i)
        13 ->
          _occurredDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> recorded = decoder.decodeStringElement(descriptor, i)
        15 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          policy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _policy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          authorization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          activity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          agent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ProvenanceAgentSerializer.listSerializer,
              null,
            )
        25 ->
          entity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ProvenanceEntitySerializer.listSerializer,
              null,
            )
        26 ->
          signature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer.listSerializer,
              null,
            )
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
          DateTime.of(
            if (occurredDateTime != null) FhirDateTime.fromString(occurredDateTime) else null,
            _occurredDateTime,
          ),
        ),
      recorded =
        Instant.of(if (recorded != null) FhirDateTime.fromString(recorded) else null, _recorded),
      policy =
        (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { index ->
          Uri.of(policy?.getOrNull(index), _policy?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'policy' on Provenance has neither a value nor an id/extension"
            )
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Provenance,
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
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.target,
      )
    when (val choice = value.occurred) {
      null -> {}
      is Provenance.Occurred.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          11 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is Provenance.Occurred.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          12 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.recorded?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.recorded)
    if (value.policy.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.policy.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 17 + descriptorOffset, value.policy)
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    if (value.authorization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.authorization,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer,
      value.activity,
    )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ProvenanceAgentSerializer.listSerializer,
        value.agent,
      )
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ProvenanceEntitySerializer.listSerializer,
        value.entity,
      )
    if (value.signature.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        SignatureSerializer.listSerializer,
        value.signature,
      )
  }
}
