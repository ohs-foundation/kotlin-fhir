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
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String
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

  override fun deserialize(decoder: Decoder): BodyStructure.IncludedStructure =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BodyStructure.IncludedStructure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): BodyStructure.IncludedStructure {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          structure =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.structureSer, null)
        4 ->
          laterality =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.structureSer, null)
        5 ->
          bodyLandmarkOrientation =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.bodyLandmarkOrientationSer,
              null,
            )
        6 ->
          spatialReference =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.spatialReferenceSer, null)
        7 ->
          qualifier =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.qualifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding IncludedStructure: " + __i)
      }
    }
    return BodyStructure.IncludedStructure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      structure = structure!!,
      laterality = laterality,
      bodyLandmarkOrientation = bodyLandmarkOrientation ?: listOf(),
      spatialReference = spatialReference ?: listOf(),
      qualifier = qualifier ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: BodyStructure.IncludedStructure) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.structure)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.structureSer, it)
    }
    (value.laterality)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.structureSer, it)
    }
    if (value.bodyLandmarkOrientation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        5,
        Hoisted.bodyLandmarkOrientationSer,
        value.bodyLandmarkOrientation,
      )
    if (value.spatialReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        6,
        Hoisted.spatialReferenceSer,
        value.spatialReference,
      )
    if (value.qualifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.qualifierSer, value.qualifier)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val structureSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val bodyLandmarkOrientationSerInner:
      KSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation> =
      BodyStructure.IncludedStructure.BodyLandmarkOrientation.serializer()

    public val bodyLandmarkOrientationSer:
      KSerializer<List<BodyStructure.IncludedStructure.BodyLandmarkOrientation>> =
      ListSerializer(Hoisted.bodyLandmarkOrientationSerInner)

    public val spatialReferenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val spatialReferenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.spatialReferenceSerInner)

    public val qualifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.structureSer)
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

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          landmarkDescription =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.landmarkDescriptionSer,
              null,
            )
        4 ->
          clockFacePosition =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.landmarkDescriptionSer,
              null,
            )
        5 ->
          distanceFromLandmark =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.distanceFromLandmarkSer,
              null,
            )
        6 ->
          surfaceOrientation =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.landmarkDescriptionSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding BodyLandmarkOrientation: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.landmarkDescription.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        3,
        Hoisted.landmarkDescriptionSer,
        value.landmarkDescription,
      )
    if (value.clockFacePosition.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        4,
        Hoisted.landmarkDescriptionSer,
        value.clockFacePosition,
      )
    if (value.distanceFromLandmark.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        5,
        Hoisted.distanceFromLandmarkSer,
        value.distanceFromLandmark,
      )
    if (value.surfaceOrientation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        6,
        Hoisted.landmarkDescriptionSer,
        value.surfaceOrientation,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val landmarkDescriptionSerInner: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val landmarkDescriptionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.landmarkDescriptionSerInner)

    public val distanceFromLandmarkSerInner:
      KSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark> =
      BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark.serializer()

    public val distanceFromLandmarkSer:
      KSerializer<
        List<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark>
      > =
      ListSerializer(Hoisted.distanceFromLandmarkSerInner)
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

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var device: List<CodeableReference>? = null
    var `value`: List<Quantity>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> device = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.deviceSer, null)
        4 -> `value` = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DistanceFromLandmark: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.deviceSer, value.device)
    if (value.`value`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.valueSer, value.`value`)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val deviceSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val deviceSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.deviceSerInner)

    public val valueSerInner: KSerializer<Quantity> = Quantity.serializer()

    public val valueSer: KSerializer<List<Quantity>> = ListSerializer(Hoisted.valueSerInner)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BodyStructure) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "BodyStructure")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): BodyStructure {
    val __desc = descriptor
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
        12 -> active = decoder.decodeBooleanElement(__desc, 12)
        13 ->
          _active =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          morphology =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.morphologySer, null)
        15 ->
          includedStructure =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.includedStructureSer,
              null,
            )
        16 ->
          excludedStructure =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.includedStructureSer,
              null,
            )
        17 -> description = decoder.decodeStringElement(__desc, 17)
        18 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 -> image = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.imageSer, null)
        20 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.patientSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BodyStructure: " + __i)
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
      patient = patient!!,
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: BodyStructure) {
    val __desc = descriptor
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
    ((value.active?.value))?.let { encoder.encodeBooleanElement(__desc, 12, it) }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.morphology)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.morphologySer, it)
    }
    if (value.includedStructure.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15,
        Hoisted.includedStructureSer,
        value.includedStructure,
      )
    if (value.excludedStructure.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        16,
        Hoisted.includedStructureSer,
        value.excludedStructure,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    if (value.image.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.imageSer, value.image)
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.patientSer, it) }
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

    public val morphologySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val includedStructureSerInner: KSerializer<BodyStructure.IncludedStructure> =
      BodyStructure.IncludedStructure.serializer()

    public val includedStructureSer: KSerializer<List<BodyStructure.IncludedStructure>> =
      ListSerializer(Hoisted.includedStructureSerInner)

    public val imageSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val imageSer: KSerializer<List<Attachment>> = ListSerializer(Hoisted.imageSerInner)

    public val patientSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object BodyStructurePolymorphicSerializer : KSerializer<BodyStructure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodyStructure") { BodyStructureSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: BodyStructure) {
    encoder.encodeStructure(descriptor) { BodyStructureSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): BodyStructure =
    decoder.decodeStructure(descriptor) { BodyStructureSerializer.deserializeJson(this) }
}
