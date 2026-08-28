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
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImagingSelection
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
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
import kotlinx.serialization.builtins.nullable
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImagingSelection.Performer =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Performer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImagingSelection.Performer {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          function =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.functionSer, null)
        4 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + i)
      }
    }
    return ImagingSelection.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ImagingSelection.Performer) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.function)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.functionSer, it)
    }
    (value.actor)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ImagingSelectionInstanceSerializer : KSerializer<ImagingSelection.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
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
      element("uid", KotlinString.serializer().descriptor, isOptional = true)
      element("_uid", Element.serializer().descriptor, isOptional = true)
      element("number", Int.serializer().descriptor, isOptional = true)
      element("_number", Element.serializer().descriptor, isOptional = true)
      element("sopClass", Coding.serializer().descriptor, isOptional = true)
      element(
        "subset",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_subset", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "imageRegion2D",
        listSerialDescriptor(
          lazyDescriptor { ImagingSelection.Instance.ImageRegion2D.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "imageRegion3D",
        listSerialDescriptor(
          lazyDescriptor { ImagingSelection.Instance.ImageRegion3D.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImagingSelection.Instance {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> uid = decoder.decodeStringElement(descriptor, i)
        4 -> _uid = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        5 -> number = decoder.decodeIntElement(descriptor, i)
        6 ->
          _number = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uidSer, null)
        7 ->
          sopClass =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sopClassSer, null)
        8 ->
          subset = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subsetSer, null)
        9 ->
          _subset =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subsetSer2, null)
        10 ->
          imageRegion2D =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.imageRegion2DSer, null)
        11 ->
          imageRegion3D =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.imageRegion3DSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + i)
      }
    }
    return ImagingSelection.Instance(
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
          R5String.of(subset?.getOrNull(index)?.let { it }, _subset?.getOrNull(index))!!
        }),
      imageRegion2D = imageRegion2D ?: listOf(),
      imageRegion3D = imageRegion3D ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ImagingSelection.Instance) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.uid.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.uid.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.uidSer, it)
    }
    ((value.number?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.uidSer, it)
    }
    (value.sopClass)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.sopClassSer, it)
    }
    (value.subset.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.subsetSer, it)
    }
    (value.subset.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.subsetSer2, it)
    }
    if (value.imageRegion2D.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        Hoisted.imageRegion2DSer,
        value.imageRegion2D,
      )
    if (value.imageRegion3D.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        Hoisted.imageRegion3DSer,
        value.imageRegion3D,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val uidSer: KSerializer<Element> = Element.serializer()

    public val sopClassSer: KSerializer<Coding> = Coding.serializer()

    public val subsetSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val subsetSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.subsetSerInner).nullable)

    public val subsetSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.uidSer).nullable)

    public val imageRegion2DSerInner: KSerializer<ImagingSelection.Instance.ImageRegion2D> =
      ImagingSelection.Instance.ImageRegion2D.serializer()

    public val imageRegion2DSer: KSerializer<List<ImagingSelection.Instance.ImageRegion2D>> =
      ListSerializer(Hoisted.imageRegion2DSerInner)

    public val imageRegion3DSerInner: KSerializer<ImagingSelection.Instance.ImageRegion3D> =
      ImagingSelection.Instance.ImageRegion3D.serializer()

    public val imageRegion3DSer: KSerializer<List<ImagingSelection.Instance.ImageRegion3D>> =
      ListSerializer(Hoisted.imageRegion3DSerInner)
  }
}

internal object ImagingSelectionInstanceImageRegion2DSerializer :
  KSerializer<ImagingSelection.Instance.ImageRegion2D> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImageRegion2D") {
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
      element("regionType", KotlinString.serializer().descriptor, isOptional = true)
      element("_regionType", Element.serializer().descriptor, isOptional = true)
      element(
        "coordinate",
        listSerialDescriptor(FhirDecimalSerializer.descriptor),
        isOptional = true,
      )
      element(
        "_coordinate",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance.ImageRegion2D =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance.ImageRegion2D) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ImagingSelection.Instance.ImageRegion2D {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var regionType: KotlinString? = null
    var _regionType: Element? = null
    var coordinate: List<FhirDecimal?>? = null
    var _coordinate: List<Element?>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> regionType = decoder.decodeStringElement(descriptor, i)
        4 ->
          _regionType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.regionTypeSer, null)
        5 ->
          coordinate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coordinateSer, null)
        6 ->
          _coordinate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coordinateSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ImageRegion2D: " + i)
      }
    }
    return ImagingSelection.Instance.ImageRegion2D(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      regionType =
        Enumeration.of(
          regionType?.let { ImagingSelection.ImagingSelection2DGraphicType.fromCode(it) },
          _regionType,
        )
          ?: throw SerializationException(
            "Missing required property 'regionType' on ImagingSelection.Instance.ImageRegion2D"
          ),
      coordinate =
        (kotlin.collections.List(maxOf(coordinate?.size ?: 0, _coordinate?.size ?: 0)) { index ->
          Decimal.of(coordinate?.getOrNull(index)?.let { it }, _coordinate?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImagingSelection.Instance.ImageRegion2D,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.regionType.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.regionType.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.regionTypeSer, it)
    }
    (value.coordinate.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.coordinateSer, it)
    }
    (value.coordinate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.coordinateSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val regionTypeSer: KSerializer<Element> = Element.serializer()

    public val coordinateSer: KSerializer<List<FhirDecimal?>> =
      ListSerializer((FhirDecimalSerializer).nullable)

    public val coordinateSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.regionTypeSer).nullable)
  }
}

