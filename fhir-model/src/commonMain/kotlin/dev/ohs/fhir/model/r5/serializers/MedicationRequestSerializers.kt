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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Dosage
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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
      element("dispenser", Reference.serializer().descriptor, isOptional = true)
      element(
        "dispenserInstruction",
        listSerialDescriptor(Annotation.serializer().descriptor),
        isOptional = true,
      )
      element("doseAdministrationAid", CodeableConcept.serializer().descriptor, isOptional = true)
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
    var dispenser: Reference? = null
    var dispenserInstruction: List<Annotation>? = null
    var doseAdministrationAid: CodeableConcept? = null
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
          dispenser =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.dispenserSer, null)
        11 ->
          dispenserInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.dispenserInstructionSer,
              null,
            )
        12 ->
          doseAdministrationAid =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.doseAdministrationAidSer,
              null,
            )
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
      dispenser = dispenser,
      dispenserInstruction = dispenserInstruction ?: listOf(),
      doseAdministrationAid = doseAdministrationAid,
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
    (value.dispenser)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.dispenserSer, it)
    }
    if (value.dispenserInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        11,
        Hoisted.dispenserInstructionSer,
        value.dispenserInstruction,
      )
    (value.doseAdministrationAid)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.doseAdministrationAidSer, it)
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

    public val dispenserSer: KSerializer<Reference> = Reference.serializer()

    public val dispenserInstructionSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val dispenserInstructionSer: KSerializer<List<Annotation>> =
      ListSerializer(Hoisted.dispenserInstructionSerInner)

    public val doseAdministrationAidSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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
          R5Boolean.of(allowedBoolean, _allowedBoolean),
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
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("priorPrescription", Reference.serializer().descriptor, isOptional = true)
      element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("statusChanged", String.serializer().descriptor, isOptional = true)
      element("_statusChanged", Element.serializer().descriptor, isOptional = true)
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
      element("medication", CodeableReference.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element(
        "informationSource",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element(
        "supportingInformation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("authoredOn", String.serializer().descriptor, isOptional = true)
      element("_authoredOn", Element.serializer().descriptor, isOptional = true)
      element("requester", Reference.serializer().descriptor, isOptional = true)
      element("reported", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_reported", Element.serializer().descriptor, isOptional = true)
      element("performerType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "device",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("recorder", Reference.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("courseOfTherapyType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "insurance",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("renderedDosageInstruction", String.serializer().descriptor, isOptional = true)
      element("_renderedDosageInstruction", Element.serializer().descriptor, isOptional = true)
      element("effectiveDosePeriod", Period.serializer().descriptor, isOptional = true)
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
    var basedOn: List<Reference>? = null
    var priorPrescription: Reference? = null
    var groupIdentifier: Identifier? = null
    var status: String? = null
    var _status: Element? = null
    var statusReason: CodeableConcept? = null
    var statusChanged: String? = null
    var _statusChanged: Element? = null
    var intent: String? = null
    var _intent: Element? = null
    var category: List<CodeableConcept>? = null
    var priority: String? = null
    var _priority: Element? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var medication: CodeableReference? = null
    var subject: Reference? = null
    var informationSource: List<Reference>? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var authoredOn: String? = null
    var _authoredOn: Element? = null
    var requester: Reference? = null
    var reported: KotlinBoolean? = null
    var _reported: Element? = null
    var performerType: CodeableConcept? = null
    var performer: List<Reference>? = null
    var device: List<CodeableReference>? = null
    var recorder: Reference? = null
    var reason: List<CodeableReference>? = null
    var courseOfTherapyType: CodeableConcept? = null
    var insurance: List<Reference>? = null
    var note: List<Annotation>? = null
    var renderedDosageInstruction: String? = null
    var _renderedDosageInstruction: Element? = null
    var effectiveDosePeriod: Period? = null
    var dosageInstruction: List<Dosage>? = null
    var dispenseRequest: MedicationRequest.DispenseRequest? = null
    var substitution: MedicationRequest.Substitution? = null
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
        12 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.basedOnSer, null)
        13 ->
          priorPrescription =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.basedOnSerInner, null)
        14 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.identifierSerInner, null)
        15 -> status = decoder.decodeStringElement(__desc, 15)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.statusReasonSer, null)
        18 -> statusChanged = decoder.decodeStringElement(__desc, 18)
        19 ->
          _statusChanged =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> intent = decoder.decodeStringElement(__desc, 20)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.categorySer, null)
        23 -> priority = decoder.decodeStringElement(__desc, 23)
        24 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> doNotPerform = decoder.decodeBooleanElement(__desc, 25)
        26 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          medication =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.medicationSer, null)
        28 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.basedOnSerInner, null)
        29 ->
          informationSource =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.basedOnSer, null)
        30 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.basedOnSerInner, null)
        31 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.basedOnSer, null)
        32 -> authoredOn = decoder.decodeStringElement(__desc, 32)
        33 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          requester =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.basedOnSerInner, null)
        35 -> reported = decoder.decodeBooleanElement(__desc, 35)
        36 ->
          _reported =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 ->
          performerType =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.statusReasonSer, null)
        38 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.basedOnSer, null)
        39 ->
          device = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.deviceSer, null)
        40 ->
          recorder =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.basedOnSerInner, null)
        41 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.deviceSer, null)
        42 ->
          courseOfTherapyType =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.statusReasonSer, null)
        43 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.basedOnSer, null)
        44 -> note = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.noteSer, null)
        45 -> renderedDosageInstruction = decoder.decodeStringElement(__desc, 45)
        46 ->
          _renderedDosageInstruction =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.implicitRulesSer, null)
        47 ->
          effectiveDosePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              47,
              Hoisted.effectiveDosePeriodSer,
              null,
            )
        48 ->
          dosageInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              48,
              Hoisted.dosageInstructionSer,
              null,
            )
        49 ->
          dispenseRequest =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.dispenseRequestSer, null)
        50 ->
          substitution =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.substitutionSer, null)
        51 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.basedOnSer, null)
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
      basedOn = basedOn ?: listOf(),
      priorPrescription = priorPrescription,
      groupIdentifier = groupIdentifier,
      status =
        Enumeration.of(MedicationRequest.MedicationrequestStatus.fromCode(status!!), _status),
      statusReason = statusReason,
      statusChanged = DateTime.of(FhirDateTime.fromString(statusChanged), _statusChanged),
      intent =
        Enumeration.of(MedicationRequest.MedicationRequestIntent.fromCode(intent!!), _intent),
      category = category ?: listOf(),
      priority =
        priority?.let { Enumeration.of(MedicationRequest.RequestPriority.fromCode(it), _priority) },
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      medication = medication!!,
      subject = subject!!,
      informationSource = informationSource ?: listOf(),
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      authoredOn = DateTime.of(FhirDateTime.fromString(authoredOn), _authoredOn),
      requester = requester,
      reported = R5Boolean.of(reported, _reported),
      performerType = performerType,
      performer = performer ?: listOf(),
      device = device ?: listOf(),
      recorder = recorder,
      reason = reason ?: listOf(),
      courseOfTherapyType = courseOfTherapyType,
      insurance = insurance ?: listOf(),
      note = note ?: listOf(),
      renderedDosageInstruction =
        Markdown.of(renderedDosageInstruction, _renderedDosageInstruction),
      effectiveDosePeriod = effectiveDosePeriod,
      dosageInstruction = dosageInstruction ?: listOf(),
      dispenseRequest = dispenseRequest,
      substitution = substitution,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.basedOnSer, value.basedOn)
    (value.priorPrescription)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.basedOnSerInner, it)
    }
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.identifierSerInner, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.statusReasonSer, it)
    }
    ((value.statusChanged?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.statusChanged?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.categorySer, value.category)
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(__desc, 25, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    (value.medication)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.medicationSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.basedOnSerInner, it)
    }
    if (value.informationSource.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.basedOnSer, value.informationSource)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.basedOnSerInner, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.basedOnSer, value.supportingInformation)
    ((value.authoredOn?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.basedOnSerInner, it)
    }
    ((value.reported?.value))?.let { encoder.encodeBooleanElement(__desc, 35, it) }
    (value.reported?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    (value.performerType)?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.statusReasonSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.basedOnSer, value.performer)
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.deviceSer, value.device)
    (value.recorder)?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.basedOnSerInner, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.deviceSer, value.reason)
    (value.courseOfTherapyType)?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.statusReasonSer, it)
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.basedOnSer, value.insurance)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.noteSer, value.note)
    ((value.renderedDosageInstruction?.value))?.let { encoder.encodeStringElement(__desc, 45, it) }
    (value.renderedDosageInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.implicitRulesSer, it)
    }
    (value.effectiveDosePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.effectiveDosePeriodSer, it)
    }
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        48,
        Hoisted.dosageInstructionSer,
        value.dosageInstruction,
      )
    (value.dispenseRequest)?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.dispenseRequestSer, it)
    }
    (value.substitution)?.let {
      encoder.encodeSerializableElement(__desc, 50, Hoisted.substitutionSer, it)
    }
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.basedOnSer, value.eventHistory)
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

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val medicationSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val deviceSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.medicationSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val effectiveDosePeriodSer: KSerializer<Period> = Period.serializer()

    public val dosageInstructionSerInner: KSerializer<Dosage> = Dosage.serializer()

    public val dosageInstructionSer: KSerializer<List<Dosage>> =
      ListSerializer(Hoisted.dosageInstructionSerInner)

    public val dispenseRequestSer: KSerializer<MedicationRequest.DispenseRequest> =
      MedicationRequest.DispenseRequest.serializer()

    public val substitutionSer: KSerializer<MedicationRequest.Substitution> =
      MedicationRequest.Substitution.serializer()
  }
}
