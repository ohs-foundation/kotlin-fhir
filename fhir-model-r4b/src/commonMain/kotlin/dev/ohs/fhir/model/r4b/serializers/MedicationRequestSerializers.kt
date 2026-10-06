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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
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
      optionalElement("performer", ReferenceSerializer.descriptor)
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
      var performer: Reference? = null
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
            performer = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
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
        performer = performer,
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
      encodeSerializableIfNotNull(descriptor, 10, ReferenceSerializer, value.performer)
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
            R4bBoolean.of(allowedBoolean, _allowedBoolean),
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
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("intent", String.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("priority", String.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_doNotPerform", ElementSerializer.descriptor)
    b.optionalElement("reportedBoolean", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_reportedBoolean", ElementSerializer.descriptor)
    b.optionalElement("reportedReference", ReferenceSerializer.descriptor)
    b.optionalElement("medicationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("medicationReference", ReferenceSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("authoredOn", String.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("requester", ReferenceSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.descriptor)
    b.optionalElement("performerType", CodeableConceptSerializer.descriptor)
    b.optionalElement("recorder", ReferenceSerializer.descriptor)
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("courseOfTherapyType", CodeableConceptSerializer.descriptor)
    b.optionalElement("insurance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("dosageInstruction", DosageSerializer.listSerializer.descriptor)
    b.optionalElement("dispenseRequest", MedicationRequestDispenseRequestSerializer.descriptor)
    b.optionalElement("substitution", MedicationRequestSubstitutionSerializer.descriptor)
    b.optionalElement("priorPrescription", ReferenceSerializer.descriptor)
    b.optionalElement("detectedIssue", ReferenceSerializer.listSerializer.descriptor)
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          statusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 -> intent = decoder.decodeStringElement(descriptor, i)
        15 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 -> priority = decoder.decodeStringElement(descriptor, i)
        18 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        20 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> reportedBoolean = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _reportedBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          reportedReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        30 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        32 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        33 ->
          performerType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        34 ->
          recorder =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        35 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        36 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        38 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        39 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        40 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        41 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        42 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        43 ->
          courseOfTherapyType =
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
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        46 ->
          dosageInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        47 ->
          dispenseRequest =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationRequestDispenseRequestSerializer,
              null,
            )
        48 ->
          substitution =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationRequestSubstitutionSerializer,
              null,
            )
        49 ->
          priorPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        50 ->
          detectedIssue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        51 ->
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
      status =
        Enumeration.of(
          if (status != null) MedicationRequest.MedicationrequestStatus.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on MedicationRequest"
          ),
      statusReason = statusReason,
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
      doNotPerform = R4bBoolean.of(doNotPerform, _doNotPerform),
      reported =
        MedicationRequest.Reported.from(
          R4bBoolean.of(reportedBoolean, _reportedBoolean),
          reportedReference,
        ),
      medication =
        MedicationRequest.Medication.from(medicationCodeableConcept, medicationReference)
          ?: throw SerializationException(
            "Missing required property 'medication' on MedicationRequest"
          ),
      subject =
        subject
          ?: throw SerializationException(
            "Missing required property 'subject' on MedicationRequest"
          ),
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      authoredOn =
        DateTime.of(
          if (authoredOn != null) FhirDateTime.fromString(authoredOn) else null,
          _authoredOn,
        ),
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
            instantiatesCanonical?.getOrNull(index),
            _instantiatesCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'instantiatesCanonical' on MedicationRequest has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on MedicationRequest has neither a value nor an id/extension"
            )
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.statusReason,
    )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.intent)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.priority)
    encoder.encodeBooleanIfNotNull(descriptor, 19 + descriptorOffset, value.doNotPerform?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.doNotPerform)
    when (val choice = value.reported) {
      null -> {}
      is MedicationRequest.Reported.Boolean -> {
        encoder.encodeBooleanIfNotNull(descriptor, 21 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
      is MedicationRequest.Reported.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    when (val choice = value.medication) {
      is MedicationRequest.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicationRequest.Medication.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableElement(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.authoredOn)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.performer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      CodeableConceptSerializer,
      value.performerType,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      ReferenceSerializer,
      value.recorder,
    )
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
      )
    if (value.instantiatesCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        37 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        38 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        39 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 40 + descriptorOffset, value.instantiatesUri)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      CodeableConceptSerializer,
      value.courseOfTherapyType,
    )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.insurance,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosageInstruction,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      47 + descriptorOffset,
      MedicationRequestDispenseRequestSerializer,
      value.dispenseRequest,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      48 + descriptorOffset,
      MedicationRequestSubstitutionSerializer,
      value.substitution,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      ReferenceSerializer,
      value.priorPrescription,
    )
    if (value.detectedIssue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.detectedIssue,
      )
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.eventHistory,
      )
  }
}
