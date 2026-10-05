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
      element("collector", Reference.serializer().descriptor, isOptional = true)
      element("collectedDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_collectedDateTime", Element.serializer().descriptor, isOptional = true)
      element("collectedPeriod", Period.serializer().descriptor, isOptional = true)
      element("duration", Duration.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "fastingStatusCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("fastingStatusDuration", Duration.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Specimen.Collection>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Collection =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Collection) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Specimen.Collection {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          collector =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        4 -> collectedDateTime = decoder.decodeStringElement(descriptor, i)
        5 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        7 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        9 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          fastingStatusCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          fastingStatusDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Collection: " + i)
      }
    }
    return Specimen.Collection(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      collector = collector,
      collected =
        Specimen.Collection.Collected.from(
          DateTime.of(collectedDateTime?.let { FhirDateTime.fromString(it) }, _collectedDateTime),
          collectedPeriod,
        ),
      duration = duration,
      quantity = quantity,
      method = method,
      bodySite = bodySite,
      fastingStatus =
        Specimen.Collection.FastingStatus.from(fastingStatusCodeableConcept, fastingStatusDuration),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Specimen.Collection) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.collector)?.let {
      encoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, it)
    }
    when (val choice = value.collected) {
      null -> {}
      is Specimen.Collection.Collected.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
        }
      }
      is Specimen.Collection.Collected.Period -> {
        encoder.encodeSerializableElement(descriptor, 6, PeriodSerializer, choice.value)
      }
    }
    (value.duration)?.let {
      encoder.encodeSerializableElement(descriptor, 7, DurationSerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, it)
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, it)
    }
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(descriptor, 10, CodeableConceptSerializer, it)
    }
    when (val choice = value.fastingStatus) {
      null -> {}
      is Specimen.Collection.FastingStatus.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 11, CodeableConceptSerializer, choice.value)
      }
      is Specimen.Collection.FastingStatus.Duration -> {
        encoder.encodeSerializableElement(descriptor, 12, DurationSerializer, choice.value)
      }
    }
  }
}

internal object SpecimenProcessingSerializer : KSerializer<Specimen.Processing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Processing") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("procedure", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "additive",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("timeDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timeDateTime", Element.serializer().descriptor, isOptional = true)
      element("timePeriod", Period.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Specimen.Processing>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Processing =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Processing) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Specimen.Processing {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          additive =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        7 -> timeDateTime = decoder.decodeStringElement(descriptor, i)
        8 ->
          _timeDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 ->
          timePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Processing: " + i)
      }
    }
    return Specimen.Processing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      procedure = procedure,
      additive = additive ?: listOf(),
      time =
        Specimen.Processing.Time.from(
          DateTime.of(timeDateTime?.let { FhirDateTime.fromString(it) }, _timeDateTime),
          timePeriod,
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Specimen.Processing) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.procedure)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    if (value.additive.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        ReferenceSerializer.listSerializer,
        value.additive,
      )
    when (val choice = value.time) {
      null -> {}
      is Specimen.Processing.Time.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
        }
      }
      is Specimen.Processing.Time.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
      }
    }
  }
}

internal object SpecimenContainerSerializer : KSerializer<Specimen.Container> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Container") {
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("capacity", Quantity.serializer().descriptor, isOptional = true)
      element("specimenQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("additiveCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("additiveReference", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Specimen.Container>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Specimen.Container =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Container) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Specimen.Container {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        4 -> description = decoder.decodeStringElement(descriptor, i)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          capacity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        8 ->
          specimenQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        9 ->
          additiveCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          additiveReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Container: " + i)
      }
    }
    return Specimen.Container(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Specimen.Container) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    (value.capacity)?.let {
      encoder.encodeSerializableElement(descriptor, 7, QuantitySerializer, it)
    }
    (value.specimenQuantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, it)
    }
    when (val choice = value.additive) {
      null -> {}
      is Specimen.Container.Additive.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, choice.value)
      }
      is Specimen.Container.Additive.Reference -> {
        encoder.encodeSerializableElement(descriptor, 10, ReferenceSerializer, choice.value)
      }
    }
  }
}

internal object SpecimenSerializer : KSerializer<Specimen> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specimen") {
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
    b.element("accessionIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("receivedTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_receivedTime", Element.serializer().descriptor, isOptional = true)
    b.element("parent", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("request", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "collection",
      lazyDescriptor { Specimen.Collection.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "processing",
      listSerialDescriptor(lazyDescriptor { Specimen.Processing.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "container",
      listSerialDescriptor(lazyDescriptor { Specimen.Container.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "condition",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Specimen =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Specimen")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
      status = Enumeration.of(status?.let { Specimen.SpecimenStatus.fromCode(it) }, _status),
      type = type,
      subject = subject,
      receivedTime = DateTime.of(receivedTime?.let { FhirDateTime.fromString(it) }, _receivedTime),
      parent = parent ?: listOf(),
      request = request ?: listOf(),
      collection = collection,
      processing = processing ?: listOf(),
      container = container ?: listOf(),
      condition = condition ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Specimen,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    (value.accessionIdentifier)?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, IdentifierSerializer, it)
    }
    ((value.status?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, ElementSerializer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, ReferenceSerializer, it)
    }
    ((value.receivedTime?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.receivedTime?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, ElementSerializer, it)
    }
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
    (value.collection)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        SpecimenCollectionSerializer,
        it,
      )
    }
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

internal object SpecimenPolymorphicSerializer : KSerializer<Specimen> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specimen") { SpecimenSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Specimen) {
    encoder.encodeStructure(descriptor) {
      SpecimenSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Specimen =
    decoder.decodeStructure(descriptor) {
      SpecimenSerializer.deserializeInternal(this, descriptor, 0)
    }
}
