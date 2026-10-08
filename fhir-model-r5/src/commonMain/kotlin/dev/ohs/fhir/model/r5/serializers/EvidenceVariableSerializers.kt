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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.EvidenceVariable
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.CharacteristicCombination
import dev.ohs.fhir.model.r5.terminologies.EvidenceVariableHandling
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

internal object EvidenceVariableCharacteristicSerializer :
  KSerializer<EvidenceVariable.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("exclude", KotlinBoolean.serializer().descriptor)
      optionalElement("_exclude", ElementSerializer.descriptor)
      optionalElement("definitionReference", ReferenceSerializer.descriptor)
      optionalElement("definitionCanonical", KotlinString.serializer().descriptor)
      optionalElement("_definitionCanonical", ElementSerializer.descriptor)
      optionalElement("definitionCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("definitionExpression", ExpressionSerializer.descriptor)
      optionalElement("definitionId", KotlinString.serializer().descriptor)
      optionalElement("_definitionId", ElementSerializer.descriptor)
      optionalElement(
        "definitionByTypeAndValue",
        EvidenceVariableCharacteristicDefinitionByTypeAndValueSerializer.descriptor,
      )
      optionalElement(
        "definitionByCombination",
        EvidenceVariableCharacteristicDefinitionByCombinationSerializer.descriptor,
      )
      optionalElement("instancesQuantity", QuantitySerializer.descriptor)
      optionalElement("instancesRange", RangeSerializer.descriptor)
      optionalElement("durationQuantity", QuantitySerializer.descriptor)
      optionalElement("durationRange", RangeSerializer.descriptor)
      optionalElement(
        "timeFromEvent",
        EvidenceVariableCharacteristicTimeFromEventSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<EvidenceVariable.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var exclude: KotlinBoolean? = null
    var _exclude: Element? = null
    var definitionReference: Reference? = null
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionCodeableConcept: CodeableConcept? = null
    var definitionExpression: Expression? = null
    var definitionId: KotlinString? = null
    var _definitionId: Element? = null
    var definitionByTypeAndValue: EvidenceVariable.Characteristic.DefinitionByTypeAndValue? = null
    var definitionByCombination: EvidenceVariable.Characteristic.DefinitionByCombination? = null
    var instancesQuantity: Quantity? = null
    var instancesRange: Range? = null
    var durationQuantity: Quantity? = null
    var durationRange: Range? = null
    var timeFromEvent: List<EvidenceVariable.Characteristic.TimeFromEvent>? = null
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
        3 -> linkId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        8 -> exclude = compositeDecoder.decodeBooleanElement(descriptor, i)
        9 ->
          _exclude =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          definitionReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        11 -> definitionCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _definitionCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          definitionCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          definitionExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        15 -> definitionId = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _definitionId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          definitionByTypeAndValue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCharacteristicDefinitionByTypeAndValueSerializer,
              null,
            )
        18 ->
          definitionByCombination =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCharacteristicDefinitionByCombinationSerializer,
              null,
            )
        19 ->
          instancesQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        20 ->
          instancesRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        21 ->
          durationQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        22 ->
          durationRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        23 ->
          timeFromEvent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCharacteristicTimeFromEventSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return EvidenceVariable.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = Id.of(linkId, _linkId),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      exclude = R5Boolean.of(exclude, _exclude),
      definitionReference = definitionReference,
      definitionCanonical = Canonical.of(definitionCanonical, _definitionCanonical),
      definitionCodeableConcept = definitionCodeableConcept,
      definitionExpression = definitionExpression,
      definitionId = Id.of(definitionId, _definitionId),
      definitionByTypeAndValue = definitionByTypeAndValue,
      definitionByCombination = definitionByCombination,
      instances = EvidenceVariable.Characteristic.Instances.from(instancesQuantity, instancesRange),
      duration = EvidenceVariable.Characteristic.Duration.from(durationQuantity, durationRange),
      timeFromEvent = timeFromEvent ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 8, value.exclude?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.exclude)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      ReferenceSerializer,
      value.definitionReference,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.definitionCanonical?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.definitionCanonical)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      CodeableConceptSerializer,
      value.definitionCodeableConcept,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      ExpressionSerializer,
      value.definitionExpression,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.definitionId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.definitionId)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17,
      EvidenceVariableCharacteristicDefinitionByTypeAndValueSerializer,
      value.definitionByTypeAndValue,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18,
      EvidenceVariableCharacteristicDefinitionByCombinationSerializer,
      value.definitionByCombination,
    )
    when (val choice = value.instances) {
      null -> {}
      is EvidenceVariable.Characteristic.Instances.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 19, QuantitySerializer, choice.value)
      }
      is EvidenceVariable.Characteristic.Instances.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 20, RangeSerializer, choice.value)
      }
    }
    when (val choice = value.duration) {
      null -> {}
      is EvidenceVariable.Characteristic.Duration.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 21, QuantitySerializer, choice.value)
      }
      is EvidenceVariable.Characteristic.Duration.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 22, RangeSerializer, choice.value)
      }
    }
    if (value.timeFromEvent.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23,
        EvidenceVariableCharacteristicTimeFromEventSerializer.listSerializer,
        value.timeFromEvent,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceVariableCharacteristicDefinitionByTypeAndValueSerializer :
  KSerializer<EvidenceVariable.Characteristic.DefinitionByTypeAndValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DefinitionByTypeAndValue") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("device", ReferenceSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
      optionalElement("valueId", KotlinString.serializer().descriptor)
      optionalElement("_valueId", ElementSerializer.descriptor)
      optionalElement("offset", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<EvidenceVariable.Characteristic.DefinitionByTypeAndValue>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): EvidenceVariable.Characteristic.DefinitionByTypeAndValue {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var method: List<CodeableConcept>? = null
    var device: Reference? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueReference: Reference? = null
    var valueId: KotlinString? = null
    var _valueId: Element? = null
    var offset: CodeableConcept? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        10 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        11 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        12 -> valueId = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _valueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          offset =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DefinitionByTypeAndValue: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return EvidenceVariable.Characteristic.DefinitionByTypeAndValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on EvidenceVariable.Characteristic.DefinitionByTypeAndValue"
          ),
      method = method ?: listOf(),
      device = device,
      `value` =
        EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.from(
          valueCodeableConcept,
          R5Boolean.of(valueBoolean, _valueBoolean),
          valueQuantity,
          valueRange,
          valueReference,
          Id.of(valueId, _valueId),
        )
          ?: throw SerializationException(
            "Missing required property 'value' on EvidenceVariable.Characteristic.DefinitionByTypeAndValue"
          ),
      offset = offset,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByTypeAndValue,
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    if (value.method.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.method,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.device)
    when (val choice = value.`value`) {
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, QuantitySerializer, choice.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 10, RangeSerializer, choice.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          11,
          ReferenceSerializer,
          choice.value,
        )
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      CodeableConceptSerializer,
      value.offset,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceVariableCharacteristicDefinitionByCombinationSerializer :
  KSerializer<EvidenceVariable.Characteristic.DefinitionByCombination> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DefinitionByCombination") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("threshold", Int.serializer().descriptor)
      optionalElement("_threshold", ElementSerializer.descriptor)
      optionalElement(
        "characteristic",
        listSerialDescriptor(
          lazyDescriptor { EvidenceVariableCharacteristicSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer:
    KSerializer<List<EvidenceVariable.Characteristic.DefinitionByCombination>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): EvidenceVariable.Characteristic.DefinitionByCombination {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var threshold: Int? = null
    var _threshold: Element? = null
    var characteristic: List<EvidenceVariable.Characteristic>? = null
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
        3 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> threshold = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _threshold =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          characteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCharacteristicSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DefinitionByCombination: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return EvidenceVariable.Characteristic.DefinitionByCombination(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Enumeration.of(if (code != null) CharacteristicCombination.fromCode(code) else null, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on EvidenceVariable.Characteristic.DefinitionByCombination"
          ),
      threshold = PositiveInt.of(threshold, _threshold),
      characteristic = characteristic ?: listOf(),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByCombination,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.threshold?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.threshold)
    if (value.characteristic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        EvidenceVariableCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceVariableCharacteristicTimeFromEventSerializer :
  KSerializer<EvidenceVariable.Characteristic.TimeFromEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TimeFromEvent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("eventCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("eventReference", ReferenceSerializer.descriptor)
      optionalElement("eventDateTime", KotlinString.serializer().descriptor)
      optionalElement("_eventDateTime", ElementSerializer.descriptor)
      optionalElement("eventId", KotlinString.serializer().descriptor)
      optionalElement("_eventId", ElementSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("range", RangeSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceVariable.Characteristic.TimeFromEvent>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.TimeFromEvent {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var eventCodeableConcept: CodeableConcept? = null
    var eventReference: Reference? = null
    var eventDateTime: KotlinString? = null
    var _eventDateTime: Element? = null
    var eventId: KotlinString? = null
    var _eventId: Element? = null
    var quantity: Quantity? = null
    var range: Range? = null
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
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          eventCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          eventReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 -> eventDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _eventDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> eventId = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _eventId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        13 ->
          range =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TimeFromEvent: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return EvidenceVariable.Characteristic.TimeFromEvent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      event =
        EvidenceVariable.Characteristic.TimeFromEvent.Event.from(
          eventCodeableConcept,
          eventReference,
          DateTime.of(
            if (eventDateTime != null) FhirDateTime.fromString(eventDateTime) else null,
            _eventDateTime,
          ),
          Id.of(eventId, _eventId),
        ),
      quantity = quantity,
      range = range,
    )
  }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic.TimeFromEvent) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    when (val choice = value.event) {
      null -> {}
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 12, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 13, RangeSerializer, value.range)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceVariableCategorySerializer : KSerializer<EvidenceVariable.Category> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Category") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceVariable.Category>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceVariable.Category {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        7 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Category: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return EvidenceVariable.Category(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name),
      `value` =
        EvidenceVariable.Category.Value.from(valueCodeableConcept, valueQuantity, valueRange),
    )
  }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Category) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    when (val choice = value.`value`) {
      null -> {}
      is EvidenceVariable.Category.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is EvidenceVariable.Category.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, QuantitySerializer, choice.value)
      }
      is EvidenceVariable.Category.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, RangeSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceVariableSerializer : FhirResourceSerializer<EvidenceVariable> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("EvidenceVariable")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("shortTitle", KotlinString.serializer().descriptor)
    b.optionalElement("_shortTitle", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
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
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("actual", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_actual", ElementSerializer.descriptor)
    b.optionalElement(
      "characteristic",
      EvidenceVariableCharacteristicSerializer.listSerializer.descriptor,
    )
    b.optionalElement("handling", KotlinString.serializer().descriptor)
    b.optionalElement("_handling", ElementSerializer.descriptor)
    b.optionalElement("category", EvidenceVariableCategorySerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): EvidenceVariable {
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
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var shortTitle: KotlinString? = null
    var _shortTitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var useContext: List<UsageContext>? = null
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
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var characteristic: List<EvidenceVariable.Characteristic>? = null
    var handling: KotlinString? = null
    var _handling: Element? = null
    var category: List<EvidenceVariable.Category>? = null
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
              IdentifierSerializer.listSerializer,
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
        22 -> shortTitle = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _shortTitle =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        36 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        37 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> copyrightLabel = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _copyrightLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> approvalDate = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 -> lastReviewDate = compositeDecoder.decodeStringElement(descriptor, i)
        46 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        48 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        49 ->
          editor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        50 ->
          reviewer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        51 ->
          endorser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        52 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        53 -> `actual` = compositeDecoder.decodeBooleanElement(descriptor, i)
        54 ->
          _actual =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        55 ->
          characteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCharacteristicSerializer.listSerializer,
              null,
            )
        56 -> handling = compositeDecoder.decodeStringElement(descriptor, i)
        57 ->
          _handling =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        58 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCategorySerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding EvidenceVariable: " + i)
      }
    }
    return EvidenceVariable(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        EvidenceVariable.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      shortTitle = R5String.of(shortTitle, _shortTitle),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on EvidenceVariable"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      useContext = useContext ?: listOf(),
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
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      `actual` = R5Boolean.of(`actual`, _actual),
      characteristic = characteristic ?: listOf(),
      handling =
        Enumeration.of(
          if (handling != null) EvidenceVariableHandling.fromCode(handling) else null,
          _handling,
        ),
      category = category ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: EvidenceVariable,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is EvidenceVariable.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is EvidenceVariable.VersionAlgorithm.Coding -> {
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.shortTitle?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.shortTitle)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.description)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.copyrightLabel?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyrightLabel)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      47 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.author.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      53 + descriptorOffset,
      value.`actual`?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 54 + descriptorOffset, value.`actual`)
    if (value.characteristic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        EvidenceVariableCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      56 + descriptorOffset,
      value.handling?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 57 + descriptorOffset, value.handling)
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        EvidenceVariableCategorySerializer.listSerializer,
        value.category,
      )
  }
}
