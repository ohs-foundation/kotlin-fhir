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
import kotlin.OptIn
import kotlin.String
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.DispenseRequest) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationRequest.DispenseRequest {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          initialFill =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.initialFillSer, null)
        4 ->
          dispenseInterval =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dispenseIntervalSer,
              null,
            )
        5 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validityPeriodSer,
              null,
            )
        6 -> numberOfRepeatsAllowed = decoder.decodeIntElement(descriptor, i)
        7 ->
          _numberOfRepeatsAllowed =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.numberOfRepeatsAllowedSer,
              null,
            )
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        9 ->
          expectedSupplyDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dispenseIntervalSer,
              null,
            )
        10 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DispenseRequest: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationRequest.DispenseRequest,
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
    (value.initialFill)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.initialFillSer, it)
    }
    (value.dispenseInterval)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.dispenseIntervalSer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.validityPeriodSer, it)
    }
    ((value.numberOfRepeatsAllowed?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.numberOfRepeatsAllowed?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.numberOfRepeatsAllowedSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.quantitySer, it)
    }
    (value.expectedSupplyDuration)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.dispenseIntervalSer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.performerSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.DispenseRequest.InitialFill) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationRequest.DispenseRequest.InitialFill {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Quantity? = null
    var duration: Duration? = null
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
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        4 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.durationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding InitialFill: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationRequest.DispenseRequest.InitialFill,
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
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.quantitySer, it)
    }
    (value.duration)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.durationSer, it)
    }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.Substitution) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationRequest.Substitution {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var allowedBoolean: KotlinBoolean? = null
    var _allowedBoolean: Element? = null
    var allowedCodeableConcept: CodeableConcept? = null
    var reason: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> allowedBoolean = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _allowedBoolean =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedBooleanSer,
              null,
            )
        5 ->
          allowedCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedCodeableConceptSer,
              null,
            )
        6 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationRequest.Substitution,
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
    when (val choice = value.allowed) {
      is MedicationRequest.Substitution.Allowed.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.allowedBooleanSer, it)
        }
      }
      is MedicationRequest.Substitution.Allowed.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          5,
          Hoisted.allowedCodeableConceptSer,
          choice.value,
        )
      }
    }
    (value.reason)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.allowedCodeableConceptSer, it)
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
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("intent", String.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("priority", String.serializer().descriptor, isOptional = true)
    b.element("_priority", Element.serializer().descriptor, isOptional = true)
    b.element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
    b.element("reportedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_reportedBoolean", Element.serializer().descriptor, isOptional = true)
    b.element("reportedReference", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "medicationCodeableConcept",
      CodeableConcept.serializer().descriptor,
      isOptional = true,
    )
    b.element("medicationReference", Reference.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("authoredOn", String.serializer().descriptor, isOptional = true)
    b.element("_authoredOn", Element.serializer().descriptor, isOptional = true)
    b.element("requester", Reference.serializer().descriptor, isOptional = true)
    b.element("performer", Reference.serializer().descriptor, isOptional = true)
    b.element("performerType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("recorder", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reasonCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reasonReference",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesCanonical",
      listSerialDescriptor(String.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesUri",
      listSerialDescriptor(String.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("courseOfTherapyType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "insurance",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "dosageInstruction",
      listSerialDescriptor(Dosage.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "dispenseRequest",
      lazyDescriptor { MedicationRequest.DispenseRequest.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "substitution",
      lazyDescriptor { MedicationRequest.Substitution.serializer().descriptor },
      isOptional = true,
    )
    b.element("priorPrescription", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "detectedIssue",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "eventHistory",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicationRequest =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicationRequest")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationRequest {
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        14 -> intent = decoder.decodeStringElement(descriptor, i)
        15 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        17 -> priority = decoder.decodeStringElement(descriptor, i)
        18 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        20 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> reportedBoolean = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _reportedBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          reportedReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportedReferenceSer,
              null,
            )
        24 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        25 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportedReferenceSer,
              null,
            )
        26 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportedReferenceSer,
              null,
            )
        27 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportedReferenceSer,
              null,
            )
        28 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInformationSer,
              null,
            )
        29 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        30 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 ->
          requester =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportedReferenceSer,
              null,
            )
        32 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportedReferenceSer,
              null,
            )
        33 ->
          performerType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        34 ->
          recorder =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportedReferenceSer,
              null,
            )
        35 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        36 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInformationSer,
              null,
            )
        37 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        38 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        39 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        40 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        41 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInformationSer,
              null,
            )
        42 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        43 ->
          courseOfTherapyType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        44 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInformationSer,
              null,
            )
        45 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        46 ->
          dosageInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dosageInstructionSer,
              null,
            )
        47 ->
          dispenseRequest =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dispenseRequestSer,
              null,
            )
        48 ->
          substitution =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.substitutionSer, null)
        49 ->
          priorPrescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportedReferenceSer,
              null,
            )
        50 ->
          detectedIssue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInformationSer,
              null,
            )
        51 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInformationSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MedicationRequest: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationRequest,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    ((value.intent.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    ((value.priority?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.doNotPerform?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.reported) {
      null -> {}
      is MedicationRequest.Reported.Boolean -> {
        ((choice.value.value))?.let {
          encoder.encodeBooleanElement(descriptor, 21 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            22 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is MedicationRequest.Reported.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          Hoisted.reportedReferenceSer,
          choice.value,
        )
      }
    }
    when (val choice = value.medication) {
      is MedicationRequest.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          Hoisted.statusReasonSer,
          choice.value,
        )
      }
      is MedicationRequest.Medication.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          Hoisted.reportedReferenceSer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableElement(
      descriptor,
      26 + descriptorOffset,
      Hoisted.reportedReferenceSer,
      value.subject,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.reportedReferenceSer,
        it,
      )
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.supportingInformationSer,
        value.supportingInformation,
      )
    ((value.authoredOn?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.reportedReferenceSer,
        it,
      )
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.reportedReferenceSer,
        it,
      )
    }
    (value.performerType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    (value.recorder)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.reportedReferenceSer,
        it,
      )
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.categorySer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.supportingInformationSer,
        value.reasonReference,
      )
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.supportingInformationSer,
        value.basedOn,
      )
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    (value.courseOfTherapyType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.supportingInformationSer,
        value.insurance,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.dosageInstructionSer,
        value.dosageInstruction,
      )
    (value.dispenseRequest)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.dispenseRequestSer,
        it,
      )
    }
    (value.substitution)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.substitutionSer,
        it,
      )
    }
    (value.priorPrescription)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.reportedReferenceSer,
        it,
      )
    }
    if (value.detectedIssue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.supportingInformationSer,
        value.detectedIssue,
      )
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
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

internal object MedicationRequestPolymorphicSerializer : KSerializer<MedicationRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationRequest") {
      MedicationRequestSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest) {
    encoder.encodeStructure(descriptor) {
      MedicationRequestSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicationRequest =
    decoder.decodeStructure(descriptor) {
      MedicationRequestSerializer.deserializeInternal(this, descriptor, 0)
    }
}
