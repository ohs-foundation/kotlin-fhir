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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImagingSelection
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
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

internal object ImagingSelectionPerformerSerializer : KSerializer<ImagingSelection.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImagingSelection.Performer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImagingSelection.Performer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
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
      ImagingSelection.Performer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        function = function,
        actor = actor,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Performer) {
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
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object ImagingSelectionInstanceSerializer : KSerializer<ImagingSelection.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("uid", KotlinString.serializer().descriptor)
      optionalElement("_uid", ElementSerializer.descriptor)
      optionalElement("number", Int.serializer().descriptor)
      optionalElement("_number", ElementSerializer.descriptor)
      optionalElement("sopClass", CodingSerializer.descriptor)
      optionalElement("subset", stringNullableListSerializer.descriptor)
      optionalElement("_subset", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "imageRegion2D",
        ImagingSelectionInstanceImageRegion2DSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "imageRegion3D",
        ImagingSelectionInstanceImageRegion3DSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ImagingSelection.Instance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var uid: KotlinString? = null
      var _uid: Element? = null
      var number: Int? = null
      var _number: Element? = null
      var sopClass: Coding? = null
      var subset: List<KotlinString?>? = null
      var _subset: List<Element?>? = null
      var imageRegion2D: List<ImagingSelection.Instance.ImageRegion2D>? = null
      var imageRegion3D: List<ImagingSelection.Instance.ImageRegion3D>? = null
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
          3 -> uid = decodeStringElement(descriptor, i)
          4 -> _uid = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> number = decodeIntElement(descriptor, i)
          6 -> _number = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> sopClass = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          8 ->
            subset =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          9 ->
            _subset =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          10 ->
            imageRegion2D =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImagingSelectionInstanceImageRegion2DSerializer.listSerializer,
                null,
              )
          11 ->
            imageRegion3D =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImagingSelectionInstanceImageRegion3DSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Instance: " + i)
        }
      }
      ImagingSelection.Instance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        uid =
          Id.of(uid, _uid)
            ?: throw SerializationException(
              "Missing required property 'uid' on ImagingSelection.Instance"
            ),
        number = UnsignedInt.of(number, _number),
        sopClass = sopClass,
        subset =
          (kotlin.collections.List(maxOf(subset?.size ?: 0, _subset?.size ?: 0)) { index ->
            R5String.of(subset?.getOrNull(index), _subset?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'subset' on ImagingSelection.Instance has neither a value nor an id/extension"
              )
          }),
        imageRegion2D = imageRegion2D ?: listOf(),
        imageRegion3D = imageRegion3D ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance) {
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
      encodeStringIfNotNull(descriptor, 3, value.uid.value)
      encodeElementIfNotNull(descriptor, 4, value.uid)
      encodeIntIfNotNull(descriptor, 5, value.number?.value)
      encodeElementIfNotNull(descriptor, 6, value.number)
      encodeSerializableIfNotNull(descriptor, 7, CodingSerializer, value.sopClass)
      if (value.subset.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          8,
          stringNullableListSerializer,
          value.subset.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 9, value.subset)
      }
      if (value.imageRegion2D.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          ImagingSelectionInstanceImageRegion2DSerializer.listSerializer,
          value.imageRegion2D,
        )
      if (value.imageRegion3D.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          ImagingSelectionInstanceImageRegion3DSerializer.listSerializer,
          value.imageRegion3D,
        )
    }
  }
}

internal object ImagingSelectionInstanceImageRegion2DSerializer :
  KSerializer<ImagingSelection.Instance.ImageRegion2D> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImageRegion2D") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("regionType", KotlinString.serializer().descriptor)
      optionalElement("_regionType", ElementSerializer.descriptor)
      optionalElement("coordinate", FhirDecimalSerializer.nullableListSerializer.descriptor)
      optionalElement("_coordinate", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImagingSelection.Instance.ImageRegion2D>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance.ImageRegion2D =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var regionType: KotlinString? = null
      var _regionType: Element? = null
      var coordinate: List<FhirDecimal?>? = null
      var _coordinate: List<Element?>? = null
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
          3 -> regionType = decodeStringElement(descriptor, i)
          4 ->
            _regionType = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            coordinate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                FhirDecimalSerializer.nullableListSerializer,
                null,
              )
          6 ->
            _coordinate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ImageRegion2D: " + i)
        }
      }
      ImagingSelection.Instance.ImageRegion2D(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        regionType =
          Enumeration.of(
            if (regionType != null)
              ImagingSelection.ImagingSelection2DGraphicType.fromCode(regionType)
            else null,
            _regionType,
          )
            ?: throw SerializationException(
              "Missing required property 'regionType' on ImagingSelection.Instance.ImageRegion2D"
            ),
        coordinate =
          (kotlin.collections.List(maxOf(coordinate?.size ?: 0, _coordinate?.size ?: 0)) { index ->
            Decimal.of(coordinate?.getOrNull(index), _coordinate?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'coordinate' on ImagingSelection.Instance.ImageRegion2D has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance.ImageRegion2D) {
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
      encodeStringIfNotNull(descriptor, 3, value.regionType.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.regionType)
      if (value.coordinate.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          FhirDecimalSerializer.nullableListSerializer,
          value.coordinate.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.coordinate)
      }
    }
  }
}

