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
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): FamilyMemberHistory.Participant {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          function =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.functionSer, null)
        4 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    return FamilyMemberHistory.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor =
        actor
          ?: throw SerializationException(
            "Missing required property 'actor' on FamilyMemberHistory.Participant"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: FamilyMemberHistory.Participant,
  ) {
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
    (value.function)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.functionSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorSer, value.actor)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Condition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): FamilyMemberHistory.Condition {
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
          outcome = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> contributedToDeath = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _contributedToDeath =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributedToDeathSer,
              null,
            )
        7 ->
          onsetAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.onsetAgeSer, null)
        8 ->
          onsetRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.onsetRangeSer, null)
        9 ->
          onsetPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.onsetPeriodSer, null)
        10 -> onsetString = decoder.decodeStringElement(descriptor, i)
        11 ->
          _onsetString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributedToDeathSer,
              null,
            )
        12 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Condition: " + i)
      }
    }
    return FamilyMemberHistory.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on FamilyMemberHistory.Condition"
          ),
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: FamilyMemberHistory.Condition) {
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
    (value.outcome)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
    ((value.contributedToDeath?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.contributedToDeath?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.contributedToDeathSer, it)
    }
    when (val choice = value.onset) {
      null -> {}
      is FamilyMemberHistory.Condition.Onset.Age -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.onsetAgeSer, choice.value)
      }
      is FamilyMemberHistory.Condition.Onset.Range -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.onsetRangeSer, choice.value)
      }
      is FamilyMemberHistory.Condition.Onset.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.onsetPeriodSer, choice.value)
      }
      is FamilyMemberHistory.Condition.Onset.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.contributedToDeathSer, it)
        }
      }
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.noteSer, value.note)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Procedure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): FamilyMemberHistory.Procedure {
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
          outcome = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> contributedToDeath = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _contributedToDeath =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributedToDeathSer,
              null,
            )
        7 ->
          performedAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performedAgeSer, null)
        8 ->
          performedRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.performedRangeSer,
              null,
            )
        9 ->
          performedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.performedPeriodSer,
              null,
            )
        10 -> performedString = decoder.decodeStringElement(descriptor, i)
        11 ->
          _performedString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributedToDeathSer,
              null,
            )
        12 -> performedDateTime = decoder.decodeStringElement(descriptor, i)
        13 ->
          _performedDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributedToDeathSer,
              null,
            )
        14 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
      }
    }
    return FamilyMemberHistory.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on FamilyMemberHistory.Procedure"
          ),
      outcome = outcome,
      contributedToDeath = R5Boolean.of(contributedToDeath, _contributedToDeath),
      performed =
        FamilyMemberHistory.Procedure.Performed.from(
          performedAge,
          performedRange,
          performedPeriod,
          R5String.of(performedString, _performedString),
          DateTime.of(performedDateTime?.let { FhirDateTime.fromString(it) }, _performedDateTime),
        ),
      note = note ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: FamilyMemberHistory.Procedure) {
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
    (value.outcome)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
    ((value.contributedToDeath?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.contributedToDeath?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.contributedToDeathSer, it)
    }
    when (val choice = value.performed) {
      null -> {}
      is FamilyMemberHistory.Procedure.Performed.Age -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.performedAgeSer, choice.value)
      }
      is FamilyMemberHistory.Procedure.Performed.Range -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.performedRangeSer, choice.value)
      }
      is FamilyMemberHistory.Procedure.Performed.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.performedPeriodSer, choice.value)
      }
      is FamilyMemberHistory.Procedure.Performed.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.contributedToDeathSer, it)
        }
      }
      is FamilyMemberHistory.Procedure.Performed.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.contributedToDeathSer, it)
        }
      }
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.noteSer, value.note)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "FamilyMemberHistory")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): FamilyMemberHistory {
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
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dataAbsentReasonSer,
              null,
            )
        18 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        19 -> date = decoder.decodeStringElement(descriptor, i)
        20 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        22 -> name = decoder.decodeStringElement(descriptor, i)
        23 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dataAbsentReasonSer,
              null,
            )
        25 ->
          sex =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dataAbsentReasonSer,
              null,
            )
        26 ->
          bornPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bornPeriodSer, null)
        27 -> bornDate = decoder.decodeStringElement(descriptor, i)
        28 ->
          _bornDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> bornString = decoder.decodeStringElement(descriptor, i)
        30 ->
          _bornString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 ->
          ageAge = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageAgeSer, null)
        32 ->
          ageRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageRangeSer, null)
        33 -> ageString = decoder.decodeStringElement(descriptor, i)
        34 ->
          _ageString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> estimatedAge = decoder.decodeBooleanElement(descriptor, i)
        36 ->
          _estimatedAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> deceasedBoolean = decoder.decodeBooleanElement(descriptor, i)
        38 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 ->
          deceasedAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageAgeSer, null)
        40 ->
          deceasedRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageRangeSer, null)
        41 -> deceasedDate = decoder.decodeStringElement(descriptor, i)
        42 ->
          _deceasedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> deceasedString = decoder.decodeStringElement(descriptor, i)
        44 ->
          _deceasedString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        46 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        47 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        48 ->
          procedure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.procedureSer, null)
        else -> throw SerializationException("Unexpected index decoding FamilyMemberHistory: " + i)
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
        ) { index ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(index)?.let { it },
            _instantiatesCanonical?.getOrNull(index),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(
            instantiatesUri?.getOrNull(index)?.let { it },
            _instantiatesUri?.getOrNull(index),
          )!!
        }),
      status =
        Enumeration.of(
          FamilyMemberHistory.FamilyHistoryStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on FamilyMemberHistory"
              )
          ),
          _status,
        ),
      dataAbsentReason = dataAbsentReason,
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on FamilyMemberHistory"
          ),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      participant = participant ?: listOf(),
      name = R5String.of(name, _name),
      relationship =
        relationship
          ?: throw SerializationException(
            "Missing required property 'relationship' on FamilyMemberHistory"
          ),
      sex = sex,
      born =
        FamilyMemberHistory.Born.from(
          bornPeriod,
          Date.of(bornDate?.let { FhirDate.fromString(it) }, _bornDate),
          R5String.of(bornString, _bornString),
        ),
      age = FamilyMemberHistory.Age.from(ageAge, ageRange, R5String.of(ageString, _ageString)),
      estimatedAge = R5Boolean.of(estimatedAge, _estimatedAge),
      deceased =
        FamilyMemberHistory.Deceased.from(
          R5Boolean.of(deceasedBoolean, _deceasedBoolean),
          deceasedAge,
          deceasedRange,
          Date.of(deceasedDate?.let { FhirDate.fromString(it) }, _deceasedDate),
          R5String.of(deceasedString, _deceasedString),
        ),
      reason = reason ?: listOf(),
      note = note ?: listOf(),
      condition = condition ?: listOf(),
      procedure = procedure ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: FamilyMemberHistory,
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
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.dataAbsentReasonSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      Hoisted.patientSer,
      value.patient,
    )
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.participantSer,
        value.participant,
      )
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      24 + descriptorOffset,
      Hoisted.dataAbsentReasonSer,
      value.relationship,
    )
    (value.sex)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.dataAbsentReasonSer,
        it,
      )
    }
    when (val choice = value.born) {
      null -> {}
      is FamilyMemberHistory.Born.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          Hoisted.bornPeriodSer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Born.Date -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            28 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is FamilyMemberHistory.Born.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            30 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    when (val choice = value.age) {
      null -> {}
      is FamilyMemberHistory.Age.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          Hoisted.ageAgeSer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Age.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          32 + descriptorOffset,
          Hoisted.ageRangeSer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Age.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            34 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.estimatedAge?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.estimatedAge?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.deceased) {
      null -> {}
      is FamilyMemberHistory.Deceased.Boolean -> {
        ((choice.value.value))?.let {
          encoder.encodeBooleanElement(descriptor, 37 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            38 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is FamilyMemberHistory.Deceased.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          39 + descriptorOffset,
          Hoisted.ageAgeSer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Deceased.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          40 + descriptorOffset,
          Hoisted.ageRangeSer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Deceased.Date -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            42 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is FamilyMemberHistory.Deceased.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            44 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.reasonSer,
        value.reason,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.conditionSer,
        value.condition,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.procedureSer,
        value.procedure,
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
    encoder.encodeStructure(descriptor) {
      FamilyMemberHistorySerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory =
    decoder.decodeStructure(descriptor) {
      FamilyMemberHistorySerializer.deserializeInternal(this, descriptor, 0)
    }
}
