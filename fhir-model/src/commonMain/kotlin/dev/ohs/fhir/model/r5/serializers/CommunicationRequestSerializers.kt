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
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest.Payload) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CommunicationRequest.Payload {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
    var contentCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.contentAttachmentSer, null)
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.contentReferenceSer, null)
        5 ->
          contentCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.contentCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payload: " + __i)
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
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CommunicationRequest.Payload) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.content) {
      null -> {}
      is CommunicationRequest.Payload.Content.Attachment -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.contentAttachmentSer, __d.value)
      }
      is CommunicationRequest.Payload.Content.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.contentReferenceSer, __d.value)
      }
      is CommunicationRequest.Payload.Content.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.contentCodeableConceptSer, __d.value)
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
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "replaces",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("intent", String.serializer().descriptor, isOptional = true)
      element("_intent", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("priority", String.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
      element(
        "medium",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("about", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element(
        "payload",
        listSerialDescriptor(
          lazyDescriptor { CommunicationRequest.Payload.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("authoredOn", String.serializer().descriptor, isOptional = true)
      element("_authoredOn", Element.serializer().descriptor, isOptional = true)
      element("requester", Reference.serializer().descriptor, isOptional = true)
      element(
        "recipient",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "informationProvider",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CommunicationRequest =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CommunicationRequest {
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
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.basedOnSer, null)
        13 ->
          replaces = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.basedOnSer, null)
        14 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.identifierSerInner, null)
        15 -> status = decoder.decodeStringElement(__desc, 15)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.statusReasonSer, null)
        18 -> intent = decoder.decodeStringElement(__desc, 18)
        19 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.categorySer, null)
        21 -> priority = decoder.decodeStringElement(__desc, 21)
        22 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> doNotPerform = decoder.decodeBooleanElement(__desc, 23)
        24 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          medium = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.categorySer, null)
        26 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.basedOnSerInner, null)
        27 ->
          about = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.basedOnSer, null)
        28 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.basedOnSerInner, null)
        29 ->
          payload = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.payloadSer, null)
        30 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 30)
        31 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.occurrencePeriodSer, null)
        33 -> authoredOn = decoder.decodeStringElement(__desc, 33)
        34 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          requester =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.basedOnSerInner, null)
        36 ->
          recipient =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.basedOnSer, null)
        37 ->
          informationProvider =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.basedOnSer, null)
        38 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.reasonSer, null)
        39 -> note = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding CommunicationRequest: " + __i)
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
      status = Enumeration.of(CommunicationRequest.RequestStatus.fromCode(status!!), _status),
      statusReason = statusReason,
      intent = Enumeration.of(CommunicationRequest.RequestIntent.fromCode(intent!!), _intent),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: CommunicationRequest) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "CommunicationRequest")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.basedOnSer, value.basedOn)
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.basedOnSer, value.replaces)
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.identifierSerInner, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.statusReasonSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.categorySer, value.category)
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(__desc, 23, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    if (value.medium.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.categorySer, value.medium)
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.basedOnSerInner, it)
    }
    if (value.about.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.basedOnSer, value.about)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.basedOnSerInner, it)
    }
    if (value.payload.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.payloadSer, value.payload)
    when (val __d = value.occurrence) {
      null -> {}
      is CommunicationRequest.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 30, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
        }
      }
      is CommunicationRequest.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 32, Hoisted.occurrencePeriodSer, __d.value)
      }
    }
    ((value.authoredOn?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.basedOnSerInner, it)
    }
    if (value.recipient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.basedOnSer, value.recipient)
    if (value.informationProvider.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.basedOnSer, value.informationProvider)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.reasonSer, value.reason)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.noteSer, value.note)
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
