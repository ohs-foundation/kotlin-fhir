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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Age
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FamilyMemberHistory
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object FamilyMemberHistoryConditionSerializer :
  KSerializer<FamilyMemberHistory.Condition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Condition") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
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
      element("outcome", CodeableConcept.serializer().descriptor, isOptional = true)
      element("contributedToDeath", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_contributedToDeath", Element.serializer().descriptor, isOptional = true)
      element("onsetAge", Age.serializer().descriptor, isOptional = true)
      element("onsetRange", Range.serializer().descriptor, isOptional = true)
      element("onsetPeriod", Period.serializer().descriptor, isOptional = true)
      element("onsetString", KotlinString.serializer().descriptor, isOptional = true)
      element("_onsetString", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory.Condition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Condition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): FamilyMemberHistory.Condition {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var outcome: CodeableConcept? = null
    var contributedToDeath: KotlinBoolean? = null
    var _contributedToDeath: Element? = null
    var onsetAge: Age? = null
    var onsetRange: Range? = null
    var onsetPeriod: Period? = null
    var onsetString: KotlinString? = null
    var _onsetString: Element? = null
    var note: List<Annotation>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 -> outcome = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> contributedToDeath = decoder.decodeBooleanElement(__desc, __i)
        6 ->
          _contributedToDeath =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contributedToDeathSer,
              null,
            )
        7 ->
          onsetAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.onsetAgeSer, null)
        8 ->
          onsetRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.onsetRangeSer, null)
        9 ->
          onsetPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.onsetPeriodSer, null)
        10 -> onsetString = decoder.decodeStringElement(__desc, __i)
        11 ->
          _onsetString =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contributedToDeathSer,
              null,
            )
        12 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Condition: " + __i)
      }
    }
    return FamilyMemberHistory.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      outcome = outcome,
      contributedToDeath = R4bBoolean.of(contributedToDeath, _contributedToDeath),
      onset =
        FamilyMemberHistory.Condition.Onset.from(
          onsetAge,
          onsetRange,
          onsetPeriod,
          R4bString.of(onsetString, _onsetString),
        ),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: FamilyMemberHistory.Condition) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.outcome)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it) }
    ((value.contributedToDeath?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.contributedToDeath?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.contributedToDeathSer, it)
    }
    when (val __d = value.onset) {
      null -> {}
      is FamilyMemberHistory.Condition.Onset.Age -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.onsetAgeSer, __d.value)
      }
      is FamilyMemberHistory.Condition.Onset.Range -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.onsetRangeSer, __d.value)
      }
      is FamilyMemberHistory.Condition.Onset.Period -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.onsetPeriodSer, __d.value)
      }
      is FamilyMemberHistory.Condition.Onset.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.contributedToDeathSer, it)
        }
      }
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val contributedToDeathSer: KSerializer<Element> = Element.serializer()

    public val onsetAgeSer: KSerializer<Age> = Age.serializer()

    public val onsetRangeSer: KSerializer<Range> = Range.serializer()

    public val onsetPeriodSer: KSerializer<Period> = Period.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object FamilyMemberHistorySerializer : KSerializer<FamilyMemberHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("FamilyMemberHistory") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
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
    b.element(
      "instantiatesCanonical",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesUri",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("dataAbsentReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("relationship", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("sex", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("bornPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("bornDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_bornDate", Element.serializer().descriptor, isOptional = true)
    b.element("bornString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_bornString", Element.serializer().descriptor, isOptional = true)
    b.element("ageAge", Age.serializer().descriptor, isOptional = true)
    b.element("ageRange", Range.serializer().descriptor, isOptional = true)
    b.element("ageString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_ageString", Element.serializer().descriptor, isOptional = true)
    b.element("estimatedAge", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_estimatedAge", Element.serializer().descriptor, isOptional = true)
    b.element("deceasedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_deceasedBoolean", Element.serializer().descriptor, isOptional = true)
    b.element("deceasedAge", Age.serializer().descriptor, isOptional = true)
    b.element("deceasedRange", Range.serializer().descriptor, isOptional = true)
    b.element("deceasedDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_deceasedDate", Element.serializer().descriptor, isOptional = true)
    b.element("deceasedString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_deceasedString", Element.serializer().descriptor, isOptional = true)
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
    b.element(
      "condition",
      listSerialDescriptor(
        lazyDescriptor { FamilyMemberHistory.Condition.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "FamilyMemberHistory")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): FamilyMemberHistory {
    val __desc = desc
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var dataAbsentReason: CodeableConcept? = null
    var patient: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var relationship: CodeableConcept? = null
    var sex: CodeableConcept? = null
    var bornPeriod: Period? = null
    var bornDate: KotlinString? = null
    var _bornDate: Element? = null
    var bornString: KotlinString? = null
    var _bornString: Element? = null
    var ageAge: Age? = null
    var ageRange: Range? = null
    var ageString: KotlinString? = null
    var _ageString: Element? = null
    var estimatedAge: KotlinBoolean? = null
    var _estimatedAge: Element? = null
    var deceasedBoolean: KotlinBoolean? = null
    var _deceasedBoolean: Element? = null
    var deceasedAge: Age? = null
    var deceasedRange: Range? = null
    var deceasedDate: KotlinString? = null
    var _deceasedDate: Element? = null
    var deceasedString: KotlinString? = null
    var _deceasedString: Element? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var condition: List<FamilyMemberHistory.Condition>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        15 -> status = decoder.decodeStringElement(__desc, __i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.dataAbsentReasonSer,
              null,
            )
        18 ->
          patient = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        19 -> date = decoder.decodeStringElement(__desc, __i)
        20 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> name = decoder.decodeStringElement(__desc, __i)
        22 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.dataAbsentReasonSer,
              null,
            )
        24 ->
          sex =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.dataAbsentReasonSer,
              null,
            )
        25 ->
          bornPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.bornPeriodSer, null)
        26 -> bornDate = decoder.decodeStringElement(__desc, __i)
        27 ->
          _bornDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 -> bornString = decoder.decodeStringElement(__desc, __i)
        29 ->
          _bornString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 ->
          ageAge = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ageAgeSer, null)
        31 ->
          ageRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ageRangeSer, null)
        32 -> ageString = decoder.decodeStringElement(__desc, __i)
        33 ->
          _ageString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        34 -> estimatedAge = decoder.decodeBooleanElement(__desc, __i)
        35 ->
          _estimatedAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        36 -> deceasedBoolean = decoder.decodeBooleanElement(__desc, __i)
        37 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        38 ->
          deceasedAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ageAgeSer, null)
        39 ->
          deceasedRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ageRangeSer, null)
        40 -> deceasedDate = decoder.decodeStringElement(__desc, __i)
        41 ->
          _deceasedDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        42 -> deceasedString = decoder.decodeStringElement(__desc, __i)
        43 ->
          _deceasedString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        44 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonCodeSer, null)
        45 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonReferenceSer, null)
        46 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        47 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conditionSer, null)
        else ->
          throw SerializationException("Unexpected index decoding FamilyMemberHistory: " + __i)
      }
    }
    return FamilyMemberHistory(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { __i ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(__i)?.let { it },
            _instantiatesCanonical?.getOrNull(__i),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          __i ->
          Uri.of(instantiatesUri?.getOrNull(__i)?.let { it }, _instantiatesUri?.getOrNull(__i))!!
        }),
      status = Enumeration.of(FamilyMemberHistory.FamilyHistoryStatus.fromCode(status!!), _status),
      dataAbsentReason = dataAbsentReason,
      patient = patient!!,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      name = R4bString.of(name, _name),
      relationship = relationship!!,
      sex = sex,
      born =
        FamilyMemberHistory.Born.from(
          bornPeriod,
          Date.of(FhirDate.fromString(bornDate), _bornDate),
          R4bString.of(bornString, _bornString),
        ),
      age = FamilyMemberHistory.Age.from(ageAge, ageRange, R4bString.of(ageString, _ageString)),
      estimatedAge = R4bBoolean.of(estimatedAge, _estimatedAge),
      deceased =
        FamilyMemberHistory.Deceased.from(
          R4bBoolean.of(deceasedBoolean, _deceasedBoolean),
          deceasedAge,
          deceasedRange,
          Date.of(FhirDate.fromString(deceasedDate), _deceasedDate),
          R4bString.of(deceasedString, _deceasedString),
        ),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      condition = condition ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: FamilyMemberHistory,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.dataAbsentReasonSer, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.patientSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.dataAbsentReasonSer, it)
    }
    (value.sex)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.dataAbsentReasonSer, it)
    }
    when (val __d = value.born) {
      null -> {}
      is FamilyMemberHistory.Born.Period -> {
        encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.bornPeriodSer, __d.value)
      }
      is FamilyMemberHistory.Born.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is FamilyMemberHistory.Born.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    when (val __d = value.age) {
      null -> {}
      is FamilyMemberHistory.Age.Age -> {
        encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.ageAgeSer, __d.value)
      }
      is FamilyMemberHistory.Age.Range -> {
        encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.ageRangeSer, __d.value)
      }
      is FamilyMemberHistory.Age.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 32 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.estimatedAge?.value))?.let { encoder.encodeBooleanElement(__desc, 34 + __off, it) }
    (value.estimatedAge?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.deceased) {
      null -> {}
      is FamilyMemberHistory.Deceased.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 36 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is FamilyMemberHistory.Deceased.Age -> {
        encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.ageAgeSer, __d.value)
      }
      is FamilyMemberHistory.Deceased.Range -> {
        encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.ageRangeSer, __d.value)
      }
      is FamilyMemberHistory.Deceased.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 40 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is FamilyMemberHistory.Deceased.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 42 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.reasonCodeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        45 + __off,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.noteSer, value.note)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.conditionSer, value.condition)
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

    public val instantiatesCanonicalSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val dataAbsentReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val bornPeriodSer: KSerializer<Period> = Period.serializer()

    public val ageAgeSer: KSerializer<Age> = Age.serializer()

    public val ageRangeSer: KSerializer<Range> = Range.serializer()

    public val reasonCodeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.dataAbsentReasonSer)

    public val reasonReferenceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val conditionSerInner: KSerializer<FamilyMemberHistory.Condition> =
      FamilyMemberHistory.Condition.serializer()

    public val conditionSer: KSerializer<List<FamilyMemberHistory.Condition>> =
      ListSerializer(Hoisted.conditionSerInner)
  }
}

internal object FamilyMemberHistoryPolymorphicSerializer : KSerializer<FamilyMemberHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("FamilyMemberHistory") {
      FamilyMemberHistorySerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory) {
    encoder.encodeStructure(descriptor) {
      FamilyMemberHistorySerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory =
    decoder.decodeStructure(descriptor) {
      FamilyMemberHistorySerializer.deserializeJson(this, descriptor, 0)
    }
}
