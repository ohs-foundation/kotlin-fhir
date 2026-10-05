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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.SpecimenDefinition
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object SpecimenDefinitionTypeTestedSerializer :
  KSerializer<SpecimenDefinition.TypeTested> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TypeTested") {
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
      element("isDerived", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isDerived", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("preference", KotlinString.serializer().descriptor, isOptional = true)
      element("_preference", Element.serializer().descriptor, isOptional = true)
      element(
        "container",
        lazyDescriptor { SpecimenDefinition.TypeTested.Container.serializer().descriptor },
        isOptional = true,
      )
      element("requirement", KotlinString.serializer().descriptor, isOptional = true)
      element("_requirement", Element.serializer().descriptor, isOptional = true)
      element("retentionTime", Duration.serializer().descriptor, isOptional = true)
      element(
        "rejectionCriterion",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "handling",
        listSerialDescriptor(
          lazyDescriptor { SpecimenDefinition.TypeTested.Handling.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SpecimenDefinition.TypeTested {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var isDerived: KotlinBoolean? = null
    var _isDerived: Element? = null
    var type: CodeableConcept? = null
    var preference: KotlinString? = null
    var _preference: Element? = null
    var container: SpecimenDefinition.TypeTested.Container? = null
    var requirement: KotlinString? = null
    var _requirement: Element? = null
    var retentionTime: Duration? = null
    var rejectionCriterion: List<CodeableConcept>? = null
    var handling: List<SpecimenDefinition.TypeTested.Handling>? = null
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
        3 -> isDerived = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _isDerived =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> preference = decoder.decodeStringElement(descriptor, i)
        7 ->
          _preference =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          container =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedContainerSerializer,
              null,
            )
        9 -> requirement = decoder.decodeStringElement(descriptor, i)
        10 ->
          _requirement =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 ->
          retentionTime =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        12 ->
          rejectionCriterion =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          handling =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TypeTested: " + i)
      }
    }
    return SpecimenDefinition.TypeTested(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      isDerived = R4Boolean.of(isDerived, _isDerived),
      type = type,
      preference =
        Enumeration.of(
          preference?.let { SpecimenDefinition.SpecimenContainedPreference.fromCode(it) },
          _preference,
        )
          ?: throw SerializationException(
            "Missing required property 'preference' on SpecimenDefinition.TypeTested"
          ),
      container = container,
      requirement = R4String.of(requirement, _requirement),
      retentionTime = retentionTime,
      rejectionCriterion = rejectionCriterion ?: listOf(),
      handling = handling ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SpecimenDefinition.TypeTested) {
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
    ((value.isDerived?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.isDerived?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    ((value.preference.value?.code))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.preference.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.container)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        8,
        SpecimenDefinitionTypeTestedContainerSerializer,
        it,
      )
    }
    ((value.requirement?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.requirement?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
    (value.retentionTime)?.let {
      encoder.encodeSerializableElement(descriptor, 11, DurationSerializer, it)
    }
    if (value.rejectionCriterion.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12,
        CodeableConceptSerializer.listSerializer,
        value.rejectionCriterion,
      )
    if (value.handling.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13,
        SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
        value.handling,
      )
  }
}

internal object SpecimenDefinitionTypeTestedContainerSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Container> {
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
      element("material", CodeableConcept.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("cap", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("capacity", Quantity.serializer().descriptor, isOptional = true)
      element("minimumVolumeQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("minimumVolumeString", KotlinString.serializer().descriptor, isOptional = true)
      element("_minimumVolumeString", Element.serializer().descriptor, isOptional = true)
      element(
        "additive",
        listSerialDescriptor(
          lazyDescriptor {
            SpecimenDefinition.TypeTested.Container.Additive.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element("preparation", KotlinString.serializer().descriptor, isOptional = true)
      element("_preparation", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Container>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Container) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SpecimenDefinition.TypeTested.Container {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var material: CodeableConcept? = null
    var type: CodeableConcept? = null
    var cap: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var capacity: Quantity? = null
    var minimumVolumeQuantity: Quantity? = null
    var minimumVolumeString: KotlinString? = null
    var _minimumVolumeString: Element? = null
    var additive: List<SpecimenDefinition.TypeTested.Container.Additive>? = null
    var preparation: KotlinString? = null
    var _preparation: Element? = null
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
          material =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          cap =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> description = decoder.decodeStringElement(descriptor, i)
        7 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          capacity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        9 ->
          minimumVolumeQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        10 -> minimumVolumeString = decoder.decodeStringElement(descriptor, i)
        11 ->
          _minimumVolumeString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          additive =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedContainerAdditiveSerializer.listSerializer,
              null,
            )
        13 -> preparation = decoder.decodeStringElement(descriptor, i)
        14 ->
          _preparation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Container: " + i)
      }
    }
    return SpecimenDefinition.TypeTested.Container(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      material = material,
      type = type,
      cap = cap,
      description = R4String.of(description, _description),
      capacity = capacity,
      minimumVolume =
        SpecimenDefinition.TypeTested.Container.MinimumVolume.from(
          minimumVolumeQuantity,
          R4String.of(minimumVolumeString, _minimumVolumeString),
        ),
      additive = additive ?: listOf(),
      preparation = R4String.of(preparation, _preparation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SpecimenDefinition.TypeTested.Container,
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
    (value.material)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    (value.cap)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.capacity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, it)
    }
    when (val choice = value.minimumVolume) {
      null -> {}
      is SpecimenDefinition.TypeTested.Container.MinimumVolume.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 9, QuantitySerializer, choice.value)
      }
      is SpecimenDefinition.TypeTested.Container.MinimumVolume.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
        }
      }
    }
    if (value.additive.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12,
        SpecimenDefinitionTypeTestedContainerAdditiveSerializer.listSerializer,
        value.additive,
      )
    ((value.preparation?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.preparation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, ElementSerializer, it)
    }
  }
}

internal object SpecimenDefinitionTypeTestedContainerAdditiveSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Container.Additive> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Additive") {
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
      element("additiveCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("additiveReference", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Container.Additive>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container.Additive =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: SpecimenDefinition.TypeTested.Container.Additive,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SpecimenDefinition.TypeTested.Container.Additive {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var additiveCodeableConcept: CodeableConcept? = null
    var additiveReference: Reference? = null
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
          additiveCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          additiveReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Additive: " + i)
      }
    }
    return SpecimenDefinition.TypeTested.Container.Additive(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      additive =
        SpecimenDefinition.TypeTested.Container.Additive.Additive.from(
          additiveCodeableConcept,
          additiveReference,
        )
          ?: throw SerializationException(
            "Missing required property 'additive' on SpecimenDefinition.TypeTested.Container.Additive"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SpecimenDefinition.TypeTested.Container.Additive,
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
    when (val choice = value.additive) {
      is SpecimenDefinition.TypeTested.Container.Additive.Additive.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
      }
      is SpecimenDefinition.TypeTested.Container.Additive.Additive.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
  }
}

