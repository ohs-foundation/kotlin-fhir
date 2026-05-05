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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Attester) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DocumentReference.Attester {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: CodeableConcept? = null
    var time: KotlinString? = null
    var _time: Element? = null
    var party: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modeSer, null)
        4 -> time = decoder.decodeStringElement(__desc, __i)
        5 -> _time = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.timeSer, null)
        6 -> party = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attester: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DocumentReference.Attester) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.mode)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.modeSer, it) }
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.timeSer, it)
    }
    (value.party)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.partySer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.RelatesTo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DocumentReference.RelatesTo {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var target: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          target = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatesTo: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DocumentReference.RelatesTo) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.target)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.targetSer, it) }
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
    var profile: List<DocumentReference.Content.Profile>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          attachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.attachmentSer, null)
        4 ->
          profile = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.profileSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Content: " + __i)
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
    if (value.profile.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.profileSer, value.profile)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Content.Profile) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DocumentReference.Content.Profile {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueCoding: Coding? = null
    var valueUri: KotlinString? = null
    var _valueUri: Element? = null
    var valueCanonical: KotlinString? = null
    var _valueCanonical: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCodingSer, null)
        4 -> valueUri = decoder.decodeStringElement(__desc, __i)
        5 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueUriSer, null)
        6 -> valueCanonical = decoder.decodeStringElement(__desc, __i)
        7 ->
          _valueCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueUriSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Profile: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DocumentReference.Content.Profile) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.`value`) {
      null -> {}
      is DocumentReference.Content.Profile.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.valueCodingSer, __d.value)
      }
      is DocumentReference.Content.Profile.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.valueUriSer, it)
        }
      }
      is DocumentReference.Content.Profile.Value.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueUriSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: DocumentReference) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DocumentReference")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): DocumentReference {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> version = decoder.decodeStringElement(__desc, __i)
        12 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        14 -> status = decoder.decodeStringElement(__desc, __i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 -> docStatus = decoder.decodeStringElement(__desc, __i)
        17 ->
          _docStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 ->
          modality =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modalitySer, null)
        19 ->
          type =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modalitySerInner, null)
        20 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modalitySer, null)
        21 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        22 ->
          context = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        23 -> event = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eventSer, null)
        24 ->
          bodySite = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eventSer, null)
        25 ->
          facilityType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modalitySerInner, null)
        26 ->
          practiceSetting =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modalitySerInner, null)
        27 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        28 -> date = decoder.decodeStringElement(__desc, __i)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 ->
          author = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        31 ->
          attester =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.attesterSer, null)
        32 ->
          custodian =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        33 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relatesToSer, null)
        34 -> description = decoder.decodeStringElement(__desc, __i)
        35 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        36 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modalitySer, null)
        37 ->
          content = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: DocumentReference,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.basedOnSer, value.basedOn)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.docStatus?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 16 + __off, it)
    }
    (value.docStatus?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.modality.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.modalitySer, value.modality)
    (value.type)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.modalitySerInner, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.modalitySer, value.category)
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.basedOnSer, value.context)
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.eventSer, value.event)
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.eventSer, value.bodySite)
    (value.facilityType)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.modalitySerInner, it)
    }
    (value.practiceSetting)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.modalitySerInner, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.periodSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.basedOnSer, value.author)
    if (value.attester.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.attesterSer, value.attester)
    (value.custodian)?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.relatesToSer, value.relatesTo)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 34 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        36 + __off,
        Hoisted.modalitySer,
        value.securityLabel,
      )
    if (value.content.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.contentSer, value.content)
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
      DocumentReferenceSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DocumentReference =
    decoder.decodeStructure(descriptor) {
      DocumentReferenceSerializer.deserializeJson(this, descriptor, 0)
    }
}
