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
import dev.ohs.fhir.model.r5.terminologies.SpecimenContainedPreference
import kotlin.Boolean as KotlinBoolean
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

internal object SpecimenDefinitionTypeTestedSerializer :
  FhirSerializer<SpecimenDefinition.TypeTested> {
  override val descriptor: SerialDescriptor = buildDescriptor("TypeTested", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("isDerived")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("preference")
    b.optionalElement("container", SpecimenDefinitionTypeTestedContainerSerializer.descriptor)
    b.strPrim("requirement")
    b.optionalElement("retentionTime", DurationSerializer.descriptor)
    b.boolPrim("singleUse")
    b.optionalElement("rejectionCriterion", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "handling",
      SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer.descriptor,
    )
    b.optionalElement("testingDestination", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var isDerived: KotlinBoolean? = null
    var _isDerived: Element? = null
    var type: CodeableConcept? = null
    var preference: SpecimenContainedPreference? = null
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
        6 ->
          preference =
            SpecimenContainedPreference.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
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
        12 -> singleUse = compositeDecoder.decodeBooleanElement(descriptor, i)
        13 ->
          _singleUse =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          rejectionCriterion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          handling =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
              null,
            )
        16 ->
          testingDestination =
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
    return SpecimenDefinition.TypeTested(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      isDerived = R5Boolean.of(isDerived, _isDerived),
      type = type,
      preference =
        required(
          Enumeration.of(preference, _preference),
          "SpecimenDefinition.TypeTested",
          "preference",
        ),
      container = container,
      requirement = Markdown.of(requirement, _requirement),
      retentionTime = retentionTime,
      singleUse = R5Boolean.of(singleUse, _singleUse),
      rejectionCriterion = listOrEmpty(rejectionCriterion),
      handling = listOrEmpty(handling),
      testingDestination = listOrEmpty(testingDestination),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 12, value.singleUse?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.singleUse)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      CodeableConceptSerializer.listSerializer,
      value.rejectionCriterion,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
      value.handling,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16,
      CodeableConceptSerializer.listSerializer,
      value.testingDestination,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SpecimenDefinitionTypeTestedContainerSerializer :
  FhirSerializer<SpecimenDefinition.TypeTested.Container> {
  override val descriptor: SerialDescriptor = buildDescriptor("Container", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Container>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("material", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("cap", CodeableConceptSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("capacity", QuantitySerializer.descriptor)
    b.optionalElement("minimumVolumeQuantity", QuantitySerializer.descriptor)
    b.strPrim("minimumVolumeString")
    b.optionalElement(
      "additive",
      SpecimenDefinitionTypeTestedContainerAdditiveSerializer.listSerializer.descriptor,
    )
    b.strPrim("preparation")
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SpecimenDefinition.TypeTested.Container(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      additive = listOrEmpty(additive),
      preparation = Markdown.of(preparation, _preparation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Container) {
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
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<SpecimenDefinition.TypeTested.Container.Additive> {
  override val descriptor: SerialDescriptor = buildDescriptor("Additive", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Container.Additive>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("additiveCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("additiveReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container.Additive {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SpecimenDefinition.TypeTested.Container.Additive(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      additive =
        required(
          SpecimenDefinition.TypeTested.Container.Additive.Additive.from(
            additiveCodeableConcept,
            additiveReference,
          ),
          "SpecimenDefinition.TypeTested.Container.Additive",
          "additive",
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: SpecimenDefinition.TypeTested.Container.Additive,
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
  FhirSerializer<SpecimenDefinition.TypeTested.Handling> {
  override val descriptor: SerialDescriptor = buildDescriptor("Handling", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SpecimenDefinition.TypeTested.Handling>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("temperatureQualifier", CodeableConceptSerializer.descriptor)
    b.optionalElement("temperatureRange", RangeSerializer.descriptor)
    b.optionalElement("maxDuration", DurationSerializer.descriptor)
    b.strPrim("instruction")
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Handling {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SpecimenDefinition.TypeTested.Handling(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      temperatureQualifier = temperatureQualifier,
      temperatureRange = temperatureRange,
      maxDuration = maxDuration,
      instruction = Markdown.of(instruction, _instruction),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Handling) {
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
    b.strPrim("url")
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.strPrim("version")
    b.strPrim("versionAlgorithmString")
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("title")
    b.strPrimList("derivedFromCanonical")
    b.strPrimList("derivedFromUri")
    b.strPrim("status")
    b.boolPrim("experimental")
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("copyright")
    b.strPrim("copyrightLabel")
    b.strPrim("approvalDate")
    b.strPrim("lastReviewDate")
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("typeCollected", CodeableConceptSerializer.descriptor)
    b.optionalElement("patientPreparation", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("timeAspect")
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
    var status: PublicationStatus? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: FhirDateTime? = null
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
    var approvalDate: FhirDate? = null
    var _approvalDate: Element? = null
    var lastReviewDate: FhirDate? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
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
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> versionAlgorithmString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          versionAlgorithmCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        18 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          derivedFromCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        23 ->
          _derivedFromCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        24 ->
          derivedFromUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        25 ->
          _derivedFromUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        26 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        27 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        29 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          subjectCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        31 ->
          subjectReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        32 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        33 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        37 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        40 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        41 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 -> copyrightLabel = compositeDecoder.decodeStringElement(descriptor, i)
        46 ->
          _copyrightLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 ->
          approvalDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        48 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 ->
          lastReviewDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        50 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        51 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        52 ->
          typeCollected =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        53 ->
          patientPreparation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        54 -> timeAspect = compositeDecoder.decodeStringElement(descriptor, i)
        55 ->
          _timeAspect =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        56 ->
          collection =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        57 ->
          typeTested =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val derivedFromCanonical_ =
      List(maxSize(derivedFromCanonical, _derivedFromCanonical)) { index ->
        entryRequired(
          Canonical.of(at(derivedFromCanonical, index), at(_derivedFromCanonical, index)),
          "SpecimenDefinition",
          "derivedFromCanonical",
        )
      }
    val derivedFromUri_ =
      List(maxSize(derivedFromUri, _derivedFromUri)) { index ->
        entryRequired(
          Uri.of(at(derivedFromUri, index), at(_derivedFromUri, index)),
          "SpecimenDefinition",
          "derivedFromUri",
        )
      }
    return SpecimenDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      derivedFromCanonical = derivedFromCanonical_,
      derivedFromUri = derivedFromUri_,
      status = required(Enumeration.of(status, _status), "SpecimenDefinition", "status"),
      experimental = R5Boolean.of(experimental, _experimental),
      subject = SpecimenDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(date, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(approvalDate, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      typeCollected = typeCollected,
      patientPreparation = listOrEmpty(patientPreparation),
      timeAspect = R5String.of(timeAspect, _timeAspect),
      collection = listOrEmpty(collection),
      typeTested = listOrEmpty(typeTested),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is SpecimenDefinition.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is SpecimenDefinition.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    if (!value.derivedFromCanonical.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        22 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFromCanonical.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        23 + descriptorOffset,
        value.derivedFromCanonical,
      )
    }
    if (!value.derivedFromUri.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        24 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFromUri.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        25 + descriptorOffset,
        value.derivedFromUri,
      )
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is SpecimenDefinition.Subject.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is SpecimenDefinition.Subject.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      32 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      39 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      40 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.copyrightLabel?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.copyrightLabel)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      47 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      49 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      52 + descriptorOffset,
      CodeableConceptSerializer,
      value.typeCollected,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      53 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.patientPreparation,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      54 + descriptorOffset,
      value.timeAspect?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 55 + descriptorOffset, value.timeAspect)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      56 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.collection,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      57 + descriptorOffset,
      SpecimenDefinitionTypeTestedSerializer.listSerializer,
      value.typeTested,
    )
  }
}