internal object ImagingSelectionInstanceImageRegion3DSerializer :
  KSerializer<ImagingSelection.Instance.ImageRegion3D> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImageRegion3D") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("regionType", KotlinString.serializer().descriptor)
      optionalElement("_regionType", ElementSerializer.descriptor)
      optionalElement("coordinate", FhirDecimalSerializer.nullableListSerializer.descriptor)
      optionalElement("_coordinate", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImagingSelection.Instance.ImageRegion3D>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance.ImageRegion3D =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var regionType: KotlinString? = null
      var _regionType: Element? = null
      var coordinate: List<FhirDecimal?>? = null
      var _coordinate: List<Element?>? = null
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
          3 -> regionType = decodeStringElement(descriptor, i)
          4 ->
            _regionType = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            coordinate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                FhirDecimalSerializer.nullableListSerializer,
                null,
              )
          6 ->
            _coordinate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ImageRegion3D: " + i)
        }
      }
      ImagingSelection.Instance.ImageRegion3D(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        regionType =
          Enumeration.of(
            if (regionType != null)
              ImagingSelection.ImagingSelection3DGraphicType.fromCode(regionType)
            else null,
            _regionType,
          )
            ?: throw SerializationException(
              "Missing required property 'regionType' on ImagingSelection.Instance.ImageRegion3D"
            ),
        coordinate =
          (kotlin.collections.List(maxOf(coordinate?.size ?: 0, _coordinate?.size ?: 0)) { index ->
            Decimal.of(coordinate?.getOrNull(index), _coordinate?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'coordinate' on ImagingSelection.Instance.ImageRegion3D has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance.ImageRegion3D) {
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
      encodeStringIfNotNull(descriptor, 3, value.regionType.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.regionType)
      if (value.coordinate.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          FhirDecimalSerializer.nullableListSerializer,
          value.coordinate.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.coordinate)
      }
    }
  }
}

internal object ImagingSelectionSerializer : FhirResourceSerializer<ImagingSelection> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ImagingSelection")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("issued", KotlinString.serializer().descriptor)
    b.optionalElement("_issued", ElementSerializer.descriptor)
    b.optionalElement("performer", ImagingSelectionPerformerSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("studyUid", KotlinString.serializer().descriptor)
    b.optionalElement("_studyUid", ElementSerializer.descriptor)
    b.optionalElement("derivedFrom", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("seriesUid", KotlinString.serializer().descriptor)
    b.optionalElement("_seriesUid", ElementSerializer.descriptor)
    b.optionalElement("seriesNumber", Int.serializer().descriptor)
    b.optionalElement("_seriesNumber", ElementSerializer.descriptor)
    b.optionalElement("frameOfReferenceUid", KotlinString.serializer().descriptor)
    b.optionalElement("_frameOfReferenceUid", ElementSerializer.descriptor)
    b.optionalElement("bodySite", CodeableReferenceSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("instance", ImagingSelectionInstanceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ImagingSelection {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var subject: Reference? = null
    var issued: KotlinString? = null
    var _issued: Element? = null
    var performer: List<ImagingSelection.Performer>? = null
    var basedOn: List<Reference>? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var studyUid: KotlinString? = null
    var _studyUid: Element? = null
    var derivedFrom: List<Reference>? = null
    var endpoint: List<Reference>? = null
    var seriesUid: KotlinString? = null
    var _seriesUid: Element? = null
    var seriesNumber: Int? = null
    var _seriesNumber: Element? = null
    var frameOfReferenceUid: KotlinString? = null
    var _frameOfReferenceUid: Element? = null
    var bodySite: CodeableReference? = null
    var focus: List<Reference>? = null
    var instance: List<ImagingSelection.Instance>? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        14 -> issued = decoder.decodeStringElement(descriptor, i)
        15 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImagingSelectionPerformerSerializer.listSerializer,
              null,
            )
        17 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 -> studyUid = decoder.decodeStringElement(descriptor, i)
        21 ->
          _studyUid =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          endpoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 -> seriesUid = decoder.decodeStringElement(descriptor, i)
        25 ->
          _seriesUid =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> seriesNumber = decoder.decodeIntElement(descriptor, i)
        27 ->
          _seriesNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> frameOfReferenceUid = decoder.decodeStringElement(descriptor, i)
        29 ->
          _frameOfReferenceUid =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        31 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          instance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImagingSelectionInstanceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ImagingSelection: " + i)
      }
    }
    return ImagingSelection(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) ImagingSelection.ImagingSelectionStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on ImagingSelection"),
      subject = subject,
      issued = Instant.of(if (issued != null) FhirDateTime.fromString(issued) else null, _issued),
      performer = performer ?: listOf(),
      basedOn = basedOn ?: listOf(),
      category = category ?: listOf(),
      code =
        code
          ?: throw SerializationException("Missing required property 'code' on ImagingSelection"),
      studyUid = Id.of(studyUid, _studyUid),
      derivedFrom = derivedFrom ?: listOf(),
      endpoint = endpoint ?: listOf(),
      seriesUid = Id.of(seriesUid, _seriesUid),
      seriesNumber = UnsignedInt.of(seriesNumber, _seriesNumber),
      frameOfReferenceUid = Id.of(frameOfReferenceUid, _frameOfReferenceUid),
      bodySite = bodySite,
      focus = focus ?: listOf(),
      instance = instance ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImagingSelection,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.issued?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.issued)
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ImagingSelectionPerformerSerializer.listSerializer,
        value.performer,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.studyUid?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.studyUid)
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.derivedFrom,
      )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.endpoint,
      )
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.seriesUid?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.seriesUid)
    encoder.encodeIntIfNotNull(descriptor, 26 + descriptorOffset, value.seriesNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.seriesNumber)
    encoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.frameOfReferenceUid?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.frameOfReferenceUid)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      CodeableReferenceSerializer,
      value.bodySite,
    )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.focus,
      )
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ImagingSelectionInstanceSerializer.listSerializer,
        value.instance,
      )
  }
}
