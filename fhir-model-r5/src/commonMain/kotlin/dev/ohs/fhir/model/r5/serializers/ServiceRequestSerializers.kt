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
import kotlinx.serialization.builtins.nullable
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
      element("parameterFocus", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "parameter",
        listSerialDescriptor(
          lazyDescriptor { ServiceRequest.OrderDetail.Parameter.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ServiceRequest.OrderDetail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.OrderDetail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ServiceRequest.OrderDetail {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var parameterFocus: CodeableReference? = null
    var parameter: List<ServiceRequest.OrderDetail.Parameter>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          parameterFocus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.parameterFocusSer,
              null,
            )
        4 ->
          parameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parameterSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OrderDetail: " + i)
      }
    }
    return ServiceRequest.OrderDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      parameterFocus = parameterFocus,
      parameter = parameter ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ServiceRequest.OrderDetail) {
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
    (value.parameterFocus)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.parameterFocusSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.parameterSer, value.parameter)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val parameterFocusSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val parameterSerInner: KSerializer<ServiceRequest.OrderDetail.Parameter> =
      ServiceRequest.OrderDetail.Parameter.serializer()

    public val parameterSer: KSerializer<List<ServiceRequest.OrderDetail.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)
  }
}

internal object ServiceRequestOrderDetailParameterSerializer :
  KSerializer<ServiceRequest.OrderDetail.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valuePeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ServiceRequest.OrderDetail.Parameter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.OrderDetail.Parameter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ServiceRequest.OrderDetail.Parameter {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        5 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        6 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        9 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        10 -> valueString = decoder.decodeStringElement(descriptor, i)
        11 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        12 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    return ServiceRequest.OrderDetail.Parameter(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ServiceRequest.OrderDetail.Parameter,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    when (val choice = value.`value`) {
      is ServiceRequest.OrderDetail.Parameter.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueQuantitySer, choice.value)
      }
      is ServiceRequest.OrderDetail.Parameter.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueRatioSer, choice.value)
      }
      is ServiceRequest.OrderDetail.Parameter.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueRangeSer, choice.value)
      }
      is ServiceRequest.OrderDetail.Parameter.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is ServiceRequest.OrderDetail.Parameter.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.codeSer, choice.value)
      }
      is ServiceRequest.OrderDetail.Parameter.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueBooleanSer, it)
        }
      }
      is ServiceRequest.OrderDetail.Parameter.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 12, Hoisted.valuePeriodSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueBooleanSer: KSerializer<Element> = Element.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object ServiceRequestPatientInstructionSerializer :
  KSerializer<ServiceRequest.PatientInstruction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PatientInstruction") {
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
      element("instructionMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_instructionMarkdown", Element.serializer().descriptor, isOptional = true)
      element("instructionReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ServiceRequest.PatientInstruction =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.PatientInstruction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ServiceRequest.PatientInstruction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instructionMarkdown: KotlinString? = null
    var _instructionMarkdown: Element? = null
    var instructionReference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> instructionMarkdown = decoder.decodeStringElement(descriptor, i)
        4 ->
          _instructionMarkdown =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instructionMarkdownSer,
              null,
            )
        5 ->
          instructionReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instructionReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PatientInstruction: " + i)
      }
    }
    return ServiceRequest.PatientInstruction(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ServiceRequest.PatientInstruction,
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
    when (val choice = value.instruction) {
      null -> {}
      is ServiceRequest.PatientInstruction.Instruction.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.instructionMarkdownSer, it)
        }
      }
      is ServiceRequest.PatientInstruction.Instruction.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          5,
          Hoisted.instructionReferenceSer,
          choice.value,
        )
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val instructionMarkdownSer: KSerializer<Element> = Element.serializer()

    public val instructionReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ServiceRequestSerializer : KSerializer<ServiceRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ServiceRequest") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesCanonical",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesUri",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "replaces",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("requisition", Identifier.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("intent", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("priority", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_priority", Element.serializer().descriptor, isOptional = true)
    b.element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
    b.element("code", CodeableReference.serializer().descriptor, isOptional = true)
    b.element(
      "orderDetail",
      listSerialDescriptor(lazyDescriptor { ServiceRequest.OrderDetail.serializer().descriptor }),
      isOptional = true,
    )
    b.element("quantityQuantity", Quantity.serializer().descriptor, isOptional = true)
    b.element("quantityRatio", Ratio.serializer().descriptor, isOptional = true)
    b.element("quantityRange", Range.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("asNeededBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_asNeededBoolean", Element.serializer().descriptor, isOptional = true)
    b.element("asNeededCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("authoredOn", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_authoredOn", Element.serializer().descriptor, isOptional = true)
    b.element("requester", Reference.serializer().descriptor, isOptional = true)
    b.element("performerType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "location",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "insurance",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specimen",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "bodySite",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("bodyStructure", Reference.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "patientInstruction",
      listSerialDescriptor(
        lazyDescriptor { ServiceRequest.PatientInstruction.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "relevantHistory",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ServiceRequest =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ServiceRequest")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        15 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        16 ->
          replaces =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        17 ->
          requisition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> intent = decoder.decodeStringElement(descriptor, i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        23 -> priority = decoder.decodeStringElement(descriptor, i)
        24 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        26 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        28 ->
          orderDetail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.orderDetailSer, null)
        29 ->
          quantityQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.quantityQuantitySer,
              null,
            )
        30 ->
          quantityRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantityRatioSer, null)
        31 ->
          quantityRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantityRangeSer, null)
        32 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        33 ->
          focus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        34 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        35 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        36 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        38 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        39 -> asNeededBoolean = decoder.decodeBooleanElement(descriptor, i)
        40 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        42 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        43 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        44 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        45 ->
          performerType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        46 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        47 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        48 ->
          reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        49 ->
          insurance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        50 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        51 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        52 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        53 ->
          bodyStructure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        54 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        55 ->
          patientInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.patientInstructionSer,
              null,
            )
        56 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
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
            instantiatesCanonical?.getOrNull(index)?.let { it },
            _instantiatesCanonical?.getOrNull(index),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(
            instantiatesUri?.getOrNull(index)?.let { it },
            _instantiatesUri?.getOrNull(index),
          )!!
        }),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      requisition = requisition,
      status =
        Enumeration.of(
          ServiceRequest.RequestStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on ServiceRequest"
              )
          ),
          _status,
        ),
      intent =
        Enumeration.of(
          ServiceRequest.RequestIntent.fromCode(
            intent
              ?: throw SerializationException(
                "Missing required property 'intent' on ServiceRequest"
              )
          ),
          _intent,
        ),
      category = category ?: listOf(),
      priority =
        priority?.let { Enumeration.of(ServiceRequest.RequestPriority.fromCode(it), _priority) },
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
          DateTime.of(occurrenceDateTime?.let { FhirDateTime.fromString(it) }, _occurrenceDateTime),
          occurrencePeriod,
          occurrenceTiming,
        ),
      asNeeded =
        ServiceRequest.AsNeeded.from(
          R5Boolean.of(asNeededBoolean, _asNeededBoolean),
          asNeededCodeableConcept,
        ),
      authoredOn = DateTime.of(authoredOn?.let { FhirDateTime.fromString(it) }, _authoredOn),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ServiceRequest,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.basedOnSer,
        value.replaces,
      )
    (value.requisition)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.intent.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    ((value.priority?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.doNotPerform?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.codeSer, it)
    }
    if (value.orderDetail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.orderDetailSer,
        value.orderDetail,
      )
    when (val choice = value.quantity) {
      null -> {}
      is ServiceRequest.Quantity.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          29 + descriptorOffset,
          Hoisted.quantityQuantitySer,
          choice.value,
        )
      }
      is ServiceRequest.Quantity.Ratio -> {
        encoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          Hoisted.quantityRatioSer,
          choice.value,
        )
      }
      is ServiceRequest.Quantity.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          Hoisted.quantityRangeSer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableElement(
      descriptor,
      32 + descriptorOffset,
      Hoisted.basedOnSerInner,
      value.subject,
    )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.basedOnSer,
        value.focus,
      )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    when (val choice = value.occurrence) {
      null -> {}
      is ServiceRequest.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            36 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ServiceRequest.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          37 + descriptorOffset,
          Hoisted.occurrencePeriodSer,
          choice.value,
        )
      }
      is ServiceRequest.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          38 + descriptorOffset,
          Hoisted.occurrenceTimingSer,
          choice.value,
        )
      }
    }
    when (val choice = value.asNeeded) {
      null -> {}
      is ServiceRequest.AsNeeded.Boolean -> {
        ((choice.value.value))?.let {
          encoder.encodeBooleanElement(descriptor, 39 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            40 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ServiceRequest.AsNeeded.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          Hoisted.categorySerInner,
          choice.value,
        )
      }
    }
    ((value.authoredOn?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 42 + descriptorOffset, it)
    }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.performerType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.basedOnSer,
        value.performer,
      )
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.locationSer,
        value.location,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.locationSer,
        value.reason,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.basedOnSer,
        value.insurance,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.locationSer,
        value.supportingInfo,
      )
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.basedOnSer,
        value.specimen,
      )
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.categorySer,
        value.bodySite,
      )
    (value.bodyStructure)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.patientInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.patientInstructionSer,
        value.patientInstruction,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        Hoisted.basedOnSer,
        value.relevantHistory,
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

    public val instantiatesCanonicalSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val codeSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val orderDetailSerInner: KSerializer<ServiceRequest.OrderDetail> =
      ServiceRequest.OrderDetail.serializer()

    public val orderDetailSer: KSerializer<List<ServiceRequest.OrderDetail>> =
      ListSerializer(Hoisted.orderDetailSerInner)

    public val quantityQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val quantityRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val quantityRangeSer: KSerializer<Range> = Range.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()

    public val locationSer: KSerializer<List<CodeableReference>> = ListSerializer(Hoisted.codeSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val patientInstructionSerInner: KSerializer<ServiceRequest.PatientInstruction> =
      ServiceRequest.PatientInstruction.serializer()

    public val patientInstructionSer: KSerializer<List<ServiceRequest.PatientInstruction>> =
      ListSerializer(Hoisted.patientInstructionSerInner)
  }
}

internal object ServiceRequestPolymorphicSerializer : KSerializer<ServiceRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ServiceRequest") { ServiceRequestSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest) {
    encoder.encodeStructure(descriptor) {
      ServiceRequestSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ServiceRequest =
    decoder.decodeStructure(descriptor) {
      ServiceRequestSerializer.deserializeInternal(this, descriptor, 0)
    }
}
