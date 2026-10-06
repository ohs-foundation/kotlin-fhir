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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.BodyStructure
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
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
import kotlin.Boolean as KotlinBoolean
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

internal object BodyStructureIncludedStructureSerializer :
  KSerializer<BodyStructure.IncludedStructure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("IncludedStructure") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("structure", CodeableConceptSerializer.descriptor)
      optionalElement("laterality", CodeableConceptSerializer.descriptor)
      optionalElement(
        "bodyLandmarkOrientation",
        BodyStructureIncludedStructureBodyLandmarkOrientationSerializer.listSerializer.descriptor,
      )
      optionalElement("spatialReference", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("qualifier", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<BodyStructure.IncludedStructure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): BodyStructure.IncludedStructure =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var structure: CodeableConcept? = null
      var laterality: CodeableConcept? = null
      var bodyLandmarkOrientation: List<BodyStructure.IncludedStructure.BodyLandmarkOrientation>? =
        null
      var spatialReference: List<Reference>? = null
      var qualifier: List<CodeableConcept>? = null
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
            structure =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            laterality =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            bodyLandmarkOrientation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                BodyStructureIncludedStructureBodyLandmarkOrientationSerializer.listSerializer,
                null,
              )
          6 ->
            spatialReference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          7 ->
            qualifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding IncludedStructure: " + i)
        }
      }
      BodyStructure.IncludedStructure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        structure =
          structure
            ?: throw SerializationException(
              "Missing required property 'structure' on BodyStructure.IncludedStructure"
            ),
        laterality = laterality,
        bodyLandmarkOrientation = bodyLandmarkOrientation ?: listOf(),
        spatialReference = spatialReference ?: listOf(),
        qualifier = qualifier ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: BodyStructure.IncludedStructure) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.structure)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.laterality)
      if (value.bodyLandmarkOrientation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          BodyStructureIncludedStructureBodyLandmarkOrientationSerializer.listSerializer,
          value.bodyLandmarkOrientation,
        )
      if (value.spatialReference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ReferenceSerializer.listSerializer,
          value.spatialReference,
        )
      if (value.qualifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.qualifier,
        )
    }
  }
}

internal object BodyStructureIncludedStructureBodyLandmarkOrientationSerializer :
  KSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodyLandmarkOrientation") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("landmarkDescription", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("clockFacePosition", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "distanceFromLandmark",
        BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer
          .listSerializer
          .descriptor,
      )
      optionalElement("surfaceOrientation", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<BodyStructure.IncludedStructure.BodyLandmarkOrientation>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var landmarkDescription: List<CodeableConcept>? = null
      var clockFacePosition: List<CodeableConcept>? = null
      var distanceFromLandmark:
        List<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark>? =
        null
      var surfaceOrientation: List<CodeableConcept>? = null
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
            landmarkDescription =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            clockFacePosition =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            distanceFromLandmark =
              decodeNullableSerializableElement(
                descriptor,
                i,
                BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer
                  .listSerializer,
                null,
              )
          6 ->
            surfaceOrientation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding BodyLandmarkOrientation: " + i)
        }
      }
      BodyStructure.IncludedStructure.BodyLandmarkOrientation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        landmarkDescription = landmarkDescription ?: listOf(),
        clockFacePosition = clockFacePosition ?: listOf(),
        distanceFromLandmark = distanceFromLandmark ?: listOf(),
        surfaceOrientation = surfaceOrientation ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation,
  ) {
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
      if (value.landmarkDescription.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.landmarkDescription,
        )
      if (value.clockFacePosition.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.clockFacePosition,
        )
      if (value.distanceFromLandmark.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer
            .listSerializer,
          value.distanceFromLandmark,
        )
      if (value.surfaceOrientation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer.listSerializer,
          value.surfaceOrientation,
        )
    }
  }
}

internal object BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer :
  KSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DistanceFromLandmark") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("device", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("value", QuantitySerializer.listSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<
      List<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark>
    > =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var device: List<CodeableReference>? = null
      var `value`: List<Quantity>? = null
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
            device =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            `value` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuantitySerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding DistanceFromLandmark: " + i)
        }
      }
      BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        device = device ?: listOf(),
        `value` = `value` ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark,
  ) {
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
      if (value.device.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableReferenceSerializer.listSerializer,
          value.device,
        )
      if (value.`value`.isNotEmpty())
        encodeSerializableElement(descriptor, 4, QuantitySerializer.listSerializer, value.`value`)
    }
  }
}

internal object BodyStructureSerializer : FhirResourceSerializer<BodyStructure> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("BodyStructure")

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
    b.optionalElement("active", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_active", ElementSerializer.descriptor)
    b.optionalElement("morphology", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "includedStructure",
      BodyStructureIncludedStructureSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "excludedStructure",
      BodyStructureIncludedStructureSerializer.listSerializer.descriptor,
    )
    b.optionalElement("description", String.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("image", AttachmentSerializer.listSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): BodyStructure {
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
    var active: KotlinBoolean? = null
    var _active: Element? = null
    var morphology: CodeableConcept? = null
    var includedStructure: List<BodyStructure.IncludedStructure>? = null
    var excludedStructure: List<BodyStructure.IncludedStructure>? = null
    var description: String? = null
    var _description: Element? = null
    var image: List<Attachment>? = null
    var patient: Reference? = null
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
        11 -> active = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _active =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          morphology =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          includedStructure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BodyStructureIncludedStructureSerializer.listSerializer,
              null,
            )
        15 ->
          excludedStructure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BodyStructureIncludedStructureSerializer.listSerializer,
              null,
            )
        16 -> description = decoder.decodeStringElement(descriptor, i)
        17 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          image =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        19 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        else -> throw SerializationException("Unexpected index decoding BodyStructure: " + i)
      }
    }
    return BodyStructure(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      active = R5Boolean.of(active, _active),
      morphology = morphology,
      includedStructure = includedStructure ?: listOf(),
      excludedStructure = excludedStructure ?: listOf(),
      description = Markdown.of(description, _description),
      image = image ?: listOf(),
      patient =
        patient
          ?: throw SerializationException("Missing required property 'patient' on BodyStructure"),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: BodyStructure,
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
    encoder.encodeBooleanIfNotNull(descriptor, 11 + descriptorOffset, value.active?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.active)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.morphology,
    )
    if (value.includedStructure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        BodyStructureIncludedStructureSerializer.listSerializer,
        value.includedStructure,
      )
    if (value.excludedStructure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        BodyStructureIncludedStructureSerializer.listSerializer,
        value.excludedStructure,
      )
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.description)
    if (value.image.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        AttachmentSerializer.listSerializer,
        value.image,
      )
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
  }
}
