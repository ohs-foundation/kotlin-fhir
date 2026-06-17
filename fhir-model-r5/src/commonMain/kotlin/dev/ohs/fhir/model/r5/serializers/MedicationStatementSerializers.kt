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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Dosage
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
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

internal object MedicationStatementAdherenceSerializer :
  KSerializer<MedicationStatement.Adherence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Adherence") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationStatement.Adherence =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationStatement.Adherence) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationStatement.Adherence {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
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
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Adherence: " + i)
      }
    }
    return MedicationStatement.Adherence(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      reason = reason,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MedicationStatement.Adherence) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    (value.reason)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

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
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("medication", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("effectiveDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("effectiveTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("dateAsserted", String.serializer().descriptor, isOptional = true)
    b.element("_dateAsserted", Element.serializer().descriptor, isOptional = true)
    b.element(
      "informationSource",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "derivedFrom",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "relatedClinicalInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("renderedDosageInstruction", String.serializer().descriptor, isOptional = true)
    b.element("_renderedDosageInstruction", Element.serializer().descriptor, isOptional = true)
    b.element("dosage", listSerialDescriptor(Dosage.serializer().descriptor), isOptional = true)
    b.element(
      "adherence",
      lazyDescriptor { MedicationStatement.Adherence.serializer().descriptor },
      isOptional = true,
    )
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
    var partOf: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var medication: CodeableReference? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var effectiveDateTime: String? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var effectiveTiming: Timing? = null
    var dateAsserted: String? = null
    var _dateAsserted: Element? = null
    var informationSource: List<Reference>? = null
    var derivedFrom: List<Reference>? = null
    var reason: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var relatedClinicalInformation: List<Reference>? = null
    var renderedDosageInstruction: String? = null
    var _renderedDosageInstruction: Element? = null
    var dosage: List<Dosage>? = null
    var adherence: MedicationStatement.Adherence? = null
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
          partOf = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        15 ->
          medication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.medicationSer, null)
        16 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        17 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        18 -> effectiveDateTime = decoder.decodeStringElement(descriptor, i)
        19 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        21 ->
          effectiveTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectiveTimingSer,
              null,
            )
        22 -> dateAsserted = decoder.decodeStringElement(descriptor, i)
        23 ->
          _dateAsserted =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          informationSource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        25 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        26 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        27 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        28 ->
          relatedClinicalInformation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        29 -> renderedDosageInstruction = decoder.decodeStringElement(descriptor, i)
        30 ->
          _renderedDosageInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 ->
          dosage = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dosageSer, null)
        32 ->
          adherence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adherenceSer, null)
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
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          MedicationStatement.MedicationStatementStatusCodes.fromCode(status!!),
          _status,
        ),
      category = category ?: listOf(),
      medication = medication!!,
      subject = subject!!,
      encounter = encounter,
      effective =
        MedicationStatement.Effective.from(
          DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
          effectivePeriod,
          effectiveTiming,
        ),
      dateAsserted = DateTime.of(FhirDateTime.fromString(dateAsserted), _dateAsserted),
      informationSource = informationSource ?: listOf(),
      derivedFrom = derivedFrom ?: listOf(),
      reason = reason ?: listOf(),
      note = note ?: listOf(),
      relatedClinicalInformation = relatedClinicalInformation ?: listOf(),
      renderedDosageInstruction =
        Markdown.of(renderedDosageInstruction, _renderedDosageInstruction),
      dosage = dosage ?: listOf(),
      adherence = adherence,
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
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.partOfSer,
        value.partOf,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      Hoisted.medicationSer,
      value.medication,
    )
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      Hoisted.partOfSerInner,
      value.subject,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    when (val choice = value.effective) {
      null -> {}
      is MedicationStatement.Effective.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            19 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is MedicationStatement.Effective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          20 + descriptorOffset,
          Hoisted.effectivePeriodSer,
          choice.value,
        )
      }
      is MedicationStatement.Effective.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          Hoisted.effectiveTimingSer,
          choice.value,
        )
      }
    }
    ((value.dateAsserted?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.dateAsserted?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.informationSource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.partOfSer,
        value.informationSource,
      )
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.partOfSer,
        value.derivedFrom,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.reasonSer,
        value.reason,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.relatedClinicalInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.partOfSer,
        value.relatedClinicalInformation,
      )
    ((value.renderedDosageInstruction?.value))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.renderedDosageInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.dosageSer,
        value.dosage,
      )
    (value.adherence)?.let {
      encoder.encodeSerializableElement(descriptor, 32 + descriptorOffset, Hoisted.adherenceSer, it)
    }
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

    public val partOfSerInner: KSerializer<Reference> = Reference.serializer()

    public val partOfSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.partOfSerInner)

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val medicationSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val effectiveTimingSer: KSerializer<Timing> = Timing.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.medicationSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val dosageSerInner: KSerializer<Dosage> = Dosage.serializer()

    public val dosageSer: KSerializer<List<Dosage>> = ListSerializer(Hoisted.dosageSerInner)

    public val adherenceSer: KSerializer<MedicationStatement.Adherence> =
      MedicationStatement.Adherence.serializer()
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
