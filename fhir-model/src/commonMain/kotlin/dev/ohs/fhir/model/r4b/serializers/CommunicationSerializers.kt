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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object CommunicationPayloadSerializer : KSerializer<Communication.Payload> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payload") {
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
      element("contentString", KotlinString.serializer().descriptor, isOptional = true)
      element("_contentString", Element.serializer().descriptor, isOptional = true)
      element("contentAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("contentReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Communication.Payload =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Communication.Payload) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Communication.Payload {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentString: KotlinString? = null
    var _contentString: Element? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> contentString = decoder.decodeStringElement(__desc, 3)
        4 ->
          _contentString =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.contentStringSer, null)
        5 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.contentAttachmentSer, null)
        6 ->
          contentReference =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.contentReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payload: " + __i)
      }
    }
    return Communication.Payload(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content =
        Communication.Payload.Content.from(
          R4bString.of(contentString, _contentString),
          contentAttachment,
          contentReference,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Communication.Payload) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.content) {
      null -> {}
      is Communication.Payload.Content.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.contentStringSer, it)
        }
      }
      is Communication.Payload.Content.Attachment -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.contentAttachmentSer, __d.value)
      }
      is Communication.Payload.Content.Reference -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.contentReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contentStringSer: KSerializer<Element> = Element.serializer()

    public val contentAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val contentReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CommunicationSerializer : KSerializer<Communication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Communication") {
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesCanonical",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesCanonical",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesUri",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "inResponseTo",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("priority", KotlinString.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element(
        "medium",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("topic", CodeableConcept.serializer().descriptor, isOptional = true)
      element("about", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("sent", KotlinString.serializer().descriptor, isOptional = true)
      element("_sent", Element.serializer().descriptor, isOptional = true)
      element("received", KotlinString.serializer().descriptor, isOptional = true)
      element("_received", Element.serializer().descriptor, isOptional = true)
      element(
        "recipient",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("sender", Reference.serializer().descriptor, isOptional = true)
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "payload",
        listSerialDescriptor(lazyDescriptor { Communication.Payload.serializer().descriptor }),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Communication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Communication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Communication {
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
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        13 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        14 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        15 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        16 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSer, null)
        17 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSer, null)
        18 ->
          inResponseTo =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.basedOnSer, null)
        19 -> status = decoder.decodeStringElement(__desc, 19)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.statusReasonSer, null)
        22 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.categorySer, null)
        23 -> priority = decoder.decodeStringElement(__desc, 23)
        24 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          medium = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.categorySer, null)
        26 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.basedOnSerInner, null)
        27 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.statusReasonSer, null)
        28 ->
          about = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.basedOnSer, null)
        29 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.basedOnSerInner, null)
        30 -> sent = decoder.decodeStringElement(__desc, 30)
        31 ->
          _sent =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 -> received = decoder.decodeStringElement(__desc, 32)
        33 ->
          _received =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          recipient =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.basedOnSer, null)
        35 ->
          sender =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.basedOnSerInner, null)
        36 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.categorySer, null)
        37 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.basedOnSer, null)
        38 ->
          payload = decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.payloadSer, null)
        39 -> note = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Communication: " + __i)
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
        ) { __i ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(__i)?.let { it },
            _instantiatesCanonical?.getOrNull(__i),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          __i ->
          Uri.of(instantiatesUri?.getOrNull(__i)?.let { it }, _instantiatesUri?.getOrNull(__i))!!
        }),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      inResponseTo = inResponseTo ?: listOf(),
      status = Enumeration.of(Communication.EventStatus.fromCode(status!!), _status),
      statusReason = statusReason,
      category = category ?: listOf(),
      priority =
        priority?.let { Enumeration.of(Communication.RequestPriority.fromCode(it), _priority) },
      medium = medium ?: listOf(),
      subject = subject,
      topic = topic,
      about = about ?: listOf(),
      encounter = encounter,
      sent = DateTime.of(FhirDateTime.fromString(sent), _sent),
      received = DateTime.of(FhirDateTime.fromString(received), _received),
      recipient = recipient ?: listOf(),
      sender = sender,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      payload = payload ?: listOf(),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Communication) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Communication")
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
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSer, value.partOf)
    if (value.inResponseTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.basedOnSer, value.inResponseTo)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.statusReasonSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.categorySer, value.category)
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    if (value.medium.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.categorySer, value.medium)
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.basedOnSerInner, it)
    }
    (value.topic)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.statusReasonSer, it)
    }
    if (value.about.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.basedOnSer, value.about)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.basedOnSerInner, it)
    }
    ((value.sent?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.sent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    ((value.received?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.received?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    if (value.recipient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.basedOnSer, value.recipient)
    (value.sender)?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.basedOnSerInner, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.categorySer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.basedOnSer, value.reasonReference)
    if (value.payload.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.payloadSer, value.payload)
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

    public val instantiatesCanonicalSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val payloadSerInner: KSerializer<Communication.Payload> =
      Communication.Payload.serializer()

    public val payloadSer: KSerializer<List<Communication.Payload>> =
      ListSerializer(Hoisted.payloadSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
