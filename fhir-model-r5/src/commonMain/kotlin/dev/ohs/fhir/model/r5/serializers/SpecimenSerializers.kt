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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SpecimenCombined
import dev.ohs.fhir.model.r5.terminologies.SpecimenStatus
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

internal object SpecimenFeatureSerializer : KSerializer<Specimen.Feature> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Feature") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Specimen.Feature>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Feature {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Feature: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Specimen.Feature(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException("Missing required property 'type' on Specimen.Feature"),
      description =
        R5String.of(description, _description)
          ?: throw SerializationException(
            "Missing required property 'description' on Specimen.Feature"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Specimen.Feature) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.description.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.description)
    compositeEncoder.endStructure(descriptor)
  }
}

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
      optionalElement("device", CodeableReferenceSerializer.descriptor)
      optionalElement("procedure", ReferenceSerializer.descriptor)
      optionalElement("bodySite", CodeableReferenceSerializer.descriptor)
      optionalElement("fastingStatusCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("fastingStatusDuration", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Specimen.Collection>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Collection {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var device: CodeableReference? = null
    var procedure: Reference? = null
    var bodySite: CodeableReference? = null
    var fastingStatusCodeableConcept: CodeableConcept? = null
    var fastingStatusDuration: Duration? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          collector =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> collectedDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _collectedDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          collectedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        7 ->
          duration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        8 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        9 ->
          method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        11 ->
          procedure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        12 ->
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        13 ->
          fastingStatusCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          fastingStatusDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Collection: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Specimen.Collection(
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
      device = device,
      procedure = procedure,
      bodySite = bodySite,
      fastingStatus =
        Specimen.Collection.FastingStatus.from(fastingStatusCodeableConcept, fastingStatusDuration),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Specimen.Collection) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      ReferenceSerializer,
      value.collector,
    )
    when (val choice = value.collected) {
      null -> {}
      is Specimen.Collection.Collected.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 4, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is Specimen.Collection.Collected.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, PeriodSerializer, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, DurationSerializer, value.duration)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.method,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      CodeableReferenceSerializer,
      value.device,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      ReferenceSerializer,
      value.procedure,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      CodeableReferenceSerializer,
      value.bodySite,
    )
    when (val choice = value.fastingStatus) {
      null -> {}
      is Specimen.Collection.FastingStatus.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          13,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Specimen.Collection.FastingStatus.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 14, DurationSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
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
      optionalElement("method", CodeableConceptSerializer.descriptor)
      optionalElement("additive", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("timeDateTime", KotlinString.serializer().descriptor)
      optionalElement("_timeDateTime", ElementSerializer.descriptor)
      optionalElement("timePeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Specimen.Processing>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Processing {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var method: CodeableConcept? = null
    var additive: List<Reference>? = null
    var timeDateTime: KotlinString? = null
    var _timeDateTime: Element? = null
    var timePeriod: Period? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          additive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        7 -> timeDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _timeDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          timePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Processing: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Specimen.Processing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R5String.of(description, _description),
      method = method,
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.method,
    )
    if (value.additive.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        ReferenceSerializer.listSerializer,
        value.additive,
      )
    when (val choice = value.time) {
      null -> {}
      is Specimen.Processing.Time.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 7, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is Specimen.Processing.Time.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SpecimenContainerSerializer : KSerializer<Specimen.Container> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Container") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("device", ReferenceSerializer.descriptor)
      optionalElement("location", ReferenceSerializer.descriptor)
      optionalElement("specimenQuantity", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Specimen.Container>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Container {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var device: Reference? = null
    var location: Reference? = null
    var specimenQuantity: Quantity? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 ->
          specimenQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Container: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Specimen.Container(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      device =
        device
          ?: throw SerializationException(
            "Missing required property 'device' on Specimen.Container"
          ),
      location = location,
      specimenQuantity = specimenQuantity,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Specimen.Container) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.device)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.location)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      QuantitySerializer,
      value.specimenQuantity,
    )
    compositeEncoder.endStructure(descriptor)
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
    b.optionalElement("combined", KotlinString.serializer().descriptor)
    b.optionalElement("_combined", ElementSerializer.descriptor)
    b.optionalElement("role", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("feature", SpecimenFeatureSerializer.listSerializer.descriptor)
    b.optionalElement("collection", SpecimenCollectionSerializer.descriptor)
    b.optionalElement("processing", SpecimenProcessingSerializer.listSerializer.descriptor)
    b.optionalElement("container", SpecimenContainerSerializer.listSerializer.descriptor)
    b.optionalElement("condition", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var combined: KotlinString? = null
    var _combined: Element? = null
    var role: List<CodeableConcept>? = null
    var feature: List<Specimen.Feature>? = null
    var collection: Specimen.Collection? = null
    var processing: List<Specimen.Processing>? = null
    var container: List<Specimen.Container>? = null
    var condition: List<CodeableConcept>? = null
    var note: List<Annotation>? = null
    while (true) {
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          accessionIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        12 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 -> receivedTime = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _receivedTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          parent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          request =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 -> combined = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _combined =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        23 ->
          feature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenFeatureSerializer.listSerializer,
              null,
            )
        24 ->
          collection =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenCollectionSerializer,
              null,
            )
        25 ->
          processing =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenProcessingSerializer.listSerializer,
              null,
            )
        26 ->
          container =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenContainerSerializer.listSerializer,
              null,
            )
        27 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        28 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
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
        Enumeration.of(if (status != null) SpecimenStatus.fromCode(status) else null, _status),
      type = type,
      subject = subject,
      receivedTime =
        DateTime.of(
          if (receivedTime != null) FhirDateTime.fromString(receivedTime) else null,
          _receivedTime,
        ),
      parent = parent ?: listOf(),
      request = request ?: listOf(),
      combined =
        Enumeration.of(
          if (combined != null) SpecimenCombined.fromCode(combined) else null,
          _combined,
        ),
      role = role ?: listOf(),
      feature = feature ?: listOf(),
      collection = collection,
      processing = processing ?: listOf(),
      container = container ?: listOf(),
      condition = condition ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Specimen,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      IdentifierSerializer,
      value.accessionIdentifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.status?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.receivedTime?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.receivedTime)
    if (value.parent.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.parent,
      )
    if (value.request.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.request,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.combined?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.combined)
    if (value.role.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.role,
      )
    if (value.feature.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        SpecimenFeatureSerializer.listSerializer,
        value.feature,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      SpecimenCollectionSerializer,
      value.collection,
    )
    if (value.processing.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        SpecimenProcessingSerializer.listSerializer,
        value.processing,
      )
    if (value.container.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        SpecimenContainerSerializer.listSerializer,
        value.container,
      )
    if (value.condition.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.condition,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
