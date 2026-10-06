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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Specimen
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object SpecimenCollectionSerializer : KSerializer<Specimen.Collection> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Collection") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("collector", ReferenceSerializer.descriptor)
      optionalElement("collectedDateTime", KotlinString.serializer().descriptor)
      optionalElement("_collectedDateTime", ElementSerializer.descriptor)
      optionalElement("collectedPeriod", PeriodSerializer.descriptor)
      optionalElement("duration", DurationSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.descriptor)
      optionalElement("bodySite", CodeableConceptSerializer.descriptor)
      optionalElement("fastingStatusCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("fastingStatusDuration", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Specimen.Collection>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Collection =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var collector: Reference? = null
      var collectedDateTime: KotlinString? = null
      var _collectedDateTime: Element? = null
      var collectedPeriod: Period? = null
      var duration: Duration? = null
      var quantity: Quantity? = null
      var method: CodeableConcept? = null
      var bodySite: CodeableConcept? = null
      var fastingStatusCodeableConcept: CodeableConcept? = null
      var fastingStatusDuration: Duration? = null
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
            collector = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> collectedDateTime = decodeStringElement(descriptor, i)
          5 ->
            _collectedDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            collectedPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          7 -> duration = decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          8 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 ->
            method =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            bodySite =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          11 ->
            fastingStatusCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            fastingStatusDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Collection: " + i)
        }
      }
      Specimen.Collection(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        collector = collector,
        collected =
          Specimen.Collection.Collected.from(
            DateTime.of(
              if (collectedDateTime != null) FhirDateTime.fromString(collectedDateTime) else null,
              _collectedDateTime,
            ),
            collectedPeriod,
          ),
        duration = duration,
        quantity = quantity,
        method = method,
        bodySite = bodySite,
        fastingStatus =
          Specimen.Collection.FastingStatus.from(
            fastingStatusCodeableConcept,
            fastingStatusDuration,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Collection) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.collector)
      when (val choice = value.collected) {
        null -> {}
        is Specimen.Collection.Collected.DateTime -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is Specimen.Collection.Collected.Period -> {
          encodeSerializableElement(descriptor, 6, PeriodSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 7, DurationSerializer, value.duration)
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.method)
      encodeSerializableIfNotNull(descriptor, 10, CodeableConceptSerializer, value.bodySite)
      when (val choice = value.fastingStatus) {
        null -> {}
        is Specimen.Collection.FastingStatus.CodeableConcept -> {
          encodeSerializableElement(descriptor, 11, CodeableConceptSerializer, choice.value)
        }
        is Specimen.Collection.FastingStatus.Duration -> {
          encodeSerializableElement(descriptor, 12, DurationSerializer, choice.value)
        }
      }
    }
  }
}

internal object SpecimenProcessingSerializer : KSerializer<Specimen.Processing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Processing") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("procedure", CodeableConceptSerializer.descriptor)
      optionalElement("additive", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("timeDateTime", KotlinString.serializer().descriptor)
      optionalElement("_timeDateTime", ElementSerializer.descriptor)
      optionalElement("timePeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Specimen.Processing>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Processing =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var procedure: CodeableConcept? = null
      var additive: List<Reference>? = null
      var timeDateTime: KotlinString? = null
      var _timeDateTime: Element? = null
      var timePeriod: Period? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            procedure =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            additive =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          7 -> timeDateTime = decodeStringElement(descriptor, i)
          8 ->
            _timeDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> timePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Processing: " + i)
        }
      }
      Specimen.Processing(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4String.of(description, _description),
        procedure = procedure,
        additive = additive ?: listOf(),
        time =
          Specimen.Processing.Time.from(
            DateTime.of(
              if (timeDateTime != null) FhirDateTime.fromString(timeDateTime) else null,
              _timeDateTime,
            ),
            timePeriod,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Processing) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.procedure)
      if (value.additive.isNotEmpty())
        encodeSerializableElement(descriptor, 6, ReferenceSerializer.listSerializer, value.additive)
      when (val choice = value.time) {
        null -> {}
        is Specimen.Processing.Time.DateTime -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Specimen.Processing.Time.Period -> {
          encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
        }
      }
    }
  }
}

