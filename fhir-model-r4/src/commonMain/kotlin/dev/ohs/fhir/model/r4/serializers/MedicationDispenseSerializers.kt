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
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicationDispense
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.MedicationDispenseStatusCodes
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

internal object MedicationDispensePerformerSerializer : KSerializer<MedicationDispense.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationDispense.Performer>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationDispense.Performer {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationDispense.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor =
        actor
          ?: throw SerializationException(
            "Missing required property 'actor' on MedicationDispense.Performer"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Performer) {
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
      CodeableConceptSerializer,
      value.function,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationDispenseSubstitutionSerializer :
  KSerializer<MedicationDispense.Substitution> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substitution") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("wasSubstituted", KotlinBoolean.serializer().descriptor)
      optionalElement("_wasSubstituted", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("reason", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("responsibleParty", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationDispense.Substitution>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationDispense.Substitution {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var wasSubstituted: KotlinBoolean? = null
    var _wasSubstituted: Element? = null
    var type: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    var responsibleParty: List<Reference>? = null
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
        3 -> wasSubstituted = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _wasSubstituted =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          type =
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
              CodeableConceptSerializer.listSerializer,
              null,
            )
        7 ->
          responsibleParty =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationDispense.Substitution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      wasSubstituted =
        R4Boolean.of(wasSubstituted, _wasSubstituted)
          ?: throw SerializationException(
            "Missing required property 'wasSubstituted' on MedicationDispense.Substitution"
          ),
      type = type,
      reason = reason ?: listOf(),
      responsibleParty = responsibleParty ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Substitution) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.wasSubstituted.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.wasSubstituted)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.reason.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        CodeableConceptSerializer.listSerializer,
        value.reason,
      )
    if (value.responsibleParty.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        ReferenceSerializer.listSerializer,
        value.responsibleParty,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationDispenseSerializer : FhirResourceSerializer<MedicationDispense> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicationDispense")

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
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReasonCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("statusReasonReference", ReferenceSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("medicationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("medicationReference", ReferenceSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("context", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("performer", MedicationDispensePerformerSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("authorizingPrescription", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("daysSupply", QuantitySerializer.descriptor)
    b.optionalElement("whenPrepared", String.serializer().descriptor)
    b.optionalElement("_whenPrepared", ElementSerializer.descriptor)
    b.optionalElement("whenHandedOver", String.serializer().descriptor)
    b.optionalElement("_whenHandedOver", ElementSerializer.descriptor)
    b.optionalElement("destination", ReferenceSerializer.descriptor)
    b.optionalElement("receiver", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("dosageInstruction", DosageSerializer.listSerializer.descriptor)
    b.optionalElement("substitution", MedicationDispenseSubstitutionSerializer.descriptor)
    b.optionalElement("detectedIssue", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("eventHistory", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationDispense {
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
    var partOf: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var statusReasonCodeableConcept: CodeableConcept? = null
    var statusReasonReference: Reference? = null
    var category: CodeableConcept? = null
    var medicationCodeableConcept: CodeableConcept? = null
    var medicationReference: Reference? = null
    var subject: Reference? = null
    var context: Reference? = null
    var supportingInformation: List<Reference>? = null
    var performer: List<MedicationDispense.Performer>? = null
    var location: Reference? = null
    var authorizingPrescription: List<Reference>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
    var daysSupply: Quantity? = null
    var whenPrepared: String? = null
    var _whenPrepared: Element? = null
    var whenHandedOver: String? = null
    var _whenHandedOver: Element? = null
    var destination: Reference? = null
    var `receiver`: List<Reference>? = null
    var note: List<Annotation>? = null
    var dosageInstruction: List<Dosage>? = null
    var substitution: MedicationDispense.Substitution? = null
    var detectedIssue: List<Reference>? = null
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
          partOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          statusReasonCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          statusReasonReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          medicationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          medicationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 ->
          context =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 ->
          supportingInformation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationDispensePerformerSerializer.listSerializer,
              null,
            )
        23 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          authorizingPrescription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        25 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        27 ->
          daysSupply =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        28 -> whenPrepared = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _whenPrepared =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> whenHandedOver = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _whenHandedOver =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          destination =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        33 ->
          `receiver` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        34 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        35 ->
          dosageInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        36 ->
          substitution =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationDispenseSubstitutionSerializer,
              null,
            )
        37 ->
          detectedIssue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        38 ->
          eventHistory =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MedicationDispense: " + i)
      }
    }
    return MedicationDispense(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) MedicationDispenseStatusCodes.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on MedicationDispense"
          ),
      statusReason =
        MedicationDispense.StatusReason.from(statusReasonCodeableConcept, statusReasonReference),
      category = category,
      medication =
        MedicationDispense.Medication.from(medicationCodeableConcept, medicationReference)
          ?: throw SerializationException(
            "Missing required property 'medication' on MedicationDispense"
          ),
      subject = subject,
      context = context,
      supportingInformation = supportingInformation ?: listOf(),
      performer = performer ?: listOf(),
      location = location,
      authorizingPrescription = authorizingPrescription ?: listOf(),
      type = type,
      quantity = quantity,
      daysSupply = daysSupply,
      whenPrepared =
        DateTime.of(
          if (whenPrepared != null) FhirDateTime.fromString(whenPrepared) else null,
          _whenPrepared,
        ),
      whenHandedOver =
        DateTime.of(
          if (whenHandedOver != null) FhirDateTime.fromString(whenHandedOver) else null,
          _whenHandedOver,
        ),
      destination = destination,
      `receiver` = `receiver` ?: listOf(),
      note = note ?: listOf(),
      dosageInstruction = dosageInstruction ?: listOf(),
      substitution = substitution,
      detectedIssue = detectedIssue ?: listOf(),
      eventHistory = eventHistory ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationDispense,
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
    if (value.partOf.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    when (val choice = value.statusReason) {
      null -> {}
      is MedicationDispense.StatusReason.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          14 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicationDispense.StatusReason.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          15 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.category,
    )
    when (val choice = value.medication) {
      is MedicationDispense.Medication.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicationDispense.Medication.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          18 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.context,
    )
    if (value.supportingInformation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    if (value.performer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        MedicationDispensePerformerSerializer.listSerializer,
        value.performer,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    if (value.authorizingPrescription.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.authorizingPrescription,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      QuantitySerializer,
      value.daysSupply,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.whenPrepared?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.whenPrepared)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.whenHandedOver?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.whenHandedOver)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.destination,
    )
    if (value.`receiver`.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.`receiver`,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.dosageInstruction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosageInstruction,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      36 + descriptorOffset,
      MedicationDispenseSubstitutionSerializer,
      value.substitution,
    )
    if (value.detectedIssue.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.detectedIssue,
      )
    if (value.eventHistory.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.eventHistory,
      )
  }
}
