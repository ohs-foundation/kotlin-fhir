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

internal object BodyStructureIncludedStructureSerializer :
  FhirSerializer<BodyStructure.IncludedStructure> {
  override val descriptor: SerialDescriptor = buildDescriptor("IncludedStructure", this)

  @JvmField
  internal val listSerializer: KSerializer<List<BodyStructure.IncludedStructure>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("structure", CodeableConceptSerializer.descriptor)
    b.optionalElement("laterality", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "bodyLandmarkOrientation",
      BodyStructureIncludedStructureBodyLandmarkOrientationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("spatialReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("qualifier", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BodyStructure.IncludedStructure {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          structure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          laterality =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          bodyLandmarkOrientation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BodyStructureIncludedStructureBodyLandmarkOrientationSerializer.listSerializer,
              null,
            )
        6 ->
          spatialReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        7 ->
          qualifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return BodyStructure.IncludedStructure(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      structure = required(structure, "BodyStructure.IncludedStructure", "structure"),
      laterality = laterality,
      bodyLandmarkOrientation = listOrEmpty(bodyLandmarkOrientation),
      spatialReference = listOrEmpty(spatialReference),
      qualifier = listOrEmpty(qualifier),
    )
  }

  override fun serialize(encoder: Encoder, `value`: BodyStructure.IncludedStructure) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.structure,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.laterality,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      BodyStructureIncludedStructureBodyLandmarkOrientationSerializer.listSerializer,
      value.bodyLandmarkOrientation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      ReferenceSerializer.listSerializer,
      value.spatialReference,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.qualifier,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BodyStructureIncludedStructureBodyLandmarkOrientationSerializer :
  FhirSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation> {
  override val descriptor: SerialDescriptor = buildDescriptor("BodyLandmarkOrientation", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<BodyStructure.IncludedStructure.BodyLandmarkOrientation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("landmarkDescription", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("clockFacePosition", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "distanceFromLandmark",
      BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer
        .listSerializer
        .descriptor,
    )
    b.optionalElement("surfaceOrientation", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          landmarkDescription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          clockFacePosition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          distanceFromLandmark =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer
                .listSerializer,
              null,
            )
        6 ->
          surfaceOrientation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return BodyStructure.IncludedStructure.BodyLandmarkOrientation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      landmarkDescription = listOrEmpty(landmarkDescription),
      clockFacePosition = listOrEmpty(clockFacePosition),
      distanceFromLandmark = listOrEmpty(distanceFromLandmark),
      surfaceOrientation = listOrEmpty(surfaceOrientation),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation,
  ) {
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
      CodeableConceptSerializer.listSerializer,
      value.landmarkDescription,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.clockFacePosition,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer
        .listSerializer,
      value.distanceFromLandmark,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      CodeableConceptSerializer.listSerializer,
      value.surfaceOrientation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer :
  FhirSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark> {
  override val descriptor: SerialDescriptor = buildDescriptor("DistanceFromLandmark", this)

  @JvmField
  internal val listSerializer:
    KSerializer<
      List<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark>
    > =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("device", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("value", QuantitySerializer.listSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var device: List<CodeableReference>? = null
    var `value`: List<Quantity>? = null
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
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        4 ->
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      device = listOrEmpty(device),
      `value` = listOrEmpty(`value`),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark,
  ) {
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
      CodeableReferenceSerializer.listSerializer,
      value.device,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      QuantitySerializer.listSerializer,
      value.`value`,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BodyStructureSerializer : FhirResourceSerializer<BodyStructure> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("BodyStructure")

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
    b.boolPrim("active")
    b.optionalElement("morphology", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "includedStructure",
      BodyStructureIncludedStructureSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "excludedStructure",
      BodyStructureIncludedStructureSerializer.listSerializer.descriptor,
    )
    b.strPrim("description")
    b.optionalElement("image", AttachmentSerializer.listSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
        11 -> active = compositeDecoder.decodeBooleanElement(descriptor, i)
        12 ->
          _active =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          morphology =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          includedStructure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BodyStructureIncludedStructureSerializer.listSerializer,
              null,
            )
        15 ->
          excludedStructure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BodyStructureIncludedStructureSerializer.listSerializer,
              null,
            )
        16 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          image =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        19 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return BodyStructure(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      active = R5Boolean.of(active, _active),
      morphology = morphology,
      includedStructure = listOrEmpty(includedStructure),
      excludedStructure = listOrEmpty(excludedStructure),
      description = Markdown.of(description, _description),
      image = listOrEmpty(image),
      patient = required(patient, "BodyStructure", "patient"),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: BodyStructure,
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 11 + descriptorOffset, value.active?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.active)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.morphology,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      BodyStructureIncludedStructureSerializer.listSerializer,
      value.includedStructure,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      BodyStructureIncludedStructureSerializer.listSerializer,
      value.excludedStructure,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18 + descriptorOffset,
      AttachmentSerializer.listSerializer,
      value.image,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
  }
}
