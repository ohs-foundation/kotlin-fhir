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

internal object EvidenceVariableCharacteristicSerializer :
  KSerializer<EvidenceVariable.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("exclude", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exclude", Element.serializer().descriptor, isOptional = true)
      element("definitionReference", Reference.serializer().descriptor, isOptional = true)
      element("definitionCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionCanonical", Element.serializer().descriptor, isOptional = true)
      element(
        "definitionCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("definitionExpression", Expression.serializer().descriptor, isOptional = true)
      element("definitionId", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionId", Element.serializer().descriptor, isOptional = true)
      element(
        "definitionByTypeAndValue",
        lazyDescriptor {
          EvidenceVariable.Characteristic.DefinitionByTypeAndValue.serializer().descriptor
        },
        isOptional = true,
      )
      element(
        "definitionByCombination",
        lazyDescriptor {
          EvidenceVariable.Characteristic.DefinitionByCombination.serializer().descriptor
        },
        isOptional = true,
      )
      element("instancesQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("instancesRange", Range.serializer().descriptor, isOptional = true)
      element("durationQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("durationRange", Range.serializer().descriptor, isOptional = true)
      element(
        "timeFromEvent",
        listSerialDescriptor(
          lazyDescriptor { EvidenceVariable.Characteristic.TimeFromEvent.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): EvidenceVariable.Characteristic {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        7 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        8 -> exclude = decoder.decodeBooleanElement(descriptor, i)
        9 ->
          _exclude =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        10 ->
          definitionReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionReferenceSer,
              null,
            )
        11 -> definitionCanonical = decoder.decodeStringElement(descriptor, i)
        12 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        13 ->
          definitionCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCodeableConceptSer,
              null,
            )
        14 ->
          definitionExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionExpressionSer,
              null,
            )
        15 -> definitionId = decoder.decodeStringElement(descriptor, i)
        16 ->
          _definitionId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        17 ->
          definitionByTypeAndValue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionByTypeAndValueSer,
              null,
            )
        18 ->
          definitionByCombination =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionByCombinationSer,
              null,
            )
        19 ->
          instancesQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instancesQuantitySer,
              null,
            )
        20 ->
          instancesRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instancesRangeSer,
              null,
            )
        21 ->
          durationQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instancesQuantitySer,
              null,
            )
        22 ->
          durationRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instancesRangeSer,
              null,
            )
        23 ->
          timeFromEvent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timeFromEventSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: EvidenceVariable.Characteristic,
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
    ((value.linkId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.linkIdSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.noteSer, value.note)
    ((value.exclude?.value))?.let { encoder.encodeBooleanElement(descriptor, 8, it) }
    (value.exclude?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.linkIdSer, it)
    }
    (value.definitionReference)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.definitionReferenceSer, it)
    }
    ((value.definitionCanonical?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.definitionCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.linkIdSer, it)
    }
    (value.definitionCodeableConcept)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.definitionCodeableConceptSer, it)
    }
    (value.definitionExpression)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.definitionExpressionSer, it)
    }
    ((value.definitionId?.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.definitionId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.linkIdSer, it)
    }
    (value.definitionByTypeAndValue)?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.definitionByTypeAndValueSer, it)
    }
    (value.definitionByCombination)?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.definitionByCombinationSer, it)
    }
    when (val choice = value.instances) {
      null -> {}
      is EvidenceVariable.Characteristic.Instances.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          19,
          Hoisted.instancesQuantitySer,
          choice.value,
        )
      }
      is EvidenceVariable.Characteristic.Instances.Range -> {
        encoder.encodeSerializableElement(descriptor, 20, Hoisted.instancesRangeSer, choice.value)
      }
    }
    when (val choice = value.duration) {
      null -> {}
      is EvidenceVariable.Characteristic.Duration.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          21,
          Hoisted.instancesQuantitySer,
          choice.value,
        )
      }
      is EvidenceVariable.Characteristic.Duration.Range -> {
        encoder.encodeSerializableElement(descriptor, 22, Hoisted.instancesRangeSer, choice.value)
      }
    }
    if (value.timeFromEvent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23,
        Hoisted.timeFromEventSer,
        value.timeFromEvent,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val definitionReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val definitionCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val definitionExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val definitionByTypeAndValueSer:
      KSerializer<EvidenceVariable.Characteristic.DefinitionByTypeAndValue> =
      EvidenceVariable.Characteristic.DefinitionByTypeAndValue.serializer()

    public val definitionByCombinationSer:
      KSerializer<EvidenceVariable.Characteristic.DefinitionByCombination> =
      EvidenceVariable.Characteristic.DefinitionByCombination.serializer()

    public val instancesQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val instancesRangeSer: KSerializer<Range> = Range.serializer()

    public val timeFromEventSerInner: KSerializer<EvidenceVariable.Characteristic.TimeFromEvent> =
      EvidenceVariable.Characteristic.TimeFromEvent.serializer()

    public val timeFromEventSer: KSerializer<List<EvidenceVariable.Characteristic.TimeFromEvent>> =
      ListSerializer(Hoisted.timeFromEventSerInner)
  }
}

