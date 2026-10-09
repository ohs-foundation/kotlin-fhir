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
import dev.ohs.fhir.model.r5.terminologies.ImagingSelection2DGraphicType
import dev.ohs.fhir.model.r5.terminologies.ImagingSelection3DGraphicType
import dev.ohs.fhir.model.r5.terminologies.ImagingSelectionStatus
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

internal object ImagingSelectionPerformerSerializer : FhirSerializer<ImagingSelection.Performer> {
  override val descriptor: SerialDescriptor = buildDescriptor("Performer", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImagingSelection.Performer>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("function", CodeableConceptSerializer.descriptor)
    b.optionalElement("actor", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingSelection.Performer {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          actor =
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
    return ImagingSelection.Performer(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      function = function,
      actor = actor,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Performer) {
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
      CodeableConceptSerializer,
      value.function,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.actor)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImagingSelectionInstanceSerializer : FhirSerializer<ImagingSelection.Instance> {
  override val descriptor: SerialDescriptor = buildDescriptor("Instance", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImagingSelection.Instance>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("uid")
    b.intPrim("number")
    b.optionalElement("sopClass", CodingSerializer.descriptor)
    b.strPrimList("subset")
    b.optionalElement(
      "imageRegion2D",
      ImagingSelectionInstanceImageRegion2DSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "imageRegion3D",
      ImagingSelectionInstanceImageRegion3DSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> uid = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _uid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> number = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _number =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          sopClass =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        8 ->
          subset =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _subset =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 ->
          imageRegion2D =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImagingSelectionInstanceImageRegion2DSerializer.listSerializer,
              null,
            )
        11 ->
          imageRegion3D =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImagingSelectionInstanceImageRegion3DSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val subset_ =
      List(maxSize(subset, _subset)) { index ->
        entryRequired(
          R5String.of(at(subset, index), at(_subset, index)),
          "ImagingSelection.Instance",
          "subset",
        )
      }
    return ImagingSelection.Instance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      uid = required(Id.of(uid, _uid), "ImagingSelection.Instance", "uid"),
      number = UnsignedInt.of(number, _number),
      sopClass = sopClass,
      subset = subset_,
      imageRegion2D = listOrEmpty(imageRegion2D),
      imageRegion3D = listOrEmpty(imageRegion3D),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.uid.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.uid)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.number?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.number)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, CodingSerializer, value.sopClass)
    if (!value.subset.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.subset.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.subset)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      ImagingSelectionInstanceImageRegion2DSerializer.listSerializer,
      value.imageRegion2D,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ImagingSelectionInstanceImageRegion3DSerializer.listSerializer,
      value.imageRegion3D,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImagingSelectionInstanceImageRegion2DSerializer :
  FhirSerializer<ImagingSelection.Instance.ImageRegion2D> {
  override val descriptor: SerialDescriptor = buildDescriptor("ImageRegion2D", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImagingSelection.Instance.ImageRegion2D>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("regionType")
    b.primList("coordinate", FhirDecimalSerializer.nullableListSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance.ImageRegion2D {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var regionType: ImagingSelection2DGraphicType? = null
    var _regionType: Element? = null
    var coordinate: List<FhirDecimal?>? = null
    var _coordinate: List<Element?>? = null
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
          regionType =
            ImagingSelection2DGraphicType.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        4 ->
          _regionType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          coordinate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer.nullableListSerializer,
              null,
            )
        6 ->
          _coordinate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val coordinate_ =
      List(maxSize(coordinate, _coordinate)) { index ->
        entryRequired(
          Decimal.of(at(coordinate, index), at(_coordinate, index)),
          "ImagingSelection.Instance.ImageRegion2D",
          "coordinate",
        )
      }
    return ImagingSelection.Instance.ImageRegion2D(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      regionType =
        required(
          Enumeration.of(regionType, _regionType),
          "ImagingSelection.Instance.ImageRegion2D",
          "regionType",
        ),
      coordinate = coordinate_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance.ImageRegion2D) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.regionType.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.regionType)
    if (!value.coordinate.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        FhirDecimalSerializer.nullableListSerializer,
        value.coordinate.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.coordinate)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImagingSelectionInstanceImageRegion3DSerializer :
  FhirSerializer<ImagingSelection.Instance.ImageRegion3D> {
  override val descriptor: SerialDescriptor = buildDescriptor("ImageRegion3D", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImagingSelection.Instance.ImageRegion3D>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("regionType")
    b.primList("coordinate", FhirDecimalSerializer.nullableListSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance.ImageRegion3D {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var regionType: ImagingSelection3DGraphicType? = null
    var _regionType: Element? = null
    var coordinate: List<FhirDecimal?>? = null
    var _coordinate: List<Element?>? = null
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
          regionType =
            ImagingSelection3DGraphicType.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        4 ->
          _regionType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          coordinate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer.nullableListSerializer,
              null,
            )
        6 ->
          _coordinate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val coordinate_ =
      List(maxSize(coordinate, _coordinate)) { index ->
        entryRequired(
          Decimal.of(at(coordinate, index), at(_coordinate, index)),
          "ImagingSelection.Instance.ImageRegion3D",
          "coordinate",
        )
      }
    return ImagingSelection.Instance.ImageRegion3D(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      regionType =
        required(
          Enumeration.of(regionType, _regionType),
          "ImagingSelection.Instance.ImageRegion3D",
          "regionType",
        ),
      coordinate = coordinate_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance.ImageRegion3D) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.regionType.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.regionType)
    if (!value.coordinate.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        FhirDecimalSerializer.nullableListSerializer,
        value.coordinate.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.coordinate)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImagingSelectionSerializer : FhirResourceSerializer<ImagingSelection> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ImagingSelection")

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
    b.strPrim("status")
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.strPrim("issued")
    b.optionalElement("performer", ImagingSelectionPerformerSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.strPrim("studyUid")
    b.optionalElement("derivedFrom", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("seriesUid")
    b.intPrim("seriesNumber")
    b.strPrim("frameOfReferenceUid")
    b.optionalElement("bodySite", CodeableReferenceSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("instance", ImagingSelectionInstanceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: ImagingSelectionStatus? = null
    var _status: Element? = null
    var subject: Reference? = null
    var issued: FhirDateTime? = null
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
          status =
            ImagingSelectionStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        14 -> issued = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        15 ->
          _issued =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImagingSelectionPerformerSerializer.listSerializer,
              null,
            )
        17 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 -> studyUid = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _studyUid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          derivedFrom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          endpoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 -> seriesUid = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _seriesUid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> seriesNumber = compositeDecoder.decodeIntElement(descriptor, i)
        27 ->
          _seriesNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> frameOfReferenceUid = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _frameOfReferenceUid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        31 ->
          focus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImagingSelectionInstanceSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return ImagingSelection(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      status = required(Enumeration.of(status, _status), "ImagingSelection", "status"),
      subject = subject,
      issued = Instant.of(issued, _issued),
      performer = listOrEmpty(performer),
      basedOn = listOrEmpty(basedOn),
      category = listOrEmpty(category),
      code = required(code, "ImagingSelection", "code"),
      studyUid = Id.of(studyUid, _studyUid),
      derivedFrom = listOrEmpty(derivedFrom),
      endpoint = listOrEmpty(endpoint),
      seriesUid = Id.of(seriesUid, _seriesUid),
      seriesNumber = UnsignedInt.of(seriesNumber, _seriesNumber),
      frameOfReferenceUid = Id.of(frameOfReferenceUid, _frameOfReferenceUid),
      bodySite = bodySite,
      focus = listOrEmpty(focus),
      instance = listOrEmpty(instance),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImagingSelection,
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.issued?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.issued)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      ImagingSelectionPerformerSerializer.listSerializer,
      value.performer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.basedOn,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.studyUid?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.studyUid)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.derivedFrom,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.endpoint,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.seriesUid?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.seriesUid)
    compositeEncoder.encodeIntIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.seriesNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.seriesNumber)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.frameOfReferenceUid?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.frameOfReferenceUid,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      CodeableReferenceSerializer,
      value.bodySite,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.focus,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ImagingSelectionInstanceSerializer.listSerializer,
      value.instance,
    )
  }
}
