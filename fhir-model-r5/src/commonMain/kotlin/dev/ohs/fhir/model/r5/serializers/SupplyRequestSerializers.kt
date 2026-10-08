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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.SupplyRequest
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.RequestPriority
import dev.ohs.fhir.model.r5.terminologies.SupplyRequestStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object SupplyRequestParameterSerializer : KSerializer<SupplyRequest.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SupplyRequest.Parameter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SupplyRequest.Parameter {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        7 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: SupplyRequest.Parameter) {
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
      value.code,
    )
    when (val choice = value.`value`) {
      null -> {}
      is SupplyRequest.Parameter.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is SupplyRequest.Parameter.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
      }
      is SupplyRequest.Parameter.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, RangeSerializer, choice.value)
      }
      is SupplyRequest.Parameter.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SupplyRequestSerializer : FhirResourceSerializer<SupplyRequest> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SupplyRequest")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("priority", String.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("deliverFor", ReferenceSerializer.descriptor)
    b.optionalElement("item", CodeableReferenceSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("parameter", SupplyRequestParameterSerializer.listSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", String.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurrenceTiming", TimingSerializer.descriptor)
    b.optionalElement("authoredOn", String.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("requester", ReferenceSerializer.descriptor)
    b.optionalElement("supplier", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("deliverFrom", ReferenceSerializer.descriptor)
    b.optionalElement("deliverTo", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SupplyRequest {
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
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        14 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 -> priority = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          deliverFor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        19 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        20 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SupplyRequestParameterSerializer.listSerializer,
              null,
            )
        21 -> occurrenceDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _occurrenceDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          occurrencePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        24 ->
          occurrenceTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        25 -> authoredOn = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _authoredOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          requester =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        28 ->
          supplier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        30 ->
          deliverFrom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        31 ->
          deliverTo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SupplyRequest: " + i)
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
        Enumeration.of(if (status != null) SupplyRequestStatus.fromCode(status) else null, _status),
      basedOn = basedOn ?: listOf(),
      category = category,
      priority =
        Enumeration.of(
          if (priority != null) RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      deliverFor = deliverFor,
      item =
        item ?: throw SerializationException("Missing required property 'item' on SupplyRequest"),
      quantity =
        quantity
          ?: throw SerializationException("Missing required property 'quantity' on SupplyRequest"),
      parameter = parameter ?: listOf(),
      occurrence =
        SupplyRequest.Occurrence.from(
          DateTime.of(
            if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
            _occurrenceDateTime,
          ),
          occurrencePeriod,
          occurrenceTiming,
        ),
      authoredOn =
        DateTime.of(
          if (authoredOn != null) FhirDateTime.fromString(authoredOn) else null,
          _authoredOn,
        ),
      requester = requester,
      supplier = supplier ?: listOf(),
      reason = reason ?: listOf(),
      deliverFrom = deliverFrom,
      deliverTo = deliverTo,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SupplyRequest,
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
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.basedOn.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.priority?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.priority)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.deliverFor,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      CodeableReferenceSerializer,
      value.item,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    if (value.parameter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        SupplyRequestParameterSerializer.listSerializer,
        value.parameter,
      )
    when (val choice = value.occurrence) {
      null -> {}
      is SupplyRequest.Occurrence.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          21 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
      is SupplyRequest.Occurrence.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is SupplyRequest.Occurrence.Timing -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.authoredOn)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    if (value.supplier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supplier,
      )
    if (value.reason.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.deliverFrom,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.deliverTo,
    )
  }
}
