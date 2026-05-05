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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.OrderDetail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ServiceRequest.OrderDetail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var parameterFocus: CodeableReference? = null
    var parameter: List<ServiceRequest.OrderDetail.Parameter>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          parameterFocus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parameterFocusSer, null)
        4 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parameterSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OrderDetail: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ServiceRequest.OrderDetail) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.parameterFocus)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.parameterFocusSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.parameterSer, value.parameter)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.OrderDetail.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ServiceRequest.OrderDetail.Parameter {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        5 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioSer, null)
        6 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        9 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        10 -> valueString = decoder.decodeStringElement(__desc, __i)
        11 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        12 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valuePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return ServiceRequest.OrderDetail.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      `value` =
        ServiceRequest.OrderDetail.Parameter.Value.from(
          valueQuantity,
          valueRatio,
          valueRange,
          R5Boolean.of(valueBoolean, _valueBoolean),
          valueCodeableConcept,
          R5String.of(valueString, _valueString),
          valuePeriod,
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ServiceRequest.OrderDetail.Parameter,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is ServiceRequest.OrderDetail.Parameter.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.valueQuantitySer, __d.value)
      }
      is ServiceRequest.OrderDetail.Parameter.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueRatioSer, __d.value)
      }
      is ServiceRequest.OrderDetail.Parameter.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.valueRangeSer, __d.value)
      }
      is ServiceRequest.OrderDetail.Parameter.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is ServiceRequest.OrderDetail.Parameter.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.codeSer, __d.value)
      }
      is ServiceRequest.OrderDetail.Parameter.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueBooleanSer, it)
        }
      }
      is ServiceRequest.OrderDetail.Parameter.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valuePeriodSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.PatientInstruction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ServiceRequest.PatientInstruction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instructionMarkdown: KotlinString? = null
    var _instructionMarkdown: Element? = null
    var instructionReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> instructionMarkdown = decoder.decodeStringElement(__desc, __i)
        4 ->
          _instructionMarkdown =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instructionMarkdownSer,
              null,
            )
        5 ->
          instructionReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instructionReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PatientInstruction: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ServiceRequest.PatientInstruction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.instruction) {
      null -> {}
      is ServiceRequest.PatientInstruction.Instruction.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.instructionMarkdownSer, it)
        }
      }
      is ServiceRequest.PatientInstruction.Instruction.Reference -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.instructionReferenceSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ServiceRequest")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): ServiceRequest {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        15 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        16 ->
          replaces =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        17 ->
          requisition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSerInner, null)
        18 -> status = decoder.decodeStringElement(__desc, __i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> intent = decoder.decodeStringElement(__desc, __i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        23 -> priority = decoder.decodeStringElement(__desc, __i)
        24 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 -> doNotPerform = decoder.decodeBooleanElement(__desc, __i)
        26 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        28 ->
          orderDetail =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.orderDetailSer, null)
        29 ->
          quantityQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.quantityQuantitySer,
              null,
            )
        30 ->
          quantityRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantityRatioSer, null)
        31 ->
          quantityRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantityRangeSer, null)
        32 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        33 ->
          focus = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        34 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        35 -> occurrenceDateTime = decoder.decodeStringElement(__desc, __i)
        36 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        37 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        38 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        39 -> asNeededBoolean = decoder.decodeBooleanElement(__desc, __i)
        40 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        41 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        42 -> authoredOn = decoder.decodeStringElement(__desc, __i)
        43 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        44 ->
          requester =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        45 ->
          performerType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        46 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        47 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        48 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        49 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        50 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        51 ->
          specimen =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        52 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        53 ->
          bodyStructure =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        54 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        55 ->
          patientInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.patientInstructionSer,
              null,
            )
        56 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        else -> throw SerializationException("Unexpected index decoding ServiceRequest: " + __i)
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
        ) { __i ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(__i)?.let { it },
            _instantiatesCanonical?.getOrNull(__i),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          __i ->
          Uri.of(instantiatesUri?.getOrNull(__i)?.let { it }, _instantiatesUri?.getOrNull(__i))!!
        }),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      requisition = requisition,
      status = Enumeration.of(ServiceRequest.RequestStatus.fromCode(status!!), _status),
      intent = Enumeration.of(ServiceRequest.RequestIntent.fromCode(intent!!), _intent),
      category = category ?: listOf(),
      priority =
        priority?.let { Enumeration.of(ServiceRequest.RequestPriority.fromCode(it), _priority) },
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      code = code,
      orderDetail = orderDetail ?: listOf(),
      quantity = ServiceRequest.Quantity.from(quantityQuantity, quantityRatio, quantityRange),
      subject = subject!!,
      focus = focus ?: listOf(),
      encounter = encounter,
      occurrence =
        ServiceRequest.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
          occurrenceTiming,
        ),
      asNeeded =
        ServiceRequest.AsNeeded.from(
          R5Boolean.of(asNeededBoolean, _asNeededBoolean),
          asNeededCodeableConcept,
        ),
      authoredOn = DateTime.of(FhirDateTime.fromString(authoredOn), _authoredOn),
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: ServiceRequest,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.basedOnSer, value.basedOn)
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.basedOnSer, value.replaces)
    (value.requisition)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.identifierSerInner, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.categorySer, value.category)
    ((value.priority?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 23 + __off, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(__desc, 25 + __off, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.codeSer, it) }
    if (value.orderDetail.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        28 + __off,
        Hoisted.orderDetailSer,
        value.orderDetail,
      )
    when (val __d = value.quantity) {
      null -> {}
      is ServiceRequest.Quantity.Quantity -> {
        encoder.encodeSerializableElement(
          __desc,
          29 + __off,
          Hoisted.quantityQuantitySer,
          __d.value,
        )
      }
      is ServiceRequest.Quantity.Ratio -> {
        encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.quantityRatioSer, __d.value)
      }
      is ServiceRequest.Quantity.Range -> {
        encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.quantityRangeSer, __d.value)
      }
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.basedOnSer, value.focus)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is ServiceRequest.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 35 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is ServiceRequest.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          __desc,
          37 + __off,
          Hoisted.occurrencePeriodSer,
          __d.value,
        )
      }
      is ServiceRequest.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          __desc,
          38 + __off,
          Hoisted.occurrenceTimingSer,
          __d.value,
        )
      }
    }
    when (val __d = value.asNeeded) {
      null -> {}
      is ServiceRequest.AsNeeded.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 39 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is ServiceRequest.AsNeeded.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.categorySerInner, __d.value)
      }
    }
    ((value.authoredOn?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 42 + __off, it)
    }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.performerType)?.let {
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.categorySerInner, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.basedOnSer, value.performer)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.locationSer, value.location)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48 + __off, Hoisted.locationSer, value.reason)
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.basedOnSer, value.insurance)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        50 + __off,
        Hoisted.locationSer,
        value.supportingInfo,
      )
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51 + __off, Hoisted.basedOnSer, value.specimen)
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52 + __off, Hoisted.categorySer, value.bodySite)
    (value.bodyStructure)?.let {
      encoder.encodeSerializableElement(__desc, 53 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54 + __off, Hoisted.noteSer, value.note)
    if (value.patientInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        55 + __off,
        Hoisted.patientInstructionSer,
        value.patientInstruction,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        56 + __off,
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
      ServiceRequestSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ServiceRequest =
    decoder.decodeStructure(descriptor) {
      ServiceRequestSerializer.deserializeJson(this, descriptor, 0)
    }
}
