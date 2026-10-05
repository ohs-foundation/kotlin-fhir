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
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("structure", CodeableConcept.serializer().descriptor, isOptional = true)
      element("laterality", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "bodyLandmarkOrientation",
        listSerialDescriptor(
          lazyDescriptor {
            BodyStructure.IncludedStructure.BodyLandmarkOrientation.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "spatialReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "qualifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<BodyStructure.IncludedStructure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): BodyStructure.IncludedStructure =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: BodyStructure.IncludedStructure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): BodyStructure.IncludedStructure {
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
          structure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          laterality =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          bodyLandmarkOrientation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BodyStructureIncludedStructureBodyLandmarkOrientationSerializer.listSerializer,
              null,
            )
        6 ->
          spatialReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        7 ->
          qualifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding IncludedStructure: " + i)
      }
    }
    return BodyStructure.IncludedStructure(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: BodyStructure.IncludedStructure,
  ) {
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
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.structure)
    (value.laterality)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    if (value.bodyLandmarkOrientation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        BodyStructureIncludedStructureBodyLandmarkOrientationSerializer.listSerializer,
        value.bodyLandmarkOrientation,
      )
    if (value.spatialReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        ReferenceSerializer.listSerializer,
        value.spatialReference,
      )
    if (value.qualifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.qualifier,
      )
  }
}

internal object BodyStructureIncludedStructureBodyLandmarkOrientationSerializer :
  KSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodyLandmarkOrientation") {
      element("id", String.serializer().descriptor, isOptional = true)
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
        "landmarkDescription",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "clockFacePosition",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "distanceFromLandmark",
        listSerialDescriptor(
          lazyDescriptor {
            BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark
              .serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "surfaceOrientation",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer:
    KSerializer<List<BodyStructure.IncludedStructure.BodyLandmarkOrientation>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation {
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
          landmarkDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          clockFacePosition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          distanceFromLandmark =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer
                .listSerializer,
              null,
            )
        6 ->
          surfaceOrientation =
            decoder.decodeNullableSerializableElement(
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
    return BodyStructure.IncludedStructure.BodyLandmarkOrientation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      landmarkDescription = landmarkDescription ?: listOf(),
      clockFacePosition = clockFacePosition ?: listOf(),
      distanceFromLandmark = distanceFromLandmark ?: listOf(),
      surfaceOrientation = surfaceOrientation ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation,
  ) {
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
    if (value.landmarkDescription.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableConceptSerializer.listSerializer,
        value.landmarkDescription,
      )
    if (value.clockFacePosition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.clockFacePosition,
      )
    if (value.distanceFromLandmark.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer
          .listSerializer,
        value.distanceFromLandmark,
      )
    if (value.surfaceOrientation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        CodeableConceptSerializer.listSerializer,
        value.surfaceOrientation,
      )
  }
}

internal object BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer :
  KSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DistanceFromLandmark") {
      element("id", String.serializer().descriptor, isOptional = true)
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
        "device",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("value", listSerialDescriptor(Quantity.serializer().descriptor), isOptional = true)
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
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var device: List<CodeableReference>? = null
    var `value`: List<Quantity>? = null
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
          device =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        4 ->
          `value` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DistanceFromLandmark: " + i)
      }
    }
    return BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      device = device ?: listOf(),
      `value` = `value` ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark,
  ) {
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
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableReferenceSerializer.listSerializer,
        value.device,
      )
    if (value.`value`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        QuantitySerializer.listSerializer,
        value.`value`,
      )
  }
}

internal object BodyStructureSerializer : KSerializer<BodyStructure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodyStructure") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_active", Element.serializer().descriptor, isOptional = true)
    b.element("morphology", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "includedStructure",
      listSerialDescriptor(
        lazyDescriptor { BodyStructure.IncludedStructure.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "excludedStructure",
      listSerialDescriptor(
        lazyDescriptor { BodyStructure.IncludedStructure.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("description", String.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("image", listSerialDescriptor(Attachment.serializer().descriptor), isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): BodyStructure =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: BodyStructure) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "BodyStructure")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: BodyStructure,
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
    ((value.active?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ElementSerializer, it)
    }
    (value.morphology)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
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
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, ElementSerializer, it)
    }
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

internal object BodyStructurePolymorphicSerializer : KSerializer<BodyStructure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodyStructure") { BodyStructureSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: BodyStructure) {
    encoder.encodeStructure(descriptor) {
      BodyStructureSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): BodyStructure =
    decoder.decodeStructure(descriptor) {
      BodyStructureSerializer.deserializeInternal(this, descriptor, 0)
    }
}
