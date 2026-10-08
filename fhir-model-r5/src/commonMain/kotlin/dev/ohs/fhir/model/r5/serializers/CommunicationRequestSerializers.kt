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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.CommunicationRequest
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.RequestIntent
import dev.ohs.fhir.model.r5.terminologies.RequestPriority
import dev.ohs.fhir.model.r5.terminologies.RequestStatus
import kotlin.Boolean as KotlinBoolean
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

internal object CommunicationRequestPayloadSerializer : KSerializer<CommunicationRequest.Payload> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payload") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("contentAttachment", AttachmentSerializer.descriptor)
      optionalElement("contentReference", ReferenceSerializer.descriptor)
      optionalElement("contentCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CommunicationRequest.Payload>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CommunicationRequest.Payload {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
    var contentCodeableConcept: CodeableConcept? = null
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
          contentAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        4 ->
          contentReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 ->
          contentCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payload: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CommunicationRequest.Payload(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content =
        CommunicationRequest.Payload.Content.from(
          contentAttachment,
          contentReference,
          contentCodeableConcept,
        )
          ?: throw SerializationException(
            "Missing required property 'content' on CommunicationRequest.Payload"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest.Payload) {
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
      is CommunicationRequest.Payload.Content.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          3,
          AttachmentSerializer,
          choice.value,
        )
      }
      is CommunicationRequest.Payload.Content.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
      is CommunicationRequest.Payload.Content.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CommunicationRequestSerializer : FhirResourceSerializer<CommunicationRequest> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CommunicationRequest")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("intent", String.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("priority", String.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_doNotPerform", ElementSerializer.descriptor)
    b.optionalElement("medium", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("about", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("payload", CommunicationRequestPayloadSerializer.listSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", String.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("authoredOn", String.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("requester", ReferenceSerializer.descriptor)
    b.optionalElement("recipient", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("informationProvider", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): CommunicationRequest {
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
    var identifier: List<Identifier>? = null
    var basedOn: List<Reference>? = null
    var replaces: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var status: String? = null
    var _status: Element? = null
    var statusReason: CodeableConcept? = null
    var intent: String? = null
    var _intent: Element? = null
    var category: List<CodeableConcept>? = null
    var priority: String? = null
    var _priority: Element? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var medium: List<CodeableConcept>? = null
    var subject: Reference? = null
    var about: List<Reference>? = null
    var encounter: Reference? = null
    var payload: List<CommunicationRequest.Payload>? = null
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var authoredOn: String? = null
    var _authoredOn: Element? = null
    var requester: Reference? = null
    var recipient: List<Reference>? = null
    var informationProvider: List<Reference>? = null
    var reason: List<CodeableReference>? = null
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
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          replaces =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 ->
          groupIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        14 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          statusReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 -> intent = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _intent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 -> priority = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> doNotPerform = compositeDecoder.decodeBooleanElement(descriptor, i)
        23 ->
          _doNotPerform =
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
          about =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        28 ->
          payload =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CommunicationRequestPayloadSerializer.listSerializer,
              null,
            )
        29 -> occurrenceDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _occurrenceDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          occurrencePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        32 -> authoredOn = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _authoredOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          requester =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        35 ->
          recipient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        36 ->
          informationProvider =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
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
        else -> throw SerializationException("Unexpected index decoding CommunicationRequest: " + i)
      }
    }
    return CommunicationRequest(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      groupIdentifier = groupIdentifier,
      status =
        Enumeration.of(if (status != null) RequestStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on CommunicationRequest"
          ),
      statusReason = statusReason,
      intent =
        Enumeration.of(if (intent != null) RequestIntent.fromCode(intent) else null, _intent)
          ?: throw SerializationException(
            "Missing required property 'intent' on CommunicationRequest"
          ),
      category = category ?: listOf(),
      priority =
        Enumeration.of(
          if (priority != null) RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      medium = medium ?: listOf(),
      subject = subject,
      about = about ?: listOf(),
      encounter = encounter,
      payload = payload ?: listOf(),
      occurrence =
        CommunicationRequest.Occurrence.from(
          DateTime.of(
            if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
            _occurrenceDateTime,
          ),
          occurrencePeriod,
        ),
      authoredOn =
        DateTime.of(
          if (authoredOn != null) FhirDateTime.fromString(authoredOn) else null,
          _authoredOn,
        ),
      requester = requester,
      recipient = recipient ?: listOf(),
      informationProvider = informationProvider ?: listOf(),
      reason = reason ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CommunicationRequest,
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
    if (value.basedOn.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.replaces,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.statusReason,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.intent.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.intent)
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.priority?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.priority)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.doNotPerform?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.doNotPerform)
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
    if (value.about.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.about,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.payload.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CommunicationRequestPayloadSerializer.listSerializer,
        value.payload,
      )
    when (val choice = value.occurrence) {
      null -> {}
      is CommunicationRequest.Occurrence.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          29 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, choice.value)
      }
      is CommunicationRequest.Occurrence.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      32 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.authoredOn)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    if (value.recipient.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.recipient,
      )
    if (value.informationProvider.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.informationProvider,
      )
    if (value.reason.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
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
