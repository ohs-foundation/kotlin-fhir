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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Media
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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
    b.element("duration", FhirDecimalSerializer.descriptor, isOptional = true)
    b.element("_duration", Element.serializer().descriptor, isOptional = true)
    b.element("content", Attachment.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Media =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Media) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Media")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Media {
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
    var duration: FhirDecimal? = null
    var _duration: Element? = null
    var content: Attachment? = null
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
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        16 ->
          modality = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        17 -> view = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        18 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        20 -> createdDateTime = decoder.decodeStringElement(descriptor, i)
        21 ->
          _createdDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          createdPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.createdPeriodSer, null)
        23 -> issued = decoder.decodeStringElement(descriptor, i)
        24 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          `operator` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        26 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonCodeSer, null)
        27 ->
          bodySite = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        28 -> deviceName = decoder.decodeStringElement(descriptor, i)
        29 ->
          _deviceName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        31 -> height = decoder.decodeIntElement(descriptor, i)
        32 ->
          _height =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> width = decoder.decodeIntElement(descriptor, i)
        34 ->
          _width =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> frames = decoder.decodeIntElement(descriptor, i)
        36 ->
          _frames =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        38 ->
          _duration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 ->
          content =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentSer, null)
        40 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        else -> throw SerializationException("Unexpected index decoding Media: " + i)
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
      status =
        Enumeration.of(
          Media.EventStatus.fromCode(
            status ?: throw SerializationException("Missing required property 'status' on Media")
          ),
          _status,
        ),
      type = type,
      modality = modality,
      view = view,
      subject = subject,
      encounter = encounter,
      created =
        Media.Created.from(
          DateTime.of(createdDateTime?.let { FhirDateTime.fromString(it) }, _createdDateTime),
          createdPeriod,
        ),
      issued = Instant.of(issued?.let { FhirDateTime.fromString(it) }, _issued),
      `operator` = `operator`,
      reasonCode = reasonCode ?: listOf(),
      bodySite = bodySite,
      deviceName = R4bString.of(deviceName, _deviceName),
      device = device,
      height = PositiveInt.of(height, _height),
      width = PositiveInt.of(width, _width),
      frames = PositiveInt.of(frames, _frames),
      duration = Decimal.of(duration, _duration),
      content =
        content ?: throw SerializationException("Missing required property 'content' on Media"),
      note = note ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Media,
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
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.basedOnSer,
        value.partOf,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.modality)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.view)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    when (val choice = value.created) {
      null -> {}
      is Media.Created.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            21 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Media.Created.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          Hoisted.createdPeriodSer,
          choice.value,
        )
      }
    }
    ((value.issued?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.`operator`)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.reasonCodeSer,
        value.reasonCode,
      )
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.deviceName?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.deviceName?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    ((value.height?.value))?.let { encoder.encodeIntElement(descriptor, 31 + descriptorOffset, it) }
    (value.height?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.width?.value))?.let { encoder.encodeIntElement(descriptor, 33 + descriptorOffset, it) }
    (value.width?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.frames?.value))?.let { encoder.encodeIntElement(descriptor, 35 + descriptorOffset, it) }
    (value.frames?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.duration?.value))?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        FhirDecimalSerializer,
        it,
      )
    }
    (value.duration?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      39 + descriptorOffset,
      Hoisted.contentSer,
      value.content,
    )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
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
      MediaSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Media =
    decoder.decodeStructure(descriptor) {
      MediaSerializer.deserializeInternal(this, descriptor, 0)
    }
}
