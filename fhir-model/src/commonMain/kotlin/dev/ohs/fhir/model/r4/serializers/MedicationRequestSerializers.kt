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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String
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

internal object MedicationRequestDispenseRequestSerializer :
  KSerializer<MedicationRequest.DispenseRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DispenseRequest") {
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
      element(
        "initialFill",
        lazyDescriptor { MedicationRequest.DispenseRequest.InitialFill.serializer().descriptor },
        isOptional = true,
      )
      element("dispenseInterval", Duration.serializer().descriptor, isOptional = true)
      element("validityPeriod", Period.serializer().descriptor, isOptional = true)
      element("numberOfRepeatsAllowed", Int.serializer().descriptor, isOptional = true)
      element("_numberOfRepeatsAllowed", Element.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("expectedSupplyDuration", Duration.serializer().descriptor, isOptional = true)
      element("performer", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationRequest.DispenseRequest =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.DispenseRequest) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationRequest.DispenseRequest {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var initialFill: MedicationRequest.DispenseRequest.InitialFill? = null
    var dispenseInterval: Duration? = null
    var validityPeriod: Period? = null
    var numberOfRepeatsAllowed: Int? = null
    var _numberOfRepeatsAllowed: Element? = null
    var quantity: Quantity? = null
    var expectedSupplyDuration: Duration? = null
    var performer: Reference? = null
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
          initialFill =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.initialFillSer, null)
        4 ->
          dispenseInterval =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.dispenseIntervalSer, null)
        5 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.validityPeriodSer, null)
        6 -> numberOfRepeatsAllowed = decoder.decodeIntElement(__desc, 6)
        7 ->
          _numberOfRepeatsAllowed =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.numberOfRepeatsAllowedSer,
              null,
            )
        8 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.quantitySer, null)
        9 ->
          expectedSupplyDuration =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.dispenseIntervalSer, null)
        10 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.performerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DispenseRequest: " + __i)
      }
    }
    return MedicationRequest.DispenseRequest(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      initialFill = initialFill,
      dispenseInterval = dispenseInterval,
      validityPeriod = validityPeriod,
      numberOfRepeatsAllowed = UnsignedInt.of(numberOfRepeatsAllowed, _numberOfRepeatsAllowed),
      quantity = quantity,
      expectedSupplyDuration = expectedSupplyDuration,
      performer = performer,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationRequest.DispenseRequest) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.initialFill)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.initialFillSer, it)
    }
    (value.dispenseInterval)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.dispenseIntervalSer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.validityPeriodSer, it)
    }
    ((value.numberOfRepeatsAllowed?.value))?.let { encoder.encodeIntElement(__desc, 6, it) }
    (value.numberOfRepeatsAllowed?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.numberOfRepeatsAllowedSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.quantitySer, it) }
    (value.expectedSupplyDuration)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.dispenseIntervalSer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.performerSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val initialFillSer: KSerializer<MedicationRequest.DispenseRequest.InitialFill> =
      MedicationRequest.DispenseRequest.InitialFill.serializer()

    public val dispenseIntervalSer: KSerializer<Duration> = Duration.serializer()

    public val validityPeriodSer: KSerializer<Period> = Period.serializer()

    public val numberOfRepeatsAllowedSer: KSerializer<Element> = Element.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val performerSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MedicationRequestDispenseRequestInitialFillSerializer :
  KSerializer<MedicationRequest.DispenseRequest.InitialFill> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InitialFill") {
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("duration", Duration.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationRequest.DispenseRequest.InitialFill =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.DispenseRequest.InitialFill) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationRequest.DispenseRequest.InitialFill {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Quantity? = null
    var duration: Duration? = null
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
          quantity = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.quantitySer, null)
        4 ->
          duration = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.durationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding InitialFill: " + __i)
      }
    }
    return MedicationRequest.DispenseRequest.InitialFill(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      quantity = quantity,
      duration = duration,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationRequest.DispenseRequest.InitialFill,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.quantitySer, it) }
    (value.duration)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.durationSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val durationSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object MedicationRequestSubstitutionSerializer :
  KSerializer<MedicationRequest.Substitution> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substitution") {
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
      element("allowedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_allowedBoolean", Element.serializer().descriptor, isOptional = true)
      element("allowedCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationRequest.Substitution =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.Substitution) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationRequest.Substitution {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var allowedBoolean: KotlinBoolean? = null
    var _allowedBoolean: Element? = null
    var allowedCodeableConcept: CodeableConcept? = null
    var reason: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> allowedBoolean = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _allowedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.allowedBooleanSer, null)
        5 ->
          allowedCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.allowedCodeableConceptSer,
              null,
            )
        6 ->
          reason =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.allowedCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + __i)
      }
    }
    return MedicationRequest.Substitution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      allowed =
        MedicationRequest.Substitution.Allowed.from(
          R4Boolean.of(allowedBoolean, _allowedBoolean),
          allowedCodeableConcept,
        )!!,
      reason = reason,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationRequest.Substitution) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.allowed) {
      null -> {}
      is MedicationRequest.Substitution.Allowed.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.allowedBooleanSer, it)
        }
      }
      is MedicationRequest.Substitution.Allowed.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.allowedCodeableConceptSer, __d.value)
      }
    }
    (value.reason)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.allowedCodeableConceptSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val allowedBooleanSer: KSerializer<Element> = Element.serializer()

    public val allowedCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()
  }
}