internal object SpecimenDefinitionTypeTestedHandlingSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Handling> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Handling") {
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
      element("temperatureQualifier", CodeableConcept.serializer().descriptor, isOptional = true)
      element("temperatureRange", Range.serializer().descriptor, isOptional = true)
      element("maxDuration", Duration.serializer().descriptor, isOptional = true)
      element("instruction", KotlinString.serializer().descriptor, isOptional = true)
      element("_instruction", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Handling>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Handling =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Handling) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SpecimenDefinition.TypeTested.Handling {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var temperatureQualifier: CodeableConcept? = null
    var temperatureRange: Range? = null
    var maxDuration: Duration? = null
    var instruction: KotlinString? = null
    var _instruction: Element? = null
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
          temperatureQualifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          temperatureRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        5 ->
          maxDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        6 -> instruction = decoder.decodeStringElement(descriptor, i)
        7 ->
          _instruction =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Handling: " + i)
      }
    }
    return SpecimenDefinition.TypeTested.Handling(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      temperatureQualifier = temperatureQualifier,
      temperatureRange = temperatureRange,
      maxDuration = maxDuration,
      instruction = R4String.of(instruction, _instruction),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SpecimenDefinition.TypeTested.Handling,
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
    (value.temperatureQualifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    (value.temperatureRange)?.let {
      encoder.encodeSerializableElement(descriptor, 4, RangeSerializer, it)
    }
    (value.maxDuration)?.let {
      encoder.encodeSerializableElement(descriptor, 5, DurationSerializer, it)
    }
    ((value.instruction?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.instruction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
  }
}

internal object SpecimenDefinitionSerializer : KSerializer<SpecimenDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SpecimenDefinition") {
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
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("typeCollected", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "patientPreparation",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("timeAspect", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_timeAspect", Element.serializer().descriptor, isOptional = true)
    b.element(
      "collection",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "typeTested",
      listSerialDescriptor(
        lazyDescriptor { SpecimenDefinition.TypeTested.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SpecimenDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SpecimenDefinition {
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
    var identifier: Identifier? = null
    var typeCollected: CodeableConcept? = null
    var patientPreparation: List<CodeableConcept>? = null
    var timeAspect: KotlinString? = null
    var _timeAspect: Element? = null
    var collection: List<CodeableConcept>? = null
    var typeTested: List<SpecimenDefinition.TypeTested>? = null
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
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        11 ->
          typeCollected =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          patientPreparation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 -> timeAspect = decoder.decodeStringElement(descriptor, i)
        14 ->
          _timeAspect =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          collection =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          typeTested =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SpecimenDefinition: " + i)
      }
    }
    return SpecimenDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      typeCollected = typeCollected,
      patientPreparation = patientPreparation ?: listOf(),
      timeAspect = R4String.of(timeAspect, _timeAspect),
      collection = collection ?: listOf(),
      typeTested = typeTested ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SpecimenDefinition,
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 10 + descriptorOffset, IdentifierSerializer, it)
    }
    (value.typeCollected)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.patientPreparation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.patientPreparation,
      )
    ((value.timeAspect?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.timeAspect?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ElementSerializer, it)
    }
    if (value.collection.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.collection,
      )
    if (value.typeTested.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        SpecimenDefinitionTypeTestedSerializer.listSerializer,
        value.typeTested,
      )
  }
}

internal object SpecimenDefinitionPolymorphicSerializer : KSerializer<SpecimenDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SpecimenDefinition") {
      SpecimenDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition) {
    encoder.encodeStructure(descriptor) {
      SpecimenDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition =
    decoder.decodeStructure(descriptor) {
      SpecimenDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
