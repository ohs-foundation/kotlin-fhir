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
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.DeviceRequest
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object DeviceRequestParameterSerializer : KSerializer<DeviceRequest.Parameter> {
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

  internal val listSerializer: KSerializer<List<DeviceRequest.Parameter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceRequest.Parameter =
    decoder.decodeStructure(descriptor) {
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          7 -> valueBoolean = decodeBooleanElement(descriptor, i)
          8 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      DeviceRequest.Parameter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        `value` =
          DeviceRequest.Parameter.Value.from(
            valueCodeableConcept,
            valueQuantity,
            valueRange,
            R5Boolean.of(valueBoolean, _valueBoolean),
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceRequest.Parameter) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.code)
      when (val choice = value.`value`) {
        null -> {}
        is DeviceRequest.Parameter.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is DeviceRequest.Parameter.Value.Quantity -> {
          encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
        }
        is DeviceRequest.Parameter.Value.Range -> {
          encodeSerializableElement(descriptor, 6, RangeSerializer, choice.value)
        }
        is DeviceRequest.Parameter.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
      }
    }
  }
}

internal object DeviceRequestSerializer : FhirResourceSerializer<DeviceRequest> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("DeviceRequest")

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
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("intent", String.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("priority", String.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_doNotPerform", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableReferenceSerializer.descriptor)
    b.optionalElement("quantity", Int.serializer().descriptor)
    b.optionalElement("_quantity", ElementSerializer.descriptor)
    b.optionalElement("parameter", DeviceRequestParameterSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", String.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurrenceTiming", TimingSerializer.descriptor)
    b.optionalElement("authoredOn", String.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("requester", ReferenceSerializer.descriptor)
    b.optionalElement("performer", CodeableReferenceSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("asNeeded", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_asNeeded", ElementSerializer.descriptor)
    b.optionalElement("asNeededFor", CodeableConceptSerializer.descriptor)
    b.optionalElement("insurance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInfo", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("relevantHistory", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): DeviceRequest {
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
    var instantiatesCanonical: List<String?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<String?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var replaces: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var status: String? = null
    var _status: Element? = null
    var intent: String? = null
    var _intent: Element? = null
    var priority: String? = null
    var _priority: Element? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var code: CodeableReference? = null
    var quantity: Int? = null
    var _quantity: Element? = null
    var parameter: List<DeviceRequest.Parameter>? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var authoredOn: String? = null
    var _authoredOn: Element? = null
    var requester: Reference? = null
    var performer: CodeableReference? = null
    var reason: List<CodeableReference>? = null
    var asNeeded: KotlinBoolean? = null
    var _asNeeded: Element? = null
    var asNeededFor: CodeableConcept? = null
    var insurance: List<Reference>? = null
    var supportingInfo: List<Reference>? = null
    var note: List<Annotation>? = null
    var relevantHistory: List<Reference>? = null
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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> intent = decoder.decodeStringElement(descriptor, i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> priority = decoder.decodeStringElement(descriptor, i)
        23 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        27 -> quantity = decoder.decodeIntElement(descriptor, i)
        28 ->
          _quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          parameter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceRequestParameterSerializer.listSerializer,
              null,
            )
        30 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        31 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        32 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        33 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        35 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        36 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        37 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        39 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        40 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        41 -> asNeeded = decoder.decodeBooleanElement(descriptor, i)
        42 ->
          _asNeeded =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          asNeededFor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        44 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        45 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        46 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        47 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding DeviceRequest: " + i)
      }
    }
    return DeviceRequest(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(index),
            _instantiatesCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'instantiatesCanonical' on DeviceRequest has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on DeviceRequest has neither a value nor an id/extension"
            )
        }),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      groupIdentifier = groupIdentifier,
      status =
        Enumeration.of(
          if (status != null) DeviceRequest.RequestStatus.fromCode(status) else null,
          _status,
        ),
      intent =
        Enumeration.of(
          if (intent != null) DeviceRequest.RequestIntent.fromCode(intent) else null,
          _intent,
        ) ?: throw SerializationException("Missing required property 'intent' on DeviceRequest"),
      priority =
        Enumeration.of(
          if (priority != null) DeviceRequest.RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      code =
        code ?: throw SerializationException("Missing required property 'code' on DeviceRequest"),
      quantity = Integer.of(quantity, _quantity),
      parameter = parameter ?: listOf(),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on DeviceRequest"),
      encounter = encounter,
      occurrence =
        DeviceRequest.Occurrence.from(
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
      performer = performer,
      reason = reason ?: listOf(),
      asNeeded = R5Boolean.of(asNeeded, _asNeeded),
      asNeededFor = asNeededFor,
      insurance = insurance ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      note = note ?: listOf(),
      relevantHistory = relevantHistory ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DeviceRequest,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.instantiatesCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.instantiatesUri)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.replaces,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.intent)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.priority)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.doNotPerform?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.doNotPerform)
    encoder.encodeSerializableElement(
      descriptor,
      26 + descriptorOffset,
      CodeableReferenceSerializer,
      value.code,
    )
    encoder.encodeIntIfNotNull(descriptor, 27 + descriptorOffset, value.quantity?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.quantity)
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        DeviceRequestParameterSerializer.listSerializer,
        value.parameter,
      )
    encoder.encodeSerializableElement(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.occurrence) {
      null -> {}
      is DeviceRequest.Occurrence.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          32 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, choice.value)
      }
      is DeviceRequest.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          34 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is DeviceRequest.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          35 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.authoredOn)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      CodeableReferenceSerializer,
      value.performer,
    )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    encoder.encodeBooleanIfNotNull(descriptor, 41 + descriptorOffset, value.asNeeded?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.asNeeded)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      CodeableConceptSerializer,
      value.asNeededFor,
    )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.insurance,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.relevantHistory,
      )
  }
}
