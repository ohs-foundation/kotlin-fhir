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
import dev.ohs.fhir.model.r5.terminologies.MedicationRequestIntent
import dev.ohs.fhir.model.r5.terminologies.MedicationrequestStatus
import dev.ohs.fhir.model.r5.terminologies.RequestPriority
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

  override fun deserialize(decoder: Decoder): MedicationRequest.DispenseRequest {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          initialFill =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationRequestDispenseRequestInitialFillSerializer,
              null,
            )
        4 ->
          dispenseInterval =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        5 ->
          validityPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        6 -> numberOfRepeatsAllowed = compositeDecoder.decodeIntElement(descriptor, i)
        7 ->
          _numberOfRepeatsAllowed =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        9 ->
          expectedSupplyDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        10 ->
          dispenser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        11 ->
          dispenserInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        12 ->
          doseAdministrationAid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DispenseRequest: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.DispenseRequest) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      MedicationRequestDispenseRequestInitialFillSerializer,
      value.initialFill,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      DurationSerializer,
      value.dispenseInterval,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      PeriodSerializer,
      value.validityPeriod,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 6, value.numberOfRepeatsAllowed?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.numberOfRepeatsAllowed)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      DurationSerializer,
      value.expectedSupplyDuration,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      ReferenceSerializer,
      value.dispenser,
    )
    if (value.dispenserInstruction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        AnnotationSerializer.listSerializer,
        value.dispenserInstruction,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      CodeableConceptSerializer,
      value.doseAdministrationAid,
    )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationRequest.DispenseRequest.InitialFill {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Quantity? = null
    var duration: Duration? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        4 ->
          duration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding InitialFill: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationRequest.DispenseRequest.InitialFill(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      quantity = quantity,
      duration = duration,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.DispenseRequest.InitialFill) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, DurationSerializer, value.duration)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationRequest.Substitution {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var allowedBoolean: KotlinBoolean? = null
    var _allowedBoolean: Element? = null
    var allowedCodeableConcept: CodeableConcept? = null
    var reason: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> allowedBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _allowedBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          allowedCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: MedicationRequest.Substitution) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.allowed) {
      is MedicationRequest.Substitution.Allowed.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is MedicationRequest.Substitution.Allowed.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.reason,
    )
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          priorPrescription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        13 ->
          groupIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        14 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          statusReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 -> statusChanged = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _statusChanged =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> intent = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _intent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        22 -> priority = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> doNotPerform = compositeDecoder.decodeBooleanElement(descriptor, i)
        25 ->
          _doNotPerform =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          medication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        27 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        28 ->
          informationSource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        30 ->
          supportingInformation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        31 -> authoredOn = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _authoredOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          requester =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        34 -> reported = compositeDecoder.decodeBooleanElement(descriptor, i)
        35 ->
          _reported =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          performerType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        37 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        38 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        39 ->
          recorder =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        40 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        41 ->
          courseOfTherapyType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        42 ->
          insurance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        43 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        44 -> renderedDosageInstruction = compositeDecoder.decodeStringElement(descriptor, i)
        45 ->
          _renderedDosageInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        46 ->
          effectiveDosePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        47 ->
          dosageInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        48 ->
          dispenseRequest =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationRequestDispenseRequestSerializer,
              null,
            )
        49 ->
          substitution =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationRequestSubstitutionSerializer,
              null,
            )
        50 ->
          eventHistory =
            compositeDecoder.decodeNullableSerializableElement(
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
          if (status != null) MedicationrequestStatus.fromCode(status) else null,
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
          if (intent != null) MedicationRequestIntent.fromCode(intent) else null,
          _intent,
        )
          ?: throw SerializationException(
            "Missing required property 'intent' on MedicationRequest"
          ),
      category = category ?: listOf(),
      priority =
        Enumeration.of(
          if (priority != null) RequestPriority.fromCode(priority) else null,
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationRequest,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.basedOn.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      ReferenceSerializer,
      value.priorPrescription,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.statusReason,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.statusChanged?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.statusChanged)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.intent.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.intent)
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.priority?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.priority)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.doNotPerform?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.doNotPerform)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      26 + descriptorOffset,
      CodeableReferenceSerializer,
      value.medication,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.informationSource.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.informationSource,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.supportingInformation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.authoredOn)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.requester,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.reported?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.reported)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      36 + descriptorOffset,
      CodeableConceptSerializer,
      value.performerType,
    )
    if (value.performer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.performer,
      )
    if (value.device.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.device,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      ReferenceSerializer,
      value.recorder,
    )
    if (value.reason.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      CodeableConceptSerializer,
      value.courseOfTherapyType,
    )
    if (value.insurance.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.insurance,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      44 + descriptorOffset,
      value.renderedDosageInstruction?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.renderedDosageInstruction,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      PeriodSerializer,
      value.effectiveDosePeriod,
    )
    if (value.dosageInstruction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosageInstruction,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      48 + descriptorOffset,
      MedicationRequestDispenseRequestSerializer,
      value.dispenseRequest,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      MedicationRequestSubstitutionSerializer,
      value.substitution,
    )
    if (value.eventHistory.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.eventHistory,
      )
  }
}
