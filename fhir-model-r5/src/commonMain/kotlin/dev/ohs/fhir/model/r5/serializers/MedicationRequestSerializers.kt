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
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.UnsignedInt
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

  internal val listSerializer: KSerializer<List<MedicationRequest.DispenseRequest>> =
    ListSerializer(this)

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
    var dispenser: Reference? = null
    var dispenserInstruction: List<Annotation>? = null
    var doseAdministrationAid: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          initialFill =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationRequestDispenseRequestInitialFillSerializer,
              null,
            )
        4 ->
          dispenseInterval =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        5 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        6 -> numberOfRepeatsAllowed = decoder.decodeIntElement(descriptor, i)
        7 ->
          _numberOfRepeatsAllowed =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        9 ->
          expectedSupplyDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        10 ->
          dispenser =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        11 ->
          dispenserInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        12 ->
          doseAdministrationAid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
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
      dispenser = dispenser,
      dispenserInstruction = dispenserInstruction ?: listOf(),
      doseAdministrationAid = doseAdministrationAid,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationRequest.DispenseRequest,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.initialFill)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3,
        MedicationRequestDispenseRequestInitialFillSerializer,
        it,
      )
    }
    (value.dispenseInterval)?.let {
      encoder.encodeSerializableElement(descriptor, 4, DurationSerializer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 5, PeriodSerializer, it)
    }
    ((value.numberOfRepeatsAllowed?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.numberOfRepeatsAllowed?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, it)
    }
    (value.expectedSupplyDuration)?.let {
      encoder.encodeSerializableElement(descriptor, 9, DurationSerializer, it)
    }
    (value.dispenser)?.let {
      encoder.encodeSerializableElement(descriptor, 10, ReferenceSerializer, it)
    }
    if (value.dispenserInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        AnnotationSerializer.listSerializer,
        value.dispenserInstruction,
      )
    (value.doseAdministrationAid)?.let {
      encoder.encodeSerializableElement(descriptor, 12, CodeableConceptSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<MedicationRequest.DispenseRequest.InitialFill>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        4 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 3, QuantitySerializer, it)
    }
    (value.duration)?.let {
      encoder.encodeSerializableElement(descriptor, 4, DurationSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<MedicationRequest.Substitution>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> allowedBoolean = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _allowedBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          allowedCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
          R5Boolean.of(allowedBoolean, _allowedBoolean),
          allowedCodeableConcept,
        )
          ?: throw SerializationException(
            "Missing required property 'allowed' on MedicationRequest.Substitution"
          ),
      reason = reason,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationRequest.Substitution,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.allowed) {
      is MedicationRequest.Substitution.Allowed.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
        }
      }
      is MedicationRequest.Substitution.Allowed.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
      }
    }
    (value.reason)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("priorPrescription", Reference.serializer().descriptor, isOptional = true)
    b.element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("statusChanged", String.serializer().descriptor, isOptional = true)
    b.element("_statusChanged", Element.serializer().descriptor, isOptional = true)
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
    b.element("medication", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "informationSource",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("authoredOn", String.serializer().descriptor, isOptional = true)
    b.element("_authoredOn", Element.serializer().descriptor, isOptional = true)
    b.element("requester", Reference.serializer().descriptor, isOptional = true)
    b.element("reported", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_reported", Element.serializer().descriptor, isOptional = true)
    b.element("performerType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "device",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("recorder", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("courseOfTherapyType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "insurance",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("renderedDosageInstruction", String.serializer().descriptor, isOptional = true)
    b.element("_renderedDosageInstruction", Element.serializer().descriptor, isOptional = true)
    b.element("effectiveDosePeriod", Period.serializer().descriptor, isOptional = true)
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
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          priorPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        13 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        14 -> status = decoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          statusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 -> statusChanged = decoder.decodeStringElement(descriptor, i)
        18 ->
          _statusChanged =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> intent = decoder.decodeStringElement(descriptor, i)
        20 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        22 -> priority = decoder.decodeStringElement(descriptor, i)
        23 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          medication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        27 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          informationSource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        30 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        31 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        32 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        34 -> reported = decoder.decodeBooleanElement(descriptor, i)
        35 ->
          _reported =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          performerType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        37 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        38 ->
          device =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        39 ->
          recorder =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        40 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        41 ->
          courseOfTherapyType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        42 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        43 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        44 -> renderedDosageInstruction = decoder.decodeStringElement(descriptor, i)
        45 ->
          _renderedDosageInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        46 ->
          effectiveDosePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        47 ->
          dosageInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        48 ->
          dispenseRequest =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationRequestDispenseRequestSerializer,
              null,
            )
        49 ->
          substitution =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationRequestSubstitutionSerializer,
              null,
            )
        50 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
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
      basedOn = basedOn ?: listOf(),
      priorPrescription = priorPrescription,
      groupIdentifier = groupIdentifier,
      status =
        Enumeration.of(
          status?.let { MedicationRequest.MedicationrequestStatus.fromCode(it) },
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on MedicationRequest"
          ),
      statusReason = statusReason,
      statusChanged =
        DateTime.of(statusChanged?.let { FhirDateTime.fromString(it) }, _statusChanged),
      intent =
        Enumeration.of(
          intent?.let { MedicationRequest.MedicationRequestIntent.fromCode(it) },
          _intent,
        )
          ?: throw SerializationException(
            "Missing required property 'intent' on MedicationRequest"
          ),
      category = category ?: listOf(),
      priority =
        Enumeration.of(priority?.let { MedicationRequest.RequestPriority.fromCode(it) }, _priority),
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      medication =
        medication
          ?: throw SerializationException(
            "Missing required property 'medication' on MedicationRequest"
          ),
      subject =
        subject
          ?: throw SerializationException(
            "Missing required property 'subject' on MedicationRequest"
          ),
      informationSource = informationSource ?: listOf(),
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      authoredOn = DateTime.of(authoredOn?.let { FhirDateTime.fromString(it) }, _authoredOn),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationRequest,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    (value.priorPrescription)?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, IdentifierSerializer, it)
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, ElementSerializer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    ((value.statusChanged?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.statusChanged?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ElementSerializer, it)
    }
    ((value.intent.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, ElementSerializer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    ((value.priority?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ElementSerializer, it)
    }
    ((value.doNotPerform?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      26 + descriptorOffset,
      CodeableReferenceSerializer,
      value.medication,
    )
    encoder.encodeSerializableElement(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.informationSource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.informationSource,
      )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, ReferenceSerializer, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    ((value.authoredOn?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 32 + descriptorOffset, ElementSerializer, it)
    }
    (value.requester)?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, ReferenceSerializer, it)
    }
    ((value.reported?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.reported?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, ElementSerializer, it)
    }
    (value.performerType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.performer,
      )
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.device,
      )
    (value.recorder)?.let {
      encoder.encodeSerializableElement(descriptor, 39 + descriptorOffset, ReferenceSerializer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    (value.courseOfTherapyType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.insurance,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    ((value.renderedDosageInstruction?.value))?.let {
      encoder.encodeStringElement(descriptor, 44 + descriptorOffset, it)
    }
    (value.renderedDosageInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 45 + descriptorOffset, ElementSerializer, it)
    }
    (value.effectiveDosePeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 46 + descriptorOffset, PeriodSerializer, it)
    }
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosageInstruction,
      )
    (value.dispenseRequest)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        MedicationRequestDispenseRequestSerializer,
        it,
      )
    }
    (value.substitution)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        MedicationRequestSubstitutionSerializer,
        it,
      )
    }
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.eventHistory,
      )
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
