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

import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DocumentReference
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.DocumentReferenceStatus
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.RelatesTo) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DocumentReference.RelatesTo {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var target: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatesTo: " + i)
      }
    }
    return DocumentReference.RelatesTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Enumeration.of(
          DocumentReference.DocumentRelationshipType.fromCode(
            code
              ?: throw SerializationException(
                "Missing required property 'code' on DocumentReference.RelatesTo"
              )
          ),
          _code,
        ),
      target =
        target
          ?: throw SerializationException(
            "Missing required property 'target' on DocumentReference.RelatesTo"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DocumentReference.RelatesTo) {
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
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.targetSer, value.target)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Content) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DocumentReference.Content {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var attachment: Attachment? = null
    var format: Coding? = null
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
          attachment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.attachmentSer, null)
        4 ->
          format = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.formatSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Content: " + i)
      }
    }
    return DocumentReference.Content(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      attachment =
        attachment
          ?: throw SerializationException(
            "Missing required property 'attachment' on DocumentReference.Content"
          ),
      format = format,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DocumentReference.Content) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.attachmentSer, value.attachment)
    (value.format)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.formatSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Context) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DocumentReference.Context {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.encounterSer, null)
        4 ->
          event = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSer, null)
        5 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        6 ->
          facilityType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSerInner, null)
        7 ->
          practiceSetting =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSerInner, null)
        8 ->
          sourcePatientInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.encounterSerInner,
              null,
            )
        9 ->
          related =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.encounterSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Context: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DocumentReference.Context) {
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
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.encounterSer, value.encounter)
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.eventSer, value.event)
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.periodSer, it) }
    (value.facilityType)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.eventSerInner, it)
    }
    (value.practiceSetting)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.eventSerInner, it)
    }
    (value.sourcePatientInfo)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.encounterSerInner, it)
    }
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.encounterSer, value.related)
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
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
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
    b.element("masterIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("docStatus", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_docStatus", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("author", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("authenticator", Reference.serializer().descriptor, isOptional = true)
    b.element("custodian", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "relatesTo",
      listSerialDescriptor(lazyDescriptor { DocumentReference.RelatesTo.serializer().descriptor }),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "securityLabel",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "content",
      listSerialDescriptor(lazyDescriptor { DocumentReference.Content.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "context",
      lazyDescriptor { DocumentReference.Context.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): DocumentReference =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DocumentReference")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): DocumentReference {
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
          masterIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.masterIdentifierSer,
              null,
            )
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> docStatus = decoder.decodeStringElement(descriptor, i)
        15 ->
          _docStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        17 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        18 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        19 -> date = decoder.decodeStringElement(descriptor, i)
        20 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          author = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authorSer, null)
        22 ->
          authenticator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        23 ->
          custodian =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        24 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatesToSer, null)
        25 -> description = decoder.decodeStringElement(descriptor, i)
        26 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        28 ->
          content =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentSer, null)
        29 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contextSer, null)
        else -> throw SerializationException("Unexpected index decoding DocumentReference: " + i)
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
      status =
        Enumeration.of(
          DocumentReferenceStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on DocumentReference"
              )
          ),
          _status,
        ),
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
      description = R4bString.of(description, _description),
      securityLabel = securityLabel ?: listOf(),
      content = content ?: listOf(),
      context = context,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DocumentReference,
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
    (value.masterIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.masterIdentifierSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.docStatus?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.docStatus?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.subjectSer, it)
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.authorSer,
        value.author,
      )
    (value.authenticator)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.custodian)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.relatesToSer,
        value.relatesTo,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.categorySer,
        value.securityLabel,
      )
    if (value.content.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.contentSer,
        value.content,
      )
    (value.context)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.contextSer, it)
    }
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

internal object DocumentReferencePolymorphicSerializer : KSerializer<DocumentReference> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DocumentReference") {
      DocumentReferenceSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference) {
    encoder.encodeStructure(descriptor) {
      DocumentReferenceSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DocumentReference =
    decoder.decodeStructure(descriptor) {
      DocumentReferenceSerializer.deserializeInternal(this, descriptor, 0)
    }
}
