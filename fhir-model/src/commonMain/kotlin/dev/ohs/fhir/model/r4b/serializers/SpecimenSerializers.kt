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
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Specimen
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

  override fun deserialize(decoder: Decoder): Specimen.Collection =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Specimen.Collection) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Specimen.Collection {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          collector =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.collectorSer, null)
        4 -> collectedDateTime = decoder.decodeStringElement(__desc, 4)
        5 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.collectedDateTimeSer, null)
        6 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.collectedPeriodSer, null)
        7 ->
          duration = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.durationSer, null)
        8 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.quantitySer, null)
        9 -> method = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.methodSer, null)
        10 ->
          bodySite = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.methodSer, null)
        11 ->
          fastingStatusCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.methodSer, null)
        12 ->
          fastingStatusDuration =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.durationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Collection: " + __i)
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
      bodySite = bodySite,
      fastingStatus =
        Specimen.Collection.FastingStatus.from(fastingStatusCodeableConcept, fastingStatusDuration),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Specimen.Collection) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.collector)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.collectorSer, it)
    }
    when (val __d = value.collected) {
      null -> {}
      is Specimen.Collection.Collected.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.collectedDateTimeSer, it)
        }
      }
      is Specimen.Collection.Collected.Period -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.collectedPeriodSer, __d.value)
      }
    }
    (value.duration)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.durationSer, it) }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.quantitySer, it) }
    (value.method)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.methodSer, it) }
    (value.bodySite)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.methodSer, it) }
    when (val __d = value.fastingStatus) {
      null -> {}
      is Specimen.Collection.FastingStatus.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.methodSer, __d.value)
      }
      is Specimen.Collection.FastingStatus.Duration -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.durationSer, __d.value)
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

  override fun deserialize(decoder: Decoder): Specimen.Processing =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Specimen.Processing) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Specimen.Processing {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 ->
          procedure =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.procedureSer, null)
        6 ->
          additive = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.additiveSer, null)
        7 -> timeDateTime = decoder.decodeStringElement(__desc, 7)
        8 ->
          _timeDateTime =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.descriptionSer, null)
        9 ->
          timePeriod =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.timePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Processing: " + __i)
      }
    }
    return Specimen.Processing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4bString.of(description, _description),
      procedure = procedure,
      additive = additive ?: listOf(),
      time =
        Specimen.Processing.Time.from(
          DateTime.of(FhirDateTime.fromString(timeDateTime), _timeDateTime),
          timePeriod,
        ),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Specimen.Processing) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    (value.procedure)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.procedureSer, it)
    }
    if (value.additive.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.additiveSer, value.additive)
    when (val __d = value.time) {
      null -> {}
      is Specimen.Processing.Time.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
        }
      }
      is Specimen.Processing.Time.Period -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.timePeriodSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val procedureSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

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

  override fun deserialize(decoder: Decoder): Specimen.Container =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Specimen.Container) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Specimen.Container {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 -> description = decoder.decodeStringElement(__desc, 4)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.descriptionSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          capacity = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.capacitySer, null)
        8 ->
          specimenQuantity =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.capacitySer, null)
        9 ->
          additiveCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.typeSer, null)
        10 ->
          additiveReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.additiveReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Container: " + __i)
      }
    }
    return Specimen.Container(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      description = R4bString.of(description, _description),
      type = type,
      capacity = capacity,
      specimenQuantity = specimenQuantity,
      additive = Specimen.Container.Additive.from(additiveCodeableConcept, additiveReference),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Specimen.Container) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, value.identifier)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.descriptionSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    (value.capacity)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.capacitySer, it) }
    (value.specimenQuantity)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.capacitySer, it)
    }
    when (val __d = value.additive) {
      null -> {}
      is Specimen.Container.Additive.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.typeSer, __d.value)
      }
      is Specimen.Container.Additive.Reference -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.additiveReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val capacitySer: KSerializer<Quantity> = Quantity.serializer()

    public val additiveReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object SpecimenCollectionCollectedSerializer : KSerializer<Specimen.Collection.Collected> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specimen.Collection.Collected") {
      element("collectedDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_collectedDateTime", Element.serializer().descriptor, isOptional = true)
      element("collectedPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Collection.Collected) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Specimen.Collection.Collected.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Specimen.Collection.Collected.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.collectedPeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Specimen.Collection.Collected =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Specimen.Collection.Collected {
    val __desc = descriptor
    var collectedDateTime: KotlinString? = null
    var _collectedDateTime: Element? = null
    var collectedPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> collectedDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.collectedPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Specimen.Collection.Collected: " + __i
          )
      }
    }
    return Specimen.Collection.Collected.from(
      DateTime.of(FhirDateTime.fromString(collectedDateTime), _collectedDateTime),
      collectedPeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val collectedPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object SpecimenCollectionFastingStatusSerializer :
  KSerializer<Specimen.Collection.FastingStatus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specimen.Collection.FastingStatus") {
      element(
        "fastingStatusCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("fastingStatusDuration", Duration.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Collection.FastingStatus) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Specimen.Collection.FastingStatus.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.fastingStatusCodeableConceptSer, __d.value)
        }
        is Specimen.Collection.FastingStatus.Duration -> {
          encodeSerializableElement(__desc, 1, Hoisted.fastingStatusDurationSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Specimen.Collection.FastingStatus =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Specimen.Collection.FastingStatus {
    val __desc = descriptor
    var fastingStatusCodeableConcept: CodeableConcept? = null
    var fastingStatusDuration: Duration? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          fastingStatusCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.fastingStatusCodeableConceptSer,
              null,
            )
        1 ->
          fastingStatusDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.fastingStatusDurationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Specimen.Collection.FastingStatus: " + __i
          )
      }
    }
    return Specimen.Collection.FastingStatus.from(
      fastingStatusCodeableConcept,
      fastingStatusDuration,
    )!!
  }

  private object Hoisted {
    public val fastingStatusCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val fastingStatusDurationSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object SpecimenProcessingTimeSerializer : KSerializer<Specimen.Processing.Time> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specimen.Processing.Time") {
      element("timeDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timeDateTime", Element.serializer().descriptor, isOptional = true)
      element("timePeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Processing.Time) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Specimen.Processing.Time.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Specimen.Processing.Time.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.timePeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Specimen.Processing.Time =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Specimen.Processing.Time {
    val __desc = descriptor
    var timeDateTime: KotlinString? = null
    var _timeDateTime: Element? = null
    var timePeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> timeDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _timeDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          timePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.timePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding Specimen.Processing.Time: " + __i)
      }
    }
    return Specimen.Processing.Time.from(
      DateTime.of(FhirDateTime.fromString(timeDateTime), _timeDateTime),
      timePeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val timePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object SpecimenContainerAdditiveSerializer : KSerializer<Specimen.Container.Additive> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specimen.Container.Additive") {
      element("additiveCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("additiveReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Specimen.Container.Additive) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Specimen.Container.Additive.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.additiveCodeableConceptSer, __d.value)
        }
        is Specimen.Container.Additive.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.additiveReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Specimen.Container.Additive =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Specimen.Container.Additive {
    val __desc = descriptor
    var additiveCodeableConcept: CodeableConcept? = null
    var additiveReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          additiveCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.additiveCodeableConceptSer,
              null,
            )
        1 ->
          additiveReference =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.additiveReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Specimen.Container.Additive: " + __i
          )
      }
    }
    return Specimen.Container.Additive.from(additiveCodeableConcept, additiveReference)!!
  }

  private object Hoisted {
    public val additiveCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val additiveReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object SpecimenSerializer : KSerializer<Specimen> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specimen") {
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
      element("accessionIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("receivedTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_receivedTime", Element.serializer().descriptor, isOptional = true)
      element("parent", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("request", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "collection",
        lazyDescriptor { Specimen.Collection.serializer().descriptor },
        isOptional = true,
      )
      element(
        "processing",
        listSerialDescriptor(lazyDescriptor { Specimen.Processing.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "container",
        listSerialDescriptor(lazyDescriptor { Specimen.Container.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "condition",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Specimen =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Specimen) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Specimen {
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
          accessionIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.identifierSerInner, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> type = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.typeSer, null)
        16 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.subjectSer, null)
        17 -> receivedTime = decoder.decodeStringElement(__desc, 17)
        18 ->
          _receivedTime =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          parent = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.parentSer, null)
        20 ->
          request = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.parentSer, null)
        21 ->
          collection =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.collectionSer, null)
        22 ->
          processing =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.processingSer, null)
        23 ->
          container =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.containerSer, null)
        24 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.conditionSer, null)
        25 -> note = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Specimen: " + __i)
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
      collection = collection,
      processing = processing ?: listOf(),
      container = container ?: listOf(),
      condition = condition ?: listOf(),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Specimen) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Specimen")
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
    (value.accessionIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.identifierSerInner, it)
    }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.typeSer, it) }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.subjectSer, it) }
    ((value.receivedTime?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.receivedTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.parentSer, value.parent)
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.parentSer, value.request)
    (value.collection)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.collectionSer, it)
    }
    if (value.processing.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.processingSer, value.processing)
    if (value.container.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.containerSer, value.container)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.conditionSer, value.condition)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.noteSer, value.note)
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

    public val collectionSer: KSerializer<Specimen.Collection> = Specimen.Collection.serializer()

    public val processingSerInner: KSerializer<Specimen.Processing> =
      Specimen.Processing.serializer()

    public val processingSer: KSerializer<List<Specimen.Processing>> =
      ListSerializer(Hoisted.processingSerInner)

    public val containerSerInner: KSerializer<Specimen.Container> = Specimen.Container.serializer()

    public val containerSer: KSerializer<List<Specimen.Container>> =
      ListSerializer(Hoisted.containerSerInner)

    public val conditionSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
