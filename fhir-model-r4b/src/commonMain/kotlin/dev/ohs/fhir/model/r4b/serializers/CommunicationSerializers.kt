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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Communication
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.EventStatus
import dev.ohs.fhir.model.r4b.terminologies.RequestPriority
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

internal object CommunicationPayloadSerializer : KSerializer<Communication.Payload> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payload") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("contentString", KotlinString.serializer().descriptor)
      optionalElement("_contentString", ElementSerializer.descriptor)
      optionalElement("contentAttachment", AttachmentSerializer.descriptor)
      optionalElement("contentReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Communication.Payload>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Communication.Payload {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentString: KotlinString? = null
    var _contentString: Element? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
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
        3 -> contentString = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _contentString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          contentAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        6 ->
          contentReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payload: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Communication.Payload(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content =
        Communication.Payload.Content.from(
          R4bString.of(contentString, _contentString),
          contentAttachment,
          contentReference,
        )
          ?: throw SerializationException(
            "Missing required property 'content' on Communication.Payload"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Communication.Payload) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.content) {
      is Communication.Payload.Content.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is Communication.Payload.Content.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Communication.Payload.Content.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CommunicationSerializer : FhirResourceSerializer<Communication> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Communication")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("inResponseTo", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("priority", KotlinString.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("medium", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.descriptor)
    b.optionalElement("about", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("sent", KotlinString.serializer().descriptor)
    b.optionalElement("_sent", ElementSerializer.descriptor)
    b.optionalElement("received", KotlinString.serializer().descriptor)
    b.optionalElement("_received", ElementSerializer.descriptor)
    b.optionalElement("recipient", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("sender", ReferenceSerializer.descriptor)
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("payload", CommunicationPayloadSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Communication {
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
    var identifier: List<Identifier>? = null
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var inResponseTo: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var medium: List<CodeableConcept>? = null
    var subject: Reference? = null
    var topic: CodeableConcept? = null
    var about: List<Reference>? = null
    var encounter: Reference? = null
    var sent: KotlinString? = null
    var _sent: Element? = null
    var received: KotlinString? = null
    var _received: Element? = null
    var recipient: List<Reference>? = null
    var sender: Reference? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var payload: List<Communication.Payload>? = null
    var note: List<Annotation>? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          partOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          inResponseTo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          statusReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        22 -> priority = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          medium =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        25 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        26 ->
          topic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          about =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        29 -> sent = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _sent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 -> received = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _received =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          recipient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        34 ->
          sender =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        35 ->
          reasonCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        36 ->
          reasonReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 ->
          payload =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CommunicationPayloadSerializer.listSerializer,
              null,
            )
        38 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Communication: " + i)
      }
    }
    return Communication(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(index),
            _instantiatesCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'instantiatesCanonical' on Communication has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on Communication has neither a value nor an id/extension"
            )
        }),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      inResponseTo = inResponseTo ?: listOf(),
      status =
        Enumeration.of(if (status != null) EventStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Communication"),
      statusReason = statusReason,
      category = category ?: listOf(),
      priority =
        Enumeration.of(
          if (priority != null) RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      medium = medium ?: listOf(),
      subject = subject,
      topic = topic,
      about = about ?: listOf(),
      encounter = encounter,
      sent = DateTime.of(if (sent != null) FhirDateTime.fromString(sent) else null, _sent),
      received =
        DateTime.of(if (received != null) FhirDateTime.fromString(received) else null, _received),
      recipient = recipient ?: listOf(),
      sender = sender,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      payload = payload ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Communication,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.instantiatesCanonical.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        14 + descriptorOffset,
        value.instantiatesUri,
      )
    }
    if (value.basedOn.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    if (value.inResponseTo.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.inResponseTo,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer,
      value.statusReason,
    )
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.priority?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.priority)
    if (value.medium.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.medium,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.topic,
    )
    if (value.about.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.about,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.sent?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.sent)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.received?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.received)
    if (value.recipient.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.recipient,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      ReferenceSerializer,
      value.sender,
    )
    if (value.reasonCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
      )
    if (value.payload.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        CommunicationPayloadSerializer.listSerializer,
        value.payload,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
