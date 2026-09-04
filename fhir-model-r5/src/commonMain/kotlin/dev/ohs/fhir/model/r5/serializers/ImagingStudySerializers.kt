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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
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
      element("modality", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("numberOfInstances", Int.serializer().descriptor, isOptional = true)
      element("_numberOfInstances", Element.serializer().descriptor, isOptional = true)
      element(
        "endpoint",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("bodySite", CodeableReference.serializer().descriptor, isOptional = true)
      element("laterality", CodeableConcept.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImagingStudy.Series {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uid: KotlinString? = null
    var _uid: Element? = null
    var number: Int? = null
    var _number: Element? = null
    var modality: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var numberOfInstances: Int? = null
    var _numberOfInstances: Element? = null
    var endpoint: List<Reference>? = null
    var bodySite: CodeableReference? = null
    var laterality: CodeableConcept? = null
    var specimen: List<Reference>? = null
    var started: KotlinString? = null
    var _started: Element? = null
    var performer: List<ImagingStudy.Series.Performer>? = null
    var instance: List<ImagingStudy.Series.Instance>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> uid = decoder.decodeStringElement(descriptor, i)
        4 -> _uid = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        5 -> number = decoder.decodeIntElement(descriptor, i)
        6 ->
          _number = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        7 ->
          modality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySer, null)
        8 -> description = decoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        10 -> numberOfInstances = decoder.decodeIntElement(descriptor, i)
        11 ->
          _numberOfInstances =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        12 ->
          endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointSer, null)
        13 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bodySiteSer, null)
        14 ->
          laterality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySer, null)
        15 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointSer, null)
        16 -> started = decoder.decodeStringElement(descriptor, i)
        17 ->
          _started = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        18 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        19 ->
          instance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instanceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Series: " + i)
      }
    }
    return ImagingStudy.Series(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      uid =
        Id.of(uid, _uid)
          ?: throw SerializationException("Missing required property 'uid' on ImagingStudy.Series"),
      number = UnsignedInt.of(number, _number),
      modality =
        modality
          ?: throw SerializationException(
            "Missing required property 'modality' on ImagingStudy.Series"
          ),
      description = R5String.of(description, _description),
      numberOfInstances = UnsignedInt.of(numberOfInstances, _numberOfInstances),
      endpoint = endpoint ?: listOf(),
      bodySite = bodySite,
      laterality = laterality,
      specimen = specimen ?: listOf(),
      started = DateTime.of(started?.let { FhirDateTime.fromString(it) }, _started),
      performer = performer ?: listOf(),
      instance = instance ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ImagingStudy.Series) {
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
    ((value.uid.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.uid.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.uidSer, it)
    }
    ((value.number?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.uidSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 7, Hoisted.modalitySer, value.modality)
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.uidSer, it)
    }
    ((value.numberOfInstances?.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
    (value.numberOfInstances?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.uidSer, it)
    }
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.endpointSer, value.endpoint)
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.bodySiteSer, it)
    }
    (value.laterality)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.modalitySer, it)
    }
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.endpointSer, value.specimen)
    ((value.started?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 16, it) }
    (value.started?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.uidSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.performerSer, value.performer)
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.instanceSer, value.instance)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val uidSer: KSerializer<Element> = Element.serializer()

    public val modalitySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val endpointSerInner: KSerializer<Reference> = Reference.serializer()

    public val endpointSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.endpointSerInner)

    public val bodySiteSer: KSerializer<CodeableReference> = CodeableReference.serializer()

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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series.Performer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImagingStudy.Series.Performer {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.functionSer, null)
        4 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + i)
      }
    }
    return ImagingStudy.Series.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor =
        actor
          ?: throw SerializationException(
            "Missing required property 'actor' on ImagingStudy.Series.Performer"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ImagingStudy.Series.Performer) {
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
    (value.function)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.functionSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorSer, value.actor)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series.Instance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImagingStudy.Series.Instance {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> uid = decoder.decodeStringElement(descriptor, i)
        4 -> _uid = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        5 ->
          sopClass =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sopClassSer, null)
        6 -> number = decoder.decodeIntElement(descriptor, i)
        7 ->
          _number = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        8 -> title = decoder.decodeStringElement(descriptor, i)
        9 -> _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + i)
      }
    }
    return ImagingStudy.Series.Instance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      uid =
        Id.of(uid, _uid)
          ?: throw SerializationException(
            "Missing required property 'uid' on ImagingStudy.Series.Instance"
          ),
      sopClass =
        sopClass
          ?: throw SerializationException(
            "Missing required property 'sopClass' on ImagingStudy.Series.Instance"
          ),
      number = UnsignedInt.of(number, _number),
      title = R5String.of(title, _title),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ImagingStudy.Series.Instance) {
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
    ((value.uid.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.uid.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.uidSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.sopClassSer, value.sopClass)
    ((value.number?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.uidSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.uidSer, it)
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
    b.element(
      "modality",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("started", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_started", Element.serializer().descriptor, isOptional = true)
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("referrer", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("numberOfSeries", Int.serializer().descriptor, isOptional = true)
    b.element("_numberOfSeries", Element.serializer().descriptor, isOptional = true)
    b.element("numberOfInstances", Int.serializer().descriptor, isOptional = true)
    b.element("_numberOfInstances", Element.serializer().descriptor, isOptional = true)
    b.element(
      "procedure",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ImagingStudy")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ImagingStudy {
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
    var modality: List<CodeableConcept>? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var started: KotlinString? = null
    var _started: Element? = null
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var referrer: Reference? = null
    var endpoint: List<Reference>? = null
    var numberOfSeries: Int? = null
    var _numberOfSeries: Element? = null
    var numberOfInstances: Int? = null
    var _numberOfInstances: Element? = null
    var procedure: List<CodeableReference>? = null
    var location: Reference? = null
    var reason: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var series: List<ImagingStudy.Series>? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          modality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modalitySer, null)
        14 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        15 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        16 -> started = decoder.decodeStringElement(descriptor, i)
        17 ->
          _started =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        19 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        20 ->
          referrer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        21 ->
          endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        22 -> numberOfSeries = decoder.decodeIntElement(descriptor, i)
        23 ->
          _numberOfSeries =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> numberOfInstances = decoder.decodeIntElement(descriptor, i)
        25 ->
          _numberOfInstances =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 ->
          procedure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.procedureSer, null)
        27 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        28 ->
          reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.procedureSer, null)
        29 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        30 -> description = decoder.decodeStringElement(descriptor, i)
        31 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          series = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.seriesSer, null)
        else -> throw SerializationException("Unexpected index decoding ImagingStudy: " + i)
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
      status =
        Enumeration.of(status?.let { ImagingStudy.ImagingStudyStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on ImagingStudy"),
      modality = modality ?: listOf(),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on ImagingStudy"),
      encounter = encounter,
      started = DateTime.of(started?.let { FhirDateTime.fromString(it) }, _started),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      referrer = referrer,
      endpoint = endpoint ?: listOf(),
      numberOfSeries = UnsignedInt.of(numberOfSeries, _numberOfSeries),
      numberOfInstances = UnsignedInt.of(numberOfInstances, _numberOfInstances),
      procedure = procedure ?: listOf(),
      location = location,
      reason = reason ?: listOf(),
      note = note ?: listOf(),
      description = R5String.of(description, _description),
      series = series ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImagingStudy,
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
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.modality.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.modalitySer,
        value.modality,
      )
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      Hoisted.subjectSer,
      value.subject,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.subjectSer, it)
    }
    ((value.started?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.started?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.basedOnSer,
        value.partOf,
      )
    (value.referrer)?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.basedOnSer,
        value.endpoint,
      )
    ((value.numberOfSeries?.value))?.let {
      encoder.encodeIntElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.numberOfSeries?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.numberOfInstances?.value))?.let {
      encoder.encodeIntElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.numberOfInstances?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.procedureSer,
        value.procedure,
      )
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.procedureSer,
        value.reason,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.series.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.seriesSer,
        value.series,
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

    public val modalitySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modalitySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.modalitySerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val procedureSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val procedureSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.procedureSerInner)

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
    encoder.encodeStructure(descriptor) {
      ImagingStudySerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ImagingStudy =
    decoder.decodeStructure(descriptor) {
      ImagingStudySerializer.deserializeInternal(this, descriptor, 0)
    }
}
