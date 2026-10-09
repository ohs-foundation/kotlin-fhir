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
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MedicationDispense
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.MedicationDispenseStatusCodes
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object MedicationDispensePerformerSerializer :
  FhirSerializer<MedicationDispense.Performer> {
  override val descriptor: SerialDescriptor = buildDescriptor("Performer", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationDispense.Performer>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("function", CodeableConceptSerializer.descriptor)
    b.optionalElement("actor", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.Performer {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationDispense.Performer(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      function = function,
      actor = required(actor, "MedicationDispense.Performer", "actor"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Performer) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationDispense.Substitution> {
  override val descriptor: SerialDescriptor = buildDescriptor("Substitution", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationDispense.Substitution>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("wasSubstituted")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("reason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("responsibleParty", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.Substitution {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var wasSubstituted: KotlinBoolean? = null
    var _wasSubstituted: Element? = null
    var type: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    var responsibleParty: Reference? = null
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
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationDispense.Substitution(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      wasSubstituted =
        required(
          R5Boolean.of(wasSubstituted, _wasSubstituted),
          "MedicationDispense.Substitution",
          "wasSubstituted",
        ),
      type = type,
      reason = listOrEmpty(reason),
      responsibleParty = responsibleParty,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Substitution) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      CodeableConceptSerializer.listSerializer,
      value.reason,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      ReferenceSerializer,
      value.responsibleParty,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationDispenseSerializer : FhirResourceSerializer<MedicationDispense> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicationDispense")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("notPerformedReason", CodeableReferenceSerializer.descriptor)
    b.strPrim("statusChanged")
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("medication", CodeableReferenceSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("performer", MedicationDispensePerformerSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("authorizingPrescription", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("daysSupply", QuantitySerializer.descriptor)
    b.strPrim("recorded")
    b.strPrim("whenPrepared")
    b.strPrim("whenHandedOver")
    b.optionalElement("destination", ReferenceSerializer.descriptor)
    b.optionalElement("receiver", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.strPrim("renderedDosageInstruction")
    b.optionalElement("dosageInstruction", DosageSerializer.listSerializer.descriptor)
    b.optionalElement("substitution", MedicationDispenseSubstitutionSerializer.descriptor)
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
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: MedicationDispenseStatusCodes? = null
    var _status: Element? = null
    var notPerformedReason: CodeableReference? = null
    var statusChanged: FhirDateTime? = null
    var _statusChanged: Element? = null
    var category: List<CodeableConcept>? = null
    var medication: CodeableReference? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var performer: List<MedicationDispense.Performer>? = null
    var location: Reference? = null
    var authorizingPrescription: List<Reference>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
    var daysSupply: Quantity? = null
    var recorded: FhirDateTime? = null
    var _recorded: Element? = null
    var whenPrepared: FhirDateTime? = null
    var _whenPrepared: Element? = null
    var whenHandedOver: FhirDateTime? = null
    var _whenHandedOver: Element? = null
    var destination: Reference? = null
    var `receiver`: List<Reference>? = null
    var note: List<Annotation>? = null
    var renderedDosageInstruction: String? = null
    var _renderedDosageInstruction: Element? = null
    var dosageInstruction: List<Dosage>? = null
    var substitution: MedicationDispense.Substitution? = null
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
          partOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 ->
          status =
            MedicationDispenseStatusCodes.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        14 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          notPerformedReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        16 ->
          statusChanged =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        17 ->
          _statusChanged =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          medication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        20 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          supportingInformation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationDispensePerformerSerializer.listSerializer,
              null,
            )
        24 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        25 ->
          authorizingPrescription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        28 ->
          daysSupply =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        29 ->
          recorded = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        30 ->
          _recorded =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          whenPrepared =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        32 ->
          _whenPrepared =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          whenHandedOver =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        34 ->
          _whenHandedOver =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          destination =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        36 ->
          `receiver` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        38 -> renderedDosageInstruction = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _renderedDosageInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 ->
          dosageInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        41 ->
          substitution =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationDispenseSubstitutionSerializer,
              null,
            )
        42 ->
          eventHistory =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return MedicationDispense(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      basedOn = listOrEmpty(basedOn),
      partOf = listOrEmpty(partOf),
      status = required(Enumeration.of(status, _status), "MedicationDispense", "status"),
      notPerformedReason = notPerformedReason,
      statusChanged = DateTime.of(statusChanged, _statusChanged),
      category = listOrEmpty(category),
      medication = required(medication, "MedicationDispense", "medication"),
      subject = required(subject, "MedicationDispense", "subject"),
      encounter = encounter,
      supportingInformation = listOrEmpty(supportingInformation),
      performer = listOrEmpty(performer),
      location = location,
      authorizingPrescription = listOrEmpty(authorizingPrescription),
      type = type,
      quantity = quantity,
      daysSupply = daysSupply,
      recorded = DateTime.of(recorded, _recorded),
      whenPrepared = DateTime.of(whenPrepared, _whenPrepared),
      whenHandedOver = DateTime.of(whenHandedOver, _whenHandedOver),
      destination = destination,
      `receiver` = listOrEmpty(`receiver`),
      note = listOrEmpty(note),
      renderedDosageInstruction =
        Markdown.of(renderedDosageInstruction, _renderedDosageInstruction),
      dosageInstruction = listOrEmpty(dosageInstruction),
      substitution = substitution,
      eventHistory = listOrEmpty(eventHistory),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.basedOn,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.partOf,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableReferenceSerializer,
      value.notPerformedReason,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.statusChanged?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.statusChanged)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      CodeableReferenceSerializer,
      value.medication,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.supportingInformation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      MedicationDispensePerformerSerializer.listSerializer,
      value.performer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.authorizingPrescription,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      QuantitySerializer,
      value.daysSupply,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.recorded?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.recorded)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.whenPrepared?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.whenPrepared)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.whenHandedOver?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.whenHandedOver)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      ReferenceSerializer,
      value.destination,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.`receiver`,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      37 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      38 + descriptorOffset,
      value.renderedDosageInstruction?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.renderedDosageInstruction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      40 + descriptorOffset,
      DosageSerializer.listSerializer,
      value.dosageInstruction,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      MedicationDispenseSubstitutionSerializer,
      value.substitution,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      42 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.eventHistory,
    )
  }
}
