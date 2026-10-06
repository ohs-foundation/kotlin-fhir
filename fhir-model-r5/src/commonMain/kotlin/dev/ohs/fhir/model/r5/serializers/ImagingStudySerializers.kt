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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("uid", KotlinString.serializer().descriptor)
      optionalElement("_uid", ElementSerializer.descriptor)
      optionalElement("number", Int.serializer().descriptor)
      optionalElement("_number", ElementSerializer.descriptor)
      optionalElement("modality", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("numberOfInstances", Int.serializer().descriptor)
      optionalElement("_numberOfInstances", ElementSerializer.descriptor)
      optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("bodySite", CodeableReferenceSerializer.descriptor)
      optionalElement("laterality", CodeableConceptSerializer.descriptor)
      optionalElement("specimen", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("started", KotlinString.serializer().descriptor)
      optionalElement("_started", ElementSerializer.descriptor)
      optionalElement("performer", ImagingStudySeriesPerformerSerializer.listSerializer.descriptor)
      optionalElement("instance", ImagingStudySeriesInstanceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImagingStudy.Series>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImagingStudy.Series =
    decoder.decodeStructure(descriptor) {
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
          3 -> uid = decodeStringElement(descriptor, i)
          4 -> _uid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> number = decodeIntElement(descriptor, i)
          6 -> _number = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            modality =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 -> description = decodeStringElement(descriptor, i)
          9 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> numberOfInstances = decodeIntElement(descriptor, i)
          11 ->
            _numberOfInstances =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            endpoint =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          13 ->
            bodySite =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          14 ->
            laterality =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          15 ->
            specimen =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          16 -> started = decodeStringElement(descriptor, i)
          17 -> _started = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 ->
            performer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImagingStudySeriesPerformerSerializer.listSerializer,
                null,
              )
          19 ->
            instance =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImagingStudySeriesInstanceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Series: " + i)
        }
      }
      ImagingStudy.Series(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        uid =
          Id.of(uid, _uid)
            ?: throw SerializationException(
              "Missing required property 'uid' on ImagingStudy.Series"
            ),
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
        started =
          DateTime.of(if (started != null) FhirDateTime.fromString(started) else null, _started),
        performer = performer ?: listOf(),
        instance = instance ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series) {
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
      encodeStringIfNotNull(descriptor, 3, value.uid.value)
      encodeElementIfNotNull(descriptor, 4, value.uid)
      encodeIntIfNotNull(descriptor, 5, value.number?.value)
      encodeElementIfNotNull(descriptor, 6, value.number)
      encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, value.modality)
      encodeStringIfNotNull(descriptor, 8, value.description?.value)
      encodeElementIfNotNull(descriptor, 9, value.description)
      encodeIntIfNotNull(descriptor, 10, value.numberOfInstances?.value)
      encodeElementIfNotNull(descriptor, 11, value.numberOfInstances)
      if (value.endpoint.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          ReferenceSerializer.listSerializer,
          value.endpoint,
        )
      encodeSerializableIfNotNull(descriptor, 13, CodeableReferenceSerializer, value.bodySite)
      encodeSerializableIfNotNull(descriptor, 14, CodeableConceptSerializer, value.laterality)
      if (value.specimen.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          ReferenceSerializer.listSerializer,
          value.specimen,
        )
      encodeStringIfNotNull(descriptor, 16, value.started?.value?.toString())
      encodeElementIfNotNull(descriptor, 17, value.started)
      if (value.performer.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          ImagingStudySeriesPerformerSerializer.listSerializer,
          value.performer,
        )
      if (value.instance.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          19,
          ImagingStudySeriesInstanceSerializer.listSerializer,
          value.instance,
        )
    }
  }
}

internal object ImagingStudySeriesPerformerSerializer : KSerializer<ImagingStudy.Series.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImagingStudy.Series.Performer>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImagingStudy.Series.Performer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var function: CodeableConcept? = null
      var actor: Reference? = null
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
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Performer: " + i)
        }
      }
      ImagingStudy.Series.Performer(
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

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series.Performer) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.function)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object ImagingStudySeriesInstanceSerializer : KSerializer<ImagingStudy.Series.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("uid", KotlinString.serializer().descriptor)
      optionalElement("_uid", ElementSerializer.descriptor)
      optionalElement("sopClass", CodingSerializer.descriptor)
      optionalElement("number", Int.serializer().descriptor)
      optionalElement("_number", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImagingStudy.Series.Instance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImagingStudy.Series.Instance =
    decoder.decodeStructure(descriptor) {
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
          3 -> uid = decodeStringElement(descriptor, i)
          4 -> _uid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> sopClass = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          6 -> number = decodeIntElement(descriptor, i)
          7 -> _number = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> title = decodeStringElement(descriptor, i)
          9 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Instance: " + i)
        }
      }
      ImagingStudy.Series.Instance(
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

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series.Instance) {
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
      encodeStringIfNotNull(descriptor, 3, value.uid.value)
      encodeElementIfNotNull(descriptor, 4, value.uid)
      encodeSerializableElement(descriptor, 5, CodingSerializer, value.sopClass)
      encodeIntIfNotNull(descriptor, 6, value.number?.value)
      encodeElementIfNotNull(descriptor, 7, value.number)
      encodeStringIfNotNull(descriptor, 8, value.title?.value)
      encodeElementIfNotNull(descriptor, 9, value.title)
    }
  }
}

internal object ImagingStudySerializer : FhirResourceSerializer<ImagingStudy> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ImagingStudy")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("modality", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("started", KotlinString.serializer().descriptor)
    b.optionalElement("_started", ElementSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("referrer", ReferenceSerializer.descriptor)
    b.optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("numberOfSeries", Int.serializer().descriptor)
    b.optionalElement("_numberOfSeries", ElementSerializer.descriptor)
    b.optionalElement("numberOfInstances", Int.serializer().descriptor)
    b.optionalElement("_numberOfInstances", ElementSerializer.descriptor)
    b.optionalElement("procedure", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("series", ImagingStudySeriesSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          modality =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        15 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 -> started = decoder.decodeStringElement(descriptor, i)
        17 ->
          _started =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          referrer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 ->
          endpoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 -> numberOfSeries = decoder.decodeIntElement(descriptor, i)
        23 ->
          _numberOfSeries =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> numberOfInstances = decoder.decodeIntElement(descriptor, i)
        25 ->
          _numberOfInstances =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        29 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        30 -> description = decoder.decodeStringElement(descriptor, i)
        31 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          series =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImagingStudySeriesSerializer.listSerializer,
              null,
            )
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
        Enumeration.of(
          if (status != null) ImagingStudy.ImagingStudyStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on ImagingStudy"),
      modality = modality ?: listOf(),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on ImagingStudy"),
      encounter = encounter,
      started =
        DateTime.of(if (started != null) FhirDateTime.fromString(started) else null, _started),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImagingStudy,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.modality.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.modality,
      )
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.started?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.started)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.referrer,
    )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.endpoint,
      )
    encoder.encodeIntIfNotNull(descriptor, 22 + descriptorOffset, value.numberOfSeries?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.numberOfSeries)
    encoder.encodeIntIfNotNull(descriptor, 24 + descriptorOffset, value.numberOfInstances?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.numberOfInstances)
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.procedure,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.description)
    if (value.series.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ImagingStudySeriesSerializer.listSerializer,
        value.series,
      )
  }
}