internal object MedicationRequestSerializer : KSerializer<MedicationRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationRequest") {
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
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("intent", String.serializer().descriptor, isOptional = true)
      element("_intent", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("priority", String.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
      element("reportedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_reportedBoolean", Element.serializer().descriptor, isOptional = true)
      element("reportedReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "medicationCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("medicationReference", Reference.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element(
        "supportingInformation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("authoredOn", String.serializer().descriptor, isOptional = true)
      element("_authoredOn", Element.serializer().descriptor, isOptional = true)
      element("requester", Reference.serializer().descriptor, isOptional = true)
      element("performer", Reference.serializer().descriptor, isOptional = true)
      element("performerType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("recorder", Reference.serializer().descriptor, isOptional = true)
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesCanonical",
        listSerialDescriptor(String.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesCanonical",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesUri",
        listSerialDescriptor(String.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("courseOfTherapyType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "insurance",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "dosageInstruction",
        listSerialDescriptor(Dosage.serializer().descriptor),
        isOptional = true,
      )
      element(
        "dispenseRequest",
        lazyDescriptor { MedicationRequest.DispenseRequest.serializer().descriptor },
        isOptional = true,
      )
      element(
        "substitution",
        lazyDescriptor { MedicationRequest.Substitution.serializer().descriptor },
        isOptional = true,
      )
      element("priorPrescription", Reference.serializer().descriptor, isOptional = true)
      element(
        "detectedIssue",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "eventHistory",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationRequest =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicationRequest {
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
    var statusReason: CodeableConcept? = null
    var intent: String? = null
    var _intent: Element? = null
    var category: List<CodeableConcept>? = null
    var priority: String? = null
    var _priority: Element? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var reportedBoolean: KotlinBoolean? = null
    var _reportedBoolean: Element? = null
    var reportedReference: Reference? = null
    var medicationCodeableConcept: CodeableConcept? = null
    var medicationReference: Reference? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var authoredOn: String? = null
    var _authoredOn: Element? = null
    var requester: Reference? = null
    var performer: Reference? = null
    var performerType: CodeableConcept? = null
    var recorder: Reference? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var instantiatesCanonical: List<String?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<String?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var courseOfTherapyType: CodeableConcept? = null
    var insurance: List<Reference>? = null
    var note: List<Annotation>? = null
    var dosageInstruction: List<Dosage>? = null
    var dispenseRequest: MedicationRequest.DispenseRequest? = null
    var substitution: MedicationRequest.Substitution? = null
    var priorPrescription: Reference? = null
    var detectedIssue: List<Reference>? = null
    var eventHistory: List<Reference>? = null
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
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.statusReasonSer, null)
        15 -> intent = decoder.decodeStringElement(__desc, 15)
        16 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.categorySer, null)
        18 -> priority = decoder.decodeStringElement(__desc, 18)
        19 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> doNotPerform = decoder.decodeBooleanElement(__desc, 20)
        21 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> reportedBoolean = decoder.decodeBooleanElement(__desc, 22)
        23 ->
          _reportedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          reportedReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              24,
              Hoisted.reportedReferenceSer,
              null,
            )
        25 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.statusReasonSer, null)
        26 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.reportedReferenceSer,
              null,
            )
        27 ->
          subject =
            decoder.decodeNullableSerializableElement(
              __desc,
              27,
              Hoisted.reportedReferenceSer,
              null,
            )
        28 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              __desc,
              28,
              Hoisted.reportedReferenceSer,
              null,
            )
        29 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              __desc,
              29,
              Hoisted.supportingInformationSer,
              null,
            )
        30 -> authoredOn = decoder.decodeStringElement(__desc, 30)
        31 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          requester =
            decoder.decodeNullableSerializableElement(
              __desc,
              32,
              Hoisted.reportedReferenceSer,
              null,
            )
        33 ->
          performer =
            decoder.decodeNullableSerializableElement(
              __desc,
              33,
              Hoisted.reportedReferenceSer,
              null,
            )
        34 ->
          performerType =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.statusReasonSer, null)
        35 ->
          recorder =
            decoder.decodeNullableSerializableElement(
              __desc,
              35,
              Hoisted.reportedReferenceSer,
              null,
            )
        36 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.categorySer, null)
        37 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              37,
              Hoisted.supportingInformationSer,
              null,
            )
        38 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              38,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        39 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              39,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        40 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              40,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        41 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              41,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        42 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              __desc,
              42,
              Hoisted.supportingInformationSer,
              null,
            )
        43 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.identifierSerInner, null)
        44 ->
          courseOfTherapyType =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.statusReasonSer, null)
        45 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              __desc,
              45,
              Hoisted.supportingInformationSer,
              null,
            )
        46 -> note = decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.noteSer, null)
        47 ->
          dosageInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              47,
              Hoisted.dosageInstructionSer,
              null,
            )
        48 ->
          dispenseRequest =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.dispenseRequestSer, null)
        49 ->
          substitution =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.substitutionSer, null)
        50 ->
          priorPrescription =
            decoder.decodeNullableSerializableElement(
              __desc,
              50,
              Hoisted.reportedReferenceSer,
              null,
            )
        51 ->
          detectedIssue =
            decoder.decodeNullableSerializableElement(
              __desc,
              51,
              Hoisted.supportingInformationSer,
              null,
            )
        52 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(
              __desc,
              52,
              Hoisted.supportingInformationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MedicationRequest: " + __i)
      }
    }
    return MedicationRequest(
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
        Enumeration.of(MedicationRequest.MedicationrequestStatus.fromCode(status!!), _status),
      statusReason = statusReason,
      intent =
        Enumeration.of(MedicationRequest.MedicationRequestIntent.fromCode(intent!!), _intent),
      category = category ?: listOf(),
      priority =
        priority?.let { Enumeration.of(MedicationRequest.RequestPriority.fromCode(it), _priority) },
      doNotPerform = R4Boolean.of(doNotPerform, _doNotPerform),
      reported =
        MedicationRequest.Reported.from(
          R4Boolean.of(reportedBoolean, _reportedBoolean),
          reportedReference,
        ),
      medication =
        MedicationRequest.Medication.from(medicationCodeableConcept, medicationReference)!!,
      subject = subject!!,
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      authoredOn = DateTime.of(FhirDateTime.fromString(authoredOn), _authoredOn),
      requester = requester,
      performer = performer,
      performerType = performerType,
      recorder = recorder,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
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
      groupIdentifier = groupIdentifier,
      courseOfTherapyType = courseOfTherapyType,
      insurance = insurance ?: listOf(),
      note = note ?: listOf(),
      dosageInstruction = dosageInstruction ?: listOf(),
      dispenseRequest = dispenseRequest,
      substitution = substitution,
      priorPrescription = priorPrescription,
      detectedIssue = detectedIssue ?: listOf(),
      eventHistory = eventHistory ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationRequest) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MedicationRequest")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.statusReasonSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.categorySer, value.category)
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(__desc, 20, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.reported) {
      null -> {}
      is MedicationRequest.Reported.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
        }
      }
      is MedicationRequest.Reported.Reference -> {
        encoder.encodeSerializableElement(__desc, 24, Hoisted.reportedReferenceSer, __d.value)
      }
    }
    when (val __d = value.medication) {
      null -> {}
      is MedicationRequest.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.statusReasonSer, __d.value)
      }
      is MedicationRequest.Medication.Reference -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.reportedReferenceSer, __d.value)
      }
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.reportedReferenceSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.reportedReferenceSer, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29,
        Hoisted.supportingInformationSer,
        value.supportingInformation,
      )
    ((value.authoredOn?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.reportedReferenceSer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.reportedReferenceSer, it)
    }
    (value.performerType)?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.statusReasonSer, it)
    }
    (value.recorder)?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.reportedReferenceSer, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.categorySer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        37,
        Hoisted.supportingInformationSer,
        value.reasonReference,
      )
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.supportingInformationSer, value.basedOn)
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.identifierSerInner, it)
    }
    (value.courseOfTherapyType)?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.statusReasonSer, it)
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        45,
        Hoisted.supportingInformationSer,
        value.insurance,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.noteSer, value.note)
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        47,
        Hoisted.dosageInstructionSer,
        value.dosageInstruction,
      )
    (value.dispenseRequest)?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.dispenseRequestSer, it)
    }
    (value.substitution)?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.substitutionSer, it)
    }
    (value.priorPrescription)?.let {
      encoder.encodeSerializableElement(__desc, 50, Hoisted.reportedReferenceSer, it)
    }
    if (value.detectedIssue.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        51,
        Hoisted.supportingInformationSer,
        value.detectedIssue,
      )
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        52,
        Hoisted.supportingInformationSer,
        value.eventHistory,
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

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val reportedReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val supportingInformationSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.reportedReferenceSer)

    public val instantiatesCanonicalSerInner: KSerializer<String> = String.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<String?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val dosageInstructionSerInner: KSerializer<Dosage> = Dosage.serializer()

    public val dosageInstructionSer: KSerializer<List<Dosage>> =
      ListSerializer(Hoisted.dosageInstructionSerInner)

    public val dispenseRequestSer: KSerializer<MedicationRequest.DispenseRequest> =
      MedicationRequest.DispenseRequest.serializer()

    public val substitutionSer: KSerializer<MedicationRequest.Substitution> =
      MedicationRequest.Substitution.serializer()
  }
}
