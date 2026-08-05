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
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.MedicationStatement
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Uri
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

internal object MedicationStatementSerializer : KSerializer<MedicationStatement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationStatement") {
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
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "statusReason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("category", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "medicationCodeableConcept",
      CodeableConcept.serializer().descriptor,
      isOptional = true,
    )
    b.element("medicationReference", Reference.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("context", Reference.serializer().descriptor, isOptional = true)
    b.element("effectiveDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("dateAsserted", String.serializer().descriptor, isOptional = true)
    b.element("_dateAsserted", Element.serializer().descriptor, isOptional = true)
    b.element("informationSource", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "derivedFrom",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
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
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("dosage", listSerialDescriptor(Dosage.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): MedicationStatement =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationStatement) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicationStatement")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationStatement {
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
    var status: String? = null
    var _status: Element? = null
    var statusReason: List<CodeableConcept>? = null
    var category: CodeableConcept? = null
    var medicationCodeableConcept: CodeableConcept? = null
    var medicationReference: Reference? = null
    var subject: Reference? = null
    var context: Reference? = null
    var effectiveDateTime: String? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var dateAsserted: String? = null
    var _dateAsserted: Element? = null
    var informationSource: Reference? = null
    var derivedFrom: List<Reference>? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var dosage: List<Dosage>? = null
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
        11 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        12 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.statusReasonSerInner,
              null,
            )
        17 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.statusReasonSerInner,
              null,
            )
        18 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        20 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        21 -> effectiveDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        24 -> dateAsserted = decoder.decodeStringElement(descriptor, i)
        25 ->
          _dateAsserted =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 ->
          informationSource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        27 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        28 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        29 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        30 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        31 ->
          dosage = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dosageSer, null)
        else -> throw SerializationException("Unexpected index decoding MedicationStatement: " + i)
      }
    }
    return MedicationStatement(
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
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          MedicationStatement.MedicationStatementStatusCodes.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on MedicationStatement"
              )
          ),
          _status,
        ),
      statusReason = statusReason ?: listOf(),
      category = category,
      medication =
        MedicationStatement.Medication.from(medicationCodeableConcept, medicationReference)
          ?: throw SerializationException(
            "Missing required property 'medication' on MedicationStatement"
          ),
      subject =
        subject
          ?: throw SerializationException(
            "Missing required property 'subject' on MedicationStatement"
          ),
      context = context,
      effective =
        MedicationStatement.Effective.from(
          DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
          effectivePeriod,
        ),
      dateAsserted = DateTime.of(FhirDateTime.fromString(dateAsserted), _dateAsserted),
      informationSource = informationSource,
      derivedFrom = derivedFrom ?: listOf(),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      dosage = dosage ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationStatement,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.basedOnSer,
        value.partOf,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.statusReasonSer,
        value.statusReason,
      )
    (value.category)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.statusReasonSerInner,
        it,
      )
    }
    when (val choice = value.medication) {
      is MedicationStatement.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.statusReasonSerInner,
          choice.value,
        )
      }
      is MedicationStatement.Medication.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          18 + descriptorOffset,
          Hoisted.basedOnSerInner,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      Hoisted.basedOnSerInner,
      value.subject,
    )
    (value.context)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    when (val choice = value.effective) {
      null -> {}
      is MedicationStatement.Effective.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
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
      is MedicationStatement.Effective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          Hoisted.effectivePeriodSer,
          choice.value,
        )
      }
    }
    ((value.dateAsserted?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.dateAsserted?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.informationSource)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.basedOnSer,
        value.derivedFrom,
      )
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.statusReasonSer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.basedOnSer,
        value.reasonReference,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.dosageSer,
        value.dosage,
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val statusReasonSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val statusReasonSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val dosageSerInner: KSerializer<Dosage> = Dosage.serializer()

    public val dosageSer: KSerializer<List<Dosage>> = ListSerializer(Hoisted.dosageSerInner)
  }
}

internal object MedicationStatementPolymorphicSerializer : KSerializer<MedicationStatement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationStatement") {
      MedicationStatementSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationStatement) {
    encoder.encodeStructure(descriptor) {
      MedicationStatementSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicationStatement =
    decoder.decodeStructure(descriptor) {
      MedicationStatementSerializer.deserializeInternal(this, descriptor, 0)
    }
}
