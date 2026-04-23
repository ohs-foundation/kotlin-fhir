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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.SupplyRequest
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object SupplyRequestParameterSerializer : KSerializer<SupplyRequest.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SupplyRequest.Parameter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SupplyRequest.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SupplyRequest.Parameter {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueQuantitySer, null)
        6 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueRangeSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueBooleanSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return SupplyRequest.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      `value` =
        SupplyRequest.Parameter.Value.from(
          valueCodeableConcept,
          valueQuantity,
          valueRange,
          R5Boolean.of(valueBoolean, _valueBoolean),
        ),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SupplyRequest.Parameter) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is SupplyRequest.Parameter.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, __d.value)
      }
      is SupplyRequest.Parameter.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueQuantitySer, __d.value)
      }
      is SupplyRequest.Parameter.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.valueRangeSer, __d.value)
      }
      is SupplyRequest.Parameter.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueBooleanSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueBooleanSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SupplyRequestParameterValueSerializer : KSerializer<SupplyRequest.Parameter.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupplyRequest.Parameter.Value") {
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: SupplyRequest.Parameter.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is SupplyRequest.Parameter.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is SupplyRequest.Parameter.Value.Quantity -> {
          encodeSerializableElement(__desc, 1, Hoisted.valueQuantitySer, __d.value)
        }
        is SupplyRequest.Parameter.Value.Range -> {
          encodeSerializableElement(__desc, 2, Hoisted.valueRangeSer, __d.value)
        }
        is SupplyRequest.Parameter.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 3, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 4, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): SupplyRequest.Parameter.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): SupplyRequest.Parameter.Value {
    val __desc = descriptor
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        1 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.valueQuantitySer, null)
        2 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.valueRangeSer, null)
        3 -> valueBoolean = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding SupplyRequest.Parameter.Value: " + __i
          )
      }
    }
    return SupplyRequest.Parameter.Value.from(
      valueCodeableConcept,
      valueQuantity,
      valueRange,
      R5Boolean.of(valueBoolean, _valueBoolean),
    )!!
  }

  private object Hoisted {
    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SupplyRequestOccurrenceSerializer : KSerializer<SupplyRequest.Occurrence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupplyRequest.Occurrence") {
      element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: SupplyRequest.Occurrence) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is SupplyRequest.Occurrence.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is SupplyRequest.Occurrence.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.occurrencePeriodSer, __d.value)
        }
        is SupplyRequest.Occurrence.Timing -> {
          encodeSerializableElement(__desc, 3, Hoisted.occurrenceTimingSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): SupplyRequest.Occurrence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): SupplyRequest.Occurrence {
    val __desc = descriptor
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.occurrencePeriodSer, null)
        3 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.occurrenceTimingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding SupplyRequest.Occurrence: " + __i)
      }
    }
    return SupplyRequest.Occurrence.from(
      DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
      occurrencePeriod,
      occurrenceTiming,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object SupplyRequestSerializer : KSerializer<SupplyRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupplyRequest") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("priority", String.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("deliverFor", Reference.serializer().descriptor, isOptional = true)
      element("item", CodeableReference.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element(
        "parameter",
        listSerialDescriptor(lazyDescriptor { SupplyRequest.Parameter.serializer().descriptor }),
        isOptional = true,
      )
      element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
      element("authoredOn", String.serializer().descriptor, isOptional = true)
      element("_authoredOn", Element.serializer().descriptor, isOptional = true)
      element("requester", Reference.serializer().descriptor, isOptional = true)
      element(
        "supplier",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("deliverFrom", Reference.serializer().descriptor, isOptional = true)
      element("deliverTo", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SupplyRequest =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SupplyRequest) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): SupplyRequest {
    val __desc = descriptor
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var status: String? = null
    var _status: Element? = null
    var basedOn: List<Reference>? = null
    var category: CodeableConcept? = null
    var priority: String? = null
    var _priority: Element? = null
    var deliverFor: Reference? = null
    var item: CodeableReference? = null
    var quantity: Quantity? = null
    var parameter: List<SupplyRequest.Parameter>? = null
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var authoredOn: String? = null
    var _authoredOn: Element? = null
    var requester: Reference? = null
    var supplier: List<Reference>? = null
    var reason: List<CodeableReference>? = null
    var deliverFrom: Reference? = null
    var deliverTo: Reference? = null
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
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.basedOnSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 -> priority = decoder.decodeStringElement(__desc, 16)
        17 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          deliverFor =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.basedOnSerInner, null)
        19 -> item = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.itemSer, null)
        20 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.quantitySer, null)
        21 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.parameterSer, null)
        22 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 22)
        23 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.occurrencePeriodSer, null)
        25 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.occurrenceTimingSer, null)
        26 -> authoredOn = decoder.decodeStringElement(__desc, 26)
        27 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          requester =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.basedOnSerInner, null)
        29 ->
          supplier = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.basedOnSer, null)
        30 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.reasonSer, null)
        31 ->
          deliverFrom =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.basedOnSerInner, null)
        32 ->
          deliverTo =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.basedOnSerInner, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupplyRequest: " + __i)
      }
    }
    return SupplyRequest(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        status?.let { Enumeration.of(SupplyRequest.SupplyRequestStatus.fromCode(it), _status) },
      basedOn = basedOn ?: listOf(),
      category = category,
      priority =
        priority?.let { Enumeration.of(SupplyRequest.RequestPriority.fromCode(it), _priority) },
      deliverFor = deliverFor,
      item = item!!,
      quantity = quantity!!,
      parameter = parameter ?: listOf(),
      occurrence =
        SupplyRequest.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
          occurrenceTiming,
        ),
      authoredOn = DateTime.of(FhirDateTime.fromString(authoredOn), _authoredOn),
      requester = requester,
      supplier = supplier ?: listOf(),
      reason = reason ?: listOf(),
      deliverFrom = deliverFrom,
      deliverTo = deliverTo,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SupplyRequest) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "SupplyRequest")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.basedOnSer, value.basedOn)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, it) }
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.deliverFor)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.basedOnSerInner, it)
    }
    (value.item)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.itemSer, it) }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.quantitySer, it) }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.parameterSer, value.parameter)
    when (val __d = value.occurrence) {
      null -> {}
      is SupplyRequest.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
        }
      }
      is SupplyRequest.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 24, Hoisted.occurrencePeriodSer, __d.value)
      }
      is SupplyRequest.Occurrence.Timing -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.occurrenceTimingSer, __d.value)
      }
    }
    ((value.authoredOn?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.basedOnSerInner, it)
    }
    if (value.supplier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.basedOnSer, value.supplier)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.reasonSer, value.reason)
    (value.deliverFrom)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.basedOnSerInner, it)
    }
    (value.deliverTo)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.basedOnSerInner, it)
    }
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val itemSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val parameterSerInner: KSerializer<SupplyRequest.Parameter> =
      SupplyRequest.Parameter.serializer()

    public val parameterSer: KSerializer<List<SupplyRequest.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> = ListSerializer(Hoisted.itemSer)
  }
}
