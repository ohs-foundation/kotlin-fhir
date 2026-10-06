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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.DocumentReferenceStatus
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

internal object DocumentReferenceAttesterSerializer : KSerializer<DocumentReference.Attester> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Attester") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("mode", CodeableConceptSerializer.descriptor)
      optionalElement("time", KotlinString.serializer().descriptor)
      optionalElement("_time", ElementSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DocumentReference.Attester>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DocumentReference.Attester =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var mode: CodeableConcept? = null
      var time: KotlinString? = null
      var _time: Element? = null
      var party: Reference? = null
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
            mode = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> time = decodeStringElement(descriptor, i)
          5 -> _time = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> party = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Attester: " + i)
        }
      }
      DocumentReference.Attester(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        mode =
          mode
            ?: throw SerializationException(
              "Missing required property 'mode' on DocumentReference.Attester"
            ),
        time = DateTime.of(if (time != null) FhirDateTime.fromString(time) else null, _time),
        party = party,
      )
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Attester) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.mode)
      encodeStringIfNotNull(descriptor, 4, value.time?.value?.toString())
      encodeElementIfNotNull(descriptor, 5, value.time)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.party)
    }
  }
}

internal object DocumentReferenceRelatesToSerializer : KSerializer<DocumentReference.RelatesTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatesTo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("target", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DocumentReference.RelatesTo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DocumentReference.RelatesTo =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var target: Reference? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> target = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatesTo: " + i)
        }
      }
      DocumentReference.RelatesTo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on DocumentReference.RelatesTo"
            ),
        target =
          target
            ?: throw SerializationException(
              "Missing required property 'target' on DocumentReference.RelatesTo"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.RelatesTo) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.target)
    }
  }
}

internal object DocumentReferenceContentSerializer : KSerializer<DocumentReference.Content> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Content") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("attachment", AttachmentSerializer.descriptor)
      optionalElement(
        "profile",
        DocumentReferenceContentProfileSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<DocumentReference.Content>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DocumentReference.Content =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var attachment: Attachment? = null
      var profile: List<DocumentReference.Content.Profile>? = null
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
            attachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          4 ->
            profile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DocumentReferenceContentProfileSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Content: " + i)
        }
      }
      DocumentReference.Content(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        attachment =
          attachment
            ?: throw SerializationException(
              "Missing required property 'attachment' on DocumentReference.Content"
            ),
        profile = profile ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Content) {
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
      encodeSerializableElement(descriptor, 3, AttachmentSerializer, value.attachment)
      if (value.profile.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          DocumentReferenceContentProfileSerializer.listSerializer,
          value.profile,
        )
    }
  }
}

