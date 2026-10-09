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
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.Specimen
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SpecimenStatus
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object SpecimenCollectionSerializer : FhirSerializer<Specimen.Collection> {
  override val descriptor: SerialDescriptor = buildDescriptor("Collection", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Specimen.Collection>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("collector", ReferenceSerializer.descriptor)
    b.strPrim("collectedDateTime")
    b.optionalElement("collectedPeriod", PeriodSerializer.descriptor)
    b.optionalElement("duration", DurationSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.descriptor)
    b.optionalElement("fastingStatusCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("fastingStatusDuration", DurationSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Specimen.Collection {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var collector: Reference? = null
    var collectedDateTime: FhirDateTime? = null
    var _collectedDateTime: Element? = null
    var collectedPeriod: Period? = null
    var duration: Duration? = null
    var quantity: Quantity? = null
    var method: CodeableConcept? = null
    var bodySite: CodeableConcept? = null
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
        4 ->
          collectedDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          fastingStatusCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          fastingStatusDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Specimen.Collection(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      collector = collector,
      collected =
        Specimen.Collection.Collected.from(
          DateTime.of(collectedDateTime, _collectedDateTime),
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

  override fun serialize(encoder: Encoder, `value`: Specimen.Collection) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
      CodeableConceptSerializer,
      value.bodySite,
    )
    when (val choice = value.fastingStatus) {
      null -> {}
      is Specimen.Collection.FastingStatus.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Specimen.Collection.FastingStatus.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 12, DurationSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SpecimenProcessingSerializer : FhirSerializer<Specimen.Processing> {
  override val descriptor: SerialDescriptor = buildDescriptor("Processing", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Specimen.Processing>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("procedure", CodeableConceptSerializer.descriptor)
    b.optionalElement("additive", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("timeDateTime")
    b.optionalElement("timePeriod", PeriodSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Specimen.Processing {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var procedure: CodeableConcept? = null
    var additive: List<Reference>? = null
    var timeDateTime: FhirDateTime? = null
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
          procedure =
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
        7 ->
          timeDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Specimen.Processing(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      description = R4bString.of(description, _description),
      procedure = procedure,
      additive = listOrEmpty(additive),
      time = Specimen.Processing.Time.from(DateTime.of(timeDateTime, _timeDateTime), timePeriod),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Specimen.Processing) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
      value.procedure,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object SpecimenContainerSerializer : FhirSerializer<Specimen.Container> {
  override val descriptor: SerialDescriptor = buildDescriptor("Container", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Specimen.Container>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("capacity", QuantitySerializer.descriptor)
    b.optionalElement("specimenQuantity", QuantitySerializer.descriptor)
    b.optionalElement("additiveCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("additiveReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Specimen.Container {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
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
        6 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          capacity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        8 ->
          specimenQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        9 ->
          additiveCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          additiveReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Specimen.Container(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      description = R4bString.of(description, _description),
      type = type,
      capacity = capacity,
      specimenQuantity = specimenQuantity,
      additive = Specimen.Container.Additive.from(additiveCodeableConcept, additiveReference),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Specimen.Container) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.description)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.capacity)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      QuantitySerializer,
      value.specimenQuantity,
    )
    when (val choice = value.additive) {
      null -> {}
      is Specimen.Container.Additive.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          9,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Specimen.Container.Additive.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          10,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SpecimenSerializer : FhirResourceSerializer<Specimen> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Specimen")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("accessionIdentifier", IdentifierSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.strPrim("receivedTime")
    b.optionalElement("parent", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.listSerializer.descriptor)
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
    var status: SpecimenStatus? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var subject: Reference? = null
    var receivedTime: FhirDateTime? = null
    var _receivedTime: Element? = null
    var parent: List<Reference>? = null
    var request: List<Reference>? = null
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
        12 -> status = SpecimenStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        16 ->
          receivedTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        20 ->
          collection =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenCollectionSerializer,
              null,
            )
        21 ->
          processing =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenProcessingSerializer.listSerializer,
              null,
            )
        22 ->
          container =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenContainerSerializer.listSerializer,
              null,
            )
        23 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        24 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Specimen(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      accessionIdentifier = accessionIdentifier,
      status = Enumeration.of(status, _status),
      type = type,
      subject = subject,
      receivedTime = DateTime.of(receivedTime, _receivedTime),
      parent = listOrEmpty(parent),
      request = listOrEmpty(request),
      collection = collection,
      processing = listOrEmpty(processing),
      container = listOrEmpty(container),
      condition = listOrEmpty(condition),
      note = listOrEmpty(note),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.parent,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.request,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      SpecimenCollectionSerializer,
      value.collection,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      SpecimenProcessingSerializer.listSerializer,
      value.processing,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      SpecimenContainerSerializer.listSerializer,
      value.container,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.condition,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
  }
}
