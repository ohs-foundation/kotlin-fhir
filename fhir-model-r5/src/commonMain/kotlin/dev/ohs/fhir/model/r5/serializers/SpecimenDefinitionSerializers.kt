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
      element("singleUse", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_singleUse", Element.serializer().descriptor, isOptional = true)
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
      element(
        "testingDestination",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
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
    var singleUse: KotlinBoolean? = null
    var _singleUse: Element? = null
    var rejectionCriterion: List<CodeableConcept>? = null
    var handling: List<SpecimenDefinition.TypeTested.Handling>? = null
    var testingDestination: List<CodeableConcept>? = null
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
        12 -> singleUse = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _singleUse =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          rejectionCriterion =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          handling =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
              null,
            )
        16 ->
          testingDestination =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
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
      isDerived = R5Boolean.of(isDerived, _isDerived),
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
      requirement = Markdown.of(requirement, _requirement),
      retentionTime = retentionTime,
      singleUse = R5Boolean.of(singleUse, _singleUse),
      rejectionCriterion = rejectionCriterion ?: listOf(),
      handling = handling ?: listOf(),
      testingDestination = testingDestination ?: listOf(),
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
    ((value.singleUse?.value))?.let { encoder.encodeBooleanElement(descriptor, 12, it) }
    (value.singleUse?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
    }
    if (value.rejectionCriterion.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        CodeableConceptSerializer.listSerializer,
        value.rejectionCriterion,
      )
    if (value.handling.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15,
        SpecimenDefinitionTypeTestedHandlingSerializer.listSerializer,
        value.handling,
      )
    if (value.testingDestination.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16,
        CodeableConceptSerializer.listSerializer,
        value.testingDestination,
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
      instruction = Markdown.of(instruction, _instruction),
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element(
      "derivedFromCanonical",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_derivedFromCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "derivedFromUri",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_derivedFromUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
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
            derivedFromCanonical?.getOrNull(index)?.let { it },
            _derivedFromCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'derivedFromCanonical' on SpecimenDefinition has neither a value nor an id/extension"
            )
        }),
      derivedFromUri =
        (kotlin.collections.List(maxOf(derivedFromUri?.size ?: 0, _derivedFromUri?.size ?: 0)) {
          index ->
          Uri.of(derivedFromUri?.getOrNull(index)?.let { it }, _derivedFromUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'derivedFromUri' on SpecimenDefinition has neither a value nor an id/extension"
            )
        }),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on SpecimenDefinition"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      subject = SpecimenDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(approvalDate?.let { FhirDate.fromString(it) }, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate?.let { FhirDate.fromString(it) }, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      typeCollected = typeCollected,
      patientPreparation = patientPreparation ?: listOf(),
      timeAspect = R5String.of(timeAspect, _timeAspect),
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, ElementSerializer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, IdentifierSerializer, it)
    }
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ElementSerializer, it)
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is SpecimenDefinition.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
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
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, ElementSerializer, it)
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, ElementSerializer, it)
    }
    (value.derivedFromCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.derivedFromCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.derivedFromUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.derivedFromUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, ElementSerializer, it)
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, ElementSerializer, it)
    }
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
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, ElementSerializer, it)
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, ElementSerializer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, ElementSerializer, it)
    }
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
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 42 + descriptorOffset, ElementSerializer, it)
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 44 + descriptorOffset, ElementSerializer, it)
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 45 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 46 + descriptorOffset, ElementSerializer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 47 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 48 + descriptorOffset, ElementSerializer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 49 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 50 + descriptorOffset, ElementSerializer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 51 + descriptorOffset, PeriodSerializer, it)
    }
    (value.typeCollected)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.patientPreparation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.patientPreparation,
      )
    ((value.timeAspect?.value))?.let {
      encoder.encodeStringElement(descriptor, 54 + descriptorOffset, it)
    }
    (value.timeAspect?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 55 + descriptorOffset, ElementSerializer, it)
    }
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
