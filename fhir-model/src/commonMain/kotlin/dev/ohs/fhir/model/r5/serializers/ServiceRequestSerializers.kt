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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          parameterFocus =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.parameterFocusSer, null)
        4 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.parameterSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueQuantitySer, null)
        5 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueRatioSer, null)
        6 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueRangeSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueBooleanSer, null)
        9 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.codeSer, null)
        10 -> valueString = decoder.decodeStringElement(__desc, 10)
        11 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueBooleanSer, null)
        12 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valuePeriodSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> instructionMarkdown = decoder.decodeStringElement(__desc, 3)
        4 ->
          _instructionMarkdown =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.instructionMarkdownSer,
              null,
            )
        5 ->
          instructionReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
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
      element(
        "instantiatesCanonical",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesCanonical",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesUri",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "replaces",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("requisition", Identifier.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("intent", KotlinString.serializer().descriptor, isOptional = true)
      element("_intent", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("priority", KotlinString.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "orderDetail",
        listSerialDescriptor(lazyDescriptor { ServiceRequest.OrderDetail.serializer().descriptor }),
        isOptional = true,
      )
      element("quantityQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("quantityRatio", Ratio.serializer().descriptor, isOptional = true)
      element("quantityRange", Range.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
      element("asNeededBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_asNeededBoolean", Element.serializer().descriptor, isOptional = true)
      element("asNeededCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("authoredOn", KotlinString.serializer().descriptor, isOptional = true)
      element("_authoredOn", Element.serializer().descriptor, isOptional = true)
      element("requester", Reference.serializer().descriptor, isOptional = true)
      element("performerType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "location",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "insurance",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "supportingInfo",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specimen",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "bodySite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("bodyStructure", Reference.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "patientInstruction",
        listSerialDescriptor(
          lazyDescriptor { ServiceRequest.PatientInstruction.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "relevantHistory",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ServiceRequest =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ServiceRequest) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ServiceRequest {
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
        12 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        13 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        14 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        15 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        16 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSer, null)
        17 ->
          replaces = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSer, null)
        18 ->
          requisition =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.identifierSerInner, null)
        19 -> status = decoder.decodeStringElement(__desc, 19)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> intent = decoder.decodeStringElement(__desc, 21)
        22 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.categorySer, null)
        24 -> priority = decoder.decodeStringElement(__desc, 24)
        25 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> doNotPerform = decoder.decodeBooleanElement(__desc, 26)
        27 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> code = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.codeSer, null)
        29 ->
          orderDetail =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.orderDetailSer, null)
        30 ->
          quantityQuantity =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.quantityQuantitySer, null)
        31 ->
          quantityRatio =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.quantityRatioSer, null)
        32 ->
          quantityRange =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.quantityRangeSer, null)
        33 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.basedOnSerInner, null)
        34 ->
          focus = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.basedOnSer, null)
        35 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.basedOnSerInner, null)
        36 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 36)
        37 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.occurrencePeriodSer, null)
        39 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.occurrenceTimingSer, null)
        40 -> asNeededBoolean = decoder.decodeBooleanElement(__desc, 40)
        41 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.categorySerInner, null)
        43 -> authoredOn = decoder.decodeStringElement(__desc, 43)
        44 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.implicitRulesSer, null)
        45 ->
          requester =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.basedOnSerInner, null)
        46 ->
          performerType =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.categorySerInner, null)
        47 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.basedOnSer, null)
        48 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.locationSer, null)
        49 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.locationSer, null)
        50 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.basedOnSer, null)
        51 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.locationSer, null)
        52 ->
          specimen = decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.basedOnSer, null)
        53 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.categorySer, null)
        54 ->
          bodyStructure =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.basedOnSerInner, null)
        55 -> note = decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.noteSer, null)
        56 ->
          patientInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              56,
              Hoisted.patientInstructionSer,
              null,
            )
        57 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.basedOnSer, null)
        CompositeDecoder.DECODE_DONE -> break
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ServiceRequest) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ServiceRequest")
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
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSer, value.basedOn)
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSer, value.replaces)
    (value.requisition)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.identifierSerInner, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.categorySer, value.category)
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(__desc, 26, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.codeSer, it) }
    if (value.orderDetail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.orderDetailSer, value.orderDetail)
    when (val __d = value.quantity) {
      null -> {}
      is ServiceRequest.Quantity.Quantity -> {
        encoder.encodeSerializableElement(__desc, 30, Hoisted.quantityQuantitySer, __d.value)
      }
      is ServiceRequest.Quantity.Ratio -> {
        encoder.encodeSerializableElement(__desc, 31, Hoisted.quantityRatioSer, __d.value)
      }
      is ServiceRequest.Quantity.Range -> {
        encoder.encodeSerializableElement(__desc, 32, Hoisted.quantityRangeSer, __d.value)
      }
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.basedOnSerInner, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.basedOnSer, value.focus)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is ServiceRequest.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 36, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
        }
      }
      is ServiceRequest.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 38, Hoisted.occurrencePeriodSer, __d.value)
      }
      is ServiceRequest.Occurrence.Timing -> {
        encoder.encodeSerializableElement(__desc, 39, Hoisted.occurrenceTimingSer, __d.value)
      }
    }
    when (val __d = value.asNeeded) {
      null -> {}
      is ServiceRequest.AsNeeded.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 40, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
        }
      }
      is ServiceRequest.AsNeeded.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 42, Hoisted.categorySerInner, __d.value)
      }
    }
    ((value.authoredOn?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 43, it) }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.implicitRulesSer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.basedOnSerInner, it)
    }
    (value.performerType)?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.categorySerInner, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.basedOnSer, value.performer)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.locationSer, value.location)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.locationSer, value.reason)
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.basedOnSer, value.insurance)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.locationSer, value.supportingInfo)
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52, Hoisted.basedOnSer, value.specimen)
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.categorySer, value.bodySite)
    (value.bodyStructure)?.let {
      encoder.encodeSerializableElement(__desc, 54, Hoisted.basedOnSerInner, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 55, Hoisted.noteSer, value.note)
    if (value.patientInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        56,
        Hoisted.patientInstructionSer,
        value.patientInstruction,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 57, Hoisted.basedOnSer, value.relevantHistory)
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
