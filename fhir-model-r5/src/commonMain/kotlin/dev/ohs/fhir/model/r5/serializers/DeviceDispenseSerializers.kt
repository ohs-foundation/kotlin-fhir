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
import dev.ohs.fhir.model.r5.DeviceDispense
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object DeviceDispensePerformerSerializer : KSerializer<DeviceDispense.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDispense.Performer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDispense.Performer =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
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
      DeviceDispense.Performer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        function = function,
        actor =
          actor
            ?: throw SerializationException(
              "Missing required property 'actor' on DeviceDispense.Performer"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDispense.Performer) {
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

internal object DeviceDispenseSerializer : FhirResourceSerializer<DeviceDispense> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("DeviceDispense")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableReferenceSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("device", CodeableReferenceSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("receiver", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("performer", DeviceDispensePerformerSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("preparedDate", String.serializer().descriptor)
    b.optionalElement("_preparedDate", ElementSerializer.descriptor)
    b.optionalElement("whenHandedOver", String.serializer().descriptor)
    b.optionalElement("_whenHandedOver", ElementSerializer.descriptor)
    b.optionalElement("destination", ReferenceSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("usageInstruction", String.serializer().descriptor)
    b.optionalElement("_usageInstruction", ElementSerializer.descriptor)
    b.optionalElement("eventHistory", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): DeviceDispense {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var statusReason: CodeableReference? = null
    var category: List<CodeableConcept>? = null
    var device: CodeableReference? = null
    var subject: Reference? = null
    var `receiver`: Reference? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var performer: List<DeviceDispense.Performer>? = null
    var location: Reference? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
    var preparedDate: String? = null
    var _preparedDate: Element? = null
    var whenHandedOver: String? = null
    var _whenHandedOver: Element? = null
    var destination: Reference? = null
    var note: List<Annotation>? = null
    var usageInstruction: String? = null
    var _usageInstruction: Element? = null
    var eventHistory: List<Reference>? = null
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
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          statusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        16 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 ->
          device =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        18 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          `receiver` =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDispensePerformerSerializer.listSerializer,
              null,
            )
        23 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        26 -> preparedDate = decoder.decodeStringElement(descriptor, i)
        27 ->
          _preparedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> whenHandedOver = decoder.decodeStringElement(descriptor, i)
        29 ->
          _whenHandedOver =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          destination =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        31 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        32 -> usageInstruction = decoder.decodeStringElement(descriptor, i)
        33 ->
          _usageInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding DeviceDispense: " + i)
      }
    }
    return DeviceDispense(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) DeviceDispense.DeviceDispenseStatusCodes.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on DeviceDispense"),
      statusReason = statusReason,
      category = category ?: listOf(),
      device =
        device
          ?: throw SerializationException("Missing required property 'device' on DeviceDispense"),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on DeviceDispense"),
      `receiver` = `receiver`,
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      performer = performer ?: listOf(),
      location = location,
      type = type,
      quantity = quantity,
      preparedDate =
        DateTime.of(
          if (preparedDate != null) FhirDateTime.fromString(preparedDate) else null,
          _preparedDate,
        ),
      whenHandedOver =
        DateTime.of(
          if (whenHandedOver != null) FhirDateTime.fromString(whenHandedOver) else null,
          _whenHandedOver,
        ),
      destination = destination,
      note = note ?: listOf(),
      usageInstruction = Markdown.of(usageInstruction, _usageInstruction),
      eventHistory = eventHistory ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DeviceDispense,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableReferenceSerializer,
      value.statusReason,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      CodeableReferenceSerializer,
      value.device,
    )
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.`receiver`,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        DeviceDispensePerformerSerializer.listSerializer,
        value.performer,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.preparedDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.preparedDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.whenHandedOver?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.whenHandedOver)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.destination,
    )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.usageInstruction?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.usageInstruction)
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.eventHistory,
      )
  }
}
