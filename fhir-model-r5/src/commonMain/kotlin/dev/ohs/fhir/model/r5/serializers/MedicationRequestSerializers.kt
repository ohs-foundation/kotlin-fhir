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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
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
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "initialFill",
        MedicationRequestDispenseRequestInitialFillSerializer.descriptor,
      )
      optionalElement("dispenseInterval", DurationSerializer.descriptor)
      optionalElement("validityPeriod", PeriodSerializer.descriptor)
      optionalElement("numberOfRepeatsAllowed", Int.serializer().descriptor)
      optionalElement("_numberOfRepeatsAllowed", ElementSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("expectedSupplyDuration", DurationSerializer.descriptor)
      optionalElement("dispenser", ReferenceSerializer.descriptor)
      optionalElement("dispenserInstruction", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("doseAdministrationAid", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationRequest.DispenseRequest>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationRequest.DispenseRequest =
    decoder.decodeStructure(descriptor) {
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
            initialFill =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationRequestDispenseRequestInitialFillSerializer,
                null,
              )
          4 ->
            dispenseInterval =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          5 ->
            validityPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          6 -> numberOfRepeatsAllowed = decodeIntElement(descriptor, i)
          7 ->
            _numberOfRepeatsAllowed =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 ->
            expectedSupplyDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          10 ->
            dispenser = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          11 ->
            dispenserInstruction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          12 ->
            doseAdministrationAid =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DispenseRequest: " + i)
        }
      }
      MedicationRequest.DispenseRequest(
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

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.DispenseRequest) {
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
      encodeSerializableIfNotNull(
        descriptor,
        3,
        MedicationRequestDispenseRequestInitialFillSerializer,
        value.initialFill,
      )
      encodeSerializableIfNotNull(descriptor, 4, DurationSerializer, value.dispenseInterval)
      encodeSerializableIfNotNull(descriptor, 5, PeriodSerializer, value.validityPeriod)
      encodeIntIfNotNull(descriptor, 6, value.numberOfRepeatsAllowed?.value)
      encodeElementIfNotNull(descriptor, 7, value.numberOfRepeatsAllowed)
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 9, DurationSerializer, value.expectedSupplyDuration)
      encodeSerializableIfNotNull(descriptor, 10, ReferenceSerializer, value.dispenser)
      if (value.dispenserInstruction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          AnnotationSerializer.listSerializer,
          value.dispenserInstruction,
        )
      encodeSerializableIfNotNull(
        descriptor,
        12,
        CodeableConceptSerializer,
        value.doseAdministrationAid,
      )
    }
  }
}

internal object MedicationRequestDispenseRequestInitialFillSerializer :
  KSerializer<MedicationRequest.DispenseRequest.InitialFill> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InitialFill") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("duration", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationRequest.DispenseRequest.InitialFill>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationRequest.DispenseRequest.InitialFill =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var quantity: Quantity? = null
      var duration: Duration? = null
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
          3 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          4 -> duration = decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding InitialFill: " + i)
        }
      }
      MedicationRequest.DispenseRequest.InitialFill(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        quantity = quantity,
        duration = duration,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.DispenseRequest.InitialFill) {
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
      encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 4, DurationSerializer, value.duration)
    }
  }
}

internal object MedicationRequestSubstitutionSerializer :
  KSerializer<MedicationRequest.Substitution> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substitution") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("allowedBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_allowedBoolean", ElementSerializer.descriptor)
      optionalElement("allowedCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("reason", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationRequest.Substitution>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationRequest.Substitution =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var allowedBoolean: KotlinBoolean? = null
      var _allowedBoolean: Element? = null
      var allowedCodeableConcept: CodeableConcept? = null
      var reason: CodeableConcept? = null
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
          3 -> allowedBoolean = decodeBooleanElement(descriptor, i)
          4 ->
            _allowedBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            allowedCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            reason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Substitution: " + i)
        }
      }
      MedicationRequest.Substitution(
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

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.Substitution) {
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
      when (val choice = value.allowed) {
        is MedicationRequest.Substitution.Allowed.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is MedicationRequest.Substitution.Allowed.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.reason)
    }
  }
}

internal object MedicationRequestSerializer : FhirResourceSerializer<MedicationRequest> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicationRequest")

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
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("priorPrescription", ReferenceSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("statusChanged", String.serializer().descriptor)
    b.optionalElement("_statusChanged", ElementSerializer.descriptor)
    b.optionalElement("intent", String.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("priority", String.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_doNotPerform", ElementSerializer.descriptor)
    b.optionalElement("medication", CodeableReferenceSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("informationSource", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("authoredOn", String.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("requester", ReferenceSerializer.descriptor)
    b.optionalElement("reported", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_reported", ElementSerializer.descriptor)
    b.optionalElement("performerType", CodeableConceptSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("device", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("recorder", ReferenceSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("courseOfTherapyType", CodeableConceptSerializer.descriptor)
    b.optionalElement("insurance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("renderedDosageInstruction", String.serializer().descriptor)
    b.optionalElement("_renderedDosageInstruction", ElementSerializer.descriptor)
    b.optionalElement("effectiveDosePeriod", PeriodSerializer.descriptor)
    b.optionalElement("dosageInstruction", DosageSerializer.listSerializer.descriptor)
    b.optionalElement("dispenseRequest", MedicationRequestDispenseRequestSerializer.descriptor)
    b.optionalElement("substitution", MedicationRequestSubstitutionSerializer.descriptor)
    b.optionalElement("eventHistory", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
          if (status != null) MedicationRequest.MedicationrequestStatus.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on MedicationRequest"
          ),
      statusReason = statusReason,
      statusChanged =
        DateTime.of(
          if (statusChanged != null) FhirDateTime.fromString(statusChanged) else null,
          _statusChanged,
        ),
      intent =
        Enumeration.of(
          if (intent != null) MedicationRequest.MedicationRequestIntent.fromCode(intent) else null,
          _intent,
        )
          ?: throw SerializationException(
            "Missing required property 'intent' on MedicationRequest"
          ),
      category = category ?: listOf(),
      priority =
        Enumeration.of(
          if (priority != null) MedicationRequest.RequestPriority.fromCode(priority) else null,
          _priority,
        ),
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
      authoredOn =
        DateTime.of(
          if (authoredOn != null) FhirDateTime.fromString(authoredOn) else null,
          _authoredOn,
        ),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationRequest,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      ReferenceSerializer,
      value.priorPrescription,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.statusReason,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.statusChanged?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.statusChanged)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.intent)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.priority)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.doNotPerform?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.doNotPerform)
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.authoredOn)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    encoder.encodeBooleanIfNotNull(descriptor, 34 + descriptorOffset, value.reported?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.reported)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      36 + descriptorOffset,
      CodeableConceptSerializer,
      value.performerType,
    )
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      ReferenceSerializer,
      value.recorder,
    )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      CodeableConceptSerializer,
      value.courseOfTherapyType,
    )
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
    encoder.encodeStringIfNotNull(
      descriptor,
      44 + descriptorOffset,
      value.renderedDosageInstruction?.value,
    )
    encoder.encodeElementIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.renderedDosageInstruction,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      PeriodSerializer,
      value.effectiveDosePeriod,
    )
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosageInstruction,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      48 + descriptorOffset,
      MedicationRequestDispenseRequestSerializer,
      value.dispenseRequest,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      MedicationRequestSubstitutionSerializer,
      value.substitution,
    )
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.eventHistory,
      )
  }
}
