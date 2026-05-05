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
import dev.ohs.fhir.model.r4.Specimen
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          collector =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.collectorSer, null)
        4 -> collectedDateTime = decoder.decodeStringElement(__desc, __i)
        5 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.collectedDateTimeSer,
              null,
            )
        6 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.collectedPeriodSer, null)
        7 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.durationSer, null)
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        9 ->
          method = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.methodSer, null)
        10 ->
          bodySite = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.methodSer, null)
        11 ->
          fastingStatusCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.methodSer, null)
        12 ->
          fastingStatusDuration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.durationSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, __i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        5 ->
          procedure =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.procedureSer, null)
        6 ->
          additive =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.additiveSer, null)
        7 -> timeDateTime = decoder.decodeStringElement(__desc, __i)
        8 ->
          _timeDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        9 ->
          timePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.timePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Processing: " + __i)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        4 -> description = decoder.decodeStringElement(__desc, __i)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        7 ->
          capacity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.capacitySer, null)
        8 ->
          specimenQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.capacitySer, null)
        9 ->
          additiveCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        10 ->
          additiveReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
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
      description = R4String.of(description, _description),
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Specimen) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Specimen")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Specimen {
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
          accessionIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSerInner, null)
        12 -> status = decoder.decodeStringElement(__desc, __i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        15 ->
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        16 -> receivedTime = decoder.decodeStringElement(__desc, __i)
        17 ->
          _receivedTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 ->
          parent = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parentSer, null)
        19 ->
          request = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parentSer, null)
        20 ->
          collection =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.collectionSer, null)
        21 ->
          processing =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.processingSer, null)
        22 ->
          container =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containerSer, null)
        23 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conditionSer, null)
        24 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Specimen,
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
    (value.accessionIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.identifierSerInner, it)
    }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.typeSer, it) }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.subjectSer, it)
    }
    ((value.receivedTime?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 16 + __off, it)
    }
    (value.receivedTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.parentSer, value.parent)
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.parentSer, value.request)
    (value.collection)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.collectionSer, it)
    }
    if (value.processing.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.processingSer, value.processing)
    if (value.container.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.containerSer, value.container)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.conditionSer, value.condition)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.noteSer, value.note)
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

internal object SpecimenPolymorphicSerializer : KSerializer<Specimen> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specimen") { SpecimenSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Specimen) {
    encoder.encodeStructure(descriptor) {
      SpecimenSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Specimen =
    decoder.decodeStructure(descriptor) { SpecimenSerializer.deserializeJson(this, descriptor, 0) }
}
