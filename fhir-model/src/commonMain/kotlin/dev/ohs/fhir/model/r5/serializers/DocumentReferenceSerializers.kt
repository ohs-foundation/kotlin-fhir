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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.DocumentReferenceStatus
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
      element("mode", CodeableConcept.serializer().descriptor, isOptional = true)
      element("time", KotlinString.serializer().descriptor, isOptional = true)
      element("_time", Element.serializer().descriptor, isOptional = true)
      element("party", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DocumentReference.Attester =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Attester) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DocumentReference.Attester {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: CodeableConcept? = null
    var time: KotlinString? = null
    var _time: Element? = null
    var party: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
        4 -> time = decoder.decodeStringElement(descriptor, i)
        5 -> _time = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timeSer, null)
        6 ->
          party = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attester: " + i)
      }
    }
    return DocumentReference.Attester(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = mode!!,
      time = DateTime.of(FhirDateTime.fromString(time), _time),
      party = party,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DocumentReference.Attester) {
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
    (value.mode)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.modeSer, it) }
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.timeSer, it)
    }
    (value.party)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.partySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val timeSer: KSerializer<Element> = Element.serializer()

    public val partySer: KSerializer<Reference> = Reference.serializer()
  }
}

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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("target", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DocumentReference.RelatesTo =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.RelatesTo) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DocumentReference.RelatesTo {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
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
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatesTo: " + i)
      }
    }
    return DocumentReference.RelatesTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      target = target!!,
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
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, it) }
    (value.target)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.targetSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

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
      element(
        "profile",
        listSerialDescriptor(
          lazyDescriptor { DocumentReference.Content.Profile.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DocumentReference.Content =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Content) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DocumentReference.Content {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var attachment: Attachment? = null
    var profile: List<DocumentReference.Content.Profile>? = null
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
          profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Content: " + i)
      }
    }
    return DocumentReference.Content(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      attachment = attachment!!,
      profile = profile ?: listOf(),
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
    (value.attachment)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.attachmentSer, it)
    }
    if (value.profile.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.profileSer, value.profile)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val attachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val profileSerInner: KSerializer<DocumentReference.Content.Profile> =
      DocumentReference.Content.Profile.serializer()

    public val profileSer: KSerializer<List<DocumentReference.Content.Profile>> =
      ListSerializer(Hoisted.profileSerInner)
  }
}

internal object DocumentReferenceContentProfileSerializer :
  KSerializer<DocumentReference.Content.Profile> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Profile") {
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
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUri", Element.serializer().descriptor, isOptional = true)
      element("valueCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCanonical", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DocumentReference.Content.Profile =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Content.Profile) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DocumentReference.Content.Profile {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueCoding: Coding? = null
    var valueUri: KotlinString? = null
    var _valueUri: Element? = null
    var valueCanonical: KotlinString? = null
    var _valueCanonical: Element? = null
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
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        4 -> valueUri = decoder.decodeStringElement(descriptor, i)
        5 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueUriSer, null)
        6 -> valueCanonical = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueUriSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Profile: " + i)
      }
    }
    return DocumentReference.Content.Profile(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        DocumentReference.Content.Profile.Value.from(
          valueCoding,
          Uri.of(valueUri, _valueUri),
          Canonical.of(valueCanonical, _valueCanonical),
        )!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: DocumentReference.Content.Profile,
  ) {
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
    when (val __d = value.`value`) {
      null -> {}
      is DocumentReference.Content.Profile.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.valueCodingSer, __d.value)
      }
      is DocumentReference.Content.Profile.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueUriSer, it)
        }
      }
      is DocumentReference.Content.Profile.Value.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueUriSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val valueUriSer: KSerializer<Element> = Element.serializer()
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("docStatus", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_docStatus", Element.serializer().descriptor, isOptional = true)
    b.element(
      "modality",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("context", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "event",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "bodySite",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("facilityType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("practiceSetting", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("author", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "attester",
      listSerialDescriptor(lazyDescriptor { DocumentReference.Attester.serializer().descriptor }),
      isOptional = true,
    )
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
  }

  override fun deserialize(decoder: Decoder): DocumentReference =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

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
        11 -> version = decoder.decodeStringElement(descriptor, i)
        12 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        14 -> status = decoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 -> docStatus = decoder.decodeStringElement(descriptor, i)
        17 ->
          _docStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          modality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySer, null)
        19 ->
          type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySerInner, null)
        20 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySer, null)
        21 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        22 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        23 ->
          event = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSer, null)
        24 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSer, null)
        25 ->
          facilityType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySerInner, null)
        26 ->
          practiceSetting =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySerInner, null)
        27 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        28 -> date = decoder.decodeStringElement(descriptor, i)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        31 ->
          attester =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.attesterSer, null)
        32 ->
          custodian =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        33 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatesToSer, null)
        34 -> description = decoder.decodeStringElement(descriptor, i)
        35 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySer, null)
        37 ->
          content =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentSer, null)
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
      status = Enumeration.of(DocumentReferenceStatus.fromCode(status!!), _status),
      docStatus =
        docStatus?.let {
          Enumeration.of(DocumentReference.CompositionStatus.fromCode(it), _docStatus)
        },
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
      date = Instant.of(FhirDateTime.fromString(date), _date),
      author = author ?: listOf(),
      attester = attester ?: listOf(),
      custodian = custodian,
      relatesTo = relatesTo ?: listOf(),
      description = Markdown.of(description, _description),
      securityLabel = securityLabel ?: listOf(),
      content = content ?: listOf(),
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
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
    ((value.docStatus?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.docStatus?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.modality.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.modalitySer,
        value.modality,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.modalitySerInner,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.modalitySer,
        value.category,
      )
    (value.subject)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.basedOnSer,
        value.context,
      )
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.eventSer,
        value.event,
      )
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.eventSer,
        value.bodySite,
      )
    (value.facilityType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.modalitySerInner,
        it,
      )
    }
    (value.practiceSetting)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.modalitySerInner,
        it,
      )
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.periodSer, it)
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.basedOnSer,
        value.author,
      )
    if (value.attester.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.attesterSer,
        value.attester,
      )
    (value.custodian)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.relatesToSer,
        value.relatesTo,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.modalitySer,
        value.securityLabel,
      )
    if (value.content.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.contentSer,
        value.content,
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

    public val modalitySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modalitySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.modalitySerInner)

    public val eventSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val eventSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.eventSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val attesterSerInner: KSerializer<DocumentReference.Attester> =
      DocumentReference.Attester.serializer()

    public val attesterSer: KSerializer<List<DocumentReference.Attester>> =
      ListSerializer(Hoisted.attesterSerInner)

    public val relatesToSerInner: KSerializer<DocumentReference.RelatesTo> =
      DocumentReference.RelatesTo.serializer()

    public val relatesToSer: KSerializer<List<DocumentReference.RelatesTo>> =
      ListSerializer(Hoisted.relatesToSerInner)

    public val contentSerInner: KSerializer<DocumentReference.Content> =
      DocumentReference.Content.serializer()

    public val contentSer: KSerializer<List<DocumentReference.Content>> =
      ListSerializer(Hoisted.contentSerInner)
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
