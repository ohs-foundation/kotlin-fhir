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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Media
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
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

internal object MediaCreatedSerializer : KSerializer<Media.Created> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Media.Created") {
      element("createdDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_createdDateTime", Element.serializer().descriptor, isOptional = true)
      element("createdPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Media.Created) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Media.Created.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Media.Created.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.createdPeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Media.Created =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Media.Created {
    val __desc = descriptor
    var createdDateTime: KotlinString? = null
    var _createdDateTime: Element? = null
    var createdPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> createdDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _createdDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          createdPeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.createdPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Media.Created: " + __i)
      }
    }
    return Media.Created.from(
      DateTime.of(FhirDateTime.fromString(createdDateTime), _createdDateTime),
      createdPeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val createdPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object MediaSerializer : KSerializer<Media> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Media") {
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
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("modality", CodeableConcept.serializer().descriptor, isOptional = true)
      element("view", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("createdDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_createdDateTime", Element.serializer().descriptor, isOptional = true)
      element("createdPeriod", Period.serializer().descriptor, isOptional = true)
      element("issued", KotlinString.serializer().descriptor, isOptional = true)
      element("_issued", Element.serializer().descriptor, isOptional = true)
      element("operator", Reference.serializer().descriptor, isOptional = true)
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element("deviceName", KotlinString.serializer().descriptor, isOptional = true)
      element("_deviceName", Element.serializer().descriptor, isOptional = true)
      element("device", Reference.serializer().descriptor, isOptional = true)
      element("height", Int.serializer().descriptor, isOptional = true)
      element("_height", Element.serializer().descriptor, isOptional = true)
      element("width", Int.serializer().descriptor, isOptional = true)
      element("_width", Element.serializer().descriptor, isOptional = true)
      element("frames", Int.serializer().descriptor, isOptional = true)
      element("_frames", Element.serializer().descriptor, isOptional = true)
      element("duration", BigDecimalSerializer.descriptor, isOptional = true)
      element("_duration", Element.serializer().descriptor, isOptional = true)
      element("content", Attachment.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Media =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Media) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Media {
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
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var modality: CodeableConcept? = null
    var view: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var createdDateTime: KotlinString? = null
    var _createdDateTime: Element? = null
    var createdPeriod: Period? = null
    var issued: KotlinString? = null
    var _issued: Element? = null
    var `operator`: Reference? = null
    var reasonCode: List<CodeableConcept>? = null
    var bodySite: CodeableConcept? = null
    var deviceName: KotlinString? = null
    var _deviceName: Element? = null
    var device: Reference? = null
    var height: Int? = null
    var _height: Element? = null
    var width: Int? = null
    var _width: Element? = null
    var frames: Int? = null
    var _frames: Element? = null
    var duration: BigDecimal? = null
    var _duration: Element? = null
    var content: Attachment? = null
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
          partOf = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.basedOnSer, null)
        14 -> status = decoder.decodeStringElement(__desc, 14)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> type = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.typeSer, null)
        17 ->
          modality = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.typeSer, null)
        18 -> view = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.typeSer, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.basedOnSerInner, null)
        20 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.basedOnSerInner, null)
        21 -> createdDateTime = decoder.decodeStringElement(__desc, 21)
        22 ->
          _createdDateTime =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          createdPeriod =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.createdPeriodSer, null)
        24 -> issued = decoder.decodeStringElement(__desc, 24)
        25 ->
          _issued =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          `operator` =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.basedOnSerInner, null)
        27 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.reasonCodeSer, null)
        28 ->
          bodySite = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.typeSer, null)
        29 -> deviceName = decoder.decodeStringElement(__desc, 29)
        30 ->
          _deviceName =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          device =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.basedOnSerInner, null)
        32 -> height = decoder.decodeIntElement(__desc, 32)
        33 ->
          _height =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 -> width = decoder.decodeIntElement(__desc, 34)
        35 ->
          _width =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> frames = decoder.decodeIntElement(__desc, 36)
        37 ->
          _frames =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, 38, BigDecimalSerializer, null)
        39 ->
          _duration =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 ->
          content = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.contentSer, null)
        41 -> note = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Media: " + __i)
      }
    }
    return Media(
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
      partOf = partOf ?: listOf(),
      status = Enumeration.of(Media.EventStatus.fromCode(status!!), _status),
      type = type,
      modality = modality,
      view = view,
      subject = subject,
      encounter = encounter,
      created =
        Media.Created.from(
          DateTime.of(FhirDateTime.fromString(createdDateTime), _createdDateTime),
          createdPeriod,
        ),
      issued = Instant.of(FhirDateTime.fromString(issued), _issued),
      `operator` = `operator`,
      reasonCode = reasonCode ?: listOf(),
      bodySite = bodySite,
      deviceName = R4String.of(deviceName, _deviceName),
      device = device,
      height = PositiveInt.of(height, _height),
      width = PositiveInt.of(width, _width),
      frames = PositiveInt.of(frames, _frames),
      duration = Decimal.of(duration, _duration),
      content = content!!,
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Media) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Media")
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
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.typeSer, it) }
    (value.modality)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.typeSer, it) }
    (value.view)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.typeSer, it) }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.created) {
      null -> {}
      is Media.Created.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
        }
      }
      is Media.Created.Period -> {
        encoder.encodeSerializableElement(__desc, 23, Hoisted.createdPeriodSer, __d.value)
      }
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    (value.`operator`)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.basedOnSerInner, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.reasonCodeSer, value.reasonCode)
    (value.bodySite)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.typeSer, it) }
    ((value.deviceName?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.deviceName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.basedOnSerInner, it)
    }
    ((value.height?.value))?.let { encoder.encodeIntElement(__desc, 32, it) }
    (value.height?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    ((value.width?.value))?.let { encoder.encodeIntElement(__desc, 34, it) }
    (value.width?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    ((value.frames?.value))?.let { encoder.encodeIntElement(__desc, 36, it) }
    (value.frames?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.duration?.value))?.let {
      encoder.encodeSerializableElement(__desc, 38, BigDecimalSerializer, it)
    }
    (value.duration?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    (value.content)?.let { encoder.encodeSerializableElement(__desc, 40, Hoisted.contentSer, it) }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.noteSer, value.note)
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val createdPeriodSer: KSerializer<Period> = Period.serializer()

    public val reasonCodeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val contentSer: KSerializer<Attachment> = Attachment.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