internal object ImagingSelectionInstanceImageRegion3DSerializer :
  KSerializer<ImagingSelection.Instance.ImageRegion3D> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImageRegion3D") {
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
      element("regionType", KotlinString.serializer().descriptor, isOptional = true)
      element("_regionType", Element.serializer().descriptor, isOptional = true)
      element(
        "coordinate",
        listSerialDescriptor(FhirDecimalSerializer.descriptor),
        isOptional = true,
      )
      element(
        "_coordinate",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance.ImageRegion3D =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance.ImageRegion3D) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ImagingSelection.Instance.ImageRegion3D {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var regionType: KotlinString? = null
    var _regionType: Element? = null
    var coordinate: List<FhirDecimal?>? = null
    var _coordinate: List<Element?>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> regionType = decoder.decodeStringElement(descriptor, i)
        4 ->
          _regionType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.regionTypeSer, null)
        5 ->
          coordinate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coordinateSer, null)
        6 ->
          _coordinate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coordinateSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ImageRegion3D: " + i)
      }
    }
    return ImagingSelection.Instance.ImageRegion3D(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      regionType =
        Enumeration.of(
          regionType?.let { ImagingSelection.ImagingSelection3DGraphicType.fromCode(it) },
          _regionType,
        )
          ?: throw SerializationException(
            "Missing required property 'regionType' on ImagingSelection.Instance.ImageRegion3D"
          ),
      coordinate =
        (kotlin.collections.List(maxOf(coordinate?.size ?: 0, _coordinate?.size ?: 0)) { index ->
          Decimal.of(coordinate?.getOrNull(index)?.let { it }, _coordinate?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImagingSelection.Instance.ImageRegion3D,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.regionType.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.regionType.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.regionTypeSer, it)
    }
    (value.coordinate.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.coordinateSer, it)
    }
    (value.coordinate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.coordinateSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val regionTypeSer: KSerializer<Element> = Element.serializer()

    public val coordinateSer: KSerializer<List<FhirDecimal?>> =
      ListSerializer((FhirDecimalSerializer).nullable)

    public val coordinateSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.regionTypeSer).nullable)
  }
}

internal object ImagingSelectionSerializer : KSerializer<ImagingSelection> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImagingSelection") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("issued", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_issued", Element.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(lazyDescriptor { ImagingSelection.Performer.serializer().descriptor }),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("studyUid", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_studyUid", Element.serializer().descriptor, isOptional = true)
    b.element(
      "derivedFrom",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("seriesUid", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_seriesUid", Element.serializer().descriptor, isOptional = true)
    b.element("seriesNumber", Int.serializer().descriptor, isOptional = true)
    b.element("_seriesNumber", Element.serializer().descriptor, isOptional = true)
    b.element("frameOfReferenceUid", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_frameOfReferenceUid", Element.serializer().descriptor, isOptional = true)
    b.element("bodySite", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "instance",
      listSerialDescriptor(lazyDescriptor { ImagingSelection.Instance.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ImagingSelection =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ImagingSelection")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        14 -> issued = decoder.decodeStringElement(descriptor, i)
        15 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        17 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        18 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        19 ->
          code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        20 -> studyUid = decoder.decodeStringElement(descriptor, i)
        21 ->
          _studyUid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        23 ->
          endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        24 -> seriesUid = decoder.decodeStringElement(descriptor, i)
        25 ->
          _seriesUid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> seriesNumber = decoder.decodeIntElement(descriptor, i)
        27 ->
          _seriesNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 -> frameOfReferenceUid = decoder.decodeStringElement(descriptor, i)
        29 ->
          _frameOfReferenceUid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bodySiteSer, null)
        31 ->
          focus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        32 ->
          instance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instanceSer, null)
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
          status?.let { ImagingSelection.ImagingSelectionStatus.fromCode(it) },
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on ImagingSelection"),
      subject = subject,
      issued = Instant.of(FhirDateTime.fromString(issued), _issued),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImagingSelection,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.subjectSer, it)
    }
    ((value.issued?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.performerSer,
        value.performer,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      Hoisted.categorySerInner,
      value.code,
    )
    ((value.studyUid?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.studyUid?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.basedOnSer,
        value.derivedFrom,
      )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.basedOnSer,
        value.endpoint,
      )
    ((value.seriesUid?.value))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.seriesUid?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.seriesNumber?.value))?.let {
      encoder.encodeIntElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.seriesNumber?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.frameOfReferenceUid?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.frameOfReferenceUid?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, Hoisted.bodySiteSer, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.basedOnSer,
        value.focus,
      )
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.instanceSer,
        value.instance,
      )
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

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val performerSerInner: KSerializer<ImagingSelection.Performer> =
      ImagingSelection.Performer.serializer()

    public val performerSer: KSerializer<List<ImagingSelection.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val bodySiteSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val instanceSerInner: KSerializer<ImagingSelection.Instance> =
      ImagingSelection.Instance.serializer()

    public val instanceSer: KSerializer<List<ImagingSelection.Instance>> =
      ListSerializer(Hoisted.instanceSerInner)
  }
}

internal object ImagingSelectionPolymorphicSerializer : KSerializer<ImagingSelection> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImagingSelection") {
      ImagingSelectionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImagingSelection) {
    encoder.encodeStructure(descriptor) {
      ImagingSelectionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ImagingSelection =
    decoder.decodeStructure(descriptor) {
      ImagingSelectionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
