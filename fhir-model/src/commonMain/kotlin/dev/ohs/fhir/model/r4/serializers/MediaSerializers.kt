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

internal object MediaSerializer : KSerializer<Media> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Media") {
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("modality", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("view", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("createdDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_createdDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("createdPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("issued", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_issued", Element.serializer().descriptor, isOptional = true)
    b.element("operator", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reasonCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("deviceName", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_deviceName", Element.serializer().descriptor, isOptional = true)
    b.element("device", Reference.serializer().descriptor, isOptional = true)
    b.element("height", Int.serializer().descriptor, isOptional = true)
    b.element("_height", Element.serializer().descriptor, isOptional = true)
    b.element("width", Int.serializer().descriptor, isOptional = true)
    b.element("_width", Element.serializer().descriptor, isOptional = true)
    b.element("frames", Int.serializer().descriptor, isOptional = true)
    b.element("_frames", Element.serializer().descriptor, isOptional = true)
    b.element("duration", BigDecimalSerializer.descriptor, isOptional = true)
    b.element("_duration", Element.serializer().descriptor, isOptional = true)
    b.element("content", Attachment.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Media =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Media) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Media")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Media {
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
        11 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        12 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(__desc, __i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        16 ->
          modality = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        17 -> view = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        18 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        20 -> createdDateTime = decoder.decodeStringElement(__desc, __i)
        21 ->
          _createdDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 ->
          createdPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.createdPeriodSer, null)
        23 -> issued = decoder.decodeStringElement(__desc, __i)
        24 ->
          _issued =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          `operator` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        26 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonCodeSer, null)
        27 ->
          bodySite = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        28 -> deviceName = decoder.decodeStringElement(__desc, __i)
        29 ->
          _deviceName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 ->
          device =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        31 -> height = decoder.decodeIntElement(__desc, __i)
        32 ->
          _height =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        33 -> width = decoder.decodeIntElement(__desc, __i)
        34 ->
          _width =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        35 -> frames = decoder.decodeIntElement(__desc, __i)
        36 ->
          _frames =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        37 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        38 ->
          _duration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        39 ->
          content = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentSer, null)
        40 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Media,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.typeSer, it) }
    (value.modality)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.typeSer, it)
    }
    (value.view)?.let { encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.typeSer, it) }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.created) {
      null -> {}
      is Media.Created.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Media.Created.Period -> {
        encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.createdPeriodSer, __d.value)
      }
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23 + __off, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.`operator`)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.reasonCodeSer, value.reasonCode)
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.typeSer, it)
    }
    ((value.deviceName?.value))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
    (value.deviceName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.basedOnSerInner, it)
    }
    ((value.height?.value))?.let { encoder.encodeIntElement(__desc, 31 + __off, it) }
    (value.height?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.width?.value))?.let { encoder.encodeIntElement(__desc, 33 + __off, it) }
    (value.width?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.frames?.value))?.let { encoder.encodeIntElement(__desc, 35 + __off, it) }
    (value.frames?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.duration?.value))?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, BigDecimalSerializer, it)
    }
    (value.duration?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.content)?.let {
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.contentSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.noteSer, value.note)
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

internal object MediaPolymorphicSerializer : KSerializer<Media> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Media") { MediaSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Media) {
    encoder.encodeStructure(descriptor) {
      MediaSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Media =
    decoder.decodeStructure(descriptor) { MediaSerializer.deserializeJson(this, descriptor, 0) }
}
