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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
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
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object AuditEventOutcomeSerializer : KSerializer<AuditEvent.Outcome> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Outcome") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodingSerializer.descriptor)
      optionalElement("detail", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Outcome>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Outcome =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: Coding? = null
      var detail: List<CodeableConcept>? = null
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
          3 -> code = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Outcome: " + i)
        }
      }
      AuditEvent.Outcome(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on AuditEvent.Outcome"
            ),
        detail = detail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AuditEvent.Outcome) {
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
      encodeSerializableElement(descriptor, 3, CodingSerializer, value.code)
      if (value.detail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.detail,
        )
    }
  }
}

internal object AuditEventAgentSerializer : KSerializer<AuditEvent.Agent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Agent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("who", ReferenceSerializer.descriptor)
      optionalElement("requestor", KotlinBoolean.serializer().descriptor)
      optionalElement("_requestor", ElementSerializer.descriptor)
      optionalElement("location", ReferenceSerializer.descriptor)
      optionalElement("policy", stringNullableListSerializer.descriptor)
      optionalElement("_policy", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("networkReference", ReferenceSerializer.descriptor)
      optionalElement("networkUri", KotlinString.serializer().descriptor)
      optionalElement("_networkUri", ElementSerializer.descriptor)
      optionalElement("networkString", KotlinString.serializer().descriptor)
      optionalElement("_networkString", ElementSerializer.descriptor)
      optionalElement("authorization", CodeableConceptSerializer.listSerializer.descriptor)
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
          6 -> requestor = decodeBooleanElement(descriptor, i)
          7 ->
            _requestor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            location = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            policy =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          10 ->
            _policy =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          11 ->
            networkReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          12 -> networkUri = decodeStringElement(descriptor, i)
          13 ->
            _networkUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> networkString = decodeStringElement(descriptor, i)
          15 ->
            _networkString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            authorization =
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
        who =
          who
            ?: throw SerializationException("Missing required property 'who' on AuditEvent.Agent"),
        requestor = R5Boolean.of(requestor, _requestor),
        location = location,
        policy =
          (kotlin.collections.List(maxOf(policy?.size ?: 0, _policy?.size ?: 0)) { index ->
            Uri.of(policy?.getOrNull(index), _policy?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'policy' on AuditEvent.Agent has neither a value nor an id/extension"
              )
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
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.who)
      encodeBooleanIfNotNull(descriptor, 6, value.requestor?.value)
      encodeElementIfNotNull(descriptor, 7, value.requestor)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.location)
      if (value.policy.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          stringNullableListSerializer,
          value.policy.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 10, value.policy)
      }
      when (val choice = value.network) {
        null -> {}
        is AuditEvent.Agent.Network.Reference -> {
          encodeSerializableElement(descriptor, 11, ReferenceSerializer, choice.value)
        }
        is AuditEvent.Agent.Network.Uri -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value)
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is AuditEvent.Agent.Network.String -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value)
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
      }
      if (value.authorization.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          CodeableConceptSerializer.listSerializer,
          value.authorization,
        )
    }
  }
}

