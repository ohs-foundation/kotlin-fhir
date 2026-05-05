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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.SpecimenDefinition
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
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

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SpecimenDefinition.TypeTested {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> isDerived = decoder.decodeBooleanElement(__desc, __i)
        4 ->
          _isDerived =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.isDerivedSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 -> preference = decoder.decodeStringElement(__desc, __i)
        7 ->
          _preference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.isDerivedSer, null)
        8 ->
          container =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containerSer, null)
        9 -> requirement = decoder.decodeStringElement(__desc, __i)
        10 ->
          _requirement =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.isDerivedSer, null)
        11 ->
          retentionTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.retentionTimeSer, null)
        12 ->
          rejectionCriterion =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.rejectionCriterionSer,
              null,
            )
        13 ->
          handling =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.handlingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TypeTested: " + __i)
      }
    }
    return SpecimenDefinition.TypeTested(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      isDerived = R4bBoolean.of(isDerived, _isDerived),
      type = type,
      preference =
        Enumeration.of(
          SpecimenDefinition.SpecimenContainedPreference.fromCode(preference!!),
          _preference,
        ),
      container = container,
      requirement = R4bString.of(requirement, _requirement),
      retentionTime = retentionTime,
      rejectionCriterion = rejectionCriterion ?: listOf(),
      handling = handling ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SpecimenDefinition.TypeTested) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.isDerived?.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.isDerived?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.isDerivedSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    ((value.preference.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.preference.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.isDerivedSer, it)
    }
    (value.container)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containerSer, it)
    }
    ((value.requirement?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.requirement?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.isDerivedSer, it)
    }
    (value.retentionTime)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.retentionTimeSer, it)
    }
    if (value.rejectionCriterion.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        12,
        Hoisted.rejectionCriterionSer,
        value.rejectionCriterion,
      )
    if (value.handling.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.handlingSer, value.handling)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val isDerivedSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val containerSer: KSerializer<SpecimenDefinition.TypeTested.Container> =
      SpecimenDefinition.TypeTested.Container.serializer()

    public val retentionTimeSer: KSerializer<Duration> = Duration.serializer()

    public val rejectionCriterionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)

    public val handlingSerInner: KSerializer<SpecimenDefinition.TypeTested.Handling> =
      SpecimenDefinition.TypeTested.Handling.serializer()

    public val handlingSer: KSerializer<List<SpecimenDefinition.TypeTested.Handling>> =
      ListSerializer(Hoisted.handlingSerInner)
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

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Container) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SpecimenDefinition.TypeTested.Container {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          material =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.materialSer, null)
        4 ->
          type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.materialSer, null)
        5 -> cap = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.materialSer, null)
        6 -> description = decoder.decodeStringElement(__desc, __i)
        7 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        8 ->
          capacity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.capacitySer, null)
        9 ->
          minimumVolumeQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.capacitySer, null)
        10 -> minimumVolumeString = decoder.decodeStringElement(__desc, __i)
        11 ->
          _minimumVolumeString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        12 ->
          additive =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.additiveSer, null)
        13 -> preparation = decoder.decodeStringElement(__desc, __i)
        14 ->
          _preparation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Container: " + __i)
      }
    }
    return SpecimenDefinition.TypeTested.Container(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      material = material,
      type = type,
      cap = cap,
      description = R4bString.of(description, _description),
      capacity = capacity,
      minimumVolume =
        SpecimenDefinition.TypeTested.Container.MinimumVolume.from(
          minimumVolumeQuantity,
          R4bString.of(minimumVolumeString, _minimumVolumeString),
        ),
      additive = additive ?: listOf(),
      preparation = R4bString.of(preparation, _preparation),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SpecimenDefinition.TypeTested.Container,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.material)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.materialSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.materialSer, it) }
    (value.cap)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.materialSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.descriptionSer, it)
    }
    (value.capacity)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.capacitySer, it) }
    when (val __d = value.minimumVolume) {
      null -> {}
      is SpecimenDefinition.TypeTested.Container.MinimumVolume.Quantity -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.capacitySer, __d.value)
      }
      is SpecimenDefinition.TypeTested.Container.MinimumVolume.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.descriptionSer, it)
        }
      }
    }
    if (value.additive.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.additiveSer, value.additive)
    ((value.preparation?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.preparation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val materialSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val capacitySer: KSerializer<Quantity> = Quantity.serializer()

    public val additiveSerInner: KSerializer<SpecimenDefinition.TypeTested.Container.Additive> =
      SpecimenDefinition.TypeTested.Container.Additive.serializer()

    public val additiveSer: KSerializer<List<SpecimenDefinition.TypeTested.Container.Additive>> =
      ListSerializer(Hoisted.additiveSerInner)
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

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container.Additive =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SpecimenDefinition.TypeTested.Container.Additive,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SpecimenDefinition.TypeTested.Container.Additive {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var additiveCodeableConcept: CodeableConcept? = null
    var additiveReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          additiveCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.additiveCodeableConceptSer,
              null,
            )
        4 ->
          additiveReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.additiveReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Additive: " + __i)
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
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SpecimenDefinition.TypeTested.Container.Additive,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.additive) {
      null -> {}
      is SpecimenDefinition.TypeTested.Container.Additive.Additive.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.additiveCodeableConceptSer, __d.value)
      }
      is SpecimenDefinition.TypeTested.Container.Additive.Additive.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.additiveReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val additiveCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val additiveReferenceSer: KSerializer<Reference> = Reference.serializer()
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

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Handling =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Handling) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SpecimenDefinition.TypeTested.Handling {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var temperatureQualifier: CodeableConcept? = null
    var temperatureRange: Range? = null
    var maxDuration: Duration? = null
    var instruction: KotlinString? = null
    var _instruction: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          temperatureQualifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.temperatureQualifierSer,
              null,
            )
        4 ->
          temperatureRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.temperatureRangeSer,
              null,
            )
        5 ->
          maxDuration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.maxDurationSer, null)
        6 -> instruction = decoder.decodeStringElement(__desc, __i)
        7 ->
          _instruction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.instructionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Handling: " + __i)
      }
    }
    return SpecimenDefinition.TypeTested.Handling(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      temperatureQualifier = temperatureQualifier,
      temperatureRange = temperatureRange,
      maxDuration = maxDuration,
      instruction = R4bString.of(instruction, _instruction),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SpecimenDefinition.TypeTested.Handling,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.temperatureQualifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.temperatureQualifierSer, it)
    }
    (value.temperatureRange)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.temperatureRangeSer, it)
    }
    (value.maxDuration)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.maxDurationSer, it)
    }
    ((value.instruction?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.instruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.instructionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val temperatureQualifierSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val temperatureRangeSer: KSerializer<Range> = Range.serializer()

    public val maxDurationSer: KSerializer<Duration> = Duration.serializer()

    public val instructionSer: KSerializer<Element> = Element.serializer()
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SpecimenDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): SpecimenDefinition {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          typeCollected =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeCollectedSer, null)
        12 ->
          patientPreparation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.patientPreparationSer,
              null,
            )
        13 -> timeAspect = decoder.decodeStringElement(__desc, __i)
        14 ->
          _timeAspect =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          collection =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.patientPreparationSer,
              null,
            )
        16 ->
          typeTested =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeTestedSer, null)
        else -> throw SerializationException("Unexpected index decoding SpecimenDefinition: " + __i)
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
      timeAspect = R4bString.of(timeAspect, _timeAspect),
      collection = collection ?: listOf(),
      typeTested = typeTested ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: SpecimenDefinition,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, it)
    }
    (value.typeCollected)?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.typeCollectedSer, it)
    }
    if (value.patientPreparation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        12 + __off,
        Hoisted.patientPreparationSer,
        value.patientPreparation,
      )
    ((value.timeAspect?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.timeAspect?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.collection.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15 + __off,
        Hoisted.patientPreparationSer,
        value.collection,
      )
    if (value.typeTested.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.typeTestedSer, value.typeTested)
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

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeCollectedSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val patientPreparationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeCollectedSer)

    public val typeTestedSerInner: KSerializer<SpecimenDefinition.TypeTested> =
      SpecimenDefinition.TypeTested.serializer()

    public val typeTestedSer: KSerializer<List<SpecimenDefinition.TypeTested>> =
      ListSerializer(Hoisted.typeTestedSerInner)
  }
}

internal object SpecimenDefinitionPolymorphicSerializer : KSerializer<SpecimenDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SpecimenDefinition") {
      SpecimenDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition) {
    encoder.encodeStructure(descriptor) {
      SpecimenDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition =
    decoder.decodeStructure(descriptor) {
      SpecimenDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
