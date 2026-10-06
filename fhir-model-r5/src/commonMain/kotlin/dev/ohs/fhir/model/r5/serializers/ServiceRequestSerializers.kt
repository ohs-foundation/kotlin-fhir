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
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
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

internal object ServiceRequestOrderDetailSerializer : KSerializer<ServiceRequest.OrderDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OrderDetail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("parameterFocus", CodeableReferenceSerializer.descriptor)
      optionalElement(
        "parameter",
        ServiceRequestOrderDetailParameterSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ServiceRequest.OrderDetail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ServiceRequest.OrderDetail =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var parameterFocus: CodeableReference? = null
      var parameter: List<ServiceRequest.OrderDetail.Parameter>? = null
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
            parameterFocus =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            parameter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ServiceRequestOrderDetailParameterSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding OrderDetail: " + i)
        }
      }
      ServiceRequest.OrderDetail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        parameterFocus = parameterFocus,
        parameter = parameter ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.OrderDetail) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableReferenceSerializer, value.parameterFocus)
      if (value.parameter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ServiceRequestOrderDetailParameterSerializer.listSerializer,
          value.parameter,
        )
    }
  }
}

internal object ServiceRequestOrderDetailParameterSerializer :
  KSerializer<ServiceRequest.OrderDetail.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRatio", RatioSerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valuePeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ServiceRequest.OrderDetail.Parameter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ServiceRequest.OrderDetail.Parameter =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueRatio: Ratio? = null
      var valueRange: Range? = null
      var valueBoolean: KotlinBoolean? = null
      var _valueBoolean: Element? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueString: KotlinString? = null
      var _valueString: Element? = null
      var valuePeriod: Period? = null
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
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          6 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          7 -> valueBoolean = decodeBooleanElement(descriptor, i)
          8 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 -> valueString = decodeStringElement(descriptor, i)
          11 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      ServiceRequest.OrderDetail.Parameter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on ServiceRequest.OrderDetail.Parameter"
            ),
        `value` =
          ServiceRequest.OrderDetail.Parameter.Value.from(
            valueQuantity,
            valueRatio,
            valueRange,
            R5Boolean.of(valueBoolean, _valueBoolean),
            valueCodeableConcept,
            R5String.of(valueString, _valueString),
            valuePeriod,
          )
            ?: throw SerializationException(
              "Missing required property 'value' on ServiceRequest.OrderDetail.Parameter"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.OrderDetail.Parameter) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      when (val choice = value.`value`) {
        is ServiceRequest.OrderDetail.Parameter.Value.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is ServiceRequest.OrderDetail.Parameter.Value.Ratio -> {
          encodeSerializableElement(descriptor, 5, RatioSerializer, choice.value)
        }
        is ServiceRequest.OrderDetail.Parameter.Value.Range -> {
          encodeSerializableElement(descriptor, 6, RangeSerializer, choice.value)
        }
        is ServiceRequest.OrderDetail.Parameter.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is ServiceRequest.OrderDetail.Parameter.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, choice.value)
        }
        is ServiceRequest.OrderDetail.Parameter.Value.String -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is ServiceRequest.OrderDetail.Parameter.Value.Period -> {
          encodeSerializableElement(descriptor, 12, PeriodSerializer, choice.value)
        }
      }
    }
  }
}