internal object AuditEventSourceSerializer : KSerializer<AuditEvent.Source> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Source") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("site", ReferenceSerializer.descriptor)
      optionalElement("observer", ReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Source>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Source =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var site: Reference? = null
      var observer: Reference? = null
      var type: List<CodeableConcept>? = null
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
          3 -> site = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            observer = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
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
        site = site,
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.site)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.observer)
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
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
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("securityLabel", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("query", KotlinString.serializer().descriptor)
      optionalElement("_query", ElementSerializer.descriptor)
      optionalElement("detail", AuditEventEntityDetailSerializer.listSerializer.descriptor)
      optionalElement(
        "agent",
        listSerialDescriptor(lazyDescriptor { AuditEventAgentSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Entity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Entity =
    decoder.decodeStructure(descriptor) {
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
          4 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            securityLabel =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 -> query = decodeStringElement(descriptor, i)
          7 -> _query = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AuditEventEntityDetailSerializer.listSerializer,
                null,
              )
          9 ->
            agent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AuditEventAgentSerializer.listSerializer,
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
        role = role,
        securityLabel = securityLabel ?: listOf(),
        query = Base64Binary.of(query, _query),
        detail = detail ?: listOf(),
        agent = agent ?: listOf(),
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
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.role)
      if (value.securityLabel.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.securityLabel,
        )
      encodeStringIfNotNull(descriptor, 6, value.query?.value)
      encodeElementIfNotNull(descriptor, 7, value.query)
      if (value.detail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          AuditEventEntityDetailSerializer.listSerializer,
          value.detail,
        )
      if (value.agent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          AuditEventAgentSerializer.listSerializer,
          value.agent,
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
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueRatio", RatioSerializer.descriptor)
      optionalElement("valueTime", LocalTimeSerializer.descriptor)
      optionalElement("_valueTime", ElementSerializer.descriptor)
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", ElementSerializer.descriptor)
      optionalElement("valuePeriod", PeriodSerializer.descriptor)
      optionalElement("valueBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_valueBase64Binary", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AuditEvent.Entity.Detail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AuditEvent.Entity.Detail =
    decoder.decodeStructure(descriptor) {
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
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> valueString = decodeStringElement(descriptor, i)
          7 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueBoolean = decodeBooleanElement(descriptor, i)
          9 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueInteger = decodeIntElement(descriptor, i)
          11 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          13 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          14 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          15 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 -> valueDateTime = decodeStringElement(descriptor, i)
          17 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          19 -> valueBase64Binary = decodeStringElement(descriptor, i)
          20 ->
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
          type
            ?: throw SerializationException(
              "Missing required property 'type' on AuditEvent.Entity.Detail"
            ),
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
            DateTime.of(
              if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
              _valueDateTime,
            ),
            valuePeriod,
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        is AuditEvent.Entity.Detail.Value.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.String -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.Range -> {
          encodeSerializableElement(descriptor, 12, RangeSerializer, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.Ratio -> {
          encodeSerializableElement(descriptor, 13, RatioSerializer, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 14, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 16, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 17, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.Period -> {
          encodeSerializableElement(descriptor, 18, PeriodSerializer, choice.value)
        }
        is AuditEvent.Entity.Detail.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 19, choice.value.value)
          encodeElementIfNotNull(descriptor, 20, choice.value)
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
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("action", KotlinString.serializer().descriptor)
    b.optionalElement("_action", ElementSerializer.descriptor)
    b.optionalElement("severity", KotlinString.serializer().descriptor)
    b.optionalElement("_severity", ElementSerializer.descriptor)
    b.optionalElement("occurredPeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurredDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_occurredDateTime", ElementSerializer.descriptor)
    b.optionalElement("recorded", KotlinString.serializer().descriptor)
    b.optionalElement("_recorded", ElementSerializer.descriptor)
    b.optionalElement("outcome", AuditEventOutcomeSerializer.descriptor)
    b.optionalElement("authorization", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
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
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 -> action = decoder.decodeStringElement(descriptor, i)
        13 ->
          _action =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> severity = decoder.decodeStringElement(descriptor, i)
        15 ->
          _severity =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          occurredPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        17 -> occurredDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _occurredDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> recorded = decoder.decodeStringElement(descriptor, i)
        20 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          outcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventOutcomeSerializer,
              null,
            )
        22 ->
          authorization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        23 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        25 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          agent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventAgentSerializer.listSerializer,
              null,
            )
        27 ->
          source =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AuditEventSourceSerializer,
              null,
            )
        28 ->
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
      category = category ?: listOf(),
      code = code ?: throw SerializationException("Missing required property 'code' on AuditEvent"),
      action =
        Enumeration.of(
          if (action != null) AuditEvent.AuditEventAction.fromCode(action) else null,
          _action,
        ),
      severity =
        Enumeration.of(
          if (severity != null) AuditEvent.AuditEventSeverity.fromCode(severity) else null,
          _severity,
        ),
      occurred =
        AuditEvent.Occurred.from(
          occurredPeriod,
          DateTime.of(
            if (occurredDateTime != null) FhirDateTime.fromString(occurredDateTime) else null,
            _occurredDateTime,
          ),
        ),
      recorded =
        Instant.of(if (recorded != null) FhirDateTime.fromString(recorded) else null, _recorded)
          ?: throw SerializationException("Missing required property 'recorded' on AuditEvent"),
      outcome = outcome,
      authorization = authorization ?: listOf(),
      basedOn = basedOn ?: listOf(),
      patient = patient,
      encounter = encounter,
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.action?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.action)
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.severity?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.severity)
    when (val choice = value.occurred) {
      null -> {}
      is AuditEvent.Occurred.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          16 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is AuditEvent.Occurred.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          17 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.recorded.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.recorded)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      AuditEventOutcomeSerializer,
      value.outcome,
    )
    if (value.authorization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.authorization,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.agent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        AuditEventAgentSerializer.listSerializer,
        value.agent,
      )
    encoder.encodeSerializableElement(
      descriptor,
      27 + descriptorOffset,
      AuditEventSourceSerializer,
      value.source,
    )
    if (value.entity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        AuditEventEntitySerializer.listSerializer,
        value.entity,
      )
  }
}
