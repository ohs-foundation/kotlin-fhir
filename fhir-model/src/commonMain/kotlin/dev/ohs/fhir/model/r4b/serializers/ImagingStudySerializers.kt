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
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ImagingStudy
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
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

internal object ImagingStudySeriesSerializer : KSerializer<ImagingStudy.Series> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Series") {
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
      element("uid", KotlinString.serializer().descriptor, isOptional = true)
      element("_uid", Element.serializer().descriptor, isOptional = true)
      element("number", Int.serializer().descriptor, isOptional = true)
      element("_number", Element.serializer().descriptor, isOptional = true)
      element("modality", Coding.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("numberOfInstances", Int.serializer().descriptor, isOptional = true)
      element("_numberOfInstances", Element.serializer().descriptor, isOptional = true)
      element(
        "endpoint",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("bodySite", Coding.serializer().descriptor, isOptional = true)
      element("laterality", Coding.serializer().descriptor, isOptional = true)
      element(
        "specimen",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("started", KotlinString.serializer().descriptor, isOptional = true)
      element("_started", Element.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(
          lazyDescriptor { ImagingStudy.Series.Performer.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "instance",
        listSerialDescriptor(
          lazyDescriptor { ImagingStudy.Series.Instance.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImagingStudy.Series =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImagingStudy.Series {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uid: KotlinString? = null
    var _uid: Element? = null
    var number: Int? = null
    var _number: Element? = null
    var modality: Coding? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var numberOfInstances: Int? = null
    var _numberOfInstances: Element? = null
    var endpoint: List<Reference>? = null
    var bodySite: Coding? = null
    var laterality: Coding? = null
    var specimen: List<Reference>? = null
    var started: KotlinString? = null
    var _started: Element? = null
    var performer: List<ImagingStudy.Series.Performer>? = null
    var instance: List<ImagingStudy.Series.Instance>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> uid = decoder.decodeStringElement(__desc, 3)
        4 -> _uid = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.uidSer, null)
        5 -> number = decoder.decodeIntElement(__desc, 5)
        6 -> _number = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.uidSer, null)
        7 ->
          modality = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.modalitySer, null)
        8 -> description = decoder.decodeStringElement(__desc, 8)
        9 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.uidSer, null)
        10 -> numberOfInstances = decoder.decodeIntElement(__desc, 10)
        11 ->
          _numberOfInstances =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.uidSer, null)
        12 ->
          endpoint =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.endpointSer, null)
        13 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.modalitySer, null)
        14 ->
          laterality =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.modalitySer, null)
        15 ->
          specimen =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.endpointSer, null)
        16 -> started = decoder.decodeStringElement(__desc, 16)
        17 -> _started = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.uidSer, null)
        18 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.performerSer, null)
        19 ->
          instance =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.instanceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Series: " + __i)
      }
    }
    return ImagingStudy.Series(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      uid = Id.of(uid, _uid)!!,
      number = UnsignedInt.of(number, _number),
      modality = modality!!,
      description = R4bString.of(description, _description),
      numberOfInstances = UnsignedInt.of(numberOfInstances, _numberOfInstances),
      endpoint = endpoint ?: listOf(),
      bodySite = bodySite,
      laterality = laterality,
      specimen = specimen ?: listOf(),
      started = DateTime.of(FhirDateTime.fromString(started), _started),
      performer = performer ?: listOf(),
      instance = instance ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImagingStudy.Series) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.uid.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.uid.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.uidSer, it)
    }
    ((value.number?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.uidSer, it)
    }
    (value.modality)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.modalitySer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.uidSer, it)
    }
    ((value.numberOfInstances?.value))?.let { encoder.encodeIntElement(__desc, 10, it) }
    (value.numberOfInstances?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.uidSer, it)
    }
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.endpointSer, value.endpoint)
    (value.bodySite)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.modalitySer, it) }
    (value.laterality)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.modalitySer, it)
    }
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.endpointSer, value.specimen)
    ((value.started?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.started?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.uidSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.performerSer, value.performer)
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.instanceSer, value.instance)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val uidSer: KSerializer<Element> = Element.serializer()

    public val modalitySer: KSerializer<Coding> = Coding.serializer()

    public val endpointSerInner: KSerializer<Reference> = Reference.serializer()

    public val endpointSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.endpointSerInner)

    public val performerSerInner: KSerializer<ImagingStudy.Series.Performer> =
      ImagingStudy.Series.Performer.serializer()

    public val performerSer: KSerializer<List<ImagingStudy.Series.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val instanceSerInner: KSerializer<ImagingStudy.Series.Instance> =
      ImagingStudy.Series.Instance.serializer()

    public val instanceSer: KSerializer<List<ImagingStudy.Series.Instance>> =
      ListSerializer(Hoisted.instanceSerInner)
  }
}

