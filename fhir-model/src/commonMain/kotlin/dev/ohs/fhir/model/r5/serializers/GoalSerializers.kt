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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.Goal
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object GoalTargetSerializer : KSerializer<Goal.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
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
      element("measure", CodeableConcept.serializer().descriptor, isOptional = true)
      element("detailQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("detailRange", Range.serializer().descriptor, isOptional = true)
      element("detailCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("detailString", KotlinString.serializer().descriptor, isOptional = true)
      element("_detailString", Element.serializer().descriptor, isOptional = true)
      element("detailBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_detailBoolean", Element.serializer().descriptor, isOptional = true)
      element("detailInteger", Int.serializer().descriptor, isOptional = true)
      element("_detailInteger", Element.serializer().descriptor, isOptional = true)
      element("detailRatio", Ratio.serializer().descriptor, isOptional = true)
      element("dueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_dueDate", Element.serializer().descriptor, isOptional = true)
      element("dueDuration", Duration.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Goal.Target =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Goal.Target) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Goal.Target {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var measure: CodeableConcept? = null
    var detailQuantity: Quantity? = null
    var detailRange: Range? = null
    var detailCodeableConcept: CodeableConcept? = null
    var detailString: KotlinString? = null
    var _detailString: Element? = null
    var detailBoolean: KotlinBoolean? = null
    var _detailBoolean: Element? = null
    var detailInteger: Int? = null
    var _detailInteger: Element? = null
    var detailRatio: Ratio? = null
    var dueDate: KotlinString? = null
    var _dueDate: Element? = null
    var dueDuration: Duration? = null
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
          measure = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.measureSer, null)
        4 ->
          detailQuantity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.detailQuantitySer, null)
        5 ->
          detailRange =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.detailRangeSer, null)
        6 ->
          detailCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.measureSer, null)
        7 -> detailString = decoder.decodeStringElement(__desc, 7)
        8 ->
          _detailString =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.detailStringSer, null)
        9 -> detailBoolean = decoder.decodeBooleanElement(__desc, 9)
        10 ->
          _detailBoolean =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.detailStringSer, null)
        11 -> detailInteger = decoder.decodeIntElement(__desc, 11)
        12 ->
          _detailInteger =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.detailStringSer, null)
        13 ->
          detailRatio =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.detailRatioSer, null)
        14 -> dueDate = decoder.decodeStringElement(__desc, 14)
        15 ->
          _dueDate =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.detailStringSer, null)
        16 ->
          dueDuration =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.dueDurationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + __i)
      }
    }
    return Goal.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      measure = measure,
      detail =
        Goal.Target.Detail.from(
          detailQuantity,
          detailRange,
          detailCodeableConcept,
          R5String.of(detailString, _detailString),
          R5Boolean.of(detailBoolean, _detailBoolean),
          Integer.of(detailInteger, _detailInteger),
          detailRatio,
        ),
      due = Goal.Target.Due.from(Date.of(FhirDate.fromString(dueDate), _dueDate), dueDuration),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Goal.Target) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.measure)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.measureSer, it) }
    when (val __d = value.detail) {
      null -> {}
      is Goal.Target.Detail.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.detailQuantitySer, __d.value)
      }
      is Goal.Target.Detail.Range -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.detailRangeSer, __d.value)
      }
      is Goal.Target.Detail.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.measureSer, __d.value)
      }
      is Goal.Target.Detail.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.detailStringSer, it)
        }
      }
      is Goal.Target.Detail.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.detailStringSer, it)
        }
      }
      is Goal.Target.Detail.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.detailStringSer, it)
        }
      }
      is Goal.Target.Detail.Ratio -> {
        encoder.encodeSerializableElement(__desc, 13, Hoisted.detailRatioSer, __d.value)
      }
    }
    when (val __d = value.due) {
      null -> {}
      is Goal.Target.Due.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.detailStringSer, it)
        }
      }
      is Goal.Target.Due.Duration -> {
        encoder.encodeSerializableElement(__desc, 16, Hoisted.dueDurationSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val measureSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val detailQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val detailRangeSer: KSerializer<Range> = Range.serializer()

    public val detailStringSer: KSerializer<Element> = Element.serializer()

    public val detailRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val dueDurationSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object GoalSerializer : KSerializer<Goal> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Goal") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("lifecycleStatus", KotlinString.serializer().descriptor, isOptional = true)
      element("_lifecycleStatus", Element.serializer().descriptor, isOptional = true)
      element("achievementStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("continuous", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_continuous", Element.serializer().descriptor, isOptional = true)
      element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("startDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_startDate", Element.serializer().descriptor, isOptional = true)
      element("startCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "target",
        listSerialDescriptor(lazyDescriptor { Goal.Target.serializer().descriptor }),
        isOptional = true,
      )
      element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_statusDate", Element.serializer().descriptor, isOptional = true)
      element("statusReason", KotlinString.serializer().descriptor, isOptional = true)
      element("_statusReason", Element.serializer().descriptor, isOptional = true)
      element("source", Reference.serializer().descriptor, isOptional = true)
      element(
        "addresses",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "outcome",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Goal =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Goal) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Goal {
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
    var lifecycleStatus: KotlinString? = null
    var _lifecycleStatus: Element? = null
    var achievementStatus: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var continuous: KotlinBoolean? = null
    var _continuous: Element? = null
    var priority: CodeableConcept? = null
    var description: CodeableConcept? = null
    var subject: Reference? = null
    var startDate: KotlinString? = null
    var _startDate: Element? = null
    var startCodeableConcept: CodeableConcept? = null
    var target: List<Goal.Target>? = null
    var statusDate: KotlinString? = null
    var _statusDate: Element? = null
    var statusReason: KotlinString? = null
    var _statusReason: Element? = null
    var source: Reference? = null
    var addresses: List<Reference>? = null
    var note: List<Annotation>? = null
    var outcome: List<CodeableReference>? = null
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
        12 -> lifecycleStatus = decoder.decodeStringElement(__desc, 12)
        13 ->
          _lifecycleStatus =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          achievementStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.achievementStatusSer,
              null,
            )
        15 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 -> continuous = decoder.decodeBooleanElement(__desc, 16)
        17 ->
          _continuous =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          priority =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.achievementStatusSer,
              null,
            )
        19 ->
          description =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.achievementStatusSer,
              null,
            )
        20 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.subjectSer, null)
        21 -> startDate = decoder.decodeStringElement(__desc, 21)
        22 ->
          _startDate =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          startCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              23,
              Hoisted.achievementStatusSer,
              null,
            )
        24 ->
          target = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.targetSer, null)
        25 -> statusDate = decoder.decodeStringElement(__desc, 25)
        26 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> statusReason = decoder.decodeStringElement(__desc, 27)
        28 ->
          _statusReason =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 ->
          source = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.subjectSer, null)
        30 ->
          addresses =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.addressesSer, null)
        31 -> note = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.noteSer, null)
        32 ->
          outcome = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.outcomeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Goal: " + __i)
      }
    }
    return Goal(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      lifecycleStatus =
        Enumeration.of(Goal.GoalLifecycleStatus.fromCode(lifecycleStatus!!), _lifecycleStatus),
      achievementStatus = achievementStatus,
      category = category ?: listOf(),
      continuous = R5Boolean.of(continuous, _continuous),
      priority = priority,
      description = description!!,
      subject = subject!!,
      start =
        Goal.Start.from(Date.of(FhirDate.fromString(startDate), _startDate), startCodeableConcept),
      target = target ?: listOf(),
      statusDate = Date.of(FhirDate.fromString(statusDate), _statusDate),
      statusReason = R5String.of(statusReason, _statusReason),
      source = source,
      addresses = addresses ?: listOf(),
      note = note ?: listOf(),
      outcome = outcome ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Goal) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Goal")
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
    ((value.lifecycleStatus.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.lifecycleStatus.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.achievementStatus)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.achievementStatusSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, value.category)
    ((value.continuous?.value))?.let { encoder.encodeBooleanElement(__desc, 16, it) }
    (value.continuous?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.priority)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.achievementStatusSer, it)
    }
    (value.description)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.achievementStatusSer, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.subjectSer, it) }
    when (val __d = value.start) {
      null -> {}
      is Goal.Start.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
        }
      }
      is Goal.Start.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 23, Hoisted.achievementStatusSer, __d.value)
      }
    }
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.targetSer, value.target)
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.statusReason?.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.statusReason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    (value.source)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.subjectSer, it) }
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.addressesSer, value.addresses)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.noteSer, value.note)
    if (value.outcome.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.outcomeSer, value.outcome)
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

    public val achievementStatusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.achievementStatusSer)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val targetSerInner: KSerializer<Goal.Target> = Goal.Target.serializer()

    public val targetSer: KSerializer<List<Goal.Target>> = ListSerializer(Hoisted.targetSerInner)

    public val addressesSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val outcomeSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val outcomeSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.outcomeSerInner)
  }
}
