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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.Goal
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Ratio
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
          R4bString.of(detailString, _detailString),
          R4bBoolean.of(detailBoolean, _detailBoolean),
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
    b.element("lifecycleStatus", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lifecycleStatus", Element.serializer().descriptor, isOptional = true)
    b.element("achievementStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("description", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("startDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_startDate", Element.serializer().descriptor, isOptional = true)
    b.element("startCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "target",
      listSerialDescriptor(lazyDescriptor { Goal.Target.serializer().descriptor }),
      isOptional = true,
    )
    b.element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_statusDate", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_statusReason", Element.serializer().descriptor, isOptional = true)
    b.element("expressedBy", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "addresses",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "outcomeCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "outcomeReference",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Goal =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Goal) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Goal")
      serializeJson(this, value)
    }
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
    var expressedBy: Reference? = null
    var addresses: List<Reference>? = null
    var note: List<Annotation>? = null
    var outcomeCode: List<CodeableConcept>? = null
    var outcomeReference: List<Reference>? = null
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
        16 ->
          priority =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.achievementStatusSer,
              null,
            )
        17 ->
          description =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.achievementStatusSer,
              null,
            )
        18 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 -> startDate = decoder.decodeStringElement(__desc, 19)
        20 ->
          _startDate =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          startCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.achievementStatusSer,
              null,
            )
        22 ->
          target = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.targetSer, null)
        23 -> statusDate = decoder.decodeStringElement(__desc, 23)
        24 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> statusReason = decoder.decodeStringElement(__desc, 25)
        26 ->
          _statusReason =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          expressedBy =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.subjectSer, null)
        28 ->
          addresses =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.addressesSer, null)
        29 -> note = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.noteSer, null)
        30 ->
          outcomeCode =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.categorySer, null)
        31 ->
          outcomeReference =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.addressesSer, null)
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
      priority = priority,
      description = description!!,
      subject = subject!!,
      start =
        Goal.Start.from(Date.of(FhirDate.fromString(startDate), _startDate), startCodeableConcept),
      target = target ?: listOf(),
      statusDate = Date.of(FhirDate.fromString(statusDate), _statusDate),
      statusReason = R4bString.of(statusReason, _statusReason),
      expressedBy = expressedBy,
      addresses = addresses ?: listOf(),
      note = note ?: listOf(),
      outcomeCode = outcomeCode ?: listOf(),
      outcomeReference = outcomeReference ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: Goal) {
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
    ((value.lifecycleStatus.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.lifecycleStatus.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.achievementStatus)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.achievementStatusSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, value.category)
    (value.priority)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.achievementStatusSer, it)
    }
    (value.description)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.achievementStatusSer, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, it) }
    when (val __d = value.start) {
      null -> {}
      is Goal.Start.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
        }
      }
      is Goal.Start.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.achievementStatusSer, __d.value)
      }
    }
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.targetSer, value.target)
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.statusReason?.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.statusReason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    (value.expressedBy)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.subjectSer, it)
    }
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.addressesSer, value.addresses)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.noteSer, value.note)
    if (value.outcomeCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.categorySer, value.outcomeCode)
    if (value.outcomeReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.addressesSer, value.outcomeReference)
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
  }
}

internal object GoalPolymorphicSerializer : KSerializer<Goal> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Goal") { GoalSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Goal) {
    encoder.encodeStructure(descriptor) { GoalSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): Goal =
    decoder.decodeStructure(descriptor) { GoalSerializer.deserializeJson(this) }
}