internal object ImagingStudySeriesPerformerSerializer : KSerializer<ImagingStudy.Series.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImagingStudy.Series.Performer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImagingStudy.Series.Performer {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + __i)
      }
    }
    return ImagingStudy.Series.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImagingStudy.Series.Performer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.functionSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ImagingStudySeriesInstanceSerializer : KSerializer<ImagingStudy.Series.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
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
      element("uid", KotlinString.serializer().descriptor, isOptional = true)
      element("_uid", Element.serializer().descriptor, isOptional = true)
      element("sopClass", Coding.serializer().descriptor, isOptional = true)
      element("number", Int.serializer().descriptor, isOptional = true)
      element("_number", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImagingStudy.Series.Instance =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series.Instance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImagingStudy.Series.Instance {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uid: KotlinString? = null
    var _uid: Element? = null
    var sopClass: Coding? = null
    var number: Int? = null
    var _number: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> uid = decoder.decodeStringElement(__desc, 3)
        4 -> _uid = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.uidSer, null)
        5 ->
          sopClass = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.sopClassSer, null)
        6 -> number = decoder.decodeIntElement(__desc, 6)
        7 -> _number = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.uidSer, null)
        8 -> title = decoder.decodeStringElement(__desc, 8)
        9 -> _title = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.uidSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + __i)
      }
    }
    return ImagingStudy.Series.Instance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      uid = Id.of(uid, _uid)!!,
      sopClass = sopClass!!,
      number = UnsignedInt.of(number, _number),
      title = R4bString.of(title, _title),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImagingStudy.Series.Instance) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.uid.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.uid.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.uidSer, it)
    }
    (value.sopClass)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.sopClassSer, it) }
    ((value.number?.value))?.let { encoder.encodeIntElement(__desc, 6, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.uidSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.uidSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val uidSer: KSerializer<Element> = Element.serializer()

    public val sopClassSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object ImagingStudySerializer : KSerializer<ImagingStudy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImagingStudy") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("modality", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("started", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_started", Element.serializer().descriptor, isOptional = true)
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("referrer", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "interpreter",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("numberOfSeries", Int.serializer().descriptor, isOptional = true)
    b.element("_numberOfSeries", Element.serializer().descriptor, isOptional = true)
    b.element("numberOfInstances", Int.serializer().descriptor, isOptional = true)
    b.element("_numberOfInstances", Element.serializer().descriptor, isOptional = true)
    b.element("procedureReference", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "procedureCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reasonCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reasonReference",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "series",
      listSerialDescriptor(lazyDescriptor { ImagingStudy.Series.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ImagingStudy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ImagingStudy")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ImagingStudy {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var modality: List<Coding>? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var started: KotlinString? = null
    var _started: Element? = null
    var basedOn: List<Reference>? = null
    var referrer: Reference? = null
    var interpreter: List<Reference>? = null
    var endpoint: List<Reference>? = null
    var numberOfSeries: Int? = null
    var _numberOfSeries: Element? = null
    var numberOfInstances: Int? = null
    var _numberOfInstances: Element? = null
    var procedureReference: Reference? = null
    var procedureCode: List<CodeableConcept>? = null
    var location: Reference? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var series: List<ImagingStudy.Series>? = null
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          modality =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.modalitySer, null)
        15 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.subjectSer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.subjectSer, null)
        17 -> started = decoder.decodeStringElement(__desc, 17)
        18 ->
          _started =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.basedOnSer, null)
        20 ->
          referrer = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.subjectSer, null)
        21 ->
          interpreter =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.basedOnSer, null)
        22 ->
          endpoint = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.basedOnSer, null)
        23 -> numberOfSeries = decoder.decodeIntElement(__desc, 23)
        24 ->
          _numberOfSeries =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> numberOfInstances = decoder.decodeIntElement(__desc, 25)
        26 ->
          _numberOfInstances =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          procedureReference =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.subjectSer, null)
        28 ->
          procedureCode =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.procedureCodeSer, null)
        29 ->
          location = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.subjectSer, null)
        30 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.procedureCodeSer, null)
        31 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.basedOnSer, null)
        32 -> note = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.noteSer, null)
        33 -> description = decoder.decodeStringElement(__desc, 33)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          series = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.seriesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ImagingStudy: " + __i)
      }
    }
    return ImagingStudy(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(ImagingStudy.ImagingStudyStatus.fromCode(status!!), _status),
      modality = modality ?: listOf(),
      subject = subject!!,
      encounter = encounter,
      started = DateTime.of(FhirDateTime.fromString(started), _started),
      basedOn = basedOn ?: listOf(),
      referrer = referrer,
      interpreter = interpreter ?: listOf(),
      endpoint = endpoint ?: listOf(),
      numberOfSeries = UnsignedInt.of(numberOfSeries, _numberOfSeries),
      numberOfInstances = UnsignedInt.of(numberOfInstances, _numberOfInstances),
      procedureReference = procedureReference,
      procedureCode = procedureCode ?: listOf(),
      location = location,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      description = R4bString.of(description, _description),
      series = series ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: ImagingStudy) {
    val __desc = descriptor
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.modality.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.modalitySer, value.modality)
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.subjectSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.subjectSer, it) }
    ((value.started?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.started?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.basedOnSer, value.basedOn)
    (value.referrer)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.subjectSer, it) }
    if (value.interpreter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.basedOnSer, value.interpreter)
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.basedOnSer, value.endpoint)
    ((value.numberOfSeries?.value))?.let { encoder.encodeIntElement(__desc, 23, it) }
    (value.numberOfSeries?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.numberOfInstances?.value))?.let { encoder.encodeIntElement(__desc, 25, it) }
    (value.numberOfInstances?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    (value.procedureReference)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.subjectSer, it)
    }
    if (value.procedureCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.procedureCodeSer, value.procedureCode)
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.subjectSer, it) }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.procedureCodeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.basedOnSer, value.reasonReference)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.noteSer, value.note)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.series.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.seriesSer, value.series)
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

    public val modalitySerInner: KSerializer<Coding> = Coding.serializer()

    public val modalitySer: KSerializer<List<Coding>> = ListSerializer(Hoisted.modalitySerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val procedureCodeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val procedureCodeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.procedureCodeSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val seriesSerInner: KSerializer<ImagingStudy.Series> = ImagingStudy.Series.serializer()

    public val seriesSer: KSerializer<List<ImagingStudy.Series>> =
      ListSerializer(Hoisted.seriesSerInner)
  }
}

internal object ImagingStudyPolymorphicSerializer : KSerializer<ImagingStudy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImagingStudy") { ImagingStudySerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy) {
    encoder.encodeStructure(descriptor) { ImagingStudySerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): ImagingStudy =
    decoder.decodeStructure(descriptor) { ImagingStudySerializer.deserializeJson(this) }
}
