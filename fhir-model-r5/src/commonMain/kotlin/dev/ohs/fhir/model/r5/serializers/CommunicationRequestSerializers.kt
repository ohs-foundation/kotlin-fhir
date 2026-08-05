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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object CommunicationRequestPayloadSerializer : KSerializer<CommunicationRequest.Payload> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payload") {
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
      element("contentAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("contentReference", Reference.serializer().descriptor, isOptional = true)
      element("contentCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CommunicationRequest.Payload =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest.Payload) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CommunicationRequest.Payload {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
    var contentCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentAttachmentSer,
              null,
            )
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentReferenceSer,
              null,
            )
        5 ->
          contentCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payload: " + i)
      }
    }
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CommunicationRequest.Payload) {
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
    when (val choice = value.content) {
      is CommunicationRequest.Payload.Content.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.contentAttachmentSer, choice.value)
      }
      is CommunicationRequest.Payload.Content.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.contentReferenceSer, choice.value)
      }
      is CommunicationRequest.Payload.Content.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          5,
          Hoisted.contentCodeableConceptSer,
          choice.value,
        )
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contentAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val contentReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contentCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()
  }
}

internal object CommunicationRequestSerializer : KSerializer<CommunicationRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CommunicationRequest") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "replaces",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("intent", String.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("priority", String.serializer().descriptor, isOptional = true)
    b.element("_priority", Element.serializer().descriptor, isOptional = true)
    b.element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
    b.element(
      "medium",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("about", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "payload",
      listSerialDescriptor(lazyDescriptor { CommunicationRequest.Payload.serializer().descriptor }),
      isOptional = true,
    )
    b.element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("authoredOn", String.serializer().descriptor, isOptional = true)
    b.element("_authoredOn", Element.serializer().descriptor, isOptional = true)
    b.element("requester", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "recipient",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "informationProvider",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): CommunicationRequest =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CommunicationRequest")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
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
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        12 ->
          replaces =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        13 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        14 -> status = decoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        17 -> intent = decoder.decodeStringElement(descriptor, i)
        18 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        20 -> priority = decoder.decodeStringElement(descriptor, i)
        21 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        23 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          medium =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        25 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        26 ->
          about = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        27 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        28 ->
          payload =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.payloadSer, null)
        29 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        30 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        32 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        33 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        35 ->
          recipient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        36 ->
          informationProvider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        37 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        38 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
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
        Enumeration.of(
          CommunicationRequest.RequestStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on CommunicationRequest"
              )
          ),
          _status,
        ),
      statusReason = statusReason,
      intent =
        Enumeration.of(
          CommunicationRequest.RequestIntent.fromCode(
            intent
              ?: throw SerializationException(
                "Missing required property 'intent' on CommunicationRequest"
              )
          ),
          _intent,
        ),
      category = category ?: listOf(),
      priority =
        priority?.let {
          Enumeration.of(CommunicationRequest.RequestPriority.fromCode(it), _priority)
        },
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      medium = medium ?: listOf(),
      subject = subject,
      about = about ?: listOf(),
      encounter = encounter,
      payload = payload ?: listOf(),
      occurrence =
        CommunicationRequest.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
        ),
      authoredOn = DateTime.of(FhirDateTime.fromString(authoredOn), _authoredOn),
      requester = requester,
      recipient = recipient ?: listOf(),
      informationProvider = informationProvider ?: listOf(),
      reason = reason ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CommunicationRequest,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.basedOnSer,
        value.replaces,
      )
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    ((value.intent.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    ((value.priority?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.doNotPerform?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.medium.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.categorySer,
        value.medium,
      )
    (value.subject)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.about.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.basedOnSer,
        value.about,
      )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.payload.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.payloadSer,
        value.payload,
      )
    when (val choice = value.occurrence) {
      null -> {}
      is CommunicationRequest.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            30 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is CommunicationRequest.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          Hoisted.occurrencePeriodSer,
          choice.value,
        )
      }
    }
    ((value.authoredOn?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.recipient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.basedOnSer,
        value.recipient,
      )
    if (value.informationProvider.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.basedOnSer,
        value.informationProvider,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.reasonSer,
        value.reason,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val payloadSerInner: KSerializer<CommunicationRequest.Payload> =
      CommunicationRequest.Payload.serializer()

    public val payloadSer: KSerializer<List<CommunicationRequest.Payload>> =
      ListSerializer(Hoisted.payloadSerInner)

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object CommunicationRequestPolymorphicSerializer : KSerializer<CommunicationRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CommunicationRequest") {
      CommunicationRequestSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest) {
    encoder.encodeStructure(descriptor) {
      CommunicationRequestSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CommunicationRequest =
    decoder.decodeStructure(descriptor) {
      CommunicationRequestSerializer.deserializeInternal(this, descriptor, 0)
    }
}
