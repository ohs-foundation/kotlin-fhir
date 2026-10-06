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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.SpecimenDefinition
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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
      optionalElement("singleUse", KotlinBoolean.serializer().descriptor)
      optionalElement("_singleUse", ElementSerializer.descriptor)
      optionalElement("rejectionCriterion", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "handling",
        SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer.descriptor,
      )
      optionalElement("testingDestination", CodeableConceptSerializer.listSerializer.descriptor)
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
      var singleUse: KotlinBoolean? = null
      var _singleUse: Element? = null
      var rejectionCriterion: List<CodeableConcept>? = null
      var handling: List<SpecimenDefinition.TypeTested.Handling>? = null
      var testingDestination: List<CodeableConcept>? = null
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
          12 -> singleUse = decodeBooleanElement(descriptor, i)
          13 ->
            _singleUse = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            rejectionCriterion =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          15 ->
            handling =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
                null,
              )
          16 ->
            testingDestination =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
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
        isDerived = R5Boolean.of(isDerived, _isDerived),
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
        requirement = Markdown.of(requirement, _requirement),
        retentionTime = retentionTime,
        singleUse = R5Boolean.of(singleUse, _singleUse),
        rejectionCriterion = rejectionCriterion ?: listOf(),
        handling = handling ?: listOf(),
        testingDestination = testingDestination ?: listOf(),
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
      encodeBooleanIfNotNull(descriptor, 12, value.singleUse?.value)
      encodeElementIfNotNull(descriptor, 13, value.singleUse)
      if (value.rejectionCriterion.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          CodeableConceptSerializer.listSerializer,
          value.rejectionCriterion,
        )
      if (value.handling.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
          value.handling,
        )
      if (value.testingDestination.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          CodeableConceptSerializer.listSerializer,
          value.testingDestination,
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
        description = Markdown.of(description, _description),
        capacity = capacity,
        minimumVolume =
          SpecimenDefinition.TypeTested.Container.MinimumVolume.from(
            minimumVolumeQuantity,
            R5String.of(minimumVolumeString, _minimumVolumeString),
          ),
        additive = additive ?: listOf(),
        preparation = Markdown.of(preparation, _preparation),
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
        instruction = Markdown.of(instruction, _instruction),
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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("derivedFromCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_derivedFromCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("derivedFromUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_derivedFromUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: Identifier? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var derivedFromCanonical: List<KotlinString?>? = null
    var _derivedFromCanonical: List<Element?>? = null
    var derivedFromUri: List<KotlinString?>? = null
    var _derivedFromUri: List<Element?>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          derivedFromCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        23 ->
          _derivedFromCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        24 ->
          derivedFromUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        25 ->
          _derivedFromUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        26 -> status = decoder.decodeStringElement(descriptor, i)
        27 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        29 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        31 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        32 -> date = decoder.decodeStringElement(descriptor, i)
        33 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> publisher = decoder.decodeStringElement(descriptor, i)
        35 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        37 -> description = decoder.decodeStringElement(descriptor, i)
        38 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        40 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        41 -> purpose = decoder.decodeStringElement(descriptor, i)
        42 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 -> copyright = decoder.decodeStringElement(descriptor, i)
        44 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        46 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        48 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        49 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        50 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        51 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        52 ->
          typeCollected =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        53 ->
          patientPreparation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        54 -> timeAspect = decoder.decodeStringElement(descriptor, i)
        55 ->
          _timeAspect =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        56 ->
          collection =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        57 ->
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
      url = Uri.of(url, _url),
      identifier = identifier,
      version = R5String.of(version, _version),
      versionAlgorithm =
        SpecimenDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      derivedFromCanonical =
        (kotlin.collections.List(
          maxOf(derivedFromCanonical?.size ?: 0, _derivedFromCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            derivedFromCanonical?.getOrNull(index),
            _derivedFromCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'derivedFromCanonical' on SpecimenDefinition has neither a value nor an id/extension"
            )
        }),
      derivedFromUri =
        (kotlin.collections.List(maxOf(derivedFromUri?.size ?: 0, _derivedFromUri?.size ?: 0)) {
          index ->
          Uri.of(derivedFromUri?.getOrNull(index), _derivedFromUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'derivedFromUri' on SpecimenDefinition has neither a value nor an id/extension"
            )
        }),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on SpecimenDefinition"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      subject = SpecimenDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      typeCollected = typeCollected,
      patientPreparation = patientPreparation ?: listOf(),
      timeAspect = R5String.of(timeAspect, _timeAspect),
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is SpecimenDefinition.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is SpecimenDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    if (value.derivedFromCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        22 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFromCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        23 + descriptorOffset,
        value.derivedFromCanonical,
      )
    }
    if (value.derivedFromUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        24 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFromUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 25 + descriptorOffset, value.derivedFromUri)
    }
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 28 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is SpecimenDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is SpecimenDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 45 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.copyrightLabel)
    encoder.encodeStringIfNotNull(
      descriptor,
      47 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      49 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      52 + descriptorOffset,
      CodeableConceptSerializer,
      value.typeCollected,
    )
    if (value.patientPreparation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.patientPreparation,
      )
    encoder.encodeStringIfNotNull(descriptor, 54 + descriptorOffset, value.timeAspect?.value)
    encoder.encodeElementIfNotNull(descriptor, 55 + descriptorOffset, value.timeAspect)
    if (value.collection.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.collection,
      )
    if (value.typeTested.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        SpecimenDefinitionTypeTestedSerializer.listSerializer,
        value.typeTested,
      )
  }
}
