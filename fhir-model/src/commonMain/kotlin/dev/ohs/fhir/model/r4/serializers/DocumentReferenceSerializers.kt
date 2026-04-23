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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DocumentReference
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.DocumentReferenceStatus
import kotlin.String as KotlinString
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

internal object DocumentReferenceRelatesToSerializer : KSerializer<DocumentReference.RelatesTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatesTo") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("target", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DocumentReference.RelatesTo =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.RelatesTo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DocumentReference.RelatesTo {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var target: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> target = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatesTo: " + __i)
      }
    }
    return DocumentReference.RelatesTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(DocumentReference.DocumentRelationshipType.fromCode(code!!), _code),
      target = target!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DocumentReference.RelatesTo) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    (value.target)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.targetSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val targetSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object DocumentReferenceContentSerializer : KSerializer<DocumentReference.Content> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Content") {
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
      element("attachment", Attachment.serializer().descriptor, isOptional = true)
      element("format", Coding.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DocumentReference.Content =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Content) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DocumentReference.Content {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var attachment: Attachment? = null
    var format: Coding? = null
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
          attachment =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.attachmentSer, null)
        4 -> format = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.formatSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Content: " + __i)
      }
    }
    return DocumentReference.Content(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      attachment = attachment!!,
      format = format,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DocumentReference.Content) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.attachment)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.attachmentSer, it)
    }
    (value.format)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.formatSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val attachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val formatSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object DocumentReferenceContextSerializer : KSerializer<DocumentReference.Context> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Context") {
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
      element(
        "encounter",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "event",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
      element("facilityType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("practiceSetting", CodeableConcept.serializer().descriptor, isOptional = true)
      element("sourcePatientInfo", Reference.serializer().descriptor, isOptional = true)
      element("related", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DocumentReference.Context =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Context) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DocumentReference.Context {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var encounter: List<Reference>? = null
    var event: List<CodeableConcept>? = null
    var period: Period? = null
    var facilityType: CodeableConcept? = null
    var practiceSetting: CodeableConcept? = null
    var sourcePatientInfo: Reference? = null
    var related: List<Reference>? = null
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
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.encounterSer, null)
        4 -> event = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.eventSer, null)
        5 -> period = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.periodSer, null)
        6 ->
          facilityType =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.eventSerInner, null)
        7 ->
          practiceSetting =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.eventSerInner, null)
        8 ->
          sourcePatientInfo =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.encounterSerInner, null)
        9 ->
          related = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.encounterSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Context: " + __i)
      }
    }
    return DocumentReference.Context(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      encounter = encounter ?: listOf(),
      event = event ?: listOf(),
      period = period,
      facilityType = facilityType,
      practiceSetting = practiceSetting,
      sourcePatientInfo = sourcePatientInfo,
      related = related ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DocumentReference.Context) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.encounterSer, value.encounter)
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.eventSer, value.event)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.periodSer, it) }
    (value.facilityType)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.eventSerInner, it)
    }
    (value.practiceSetting)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.eventSerInner, it)
    }
    (value.sourcePatientInfo)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.encounterSerInner, it)
    }
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.encounterSer, value.related)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val encounterSerInner: KSerializer<Reference> = Reference.serializer()

    public val encounterSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.encounterSerInner)

    public val eventSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val eventSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.eventSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object DocumentReferenceSerializer : KSerializer<DocumentReference> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DocumentReference") {
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
      element("masterIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("docStatus", KotlinString.serializer().descriptor, isOptional = true)
      element("_docStatus", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("author", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("authenticator", Reference.serializer().descriptor, isOptional = true)
      element("custodian", Reference.serializer().descriptor, isOptional = true)
      element(
        "relatesTo",
        listSerialDescriptor(
          lazyDescriptor { DocumentReference.RelatesTo.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "securityLabel",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "content",
        listSerialDescriptor(lazyDescriptor { DocumentReference.Content.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "context",
        lazyDescriptor { DocumentReference.Context.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DocumentReference =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): DocumentReference {
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
    var masterIdentifier: Identifier? = null
    var identifier: List<Identifier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var docStatus: KotlinString? = null
    var _docStatus: Element? = null
    var type: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var subject: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var author: List<Reference>? = null
    var authenticator: Reference? = null
    var custodian: Reference? = null
    var relatesTo: List<DocumentReference.RelatesTo>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var securityLabel: List<CodeableConcept>? = null
    var content: List<DocumentReference.Content>? = null
    var context: DocumentReference.Context? = null
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
          masterIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.masterIdentifierSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.identifierSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> docStatus = decoder.decodeStringElement(__desc, 15)
        16 ->
          _docStatus =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 -> type = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.typeSer, null)
        18 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.categorySer, null)
        19 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.subjectSer, null)
        20 -> date = decoder.decodeStringElement(__desc, 20)
        21 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          author = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.authorSer, null)
        23 ->
          authenticator =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.subjectSer, null)
        24 ->
          custodian =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.subjectSer, null)
        25 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.relatesToSer, null)
        26 -> description = decoder.decodeStringElement(__desc, 26)
        27 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.categorySer, null)
        29 ->
          content = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.contentSer, null)
        30 ->
          context = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.contextSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DocumentReference: " + __i)
      }
    }
    return DocumentReference(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      masterIdentifier = masterIdentifier,
      identifier = identifier ?: listOf(),
      status = Enumeration.of(DocumentReferenceStatus.fromCode(status!!), _status),
      docStatus =
        docStatus?.let {
          Enumeration.of(DocumentReference.CompositionStatus.fromCode(it), _docStatus)
        },
      type = type,
      category = category ?: listOf(),
      subject = subject,
      date = Instant.of(FhirDateTime.fromString(date), _date),
      author = author ?: listOf(),
      authenticator = authenticator,
      custodian = custodian,
      relatesTo = relatesTo ?: listOf(),
      description = R4String.of(description, _description),
      securityLabel = securityLabel ?: listOf(),
      content = content ?: listOf(),
      context = context,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DocumentReference) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "DocumentReference")
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
    (value.masterIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.masterIdentifierSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    ((value.docStatus?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.docStatus?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.typeSer, it) }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.categorySer, value.category)
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.subjectSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.authorSer, value.author)
    (value.authenticator)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.subjectSer, it)
    }
    (value.custodian)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.subjectSer, it) }
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.relatesToSer, value.relatesTo)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.categorySer, value.securityLabel)
    if (value.content.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.contentSer, value.content)
    (value.context)?.let { encoder.encodeSerializableElement(__desc, 30, Hoisted.contextSer, it) }
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

    public val masterIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.masterIdentifierSer)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val authorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val relatesToSerInner: KSerializer<DocumentReference.RelatesTo> =
      DocumentReference.RelatesTo.serializer()

    public val relatesToSer: KSerializer<List<DocumentReference.RelatesTo>> =
      ListSerializer(Hoisted.relatesToSerInner)

    public val contentSerInner: KSerializer<DocumentReference.Content> =
      DocumentReference.Content.serializer()

    public val contentSer: KSerializer<List<DocumentReference.Content>> =
      ListSerializer(Hoisted.contentSerInner)

    public val contextSer: KSerializer<DocumentReference.Context> =
      DocumentReference.Context.serializer()
  }
}