internal object EvidenceVariableCharacteristicDefinitionByTypeAndValueSerializer :
  KSerializer<EvidenceVariable.Characteristic.DefinitionByTypeAndValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DefinitionByTypeAndValue") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "method",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("device", Reference.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("valueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueId", Element.serializer().descriptor, isOptional = true)
      element("offset", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): EvidenceVariable.Characteristic.DefinitionByTypeAndValue =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByTypeAndValue,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): EvidenceVariable.Characteristic.DefinitionByTypeAndValue {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          method = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        5 ->
          device = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        6 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        9 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        10 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        11 ->
          valueReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        12 -> valueId = decoder.decodeStringElement(descriptor, i)
        13 ->
          _valueId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        14 ->
          offset = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DefinitionByTypeAndValue: " + i)
      }
    }
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByTypeAndValue,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    if (value.method.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.methodSer, value.method)
    (value.device)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.deviceSer, it) }
    when (val choice = value.`value`) {
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, choice.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueQuantitySer, choice.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueRangeSer, choice.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.deviceSer, choice.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.valueBooleanSer, it)
        }
      }
    }
    (value.offset)?.let { encoder.encodeSerializableElement(descriptor, 14, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val methodSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val deviceSer: KSerializer<Reference> = Reference.serializer()

    public val valueBooleanSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object EvidenceVariableCharacteristicDefinitionByCombinationSerializer :
  KSerializer<EvidenceVariable.Characteristic.DefinitionByCombination> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DefinitionByCombination") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("threshold", Int.serializer().descriptor, isOptional = true)
      element("_threshold", Element.serializer().descriptor, isOptional = true)
      element(
        "characteristic",
        listSerialDescriptor(
          lazyDescriptor { EvidenceVariable.Characteristic.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(
    decoder: Decoder
  ): EvidenceVariable.Characteristic.DefinitionByCombination =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByCombination,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): EvidenceVariable.Characteristic.DefinitionByCombination {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var threshold: Int? = null
    var _threshold: Element? = null
    var characteristic: List<EvidenceVariable.Characteristic>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> threshold = decoder.decodeIntElement(descriptor, i)
        6 ->
          _threshold =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characteristicSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DefinitionByCombination: " + i)
      }
    }
    return EvidenceVariable.Characteristic.DefinitionByCombination(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Enumeration.of(code?.let { EvidenceVariable.CharacteristicCombination.fromCode(it) }, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on EvidenceVariable.Characteristic.DefinitionByCombination"
          ),
      threshold = PositiveInt.of(threshold, _threshold),
      characteristic = characteristic ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByCombination,
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
    ((value.code.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.threshold?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.threshold?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        Hoisted.characteristicSer,
        value.characteristic,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val characteristicSerInner: KSerializer<EvidenceVariable.Characteristic> =
      EvidenceVariable.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<EvidenceVariable.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)
  }
}

internal object EvidenceVariableCharacteristicTimeFromEventSerializer :
  KSerializer<EvidenceVariable.Characteristic.TimeFromEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TimeFromEvent") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("eventCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("eventReference", Reference.serializer().descriptor, isOptional = true)
      element("eventDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_eventDateTime", Element.serializer().descriptor, isOptional = true)
      element("eventId", KotlinString.serializer().descriptor, isOptional = true)
      element("_eventId", Element.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("range", Range.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.TimeFromEvent =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic.TimeFromEvent) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): EvidenceVariable.Characteristic.TimeFromEvent {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        6 ->
          eventCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.eventCodeableConceptSer,
              null,
            )
        7 ->
          eventReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.eventReferenceSer,
              null,
            )
        8 -> eventDateTime = decoder.decodeStringElement(descriptor, i)
        9 ->
          _eventDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        10 -> eventId = decoder.decodeStringElement(descriptor, i)
        11 ->
          _eventId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        12 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        13 ->
          range = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TimeFromEvent: " + i)
      }
    }
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
          DateTime.of(FhirDateTime.fromString(eventDateTime), _eventDateTime),
          Id.of(eventId, _eventId),
        ),
      quantity = quantity,
      range = range,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: EvidenceVariable.Characteristic.TimeFromEvent,
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteSer, value.note)
    when (val choice = value.event) {
      null -> {}
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          6,
          Hoisted.eventCodeableConceptSer,
          choice.value,
        )
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.Reference -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.eventReferenceSer, choice.value)
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.descriptionSer, it)
        }
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.Id -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.descriptionSer, it)
        }
      }
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.quantitySer, it)
    }
    (value.range)?.let { encoder.encodeSerializableElement(descriptor, 13, Hoisted.rangeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val eventCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val eventReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val rangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object EvidenceVariableCategorySerializer : KSerializer<EvidenceVariable.Category> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Category") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Category =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Category) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): EvidenceVariable.Category {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        6 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        7 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Category: " + i)
      }
    }
    return EvidenceVariable.Category(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name),
      `value` =
        EvidenceVariable.Category.Value.from(valueCodeableConcept, valueQuantity, valueRange),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: EvidenceVariable.Category) {
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
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    when (val choice = value.`value`) {
      null -> {}
      is EvidenceVariable.Category.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          5,
          Hoisted.valueCodeableConceptSer,
          choice.value,
        )
      }
      is EvidenceVariable.Category.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueQuantitySer, choice.value)
      }
      is EvidenceVariable.Category.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueRangeSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object EvidenceVariableSerializer : KSerializer<EvidenceVariable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EvidenceVariable") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("shortTitle", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_shortTitle", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
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
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
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
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element("actual", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_actual", Element.serializer().descriptor, isOptional = true)
    b.element(
      "characteristic",
      listSerialDescriptor(
        lazyDescriptor { EvidenceVariable.Characteristic.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("handling", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_handling", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(lazyDescriptor { EvidenceVariable.Category.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "EvidenceVariable")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> shortTitle = decoder.decodeStringElement(descriptor, i)
        23 ->
          _shortTitle =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> status = decoder.decodeStringElement(descriptor, i)
        25 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 -> date = decoder.decodeStringElement(descriptor, i)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 -> publisher = decoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        33 -> description = decoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        36 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        37 -> purpose = decoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> copyright = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        42 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        44 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        46 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        47 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        48 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        49 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        50 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        51 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        52 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        53 -> `actual` = decoder.decodeBooleanElement(descriptor, i)
        54 ->
          _actual =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        55 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characteristicSer,
              null,
            )
        56 -> handling = decoder.decodeStringElement(descriptor, i)
        57 ->
          _handling =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        58 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
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
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on EvidenceVariable"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      useContext = useContext ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
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
          handling?.let { EvidenceVariable.EvidenceVariableHandling.fromCode(it) },
          _handling,
        ),
      category = category ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: EvidenceVariable,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is EvidenceVariable.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is EvidenceVariable.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.shortTitle?.value))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.shortTitle?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 45 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.`actual`?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 53 + descriptorOffset, it)
    }
    (value.`actual`?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.characteristicSer,
        value.characteristic,
      )
    ((value.handling?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 56 + descriptorOffset, it)
    }
    (value.handling?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
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

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val characteristicSerInner: KSerializer<EvidenceVariable.Characteristic> =
      EvidenceVariable.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<EvidenceVariable.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)

    public val categorySerInner: KSerializer<EvidenceVariable.Category> =
      EvidenceVariable.Category.serializer()

    public val categorySer: KSerializer<List<EvidenceVariable.Category>> =
      ListSerializer(Hoisted.categorySerInner)
  }
}

internal object EvidenceVariablePolymorphicSerializer : KSerializer<EvidenceVariable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EvidenceVariable") {
      EvidenceVariableSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable) {
    encoder.encodeStructure(descriptor) {
      EvidenceVariableSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable =
    decoder.decodeStructure(descriptor) {
      EvidenceVariableSerializer.deserializeInternal(this, descriptor, 0)
    }
}
