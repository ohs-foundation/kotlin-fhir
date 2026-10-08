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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.SpecimenDefinition
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SpecimenContainedPreference
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

internal object SpecimenDefinitionTypeTestedSerializer :
  KSerializer<SpecimenDefinition.TypeTested> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TypeTested") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("isDerived", KotlinBoolean.serializer().descriptor)
      optionalElement("_isDerived", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("preference", KotlinString.serializer().descriptor)
      optionalElement("_preference", ElementSerializer.descriptor)
      optionalElement("container", SpecimenDefinitionTypeTestedContainerSerializer.descriptor)
      optionalElement("requirement", KotlinString.serializer().descriptor)
      optionalElement("_requirement", ElementSerializer.descriptor)
      optionalElement("retentionTime", DurationSerializer.descriptor)
      optionalElement("rejectionCriterion", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "handling",
        SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> isDerived = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _isDerived =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> preference = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _preference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          container =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedContainerSerializer,
              null,
            )
        9 -> requirement = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _requirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          retentionTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        12 ->
          rejectionCriterion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          handling =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TypeTested: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SpecimenDefinition.TypeTested(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      isDerived = R4bBoolean.of(isDerived, _isDerived),
      type = type,
      preference =
        Enumeration.of(
          if (preference != null) SpecimenContainedPreference.fromCode(preference) else null,
          _preference,
        )
          ?: throw SerializationException(
            "Missing required property 'preference' on SpecimenDefinition.TypeTested"
          ),
      container = container,
      requirement = R4bString.of(requirement, _requirement),
      retentionTime = retentionTime,
      rejectionCriterion = rejectionCriterion ?: listOf(),
      handling = handling ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.isDerived?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.isDerived)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.preference.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.preference)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      SpecimenDefinitionTypeTestedContainerSerializer,
      value.container,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.requirement?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.requirement)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      DurationSerializer,
      value.retentionTime,
    )
    if (value.rejectionCriterion.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        CodeableConceptSerializer.listSerializer,
        value.rejectionCriterion,
      )
    if (value.handling.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13,
        SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
        value.handling,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SpecimenDefinitionTypeTestedContainerSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Container> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Container") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("material", CodeableConceptSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("cap", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("capacity", QuantitySerializer.descriptor)
      optionalElement("minimumVolumeQuantity", QuantitySerializer.descriptor)
      optionalElement("minimumVolumeString", KotlinString.serializer().descriptor)
      optionalElement("_minimumVolumeString", ElementSerializer.descriptor)
      optionalElement(
        "additive",
        SpecimenDefinitionTypeTestedContainerAdditiveSerializer.listSerializer.descriptor,
      )
      optionalElement("preparation", KotlinString.serializer().descriptor)
      optionalElement("_preparation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Container>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          material =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          cap =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          capacity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        9 ->
          minimumVolumeQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        10 -> minimumVolumeString = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _minimumVolumeString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          additive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedContainerAdditiveSerializer.listSerializer,
              null,
            )
        13 -> preparation = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _preparation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Container: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Container) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.material,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.cap,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.description)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.capacity)
    when (val choice = value.minimumVolume) {
      null -> {}
      is SpecimenDefinition.TypeTested.Container.MinimumVolume.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, QuantitySerializer, choice.value)
      }
      is SpecimenDefinition.TypeTested.Container.MinimumVolume.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
    }
    if (value.additive.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        SpecimenDefinitionTypeTestedContainerAdditiveSerializer.listSerializer,
        value.additive,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.preparation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.preparation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SpecimenDefinitionTypeTestedContainerAdditiveSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Container.Additive> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Additive") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("additiveCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("additiveReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Container.Additive>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container.Additive {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var additiveCodeableConcept: CodeableConcept? = null
    var additiveReference: Reference? = null
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
          additiveCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          additiveReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Additive: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(
    encoder: Encoder,
    `value`: SpecimenDefinition.TypeTested.Container.Additive,
  ) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.additive) {
      is SpecimenDefinition.TypeTested.Container.Additive.Additive.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is SpecimenDefinition.TypeTested.Container.Additive.Additive.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SpecimenDefinitionTypeTestedHandlingSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Handling> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Handling") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("temperatureQualifier", CodeableConceptSerializer.descriptor)
      optionalElement("temperatureRange", RangeSerializer.descriptor)
      optionalElement("maxDuration", DurationSerializer.descriptor)
      optionalElement("instruction", KotlinString.serializer().descriptor)
      optionalElement("_instruction", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Handling>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Handling {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var temperatureQualifier: CodeableConcept? = null
    var temperatureRange: Range? = null
    var maxDuration: Duration? = null
    var instruction: KotlinString? = null
    var _instruction: Element? = null
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
          temperatureQualifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          temperatureRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        5 ->
          maxDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        6 -> instruction = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _instruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Handling: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Handling) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.temperatureQualifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      RangeSerializer,
      value.temperatureRange,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      DurationSerializer,
      value.maxDuration,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.instruction?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.instruction)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SpecimenDefinitionSerializer : FhirResourceSerializer<SpecimenDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SpecimenDefinition")

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
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("typeCollected", CodeableConceptSerializer.descriptor)
    b.optionalElement("patientPreparation", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("timeAspect", KotlinString.serializer().descriptor)
    b.optionalElement("_timeAspect", ElementSerializer.descriptor)
    b.optionalElement("collection", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "typeTested",
      SpecimenDefinitionTypeTestedSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
              IdentifierSerializer,
              null,
            )
        11 ->
          typeCollected =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          patientPreparation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 -> timeAspect = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _timeAspect =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          collection =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          typeTested =
            compositeDecoder.decodeNullableSerializableElement(
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
      timeAspect = R4bString.of(timeAspect, _timeAspect),
      collection = collection ?: listOf(),
      typeTested = typeTested ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SpecimenDefinition,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.typeCollected,
    )
    if (value.patientPreparation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.patientPreparation,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.timeAspect?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.timeAspect)
    if (value.collection.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.collection,
      )
    if (value.typeTested.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        SpecimenDefinitionTypeTestedSerializer.listSerializer,
        value.typeTested,
      )
  }
}
