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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Goal.Target) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Goal.Target {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          measure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.measureSer, null)
        4 ->
          detailQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.detailQuantitySer,
              null,
            )
        5 ->
          detailRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailRangeSer, null)
        6 ->
          detailCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.measureSer, null)
        7 -> detailString = decoder.decodeStringElement(descriptor, i)
        8 ->
          _detailString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailStringSer, null)
        9 -> detailBoolean = decoder.decodeBooleanElement(descriptor, i)
        10 ->
          _detailBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailStringSer, null)
        11 -> detailInteger = decoder.decodeIntElement(descriptor, i)
        12 ->
          _detailInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailStringSer, null)
        13 ->
          detailRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailRatioSer, null)
        14 -> dueDate = decoder.decodeStringElement(descriptor, i)
        15 ->
          _dueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailStringSer, null)
        16 ->
          dueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dueDurationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Goal.Target) {
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
    (value.measure)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.measureSer, it)
    }
    when (val choice = value.detail) {
      null -> {}
      is Goal.Target.Detail.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.detailQuantitySer, choice.value)
      }
      is Goal.Target.Detail.Range -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.detailRangeSer, choice.value)
      }
      is Goal.Target.Detail.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.measureSer, choice.value)
      }
      is Goal.Target.Detail.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.detailStringSer, it)
        }
      }
      is Goal.Target.Detail.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.detailStringSer, it)
        }
      }
      is Goal.Target.Detail.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.detailStringSer, it)
        }
      }
      is Goal.Target.Detail.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 13, Hoisted.detailRatioSer, choice.value)
      }
    }
    when (val choice = value.due) {
      null -> {}
      is Goal.Target.Due.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.detailStringSer, it)
        }
      }
      is Goal.Target.Due.Duration -> {
        encoder.encodeSerializableElement(descriptor, 16, Hoisted.dueDurationSer, choice.value)
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
    b.element("continuous", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_continuous", Element.serializer().descriptor, isOptional = true)
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
    b.element("source", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "addresses",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "outcome",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Goal =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Goal) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Goal")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Goal {
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
        11 -> lifecycleStatus = decoder.decodeStringElement(descriptor, i)
        12 ->
          _lifecycleStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          achievementStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.achievementStatusSer,
              null,
            )
        14 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        15 -> continuous = decoder.decodeBooleanElement(descriptor, i)
        16 ->
          _continuous =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.achievementStatusSer,
              null,
            )
        18 ->
          description =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.achievementStatusSer,
              null,
            )
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        20 -> startDate = decoder.decodeStringElement(descriptor, i)
        21 ->
          _startDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          startCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.achievementStatusSer,
              null,
            )
        23 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        24 -> statusDate = decoder.decodeStringElement(descriptor, i)
        25 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> statusReason = decoder.decodeStringElement(descriptor, i)
        27 ->
          _statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 ->
          source =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        29 ->
          addresses =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressesSer, null)
        30 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        31 ->
          outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.outcomeSer, null)
        else -> throw SerializationException("Unexpected index decoding Goal: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Goal,
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
    ((value.lifecycleStatus.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.lifecycleStatus.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.achievementStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.achievementStatusSer,
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
    ((value.continuous?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.continuous?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.priority)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.achievementStatusSer,
        it,
      )
    }
    (value.description)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.achievementStatusSer,
        it,
      )
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.subjectSer, it)
    }
    when (val choice = value.start) {
      null -> {}
      is Goal.Start.Date -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            21 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Goal.Start.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          Hoisted.achievementStatusSer,
          choice.value,
        )
      }
    }
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.targetSer,
        value.target,
      )
    ((value.statusDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.statusReason?.value))?.let {
      encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.statusReason?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.source)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.addressesSer,
        value.addresses,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.outcome.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.outcomeSer,
        value.outcome,
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

internal object GoalPolymorphicSerializer : KSerializer<Goal> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Goal") { GoalSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Goal) {
    encoder.encodeStructure(descriptor) {
      GoalSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Goal =
    decoder.decodeStructure(descriptor) { GoalSerializer.deserializeInternal(this, descriptor, 0) }
}