internal object ServiceRequestPatientInstructionSerializer :
  KSerializer<ServiceRequest.PatientInstruction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PatientInstruction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("instructionMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_instructionMarkdown", ElementSerializer.descriptor)
      optionalElement("instructionReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ServiceRequest.PatientInstruction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ServiceRequest.PatientInstruction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var instructionMarkdown: KotlinString? = null
      var _instructionMarkdown: Element? = null
      var instructionReference: Reference? = null
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
          3 -> instructionMarkdown = decodeStringElement(descriptor, i)
          4 ->
            _instructionMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            instructionReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PatientInstruction: " + i)
        }
      }
      ServiceRequest.PatientInstruction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        instruction =
          ServiceRequest.PatientInstruction.Instruction.from(
            Markdown.of(instructionMarkdown, _instructionMarkdown),
            instructionReference,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.PatientInstruction) {
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
      when (val choice = value.instruction) {
        null -> {}
        is ServiceRequest.PatientInstruction.Instruction.Markdown -> {
          encodeStringIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is ServiceRequest.PatientInstruction.Instruction.Reference -> {
          encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object ServiceRequestSerializer : FhirResourceSerializer<ServiceRequest> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ServiceRequest")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("requisition", IdentifierSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("intent", KotlinString.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("priority", KotlinString.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_doNotPerform", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableReferenceSerializer.descriptor)
    b.optionalElement("orderDetail", ServiceRequestOrderDetailSerializer.listSerializer.descriptor)
    b.optionalElement("quantityQuantity", QuantitySerializer.descriptor)
    b.optionalElement("quantityRatio", RatioSerializer.descriptor)
    b.optionalElement("quantityRange", RangeSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurrenceTiming", TimingSerializer.descriptor)
    b.optionalElement("asNeededBoolean", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_asNeededBoolean", ElementSerializer.descriptor)
    b.optionalElement("asNeededCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("authoredOn", KotlinString.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("requester", ReferenceSerializer.descriptor)
    b.optionalElement("performerType", CodeableConceptSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("location", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("insurance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInfo", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("specimen", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("bodyStructure", ReferenceSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement(
      "patientInstruction",
      ServiceRequestPatientInstructionSerializer.listSerializer.descriptor,
    )
    b.optionalElement("relevantHistory", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ServiceRequest {
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
    var identifier: List<Identifier>? = null
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var replaces: List<Reference>? = null
    var requisition: Identifier? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var category: List<CodeableConcept>? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var code: CodeableReference? = null
    var orderDetail: List<ServiceRequest.OrderDetail>? = null
    var quantityQuantity: Quantity? = null
    var quantityRatio: Ratio? = null
    var quantityRange: Range? = null
    var subject: Reference? = null
    var focus: List<Reference>? = null
    var encounter: Reference? = null
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var asNeededBoolean: KotlinBoolean? = null
    var _asNeededBoolean: Element? = null
    var asNeededCodeableConcept: CodeableConcept? = null
    var authoredOn: KotlinString? = null
    var _authoredOn: Element? = null
    var requester: Reference? = null
    var performerType: CodeableConcept? = null
    var performer: List<Reference>? = null
    var location: List<CodeableReference>? = null
    var reason: List<CodeableReference>? = null
    var insurance: List<Reference>? = null
    var supportingInfo: List<CodeableReference>? = null
    var specimen: List<Reference>? = null
    var bodySite: List<CodeableConcept>? = null
    var bodyStructure: Reference? = null
    var note: List<Annotation>? = null
    var patientInstruction: List<ServiceRequest.PatientInstruction>? = null
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
          requisition =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> intent = decoder.decodeStringElement(descriptor, i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        23 -> priority = decoder.decodeStringElement(descriptor, i)
        24 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        26 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        28 ->
          orderDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ServiceRequestOrderDetailSerializer.listSerializer,
              null,
            )
        29 ->
          quantityQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        30 ->
          quantityRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        31 ->
          quantityRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        32 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        33 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        34 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        35 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        36 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        38 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        39 -> asNeededBoolean = decoder.decodeBooleanElement(descriptor, i)
        40 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        42 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        43 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        45 ->
          performerType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        46 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        47 ->
          location =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        48 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        49 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        50 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        51 ->
          specimen =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        52 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        53 ->
          bodyStructure =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        54 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        55 ->
          patientInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ServiceRequestPatientInstructionSerializer.listSerializer,
              null,
            )
        56 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ServiceRequest: " + i)
      }
    }
    return ServiceRequest(
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
              "An entry of 'instantiatesCanonical' on ServiceRequest has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on ServiceRequest has neither a value nor an id/extension"
            )
        }),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      requisition = requisition,
      status =
        Enumeration.of(
          if (status != null) ServiceRequest.RequestStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on ServiceRequest"),
      intent =
        Enumeration.of(
          if (intent != null) ServiceRequest.RequestIntent.fromCode(intent) else null,
          _intent,
        ) ?: throw SerializationException("Missing required property 'intent' on ServiceRequest"),
      category = category ?: listOf(),
      priority =
        Enumeration.of(
          if (priority != null) ServiceRequest.RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      code = code,
      orderDetail = orderDetail ?: listOf(),
      quantity = ServiceRequest.Quantity.from(quantityQuantity, quantityRatio, quantityRange),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on ServiceRequest"),
      focus = focus ?: listOf(),
      encounter = encounter,
      occurrence =
        ServiceRequest.Occurrence.from(
          DateTime.of(
            if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
            _occurrenceDateTime,
          ),
          occurrencePeriod,
          occurrenceTiming,
        ),
      asNeeded =
        ServiceRequest.AsNeeded.from(
          R5Boolean.of(asNeededBoolean, _asNeededBoolean),
          asNeededCodeableConcept,
        ),
      authoredOn =
        DateTime.of(
          if (authoredOn != null) FhirDateTime.fromString(authoredOn) else null,
          _authoredOn,
        ),
      requester = requester,
      performerType = performerType,
      performer = performer ?: listOf(),
      location = location ?: listOf(),
      reason = reason ?: listOf(),
      insurance = insurance ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      specimen = specimen ?: listOf(),
      bodySite = bodySite ?: listOf(),
      bodyStructure = bodyStructure,
      note = note ?: listOf(),
      patientInstruction = patientInstruction ?: listOf(),
      relevantHistory = relevantHistory ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ServiceRequest,
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
      value.requisition,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.intent)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.priority)
    encoder.encodeBooleanIfNotNull(descriptor, 25 + descriptorOffset, value.doNotPerform?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.doNotPerform)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableReferenceSerializer,
      value.code,
    )
    if (value.orderDetail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ServiceRequestOrderDetailSerializer.listSerializer,
        value.orderDetail,
      )
    when (val choice = value.quantity) {
      null -> {}
      is ServiceRequest.Quantity.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          29 + descriptorOffset,
          QuantitySerializer,
          choice.value,
        )
      }
      is ServiceRequest.Quantity.Ratio -> {
        encoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          RatioSerializer,
          choice.value,
        )
      }
      is ServiceRequest.Quantity.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableElement(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.focus,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.occurrence) {
      null -> {}
      is ServiceRequest.Occurrence.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          35 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, choice.value)
      }
      is ServiceRequest.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          37 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is ServiceRequest.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          38 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
    }
    when (val choice = value.asNeeded) {
      null -> {}
      is ServiceRequest.AsNeeded.Boolean -> {
        encoder.encodeBooleanIfNotNull(descriptor, 39 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, choice.value)
      }
      is ServiceRequest.AsNeeded.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      42 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.authoredOn)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      CodeableConceptSerializer,
      value.performerType,
    )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.performer,
      )
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.location,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.insurance,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.specimen,
      )
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.bodySite,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      53 + descriptorOffset,
      ReferenceSerializer,
      value.bodyStructure,
    )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.patientInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        ServiceRequestPatientInstructionSerializer.listSerializer,
        value.patientInstruction,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.relevantHistory,
      )
  }
}