internal object DocumentReferenceContentProfileSerializer :
  KSerializer<DocumentReference.Content.Profile> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Profile") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("valueCoding", CodingSerializer.descriptor)
      optionalElement("valueUri", KotlinString.serializer().descriptor)
      optionalElement("_valueUri", ElementSerializer.descriptor)
      optionalElement("valueCanonical", KotlinString.serializer().descriptor)
      optionalElement("_valueCanonical", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DocumentReference.Content.Profile>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): DocumentReference.Content.Profile =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var valueCoding: Coding? = null
      var valueUri: KotlinString? = null
      var _valueUri: Element? = null
      var valueCanonical: KotlinString? = null
      var _valueCanonical: Element? = null
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
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 -> valueUri = decodeStringElement(descriptor, i)
          5 -> _valueUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> valueCanonical = decodeStringElement(descriptor, i)
          7 ->
            _valueCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Profile: " + i)
        }
      }
      DocumentReference.Content.Profile(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` =
          DocumentReference.Content.Profile.Value.from(
            valueCoding,
            Uri.of(valueUri, _valueUri),
            Canonical.of(valueCanonical, _valueCanonical),
          )
            ?: throw SerializationException(
              "Missing required property 'value' on DocumentReference.Content.Profile"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Content.Profile) {
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
      when (val choice = value.`value`) {
        is DocumentReference.Content.Profile.Value.Coding -> {
          encodeSerializableElement(descriptor, 3, CodingSerializer, choice.value)
        }
        is DocumentReference.Content.Profile.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is DocumentReference.Content.Profile.Value.Canonical -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
      }
    }
  }
}

internal object DocumentReferenceSerializer : FhirResourceSerializer<DocumentReference> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("DocumentReference")

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
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("docStatus", KotlinString.serializer().descriptor)
    b.optionalElement("_docStatus", ElementSerializer.descriptor)
    b.optionalElement("modality", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("context", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("event", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("bodySite", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("facilityType", CodeableConceptSerializer.descriptor)
    b.optionalElement("practiceSetting", CodeableConceptSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("attester", DocumentReferenceAttesterSerializer.listSerializer.descriptor)
    b.optionalElement("custodian", ReferenceSerializer.descriptor)
    b.optionalElement("relatesTo", DocumentReferenceRelatesToSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("securityLabel", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("content", DocumentReferenceContentSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var basedOn: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var docStatus: KotlinString? = null
    var _docStatus: Element? = null
    var modality: List<CodeableConcept>? = null
    var type: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var subject: Reference? = null
    var context: List<Reference>? = null
    var event: List<CodeableReference>? = null
    var bodySite: List<CodeableReference>? = null
    var facilityType: CodeableConcept? = null
    var practiceSetting: CodeableConcept? = null
    var period: Period? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var author: List<Reference>? = null
    var attester: List<DocumentReference.Attester>? = null
    var custodian: Reference? = null
    var relatesTo: List<DocumentReference.RelatesTo>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var securityLabel: List<CodeableConcept>? = null
    var content: List<DocumentReference.Content>? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> version = decoder.decodeStringElement(descriptor, i)
        12 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        14 -> status = decoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> docStatus = decoder.decodeStringElement(descriptor, i)
        17 ->
          _docStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          modality =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        21 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          context =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          event =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        25 ->
          facilityType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          practiceSetting =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        28 -> date = decoder.decodeStringElement(descriptor, i)
        29 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        31 ->
          attester =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DocumentReferenceAttesterSerializer.listSerializer,
              null,
            )
        32 ->
          custodian =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        33 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DocumentReferenceRelatesToSerializer.listSerializer,
              null,
            )
        34 -> description = decoder.decodeStringElement(descriptor, i)
        35 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        37 ->
          content =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DocumentReferenceContentSerializer.listSerializer,
              null,
            )
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
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      basedOn = basedOn ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) DocumentReferenceStatus.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on DocumentReference"
          ),
      docStatus =
        Enumeration.of(
          if (docStatus != null) DocumentReference.CompositionStatus.fromCode(docStatus) else null,
          _docStatus,
        ),
      modality = modality ?: listOf(),
      type = type,
      category = category ?: listOf(),
      subject = subject,
      context = context ?: listOf(),
      event = event ?: listOf(),
      bodySite = bodySite ?: listOf(),
      facilityType = facilityType,
      practiceSetting = practiceSetting,
      period = period,
      date = Instant.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      author = author ?: listOf(),
      attester = attester ?: listOf(),
      custodian = custodian,
      relatesTo = relatesTo ?: listOf(),
      description = Markdown.of(description, _description),
      securityLabel = securityLabel ?: listOf(),
      content = content ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DocumentReference,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.version)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.docStatus?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.docStatus)
    if (value.modality.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.modality,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.context,
      )
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.event,
      )
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.bodySite,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.facilityType,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.practiceSetting,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.date)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.author,
      )
    if (value.attester.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        DocumentReferenceAttesterSerializer.listSerializer,
        value.attester,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.custodian,
    )
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        DocumentReferenceRelatesToSerializer.listSerializer,
        value.relatesTo,
      )
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.description)
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.securityLabel,
      )
    if (value.content.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        DocumentReferenceContentSerializer.listSerializer,
        value.content,
      )
  }
}