internal object SpecimenContainerSerializer : KSerializer<Specimen.Container> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Container") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("capacity", QuantitySerializer.descriptor)
      optionalElement("specimenQuantity", QuantitySerializer.descriptor)
      optionalElement("additiveCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("additiveReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Specimen.Container>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Container =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: List<Identifier>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var type: CodeableConcept? = null
      var capacity: Quantity? = null
      var specimenQuantity: Quantity? = null
      var additiveCodeableConcept: CodeableConcept? = null
      var additiveReference: Reference? = null
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
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 -> description = decodeStringElement(descriptor, i)
          5 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> capacity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          8 ->
            specimenQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 ->
            additiveCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            additiveReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Container: " + i)
        }
      }
      Specimen.Container(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        description = R4String.of(description, _description),
        type = type,
        capacity = capacity,
        specimenQuantity = specimenQuantity,
        additive = Specimen.Container.Additive.from(additiveCodeableConcept, additiveReference),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Container) {
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
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      encodeStringIfNotNull(descriptor, 4, value.description?.value)
      encodeElementIfNotNull(descriptor, 5, value.description)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.capacity)
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.specimenQuantity)
      when (val choice = value.additive) {
        null -> {}
        is Specimen.Container.Additive.CodeableConcept -> {
          encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, choice.value)
        }
        is Specimen.Container.Additive.Reference -> {
          encodeSerializableElement(descriptor, 10, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object SpecimenSerializer : FhirResourceSerializer<Specimen> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Specimen")

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
    b.optionalElement("accessionIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("receivedTime", KotlinString.serializer().descriptor)
    b.optionalElement("_receivedTime", ElementSerializer.descriptor)
    b.optionalElement("parent", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("collection", SpecimenCollectionSerializer.descriptor)
    b.optionalElement("processing", SpecimenProcessingSerializer.listSerializer.descriptor)
    b.optionalElement("container", SpecimenContainerSerializer.listSerializer.descriptor)
    b.optionalElement("condition", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Specimen {
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
    var accessionIdentifier: Identifier? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var subject: Reference? = null
    var receivedTime: KotlinString? = null
    var _receivedTime: Element? = null
    var parent: List<Reference>? = null
    var request: List<Reference>? = null
    var collection: Specimen.Collection? = null
    var processing: List<Specimen.Processing>? = null
    var container: List<Specimen.Container>? = null
    var condition: List<CodeableConcept>? = null
    var note: List<Annotation>? = null
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
        11 ->
          accessionIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 -> receivedTime = decoder.decodeStringElement(descriptor, i)
        17 ->
          _receivedTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          parent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          request =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          collection =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenCollectionSerializer,
              null,
            )
        21 ->
          processing =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenProcessingSerializer.listSerializer,
              null,
            )
        22 ->
          container =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenContainerSerializer.listSerializer,
              null,
            )
        23 ->
          condition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        24 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Specimen: " + i)
      }
    }
    return Specimen(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      accessionIdentifier = accessionIdentifier,
      status =
        Enumeration.of(
          if (status != null) Specimen.SpecimenStatus.fromCode(status) else null,
          _status,
        ),
      type = type,
      subject = subject,
      receivedTime =
        DateTime.of(
          if (receivedTime != null) FhirDateTime.fromString(receivedTime) else null,
          _receivedTime,
        ),
      parent = parent ?: listOf(),
      request = request ?: listOf(),
      collection = collection,
      processing = processing ?: listOf(),
      container = container ?: listOf(),
      condition = condition ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Specimen,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      IdentifierSerializer,
      value.accessionIdentifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.receivedTime?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.receivedTime)
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.parent,
      )
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.request,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      SpecimenCollectionSerializer,
      value.collection,
    )
    if (value.processing.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        SpecimenProcessingSerializer.listSerializer,
        value.processing,
      )
    if (value.container.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        SpecimenContainerSerializer.listSerializer,
        value.container,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.condition,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
