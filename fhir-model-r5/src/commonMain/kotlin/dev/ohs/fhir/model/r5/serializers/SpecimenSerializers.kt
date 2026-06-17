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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SpecimenCombined
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

internal object SpecimenFeatureSerializer : KSerializer<Specimen.Feature> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Feature") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Specimen.Feature =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Feature) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Specimen.Feature {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> description = decoder.decodeStringElement(descriptor, i)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Feature: " + i)
      }
    }
    return Specimen.Feature(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      description = R5String.of(description, _description)!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Specimen.Feature) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    ((value.description.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val descriptionSer: KSerializer<Element> = Element.serializer()
  }
}

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
      element("device", CodeableReference.serializer().descriptor, isOptional = true)
      element("procedure", Reference.serializer().descriptor, isOptional = true)
      element("bodySite", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "fastingStatusCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("fastingStatusDuration", Duration.serializer().descriptor, isOptional = true)
    }

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
    var device: CodeableReference? = null
    var procedure: Reference? = null
    var bodySite: CodeableReference? = null
    var fastingStatusCodeableConcept: CodeableConcept? = null
    var fastingStatusDuration: Duration? = null
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
          collector =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.collectorSer, null)
        4 -> collectedDateTime = decoder.decodeStringElement(descriptor, i)
        5 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.collectedDateTimeSer,
              null,
            )
        6 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.collectedPeriodSer,
              null,
            )
        7 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.durationSer, null)
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        9 ->
          method = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        10 ->
          device = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        11 ->
          procedure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.collectorSer, null)
        12 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        13 ->
          fastingStatusCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        14 ->
          fastingStatusDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.durationSer, null)
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
          DateTime.of(FhirDateTime.fromString(collectedDateTime), _collectedDateTime),
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Specimen.Collection) {
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
    (value.collector)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.collectorSer, it)
    }
    when (val choice = value.collected) {
      null -> {}
      is Specimen.Collection.Collected.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.collectedDateTimeSer, it)
        }
      }
      is Specimen.Collection.Collected.Period -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.collectedPeriodSer, choice.value)
      }
    }
    (value.duration)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.durationSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.quantitySer, it)
    }
    (value.method)?.let { encoder.encodeSerializableElement(descriptor, 9, Hoisted.methodSer, it) }
    (value.device)?.let { encoder.encodeSerializableElement(descriptor, 10, Hoisted.deviceSer, it) }
    (value.procedure)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.collectorSer, it)
    }
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.deviceSer, it)
    }
    when (val choice = value.fastingStatus) {
      null -> {}
      is Specimen.Collection.FastingStatus.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 13, Hoisted.methodSer, choice.value)
      }
      is Specimen.Collection.FastingStatus.Duration -> {
        encoder.encodeSerializableElement(descriptor, 14, Hoisted.durationSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val collectorSer: KSerializer<Reference> = Reference.serializer()

    public val collectedDateTimeSer: KSerializer<Element> = Element.serializer()

    public val collectedPeriodSer: KSerializer<Period> = Period.serializer()

    public val durationSer: KSerializer<Duration> = Duration.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val methodSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val deviceSer: KSerializer<CodeableReference> = CodeableReference.serializer()
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
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "additive",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("timeDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timeDateTime", Element.serializer().descriptor, isOptional = true)
      element("timePeriod", Period.serializer().descriptor, isOptional = true)
    }

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
    var method: CodeableConcept? = null
    var additive: List<Reference>? = null
    var timeDateTime: KotlinString? = null
    var _timeDateTime: Element? = null
    var timePeriod: Period? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 ->
          method = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        6 ->
          additive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.additiveSer, null)
        7 -> timeDateTime = decoder.decodeStringElement(descriptor, i)
        8 ->
          _timeDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        9 ->
          timePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Processing: " + i)
      }
    }
    return Specimen.Processing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R5String.of(description, _description),
      method = method,
      additive = additive ?: listOf(),
      time =
        Specimen.Processing.Time.from(
          DateTime.of(FhirDateTime.fromString(timeDateTime), _timeDateTime),
          timePeriod,
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Specimen.Processing) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    (value.method)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.methodSer, it) }
    if (value.additive.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.additiveSer, value.additive)
    when (val choice = value.time) {
      null -> {}
      is Specimen.Processing.Time.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.descriptionSer, it)
        }
      }
      is Specimen.Processing.Time.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.timePeriodSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val methodSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val additiveSerInner: KSerializer<Reference> = Reference.serializer()

    public val additiveSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.additiveSerInner)

    public val timePeriodSer: KSerializer<Period> = Period.serializer()
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
      element("device", Reference.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("specimenQuantity", Quantity.serializer().descriptor, isOptional = true)
    }

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
    var device: Reference? = null
    var location: Reference? = null
    var specimenQuantity: Quantity? = null
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
          device = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        4 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        5 ->
          specimenQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.specimenQuantitySer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Container: " + i)
      }
    }
    return Specimen.Container(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      device = device!!,
      location = location,
      specimenQuantity = specimenQuantity,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Specimen.Container) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.deviceSer, value.device)
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.deviceSer, it)
    }
    (value.specimenQuantity)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.specimenQuantitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val deviceSer: KSerializer<Reference> = Reference.serializer()

    public val specimenQuantitySer: KSerializer<Quantity> = Quantity.serializer()
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
    b.element("combined", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_combined", Element.serializer().descriptor, isOptional = true)
    b.element(
      "role",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "feature",
      listSerialDescriptor(lazyDescriptor { Specimen.Feature.serializer().descriptor }),
      isOptional = true,
    )
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
          accessionIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        15 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        16 -> receivedTime = decoder.decodeStringElement(descriptor, i)
        17 ->
          _receivedTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          parent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parentSer, null)
        19 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parentSer, null)
        20 -> combined = decoder.decodeStringElement(descriptor, i)
        21 ->
          _combined =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        23 ->
          feature =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.featureSer, null)
        24 ->
          collection =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.collectionSer, null)
        25 ->
          processing =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processingSer, null)
        26 ->
          container =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containerSer, null)
        27 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        28 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
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
      status = status?.let { Enumeration.of(Specimen.SpecimenStatus.fromCode(it), _status) },
      type = type,
      subject = subject,
      receivedTime = DateTime.of(FhirDateTime.fromString(receivedTime), _receivedTime),
      parent = parent ?: listOf(),
      request = request ?: listOf(),
      combined = combined?.let { Enumeration.of(SpecimenCombined.fromCode(it), _combined) },
      role = role ?: listOf(),
      feature = feature ?: listOf(),
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
    (value.accessionIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.subjectSer, it)
    }
    ((value.receivedTime?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.receivedTime?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.parentSer,
        value.parent,
      )
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.parentSer,
        value.request,
      )
    ((value.combined?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.combined?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.role.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.roleSer,
        value.role,
      )
    if (value.feature.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.featureSer,
        value.feature,
      )
    (value.collection)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.collectionSer,
        it,
      )
    }
    if (value.processing.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.processingSer,
        value.processing,
      )
    if (value.container.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.containerSer,
        value.container,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.roleSer,
        value.condition,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val parentSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val roleSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val featureSerInner: KSerializer<Specimen.Feature> = Specimen.Feature.serializer()

    public val featureSer: KSerializer<List<Specimen.Feature>> =
      ListSerializer(Hoisted.featureSerInner)

    public val collectionSer: KSerializer<Specimen.Collection> = Specimen.Collection.serializer()

    public val processingSerInner: KSerializer<Specimen.Processing> =
      Specimen.Processing.serializer()

    public val processingSer: KSerializer<List<Specimen.Processing>> =
      ListSerializer(Hoisted.processingSerInner)

    public val containerSerInner: KSerializer<Specimen.Container> = Specimen.Container.serializer()

    public val containerSer: KSerializer<List<Specimen.Container>> =
      ListSerializer(Hoisted.containerSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
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
