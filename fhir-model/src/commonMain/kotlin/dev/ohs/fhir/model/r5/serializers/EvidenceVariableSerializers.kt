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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EvidenceVariable.Characteristic {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.linkIdSer, null)
        7 -> note = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.noteSer, null)
        8 -> exclude = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _exclude = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.linkIdSer, null)
        10 ->
          definitionReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.definitionReferenceSer,
              null,
            )
        11 -> definitionCanonical = decoder.decodeStringElement(__desc, 11)
        12 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.linkIdSer, null)
        13 ->
          definitionCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.definitionCodeableConceptSer,
              null,
            )
        14 ->
          definitionExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.definitionExpressionSer,
              null,
            )
        15 -> definitionId = decoder.decodeStringElement(__desc, 15)
        16 ->
          _definitionId =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.linkIdSer, null)
        17 ->
          definitionByTypeAndValue =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.definitionByTypeAndValueSer,
              null,
            )
        18 ->
          definitionByCombination =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.definitionByCombinationSer,
              null,
            )
        19 ->
          instancesQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.instancesQuantitySer,
              null,
            )
        20 ->
          instancesRange =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.instancesRangeSer, null)
        21 ->
          durationQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.instancesQuantitySer,
              null,
            )
        22 ->
          durationRange =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.instancesRangeSer, null)
        23 ->
          timeFromEvent =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.timeFromEventSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceVariable.Characteristic) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.linkIdSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.noteSer, value.note)
    ((value.exclude?.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
    (value.exclude?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.linkIdSer, it)
    }
    (value.definitionReference)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.definitionReferenceSer, it)
    }
    ((value.definitionCanonical?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.definitionCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.linkIdSer, it)
    }
    (value.definitionCodeableConcept)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.definitionCodeableConceptSer, it)
    }
    (value.definitionExpression)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.definitionExpressionSer, it)
    }
    ((value.definitionId?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.definitionId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.linkIdSer, it)
    }
    (value.definitionByTypeAndValue)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.definitionByTypeAndValueSer, it)
    }
    (value.definitionByCombination)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.definitionByCombinationSer, it)
    }
    when (val __d = value.instances) {
      null -> {}
      is EvidenceVariable.Characteristic.Instances.Quantity -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.instancesQuantitySer, __d.value)
      }
      is EvidenceVariable.Characteristic.Instances.Range -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.instancesRangeSer, __d.value)
      }
    }
    when (val __d = value.duration) {
      null -> {}
      is EvidenceVariable.Characteristic.Duration.Quantity -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.instancesQuantitySer, __d.value)
      }
      is EvidenceVariable.Characteristic.Duration.Range -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.instancesRangeSer, __d.value)
      }
    }
    if (value.timeFromEvent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.timeFromEventSer, value.timeFromEvent)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByTypeAndValue,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): EvidenceVariable.Characteristic.DefinitionByTypeAndValue {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> method = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.methodSer, null)
        5 -> device = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.deviceSer, null)
        6 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueBooleanSer, null)
        9 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueQuantitySer, null)
        10 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueRangeSer, null)
        11 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.deviceSer, null)
        12 -> valueId = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueId =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.valueBooleanSer, null)
        14 -> offset = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DefinitionByTypeAndValue: " + __i)
      }
    }
    return EvidenceVariable.Characteristic.DefinitionByTypeAndValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
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
        )!!,
      offset = offset,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByTypeAndValue,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.method.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.methodSer, value.method)
    (value.device)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.deviceSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, __d.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.valueQuantitySer, __d.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.valueRangeSer, __d.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.deviceSer, __d.value)
      }
      is EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.valueBooleanSer, it)
        }
      }
    }
    (value.offset)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.typeSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByCombination,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): EvidenceVariable.Characteristic.DefinitionByCombination {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var threshold: Int? = null
    var _threshold: Element? = null
    var characteristic: List<EvidenceVariable.Characteristic>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> threshold = decoder.decodeIntElement(__desc, 5)
        6 ->
          _threshold = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.characteristicSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DefinitionByCombination: " + __i)
      }
    }
    return EvidenceVariable.Characteristic.DefinitionByCombination(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(EvidenceVariable.CharacteristicCombination.fromCode(code!!), _code),
      threshold = PositiveInt.of(threshold, _threshold),
      characteristic = characteristic ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByCombination,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.threshold?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.threshold?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.characteristicSer, value.characteristic)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic.TimeFromEvent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): EvidenceVariable.Characteristic.TimeFromEvent {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.noteSer, null)
        6 ->
          eventCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.eventCodeableConceptSer,
              null,
            )
        7 ->
          eventReference =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.eventReferenceSer, null)
        8 -> eventDateTime = decoder.decodeStringElement(__desc, 8)
        9 ->
          _eventDateTime =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.descriptionSer, null)
        10 -> eventId = decoder.decodeStringElement(__desc, 10)
        11 ->
          _eventId =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.descriptionSer, null)
        12 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.quantitySer, null)
        13 -> range = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.rangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TimeFromEvent: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: EvidenceVariable.Characteristic.TimeFromEvent,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.noteSer, value.note)
    when (val __d = value.event) {
      null -> {}
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.eventCodeableConceptSer, __d.value)
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.Reference -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.eventReferenceSer, __d.value)
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.descriptionSer, it)
        }
      }
      is EvidenceVariable.Characteristic.TimeFromEvent.Event.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.descriptionSer, it)
        }
      }
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.quantitySer, it) }
    (value.range)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.rangeSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Category) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EvidenceVariable.Category {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        6 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueQuantitySer, null)
        7 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Category: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceVariable.Category) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is EvidenceVariable.Category.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueCodeableConceptSer, __d.value)
      }
      is EvidenceVariable.Category.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.valueQuantitySer, __d.value)
      }
      is EvidenceVariable.Category.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueRangeSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "EvidenceVariable")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): EvidenceVariable {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 16)
        17 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        19 -> name = decoder.decodeStringElement(__desc, 19)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> title = decoder.decodeStringElement(__desc, 21)
        22 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> shortTitle = decoder.decodeStringElement(__desc, 23)
        24 ->
          _shortTitle =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> status = decoder.decodeStringElement(__desc, 25)
        26 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> experimental = decoder.decodeBooleanElement(__desc, 27)
        28 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> date = decoder.decodeStringElement(__desc, 29)
        30 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> publisher = decoder.decodeStringElement(__desc, 31)
        32 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.contactSer, null)
        34 -> description = decoder.decodeStringElement(__desc, 34)
        35 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> note = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.noteSer, null)
        37 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.useContextSer, null)
        38 -> purpose = decoder.decodeStringElement(__desc, 38)
        39 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> copyright = decoder.decodeStringElement(__desc, 40)
        41 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 -> copyrightLabel = decoder.decodeStringElement(__desc, 42)
        43 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 -> approvalDate = decoder.decodeStringElement(__desc, 44)
        45 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 -> lastReviewDate = decoder.decodeStringElement(__desc, 46)
        47 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.implicitRulesSer, null)
        48 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.effectivePeriodSer, null)
        49 ->
          author = decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.contactSer, null)
        50 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.contactSer, null)
        51 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.contactSer, null)
        52 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.contactSer, null)
        53 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.relatedArtifactSer, null)
        54 -> `actual` = decoder.decodeBooleanElement(__desc, 54)
        55 ->
          _actual =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.implicitRulesSer, null)
        56 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.characteristicSer, null)
        57 -> handling = decoder.decodeStringElement(__desc, 57)
        58 ->
          _handling =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.implicitRulesSer, null)
        59 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.categorySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EvidenceVariable: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
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
        handling?.let {
          Enumeration.of(EvidenceVariable.EvidenceVariableHandling.fromCode(it), _handling)
        },
      category = category ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceVariable) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is EvidenceVariable.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is EvidenceVariable.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.versionAlgorithmCodingSer, __d.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.shortTitle?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.shortTitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 27, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.noteSer, value.note)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.useContextSer, value.useContext)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 44, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 46, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.effectivePeriodSer, it)
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        53,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.`actual`?.value))?.let { encoder.encodeBooleanElement(__desc, 54, it) }
    (value.`actual`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 55, Hoisted.implicitRulesSer, it)
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 56, Hoisted.characteristicSer, value.characteristic)
    ((value.handling?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 57, it) }
    (value.handling?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 58, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 59, Hoisted.categorySer, value.category)
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
    encoder.encodeStructure(descriptor) { EvidenceVariableSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable =
    decoder.decodeStructure(descriptor) { EvidenceVariableSerializer.deserializeJson(this) }
}
