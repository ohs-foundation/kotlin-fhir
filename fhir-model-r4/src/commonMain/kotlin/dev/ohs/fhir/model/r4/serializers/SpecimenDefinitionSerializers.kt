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
import dev.ohs.fhir.model.r4.FhirResourceSerializer
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

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested =
    decoder.decodeStructure(descriptor) {
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
          3 -> isDerived = decodeBooleanElement(descriptor, i)
          4 ->
            _isDerived = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> preference = decodeStringElement(descriptor, i)
          7 ->
            _preference = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            container =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SpecimenDefinitionTypeTestedContainerSerializer,
                null,
              )
          9 -> requirement = decodeStringElement(descriptor, i)
          10 ->
            _requirement = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            retentionTime =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          12 ->
            rejectionCriterion =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          13 ->
            handling =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TypeTested: " + i)
        }
      }
      SpecimenDefinition.TypeTested(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        isDerived = R4Boolean.of(isDerived, _isDerived),
        type = type,
        preference =
          Enumeration.of(
            if (preference != null)
              SpecimenDefinition.SpecimenContainedPreference.fromCode(preference)
            else null,
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

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.isDerived?.value)
      encodeElementIfNotNull(descriptor, 4, value.isDerived)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 6, value.preference.value?.code)
      encodeElementIfNotNull(descriptor, 7, value.preference)
      encodeSerializableIfNotNull(
        descriptor,
        8,
        SpecimenDefinitionTypeTestedContainerSerializer,
        value.container,
      )
      encodeStringIfNotNull(descriptor, 9, value.requirement?.value)
      encodeElementIfNotNull(descriptor, 10, value.requirement)
      encodeSerializableIfNotNull(descriptor, 11, DurationSerializer, value.retentionTime)
      if (value.rejectionCriterion.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          CodeableConceptSerializer.listSerializer,
          value.rejectionCriterion,
        )
      if (value.handling.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
          value.handling,
        )
    }
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

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container =
    decoder.decodeStructure(descriptor) {
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
            material =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            cap = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> description = decodeStringElement(descriptor, i)
          7 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> capacity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 ->
            minimumVolumeQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          10 -> minimumVolumeString = decodeStringElement(descriptor, i)
          11 ->
            _minimumVolumeString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            additive =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SpecimenDefinitionTypeTestedContainerAdditiveSerializer.listSerializer,
                null,
              )
          13 -> preparation = decodeStringElement(descriptor, i)
          14 ->
            _preparation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Container: " + i)
        }
      }
      SpecimenDefinition.TypeTested.Container(
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

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Container) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.material)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.cap)
      encodeStringIfNotNull(descriptor, 6, value.description?.value)
      encodeElementIfNotNull(descriptor, 7, value.description)
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.capacity)
      when (val choice = value.minimumVolume) {
        null -> {}
        is SpecimenDefinition.TypeTested.Container.MinimumVolume.Quantity -> {
          encodeSerializableElement(descriptor, 9, QuantitySerializer, choice.value)
        }
        is SpecimenDefinition.TypeTested.Container.MinimumVolume.String -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
      }
      if (value.additive.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          SpecimenDefinitionTypeTestedContainerAdditiveSerializer.listSerializer,
          value.additive,
        )
      encodeStringIfNotNull(descriptor, 13, value.preparation?.value)
      encodeElementIfNotNull(descriptor, 14, value.preparation)
    }
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

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container.Additive =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var additiveCodeableConcept: CodeableConcept? = null
      var additiveReference: Reference? = null
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
            additiveCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            additiveReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Additive: " + i)
        }
      }
      SpecimenDefinition.TypeTested.Container.Additive(
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
      when (val choice = value.additive) {
        is SpecimenDefinition.TypeTested.Container.Additive.Additive.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is SpecimenDefinition.TypeTested.Container.Additive.Additive.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
      }
    }
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

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Handling =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var temperatureQualifier: CodeableConcept? = null
      var temperatureRange: Range? = null
      var maxDuration: Duration? = null
      var instruction: KotlinString? = null
      var _instruction: Element? = null
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
            temperatureQualifier =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            temperatureRange =
              decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          5 ->
            maxDuration = decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          6 -> instruction = decodeStringElement(descriptor, i)
          7 ->
            _instruction = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Handling: " + i)
        }
      }
      SpecimenDefinition.TypeTested.Handling(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        temperatureQualifier = temperatureQualifier,
        temperatureRange = temperatureRange,
        maxDuration = maxDuration,
        instruction = R4String.of(instruction, _instruction),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Handling) {
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
      encodeSerializableIfNotNull(
        descriptor,
        3,
        CodeableConceptSerializer,
        value.temperatureQualifier,
      )
      encodeSerializableIfNotNull(descriptor, 4, RangeSerializer, value.temperatureRange)
      encodeSerializableIfNotNull(descriptor, 5, DurationSerializer, value.maxDuration)
      encodeStringIfNotNull(descriptor, 6, value.instruction?.value)
      encodeElementIfNotNull(descriptor, 7, value.instruction)
    }
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SpecimenDefinition,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.typeCollected,
    )
    if (value.patientPreparation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.patientPreparation,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.timeAspect?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.timeAspect)
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
