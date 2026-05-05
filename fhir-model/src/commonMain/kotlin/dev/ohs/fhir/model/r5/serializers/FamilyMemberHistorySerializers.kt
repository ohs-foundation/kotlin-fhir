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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Age
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FamilyMemberHistory
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object FamilyMemberHistoryParticipantSerializer :
  KSerializer<FamilyMemberHistory.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): FamilyMemberHistory.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          function = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return FamilyMemberHistory.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: FamilyMemberHistory.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.functionSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> outcome = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> contributedToDeath = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _contributedToDeath =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.contributedToDeathSer,
              null,
            )
        7 ->
          onsetAge = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.onsetAgeSer, null)
        8 ->
          onsetRange =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.onsetRangeSer, null)
        9 ->
          onsetPeriod =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.onsetPeriodSer, null)
        10 -> onsetString = decoder.decodeStringElement(__desc, 10)
        11 ->
          _onsetString =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.contributedToDeathSer,
              null,
            )
        12 -> note = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.noteSer, null)
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
      contributedToDeath = R5Boolean.of(contributedToDeath, _contributedToDeath),
      onset =
        FamilyMemberHistory.Condition.Onset.from(
          onsetAge,
          onsetRange,
          onsetPeriod,
          R5String.of(onsetString, _onsetString),
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

internal object FamilyMemberHistoryProcedureSerializer :
  KSerializer<FamilyMemberHistory.Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
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
      element("performedAge", Age.serializer().descriptor, isOptional = true)
      element("performedRange", Range.serializer().descriptor, isOptional = true)
      element("performedPeriod", Period.serializer().descriptor, isOptional = true)
      element("performedString", KotlinString.serializer().descriptor, isOptional = true)
      element("_performedString", Element.serializer().descriptor, isOptional = true)
      element("performedDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_performedDateTime", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory.Procedure =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Procedure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): FamilyMemberHistory.Procedure {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var outcome: CodeableConcept? = null
    var contributedToDeath: KotlinBoolean? = null
    var _contributedToDeath: Element? = null
    var performedAge: Age? = null
    var performedRange: Range? = null
    var performedPeriod: Period? = null
    var performedString: KotlinString? = null
    var _performedString: Element? = null
    var performedDateTime: KotlinString? = null
    var _performedDateTime: Element? = null
    var note: List<Annotation>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> outcome = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> contributedToDeath = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _contributedToDeath =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.contributedToDeathSer,
              null,
            )
        7 ->
          performedAge =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.performedAgeSer, null)
        8 ->
          performedRange =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.performedRangeSer, null)
        9 ->
          performedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.performedPeriodSer, null)
        10 -> performedString = decoder.decodeStringElement(__desc, 10)
        11 ->
          _performedString =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.contributedToDeathSer,
              null,
            )
        12 -> performedDateTime = decoder.decodeStringElement(__desc, 12)
        13 ->
          _performedDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.contributedToDeathSer,
              null,
            )
        14 -> note = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + __i)
      }
    }
    return FamilyMemberHistory.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      outcome = outcome,
      contributedToDeath = R5Boolean.of(contributedToDeath, _contributedToDeath),
      performed =
        FamilyMemberHistory.Procedure.Performed.from(
          performedAge,
          performedRange,
          performedPeriod,
          R5String.of(performedString, _performedString),
          DateTime.of(FhirDateTime.fromString(performedDateTime), _performedDateTime),
        ),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: FamilyMemberHistory.Procedure) {
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
    when (val __d = value.performed) {
      null -> {}
      is FamilyMemberHistory.Procedure.Performed.Age -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.performedAgeSer, __d.value)
      }
      is FamilyMemberHistory.Procedure.Performed.Range -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.performedRangeSer, __d.value)
      }
      is FamilyMemberHistory.Procedure.Performed.Period -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.performedPeriodSer, __d.value)
      }
      is FamilyMemberHistory.Procedure.Performed.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.contributedToDeathSer, it)
        }
      }
      is FamilyMemberHistory.Procedure.Performed.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.contributedToDeathSer, it)
        }
      }
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val contributedToDeathSer: KSerializer<Element> = Element.serializer()

    public val performedAgeSer: KSerializer<Age> = Age.serializer()

    public val performedRangeSer: KSerializer<Range> = Range.serializer()

    public val performedPeriodSer: KSerializer<Period> = Period.serializer()

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
    b.element(
      "participant",
      listSerialDescriptor(
        lazyDescriptor { FamilyMemberHistory.Participant.serializer().descriptor }
      ),
      isOptional = true,
    )
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
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
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
    b.element(
      "procedure",
      listSerialDescriptor(
        lazyDescriptor { FamilyMemberHistory.Procedure.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "FamilyMemberHistory")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): FamilyMemberHistory {
    val __desc = descriptor
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
    var participant: List<FamilyMemberHistory.Participant>? = null
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
    var reason: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var condition: List<FamilyMemberHistory.Condition>? = null
    var procedure: List<FamilyMemberHistory.Procedure>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        13 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        14 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        15 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        16 -> status = decoder.decodeStringElement(__desc, 16)
        17 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.dataAbsentReasonSer, null)
        19 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.patientSer, null)
        20 -> date = decoder.decodeStringElement(__desc, 20)
        21 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.participantSer, null)
        23 -> name = decoder.decodeStringElement(__desc, 23)
        24 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.dataAbsentReasonSer, null)
        26 ->
          sex =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.dataAbsentReasonSer, null)
        27 ->
          bornPeriod =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.bornPeriodSer, null)
        28 -> bornDate = decoder.decodeStringElement(__desc, 28)
        29 ->
          _bornDate =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> bornString = decoder.decodeStringElement(__desc, 30)
        31 ->
          _bornString =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          ageAge = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.ageAgeSer, null)
        33 ->
          ageRange =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.ageRangeSer, null)
        34 -> ageString = decoder.decodeStringElement(__desc, 34)
        35 ->
          _ageString =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> estimatedAge = decoder.decodeBooleanElement(__desc, 36)
        37 ->
          _estimatedAge =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> deceasedBoolean = decoder.decodeBooleanElement(__desc, 38)
        39 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 ->
          deceasedAge =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.ageAgeSer, null)
        41 ->
          deceasedRange =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.ageRangeSer, null)
        42 -> deceasedDate = decoder.decodeStringElement(__desc, 42)
        43 ->
          _deceasedDate =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 -> deceasedString = decoder.decodeStringElement(__desc, 44)
        45 ->
          _deceasedString =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.reasonSer, null)
        47 -> note = decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.noteSer, null)
        48 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.conditionSer, null)
        49 ->
          procedure =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.procedureSer, null)
        CompositeDecoder.DECODE_DONE -> break
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
      participant = participant ?: listOf(),
      name = R5String.of(name, _name),
      relationship = relationship!!,
      sex = sex,
      born =
        FamilyMemberHistory.Born.from(
          bornPeriod,
          Date.of(FhirDate.fromString(bornDate), _bornDate),
          R5String.of(bornString, _bornString),
        ),
      age = FamilyMemberHistory.Age.from(ageAge, ageRange, R5String.of(ageString, _ageString)),
      estimatedAge = R5Boolean.of(estimatedAge, _estimatedAge),
      deceased =
        FamilyMemberHistory.Deceased.from(
          R5Boolean.of(deceasedBoolean, _deceasedBoolean),
          deceasedAge,
          deceasedRange,
          Date.of(FhirDate.fromString(deceasedDate), _deceasedDate),
          R5String.of(deceasedString, _deceasedString),
        ),
      reason = reason ?: listOf(),
      note = note ?: listOf(),
      condition = condition ?: listOf(),
      procedure = procedure ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: FamilyMemberHistory) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.instantiatesCanonicalSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.dataAbsentReasonSer, it)
    }
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.patientSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.participantSer, value.participant)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.dataAbsentReasonSer, it)
    }
    (value.sex)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.dataAbsentReasonSer, it)
    }
    when (val __d = value.born) {
      null -> {}
      is FamilyMemberHistory.Born.Period -> {
        encoder.encodeSerializableElement(__desc, 27, Hoisted.bornPeriodSer, __d.value)
      }
      is FamilyMemberHistory.Born.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
        }
      }
      is FamilyMemberHistory.Born.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
        }
      }
    }
    when (val __d = value.age) {
      null -> {}
      is FamilyMemberHistory.Age.Age -> {
        encoder.encodeSerializableElement(__desc, 32, Hoisted.ageAgeSer, __d.value)
      }
      is FamilyMemberHistory.Age.Range -> {
        encoder.encodeSerializableElement(__desc, 33, Hoisted.ageRangeSer, __d.value)
      }
      is FamilyMemberHistory.Age.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.estimatedAge?.value))?.let { encoder.encodeBooleanElement(__desc, 36, it) }
    (value.estimatedAge?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.deceased) {
      null -> {}
      is FamilyMemberHistory.Deceased.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 38, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
        }
      }
      is FamilyMemberHistory.Deceased.Age -> {
        encoder.encodeSerializableElement(__desc, 40, Hoisted.ageAgeSer, __d.value)
      }
      is FamilyMemberHistory.Deceased.Range -> {
        encoder.encodeSerializableElement(__desc, 41, Hoisted.ageRangeSer, __d.value)
      }
      is FamilyMemberHistory.Deceased.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 42, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
        }
      }
      is FamilyMemberHistory.Deceased.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 44, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.reasonSer, value.reason)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.noteSer, value.note)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.conditionSer, value.condition)
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.procedureSer, value.procedure)
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

    public val participantSerInner: KSerializer<FamilyMemberHistory.Participant> =
      FamilyMemberHistory.Participant.serializer()

    public val participantSer: KSerializer<List<FamilyMemberHistory.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val bornPeriodSer: KSerializer<Period> = Period.serializer()

    public val ageAgeSer: KSerializer<Age> = Age.serializer()

    public val ageRangeSer: KSerializer<Range> = Range.serializer()

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val conditionSerInner: KSerializer<FamilyMemberHistory.Condition> =
      FamilyMemberHistory.Condition.serializer()

    public val conditionSer: KSerializer<List<FamilyMemberHistory.Condition>> =
      ListSerializer(Hoisted.conditionSerInner)

    public val procedureSerInner: KSerializer<FamilyMemberHistory.Procedure> =
      FamilyMemberHistory.Procedure.serializer()

    public val procedureSer: KSerializer<List<FamilyMemberHistory.Procedure>> =
      ListSerializer(Hoisted.procedureSerInner)
  }
}

internal object FamilyMemberHistoryPolymorphicSerializer : KSerializer<FamilyMemberHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("FamilyMemberHistory") {
      FamilyMemberHistorySerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory) {
    encoder.encodeStructure(descriptor) { FamilyMemberHistorySerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory =
    decoder.decodeStructure(descriptor) { FamilyMemberHistorySerializer.deserializeJson(this) }
}
